package io.rtdi.appcontainer.plugins.databasehana;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.DatabaseObjectTree;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.plugins.database.SelectSource;

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

	@Override
	public DatabaseObjectTree getDependencies(Connection conn, String schema, String name) throws SQLException {
		String sql = "SELECT\r\n"
				+ "    dependent_database_name, dependent_schema_name, dependent_object_name, dependent_object_type,\r\n"
				+ "    base_database_name, base_schema_name, base_object_name, base_object_type,\r\n"
				+ "    HIERARCHY_LEVEL,\r\n"
				+ "    parent_id, node_id\r\n"
				+ "FROM HIERARCHY (\r\n"
				+ "    SOURCE (\r\n"
				+ "    	SELECT	dependent_database_name || '.' || dependent_schema_name || '.' || dependent_object_name AS parent_id, \r\n"
				+ "			    base_database_name || '.' || base_schema_name || '.' || base_object_name AS node_id,\r\n"
				+ "			    *\r\n"
				+ "		FROM object_dependencies WHERE dependency_type = 1 and base_object_type in ('TABLE', 'VIEW', 'SYNONYM'))\r\n"
				+ "    START WHERE dependent_database_name = (select database_name from m_database) AND dependent_schema_name = ? AND dependent_object_name = ?)\r\n"
				+ "ORDER BY HIERARCHY_LEVEL";
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, null);
		Map<String, DatabaseObjectTree> index = new HashMap<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			String database = null;
			try (ResultSet rs = stmt.executeQuery(); ) {
				DatabaseObjectTree referencing;
				while (rs.next()) {
					if (index.size() == 0) {
						index.put(rs.getString(10), tree);
						referencing = tree;
						tree.setType(ObjectType.valueOfOrNull(rs.getString(4)));
						database = rs.getString(1);
					} else {
						referencing = index.get(rs.getString(10));
					}
					DatabaseObjectTree child;
					if (rs.getString(5).equals(database)) {
						child = new DatabaseObjectTree(rs.getString(6), rs.getString(7), ObjectType.valueOfOrNull(rs.getString(8)));
					} else {
						String identifier = '"' + rs.getString(5) + "\".\"" + rs.getString(6) + "\".\"" + rs.getString(7) + '"';
						child = new DatabaseObjectTree(identifier, ObjectType.valueOfOrNull(rs.getString(8)));
					}
					referencing.addChild(child);
					index.put(rs.getString(11), child);
				}
				return tree;
			}
		}
	}

	@Override
	public DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException {
		String sql = "SELECT\r\n"
				+ "    dependent_database_name, dependent_schema_name, dependent_object_name, dependent_object_type,\r\n"
				+ "    base_database_name, base_schema_name, base_object_name, base_object_type,\r\n"
				+ "    HIERARCHY_LEVEL,\r\n"
				+ "    parent_id, node_id\r\n"
				+ "FROM HIERARCHY (\r\n"
				+ "    SOURCE (\r\n"
				+ "    	SELECT	dependent_database_name || '.' || dependent_schema_name || '.' || dependent_object_name AS node_id, \r\n"
				+ "			    base_database_name || '.' || base_schema_name || '.' || base_object_name AS parent_id,\r\n"
				+ "			    *\r\n"
				+ "		FROM object_dependencies WHERE dependency_type = 1 and dependent_object_type in ('TABLE', 'VIEW', 'SYNONYM'))\r\n"
				+ "    START WHERE base_database_name = (select database_name from m_database) AND base_schema_name = ? AND base_object_name = ?)\r\n"
				+ "ORDER BY HIERARCHY_LEVEL";
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, null);
		Map<String, DatabaseObjectTree> index = new HashMap<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			String database = null;
			try (ResultSet rs = stmt.executeQuery(); ) {
				DatabaseObjectTree referencing;
				while (rs.next()) {
					if (index.size() == 0) {
						index.put(rs.getString(11), tree);
						tree.setType(ObjectType.valueOfOrNull(rs.getString(8)));
						referencing = tree;
						database = rs.getString(5);
					} else {
						referencing = index.get(rs.getString(11));
					}
					DatabaseObjectTree child;
					if (rs.getString(1).equals(database)) {
						child = new DatabaseObjectTree(rs.getString(2), rs.getString(3), ObjectType.valueOfOrNull(rs.getString(4)));
					} else {
						String identifier = '"' + rs.getString(1) + "\".\"" + rs.getString(2) + "\".\"" + rs.getString(3) + '"';
						child = new DatabaseObjectTree(identifier, ObjectType.valueOfOrNull(rs.getString(4)));
					}
					referencing.addChild(child);
					index.put(rs.getString(10), child);
				}
				return tree;
			}
		}
	}

	@Override
	public List<SelectSource> getAllSelectSources(Connection conn) throws SQLException {
		List<SelectSource> res = new ArrayList<>();
		String sql = "SELECT schema_name, synonym_name AS object_name, 'SYNONYM' AS object_type, "
				+ "object_schema AS target_schema, object_name AS target_object_name, object_type as target_object_type "
				+ "FROM synonyms WHERE is_valid = 'TRUE'\r\n"
				+ "UNION all\r\n"
				+ "SELECT schema_name, view_name AS object_name, 'VIEW' AS object_type, "
				+ "schema_name AS target_schema, view_name AS target_object_name, 'VIEW' as target_object_type "
				+ "FROM views WHERE is_valid = 'TRUE'\r\n"
				+ "UNION ALL \r\n"
				+ "SELECT schema_name, table_name AS object_name, 'TABLE' AS object_type, "
				+ "schema_name AS target_schema, table_name AS target_object_name, 'TABLE' as target_object_type "
				+ "FROM tables WHERE is_temporary = 'FALSE'";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			try (ResultSet rs = stmt.executeQuery(); ) {
				while (rs.next()) {
					res.add(new SelectSource(rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)),
							rs.getString(4), rs.getString(5), ObjectType.valueOfOrNull(rs.getString(6)),
							conn.getSchema()));
				}
				return res;
			}
		}
	}

}
