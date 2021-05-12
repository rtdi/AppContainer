package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Describe {

	public static List<ColumnDefinition> getObjectColumns(Connection conn, String schemaname, String objectname) throws AppContainerSQLException {
		try (ResultSet rs1 = conn.getMetaData().getColumns(null, schemaname, objectname, null);
				ResultSet rs2 = conn.getMetaData().getPrimaryKeys(null, schemaname, objectname); ) {
			Set<String> pk = new HashSet<>();
			while (rs2.next()) {
				pk.add(rs2.getString(4));
			}
			
			/*
				1.TABLE_CAT String => table catalog (may be null) 
				2.TABLE_SCHEM String => table schema (may be null) 
				3.TABLE_NAME String => table name 
				4.COLUMN_NAME String => column name 
				5.DATA_TYPE int => SQL type from java.sql.Types 
				6.TYPE_NAME String => Data source dependent type name,for a UDT the type name is fully qualified 
				7.COLUMN_SIZE int => column size. 
				8.BUFFER_LENGTH is not used. 
				9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types whereDECIMAL_DIGITS is not applicable. 
				10.NUM_PREC_RADIX int => Radix (typically either 10 or 2) 
				11.NULLABLE int => is NULL allowed.
				12.REMARKS String => comment describing column (may be null) 
				13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null) 
				14.SQL_DATA_TYPE int => unused 
				15.SQL_DATETIME_SUB int => unused 
				16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column 
				17.ORDINAL_POSITION int => index of column in table(starting at 1) 
				18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
				19.SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF) 
				20.SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF) 
				21.SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF) 
				22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generatedRef type, SQL type from java.sql.Types (null if DATA_TYPEisn't DISTINCT or user-generated REF) 
				23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
				24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column
			 */
			List<ColumnDefinition> columns = new ArrayList<>();
			while (rs1.next()) {
				String columnname = rs1.getString(4);
				ColumnDefinition col = new ColumnDefinition(columnname);
				col.setDataType(rs1.getInt(5), rs1.getInt(7), rs1.getInt(9), rs1.getString(12), pk.contains(columnname));
				columns.add(col);
			}
			return columns;
		} catch (SQLException e) {
			throw new AppContainerSQLException(e, "describe table", "Tried to read the object definition");
		}
	}

	public static List<ColumnDefinition> getTableColumns(Connection conn, String schemaname, String objectname) throws AppContainerSQLException {
		return getObjectColumns(conn, schemaname, objectname);
	}

	public static List<ColumnDefinition> getViewColumns(Connection conn, String schemaname, String objectname) throws AppContainerSQLException {
		return getObjectColumns(conn, schemaname, objectname);
	}

	public static class ColumnDefinition {

		private String columnname;
		private int length;
		private int scale;
		private String comment;
		private boolean iskey;
		private JDBCType datatype;

		public ColumnDefinition(String columnname) {
			this.columnname = columnname;
		}

		public void setDataType(int datatype, int length, int scale, String comment, boolean iskey) {
			this.datatype = JDBCType.valueOf(datatype);
			this.length = length;
			this.scale = scale;
			this.comment = comment;
			this.iskey = iskey;
		}

		public String getColumnname() {
			return columnname;
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

		public JDBCType getDatatype() {
			return datatype;
		}
		
	}
}
