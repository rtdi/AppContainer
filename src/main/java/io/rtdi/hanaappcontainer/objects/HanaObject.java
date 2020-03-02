package io.rtdi.hanaappcontainer.objects;

import java.util.ArrayList;
import java.util.List;

import io.rtdi.hanaappserver.utils.HanaSQLException;

public class HanaObject {
	protected String schemaname;
	protected String objectname;
	protected List<String> creationmessages = new ArrayList<>();

	public HanaObject(String schemaname, String objectname) {
		this();
		this.schemaname = schemaname;
		this.objectname = objectname;
	}

	public HanaObject() {
		super();
	}
	
	public String getSchemaName() {
		return schemaname;
	}
	public void setSchemaName(String schemaname) {
		this.schemaname = schemaname;
	}
	public String getObjectName() {
		return objectname;
	}
	public void setObjectName(String objectname) {
		this.objectname = objectname;
	}

	public String getIdentifier() {
		return "\"" + schemaname + "\".\"" + objectname + "\"";
	}

	public void addCreationMessage(String text) {
		creationmessages.add(text);
	}
	
	public List<String> getCreationMessages() {
		return creationmessages;
	}
	
	public void valid() throws HanaSQLException {
		if (schemaname == null || schemaname.length() == 0) {
			creationmessages.add("Table has no schema set");
			throw new HanaSQLException("The object has no schema set", "Check return information");
		}
		if (objectname == null || objectname.length() == 0) {
			creationmessages.add("Object has no name set");
			throw new HanaSQLException("The object has no name set", "Check return information");
		}
	}

}
