package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.snowflake.SnowflakeSQLScriptParser;

public class SQLScriptPrinter implements ISQLScriptActivation {
	private SnowflakeSQLScriptParser parser = new SnowflakeSQLScriptParser();

	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public Boolean fireLineComment(String string) {
		return null;
	}

	@Override
	public boolean fireSQL(String text) {
		System.out.println(text);
		return true;
	}

	@Override
	public String fireAlias(String alias) {
		return alias;
	}

	@Override
	public String fireVariable(String variable) {
		return variable;
	}

	@Override
	public void parse(File file, ActivationResult result) throws FileNotFoundException, IOException, ActivationException, AppContainerSQLException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			parser.parse(reader, result, this);
		}
	}

	@Override
	public void parse(String text, ActivationResult result) throws IOException, ActivationException, AppContainerSQLException {
		Reader reader = new StringReader(text);
		parser.parse(reader, result, this);
	}

}