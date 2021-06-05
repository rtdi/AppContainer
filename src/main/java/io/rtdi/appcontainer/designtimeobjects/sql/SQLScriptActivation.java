package io.rtdi.appcontainer.designtimeobjects.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.DatabaseType;
import io.rtdi.appcontainer.utils.IDDLStatements;
import io.rtdi.appcontainer.utils.hana.HanaSqlStatements;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeSqlStatements;

public class SQLScriptActivation implements ISQLScriptActivation {

	private Connection conn;
	private String schemaname;
	private GlobalSchemaMapping gm;
	private SQLVariables variables;
	private boolean skipnext = false;
	private IDDLStatements ddl;

	public SQLScriptActivation(Connection conn, String schemaname, GlobalSchemaMapping gm, SQLVariables variables) throws AppContainerSQLException {
		this.conn = conn;
		this.schemaname = gm.getActualSchema(schemaname, schemaname);
		try {
			conn.setSchema(schemaname);
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "setSchema(\"" + this.schemaname + "\")", "The first directory level is the name of the schema to use or an alias");
		}
		this.gm = gm;
		this.variables = variables;
		try {
			if (DatabaseType.getDatabaseType(conn) == DatabaseType.HANA) {
				ddl = new HanaSqlStatements();
			} else {
				ddl = new SnowflakeSqlStatements();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Driver returns unknown name", "Is the driver jar file the correct one?");
		}
	}

	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public void fireLineComment(String string) throws AppContainerSQLException {
		String[] parts = string.split("\\s");
		if (parts[1].equalsIgnoreCase("if")) {
			switch (parts[2].toLowerCase()) {
			case "object":
				if (parts[3].equalsIgnoreCase("exists")) {
					skipnext = !ddl.if_exists_object(conn, parts[4], gm);
				} else if (parts[3].equalsIgnoreCase("not") && parts[4].equalsIgnoreCase("exists")) {
					skipnext = ddl.if_exists_object(conn, parts[5], gm);
				}
				break;
			case "column":
				if (parts[3].equalsIgnoreCase("exists")) {
					skipnext = !ddl.if_exists_column(conn, parts[4], gm);
				} else if (parts[3].equalsIgnoreCase("not") && parts[4].equalsIgnoreCase("exists")) {
					skipnext = ddl.if_exists_column(conn, parts[5], gm);
				}
				break;
			}
		}
	}

	@Override
	public void fireSQL(String sql) throws AppContainerSQLException {
		if (!skipnext) {
			try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
				stmt.execute();
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, sql, null);
			}
		} else {
			skipnext = false;
		}
	}

	@Override
	public String fireAlias(String alias) throws ActivationException {
		return gm.getActualSchema(alias, schemaname);
	}

	@Override
	public String fireVariable(String variable) throws ActivationException {
		return variables.getValue(variable);
	}

}
