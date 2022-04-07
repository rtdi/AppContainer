package io.rtdi.appcontainer.plugins.databasehana;

import java.nio.file.Path;

import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;

public class HanaProvider implements IDatabaseProvider {
	public static final String JDBC_DRIVER = "com.sap.db.jdbc.Driver";
	private static ActivationServiceDirectory activationservice;
	private static ICatalogService catalogservice;
	private static IStoredProcedure procedureservice;

	@Override
	public ActivationServiceDirectory getActivationServices(Path rootpath) {
		if (activationservice == null) {
			activationservice = new HanaActivationServiceDirectory(rootpath);
		}
		return activationservice;
	}

	@Override
	public ICatalogService getCatalogService() {
		if (catalogservice == null) {
			catalogservice = new HanaCatalogService();
		}
		return catalogservice;
	}
	
	public IStoredProcedure getProcedureService() {
		if (procedureservice == null) {
			procedureservice = new HanaStoredProcedure();
		}
		return procedureservice;
	}

	@Override
	public String getJDBCDriverName() {
		return JDBC_DRIVER;
	}

}
