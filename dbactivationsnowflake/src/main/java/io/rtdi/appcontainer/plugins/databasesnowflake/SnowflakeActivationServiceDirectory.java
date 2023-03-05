package io.rtdi.appcontainer.plugins.databasesnowflake;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class SnowflakeActivationServiceDirectory extends ActivationServiceDirectory {

	protected SnowflakeActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SQLParser());
		addService(".csv", new SnowflakeCSVImport());
	}
	

}
