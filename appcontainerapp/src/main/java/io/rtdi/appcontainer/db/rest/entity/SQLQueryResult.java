package io.rtdi.appcontainer.db.rest.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLQueryResult {
	private String sql;
	private List<SQLResultSet> resultsets;
	
	public SQLQueryResult(String sql) {
		this.sql = sql;
	}

	public void addResultSet(ResultSet resultset, String name) throws SQLException {
		if (resultsets == null) {
			resultsets = new ArrayList<>();
		}
		resultsets.add(new SQLResultSet(resultset, name));
	}

	public String getSql() {
		return sql;
	}
	
	public List<SQLResultSet> getResultsets() {
		return resultsets;
	}
	
}
