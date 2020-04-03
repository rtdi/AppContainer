package io.rtdi.hanaappcontainer.objects.table.subelements;

import java.util.Map;

import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationSuccess;
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
	private Map<String, ColumnDefinition> typecolumns;
	
	public String getName() {
		return name;
	}
	public void setDataType(String datatypename, int length, int scale, boolean nullable) throws HanaSQLException {
		sqlType = HanaDataType.valueOf(datatypename);
		switch (sqlType.getGroup()) {
		case DECIMALPARAM:
			this.precision = length;
			this.scale = scale;
			this.length = null;
			break;
		case LENGTHPARAM:
			this.length = length;
			this.scale = null;
			this.precision = null;
			break;
		case NOPARAM:
			this.length = null;
			this.scale = null;
			this.precision = null;
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
	public void validate(ActivationResult result) throws HanaSQLException {
		if (name == null || name.length() == 0) {
			result.addResult("Column has no name", null, ActivationSuccess.FAILED, result.getObject());
			throw new HanaSQLException("The column has no name", null);
		}
		if (sqlType == null) {
			result.addResult("Column \"" + name + "\" has no data type", null, ActivationSuccess.FAILED, result.getObject());
			throw new HanaSQLException("The column \"" + name + "\" has no data type", null);
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
		if (getSqlType() != null) {
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
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		if (name == null) {
			return 1;
		} else {
			return name.hashCode(); // name is unique enough for the hash buckets
		}
	}
	@Override
	public String toString() {
		return "Column [name=" + name + ", sqlType=" + sqlType + "]";
	}

	public void applyDataType(ColumnDefinition from) {
		sqlType = from.getSqlType();
		length = from.getLength();
		precision = from.getPrecision();
		scale = from.getScale();
	}
	/**
	 * One column might be a synonym of a set of columns, e.g. when the column has as data type a complex type
	 * 
	 * @param source a list of columns this column has created
	 */
	public void setTypeColumns(Map<String, ColumnDefinition> source) {
		this.typecolumns = source;
	}
	public Map<String, ColumnDefinition> getTypeColumns() {
		return typecolumns;
	}
	public void applyComment(ColumnDefinition t) {
		if (comment == null) {
			comment = t.getComment();
		}
	}
	
}