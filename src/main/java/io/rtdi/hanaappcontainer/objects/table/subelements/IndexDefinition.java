package io.rtdi.hanaappcontainer.objects.table.subelements;

import java.util.List;

public class IndexDefinition {
	String name;
	Boolean unique;
	Order order;
	IndexType indexType;
	List<String> indexColumns;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getUnique() {
		return unique;
	}
	public void setUnique(Boolean unique) {
		this.unique = unique;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public IndexType getIndexType() {
		return indexType;
	}
	public void setIndexType(IndexType indexType) {
		this.indexType = indexType;
	}
	public List<String> getIndexColumns() {
		return indexColumns;
	}
	public void setIndexColumns(List<String> indexColumns) {
		this.indexColumns = indexColumns;
	}
	public String toString() {
		return (name!=null?name:"unknown name") + " " + indexColumns;
	}
}