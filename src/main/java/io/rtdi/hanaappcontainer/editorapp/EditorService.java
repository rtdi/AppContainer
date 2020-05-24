package io.rtdi.hanaappcontainer.editorapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.SuccessMessage;
import io.rtdi.hanaappserver.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

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
	@Operation(
			summary = "Content of a file",
			description = "Returns the content of the requested file",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The file content Json object",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = FileContent.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response getTextFileContent(
    		@PathParam("path")
   		 	@Parameter(
 	    		description = "Path in the format SCHEMA/dir1/dir2/fileX",
 	    		example = "SCHEMAXYZ/dir1/subdirA/fileX"
 	    		)
    		String path) {
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
	@Operation(
			summary = "All directories of the user",
			description = "Returns a tree of all schemas and their directories of the currently logged in user",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response writeTextFileContent(
    		@PathParam("path")
    		@Parameter(
 	    		description = "Path in the format SCHEMA/dir1/dir2/fileX",
 	    		example = "SCHEMAXYZ/dir1/subdirA/fileX"
 	    		)
    		String path,
    		@Parameter(
 	    		description = "payload of the file",
 	    		example = "This is a free form text"
 	    		)
    		String content) {
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

	@Schema(description="Json structure with the file content information")
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
