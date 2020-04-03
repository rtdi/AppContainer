package io.rtdi.hanaappcontainer.objects.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.rtdi.hanaappcontainer.objects.HanaObjectWithColumns;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationStyle;
import io.rtdi.hanaappserver.ActivationSuccess;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class HanaTable extends HanaObjectWithColumns {
	private static final Object TRUE = "TRUE";

	TemporaryType temporary;
	TableType tableType;
	Boolean hasPublicSynonym;
	TableLoggingType loggingType;
	List<IndexDefinition> indexes;
	PrimaryKeyDefinition primaryKey;
	
	public HanaTable(String schemaname, String tablename) throws HanaSQLException {
		super(schemaname, tablename);
	}

	@Override
	public ActivationResult valid(ActivationResult result) throws HanaSQLException {
		super.valid(result);
		if (columns == null || columns.size() == 0) {
			result.addResult("Table has no columns defined", null, ActivationSuccess.FAILED, this);
			throw new HanaSQLException("The table \"" + getObjectName() + "\" has no columns defined", null);
		} else {
			for (ColumnDefinition c : columns) {
				c.validate(result);
			}
		}
		return result;
	}
	
	public String getTableName() {
		return getObjectName();
	}
	public TemporaryType getTemporary() {
		return temporary;
	}
	public void setTemporary(TemporaryType temporary) {
		this.temporary = temporary;
	}
	public TableType getTableType() {
		return tableType;
	}
	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}
	public Boolean getHasPublicSynonym() {
		return hasPublicSynonym;
	}
	public void setHasPublicSynonym(Boolean isPublic) {
		this.hasPublicSynonym = isPublic;
	}
	public TableLoggingType getLoggingType() {
		return loggingType;
	}
	public void setLoggingType(TableLoggingType loggingType) {
		this.loggingType = loggingType;
	}
	public List<IndexDefinition> getIndexes() {
		return indexes;
	}
	public void setIndexes(List<IndexDefinition> indexes) {
		this.indexes = indexes;
	}
	public PrimaryKeyDefinition getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(PrimaryKeyDefinition primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Override
	public String toString() {
		return "Table:" + getObjectName() + columns;
	}

	public void diff(HanaTableDiffAction action) throws HanaSQLException {
		HanaTable newtable = action.getObject();
		boolean needrecreate = !Util.sameOrNull(temporary, newtable.getTemporary());
		needrecreate |= !Util.sameOrNull(tableType, newtable.getTableType());
		needrecreate |= !Util.sameOrNull(loggingType, newtable.getLoggingType());
		try {
			if (needrecreate) {
				action.addCreationMessage(
						"Table has different settings for either temporary, tabletype or logging and needs to be recreated from scratch hence", 
						null, ActivationSuccess.WARNING);
				action.dropTable();
				action.createTable();
			} else {
				if (!Util.sameOrNull(hasPublicSynonym, newtable.getHasPublicSynonym())) {
					if (newtable.getHasPublicSynonym()) {
						action.createSynonym();
					} else {
						action.dropSynonym();
					}
				} else {
					action.addCreationMessage("No change in public synonym setting", null, ActivationSuccess.SUCCESS);
				}
				if (!Util.sameOrNull(getDescription(), newtable.getDescription())) {
					action.setTableComment();
				} else {
					action.addCreationMessage("No change in the table comment", null, ActivationSuccess.SUCCESS);
				}
				if (primaryKey == null && newtable.getPrimaryKey() == null) {
					// No PK in existing table and none in the new table
				} else if (primaryKey == null) {
					// newly created PK
					action.createPK();
				} else if (newtable.getPrimaryKey() == null) {
					// there was a PK but is no longer
					action.dropPK();
				} else {
					primaryKey.diff(newtable.getPrimaryKey(), action);
				}
				if (indexes == null && newtable.getIndexes() == null) {
				} else if (indexes == null) {
					createIndexes(newtable.getIndexes(), action);
				} else if (newtable.getIndexes() == null) {
					dropIndexes(indexes, action);
				} else {
					Set<IndexDefinition> iremove = new HashSet<>(indexes);
					iremove.removeAll(new HashSet<>(newtable.getIndexes()));
					Set<IndexDefinition> iadd = new HashSet<>(newtable.getIndexes());
					iadd.removeAll(new HashSet<>(indexes));
					if (iadd.size() == 0 && iremove.size() == 0) {
						action.addCreationMessage("No change in the table index definitions", null, ActivationSuccess.SUCCESS);
					} else {
						dropIndexes(iremove, action);
						createIndexes(iadd, action);
					}
				}
				if (!(columns == null && newtable.getColumns() == null)) {
					Map<String, ColumnDefinition> cl = getAsMap(columns, false);
					Map<String, ColumnDefinition> cr = getAsMap(newtable.getColumns(), false);
	
					Set<ColumnDefinition> newcolumns = new HashSet<>();
	
					Set<ColumnDefinition> changedcolumns = new HashSet<>();
					for (String columnname : cr.keySet()) {
						ColumnDefinition dl = cl.get(columnname);
						ColumnDefinition dr = cr.get(columnname);
						if (dl == null) {
							newcolumns.add(dr);
						} else if (!dr.equals(dl)) {
							changedcolumns.add(dr);
						}
					}
					
					Set<String> dropcolumns = new HashSet<>(cl.keySet());
					dropcolumns.removeAll(cr.keySet());
					
					action.addColumns(newcolumns);
					action.dropColumns(dropcolumns);
					action.modifyColumns(changedcolumns);
				}
			}
		} catch (HanaSQLException e) {
			action.addCreationMessage(e.toString(), e.getSQLStatement(), ActivationSuccess.FAILED);
			throw e;
		}
	}
	
	private void createIndexes(Collection<IndexDefinition> indexes, HanaTableDiffAction action) throws HanaSQLException {
		for (IndexDefinition add : indexes) {
			action.createIndex(add);
		}
	}

	private void dropIndexes(Collection<IndexDefinition> indexes, HanaTableDiffAction action) throws HanaSQLException {
		for (IndexDefinition add : indexes) {
			action.dropIndex(add);
		}
	}

	@Override
	public ActivationResult activate(ActivationResult result, Connection conn, ActivationStyle activation) throws HanaSQLException {
		try {
			String tablename = getTableName();
			HanaTableDiffAction action = new HanaTableDiffAction(conn, this, activation, result);
			HanaTable currenttable = createDefinitionFromDatabase(conn, getSchemaName(), tablename);
			if (currenttable == null) {
				action.createTable();
			} else {
				action.addCreationMessage("Table exists already, applying changes if needed", null, ActivationSuccess.SUCCESS);
				currenttable.diff(action);
			}
			return result; 
		} catch (HanaSQLException e) {
			result.addResult(e.toString(), e.getSQLStatement(), ActivationSuccess.FAILED, this);
			throw e;
		}
	}

	public static HanaTable createDefinitionFromDatabase(Connection conn, String schemaname, String tablename) throws HanaSQLException {
		String sql = "select t.comments, t.is_logged, t.table_type, t.temporary_table_type, "
				+ "t.partition_spec, t.is_preload, t.is_series_table, t.unload_priority, t.temporal_type, s.synonym_name "
				+ "from tables t "
				+ "left outer join synonyms s "
				+ "on (s.schema_name = 'PUBLIC' and s.object_schema = t.schema_name and s.object_name = t.table_name) "
				+ "where t.schema_name = ? and t.table_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaname);
			stmt.setString(2, tablename);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					HanaTable table = new HanaTable(schemaname, tablename);
					table.setDescription(rs.getString(1));
					table.setLoggingType(TRUE.equals(rs.getString(2))?TableLoggingType.LOGGING:TableLoggingType.NOLOGGING);
					table.setTableType("COLUMN".equals(rs.getString(3))?TableType.COLUMN:TableType.ROW);
					table.setTemporary("GLOBAL".equals(rs.getString(4))?TemporaryType.GLOBALTEMPORARY:null);
					table.setHasPublicSynonym(tablename.equals(rs.getString(10))); // When there is a public synonym of same name, then its public property is set to true
					
					sql = "select position, column_name, data_type_name, length, scale, is_nullable, default_value, "
							+ "comments, preload, generated_always_as, is_masked, mask_expression "
							+ "from table_columns "
							+ "where schema_name = ? and table_name = ? order by position";
					try (PreparedStatement stmtcol = conn.prepareStatement(sql);) {
						stmtcol.setString(1, schemaname);
						stmtcol.setString(2, tablename);
						ArrayList<ColumnDefinition> cols = new ArrayList<>();
						try (ResultSet rscol = stmtcol.executeQuery();) {
							while (rscol.next()) {
								ColumnDefinition coldef = new ColumnDefinition();
								coldef.setName(rscol.getString(2));
								coldef.setDataType(rscol.getString(3), rscol.getInt(4), rscol.getInt(5), TRUE.equals(rscol.getString(6)));
								coldef.setDefaultValue(rscol.getString(7));
								coldef.setComment(rscol.getString(8));
								cols.add(coldef);
							}
						}
						table.setColumns(cols);
					}

					sql = "select index_name, index_type, constraint from indexes where schema_name = ? and table_name = ?";
					try (PreparedStatement stmtcol = conn.prepareStatement(sql);) {
						stmtcol.setString(1, schemaname);
						stmtcol.setString(2, tablename);
						ArrayList<IndexDefinition> indexes = new ArrayList<>();
						try (ResultSet rsidx = stmtcol.executeQuery();) {
							while (rsidx.next()) {
								String indexname = rsidx.getString(1);
								List<String> indexcolumns = new ArrayList<>();
								sql = "select position, column_name, ascending_order from index_columns where schema_name = ? and index_name = ? order by position";
								try (PreparedStatement stmtidxcol = conn.prepareStatement(sql);) {
									stmtidxcol.setString(1, schemaname);
									stmtidxcol.setString(2, indexname);
									try (ResultSet rsidxcols = stmtidxcol.executeQuery();) {
										while (rsidxcols.next()) {
											indexcolumns.add(rsidxcols.getString(2));
										}
									}
								}
								if ("PRIMARY KEY".equals(rsidx.getString(3))) {
									PrimaryKeyDefinition pkdef = new PrimaryKeyDefinition();
									pkdef.setPkcolumns(indexcolumns);
									table.setPrimaryKey(pkdef);
								} else {
									IndexDefinition idxdef = new IndexDefinition();
									idxdef.setName(indexname);
									idxdef.setUnique("NOT NULL UNIQUE".equals(rsidx.getString(3)) || "UNIQUE".equals(rsidx.getString(3)));
									idxdef.setIndexColumns(indexcolumns);
									indexes.add(idxdef);
								}
							}
						}
						table.setIndexes(indexes);
					}

					return table;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Please file an issue");
		}
	}

	public static Map<String, ColumnDefinition> getAsMap(List<ColumnDefinition> columns, boolean withignored) {
		Map<String, ColumnDefinition> colmap = new HashMap<>();
		for (ColumnDefinition c : columns) {
			if (c.getSqlType() != HanaDataType.IGNORE || withignored) {
				colmap.put(c.getName(), c);
			}
		}
		return colmap;
	}

	public void addPrimaryKey(String columnname) {
		if (primaryKey == null) {
			primaryKey = new PrimaryKeyDefinition();
		}
		if (primaryKey.getPkcolumns() == null) {
			primaryKey.setPkcolumns(new ArrayList<>());
		}
		primaryKey.getPkcolumns().add(columnname);
	}
}