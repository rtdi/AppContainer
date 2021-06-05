package io.rtdi.appcontainer.utils.hana;

import java.sql.JDBCType;
import java.util.List;

import io.rtdi.appcontainer.utils.ProcedureParameter;
import io.rtdi.appcontainer.utils.ProcedureParameterInOutType;

public class TableParameterMetadata extends ProcedureParameter {

	private String createtablestring;
	private String insertsqlstring;
	private List<String> columnindex;
	private String parametername;
	private String datatypename;
	private ProcedureParameterInOutType inouttype;

	public TableParameterMetadata(int index, String parametername, String datatypename, ProcedureParameterInOutType inouttype) {
		super(index, parametername, JDBCType.STRUCT, datatypename, inouttype);
	}

	public void setCreateTableSQL(String string) {
		this.createtablestring = string;
	}

	public List<String> getColumnIndex() {
		return columnindex;
	}

	public void setColumnIndex(List<String> columnindex) {
		this.columnindex = columnindex;
	}

	public String getInsertSQL() {
		return insertsqlstring;
	}

	public void setInsertSQL(String insertsql) {
		this.insertsqlstring = insertsql;
	}

	public String getCreateTableSQL() {
		return createtablestring;
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
}