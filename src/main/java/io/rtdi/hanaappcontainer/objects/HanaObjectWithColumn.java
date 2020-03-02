package io.rtdi.hanaappcontainer.objects;

import java.util.List;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;

public class HanaObjectWithColumn extends HanaObject {
	protected List<ColumnDefinition> columns;

	public HanaObjectWithColumn() {
		super();
	}

	public HanaObjectWithColumn(String schemaname, String objectname) {
		super(schemaname, objectname);
	}

	public List<ColumnDefinition> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnDefinition> columns) {
		this.columns = columns;
	}

}
