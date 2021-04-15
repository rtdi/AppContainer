package io.rtdi.appcontainer.designtimeobjects.hdbcds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.HanaObject;
import io.rtdi.appcontainer.objects.table.HanaTable;
import io.rtdi.appcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.appcontainer.utils.HanaDataType;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class CDSTable extends HanaTable {
	private Map<String, HanaObject> typedirectory;
	private Map<String, HanaObject> objectdirectory;

	public CDSTable(String schemaname, String tablename) throws HanaSQLException {
		super(schemaname, tablename);
	}

	@Override
	public ActivationResult valid(ActivationResult result) throws HanaSQLException {
		ListIterator<ColumnDefinition> iter = getColumns().listIterator();
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
								Map<String, ColumnDefinition> source = new HashMap<>();
								for ( JoinCondition condition : association.getJoinconditions()) {
									ColumnDefinition referencedcolumn = findByName(referencedtable.getColumns(), condition.getRightcolumn());
									if (referencedcolumn != null) {
										ColumnDefinition n = new ColumnDefinition();
										n.setName(condition.getLeftcolumn());
										n.applyDataType(referencedcolumn);
										n.applyComment(referencedcolumn);
										iter.add(n);
										source.put(n.getName(), n);
									}
								}
								coldef.setTypeColumns(source);
							}
						}
						coldef.setSqlType(HanaDataType.IGNORE);
					} else {
						HanaObject type = typedirectory.get(cdscoldef.getCDSType());
						if (type == null) {
							throw new HanaSQLException("The column \"" + cdscoldef.getName() + "\" has a CDS type called \"" + cdscoldef.getCDSType() + "\" which is not known", null);
						} else if (type instanceof ColumnType) {
							ColumnType c = (ColumnType) type;
							cdscoldef.applyDataType(c.getDataType());
						} else if (type instanceof ComplexType) {
							ComplexType c = (ComplexType) type;
							Map<String, ColumnDefinition> source = new HashMap<>();
							for (int i=c.getColumns().size()-1; i >= 0; i--) {
								ColumnDefinition t = c.getColumns().get(i);
								ColumnDefinition n = new ColumnDefinition();
								n.setName(coldef.getName() + "." + t.getName());
								n.applyDataType(t);
								n.applyComment(t);
								iter.add(n);
								source.put(n.getName(), n);
							}
							coldef.setSqlType(HanaDataType.IGNORE);
							coldef.setTypeColumns(source);
						}
					}
				}
			}
		}
		if (getPrimaryKey() != null && getPrimaryKey().getPkcolumns() != null) {
			Map<String, ColumnDefinition> columnnameindex = getAsMap(getColumns(), true);
			List<String> pkcolumns = new ArrayList<>();
			for (String p : getPrimaryKey().getPkcolumns()) {
				CDSColumnDefinition pkcolumn = (CDSColumnDefinition) columnnameindex.get(p);
				Map<String, ColumnDefinition> t = pkcolumn.getTypeColumns();
				if (t == null) {
					pkcolumns.add(p);
				} else {
					pkcolumns.addAll(t.keySet());
				}
			}
			getPrimaryKey().setPkcolumns(pkcolumns);
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
