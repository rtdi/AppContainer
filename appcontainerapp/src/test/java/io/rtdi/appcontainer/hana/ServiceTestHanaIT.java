package io.rtdi.appcontainer.hana;

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
import io.rtdi.appcontainer.hanarealm.HanaRealm;
import io.rtdi.appcontainer.util.ODataCalls;
import io.rtdi.appcontainer.util.QueryRestCalls;
import io.rtdi.appcontainer.util.RepoRestCalls;
import io.rtdi.appcontainer.util.RestClient;

class ServiceTestHanaIT {

	private static Path basedir;
	private static Tomcat tomcat;
	private static RestClient client;
	private static final int PORT = 8080;
	private static final String APPURL = "/appcontainerapp";

	@BeforeAll
	static void setUp() throws Exception {
		String jdbcurl = System.getenv("hana_jdbcurl");
        tomcat = new Tomcat();
        basedir = Files.createTempDirectory("tomcat");
        basedir = basedir.resolve("root"); // add one level so that the repo root directory is contained in the temp directory also
        Path webinfdir = basedir.resolve("appcontainerapp/WEB-INF");
        Files.createDirectories(webinfdir);
        Files.copy(Path.of("src/main/webapp/WEB-INF/web.xml"), webinfdir.resolve("web.xml")); // webapp security is configured via the web.xml, so copy it
        tomcat.setBaseDir(basedir.toString());
        tomcat.setPort(PORT);
        Context context = tomcat.addWebapp(APPURL, basedir.resolve("appcontainerapp").toString());
        DatabaseLoginRealm realm = new HanaRealm();
        realm.setJDBCURL(jdbcurl);
        context.setRealm(realm);
        
		File additionWebInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(context);
		resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		context.setResources(resources);

        tomcat.getConnector();
        tomcat.start();
        Thread.sleep(1000L);
        
		String username = System.getenv("hana_jdbcuser");
		String credential = System.getenv("hana_jdbccredential");
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
			JsonNode data = c.queryTable("SYS", "VIEWS");
			assertTrue(data.get("value") instanceof ArrayNode, "OData call did not return any records in the value element");
			ArrayNode resultset = (ArrayNode) data.get("value");
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 views in the whole database? Can't be.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testRestEndpoint() {
		try {
			QueryRestCalls c = new QueryRestCalls(client);
			JsonNode data = c.queryTable("SYS", "VIEWS");
			assertTrue(data instanceof ArrayNode, "the full table query must return an array of rows");
			ArrayNode resultset = (ArrayNode) data;
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 views in the whole database? Can't be.");

			data = c.executeSelectStatement("select * from SYS.VIEWS");
			assertTrue(data.get("rows") instanceof ArrayNode, "The query call did not return any records in the rows element");
			resultset = (ArrayNode) data.get("rows");
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 views in the whole database? Can't be.");

			data = c.lookupRow("SYS", "VIEWS", "VIEW_NAME = 'VIEWS'");
			assertNotNull(data.get("VIEW_NAME"));
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
				+ "// endif\r\n"
				+ "create column table all_datatypes(tinyint1 tinyint, smallint1 smallint, integer1 integer, bigint1 bigint, decimal1 decimal, decimal2 decimal(10, 4), smalldecimal1 smalldecimal, real1 real, double1 double, float1 float(10), float2 float(40),\r\n"
				+ "varchar1 varchar(10), nvarchar1 nvarchar(10), alphanum1 alphanum(10), shorttext1 shorttext(10), varbinary1 varbinary(10), boolean1 boolean,\r\n"
				+ "date1 date, timestamp1 timestamp, time1 time, seconddate1 seconddate,\r\n"
				+ "blob1 blob, clob1 clob, nclob1 nclob, text1 text, bintext1 bintext,\r\n"
				+ "array1 int array,\r\n"
				+ "geography1 ST_Geometry);\r\n"
				+ "insert into all_datatypes values ( 1, 2, 3, 4, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14, "
				+ "'ABCDEFG', 'ABCD', '0000000001', 'XYZ', 'ABC', true,"
				+ "to_date('2017-01-01', 'YYYY-MM-DD'), to_timestamp('2017-01-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), '13:00:00', to_seconddate('2017-01-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'),"
				+ "'ABC', 'ABC', 'ABC', 'ABC', 'ABC',"
				+ "array(1, 2, 3),"
				+ "new ST_POINT('Point(2.5 3.0)') );";
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

	
	@Test
	public void testStoredProcedure() {
		String script1 = "// A procedure\r\n"
				+ "create or replace procedure return_greater(number_1 integer, number_2 integer, out result integer)\r\n"
				+ "language sqlscript\r\n"
				+ "as\r\n"
				+ "begin\r\n"
				+ "  if (:number_1 > :number_2) then\r\n"
				+ "    result = :number_1;\r\n"
				+ "  else\r\n"
				+ "    result = :number_2;\r\n"
				+ "  end if;\r\n"
				+ "end;";
		String script2 = "create or replace procedure get_as_table(keyid varchar(10), value varchar(10), out out1 table(keyid varchar(10), value varchar(10)))\r\n"
				+ "language sqlscript\r\n"
				+ "as\r\n"
				+ "begin\r\n"
				+ "  out1 = select :keyid as keyid, :value as value from dummy;\r\n"
				+ "end;";
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
	    	// result = {"RESULT":{"RETURN_GREATER":99}}
	    	assertNotNull(result.get("RESULT"), "Json result field success not found or no TextNode");
	    	assertEquals(99, result.get("RESULT").asInt(), "stored procedure call RETURN_GREATER() did not return the desired result");

			inputjson = "{ \"KEYID\": \"mykey\", \"VALUE\": \"myvalue\" }";
	    	result = q.callProcedure("currentschema", "GET_AS_TABLE", inputjson);
	    	// result = {"OUT1":[{"KEYID":"mykey","VALUE":"myvalue"}]}
	    	assertEquals(1, result.get("OUT1").size(), "stored procedure call GET_AS_TABLE() did not return an array with one row");

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
}
