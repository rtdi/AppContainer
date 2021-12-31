package io.rtdi.appcontainer.plugins.databasesnowflake.parser;

import io.rtdi.appcontainer.plugins.activation.parser.CommandParser;
import io.rtdi.appcontainer.plugins.activation.parser.Parser;

public class SnowflakeCommandParser extends CommandParser {

	public SnowflakeCommandParser(Parser parent) {
		super(parent);
	}

	@Override
	public void setParsers() {
		super.setParsers();
		addChildParser('$', new SnowflakeDollarParser(this));
	}

}
