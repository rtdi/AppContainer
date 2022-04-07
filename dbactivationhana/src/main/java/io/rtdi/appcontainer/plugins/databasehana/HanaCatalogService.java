package io.rtdi.appcontainer.plugins.databasehana;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.appcontainer.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;

public class HanaCatalogService implements ICatalogService {
	
	@Override
	public ObjectType objectExists(Connection conn, String schema, String name) throws SQLException {
		String sql = "select object_type from objects where schema_name = ? and object_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					switch (rs.getString(1)) {
					case "TABLE":
						return ObjectType.TABLE;
					case "VIEW":
					case "MONITORVIEW":
						return ObjectType.VIEW;
					case "SEQUENCE":
						return ObjectType.SEQUENCE;
					case "PROCEDURE":
						return ObjectType.PROCEDURE;
					case "FUNCTION":
						return ObjectType.FUNCTION;
					case "SYNONYM":
						return ObjectType.SYNONYM;
					default:
						return null;
					}
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the Hana data dictionary using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException {
		String sql = "select column_name from table_columns where schema_name = ? and table_name = ? and column_name = ? \n"
				+ "union all \n"
				+ "select column_name from view_columns where schema_name = ? and view_name = ? and column_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, columnname);
			stmt.setString(4, schema);
			stmt.setString(5, name);
			stmt.setString(6, columnname);
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the Hana data dictionary using the SQL \"" + sql + "\"", null);
		}
	}

	private String getDDL(Connection conn, String schema, String name, String type) throws AppContainerSQLException {
		String sql = "call GET_OBJECT_DEFINITION(? , ?)";
		try (CallableStatement stmt = conn.prepareCall(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next() ) {
					return rs.getString(1);
				} else {
					throw new AppContainerSQLException("call GET_OBJECT_DEFINITION() did return no data", sql, null);
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom("Failed to generate the table DDL", e, sql, null);
		}
	}
	
	@Override
	public String getTableDDL(Connection conn, String schema, String name) throws SQLException {
		return getDDL(conn, schema, name, "TABLE");
	}

	@Override
	public String getViewDDL(Connection conn, String schema, String name) throws SQLException {
		return getDDL(conn, schema, name, "VIEW");
	}

	@Override
	public String getFunctionDDL(Connection conn, String schema, String name) throws SQLException {
		return getDDL(conn, schema, name, "FUNCTION");
	}

	@Override
	public String getProcedureDDL(Connection conn, String schema, String name) throws SQLException {
		return getDDL(conn, schema, name, "PRODEDURE");
	}

}
