package io.rtdi.appcontainer.plugins.databasesqlserver;

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

public class SqlserverCSVImport extends CSVImport {

	@Override
	public StringBuilder getUpsertStatement(String owner, String tablename, StringBuilder columnlist, StringBuilder paramlist, DatabaseMetaData databaseMetaData) {
		/*
			MERGE INTO Sales.SalesReason AS tgt  
			USING (VALUES ('Recommendation','Other'), ('Review', 'Marketing'),
			              ('Internet', 'Promotion'))  
			       as src (NewName, NewReasonType)  
			ON tgt.Name = src.NewName  
			WHEN MATCHED THEN  
			UPDATE SET ReasonType = src.NewReasonType  
			WHEN NOT MATCHED BY TARGET THEN  
			INSERT (Name, ReasonType) VALUES (NewName, NewReasonType)  
			OUTPUT $action INTO @SummaryOfChanges;  
		 */
		// TODO: Implement
		/* StringBuilder out = new StringBuilder();
		out.append("merge into [").append(owner).append("].[").append(tablename).append("] as t ");
		out.append("using (values (").append(paramlist).append(")) as s (").append(columnlist).append(") ");
		out.append("on "); */
		return null;
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
