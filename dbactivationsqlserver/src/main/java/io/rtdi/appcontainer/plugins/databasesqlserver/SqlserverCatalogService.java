package io.rtdi.appcontainer.plugins.databasesqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.DatabaseObjectTree;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.plugins.database.SelectSource;

public class SqlserverCatalogService implements ICatalogService {
	
	@Override
	public ObjectType objectExists(Connection conn, String schema, String name) throws SQLException {
		String sql = "select \n"
				+ "  case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type, \n"
				+ "  table_name \n"
				+ "from information_schema.tables where table_schema = ? and table_name = ? \n"
				+ "union all \n"
				+ "select 'PROCEDURE', routine_name from information_schema.routines where routine_schema = ? and routine_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, schema);
			stmt.setString(4, name);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return ObjectType.valueOf(rs.getString(1));
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the SQLServer Information schema using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public boolean columnExists(Connection conn, String schema, String name, String columnname) throws SQLException {
		String sql = "select column_name from information_schema.columns where table_schema = ? and table_name = ? and column_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, columnname);
			try (ResultSet rs = stmt.executeQuery();) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the SQLServer Information schema using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public String getTableDDL(Connection conn, String schema, String name) throws SQLException {
		String sql = "select  'create table [' + so.table_schema + '].[' + so.table_name + '] (' + LEFT(o.list, LEN(o.list)-1) +"
				+ " CASE WHEN tc.Constraint_Name IS NULL THEN ');' ELSE ', CONSTRAINT ' + tc.Constraint_Name  + ' PRIMARY KEY ' + ' (' + LEFT(j.List, Len(j.List)-1) + ') );' END\r\n"
				+ "from    information_schema.tables so\r\n"
				+ "cross apply\r\n"
				+ "    (SELECT \r\n"
				+ "        '  ['+column_name+'] ' + \r\n"
				+ "        data_type + case data_type\r\n"
				+ "            when 'sql_variant' then ''\r\n"
				+ "            when 'text' then ''\r\n"
				+ "            when 'ntext' then ''\r\n"
				+ "            when 'xml' then ''\r\n"
				+ "            when 'decimal' then '(' + cast(numeric_precision as varchar) + ', ' + cast(numeric_scale as varchar) + ')'\r\n"
				+ "            else coalesce('('+case when character_maximum_length = -1 then 'MAX' else cast(character_maximum_length as varchar) end +')','') end + ' ' +\r\n"
				+ "        case when exists ( \r\n"
				+ "        select 1 from information_schema.columns sc\r\n"
				+ "        where sc.table_name=so.table_name\r\n"
				+ "		and sc.table_schema = so.table_schema\r\n"
				+ "        and sc.table_name=column_name\r\n"
				+ "        and columnproperty(object_id(TABLE_SCHEMA+'.'+TABLE_NAME),sc.table_name,'IsIdentity') = 1 \r\n"
				+ "        ) then\r\n"
				+ "        'IDENTITY(' + \r\n"
				+ "        cast(ident_seed(so.table_schema + '.' + so.table_name) as varchar) + ',' + \r\n"
				+ "        cast(ident_incr(so.table_schema + '.' + so.table_name) as varchar) + ')'\r\n"
				+ "        else ''\r\n"
				+ "        end + ' ' +\r\n"
				+ "         (case when UPPER(IS_NULLABLE) = 'NO' then 'NOT ' else '' end ) + 'NULL ' + \r\n"
				+ "          case when col.COLUMN_DEFAULT IS NOT NULL THEN 'DEFAULT '+ col.COLUMN_DEFAULT ELSE '' END + ', ' \r\n"
				+ "     from information_schema.columns col where col.table_name = so.table_name and col.table_schema = so.table_schema\r\n"
				+ "     order by ordinal_position\r\n"
				+ "    FOR XML PATH('')) o (list)\r\n"
				+ "left join\r\n"
				+ "    information_schema.table_constraints tc\r\n"
				+ "on  tc.Table_name       = so.table_name\r\n"
				+ "and tc.table_schema = so.table_schema\r\n"
				+ "AND tc.Constraint_Type  = 'PRIMARY KEY'\r\n"
				+ "cross apply\r\n"
				+ "    (select '[' + Column_Name + '], '\r\n"
				+ "     FROM   information_schema.key_column_usage kcu\r\n"
				+ "     WHERE  kcu.Constraint_Name = tc.Constraint_Name\r\n"
				+ "	 and tc.table_schema = kcu.table_schema\r\n"
				+ "     ORDER BY\r\n"
				+ "        ORDINAL_POSITION\r\n"
				+ "     FOR XML PATH('')) j (list)\r\n"
				+ "where \r\n"
				+ "so.table_name    NOT IN ('dtproperties')\r\n"
				+ "and so.table_name = ? and so.table_schema = ?;";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return rs.getString(1);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to generate the table DDL using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public String getViewDDL(Connection conn, String schema, String name) throws SQLException {
		String sql = "select view_definition from information_schema.views where table_schema = ? and table_name = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return rs.getString(1);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the column in the SQLServer Information schema using the SQL \"" + sql + "\"", null);
		}
	}

	@Override
	public String getFunctionDDL(Connection conn, String schema, String name) throws SQLException {
		return getRoutineDDL(conn, schema, name, "FUNCTION");
	}

	@Override
	public String getProcedureDDL(Connection conn, String schema, String name) throws SQLException {
		return getRoutineDDL(conn, schema, name, "PRODEDURE");
	}

	private String getRoutineDDL(Connection conn, String schema, String name, String routinetype) throws SQLException {
		String sql = "select routine_definition from information_schema.routines where routine_schema = ? and routine_name = ? and routine_type = ?";
		if (schema == null) {
			schema = conn.getSchema();
		}
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			stmt.setString(3, routinetype);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return rs.getString(1);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for the " + routinetype + " in the SQLServer Information schema using the SQL \"" + sql + "\"", null);
		}
	}
	
	@Override
	public DatabaseObjectTree getDependencies(Connection conn, String schema, String name) throws SQLException {
		Map<String, DatabaseObjectTree> index = new HashMap<>();
		return getDependencies(conn, schema, name, index);
	}


	@Override
	public DatabaseObjectTree getImpact(Connection conn, String schema, String name) throws SQLException {
		Map<String, DatabaseObjectTree> index = new HashMap<>();
		return getImpact(conn, schema, name, index);
	}
	
	private static DatabaseObjectTree getImpact(Connection conn, String schema, String name, Map<String, DatabaseObjectTree> index) throws SQLException {
		/*
		 * Hierarchical queries fail frequently with max depth and cannot deal with loops
		 */
		String sql = "SELECT s.name as schema_name, o.name as object_name, o.type as object_type\r\n"
				+ " FROM sys.dm_sql_referencing_entities (? + '.' + ?', 'OBJECT') re\r\n"
				+ " join sys.objects o ON re.referencing_id = o.object_id\r\n"
				+ " JOIN sys.schemas s ON o.schema_id = s.schema_id";
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, null);
		index.put(getIndexKey(schema, name), tree);
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery(); ) {
				while (rs.next()) {
					ObjectType t = getChildType(rs.getString(3));
					if (t != null) {
						String key = getIndexKey(rs.getString(1), rs.getString(2));
						DatabaseObjectTree child = index.get(key);
						if (child == null) {
							child = new DatabaseObjectTree(rs.getString(1), rs.getString(2), t);
						}
						tree.addChild(child);
					}
				}
			}
		}
		for (DatabaseObjectTree c : tree.getChildren()) {
			c.addChild(getImpact(conn, c.getSchema(), c.getName(), index));
		}
		return tree;
	}
	
	private static DatabaseObjectTree getDependencies(Connection conn, String schema, String name, Map<String, DatabaseObjectTree> index) throws SQLException {
		String sql = "SELECT s.name as schema_name, o.name as object_name, o.type as object_type\r\n"
				+ " FROM sys.dm_sql_referenced_entities (? + '.' + ?', 'OBJECT') re\r\n"
				+ " join sys.objects o ON re.referenced_id = o.object_id\r\n"
				+ " JOIN sys.schemas s ON o.schema_id = s.schema_id";
		DatabaseObjectTree tree = new DatabaseObjectTree(schema, name, null);
		index.put(getIndexKey(schema, name), tree);
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			stmt.setString(1, schema);
			stmt.setString(2, name);
			try (ResultSet rs = stmt.executeQuery(); ) {
				while (rs.next()) {
					ObjectType t = getChildType(rs.getString(3));
					if (t != null) {
						String key = getIndexKey(rs.getString(1), rs.getString(2));
						DatabaseObjectTree child = index.get(key);
						if (child == null) {
							child = new DatabaseObjectTree(rs.getString(1), rs.getString(2), t);
						}
						tree.addChild(child);
					}
				}
			}
		}
		for (DatabaseObjectTree c : tree.getChildren()) {
			c.addChild(getImpact(conn, c.getSchema(), c.getName(), index));
		}
		return tree;
	}


	private static String getIndexKey(String schema, String name) {
		return schema + "." + name;
	}
	
	private static ObjectType getChildType(String type) {
		/*
				AF = Aggregate function (CLR)
				C = CHECK constraint
				D = DEFAULT (constraint or stand-alone)
				F = FOREIGN KEY constraint
				FN = SQL scalar function
				FS = Assembly (CLR) scalar-function
				FT = Assembly (CLR) table-valued function
				IF = SQL inline table-valued function
				IT = Internal table
				P = SQL Stored Procedure
				PC = Assembly (CLR) stored-procedure
				PG = Plan guide
				PK = PRIMARY KEY constraint
				R = Rule (old-style, stand-alone)
				RF = Replication-filter-procedure
				S = System base table
				SN = Synonym
				SO = Sequence object
				U = Table (user-defined)
				V = View
		*/
		switch (type) {
		case "V": return ObjectType.VIEW;
		case "U":
		case "S": return ObjectType.TABLE;
		case "SN": return ObjectType.SYNONYM;
		case "AF":
		case "FN": return ObjectType.FUNCTION;
		case "P": return ObjectType.PROCEDURE;
		default: return null;
		}
	}


	@Override
	public List<SelectSource> getAllSelectSources(Connection conn, boolean showinternal) throws SQLException {
		String sql = "select table_schema as schema_name, table_name as object_name, case when table_type = 'BASE TABLE' then 'TABLE' else table_type end as object_type\r\n"
				+ "from information_schema.tables";
		List<SelectSource> res = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					res.add(new SelectSource(rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)), rs.getString(1), rs.getString(2), ObjectType.valueOfOrNull(rs.getString(3)), conn.getSchema()));
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for tables/views in the Information schema using the SQL \"" + sql + "\"", null);
		}
		sql = "select o.name, s.name, base_object_name from sys.synonyms s join sys.schemas o on (s.schema_id = o.schema_id)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					String baseid = rs.getString(3); // [SalesLT].[Address]
					String[] parts = baseid.split("\\.");
					if (parts.length == 2) {
						String baseschema = parts[0].substring(1, parts[0].length()-1);
						String basetable = parts[1].substring(1, parts[1].length()-1);;
						res.add(new SelectSource(rs.getString(1), rs.getString(2), ObjectType.SYNONYM, baseschema, basetable, null, conn.getSchema()));
					}
				}
			}
		} catch (SQLException e) {
			throw AppContainerSQLException.cloneFrom(e, "Failed to search for tables/views in the Information schema using the SQL \"" + sql + "\"", null);
		}
		return res;
	}

}
