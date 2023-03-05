package io.rtdi.appcontainer.plugins.database;

import java.sql.Connection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.benmanes.caffeine.cache.Cache;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureMetadata;

public interface IStoredProcedure {

	/**
	 * 
	 * @param conn 
	 * @param schema 
	 * @param procedurename 
	 * @param data 
	 * @param cache 
	 * @param provider
	 * @return the Json payload
	 * @throws AppContainerSQLException 
	 * 
	 */
	ObjectNode callProcedure(Connection conn, String schema, String procedurename, JsonNode data,
			Cache<String, ProcedureMetadata> cache, IDatabaseProvider provider) throws AppContainerSQLException;

}