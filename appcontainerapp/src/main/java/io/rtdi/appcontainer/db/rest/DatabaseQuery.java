package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.db.rest.entity.SQLQueryResult;
import io.rtdi.appcontainer.db.rest.entity.SQLText;
import io.rtdi.appcontainer.db.rest.entity.sql.SqlStatement;
import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.rest.RestService;
import io.rtdi.appcontainer.rest.entity.CustomSuccessMessage;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.DatabaseProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class DatabaseQuery extends RestService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
 

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("query")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Execute a select statement and return the data as Json",
			description = "It executes the provided select and returns the data",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A json object representing the resultset",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "ReadDB")
    public Response query(
    		@QueryParam("$select")
   		 	@Parameter(
 	    		description = "The select statement to execute, usually a select but can be others as well",
 	    		example = "select user_name from users"
 	    		)
    		String sql) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				if (sql == null) {
					throw new AppContainerSQLException("No parameter $select= provided", sql, null);
				} else {
					SQLQueryResult queryresult = new SQLQueryResult(sql);
					try (PreparedStatement stmt = conn.prepareStatement(sql);) {
						boolean isrs = stmt.execute();
						int i=0;
						while (isrs) {
							ResultSet rs = stmt.getResultSet();
							String name = String.format("RS%d", i);
							queryresult.addResultSet(rs, name);
							isrs = stmt.getMoreResults();
							i++;
						}
						tickRest();
						return CustomSuccessMessage.createResponse(queryresult);
					} catch (SQLException e) {
						throw AppContainerSQLException.cloneFrom(e, sql, null);
					}
				}
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@POST
	@Path("query")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Execute a select statement provided as Json from the SQLApp and return the data as Json",
			description = "It executes the provided Json from the SQLApp and returns the data",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A json object representing the resultset",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "ReadDB")
    public Response queryJson(SqlStatement query) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
			String sql = provider.createSql(query);
			return query(sql.trim());
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@POST
	@Path("translate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Convert a select statement provided as Json from the SQLApp and return the SQL text",
			description = "It converts the provided Json from the SQLApp into a SQL text",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A json object representing the resultset",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "ReadDB")
    public Response querytranslateJson(SqlStatement query) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
			String sql = provider.createSql(query);
			return CustomSuccessMessage.createResponse(new SQLText(sql));
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
