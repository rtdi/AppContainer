package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.odata.JDBCoDataServiceList;
import io.rtdi.appcontainer.odata.ODataIdentifier;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import jakarta.servlet.ServletException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/odata")
public class JDBCoDataServiceListFacade extends JDBCoDataServiceList {

	@Override
	protected Connection getConnection() throws SQLException, ServletException {
		IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
		return dbprincipal.getConnection();
	}

	@Override
	@GET
	@Path("/tables/$metadata")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getODataMetadata(
			@QueryParam("$format")
    		String format
			) {
		return super.getODataMetadata(format);
	}

	@Override
	@GET
	@Path("/tables/" + ODataIdentifier.ENTITYSETNAME)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySet(
    		@QueryParam("$top")
    		Integer top,
    		@QueryParam("$skip")
    		Integer skip,
    		@QueryParam("$skiptoken")
    		String skiptoken,
    		@QueryParam("$format")
    		String format
			) {
		return super.getODataEntitySet(top, skip, skiptoken, format);
	}

}
