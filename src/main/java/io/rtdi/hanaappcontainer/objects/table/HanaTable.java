package io.rtdi.hanaappcontainer.objects.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.rtdi.hanaappcontainer.objects.HanaObjectWithColumn;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class HanaTable extends HanaObjectWithColumn {
	TemporaryType temporary;
	TableType tableType;
	Boolean hasPublicSynonym;
	TableLoggingType loggingType;
	List<IndexDefinition> indexes;
	PrimaryKeyDefinition primaryKey;
	String description;
	
	public HanaTable() {
		super();
	}

	public HanaTable(String schemaname, String tablename) {
		super(schemaname, tablename);
	}

	@Override
	public void valid() throws HanaSQLException {
		super.valid();
		if (columns == null || columns.size() == 0) {
			creationmessages.add("Table has no columns defined");
			throw new HanaSQLException("The table has no columns defined", "Check return information");
		} else {
			for (ColumnDefinition c : columns) {
				c.validate(creationmessages);
			}
		}
	}
	
	public String getTableName() {
		return getObjectName();
	}
	public void setTableName(String tableName) {
		setObjectName(tableName);
	}
	public TemporaryType getTemporary() {
		return temporary;
	}
	public void setTemporary(TemporaryType temporary) {
		this.temporary = temporary;
	}
	public TableType getTableType() {
		return tableType;
	}
	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}
	public Boolean getHasPublicSynonym() {
		return hasPublicSynonym;
	}
	public void setHasPublicSynonym(Boolean isPublic) {
		this.hasPublicSynonym = isPublic;
	}
	public TableLoggingType getLoggingType() {
		return loggingType;
	}
	public void setLoggingType(TableLoggingType loggingType) {
		this.loggingType = loggingType;
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
		return "Table:" + objectname + columns;
	}

	public void diff(HanaTableDiffAction action) throws HanaSQLException {
		HanaTable newtable = action.getTable();
		boolean needrecreate = !Util.sameOrNull(temporary, newtable.getTemporary());
		needrecreate |= !Util.sameOrNull(tableType, newtable.getTableType());
		needrecreate |= !Util.sameOrNull(loggingType, newtable.getLoggingType());
		if (needrecreate) {
			newtable.addCreationMessage("Table has different settings for either temporary, tabletype or logging and needs to be recreated from scratch hence");
			action.dropTable();
			action.createTable();
		} else {
			if (!Util.sameOrNull(hasPublicSynonym, newtable.getHasPublicSynonym())) {
				if (newtable.getHasPublicSynonym()) {
					action.createSynonym();
				} else {
					action.dropSynonym();
				}
			} else {
				action.addCreationMessage("No change in public synonym setting");
			}
			if (!Util.sameOrNull(description, newtable.getDescription())) {
				action.setTableComment();
			} else {
				action.addCreationMessage("No change in the table comment");
			}
			if (!(primaryKey == null && newtable.getPrimaryKey() == null)) {
				primaryKey.diff(newtable.getPrimaryKey(), action);
			}
			if (!(indexes == null && newtable.getIndexes() == null)) {
				Set<IndexDefinition> iremove = new HashSet<>(indexes);
				iremove.removeAll(new HashSet<>(newtable.getIndexes()));
				Set<IndexDefinition> iadd = new HashSet<>(newtable.getIndexes());
				iadd.removeAll(new HashSet<>(indexes));
				if (iadd.size() == 0 && iremove.size() == 0) {
					action.addCreationMessage("No change in the table index definitions");
				} else {
					for (IndexDefinition remove : iremove) {
						action.dropIndex(remove);
					}
					for (IndexDefinition add : iadd) {
						action.createIndex(add);
					}
				}
			}
			if (!(columns == null && newtable.getColumns() == null)) {
				Map<String, ColumnDefinition> cl = getAsMap(columns);
				Map<String, ColumnDefinition> cr = getAsMap(newtable.getColumns());

				Set<ColumnDefinition> newcolumns = new HashSet<>();

				Set<ColumnDefinition> changedcolumns = new HashSet<>();
				for (String columnname : cr.keySet()) {
					ColumnDefinition dl = cl.get(columnname);
					ColumnDefinition dr = cr.get(columnname);
					if (dl == null) {
						newcolumns.add(dr);
					} else if (!dr.equals(dl)) {
						changedcolumns.add(dr);
					}
				}
				
				Set<String> dropcolumns = new HashSet<>(cl.keySet());
				dropcolumns.removeAll(cr.keySet());
				
				
				action.addColumns(newcolumns);
				action.dropColumns(dropcolumns);
				action.modifyColumns(changedcolumns);
			}
		}
	}
	
	public static Map<String, ColumnDefinition> getAsMap(List<ColumnDefinition> columns) {
		Map<String, ColumnDefinition> colmap = new HashMap<>();
		for (ColumnDefinition c : columns) {
			colmap.put(c.getName(), c);
		}
		return colmap;
	}
}