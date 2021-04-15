package io.rtdi.appcontainer.activationapp;

import java.util.ArrayList;
import java.util.List;

public class DesignTimeParsingResult {
	private List<String> parsingerrors;
	
	public void addCreationMessage(String text) {
		if (parsingerrors == null) {
			parsingerrors = new ArrayList<>();
		}
		parsingerrors.add(text);
	}

	public List<String> getParsingErrors() {
		return parsingerrors;
	}
}
