package io.rtdi.appcontainer.plugins.database;

public class SelectSource {
	private String schemaname;
	private String objectname;
	private String objecttype;
	private String targetschemaname;
	private String targetobjectname;
	private String targetobjecttype;
	private String qualifiershort;
	private String qualifier;
	
	public SelectSource(String schemaname, String objectname, String objecttype, String targetschemaname,
			String targetobjectname, String targetobjecttype, String ownschema) {
		super();
		this.schemaname = schemaname;
		this.objectname = objectname;
		this.objecttype = objecttype;
		this.targetschemaname = targetschemaname;
		this.targetobjectname = targetobjectname;
		this.targetobjecttype = targetobjecttype;
		if ("PUBLIC".equals(schemaname) && "SYNONYM".equals(objecttype)) {
			// A public synonym does not get the schema qualifier public.synonymname, just synonymname is enough
			this.qualifier = objectname;
			this.qualifiershort = objectname;
		} else {
			this.qualifier = schemaname + "." + objectname;
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
	public String getObjecttype() {
		return objecttype;
	}
	public String getTargetschemaname() {
		return targetschemaname;
	}
	public String getTargetobjectname() {
		return targetobjectname;
	}
	public String getTargetobjecttype() {
		return targetobjecttype;
	}

	public String getQualifiershort() {
		return qualifiershort;
	}

	public String getQualifier() {
		return qualifier;
	}

}
