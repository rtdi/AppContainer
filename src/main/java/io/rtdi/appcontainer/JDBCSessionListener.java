package io.rtdi.appcontainer;

import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Application Lifecycle Listener implementation class JDBCSessionListener
 *
 */
@WebListener
public class JDBCSessionListener implements HttpSessionListener {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

    public JDBCSessionListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	log.debug("Session created"); 
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	log.debug("Session getting removed");
		DataSource datasource = (DataSource) se.getSession().getAttribute("datasource");
		if (datasource != null) {
			datasource.close(true);
	    	log.debug("Session connection pool {} closed", datasource.getName());
			@SuppressWarnings("unchecked")
			Map<HttpSession, DataSource> pools = (Map<HttpSession, DataSource>) se.getSession().getServletContext().getAttribute("io.rtdi.sessionpools");
	    	if (pools != null) {
	    		pools.remove(se.getSession());
	    	}
		}
    }
	
}
