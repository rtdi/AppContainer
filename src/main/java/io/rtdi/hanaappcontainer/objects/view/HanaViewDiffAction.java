package io.rtdi.hanaappcontainer.objects.view;

import java.sql.Connection;
import java.util.List;

import io.rtdi.hanaappcontainer.objects.ColumnMask;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationStyle;
import io.rtdi.hanaappserver.DiffAction;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class HanaViewDiffAction extends DiffAction<HanaView> {

	public HanaViewDiffAction(Connection conn, HanaView view, ActivationStyle activation, ActivationResult result) {
		super(conn, view, activation, result);
	}

	public void createView() throws HanaSQLException {
		HanaView view = getObject();
		StringBuffer b = new StringBuffer();
		b.append("create view ").append(view.getIdentifier());
		if (view.getDescription() != null) {
			b.append(" comment '").append(view.getDescription()).append("'");
		}
		if (view.getParameters() != null && view.getParameters().size() > 0) {
			b.append(" (").append(getParameterClause(view.getParameters())).append(")");
		}
		if (view.getMaskedColumns() != null && view.getMaskedColumns().size() > 0) {
			b.append(" with mask (").append(getMaskedClause(view.getMaskedColumns())).append(")");
		}
		b.append(" as ").append(view.getViewDefinition());
		if (view.getHasStructuredPriv() != null && view.getHasStructuredPriv().booleanValue()) {
			b.append(" with structured privilege check");
		}
		executeSQL(b.toString(), "Failed to create the view");
		createColumnComments();
	}
	
	public void dropView() throws HanaSQLException {
		executeSQL("drop view " + getObject().getIdentifier(), "Failed to drop the view " + getObject().getIdentifier());
	}

	public void createColumnComments() throws HanaSQLException {
		HanaView view = getObject();
		if (view.getColumns() != null) {
			for (ColumnDefinition c : view.getColumns()) {
				createColumnComment(c);
			}
		}
	}

	public void createColumnComment(ColumnDefinition c) throws HanaSQLException {
		if (c.getComment() != null) {
			executeSQL("comment on column " + getObject().getIdentifier() + ".\"" + c.getName() + "\" is '" + c.getComment() + "'", "Failed to create column comment");
		}
	}

	private Object getMaskedClause(List<ColumnMask> columns) {
		StringBuffer b = new StringBuffer();
		for (ColumnMask c : columns) {
			if (b.length() != 0) {
				b.append(", ");
			}
			b.append(" \"").append(c.getColumnName()).append("\" using ").append(c.getMaskExpression());
		}
		return b.toString();
	}

	private String getParameterClause(List<ColumnDefinition> parameters) throws HanaSQLException {
		StringBuffer b = new StringBuffer();
		for (ColumnDefinition p : parameters) {
			if (b.length() != 0) {
				b.append(", ");
			}
			b.append(" IN \"").append(p.getName()).append("\" ");
			b.append(Util.getDataTypeString(p.getSqlType(), p.getLength(), p.getPrecision(), p.getScale()));
			if (p.getDefaultValue() != null) {
				b.append(p.getDefaultValue());
			}
		}
		return b.toString();
	}

	public void alterViewDefinition() throws HanaSQLException {
		HanaView view = getObject();
		executeSQL("alter view " + view.getIdentifier() + " as " + view.getViewDefinition(), "Failed to change the view definition");
	}
	
	public void setViewComment() throws HanaSQLException {
		executeSQL(
				"comment on view " + getObject().getIdentifier() + " is \'" + getObject().getDescription()+ '\'',
				"Failed to create view comment");
	}


}
