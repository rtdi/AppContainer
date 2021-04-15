package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Describe {

	public static List<ColumnDefinition> getObjectColumns(Connection conn, String schemaname, String objectname) throws HanaSQLException {
		String sql = "select column_name, data_type_name, length, scale, comments, is_primary_key from (" +
				"select column_name, data_type_name, length, scale, comments, position, null as is_primary_key from view_columns \r\n" + 
				"where schema_name = ? and view_name = ? \r\n" + 
				"union all \r\n" +
				"select t.column_name, t.data_type_name, t.length, t.scale, t.comments, t.position, p.is_primary_key " +
				"from table_columns t\r\n" + 
				"left join constraints p on " +
				"  (p.schema_name = t.schema_name and p.table_name = t.table_name and p.column_name = t.column_name and p.is_primary_key = 'TRUE') " +
				"where t.schema_name = ? and t.table_name = ? \r\n" + 
				") order by position";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaname);
			stmt.setString(2, objectname);
			stmt.setString(3, schemaname);
			stmt.setString(4, objectname);
			try (ResultSet rs = stmt.executeQuery(); ) {
				List<ColumnDefinition> columns = new ArrayList<>();
				while (rs.next()) {
					String columnname = rs.getString(1);
					ColumnDefinition col = new ColumnDefinition(columnname);
					col.setDataType(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					columns.add(col);
				}
				return columns;
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Tried to read the object definition");
		}
	}

	public static List<ColumnDefinition> getTableColumns(Connection conn, String schemaname, String objectname) throws HanaSQLException {
		String sql = "select t.column_name, t.data_type_name, t.length, t.scale, t.comments, t.position, p.is_primary_key " +
				"from table_columns t\r\n" + 
				"left join constraints p on " +
				"  (p.schema_name = t.schema_name and p.table_name = t.table_name and p.column_name = t.column_name and p.is_primary_key = 'TRUE') " +
				"where t.schema_name = ? and t.table_name = ? \r\n" + 
				"order by t.position";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaname);
			stmt.setString(2, objectname);
			try (ResultSet rs = stmt.executeQuery(); ) {
				List<ColumnDefinition> columns = new ArrayList<>();
				while (rs.next()) {
					String columnname = rs.getString(1);
					ColumnDefinition col = new ColumnDefinition(columnname);
					col.setDataType(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					columns.add(col);
				}
				return columns;
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Tried to read the table definition");
		}
	}

	public static List<ColumnDefinition> getViewColumns(Connection conn, String schemaname, String objectname) throws HanaSQLException {
		String sql = "select column_name, data_type_name, length, scale, comments, position, null as is_primary_key from view_columns \r\n" + 
				"where schema_name = ? and view_name = ? \r\n" + 
				"order by position";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaname);
			stmt.setString(2, objectname);
			try (ResultSet rs = stmt.executeQuery(); ) {
				List<ColumnDefinition> columns = new ArrayList<>();
				while (rs.next()) {
					String columnname = rs.getString(1);
					ColumnDefinition col = new ColumnDefinition(columnname);
					col.setDataType(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					columns.add(col);
				}
				return columns;
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Tried to read the view definition");
		}
	}

	public static class ColumnDefinition {

		private String columnname;
		private String datatypename;
		private int length;
		private int scale;
		private String comment;
		private boolean iskey;
		private HanaDataType datatype;

		public ColumnDefinition(String columnname) {
			this.columnname = columnname;
		}

		public void setDataType(String datatypename, int length, int scale, String comment, String iskey) {
			this.datatypename = datatypename;
			this.length = length;
			this.scale = scale;
			this.comment = comment;
			this.iskey = (iskey != null);
			this.datatype = HanaDataType.valueOf(datatypename);
		}

		public String getColumnname() {
			return columnname;
		}

		public String getDatatypename() {
			return datatypename;
		}

		public int getLength() {
			return length;
		}

		public int getScale() {
			return scale;
		}

		public String getComment() {
			return comment;
		}

		public boolean isKey() {
			return iskey;
		}

		public HanaDataType getDatatype() {
			return datatype;
		}
		
	}
}
