package io.rtdi.appcontainer.designtimeobjects.hdbcds;

import io.rtdi.appcontainer.activationapp.HanaObject;
import io.rtdi.appcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class ColumnType extends HanaObject {

	private ColumnDefinition datatype;

	public ColumnType(String schemaname, String typename) throws HanaSQLException {
		super(schemaname, typename);
	}

	public ColumnDefinition getDataType() {
		return datatype;
	}

	public void setDataType(ColumnDefinition datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		return "ColumnType [datatype=" + datatype + ", objectname=" + getObjectName() + "]";
	}

}
