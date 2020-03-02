package io.rtdi.hanaappcontainer.objects.table.subelements;

import java.util.List;

import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class ColumnDefinition {
	String name;
	HanaDataType sqlType;
	Boolean nullable;
	Boolean unique;
	Integer length;
	Integer scale;
	Integer precision;
	String defaultValue;
	String comment;
	
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
			throw new HanaSQLException("Unknown datatype, please file an issue", datatypename);
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
	public void validate(List<String> ret) throws HanaSQLException {
		if (name == null || name.length() == 0) {
			ret.add("Column has no name");
			throw new HanaSQLException("The columns has no name", "Check return information");
		}
		if (sqlType == null) {
			ret.add("Column \"" + name + "\" has no data type");
			throw new HanaSQLException("The column has no data type", "Check return information");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (!(o instanceof ColumnDefinition)) {
			return false;
		} else {
			ColumnDefinition c = (ColumnDefinition) o;
			if (c.name == null || name == null || !c.name.equals((name))) { // just a failsafe
				return false;
			} else if (!Util.sameOrNull(c.sqlType, sqlType)) {
				return false;
			} else if (!Util.sameOrNull(c.nullable, nullable)) {
				return false;
			} else if (!Util.sameOrNull(c.unique, unique)) {
				return false;
			} else if (!Util.sameOrNull(c.length, length)) {
				return false;
			} else if (!Util.sameOrNull(c.scale, scale)) {
				return false;
			} else if (!Util.sameOrNull(c.precision, precision)) {
				return false;
			} else if (!Util.sameOrNull(c.defaultValue, defaultValue)) {
				return false;
			} else if (!Util.sameOrNull(c.comment, comment)) {
				return false;
			} else {
				return true;
			}
		}
	}
	public String getColumnDefinition() throws HanaSQLException {
		StringBuffer b = new StringBuffer();
		b.append('"').append(name).append("\" ");
		b.append(Util.getDataTypeString(getSqlType(), getLength(), getPrecision(), getScale()));
		if (getNullable() != null && !getNullable().booleanValue()) {
			b.append(" not null");
		}
		if (getDefaultValue() != null) {
			if (getSqlType().isStringType()) {
				b.append(" default '").append(getDefaultValue()).append("'");
			} else {
				b.append(" default ").append(getDefaultValue());
			}
		}
		if (getComment() != null) {
			b.append(" comment '").append(getComment()).append("'");
		}
		return b.toString();
	}

	@Override
	public int hashCode() {
		if (name == null) {
			return 1;
		} else {
			return name.hashCode(); // name is unique enough for the hash buckets
		}
	}

}