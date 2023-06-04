package io.rtdi.appcontainer.rest.entity;

import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.Response;

public class CustomSuccessMessage {
	public static CacheControl control = new CacheControl();
	
	static {
		control.setNoCache(true);
		control.setMaxAge(0);
	}

	public static Response createResponse(Object entity) {
		return Response.ok(entity).cacheControl(control).build();
	}

}
