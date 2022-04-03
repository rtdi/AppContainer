package io.rtdi.appcontainer;

import java.nio.file.Path;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.module.jakarta.xmlbind.JakartaXmlBindAnnotationModule;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.ApplicationPath;


/**
 * Enable OpenAPI
 *
 */
@OpenAPIDefinition(
        info = @Info(
                title = "AppContainer",
                version = "1.0",
                description = "All Restful APIs of the AppContainer"
        ),
        tags = {
                @Tag(name = "Repository", description = "APIs used to manipulate files in the repository"),
                @Tag(name = "ReadDB", description = "APIs to read data from the database"),
                @Tag(name = "WriteDB", description = "APIs to write data into the database"),
                @Tag(name = "Information", description = "APIs to get dictionary-like data from the database")
        },
        servers = {
                @Server(
                        description = "AppContainer",
                        url = "../../"
                        )
        }
)
@ApplicationPath("/protected/rest")
public class WebApplication extends ResourceConfig {
	
	public WebApplication() {
		super();
		String[] p = getPackages();
		packages(p);
		register(JacksonFeature.class);
		register(RolesAllowedDynamicFeature2.class);
		register(JakartaXmlBindAnnotationModule.class);
		
		Object[] objects = getObjectsToRegister();
		if (objects != null) {
			for (Object o : objects) {
				register(o);
			}
		}
	}

	/**
	 * In case 
	 * @return null or a String[] of package names containing additional Jersey services
	 */
	protected String[] getPackages() {
		String [] packages = {
				"io.rtdi.appcontainer"};
		return packages;
	}
	
	protected Object[] getObjectsToRegister() {
		Object[] r = { new OpenApiResource() };
        return r;
	}
	
	public static Path getWebAppRootPath(ServletContext servletcontext) {
		return Path.of(servletcontext.getRealPath("/"));
	}

}  