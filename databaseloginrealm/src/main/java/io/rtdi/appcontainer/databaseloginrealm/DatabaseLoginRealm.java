package io.rtdi.appcontainer.databaseloginrealm;

import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.realm.RealmBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * There are two ways to set the jdbcurl
 * 1. In the server.xml as property &lt;Realm className="io.rtdi.appcontainer.snowflakerealm.SnowflakeRealm" 
 *    JDBCURL="jdbc:snowflake://&lt;account_name&gt;.snowflakecomputing.com/?&lt;connection_params&gt;"/&gt;
 * 2. As environment variable called JDBCURL
 *
 */
public abstract class DatabaseLoginRealm extends RealmBase {
    protected final Log log;
    private String jdbcurl;
    private Map<String, Principal> userdirectory = new HashMap<>();

	public DatabaseLoginRealm() {
		log = LogFactory.getLog(this.getClass());
	}

	@Override
	public Principal authenticate(String username, String credentials) {
		if (jdbcurl == null) {
			jdbcurl = System.getenv("JDBCURL");
			if (jdbcurl == null) {
				log.error("No jdbc-url configured, neither as property in the server.xml nor as environment variable JDBCURL");
				return null;
			}
		}
		log.debug("Authenticating user \"" + username + "\" with database \"" + jdbcurl + "\"");
		try {
			Principal principal = userdirectory.get(username);
			if (principal == null ) { 
				principal = createNewPrincipal(username, credentials, jdbcurl); // this does throw a SQLException in case the login data is invalid
				userdirectory.put(username, principal);
			}
			return principal;
		} catch (SQLException e) {
			log.error("failed to login with the provided credentials for \"" + username + "\" with database \"" + jdbcurl + "\" and exception " + e.getMessage());
			return null;
		}
	}
	
	protected abstract Principal createNewPrincipal(String username, String credentials, String jdbcurl) throws SQLException;

	/**
	 * Actually returns null for security reasons
	 */
	@Override
	protected String getPassword(String username) {
		return null; // Do not expose the password. What is the side effect of that with md5 digest???
	}

	/**
	 * Get the SnowflakePrincipal associated with the specified user
	 * @return SnowflakePrincipal
	 */
	@Override
	protected Principal getPrincipal(String username) {
		return userdirectory.get(username);
	}
	
	/**
	 * @return JDBC URL of the used database
	 */
	public String getJDBCURL() {
		return jdbcurl;
	}

	/**
	 * @param jdbcurl the JDBC URL to be used
	 */
	public void setJDBCURL(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}

}
