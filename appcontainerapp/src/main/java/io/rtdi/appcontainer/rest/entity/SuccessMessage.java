package io.rtdi.appcontainer.rest.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.ws.rs.core.Response;

@Schema(description="Simple success message")
public class SuccessMessage {
	private String message;
	private static final SuccessMessage OK = new SuccessMessage("OK");

	public static SuccessMessage getOk() {
		return OK;
	}
	
	public SuccessMessage() {
		super();
	}
	
	public SuccessMessage(String message) {
		this();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static Response createResponseOK() {
		return Response.ok().entity(OK).build();
	}

	public static Response createResponseOK(String message) {
		return Response.ok().entity(new SuccessMessage(message)).build();
	}

}
