package io.rtdi.appcontainer.dbactivationbase;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * When reading CSV files, writing CSV files, reading database tables,... different object types might be used, e.g.
 * BigInteger or Long, java.sql.Timestamp vs ZonedDateTime. And then they cannot be compared.
 * THese functions here helps to convert the objects into the correct class. 
 *
 */
public class JDBCDataTypeConversion {
	
	public JDBCDataTypeConversion() {
	}
	
	public void setTIMESTAMP_WITH_TIMEZONEFormatter(DateTimeFormatter df) {
	}

	/**
	 * Convert the value into a string based on the JDBCType
	 * @param value
	 * @param type
	 * @return
	 */
	public String convertJDBCToCSV(Object value, JDBCType type) {
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
			return "\"" + Base64.getEncoder().encodeToString((byte[]) value) + "\"";
		case BOOLEAN:
		case BIT:
		case ROWID:
			return value.toString();
		case DATE: {
			Date d = (Date) value;
			return "\"" + d.toLocalDate().toString() + "\"";
		}
		case TIME: {
			Time t = (Time) value;
			return "\"" + t.toLocalTime().toString() + "\"";
		}
		case TIMESTAMP: {
			Timestamp ts = (Timestamp) value;
			return "\"" + ts.toInstant().toString() + "\"";
		}
		case TIMESTAMP_WITH_TIMEZONE: {
			ZonedDateTime zoned = ZonedDateTime.parse(value.toString());
			return "\"" + zoned.toString() + "\"";
		}
		case TIME_WITH_TIMEZONE: {
			return "\"" + value.toString() + "\"";
		}
		default:
			return "\"" + value.toString() + "\"";
		}
	}

	/**
	 * Convert the JDBC driver returned object of the getObject() method into the generic object
	 * @param value
	 * @param type
	 * @return
	 */
	public Object convertJDBCtoJava(Object value, JDBCType type) {
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
		case ROWID:
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
			return ZonedDateTime.parse(value.toString());
		}
		case TIME_WITH_TIMEZONE: {
			return value.toString();
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
	public Object convertJsonNodeJDBC(JsonNode value, JDBCType type) {
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
		case ROWID:
			return value.asText();
		case BIGINT:
			return value.asLong();
		case DECIMAL:
		case DOUBLE:
		case FLOAT:
		case NUMERIC:
		case REAL:
			return value.asDouble();
		case INTEGER:
		case SMALLINT:
		case TINYINT:
			return value.asInt();
		case BINARY:
		case BLOB:
		case LONGVARBINARY:
		case VARBINARY:
			try {
				return value.binaryValue();
			} catch (IOException e1) {
				return value.asText();
			}
		case BOOLEAN:
		case BIT:
			return value;
		case DATE: {
			String datestring = value.asText();
			try {
				return Date.valueOf(datestring);
			} catch (IllegalArgumentException e) {
				return datestring;
			}
		}
		case TIME: {
			String timestring = value.asText();
			try {
				return Time.valueOf(timestring);
			} catch (IllegalArgumentException e) {
				return timestring;
			}
		}
		case TIMESTAMP: {
			String timestampstring = value.asText();
			try {
				LocalDateTime date = LocalDateTime.parse(timestampstring);
				return Timestamp.valueOf(date);
			} catch (IllegalArgumentException e) {
				return timestampstring;
			}
		}
		case TIMESTAMP_WITH_TIMEZONE: {
			String timestampstring = value.asText();
			try {
				ZonedDateTime date = ZonedDateTime.parse(timestampstring);
				return Timestamp.from(date.toInstant());
			} catch (IllegalArgumentException e) {
				return timestampstring;
			}
		}
		case TIME_WITH_TIMEZONE: {
			String timestring = value.asText();
			try {
				return Time.valueOf(timestring);
			} catch (IllegalArgumentException e) {
				return timestring;
			}
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
	public JsonNode convertJDBCToJsonNode(Object value, JDBCType type) {
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			return JsonNodeFactory.instance.textNode((String) value);
		} else if (value instanceof BigInteger) {
			return JsonNodeFactory.instance.numberNode((BigInteger) value);
		} else if (value instanceof Integer) {
			return JsonNodeFactory.instance.numberNode((Integer) value);
		} else if (value instanceof Long) {
			return JsonNodeFactory.instance.numberNode((Long) value);
		} else if (value instanceof Short) {
			return JsonNodeFactory.instance.numberNode((Short) value);
		} else if (value instanceof Byte) {
			return JsonNodeFactory.instance.numberNode((Byte) value);
		} else if (value instanceof Double) {
			return JsonNodeFactory.instance.numberNode((Double) value);
		} else if (value instanceof Float) {
			return JsonNodeFactory.instance.numberNode((Float) value);
		} else if (value instanceof Date) {
			return JsonNodeFactory.instance.textNode(((Date) value).toLocalDate().toString());
		} else if (value instanceof Time) {
			return JsonNodeFactory.instance.textNode(((Time) value).toString());
		} else if (value instanceof Timestamp) {
			return JsonNodeFactory.instance.textNode(((Timestamp) value).toInstant().toString());
		} else if (value instanceof byte[]) {
			return JsonNodeFactory.instance.binaryNode((byte[]) value);
		} else {
			return JsonNodeFactory.instance.textNode(value.toString());
		}
	}


}
