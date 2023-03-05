package io.rtdi.appcontainer.sqlserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;

import io.rtdi.appcontainer.databaseloginrealm.DatabaseLoginRealm;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.sqlserverrealm.SQLServerRealm;
import io.rtdi.appcontainer.util.ODataCalls;
import io.rtdi.appcontainer.util.QueryRestCalls;
import io.rtdi.appcontainer.util.RepoRestCalls;
import io.rtdi.appcontainer.util.RestClient;

class ServiceTestSqlServerIT {

	private static Path basedir;
	private static Tomcat tomcat;
	private static RestClient client;
	private static final int PORT = 8080;
	private static final String APPURL = "/appcontainerapp";

	@BeforeAll
	static void setUp() throws Exception {
		String jdbcurl = System.getenv("sqlserver_jdbcurl");
        tomcat = new Tomcat();
        basedir = Files.createTempDirectory("tomcat");
        basedir = basedir.resolve("root"); // add one level so that the repo root directory is contained in the temp directory also
        Path webinfdir = basedir.resolve("appcontainerapp/WEB-INF");
        Files.createDirectories(webinfdir);
        Files.copy(Path.of("src/main/webapp/WEB-INF/web.xml"), webinfdir.resolve("web.xml")); // webapp security is configured via the web.xml, so copy it
        tomcat.setBaseDir(basedir.toString());
        tomcat.setPort(PORT);
        Context context = tomcat.addWebapp(APPURL, basedir.resolve("appcontainerapp").toString());
        DatabaseLoginRealm realm = new SQLServerRealm();
        realm.setJDBCURL(jdbcurl);
        context.setRealm(realm);
        
		File additionWebInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(context);
		resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		context.setResources(resources);

        tomcat.getConnector();
        tomcat.start();
        Thread.sleep(1000L);
        
		String username = System.getenv("sqlserver_jdbcuser");
		String credential = System.getenv("sqlserver_jdbccredential");
		client = new RestClient(username, credential, "http://localhost:" + String.valueOf(PORT) + APPURL);
	}

	@AfterAll
	static void tearDown() throws Exception {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Test ended, shutting down the webserver");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		if (client != null) {
			client.close();
		}
		if (tomcat != null) {
			tomcat.stop();
		}
		if (basedir != null) {
			Files.walk(basedir)
		      .sorted(Comparator.reverseOrder())
		      .map(Path::toFile)
		      .forEach(File::delete);
		}
	}

	@Test
	public void testODataEndpoint() {
		try {
			ODataCalls c = new ODataCalls(client);
			JsonNode data = c.queryTable("INFORMATION_SCHEMA", "TABLES");
			assertTrue(data.get("value") instanceof ArrayNode, "OData call did not return any records in the value element");
			ArrayNode resultset = (ArrayNode) data.get("value");
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 tables in the whole database? Can't be.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testRestEndpoint() {
		try {
			QueryRestCalls c = new QueryRestCalls(client);
			JsonNode data = c.queryTable("INFORMATION_SCHEMA", "TABLES");
			assertTrue(data instanceof ArrayNode, "the full table query must return an array of rows");
			ArrayNode resultset = (ArrayNode) data;
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 tables in the whole database? Can't be.");

			data = c.executeSelectStatement("select * from INFORMATION_SCHEMA.TABLES");
			assertTrue(data.get("rows") instanceof ArrayNode, "The query call did not return any records in the rows element");
			resultset = (ArrayNode) data.get("rows");
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 tables in the whole database? Can't be.");

			data = c.lookupRow("dbo", "BuildVersion", "SystemInformationID = 1");
			assertNotNull(data.get("VersionDate"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testDataTypes() {
		String script1 = "// A table\r\n"
				+ "// if object exists CURRENTSCHEMA.ALL_DATATYPES\r\n"
				+ "drop table all_datatypes;\r\n"
				+ "// end if\r\n"
				+ "create table all_datatypes(number1 bigint, number2 numeric(4,0), number3 bit(2), number4 smallint, \r\n"
				+ "number5 decimal(8,2), number6 smallmoney, number7 int, number8 tinyint, number9 money, float1 float, real1 real\r\n"
				+ "varchar1 varchar(10), char1 char(5), text1 text, varchar2 nvarchar(10), char2 nchar(5), text2 ntext, binary1 binary, binary2 varbinary(10), image1 image, \r\n"
				+ "date1 date, date2 datetimeoffset, date3 datetime2, date4 smalldatetime, date5 datetime, time1 time(7),\r\n"
				+ "variant1 sql_variant, hierarchyid1 hierarchyid, uniqueidentifier1 uniqueidentifier, xml1 xml, \r\n"
				+ "geometry1 geometry, geography1 geography, rowversion1 rowversion);\r\n"
				+ "insert into all_datatypes values ( 1234, 34.32, 01, 23, 3.14, 123, 1234, 12, 3.14, 3.14, 3.14,"
				+ "'ABCDEFG', 'ABCD', 'sedfe', 'ABCDEFG', 'ABCD', 'sedfe', 'AC01', 'AC02', 'AC03', "
				+ "'2017-01-01', '2017-01-01 13:00:00 -04:00', '2017-01-01 13:00:00', '2017-01-01 13:00:00', '2017-01-01 13:00:00', '13:00:00',"
				+ "1234, '/1/', '6F9619FF-8B86-D011-B42D-00C04FC964FF', '<x>abc</x>'"
				+ "geometry::STGeomFromText('LINESTRING (100 100, 20 180, 180 180)', 0), geography::STGeomFromText('LINESTRING(-122.360 47.656, -122.343 47.656 )', 4326) );";
		try {
			RepoRestCalls c = new RepoRestCalls(client);
	    	JsonNode result = c.mkdir("/datatypes");
	    	assertTrue(RestClient.isSuccess(result), "Creating dir /datatypes failed");
	    	result = c.save("/datatypes/script1.sql", script1);
	    	assertTrue(RestClient.isSuccess(result), "Saving script1.sql failed");
	    	result = c.activate("/datatypes");
	    	assertTrue(result.get("success") instanceof TextNode, "Json result field success not found or no TextNode");
	    	assertEquals("SUCCESS", result.get("success").asText(), "activation was not successful");
	    	
			ODataCalls q = new ODataCalls(client);
			JsonNode data = q.queryTable("currentschema", "ALL_DATATYPES");
			assertTrue(data.get("value") instanceof ArrayNode, "OData call did not return any records in the value element");
			ArrayNode resultset = (ArrayNode) data.get("value");
			assertTrue(resultset.size() == 1, "One record returned");

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	/*
	 * CREATE PROCEDURE ins_NewEmp_with_outputparamaters
(@Ename varchar(50),
@EId int output)
AS
BEGIN
SET NOCOUNT ON
 
INSERT INTO Employee (EmpName) VALUES (@Ename)
 
SELECT @EId= SCOPE_IDENTITY()
 
END
	 */
	
	@Test
	public void testStoredProcedure() {
		String script1 =
				"// A procedure\r\n"
				+ "// if object exists CURRENTSCHEMA.RETURN_GREATER"
				+ "  drop procedure return_greater;\r\n"
				+ "// end if\r\n"
				+ "create procedure return_greater(@number_1 int, @number_2 int, @result int output)\r\n"
				+ "as\r\n"
				+ "begin\r\n"
				+ "  if (@number_1 > @number_2)\r\n"
				+ "    select @result = @number_1;\r\n"
				+ "  else\r\n"
				+ "    select @result = @number_2;\r\n"
				+ "end;\r\n"
				+ ";";
		String script2 = 
				"// if object exists CURRENTSCHEMA.RETURN_GREATER"
				+ "  drop procedure get_as_table;\r\n"
				+ "// end if\r\n"
				+ "createprocedure get_as_table(@keyid varchar, @value varchar)\r\n"
				+ "as\r\n"
				+ "begin\r\n"
				+ "  select @keyid, @value;\r\n"
				+ "end;\r\n"
				+ ";";
		try {
			RepoRestCalls c = new RepoRestCalls(client);
	    	JsonNode result = c.mkdir("/procs");
	    	assertTrue(RestClient.isSuccess(result), "Creating dir /procs failed");
	    	result = c.save("/procs/script1.sql", script1);
	    	assertTrue(RestClient.isSuccess(result), "Saving script1.sql failed");
	    	result = c.save("/procs/script2.sql", script2);
	    	assertTrue(RestClient.isSuccess(result), "Saving script2.sql failed");
	    	result = c.activate("/procs");
	    	assertTrue(result.get("success") instanceof TextNode, "Json result field success not found or no TextNode");
	    	assertEquals("SUCCESS", result.get("success").asText(), "activation was not successful");
			QueryRestCalls q = new QueryRestCalls(client);
			String inputjson = "{ \"NUMBER_1\": 12, \"NUMBER_2\": 99 }";
	    	result = q.callProcedure("currentschema", "RETURN_GREATER", inputjson);
	    	// result = {"OUT1":[{"RETURN_GREATER":99}]}
	    	assertTrue(result.get("OUT1") instanceof ArrayNode, "Json result field success not found or no TextNode");
	    	assertEquals(99, result.get("OUT1").get(0).get("RETURN_GREATER").asInt(), "stored procedure call RETURN_GREATER() did not return the desired result");

			inputjson = "{ \"KEYID\": \"mykey\", \"VALUE\": \"myvalue\" }";
	    	result = q.callProcedure("currentschema", "GET_AS_TABLE", inputjson);
	    	// result = {"OUT1":[{"KEYID":"mykey","VALUE":"myvalue"}]}
	    	assertEquals(1, result.get("OUT1").size(), "stored procedure call GET_AS_TABLE() did not return an array with one row");

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	void testUnitTest() {
		String code = "\r\n"
				+ "let all_tables = db.query('select * from INFORMATION_SCHEMA.TABLES');\r\n"
				+ "var all_tables_subset;\r\n"
				+ "\r\n"
				+ "all_tables_subset = db.query('select TABLE_NAME from INFORMATION_SCHEMA.TABLES');\r\n"
				+ "console.log(all_tables.toString());\r\n"
				+ "console.log(all_tables_subset.toString());\r\n"
				+ "\r\n"
				+ "console.log(all_tables.equals(all_tables_subset));\r\n";
		try {
			RepoRestCalls c = new RepoRestCalls(client);
	    	if (c.exists("/unittest")) {
	    		c.rmdir("/unittest");
	    	}
	    	c.mkdir("/unittest");
			assertTrue(RestClient.isSuccess(c.save("/unittest/code.test.js", code)), "Failed to save the file");
			JsonNode n = c.activate("/unittest");
	    	ActivationResult result = ActivationResult.fromJson(n.toString());
	    	assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Test failed");
	    	assertTrue(result.getByPath("0.0").getInfo().contains("true"), "Test comparison did not return true");
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

}
