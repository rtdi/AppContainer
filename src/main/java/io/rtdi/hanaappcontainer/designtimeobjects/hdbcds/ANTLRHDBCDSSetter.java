package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import io.rtdi.hanaappcontainer.antlr.sql.HDBCDSParser.*;
import io.rtdi.hanaappcontainer.antlr.sql.HDBCDSParserBaseListener;
import io.rtdi.hanaappcontainer.designtimeobjects.SQLParser;
import io.rtdi.hanaappcontainer.objects.HanaObjectWithColumns;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappserver.DesignTimeParsingResult;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ANTLRHDBCDSSetter extends HDBCDSParserBaseListener {
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
		String comment = ctx.getChild(2).getText();
		int l = comment.length();
		this.currentcomment = comment.substring(1, l-1);
	}
	
	private String getCommentAndClear() {
		String c = this.currentcomment;
		this.currentcomment = null;
		return c;
	}

	@Override
	public void enterEntityname(EntitynameContext ctx) {
		ParseTree t = ctx.getChild(0);
		String tablename = getTablePrefix() + t.getText();
		try {
			CDSTable table = new CDSTable(schemaname, tablename);
			table.setDescription(getCommentAndClear());
			table.setTypeDictionary(typedirectory, objectdirectory);
			objectdirectory.put(tablename, table);
			currentobject = table;
		} catch (HanaSQLException e) {
			
		}
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
	public void enterEntitycolumnname(EntitycolumnnameContext ctx) {
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
		try {
			ColumnType ct = new ColumnType(schemaname, typename);
			currentobject = ct;
			typedirectory.put(typename, ct);
			currentcolumndefinition = new CDSColumnDefinition();
			currentcolumndefinition.setName(t.getText());
			ct.setDataType(currentcolumndefinition);
		} catch (HanaSQLException e) {
			
		}
		currentcolumndefinition.setComment(getCommentAndClear());
	}

	@Override
	public void enterTypenamecomplex(TypenamecomplexContext ctx) {
		ParseTree t = ctx.getChild(0);
		String typename = getTablePrefix() + t.getText();
		try {
			ComplexType ct = new ComplexType(schemaname, typename);
			ct.setTypeDictionary(typedirectory);
			getCommentAndClear();
			currentobject = ct;
			typedirectory.put(typename, ct);
		} catch (HanaSQLException e) {
			
		}
	}

	@Override
	public void enterTypecolumnname(TypecolumnnameContext ctx) {
		ParseTree t = ctx.getChild(0);
		currentcolumndefinition = new CDSColumnDefinition();
		currentcolumndefinition.setName(t.getText());
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

	@Override
	public void enterAssociation(AssociationContext ctx) {
		currentcolumndefinition.createCDSAssociation();
	}

	@Override
	public void enterAssociationfromcardinality(AssociationfromcardinalityContext ctx) {
		currentcolumndefinition.getCDSAssociation().setSourcecardinality(ctx.getChild(0).getText());
	}

	@Override
	public void enterAssociationtocardinality(AssociationtocardinalityContext ctx) {
		currentcolumndefinition.getCDSAssociation().setTargetcardinality(ctx.getChild(0).getText());
	}

	@Override
	public void enterAssociationreferenceto(AssociationreferencetoContext ctx) {
		currentcolumndefinition.getCDSAssociation().setReferencedobject(getTablePrefix() + ctx.getChild(0).getText());
	}

	@Override
	public void enterAssociatedcols(AssociatedcolsContext ctx) {
	}

	@Override
	public void enterAssociatedcolname(AssociatedcolnameContext ctx) {
		JoinCondition join = currentcolumndefinition.getCDSAssociation().addJoincondition();
		join.setLeftcolumn(currentcolumndefinition.getName() + "." + ctx.getChild(0).getText());
		join.setRightcolumn(ctx.getChild(0).getText());
	}

	@Override
	public void enterTabletype(TabletypeContext ctx) {
		ParseTree t = ctx.getChild(0);
		if (t instanceof Tabletype1Context) {
			CDSTable cdstable = (CDSTable) currentobject;
			cdstable.setTableType(TableType.COLUMN);
		} else if (t instanceof Tabletype2Context) {
			CDSTable cdstable = (CDSTable) currentobject;
			cdstable.setTableType(TableType.ROW);
		}
	}

	@Override
	public void enterViewname(ViewnameContext ctx) {
		ParseTree t = ctx.getChild(0);
		String viewname = getTablePrefix() + t.getText();
		try {
			CDSView cdsview = new CDSView(schemaname, viewname);
			cdsview.setDescription(getCommentAndClear());
			cdsview.setTypeDictionary(typedirectory, objectdirectory);
			objectdirectory.put(viewname, cdsview);
			currentobject = cdsview;
		} catch (HanaSQLException e) {
			
		}
	}

	@Override
	public void enterViewoptions(ViewoptionsContext ctx) {
	}

	@Override
	public void enterFromClause(FromClauseContext ctx) {
		if (currentobject instanceof CDSView) {
			CDSView cdsview = (CDSView) currentobject;
			// cdsview.addFrom(getTablePrefix() + t.getText());
			cdsview.addFrom(SQLParser.getFromClause(ctx));
		}
	}

	@Override
	public void enterSelectItem(SelectItemContext ctx) {
		ParseTree t = ctx.getChild(0);
		HanaObjectWithColumns cur = (HanaObjectWithColumns) currentobject;
		CDSViewColumn viewcolumn = new CDSViewColumn();
		String projectionformula = t.getText(); 
		viewcolumn.setProjection(projectionformula);
		viewcolumn.setName(projectionformula);
		currentcolumndefinition = viewcolumn;
		cur.addColumn(currentcolumndefinition);
	}

	@Override
	public void enterViewprivcheck(ViewprivcheckContext ctx) {
		if (currentobject instanceof CDSView) {
			CDSView cdsview = (CDSView) currentobject;
			cdsview.setStructuredPrivCheck(true);
		}
	}

	@Override
	public void enterConstantname(ConstantnameContext ctx) {
		ParseTree t = ctx.getChild(0);
		currentcolumndefinition = new CDSColumnDefinition();
		currentcolumndefinition.setName(t.getText());
	}

}
