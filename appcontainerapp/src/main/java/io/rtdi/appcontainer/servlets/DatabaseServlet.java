package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * A database servlet is a normal servlet that has also a database connection. See {@link #doGet(HttpServletRequest, HttpServletResponse, Connection)}
 *
 */
public abstract class DatabaseServlet extends HttpServlet {

	private static final long serialVersionUID = 8662275676633639191L;

	public DatabaseServlet() {
	}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IDatabaseLoginPrincipal dbprincipal = getPrincipal(req);
		try (Connection conn = dbprincipal.getConnection();) {
			doGet(req, resp, conn);
		} catch (SQLException e) {
			resp.sendError(HttpURLConnection.HTTP_FORBIDDEN, e.getMessage());
			log("SQL Error", e);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp, Connection conn)  throws ServletException, IOException, SQLException {
		super.doGet(req, resp); // default implementation which should  be overwritten - returns an http error that this method is not implemented.
	}

	@Override
	protected final void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IDatabaseLoginPrincipal dbprincipal = getPrincipal(req);
		try (Connection conn = dbprincipal.getConnection();) {
			doPut(req, resp, conn);
		} catch (SQLException e) {
			resp.sendError(HttpURLConnection.HTTP_FORBIDDEN, e.getMessage());
			log("SQL Error", e);
		}
	}

	private void doPut(HttpServletRequest req, HttpServletResponse resp, Connection conn) throws ServletException, IOException, SQLException {
		super.doPut(req, resp); // default implementation which should  be overwritten - returns an http error that this method is not implemented.
	}

	@Override
	protected final void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IDatabaseLoginPrincipal dbprincipal = getPrincipal(req);
		try (Connection conn = dbprincipal.getConnection();) {
			doDelete(req, resp, conn);
		} catch (SQLException e) {
			resp.sendError(HttpURLConnection.HTTP_FORBIDDEN, e.getMessage());
			log("SQL Error", e);
		}
	}

	private void doDelete(HttpServletRequest req, HttpServletResponse resp, Connection conn) throws ServletException, IOException, SQLException {
		super.doDelete(req, resp); // default implementation which should  be overwritten - returns an http error that this method is not implemented.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IDatabaseLoginPrincipal dbprincipal = getPrincipal(req);
		try (Connection conn = dbprincipal.getConnection();) {
			doPost(req, resp, conn);
		} catch (SQLException e) {
			resp.sendError(HttpURLConnection.HTTP_FORBIDDEN, e.getMessage());
			log("SQL Error", e);
		}
	}

	private void doPost(HttpServletRequest req, HttpServletResponse resp, Connection conn) throws ServletException, IOException, SQLException {
		super.doPost(req, resp); // default implementation which should  be overwritten - returns an http error that this method is not implemented.
	}

	/**
	 * @param req
	 * @return must return the servlet principal of type IDatabaseLoginPrincipal
	 * @throws ServletException in case no correct IDatabaseLoginPrincipal can be found
	 */
	public static IDatabaseLoginPrincipal getPrincipal(HttpServletRequest req) throws ServletException {
		Principal principal = req.getUserPrincipal();
		if (principal == null) {
			throw new ServletException("There seems to be a web server configuration error. "
					+ "A protected page was accessed but no user information (Principal) was found.");
		} else if (principal instanceof IDatabaseLoginPrincipal) {
			IDatabaseLoginPrincipal dbprincipal = (IDatabaseLoginPrincipal) principal;
			return dbprincipal;
		} else {
			throw new ServletException("There seems to be a web server configuration error. "
					+ "User information (Principal) was found but it is not a IDatabaseLoginPrincipal.");
		}
	}

}
