package io.rtdi.appcontainer.db.rest.entity.sql;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public abstract class PrettyPrint {

	public abstract String toString(int level, IDatabaseProvider db);
	
	public static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}
	
	@Override
	public String toString() {
		return toString(0, null);
	}
	
	public static void intend(StringBuilder sb, int level) {
		sb.append(" ".repeat(level*2));
	}
}
