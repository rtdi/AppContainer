package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.db.rest.entity.StoredProcedure;
import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureMetadata;
import io.rtdi.appcontainer.rest.RestService;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.DatabaseProvider;
import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class StoredProcedureService extends RestService {

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
		                    description = "The list of all Stored Procedures the user has access to",
		                    content = {
		                            @Content(
		                                    array = @ArraySchema(schema = @Schema(implementation = StoredProcedure.class))
		                            )
		                    }
	                    ),
						@ApiResponse(responseCode = "400", description = "Any exception thrown")
			})
	@Tag(name = "Information")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProcedures() {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				try (ResultSet rs = conn.getMetaData().getProcedures(null, null, null); ) {
					List<StoredProcedure> elements = new ArrayList<>();
					while (rs.next()) {
						elements.add(new StoredProcedure(rs.getString(2), rs.getString(3)));
					}
					return Response.ok(elements).build();
				}
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getProcedures()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
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
					@ApiResponse(responseCode = "400", description = "Any exception thrown")
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
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				String schema = Util.decodeURIfull(schemaraw);
				schema = Util.getSchema(schema, request);
				IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
				IStoredProcedure procedureservice = provider.getProcedureService();
				tickRest();
				return Response.ok(procedureservice.callProcedure(conn, schema, procedurename, data, cache, provider)).build();
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
