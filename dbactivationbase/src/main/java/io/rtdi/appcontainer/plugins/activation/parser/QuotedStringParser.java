package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * All strings under single quotes
 *
 */
public class QuotedStringParser extends ParserCharSequence {

	public QuotedStringParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<'..'>";
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '\'';
	}

	@Override
	public void setParsers() {
		addChildParser('\\', new EscapeCharParser(this));
		addChildParser('\\', new DollarParser(this));
	}

}
