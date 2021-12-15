package io.rtdi.appcontainer.rest.entity;

import java.net.HttpURLConnection;

import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.ws.rs.core.Response;

@Schema(description="Detailed error information from the server")
public class ErrorMessage {
	private Exception exception;
	private String message;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(Exception e) {
		super();
		exception = e;
		message = e.toString();
	}

	public ErrorMessage(String text) {
		super();
		this.message = text;
	}

	public String getMessage() {
		return message;
	}
	
	public String getHint() {
		if (exception instanceof AppContainerSQLException) {
			return ((AppContainerSQLException) exception).getHint();
		} else {
			return null;
		}
	}

	public String getSQLStatement() {
		if (exception instanceof AppContainerSQLException) {
			return ((AppContainerSQLException) exception).getSQLStatement();
		} else {
			return null;
		}
	}

	public String getSourceCodeLine() {
		StackTraceElement line = exception.getStackTrace()[0];
		String filename = line.getFileName();
		int lineno = line.getLineNumber();
		String link = null;
		try {
			Class<?> c = Class.forName(line.getClassName());
			String jarlocation = c.getProtectionDomain().getCodeSource().getLocation().getPath();
			String jarfile = jarlocation.substring(jarlocation.lastIndexOf('/')+1);
			int p = jarfile.indexOf('-');
			String module;
			if (p != -1) {
				module = jarfile.substring(0, p);
			} else {
				module = jarfile;
			}
			String packagename = c.getCanonicalName().substring(0, c.getCanonicalName().lastIndexOf(filename.substring(0, filename.lastIndexOf(".java")))-1);
			
			link = module + "/src/main/java/" + packagename.replace('.', '/') + "/" + filename + "#L" + String.valueOf(lineno);
		} catch (Exception e) {
		}
		return link;
	}

	public String getJavaClass() {
		StackTraceElement line = exception.getStackTrace()[0];
		return line.getClassName();
	}

	/**
	 * For any exception in JAX-RS create a response object for that
	 *  
	 * @param e is the exception to inform the end user about
	 * @return a Json with detailed information about the problem
	 */
	public static Response createResponse(Exception e) {
		return Response.status(HttpURLConnection.HTTP_ACCEPTED).entity(new ErrorMessage(e)).build();
	}

	public static Response createResponse(String text) {
		return Response.status(HttpURLConnection.HTTP_ACCEPTED).entity(new ErrorMessage(text)).build();
	}
}
