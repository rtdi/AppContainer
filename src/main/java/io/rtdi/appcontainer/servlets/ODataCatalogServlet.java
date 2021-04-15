package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;

import io.rtdi.appcontainer.rest.odata.catalog.ODataCatalogEndpointsCollectionProcessor;
import io.rtdi.appcontainer.rest.odata.catalog.ODataCatalogEndpointsEdm;
import io.rtdi.appcontainer.rest.odata.catalog.ODataCatalogEndpointsEntityProcessor;
import io.rtdi.appcontainer.rest.odata.catalog.ODataCatalogEndpointsPrimitiveProcessor;
import io.rtdi.appcontainer.utils.SessionHandler;

@WebServlet("/protected/catalog/odataendpoints/*")
public class ODataCatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 49256593422061213L;
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	private static ODataCatalogEndpointsEdm catalogedm = new ODataCatalogEndpointsEdm();

	protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		try (Connection conn = SessionHandler.handleSession(req, log);) {
			OData odata = OData.newInstance();

			ServiceMetadata edm = odata.createServiceMetadata(catalogedm, new ArrayList<EdmxReference>());
			ODataHttpHandler handler = odata.createHandler(edm);
			handler.register(new ODataCatalogEndpointsCollectionProcessor(conn, edm));
			handler.register(new ODataCatalogEndpointsEntityProcessor(conn));
			handler.register(new ODataCatalogEndpointsPrimitiveProcessor(conn));
			handler.process(req, resp);
		} catch (RuntimeException | SQLException e) {
			log.error("Server Error occurred in ODataServlet", e);
			throw new ServletException(e);
		}
	}

}
