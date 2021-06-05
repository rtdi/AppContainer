package io.rtdi.appcontainer.utils;

import java.sql.JDBCType;

public class ProcedureParameter {

	private String parametername;
	private String datatypename;
	private ProcedureParameterInOutType inouttype;
	private int index;
	private JDBCType jdbcdatatype;

	public ProcedureParameter(int index, String parametername, JDBCType dt, String datatypename, ProcedureParameterInOutType inouttype) {
		this.parametername = parametername;
		this.datatypename = datatypename;
		this.inouttype = inouttype;
		this.index = index;
		this.jdbcdatatype = dt;
	}

	public String getParametername() {
		return parametername;
	}

	public String getDatatypename() {
		return datatypename;
	}

	public ProcedureParameterInOutType getInouttype() {
		return inouttype;
	}

	public int getIndex() {
		return index;
	}

	public JDBCType getJDBCDataType() {
		return jdbcdatatype;
	}
}