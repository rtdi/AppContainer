package io.rtdi.appcontainer.db.rest.entity;

public class SchemaDefinition {
	private String schemaname;
	
	public SchemaDefinition() {
		
	}
	
	public SchemaDefinition(String schemaname) {
		this.schemaname = schemaname;
	}

	public String getSchemaname() {
		return schemaname;
	}

	public String getName() {
		return schemaname;
	}
	
	public void setSchemaname(String name) {
		this.schemaname = name;
	}
	
	public void setName(String name) {
		this.schemaname = name;
	}
	
}