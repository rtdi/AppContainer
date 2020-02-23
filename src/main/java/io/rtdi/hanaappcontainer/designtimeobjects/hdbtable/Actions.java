package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.hanaappcontainer.antlr4.hdbtable.HDBTableLexer;
import io.rtdi.hanaappcontainer.antlr4.hdbtable.HDBTableParser;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.IndexType;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.Order;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.subelements.TableType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

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
	public static final String TRUE = "TRUE";

	public static HDBTable parseHDBTableText(String text) {
		CharStream input = CharStreams.fromString(text);;
		HDBTableLexer lexer = new HDBTableLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HDBTableParser parser = new HDBTableParser(tokens);
		ParseTree tree = parser.keyvaluepairs();
		ParseTreeWalker walker = new ParseTreeWalker();
		HDBTable hdbtable = new HDBTable();
		ANTLRHDBTableSetter listener= new ANTLRHDBTableSetter(hdbtable);
		walker.walk(listener, tree);
		return hdbtable;
	}

	public static HDBTable createHDBTableFromDatabase(Connection conn, String schemaname, String tablename) throws HanaSQLException {
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
					HDBTable table = new HDBTable();
					table.setDescription(rs.getString(1));
					table.setLoggingType(TRUE.equals(rs.getString(2))?TableLoggingType.LOGGING:TableLoggingType.NOLOGGING);
					table.setTableType("COLUMN".equals(rs.getString(3))?TableType.COLUMNSTORE:TableType.ROWSTORE);
					table.setTemporary("GLOBAL".equals(rs.getString(4)));
					table.setPublic(tablename.equals(rs.getString(10))); // When there is a public synonym of same name, then its public property is set to true
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
					throw new HanaSQLException("No table with the name found", schemaname + "." + tablename, 10003);
				}
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Please file an issue", 10001);
		}
	}
	
	public static List<String> activate(Connection conn, String schemaname, String tablename, HDBTable hdbtable) throws HanaSQLException {
		List<String> ret = new ArrayList<>();
		try {
			HDBTable currentdef = createHDBTableFromDatabase(conn, schemaname, tablename);
		} catch (HanaSQLException e) {
			if (e.getErrorcode() == 10003) {
				// No table exists yet
				StringBuffer b = new StringBuffer();
				
				/*
				 * 	ROW | [ COLUMN ] } TABLE
					 | HISTORY COLUMN TABLE
					 | GLOBAL TEMPORARY { [ ROW ] | COLUMN } TABLE
					 | LOCAL TEMPORARY { [ ROW ] | COLUMN } TABLE
					 | VIRTUAL TABLE
				 */
				String tabletypekeyword;
				if (hdbtable.getTableType() == null || hdbtable.getTableType() == TableType.COLUMNSTORE) {
					tabletypekeyword = "column ";
				} else {
					tabletypekeyword = "row ";
				}
				String temporarykeyword;
				if (hdbtable.getTemporary() == null || hdbtable.getTemporary().booleanValue()) {
					temporarykeyword = "global temporary ";
				} else {
					temporarykeyword = "";
				}
				b.append("create ").append(temporarykeyword).append(tabletypekeyword)
				.append("table \"").append(schemaname).append("\".\"").append(tablename).append("\" ");
				b.append("(\n");
				Map<String, String> columncomments = new HashMap<>();
				boolean first = true;
				for (ColumnDefinition c : hdbtable.getColumns()) {
					if (first) {
						first = false;
					} else {
						b.append(",\n");
					}
					b.append("    \"").append(c.getName()).append("\" ");
					b.append(Util.getDataTypeString(c.getSqlType(), c.getLength(), c.getPrecision(), c.getScale()));
					if (c.getNullable() != null && !c.getNullable().booleanValue()) {
						b.append("not null ");
					}
					if (c.getComment() != null && c.getComment().length() > 0) {
						columncomments.put(c.getName(), c.getComment());
					}
				}
				if (hdbtable.getPrimaryKey() != null) {
					if (hdbtable.getPrimaryKey().getPkcolumns() != null) {
						b.append(",\n    primary key (");
						first = true;
						for (String p : hdbtable.getPrimaryKey().getPkcolumns()) {
							if (first) {
								first = false;
							} else {
								b.append(", ");
							}
							b.append('"').append(p).append("\"");
						}
						b.append(')');
					}
				}
				b.append(')');
				try (PreparedStatement stmt = conn.prepareStatement(b.toString());) {
					stmt.execute();
					ret.add(b.toString());
					if (hdbtable.getDescription() != null) {
						b = new StringBuffer();
						b.append("comment on table \"").append(schemaname).append("\".\"").append(tablename).append("\" is ");
						b.append('\'').append(hdbtable.getDescription()).append('\'');
						try (PreparedStatement stmtcomment = conn.prepareStatement(b.toString());) {
							stmtcomment.execute();
							ret.add(b.toString());
						}
					}
					if (hdbtable.getIndexes() != null) {
						for (IndexDefinition idx : hdbtable.getIndexes()) {
							b = new StringBuffer();
							String indextype = "";
							if (idx.getUnique() != null && idx.getUnique().booleanValue()) {
								indextype = "UNIQUE ";
							}
							if (idx.getIndexType() != null) {
								if (idx.getIndexType() == IndexType.B_TREE) {
									indextype += "BTREE ";
								} else {
									indextype += "CPBTREE ";
								}
							}
							b.append("create ").append(indextype).append("index \"").append(schemaname).append("\".\"").append(idx.getName()).append("\" ");
							b.append("on \"").append(schemaname).append("\".\"").append(tablename).append("\"(");
							if (idx.getIndexColumns() != null && idx.getIndexColumns().size() > 0) {
								first = true;
								for (String p : idx.getIndexColumns()) {
									if (first) {
										first = false;
									} else {
										b.append(", ");
									}
									b.append('"').append(p).append("\"");
								}
								b.append(") ");
								if (idx.getOrder() != null) {
									if (idx.getOrder() == Order.ASC) {
										b.append("ASC");
									} else {
										b.append("DESC");
									}
								}
								try (PreparedStatement stmtidx = conn.prepareStatement(b.toString());) {
									stmtidx.execute();
									ret.add(b.toString());
								}
							}
						}
					}
					if (hdbtable.getPublic() != null && hdbtable.getPublic().booleanValue()) {
						b = new StringBuffer();
						b.append("select synonym_name from synonyms where schema_name = 'PUBLIC' and synonym_name = ?");
						try (PreparedStatement stmtsynquery = conn.prepareStatement(b.toString());) {
							stmtsynquery.setString(1, tablename);
							try (ResultSet rssyn = stmtsynquery.executeQuery();) {
								if (!rssyn.next()) {
									// No Synonym of that name exists yet, create one
									b = new StringBuffer();
									b.append("create public synonym \"").append(tablename).append("\" for \"")
									.append(schemaname).append("\".\"").append(tablename).append("\" ");
									try (PreparedStatement stmtsyn = conn.prepareStatement(b.toString());) {
										stmtsyn.execute();
										ret.add(b.toString());
									}
								}
							}
						}
					}
					if (columncomments != null && columncomments.size() > 0) {
						for (String column : columncomments.keySet()) {
							b = new StringBuffer();
							b.append("comment on column \"").append(schemaname).append("\".\"")
							.append(tablename).append("\".\"").append(column).append("\" is ");
							b.append('\'').append(hdbtable.getDescription()).append('\'');
							try (PreparedStatement stmtcc = conn.prepareStatement(b.toString());) {
								stmtcc.execute();
								ret.add(b.toString());
							}
							
						}
					}
				} catch (SQLException e1) {
					throw new HanaSQLException(e1, "No table found but creating it failed", b.toString(), 10001);
				}
			} else {
				throw e;
			}
		}
		return ret;
	}
}
