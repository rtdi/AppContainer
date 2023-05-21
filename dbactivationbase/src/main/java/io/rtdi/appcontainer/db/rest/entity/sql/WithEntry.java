package io.rtdi.appcontainer.db.rest.entity.sql;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class WithEntry extends PrettyPrint {
	private String alias;
	private Subquery subquery;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Subquery getSubquery() {
		return subquery;
	}
	public void setSubquery(Subquery subquery) {
		this.subquery = subquery;
	}
	public boolean isValid() {
		return alias != null && alias.length() != 0;
	}

	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		sb.append(alias).append(" AS (\r\n");
		if (subquery != null) {
			sb.append(subquery.toString(level+1, db));
		} else {
			intend(sb, level+1);
			sb.append("<select...from...>");
		}
		sb.append(")");
		return sb.toString();
	}
	
}
