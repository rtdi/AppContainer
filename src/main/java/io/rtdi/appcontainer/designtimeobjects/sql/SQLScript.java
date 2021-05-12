package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.ActivationSuccess;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public class SQLScript {
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

	public static void execute(File file, ActivationResult result, ISQLScriptActivation sqlscript) throws FileNotFoundException, IOException, ActivationException, AppContainerSQLException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			parse(reader, result, sqlscript);
		}
	}

	public static void execute(String text, ActivationResult result, ISQLScriptActivation sqlscript) throws IOException, ActivationException, AppContainerSQLException {
		Reader reader = new StringReader(text);
		parse(reader, result, sqlscript);
	}

	public static void parse(Reader reader, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException, AppContainerSQLException {
		SQLScriptParserStates state = SQLScriptParserStates.SQL_TEXT;
		int r;
		int level = 0;
		boolean incodeblock = false;
		StringBuilder text = new StringBuilder();
		StringBuilder alias = new StringBuilder();
		while ((r = reader.read()) != -1) {
			char c = (char) r;
			switch (state) {
			case SLASH:
				text.append('/').append(c);
				if (c == '/') {
					state = SQLScriptParserStates.LINE_COMMENT;
				} else if (c == '*') {
					state = SQLScriptParserStates.BLOCK_COMMENT;
				}
				break;
			case BLOCK_COMMENT:
				text.append('/').append(c);
				if (c == '*') state = SQLScriptParserStates.BLOCK_COMMENT_END;
				break;
			case BLOCK_COMMENT_END:
				text.append('*').append(c); // text has all chars
				if (c == '/') {
					state = SQLScriptParserStates.SQL_TEXT;
					if (!incodeblock) {
						callback.fireBlockComment(text.toString());
						text = new StringBuilder();
					}
				}
				else state = SQLScriptParserStates.BLOCK_COMMENT; // The previous * char was just regular text
				break;
			case LINE_COMMENT:
				if (c == '\n') {
					state = SQLScriptParserStates.SQL_TEXT;
					if (!incodeblock) {
						callback.fireLineComment(text.toString());
						text = new StringBuilder();
					} else {
						text.append(c);
					}
				}
				else text.append(c);
				break;
			case SQL_TEXT:
				switch (c) {
				case '/': state = SQLScriptParserStates.SLASH; break;
				case '"': 
					state = SQLScriptParserStates.STRING_DOUBLE_QUOTE; 
					text.append(c);
					break;
				case '\'': 
					state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
					text.append(c);
					break;
				case ';':
					if (level == 0 && !incodeblock) { // a semicolon ends a sql command
						callback.fireSQL(text.toString());
						result.addResult("ExecuteSQL", text.toString(), ActivationSuccess.SUCCESS);
						text = new StringBuilder();
					} else {
						text.append(c);
					}
					break;
				case '(': 
					level++;
					text.append(c);
					break;
				case ')':
					level--;
					text.append(c);
					if (level < 0) {
						level = 0;
						throw new ActivationException("The number of brackets does not match, one more closing braket than open");
					}
					break;
				case '$': state = SQLScriptParserStates.DOLLAR_IN_SQL_TEXT; break;
				case '&':
					state = SQLScriptParserStates.AMPERSEND_IN_SQL_TEXT;
					alias = new StringBuilder();
					break;
				default: text.append(c);
				}
				break;
			case STRING_DOUBLE_QUOTE:
				switch (c) {
				case '\\': state = SQLScriptParserStates.STRING_ESCAPE_DOUBLE_QUOTE; break;
				case '"': 
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(c);
					break;
				case '$': state = SQLScriptParserStates.DOLLAR_IN_DOUBLE_QUOTE; break;
				case '&':
					state = SQLScriptParserStates.AMPERSEND_IN_DOUBLE_QUOTE;
					alias = new StringBuilder();
					break;
				default: text.append(c);
				}
				break;
			case STRING_SINGLE_QUOTE:
				switch (c) {
				case '\\': state = SQLScriptParserStates.STRING_ESCAPE_SINGLE_QUOTE; break;
				case '\'': 
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(c);
					break;
				case '$': state = SQLScriptParserStates.DOLLAR_IN_SINGLE_QUOTE; break;
				case '&':
					state = SQLScriptParserStates.AMPERSEND_IN_SINGLE_QUOTE;
					alias = new StringBuilder();
					break;
				default: text.append(c);
				}
				break;
			case STRING_ESCAPE_DOUBLE_QUOTE:
				text.append(c);
				state = SQLScriptParserStates.STRING_DOUBLE_QUOTE;
				break;
			case STRING_ESCAPE_SINGLE_QUOTE:
				text.append(c);
				state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
				break;
			case DOLLAR_IN_DOUBLE_QUOTE:
				if (c == '{') {
					alias = new StringBuilder();
					state = SQLScriptParserStates.ALIAS_IN_DOUBLE_QUOTE;
				} else {
					state = SQLScriptParserStates.STRING_DOUBLE_QUOTE;
					text.append('$').append(c);
				}
				break;
			case DOLLAR_IN_SINGLE_QUOTE:
				if (c == '{') {
					alias = new StringBuilder();
					state = SQLScriptParserStates.ALIAS_IN_SINGLE_QUOTE;
				} else {
					state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
					text.append('$').append(c);
				}
				break;
			case DOLLAR_IN_SQL_TEXT:
				if (c == '{') {
					alias = new StringBuilder();
					state = SQLScriptParserStates.ALIAS_IN_SQL_TEXT;
				} else if (c == '$') {
					// $$
					incodeblock = !incodeblock;
					state = SQLScriptParserStates.SQL_TEXT;
					text.append('$').append(c);
				} else {
					state = SQLScriptParserStates.SQL_TEXT;
					text.append('$').append(c);
				}
				break;
			case AMPERSEND_IN_DOUBLE_QUOTE:
				if (c == '{') {
					state = SQLScriptParserStates.VARIABLE_IN_DOUBLE_QUOTE;
				} else {
					alias.append(c);
					state = SQLScriptParserStates.VARIABLE_IN_DOUBLE_QUOTE;
				}
				break;
			case AMPERSEND_IN_SINGLE_QUOTE:
				if (c == '{') {
					state = SQLScriptParserStates.VARIABLE_IN_SINGLE_QUOTE;
				} else {
					alias.append(c);
					state = SQLScriptParserStates.VARIABLE_IN_SINGLE_QUOTE;
				}
				break;
			case AMPERSEND_IN_SQL_TEXT:
				if (c == '{') {
					state = SQLScriptParserStates.VARIABLE_IN_SQL_TEXT;
				} else {
					alias.append(c);
					state = SQLScriptParserStates.VARIABLE_IN_SQL_TEXT;
				}
				break;
			case ALIAS_IN_DOUBLE_QUOTE:
				if (c == '}') {
					state = SQLScriptParserStates.STRING_DOUBLE_QUOTE;
					text.append(callback.fireAlias(alias.toString()));
					alias = new StringBuilder();
				} else {
					alias.append(c);
				}
				break;
			case ALIAS_IN_SINGLE_QUOTE:
				if (c == '}') {
					state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
					text.append(callback.fireAlias(alias.toString()));
					alias = new StringBuilder();
				} else {
					alias.append(c);
				}
				break;
			case ALIAS_IN_SQL_TEXT:
				if (c == '}') {
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(callback.fireAlias(alias.toString()));
					alias = new StringBuilder();
				} else {
					alias.append(c);
				}
				break;
			case VARIABLE_IN_DOUBLE_QUOTE:
				if (c == '}') {
					state = SQLScriptParserStates.STRING_DOUBLE_QUOTE;
					text.append(callback.fireVariable(alias.toString()));
					alias = new StringBuilder();
				} else if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
					state = SQLScriptParserStates.STRING_DOUBLE_QUOTE;
					text.append(callback.fireVariable(alias.toString()));
					text.append(c);
				} else {
					alias.append(c);
				}
				break;
			case VARIABLE_IN_SINGLE_QUOTE:
				if (c == '}') {
					state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
					text.append(callback.fireVariable(alias.toString()));
					alias = new StringBuilder();
				} else if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
					state = SQLScriptParserStates.STRING_SINGLE_QUOTE;
					text.append(callback.fireVariable(alias.toString()));
					text.append(c);
				} else {
					alias.append(c);
				}
				break;
			case VARIABLE_IN_SQL_TEXT:
				if (c == '}') {
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(callback.fireVariable(alias.toString()));
					alias = new StringBuilder();
				} else if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(callback.fireVariable(alias.toString()));
					text.append(c);
				} else if (c == ';' && level == 0 && !incodeblock) { // a semicolon ends a sql command
					state = SQLScriptParserStates.SQL_TEXT;
					text.append(callback.fireVariable(alias.toString()));
					callback.fireSQL(text.toString());
					result.addResult("ExecuteSQL", text.toString(), ActivationSuccess.SUCCESS);
					text = new StringBuilder();
				} else {
					alias.append(c);
				}
				break;
			}
		}
	}

}
