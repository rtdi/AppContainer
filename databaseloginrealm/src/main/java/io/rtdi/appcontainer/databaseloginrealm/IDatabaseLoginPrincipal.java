package io.rtdi.appcontainer.databaseloginrealm;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Every implementer of this interface must create a connection pool and query the required data
 * from the database. 
 *
 */
public interface IDatabaseLoginPrincipal {

	/**
	 * Call the Tomcat's DataSource getConnection() method to retrieve a currently idle connection from the pool.
	 * 
	 * @return a JDBC connection from the pool for temporary use
	 * @throws SQLException
	 */
	Connection getConnection() throws SQLException;

	/**
	 * @return the FQN class name used
	 */
	String getDriver();

	/**
	 * @return the version string of the connected database as retrieved at login
	 */
	String getDBVersion();
	
	/**
	 * @return the JDBC driver version being used
	 */
	String getDriverVersion();

	/**
	 * @return the exact user, e.g. the login might have been user1 but the actual database user name is "USER1"
	 */
	String getDBUser();
	
	/**
	 * @return the user's default schema
	 */
	String getSchema();

	/**
	 * @return a list of all database roles the user is associated with 
	 */
	String[] getRoles();
	
	/**
	 * @return a text to be rendered as information for the end user like password is about to expire, must change password
	 */
	Optional<String> getLoginWarnings();
	
}