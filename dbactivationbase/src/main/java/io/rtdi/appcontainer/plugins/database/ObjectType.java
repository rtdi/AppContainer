package io.rtdi.appcontainer.plugins.database;

public enum ObjectType {
	TABLE,
	VIEW,
	PROCEDURE,
	SEQUENCE,
	SYNONYM,
	FUNCTION;
	
	public static ObjectType valueOfOrNull(String type) {
		try {
			return ObjectType.valueOf(type);
		} catch (Exception e) {
			return null;
		}
	}

}
