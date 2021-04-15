package io.rtdi.appcontainer.designtimeobjects.hdbcds;

public class CDSViewColumn extends CDSColumnDefinition {

	private String projection;
	private String alias;

	public void setProjection(String projectionformula) {
		this.projection = projectionformula;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getProjection() {
		return projection;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	public String toString() {
		if (alias != null) {
			return projection + " as " + alias;
		} else {
			return projection;
		}
	}

}