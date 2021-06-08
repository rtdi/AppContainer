package io.rtdi.appcontainer.designtimeobjects.sql;

import java.util.ArrayList;
import java.util.List;

public class SQLScriptCollector implements ISQLScriptActivation {
	private List<String> statements = new ArrayList<>();

	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public Boolean fireLineComment(String string) {
		return null;
	}

	@Override
	public boolean fireSQL(String text) {
		statements.add(text);
		return true;
	}

	@Override
	public String fireAlias(String alias) {
		return alias;
	}
	
	public List<String> getStatements() {
		return statements;
	}

	@Override
	public String fireVariable(String variable) {
		return variable;
	}

}
