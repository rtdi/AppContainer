package io.rtdi.appcontainer.dbactivationbase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import io.rtdi.appcontainer.plugins.database.DatabaseObjectTree;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.plugins.database.SelectSource;

public class TestCatalogService implements ICatalogService {

	@Override
	public ObjectType objectExists(Connection conn, String schema, String name) throws SQLException {
		if (name.toLowerCase().contains("exists")) {
			return ObjectType.TABLE;
		} else {
			return null;
		}
	}

	@Override
	public boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException {
		if (columnname.toLowerCase().contains("exists")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getTableDDL(Connection conn, String schema, String name) throws SQLException {
		return "create table " + schema + "." + name + "(col1 varchar)";
	}

	@Override
	public String getViewDDL(Connection conn, String schema, String name) throws SQLException {
		return "create view " + schema + "." + name + " select * from table1";
	}

	@Override
	public String getFunctionDDL(Connection conn, String schema, String name) throws SQLException {
		return "create function " + schema + "." + name + " return 1";
	}

	@Override
	public String getProcedureDDL(Connection conn, String schema, String name) throws SQLException {
		return "create procedure " + schema + "." + name + " return 1";
	}

	@Override
	public DatabaseObjectTree getDependencies(Connection conn, String schema, String name) throws SQLException {
		return new DatabaseObjectTree(schema, name, ObjectType.valueOfOrNull("TABLE"));
	}

	@Override
	public DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException {
		return null;
	}

	@Override
	public List<SelectSource> getAllSelectSources(Connection conn) throws SQLException {
		return null;
	}

}
