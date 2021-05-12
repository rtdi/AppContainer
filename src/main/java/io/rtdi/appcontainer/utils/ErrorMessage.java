package io.rtdi.appcontainer.utils;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Detailed error information from the server")
public class ErrorMessage {
	private Exception exception;
	private ErrorCode code;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(Exception e, ErrorCode code) {
		super();
		exception = e;
		this.code = code;
	}

	public String getMessage() {
		return exception.toString();
	}
	
	public int getErrorCode() {
		return code.getCode();
	}
	
	public boolean isRecoverable() {
		return code.isRecoverable();
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

	public List<String> getMsgList() {
		if (exception instanceof AppContainerSQLException) {
			return ((AppContainerSQLException) exception).getMsglist();
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

}
