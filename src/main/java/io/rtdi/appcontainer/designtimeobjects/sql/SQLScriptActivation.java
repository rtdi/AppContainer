package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.DatabaseType;
import io.rtdi.appcontainer.utils.IDDLStatements;
import io.rtdi.appcontainer.utils.ISQLScriptParser;
import io.rtdi.appcontainer.utils.hana.HanaSQLScriptParser;
import io.rtdi.appcontainer.utils.hana.HanaSqlStatements;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeSQLScriptParser;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeSqlStatements;

public class SQLScriptActivation implements ISQLScriptActivation {

	private Connection conn;
	private String schemaname;
	private GlobalSchemaMapping gm;
	private SQLVariables variables;
	private boolean skipnext = false;
	private IDDLStatements ddl;
	private ISQLScriptParser parser;

	public SQLScriptActivation(Connection conn, String schemaname, GlobalSchemaMapping gm, SQLVariables variables) throws AppContainerSQLException {
		this.conn = conn;
		this.schemaname = gm.getActualSchema(schemaname, schemaname);
		try {
			conn.setSchema(this.schemaname);
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "setSchema(\"" + this.schemaname + "\")", "The first directory level is the name of the schema to use or an alias");
		}
		this.gm = gm;
		this.variables = variables;
		try {
			if (DatabaseType.getDatabaseType(conn) == DatabaseType.HANA) {
				ddl = new HanaSqlStatements();
				parser = new HanaSQLScriptParser();
			} else {
				ddl = new SnowflakeSqlStatements();
				parser = new SnowflakeSQLScriptParser();
			}
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "Driver returns unknown name", "Is the driver jar file the correct one?");
		}
	}
	
	/*
	 * The goal of any SQL script is to bring the database structure to the most recent level without losing data.
	 * - If a table does not exist, create it. 
	 * - If the table does exist but has one column less, add the column without dropping the table and hence its data
	 * - create or replace view
	 * - create or replace procedures/functions
	 * - ...
	 * 
	 * At the same time, 100% of the syntax today and in future must be supported.
	 */

	public void parse(File file, ActivationResult result) throws FileNotFoundException, IOException, ActivationException, AppContainerSQLException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			parser.parse(reader, result, this);
		}
	}

	public void parse(String text, ActivationResult result) throws IOException, ActivationException, AppContainerSQLException {
		Reader reader = new StringReader(text);
		parser.parse(reader, result, this);
	}


	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public Boolean fireLineComment(String string) throws AppContainerSQLException {
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
			return skipnext;
		} else if (parts[1].equalsIgnoreCase("endif")) {
			skipnext = false; // after an endif code is always executed
			return skipnext;
		}
		return null;
	}

	@Override
	public boolean fireSQL(String sql) throws AppContainerSQLException {
		if (!skipnext) {
			try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
				stmt.execute();
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, sql, null);
			}
			return true;
		} else {
			return false;
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
