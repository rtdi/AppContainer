package io.rtdi.appcontainer.plugins.databasesnowflake.parser;

import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.activation.parser.DollarParser;
import io.rtdi.appcontainer.plugins.activation.parser.EscapeCharParser;
import io.rtdi.appcontainer.plugins.activation.parser.Parser;
import io.rtdi.appcontainer.plugins.activation.parser.ParserCharSequence;
import io.rtdi.appcontainer.plugins.activation.parser.VariableParser;

/**
 * All strings under single backtick quotes, needed for procedures
 * 
 * 			CREATE or replace PROCEDURE proc3()
 * 			RETURNS VARCHAR
 * 			  LANGUAGE javascript
 * 			  AS
 * 			  $$
 * 			  var rs = snowflake.execute( { sqlText:
 * 			      `INSERT INTO ${alias1}.table1 (\"column 1\")    <--- `
 * 			           SELECT 'value 1' AS \"column 1\" ;`        <--- `
 * 			       } );
 * 			  return 'Done.';
 * 			  $$;
 *
 */
public class BackTickParser extends ParserCharSequence {

	protected BackTickParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<'..'>";
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return c == '`';
	}

	@Override
	public void setParsers() {
		addChildParser('\\', new EscapeCharParser(this));
		addChildParser('$', new DollarParser(this)); // Use the DollarParser, not the Snowflake DollarDollarParser as it does not allow nesting 
		addChildParser('&', new VariableParser(this));
	}

}
