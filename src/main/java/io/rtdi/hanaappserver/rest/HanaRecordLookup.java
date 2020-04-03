package io.rtdi.hanaappserver.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;

@Path("/")
public class HanaRecordLookup {
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
    public Response lookupRecord(@PathParam("schema") String schemaraw, @PathParam("name") String nameraw) {
		String schema = Util.decodeURIfull(schemaraw);
		String name = Util.decodeURIfull(nameraw);
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			Map<String, String[]> parameters = request.getParameterMap();
			StringBuffer sql = new StringBuffer();
			sql.append("select");
			if (parameters.containsKey("$select")) {
				String[] p = parameters.get("$select");
				if (p.length == 1) {
					String[] projections = p[0].split("\\,");
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
					throw new HanaSQLException("More than a single select list passed in via URL parameter $select", parameters.toString());
				}
			} else {
				sql.append(" *");
			}
			sql.append(" from \"")
				.append(schema)
				.append("\".\"")
				.append(name)
				.append("\" where");
			
			List<String> params = new ArrayList<String>();
			boolean firstcondition = true;
			for (String f : parameters.keySet()) {
				if (!f.equals("$select")) {
					if (firstcondition) {
						firstcondition = false;
					} else {
						sql.append(" AND");
					}
					sql.append(" \"")
						.append(f)
						.append("\"");
					String[] values = parameters.get(f);
					if (values.length == 0) {
						sql.append(" is null");
					} else if (values.length == 1) {
						sql.append(" = ?");
						params.add(values[0]);
					} else {
						sql.append(" in (");
						boolean first = true;
						for (int i=0; i<values.length; i++) {
							if (first) {
								first = false;
							} else {
								sql.append(",");
							}
							sql.append(" ?");
							params.add(values[i]);
						}
						sql.append(")");
					}
				}
			}
			

			try (PreparedStatement stmt = conn.prepareStatement(sql.toString());) {
				int c = 1;
				for (String f : params) {
					stmt.setString(c++, f);
				}
				ObjectMapper objectMapper = new ObjectMapper();
				ObjectNode rootnode = objectMapper.createObjectNode();
				try (ResultSet rs = stmt.executeQuery(); ) {
					if (rs.next()) {
			    		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			    			rootnode.put(rs.getMetaData().getColumnName(i), rs.getString(i));
			    		}
					}
					return Response.ok(rootnode).build();
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql.toString(), "Executed SQL statement threw an error");
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}


}
