package io.rtdi.appcontainer.importapp;
import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.hdbcds.HDBCDS;



public class HDBCDSTest2 {
	public static void main(String[] args) throws Exception {

		String text = "context MyContext {\r\n" + 
				"  const MyIntConst      : Integer      = 7;\r\n" + 
				"  const MyStringConst   : String(10)   = 'bright';\r\n" + 
				"  const MyDecConst      : Decimal(4,2) = 3.14;\r\n" + 
				"  const MyDateTimeConst : UTCDateTime  = '2015-09-30 14:33'; \r\n" + 
				"\r\n" + 
				"  entity MyEntity {\r\n" + 
				"    key id : Integer;\r\n" + 
				"    a : Integer;\r\n" + 
				"    b : String(100);\r\n" + 
				"    c : Decimal(20,10);\r\n" + 
				"    d : UTCDateTime;\r\n" + 
				"    your : association[1] to YourEntity on your.a = :MyIntConst;\r\n" + 
				"  };\r\n" + 
				"\r\n" + 
				"  entity YourEntity {\r\n" + 
				"    key id : Integer;\r\n" + 
				"    a : Integer;    \r\n" + 
				"  };\r\n" + 
				"\r\n" + 
				"  entity HerEntity {\r\n" + 
				"    key id : Integer;\r\n" + 
				"    t : String(20);\r\n" + 
				"  };\r\n" + 
				"\r\n" + 
				"  view MyView as select from MyEntity \r\n" + 
				"           inner join HerEntity on locate (b, :MyStringConst) > 0\r\n" + 
				"  {\r\n" + 
				"    a + :MyIntConst as x,\r\n" + 
				"    b || ' is ' || :MyStringConst as y,\r\n" + 
				"    c * sin(:MyDecConst) as z    \r\n" + 
				"  } where d < :MyContext.MyDateTimeConst; \r\n" + 
				"};";

		HDBCDS cds = HDBCDS.parseHBDCDSFile(text, "schema1");
		
		ActivationResult result = new ActivationResult();
		cds.valid(result);
		System.out.println(result.toString());
	}
}
