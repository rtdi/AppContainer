package io.rtdi.appcontainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
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
 * Application Lifecycle Listener implementation class WebAppStartListener
 *
 */
@WebListener
public class WebAppStartListener implements ServletContextListener {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

    public WebAppStartListener() {
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
    	String webapprootpath = sce.getServletContext().getRealPath("/");
    	Path rootpath = Path.of(webapprootpath, "..", "..", "repo").toAbsolutePath();
    	WebAppConstants.setHanaRepo(sce.getServletContext(), rootpath);
    	File rootdir = rootpath.toFile();
    	if (!rootdir.exists()) {
    		rootdir.mkdirs();
    	}
    	if (rootdir.listFiles().length == 0) {
    		Path temppath = rootpath.resolve("WEB-INF/repo");
    		try {
				copyFolder(temppath, rootpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
     }
	
    public static void copyFolder(Path source, Path target, CopyOption... options) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                Files.createDirectories(target.resolve(source.relativize(dir)));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.copy(file, target.resolve(source.relativize(file)), options);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
