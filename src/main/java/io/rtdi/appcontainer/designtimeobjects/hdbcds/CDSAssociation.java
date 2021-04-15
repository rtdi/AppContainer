package io.rtdi.appcontainer.designtimeobjects.hdbcds;

import java.util.ArrayList;
import java.util.List;

public class CDSAssociation {
	private String sourcecardinality;
	private String targetcardinality;
	private String referencedobject;
	private List<JoinCondition> joinconditions;
	
	
	public String getSourcecardinality() {
		return sourcecardinality;
	}
	public void setSourcecardinality(String sourcecardinality) {
		this.sourcecardinality = sourcecardinality;
	}
	public String getTargetcardinality() {
		return targetcardinality;
	}
	public void setTargetcardinality(String targetcardinality) {
		this.targetcardinality = targetcardinality;
	}
	public String getReferencedobject() {
		return referencedobject;
	}
	public void setReferencedobject(String referencedobject) {
		this.referencedobject = referencedobject;
	}
	public List<JoinCondition> getJoinconditions() {
		return joinconditions;
	}
	public void setJoinconditions(List<JoinCondition> joinconditions) {
		this.joinconditions = joinconditions;
	}
	public JoinCondition addJoincondition() {
		if (joinconditions == null) {
			joinconditions = new ArrayList<>();
		}
		JoinCondition j = new JoinCondition();
		joinconditions.add(j);
		return j;
	}
	
	@Override
	public String toString() {
		return "CDSAssociation [referencedobject=" + referencedobject + ", joinconditions=" + joinconditions + "]";
	}
	
}
