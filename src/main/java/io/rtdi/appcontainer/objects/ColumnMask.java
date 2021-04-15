package io.rtdi.appcontainer.objects;

public class ColumnMask {
	private String columnname;
	private String maskexpression;

	public ColumnMask(String columnname, String maskexpression) {
		super();
		this.columnname = columnname;
		this.maskexpression = maskexpression;
	}

	public String getColumnName() {
		return columnname;
	}

	public String getMaskExpression() {
		return maskexpression;
	}

	@Override
	public String toString() {
		return "Masking " + columnname + " via " + maskexpression;
	}

}
