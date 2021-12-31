package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.IParser;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public abstract class ParserCharSequence extends Parser {

	protected ParserCharSequence(Parser parent) {
		super(parent);
	}

	@Override
	public StringBuilder read(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws IOException, ActivationException, SQLException {
		Character c;
		while ((c = readChar(reader, ctx)) != null) {
			IParser parser = null;
			if (getChildParsers() != null) {
				parser = getChildParsers().getOrDefault(c, getDefaultParser());
			} else if (getDefaultParser() != null) {
				parser = getDefaultParser();
			}
			if (parser != null) {
				StringBuilder cb = parser.read(getNewStringBuilder(c), reader, ctx, result);
				sb.append(cb);
				fireChildParserCompleted(cb, parser, ctx, result);
			} else {
				sb.append(c);
				if (isParsingComplete(c, ctx)) {
					return fireParserComplete(sb, reader, ctx, result);
				}
			}
		}
		return fireParserComplete(sb, reader, ctx, result);
	}

	protected abstract boolean isParsingComplete(Character c, SQLParserContext ctx);

}
