package io.rtdi.appcontainer.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;


public abstract class UI5Servlet extends HttpServlet {

	private static final long serialVersionUID = -2213196309276654L;
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;
    
    public static void process(HttpServletRequest request, HttpServletResponse response, Path requestedpath, Path relativepath, ServletContext servletContext) throws IOException {
        File file = requestedpath.toFile();
		if (file.isDirectory()) {
			/*
			 * In case the requested file is a directory, send a redirect to the index.html to be consistent with other web servers
			 */
			String redirectto = relativepath.getFileName().toString() + "/index.html";
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
        if (file.isFile()) {
        	/*
        	 * if the file exist, then output it
        	 */
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
        if (file.getName().equals("manifest.json")) {
        	writeUI5Manifest(response, requestedpath, request.getHeader("referer"));
        	return;
        }
        if (file.getName().equals("Component.js")) {
        	writeUI5ComponentJS(request, response, requestedpath);
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
		response.sendError(404, "File at location \"" + file.getAbsolutePath() + "\" does not exist");
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
		out.println("    <script");
		out.println("       id=\"sap-ui-bootstrap\"");
		out.println("       src=\"/openui5/resources/sap-ui-core.js\"");
		out.println("       data-sap-ui-libs=\"sap.m\"");
		out.println("       data-sap-ui-theme=\"sap_fiori_3\"");
		out.println("       data-sap-ui-async=\"true\"");
		out.println("       data-sap-ui-xx-bindingSyntax=\"complex\"");
		out.println("       data-sap-ui-xx-supportedLanguages=\"en\"");
		out.println("       data-sap-ui-frameOptions=\"trusted\"");
		out.println("       >");
		out.println("    </script>");
		out.println("    <script>");
		out.println("        sap.ui.getCore().attachInit(function() {");
		out.println("            document.body.innerHTML=''");
		out.println("        	 new sap.m.Shell({");
		out.println("        	     app: new sap.ui.core.ComponentContainer({");
		out.println("        		     height : \"100%\",");
		out.println("        			 name : \"ui5app\",");
		out.println("        			 url : \"./\"");
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

    private static void writeUI5Manifest(HttpServletResponse response, Path dir, String referer) throws IOException {
    	String pagename = "index";
    	if (referer != null) {
    		int p1 = referer.lastIndexOf('/');
    		int p2 = referer.lastIndexOf('.');
    		if (p1 > 0 && p2 > p1) {
    			pagename = referer.substring(p1+1, p2);
    		}
    	}
    	ServletOutputStream out = response.getOutputStream();
		out.println("{");
		out.println("	\"sap.app\": {");
		out.println("		\"id\": \""+ pagename + "\",");
		out.println("		\"type\": \"application\",");
		out.println("		\"title\": \"" + pagename + ".html\"");
		out.println("	},");
		out.println("	\"sap.ui5\": {");
		out.println("		\"rootView\": {");
		out.println("			\"viewName\": \"ui5app." + pagename + "\",");
		out.println("			\"type\": \"XML\"");
		out.println("		}");
		out.println("	}");
		out.println("}");
        response.setHeader("Content-Type", "application/json");
    }

    private static void writeUI5ComponentJS(HttpServletRequest request, HttpServletResponse response, Path dir) throws IOException {
    	String rootname = request.getContextPath();
    	ServletOutputStream out = response.getOutputStream();
		out.println("jQuery.sap.registerModulePath(\"ui5libs\", \"" + rootname + "/ui5libs\");");
		out.println("jQuery.sap.registerModulePath(\"am4charts\", \"" + rootname + "/ui5libs/am4charts/dist\");");
		out.println("jQuery.sap.registerModulePath(\"ui5rest\", \"" + rootname + "/protected/rest\");");
		out.println("jQuery.sap.registerModulePath(\"ui5odata\", \"" + rootname + "/protected/rest/odata\");");
		out.println("jQuery.sap.registerModulePath(\"ui5root\", \"" + rootname + "\");");
		out.println("jQuery.sap.registerModulePath(\"ui5externallibs\", \"ui5externallibs\");");
		out.println("jQuery.sap.registerModulePath(\"ui5app\", \"./\");");
		out.println("sap.ui.define([");
		out.println("           	\"sap/ui/core/UIComponent\","); 
		out.println("           	\"sap/ui/Device\""); 
		out.println("           ], function(UIComponent, Device) {");
		out.println("           	\"use strict\";");
		out.println("           	return UIComponent.extend(\"ui5app.Component\", {");
		out.println("           		metadata: {");
		out.println("           			manifest: \"json\"");
		out.println("           		},");
		out.println("           		init: function() {");
		out.println("           			UIComponent.prototype.init.apply(this, arguments);");
		out.println("           			document.title = this.getManifestEntry(\"/sap.app/title\");");
		out.println("           		}");
		out.println("           	});");
		out.println("           });");
        response.setHeader("Content-Type", "text/javascript");
    }

    private static void writeEmpty(HttpServletResponse response, Path dir) throws IOException {
        response.setHeader("Content-Type", "text/javascript");
    }

    private static void writeUI5ControllerJS(HttpServletResponse response, Path dir) throws IOException {
		String name = dir.getFileName().toString();
		name = name.replace(".controller.js", "");

    	ServletOutputStream out = response.getOutputStream();
		out.println("sap.ui.define([\r\n" + 
				"           	\"ui5libs/controls/Controller\"\r\n" + 
				"           ], function(Controller) {\r\n" + 
				"           	\"use strict\";\r\n" + 
				"           	return Controller.extend(\"ui5app." + name + "\", {\r\n" + 
				"           	});\r\n" + 
				"           });");
        response.setHeader("Content-Type", "text/javascript");
    }

}

