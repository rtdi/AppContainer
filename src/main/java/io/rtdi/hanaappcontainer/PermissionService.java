package io.rtdi.hanaappcontainer;

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

import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;

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
    public Response getPermissionObject(@PathParam("user") String user, @PathParam("schema") String schema) {
		try {
			String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
			String schemapath = user + File.separatorChar + schema;
			File file = new File(rootpath, schemapath);
			if (!file.isDirectory()) {
				throw new IOException("Cannot find directory \"" + file.getAbsolutePath() + "\" on the server");
			}
			return Response.ok(getPermissions(request, user, schema)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}
	
	public static Permissions getPermissions(HttpServletRequest request, String user, String schema) throws ServletException, IOException {
		HanaPrincipal hanauser = (HanaPrincipal) request.getUserPrincipal();
		if (hanauser == null) {
			throw new ServletException("No login information found?");
		}
    	HttpSession session = request.getSession(true);
		String schemapath = user + File.separatorChar + schema;
    	@SuppressWarnings("unchecked")
		Cache<String, Permissions> permissioncache = (Cache<String, Permissions>) session.getAttribute(FILEPERMISSIONCACHE);
    	if (permissioncache == null) {
    		permissioncache = Caffeine.newBuilder()
    		    .expireAfterWrite(5, TimeUnit.MINUTES)
    		    .maximumSize(10000)
    		    .build();
    		session.setAttribute(FILEPERMISSIONCACHE, permissioncache);
    	}
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		Permissions permissions = permissioncache.getIfPresent(schemapath);
		if (permissions == null) {
			permissions = new Permissions(hanauser, user, schema, rootpath);
			permissioncache.put(schemapath, permissions);
		}
		return permissions;
	}

	public static class Permissions {
		private String[] roles;
		private Set<String> directories = new HashSet<>();
		
		public Permissions(HanaPrincipal hanauser, String user, String schema, String rootpath) throws IOException {
			super();
			roles = hanauser.getRoles();

    		HashSet<String> assignedroles = new HashSet<>();
    		assignedroles.addAll(Arrays.asList(hanauser.getRoles()));
    		assignedroles.add("PUBLIC");
			java.nio.file.Path requestedpath = Paths.get(rootpath, user, schema);
			if (!requestedpath.toFile().exists()) {
				throw new IOException("The path \"" + requestedpath.toString() + "\" does not exist");
			} else if (!requestedpath.toFile().isDirectory()) {
				throw new IOException("The path \"" + requestedpath.toString() + "\" is not a directory");
			} else {
				addDirectories(requestedpath, directories, assignedroles, requestedpath, user.equals(hanauser.getHanaUser()));
			}
		}

		private void addDirectories(java.nio.file.Path dirpath, Set<String> directories, Set<String> assignedroles, java.nio.file.Path requestedpath, boolean own) throws IOException {
			File dir = dirpath.toFile();
			if (!own) { // this is not within the user's own directory
				File allowfile = new File(dir, "allow");
				if (allowfile.isFile()) {
		    		List<String> allowed = Files.readAllLines(allowfile.toPath());
		    		HashSet<String> allowedroles = new HashSet<>();
		    		allowedroles.addAll(allowed);
		    		allowedroles.retainAll(assignedroles);
		    		if (allowedroles.size() > 0) {
						directories.add(getRestUri(requestedpath.relativize(dirpath)));
		    		}
				}
			} else {
				directories.add(getRestUri(requestedpath.relativize(dirpath)));
			}
			File[] subdirs = dir.listFiles(new DirectoryFilter());
			if (subdirs != null) {
				for (File subdir : subdirs) {
					addDirectories(subdir.toPath(), directories, assignedroles, requestedpath, own);
				}
			}
		}
		
		private String getRestUri(java.nio.file.Path p) {
			String r = p.toString().replace('\\', '/');
			return '/' + r;
		}

		public String[] getRoles() {
			return roles;
		}

		public Set<String> getDirectories() {
			return directories;
		}

	}
	
	private static class DirectoryFilter implements FileFilter {

		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
		
	}
}
