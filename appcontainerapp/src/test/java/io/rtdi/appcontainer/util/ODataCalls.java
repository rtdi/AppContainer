package io.rtdi.appcontainer.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class ODataCalls {
	private RestClient client;
	private static final String ODATA_API = "/protected/rest/odata"; 

	public ODataCalls(RestClient client) {
		this.client = client;
	}
	
	public JsonNode queryTable(String schema, String table) throws IOException {
		return client.executeJsonGet(ODATA_API + "/tables/" + RestClient.urlencode(schema) + "/" + RestClient.urlencode(table) + "/RS?$format=json").getJson();
	}

}
