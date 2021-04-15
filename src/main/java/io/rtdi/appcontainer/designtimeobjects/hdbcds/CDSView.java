package io.rtdi.appcontainer.designtimeobjects.hdbcds;

import java.util.Map;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.HanaObject;
import io.rtdi.appcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.appcontainer.objects.view.HanaView;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class CDSView extends HanaView {
	private Map<String, HanaObject> typedirectory;
	private Map<String, HanaObject> objectdirectory;
	private String from;
	private Boolean structuredprivcheck;

	public CDSView(String schemaname, String viewname) throws HanaSQLException {
		super(schemaname, viewname);
	}

	public void setTypeDictionary(Map<String, HanaObject> typedirectory, Map<String, HanaObject> objectdirectory) {
		this.typedirectory = typedirectory;
		this.objectdirectory = objectdirectory;
	}

	@Override
	public ActivationResult valid(ActivationResult result) throws HanaSQLException {
		StringBuffer b = new StringBuffer();
		b.append("select ");
		if (from == null) {
			throw new HanaSQLException("The view \"" + getViewName() + "\" has no from clause", null);
		}
		boolean first = true;
		if (getColumns() == null || getColumns().size() == 0) {
			throw new HanaSQLException("The view \"" + getViewName() + "\" has no columns", null);
		}
		for (ColumnDefinition c : getColumns()) {
			if (first) {
				first = false;
			} else {
				b.append(",\r\n");
			}
			CDSViewColumn cdscol = (CDSViewColumn) c;
			c.validate(result);
			b.append('"').append(cdscol.getProjection()).append('"');
			if (cdscol.getAlias() != null) {
				b.append(" as \"").append(cdscol.getAlias()).append("\"");
			}
		}
		b.append(" from \"").append(from).append("\"");
		setViewDefinition(b.toString());
		super.setStructuredPriv(structuredprivcheck);
		return result;
	}

	public String getViewName() {
		return getObjectName();
	}

	public void addFrom(String text) {
		this.from = text;
	}

	public void setStructuredPrivCheck(Boolean b) {
		this.structuredprivcheck = b;
	}

	public Boolean getStructuredPrivCheck() {
		return structuredprivcheck;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
