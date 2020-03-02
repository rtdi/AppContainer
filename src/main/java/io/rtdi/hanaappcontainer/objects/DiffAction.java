package io.rtdi.hanaappcontainer.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappserver.utils.HanaSQLException;

/**
 * Allows to trigger an action in case a difference was found
 *
 */
public class DiffAction {
	protected Connection conn;
	protected HanaTable newtable;
	protected ActivationStyle activation;

	public DiffAction(Connection conn, HanaTable table, ActivationStyle activation) {
		this.conn = conn;
		this.newtable = table;
		this.activation = activation;
	}

	protected void executeSQL(String sql, String text) throws HanaSQLException {
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.execute();
			newtable.addCreationMessage(sql);
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
			throw new HanaSQLException(e, sql, "Failed executing the query on the objects data dictionary view");
		}
	}
	
	public HanaTable getTable() {
		return newtable;
	}
	
	public void addCreationMessage(String text) {
		newtable.addCreationMessage(text);
	}
}
