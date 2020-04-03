package io.rtdi.hanaappserver;

import io.rtdi.hanaappserver.utils.HanaSQLException;

public class HanaObjectIdentifier {
	private String schemaname;
	private String objectname;
	
	public HanaObjectIdentifier(String schemaname, String objectname) throws HanaSQLException {
		this.schemaname = schemaname;
		this.objectname = objectname;
		if (schemaname == null || schemaname.length() == 0) {
			throw new HanaSQLException("The object has no schema set", null);
		}
		if (objectname == null || objectname.length() == 0) {
			throw new HanaSQLException("The object has no name set", null);
		}
	}

	public String getSchemaName() {
		return schemaname;
	}

	public String getObjectName() {
		return objectname;
	}

	@Override
	public String toString() {
		return getIdentifier();
	}

	public String getIdentifier() {
		return '"' + schemaname + "\".\"" + objectname + '"';
	}
	
	
}
