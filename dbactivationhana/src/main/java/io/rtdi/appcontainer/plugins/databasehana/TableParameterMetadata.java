package io.rtdi.appcontainer.plugins.databasehana;

import java.sql.JDBCType;
import java.util.List;

import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameter;
import io.rtdi.appcontainer.plugins.database.entity.ProcedureParameterInOutType;

public class TableParameterMetadata extends ProcedureParameter {

	private String createtablestring;
	private String insertsqlstring;
	private List<String> columnindex;

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

}