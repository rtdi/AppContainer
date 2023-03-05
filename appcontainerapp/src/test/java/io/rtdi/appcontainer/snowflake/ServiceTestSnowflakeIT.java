package io.rtdi.appcontainer.snowflake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;

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
import io.rtdi.appcontainer.snowflakerealm.SnowflakePrincipal;
import io.rtdi.appcontainer.snowflakerealm.SnowflakeRealm;
import io.rtdi.appcontainer.util.ODataCalls;
import io.rtdi.appcontainer.util.QueryRestCalls;
import io.rtdi.appcontainer.util.RepoRestCalls;
import io.rtdi.appcontainer.util.RestClient;

class ServiceTestSnowflakeIT {

	private static Path basedir;
	private static Tomcat tomcat;
	private static RestClient client;
	private static String defaultschema;
	private static final int PORT = 8080;
	private static final String APPURL = "/appcontainerapp";

	@BeforeAll
	static void setUp() throws Exception {
		String jdbcurl = System.getenv("snowflake_jdbcurl");
        tomcat = new Tomcat();
        basedir = Files.createTempDirectory("tomcat");
        basedir = basedir.resolve("root"); // add one level so that the repo root directory is contained in the temp directory also
        Path webinfdir = basedir.resolve("appcontainerapp/WEB-INF");
        Files.createDirectories(webinfdir);
        Files.copy(Path.of("src/main/webapp/WEB-INF/web.xml"), webinfdir.resolve("web.xml")); // webapp security is configured via the web.xml, so copy it
        tomcat.setBaseDir(basedir.toString());
        tomcat.setPort(PORT);
        Context context = tomcat.addWebapp(APPURL, basedir.resolve("appcontainerapp").toString());
        DatabaseLoginRealm realm = new SnowflakeRealm();
        realm.setJDBCURL(jdbcurl);
        context.setRealm(realm);
        
		File additionWebInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(context);
		resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		context.setResources(resources);

        tomcat.getConnector();
        tomcat.start();
        Thread.sleep(1000L);
        
		String username = System.getenv("snowflake_jdbcuser");
		String credential = System.getenv("snowflake_jdbccredential");
        SnowflakePrincipal principal = (SnowflakePrincipal) realm.authenticate(username, credential);
        defaultschema = principal.getSchema();
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
			JsonNode data = c.queryTable("INFORMATION_SCHEMA", "VIEWS");
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
			JsonNode data = c.queryTable("INFORMATION_SCHEMA", "VIEWS");
			assertTrue(data instanceof ArrayNode, "the full table query must return an array of rows");
			ArrayNode resultset = (ArrayNode) data;
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 views in the whole database? Can't be.");

			data = c.executeSelectStatement("select * from INFORMATION_SCHEMA.VIEWS");
			assertTrue(data.get("rows") instanceof ArrayNode, "The query call did not return any records in the rows element");
			resultset = (ArrayNode) data.get("rows");
			assertTrue(resultset.size() > 5, "Odd, there are less than 6 views in the whole database? Can't be.");

			data = c.lookupRow("INFORMATION_SCHEMA", "VIEWS", "TABLE_NAME = 'VIEWS'");
			assertNotNull(data.get("TABLE_NAME"));
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
				+ "create table all_datatypes(number1 number(10,2), number2 number(4,0), float1 float,\r\n"
				+ "varchar1 varchar(10), binary1 binary, boolean1 boolean,\r\n"
				+ "date1 date, timestamp_ltz1 timestamp_ltz, timestamp_ntz1 timestamp_ntz, timestamp_tz1 timestamp_tz, time1 time,\r\n"
				+ "variant1 variant, object1 object,\r\n"
				+ "array1 array,\r\n"
				+ "geography1 geography);\r\n"
				+ "insert into all_datatypes select 3.14, 123, 3.14,"
				+ "'ABCDEFG', 'ABCD', true,"
				+ "'2017-01-01'::date, '2017-01-01 13:00:00'::timestamp_ltz, '2017-01-01 13:00:00'::timestamp_ntz, '2017-01-01 13:00:00 -04:00'::timestamp_tz, '13:00:00'::time,"
				+ "to_variant(parse_json('{ \"key1\": \"value1\" }')), object_construct('key1', 'value1'::variant),"
				+ "array_construct(1, 2, 3),"
				+ "'POINT(-122.35 37.55)';";
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
				+ "create or replace procedure return_greater(number_1 integer, number_2 integer)\r\n"
				+ "returns integer not null\r\n"
				+ "language sql\r\n"
				+ "as\r\n"
				+ "$$\r\n"
				+ "begin\r\n"
				+ "  if (number_1 > number_2) then\r\n"
				+ "    return number_1;\r\n"
				+ "  else\r\n"
				+ "    return number_2;\r\n"
				+ "  end if;\r\n"
				+ "end;\r\n"
				+ "$$\r\n"
				+ ";";
		String script2 = "create or replace procedure get_as_table(keyid varchar, value varchar)\r\n"
				+ "returns table (keyid varchar, value varchar)\r\n"
				+ "language sql\r\n"
				+ "as\r\n"
				+ "$$\r\n"
				+ "declare\r\n"
				+ "  res resultset default (select :keyid, :value);\r\n"
				+ "begin\r\n"
				+ "  return table(res);\r\n"
				+ "end;\r\n"
				+ "$$\r\n"
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
	public void testCSVandVariables() {
		String script1 = "// A procedure\r\n"
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
		String script2 = "// if object not exists CURRENTSCHEMA.MYTABLE1\r\n"
				+ "     create table MYTABLE1 (col1 varchar(&defaultvarcharlength));\r\n"
				+ "// if object not exists CURRENTSCHEMA.MYTABLE2\r\n"
				+ "     create table MYTABLE2 (id int, col_number number(10,3), col_float float, col_double double,"
				+ "       col_varchar varchar(100), col_varbinary varbinary,"
				+ "       col_datetime datetime, col_date date, col_timestamp timestamp, col_time time,"
				+ "       col_boolean boolean,"
				+ "       col_geo geography,"
				+ "       primary key(id)"
				+ "     );\r\n"
				+ "// end if\r\n"
				+ "// end if\r\n";
		String gm = "{\"mappings\":{\"alias1\":\"" + defaultschema + "\"}}";
		String vm = "{\"variables\":{\"defaultvarcharlength\":\"100\"}}";
		String MYTABLE1_CSV = "COL1\nHello World\n";
		String MYTABLE2_CSV = "_CHANGE_TYPE, ID, COL_NUMBER, COL_FLOAT, COL_DOUBLE, "
				+ "COL_VARCHAR, COL_VARBINARY, "
				+ "COL_DATETIME, COL_DATE, COL_TIMESTAMP, COL_TIME, "
				+ "COL_BOOLEAN, "
				+ "COL_GEO\r\n"
				+ "A, 1, 3.1415, 3.1415, 3.1415, "
				+ "\"Hello World\", SGVsbG8gV29ybGQ=,"
				+ "2020-12-31 14:02:01, 2020-12-31, 2020-12-31 14:02:01.123, 14:02:01.123, "
				+ "1,"
				+ "POINT(-122.35 37.55)\r\n";
		try {
			RepoRestCalls c = new RepoRestCalls(client);
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
	    	c.save("/testactivation/app1/db/DATA/CURRENTSCHEMA.MYTABLE1.csv", MYTABLE1_CSV);
	    	c.save("/testactivation/app1/db/DATA/$%7Balias1%7D.MYTABLE2.csv", MYTABLE2_CSV);
			JsonNode n = c.activate("/testactivation");
			String json = n.toString();
	    	ActivationResult result = ActivationResult.fromJson(json);
	    	assertEquals(ActivationSuccess.SUCCESS, result.getSuccess(), "Activation failed");
	    	n = c.rmFile("/.globalmapping");
	    	assertTrue(RestClient.isSuccess(n));
	    	
	    	n = c.rmdir("/testactivation");
	    	assertTrue(RestClient.isSuccess(n));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown");
		}
	}
	
	@Test
	public void testFileOperations() {
		try {
			RepoRestCalls c = new RepoRestCalls(client);
			
			/*
			 * Dir
			 */
	    	if (c.exists("/testreposervice")) {
	    		c.rmdir("/testreposervice");
	    	}
	    	c.mkdir("/testreposervice");
	    	c.mkdir("/testreposervice/dir1");
	    	c.mkdir("/testreposervice/dir1/dirA");
	    	c.mkdir("/testreposervice/dir2");
	    	c.mkdir("/testreposervice/move1");
	    	c.mkdir("/testreposervice/move1/move1a");
	    	c.mkdir("/testreposervice/move2");
	    	c.mkdir("/testreposervice/fileio");
	    	c.touch("/testreposervice/rootfile.txt");
	    	c.touch("/testreposervice/dir1/dirA/file1.txt");
	    	c.touch("/testreposervice/dir1/dirA/file2.txt");
	    	c.touch("/testreposervice/dir1/file.txt");
	    	c.touch("/testreposervice/dir2/file.txt");
	    	
	    	
			JsonNode n = c.dir(""); // {"folders":[{"folders":[{"folders":[{"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}],"name":"dir1","path":"testreposervice/dir1","filecount":1},{"folders":null,"name":"dir2","path":"testreposervice/dir2","filecount":1},{"folders":null,"name":"move2","path":"testreposervice/move2","filecount":1},{"folders":[{"folders":null,"name":"move1a","path":"testreposervice/move4/move1a","filecount":0}],"name":"move4","path":"testreposervice/move4","filecount":1}],"name":"testreposervice","path":"testreposervice","filecount":1}],"name":null,"path":null,"filecount":0}
			Map<String, JsonNode> s = RestClient.getJsonKV(n);
			assertTrue(s.containsKey("folders->path:testreposervice"), "Missing directory testreposervice");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir1"), "Missing directory testreposervice/dir1");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir2"), "Missing directory testreposervice/dir2");
			assertTrue(s.containsKey("folders->folders->folders->path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			assertTrue(s.containsKey("folders->folders->folders->filecount:2"), "directory testreposervice/dir1/dirA does not contain two files");
			n = c.dir("/testreposervice"); // {"folders":[{"folders":[{"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}],"name":"dir1","path":"testreposervice/dir1","filecount":1},{"folders":null,"name":"dir2","path":"testreposervice/dir2","filecount":1},{"folders":null,"name":"move2","path":"testreposervice/move2","filecount":1},{"folders":[{"folders":null,"name":"move1a","path":"testreposervice/move4/move1a","filecount":0}],"name":"move4","path":"testreposervice/move4","filecount":1}],"name":"testreposervice","path":"testreposervice","filecount":1}
			s = RestClient.getJsonKV(n);
			assertTrue(s.containsKey("path:testreposervice"), "Missing directory testreposervice");
			assertTrue(s.containsKey("folders->path:testreposervice/dir1"), "Missing directory testreposervice/dir1");
			assertTrue(s.containsKey("folders->path:testreposervice/dir2"), "Missing directory testreposervice/dir2");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			n = c.dir("/testreposervice/dir1/dirA"); // {"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}
			s = RestClient.getJsonKV(n);
			assertTrue(s.containsKey("path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			assertThrows(IOException.class, () -> c.dir("/doesnotexist"), "A dir call on a non-existing directory should return with a !=200 status code");
			
			
			/*
			 * List
			 */
			n = c.listFiles("/testreposervice"); // {"path":"testreposervice","files":[{"name":"rootfile.txt","extension":"txt","path":"testreposervice/rootfile.txt"}]}
			s = RestClient.getJsonKV(n);
			assertTrue(s.containsKey("files->path:testreposervice/rootfile.txt"), "The testreposervice directory must have one file");
			n = c.listFiles("/testreposervice/dir1/dirA"); // {"path":"testreposervice/dir1/dirA","files":[{"name":"file1.txt","extension":"txt","path":"testreposervice/dir1/dirA/file1.txt"},{"name":"file2.txt","extension":"txt","path":"testreposervice/dir1/dirA/file2.txt"}]}
			s = RestClient.getJsonKV(n);
			assertTrue(s.containsKey("files->path:testreposervice/dir1/dirA/file1.txt"), "The testreposervice/dir1/dirA/file1.txt must exist");
			assertTrue(s.containsKey("files->path:testreposervice/dir1/dirA/file2.txt"), "The testreposervice/dir1/dirA/file2.txt must exist");
			assertThrows(IOException.class, () -> c.listFiles("/doesnotexist"), "A list files call on a non-existing directory should return with a !=200 status code");

			/*
			 * Move
			 */
			c.touch("/testreposervice/move1/filetomove.txt");
			n = c.mv("/testreposervice/move1/filetomove.txt", "/testreposervice/move1/move1a/filetomove.txt"); // {"message":"OK"}
			assertTrue(RestClient.isSuccess(n), "failed to mv testreposervice/move1/filetomove.txt testreposervice/move1/move1a/filetomove.txt");
			n = c.mv("/testreposervice/move1/move1a/filetomove.txt", "/testreposervice/move2/filetomove.txt"); // {"message":"OK"}
			assertTrue(RestClient.isSuccess(n), "failed to mv testreposervice/move1/move1a/filetomove.txt testreposervice/move2/filetomove.txt");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move1/move1a/filetomove.txt", "/testreposervice/move2/filetomove.txt"),
					"A mv call on a non-existing file should return with a !=200 status code");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move2/filetomove.txt", "/testreposervice/move3/filetomove.txt"),
					"A mv call into a non-existing dir should return with a !=200 status code");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move2/filetomove.txt", "/testreposervice/dir1/file.txt"),
					"A mv call over an existing file should return with a !=200 status code");
			n = c.mv("/testreposervice/move1", "/testreposervice/move3"); // {"message":"OK"}
			assertTrue(RestClient.isSuccess(n), "failed to mv testreposervice/move1 testreposervice/move3");
			c.touch("/testreposervice/move3/filetomove.txt");
			n = c.mv("/testreposervice/move3", "/testreposervice/move4"); // {"message":"OK"}
			assertTrue(RestClient.isSuccess(n), "failed to mv testreposervice/move3 testreposervice/move4");
			assertTrue(c.exists("/testreposervice/move4/filetomove.txt"));

			/*
			 * Save read
			 */
			String data1 = "Hello world";
			String data2 = "Hello\nNew world\r\n";
			assertTrue(RestClient.isSuccess(c.save("/testreposervice/fileio/hello.txt", data1)), "Failed to save the file");
			n = c.read("/testreposervice/fileio/hello.txt");
			assertEquals(data1, n.get("content").textValue(), "Read content not equal to content when file was created");
			assertTrue(RestClient.isSuccess(c.save("/testreposervice/fileio/hello.txt", data2)), "Failed to save new contents to the file");
			n = c.read("/testreposervice/fileio/hello.txt");
			assertEquals(data2, n.get("content").textValue(), "Read content not equal latest content");

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
