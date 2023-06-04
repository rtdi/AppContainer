package io.rtdi.appcontainer.db.rest.entity;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLColumnMetadata {
	private String label;
	private int jdbctype;
	private String typename;
	private int displaysize;
	private String name;

	public SQLColumnMetadata(ResultSetMetaData metadata, int i) throws SQLException {
		label = metadata.getColumnLabel(i);
		jdbctype = metadata.getColumnType(i);
		typename = metadata.getColumnTypeName(i);
		displaysize = metadata.getColumnDisplaySize(i);
		name = metadata.getColumnName(i);
	}

	public String getLabel() {
		return label;
	}

	public int getJdbctype() {
		return jdbctype;
	}

	public String getTypename() {
		return typename;
	}

	public int getDisplaysize() {
		return displaysize;
	}

	public String getName() {
		return name;
	}

}