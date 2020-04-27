package io.rtdi.hanaappcontainer;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import io.rtdi.hanaappcontainer.PermissionService.Permissions;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;


@WebServlet("/protected/hanarepo/*")
public class HanaRepoServlet extends HttpServlet {

	public static final String FILEPERMISSIONCACHE = "FILEPERMISSIONCACHE";
	private static final long serialVersionUID = -2213196309277266654L;
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;

    /**
     * This servlet returns the requested file (or the index.html file in case a directory was requested) if the user
     * has the permissions to do so.
     * Permissions are evaluated via two options
     * 1. The user has access to all files within his protected/hanarepo/{loggedin user}/ folder
     * 2. The user is part of a group the allow file in the requested directory lists.
     * 
     * Example for use case 2: The requested file was protected/hanarepo/FRITZ/SCHEMA1/dir1/index.html
     * In the dir1 is a file called allow and it contains the line PUBLIC. All users are part of the Hana group PUBLIC, hence the file is served by the servlet. 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	try {
			HanaPrincipal hanauser = (HanaPrincipal) request.getUserPrincipal();
	        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
	        if (filename.startsWith("[currentuser]/")) {
	        	filename = filename.replace("[currentuser]", hanauser.getHanaUser());
	        }
	    	Path relativepath = Paths.get(filename);
	    	if (relativepath.getNameCount() < 2) {
				response.sendError(Response.SC_NOT_FOUND, "requested file has to follow the pattern /protected/hanarepo/{hanauser}/{hanaschema}/*");
				return;
	    	}
	        String userdir = relativepath.getName(0).toString();
	        String schemadir = relativepath.getName(1).toString();
	
			Path rootpath = Paths.get(request.getServletContext().getRealPath(WebAppConstants.HANAREPO));
			Path requestedpath = rootpath.resolve(relativepath);
	        File file = requestedpath.toFile();
			Path contentpath;
			if (file.isDirectory()) {
	        	contentpath = requestedpath.resolve("index.html");
	        } else {
	        	contentpath = requestedpath;
	        }
			Path schemapath = rootpath.resolve(userdir).resolve(schemadir);
			// The user is allowed if the requested path is within its own home directory
	        if (!userdir.equals(hanauser.getHanaUser())) {
	    		Permissions permissions = PermissionService.getPermissions(request, userdir, schemadir);
	    		Set<String> dirs = permissions.getDirectories();
	    		Path r = schemapath.relativize(contentpath.getParent()); // find the directory of the requested file
	    		if (!dirs.contains(PermissionService.getRestUri(r))) {
	    			response.sendError(Response.SC_FORBIDDEN, "User has no permissions to read the data in location \"" + contentpath.getParent().toString() + "\"");
	    			return;
	    		}
	        }
	        invocations++;
	        lastprocessedtime = System.currentTimeMillis();
	        file = contentpath.toFile();
	        if (file.isFile()) { // if the file exist, then output it
		        response.setHeader("Content-Type", getServletContext().getMimeType(file.getAbsolutePath()));
		        response.setHeader("Content-Length", String.valueOf(file.length()));
		        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		        Files.copy(contentpath, response.getOutputStream());
		        return;
	        }
	        /*
	         * When the file does not exist, then create some default ones automatically for UI5 applications
	         */
	        if (file.getName().endsWith(".html")) {
	        	writeUI5HTML(response, contentpath);
	        	return;
	        }
	        if (file.getName().equals("Component.js")) {
	        	writeUI5ComponentJS(response, contentpath);
	        	return;
	        }
	        if (file.getName().equals("Component-preload.js")) {
	        	writeEmpty(response, contentpath);
	        	return;
	        }
			response.sendError(Response.SC_NOT_FOUND, "File at location \"" + file.getAbsolutePath() + "\" does not exist");
    	} catch (IOException e) {
    		response.sendError(Response.SC_NOT_FOUND, "HanaRepoServlet throw an error: " + e.getMessage());
    	}
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
		out.println("    <script");
		out.println("       id=\"sap-ui-bootstrap\"");
		out.println("       src=\"/openui5/resources/sap-ui-core.js\"");
		out.println("       data-sap-ui-theme=\"sap_fiori_3\"");
		out.println("       data-sap-ui-async=\"true\"");
		out.println("       data-sap-ui-xx-bindingSyntax=\"complex\"");
		out.println("       data-sap-ui-xx-supportedLanguages=\"en\"");
		out.println("       data-sap-ui-frameOptions=\"trusted\"");
		out.println("       data-sap-ui-resourceroots='{");
		out.println("          \"" + resourceroot + "\": \"./\"");
		out.println("       }' >");
		out.println("    </script>");
		out.println("    <script>");
		out.println("        sap.ui.getCore().attachInit(function () {");
		out.println("            document.body.innerHTML=''");
		out.println("            new sap.ui.xmlview({");
		out.println("                viewName: \"" + resourceroot + "." + name + "\", id: \"mainview\"");
		out.println("            }).placeAt(\"content\");");
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

}

