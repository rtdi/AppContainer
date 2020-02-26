package io.rtdi.hanaappcontainer.importapp;

import static org.junit.Assert.fail;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.HDBTable;
import io.rtdi.hanaappcontainer.objects.table.Actions;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;

public class ImportTableTest {
	private Connection conn;
	
	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(
	            "jdbc:sap://hanawd:39015/HXE", "rtdi", "Toor1234");
	}

	@Test
	public void test() {
		try {
			/*HDBTable hdbtable = ImportTable.createHDBTable(conn, "SAPHANADB", "VBAP");
			StringWriter w = new StringWriter();
			hdbtable.write(w);
			System.out.print(w.toString());*/
			
			HanaTable table = HDBTable.parseHDBTableText("table.schemaName = \"MYSCHEMA\";\r\n" + 
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
					"table.primaryKey.pkcolumns = [\"Col1\", \"Col2\"];", "TABLE1");

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
