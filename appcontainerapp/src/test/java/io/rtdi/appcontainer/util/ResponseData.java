package io.rtdi.appcontainer.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class ResponseData {
	private String payload;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	public JsonNode getJson() throws IOException { 
		return RestClient.parseJson(payload);
	}
}
