package io.rtdi.hanaappcontainer;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.ServletException;
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
		HanaPrincipal hanauser = (HanaPrincipal) request.getUserPrincipal();
        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
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
		if (!file.exists()) {
			response.sendError(Response.SC_NOT_FOUND, "File at location \"" + file.getAbsolutePath() + "\" does not exist");
			return;
		} else if (file.isDirectory()) {
        	contentpath = requestedpath.resolve("index.html");
        } else {
        	contentpath = requestedpath;
        }
		// The user is allowed if the requested path is within its own home directory
        if (!userdir.equals(hanauser.getHanaUser())) {
    		Permissions permissions = PermissionService.getPermissions(request, userdir, schemadir);
    		Set<String> dirs = permissions.getDirectories();
    		Path p = rootpath.resolve(userdir).resolve(schemadir);
    		Path r = p.relativize(contentpath.getParent()); // find the directory of the requested file
    		if (!dirs.contains(File.separatorChar + r.toString())) {
    			response.sendError(Response.SC_FORBIDDEN, "User has no permissions to read the data in location \"" + contentpath.getParent().toString() + "\"");
    			return;
    		}
        }
        file = contentpath.toFile();
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getAbsolutePath()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(contentpath, response.getOutputStream());
    }

}
