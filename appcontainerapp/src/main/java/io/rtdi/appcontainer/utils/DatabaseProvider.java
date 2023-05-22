package io.rtdi.appcontainer.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import jakarta.servlet.ServletContext;
import jakarta.validation.constraints.NotNull;

public class DatabaseProvider {
	public static final String DATABASE_PROVIDER = "io.rtdi.appcontainer.dbactivationbase.databaseprovider";
	private static final Logger log = LogManager.getLogger(DatabaseProvider.class);

	/**
	 * Find the database provider for database specific code with the same jdbc driver name.
	 * Usually there will be a single database provider provided in the webapp, the same as the database login realm.
	 * But in case there are multiple, pick the one with the matching driver name.
	 * If found, store it as servlet context attribute for faster access.
	 * 
	 * @param ctx Servlet Context to read/store the database provider from/in
	 * @param jdbcdrivername
	 * @return the database provider for the requested jdbc driver database
	 * @throws IOException in case no service provider can be found
	 */
	public synchronized static IDatabaseProvider getDatabaseProvider(@NotNull ServletContext ctx, String jdbcdrivername) throws IOException {
		if (ctx.getAttribute(DATABASE_PROVIDER) == null) {
			ServiceLoader<IDatabaseProvider> services = ServiceLoader.load(IDatabaseProvider.class);
			Iterator<IDatabaseProvider> iter = services.iterator();
			log.info("Trying to find the AppContainer's specific DatabaseProvider from {}", jdbcdrivername);
			while (iter.hasNext()) {
				IDatabaseProvider candidate = iter.next();
				log.info("Found candidate class {} handling the jdbc driver name {}", services.getClass().getSimpleName(), candidate.getJDBCDriverName());
				if (candidate.getJDBCDriverName().equals(jdbcdrivername)) {
					ctx.setAttribute(DATABASE_PROVIDER, candidate);
					log.info("Take it!");
					return candidate;
				}
			}
			// Should not be reached
			throw new IOException("Cannot find a service loader for the database");
		} else {
			return (IDatabaseProvider) ctx.getAttribute(DATABASE_PROVIDER);
		}
	}
}
