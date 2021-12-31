package io.rtdi.appcontainer.plugins.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ICatalogService {

	/**
	 * Test if the object exists and its type.
	 * 
	 * @param conn
	 * @param schema the schema or null to use the default schema
	 * @param name exact object name
	 * @return null if the object does not exist or the type of the object
	 * @throws SQLException 
	 */
	ObjectType objectExists(Connection conn, String schema, String name) throws SQLException;
	
	/**
	 * Test if the object exists and its type.
	 * 
	 * @param conn
	 * @param schema the schema or null to use the default schema
	 * @param name exact object name
	 * @param columnname exact name of the column
	 * @return true if the column exists
	 * @throws SQLException 
	 */
	boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException;
}
