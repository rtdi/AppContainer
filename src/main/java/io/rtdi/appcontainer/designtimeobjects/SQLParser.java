package io.rtdi.appcontainer.designtimeobjects;

import io.rtdi.appcontainer.antlr.sql.HDBCDSParser.FromClauseContext;

public class SQLParser {

	public static String getFromClause(FromClauseContext ctx) {
		return ctx.getText();
	}
}
