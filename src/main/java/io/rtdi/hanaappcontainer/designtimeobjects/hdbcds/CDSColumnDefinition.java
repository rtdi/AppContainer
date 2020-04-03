package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class CDSColumnDefinition extends ColumnDefinition {
	private String cdstype;
	private CDSAssociation cdsassociation;
	
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
	public void validate(ActivationResult result) throws HanaSQLException {
		// super.validate(result);
	}
	
	public CDSAssociation getCDSAssociation() {
		return cdsassociation;
	}

	public void setCDSAssociation(CDSAssociation cdsassociation) {
		this.cdsassociation = cdsassociation;
	}

	public CDSAssociation createCDSAssociation() {
		cdsassociation = new CDSAssociation();
		return cdsassociation;
	}

}
