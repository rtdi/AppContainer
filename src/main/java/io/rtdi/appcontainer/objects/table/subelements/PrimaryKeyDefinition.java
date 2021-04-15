package io.rtdi.appcontainer.objects.table.subelements;

import java.util.List;

import io.rtdi.appcontainer.activationapp.ActivationSuccess;
import io.rtdi.appcontainer.objects.table.HanaTableDiffAction;
import io.rtdi.appcontainer.utils.HanaSQLException;
import io.rtdi.appcontainer.utils.Util;

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
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (!(o instanceof PrimaryKeyDefinition)) {
			return false;
		} else {
			PrimaryKeyDefinition p = (PrimaryKeyDefinition) o;
			if (!Util.sameOrNull(indexType, p.getIndexType())) {
				return false;
			} else if (!Util.sameOrNull(pkcolumns, p.getPkcolumns())) {
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public int hashCode() {
		if (pkcolumns == null) {
			return 1;
		} else {
			return pkcolumns.hashCode(); // pkcolumns is unique enough for the hash buckets
		}
	}

	public void diff(PrimaryKeyDefinition newpk, HanaTableDiffAction action) throws HanaSQLException {
		if (!Util.sameOrNull(indexType, newpk.getIndexType()) || !Util.sameOrNull(pkcolumns, newpk.getPkcolumns())) {
			action.dropPK();
			action.createPK();
		} else {
			action.addCreationMessage("No change in primary keys", null, ActivationSuccess.SUCCESS);
		}

	}
}