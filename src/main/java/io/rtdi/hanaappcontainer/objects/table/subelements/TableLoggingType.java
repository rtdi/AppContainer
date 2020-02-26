package io.rtdi.hanaappcontainer.objects.table.subelements;

public enum TableLoggingType {
	LOGGING("logging"), 
	NOLOGGING("nologging");

	private String keyword;

	TableLoggingType(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKey() {
		return keyword;
	}
}