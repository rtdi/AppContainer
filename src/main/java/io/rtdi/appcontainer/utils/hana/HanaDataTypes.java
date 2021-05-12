package io.rtdi.appcontainer.utils.hana;

import io.rtdi.appcontainer.utils.AppContainerSQLException;

public class HanaDataTypes {

	public static String getDataTypeString(String datatypename, Integer length, Integer scale) throws AppContainerSQLException {
		return getDataTypeString(datatypename, length, length, scale);
	}
	
	public static String getDataTypeString(String datatypename, Integer length, Integer precision, Integer scale) throws AppContainerSQLException {
		switch (datatypename) {
		case "TINYINT":
		case "SMALLINT":
		case "INTEGER":
		case "BIGINT":
		case "REAL":
		case "DOUBLE":
		case "DATE":
		case "TIME":
		case "TIMESTAMP":
		case "CLOB":
		case "BLOB":
		case "NCLOB":
		case "SMALLDECIMAL":
		case "TEXT":
		case "BINTEXT":
		case "SECONDDATE":
		case "ST_POINT":
		case "ST_GEOMETRY":
		case "BOOLEAN":
			return datatypename;
		case "CHAR":
		case "VARCHAR":
		case "BINARY":
		case "VARBINARY":
		case "NCHAR":
		case "NVARCHAR":
		case "ALPHANUM":
		case "SHORTTEXT":
			if (length == null || length.intValue() == 0) {
				throw new AppContainerSQLException("The datatype needs a length information", datatypename);
			}
			return datatypename + " (" + String.valueOf(length) + ")";
		case "DECIMAL":
			if (precision == null || precision.intValue() == 0) {
				if (length == null || length.intValue() == 0) {
					throw new AppContainerSQLException("The datatype needs a length/precision information", datatypename);
				}
				precision = length;
			}
			if (scale == null) {
				scale = 0;
			}
			return datatypename + " (" + String.valueOf(precision) + "," + String.valueOf(scale) + ")";
		default:
			throw new AppContainerSQLException("The datatype is not known", datatypename);
		}
	}

}
