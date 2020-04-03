package io.rtdi.hanaappserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.hanaappserver.utils.HanaSQLException;

/**
 * Allows to trigger an action in case a difference was found
 *
 */
public class DiffAction<T extends HanaObject> {
	protected Connection conn;
	private T object;
	private ActivationStyle activation;
	private ActivationResult result;

	public DiffAction(Connection conn, T table, ActivationStyle activation, ActivationResult result) {
		this.conn = conn;
		this.object = table;
		this.activation = activation;
		this.result = result;
	}

	protected void executeSQL(String sql, String text) throws HanaSQLException {
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.execute();
			addCreationMessage(text, sql, ActivationSuccess.SUCCESS);
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, text);
		}
	}
	
	protected boolean objectExists(String schemaname, String objectname) throws HanaSQLException {
		String sql = "select count(*) from objects where schema_name = ? and object_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, schemaname);
			stmt.setString(2, objectname);
			try (ResultSet rs = stmt.executeQuery(); ) {
				if (rs.next()) {
					return rs.getInt(1) >= 1;
				}
				return false; // Cannot happen actually
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Failed executing the query on the \"objects\" data dictionary view");
		}
	}
	
	public T getObject() {
		return object;
	}
	
	public void addCreationMessage(String text, String sql, ActivationSuccess success) {
		result.addResult(text, sql, success, object);
	}

	public void failingCreationMessage(String text, String sql) throws HanaSQLException {
		result.addResult(text, sql, ActivationSuccess.FAILED, object);
		throw new HanaSQLException(text, sql);
	}

	public ActivationStyle getActivation() {
		return activation;
	}
}
