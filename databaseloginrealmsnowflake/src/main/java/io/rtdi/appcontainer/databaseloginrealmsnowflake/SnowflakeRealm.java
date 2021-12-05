package io.rtdi.appcontainer.databaseloginrealmsnowflake;

import java.security.Principal;
import java.sql.SQLException;

import io.rtdi.appcontainer.databaseloginrealm.DatabaseLoginRealm;

/**
 * The Snowflake Realm is an authentication method for Tomcat to use the Snowflake database as authenticator.
 * In addition to that, the Principal returned by this Realm has all the Snowflake roles the user has assigned to as well.
 * 
 */
public class SnowflakeRealm extends DatabaseLoginRealm {

	public SnowflakeRealm() {
		super();
	}

	@Override
	protected Principal createNewPrincipal(String username, String credentials, String jdbcurl) throws SQLException {
		return new SnowflakePrincipal(username, credentials, jdbcurl); // this does throw a SQLException in case the login data is invalid
	}

}
