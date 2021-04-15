package io.rtdi.appcontainer.utils;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Simple success message")
public class SuccessMessage {
	private String message;

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

}
