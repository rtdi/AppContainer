package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSBaseListener;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.*;
import io.rtdi.hanaappcontainer.objects.HanaObjectWithColumns;
import io.rtdi.hanaappserver.DesignTimeParsingResult;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.utils.HanaDataType;

public class ANTLRHDBCDSSetter extends HDBCDSBaseListener {
	private List<String> currentcontext = new ArrayList<>();
	private String namespace = null;
	private HanaObject currentobject;
	private Map<String, HanaObject> objectdirectory = new HashMap<>();
	private Map<String, HanaObject> typedirectory = new HashMap<>();
	private String schemaname;
	private DesignTimeParsingResult parsingresult;
	private CDSColumnDefinition currentcolumndefinition;
	private String currentcomment;
	private String cachednamespace;
	private List<String> cachedcontext;
	private String cachedprefix;
	
	public ANTLRHDBCDSSetter(String schemaname) {
		this.schemaname = schemaname;
		this.parsingresult = new DesignTimeParsingResult();
	}

	@Override
	public void enterContext(ContextContext ctx) {
		getCommentAndClear();
		ParseTree t = ctx.getChild(1);
		this.currentcontext.add(t.getText());
	}

	@Override
	public void enterColumndefault(ColumndefaultContext ctx) {
		currentcolumndefinition.setDefaultValue(ctx.getChild(1).getText());
	}

	@Override
	public void enterColumnnullable(ColumnnullableContext ctx) {
		if (ctx.getChild(0).getText().equalsIgnoreCase("not")) {
			currentcolumndefinition.setNullable(false);
		} else {
			currentcolumndefinition.setNullable(true);
		}
	}

	@Override
	public void enterNamespace(NamespaceContext ctx) {
		ParseTree t = ctx.getChild(1);
		this.namespace = t.getText();
	}

	@Override
	public void enterComment(CommentContext ctx) {
		this.currentcomment = ctx.getChild(2).getText();
	}
	
	private String getCommentAndClear() {
		String c = this.currentcomment;
		this.currentcomment = null;
		return c;
	}

	@Override
	public void enterEntityname(EntitynameContext ctx) {
		ParseTree t = ctx.getChild(0);
		CDSTable table = new CDSTable();
		String tablename = getTablePrefix() + t.getText();
		table.setTableName(tablename);
		table.setSchemaName(schemaname);
		table.setDescription(getCommentAndClear());
		table.setTypeDictionary(typedirectory);
		objectdirectory.put(tablename, table);
		currentobject = table;
	}

	private String getTablePrefix() {
		if (cachednamespace != namespace || cachedcontext != currentcontext) {
			StringBuilder b = new StringBuilder();
			if (namespace != null && namespace.length() != 0) {
				b.append(namespace);
				b.append("::");
			}
			for (String contextpart : currentcontext) {
				b.append(contextpart);
				b.append('.');
			}
			cachednamespace = namespace;
			cachedcontext = currentcontext;
			if (b.length() == 0) {
				cachedprefix = "";
			} else {
				cachedprefix = b.toString();
			}
		}
		return cachedprefix;
	}

	@Override
	public void exitContext(ContextContext ctx) {
		currentcontext.remove(currentcontext.size()-1);
	}

	@Override
	public void enterColumnname(ColumnnameContext ctx) {
		ParseTree t = ctx.getChild(0);
		if (currentobject instanceof CDSTable) {
			HanaObjectWithColumns cur = (HanaObjectWithColumns) currentobject;
			currentcolumndefinition = new CDSColumnDefinition();
			currentcolumndefinition.setName(t.getText());
			cur.addColumn(currentcolumndefinition);
			currentcolumndefinition.setComment(getCommentAndClear());
			if (ctx.getParent() instanceof KeycolumnContext) {
				((CDSTable) currentobject).addPrimaryKey(t.getText());
			}
		}
	}

	public Map<String, HanaObject> getObjects() {
		return objectdirectory;
	}

	public DesignTimeParsingResult getParsingresult() {
		return parsingresult;
	}

	@Override
	public void enterTypenameprimitive(TypenameprimitiveContext ctx) {
		ParseTree t = ctx.getChild(0);
		String typename = getTablePrefix() + t.getText();
		ColumnType ct = new ColumnType(schemaname, typename);
		currentobject = ct;
		typedirectory.put(typename, ct);
		currentcolumndefinition = new CDSColumnDefinition();
		currentcolumndefinition.setName(t.getText());
		ct.setDataType(currentcolumndefinition);
		currentcolumndefinition.setComment(getCommentAndClear());
	}

	@Override
	public void enterTypenamecomplex(TypenamecomplexContext ctx) {
		ParseTree t = ctx.getChild(0);
		String typename = getTablePrefix() + t.getText();
		ComplexType ct = new ComplexType(schemaname, typename);
		ct.setTypeDictionary(typedirectory);
		getCommentAndClear();
		currentobject = ct;
		typedirectory.put(typename, ct);
	}

	@Override
	public void enterTypecolumnname(TypecolumnnameContext ctx) {
		ParseTree t = ctx.getChild(0);
		String typename = getTablePrefix() + t.getText();
		currentcolumndefinition = new CDSColumnDefinition();
		currentcolumndefinition.setName(typename);
		currentcolumndefinition.setComment(getCommentAndClear());
		((ComplexType) currentobject).addColumn(currentcolumndefinition);
	}

	@Override
	public void enterDatatype1(Datatype1Context ctx) {
		// datatype with length
		String datatype = ctx.getChild(0).getText();
		String length = ctx.getChild(2).getText();
		int len = Integer.valueOf(length);
		currentcolumndefinition.setLength(len);
		switch (datatype) {
		case "String":
			currentcolumndefinition.setSqlType(HanaDataType.NVARCHAR);
			break;
		case "Binary":
			currentcolumndefinition.setSqlType(HanaDataType.VARBINARY);
			break;
		case "hana.ALPHANUM":
			currentcolumndefinition.setSqlType(HanaDataType.ALPHANUM);
			break;
		case "hana.VARCHAR":
			currentcolumndefinition.setSqlType(HanaDataType.VARCHAR);
			break;
		case "hana.BINARY":
			currentcolumndefinition.setSqlType(HanaDataType.BINARY);
			break;
		}
	}

	@Override
	public void enterDatatype2(Datatype2Context ctx) {
		// decimal
		String datatype = ctx.getChild(0).getText();
		int precision = Integer.valueOf(ctx.getChild(2).getText());
		int scale = Integer.valueOf(ctx.getChild(4).getText());
		switch (datatype) {
		case "Decimal":
			currentcolumndefinition.setSqlType(HanaDataType.DECIMAL);
			currentcolumndefinition.setPrecision(precision);
			currentcolumndefinition.setScale(scale);
			break;
		}
	}

	@Override
	public void enterDatatype3(Datatype3Context ctx) {
		// no length arg
		String datatype = ctx.getChild(0).getText();
		switch (datatype) {
		case "LargeString":
			currentcolumndefinition.setSqlType(HanaDataType.NCLOB);
			break;
		case "LargeBinary":
			currentcolumndefinition.setSqlType(HanaDataType.BLOB);
			break;
		case "Integer":
			currentcolumndefinition.setSqlType(HanaDataType.INTEGER);
			break;
		case "Integer64":
			currentcolumndefinition.setSqlType(HanaDataType.BIGINT);
			break;
		case "DecimalFloat":
			currentcolumndefinition.setSqlType(HanaDataType.DECIMAL);
			break;
		case "BinaryFloat":
			currentcolumndefinition.setSqlType(HanaDataType.DOUBLE);
			break;
		case "LocalDate":
			currentcolumndefinition.setSqlType(HanaDataType.DATE);
			break;
		case "LocalTime":
			currentcolumndefinition.setSqlType(HanaDataType.TIME);
			break;
		case "UTCDateTime":
			currentcolumndefinition.setSqlType(HanaDataType.SECONDDATE);
			break;
		case "UTCTimestamp":
			currentcolumndefinition.setSqlType(HanaDataType.TIMESTAMP);
			break;
		case "hana.SMALLINT":
			currentcolumndefinition.setSqlType(HanaDataType.SMALLINT);
			break;
		case "hana.TINYINT":
			currentcolumndefinition.setSqlType(HanaDataType.TINYINT);
			break;
		case "hana.SMALLDECIMAL":
			currentcolumndefinition.setSqlType(HanaDataType.SMALLDECIMAL);
			break;
		case "hana.REAL":
			currentcolumndefinition.setSqlType(HanaDataType.REAL);
			break;
		case "hana.CLOB":
			currentcolumndefinition.setSqlType(HanaDataType.CLOB);
			break;
		case "hana.ST_POINT":
			currentcolumndefinition.setSqlType(HanaDataType.ST_POINT);
			break;
		case "hana.ST_GEOMETRY":
			currentcolumndefinition.setSqlType(HanaDataType.ST_GEOMETRY);
			break;
		default:
			currentcolumndefinition.setCDSType(getTablePrefix() + datatype);
			break;
		}
	}

	public Map<String, HanaObject> getTypes() {
		return typedirectory;
	}

}
