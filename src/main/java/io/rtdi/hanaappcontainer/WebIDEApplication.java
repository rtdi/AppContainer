package io.rtdi.hanaappcontainer;

import javax.ws.rs.ApplicationPath;

import io.rtdi.hanaappserver.servlets.JerseyApplication;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;


/**
 * Initialize all Jersey infrastructure.<br>
 * If a connector needs more than the default Jersey services it would extend this class,
 * override the {@link #getPackages()} method on register the new one in the web.xml.
 * Otherwise this class is added to the web.xml.
 *
 */
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