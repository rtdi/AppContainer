package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class LoginError extends HttpServlet {

	private static final long serialVersionUID = 454683436219128919L;

	public LoginError() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ui5url = "/openui5/resources/sap-ui-core.js";
		
		out.println("<!DOCTYPE html>");
		out.println("<html style=\"height: 100%;\">");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login Error</title>");
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
		out.println("					<Text text=\"login failed\" />");
		out.println("				 </content>");
		out.println("			 </Page>");
		out.println("        </App>");
		out.println("    </mvc:View> ");
		out.println("</script>");
		
		out.println("  <script>");
		out.println("sap.ui.controller(\"local.controller\", {");
		out.println("  onLoginTap:function() {");
		out.println("    ");
		out.println("  }");
		out.println("});");

		out.println("var oView = sap.ui.xmlview({");
		out.println("  viewContent: jQuery('#view1').html()");
		out.println("});");
		out.println("oView.placeAt('content');");
		out.println("</script>");

		out.println("</head>");
		out.println("<body class='sapUiBody' style=\"height: 100%;\" >");
		out.println("    <div id=\"content\">");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
