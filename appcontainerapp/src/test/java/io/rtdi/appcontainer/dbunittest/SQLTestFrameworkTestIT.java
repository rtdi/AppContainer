package io.rtdi.appcontainer.dbunittest;

import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.rtdi.appcontainer.repo.CreateCSV;

class SQLTestFrameworkTestIT {

	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
	    conn = DriverManager.getConnection("jdbc:snowflake://tn83433.eu-central-1.snowflakecomputing.com/?db=S4HANA", "wdaehn", "W4JCv3tz4crxNZn");
	    try (PreparedStatement stmt = conn.prepareStatement("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");) {
	    	stmt.execute();
	    }
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	@Test
	void test1() {
		String code = "\r\n"
				+ "let all_tables = db.query('select * from INFORMATION_SCHEMA.TABLES');\r\n"
				+ "var all_tables_subset;\r\n"
				+ "\r\n"
				+ "all_tables_subset = db.query('select TABLE_NAME from INFORMATION_SCHEMA.TABLES');\r\n"
				+ "console.log(all_tables.toString());\r\n"
				+ "console.log(all_tables_subset.toString());\r\n"
				+ "\r\n"
				+ "console.log(all_tables.equals(all_tables_subset));\r\n"
				+ "\r\n";
				// + "console.log(all_tables == db.readCSV('TABLES.csv'));\\r\\n";
		try {
			Path rootpath = Path.of("c:\\temp");
			Path codepath = Files.writeString(rootpath.resolve("code.test.js"), code);
			CreateCSV.createCSV(conn, "select * from INFORMATION_SCHEMA.TABLES", rootpath.resolve("TABLES.csv"));
			JavaScriptExecutor js = new JavaScriptExecutor(rootpath);
			System.out.println(js.activate(codepath.toFile(), conn, null, null, null));
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

}
