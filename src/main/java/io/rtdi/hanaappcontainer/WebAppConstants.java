package io.rtdi.hanaappcontainer;

import java.nio.file.Path;

import javax.servlet.ServletContext;

public class WebAppConstants {
	public static final String HANAREPO = "HANAREPO";
	
	public static Path getHanaRepo(ServletContext ctx) {
		return (Path) ctx.getAttribute(HANAREPO);
	}

	public static void setHanaRepo(ServletContext ctx, Path p) {
		ctx.setAttribute(HANAREPO, p);
	}
	
	public static Path getHanaRepoUserDir(ServletContext ctx, String username) {
		Path rootdir = getHanaRepo(ctx);
		return rootdir.resolve(username);
	}

	public static Path getHanaRepoSchemaDir(ServletContext ctx, String username, String schemaname) {
		Path rootdir = getHanaRepoUserDir(ctx, username);
		return rootdir.resolve(schemaname);
	}

}
