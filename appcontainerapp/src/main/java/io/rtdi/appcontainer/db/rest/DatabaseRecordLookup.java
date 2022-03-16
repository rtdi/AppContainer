package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.rtdi.appcontainer.AppContainerSQLException;
import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class DatabaseRecordLookup {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("lookup/{schema}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Lookup a single record",
			description = "Returns a single record from a table/view using $where and $select parameters",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A json object representing the table row",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
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
	@Tag(name = "ReadDB")
    public Response lookupRecord(
    		@PathParam("schema")
   		 	@Parameter(
 	    		description = "Schema of the object to lookup data from",
 	    		example = "SYS"
 	    		)
    		String schemaraw,
    		@PathParam("name")
   		 	@Parameter(
   	 	    		description = "Object name",
   	 	    		example = "USERS"
   	 	    		)
    		String nameraw,
    		@QueryParam("$select")
   		 	@Parameter(
   	 	    		description = "Comma separated list of columns",
   	 	    		example = "USER_NAME, CREATE_TIME"
   	 	    		)
    		String select,
    		@QueryParam("$where")
   		 	@Parameter(
   	 	    		description = "A where condition to be added",
   	 	    		example = "USER_NAME = 'SYSTEM'"
   	 	    		)
			String where) {
		String name = Util.decodeURIfull(nameraw);
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				String schema = Util.decodeURIfull(schemaraw);
				schema = Util.getSchema(schema, request);
				StringBuffer sql = new StringBuffer();
				sql.append("select top 1 ");
				if (select != null) {
					String[] projections = select.split("\\,");
					boolean first = true;
					for (String s : projections) {
						if (first) {
							first = false;
						} else {
							sql.append(",");
						}
						sql.append(" \"")
							.append(s.trim())
							.append("\"");
					}
				} else {
					sql.append(" *");
				}
				sql.append(" from \"")
					.append(schema)
					.append("\".\"")
					.append(name)
					.append("\" ");
				
				if (where != null && where.length() != 0) {
					sql.append("where ").append(where);
				}
	
				try (PreparedStatement stmt = conn.prepareStatement(sql.toString());) {
					ObjectMapper objectMapper = new ObjectMapper();
					ObjectNode rootnode = objectMapper.createObjectNode();
					try (ResultSet rs = stmt.executeQuery(); ) {
						DateFormat timeformatter = new SimpleDateFormat("HH:mm:ss");
						DateTimeFormatter timestampformatter = DateTimeFormatter.ISO_INSTANT;
						if (rs.next()) {
				    		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				    			DatabaseQuery.setRestObject(rs, i, rootnode, timeformatter, timestampformatter);
				    		}
						}
						return Response.ok(rootnode).build();
					}
				} catch (SQLException e) {
					throw AppContainerSQLException.cloneFrom(e, sql.toString(), null);
				}
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}


}
