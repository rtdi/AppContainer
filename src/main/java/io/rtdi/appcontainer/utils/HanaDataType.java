package io.rtdi.appcontainer.utils;

public enum HanaDataType {
	TINYINT(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	SMALLINT(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	INTEGER(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	BIGINT(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	DECIMAL(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.DECIMALPARAM),
	REAL(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	DOUBLE(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	CHAR(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	VARCHAR(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	BINARY(HanaDataTypeValueGroup.BINARY, HanaDataTypeGroup.LENGTHPARAM),
	VARBINARY(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	DATE(HanaDataTypeValueGroup.DATE, HanaDataTypeGroup.NOPARAM),
	TIME(HanaDataTypeValueGroup.TIME, HanaDataTypeGroup.NOPARAM),
	TIMESTAMP(HanaDataTypeValueGroup.TIMESTAMP, HanaDataTypeGroup.NOPARAM),
	CLOB(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	BLOB(HanaDataTypeValueGroup.BINARY, HanaDataTypeGroup.NOPARAM),
	NCHAR(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	NVARCHAR(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	ALPHANUM(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	NCLOB(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	SMALLDECIMAL(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	TEXT(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	BINTEXT(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	SHORTTEXT(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.LENGTHPARAM),
	SECONDDATE(HanaDataTypeValueGroup.DATETIME, HanaDataTypeGroup.NOPARAM),
	ST_POINT(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	ST_GEOMETRY(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM),
	BOOLEAN(HanaDataTypeValueGroup.NUMBER, HanaDataTypeGroup.NOPARAM),
	/**
	 * Pseudocolumn, do not add to the table 
	 */
	IGNORE(HanaDataTypeValueGroup.STRING, HanaDataTypeGroup.NOPARAM);

	private HanaDataTypeValueGroup valuegroup;
	private HanaDataTypeGroup group;

	HanaDataType(HanaDataTypeValueGroup valuegroup, HanaDataTypeGroup group) {
		this.valuegroup = valuegroup;
		this.group = group;
	}

	public HanaDataTypeGroup getGroup() {
		return group;
	}

	public boolean isStringType() {
		return valuegroup == HanaDataTypeValueGroup.STRING;
	}
	
	public HanaDataTypeValueGroup getValueGroup() {
		return valuegroup;
	}
	
}
