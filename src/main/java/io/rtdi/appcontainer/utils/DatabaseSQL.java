package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.utils.hana.HanaSqlStatements;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeSqlStatements;

public class DatabaseSQL {

	public static String getAllObjects(Connection conn) throws SQLException {
		DatabaseType vendor = DatabaseType.getDatabaseType(conn);
		switch (vendor) {
		case HANA:
			return HanaSqlStatements.HANA_SQL_ALL_OBJECTS;
		case SNOWFLAKE:
			return SnowflakeSqlStatements.SNOWFLAKE_SQL_ALL_OBJECTS;
		}
		return null;
	}

}
