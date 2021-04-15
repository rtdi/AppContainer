package io.rtdi.appcontainer.objects;

import java.util.ArrayList;
import java.util.List;

import io.rtdi.appcontainer.activationapp.HanaObject;
import io.rtdi.appcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class HanaObjectWithColumns extends HanaObject {
	protected List<ColumnDefinition> columns;
	private String description;

	public HanaObjectWithColumns(String schemaname, String objectname) throws HanaSQLException {
		super(schemaname, objectname);
	}

	public List<ColumnDefinition> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnDefinition> columns) {
		this.columns = columns;
	}
	public void addColumn(ColumnDefinition column) {
		if (columns == null) {
			columns = new ArrayList<>();
		}
		columns.add(column);
	}

	@Override
	public String toString() {
		return "HanaObjectWithColumns [columns=" + columns + ", objectname=" + getObjectName() + "]";
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
