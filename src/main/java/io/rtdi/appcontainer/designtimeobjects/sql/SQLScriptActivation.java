package io.rtdi.appcontainer.designtimeobjects.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public class SQLScriptActivation implements ISQLScriptActivation {

	private Connection conn;
	private String schemaname;
	private GlobalSchemaMapping gm;
	private SQLVariables variables;

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
	}

	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public void fireLineComment(String string) {
	}

	@Override
	public void fireSQL(String sql) throws AppContainerSQLException {
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.execute();
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, sql, null);
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
