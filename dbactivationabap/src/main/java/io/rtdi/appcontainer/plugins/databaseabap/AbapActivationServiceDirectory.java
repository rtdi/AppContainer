package io.rtdi.appcontainer.plugins.databaseabap;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;

public class AbapActivationServiceDirectory extends ActivationServiceDirectory {

	protected AbapActivationServiceDirectory(Path rootpath) {
		super(rootpath);
	}

	@Override
	protected void addServices() {
	}
	

}
