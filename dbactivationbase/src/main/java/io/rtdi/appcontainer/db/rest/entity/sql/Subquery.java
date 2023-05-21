package io.rtdi.appcontainer.db.rest.entity.sql;

import java.util.List;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

/**
 * <pre>
 * - subquery
 *   - projections
 *     - value
 *     - alias
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
 * </pre>
 *
 */
public class Subquery extends PrettyPrint {
	private List<Projection> projections;
	private List<TableExpression> from;
	private List<WhereCondition> where;
	
	public List<Projection> getProjections() {
		return projections;
	}
	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}
	public List<TableExpression> getFrom() {
		return from;
	}
	public void setFrom(List<TableExpression> from) {
		this.from = from;
	}
	public List<WhereCondition> getWhere() {
		return where;
	}
	public void setWhere(List<WhereCondition> where) {
		this.where = where;
	}
	public boolean isValid() {
		return from != null && from.size() > 0 && from.get(0).isValid();
	}
	
	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		StringBuilder groupby = new StringBuilder();
		boolean isgroupby = false;
		intend(sb, level);
		sb.append("SELECT\r\n");
		if (projections != null) {
			boolean first = true;
			for (Projection item : projections) {
				if (item.isValid()) {
					if (first) {
						first = false;
					} else {
						sb.append(",\r\n");
					}
					intend(sb, level+1);
					sb.append(item.toString(0, db));
					if (item.isAggregation(db)) {
						isgroupby = true;
					} else {
						if (groupby.length() != 0) {
							groupby.append(", ");
						}
						groupby.append(item.toColumnname());
					}
				}
			}
			if (first) {
				intend(sb, level+1);
				sb.append("*");
			}
		} else {
			intend(sb, level+1);
			sb.append("*");
		}
		sb.append("\r\n");
		intend(sb, level);
		sb.append("FROM ");
		if (from != null) {
			boolean first = true;
			for (TableExpression item : from) {
				if (item.isValid()) {
					if (first) {
						first = false;
					} else {
						sb.append("\r\n");
						intend(sb, level+1);
					}
					sb.append(item.toString(level+1, db));
				}
			}
		}
		if (where != null) {
			boolean first = true;
			for (WhereCondition item : where) {
				if (item.isValid()) {
					if (first) {
						sb.append("\r\n");
						intend(sb, level);
						sb.append("WHERE ");
						first = false;
					} else {
						sb.append(" AND ");
					}
					sb.append(item.toString(level+1, db));
				}
			}
		}
		if (isgroupby && groupby.length() > 0) {
			sb.append("\r\n");
			intend(sb, level);
			sb.append("GROUP BY ").append(groupby);
		}
		return sb.toString();
	}

}
