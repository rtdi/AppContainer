package io.rtdi.hanaappcontainer.objects.table.subelements;

import java.util.List;

public class PrimaryKeyDefinition {
	/*
		struct PrimaryKeyDefinition {
		    list<string> pkcolumns;
		    optional IndexType indexType;
		};
	 */
	List<String> pkcolumns;
	
	IndexType indexType;
	
	public List<String> getPkcolumns() {
		return pkcolumns;
	}
	public void setPkcolumns(List<String> pkcolumns) {
		this.pkcolumns = pkcolumns;
	}
	public IndexType getIndexType() {
		return indexType;
	}
	public void setIndexType(IndexType indexType) {
		this.indexType = indexType;
	}
	public String toString() {
		return "" + pkcolumns;
	}
}