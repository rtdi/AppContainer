package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import io.rtdi.appcontainer.WebAppConstants;
import io.rtdi.appcontainer.utils.Util;


@WebServlet("/protected/apps/*")
public class HanaAppServlet extends HanaUI5Servlet {

	private static final long serialVersionUID = -221309277266654L;

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
	        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
			if (filename.endsWith("/")) {
				filename += "index.html";
			}
	        Path relativepath = Path.of(filename);
	        Path rootpath = WebAppConstants.getWebAppRootPath(request.getServletContext()).resolve("protected/apps");
			Path requestedpath = rootpath.resolve(Util.makeRelativePath(relativepath.toString()));
			process(request, response, requestedpath, relativepath, getServletContext());
    	} catch (IOException e) {
    		response.sendError(Response.SC_NOT_FOUND, "HanaRepoServlet throw an error: " + e.getMessage());
    	}
    }

}

