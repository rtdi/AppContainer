package io.rtdi.appcontainer.plugins.databasehana;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.benmanes.caffeine.cache.Cache;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureMetadata;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameter;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameterInOutType;

public class HanaStoredProcedure implements IStoredProcedure {
	
	private static JDBCDataTypeConversion conv = new JDBCDataTypeConversion();


	/**
	 * There are multiple cases to consider:
	 * Input
	 * a) Scalar inputs: create procedure (in name varchar(10),...
	 * b) Anonymous Table Type parameters: create procedure (in namelist table (name varchar(50), type varchar(10)),...
	 * c) Table Type: create procedure (in names user1.type1,...
	 * d) Array input
	 * Output
	 * a) Scalar output: create procedure (in name varchar(10),...
	 * b) Table Resultset: begin select now() from dummy; end;
	 * c) Output parameter (anonymous): create procedure (out namelist table (name varchar(50), type varchar(10)),...
	 * d) Output parameter with table type: create procedure (out names user1.type1,...
	 * e) Array output
	 * InOut
	 * a) Scalar in/out: create procedure (inout name varchar(10),...
	 * b) In/Output parameter (anonymous): create procedure (out namelist table (name varchar(50), type varchar(10)),...
	 * c) In/Output parameter with table type: create procedure (out names user1.type1,...
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
    		ProcedureMetadata> cache, IDatabaseProvider provider) throws AppContainerSQLException {
		String cachekey = schema + "." + procedurename;
		ProcedureMetadata metadata = cache.getIfPresent(cachekey);
		if (metadata == null) {
			metadata = new HanaProcedureMetadata();
			// Output parameters
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
				throw AppContainerSQLException.cloneFrom(e, null, "reading stored procedure metadata threw an error");
			}
		}
		
		/*
		 * The call statement is built based on the input json, because if parameters are missing, they must get the default values from
		 * the procedure definition.
		 */
		StringBuffer sql = new StringBuffer();
		sql.append("{ call \"").append(schema).append("\".\"").append(procedurename).append("\"(");
		Iterator<String> iter = data.fieldNames();
		boolean first = true;
		while (iter.hasNext()) {
			String fieldname = iter.next();
			if (first) {
				first = false;
			} else {
				sql.append(", ");
			}
			sql.append('"').append(fieldname).append("\" => ");
			if (data.get(fieldname).getNodeType() == JsonNodeType.ARRAY) {
				/*
				 * Array nodes are passed in via temporary tables
				 */
				ProcedureParameter p = metadata.getParameter(fieldname);
				if (p == null) {
					throw new AppContainerSQLException("The procedure does not have a parameter \"" + fieldname + "\"", null, null);
				} else if (!(p instanceof TableParameterMetadata)) {
					throw new AppContainerSQLException("The input for the parameter \"" + fieldname + "\" is not a table, hence no Json array is allowed as input", null, null);
				} else {
					String tablename = create_temporary_table(conn, schema, procedurename, fieldname, (ArrayNode) data.get(fieldname), (TableParameterMetadata) p);
					sql.append(tablename);
				}
			} else {
				sql.append("?");
			}
		}
		
		/*
		 * Next add all output parameters with   name => ?
		 */
		for (ProcedureParameter p : metadata.getOutputParameters()) {
			if (first) {
				first = false;
			} else {
				sql.append(", ");
			}
			sql.append("\"").append(p.getParametername()).append("\" => ?");
		}


		sql.append(") }");
		
		try (CallableStatement stmt = conn.prepareCall(sql.toString());) {
			int counter = 1;
			if (data != null) { // procedures without input parameters are fine
				iter = data.fieldNames();
				while (iter.hasNext()) {
					String fieldname = iter.next();
					if (data.get(fieldname).getNodeType() == JsonNodeType.ARRAY) {
						// nothing to do, a table with the data has been created already
					} else {
						stmt.setObject(counter++, conv.convertJsonNodeJDBC(data.get(fieldname), metadata.getParameter(fieldname).getJDBCDataType() ));
					}
				}
			}
			/*
			 * Scalar and table output parameters are prepared
			 */
			List<ProcedureParameter> tableout = new ArrayList<>();
			for ( ProcedureParameter outputparameter : metadata.getOutputParameters()) {
				String datatype = outputparameter.getDatatypename();
				if (datatype != null) {
					switch (datatype) {
					case "TABLE_TYPE":
						// not used, data is returned as result set in Hana
						tableout.add(outputparameter);
						break;
					default:
						stmt.registerOutParameter(counter++, outputparameter.getJDBCDataType().getVendorTypeNumber());
					}
				}
			}
			boolean hasrs = stmt.execute();
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode rootnode = objectMapper.createObjectNode();
			/*
			 * Table Output Parameters and anonymous outputs are read here.
			 * Adds one arraynode per table with 0..n rows each
			 */
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
				    					conv.convertJDBCToJsonNode(
				    							rs.getObject(i),
				    							JDBCType.valueOf(rs.getMetaData().getColumnType(i))));
				    		}
				    	}
				    	String outname = null;
				    	if (rscount < tableout.size()) {
				    		outname = tableout.get(rscount).getParametername();
				    	} else {
				    		outname = "OUT" + String.valueOf(rscount + 1 - tableout.size());
				    	}
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
			 * Scalar output parameters are read
			 */
			for ( ProcedureParameter outputparameter : metadata.getOutputParameters()) {
				String datatype = outputparameter.getDatatypename();
				if (datatype != null) {
					switch (datatype) {
					case "TABLE_TYPE":
						// ignore
						break;
					default:
						rootnode.set(outputparameter.getParametername(),
								conv.convertJDBCToJsonNode(
										stmt.getObject(outputparameter.getParametername()),
										outputparameter.getJDBCDataType()));
					}
				}
			}
			return rootnode;
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, sql.toString(), "Executed SQL statement threw an error");
		}
	}

	private static String create_temporary_table(Connection conn, String schema, String procedurename,
			String fieldname, ArrayNode data, TableParameterMetadata tablemetadata) throws AppContainerSQLException {
		String tablename = "#" + fieldname;
		try (PreparedStatement stmt = conn.prepareStatement("drop table \"" + tablename + "\""); ) {
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Exception " + e.getMessage());
		}
		if (tablemetadata.getCreateTableSQL() == null) {
			StringBuffer sql = new StringBuffer();
			StringBuffer columnlist = new StringBuffer();
			StringBuffer parameterlist = new StringBuffer();
			List<String> columnindex = new ArrayList<>();
			sql.append("create local temporary table \"").append(tablename).append("\" (");
			String selectsql = "SELECT column_name, data_type_name, length, scale FROM PROCEDURE_PARAMETER_COLUMNS " + 
					"where schema_name = ? and procedure_name = ? and parameter_name = ? " + 
					"order by position";
			try (PreparedStatement stmt = conn.prepareStatement(selectsql); ) {
				stmt.setString(1, schema);
				stmt.setString(2, procedurename);
				stmt.setString(3, fieldname);
				try (ResultSet rs = stmt.executeQuery(); ) {
					boolean first = true;
					while (rs.next()) {
						if (first) {
							first = false;
						} else {
							sql.append(", ");
							columnlist.append(", ");
							parameterlist.append(", ");
						}
						String columnname = rs.getString(1);
						sql.append('"').append(columnname).append("\" ");
						sql.append(HanaDataTypes.getDataTypeString(rs.getString(2), rs.getInt(3), rs.getInt(4)));
						columnlist.append('"').append(columnname).append("\" ");
						parameterlist.append('?');
						columnindex.add(columnname);
					}
				}
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, selectsql, "Executed SQL statement threw an error");
			}
			sql.append(')');
			tablemetadata.setCreateTableSQL(sql.toString());

			String insertsql = "insert into \"" + tablename + "\" (" + columnlist + ") values (" + parameterlist + ")";
			tablemetadata.setInsertSQL(insertsql);
			
			tablemetadata.setColumnIndex(columnindex);
		}
		try (PreparedStatement stmt = conn.prepareStatement(tablemetadata.getCreateTableSQL()); ) {
			stmt.execute();
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, tablemetadata.getCreateTableSQL(), "Executed SQL statement threw an error");
		}

		// Insert data
		try (PreparedStatement stmt = conn.prepareStatement(tablemetadata.getInsertSQL()); ) {
			Iterator<JsonNode> iter = data.elements();
			while (iter.hasNext()) {
				JsonNode row = iter.next();
				if (row.getNodeType() == JsonNodeType.OBJECT) {
					for (int i=0; i < tablemetadata.getColumnIndex().size(); i++) {
						JsonNode n = row.get(tablemetadata.getColumnIndex().get(i));
						stmt.setObject(i+1, (n==null?null:conv.convertJsonNodeJDBC(n, JDBCType.valueOf(stmt.getMetaData().getColumnType(i+1)))));
					}
					stmt.addBatch();
				}
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, tablemetadata.getInsertSQL(), "Executed SQL statement threw an error");
		}
		return tablename;
	}

}
