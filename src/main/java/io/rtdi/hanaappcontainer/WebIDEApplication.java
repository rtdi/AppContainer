package io.rtdi.hanaappcontainer;

import javax.ws.rs.ApplicationPath;

import io.rtdi.hanaappserver.servlets.JerseyApplication;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * Initialize all Jersey infrastructure.<br>
 * If a connector needs more than the default Jersey services it would extend this class,
 * override the {@link #getPackages()} method on register the new one in the web.xml.
 * Otherwise this class is added to the web.xml.
 *
 */
@OpenAPIDefinition(
        info = @Info(
                title = "HanaAppContainer",
                version = "1.0",
                description = "All Restful APIs of the HanaAppContainer"
        ),
        tags = {
                @Tag(name = "Filesystem", description = "APIs used to manipulate files"),
                @Tag(name = "ReadHana", description = "APIs to read data from Hana"),
                @Tag(name = "WriteHana", description = "APIs to write data into Hana"),
                @Tag(name = "Information", description = "APIs to get dictionary like data from Hana")
        },
        servers = {
                @Server(
                        description = "HanaAppContainer",
                        url = "/HanaAppContainer"
                        )
        }
)
@ApplicationPath("/protected/rest")
public class WebIDEApplication extends JerseyApplication {
	
	public WebIDEApplication() {
		super();
	}

	/**
	 * In case 
	 * @return null or a String[] of package names containing additional Jersey services
	 */
	@Override
	protected String[] getPackages() {
		String [] packages = {
				"io.rtdi.hanaappcontainer"};
		return packages;
	}
	
	@Override
	protected Object[] getObjectsToRegister() {
		Object[] r = { new OpenApiResource() };
        return r;
	}
}  