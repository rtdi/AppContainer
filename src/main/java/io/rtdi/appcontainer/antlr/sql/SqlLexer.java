package io.rtdi.appcontainer.antlr.sql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class SqlLexer extends Lexer {
	
	public SqlLexer(CharStream input) {
		super(input);
	}
	
	protected int determineFunction(int stdSymbol) {
		return stdSymbol;
	}

	protected int determineNumericType(String text) {
		return 0;
	}

	protected void emitDot() {
	}

}
