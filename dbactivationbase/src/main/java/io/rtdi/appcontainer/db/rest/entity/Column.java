package io.rtdi.appcontainer.db.rest.entity;

public class Column {
	private String name;
	private String datatype;
	private Boolean notnull;
	private int position;
	private Integer pkindex;
	private String comment;
	private Integer precision;
	private Integer length;
	
	public Column() {
		super();
	}
	
	public Column(String name, String datatype, Integer length, Integer precision, Boolean notnull, int position, String comment) {
		this.name = name;
		this.datatype = datatype;
		this.notnull = notnull;
		this.position = position;
		this.comment = comment;
		this.length = length;
		this.precision = precision;
	}

	public String getName() {
		return name;
	}

	public String getDatatype() {
		return datatype;
	}

	public Boolean getNotnull() {
		return notnull;
	}

	public int getPosition() {
		return position;
	}

	public Integer getPkindex() {
		return pkindex;
	}
	
	public void setPkindex(Integer pos) {
		this.pkindex = pos;
	}

	public String getComment() {
		return comment;
	}

	public Integer getPrecision() {
		return precision;
	}

	public Integer getLength() {
		return length;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public void setNotnull(Boolean notnull) {
		this.notnull = notnull;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}