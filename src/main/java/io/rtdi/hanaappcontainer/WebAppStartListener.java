package io.rtdi.hanaappcontainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebAppStartListener
 *
 */
@WebListener
public class WebAppStartListener implements ServletContextListener {

    public WebAppStartListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
   }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	String webapprootpath = sce.getServletContext().getRealPath("/");
    	Path rootpath = Path.of(webapprootpath, "..", "..", "hanarepo").toAbsolutePath();
    	WebAppConstants.setHanaRepo(sce.getServletContext(), rootpath);
    	File rootdir = rootpath.toFile();
    	if (!rootdir.exists()) {
    		rootdir.mkdirs();
    	}
    	if (rootdir.listFiles().length == 0) {
    		Path temppath = rootpath.resolve("WEB-INF/hanarepo");
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
