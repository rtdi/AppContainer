package io.rtdi.appcontainer.utils;

import java.util.List;

public class HanaSQLException extends Exception {

	private static final long serialVersionUID = 2754081147435338891L;
	private String sqltext;
	private String hint = null;
	private List<String> msglist;

	public HanaSQLException(Exception e, String sqltext, String hint) {
		super(e.getMessage(), e.getCause());
		this.sqltext = sqltext;
		this.hint = hint;
	}

	public HanaSQLException(Exception e, List<String> msglist, String hint) {
		super(e.getMessage(), e.getCause());
		this.msglist = msglist;
	}

	public HanaSQLException(String message, String hint) {
		super(message);
		this.hint = hint;
	}

	public String getHint() {
		return hint;
	}

	public String getSQLStatement() {
		return sqltext;
	}

	public List<String> getMsglist() {
		return msglist;
	}

}
