package io.rtdi.appcontainer.plugins.databasesnowflake;

import io.rtdi.appcontainer.plugins.activation.CSVImport;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class SnowflakeActivationServiceDirectory extends ActivationServiceDirectory {

	protected SnowflakeActivationServiceDirectory() {
		super();
	}

	@Override
	protected void addServices() {
		addService(".sql", new SnowflakeSQLParser());
		addService(".csv", new CSVImport());
	}
	

}
