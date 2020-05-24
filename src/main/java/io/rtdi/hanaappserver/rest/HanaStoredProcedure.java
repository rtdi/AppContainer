package io.rtdi.hanaappserver.rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class HanaStoredProcedure {
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;

	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	private static Cache<String, ProcedureMetadata> cache = Caffeine.newBuilder()
	  .expireAfterAccess(1, TimeUnit.MINUTES)
	  .maximumSize(10000)
	  .build();
	
	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("procedures")
	@Operation(
			summary = "All available procedures",
			description = "Returns the list of all procedures the user has access to",
				responses = {
						@ApiResponse(
		                    responseCode = "200",
		                    description = "The list of all Hana Stored Procedures the user has access to",
		                    content = {
		                            @Content(
		                                    array = @ArraySchema(schema = @Schema(implementation = HanaProcedure.class))
		                            )
		                    }
	                    ),
						@ApiResponse(responseCode = "500", description = "Any exception thrown")
			})
	@Tag(name = "Information")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProcedures() {
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			String sql = "select schema_name, procedure_name from procedures";
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				try (ResultSet rs = stmt.executeQuery(); ) {
					List<HanaProcedure> elements = new ArrayList<>();
					while (rs.next()) {
						elements.add(new HanaProcedure(rs.getString(1), rs.getString(2)));
					}
					return Response.ok(elements).build();
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql, "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

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
	 * @param schemaraw the Hana schema name with the char '/' encoded as '%2f'
	 * @param procedurenameraw the Hana procedure name with the char '/' encoded as '%2f'
	 * @param data contains the input parameters for the procedure
	 * @return Json with the procedure output
	 */
	@POST
	@Path("procedures/{schema}/{procedurename}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Invoke this procedure",
			description = "Calls the named stored procedure with input and output data",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A Json object with all output parameters being nodes",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
	                            )
	                    }
                    ),
					@ApiResponse(responseCode = "500", description = "Any exception thrown")
            })
	@Tag(name = "ReadHana")
	@Tag(name = "WriteHana")
    public Response callProcedure(
    		@PathParam("schema") 
    	    @Parameter(
    	    		description = "Schema of the object",
    	    		example = "SYS"
    	    		)
    		String schemaraw, 
    		@PathParam("procedurename") 
    	    @Parameter(
    	    		description = "Name of the procedure",
    	    		example = "IS_VALID_USER_NAME"
    	    		)
    		String procedurenameraw, 
    		@RequestBody(
    				description = "JSON object with all used input parameters", 
    				required = true,
    				content = @Content(
    						schema = @Schema(
    								type = "object",
    								example = "{\"USER_NAME\" : \"$$$\"}"
    						)
    				)
    		)
    		JsonNode data) {
		String schema = Util.decodeURIfull(schemaraw);
		String procedurename = Util.decodeURIfull(procedurenameraw);
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			boolean setcache = false;
			String cachekey = schema + "." + procedurename;
			ProcedureMetadata metadata = cache.getIfPresent(cachekey);
			if (metadata == null) {
				metadata = new ProcedureMetadata();
				setcache = true;
				// Output parameters
				String paramsql = "select parameter_name, data_type_name from procedure_parameters " + 
						"where schema_name = ? and procedure_name = ? and parameter_type = 'OUT' " + 
						"order by position";
				try (PreparedStatement stmt = conn.prepareStatement(paramsql);) {
					stmt.setString(1, schema);
					stmt.setString(2, procedurename);
					try (ResultSet rs = stmt.executeQuery(); ) {
						while (rs.next()) {
							metadata.putOutputParameter(rs.getString(1), rs.getString(2));
						}
					}
				} catch (SQLException e) {
					throw new HanaSQLException(e, paramsql, "Executed SQL statement threw an error");
				}
			}
			
			/*
			 * The call statement is built based on the input json, because if parameters are missing, they get the default values from
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
					String tablename = create_temporary_table(conn, schema, procedurename, fieldname, (ArrayNode) data.get(fieldname), metadata);
					sql.append(tablename);
				} else {
					sql.append("?");
				}
			}

			String outparams = metadata.getOutputParameterString();
			if (outparams != null && outparams.length() != 0) {
				if (first) {
					first = false;
				} else {
					sql.append(", ");
				}
				sql.append(outparams);
			}

			sql.append(") }");
			
			if (setcache) {
				cache.put(cachekey, metadata);
			}

			try (CallableStatement stmt = conn.prepareCall(sql.toString());) {
				iter = data.fieldNames();
				int counter = 1;
				while (iter.hasNext()) {
					String fieldname = iter.next();
					if (data.get(fieldname).getNodeType() == JsonNodeType.ARRAY) {
						// nothing
					} else {
						stmt.setString(counter++, data.get(fieldname).textValue());
					}
				}
				/*
				 * Scalar output parameters are prepared
				 */
				for ( String outputparameter : metadata.getOutputParameters().keySet()) {
					String datatype = metadata.getOutputParameters().get(outputparameter);
					if (datatype != null) {
						stmt.registerOutParameter(outputparameter, Types.NVARCHAR);
					}
				}
				boolean hasrs = stmt.execute();
				invocations++;
				lastprocessedtime = System.currentTimeMillis();
				ObjectMapper objectMapper = new ObjectMapper();
				ObjectNode rootnode = objectMapper.createObjectNode();
				/*
				 * Table Output Parameters read via this method
				 */
				if (hasrs) {
					int rscount = 1;
					while (hasrs) {
						ObjectNode rsnode = objectMapper.createObjectNode();
					    try (ResultSet rs = stmt.getResultSet();) {
					    	while (rs.next()) {
					    		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					    			rsnode.put(rs.getMetaData().getColumnName(i), rs.getString(i));
					    		}
					    	}
							rootnode.set("OUT" + String.valueOf(rscount), rsnode);
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
				for ( String outputparameter : metadata.getOutputParameters().keySet()) {
					String datatype = metadata.getOutputParameters().get(outputparameter);
					if (datatype != null) {
						rootnode.put(outputparameter, stmt.getString(outputparameter));
					}
				}
				return Response.ok(rootnode).build();
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql.toString(), "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

	private String create_temporary_table(Connection conn, String schema, String procedurename, String fieldname, ArrayNode data, ProcedureMetadata metadata) throws HanaSQLException {
		String tablename = "#" + fieldname;
		try (PreparedStatement stmt = conn.prepareStatement("drop table \"" + tablename + "\""); ) {
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Exception " + e.getMessage());
		}
		TableParameterMetadata tablemetadata = metadata.getTableInputParameter(fieldname);
		if (tablemetadata == null) {
			tablemetadata = new TableParameterMetadata();
			metadata.putTableInputParameter(fieldname, tablemetadata);
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
						sql.append(Util.getDataTypeString(rs.getString(2), rs.getInt(3), rs.getInt(4)));
						columnlist.append('"').append(columnname).append("\" ");
						parameterlist.append('?');
						columnindex.add(columnname);
					}
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, selectsql, "Executed SQL statement threw an error");
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
			throw new HanaSQLException(e, tablemetadata.getCreateTableSQL(), "Executed SQL statement threw an error");
		}

		// Insert data
		try (PreparedStatement stmt = conn.prepareStatement(tablemetadata.getInsertSQL()); ) {
			Iterator<JsonNode> iter = data.elements();
			while (iter.hasNext()) {
				JsonNode row = iter.next();
				if (row.getNodeType() == JsonNodeType.OBJECT) {
					for (int i=0; i < tablemetadata.getColumnIndex().size(); i++) {
						JsonNode n = row.get(tablemetadata.getColumnIndex().get(i));
						stmt.setString(i+1, (n==null?null:n.asText()));
					}
					stmt.addBatch();
				}
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw new HanaSQLException(e, tablemetadata.getInsertSQL(), "Executed SQL statement threw an error");
		}
		
		return tablename;
	}

	@Schema(description="Hana Stored Procedure information")
	public static class HanaProcedure {
		private String schemaname;
		private String procedurename;
		private String endpoint;
		
		public HanaProcedure(String schemaname, String procedurename) {
			super();
			this.schemaname = schemaname;
			this.procedurename = procedurename;
			this.endpoint = "HanaAppContainer/rest/procedure/" 
					+ Util.encodeURIfull(schemaname) 
					+ "/" 
					+ Util.encodeURIfull(procedurename);
		}

		public HanaProcedure() {
			super();
		}

		public String getProcedurename() {
			return procedurename;
		}
		public void setProcedurename(String procedurename) {
			this.procedurename = procedurename;
		}
		public String getSchemaname() {
			return schemaname;
		}
		public void setSchemaname(String schemaname) {
			this.schemaname = schemaname;
		}

		public String getEndpoint() {
			return endpoint;
		}

		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}
	}
	
	public static class ProcedureMetadata {

		private String outputparameterstring;
		private Map<String, TableParameterMetadata> tableparameters = new HashMap<>();
		private Map<String, String> outparameters = new HashMap<>();

		public void putOutputParameter(String parametername, String datatypename) {
			if (outparameters.size() == 0) {
				outputparameterstring = "\"" + parametername + "\"  => ?";
			} else {
				outputparameterstring = outputparameterstring + ", \"" + parametername + "\" => ?";
			}
			outparameters.put(parametername, datatypename);
		}

		public void putTableInputParameter(String fieldname, TableParameterMetadata tablemetadata) {
			tableparameters.put(fieldname, tablemetadata);
		}

		public TableParameterMetadata getTableInputParameter(String fieldname) {
			return tableparameters.get(fieldname);
		}

		public Map<String, String> getOutputParameters() {
			return outparameters;
		}

		public String getOutputParameterString() {
			return outputparameterstring;
		}
		
	}
	
	public static class TableParameterMetadata {

		private String createtablestring;
		private String insertsqlstring;
		private List<String> columnindex;

		public void setCreateTableSQL(String string) {
			this.createtablestring = string;
		}

		public List<String> getColumnIndex() {
			return columnindex;
		}

		public void setColumnIndex(List<String> columnindex) {
			this.columnindex = columnindex;
		}

		public String getInsertSQL() {
			return insertsqlstring;
		}

		public void setInsertSQL(String insertsql) {
			this.insertsqlstring = insertsql;
		}

		public String getCreateTableSQL() {
			return createtablestring;
		}
	}
	
    public static int getInvocations() {
    	return invocations;
    }

    public static long getStarttime() {
    	return starttime;
    }

    public static long getLastProcessedtime() {
    	return lastprocessedtime;
    }

}
