package io.rtdi.hanaappserver.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import io.rtdi.hanaappcontainer.PermissionService;
import io.rtdi.hanaappcontainer.PermissionService.Permissions;
import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.Util;


@WebServlet("/protected/hanarepo/*")
public class HanaRepoServlet extends HanaUI5Servlet {

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
			HanaPrincipal hanauser = (HanaPrincipal) request.getUserPrincipal();
	        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
	        if (filename.startsWith("currentuser/")) {
	        	filename = hanauser.getHanaUser() + filename.substring(11);
	        }
	    	Path relativepath = Paths.get(filename);
	    	if (relativepath.getNameCount() < 1) {
				response.sendError(Response.SC_NOT_FOUND, "requested file has to follow the pattern /protected/hanarepo/{hanauser}/*");
				return;
	    	}
	        String userdir = relativepath.getName(0).toString();
			Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), userdir);
	
	        Path rootpath = WebAppConstants.getHanaRepo(request.getServletContext());
			Path requestedpath = rootpath.resolve(Util.makeRelativePath(relativepath.toString()));
			// The user is allowed if the requested path is within its own home directory
	        if (!userdir.equals(hanauser.getHanaUser())) {
	    		Permissions permissions = PermissionService.getPermissions(request, userdir);
	    		Set<String> dirs = permissions.getDirectories();
	    		Path r = upath.relativize(requestedpath.getParent()); // find the directory of the requested file
	    		if (!dirs.contains(PermissionService.getRestUri(r))) {
	    			response.sendError(Response.SC_FORBIDDEN, "User has no permissions to read the data in location \"" + requestedpath.getParent().toString() + "\"");
	    			return;
	    		}
	        }
			process(request, response, requestedpath, relativepath, getServletContext());
    	} catch (IOException e) {
    		response.sendError(Response.SC_NOT_FOUND, "HanaRepoServlet throw an error: " + e.getMessage());
    	}
    }

}

