package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.utils.HanaSQLException;

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
