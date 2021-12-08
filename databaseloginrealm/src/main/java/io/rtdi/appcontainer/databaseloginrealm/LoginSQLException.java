package io.rtdi.appcontainer.databaseloginrealm;

import java.sql.SQLException;

/**
 * A SQLException that contains the sql string and extends the message with the sql details.
 * It substitutes the SQLException with this exception rather than throwing a new exception with the cause
 * being the SQLException.
 *
 */
public class LoginSQLException extends SQLException {

	private static final long serialVersionUID = 7144234468537929847L;
	private String sql;
	
	public LoginSQLException(String message, SQLException clonefrom, String sql) {
		super(message + "; sql failed with '" + clonefrom.getMessage() + "'; sql executed was '" + sql + "'",
				clonefrom.getSQLState(), clonefrom.getErrorCode(), clonefrom.getCause());
		this.sql = sql;
	}

	public LoginSQLException(SQLException clonefrom, String sql) {
		this(clonefrom.getMessage(), clonefrom, sql);
	}

	public String getSQL() {
		return sql;
	}
}
