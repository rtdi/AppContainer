package io.rtdi.appcontainer.plugins.databaseabap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.DatabaseObjectTree;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.plugins.database.SelectSource;

public class AbapCatalogService implements ICatalogService {
	
	@Override
	public ObjectType objectExists(Connection conn, String schema, String name) throws SQLException {
		ResultSet rs = conn.getMetaData().getTables(null, null, name, new String[] {"TABLE", "VIEW"});
		if (rs.next()) {
			return ObjectType.valueOf(rs.getString(4));
		} else {
			return null;
		}
	}

	@Override
	public boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException {
		ResultSet rs = conn.getMetaData().getColumns(null, null, name, columnname);
		return rs.next();
	}

	private String getDDL(Connection conn, String schema, String name, String type) throws AppContainerSQLException {
		return null;
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
		return null;
	}

	@Override
	public DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException {
		return null;
	}

	@Override
	public List<SelectSource> getAllSelectSources(Connection conn, boolean showinternal) throws SQLException {
		List<SelectSource> res = new ArrayList<>();
		ResultSet rs = conn.getMetaData().getTables(null, null, null, new String[] {"TABLE", "VIEW"});
		while (rs.next()) {
			res.add(new SelectSource(rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)),
					rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)),
					null));
		}
		return res;
	}

}
