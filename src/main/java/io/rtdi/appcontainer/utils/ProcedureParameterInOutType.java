package io.rtdi.appcontainer.utils;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public enum ProcedureParameterInOutType {
	IN(DatabaseMetaData.procedureColumnIn),
	OUT(DatabaseMetaData.procedureColumnOut),
	INOUT(DatabaseMetaData.procedureColumnInOut),
	RETURN(DatabaseMetaData.procedureColumnReturn);

	private int jdbccode;

	ProcedureParameterInOutType(int jdbccode) {
		this.jdbccode = jdbccode;
	}

	public int getJDBCCode() {
		return jdbccode;
	}

	public static ProcedureParameterInOutType value(short inouttype) throws SQLException {
		switch (inouttype) {
		case DatabaseMetaData.procedureColumnIn: return IN;
		case DatabaseMetaData.procedureColumnOut: return OUT;
		case DatabaseMetaData.procedureColumnInOut: return INOUT;
		case DatabaseMetaData.procedureColumnReturn: return RETURN;
		}
		throw new SQLException("Metdata code for procedure parameter not handled.");
	}
}
