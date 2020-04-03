package io.rtdi.hanaappcontainer.designtimeobjects;

import io.rtdi.hanaappcontainer.antlr.sql.HDBCDSParser.FromClauseContext;

public class SQLParser {

	public static String getFromClause(FromClauseContext ctx) {
		return ctx.getText();
	}
}
