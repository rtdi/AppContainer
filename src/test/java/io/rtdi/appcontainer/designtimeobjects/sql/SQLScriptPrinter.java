package io.rtdi.appcontainer.designtimeobjects.sql;

public class SQLScriptPrinter implements ISQLScriptActivation {

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

}
