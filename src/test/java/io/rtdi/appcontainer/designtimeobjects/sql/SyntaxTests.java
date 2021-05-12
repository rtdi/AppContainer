package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public class SyntaxTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ActivationException, AppContainerSQLException {
		ActivationResult result = new ActivationResult();
		SQLScriptCollector callback = new SQLScriptCollector();
		String text1 = "CREATE TABLE stproc_test_table1 (num_col1 numeric(14,7));";
		SQLScript.execute(text1, result, callback);
		
		String text2 = "create or replace procedure stproc1(FLOAT_PARAM1 FLOAT)\r\n"
				+ "    returns string\r\n"
				+ "    language javascript\r\n"
				+ "    strict\r\n"
				+ "    execute as owner\r\n"
				+ "    as\r\n"
				+ "    $$\r\n"
				+ "    var sql_command = \r\n"
				+ "     \"INSERT INTO stproc_test_table1 (num_col1) VALUES (\" + FLOAT_PARAM1 + \")\";\r\n"
				+ "    try {\r\n"
				+ "        snowflake.execute (\r\n"
				+ "            {sqlText: sql_command}\r\n"
				+ "            );\r\n"
				+ "        return \"Succeeded.\";   // Return a success/error indicator.\r\n"
				+ "        }\r\n"
				+ "    catch (err)  {\r\n"
				+ "        return \"Failed: \" + err;   // Return a success/error indicator.\r\n"
				+ "        }\r\n"
				+ "    $$\r\n"
				+ "    ;";
		SQLScript.execute(text2, result, callback);
		String text3 = "select &__rowcount;";
		SQLScript.execute(text3, result, callback);
		String text4 = "create or replace procedure \"${owner1}\".recursive_stproc(counter FLOAT)\r\n"
				+ "    returns varchar not null\r\n"
				+ "    language javascript\r\n"
				+ "    as\r\n"
				+ "    -- \"$$\" is the delimiter that shows the beginning and end of the stored proc.\r\n"
				+ "    $$\r\n"
				+ "    var counter1 = COUNTER;\r\n"
				+ "    var returned_value = \"\";\r\n"
				+ "    var accumulator = \"\";\r\n"
				+ "    var stmt = snowflake.createStatement(\r\n"
				+ "        {\r\n"
				+ "        sqlText: \"INSERT INTO stproc_test_table2 (col1) VALUES (?);\",\r\n"
				+ "        binds:[counter1]\r\n"
				+ "        }\r\n"
				+ "        );\r\n"
				+ "    var res = stmt.execute();\r\n"
				+ "    if (COUNTER > 0)\r\n"
				+ "        {\r\n"
				+ "        stmt = snowflake.createStatement(\r\n"
				+ "            {\r\n"
				+ "            sqlText: \"call ${owner1}.recursive_stproc (?);\",\r\n"
				+ "            binds:[counter1 - 1]\r\n"
				+ "            }\r\n"
				+ "            );\r\n"
				+ "        res = stmt.execute();\r\n"
				+ "        res.next();\r\n"
				+ "        returned_value = res.getColumnValue(1);\r\n"
				+ "        }\r\n"
				+ "    accumulator = accumulator + counter1 + \":\" + returned_value;\r\n"
				+ "    return accumulator;\r\n"
				+ "    $$\r\n"
				+ "    ;";
		SQLScript.execute(text4, result, callback);
	}

}
