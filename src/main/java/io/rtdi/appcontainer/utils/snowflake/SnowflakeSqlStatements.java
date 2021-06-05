package io.rtdi.appcontainer.utils.snowflake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ColumnIdentifier;
import io.rtdi.appcontainer.utils.IDDLStatements;
import io.rtdi.appcontainer.utils.ObjectIdentifier;

public class SnowflakeSqlStatements implements IDDLStatements {

	public static final String SNOWFLAKE_SQL_ALL_OBJECTS = "select table_schema as schema_name, table_name as object_name, "
			+ "case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type "
			+ "from information_schema.tables "
			+ "order by table_schema, table_name";

	public static final String SNOWFLAKE_SQL_SINGLE_OBJECT = "select table_schema as schema_name, table_name as object_name, "
			+ "case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type "
			+ "from information_schema.tables "
			+ "where table_schema = ? and table_name = ? order by table_schema, table_name";

	public static final String SNOWFLAKE_SQL_SELECT_OBJECTS = "select table_schema as schema_name, table_name as object_name, "
			+ "case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type "
			+ "from information_schema.tables ";
	
	@Override
	public boolean if_exists_object(Connection conn, String objectidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		ObjectIdentifier o = new ObjectIdentifier(conn, objectidentifier, gm);
		String sql = "select table_name from information_schema.tables where table_schema = ? and table_name = ? \n"
				+ "union all \n"
				+ "select procedure_name from information_schema.procedures where procedure_schema = ? and procedure_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, o.getSchemaname());
			stmt.setString(2, o.getObjectname());
			stmt.setString(3, o.getSchemaname());
			stmt.setString(4, o.getObjectname());
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Failed to search for the object in the Snowflake Information schema", null);
		}
	}

	@Override
	public boolean if_exists_column(Connection conn, String columnidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		ColumnIdentifier o = new ColumnIdentifier(conn, columnidentifier, gm);
		String sql = "select column_name from information_schema.columns where table_schema = ? and table_name = ? and column_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, o.getSchemaname());
			stmt.setString(2, o.getObjectname());
			stmt.setString(3, o.getColumnname());
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Failed to search for the column in the Snowflake Information schema", null);
		}
	}

}
