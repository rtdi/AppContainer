package io.rtdi.appcontainer.plugins.databasesnowflake.parser;

import java.io.IOException;
import java.io.Reader;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.activation.parser.Parser;
import io.rtdi.appcontainer.plugins.activation.parser.ParserCharSequence;
import io.rtdi.appcontainer.plugins.activation.parser.QuotedObjectParser;
import io.rtdi.appcontainer.plugins.activation.parser.QuotedStringParser;

/**
 * Everything between two $$ ... $$ blocks 
 *
 */
public class DollarDollarParser extends ParserCharSequence {

	protected DollarDollarParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '$' && ctx.getChar(-1).equals('$');
	}

	@Override
	public String toString() {
		return "<$$...$$>";
	}

	@Override
	public void setParsers() {
		addChildParser('`', new BackTickParser(this));
		addChildParser('"', new QuotedObjectParser(this));
		addChildParser('\'', new QuotedStringParser(this));
	}

	@Override
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException, IOException {
		return sb.insert(0, "$");
	}

}
