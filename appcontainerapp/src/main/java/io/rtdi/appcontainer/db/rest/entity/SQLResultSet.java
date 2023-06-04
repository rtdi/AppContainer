package io.rtdi.appcontainer.db.rest.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SQLResultSet {
	private int columncount;
	private boolean hasmoredata = false;
	private List<ObjectNode> rows;
	private List<SQLColumnMetadata> columns;
	private int rowcount;
	private static final DateFormat timeformatter = new SimpleDateFormat("HH:mm:ss");
	private static final DateTimeFormatter timestampformatter = DateTimeFormatter.ISO_INSTANT;
	private String name;

	
	public void addColumnMetadata(ResultSet rs) throws SQLException {
		columncount = rs.getMetaData().getColumnCount();
		columns = new ArrayList<>();
		for (int i=1; i<=rs.getMetaData().getColumnCount(); i++) {
			columns.add(new SQLColumnMetadata(rs.getMetaData(), i));
		}
	}
	
	public SQLResultSet(ResultSet rs, String name) throws SQLException {
		super();
		ObjectMapper om = new ObjectMapper();
		addColumnMetadata(rs);
		this.name = name;
		rowcount = 0;
		rows = new ArrayList<>();
		while (rs.next()) {
			ObjectNode row = om.createObjectNode();
			for (int i = 1; i <= columncount; i++) {
				setRestObject(rs, i, row);
			}
			rows.add(row);
			rowcount++;
			if (rowcount > 10000) {
				hasmoredata = true;
				break;
			}
		}
	}

	public static void setRestObject(ResultSet rs, int i, ObjectNode row) throws SQLException {
		Object value = rs.getObject(i);
		if (value == null) {
			// null values are not added
		} else if (value instanceof CharSequence) {
			row.put(rs.getMetaData().getColumnName(i), ((CharSequence) value).toString());
		} else if (value instanceof Integer) {
			row.put(rs.getMetaData().getColumnName(i), (Integer) value);
		} else if (value instanceof Long) {
			row.put(rs.getMetaData().getColumnName(i), (Long) value);
		} else if (value instanceof Byte) {
			row.put(rs.getMetaData().getColumnName(i), (Byte) value);
		} else if (value instanceof Short) {
			row.put(rs.getMetaData().getColumnName(i), (Short) value);
		} else if (value instanceof BigInteger) {
			row.put(rs.getMetaData().getColumnName(i), (BigInteger) value);
		} else if (value instanceof BigDecimal) {
			row.put(rs.getMetaData().getColumnName(i), (BigDecimal) value);
		} else if (value instanceof Date) {
			row.put(rs.getMetaData().getColumnName(i), ((Date) value).toString());
		} else if (value instanceof Time) {
			row.put(rs.getMetaData().getColumnName(i), timeformatter.format((Time) value));
		} else if (value instanceof Timestamp) {
			row.put(rs.getMetaData().getColumnName(i), timestampformatter.format(((Timestamp) value).toInstant()));
		}
	}

	public static Object getJsonValue(ResultSet rs, int i) throws SQLException {
		Object value = rs.getObject(i);
		if (value == null) {
			return null;
		} else if (value instanceof CharSequence) {
			return ((CharSequence) value).toString();
		} else if (value instanceof Integer) {
			return (Integer) value;
		} else if (value instanceof Long) {
			return (Long) value;
		} else if (value instanceof Byte) {
			return (Byte) value;
		} else if (value instanceof Short) {
			return (Short) value;
		} else if (value instanceof BigInteger) {
			return (BigInteger) value;
		} else if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		} else if (value instanceof Date) {
			return ((Date) value).toString();
		} else if (value instanceof Time) {
			return timeformatter.format((Time) value);
		} else if (value instanceof Timestamp) {
			return timestampformatter.format(((Timestamp) value).toInstant());
		} else {
			return null;
		}
	}

	public int getColumncount() {
		return columncount;
	}

	public boolean isHasmoredata() {
		return hasmoredata;
	}

	public List<ObjectNode> getRows() {
		return rows;
	}

	public List<SQLColumnMetadata> getColumns() {
		return columns;
	}

	public int getRowcount() {
		return rowcount;
	}

	public String getName() {
		return name;
	}

}

