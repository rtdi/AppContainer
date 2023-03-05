package io.rtdi.appcontainer.plugins.databasehana;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class HanaActivationServiceDirectory extends ActivationServiceDirectory {

	protected HanaActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SQLParser());
		addService(".csv", new HanaCSVImport());
	}
	

}
