package io.rtdi.appcontainer.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ErrorCode;
import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.appcontainer.utils.SessionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class DatabaseSchemaCatalog {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("catalog/schemas")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All schemas of the database",
			description = "Returns a list of all schemas in the database",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of schemas",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Schemas.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getSchemas() {
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			try (ResultSet rs = conn.getMetaData().getSchemas(conn.getCatalog(), null); ) {
				Schemas endpoints = new Schemas();
				while (rs.next()) {
					endpoints.addSchema(rs.getString(1));
				}
				return Response.ok(endpoints).build();
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, "JDBC getSchemas()", "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.ACCEPTED).entity(new ErrorMessage(e, ErrorCode.LOWLEVELEXCEPTION)).build();
		}
	}

	public static class Schemas {
		private List<SchemaDefinition> schemas;

		protected void addSchema(String schemaname) {
			if (schemas == null) {
				schemas = new ArrayList<>();
			}
			schemas.add(new SchemaDefinition(schemaname));
		}
		
		public List<SchemaDefinition> getSchemas() {
			return schemas;
		}
	}

	public static class SchemaDefinition {
		private String schemaname;
		
		public SchemaDefinition(String schemaname) {
			this.schemaname = schemaname;
		}

		public String getSchemaname() {
			return schemaname;
		}

	}
}
