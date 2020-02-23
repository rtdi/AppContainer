package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.HDBTable;

public class IndexDefinition {
	/*
		struct IndexDefinition {
		    string name;
		    bool unique;
		    optional Order order;
		    optional IndexType indexType;
		    list<string> indexColumns;
		};
	 */
	String name;
	Boolean unique;
	Order order;
	IndexType indexType;
	List<String> indexColumns;
	
	public void write(Writer w) throws IOException {
		w.append("{name = \"").append(name).append("\";");
		if (unique != null) {
			w.append(" unique = ").append(String.valueOf(unique)).append(";");
		}
		if (order != null) {
			w.append(" order = ").append(order.name()).append(";");
		}
		if (indexType != null) {
			w.append(" indexType = ").append(indexType.name()).append(";");
		}
		w.append(" indexColumns = ").append(HDBTable.writeStringList(indexColumns)).append(";}");
	}
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