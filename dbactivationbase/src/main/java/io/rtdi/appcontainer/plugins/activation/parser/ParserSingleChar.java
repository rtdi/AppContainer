package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.IParser;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public abstract class ParserSingleChar extends Parser {
	
	protected ParserSingleChar(Parser parent) {
		super(parent);
	}

	@Override
	public StringBuilder read(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws IOException, ActivationException, SQLException {
		Character c;
		if ((c = readChar(reader, ctx)) != null) {
			if (getChildParsers() != null) {
				IParser parser = getChildParsers().getOrDefault(c, getDefaultParser());
				if (parser != null) {
					StringBuilder cb = parser.read(getNewStringBuilder(c), reader, ctx, result);
					sb.append(cb);
					fireChildParserCompleted(cb, parser, ctx, result);
					return fireParserComplete(sb, reader, ctx, result);
				} else {
					// The current char does not match any known pattern, so we must assume it is simply part of the normal text
					sb.append(c);
					return fireNoMatch(sb, ctx);
				}
			}
		}
		return sb;
	}

	protected StringBuilder fireNoMatch(StringBuilder sb, SQLParserContext ctx) {
		return sb;
	}

}
