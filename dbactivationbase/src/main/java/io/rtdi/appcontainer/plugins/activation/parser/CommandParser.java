package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * The line starts with a / char, so could be either a line comment or a block comment
 *
 */
public class CommandParser extends ParserCharSequence {

	public CommandParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == ';';
	}

	@Override
	public String toString() {
		return "<command>";
	}
	
	@Override
	public void setParsers() {
		addChildParser('/', new LineCommentInnerParser(this));
		addChildParser('*', new BlockCommentParser(this));
		addChildParser('(', new BracketParser(this));
		addChildParser('\'', new QuotedStringParser(this));
		addChildParser('"', new QuotedObjectParser(this));
		addChildParser('$', new DollarParser(this));
		addChildParser('&', new VariableParser(this));
	}

}
