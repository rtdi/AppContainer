package io.rtdi.appcontainer.dbunittest.value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.appcontainer.JDBCDataTypeConversion;


public class TableRow {
	List<Object> rowdata = new ArrayList<>();

	public TableRow(ResultSet rs, TableValue container) throws SQLException {
		for (int i = 0; i < container.columns.size(); i++) {
			Object o = JDBCDataTypeConversion.convert(rs.getObject(i+1), container.columns.get(i).getColumnType());
			rowdata.add(o);
		}
	}

	public TableRow(Object[] row, TableValue container) {
		for (Object v : row) {
			rowdata.add(v);
		}
	}

	public Object getColumnValue(int index) {
		return rowdata.get(index);
	}

	@Override
	public String toString() {
		if (rowdata != null) {
			return rowdata.toString();
		} else {
			return "<no data>";
		}
	}
}