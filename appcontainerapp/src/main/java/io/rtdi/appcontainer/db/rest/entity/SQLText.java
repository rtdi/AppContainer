package io.rtdi.appcontainer.db.rest.entity;

public class SQLText {
	private String sqltext;
	
	public SQLText() {
	}
	
	public SQLText(String text) {
		this.sqltext = text;
	}

	public String getSqltext() {
		return sqltext;
	}

	public void setSqltext(String text) {
		this.sqltext = text;
	}
	
}
