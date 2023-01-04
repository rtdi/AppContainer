package io.rtdi.appcontainer.plugins.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	
	String getTableDDL(Connection conn, String schema, String name) throws SQLException;
	String getViewDDL(Connection conn, String schema, String name) throws SQLException;
	String getFunctionDDL(Connection conn, String schema, String name) throws SQLException;
	String getProcedureDDL(Connection conn, String schema, String name) throws SQLException;
	DatabaseObjectTree getDependencies(Connection conn, String schema, String name) throws SQLException;
	DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException;
	List<SelectSource> getAllSelectSources(Connection conn) throws SQLException;
	
}
