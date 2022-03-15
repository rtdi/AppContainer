package io.rtdi.appcontainer.dbunittest.value;

import java.sql.JDBCType;

public class ColumnMetadata {

	private String columnName;
	private JDBCType columnType;
	private int scale;
	private int precision;
	private int index;
	
	public ColumnMetadata(String name, int index) {
		this.columnName = name;
		this.index = index;
	}

	public void setColumnDataType(int columnType) {
		this.columnType = JDBCType.valueOf(columnType);
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getColumnName() {
		return columnName;
	}

	public JDBCType getColumnType() {
		return columnType;
	}

	public int getScale() {
		return scale;
	}

	public int getPrecision() {
		return precision;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setColumnDataType(JDBCType columnType) {
		this.columnType = columnType;
	}
	
	@Override
	public String toString() {
		return columnName + " at index " + index;
	}
}
