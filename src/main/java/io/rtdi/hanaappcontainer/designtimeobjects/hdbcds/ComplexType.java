package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.util.Map;

import io.rtdi.hanaappcontainer.objects.HanaObjectWithColumns;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ComplexType extends HanaObjectWithColumns {

	private Map<String, HanaObject> typedirectory;

	public ComplexType(String schemaname, String typename) throws HanaSQLException {
		super(schemaname, typename);
	}

	@Override
	public String toString() {
		return "ComplexType [columns=" + columns + ", objectname=" + getObjectName() + "]";
	}

	public void setTypeDictionary(Map<String, HanaObject> typedirectory) {
		this.typedirectory = typedirectory;
	}

	@Override
	public ActivationResult valid(ActivationResult result) throws HanaSQLException {
		for ( ColumnDefinition column : getColumns()) {
			if (column.getSqlType() == null) {
				CDSColumnDefinition cdscoldef = (CDSColumnDefinition) column;
				HanaObject type = typedirectory.get(cdscoldef.getCDSType());
				if (type == null) {
					throw new HanaSQLException("The column \"" + cdscoldef.getName() + "\" has a CDS type called \"" + cdscoldef.getCDSType() + "\" which is not known", null);
				} else if (type instanceof ColumnType) {
					ColumnType c = (ColumnType) type;
					cdscoldef.applyDataType(c.getDataType());
				}
			}
		}
		return super.valid(result);
	}
	
}
