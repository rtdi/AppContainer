package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * All code within (..) brackets
 *
 */
public class BracketParser extends ParserCharSequence {
	
	public BracketParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<(..)>";
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == ')';
	}

	@Override
	public void setParsers() {
		addChildParser('/', new LineCommentParser(this));
		addChildParser('*', new BlockCommentParser(this));
		addChildParser('(', this);
		addChildParser('\'', new QuotedStringParser(this));
		addChildParser('"', new QuotedObjectParser(this));
		addChildParser('$', new DollarParser(this));
		addChildParser('&', new VariableParser(this));
	}

}
