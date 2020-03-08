package io.rtdi.hanaappcontainer.editorapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.SuccessMessage;
import io.rtdi.hanaappserver.utils.Util;

@Path("/editorapp")
public class EditorService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("file/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTextFileContent(@PathParam("path") String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		try {
			String username = user.getHanaUser();
			String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
			username = Util.validateFilename(username);
			File file = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!file.isFile()) {
				throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
			}
			return Response.ok(new FileContent(file, path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@POST
	@Path("file/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
    public Response writeTextFileContent(@PathParam("path") String path, String content) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		try {
			String username = user.getHanaUser();
			String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
			username = Util.validateFilename(username);
			File file = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!file.isFile()) {
				throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
			}
			Files.writeString(file.toPath(), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			return Response.ok(new SuccessMessage(path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	public static class FileContent {
		private String content;
		private String filename;
		private String path;
		
		public FileContent() {
			super();
		}

		public FileContent(File file, String path) throws IOException {
			this.path = path;
			this.filename = file.getName();
			content = new String(Files.readAllBytes(file.toPath()));
		}

		public String getContent() {
			return content;
		}

		public String getFilename() {
			return filename;
		}

		public String getPath() {
			return path;
		}
	}
}
