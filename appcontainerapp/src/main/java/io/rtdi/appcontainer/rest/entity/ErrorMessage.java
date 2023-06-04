package io.rtdi.appcontainer.rest.entity;

import java.net.HttpURLConnection;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.ws.rs.core.Response;

@Schema(description="Detailed error information from the server")
public class ErrorMessage {
	private Exception exception;
	private String message;
	private long timestamp;

	public ErrorMessage() {
		super();
		this.timestamp = System.currentTimeMillis();
	}

	public ErrorMessage(Exception e) {
		super();
		exception = e;
		message = e.toString();
		this.timestamp = System.currentTimeMillis();
	}

	public ErrorMessage(String text) {
		super();
		this.message = text;
		this.timestamp = System.currentTimeMillis();
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

	public String getType() {
		return exception.getClass().getSimpleName();
	}
	
	public String getSourceCodeLine() {
		StackTraceElement[] lines;
		if (exception instanceof AppContainerSQLException) {
			lines = ((AppContainerSQLException) exception).getActualException().getStackTrace();
		} else {
			lines = exception.getStackTrace();
		}
		StackTraceElement line = null;
		for (int i=0; i<lines.length; i++) {
			if (lines[i].getClassName().startsWith("io.rtdi")) {
				line = lines[i];
				break;
			}
		}
		String link = null;
		if (line != null) {
			String filename = line.getFileName();
			int lineno = line.getLineNumber();
			try {
				Class<?> c = Class.forName(line.getClassName());
				String jarlocation = c.getProtectionDomain().getCodeSource().getLocation().getPath();
				String jarfile = jarlocation.substring(jarlocation.lastIndexOf('/')+1);
				int p = jarfile.indexOf('-');
				String module;
				if (p != -1) {
					module = jarfile.substring(0, p);
				} else if (jarfile == null || jarfile.length() == 0) {
					module = "appcontainerapp";
				} else {
					module = jarfile;
				}
				String packagename = c.getCanonicalName().substring(0, c.getCanonicalName().lastIndexOf(filename.substring(0, filename.lastIndexOf(".java")))-1);
				
				link = "https://github.com/rtdi/AppContainer/blob/master/" + module + "/src/main/java/" + packagename.replace('.', '/') + "/" + filename + "#L" + String.valueOf(lineno);
			} catch (Exception e) {
			}
		}
		return link;
	}

	public String getJavaClass() {
		StackTraceElement line;
		if (exception instanceof AppContainerSQLException) {
			line = ((AppContainerSQLException) exception).getActualException().getStackTrace()[0];
		} else {
			line = exception.getStackTrace()[0];
		}
		return line.getClassName();
	}

	/**
	 * For any exception in JAX-RS create a response object for that
	 *  
	 * @param e is the exception to inform the end user about
	 * @return a Json with detailed information about the problem
	 */
	public static Response createResponse(Exception e) {
		return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(new ErrorMessage(e)).cacheControl(CustomSuccessMessage.control).build();
	}

	public static Response createResponse(String text) {
		return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(new ErrorMessage(text)).cacheControl(CustomSuccessMessage.control).build();
	}

	public long getTimestamp() {
		return timestamp;
	}
}
