package io.rtdi.hanaappcontainer.objects.table;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationStyle;
import io.rtdi.hanaappserver.ActivationSuccess;
import io.rtdi.hanaappserver.DiffAction;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class HanaTableDiffAction extends DiffAction<HanaTable> {

	public HanaTableDiffAction(Connection conn, HanaTable table, ActivationStyle activation, ActivationResult result) {
		super(conn, table, activation, result);
	}

	public void dropPK() throws HanaSQLException {
		executeSQL(
				"alter table " + getObject().getIdentifier() + " drop primary key",
				"Failed dropping the primary key of the table");
	}

	public void createPK() throws HanaSQLException {
		if (getObject().getPrimaryKey() != null && getObject().getPrimaryKey().getPkcolumns() != null && getObject().getPrimaryKey().getPkcolumns().size() != 0) {
			executeSQL(
					"alter table " + getObject().getIdentifier() + " add primary key (" + Util.getColumnList(getObject().getPrimaryKey().getPkcolumns()) + ")",
					"Failed creating the primary key for the table");
		}
	}

	public void dropIndex(IndexDefinition idx) throws HanaSQLException {
		executeSQL(
				"drop index \"" + getObject().getSchemaName() + "\".\"" + idx.getName() + "\"",
				"Failed dropping the index");
	}

	public void createIndex(IndexDefinition idx) throws HanaSQLException {
		String schemaname = getObject().getSchemaName();
		String tablename = getObject().getObjectName();
		StringBuffer b = new StringBuffer();
		String indextype = "";
		if (idx.getUnique() != null && idx.getUnique().booleanValue()) {
			indextype = "UNIQUE ";
		}
		if (idx.getIndexType() != null) {
			indextype += idx.getIndexType().name();
		}
		b.append("create ").append(indextype).append("index \"").append(schemaname).append("\".\"").append(idx.getName()).append("\" ");
		b.append("on \"").append(schemaname).append("\".\"").append(tablename).append("\"(");
		if (idx.getIndexColumns() != null && idx.getIndexColumns().size() > 0) {
			boolean first = true;
			for (String p : idx.getIndexColumns()) {
				if (first) {
					first = false;
				} else {
					b.append(", ");
				}
				b.append('"').append(p).append("\"");
			}
			b.append(") ");
			if (idx.getOrder() != null) {
				b.append(idx.getOrder().name());
			}
			executeSQL(
					b.toString(),
					"Create index \"" + idx.getName() + "\" failed");
		}
	}

	public void createTable() throws HanaSQLException {
		// No table exists yet
		StringBuffer b = new StringBuffer();
		
		/*
		 * 	ROW | [ COLUMN ] } TABLE
			 | HISTORY COLUMN TABLE
			 | GLOBAL TEMPORARY { [ ROW ] | COLUMN } TABLE
			 | LOCAL TEMPORARY { [ ROW ] | COLUMN } TABLE
			 | VIRTUAL TABLE
		 */
		String tabletypekeyword;
		if (getObject().getTableType() == null || getObject().getTableType() == TableType.COLUMN) {
			tabletypekeyword = "column ";
		} else {
			tabletypekeyword = "row ";
		}
		String temporarykeyword = "";
		if (getObject().getTemporary() != null) {
			temporarykeyword = getObject().getTemporary().getKey();
		}
		b.append("create ").append(temporarykeyword).append(tabletypekeyword)
		.append("table ").append(getObject().getIdentifier());
		b.append("(\n");
		boolean first = true;
		Map<String, ColumnDefinition> columnnameindex = new HashMap<>();
		for (ColumnDefinition c : getObject().getColumns()) {
			columnnameindex.put(c.getName(), c); // needed later to lookup the PK columns
			if (c.getSqlType() != HanaDataType.IGNORE) {
				if (first) {
					first = false;
				} else {
					b.append(",\n");
				}
				b.append("    ").append(c.getColumnDefinition());
			}
		}
		if (getObject().getPrimaryKey() != null) {
			if (getObject().getPrimaryKey().getPkcolumns() != null) {
				StringBuffer pkcolumnlist = new StringBuffer();
				b.append(",\n    primary key (");
				for (String p : getObject().getPrimaryKey().getPkcolumns()) {
					ColumnDefinition pkcolumn = columnnameindex.get(p);
					if (pkcolumn != null) {
						if (pkcolumn.getSqlType() == HanaDataType.IGNORE) {
							// This is not a real column but a synonym for a list of columns
							Map<String, ColumnDefinition> type = pkcolumn.getTypeColumns();
							if (type != null) {
								for (String t : type.keySet()) {
									addPKColumn(pkcolumnlist, t);
								}
							} else {
								failingCreationMessage(
										"Primary key column \"" + p + 
										"\" is a column with data type ComplexType but its type cannot be found", 
										null);
							}
						} else {
							addPKColumn(pkcolumnlist, p);
						}
					} else {
						failingCreationMessage("Specified primary key column \"" + p + "\" is no existing column of the table", null);
					}
				}
				b.append(pkcolumnlist);
				b.append(')');
			}
		}
		b.append(") ");
		if (getObject().getLoggingType() != null) {
			b.append(getObject().getLoggingType().name());
		}
		executeSQL(
				b.toString(),
				"Failed creating the table"
				);
		if (getObject().getDescription() != null) {
			setTableComment();
		}
		if (getObject().getIndexes() != null) {
			for (IndexDefinition idx : getObject().getIndexes()) {
				createIndex(idx);
			}
		}
		if (getObject().getHasPublicSynonym() != null && getObject().getHasPublicSynonym().booleanValue()) {
			if (!objectExists("PUBLIC", getObject().getTableName())) {
				createSynonym();
			}
		}
	}
	
	private StringBuffer addPKColumn(StringBuffer pkcolumnlist, String columnname) {
		if (pkcolumnlist.length() != 0) {
			pkcolumnlist.append(", ");
		}
		pkcolumnlist.append('"').append(columnname).append("\"");
		return pkcolumnlist;
	}

	public void dropTable() throws HanaSQLException {
		executeSQL("drop table " + getObject().getIdentifier() + " cascade", "Failed dropping the table");
	}

	public void createSynonym() throws HanaSQLException {
		executeSQL(
				"create public synonym \"" + getObject().getTableName() + "\" for " + getObject().getIdentifier(), 
				"Failed creating the public synonym for the table");
	}

	public void dropSynonym() throws HanaSQLException {
		executeSQL(
				"drop public synonym \"" + getObject().getTableName() + "\";", 
				"Failed dropping the public synonym for the table");
	}

	public void setTableComment() throws HanaSQLException {
		executeSQL(
				"comment on table " + getObject().getIdentifier() + " is \'" + getObject().getDescription()+ '\'',
				"Failed to create table comment");
	}

	public void createColumnComment(ColumnDefinition c) throws HanaSQLException {
		executeSQL(
				"comment on column " + getObject().getIdentifier() + ".\"" + c.getName() + "\" is '" + c.getComment() + "'", 
				"Failed creating the column comment");
	}

	public void addColumns(Set<ColumnDefinition> newcolumns) throws HanaSQLException {
		if (newcolumns != null && newcolumns.size() > 0) {
			StringBuffer b = new StringBuffer();
	
			for (ColumnDefinition c : newcolumns) {
				if (b.length() != 0) {
					b.append(", ");
				}
				b.append(c.getColumnDefinition());
			}
			b.insert(0, "alter table " + getObject().getIdentifier() + " add (");
			b.append(")");
			executeSQL(b.toString(), "Failed to add the new columns");
		} else {
			addCreationMessage("No new columns", null, ActivationSuccess.SUCCESS);
		}
	}

	public void dropColumns(Set<String> dropcolumns) throws HanaSQLException {
		if (dropcolumns != null && dropcolumns.size() > 0) {
			StringBuffer b = new StringBuffer();
	
			for (String columnname : dropcolumns) {
				if (b.length() != 0) {
					b.append(", ");
				}
				b.append(columnname);
			}
			b.insert(0, "alter table " + getObject().getIdentifier() + " drop (");
			b.append(")");
			executeSQL(b.toString(), "Failed to drop the removed columns");
		} else {
			addCreationMessage("No removed columns", null, ActivationSuccess.SUCCESS);
		}
	}

	public void modifyColumns(Set<ColumnDefinition> changedcolumns) throws HanaSQLException {
		if (changedcolumns != null && changedcolumns.size() > 0) {
			StringBuffer b = new StringBuffer();
	
			for (ColumnDefinition column : changedcolumns) {
				if (b.length() != 0) {
					b.append(", ");
				}
				b.append(column.getColumnDefinition());
			}
			b.insert(0, "alter table " + getObject().getIdentifier() + " alter (");
			b.append(")");
			executeSQL(b.toString(), "Failed to alter the changed columns");
		} else {
			addCreationMessage("No changed columns", null, ActivationSuccess.SUCCESS);
		}
	}

}
