package io.rtdi.appcontainer.plugins.activation.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class LineCommentInnerParser extends ParserCharSequence {

	public LineCommentInnerParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '\n';
	}

	@Override
	public String toString() {
		return "<linecomment>";
	}
	
	@Override
	public void setParsers() {
	}

}
