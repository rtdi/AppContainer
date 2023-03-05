package io.rtdi.appcontainer.dbunittest.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class SQLSingleValueSelect {

	public static Object execute(String sqltext, Object[] parameters, Connection conn, IDatabaseProvider provider) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(sqltext);) {
			int index = 1;
			for (Object param : parameters) {
				stmt.setObject(index++, param);
			}
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return rs.getObject(1);
				} else {
					return null;
				}
			}
		}
	}

}
