package io.rtdi.appcontainer.databaseloginrealmsnowflake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import io.rtdi.appcontainer.databaseloginrealm.DatabaseLoginPrincipal;
import io.rtdi.appcontainer.databaseloginrealm.LoginSQLException;

public class SnowflakePrincipal extends DatabaseLoginPrincipal {

	private static final long serialVersionUID = 742580325432L;
	public static final String JDBC_DRIVER = "net.snowflake.client.jdbc.SnowflakeDriver";
	public static final String ROLE_QUERY = "select role_name from UTIL_DB.INFORMATION_SCHEMA.APPLICABLE_ROLES";
	public static final String DBVERSION_QUERY = "select current_version()";
	public static final String DBUSER_QUERY = "select current_user()";

	public SnowflakePrincipal(String name, String password, String jdbcurl) throws SQLException {
		super(name, password, jdbcurl, JDBC_DRIVER, ROLE_QUERY);
	}

	@Override
	public Optional<String> validateLogin(Connection c) throws LoginSQLException {
		return Optional.empty();
	}


	@Override
	public String readDatabaseVersion(Connection c) throws LoginSQLException {
		try (PreparedStatement stmt = c.prepareStatement(DBVERSION_QUERY); ) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return "database version unknown";
			}
		} catch (SQLException e) {
			throw new LoginSQLException("Failed to read the database version", e, DBVERSION_QUERY);
		}
	}


	@Override
	public String readExactUserName(Connection c) throws LoginSQLException {
		try (PreparedStatement stmt = c.prepareStatement(DBUSER_QUERY); ) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return this.getName();
			}
		} catch (SQLException e) {
			throw new LoginSQLException("Failed to read the database user", e, DBUSER_QUERY);
		}
	}

}
