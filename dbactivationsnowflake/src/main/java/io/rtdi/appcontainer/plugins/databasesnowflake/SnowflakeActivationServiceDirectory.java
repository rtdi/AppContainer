package io.rtdi.appcontainer.plugins.databasesnowflake;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class SnowflakeActivationServiceDirectory extends ActivationServiceDirectory {

	protected SnowflakeActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SnowflakeSQLParser());
		addService(".csv", new SnowflakeCSVImport());
	}
	

}
