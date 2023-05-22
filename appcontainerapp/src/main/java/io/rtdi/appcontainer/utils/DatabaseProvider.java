package io.rtdi.appcontainer.utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.databasehana.HanaProvider;
import io.rtdi.appcontainer.plugins.databasemysql.MysqlProvider;
import io.rtdi.appcontainer.plugins.databasepostgresql.PostgresqlProvider;
import io.rtdi.appcontainer.plugins.databasesnowflake.SnowflakeProvider;
import io.rtdi.appcontainer.plugins.databasesqlserver.SqlserverProvider;
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
			IDatabaseProvider provider = null;
			switch (jdbcdrivername) {
			case HanaProvider.JDBC_DRIVER: provider = new HanaProvider(); break;
			case MysqlProvider.JDBC_DRIVER: provider = new MysqlProvider(); break;
			case PostgresqlProvider.JDBC_DRIVER: provider = new PostgresqlProvider(); break;
			case SnowflakeProvider.JDBC_DRIVER: provider = new SnowflakeProvider(); break;
			case SqlserverProvider.JDBC_DRIVER: provider = new SqlserverProvider(); break;
			}
			if (provider != null) {
				ctx.setAttribute(DATABASE_PROVIDER, provider);
				log.info("Using provider {} for jdbc driver name {}", provider.getClass().getSimpleName(), jdbcdrivername);
				return provider;
			}
			/*
			 * The ServiceLoader work from within the development environment but not packaged inside a war and deployed in tomcat.
			 * No services found then.
			 */
			/* ServiceLoader<IDatabaseProvider> services = ServiceLoader.load(IDatabaseProvider.class);
			Iterator<IDatabaseProvider> iter = services.iterator();
			log.info("Trying to find the AppContainer's specific DatabaseProvider for {}", jdbcdrivername);
			while (iter.hasNext()) {
				IDatabaseProvider candidate = iter.next();
				log.info("Found candidate class {} handling the jdbc driver name {}", services.getClass().getSimpleName(), candidate.getJDBCDriverName());
				if (candidate.getJDBCDriverName().equals(jdbcdrivername)) {
					ctx.setAttribute(DATABASE_PROVIDER, candidate);
					log.info("Take it!");
					return candidate;
				}
			} */
			// Should not be reached
			throw new IOException("Cannot find a service loader for the database");
		} else {
			return (IDatabaseProvider) ctx.getAttribute(DATABASE_PROVIDER);
		}
	}
}
