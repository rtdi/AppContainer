package io.rtdi.appcontainer.plugins.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.dbunittest.JavaScriptExecutor;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;

public abstract class ActivationServiceDirectory {
	
	private static Map<String, IActivationService> services;
	
	public ActivationServiceDirectory(Path rootpath) {
		addServices();
		addService(".test.js", new JavaScriptExecutor(rootpath));
	}

	protected abstract void addServices();
	
	protected void addService(String extension, IActivationService service) {
		if (services == null) {
			services = new HashMap<>();
		}
		services.put(extension, service);
	}

	public ActivationResult activate(File file, IDatabaseLoginPrincipal dbprincipal, GlobalSchemaMapping gm, SQLVariables variables,
			ICatalogService catalogservice) throws IOException, SQLException {
		String name = file.getName();
		int pos = name.lastIndexOf('.');
		if (pos != -1) {
			String extension = name.substring(pos);
			IActivationService service = services.get(extension);
			if (service != null) {
				try (Connection conn = dbprincipal.getConnection();) {
					return service.activate(file, conn, gm, variables, catalogservice);
				}
			}
		}
		return null;
	}

}
