package io.rtdi.hanaappserver;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Application Lifecycle Listener implementation class ServerListener
 *
 */
@WebListener
public class ServerListener implements ServletContextListener {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

    /**
     * Default constructor. 
     */
    public ServerListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	log.debug("ServletContext gets destroyed");
    	ServletContext context = sce.getServletContext();
    	@SuppressWarnings("unchecked")
		Map<HttpSession, DataSource> pools = (Map<HttpSession, DataSource>) context.getAttribute("io.rtdi.sessionpools");
    	if (pools != null) {
    		for (DataSource p : pools.values()) {
    			p.close(true);
    			p.getPool().terminatePoolCleaner();
    	    	log.debug("Closing session connection pool {}", p.getName());
    		}
    		pools.clear();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    }
	
}
