package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * Decides what to do with a dollar char
 *
 */
public class DollarParser extends ParserSingleChar {
	
	public DollarParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<$?>";
	}

	@Override
	public void setParsers() {
		addChildParser('{', new AliasParser(this));
	}

	@Override
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException, IOException {
		return sb.deleteCharAt(0);
	}

}
