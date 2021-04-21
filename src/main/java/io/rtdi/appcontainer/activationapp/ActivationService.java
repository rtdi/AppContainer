package io.rtdi.appcontainer.activationapp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
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

import io.rtdi.appcontainer.WebAppConstants;
import io.rtdi.appcontainer.designtimeobjects.csv.CSVImport;
import io.rtdi.appcontainer.realm.IAppContainerPrincipal;
import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.appcontainer.utils.HanaSQLException;
import io.rtdi.appcontainer.utils.SessionHandler;
import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/activationapp")
public class ActivationService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("activate/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Activate file",
			description = "Activate a single design time object",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The detailed information what was activited and how",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = ActivationResult.class)
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
    public Response activateSingle(
    		@PathParam("path") 
    	    @Parameter(
    	    		description = "The location of a single file in the repository",
    	    		example = "USER1/SCHEMA1/dir1/dir2/mytable.hdbtable"
    	    		)
    		String path) {
		IAppContainerPrincipal user = (IAppContainerPrincipal) request.getUserPrincipal();
		try {
			String username = user.getDBUser();
			try (Connection conn = SessionHandler.handleSession(request, log);) {
				username = Util.validateFilename(username);
				java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path fpath = upath.resolve(path);
				File file = fpath.toFile();
				if (!file.isFile()) {
					throw new IOException("The file \"" + file.getAbsolutePath() + "\" is not a regular file");
				}
				String schemaname = Util.fileToSchemaname(file, upath.toFile());
				ActivationResult cdsactivationresult = new ActivationResult("Activating the file", null, ActivationSuccess.SUCCESS, null);
				java.nio.file.Path ppath = upath.getParent().resolve("PUBLIC").resolve(schemaname);
				activateFile(file, schemaname, conn, cdsactivationresult, upath, ppath);
				return Response.ok(cdsactivationresult).build();
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Activation failed", null);
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}
	
	@GET
	@Path("activateall/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Activate all files in a directory",
			description = "Activates all files in a directory recursively",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The detailed information what was activited and how",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = ActivationResult.class)
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
    public Response activateAll(@PathParam("path") String path) {
		IAppContainerPrincipal user = (IAppContainerPrincipal) request.getUserPrincipal();
		try {
			String username = user.getDBUser();
			try (Connection conn = SessionHandler.handleSession(request, log);) {
				username = Util.validateFilename(username);
				java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path filepath = upath.resolve(path);
				File file = filepath.toFile();
				if (!file.exists()) {
					throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
				}
				String schemaname = Util.fileToSchemaname(file, upath.toFile());
				if (schemaname != null) {
					ActivationResult result = new ActivationResult("Activating the directory", null, ActivationSuccess.SUCCESS, null);
					try {
						java.nio.file.Path ppath = upath.getParent().resolve("PUBLIC").resolve(schemaname);
						if (file.isDirectory()) {
							java.nio.file.Path relativepath = upath.relativize(filepath);
							// delete all existing files in repo/PUBLIC/schema that are going to be activated
							Util.rmDirRecursive(ppath.resolve(relativepath));
							result.addResult("Deleted all existing files in the matching PUBLIC repo space", relativepath.toString(), ActivationSuccess.SUCCESS, null);
							// copy the files in case there are any
							activateRecursive(file, schemaname, conn, result, upath, ppath);
						} else {
							activateFile(file, schemaname, conn, result, upath, ppath);
						}
						return Response.ok(result).build();
					} catch (HanaSQLException e) {
						return Response.ok(result).build();
					}
				} else {
					throw new HanaSQLException("The requested directory is invalid", file.getName());
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Activation failed because the database connection has a problem", null);
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}


	private void activateRecursive(
			File file, 
			String schemaname, 
			Connection conn, 
			ActivationResult cdsactivationresult,
			java.nio.file.Path upath,
			java.nio.file.Path ppath) throws HanaParsingException, HanaSQLException, IOException {
		if (file != null && file.isDirectory()) {
			File[] files = file.listFiles();
			Arrays.sort(files);
			for (File f : files) {
				if (f.isDirectory()) {
					activateRecursive(f, schemaname, conn, cdsactivationresult, upath, ppath);
				} else {
					activateFile(f, schemaname, conn, cdsactivationresult, upath, ppath);
				}
			}
		}
	}

	private void activateFile(
			File file,
			String schemaname,
			Connection conn,
			ActivationResult result,
			java.nio.file.Path upath,
			java.nio.file.Path ppath) throws HanaParsingException, HanaSQLException, IOException {
		FileTypes filetype = getFileType(file);
		if (filetype != null) {
			switch (filetype) {
			case CSV: {
				String tablename = file.getName().substring(0, file.getName().length()-4);
				CSVImport imp = new CSVImport(result, conn, ActivationStyle.RECONCILE);
				imp.csvImport(file, schemaname, tablename);
			}
			case SQL:
				break;
			}
		}
	}

	public static FileTypes getFileType(File file) {
		try {
			String filetype = Util.getFileExtension(file);
			if (filetype == null) {
				return null;
			} else {
				return FileTypes.valueOf(filetype.toUpperCase());
			}
		} catch (IllegalArgumentException e) {
			return null; // meaning this file has an extension that is not handled, which is just fine
		}

	}
}
