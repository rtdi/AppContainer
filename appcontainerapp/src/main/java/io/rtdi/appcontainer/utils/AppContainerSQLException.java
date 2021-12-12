package io.rtdi.appcontainer.utils;

import java.sql.SQLException;

public class AppContainerSQLException extends SQLException {

	private static final long serialVersionUID = 2754081147435338891L;
	private String sqltext;
	private String hint = null;

	private AppContainerSQLException(String message, SQLException e, String sqltext, String hint) {
		super(String.format("%s, SQLMessage: %s", message, e.getMessage()), e.getSQLState(), e.getErrorCode(), e.getCause());
		this.sqltext = sqltext;
		this.hint = hint;
	}

	private AppContainerSQLException(SQLException e, String sqltext, String hint) {
		super(e.getMessage(), e.getSQLState(), e.getErrorCode(), e);
		this.sqltext = sqltext;
		this.hint = hint;
	}

	public AppContainerSQLException(String message, String sqltext, String hint) {
		super(message);
		this.sqltext = sqltext;
		this.hint = hint;
	}

	public String getHint() {
		return hint;
	}

	public String getSQLStatement() {
		return sqltext;
	}

	/**
	 * Substitute a SQLException with a more detailed SQLException, which contains a custom message, the sql statement and a end user hint
	 * 
	 * @param message of what has been tried
	 * @param e the original SQLException it clones the values from
	 * @param sqltext is the exact SQL statement tried to be executed
	 * @param hint is a end user orientated text aimed to help the user how to fix it
	 * @return
	 */
	public static AppContainerSQLException cloneFrom(String message, SQLException e, String sqltext, String hint) {
		return new AppContainerSQLException(message, e, sqltext, hint);
	}

	/**
	 * Substitute a SQLException with a more detailed SQLException, which contains the sql statement and a end user hint
	 * 
	 * @param e the original SQLException it clones the values from
	 * @param sqltext is the exact SQL statement tried to be executed
	 * @param hint is a end user orientated text aimed to help the user how to fix it
	 * @return
	 */
	public static AppContainerSQLException cloneFrom(SQLException e, String sqltext, String hint) {
		return new AppContainerSQLException(e, sqltext, hint);
	}

}
