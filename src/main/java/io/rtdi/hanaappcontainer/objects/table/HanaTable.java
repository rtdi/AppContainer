package io.rtdi.hanaappcontainer.objects.table;

import java.util.List;

import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;

public class HanaTable {
	String schemaName;
	String tableName;
	TemporaryType temporary;
	TableType tableType;
	Boolean hasPublicSynonym;
	TableLoggingType loggingType;
	List<ColumnDefinition> columns;
	List<IndexDefinition> indexes;
	PrimaryKeyDefinition primaryKey;
	String description;
	
	public HanaTable() {
		super();
	}
	
	public String getSchemaName() { // should not be used!
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
		return "Table:" + tableName + columns;
	}

}