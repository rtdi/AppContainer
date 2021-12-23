package io.rtdi.appcontainer.repo.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.repo.FileUtil;
import io.rtdi.appcontainer.repo.RepoDirectory;
import io.rtdi.appcontainer.repo.rest.entity.DirectoryContent;
import io.rtdi.appcontainer.repo.rest.entity.FileData;
import io.rtdi.appcontainer.repo.rest.entity.Folder;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.rest.entity.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
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

@Path("/repo")
public class RepoService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	
	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;
	
	
	@GET
	@Path("dir")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All directories of the user",
			description = "Returns a tree of all the directories of the currently logged in user",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Folder.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response dir() {
		return dir(null);
	}
	
	@GET
	@Path("dir/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All directories of the user relative to the current path",
			description = "Returns a tree of all the directories of the currently logged in user starting at {path}",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Folder.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response dir(
   		 @PathParam("path") 
   		 @Parameter(
   	    		description = "Path for which to produce the directory tree for or empty",
   	    		example = "dir1"
   	    		)
   		 String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			Folder directorytree = new Folder(targetpath.toFile(), path); 
			return Response.ok(directorytree).build();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	
	/**
	 * Read from the request the user directory and merge it with the path string.
	 * 
	 * @param request of the servlet
	 * @param path is the sub path to add or null, should not start with a slash or dot char
	 * @return the user repository path combined with the path if present
	 * @throws ServletException
	 * @throws IOException
	 */
	private static java.nio.file.Path getEffectivePath(@NotNull HttpServletRequest request, String path) throws ServletException, IOException {
		java.nio.file.Path upath = RepoDirectory.getRepoUserDir(request);
		java.nio.file.Path dirpath = null;
		if (path != null) {
			dirpath = java.nio.file.Path.of(FileUtil.validateFilename(path));
			return upath.resolve(dirpath);
		} else {
			return upath;
		} 
	}

	@GET
	@Path("files")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All files in a user root directory",
			description = "Returns a list of all files of the user root directory",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory content",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DirectoryContent.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response listFiles() {
		return listFiles(null);
	}

	@GET
	@Path("files/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All files in a user directory",
			description = "Returns a list of all files of the user in a given schema and directory",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory content",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DirectoryContent.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response listFiles(
    		 @PathParam("path") 
    		 @Parameter(
    	    		description = "Path to the directory relative to the user directory or null",
    	    		example = "dir1"
    	    		)
    		 String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			File filedir = targetpath.toFile();
			if (!filedir.exists()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			} else if (!filedir.isDirectory()) {
				throw new IOException("The file exists but is not a directory \"" + filedir.getAbsolutePath() + "\"");
			}
			DirectoryContent directorylist = new DirectoryContent(filedir, path);
			return Response.ok(directorylist).build();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("touch/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Create file",
			description = "Creates a file in the current users workspace at the given schema and directory location",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the file metadata",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = FileData.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown, e.g. file exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response touch(
    		@PathParam("path")
   		 	@Parameter(
 	    		description = "Path in the format dir1/dir2/fileX",
 	    		example = "dir1/fileX"
 	    		)
    		String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			File file = targetpath.toFile();
			if (file.exists()) {
				throw new IOException("The file exists on the server already \"" + file.getAbsolutePath() + "\"");
			}
			java.nio.file.Path newfile = Files.createFile(targetpath);
			FileData data = new FileData(newfile.toFile(), path);
			return Response.ok(data).build();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("mkdir/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Create directory",
			description = "Creates a directory in the current users workspace at the given path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown, e.g. path exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response mkDir(
    		@PathParam("path") 
   		 	@Parameter(
   	 	    		description = "Path in the format dir1/dir2",
   	 	    		example = "dir1"
   	 	    		)
    		String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			File filedir = targetpath.toFile();
			if (filedir.exists()) {
				throw new IOException("A file of that name exists already on the server \"" 
						+ filedir.getAbsolutePath() + "\"");
			}
			if (filedir.mkdir()) {
				return SuccessMessage.createResponseOK();
			} else {
				throw new IOException("Failed to create the directory on the server \"" 
						+ filedir.getAbsolutePath() + "\"");
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("rmdir/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Remove directory",
			description = "Removes a directory in the current users workspace at the given path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown, e.g. path does not exist",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response rmDir(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format dir1/dir2",
   	 	    		example = "dir1"
   	 	    		)
    		String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			File filedir = targetpath.toFile();
			if (!filedir.exists()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			} else if (!filedir.isDirectory()) {
				throw new IOException("The path exists but is no directory \"" + filedir.getAbsolutePath() + "\"");
			}
			FileUtil.rmDirRecursive(targetpath);
			return SuccessMessage.createResponseOK();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("rm/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Delete file",
			description = "Removes a file in the current users workspace specified by the path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown, e.g. path exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response rmFile(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format dir1/dir2/fileA",
   	 	    		example = "dir1/subdirA/fileX"
   	 	    		)
    		String path) {
		try {
			java.nio.file.Path targetpath = getEffectivePath(request, path);
			File file = targetpath.toFile();
			if (!file.exists()) {
				throw new IOException("The file is not accessible on the server \"" + file.getAbsolutePath() + "\"");
			} else if (file.isDirectory()) {
				throw new IOException("The path exists but is a directory \"" + file.getAbsolutePath() + "\"");
			}
			if (file.delete()) {
				return SuccessMessage.createResponseOK();
			} else {
				throw new IOException("Failed to delete the file on the server \"" 
						+ file.getAbsolutePath() + "\"");
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@POST
	@Path("mv/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Move file",
			description = "Moves a file from path to target location",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown, e.g. file at path does not exist",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response mvFile(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format app1/dir1/dir2/fileA",
   	 	    		example = "dir1/subdirA/fileX"
   	 	    		)
    		String path,
   		 	@Parameter(
   	 	    		description = "Json with the target location",
   	 	    		example = "{ path: \"dir1/subdirA/fileY\" }"
   	 	    		)
    		FileData target) {
		try {
			java.nio.file.Path frompath = getEffectivePath(request, path);
			java.nio.file.Path topath = getEffectivePath(request, target.getPath());
			if (!frompath.toFile().exists()) {
				throw new IOException("The file does not exist \"" + frompath.toAbsolutePath().toString() + "\"");
			}
			if (topath.toFile().exists()) {
				throw new IOException("The target file exist already \"" + topath.toAbsolutePath().toString() + "\"");
			}
			Files.move(frompath, topath);
			return SuccessMessage.createResponseOK();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}