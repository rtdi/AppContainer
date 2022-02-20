package io.rtdi.appcontainer.db.rest.entity;

import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Stored Procedure information")
public class StoredProcedure {
	private String schemaname;
	private String procedurename;
	private String endpoint;
	
	public StoredProcedure(String schemaname, String procedurename) {
		super();
		this.schemaname = schemaname;
		this.procedurename = procedurename;
		this.endpoint = "AppContainer/rest/procedure/" 
				+ Util.encodeURIfull(schemaname) 
				+ "/" 
				+ Util.encodeURIfull(procedurename);
	}

	public StoredProcedure() {
		super();
	}

	public String getProcedurename() {
		return procedurename;
	}
	public void setProcedurename(String procedurename) {
		this.procedurename = procedurename;
	}
	public String getSchemaname() {
		return schemaname;
	}
	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}