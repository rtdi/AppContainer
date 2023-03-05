package io.rtdi.appcontainer.plugins.databasesqlserver;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class SqlserverActivationServiceDirectory extends ActivationServiceDirectory {

	protected SqlserverActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SQLParser());
		addService(".csv", new SqlserverCSVImport());
	}
	

}
