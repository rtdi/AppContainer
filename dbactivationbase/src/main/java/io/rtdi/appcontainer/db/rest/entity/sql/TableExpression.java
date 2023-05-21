package io.rtdi.appcontainer.db.rest.entity.sql;

import java.util.List;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

/**
 * <pre>
 *   - from
 *     - jointype
 *     - value
 *     - on
 *       - left
 *       - right
 * </pre>
 *
 */
public class TableExpression extends PrettyPrint {
	private String jointype;
	private String value;
	private Boolean joinVisible; 
	private List<JoinCondition> on;
	private String alias;
	
	public String getJointype() {
		return jointype;
	}
	public void setJointype(String jointype) {
		this.jointype = jointype;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getJoinVisible() {
		return joinVisible;
	}
	public void setJoinVisible(Boolean joinVisible) {
		this.joinVisible = joinVisible;
	}
	public List<JoinCondition> getOn() {
		return on;
	}
	public void setOn(List<JoinCondition> on) {
		this.on = on;
	}
	public boolean isValid() {
		return value != null && value.length() > 0;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		if (joinVisible == Boolean.TRUE) {
			if (jointype == null || jointype.length() == 0) {
				sb.append(", ");
			} else {
				sb.append(" ").append(jointype);
				sb.append(" ");
			}
		}
		if (value != null) {
			sb.append(value);
		} else {
			sb.append("<table>");
		}
		if (alias != null && alias.length() > 0) {
			sb.append(" AS ").append(alias);
		}
		if (joinVisible == Boolean.TRUE && on != null) {
			boolean first = true;
			for (JoinCondition item : on) {
				if (item.isValid()) {
					if (first) {
						sb.append(" ON ");
						first = false;
					} else {
						sb.append(" AND ");
					}
					sb.append(item.toString(level+1, db));
				}
			}
		}
		return sb.toString();
	}
}
