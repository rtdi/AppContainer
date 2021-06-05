package io.rtdi.appcontainer.utils.hana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ColumnIdentifier;
import io.rtdi.appcontainer.utils.IDDLStatements;
import io.rtdi.appcontainer.utils.ObjectIdentifier;

public class HanaSqlStatements implements IDDLStatements {

	public static final String HANA_SQL_ALL_OBJECTS = "select schema_name, object_name, object_type from objects\r\n" + 
			"where object_type in ('TABLE', 'VIEW') order by schema_name, object_name";
	public static final String HANA_SQL_SINGLE_OBJECT = "select schema_name, object_name, object_type from objects\r\n" + 
			"where object_type in ('TABLE', 'VIEW') and schema_name = ? and object_name = ? order by schema_name, object_name";
	public static final String HANA_SQL_SELECT_OBJECTS = "select schema_name, object_name, object_type from objects\r\n" + 
			"where object_type in ('TABLE', 'VIEW')";
	
	@Override
	public boolean if_exists_object(Connection conn, String objectidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		ObjectIdentifier o = new ObjectIdentifier(conn, objectidentifier, gm);
		String sql = "select object_name from objects where schema_name = ? and object_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, o.getSchemaname());
			stmt.setString(2, o.getObjectname());
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Failed to search for the object in the OBJECTS dictionary view", null);
		}
	}

	@Override
	public boolean if_exists_column(Connection conn, String columnidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		ColumnIdentifier o = new ColumnIdentifier(conn, columnidentifier, gm);
		String sql = "select column_name from table_columns where schema_name = ? and table_name = ? and column_name = ? \n"
				+ "union all \n"
				+ "select column_name from view_columns where schema_name = ? and view_name = ? and column_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, o.getSchemaname());
			stmt.setString(2, o.getObjectname());
			stmt.setString(3, o.getColumnname());
			stmt.setString(4, o.getSchemaname());
			stmt.setString(5, o.getObjectname());
			stmt.setString(6, o.getColumnname());
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Failed to search for the column in the TABLE_COLUMNS and VIEW_COLUMNS dictionary views", null);
		}
	}
	
}
