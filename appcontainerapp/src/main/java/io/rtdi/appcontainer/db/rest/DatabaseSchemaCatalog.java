package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.AppContainerSQLException;
import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				try (ResultSet rs = conn.getMetaData().getSchemas(conn.getCatalog(), null); ) {
					Schemas endpoints = new Schemas();
					while (rs.next()) {
						endpoints.addSchema(rs.getString(1));
					}
					return Response.ok(endpoints).build();
				}
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getSchemas()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
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
