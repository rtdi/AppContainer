package io.rtdi.hanaappserver.utils;

public enum HanaDataType {
	TINYINT(false, HanaDataTypeGroup.NOPARAM),
	SMALLINT(false, HanaDataTypeGroup.NOPARAM),
	INTEGER(false, HanaDataTypeGroup.NOPARAM),
	BIGINT(false, HanaDataTypeGroup.NOPARAM),
	DECIMAL(false, HanaDataTypeGroup.DECIMALPARAM),
	REAL(false, HanaDataTypeGroup.NOPARAM),
	DOUBLE(false, HanaDataTypeGroup.NOPARAM),
	CHAR(true, HanaDataTypeGroup.LENGTHPARAM),
	VARCHAR(true, HanaDataTypeGroup.LENGTHPARAM),
	BINARY(true, HanaDataTypeGroup.LENGTHPARAM),
	VARBINARY(true, HanaDataTypeGroup.LENGTHPARAM),
	DATE(false, HanaDataTypeGroup.NOPARAM),
	TIME(false, HanaDataTypeGroup.NOPARAM),
	TIMESTAMP(false, HanaDataTypeGroup.NOPARAM),
	CLOB(true, HanaDataTypeGroup.NOPARAM),
	BLOB(false, HanaDataTypeGroup.NOPARAM),
	NCHAR(true, HanaDataTypeGroup.LENGTHPARAM),
	NVARCHAR(true, HanaDataTypeGroup.LENGTHPARAM),
	ALPHANUM(true, HanaDataTypeGroup.LENGTHPARAM),
	NCLOB(true, HanaDataTypeGroup.NOPARAM),
	SMALLDECIMAL(false, HanaDataTypeGroup.NOPARAM),
	TEXT(true, HanaDataTypeGroup.NOPARAM),
	BINTEXT(true, HanaDataTypeGroup.NOPARAM),
	SHORTTEXT(true, HanaDataTypeGroup.LENGTHPARAM),
	SECONDDATE(false, HanaDataTypeGroup.NOPARAM),
	ST_POINT(false, HanaDataTypeGroup.NOPARAM),
	ST_GEOMETRY(false, HanaDataTypeGroup.NOPARAM),
	BOOLEAN(false, HanaDataTypeGroup.NOPARAM),
	/**
	 * Pseudocolumn, do not add to the table 
	 */
	IGNORE(false, HanaDataTypeGroup.NOPARAM);

	private boolean stringtype;
	private HanaDataTypeGroup group;

	HanaDataType(boolean stringtype, HanaDataTypeGroup group) {
		this.stringtype = stringtype;
		this.group = group;
	}

	public HanaDataTypeGroup getGroup() {
		return group;
	}

	public boolean isStringType() {
		return stringtype;
	}
}
