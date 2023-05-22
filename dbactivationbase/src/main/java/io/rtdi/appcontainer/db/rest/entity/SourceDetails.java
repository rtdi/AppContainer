package io.rtdi.appcontainer.db.rest.entity;

public class SourceDetails {
	private String objectname;
	private String objecttype;
	private String comment;
	private String schema;
	
	public SourceDetails() {
	}
	
	public SourceDetails(String schema, String objectname, String objecttype, String comment) {
		this.objectname = objectname;
		this.objecttype = objecttype;
		this.comment = comment;
		this.schema = schema;
	}

	public String getObjectname() {
		return objectname;
	}

	public String getName() {
		return objectname;
	}

	public String getObjecttype() {
		return objecttype;
	}

	public String getComment() {
		return comment;
	}

	public String getSchema() {
		return schema;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}
	
	public void setName(String objectname) {
		this.objectname = objectname;
	}

	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}