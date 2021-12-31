package io.rtdi.appcontainer.plugins.database;

public interface IDatabaseProvider {
	
	String getJDBCDriverName();
	ActivationServiceDirectory getActivationServices();
	ICatalogService getCatalogService();

}
