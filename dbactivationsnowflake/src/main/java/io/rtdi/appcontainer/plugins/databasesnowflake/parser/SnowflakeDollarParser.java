package io.rtdi.appcontainer.plugins.databasesnowflake.parser;

import io.rtdi.appcontainer.plugins.activation.parser.DollarParser;
import io.rtdi.appcontainer.plugins.activation.parser.Parser;

public class SnowflakeDollarParser extends DollarParser {

	protected SnowflakeDollarParser(Parser parent) {
		super(parent);
	}

	@Override
	public void setParsers() {
		super.setParsers();
		addChildParser('$', new DollarDollarParser(this));
	}
	
}
