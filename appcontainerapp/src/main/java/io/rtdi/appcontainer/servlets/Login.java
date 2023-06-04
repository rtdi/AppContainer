package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This is the login form Tomcat redirects the user to, in case a protected page is requested and the user is not logged in yet.
 * It also handles the autologin, which provides the username/password as session parameter.
 *
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 454601115219128919L;

	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		String username = null;
		String password = null;
		/* 
		 * This should not cache the html page so the code is always executed
		 */
		resp.setHeader("Cache-control", "no-cache, no-store");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Expires", "0");
		if (session != null) {
			username = (String) session.getAttribute("username");
			password = (String) session.getAttribute("password");
			session.removeAttribute("username");
			session.removeAttribute("password");
			if (username != null && password != null) {
				/*
				 * The login information was provided via the autologin servlet
				 */
				String target = "j_security_check?j_username=" + URLEncoder.encode(username, "UTF-8") + "&j_password=" + URLEncoder.encode(password, "UTF-8");
				// resp.sendRedirect(target);
				out.println("<!DOCTYPE html>");
				out.println("<html><head>");
				out.println("<script>\n"
						+ "    function loginForm() {\n"
						+ "        document.loginform.submit();\n"
						+ "    }\n"
						+ "</script>");
				out.println("</head>");
				out.println("<body onload=\"loginForm()\">\n");
				out.println("Redirecting to the <a href=\"" + target + "\">tomcat authenticator</a> (j_security_check)");
				out.println("<form name=\"loginform\" action=\"j_security_check\" method=\"post\">\n"
						+ "    <input type=\"hidden\" name=\"j_username\" value=\"" + username + "\">\n"
						+ "    <input type=\"hidden\" name=\"j_password\" value=\"" + password + "\">\n"
						+ "</form>\n"
						+ "</body>");
				out.println("</html>");
				return;
			}
		}
		if (username == null) username = "";
		if (password == null) password = "";
		String ui5url = "/openui5/resources/sap-ui-core.js";
		
		out.println("<!DOCTYPE html>");
		out.println("<html style=\"height: 100%;\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Login</title>");
		out.println("<script src=\"" + ui5url + "\"");
		out.println("	id=\"sap-ui-bootstrap\""); 
		out.println("	data-sap-ui-theme=\"sap_fiori_3\"");
		out.println("	data-sap-ui-libs=\"sap.m\">");
		out.println("</script>");

		out.println("<script id=\"view1\" type=\"sapui5/xmlview\">");
		out.println("    <mvc:View");
		out.println("        controllerName=\"local.controller\"");
		out.println("        xmlns:mvc=\"sap.ui.core.mvc\"");
		out.println("        xmlns=\"sap.m\">");
		out.println("        <App>");
		out.println("            <Page title=\"Login Form\">");
		out.println("				<content>");
		out.println("					<VBox fitContainer=\"true\" justifyContent=\"Center\" alignItems=\"Center\" alignContent=\"Center\">");
		out.println("						<items>");
		out.println("							<Input id=\"uid\" name=\"j_username\" value=\"" + username + "\" placeholder=\"User ID\"></Input>");
		out.println("							<Input id=\"pasw\" name=\"j_password\" value=\"" + password + "\" placeholder=\"Password\" type=\"Password\"></Input>");
		out.println("							<Button width=\"12rem\" text=\"Login\" type=\"Emphasized\" press=\"onLoginTap\"></Button>");
		out.println("						</items>");
		out.println("					</VBox>");
		out.println("				 </content>");
		out.println("			 </Page>");
		out.println("        </App>");
		out.println("    </mvc:View> ");
		out.println("</script>");
		
		out.println("  <script>");
		out.println("sap.ui.controller(\"local.controller\", {");
		out.println("  onLoginTap:function() {");
		out.println("    document.forms[0].submit();");
		out.println("  }");
		out.println("});");

		out.println("var oView = sap.ui.xmlview({");
		out.println("  viewContent: jQuery('#view1').html()");
		out.println("});");
		out.println("oView.placeAt('content');");
		out.println("</script>");

		out.println("</head>");
		out.println("<body class='sapUiBody' style=\"height: 100%;\" >");
		out.println("<form action=\"j_security_check\" method=\"post\">");
		out.println("    <div id=\"content\">");
		out.println("        <div id=\"htmllogin\"><div>UI5 seems not to be loaded, showing a basic login dialog instead</div>");
		out.println("        <label for=\"j_username\"><b>Username</b></label>");
		out.println("        <input type=\"text\" placeholder=\"Enter Username\" name=\"j_username\" required>");
		out.println("        <label for=\"j_password\"><b>Password</b></label>");
		out.println("        <input type=\"password\" placeholder=\"Enter Password\" name=\"j_password\" required>");
		out.println("        <button type=\"submit\">Login</button>");
		out.println("    </div></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
