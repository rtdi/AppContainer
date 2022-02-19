package io.rtdi.appcontainer.plugins.databasesnowflake;

import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;

public class SnowflakeProvider implements IDatabaseProvider {
	public static final String JDBC_DRIVER = "net.snowflake.client.jdbc.SnowflakeDriver";
	private static ActivationServiceDirectory activationservice;
	private static ICatalogService catalogservice;
	private static IStoredProcedure procedureservice;

	@Override
	public ActivationServiceDirectory getActivationServices() {
		if (activationservice == null) {
			activationservice = new SnowflakeActivationServiceDirectory();
		}
		return activationservice;
	}

	@Override
	public ICatalogService getCatalogService() {
		if (catalogservice == null) {
			catalogservice = new SnowflakeCatalogService();
		}
		return catalogservice;
	}
	
	public IStoredProcedure getProcedureService() {
		if (procedureservice == null) {
			procedureservice = new SnowflakeStoredProcedure();
		}
		return procedureservice;
	}

	@Override
	public String getJDBCDriverName() {
		return JDBC_DRIVER;
	}

}
