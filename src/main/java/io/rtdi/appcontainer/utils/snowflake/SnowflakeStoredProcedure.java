package io.rtdi.appcontainer.utils.snowflake;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.benmanes.caffeine.cache.Cache;

import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ProcedureMetadata;
import io.rtdi.appcontainer.utils.ProcedureParameter;
import io.rtdi.appcontainer.utils.ProcedureParameterInOutType;

public class SnowflakeStoredProcedure {
	
	/**
	 * 
	 * @param conn 
	 * @param schema 
	 * @param procedurename 
	 * @param data 
	 * @param cache 
	 * @return the Json payload
	 * @throws AppContainerSQLException 
	 * 
	 */
    public static ObjectNode callProcedure(
    		Connection conn,
    		String schema,
    		String procedurename,
    		JsonNode data,
    		Cache<String,
    		ProcedureMetadata> cache) throws AppContainerSQLException {
		String cachekey = schema + "." + procedurename;
		ProcedureMetadata metadata = cache.getIfPresent(cachekey);
		if (metadata == null) {
			metadata = new ProcedureMetadata();
			try (ResultSet rs = conn.getMetaData().getProcedureColumns(null, schema, procedurename, null); ) {
				while (rs.next()) {
					short inouttype = rs.getShort(5);
					JDBCType dt = JDBCType.valueOf(rs.getInt(6));
					ProcedureParameterInOutType io = ProcedureParameterInOutType.value(inouttype);
					ProcedureParameter p = new ProcedureParameter(rs.getInt(18), rs.getString(4), dt, rs.getString(7), io);
					metadata.addParameter(p);
				}
				cache.put(cachekey, metadata);
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, (String) null, "Executed SQL statement threw an error");
			}
		}
		
		/*
		 * Snowflake does not allow to call procedures with parameters by name, must be positional
		 */
		StringBuffer sql = new StringBuffer();
		sql.append("call \"").append(schema).append("\".\"").append(procedurename).append("\"(");
		boolean first = true;
		for ( ProcedureParameter p : metadata.getParameters()) {
			if (p.getInouttype() != ProcedureParameterInOutType.RETURN) {
				if (first) {
					first = false;
				} else {
					sql.append(", ");
				}
				sql.append("?");
			}
		}
		sql.append(")");
		
		try (CallableStatement stmt = conn.prepareCall(sql.toString());) {
			if (data != null) {
			Iterator<String> iter = data.fieldNames();
				while (iter.hasNext()) {
					String fieldname = iter.next();
					ProcedureParameter p = metadata.getParameter(fieldname);
					if (p == null) {
						throw new AppContainerSQLException("The procedure does not have a parameter with the name \"" + fieldname
								+ "\"", "Provided input Json is invalid");
					}
					switch (p.getDatatypename()) {
					
					}
					stmt.setString(p.getIndex(), data.get(fieldname).textValue());
				}
			}
			/*
			 * Scalar output parameters are prepared
			 */
			for ( ProcedureParameter outputparameter : metadata.getOutputParameters()) {
				JDBCType datatype = outputparameter.getJDBCDataType();
				stmt.registerOutParameter(outputparameter.getIndex(), datatype.getVendorTypeNumber());
			}
			boolean hasrs = stmt.execute();
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode rootnode = objectMapper.createObjectNode();
			if (hasrs) {
				int rscount = 0;
				while (hasrs) {
					ArrayNode arraynode = objectMapper.createArrayNode();
				    try (ResultSet rs = stmt.getResultSet();) {
				    	while (rs.next()) {
							ObjectNode rsnode = objectMapper.createObjectNode();
							arraynode.add(rsnode);
				    		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				    			rsnode.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				    		}
				    	}
			    		String outname = "OUT" + String.valueOf(rscount + 1);
			    		rootnode.set(outname, arraynode);
						rscount++;
				    }
				    if (stmt.isClosed()) {
				    	hasrs = false;
				    } else {
				    	hasrs = stmt.getMoreResults();
				    }
				}
			}
			/*
			 * Table Output Parameters read via this method.
			 * Adds one arraynode per table with 0..n rows each
			 */
			/*
			 * Scalar output parameters are read
			 */
			for ( ProcedureParameter outputparameter : metadata.getOutputParameters()) {
				JDBCType datatype = outputparameter.getJDBCDataType();
				if (datatype != null) {
					switch (datatype) {
					default:
						rootnode.put(outputparameter.getParametername(), stmt.getString(outputparameter.getIndex()));
					}
				}
			}
			return rootnode;
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, sql.toString(), "Executed SQL statement threw an error");
		}
	}

}
