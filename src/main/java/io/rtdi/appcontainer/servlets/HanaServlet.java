package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.utils.SessionHandler;

public abstract class HanaServlet extends HttpServlet {

	private static final long serialVersionUID = 8662275676633639191L;
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	public HanaServlet() {
	}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (Connection conn = SessionHandler.handleSession(req, log);) {
			doget(req, resp, conn);
		} catch (SQLException e) {
			resp.sendError(Status.FORBIDDEN.getStatusCode(), e.getMessage());
			log.error("SQL Error", e);
		}
		
	}

	protected void doget(HttpServletRequest req, HttpServletResponse resp, Connection conn)  throws ServletException, IOException, SQLException {
		super.doGet(req, resp); // default implementation which should  be overwritten - returns an http error that this method is not implemented.
	}

}
