package io.rtdi.appcontainer.designtimeobjects.sql;

public class SQLScriptPrinter implements ISQLScriptActivation {

	@Override
	public void fireBlockComment(String string) {
	}

	@Override
	public void fireLineComment(String string) {
	}

	@Override
	public void fireSQL(String text) {
		System.out.println(text);
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
