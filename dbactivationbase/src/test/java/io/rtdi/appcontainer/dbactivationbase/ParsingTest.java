package io.rtdi.appcontainer.dbactivationbase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

class ParsingTest {

	private static GlobalSchemaMapping gm;
	private static SQLVariables variables;
	private static IDatabaseProvider provider;
	private static DummyConnection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gm = GlobalSchemaMapping.read(Path.of("src/test/resources/schemamapping"), "schema1", "user1");
		variables = SQLVariables.read(Path.of("src/test/resources/variables"));
		provider = new TestProvider();
		conn = new DummyConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testMultilinestatement() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/multilinestatement.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0");
			assertEquals("create table TABLE_EXISTS\r\n"
					+ "  // Comment 1\r\n"
					+ "  (col1 varchar(1) /* no pk */);", trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testSimpledirective() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/simpledirective.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0.0");
			assertEquals("drop table TABLE_EXISTS;", trim(s0.getSqltext()));
			ActivationResult s1 = result.getByPath("1");
			assertEquals("create table TABLE_EXISTS (col1 varchar(1));", trim(s1.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testSimpledirective_with_comments() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/simpledirective_with_comments.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0.0");
			assertEquals("drop table TABLE_EXISTS;", trim(s0.getSqltext()));
			ActivationResult s1 = result.getByPath("1");
			assertEquals("create table TABLE_EXISTS (col1 varchar(1));", trim(s1.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	void testNesteddirective() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/nesteddirective.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0.0.0");
			assertEquals("alter table TABLE_EXISTS add column (NO_SUCH_COLUMN decimal(5,4));", trim(s0.getSqltext()));
			ActivationResult s1 = result.getByPath("1");
			assertEquals("create or replace view V_TABLE_EXISTS\r\n"
					+ "  select * from TABLE_EXISTS;", trim(s1.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	private static String trim(String text) {
		if (text == null) {
			return null;
		} else {
			return text.trim();
		}
	}

	@Test
	void testProcedure1() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/procedure1.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			String expected = "create or replace procedure return_greater(number_1 integer, number_2 integer, out result integer)\r\n"
					+ "language sqlscript\r\n"
					+ "as\r\n"
					+ "begin\r\n"
					+ "  if (:number_1 > :number_2) then\r\n"
					+ "    result = :number_1;\r\n"
					+ "  else\r\n"
					+ "    result = :number_2;\r\n"
					+ "  end if;\r\n"
					+ "end;";
			ActivationResult s0 = result.getByPath("0");
			assertEquals(expected, trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testOneCommand() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/onecommand.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0");
			assertEquals("ALTER SESSION SET X = 1;", trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testAlias() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/alias.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0");
			assertEquals("alter table actualschema1.TABLE_EXISTS add column (NO_SUCH_COLUMN decimal(5,4));", trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	void testVariable() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/variable.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("0");
			assertEquals("alter table TABLE_EXISTS add column (NO_SUCH_COLUMN decimal(5,4));", trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testInsert() {
		try {
			String expected = "create table all_datatypes(number1 bigint, number2 numeric(4,0), number3 bit(2), number4 smallint,\r\n"
					+ "number5 decimal(8,2), number6 smallmoney, number7 int, number8 tinyint, number9 money, float1 float, real1 real,\r\n"
					+ "varchar1 varchar(10), char1 char(5), text1 text, varchar2 nvarchar(10), char2 nchar(5), text2 ntext, binary1 binary, binary2 varbinary(10), image1 image,\r\n"
					+ "date1 date, date2 datetimeoffset, date3 datetime2, date4 smalldatetime, date5 datetime, time1 time(7),\r\n"
					+ "variant1 sql_variant, hierarchyid1 hierarchyid, uniqueidentifier1 uniqueidentifier, xml1 xml, \r\n"
					+ "geometry1 geometry, geography1 geography, rowversion1 rowversion);";
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/insert.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			ActivationResult s0 = result.getByPath("1");
			assertEquals(expected, trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	void testSnowflakeProcedure() {
		try {
			SQLParser parser = new SQLParser();
			ActivationResult result = parser.activate(new File("src/test/resources/activationsamples/procedure2.sql"), conn, gm, variables, provider);
			assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Code not activated");
			String expected = "CREATE or replace PROCEDURE PROD.proc2()\r\n"
					+ "  RETURNS VARCHAR\r\n"
					+ "  // return table contents\r\n"
					+ "  LANGUAGE javascript\r\n"
					+ "  AS\r\n"
					+ "  $$\r\n"
					+ "  var rs = snowflake.execute( { sqlText:\r\n"
					+ "      `INSERT INTO ${alias1}.table1 (\"column 1\") \r\n"
					+ "           SELECT 'value 1' AS \"column 1\" ;`\r\n"
					+ "       } );\r\n"
					+ "  return 'Done.';\r\n"
					+ "  $$;";
			ActivationResult s0 = result.getByPath("0");
			assertEquals(expected, trim(s0.getSqltext()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

}
