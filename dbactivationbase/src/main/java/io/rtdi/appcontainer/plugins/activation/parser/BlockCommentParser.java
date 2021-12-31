package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class BlockCommentParser extends ParserCharSequence {

	public BlockCommentParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '/' && ctx.getChar(-1) == '*';
	}

	@Override
	public String toString() {
		return "<blockcomment>";
	}
	@Override
	public void setParsers() {
	}

}
