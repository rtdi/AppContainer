package io.rtdi.appcontainer.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.appcontainer.utils.HanaSQLException;
import io.rtdi.appcontainer.utils.SessionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/")
public class HanaGroupQuery {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("groupquery")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Execute a select statement and return the data as nested(!) Json",
			description = "It executes the provided select, nests the data and returns it",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A json deeply nested object representing the resultset",
	                    content = {
	                            @Content(
	                                    schema = @Schema(type = "object")
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
	@Tag(name = "ReadHana")
    public Response groupquery(
    		@QueryParam("$select")
   		 	@Parameter(
 	    		description = "The select statement to execute, must start with \"select\" as first keyword",
 	    		example = "select user_name from users"
 	    		)
    		String query,
    		@QueryParam("$levelcolumns")
   		 	@Parameter(
 	    		description = "The first n columns are used for the levels",
 	    		example = "3 because the query has three levels with three columns plus at least one column with a value"
 	    		)
    		int levelcolumns) {
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			if (query == null) {
				throw new HanaSQLException(query, "No parameter $select= provided");
			} else if (query.toUpperCase().startsWith("SELECT ")) {
				try (PreparedStatement stmt = conn.prepareStatement(query);) {
					ObjectMapper objectMapper = new ObjectMapper();
					DateFormat timeformatter = new SimpleDateFormat("HH:mm:ss");
					DateTimeFormatter timestampformatter = DateTimeFormatter.ISO_INSTANT;
					int rowcount = 0;
					try (ResultSet rs = stmt.executeQuery(); ) {
						int columncount = rs.getMetaData().getColumnCount();
						Node root = new Node(objectMapper, timeformatter, timestampformatter);
						while (rs.next()) {
							int i = 0;
							Node leaf = root;
							while (i < levelcolumns) {
								Object v = HanaQuery.getJsonValue(rs, i+1, timeformatter, timestampformatter);
								if (v != null) {
									String name = v.toString();
									Node n = leaf.getChild(name);
									if (n == null) {
										leaf = leaf.addChild(name);
									} else {
										leaf = n;
									}
								}
								i++;
							}
							while (i < columncount) {
								HanaQuery.setRestObject(rs, i+1, leaf.jsonnode, timeformatter, timestampformatter);
								i++;
							}
							rowcount++;
							if (rowcount > 30000) {
								throw new HanaSQLException(query, "The query read more than 30k records, that is prevented as safety precaution");
							}
						}
						return Response.ok(root.jsonnode.get("children")).build();
					}
				} catch (SQLException e) {
					throw new HanaSQLException(e, query, "Executed SQL statement threw an error");
				}
			} else {
				throw new HanaSQLException(query, "The provided query parameter does not start with the text \"select\"");
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

	public static class Node {
		private Map<String, Node> children = new HashMap<>();
		private ObjectNode jsonnode;
		private ObjectMapper objectMapper;
		private DateTimeFormatter timestampformatter;
		private DateFormat timeformatter;
		
		public Node(ObjectMapper objectMapper, DateFormat timeformatter, DateTimeFormatter timestampformatter) {
			this.objectMapper = objectMapper;
			this.jsonnode = objectMapper.createObjectNode();
			this.timeformatter = timeformatter;
			this.timestampformatter = timestampformatter;
		}

		public Node(ObjectMapper objectMapper, String o, DateFormat timeformatter, DateTimeFormatter timestampformatter) throws SQLException {
			this(objectMapper, timeformatter, timestampformatter);
			jsonnode.put("name", o);
		}
		
		public Node getChild(String v) {
			return children.get(v);
		}

		public Node addChild(String v) throws SQLException {
			Node n = new Node(objectMapper, v, timeformatter, timestampformatter);
			children.put(v, n);
			ArrayNode c = (ArrayNode) jsonnode.get("children");
			if (c == null) {
				c = objectMapper.createArrayNode();
				jsonnode.set("children", c);
			}
			c.add(n.jsonnode);
			return n;
		}
	}

}
