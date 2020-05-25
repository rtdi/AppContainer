package io.rtdi.hanaappserver.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
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

import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class HanaODataServiceCatalog {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("catalog/odataendpoints/{schema}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All oData endpoints",
			description = "Returns a list of all oData endpoints the currently logged in user has access to",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = ODataEndPoints.class)
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
	@Tag(name = "Information")
    public Response getEndpointsForSchema(
    		@PathParam("schema")
   		 	@Parameter(
 	    		description = "Database schema the oData Services provide data for",
 	    		example = "SYS"
 	    		)
    		String schemaraw) {
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			String schema = Util.decodeURIfull(schemaraw);
			String sql = "select schema_name, object_name, object_type from objects\r\n" + 
					"where object_type in ('TABLE', 'VIEW') and schema_name = ? order by schema_name, object_name";
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setString(1, schema);
				try (ResultSet rs = stmt.executeQuery(); ) {
					ODataEndPoints endpoints = new ODataEndPoints();
					while (rs.next()) {
						endpoints.addEndpoint(rs.getString(1), rs.getString(2), rs.getString(3));
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

	@Schema(description="List of oData endpoints")
	public static class ODataEndPoints {
		private List<ODataEndPoint> endpoints;

		protected void addEndpoint(String schema, String object, String type) {
			if (endpoints == null) {
				endpoints = new ArrayList<>();
			}
			endpoints.add(new ODataEndPoint(schema, object, type));
		}
		
		public List<ODataEndPoint> getEndpoints() {
			return endpoints;
		}
	}

	public static class ODataEndPoint {
		private String schemaname;
		private String objectname;
		private String endpoint;
		private String type;
		
		public ODataEndPoint(String schema, String object, String type) {
			this.schemaname = schema;
			this.objectname = object;
			this.endpoint = "/HanaAppContainer/protected/odata/" + Util.encodeURIfull(schema) + "/" + Util.encodeURIfull(object) + "/";
			this.type = type;
		}
		public String getSchemaname() {
			return schemaname;
		}
		public String getObjectname() {
			return objectname;
		}
		public String getEndpoint() {
			return endpoint;
		}
		public String getType() {
			return type;
		}
	}
}
