package io.rtdi.appcontainer.repo;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import io.rtdi.appcontainer.util.RepoRestCalls;

class ActivationServiceTestIT {
	private static RepoRestCalls c;
	private static String script1 = "// A procedure\r\n"
			+ "CREATE or replace PROCEDURE PROD.proc3()\r\n"
			+ "  RETURNS VARCHAR\r\n"
			+ "  // return table contents\r\n"
			+ "  LANGUAGE javascript\r\n"
			+ "  AS\r\n"
			+ "  $$\r\n"
			+ "  var rs = snowflake.execute( { sqlText: \r\n"
			+ "      `INSERT INTO ${alias1}.table1 (\"column 1\") \r\n"
			+ "           SELECT 'value 1' AS \"column 1\" ;`\r\n"
			+ "       } );\r\n"
			+ "  return 'Done.';\r\n"
			+ "  $$;";
	private static String script2 = "// if object not exists PROD.MYTABLE1\r\n"
			+ "     create table PROD.MYTABLE1 (col1 varchar(&defaultvarcharlength));\r\n"
			+ "// if object not exists PROD.MYTABLE2\r\n"
			+ "     create table PROD.MYTABLE2 (id int, col_number number(10,3), col_float float, col_double double,"
			+ "       col_varchar varchar(100), col_varbinary varbinary,"
			+ "       col_datetime datetime, col_date date, col_timestamp timestamp, col_time time,"
			+ "       col_boolean boolean,"
			+ "       col_geo geography,"
			+ "       primary key(id)"
			+ "     );\r\n"
			+ "// endif\r\n"
			+ "// endif\r\n";
	private static String gm = "{\"mappings\":{\"alias1\":\"PROD\"}}";
	private static String vm = "{\"variables\":{\"defaultvarcharlength\":\"100\"}}";
	private static String MYTABLE1_CSV = "COL1\nHello World\n";
	private static String MYTABLE2_CSV = "_CHANGE_TYPE, ID, COL_NUMBER, COL_FLOAT, COL_DOUBLE, "
			+ "COL_VARCHAR, COL_VARBINARY, "
			+ "COL_DATETIME, COL_DATE, COL_TIMESTAMP, COL_TIME, "
			+ "COL_BOOLEAN, "
			+ "COL_GEO\r\n"
			+ "A, 1, 3.1415, 3.1415, 3.1415, "
			+ "\"Hello World\", SGVsbG8gV29ybGQ=,"
			+ "2020-12-31 14:02:01, 2020-12-31, 2020-12-31 14:02:01.123, 14:02:01.123, "
			+ "1,"
			+ "POINT(-122.35 37.55)\r\n";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new RepoRestCalls();
    	if (c.exists("/testactivation")) {
    		c.rmdir("/testactivation");
    	}
    	c.mkdir("/testactivation");
    	c.mkdir("/testactivation/app1");
    	c.mkdir("/testactivation/app2");
    	c.mkdir("/testactivation/app1/db");
    	c.mkdir("/testactivation/app1/db/DATA");
    	c.save("/testactivation/app1/db/script1.sql", script1);
    	c.save("/testactivation/app1/db/script2.sql", script2);
    	c.save("/.globalmapping", gm);
    	c.save("/testactivation/app1/.variables", vm);
    	c.save("/testactivation/app1/db/DATA/PROD.MYTABLE1.csv", MYTABLE1_CSV);
    	c.save("/testactivation/app1/db/DATA/$%7Balias1%7D.MYTABLE2.csv", MYTABLE2_CSV);
    	
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
    	c.rmdir("/testactivation");
		c.close();
	}

	@Test
	void testDir() {
		try {
			JsonNode n1 = c.activate("/testactivation");
			System.out.println(n1);
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

}
