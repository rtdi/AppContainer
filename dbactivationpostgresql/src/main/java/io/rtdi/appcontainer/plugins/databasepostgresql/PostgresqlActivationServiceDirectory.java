package io.rtdi.appcontainer.plugins.databasepostgresql;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class PostgresqlActivationServiceDirectory extends ActivationServiceDirectory {

	protected PostgresqlActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SQLParser());
		addService(".csv", new PostgresqlCSVImport());
	}
	

}
