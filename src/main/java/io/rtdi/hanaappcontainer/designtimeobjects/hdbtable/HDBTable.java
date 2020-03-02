package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableLexer;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.Order;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class HDBTable {	

	public static HanaTable parseHDBTableText(String text, String schemaname, String tablename) {
		CharStream input = CharStreams.fromString(text);;
		HDBTableLexer lexer = new HDBTableLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HDBTableParser parser = new HDBTableParser(tokens);
		ParseTree tree = parser.keyvaluepairs();
		ParseTreeWalker walker = new ParseTreeWalker();
		HanaTable table = new HanaTable();
		ANTLRHDBTableSetter listener= new ANTLRHDBTableSetter(table);
		walker.walk(listener, tree);
		table.setSchemaName(schemaname); // ignore the schema name in the file
		table.setTableName(tablename);
		return table;
	}
	
	private static String translate(TableType type) throws HanaSQLException {
		if (type == null) {
			return "";
		} else if (type == TableType.COLUMN) {
			return "columnstore";
		} else if (type == TableType.ROW) {
			return "rowstore";
		} else {
			throw new HanaSQLException("The table type is not supported by .hdbtable files of SAP", type.name());
		}
	}

	public static String getHDBTableDefinition(HanaTable table) throws IOException, HanaSQLException {
		/*
			struct TableDefinition {
			    string schemaName;
			    optional bool temporary;
			    optional TableType tableType;
			    optional bool public;
			    optional TableLoggingType loggingType;
			    list<ColumnDefinition> columns;
			    optional list<IndexDefinition> indexes;
			    optional PrimaryKeyDefinition primaryKey;
			    optional string description;
			};
			TableDefinition table;
		 * };
		 * 
		 */
		StringWriter w = new StringWriter();
		if (table.getSchemaName() != null) {
			w.append("table.schemaName = \"").append(table.getSchemaName()).append("\";\n");
		}
		if (table.getTemporary() != null) {
			w.append("table.temporary = ").append(table.getTemporary()==TemporaryType.GLOBALTEMPORARY?"true":"false").append(";\n");
		}
		if (table.getTableType() != null) {
			w.append("table.tableType = ").append(translate(table.getTableType())).append(";\n");
		}
		if (table.getLoggingType() != null) {
			w.append("table.loggingType = ").append(table.getLoggingType().name()).append(";\n");
		}
		w.append("table.columns = [\n");
		boolean first = true;
		for (ColumnDefinition c : table.getColumns()) {
			if (first) {
				first = false;
			} else {
				w.append(",\n");
			}
			w.append("         ");
			writeColumnDefinition(w,c);
		}
		w.append("\n];\n");
		if (table.getIndexes() != null && table.getIndexes().size() != 0) {
			w.append("table.indexes = [\n");
			first = true;
			for (IndexDefinition idx : table.getIndexes()) {
				if (first) {
					first = false;
				} else {
					w.append(",\n");
				}
				w.append("         ");
				writeIndexDefinition(w, idx);
			}
			w.append("\n];\n");
		}
		if (table.getPrimaryKey() != null && table.getPrimaryKey().getPkcolumns() != null && table.getPrimaryKey().getPkcolumns().size() != 0) {
			w.append("table.primaryKey.pkcolumns = ").append(Util.writeStringList(table.getPrimaryKey().getPkcolumns())).append(";\n");
		}
		return w.toString();
	}
	
	private static void writeColumnDefinition(Writer w, ColumnDefinition c) throws IOException {
		/*
			struct ColumnDefinition {
			    string name;
			    SqlDataType sqlType;
			    optional bool nullable;
			    optional bool unique;
			    optional int32 length;
			    optional int32 scale;
			    optional int32 precision;
			    optional string defaultValue;
			    optional string comment;
			};
		 */
		w.append("{name = \"").append(c.getName()).append("\";");
		w.append(" sqlType = ").append(c.getSqlType().toString()).append(";");
		if (c.getNullable() != null) {
			w.append(" nullable = ").append(String.valueOf(c.getNullable())).append(";");
		}
		if (c.getLength() != null) {
			w.append(" length = ").append(String.valueOf(c.getLength())).append(";");
		}
		if (c.getPrecision() != null) {
			w.append(" precision = ").append(String.valueOf(c.getPrecision())).append(";");
		}
		if (c.getScale() != null) {
			w.append(" scale = ").append(String.valueOf(c.getScale())).append(";");
		}
		if (c.getDefaultValue() != null) {
			w.append(" defaultValue = \"").append(c.getDefaultValue()).append("\";");
		}
		if (c.getComment() != null) {
			w.append(" comment = \"").append(c.getComment()).append("\";");
		}
		w.append("}");
	}

	private static void writeIndexDefinition(Writer w, IndexDefinition idx) throws IOException {
		/*
			struct IndexDefinition {
			    string name;
			    bool unique;
			    optional Order order;
			    optional IndexType indexType;
			    list<string> indexColumns;
			};
		 */
		w.append("{name = \"").append(idx.getName()).append("\";");
		if (idx.getUnique() != null) {
			w.append(" unique = ").append(String.valueOf(idx.getUnique())).append(";");
		}
		if (idx.getOrder() != null) {
			w.append(" order = ").append(idx.getOrder() == Order.ASC?"ASC":"DSC").append(";");
		}
		if (idx.getIndexType() != null) {
			w.append(" indexType = ").append(idx.getIndexType().name()).append(";");
		}
		w.append(" indexColumns = ").append(Util.writeStringList(idx.getIndexColumns())).append(";}");
	}

}