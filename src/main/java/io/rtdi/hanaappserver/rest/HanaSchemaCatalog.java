package io.rtdi.hanaappserver.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
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

import io.rtdi.hanaappcontainer.browseapp.BrowseService.DirectoryContent;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class HanaSchemaCatalog {
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
							responseCode = "500", 
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
			String sql = "select schema_name, schema_owner, create_time from schemas order by schema_name";
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				try (ResultSet rs = stmt.executeQuery(); ) {
					Schemas endpoints = new Schemas();
					if (rs.next()) {
						endpoints.addSchema(rs.getString(1), rs.getString(2), rs.getTimestamp(3));
					}
					return Response.ok(endpoints).build();
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql.toString(), "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

	public static class Schemas {
		private List<SchemaDefinition> schemas;

		protected void addSchema(String schemaname, String schemaowner, Timestamp createtime) {
			if (schemas == null) {
				schemas = new ArrayList<>();
			}
			schemas.add(new SchemaDefinition(schemaname, schemaowner, createtime));
		}
		
		public List<SchemaDefinition> getSchemas() {
			return schemas;
		}
	}

	public static class SchemaDefinition {
		private String schemaname;
		private String schemaowner;
		private String createtime;
		
		public SchemaDefinition(String schemaname, String schemaowner, Timestamp createtime) {
			this.schemaname = schemaname;
			this.schemaowner = schemaowner;
			this.createtime = createtime.toInstant().atOffset(ZoneOffset.UTC).toString();
		}

		public String getSchemaname() {
			return schemaname;
		}

		public String getSchemaowner() {
			return schemaowner;
		}

		public String getCreatetime() {
			return createtime;
		}
	}
}
