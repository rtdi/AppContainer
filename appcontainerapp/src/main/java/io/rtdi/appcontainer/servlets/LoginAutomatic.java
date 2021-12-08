package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * The autologin is a method to bypass the form based login and rather provide the login data as url parameter.
 *
 */
@WebServlet("/autologin")
public class LoginAutomatic extends HttpServlet {

	private static final long serialVersionUID = 454601115219128919L;

	public LoginAutomatic() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(true);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String page = req.getParameter("page");
		if (username != null && password != null) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			if (page == null) {
				page = "index.html";
			}
			resp.sendRedirect(page);
			out.println("<!DOCTYPE html>");
			out.println("<html><head></head><body>");
			out.println("Redirecting to the <a href=\"" + page + "\">" + page + "</a></body></html>");
		} else {
			out.println("<!DOCTYPE html>");
			out.println("<html style=\"height: 100%;\">");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("The autologin page requires the URL parameters username and password and optionally the target page");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
