package io.rtdi.appcontainer.plugins.database;

public class SelectSource {
	private String schemaname;
	private String objectname;
	private ObjectType objecttype;
	private String targetschemaname;
	private String targetobjectname;
	private ObjectType targetobjecttype;
	private String qualifiershort;
	private String qualifier;
	private Integer match;

	public SelectSource() {
	}
	
	public SelectSource(String schemaname, String objectname, ObjectType objecttype, String targetschemaname,
			String targetobjectname, ObjectType targetobjecttype, String ownschema) {
		super();
		this.schemaname = schemaname;
		this.objectname = objectname;
		this.objecttype = objecttype;
		this.targetschemaname = targetschemaname;
		this.targetobjectname = targetobjectname;
		this.targetobjecttype = targetobjecttype;
		this.qualifier = schemaname + "." + objectname;
		if ("PUBLIC".equals(schemaname) && objecttype == ObjectType.SYNONYM) {
			// A public synonym does not get the schema qualifier public.synonymname, just synonym name is enough
			this.qualifiershort = objectname;
		} else {
			if (ownschema != null && ownschema.equals(schemaname)) { 
				this.qualifiershort = objectname;
			} else {
				this.qualifiershort = qualifier;
			}
		}
	}

	public String getSchemaname() {
		return schemaname;
	}
	public String getObjectname() {
		return objectname;
	}
	public ObjectType getObjecttype() {
		return objecttype;
	}
	public String getTargetschemaname() {
		return targetschemaname;
	}
	public String getTargetobjectname() {
		return targetobjectname;
	}
	public ObjectType getTargetobjecttype() {
		return targetobjecttype;
	}

	public String getQualifiershort() {
		return qualifiershort;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifiershort(String text) {
		this.qualifiershort = text;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public void setObjecttype(ObjectType objecttype) {
		this.objecttype = objecttype;
	}

	public void setTargetschemaname(String targetschemaname) {
		this.targetschemaname = targetschemaname;
	}

	public void setTargetobjectname(String targetobjectname) {
		this.targetobjectname = targetobjectname;
	}

	public void setTargetobjecttype(ObjectType targetobjecttype) {
		this.targetobjecttype = targetobjecttype;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public Integer getMatch() {
		return match;
	}
	public void setMatch(Integer match) {
		this.match = match;
	}

}
