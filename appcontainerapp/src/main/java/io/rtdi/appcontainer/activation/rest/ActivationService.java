package io.rtdi.appcontainer.activation.rest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.activation.DirectoryDependency;
import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.repo.FileUtil;
import io.rtdi.appcontainer.repo.RepoDirectory;
import io.rtdi.appcontainer.repo.rest.RepoService;
import io.rtdi.appcontainer.repo.rest.entity.Folder;
import io.rtdi.appcontainer.rest.RestService;
import io.rtdi.appcontainer.rest.entity.CustomSuccessMessage;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.DatabaseProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/activation")
public class ActivationService extends RestService {

	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	
	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;
	
	public ActivationService() {
		super();
	}

	@GET
	@Path("activate/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "activate the code of this file or directory",
			description = "In case a file is provided, it gets activated, for a directory all within the scope of the directory is activated",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Activation feedback, what worked, which script got an error, what was skipped",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Folder.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "If the activation failed",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response activate(
    		@PathParam("path") 
    		@Parameter(
	   	    		description = "Path of the file or directory to activate",
	   	    		example = "dir1"
	   	    		)
	   		 String path) {

		try {
			java.nio.file.Path targetpath = RepoService.getEffectivePath(request, path);
			java.nio.file.Path upath = RepoDirectory.getRepoUserDir(request);
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			GlobalSchemaMapping gm = GlobalSchemaMapping.read(upath, dbprincipal.getSchema(), dbprincipal.getDBUser());
			SQLVariables variables = SQLVariables.read(upath);
			tickRepo();
			return CustomSuccessMessage.createResponse(activate(targetpath, targetpath, gm, variables));
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	private static String getActivationInfo(String text, java.nio.file.Path targetpath, java.nio.file.Path upath) {
		return text + ": \"" + getFilePath(targetpath, upath) + "\"";
	}
	
	private static String getFilePath(java.nio.file.Path targetpath, java.nio.file.Path upath) {
		java.nio.file.Path p = upath.relativize(targetpath);
		if (p != null) {
			return p.toString();
		} else {
			return ".";
		}
	}

	private ActivationResult activate(java.nio.file.Path targetpath, java.nio.file.Path activationrootpath, GlobalSchemaMapping gm, SQLVariables parentvariables) throws IOException, ServletException, SQLException {
		java.nio.file.Path upath = RepoDirectory.getRepoUserDir(request);
		if (targetpath.toFile().isFile()) {
			// activate a single file
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
			ActivationServiceDirectory service = provider.getActivationServices(upath);
			return service.activate(targetpath.toFile(), dbprincipal, gm, parentvariables, provider);
		} else if (targetpath.toFile().isDirectory()) {
			/*
			 * Take the parent variables and add the current directory .variables file - in case such file exists
			 */
			SQLVariables variables = SQLVariables.read(targetpath, parentvariables);
			// activate all in directory
			ActivationResult result = new ActivationResult(targetpath, getActivationInfo("Activating the directory", targetpath, upath));
			
			/*
			 *  Step 1: Check if the directory has a .requires file. If yes and it is within the activation scope, execute that first
			 */
			DirectoryDependency dep = DirectoryDependency.read(targetpath.toFile());
			if (dep != null) {
				ActivationResult info = result.addResult(targetpath, getActivationInfo("Found .requires file", targetpath, upath), null, ActivationSuccess.SUCCESS);
				List<String> dependents = dep.getDependents();
				for (String d : dependents) {
					java.nio.file.Path dpath;
					if (d.startsWith("/")) {
						dpath = RepoService.getEffectivePath(request, d);
					} else {
						dpath = targetpath.resolve(d);
					}
					if (dpath.startsWith(activationrootpath)) {
						// The dependent directory is within the selected activation path, hence gets activated first
						
						/*
						 * As a dependency can point to anywhere, the variables must be built from ground up
						 */
						SQLVariables depvariables = SQLVariables.readAllVariablesForPath(dpath, upath);
						info.add(activate(dpath, activationrootpath, gm, depvariables));
					} else {
						// outside the activation scope
						info.addResult(dpath, getActivationInfo("Dependent outside the scope of the activation is ignored", dpath, upath), null, ActivationSuccess.SUCCESS);
					}
				}
			}
			/*
			 * Step 2: Activate all files in this directory sorted by name
			 */
			File[] files = targetpath.toFile().listFiles(FileUtil.PLAINFILEFILTER);
			if (files != null) {
				Arrays.sort(files);
				for (File f : files) {
					result.add(activate(f.toPath(), activationrootpath, gm, variables));
				}
			}
			/*
			 * Step 3: Go through the child directories sorted by name
			 */
			files = targetpath.toFile().listFiles(FileUtil.DIRECTORYFILTER);
			if (files != null) {
				Arrays.sort(files);
				for (File f : files) {
					result.add(activate(f.toPath(), activationrootpath, gm, variables));
				}
			}
			

			return result;
		} else {
			// ignore
			return new ActivationResult(targetpath, getActivationInfo("Not a file or directory - ignored", targetpath, upath));
		}
	}
		

}
