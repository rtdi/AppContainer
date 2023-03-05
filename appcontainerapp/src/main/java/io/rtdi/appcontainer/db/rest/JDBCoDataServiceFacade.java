package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.odata.JDBCoDataServiceForSchema;
import io.rtdi.appcontainer.odata.ODataIdentifier;
import io.rtdi.appcontainer.rest.RestService;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.Util;
import jakarta.servlet.ServletException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/odata")
public class JDBCoDataServiceFacade extends JDBCoDataServiceForSchema {
	private static RestService counter = new  RestService();
	
	@Override
	protected Connection getConnection() throws SQLException, ServletException {
		IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
		return dbprincipal.getConnection();
	}

	@Override
	@GET
	@Path("/tables/{schema}/{name}/")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySets(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@QueryParam("$format")
    		String format
			) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySets(schema, name, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/tables/{schema}/{name}/$metadata")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getODataMetadata(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
			String nameraw,
			@QueryParam("$format")
    		String format
			) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataMetadata(schema, name, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/tables/{schema}/{name}/" + ODataIdentifier.ENTITYSETNAME)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySet(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@QueryParam("$select")
    		String select,
    		@QueryParam("$filter")
    		String filter,
    		@QueryParam("$order")
    		String order,
    		@QueryParam("$top")
    		Integer top,
    		@QueryParam("$skip")
    		Integer skip,
    		@QueryParam("$skiptoken")
    		String skiptoken,
    		@QueryParam("$format")
    		String format
			) {
		counter.tickOData();
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySet(schema, name, select, filter, order, top, skip, skiptoken, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/tables/{schema}/{name}/" + ODataIdentifier.ENTITYSETNAME + "({keys})")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntityRow(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@PathParam("keys")
    		String keys,
    		@QueryParam("$select")
    		String select,
    		@QueryParam("$format")
    		String format
			) {
		counter.tickOData();
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntityRow(schema, name, keys, select, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/tables/{schema}/{name}/" + ODataIdentifier.ENTITYSETNAME + "/$count")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySetCount(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@QueryParam("$filter")
    		String filter,
    		@QueryParam("$format")
    		String format) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySetCount(schema, name, filter, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/schemas/{schema}/")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySetsForSchema(
    		@PathParam("schema")
    		String schemaraw,
    		@QueryParam("$format")
    		String format
			) {
		try {
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySetsForSchema(schema, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/schemas/{schema}/$metadata")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getODataMetadataForSchema(
    		@PathParam("schema")
    		String schemaraw,
			@QueryParam("$format")
    		String format
			) {
		try {
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataMetadataForSchema(schema, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/schemas/{schema}/{name}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySetForSchema(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@QueryParam("$select")
    		String select,
    		@QueryParam("$filter")
    		String filter,
    		@QueryParam("$order")
    		String order,
    		@QueryParam("$top")
    		Integer top,
    		@QueryParam("$skip")
    		Integer skip,
    		@QueryParam("$skiptoken")
    		String skiptoken,
    		@QueryParam("$format")
    		String format
			) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySetForSchema(schema, name, select, filter, order, top, skip, skiptoken, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/schemas/{schema}/{name}({keys})")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntityRowForSchema(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@PathParam("keys")
    		String keys,
    		@QueryParam("$select")
    		String select,
    		@QueryParam("$format")
    		String format
			) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntityRowForSchema(schema, name, keys, select, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@Override
	@GET
	@Path("/schemas/{schema}/{name}/$count")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getODataEntitySetCountForSchema(
    		@PathParam("schema")
    		String schemaraw,
    		@PathParam("name")
    		String nameraw,
    		@QueryParam("$filter")
    		String filter,
    		@QueryParam("$format")
    		String format) {
		try {
			String name = Util.decodeURIfull(nameraw);
			String schema = Util.decodeURIfull(schemaraw);
			schema = Util.getSchema(schema, request);
			return super.getODataEntitySetCountForSchema(schema, name, filter, format);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
