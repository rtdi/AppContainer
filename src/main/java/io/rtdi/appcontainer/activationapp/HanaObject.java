package io.rtdi.appcontainer.activationapp;

import java.sql.Connection;

import io.rtdi.appcontainer.utils.HanaSQLException;

public class HanaObject {
	protected HanaObjectIdentifier object;

	public HanaObject(String schemaname, String objectname) throws HanaSQLException {
		this();
		this.object = new HanaObjectIdentifier(schemaname, objectname);
	}

	public HanaObject() {
		super();
	}
	
	public String getSchemaName() {
		return object.getSchemaName();
	}

	public String getObjectName() {
		return object.getObjectName();
	}

	public String getIdentifier() {
		return object.getIdentifier();
	}

	public ActivationResult valid(ActivationResult result) throws HanaSQLException {
		return result;
	}
	
	public ActivationResult activate(ActivationResult result, Connection conn, ActivationStyle activation) throws HanaSQLException {
		return result;
	}

	@Override
	public String toString() {
		return "HanaObject [objectname=" + getObjectName() + "]";
	}

}
