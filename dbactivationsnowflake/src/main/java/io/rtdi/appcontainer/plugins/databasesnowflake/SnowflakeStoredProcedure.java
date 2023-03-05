package io.rtdi.appcontainer.plugins.databasesnowflake;

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

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureMetadata;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameter;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameterInOutType;


public class SnowflakeStoredProcedure implements IStoredProcedure {
	
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
    @Override
	public ObjectNode callProcedure(
    		Connection conn,
    		String schema,
    		String procedurename,
    		JsonNode data,
    		Cache<String,
    		ProcedureMetadata> cache,
    		IDatabaseProvider provider) throws AppContainerSQLException {
    	JDBCDataTypeConversion conv = provider.getConversionClass();
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
				throw AppContainerSQLException.cloneFrom(e, null, "reading store procedure metadata threw an error");
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
						throw new AppContainerSQLException("The procedure does not exist or does not have a parameter with the name \"" + fieldname
								+ "\"", "Provided input Json is invalid", null);
					}
					stmt.setObject(p.getIndex(), conv.convertJsonNodeJDBC(data.get(fieldname), p.getJDBCDataType()));
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
				    			rsnode.set(rs.getMetaData().getColumnName(i),
				    					conv.convertJDBCToJsonNode(rs.getObject(i), JDBCType.valueOf(rs.getMetaData().getColumnType(i))));
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
						rootnode.set(outputparameter.getParametername(),
								conv.convertJDBCToJsonNode(
										stmt.getObject(outputparameter.getIndex()),
										outputparameter.getJDBCDataType()));
					}
				}
			}
			return rootnode;
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, sql.toString(), "Executed SQL statement threw an error");
		}
	}

}
