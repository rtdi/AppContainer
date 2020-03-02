package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSLexer;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser;



public class HDBCDSTest {
	public static void main(String[] args) throws Exception {

		ANTLRInputStream input = new ANTLRInputStream("context PurchaseOrder {\r\n" + 
				"    type BusinessKey : String(10);\r\n" + 
				"    type SDate : LocalDate;\r\n" + 
				"    type CurrencyT : String(5);\r\n" + 
				"    type AmountT : Decimal(15, 2);\r\n" + 
				"    type QuantityT : Decimal(13, 3);\r\n" + 
				"    type UnitT : String(3);\r\n" + 
				"    type StatusT : String(1);\r\n" + 
				"    type HistoryT {\r\n" + 
				"        @Comment : 'Created By'\r\n" + 
				"        CREATEDBY : BusinessKey;\r\n" + 
				"        @Comment : 'Created Date'\r\n" + 
				"        CREATEDAT : SDate;\r\n" + 
				"        @Comment : 'Changed By'\r\n" + 
				"        CHANGEDBY : BusinessKey;\r\n" + 
				"        @Comment : 'Change Date'\r\n" + 
				"        CHANGEDAT : SDate;\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    @Comment : 'Purchase Order Header'\r\n" + 
				"    entity Header {\r\n" + 
				"            @Comment : 'Purchase Order ID'\r\n" + 
				"        key PURCHASEORDERID : Integer generated by default as identity(start with 200000000 increment by 1 no minvalue maxvalue 2999999999 no cache no cycle);\r\n" + 
				"            ITEMS           : association[1, 0..*] to Item on Header.PURCHASEORDERID = PURCHASEORDERID;\r\n" + 
				"            HISTORY         : HistoryT;\r\n" + 
				"            @Comment : 'Notes'\r\n" + 
				"            NOTEID          : BusinessKey null;\r\n" + 
				"            @Comment : 'Supplier'\r\n" + 
				"            PARTNER         : BusinessKey;\r\n" + 
				"            @Comment : 'Currency'\r\n" + 
				"            CURRENCY        : CurrencyT;\r\n" + 
				"            @Comment : 'Gross Amount'\r\n" + 
				"            GROSSAMOUNT     : AmountT;\r\n" + 
				"            @Comment : 'Net Amount'\r\n" + 
				"            NETAMOUNT       : AmountT;\r\n" + 
				"            @Comment : 'Tax Amount'\r\n" + 
				"            TAXAMOUNT       : AmountT;\r\n" + 
				"            @Comment : 'Lifecycle Status'\r\n" + 
				"            LIFECYCLESTATUS : StatusT;\r\n" + 
				"            @Comment : 'Approval Status'\r\n" + 
				"            APPROVALSTATUS  : StatusT;\r\n" + 
				"            @Comment : 'Confirmation Status'\r\n" + 
				"            CONFIRMSTATUS   : StatusT;\r\n" + 
				"            @Comment : 'Ordering Status'\r\n" + 
				"            ORDERINGSTATUS  : StatusT;\r\n" + 
				"            @Comment : 'Invoicing Status'\r\n" + 
				"            INVOICINGSTATUS : StatusT;\r\n" + 
				"    }\r\n" + 
				"    technical configuration {\r\n" + 
				"        column store;\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    @Comment : 'Purchase Order Item'\r\n" + 
				"    entity Item {\r\n" + 
				"        key POHeader     : association[*, 1..1] to Header { PURCHASEORDERID };\r\n" + 
				"            @Comment : 'Product ID'\r\n" + 
				"        key PRODUCT      : BusinessKey;\r\n" + 
				"            @Comment : 'Notes'\r\n" + 
				"            NOTEID       : BusinessKey null;\r\n" + 
				"            @Comment : 'Currency'\r\n" + 
				"            CURRENCY     : CurrencyT;\r\n" + 
				"            @Comment : 'Gross Amount'\r\n" + 
				"            GROSSAMOUNT  : AmountT;\r\n" + 
				"            @Comment : 'Net Amount'\r\n" + 
				"            NETAMOUNT    : AmountT;\r\n" + 
				"            @Comment : 'Tax Amount'\r\n" + 
				"            TAXAMOUNT    : AmountT;\r\n" + 
				"            @Comment : 'Quantity'\r\n" + 
				"            QUANTITY     : QuantityT;\r\n" + 
				"            @Comment : 'Quantity Unit'\r\n" + 
				"            QUANTITYUNIT : UnitT;\r\n" + 
				"            @Comment : 'Delivery Date'\r\n" + 
				"            DELIVERYDATE : SDate;\r\n" + 
				"    }\r\n" + 
				"    technical configuration {\r\n" + 
				"        column store;\r\n" + 
				"        //    index PURCHASEORDER_ITEM_ID on (POHeader.PURCHASEORDERID) asc;\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    @Comment : 'Purchase Order Item View'\r\n" + 
				"    define view ItemView as\r\n" + 
				"        select from Item\r\n" + 
				"        {\r\n" + 
				"            POHeader.PURCHASEORDERID as \"PurchaseOrderItemId\",\r\n" + 
				"            POHeader.PARTNER         as \"PartnerId\",\r\n" + 
				"            PRODUCT                  as \"ProductID\",\r\n" + 
				"            CURRENCY                 as \"CurrencyCode\",\r\n" + 
				"            GROSSAMOUNT              as \"Amount\",\r\n" + 
				"            NETAMOUNT                as \"NetAmount\",\r\n" + 
				"            TAXAMOUNT                as \"TaxAmount\",\r\n" + 
				"            QUANTITY                 as \"Quantity\",\r\n" + 
				"            QUANTITYUNIT             as \"QuantityUnit\",\r\n" + 
				"            DELIVERYDATE             as \"DeliveryDate1\"\r\n" + 
				"        }\r\n" + 
				"        with structured privilege check;\r\n" + 
				"};");

		HDBCDSLexer lexer = new HDBCDSLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HDBCDSParser parser = new HDBCDSParser(tokens);
		ParseTree tree = parser.root(); // begin parsing at rule 'root'
		ParseTreeWalker walker = new ParseTreeWalker();
		ANTLRHDBCDSSetter listener= new ANTLRHDBCDSSetter("schema1");
		walker.walk(listener, tree);
		
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		System.out.println(listener.getTables());
	}
}
