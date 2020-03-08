package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.HanaActivationException;

public class CDSColumnDefinition extends ColumnDefinition {
	private String cdstype;
	
	public String getCDSType() {
		return cdstype;
	}
	public void setCDSType(String cdstype) {
		this.cdstype = cdstype;
	}
	@Override
	public String toString() {
		return "CDSColumn [cdstype=" + cdstype + ", name=" + getName() + ", sqlType=" + getSqlType() + "]";
	}
	
	@Override
	public void validate(ActivationResult result) throws HanaActivationException {
		super.validate(result);
	}

}
