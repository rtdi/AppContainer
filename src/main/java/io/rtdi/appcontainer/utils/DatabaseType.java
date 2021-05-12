package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.SQLException;

public enum DatabaseType {
	HANA,
	SNOWFLAKE;
	
	public static DatabaseType getDatabaseType(Connection conn) throws SQLException {
		String drivername = conn.getMetaData().getDriverName();
		if (drivername.equals("Hana")) {
			return HANA;
		} else if (drivername.equals("Snowflake")) {
			return SNOWFLAKE;
		} else {
			throw new SQLException("Connection is with a database not supported");
		}
	}
}
