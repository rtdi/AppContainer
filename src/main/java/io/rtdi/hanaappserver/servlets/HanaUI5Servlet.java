package io.rtdi.hanaappserver.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


public abstract class HanaUI5Servlet extends HttpServlet {

	private static final long serialVersionUID = -2213196309276654L;
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;
    
    public static void process(HttpServletRequest request, HttpServletResponse response, Path requestedpath, Path relativepath, ServletContext servletContext) throws IOException {
        File file = requestedpath.toFile();
		if (file.isDirectory()) {
			// send redirect
			String redirectto;
			if (relativepath.getFileName().toString().endsWith("/")) {
				redirectto = "index.html";
			} else {
				redirectto = relativepath.getFileName().toString() + "/index.html";
			}
        	ServletOutputStream out = response.getOutputStream();
    		out.println("<!DOCTYPE html>");
    		out.println("<html>");
    		out.println("  <head>");
    		out.println("    <meta http-equiv=\"refresh\" content=\"0; url=" + redirectto + "\" />");
    		out.println("  </head>");
    		out.println("  <body>");
    		out.println("    <p><a href=\"" + redirectto + "\">redirect to index.html</a></p>");
    		out.println("  </body>");
    		out.println("</html>");
    		return;
        }
        invocations++;
        lastprocessedtime = System.currentTimeMillis();
        file = requestedpath.toFile();
        if (file.isFile()) { // if the file exist, then output it
	        response.setHeader("Content-Type", servletContext.getMimeType(file.getAbsolutePath()));
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
	        Files.copy(requestedpath, response.getOutputStream());
	        return;
        }
        /*
         * When the file does not exist, then create some default ones automatically for UI5 applications
         */
        if (file.getName().endsWith(".html")) {
        	writeUI5HTML(response, requestedpath);
        	return;
        }
        if (file.getName().equals("Component.js")) {
        	writeUI5ComponentJS(response, requestedpath);
        	return;
        }
        if (file.getName().endsWith(".controller.js")) {
        	writeUI5ControllerJS(response, requestedpath);
        	return;
        }
        if (file.getName().equals("Component-preload.js")) {
        	writeEmpty(response, requestedpath);
        	return;
        }
		response.sendError(Response.SC_NOT_FOUND, "File at location \"" + file.getAbsolutePath() + "\" does not exist");
    }
    
    public static int getInvocations() {
    	return invocations;
    }

    public static long getStarttime() {
    	return starttime;
    }

    public static long getLastProcessedtime() {
    	return lastprocessedtime;
    }

    private static void writeUI5HTML(HttpServletResponse response, Path dir) throws IOException {
		String resourceroot = "ui5.app";
		String name = dir.getFileName().toString();
		int p = name.lastIndexOf(".");
		if (p > 0) {
			name = name.substring(0, p);
		}

    	ServletOutputStream out = response.getOutputStream();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("  <head>");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <script src=\"/HanaAppContainer/ui5libs/am4charts/dist/core.js\"></script>");
		out.println("    <script src=\"/HanaAppContainer/ui5libs/am4charts/dist/charts.js\"></script>");
		out.println("    <script");
		out.println("       id=\"sap-ui-bootstrap\"");
		out.println("       src=\"/openui5/resources/sap-ui-core.js\"");
		out.println("       data-sap-ui-libs=\"sap.m\"");
		out.println("       data-sap-ui-theme=\"sap_fiori_3\"");
		out.println("       data-sap-ui-async=\"true\"");
		out.println("       data-sap-ui-xx-bindingSyntax=\"complex\"");
		out.println("       data-sap-ui-xx-supportedLanguages=\"en\"");
		out.println("       data-sap-ui-frameOptions=\"trusted\"");
		out.println("       data-sap-ui-resourceroots='{");
		out.println("          \"ui5libs\": \"/HanaAppContainer/ui5libs\",");
		out.println("          \"ui5rest\": \"/HanaAppContainer/protected/rest\",");
		out.println("          \"ui5odata\": \"/HanaAppContainer/protected/odata\",");
		out.println("          \"ui5root\": \"/HanaAppContainer\",");
		out.println("          \"ui5externallibs\": \"/ui5externallibs\",");
		out.println("          \"" + resourceroot + "\": \"./\"");
		out.println("       }' >");
		out.println("    </script>");
		out.println("    <script>");
		out.println("        sap.ui.getCore().attachInit(function() {");
		out.println("            document.body.innerHTML=''");
		out.println("        	 new sap.m.Shell({");
		out.println("        	     app: new sap.ui.core.ComponentContainer({");
		out.println("        		     height : \"100%\",");
		out.println("        			 name : \"" + resourceroot + "\"");
		out.println("        		 }),");
		out.println("                appWidthLimited : false");	
		out.println("        	}).placeAt(\"content\");");
		out.println("        });");
		out.println("    </script>");
		out.println("  </head>");
		out.println("  <body class=\"sapUiBody\" id=\"content\" style=\"height: 100%;\" >");
		out.println("    <p>Loading OpenUI5 from <a href=\"/openui5/resources/sap-ui-core.js\">here</a></p>");
		out.println("  </body>");
		out.println("</html>");
        response.setHeader("Content-Type", "text/html");
    }

    private static void writeUI5ComponentJS(HttpServletResponse response, Path dir) throws IOException {
		String resourceroot = "ui5.app";

    	ServletOutputStream out = response.getOutputStream();
		out.println("sap.ui.define([\r\n" + 
				"           	\"sap/ui/core/UIComponent\",\r\n" + 
				"           	\"sap/ui/Device\"\r\n" + 
				"           ], function(UIComponent, Device) {\r\n" + 
				"           	\"use strict\";\r\n" + 
				"           	return UIComponent.extend(\"" + resourceroot + ".Component\", {\r\n" + 
				"           		metadata: {\r\n" + 
				"           			manifest: \"json\"\r\n" + 
				"           		},\r\n" + 
				"           		init: function() {\r\n" + 
				"           			UIComponent.prototype.init.apply(this, arguments);\r\n" +
				"           			document.title = this.getManifestEntry(\"/sap.app/title\");\r\n" +
				"           		}\r\n" + 
				"           	});\r\n" + 
				"           });");
        response.setHeader("Content-Type", "text/javascript");
    }

    private static void writeEmpty(HttpServletResponse response, Path dir) throws IOException {
        response.setHeader("Content-Type", "text/javascript");
    }

    private static void writeUI5ControllerJS(HttpServletResponse response, Path dir) throws IOException {
		String resourceroot = "ui5.app";
		String name = dir.getFileName().toString();
		name = name.replace(".controller.js", "");

    	ServletOutputStream out = response.getOutputStream();
		out.println("sap.ui.define([\r\n" + 
				"           	\"sap/ui/core/mvc/Controller\"\r\n" + 
				"           ], function(Controller) {\r\n" + 
				"           	\"use strict\";\r\n" + 
				"           	return Controller.extend(\"" + resourceroot + "." + name + "\", {\r\n" + 
				"           		onInit: function() {\r\n" + 
				"           			var oView = sap.ui.getCore().byId(\"mainview\");\r\n" + 
				"           			this.setModelRecursive(oView);\r\n" +
				"           		},\r\n" + 
				"           		setModelRecursive: function(oControl) {\r\n" + 
				"           			if (oControl.data('odataurl')) {\r\n" +
				"           				var oModel = new sap.ui.model.odata.v4.ODataModel({\r\n" + 
				"		    					serviceUrl : oControl.data('odataurl'), \r\n" + 
				"		    					\"autoExpandSelect\": true,\r\n" + 
				"								\"operationMode\": \"Server\",\r\n" + 
				"								\"groupId\": \"$direct\",\r\n" + 
				"								\"synchronizationMode\": \"None\"\r\n" + 
				"		    				});\r\n" + 
				"							oControl.setModel(oModel);\r\n" +
				"           			}\r\n" +
				"           			if ('getContent' in oControl) {\r\n" +
				"           				var aContent = oControl.getContent();\r\n" +
				"           				if (aContent) {\r\n" +
				"           					for (var i = 0; i<aContent.length; i++) {\r\n" +
				"           						this.setModelRecursive(aContent[i]);\r\n" +
				"           					}\r\n" +
				"           				}\r\n" +
				"           			}\r\n" +
				"           			if ('getItems' in oControl) {\r\n" +
				"           				var aContent = oControl.getItems();\r\n" +
				"           				if (aContent) {\r\n" +
				"           					for (var i = 0; i<aContent.length; i++) {\r\n" +
				"           						this.setModelRecursive(aContent[i]);\r\n" +
				"           					}\r\n" +
				"           				}\r\n" +
				"           			}\r\n" +
				"           		}\r\n" + 
				"           	});\r\n" + 
				"           });");
        response.setHeader("Content-Type", "text/javascript");
    }

}

