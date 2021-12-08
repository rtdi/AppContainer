package io.rtdi.appcontainer.databaseloginrealm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.realm.GenericPrincipal;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public abstract class DatabaseLoginPrincipal extends GenericPrincipal implements IDatabaseLoginPrincipal {

	private static final long serialVersionUID = 486703493493L;
	private String version;
	private String user;
	private Optional<String> loginwarnings;
	private DataSource pool;
	private String schema;
	private String driverversion;
	private String jdbcdriver; 

	/**
	 * @param name database user name
	 * @param password database password
	 * @param jdbcurl database JDBC connection URL
	 * @param jdbcdriver class name of the JDBC driver to use
	 * @param roleSQL a select with a single string column containing all database roles assigned to that user
	 * @throws SQLException in case the login sequence cannot be performed completely
	 */
	public DatabaseLoginPrincipal(String name, String password, String jdbcurl, String jdbcdriver, String roleSql) throws SQLException {
		super(name, queryRoles(name, password, jdbcurl, jdbcdriver, roleSql)); // unfortunately there is no better way than that because of the Tomcat Principal constructor
		pool = getDataSource(name, password, jdbcurl, jdbcdriver);
		this.jdbcdriver = jdbcdriver;
	}

	/**
	 * @param name database user name
	 * @param password database password
	 * @param jdbcurl database JDBC connection URL
	 * @param jdbcdriver class name of the JDBC driver to use
	 * @param roleSQL a select with a single string column containing all database roles assigned to that user
	 * @return the list of database role names the user has assigned, direct or indirect
	 * @throws SQLException in case the roles cannot be read
	 */
	private static List<String> queryRoles(String name, String password, String jdbcurl, String jdbcdriver, String roleSql) throws SQLException {
		try (Connection c = getDatabaseConnection(name, password, jdbcurl, jdbcdriver)) {
			try (PreparedStatement stmt = c.prepareStatement(roleSql); ) {
				List<String> roles = new ArrayList<String>();
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					roles.add(rs.getString(1));
				}
				return roles;
			} catch (SQLException e) {
				throw new LoginSQLException(e, roleSql);
			}
		}
	}
	
	private static Connection getDatabaseConnection(String user, String passwd, String jdbcurl, String jdbcdriver) throws SQLException {
        try {
            Class.forName(jdbcdriver);
            return DriverManager.getConnection(jdbcurl, user, passwd);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No JDBC driver library found with name '" + jdbcdriver + "'");
        }
	}

	@Override
	public String getDriver() {
		return jdbcdriver;
	}

	@Override
	public String getDBVersion() {
		return version;
	}

	@Override
	public String getDBUser() {
		return user;
	}

	@Override
	public Optional<String> getLoginWarnings() {
		return loginwarnings;
	}

	private DataSource getDataSource(String name, String password, String jdbcurl, String jdbcdriver) throws SQLException {
		DataSource datasource = null;
        PoolProperties p = new PoolProperties();
        p.setUrl(jdbcurl);
        p.setDriverClassName(jdbcdriver);
        p.setUsername(name);
        p.setPassword(password);
        p.setJmxEnabled(false);
        p.setTestWhileIdle(false);
        // p.setTestOnBorrow(true);
        // p.setValidationQuery("SELECT 1");
        // p.setTestOnReturn(false);
        // p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(3);
        p.setInitialSize(1);
        p.setMaxIdle(p.getMaxActive());
        p.setMinIdle(p.getMaxActive());
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        // p.setMinEvictableIdleTimeMillis(60000);
        // p.setMinIdle(10);
        // p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setDefaultAutoCommit(false);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        setAdditionalJDBCPoolProperties(p);
        datasource = new DataSource();
        datasource.setPoolProperties(p);
		try (Connection c = datasource.getConnection()) {
			this.schema = c.getSchema();
			driverversion = c.getMetaData().getDriverVersion();
			this.version = readDatabaseVersion(c);
			this.user = readExactUserName(c);
			this.loginwarnings = validateLogin(c);
		}		
        return datasource;
	}

	/**
	 * A hook to set additional values in p, which is then passed to datasource.setPoolProperties(p);
	 * Only a last reserve, should be the empty implementation most of the time.
	 * 
	 * @param p Tomcat prepopulated PoolProperties object the overwrite some
	 */
	protected void setAdditionalJDBCPoolProperties(PoolProperties p) {
	}

	@Override
	public Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	@Override
	public String getDriverVersion() {
		return driverversion;
	}

	@Override
	public String getSchema() {
		return schema;
	}

	/**
	 * This method should validate the connected user and return a string with information useful to the end user.<br>
	 * Examples of tests and information to be returned may include:
	 * <ul>
	 * <li>Password will expire in one week</li>
	 * <li>Password must be changed immediately</li>
	 * </ul> 
	 *  
	 * @param c a JDBC connection to retrieve the data
	 * @return a text with maybe a HTML link or null
	 * @throws SQLException
	 */
	public abstract Optional<String> validateLogin(Connection c) throws LoginSQLException;
	
	/**
	 * @param c a JDBC connection to retrieve the data
	 * @return a string indicating the connected database version
	 * @throws SQLException
	 */
	public abstract String readDatabaseVersion(Connection c) throws LoginSQLException;
	
	/**
	 * @param c a JDBC connection to retrieve the data
	 * @return the exact username as known by the database, e.g. the login was 'user1' but the actual user name is 'USER1'
	 * @throws SQLException
	 */
	public abstract String readExactUserName(Connection c) throws LoginSQLException;
}
