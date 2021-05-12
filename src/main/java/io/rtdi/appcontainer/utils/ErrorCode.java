package io.rtdi.appcontainer.utils;

public enum ErrorCode {
	DATABASE_CONFIGURATION_ERROR(100, false),
	LOWLEVELEXCEPTION(1, false);

	private boolean recoverable;
	private int code;

	ErrorCode(int code, boolean recoverable) {
		this.recoverable = recoverable;
		this.code = code;
	}

	public boolean isRecoverable() {
		return recoverable;
	}

	public int getCode() {
		return code;
	}
}
