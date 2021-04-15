package io.rtdi.appcontainer.importapp;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.appcontainer.antlr.sql.HDBTableLexer;
import io.rtdi.appcontainer.antlr.sql.HDBTableParser;
import io.rtdi.appcontainer.designtimeobjects.hdbtable.ANTLRHDBTableSetter;
import io.rtdi.appcontainer.objects.table.HanaTable;

public class HDBTableTest {
	public static void main(String[] args) throws Exception {

		ANTLRInputStream input = new ANTLRInputStream("table.schemaName = \"MYSCHEMA\";\r\n" + 
				"table.temporary = true;\r\n" + 
				"table.tableType = COLUMNSTORE;\r\n" + 
				"table.loggingType = NOLOGGING;\r\n" + 
				"table.columns = [\r\n" + 
				"	{name = \"Col1\"; sqlType = VARCHAR; nullable = false; length = 20; comment = \"dummy comment\";},\r\n" + 
				"	{name = \"Col2\"; sqlType = INTEGER; nullable = false;},\r\n" + 
				"	{name = \"Col3\"; sqlType = NVARCHAR; nullable = true; length = 20; defaultValue = \"Defaultvalue\";},\r\n" + 
				"	{name = \"Col4\"; sqlType = DECIMAL; nullable = false; precision = 2; scale = 3;}];\r\n" + 
				"table.indexes =  [\r\n" + 
				"	{name = \"MYINDEX1\"; unique = true; order = DSC; indexColumns = [\"Col2\"];},\r\n" + 
				"	{name = \"MYINDEX2\"; unique = true; order = DSC; indexType = B_TREE; indexColumns = [\"Col1\", \"Col4\"];}];\r\n" + 
				"table.primaryKey.pkcolumns = [\"Col1\", \"Col2\"];");

		HDBTableLexer lexer = new HDBTableLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HDBTableParser parser = new HDBTableParser(tokens);
		ParseTree tree = parser.keyvaluepairs(); // begin parsing at rule 'r'
		ParseTreeWalker walker = new ParseTreeWalker();
		HanaTable table = new HanaTable("s", "t");
		ANTLRHDBTableSetter listener= new ANTLRHDBTableSetter(table);
		walker.walk(listener, tree);
		
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		System.out.println(table);
	}
}
