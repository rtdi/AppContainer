package io.rtdi.appcontainer.activationapp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.WebAppConstants;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.DirectoryDependency;
import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.designtimeobjects.csv.CSVImport;
import io.rtdi.appcontainer.designtimeobjects.sql.SQLScript;
import io.rtdi.appcontainer.designtimeobjects.sql.SQLScriptActivation;
import io.rtdi.appcontainer.designtimeobjects.sql.SQLVariables;
import io.rtdi.appcontainer.realm.IAppContainerPrincipal;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ErrorCode;
import io.rtdi.appcontainer.utils.ErrorMessage;
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
				java.nio.file.Path upath = WebAppConstants.getRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path fpath = upath.resolve(path);
				File file = fpath.toFile();
				if (!file.isFile()) {
					throw new IOException("The file \"" + file.getAbsolutePath() + "\" is not a regular file");
				}
				String schemaname = Util.fileToSchemaname(file, upath.toFile());
				GlobalSchemaMapping gm = GlobalSchemaMapping.read(upath);
				SQLVariables variables = SQLVariables.read(upath);
				ActivationResult activationresult = new ActivationResult("Activating the file", null, ActivationSuccess.SUCCESS);
				try {
					activateFile(file, schemaname, conn, activationresult, upath, gm, variables);
					return Response.ok(activationresult).build();
				} catch (AppContainerSQLException e) {
					return Response.ok(activationresult).build();
				}
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, "Activation failed", null);
			}
		} catch (Exception e) {
			return Response.ok(new ErrorMessage(e, ErrorCode.LOWLEVELEXCEPTION)).build();
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
				java.nio.file.Path upath = WebAppConstants.getRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path filepath = upath.resolve(path);
				File file = filepath.toFile();
				if (!file.exists()) {
					throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
				}
				ActivationResult result = new ActivationResult("Activating the directory", null, ActivationSuccess.SUCCESS);
				try {
					GlobalSchemaMapping gm = GlobalSchemaMapping.read(upath);
					if (file.isDirectory()) {
						SQLVariables variables = SQLVariables.read(filepath);
						activateRecursive(file, null, conn, result, upath, filepath, gm, variables, new HashSet<>());
					} else {
						String schemaname = Util.fileToSchemaname(file, upath.toFile());
						SQLVariables variables = SQLVariables.read(filepath.getParent());
						activateFile(file, schemaname, conn, result, upath, gm, variables);
					}
					return Response.ok(result).build();
				} catch (AppContainerSQLException e) {
					return Response.ok(result).build();
				}
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, "Activation failed because the database connection has a problem", null);
			}
		} catch (Exception e) {
			return Response.ok(new ErrorMessage(e, ErrorCode.LOWLEVELEXCEPTION)).build();
		}
	}


	/**
	 * Activate a directory and its children. The directory might be the root directory without a schema name yet.
	 * 
	 * @param file
	 * @param schemaname
	 * @param conn
	 * @param result
	 * @param upath
	 * @param gm
	 * @param variables
	 * @throws AppContainerSQLException
	 * @throws IOException
	 * @throws ActivationException
	 */
	private void activateRecursive(
			File file, 
			String schemaname, 
			Connection conn, 
			ActivationResult result,
			java.nio.file.Path upath,
			java.nio.file.Path activationroot,
			GlobalSchemaMapping gm,
			SQLVariables variables,
			Set<File> visited) throws AppContainerSQLException, IOException, ActivationException {
		if (schemaname == null) {
			schemaname = Util.fileToSchemaname(file, upath.toFile());
		}
		if (file != null && file.isDirectory()) {
			File c = file.getCanonicalFile();
			if (!visited.contains(c)) {
				visited.add(c);
				File[] files = file.listFiles();
				Arrays.sort(files);
				// First activate all files...
				DirectoryDependency dep = DirectoryDependency.read(file, upath);
				if (dep != null) {
					List<File> depfiles = dep.getDependentsInside(activationroot);
					for (File f : depfiles) {
						if (!visited.contains(f)) {
							activateRecursive(f, schemaname, conn, result, upath, activationroot, gm, variables, visited);
						}
					}
				}
				for (File f : files) {
					if (f.isDirectory()) {
					} else {
						activateFile(f, schemaname, conn, result, upath, gm, variables);
					}
				}
				// then activate all directories
				for (File f : files) {
					if (f.isDirectory()) {
						ActivationResult dirresult = result.addResult("Activation of directory \"" + file.getName() + "\"", file.getName(), ActivationSuccess.SUCCESS);
						activateRecursive(f, schemaname, conn, dirresult, upath, activationroot, gm, SQLVariables.read(f.toPath(), variables), visited);
					}
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
			GlobalSchemaMapping gm,
			SQLVariables variables) throws IOException, ActivationException, AppContainerSQLException {
		FileTypes filetype = getFileType(file);
		if (filetype != null) {
			ActivationResult fileresult = null;
			try {
				if (schemaname == null) {
					schemaname = file.getParentFile().getName();
				}
				switch (filetype) {
				case CSV: {
					String tablename = file.getName().substring(0, file.getName().length()-4);
					fileresult = result.addResult("Activation of CSV import file \"" + file.getName() + "\"", tablename, ActivationSuccess.SUCCESS);
					CSVImport.csvImport(conn, file, schemaname, tablename, fileresult);
					break;
				}
				case SQL:
					fileresult = result.addResult("Activation of sql script \"" + file.getName() + "\"", file.getName(), ActivationSuccess.SUCCESS);
					SQLScriptActivation callback = new SQLScriptActivation(conn, schemaname, gm, variables);
					SQLScript.execute(file, fileresult, callback);
					break;
				}
			} catch (Exception e) {
				if (fileresult != null) {
					fileresult.setActivationSuccess(ActivationSuccess.FAILED);
				}
				if (e instanceof AppContainerSQLException) {
					AppContainerSQLException e1 = (AppContainerSQLException) e;
					fileresult.addResult("SQL operation failed", e1.getSQLStatement(), ActivationSuccess.FAILED);
				}
				throw e;
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
