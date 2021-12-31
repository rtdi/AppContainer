package io.rtdi.appcontainer.plugins.databasesnowflake;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.databasesnowflake.parser.SnowflakeCommandParser;

public class SnowflakeSQLParser extends SQLParser {

	@Override
	public void setParsers() {
		super.setParsers();
		setDefaultParser(new SnowflakeCommandParser(this));
	}

}
