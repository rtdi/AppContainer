package io.rtdi.appcontainer.servlets;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import io.rtdi.appcontainer.WebApplication;
import io.rtdi.appcontainer.repo.FileUtil;
import io.rtdi.appcontainer.utils.Util;


@WebServlet("/protected/repofiles/*")
public class RepoAppServlet extends UI5Servlet {

	private static final long serialVersionUID = -221309277266654L;

    /**
     * This servlet returns the requested file (or the index.html file in case a directory was requested) if the user
     * has the permissions to do so.
     * Permissions are evaluated via two options
     * 1. The user has access to all files within his protected/repo/{loggedin user}/ folder
     * 2. The user is part of a group the allow file in the requested directory lists.
     * 
     * Example for use case 2: The requested file was protected/repo/FRITZ/SCHEMA1/dir1/index.html
     * In the dir1 is a file called allow and it contains the line PUBLIC. All users are part of the database group PUBLIC, hence the file is served by the servlet. 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	try {
	        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
			if (filename.endsWith("/")) {
				filename += "index.html";
			}
			int p = filename.indexOf('/');
			if (p == -1) {
				throw new IOException("A repository path must contain a repository name as first element in the path");
			}
			String reponame = filename.substring(0, p);
			String mappedreponame = Util.getSchema(reponame, request);
			String repofile = filename.substring(p);
	        Path relativepath = Path.of(mappedreponame + repofile);
	        Path rootpath = WebApplication.getWebAppRootPath(request.getServletContext()).resolve("../../repo");
			Path requestedpath = rootpath.resolve(FileUtil.makeRelativePath(relativepath.toString()));
			process(request, response, requestedpath, relativepath, getServletContext());
    	} catch (IOException | URISyntaxException e) {
    		response.sendError(Response.SC_NOT_FOUND, "RepoServlet throw an error: " + e.getMessage());
    	}
    }

}

