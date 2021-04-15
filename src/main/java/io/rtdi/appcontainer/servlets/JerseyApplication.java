package io.rtdi.appcontainer.servlets;

import java.util.Arrays;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * Initialize all Jersey infrastructure.<br>
 * If a connector needs more than the default Jersey services it would extend this class,
 * override the getPackages() method on register the new one in the web.xml.
 * Otherwise this class is added to the web.xml.
 *
 */
public class JerseyApplication extends ResourceConfig {
	
	public JerseyApplication() {
		super();
		String[] p = getPackages();
		if (p == null) {
			packages("io.rtdi.appcontainer.rest");
		} else {
			p = Arrays.copyOf(p, p.length+1);
			p[p.length-1] = "io.rtdi.appcontainer.rest";
			packages(p);
		}
		register(JacksonFeature.class);
		register(RolesAllowedDynamicFeature2.class);
		
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
		return null;
	}
	
	protected Object[] getObjectsToRegister() {
		return null;
	}
}