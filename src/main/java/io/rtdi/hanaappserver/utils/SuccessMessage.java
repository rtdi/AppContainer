package io.rtdi.hanaappserver.utils;

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
