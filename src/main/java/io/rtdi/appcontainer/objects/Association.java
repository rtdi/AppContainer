package io.rtdi.appcontainer.objects;

import io.rtdi.appcontainer.activationapp.HanaObjectIdentifier;

public class Association {
	private String name;
	private HanaObjectIdentifier remoteobject;
	private JoinCardinality cardinality;
	private JoinDefinition join;

	public Association(String name) {
		super();
		this.name = name;
	}

	public HanaObjectIdentifier getRemoteObject() {
		return remoteobject;
	}

	public void setRemoteObject(HanaObjectIdentifier remoteobject) {
		this.remoteobject = remoteobject;
	}

	public JoinCardinality getCardinality() {
		return cardinality;
	}

	public void setCardinality(JoinCardinality cardinality) {
		this.cardinality = cardinality;
	}

	public JoinDefinition getJoin() {
		return join;
	}

	public void setJoin(JoinDefinition join) {
		this.join = join;
	}

	public String getName() {
		return name;
	}

	
}
