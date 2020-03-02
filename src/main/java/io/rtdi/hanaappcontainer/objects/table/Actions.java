package io.rtdi.hanaappcontainer.objects.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.hanaappcontainer.objects.ActivationStyle;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

/**
 * SAP syntax is missing...
 * 
 * <ul><li>Partition Information</li>
 * <li>Temporal type</li>
 * <li>Preload data</li>
 * <li>unload info</li>
 * <li>series table</li>
 * <li>DataTypes ST_POINT, ST_GEOMETRY</li>
 * <li>Primary key index has no name</li>
 * <li>ascending/descending is an index column property</li>
 * <li></li>
 * </ul>
 *
 *
 * Note the following differences in processing
 * <ul><li>The schema information is ignored as the schema comes from the package root folder</li></ul>
 */
public class Actions {

	private static final Object TRUE = "TRUE";

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
					HanaTable table = new HanaTable();
					table.setTableName(tablename);
					table.setDescription(rs.getString(1));
					table.setLoggingType(TRUE.equals(rs.getString(2))?TableLoggingType.LOGGING:TableLoggingType.NOLOGGING);
					table.setTableType("COLUMN".equals(rs.getString(3))?TableType.COLUMN:TableType.ROW);
					table.setTemporary("GLOBAL".equals(rs.getString(4))?TemporaryType.GLOBALTEMPORARY:null);
					table.setHasPublicSynonym(tablename.equals(rs.getString(10))); // When there is a public synonym of same name, then its public property is set to true
					table.setSchemaName(schemaname);
					
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
	
	public static void activate(Connection conn, String schemaname, HanaTable table, ActivationStyle activation) throws HanaSQLException {
		String tablename = table.getTableName();
		HanaTableDiffAction action = new HanaTableDiffAction(conn, table, activation);
		HanaTable currenttable = createDefinitionFromDatabase(conn, schemaname, tablename);
		if (currenttable == null) {
			action.createTable();
		} else {
			table.addCreationMessage("Table exists already, applying changes if needed");
			currenttable.diff(action);
		}
	}
}
