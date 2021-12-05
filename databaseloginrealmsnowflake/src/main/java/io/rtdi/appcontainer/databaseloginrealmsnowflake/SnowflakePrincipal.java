package io.rtdi.appcontainer.databaseloginrealmsnowflake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.realm.GenericPrincipal;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import io.rtdi.appcontainer.databaseloginrealm.IAppContainerPrincipal;

/**
 * The generic principal enriched with some additional information, e.g. the exact 
 * username (uppercase?) and the Snowflake version.
 *
 */
public class SnowflakePrincipal extends GenericPrincipal implements IAppContainerPrincipal {

	public static final String JDBC_DRIVER = "net.snowflake.client.jdbc.SnowflakeDriver";
	private static final long serialVersionUID = 465826394352656292L;
	private String version;
	private String user;
	private String loginwarnings;
	private DataSource pool;
	private String schema;
	private String driverversion;

	public SnowflakePrincipal(String name, String password, String jdbcurl) throws SQLException {
		super(name, queryRoles(name, password, jdbcurl)); // unfortunately there is no better way than that
		pool = getDataSource(name, password, jdbcurl);
	}

	/**
	 * @param name Snowflake user name
	 * @param password Snowflake password
	 * @param jdbcurl Snowflake JDBC connection URL
	 * @return the list of Snowflake role names the user has assigned, direct or indirect
	 * @throws SQLException in case the roles cannot be read
	 */
	public static List<String> queryRoles(String name, String password, String jdbcurl) throws SQLException {
		try (Connection c = getDatabaseConnection(name, password, jdbcurl)) {
			try (PreparedStatement stmt = c.prepareStatement("select role_name from UTIL_DB.INFORMATION_SCHEMA.APPLICABLE_ROLES"); ) {
				List<String> roles = new ArrayList<String>();
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					roles.add(rs.getString(1));
				}
				return roles;
			}
		}
	}
	
	private static Connection getDatabaseConnection(String user, String passwd, String jdbcurl) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(jdbcurl, user, passwd);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No Snowflake JDBC driver library found");
        }
	}

	@Override
	public String getDriver() {
		return JDBC_DRIVER;
	}

	/**
	 * @return the version string of the connected database as retrieved at login
	 */
	@Override
	public String getDBVersion() {
		return version;
	}

	/**
	 * @return the exact database user, e.g. the login user might by "user1" but the actual database user name is "USER1"
	 */
	@Override
	public String getDBUser() {
		return user;
	}

	@Override
	public String getLoginWarnings() {
		return loginwarnings;
	}

	@Override
	public void setLoginWarnings(String message) {
		this.loginwarnings = message;
	}

	private DataSource getDataSource(String name, String password, String jdbcurl) throws SQLException {
		DataSource datasource = null;
        PoolProperties p = new PoolProperties();
        p.setUrl(jdbcurl);
        p.setDriverClassName(JDBC_DRIVER);
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
        datasource = new DataSource();
        datasource.setPoolProperties(p);
		try (Connection c = datasource.getConnection()) {
			this.schema = c.getSchema();
			driverversion = c.getMetaData().getDriverVersion();
			try (PreparedStatement stmt = c.prepareStatement("select current_version(), current_user()"); ) {
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					this.version = rs.getString(1);
					this.user = rs.getString(2);
				}
			}
		}		

        return datasource;
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

}
