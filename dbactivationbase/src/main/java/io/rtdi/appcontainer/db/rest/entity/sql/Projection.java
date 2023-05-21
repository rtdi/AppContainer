package io.rtdi.appcontainer.db.rest.entity.sql;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

/**
 * <pre>
 *   - projections
 *     - value
 *     - alias
 *     - orderVisible
 * </pre>
 *
 */
public class Projection extends PrettyPrint {
	private String value;
	private String alias;
	private String order;
	private String ordervisible;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean isValid() {
		return value != null && value.length() > 0;
	}
	
	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		if (alias != null && alias.length() > 0) {
			sb.append(" AS ").append(alias);
		}
		return sb.toString();
	}
	
	public boolean isAggregation(IDatabaseProvider db) {
		return db.isAggregationExpression(value);
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public OrderBy orderBy() {
		if (order == null) {
			return OrderBy.NONE;
		} else if (order.equalsIgnoreCase("asc")) {
			return OrderBy.ASC;
		} else if (order.equalsIgnoreCase("desc")) {
			return OrderBy.DESC;
		} else {
			return OrderBy.NONE;
		}
	}
	public String getOrderVisible() {
		return ordervisible;
	}
	public void setOrderVisible(String ordervisible) {
		this.ordervisible = ordervisible;
	}
	public String toColumnname() {
		return value;
	}
}
