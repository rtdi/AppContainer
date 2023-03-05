package io.rtdi.appcontainer.plugins.databasehana;

import java.nio.ByteBuffer;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import io.rtdi.appcontainer.plugins.activation.CSVImport;

public class HanaCSVImport extends CSVImport {

	@Override
	public StringBuilder getUpsertStatement(String owner, String tablename, StringBuilder columnlist, StringBuilder paramlist, DatabaseMetaData databaseMetaData) {
		StringBuilder sqlinsert = new StringBuilder();
		sqlinsert.append("upsert ")
			.append("\"")
			.append(owner)
			.append("\".\"")
			.append(tablename)
			.append("\" (")
			.append(columnlist)
			.append(") values (")
			.append(paramlist)
			.append(") WITH PRIMARY KEY");
		return sqlinsert;
	}
	
	@Override
	public boolean supportsBigInt() {
		return false;
	}

	@Override
	public void setColumnValue(PreparedStatement stmt, int pos, Object value) throws SQLException {
		if (value instanceof ZonedDateTime) {
			ZonedDateTime dt = (ZonedDateTime) value;
			Timestamp ts = Timestamp.from(dt.toInstant());
			stmt.setTimestamp(pos, ts);
		} else if (value instanceof LocalTime) {
			Time t = Time.valueOf((LocalTime) value);
			stmt.setTime(pos, t);
		} else if (value instanceof LocalDate) {
			Date d = Date.valueOf((LocalDate) value);
			stmt.setDate(pos, d);
		} else if (value instanceof ByteBuffer) {
			stmt.setBytes(pos, ((ByteBuffer) value).array());
		} else {
			super.setColumnValue(stmt, pos, value);
		}
	}

}
