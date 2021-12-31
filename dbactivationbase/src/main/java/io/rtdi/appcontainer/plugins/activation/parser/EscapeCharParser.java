package io.rtdi.appcontainer.plugins.activation.parser;

/**
 * A \ char escapes the subsequent char
 *
 */
public class EscapeCharParser extends ParserSingleChar {
	
	public EscapeCharParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<\\>";
	}

	@Override
	public void setParsers() {
	}

}
