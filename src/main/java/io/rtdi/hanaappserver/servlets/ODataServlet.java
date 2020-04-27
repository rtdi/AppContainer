package io.rtdi.hanaappserver.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.rtdi.hanaappserver.rest.odata.hanatable.ODataCollectionProcessor;
import io.rtdi.hanaappserver.rest.odata.hanatable.ODataEdm;
import io.rtdi.hanaappserver.rest.odata.hanatable.ODataEntityProcessor;
import io.rtdi.hanaappserver.rest.odata.hanatable.ODataPrimitiveProcessor;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;

@WebServlet("/protected/odata/*")
public class ODataServlet extends HttpServlet {

	private static final long serialVersionUID = 4925659342206163213L;
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	private static Cache<String, ServiceMetadata> cache = Caffeine.newBuilder()
			  .expireAfterAccess(1, TimeUnit.MINUTES)
			  .maximumSize(10000)
			  .build();

	protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		try (Connection conn = SessionHandler.handleSession(req, log);) {
			OData odata = OData.newInstance();
			String path = req.getPathInfo();
			int p1 = path.indexOf('/', 1);
			int p2 = path.indexOf('/', p1+1);
			if (p2 == -1) { // no trailing '/' char
				p2 = path.length();
			}
			String schemaname = Util.decodeURIfull(path.substring(1, p1));
			String viewname = Util.decodeURIfull(path.substring(p1+1, p2));

			ServiceMetadata edm = cache.getIfPresent(schemaname + "." + viewname);
			if (edm == null) {
				edm = odata.createServiceMetadata(new ODataEdm(conn, schemaname, viewname), new ArrayList<EdmxReference>());
				cache.put(schemaname + "." + viewname, edm);
			}
			ODataHttpHandler handler = odata.createHandler(edm);
			handler.setSplit(2); // remove the schemaname and viewname from the odata considered URI path elements
			handler.register(new ODataCollectionProcessor(conn, schemaname, viewname, edm));
			handler.register(new ODataEntityProcessor(conn, schemaname, viewname, edm));
			handler.register(new ODataPrimitiveProcessor(conn, schemaname, viewname));
			handler.process(req, resp);
		} catch (RuntimeException | SQLException | HanaSQLException e) {
			log.error("Server Error occurred in ODataServlet", e);
			throw new ServletException(e);
		}
	}

}
