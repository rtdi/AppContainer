package io.rtdi.appcontainer.plugins.databasesnowflake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.appcontainer.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;

public class SnowflakeCatalogService implements ICatalogService {
	
	@Override
	public ObjectType objectExists(Connection conn, String schema, String name) throws SQLException {
		String sql = "select \n"
				+ "  case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type, \n"
				+ "  table_name \n"
				+ "from information_schema.tables where table_schema = ? and table_name = ? \n"
				+ "union all \n"
				+ "select 'PROCEDURE', procedure_name from information_schema.procedures where procedure_schema = ? and procedure_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, schema);
			stmt.setString(4, name);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return ObjectType.valueOf(rs.getString(1));
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the Snowflake Information schema using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException {
		String sql = "select column_name from information_schema.columns where table_schema = ? and table_name = ? and column_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, columnname);
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the Snowflake Information schema using the SQL \"" + sql + "\"", null);
		}
	}

}
