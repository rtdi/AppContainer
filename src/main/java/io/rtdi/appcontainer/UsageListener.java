package io.rtdi.appcontainer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import io.rtdi.appcontainer.utils.UsageStatisticSender;

/**
 * Application Lifecycle Listener implementation class UsageListener
 *
 */
@WebListener
public class UsageListener implements ServletContextListener {

    private ScheduledExecutorService executor;

   public UsageListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	if (executor != null) {
    		executor.shutdownNow();
    		try {
				executor.awaitTermination(20, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
			}
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	if (System.getenv("HANAAPPCONTAINERSTATISTICS") == null || !System.getenv("HANAAPPCONTAINERSTATISTICS").equalsIgnoreCase("FALSE") ) {
	    	this.executor = Executors.newSingleThreadScheduledExecutor();
	    	executor.scheduleAtFixedRate(new UsageStatisticSender(), 1, 10, TimeUnit.MINUTES);
    	}
    }
	
}
