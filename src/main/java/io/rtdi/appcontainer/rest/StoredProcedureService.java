package io.rtdi.appcontainer.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.DatabaseType;
import io.rtdi.appcontainer.utils.ErrorCode;
import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.appcontainer.utils.ProcedureMetadata;
import io.rtdi.appcontainer.utils.SessionHandler;
import io.rtdi.appcontainer.utils.Util;
import io.rtdi.appcontainer.utils.hana.HanaStoredProcedure;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeStoredProcedure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class StoredProcedureService {
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
		                                    array = @ArraySchema(schema = @Schema(implementation = StoredProcedure.class))
		                            )
		                    }
	                    ),
						@ApiResponse(responseCode = "202", description = "Any exception thrown")
			})
	@Tag(name = "Information")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProcedures() {
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			try (ResultSet rs = conn.getMetaData().getProcedures(null, null, null); ) {
				List<StoredProcedure> elements = new ArrayList<>();
				while (rs.next()) {
					elements.add(new StoredProcedure(rs.getString(2), rs.getString(3)));
				}
				return Response.ok(elements).build();
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, "JDBC getProcedures()", "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.ACCEPTED).entity(new ErrorMessage(e, ErrorCode.LOWLEVELEXCEPTION)).build();
		}
	}

	/**
	 * 
	 * @param schemaraw the schema name with the char '/' encoded as '%2f'
	 * @param procedurenameraw the procedure name with the char '/' encoded as '%2f'
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
					@ApiResponse(responseCode = "202", description = "Any exception thrown")
            })
	@Tag(name = "ReadDB")
	@Tag(name = "WriteDB")
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
		String procedurename = Util.decodeURIfull(procedurenameraw);
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			if (DatabaseType.getDatabaseType(conn) == DatabaseType.HANA) {
				return Response.ok(HanaStoredProcedure.callProcedure(conn, schema, procedurename, data, cache)).build();
			} else {
				return Response.ok(SnowflakeStoredProcedure.callProcedure(conn, schema, procedurename, data, cache)).build();
			}
		} catch (Exception e) {
			return Response.status(Status.ACCEPTED).entity(new ErrorMessage(e, ErrorCode.LOWLEVELEXCEPTION)).build();
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
