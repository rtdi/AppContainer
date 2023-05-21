package io.rtdi.appcontainer.plugins.databasepostgresql;

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

public class PostgresqlCatalogService implements ICatalogService {
	
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

	private String getDDL(Connection conn, String schema, String name, String type) throws AppContainerSQLException {
		String sql = "call GET_DDL(? , ?)";
		try (CallableStatement stmt = conn.prepareCall(sql);) {
			stmt.setString(1, type);
			stmt.setString(2, schema + "." + name);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next() ) {
					return rs.getString(1);
				} else {
					throw new AppContainerSQLException("call GET_DDL() did return no data", sql, null);
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
		updateDependencyTable(conn, false);
		String sql = "select referenced_database, referenced_schema, referenced_object_name, referenced_object_id, referenced_object_domain,\r\n"
				+ "  referencing_database, referencing_schema, referencing_object_name, referencing_object_id, referencing_object_domain,\r\n"
				+ "  dependency_type, level\r\n"
				+ "from \"__DEPENDENCIES\"\r\n"
				+ "    start with referencing_object_name = ? and referencing_schema = ? and referencing_database = ?\r\n"
				+ "    connect by\r\n"
				+ "      referenced_object_id = prior referencing_object_id\r\n"
				+ "order by level";
		String database = conn.getCatalog();
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, ObjectType.valueOfOrNull("TABLE"));
		Map<Integer, DatabaseObjectTree> index = new HashMap<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, name);
			stmt.setString(2, schema);
			stmt.setString(3, database);
			try (ResultSet rs = stmt.executeQuery();) {
				DatabaseObjectTree referencing;
				while (rs.next()) {
					if (index.size() == 0) {
						index.put(rs.getInt(9), tree);
						referencing = tree;
					} else {
						referencing = index.get(rs.getInt(9));
					}
					DatabaseObjectTree child;
					if (rs.getString(1).equals(database)) {
						child = new DatabaseObjectTree(rs.getString(2), rs.getString(3), ObjectType.valueOfOrNull(rs.getString(5)));
					} else {
						String identifier = '"' + rs.getString(1) + "\".\"" + rs.getString(2) + "\".\"" + rs.getString(3) + '"';
						child = new DatabaseObjectTree(identifier, ObjectType.valueOfOrNull(rs.getString(5)));
					}
					referencing.addChild(child);
					index.put(rs.getInt(4), child);
				}
			}
		}
		return tree;
	}

	@Override
	public DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException {
		updateDependencyTable(conn, false);
		String sql = "select referenced_database, referenced_schema, referenced_object_name, referenced_object_id, referenced_object_domain,\r\n"
				+ "  referencing_database, referencing_schema, referencing_object_name, referencing_object_id, referencing_object_domain,\r\n"
				+ "  dependency_type, level\r\n"
				+ "from \"__DEPENDENCIES\"\r\n"
				+ "    start with referenced_object_name = ? and referenced_schema = ? and referenced_database = ?\r\n"
				+ "    connect by\r\n"
				+ "      referencing_object_id = prior referenced_object_id"
				+ "order by level";
		String database = conn.getCatalog();
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, ObjectType.valueOfOrNull("TABLE"));
		Map<Integer, DatabaseObjectTree> index = new HashMap<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, name);
			stmt.setString(2, schema);
			stmt.setString(3, database);
			try (ResultSet rs = stmt.executeQuery();) {
				DatabaseObjectTree referencing;
				while (rs.next()) {
					if (index.size() == 0) {
						index.put(rs.getInt(4), tree);
						referencing = tree;
					} else {
						referencing = index.get(rs.getInt(4));
					}
					DatabaseObjectTree child;
					if (rs.getString(6).equals(database)) {
						child = new DatabaseObjectTree(rs.getString(7), rs.getString(8), ObjectType.valueOfOrNull(rs.getString(10)));
					} else {
						String identifier = '"' + rs.getString(6) + "\".\"" + rs.getString(7) + "\".\"" + rs.getString(8) + '"';
						child = new DatabaseObjectTree(identifier, ObjectType.valueOfOrNull(rs.getString(10)));
					}
					referencing.addChild(child);
					index.put(rs.getInt(9), child);
				}
			}
		}
		return tree;
	}
	
	private void updateDependencyTable(Connection conn, boolean force) throws SQLException {
		boolean tablereload = true;
		boolean tableexists = false;
		try (PreparedStatement stmt = conn.prepareStatement("select table_type, datediff(minute, last_altered, CURRENT_TIMESTAMP) as minutes from information_schema.tables where table_schema = ? and table_name = ?"); ) {
			stmt.setString(1, conn.getSchema());
			stmt.setString(2, "__DEPENDENCIES");
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					if (rs.getString(1).equals("LOCAL TEMPORARY")) {
						tableexists = true;
					}
					if (rs.getInt(2) < 15 && force == false) {
						tablereload = false;
					}
				}
			}
		}
		String identifier = '"' + conn.getSchema() + "\".\"" + "__DEPENDENCIES\"";
		if (tableexists) {
			if (tablereload) {
				try (PreparedStatement stmt = conn.prepareStatement("truncate table " + identifier); ) {
					stmt.execute();
				}
				try (PreparedStatement stmt = conn.prepareStatement("insert into " + identifier + " select * from snowflake.account_usage.OBJECT_DEPENDENCIES;"); ) {
					stmt.execute();
				}
			}
		} else {
			try (PreparedStatement stmt = conn.prepareStatement("create temporary table " + identifier + " as select * from snowflake.account_usage.OBJECT_DEPENDENCIES;"); ) {
				stmt.execute();
			}
		}
	}

	@Override
	public List<SelectSource> getAllSelectSources(Connection conn, boolean showinternal) throws SQLException {
		String sql = "select table_schema as schema_name, table_name as object_name, case when table_type = 'BASE TABLE' then 'TABLE' else table_type end as object_type\r\n"
				+ "from information_schema.tables";
		List<SelectSource> res = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					res.add(new SelectSource(rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)), rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)), conn.getSchema()));
				}
				return res;
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the Snowflake Information schema using the SQL \"" + sql + "\"", null);
		}
	}

}
