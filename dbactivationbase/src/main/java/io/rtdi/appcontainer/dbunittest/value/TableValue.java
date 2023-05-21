package io.rtdi.appcontainer.dbunittest.value;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.graalvm.polyglot.HostAccess;

import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

import java.util.Set;
import java.util.TreeMap;

public class TableValue {
	List<ColumnMetadata> columns = new ArrayList<>();
	Map<String, ColumnMetadata> columnnameindex = new HashMap<>();
	Set<TableRow> data = new HashSet<>();
	private IDatabaseProvider provider;

	public TableValue(ResultSet rs, IDatabaseProvider provider) throws SQLException {
		this.provider = provider;
		if (rs.next()) { // fetch the first row so we have metadata
			setMetadata(rs);
			addRow(rs);
			while (rs.next()) {
				addRow(rs);
			}
		}
	}

	public TableValue() {
		super();
	}

	private void addRow(ResultSet rs) throws SQLException {
		data.add(new TableRow(rs, this));
	}

	public void addRow(Object[] row) {
		data.add(new TableRow(row, this));
	}

	private void setMetadata(ResultSet rs) throws SQLException {
		ResultSetMetaData m = rs.getMetaData();
		for (int i = 0; i < m.getColumnCount(); i++) {
			ColumnMetadata c = new ColumnMetadata(m.getColumnName(i+1), i);
			c.setColumnDataType(m.getColumnType(i+1));
			c.setScale(m.getScale(i+1));
			c.setPrecision(m.getPrecision(i+1));
			columns.add(c);
			columnnameindex.put(c.getColumnName(), c);
		}
	}

	public ColumnMetadata getColumnMetadata(int i) {
		return columns.get(i);
	}
	
	public ColumnMetadata getColumnMetadata(String columnname) {
		return columnnameindex.get(columnname);
	}
	
	/**
	 * Two datasets are equal if they have the same number of rows and each row has an equivalent in the other dataset.
	 * If the datasets have different columns, only the shared columns are considered.
	 * The comparison is performed by
	 * - test for logical inconsistencies that proof the datasets cannot be equal
	 * - test if there are shared columns, else each row has a matching partner per definition
	 * - create an index of hash value of the considered columns and all rows with that hash value and remove all matched rows
	 */
	@Override
	@HostAccess.Export
	public boolean equals(Object o) {
		if (o == null) {
			return true;
		} else if (!(o instanceof TableValue)) {
			return false;
		} else {
			TableValue comp = (TableValue) o;
			if (data.size() != comp.data.size()) {
				return false;
			} else if (data.size() == 0) {
				return true;
			} else {
				// To save time, create a structure with the mapping, which column must be compared with what other column
				Map<Integer, Integer> columnmapping = new HashMap<>();
				for (int i = 0; i < columns.size(); i++) {
					ColumnMetadata c = comp.getColumnMetadata(getColumnMetadata(i).getColumnName());
					if (c != null) {
						columnmapping.put(i, c.getIndex());
					}
				}
				if (columnmapping.size() == 0) {
					return true; // There are no shared columns
				}

				// find common columns and calculate the overall hashcode - number overflow for it is fine
				Map<Long, List<TableRow>> hashleft = new TreeMap<>();
				Map<Long, List<TableRow>> hashright = new TreeMap<>();
				
				/*
				 * Fill a MultiValue Map with data left
				 */
				for (TableRow row : data) {
					long hashvalue = 0L;
					for (Integer i : columnmapping.keySet()) {
						Object value = row.getColumnValue(i);
						if (value != null) {
							hashvalue += value.hashCode();
						}
					}
					List<TableRow> e = hashleft.get(hashvalue);
					if (e == null) {
						e = new ArrayList<>();
						hashleft.put(hashvalue, e);
					}
					e.add(row);
				}
	
				/*
				 * Fill a MultiValue Map with data right
				 */
				for (TableRow row : comp.data) {
					long hashvalue = 0L;
					for (Integer i : columnmapping.values()) {
						Object value = row.getColumnValue(i);
						if (value != null) {
							hashvalue += value.hashCode();
						}
					}
					List<TableRow> e = hashright.get(hashvalue);
					if (e == null) {
						e = new ArrayList<>();
						hashright.put(hashvalue, e);
					}
					e.add(row);
				}
	
				if (!hashleft.keySet().equals(hashright.keySet())) {
					/*
					 * At least one row has different hash values
					 */
					return false;
				} else {
					/*
					 *  compare rows as one entry might be <1,2> the other <2, 1>. Both would have 
					 *  the same row hash value but are obviously not the same
					 */
					for (Long hashvalue : hashleft.keySet()) {
						List<TableRow> sl = hashleft.get(hashvalue);
						List<TableRow> sr = hashright.get(hashvalue);
						if (sr == null) {
							return false; // Right hand side does not have a row with that hash value. Cannot happen but...
						}
						for (TableRow rowleft : sl) {
							TableRow matchedrow = null;
							for (int i = 0; i < sr.size(); i++) {
								TableRow rowcandidate = sr.get(i);
								if (rowcandidate != null) {
									boolean isequal = true;
									for (Entry<Integer, Integer> mapping : columnmapping.entrySet()) {
										Object left = rowleft.getColumnValue(mapping.getKey());
										Object right = rowcandidate.getColumnValue(mapping.getValue());
										if (!columnValueCompare(left, right)) {
											isequal = false;
											break;
										}
									}
									if (isequal) {
										/*
										 *  A matching row was found, remove it so it cannot be used a second time.
										 *  Otherwise four rows dataset1=[col1: {0,0,0,0} ] would be equal to dataset2=[col1: {0,1,2,3} ]
										 */
										sr.set(i, null);
										matchedrow = rowcandidate;
										break;
									}
								}
							}
							if (matchedrow == null) {
								return false;
							}
						}
					}
					return true;
				}
			}
		}
	}
	
	public static boolean columnValueCompare(Object left, Object right) {
		if (left == null && right != null) {
			return false;
		} else if (left != null && right == null) {
			return false;
		} else if (left == null && right == null) {
			return true;
		} else {
			return left.equals(right);
		}
	}
	
	@Override
	@HostAccess.Export
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int c = 0; c < 5 && c < columns.size(); c++) {
			b.append("| ");
			pad(columns.get(c).getColumnName(), b);
		}
		b.append("|\r\n");
		if (data.size() > 0) {
			for (int c = 0; c < 5 && c < columns.size(); c++) {
				b.append("+-");
				b.append("---------------");
			}
			b.append("+\r\n");
			int  rowcount = 0;
			for (TableRow r : data) {
				for (int c = 0; c < 5 && c < columns.size(); c++) {
					b.append("| ");
					pad(r.getColumnValue(c), b);
				}
				b.append("|\r\n");
				rowcount++;
				if (rowcount > 5) {
					break;
				}
			}
		}
		return b.toString();
	}

	private void pad(Object objvalue, StringBuilder b) {
		int start = b.length();
		if (objvalue == null) {
			b.append("<null>");
		} else {
			String text = objvalue.toString();
			if (text.length() < 15) {
				b.append(text);
			} else {
				b.append(text.subSequence(0, 12));
				b.append("..");
			}
		}
		int end = start + 15;
		while (b.length() < end) {
			b.append(' ');
		}
	}

	public void addColumn(ColumnMetadata c) {
		columns.add(c);
		columnnameindex.put(c.getColumnName(), c);
	}

	public IDatabaseProvider getDatabaseProvider() {
		return provider;
	}
}
