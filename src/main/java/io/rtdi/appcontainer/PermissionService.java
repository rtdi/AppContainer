package io.rtdi.appcontainer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/permissions")
public class PermissionService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	public static final String FILEPERMISSIONCACHE = "FILEPERMISSIONCACHE";

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("{user}/{schema}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Produce the permission tree",
			description = "In the Hana repository each user has its own objects organized by schemas. "
					+ "The USER1 might have cloned the files for schema XYZ and the "
					+ "currently requesting user might or might not have access.",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "A Json object with all directories the current user has access to",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Permissions.class)
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
	@Tag(name = "Information")
    public Response getPermissionObject(
    		@PathParam("user") 
    	    @Parameter(
    	    		description = "Hana repository owner",
    	    		example = "<currently logged in user to see his own files>"
    	    		)
    		String user) {
		try {
			java.nio.file.Path spath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), user);
			File file = spath.toFile();
			if (!file.isDirectory()) {
				throw new IOException("Cannot find directory \"" + file.getAbsolutePath() + "\" on the server");
			}
			return Response.ok(getPermissions(request, user)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}
	
	public static Permissions getPermissions(HttpServletRequest request, String user) throws ServletException, IOException {
		HanaPrincipal hanauser = (HanaPrincipal) request.getUserPrincipal();
		if (hanauser == null) {
			throw new ServletException("No login information found?");
		}
    	HttpSession session = request.getSession(true);
    	@SuppressWarnings("unchecked")
		Cache<String, Permissions> permissioncache = (Cache<String, Permissions>) session.getAttribute(FILEPERMISSIONCACHE);
    	if (permissioncache == null) {
    		permissioncache = Caffeine.newBuilder()
    		    .expireAfterWrite(5, TimeUnit.MINUTES)
    		    .maximumSize(10000)
    		    .build();
    		session.setAttribute(FILEPERMISSIONCACHE, permissioncache);
    	}
    	java.nio.file.Path rootpath = WebAppConstants.getHanaRepo(request.getServletContext());
		Permissions permissions = permissioncache.getIfPresent(user);
		if (permissions == null) {
			permissions = new Permissions(hanauser, user, rootpath.toString());
			permissioncache.put(user, permissions);
		}
		return permissions;
	}

	@Schema(description="Permission information for the current user")
	public static class Permissions {
		private String[] roles;
		private Set<String> directories = new HashSet<>();
		
		public Permissions(HanaPrincipal hanauser, String user, String rootpath) throws IOException {
			super();
			roles = hanauser.getRoles();

    		HashSet<String> assignedroles = new HashSet<>();
    		assignedroles.addAll(Arrays.asList(hanauser.getRoles()));
    		assignedroles.add("PUBLIC");
			java.nio.file.Path requestedpath = Paths.get(rootpath, user);
			if (!requestedpath.toFile().exists()) {
				throw new IOException("The path \"" + requestedpath.toString() + "\" does not exist");
			} else if (!requestedpath.toFile().isDirectory()) {
				throw new IOException("The path \"" + requestedpath.toString() + "\" is not a directory");
			} else {
				addDirectories(requestedpath, directories, assignedroles, requestedpath,
						user.equals(hanauser.getHanaUser()) || user.equals("PUBLIC"), false);
			}
		}

		/**
		 * A directory is added as allowed if either
		 * 1. The directory is within the same user
		 * 2. There is an allow file with at least one group the user has assigned in Hana
		 * 3. There is no allow file but the parent directory allowed the user
		 * 
		 * @param dirpath
		 * @param directories
		 * @param assignedroles
		 * @param requestedpath
		 * @param own
		 * @param parentallowed
		 * @throws IOException
		 */
		private void addDirectories(java.nio.file.Path dirpath, Set<String> directories, Set<String> assignedroles, java.nio.file.Path requestedpath, boolean own, boolean parentallowed) throws IOException {
			File dir = dirpath.toFile();
			boolean allow = parentallowed | own;
			if (!own) { // this is not within the user's own directory
				File allowfile = new File(dir, "allow");
				if (allowfile.isFile()) {
		    		List<String> allowed = Files.readAllLines(allowfile.toPath());
		    		HashSet<String> allowedroles = new HashSet<>();
		    		allowedroles.addAll(allowed);
		    		allowedroles.retainAll(assignedroles);
		    		allow = allowedroles.size() > 0;
				}
			}
			if (allow) {
				directories.add(getRestUri(requestedpath.relativize(dirpath)));				
				File[] subdirs = dir.listFiles(new DirectoryFilter());
				if (subdirs != null) {
					for (File subdir : subdirs) {
						if (!subdir.getName().equals(".git")) {
							addDirectories(subdir.toPath(), directories, assignedroles, requestedpath, own, allow);
						}
					}
				}
			}
		}
		
		public String[] getRoles() {
			return roles;
		}

		public Set<String> getDirectories() {
			return directories;
		}

	}
	
	public static String getRestUri(java.nio.file.Path p) {
		String r = p.toString().replace('\\', '/');
		return '/' + r;
	}

	private static class DirectoryFilter implements FileFilter {

		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
		
	}
}
