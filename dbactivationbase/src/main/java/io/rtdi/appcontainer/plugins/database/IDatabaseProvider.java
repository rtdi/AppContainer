package io.rtdi.appcontainer.plugins.database;

import java.nio.file.Path;

public interface IDatabaseProvider {
	
	String getJDBCDriverName();
	ActivationServiceDirectory getActivationServices(Path rootpath);
	ICatalogService getCatalogService();
	public IStoredProcedure getProcedureService();
	
}
