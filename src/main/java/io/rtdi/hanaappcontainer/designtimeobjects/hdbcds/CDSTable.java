package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.HanaActivationException;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.utils.HanaDataType;

public class CDSTable extends HanaTable {
	private Map<String, HanaObject> typedirectory;
	private Map<String, HanaObject> objectdirectory;

	public CDSTable() {
		super();
	}

	public CDSTable(String schemaname, String tablename) {
		super(schemaname, tablename);
	}

	@Override
	public ActivationResult valid(ActivationResult result) throws HanaActivationException {
		Iterator<ColumnDefinition> iter = getColumns().iterator();
		int j = 0;
		while (iter.hasNext()) {
			ColumnDefinition coldef = iter.next();
			if (coldef.getSqlType() == null) {
				if (coldef instanceof CDSColumnDefinition) {
					CDSColumnDefinition cdscoldef = (CDSColumnDefinition) coldef;
					if (cdscoldef.getCDSAssociation() != null) {
						CDSAssociation association = cdscoldef.getCDSAssociation();
						String cardinality = association.getSourcecardinality();
						if (cardinality != null && cardinality.equals("*")) {
							HanaObject referenced = objectdirectory.get(association.getReferencedobject());
							if (cdscoldef.getCDSAssociation().getJoinconditions() != null && referenced != null && referenced instanceof CDSTable) {
								CDSTable referencedtable = (CDSTable) referenced;
								for ( JoinCondition condition : association.getJoinconditions()) {
									ColumnDefinition referencedcolumn = findByName(referencedtable.getColumns(), condition.getRightcolumn());
									ColumnDefinition n = new ColumnDefinition();
									n.setName(condition.getLeftcolumn());
									n.applyDataType(referencedcolumn);
									getColumns().add(n);
								}
							}
						}
					} else {
						HanaObject type = typedirectory.get(cdscoldef.getCDSType());
						if (type == null) {
							throw new HanaActivationException(result, "The column \"" + cdscoldef.getName() + "\" has a CDS type called \"" + cdscoldef.getCDSType() + "\" which is not known");
						} else if (type instanceof ColumnType) {
							ColumnType c = (ColumnType) type;
							cdscoldef.applyDataType(c.getDataType());
						} else if (type instanceof ComplexType) {
							ComplexType c = (ComplexType) type;
							for (int i=c.getColumns().size()-1; i >= 0; i--) {
								ColumnDefinition t = c.getColumns().get(i);
								ColumnDefinition n = new ColumnDefinition();
								n.setName(coldef.getName() + "." + t.getName());
								n.applyDataType(t);
								getColumns().add(j++, n);
							}
						}
					}
					coldef.setSqlType(HanaDataType.IGNORE);
				}
			}
			j++;
		}
		
		return super.valid(result);
	}

	private ColumnDefinition findByName(List<ColumnDefinition> columns, String name) {
		for (ColumnDefinition c : columns) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	public void setTypeDictionary(Map<String, HanaObject> typedirectory, Map<String, HanaObject> objectdirectory) {
		this.typedirectory = typedirectory;
		this.objectdirectory = objectdirectory;
	}

}
