package io.rtdi.appcontainer.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class QueryRestCalls {
	private RestClient client;
	private static final String REST_API = "/protected/rest"; 

	public QueryRestCalls(RestClient client) {
		this.client = client;
	}
	
	public JsonNode queryTable(String schema, String table) throws IOException {
		return client.executeJsonGet(REST_API + "/query/" + RestClient.urlencode(schema) + "/" + RestClient.urlencode(table)).getJson();
	}

	public JsonNode executeSelectStatement(String sql) throws IOException {
		return client.executeJsonGet(REST_API + "/query?$select=" + RestClient.urlencode(sql)).getJson();
	}

	public JsonNode lookupRow(String schema, String table, String where) throws IOException {
		return client.executeJsonGet(REST_API + "/lookup/" + RestClient.urlencode(schema) + "/" + RestClient.urlencode(table) + "?$where=" + RestClient.urlencode(where)).getJson();
	}

	public JsonNode getProcedures() throws IOException {
		return client.executeJsonGet(REST_API + "/procedures").getJson();
	}

	public JsonNode callProcedure(String schema, String name, String inputjson) throws IOException {
		return client.executeJsonPost(REST_API + "/procedures/" + RestClient.urlencode(schema) + "/" + RestClient.urlencode(name), inputjson).getJson();
	}

}
