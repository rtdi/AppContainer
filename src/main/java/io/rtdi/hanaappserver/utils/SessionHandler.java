package io.rtdi.hanaappserver.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;

public class SessionHandler {

	/**
	 * Do everything needed to handle the session state, errors and return a database connection
	 * @param req HttpServletRequest
	 * @param log Logger to use for debug information
	 * @return One database connection valid for the duration of the call
	 * @throws SQLException for any database errors
	 */
	public static Connection handleSession(HttpServletRequest req, Logger log) throws SQLException {
		HttpSession session = req.getSession();
		DataSource datasource = (DataSource) session.getAttribute("io.rtdi.datasource");
		if (datasource == null) {
			datasource = getDataSource((HanaPrincipal) req.getUserPrincipal(), session, log);
		}
		return datasource.getConnection();
	}

	public static synchronized DataSource getDataSource(HanaPrincipal principal, HttpSession session, Logger log) throws SQLException {
		if (principal == null) {
			throw new SQLException("User is not logged in");
		}
		DataSource datasource = (DataSource) session.getAttribute("io.rtdi.datasource");
		if (datasource == null) {
	        PoolProperties p = new PoolProperties();
	        p.setUrl(principal.getHanaJDBCURL());
	        p.setDriverClassName("com.sap.db.jdbc.Driver");
	        p.setUsername(principal.getName());
	        p.setPassword(principal.getPassword());
	        p.setJmxEnabled(false);
	        p.setTestWhileIdle(false);
	        // p.setTestOnBorrow(true);
	        // p.setValidationQuery("SELECT 1");
	        // p.setTestOnReturn(false);
	        // p.setValidationInterval(30000);
	        p.setTimeBetweenEvictionRunsMillis(30000);
	        p.setMaxActive(3);
	        p.setInitialSize(1);
	        p.setMaxIdle(p.getMaxActive());
	        p.setMinIdle(p.getMaxActive());
	        p.setMaxWait(10000);
	        p.setRemoveAbandonedTimeout(60);
	        // p.setMinEvictableIdleTimeMillis(60000);
	        // p.setMinIdle(10);
	        // p.setLogAbandoned(true);
	        p.setRemoveAbandoned(true);
	        p.setDefaultAutoCommit(false);
	        p.setJdbcInterceptors(
	          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
	          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
	        datasource = new DataSource();
	        datasource.setPoolProperties(p);
			session.setAttribute("io.rtdi.datasource", datasource);
			// This is used as failsafe for shutting down the server, as the shutdown does not trigger a session.destroy event normally
			@SuppressWarnings("unchecked")
			Map<HttpSession, DataSource> pools = (Map<HttpSession, DataSource>) session.getServletContext().getAttribute("io.rtdi.sessionpools");
			if (pools == null) {
				pools = new HashMap<>();
				session.getServletContext().setAttribute("io.rtdi.sessionpools", pools);
			}
			pools.put(session, datasource);
			log.debug("Hana connection pool {} created", datasource.getName());
		}
        return datasource;
	}

}
