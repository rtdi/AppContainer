package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.Reader;
import java.util.Map;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class VariableParser extends ParserCharSequence {

	public VariableParser(Parser parent) {
		super(parent);
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return !((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_');
	}

	@Override
	public String toString() {
		return "<variable>";
	}

	@Override
	public void setParsers() {
	}

	@Override
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException {
		ctx.parserDidReadAhead(); // This parser reads one char more than what belongs to it, hence must rewind by one char
		Map<String, String> variables = ctx.getVariables().getVariables();
		String variable = sb.toString();
		String value = variable.substring(1, variable.length()-1);
		if (variables != null) {
			value = variables.get(value);
			if (value != null) {
				return new StringBuilder().append(value);
			} else {
				throw new ActivationException(
						String.format("The sql file contained a variable \"%s\" but it is not known in that context by any of the .variables files",
								variable)); 
			}
		} else {
			throw new ActivationException(
					String.format("The sql file contained a variable \"%s\" but there is no .variables file",
							variable)); 
		}
	}


}
