package io.rtdi.appcontainer.plugins.databasemysql;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.activation.SQLParser;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class MysqlActivationServiceDirectory extends ActivationServiceDirectory {

	protected MysqlActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
		addService(".sql", new SQLParser());
		addService(".csv", new MysqlCSVImport());
	}
	

}
