package io.rtdi.appcontainer.db.rest.entity.sql;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class OrderByEntry extends PrettyPrint {
	private String value;
	private Boolean descending;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getDescending() {
		return descending;
	}
	public void setDescending(Boolean descending) {
		this.descending = descending;
	}
	public boolean isValid() {
		return value != null && value.length() > 0;
	}
	
	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		if (value != null && value.length() > 0) {
			sb.append(value);
			if (descending == Boolean.TRUE) {
				sb.append(" DESC");
			}
		}
		return sb.toString();
	}

}
