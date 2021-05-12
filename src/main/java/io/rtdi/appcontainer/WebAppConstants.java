package io.rtdi.appcontainer;

import java.nio.file.Path;

import javax.servlet.ServletContext;

public class WebAppConstants {
	public static final String JDBCREPO = "JDBCREPO";
	
	public static Path getJDBCRepo(ServletContext ctx) {
		return (Path) ctx.getAttribute(JDBCREPO);
	}

	public static void setJDBCRepo(ServletContext ctx, Path p) {
		ctx.setAttribute(JDBCREPO, p);
	}
	
	public static Path getRepoUserDir(ServletContext ctx, String username) {
		Path rootdir = getJDBCRepo(ctx);
		return rootdir.resolve(username);
	}

	public static Path getWebAppRootPath(ServletContext servletcontext) {
		return Path.of(servletcontext.getRealPath("/"));
	}
}
