package io.rtdi.appcontainer.db.rest.entity.sql;

import java.util.List;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

/**
 * The SQLApp produces a Json in the form of
 * 
 * <pre>
 * - with
 *   - alias
 *   - subquery
 * - subquery
 *   - projections
 *     - value
 *     - alias
 *     - order
 *   - from
 *     - jointype
 *     - value
 *     - on
 *       - left
 *       - right
 *   - where
 *     - left
 *     - op
 *     - right
 * - limit
 * - offset
 * </pre>
 * 
 * Note that this is the UI tree, so it will have empty elements.
 *
 */
public class SqlStatement extends PrettyPrint {
	private List<WithEntry> with;
	private Subquery subquery;
	private List<OrderByEntry> order;
	private Integer limit;
	private Integer offset;
	
	public List<WithEntry> getWith() {
		return with;
	}
	public void setWith(List<WithEntry> with) {
		this.with = with;
	}
	public Subquery getSubquery() {
		return subquery;
	}
	public void setSubquery(Subquery subquery) {
		this.subquery = subquery;
	}
	public List<OrderByEntry> getOrder() {
		return order;
	}
	public void setOrder(List<OrderByEntry> order) {
		this.order = order;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	
	
	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		if (with != null) {
			boolean first = true;
			for (WithEntry item : with) {
				if (item.isValid()) {
					if (first) {
						sb.append("WITH\r\n");
						first = false;
					} else {
						sb.append(",\r\n");
					}
					intend(sb, level+1);
					sb.append(item.toString(level+1, db));
				}
			}
			if (!first) {
				sb.append("\r\n");
			}
		}
		if (subquery != null) {
			sb.append(subquery.toString(level, db));
		} else {
			intend(sb, level);
			sb.append("<select..from..>");
		}
		sb.append("\r\n");
		if (subquery != null && subquery.getProjections() != null) {
			boolean first = true;
			for (Projection item : subquery.getProjections()) {
				if (item.isValid()) {
					OrderBy itemorder = item.orderBy();
					if (itemorder != null && itemorder != OrderBy.NONE) {
						if (first) {
							sb.append("ORDER BY ");
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(item.toColumnname());
						if (itemorder == OrderBy.DESC) {
							sb.append(" ");
							sb.append(itemorder.name());
						}
					}
				}
			}
		}
		return sb.toString();
	}
	
}