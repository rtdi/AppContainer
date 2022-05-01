package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 754601115219128919L;

	public Logout() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(req);
			try {
				dbprincipal.logout();
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getSession(false).invalidate();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta http-equiv=\"refresh\" content=\"0; URL=index.html\"></head><body>");
		out.println("Redirecting to the <a href=\"index.html\">Index page</a></body></html>");
	}

}
