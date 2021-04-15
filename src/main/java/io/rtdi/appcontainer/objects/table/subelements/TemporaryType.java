package io.rtdi.appcontainer.objects.table.subelements;

public enum TemporaryType {
	GLOBALTEMPORARY("global temporary"),
	LOCALTEMPORARY("local temporary");

	private String keyword;

	TemporaryType(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKey() {
		return keyword;
	}
}
