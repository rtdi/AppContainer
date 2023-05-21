package io.rtdi.appcontainer.db.rest.entity.sql;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

/**
 * <pre>
 *   - where
 *     - left
 *     - op
 *     - right
 * </pre>
 *
 */
public class WhereCondition extends PrettyPrint {
	private String left;
	private String op;
	private String right;
	
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public boolean isValid() {
		return left != null && left.length() > 0;
	}

	@Override
	public String toString(int level, IDatabaseProvider db) {
		StringBuilder sb = new StringBuilder();
		sb.append(left);
		sb.append(" ").append(op);
		if (right != null && right.length() > 0) {
			sb.append(" ").append(right);
		}
		return sb.toString();
	}

}
