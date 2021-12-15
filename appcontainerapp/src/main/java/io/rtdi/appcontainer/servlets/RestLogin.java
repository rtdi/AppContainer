package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.MediaType;

/**
 * The restlogin is a method to bypass the form based login and rather provide the login data as url parameter.
 *
 */
@WebServlet("/restlogin")
public class RestLogin extends HttpServlet {

	private static final long serialVersionUID = 454601115219128919L;

	public RestLogin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(MediaType.APPLICATION_JSON);
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(true);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && password != null) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			resp.sendRedirect("protected/rest/session/loginsuccess");
			out.println(
					"{'errorMessage':" +
					"   {'message': ' The restlogin page redirects to the protected success message to trigger the login procedure' }" +
					"}");
		} else {
			out.println(
					"{'errorMessage':" +
					"   {'message': 'The restlogin page requires the URL parameters username and password' }" +
					"}");
		}
	}

}
