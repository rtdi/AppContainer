package io.rtdi.appcontainer.activationapp;

public class HanaParsingException extends Exception {
	private static final long serialVersionUID = -7073824340251134919L;
	private DesignTimeParsingResult parsingresult;

	public HanaParsingException(String text, DesignTimeParsingResult parsingresult) {
		super(text);
		this.parsingresult = parsingresult;
	}

	public DesignTimeParsingResult getDesignTimeParsingResult() {
		return parsingresult;
	}
}
