package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

public class JoinCondition {
	private String leftcolumn;
	private String rightcolumn;
	
	public JoinCondition() {
		super();
	}

	public JoinCondition(String leftcolumn, String rightcolumn) {
		super();
		this.leftcolumn = leftcolumn;
		this.rightcolumn = rightcolumn;
	}

	public String getLeftcolumn() {
		return leftcolumn;
	}
	public String getRightcolumn() {
		return rightcolumn;
	}

	public void setLeftcolumn(String leftcolumn) {
		this.leftcolumn = leftcolumn;
	}

	public void setRightcolumn(String rightcolumn) {
		this.rightcolumn = rightcolumn;
	}
}
