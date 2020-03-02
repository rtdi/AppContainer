package io.rtdi.hanaappcontainer;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.Util;


@WebServlet("/protected/hanarepo/*")
public class HanaRepoServlet extends HttpServlet {

	private static final long serialVersionUID = -2213196309277266654L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		if (user == null) {
			throw new ServletException("No login information found?");
		}
		String username = Util.validateFilename(user.getHanaUser());
        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		File userspecific_repo = new File(rootpath, username);
        File file = new File(userspecific_repo, filename);
        if (file.isDirectory()) {
        	file = new File(file.getAbsolutePath(), "index.html");
        }
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }

}
