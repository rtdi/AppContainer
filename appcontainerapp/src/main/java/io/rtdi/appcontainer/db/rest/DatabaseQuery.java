package io.rtdi.appcontainer.db.rest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
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
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class DatabaseQuery {
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
    public Response query(
    		@QueryParam("$select")
   		 	@Parameter(
 	    		description = "The select statement to execute, must start with \"select\" as first keyword",
 	    		example = "select user_name from users"
 	    		)
    		String query) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			try (Connection conn = dbprincipal.getConnection();) {
				if (query == null) {
					throw new AppContainerSQLException("No parameter $select= provided", query, null);
				} else if (query.toUpperCase().startsWith("SELECT ")) {
					try (PreparedStatement stmt = conn.prepareStatement(query);) {
						ObjectMapper objectMapper = new ObjectMapper();
						ArrayNode rows = objectMapper.createArrayNode();
						DateFormat timeformatter = new SimpleDateFormat("HH:mm:ss");
						DateTimeFormatter timestampformatter = DateTimeFormatter.ISO_INSTANT;
						int rowcount = 0;
						try (ResultSet rs = stmt.executeQuery(); ) {
							int columncount = rs.getMetaData().getColumnCount();
							while (rs.next()) {
					    		ObjectNode row = rows.objectNode();
								for (int i = 1; i <= columncount; i++) {
					    			setRestObject(rs, i, row, timeformatter, timestampformatter);
					    		}
								rows.add(row);
								rowcount++;
								if (rowcount > 30000) {
									throw new AppContainerSQLException("The query read more than 30k records, that is prevented as safety precaution", query, null);
								}
							}
							return Response.ok(rows).build();
						}
					} catch (SQLException e) {
						throw AppContainerSQLException.cloneFrom(e, query, null);
					}
				} else {
					throw new AppContainerSQLException("The provided query parameter does not start with the text \"select\"", query, null);
				}
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	public static void setRestObject(ResultSet rs, int i, ObjectNode row, DateFormat timeformatter, DateTimeFormatter timestampformatter) throws SQLException {
		Object value = rs.getObject(i);
		if (value == null) {
			// null values are not added
		} else if (value instanceof CharSequence) {
			row.put(rs.getMetaData().getColumnName(i), ((CharSequence) value).toString());
		} else if (value instanceof Integer) {
			row.put(rs.getMetaData().getColumnName(i), (Integer) value);
		} else if (value instanceof Long) {
			row.put(rs.getMetaData().getColumnName(i), (Long) value);
		} else if (value instanceof Byte) {
			row.put(rs.getMetaData().getColumnName(i), (Byte) value);
		} else if (value instanceof Short) {
			row.put(rs.getMetaData().getColumnName(i), (Short) value);
		} else if (value instanceof BigInteger) {
			row.put(rs.getMetaData().getColumnName(i), (BigInteger) value);
		} else if (value instanceof BigDecimal) {
			row.put(rs.getMetaData().getColumnName(i), (BigDecimal) value);
		} else if (value instanceof Date) {
			row.put(rs.getMetaData().getColumnName(i), ((Date) value).toString());
		} else if (value instanceof Time) {
			row.put(rs.getMetaData().getColumnName(i), timeformatter.format((Time) value));
		} else if (value instanceof Timestamp) {
			row.put(rs.getMetaData().getColumnName(i), timestampformatter.format(((Timestamp) value).toInstant()));
		}
	}

	public static Object getJsonValue(ResultSet rs, int i, DateFormat timeformatter, DateTimeFormatter timestampformatter) throws SQLException {
		Object value = rs.getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof CharSequence) {
			return ((CharSequence) value).toString();
		} else if (value instanceof Integer) {
			return (Integer) value;
		} else if (value instanceof Long) {
			return (Long) value;
		} else if (value instanceof Byte) {
			return (Byte) value;
		} else if (value instanceof Short) {
			return (Short) value;
		} else if (value instanceof BigInteger) {
			return (BigInteger) value;
		} else if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		} else if (value instanceof Date) {
			return ((Date) value).toString();
		} else if (value instanceof Time) {
			return timeformatter.format((Time) value);
		} else if (value instanceof Timestamp) {
			return timestampformatter.format(((Timestamp) value).toInstant());
		} else {
			return null;
		}
	}


}
