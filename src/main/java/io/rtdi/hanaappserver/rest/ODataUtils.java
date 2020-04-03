package io.rtdi.hanaappserver.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.olingo.commons.api.ex.ODataRuntimeException;

public class ODataUtils {

	public static URI createId(String entitySetName, Object id) {
	    try {
	        return new URI(entitySetName + "(" + String.valueOf(id) + ")");
	    } catch (URISyntaxException e) {
	        throw new ODataRuntimeException("Unable to create id for entity: " + entitySetName, e);
	    }
	}

}
