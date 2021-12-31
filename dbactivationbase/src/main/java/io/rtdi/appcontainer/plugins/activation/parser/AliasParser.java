package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.Reader;
import java.util.Map;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class AliasParser extends ParserCharSequence {

	public AliasParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '}';
	}

	@Override
	public String toString() {
		return "<alias>";
	}

	@Override
	public void setParsers() {
	}

	@Override
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException {
		Map<String, String> aliases = ctx.getGlobalSchemaMapping().getMappings();
		String alias = sb.toString();
		String schema = alias.substring(1, alias.length()-1);
		if (aliases != null) {
			schema = aliases.get(schema);
			if (schema != null) {
				return new StringBuilder().append(schema);
			} else {
				throw new ActivationException(
						String.format("The sql file contained an alias \"%s\" but the .globalmapping file does not have a value for",
								alias)); 
			}
		} else {
			throw new ActivationException(
					String.format("The sql file contained an alias \"%s\" but there is no .globalmapping file",
							alias)); 
		}
	}


}
