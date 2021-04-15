package io.rtdi.appcontainer.objects;

import java.util.ArrayList;
import java.util.List;

public class JoinDefinition {
	private String remoteobjectalias;
	private List<JoinCondition> joinconditions;
	
	public JoinDefinition() {
		super();
	}
	
	public static class JoinCondition {
		private String left;
		private String right;
		
		
		public JoinCondition(String left, String right) {
			super();
			this.left = left;
			this.right = right;
		}


		@Override
		public String toString() {
			return left + " = " + right;
		}
	}

	public String getRemoteObjectAlias() {
		return remoteobjectalias;
	}

	public List<JoinCondition> getJoinConditions() {
		return joinconditions;
	}

	public void setRemoteObjectAlias(String remoteobjectalias) {
		this.remoteobjectalias = remoteobjectalias;
	}

	public void setJoinConditions(List<JoinCondition> joinconditions) {
		this.joinconditions = joinconditions;
	}
	
	public void addJoinCondition(String left, String right) {
		if (joinconditions == null) {
			joinconditions = new ArrayList<>();
		}
		joinconditions.add(new JoinCondition(left, right));
	}
}
