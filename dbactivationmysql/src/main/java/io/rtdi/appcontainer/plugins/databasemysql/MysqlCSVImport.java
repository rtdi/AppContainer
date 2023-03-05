package io.rtdi.appcontainer.plugins.databasemysql;

import java.nio.ByteBuffer;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import io.rtdi.appcontainer.plugins.activation.CSVImport;

public class MysqlCSVImport extends CSVImport {

	@Override
	public StringBuilder getUpsertStatement(String owner, String tablename, StringBuilder columnlist, StringBuilder paramlist, DatabaseMetaData databaseMetaData) {
		/*
		 * Snowflake supports a merge statement but not for individual records. Better to use the fallback of delete-insert.
		 */
		return null;
	}
	
	@Override
	public boolean supportsBigInt() {
		return false;
	}

	@Override
	public void setColumnValue(PreparedStatement stmt, int pos, Object value) throws SQLException {
		/*
		 * Snowflake is very bad at the setObject() support at the moment.
		 * https://github.com/snowflakedb/snowflake-jdbc/blob/27788f0c931fbe88bd0587aad10b1f7ba5dc2e5c/src/main/java/net/snowflake/client/jdbc/SnowflakePreparedStatementV1.java#L398
		 */
		if (value instanceof ZonedDateTime) {
			ZonedDateTime dt = (ZonedDateTime) value;
			Timestamp ts = Timestamp.from(dt.toInstant());
			stmt.setTimestamp(pos, ts);
		} else if (value instanceof Instant) {
			Instant dt = (Instant) value;
			Timestamp ts = Timestamp.from(dt);
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
