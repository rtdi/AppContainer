package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * The line starts with a / char, so could be either a line comment or a block comment
 *
 */
public class QuotedObjectParser extends ParserCharSequence {

	public QuotedObjectParser(Parser parent) {
		super(parent);
	}
	
	@Override
	public String toString() {
		return "<'..'>";
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '"';
	}

	@Override
	public void setParsers() {
		addChildParser('\\', new EscapeCharParser(this));
		addChildParser('$', new DollarParser(this));
	}

}
