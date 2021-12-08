package databaseloginrealmsnowflake;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.rtdi.appcontainer.databaseloginrealmsnowflake.SnowflakePrincipal;

class LoginTestIT {

	private static Properties p;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File homedir = new File(System.getProperty("user.home"), "appcontainer/login.properties");
		p = new Properties();
		p.load(new FileReader(homedir));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testSnowflakePrincipal() {
		try {
			String username = p.getProperty("username");
			SnowflakePrincipal principal = new SnowflakePrincipal(username, p.getProperty("password"), p.getProperty("JDBCURL"));
			assertNotNull(principal.getDriver(), "The driver class must be returned");
			assertNotNull(principal.getDBVersion(), "The DB version must be returned");
			assertEquals(username, principal.getName(), "getName() must be equal to the provided username");
			assertNotNull(principal.getDriverVersion(), "The driver version must be returned");
			assertEquals(username.toUpperCase(), principal.getDBUser(), "getDBUser() must be equal to the provided username in all uppercase");
			String[] roles = principal.getRoles();
			assertNotNull(roles, "Roles must be returned");
			List<String> roleslist = Arrays.asList(roles);
			assertTrue(roleslist.contains("PUBLIC"), "Every Snowflake user must have the PUBLIC roles");
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Test failed with an unexpected exception");
		}
	}

}
