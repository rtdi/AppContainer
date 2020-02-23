package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.TableType;

public class HDBTable {
	/*
		struct TableDefinition {
		    string schemaName;
		    optional bool temporary;
		    optional TableType tableType;
		    optional bool public;
		    optional TableLoggingType loggingType;
		    list<ColumnDefinition> columns;
		    optional list<IndexDefinition> indexes;
		    optional PrimaryKeyDefinition primaryKey;
		    optional string description;
		};
		TableDefinition table;
	 * };
	 * 
	 */
	String schemaName;
	Boolean temporary;
	TableType tableType;
	Boolean isPublic;
	TableLoggingType loggingType;
	List<ColumnDefinition> columns;
	List<IndexDefinition> indexes;
	PrimaryKeyDefinition primaryKey;
	String description;
	
	public HDBTable() {
		super();
	}
	
	public String getSchemaName() { // should not be used!
		return schemaName;
	}
	public void write(Writer w) throws IOException {
		w.append("table.schemaName = \"").append(schemaName).append("\";\n");
		w.append("table.temporary = ").append(String.valueOf(temporary)).append(";\n");
		w.append("table.tableType = ").append(tableType.name()).append(";\n");
		w.append("table.loggingType = ").append(loggingType.name()).append(";\n");
		w.append("table.columns = [\n");
		boolean first = true;
		for (ColumnDefinition c : columns) {
			if (first) {
				first = false;
			} else {
				w.append(",\n");
			}
			w.append("         ");
			c.write(w);
		}
		w.append("\n];\n");
		if (indexes != null && indexes.size() != 0) {
			w.append("table.indexes = [\n");
			first = true;
			for (IndexDefinition idx : indexes) {
				if (first) {
					first = false;
				} else {
					w.append(",\n");
				}
				w.append("         ");
				idx.write(w);
			}
			w.append("\n];\n");
		}
		if (primaryKey != null && primaryKey.getPkcolumns() != null && primaryKey.getPkcolumns().size() != 0) {
			w.append("table.primaryKey.pkcolumns = ").append(HDBTable.writeStringList(primaryKey.getPkcolumns())).append(";\n");
		}
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public Boolean getTemporary() {
		return temporary;
	}
	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}
	public TableType getTableType() {
		return tableType;
	}
	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}
	public Boolean getPublic() {
		return isPublic;
	}
	public void setPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public TableLoggingType getLoggingType() {
		return loggingType;
	}
	public void setLoggingType(TableLoggingType loggingType) {
		this.loggingType = loggingType;
	}
	public List<ColumnDefinition> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnDefinition> columns) {
		this.columns = columns;
	}
	public List<IndexDefinition> getIndexes() {
		return indexes;
	}
	public void setIndexes(List<IndexDefinition> indexes) {
		this.indexes = indexes;
	}
	public PrimaryKeyDefinition getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(PrimaryKeyDefinition primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "HDBTable:" + columns;
	}

	public static String writeStringList(List<String> list) {
		StringBuffer b = new StringBuffer();
		b.append("[");
		boolean first = true;
		for (String s : list) {
			if (first) {
				first = false;
			} else {
				b.append(", ");
			}
			b.append("\"").append(s).append("\"");
		}
		b.append("]");
		return b.toString();
	}

}