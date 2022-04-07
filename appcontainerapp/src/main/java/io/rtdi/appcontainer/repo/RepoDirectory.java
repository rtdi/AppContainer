package io.rtdi.appcontainer.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;

/**
 * The pattern of directories is<BR><BR>
 * 
 * /repo/DBUser/applicationname/db/DBSchema/...
 *
 */
public class RepoDirectory {
	public static final String JDBCREPO = "JDBCREPO";
	private static final Logger log = LogManager.getLogger("RootDirectory");

	public static Path getJDBCRepo(@NotNull ServletContext ctx) throws IOException {
		Object path =  ctx.getAttribute(JDBCREPO);
		if (path == null) {
			String webapprootpath = ctx.getRealPath("/");
			/*
			 * Move into the webserver's install dir and create a repo directory there.
			 */
			Path rootpath = Path.of(webapprootpath, "..", "..", "repo").toAbsolutePath();
			RepoDirectory.setJDBCRepo(ctx, rootpath);
			File rootdir = rootpath.toFile();
			if (!rootdir.exists()) {
				if (!rootdir.mkdirs()) {
					throw new IOException("Cannot create the repo root directory \"" + rootpath + "\"");
				}
			}
			log.info("Repository root path evaluated to \"{}\"", rootpath);
			return rootpath;
		} else {
			return (Path) path;
		}
	}

	public static void setJDBCRepo(ServletContext ctx, Path p) {
		ctx.setAttribute(JDBCREPO, p);
	}

	public static synchronized Path getRepoUserDir(@NotNull HttpServletRequest request) throws ServletException, IOException {
		IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
		if (dbprincipal == null) {
			throw new IOException("The user did not log in yet");
		}
		String dbuser = dbprincipal.getDBUser();
		Path userdir = getJDBCRepo(request.getServletContext()).resolve(encodePath(dbuser));
		File dir = userdir.toFile();
		if (!dir.exists()) {
			if (!dir.mkdir()) {
				log.error("Cannot create the repo user directory \"{}\"", userdir);
				throw new IOException("Cannot create the repo user directory \"" + userdir + "\"");
			}
		}
		return userdir;
	}
	
	public static String encodePath(String name) {
		// TODO: Implement an encoding method in case the name contains chars the file system does not allow
		return name;
	}

	public static String decodePath(String filename) {
		// TODO: Implement the decoding method
		return filename;
	}

}


