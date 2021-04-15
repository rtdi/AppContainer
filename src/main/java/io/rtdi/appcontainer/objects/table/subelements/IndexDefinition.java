package io.rtdi.appcontainer.objects.table.subelements;

import java.util.List;

import io.rtdi.appcontainer.utils.Util;

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
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (!(o instanceof IndexDefinition)) {
			return false;
		} else {
			IndexDefinition idx = (IndexDefinition) o;
			if (!Util.sameOrNull(name, idx.getName())) {
				return false;
			} else if (!Util.sameOrNull(unique, idx.getUnique())) {
				return false;
			} else if (!Util.sameOrNull(order, idx.getOrder())) {
				return false;
			} else if (!Util.sameOrNull(indexType, idx.getIndexType())) {
				return false;
			} else if (!Util.sameOrNull(indexColumns, idx.getIndexColumns())) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	@Override
	public int hashCode() {
		if (name == null) {
			return 1;
		} else {
			return name.hashCode(); // name is unique enough for the hash buckets
		}
	}
	
	
}