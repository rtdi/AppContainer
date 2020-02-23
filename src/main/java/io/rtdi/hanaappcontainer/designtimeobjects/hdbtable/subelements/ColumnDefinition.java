package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements;

import java.io.IOException;
import java.io.Writer;

import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ColumnDefinition {
	/*
		struct ColumnDefinition {
		    string name;
		    SqlDataType sqlType;
		    optional bool nullable;
		    optional bool unique;
		    optional int32 length;
		    optional int32 scale;
		    optional int32 precision;
		    optional string defaultValue;
		    optional string comment;
		};
	 */
	String name;
	HanaDataType sqlType;
	Boolean nullable;
	Boolean unique;
	Integer length;
	Integer scale;
	Integer precision;
	String defaultValue;
	String comment;
	
	public void write(Writer w) throws IOException {
		w.append("{name = \"").append(name).append("\";");
		w.append(" sqlType = \"").append(sqlType.toString()).append("\";");
		if (nullable != null) {
			w.append(" nullable = ").append(String.valueOf(nullable)).append(";");
		}
		if (length != null) {
			w.append(" length = ").append(String.valueOf(length)).append(";");
		}
		if (precision != null) {
			w.append(" precision = ").append(String.valueOf(precision)).append(";");
		}
		if (scale != null) {
			w.append(" scale = ").append(String.valueOf(scale)).append(";");
		}
		if (defaultValue != null) {
			w.append(" defaultValue = \"").append(defaultValue).append("\";");
		}
		if (comment != null) {
			w.append(" comment = \"").append(comment).append("\";");
		}
		w.append("}");
	}
	public String getName() {
		return name;
	}
	public void setDataType(String datatypename, int length, int scale, boolean nullable) throws HanaSQLException {
		sqlType = HanaDataType.valueOf(datatypename);
		switch (sqlType) {
		case BIGINT:
		case BINTEXT:
		case BLOB:
		case BOOLEAN:
		case CLOB:
		case DATE:
		case DOUBLE:
		case INTEGER:
		case NCLOB:
		case REAL:
		case SECONDDATE:
		case SMALLDECIMAL:
		case SMALLINT:
		case ST_GEOMETRY:
		case ST_POINT:
		case TEXT:
		case TIME:
		case TIMESTAMP:
		case TINYINT:
			this.length = null;
			this.scale = null;
			this.precision = null;
			break;
		case ALPHANUM:
		case BINARY:
		case CHAR:
		case NCHAR:
		case NVARCHAR:
		case SHORTTEXT:
		case VARBINARY:
		case VARCHAR:
			this.length = length;
			this.scale = null;
			this.precision = null;
			break;
		case DECIMAL:
			this.precision = length;
			this.scale = scale;
			this.length = null;
			break;
		default:
			throw new HanaSQLException("Unknown datatype", datatypename, 10005);
		}
		this.nullable = nullable;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HanaDataType getSqlType() {
		return sqlType;
	}
	public void setSqlType(HanaDataType sqlType) {
		this.sqlType = sqlType;
	}
	public Boolean getNullable() {
		return nullable;
	}
	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}
	public Boolean getUnique() {
		return unique;
	}
	public void setUnique(Boolean unique) {
		this.unique = unique;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getPrecision() {
		return precision;
	}
	public void setPrecision(Integer precision) {
		this.precision = precision;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return (name!=null?name:"unknown name") + " " + (sqlType != null?sqlType.name():"unknown datatype");
	}
}