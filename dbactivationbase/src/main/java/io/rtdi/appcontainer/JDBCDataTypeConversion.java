package io.rtdi.appcontainer;

import java.sql.Date;
import java.sql.JDBCType;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Base64;

/**
 * When reading CSV files, writing CSV files, reading database tables,... different object types might be used, e.g.
 * BigInteger or Long, java.sql.Timestamp vs ZonedDateTime. And then they cannot be compared.
 * THese functions here helps to convert the objects into the correct class. 
 *
 */
public class JDBCDataTypeConversion {

	/**
	 * Convert the value into a string based on the JDBCType
	 * @param value
	 * @param type
	 * @return
	 */
	public static String format(Object value, JDBCType type) {
		if (value == null) {
			return "";
		}
		switch (type) {
		case LONGNVARCHAR:
		case LONGVARCHAR:
		case CHAR:
		case CLOB:
		case NCHAR:
		case NCLOB:
		case NVARCHAR:
		case VARCHAR:
			return "\"" + value.toString().replace("\"", "\\\"") + "\"";
		case BIGINT:
		case DECIMAL:
		case DOUBLE:
		case FLOAT:
		case INTEGER:
		case NUMERIC:
		case REAL:
		case SMALLINT:
		case TINYINT:
			return value.toString();
		case BINARY:
		case BLOB:
		case LONGVARBINARY:
		case VARBINARY:
			return Base64.getEncoder().encodeToString((byte[]) value);
		case BOOLEAN:
		case BIT:
		case ROWID:
			return value.toString();
		case DATE: {
			Date d = (Date) value;
			return d.toLocalDate().toString();
		}
		case TIME: {
			Time t = (Time) value;
			return t.toLocalTime().toString();
		}
		case TIMESTAMP: {
			Timestamp ts = (Timestamp) value;
			return ts.toInstant().toString();
		}
		case TIMESTAMP_WITH_TIMEZONE: {
			Timestamp ts = (Timestamp) value;
			return ts.toString();
		}
		case TIME_WITH_TIMEZONE: {
			Time t = (Time) value;
			return t.toString();
		}
		default:
			return value.toString();
		}
	}

	/**
	 * Convert the JDBC driver returned object of the getObject() method into the generic object
	 * @param value
	 * @param type
	 * @return
	 */
	public static Object convert(Object value, JDBCType type) {
		if (value == null) {
			return null;
		}
		switch (type) {
		case LONGNVARCHAR:
		case LONGVARCHAR:
		case CHAR:
		case CLOB:
		case NCHAR:
		case NCLOB:
		case NVARCHAR:
		case VARCHAR:
			return value.toString();
		case BIGINT:
		case DECIMAL:
		case DOUBLE:
		case FLOAT:
		case INTEGER:
		case NUMERIC:
		case REAL:
		case SMALLINT:
		case TINYINT:
			return value;
		case BINARY:
		case BLOB:
		case LONGVARBINARY:
		case VARBINARY:
			return value;
		case BOOLEAN:
		case BIT:
		case ROWID:
			return value;
		case DATE: {
			Date d = (Date) value;
			return d.toLocalDate();
		}
		case TIME: {
			Time t = (Time) value;
			return t.toLocalTime();
		}
		case TIMESTAMP: {
			Timestamp ts = (Timestamp) value;
			return ts.toInstant();
		}
		case TIMESTAMP_WITH_TIMEZONE: {
			Timestamp ts = (Timestamp) value;
			return ts.toString();
		}
		case TIME_WITH_TIMEZONE: {
			Time t = (Time) value;
			return t.toString();
		}
		default:
			return value.toString();
		}
	}


}
