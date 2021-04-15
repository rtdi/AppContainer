// Generated from HDBCDSParser.g4 by ANTLR 4.8
package io.rtdi.appcontainer.antlr.sql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HDBCDSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT2_SYMBOL=1, CONCAT_PIPES_SYMBOL=2, LONG_NUMBER=3, ULONGLONG_NUMBER=4, 
		ASSOCCARD=5, OPEN_RECT_SYMBOL=6, CLOSE_RECT_SYMBOL=7, IDENTITY_SYMBOL=8, 
		NAMESPACE_SYMBOL=9, CONTEXT_SYMBOL=10, COMMENT_SYMBOL=11, ENTITY_SYMBOL=12, 
		ASSOCIATION_SYMBOL=13, CONST_SYMBOL=14, ALWAYS_SYMBOL=15, INCREMENT_SYMBOL=16, 
		MINVALUE_SYMBOL=17, MAXVALUE_SYMBOL=18, CYCLE_SYMBOL=19, CONFIGURATION_SYMBOL=20, 
		TECHNICAL_SYMBOL=21, STORE_SYMBOL=22, DEFINE_SYMBOL=23, STRUCTURED_SYMBOL=24, 
		PRIVILEGE_SYMBOL=25, TYPE_SYMBOL=26, DEFAULT_SYMBOL=27, KEY_SYMBOL=28, 
		GENERATED_SYMBOL=29, START_SYMBOL=30, CACHE_SYMBOL=31, COLUMN_SYMBOL=32, 
		VIEW_SYMBOL=33, CHECK_SYMBOL=34, EQUAL_OPERATOR=35, ASSIGN_OPERATOR=36, 
		NULL_SAFE_EQUAL_OPERATOR=37, GREATER_OR_EQUAL_OPERATOR=38, GREATER_THAN_OPERATOR=39, 
		LESS_OR_EQUAL_OPERATOR=40, LESS_THAN_OPERATOR=41, NOT_EQUAL_OPERATOR=42, 
		PLUS_OPERATOR=43, MINUS_OPERATOR=44, MULT_OPERATOR=45, DIV_OPERATOR=46, 
		MOD_OPERATOR=47, DOT_SYMBOL=48, COMMA_SYMBOL=49, SEMICOLON_SYMBOL=50, 
		COLON_SYMBOL=51, OPEN_PAR_SYMBOL=52, CLOSE_PAR_SYMBOL=53, OPEN_CURLY_SYMBOL=54, 
		CLOSE_CURLY_SYMBOL=55, UNDERLINE_SYMBOL=56, NULL2_SYMBOL=57, PARAM_MARKER=58, 
		HEX_NUMBER=59, BIN_NUMBER=60, INT_NUMBER=61, DECIMAL_NUMBER=62, FLOAT_NUMBER=63, 
		DOT_IDENTIFIER=64, LOCATE_SYMBOL=65, ASCII_SYMBOL=66, COALESCE_SYMBOL=67, 
		SUBSTR_SYMBOL=68, SUBSTRING_SYMBOL=69, AND_SYMBOL=70, OR_SYMBOL=71, NOT_SYMBOL=72, 
		UNION_SYMBOL=73, ALL_SYMBOL=74, CURRENT_USER_SYMBOL=75, ROWS_SYMBOL=76, 
		WINDOW_SYMBOL=77, PARTITION_SYMBOL=78, BY_SYMBOL=79, DENSE_RANK_SYMBOL=80, 
		FIRST_VALUE_SYMBOL=81, LAG_SYMBOL=82, LAST_VALUE_SYMBOL=83, LEAD_SYMBOL=84, 
		NTILE_SYMBOL=85, NULLS_SYMBOL=86, OVER_SYMBOL=87, PRECEDING_SYMBOL=88, 
		RANK_SYMBOL=89, ROW_NUMBER_SYMBOL=90, UNBOUNDED_SYMBOL=91, INTERVAL_SYMBOL=92, 
		CURRENT_SYMBOL=93, ROW_SYMBOL=94, FOLLOWING_SYMBOL=95, EXCLUDE_SYMBOL=96, 
		TIES_SYMBOL=97, OTHERS_SYMBOL=98, RECURSIVE_SYMBOL=99, AVG_SYMBOL=100, 
		COUNT_SYMBOL=101, DISTINCT_SYMBOL=102, SUM_SYMBOL=103, MAX_SYMBOL=104, 
		MIN_SYMBOL=105, STD_SYMBOL=106, STDDEV_SYMBOL=107, VARIANCE_SYMBOL=108, 
		GROUP_CONCAT_SYMBOL=109, SEPARATOR_SYMBOL=110, FOR_SYMBOL=111, MODE_SYMBOL=112, 
		SHARE_SYMBOL=113, UPDATE_SYMBOL=114, LOCK_SYMBOL=115, SKIP_SYMBOL=116, 
		LOCKED_SYMBOL=117, CROSS_SYMBOL=118, INNER_SYMBOL=119, JOIN_SYMBOL=120, 
		LEFT_SYMBOL=121, RIGHT_SYMBOL=122, LATERAL_SYMBOL=123, ELSE_SYMBOL=124, 
		THEN_SYMBOL=125, WHEN_SYMBOL=126, ANY_SYMBOL=127, AS_SYMBOL=128, ASC_SYMBOL=129, 
		AT_SYMBOL=130, BETWEEN_SYMBOL=131, CASE_SYMBOL=132, CAST_SYMBOL=133, CONTAINS_SYMBOL=134, 
		DATE_SYMBOL=135, DESC_SYMBOL=136, DUMMY_SYMBOL=137, END_SYMBOL=138, ESCAPE_SYMBOL=139, 
		EXISTS_SYMBOL=140, FALSE_SYMBOL=141, FIRST_SYMBOL=142, FROM_SYMBOL=143, 
		FULL_SYMBOL=144, FULLTEXT_SYMBOL=145, FUNCTION_SYMBOL=146, GROUP_SYMBOL=147, 
		HAVING_SYMBOL=148, IN_SYMBOL=149, IS_SYMBOL=150, KEYS_SYMBOL=151, LAST_SYMBOL=152, 
		LIKE_SYMBOL=153, LIMIT_SYMBOL=154, NOW_SYMBOL=155, NO_SYMBOL=156, NULL_SYMBOL=157, 
		OFFSET_SYMBOL=158, ON_SYMBOL=159, ORDER_SYMBOL=160, OUTER_SYMBOL=161, 
		SELECT_SYMBOL=162, TIMESTAMP_SYMBOL=163, TIME_SYMBOL=164, TO_SYMBOL=165, 
		TRUE_SYMBOL=166, UNKNOWN_SYMBOL=167, USING_SYMBOL=168, WHERE_SYMBOL=169, 
		WITH_SYMBOL=170, OF_SYMBOL=171, NOWAIT_SYMBOL=172, GROUPING_SYMBOL=173, 
		WHITESPACE=174, INVALID_INPUT=175, IDENTIFIER=176, NCHAR_TEXT=177, DOUBLE_QUOTED_TEXT=178, 
		SINGLE_QUOTED_TEXT=179, BLOCK_COMMENT=180, POUND_COMMENT=181, DASHDASH_COMMENT=182, 
		SLASHSLASH_COMMENT=183, NOT_EQUAL2_OPERATOR=184;
	public static final int
		RULE_root = 0, RULE_namespace = 1, RULE_context = 2, RULE_primitivetype = 3, 
		RULE_complextype = 4, RULE_comment = 5, RULE_typecolumn = 6, RULE_columndefault = 7, 
		RULE_columnnullable = 8, RULE_typenameprimitive = 9, RULE_typenamecomplex = 10, 
		RULE_typecolumnname = 11, RULE_contextname = 12, RULE_constant = 13, RULE_constantname = 14, 
		RULE_datatype = 15, RULE_entity = 16, RULE_entityname = 17, RULE_tablecolumn = 18, 
		RULE_keycolumn = 19, RULE_regularcolumn = 20, RULE_entitycolumnname = 21, 
		RULE_association = 22, RULE_associationreferenceto = 23, RULE_associationjoinexpr = 24, 
		RULE_associationfromcardinality = 25, RULE_associationtocardinality = 26, 
		RULE_associatedcols = 27, RULE_associatedcolname = 28, RULE_generated = 29, 
		RULE_generatedalways = 30, RULE_generatedbydefault = 31, RULE_identitystart = 32, 
		RULE_identityincrement = 33, RULE_identityminclause = 34, RULE_identitynomin = 35, 
		RULE_identitymin = 36, RULE_identitymaxclause = 37, RULE_identitynomax = 38, 
		RULE_identitymax = 39, RULE_identitynochache = 40, RULE_identitynocycle = 41, 
		RULE_techconfig = 42, RULE_tabletype = 43, RULE_tabletype1 = 44, RULE_tabletype2 = 45, 
		RULE_define = 46, RULE_viewname = 47, RULE_viewprojectionlist = 48, RULE_viewoptions = 49, 
		RULE_viewprivcheck = 50, RULE_datatype1 = 51, RULE_datatype2 = 52, RULE_datatype3 = 53, 
		RULE_selectStatement = 54, RULE_queryExpression = 55, RULE_queryExpressionBody = 56, 
		RULE_queryExpressionParens = 57, RULE_querySpecification = 58, RULE_subquery = 59, 
		RULE_querySpecOption = 60, RULE_limitClause = 61, RULE_simpleLimitClause = 62, 
		RULE_limitOptions = 63, RULE_limitOption = 64, RULE_havingClause = 65, 
		RULE_windowClause = 66, RULE_windowDefinition = 67, RULE_windowSpec = 68, 
		RULE_windowSpecDetails = 69, RULE_windowFrameClause = 70, RULE_windowFrameUnits = 71, 
		RULE_windowFrameExtent = 72, RULE_windowFrameStart = 73, RULE_windowFrameBetween = 74, 
		RULE_windowFrameBound = 75, RULE_windowFrameExclusion = 76, RULE_withClause = 77, 
		RULE_commonTableExpression = 78, RULE_groupByClause = 79, RULE_orderClause = 80, 
		RULE_direction = 81, RULE_fromClause = 82, RULE_tableReferenceList = 83, 
		RULE_selectOption = 84, RULE_lockingClause = 85, RULE_lockStrengh = 86, 
		RULE_lockedRowAction = 87, RULE_selectItemList = 88, RULE_selectItem = 89, 
		RULE_selectAlias = 90, RULE_whereClause = 91, RULE_tableReference = 92, 
		RULE_escapedTableReference = 93, RULE_joinedTable = 94, RULE_innerJoinType = 95, 
		RULE_outerJoinType = 96, RULE_tableFactor = 97, RULE_singleTable = 98, 
		RULE_singleTableParens = 99, RULE_derivedTable = 100, RULE_tableReferenceListParens = 101, 
		RULE_unionOption = 102, RULE_tableAlias = 103, RULE_expr = 104, RULE_boolPri = 105, 
		RULE_compOp = 106, RULE_predicate = 107, RULE_predicateOperations = 108, 
		RULE_bitExpr = 109, RULE_simpleExpr = 110, RULE_sumExpr = 111, RULE_groupingOperation = 112, 
		RULE_windowFunctionCall = 113, RULE_windowingClause = 114, RULE_leadLagInfo = 115, 
		RULE_inSumExpr = 116, RULE_identListArg = 117, RULE_identList = 118, RULE_runtimeFunctionCall = 119, 
		RULE_timeFunctionParameters = 120, RULE_fractionalPrecision = 121, RULE_substringFunction = 122, 
		RULE_functionCall = 123, RULE_udfExprList = 124, RULE_udfExpr = 125, RULE_whenExpression = 126, 
		RULE_thenExpression = 127, RULE_elseExpression = 128, RULE_castType = 129, 
		RULE_exprList = 130, RULE_notRule = 131, RULE_not2Rule = 132, RULE_exprListWithParentheses = 133, 
		RULE_exprWithParentheses = 134, RULE_simpleExprWithParentheses = 135, 
		RULE_orderList = 136, RULE_orderExpression = 137, RULE_groupList = 138, 
		RULE_groupingExpression = 139, RULE_pureIdentifier = 140, RULE_identifier = 141, 
		RULE_identifierList = 142, RULE_identifierListWithParentheses = 143, RULE_qualifiedIdentifier = 144, 
		RULE_simpleIdentifier = 145, RULE_dotIdentifier = 146, RULE_ulong_number = 147, 
		RULE_real_ulong_number = 148, RULE_ulonglong_number = 149, RULE_real_ulonglong_number = 150, 
		RULE_literal = 151, RULE_signedLiteral = 152, RULE_stringList = 153, RULE_textStringLiteral = 154, 
		RULE_textString = 155, RULE_textStringHash = 156, RULE_textLiteral = 157, 
		RULE_textStringNoLinebreak = 158, RULE_textStringLiteralList = 159, RULE_numLiteral = 160, 
		RULE_boolLiteral = 161, RULE_nullLiteral = 162, RULE_temporalLiteral = 163, 
		RULE_floatOptions = 164, RULE_standardFloatOptions = 165, RULE_precision = 166, 
		RULE_textOrIdentifier = 167, RULE_sizeNumber = 168, RULE_parentheses = 169, 
		RULE_equal = 170, RULE_identifierKeyword = 171, RULE_identifierKeywordsUnambiguous = 172, 
		RULE_windowName = 173, RULE_fieldIdentifier = 174, RULE_columnName = 175, 
		RULE_columnInternalRef = 176, RULE_columnInternalRefList = 177, RULE_columnRef = 178, 
		RULE_tableRefWithWildcard = 179, RULE_tableAliasRefList = 180, RULE_tableWild = 181, 
		RULE_tableRef = 182, RULE_fieldLength = 183, RULE_typeDatetimePrecision = 184;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "namespace", "context", "primitivetype", "complextype", "comment", 
			"typecolumn", "columndefault", "columnnullable", "typenameprimitive", 
			"typenamecomplex", "typecolumnname", "contextname", "constant", "constantname", 
			"datatype", "entity", "entityname", "tablecolumn", "keycolumn", "regularcolumn", 
			"entitycolumnname", "association", "associationreferenceto", "associationjoinexpr", 
			"associationfromcardinality", "associationtocardinality", "associatedcols", 
			"associatedcolname", "generated", "generatedalways", "generatedbydefault", 
			"identitystart", "identityincrement", "identityminclause", "identitynomin", 
			"identitymin", "identitymaxclause", "identitynomax", "identitymax", "identitynochache", 
			"identitynocycle", "techconfig", "tabletype", "tabletype1", "tabletype2", 
			"define", "viewname", "viewprojectionlist", "viewoptions", "viewprivcheck", 
			"datatype1", "datatype2", "datatype3", "selectStatement", "queryExpression", 
			"queryExpressionBody", "queryExpressionParens", "querySpecification", 
			"subquery", "querySpecOption", "limitClause", "simpleLimitClause", "limitOptions", 
			"limitOption", "havingClause", "windowClause", "windowDefinition", "windowSpec", 
			"windowSpecDetails", "windowFrameClause", "windowFrameUnits", "windowFrameExtent", 
			"windowFrameStart", "windowFrameBetween", "windowFrameBound", "windowFrameExclusion", 
			"withClause", "commonTableExpression", "groupByClause", "orderClause", 
			"direction", "fromClause", "tableReferenceList", "selectOption", "lockingClause", 
			"lockStrengh", "lockedRowAction", "selectItemList", "selectItem", "selectAlias", 
			"whereClause", "tableReference", "escapedTableReference", "joinedTable", 
			"innerJoinType", "outerJoinType", "tableFactor", "singleTable", "singleTableParens", 
			"derivedTable", "tableReferenceListParens", "unionOption", "tableAlias", 
			"expr", "boolPri", "compOp", "predicate", "predicateOperations", "bitExpr", 
			"simpleExpr", "sumExpr", "groupingOperation", "windowFunctionCall", "windowingClause", 
			"leadLagInfo", "inSumExpr", "identListArg", "identList", "runtimeFunctionCall", 
			"timeFunctionParameters", "fractionalPrecision", "substringFunction", 
			"functionCall", "udfExprList", "udfExpr", "whenExpression", "thenExpression", 
			"elseExpression", "castType", "exprList", "notRule", "not2Rule", "exprListWithParentheses", 
			"exprWithParentheses", "simpleExprWithParentheses", "orderList", "orderExpression", 
			"groupList", "groupingExpression", "pureIdentifier", "identifier", "identifierList", 
			"identifierListWithParentheses", "qualifiedIdentifier", "simpleIdentifier", 
			"dotIdentifier", "ulong_number", "real_ulong_number", "ulonglong_number", 
			"real_ulonglong_number", "literal", "signedLiteral", "stringList", "textStringLiteral", 
			"textString", "textStringHash", "textLiteral", "textStringNoLinebreak", 
			"textStringLiteralList", "numLiteral", "boolLiteral", "nullLiteral", 
			"temporalLiteral", "floatOptions", "standardFloatOptions", "precision", 
			"textOrIdentifier", "sizeNumber", "parentheses", "equal", "identifierKeyword", 
			"identifierKeywordsUnambiguous", "windowName", "fieldIdentifier", "columnName", 
			"columnInternalRef", "columnInternalRefList", "columnRef", "tableRefWithWildcard", 
			"tableAliasRefList", "tableWild", "tableRef", "fieldLength", "typeDatetimePrecision"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'['", "']'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'='", 
			"':='", "'<=>'", "'>='", "'>'", "'<='", "'<'", "'!='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'.'", "','", "';'", "':'", "'('", "')'", "'{'", 
			"'}'", "'_'", "'\\N'", "'?'", null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NOT2_SYMBOL", "CONCAT_PIPES_SYMBOL", "LONG_NUMBER", "ULONGLONG_NUMBER", 
			"ASSOCCARD", "OPEN_RECT_SYMBOL", "CLOSE_RECT_SYMBOL", "IDENTITY_SYMBOL", 
			"NAMESPACE_SYMBOL", "CONTEXT_SYMBOL", "COMMENT_SYMBOL", "ENTITY_SYMBOL", 
			"ASSOCIATION_SYMBOL", "CONST_SYMBOL", "ALWAYS_SYMBOL", "INCREMENT_SYMBOL", 
			"MINVALUE_SYMBOL", "MAXVALUE_SYMBOL", "CYCLE_SYMBOL", "CONFIGURATION_SYMBOL", 
			"TECHNICAL_SYMBOL", "STORE_SYMBOL", "DEFINE_SYMBOL", "STRUCTURED_SYMBOL", 
			"PRIVILEGE_SYMBOL", "TYPE_SYMBOL", "DEFAULT_SYMBOL", "KEY_SYMBOL", "GENERATED_SYMBOL", 
			"START_SYMBOL", "CACHE_SYMBOL", "COLUMN_SYMBOL", "VIEW_SYMBOL", "CHECK_SYMBOL", 
			"EQUAL_OPERATOR", "ASSIGN_OPERATOR", "NULL_SAFE_EQUAL_OPERATOR", "GREATER_OR_EQUAL_OPERATOR", 
			"GREATER_THAN_OPERATOR", "LESS_OR_EQUAL_OPERATOR", "LESS_THAN_OPERATOR", 
			"NOT_EQUAL_OPERATOR", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", 
			"DIV_OPERATOR", "MOD_OPERATOR", "DOT_SYMBOL", "COMMA_SYMBOL", "SEMICOLON_SYMBOL", 
			"COLON_SYMBOL", "OPEN_PAR_SYMBOL", "CLOSE_PAR_SYMBOL", "OPEN_CURLY_SYMBOL", 
			"CLOSE_CURLY_SYMBOL", "UNDERLINE_SYMBOL", "NULL2_SYMBOL", "PARAM_MARKER", 
			"HEX_NUMBER", "BIN_NUMBER", "INT_NUMBER", "DECIMAL_NUMBER", "FLOAT_NUMBER", 
			"DOT_IDENTIFIER", "LOCATE_SYMBOL", "ASCII_SYMBOL", "COALESCE_SYMBOL", 
			"SUBSTR_SYMBOL", "SUBSTRING_SYMBOL", "AND_SYMBOL", "OR_SYMBOL", "NOT_SYMBOL", 
			"UNION_SYMBOL", "ALL_SYMBOL", "CURRENT_USER_SYMBOL", "ROWS_SYMBOL", "WINDOW_SYMBOL", 
			"PARTITION_SYMBOL", "BY_SYMBOL", "DENSE_RANK_SYMBOL", "FIRST_VALUE_SYMBOL", 
			"LAG_SYMBOL", "LAST_VALUE_SYMBOL", "LEAD_SYMBOL", "NTILE_SYMBOL", "NULLS_SYMBOL", 
			"OVER_SYMBOL", "PRECEDING_SYMBOL", "RANK_SYMBOL", "ROW_NUMBER_SYMBOL", 
			"UNBOUNDED_SYMBOL", "INTERVAL_SYMBOL", "CURRENT_SYMBOL", "ROW_SYMBOL", 
			"FOLLOWING_SYMBOL", "EXCLUDE_SYMBOL", "TIES_SYMBOL", "OTHERS_SYMBOL", 
			"RECURSIVE_SYMBOL", "AVG_SYMBOL", "COUNT_SYMBOL", "DISTINCT_SYMBOL", 
			"SUM_SYMBOL", "MAX_SYMBOL", "MIN_SYMBOL", "STD_SYMBOL", "STDDEV_SYMBOL", 
			"VARIANCE_SYMBOL", "GROUP_CONCAT_SYMBOL", "SEPARATOR_SYMBOL", "FOR_SYMBOL", 
			"MODE_SYMBOL", "SHARE_SYMBOL", "UPDATE_SYMBOL", "LOCK_SYMBOL", "SKIP_SYMBOL", 
			"LOCKED_SYMBOL", "CROSS_SYMBOL", "INNER_SYMBOL", "JOIN_SYMBOL", "LEFT_SYMBOL", 
			"RIGHT_SYMBOL", "LATERAL_SYMBOL", "ELSE_SYMBOL", "THEN_SYMBOL", "WHEN_SYMBOL", 
			"ANY_SYMBOL", "AS_SYMBOL", "ASC_SYMBOL", "AT_SYMBOL", "BETWEEN_SYMBOL", 
			"CASE_SYMBOL", "CAST_SYMBOL", "CONTAINS_SYMBOL", "DATE_SYMBOL", "DESC_SYMBOL", 
			"DUMMY_SYMBOL", "END_SYMBOL", "ESCAPE_SYMBOL", "EXISTS_SYMBOL", "FALSE_SYMBOL", 
			"FIRST_SYMBOL", "FROM_SYMBOL", "FULL_SYMBOL", "FULLTEXT_SYMBOL", "FUNCTION_SYMBOL", 
			"GROUP_SYMBOL", "HAVING_SYMBOL", "IN_SYMBOL", "IS_SYMBOL", "KEYS_SYMBOL", 
			"LAST_SYMBOL", "LIKE_SYMBOL", "LIMIT_SYMBOL", "NOW_SYMBOL", "NO_SYMBOL", 
			"NULL_SYMBOL", "OFFSET_SYMBOL", "ON_SYMBOL", "ORDER_SYMBOL", "OUTER_SYMBOL", 
			"SELECT_SYMBOL", "TIMESTAMP_SYMBOL", "TIME_SYMBOL", "TO_SYMBOL", "TRUE_SYMBOL", 
			"UNKNOWN_SYMBOL", "USING_SYMBOL", "WHERE_SYMBOL", "WITH_SYMBOL", "OF_SYMBOL", 
			"NOWAIT_SYMBOL", "GROUPING_SYMBOL", "WHITESPACE", "INVALID_INPUT", "IDENTIFIER", 
			"NCHAR_TEXT", "DOUBLE_QUOTED_TEXT", "SINGLE_QUOTED_TEXT", "BLOCK_COMMENT", 
			"POUND_COMMENT", "DASHDASH_COMMENT", "SLASHSLASH_COMMENT", "NOT_EQUAL2_OPERATOR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HDBCDSParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HDBCDSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public List<ContextContext> context() {
			return getRuleContexts(ContextContext.class);
		}
		public ContextContext context(int i) {
			return getRuleContext(ContextContext.class,i);
		}
		public List<PrimitivetypeContext> primitivetype() {
			return getRuleContexts(PrimitivetypeContext.class);
		}
		public PrimitivetypeContext primitivetype(int i) {
			return getRuleContext(PrimitivetypeContext.class,i);
		}
		public List<ComplextypeContext> complextype() {
			return getRuleContexts(ComplextypeContext.class);
		}
		public ComplextypeContext complextype(int i) {
			return getRuleContext(ComplextypeContext.class,i);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAMESPACE_SYMBOL) {
				{
				setState(370);
				namespace();
				}
			}

			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTEXT_SYMBOL) | (1L << COMMENT_SYMBOL) | (1L << ENTITY_SYMBOL) | (1L << CONST_SYMBOL) | (1L << DEFINE_SYMBOL) | (1L << TYPE_SYMBOL) | (1L << VIEW_SYMBOL))) != 0)) {
				{
				setState(379);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(373);
					context();
					}
					break;
				case 2:
					{
					setState(374);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(375);
					complextype();
					}
					break;
				case 4:
					{
					setState(376);
					entity();
					}
					break;
				case 5:
					{
					setState(377);
					define();
					}
					break;
				case 6:
					{
					setState(378);
					constant();
					}
					break;
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode NAMESPACE_SYMBOL() { return getToken(HDBCDSParser.NAMESPACE_SYMBOL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitNamespace(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(NAMESPACE_SYMBOL);
			setState(385);
			match(IDENTIFIER);
			setState(386);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextContext extends ParserRuleContext {
		public TerminalNode CONTEXT_SYMBOL() { return getToken(HDBCDSParser.CONTEXT_SYMBOL, 0); }
		public ContextnameContext contextname() {
			return getRuleContext(ContextnameContext.class,0);
		}
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<ContextContext> context() {
			return getRuleContexts(ContextContext.class);
		}
		public ContextContext context(int i) {
			return getRuleContext(ContextContext.class,i);
		}
		public List<PrimitivetypeContext> primitivetype() {
			return getRuleContexts(PrimitivetypeContext.class);
		}
		public PrimitivetypeContext primitivetype(int i) {
			return getRuleContext(PrimitivetypeContext.class,i);
		}
		public List<ComplextypeContext> complextype() {
			return getRuleContexts(ComplextypeContext.class);
		}
		public ComplextypeContext complextype(int i) {
			return getRuleContext(ComplextypeContext.class,i);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitContext(this);
		}
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_context);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(388);
				comment();
				}
			}

			setState(391);
			match(CONTEXT_SYMBOL);
			setState(392);
			contextname();
			setState(393);
			match(OPEN_CURLY_SYMBOL);
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTEXT_SYMBOL) | (1L << COMMENT_SYMBOL) | (1L << ENTITY_SYMBOL) | (1L << CONST_SYMBOL) | (1L << DEFINE_SYMBOL) | (1L << TYPE_SYMBOL) | (1L << VIEW_SYMBOL))) != 0)) {
				{
				setState(400);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(394);
					context();
					}
					break;
				case 2:
					{
					setState(395);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(396);
					complextype();
					}
					break;
				case 4:
					{
					setState(397);
					entity();
					}
					break;
				case 5:
					{
					setState(398);
					define();
					}
					break;
				case 6:
					{
					setState(399);
					constant();
					}
					break;
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(405);
			match(CLOSE_CURLY_SYMBOL);
			setState(406);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitivetypeContext extends ParserRuleContext {
		public TerminalNode TYPE_SYMBOL() { return getToken(HDBCDSParser.TYPE_SYMBOL, 0); }
		public TypenameprimitiveContext typenameprimitive() {
			return getRuleContext(TypenameprimitiveContext.class,0);
		}
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public PrimitivetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitivetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrimitivetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrimitivetype(this);
		}
	}

	public final PrimitivetypeContext primitivetype() throws RecognitionException {
		PrimitivetypeContext _localctx = new PrimitivetypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(408);
				comment();
				}
			}

			setState(411);
			match(TYPE_SYMBOL);
			setState(412);
			typenameprimitive();
			setState(413);
			match(COLON_SYMBOL);
			setState(414);
			datatype();
			setState(415);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplextypeContext extends ParserRuleContext {
		public TerminalNode TYPE_SYMBOL() { return getToken(HDBCDSParser.TYPE_SYMBOL, 0); }
		public TypenamecomplexContext typenamecomplex() {
			return getRuleContext(TypenamecomplexContext.class,0);
		}
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<TypecolumnContext> typecolumn() {
			return getRuleContexts(TypecolumnContext.class);
		}
		public TypecolumnContext typecolumn(int i) {
			return getRuleContext(TypecolumnContext.class,i);
		}
		public ComplextypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complextype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterComplextype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitComplextype(this);
		}
	}

	public final ComplextypeContext complextype() throws RecognitionException {
		ComplextypeContext _localctx = new ComplextypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_complextype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(417);
				comment();
				}
			}

			setState(420);
			match(TYPE_SYMBOL);
			setState(421);
			typenamecomplex();
			setState(422);
			match(OPEN_CURLY_SYMBOL);
			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(423);
				typecolumn();
				}
				}
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT_SYMBOL || _la==IDENTIFIER );
			setState(428);
			match(CLOSE_CURLY_SYMBOL);
			setState(429);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_SYMBOL() { return getToken(HDBCDSParser.COMMENT_SYMBOL, 0); }
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(COMMENT_SYMBOL);
			setState(432);
			match(COLON_SYMBOL);
			setState(433);
			match(SINGLE_QUOTED_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypecolumnContext extends ParserRuleContext {
		public TypecolumnnameContext typecolumnname() {
			return getRuleContext(TypecolumnnameContext.class,0);
		}
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TypecolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typecolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTypecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTypecolumn(this);
		}
	}

	public final TypecolumnContext typecolumn() throws RecognitionException {
		TypecolumnContext _localctx = new TypecolumnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typecolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(435);
				comment();
				}
			}

			setState(438);
			typecolumnname();
			setState(439);
			match(COLON_SYMBOL);
			setState(440);
			datatype();
			setState(441);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumndefaultContext extends ParserRuleContext {
		public TerminalNode DEFAULT_SYMBOL() { return getToken(HDBCDSParser.DEFAULT_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public ColumndefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columndefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumndefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumndefault(this);
		}
	}

	public final ColumndefaultContext columndefault() throws RecognitionException {
		ColumndefaultContext _localctx = new ColumndefaultContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_columndefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(DEFAULT_SYMBOL);
			setState(444);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==SINGLE_QUOTED_TEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnnullableContext extends ParserRuleContext {
		public TerminalNode NULL_SYMBOL() { return getToken(HDBCDSParser.NULL_SYMBOL, 0); }
		public TerminalNode NOT_SYMBOL() { return getToken(HDBCDSParser.NOT_SYMBOL, 0); }
		public ColumnnullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnnullable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumnnullable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumnnullable(this);
		}
	}

	public final ColumnnullableContext columnnullable() throws RecognitionException {
		ColumnnullableContext _localctx = new ColumnnullableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columnnullable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT_SYMBOL) {
				{
				setState(446);
				match(NOT_SYMBOL);
				}
			}

			setState(449);
			match(NULL_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameprimitiveContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TypenameprimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenameprimitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTypenameprimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTypenameprimitive(this);
		}
	}

	public final TypenameprimitiveContext typenameprimitive() throws RecognitionException {
		TypenameprimitiveContext _localctx = new TypenameprimitiveContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typenameprimitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenamecomplexContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TypenamecomplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenamecomplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTypenamecomplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTypenamecomplex(this);
		}
	}

	public final TypenamecomplexContext typenamecomplex() throws RecognitionException {
		TypenamecomplexContext _localctx = new TypenamecomplexContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typenamecomplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypecolumnnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TypecolumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typecolumnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTypecolumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTypecolumnname(this);
		}
	}

	public final TypecolumnnameContext typecolumnname() throws RecognitionException {
		TypecolumnnameContext _localctx = new TypecolumnnameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typecolumnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public ContextnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterContextname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitContextname(this);
		}
	}

	public final ContextnameContext contextname() throws RecognitionException {
		ContextnameContext _localctx = new ContextnameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_contextname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode CONST_SYMBOL() { return getToken(HDBCDSParser.CONST_SYMBOL, 0); }
		public ConstantnameContext constantname() {
			return getRuleContext(ConstantnameContext.class,0);
		}
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode EQUAL_OPERATOR() { return getToken(HDBCDSParser.EQUAL_OPERATOR, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(CONST_SYMBOL);
			setState(460);
			constantname();
			setState(461);
			match(COLON_SYMBOL);
			setState(462);
			datatype();
			setState(463);
			match(EQUAL_OPERATOR);
			setState(464);
			_la = _input.LA(1);
			if ( !(_la==INT_NUMBER || _la==SINGLE_QUOTED_TEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(465);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public ConstantnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterConstantname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitConstantname(this);
		}
	}

	public final ConstantnameContext constantname() throws RecognitionException {
		ConstantnameContext _localctx = new ConstantnameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeContext extends ParserRuleContext {
		public Datatype1Context datatype1() {
			return getRuleContext(Datatype1Context.class,0);
		}
		public Datatype2Context datatype2() {
			return getRuleContext(Datatype2Context.class,0);
		}
		public Datatype3Context datatype3() {
			return getRuleContext(Datatype3Context.class,0);
		}
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDatatype(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_datatype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(469);
				datatype1();
				}
				break;
			case 2:
				{
				setState(470);
				datatype2();
				}
				break;
			case 3:
				{
				setState(471);
				datatype3();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityContext extends ParserRuleContext {
		public TerminalNode ENTITY_SYMBOL() { return getToken(HDBCDSParser.ENTITY_SYMBOL, 0); }
		public EntitynameContext entityname() {
			return getRuleContext(EntitynameContext.class,0);
		}
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<TablecolumnContext> tablecolumn() {
			return getRuleContexts(TablecolumnContext.class);
		}
		public TablecolumnContext tablecolumn(int i) {
			return getRuleContext(TablecolumnContext.class,i);
		}
		public TechconfigContext techconfig() {
			return getRuleContext(TechconfigContext.class,0);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(474);
				comment();
				}
			}

			setState(477);
			match(ENTITY_SYMBOL);
			setState(478);
			entityname();
			setState(479);
			match(OPEN_CURLY_SYMBOL);
			setState(481); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(480);
				tablecolumn();
				}
				}
				setState(483); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT_SYMBOL || _la==KEY_SYMBOL || _la==IDENTIFIER );
			setState(485);
			match(CLOSE_CURLY_SYMBOL);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TECHNICAL_SYMBOL) {
				{
				setState(486);
				techconfig();
				}
			}

			setState(489);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntitynameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public EntitynameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterEntityname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitEntityname(this);
		}
	}

	public final EntitynameContext entityname() throws RecognitionException {
		EntitynameContext _localctx = new EntitynameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_entityname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablecolumnContext extends ParserRuleContext {
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public KeycolumnContext keycolumn() {
			return getRuleContext(KeycolumnContext.class,0);
		}
		public RegularcolumnContext regularcolumn() {
			return getRuleContext(RegularcolumnContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TablecolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablecolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTablecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTablecolumn(this);
		}
	}

	public final TablecolumnContext tablecolumn() throws RecognitionException {
		TablecolumnContext _localctx = new TablecolumnContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tablecolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(493);
				comment();
				}
			}

			setState(498);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_SYMBOL:
				{
				setState(496);
				keycolumn();
				}
				break;
			case IDENTIFIER:
				{
				setState(497);
				regularcolumn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(500);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeycolumnContext extends ParserRuleContext {
		public TerminalNode KEY_SYMBOL() { return getToken(HDBCDSParser.KEY_SYMBOL, 0); }
		public EntitycolumnnameContext entitycolumnname() {
			return getRuleContext(EntitycolumnnameContext.class,0);
		}
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public List<ColumndefaultContext> columndefault() {
			return getRuleContexts(ColumndefaultContext.class);
		}
		public ColumndefaultContext columndefault(int i) {
			return getRuleContext(ColumndefaultContext.class,i);
		}
		public List<ColumnnullableContext> columnnullable() {
			return getRuleContexts(ColumnnullableContext.class);
		}
		public ColumnnullableContext columnnullable(int i) {
			return getRuleContext(ColumnnullableContext.class,i);
		}
		public GeneratedContext generated() {
			return getRuleContext(GeneratedContext.class,0);
		}
		public KeycolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keycolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterKeycolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitKeycolumn(this);
		}
	}

	public final KeycolumnContext keycolumn() throws RecognitionException {
		KeycolumnContext _localctx = new KeycolumnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_keycolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(KEY_SYMBOL);
			setState(503);
			entitycolumnname();
			setState(504);
			match(COLON_SYMBOL);
			setState(517);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(505);
				datatype();
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEFAULT_SYMBOL || _la==NOT_SYMBOL || _la==NULL_SYMBOL) {
					{
					setState(508);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DEFAULT_SYMBOL:
						{
						setState(506);
						columndefault();
						}
						break;
					case NOT_SYMBOL:
					case NULL_SYMBOL:
						{
						setState(507);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERATED_SYMBOL) {
					{
					setState(513);
					generated();
					}
				}

				}
				}
				break;
			case ASSOCIATION_SYMBOL:
				{
				setState(516);
				association();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegularcolumnContext extends ParserRuleContext {
		public EntitycolumnnameContext entitycolumnname() {
			return getRuleContext(EntitycolumnnameContext.class,0);
		}
		public TerminalNode COLON_SYMBOL() { return getToken(HDBCDSParser.COLON_SYMBOL, 0); }
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public List<ColumndefaultContext> columndefault() {
			return getRuleContexts(ColumndefaultContext.class);
		}
		public ColumndefaultContext columndefault(int i) {
			return getRuleContext(ColumndefaultContext.class,i);
		}
		public List<ColumnnullableContext> columnnullable() {
			return getRuleContexts(ColumnnullableContext.class);
		}
		public ColumnnullableContext columnnullable(int i) {
			return getRuleContext(ColumnnullableContext.class,i);
		}
		public GeneratedContext generated() {
			return getRuleContext(GeneratedContext.class,0);
		}
		public RegularcolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularcolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterRegularcolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitRegularcolumn(this);
		}
	}

	public final RegularcolumnContext regularcolumn() throws RecognitionException {
		RegularcolumnContext _localctx = new RegularcolumnContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_regularcolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			entitycolumnname();
			setState(520);
			match(COLON_SYMBOL);
			setState(533);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(521);
				datatype();
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEFAULT_SYMBOL || _la==NOT_SYMBOL || _la==NULL_SYMBOL) {
					{
					setState(524);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DEFAULT_SYMBOL:
						{
						setState(522);
						columndefault();
						}
						break;
					case NOT_SYMBOL:
					case NULL_SYMBOL:
						{
						setState(523);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(528);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERATED_SYMBOL) {
					{
					setState(529);
					generated();
					}
				}

				}
				}
				break;
			case ASSOCIATION_SYMBOL:
				{
				setState(532);
				association();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntitycolumnnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public EntitycolumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entitycolumnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterEntitycolumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitEntitycolumnname(this);
		}
	}

	public final EntitycolumnnameContext entitycolumnname() throws RecognitionException {
		EntitycolumnnameContext _localctx = new EntitycolumnnameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_entitycolumnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationContext extends ParserRuleContext {
		public TerminalNode ASSOCIATION_SYMBOL() { return getToken(HDBCDSParser.ASSOCIATION_SYMBOL, 0); }
		public TerminalNode OPEN_RECT_SYMBOL() { return getToken(HDBCDSParser.OPEN_RECT_SYMBOL, 0); }
		public AssociationfromcardinalityContext associationfromcardinality() {
			return getRuleContext(AssociationfromcardinalityContext.class,0);
		}
		public TerminalNode CLOSE_RECT_SYMBOL() { return getToken(HDBCDSParser.CLOSE_RECT_SYMBOL, 0); }
		public TerminalNode TO_SYMBOL() { return getToken(HDBCDSParser.TO_SYMBOL, 0); }
		public AssociationreferencetoContext associationreferenceto() {
			return getRuleContext(AssociationreferencetoContext.class,0);
		}
		public TerminalNode ON_SYMBOL() { return getToken(HDBCDSParser.ON_SYMBOL, 0); }
		public AssociationjoinexprContext associationjoinexpr() {
			return getRuleContext(AssociationjoinexprContext.class,0);
		}
		public AssociatedcolsContext associatedcols() {
			return getRuleContext(AssociatedcolsContext.class,0);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBCDSParser.COMMA_SYMBOL, 0); }
		public AssociationtocardinalityContext associationtocardinality() {
			return getRuleContext(AssociationtocardinalityContext.class,0);
		}
		public AssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_association; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociation(this);
		}
	}

	public final AssociationContext association() throws RecognitionException {
		AssociationContext _localctx = new AssociationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_association);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(ASSOCIATION_SYMBOL);
			setState(538);
			match(OPEN_RECT_SYMBOL);
			setState(539);
			associationfromcardinality();
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL) {
				{
				setState(540);
				match(COMMA_SYMBOL);
				setState(541);
				associationtocardinality();
				}
			}

			setState(544);
			match(CLOSE_RECT_SYMBOL);
			setState(545);
			match(TO_SYMBOL);
			setState(546);
			associationreferenceto();
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON_SYMBOL:
				{
				setState(547);
				match(ON_SYMBOL);
				setState(548);
				associationjoinexpr();
				}
				break;
			case OPEN_CURLY_SYMBOL:
				{
				setState(549);
				associatedcols();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationreferencetoContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public AssociationreferencetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationreferenceto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociationreferenceto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociationreferenceto(this);
		}
	}

	public final AssociationreferencetoContext associationreferenceto() throws RecognitionException {
		AssociationreferencetoContext _localctx = new AssociationreferencetoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_associationreferenceto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationjoinexprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssociationjoinexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationjoinexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociationjoinexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociationjoinexpr(this);
		}
	}

	public final AssociationjoinexprContext associationjoinexpr() throws RecognitionException {
		AssociationjoinexprContext _localctx = new AssociationjoinexprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_associationjoinexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationfromcardinalityContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode ASSOCCARD() { return getToken(HDBCDSParser.ASSOCCARD, 0); }
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public AssociationfromcardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationfromcardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociationfromcardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociationfromcardinality(this);
		}
	}

	public final AssociationfromcardinalityContext associationfromcardinality() throws RecognitionException {
		AssociationfromcardinalityContext _localctx = new AssociationfromcardinalityContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_associationfromcardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSOCCARD) | (1L << MULT_OPERATOR) | (1L << INT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationtocardinalityContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode ASSOCCARD() { return getToken(HDBCDSParser.ASSOCCARD, 0); }
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public AssociationtocardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationtocardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociationtocardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociationtocardinality(this);
		}
	}

	public final AssociationtocardinalityContext associationtocardinality() throws RecognitionException {
		AssociationtocardinalityContext _localctx = new AssociationtocardinalityContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_associationtocardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSOCCARD) | (1L << MULT_OPERATOR) | (1L << INT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociatedcolsContext extends ParserRuleContext {
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public List<AssociatedcolnameContext> associatedcolname() {
			return getRuleContexts(AssociatedcolnameContext.class);
		}
		public AssociatedcolnameContext associatedcolname(int i) {
			return getRuleContext(AssociatedcolnameContext.class,i);
		}
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public AssociatedcolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associatedcols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociatedcols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociatedcols(this);
		}
	}

	public final AssociatedcolsContext associatedcols() throws RecognitionException {
		AssociatedcolsContext _localctx = new AssociatedcolsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_associatedcols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(OPEN_CURLY_SYMBOL);
			setState(561);
			associatedcolname();
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(562);
				match(COMMA_SYMBOL);
				setState(563);
				associatedcolname();
				}
				}
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(569);
			match(CLOSE_CURLY_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociatedcolnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public AssociatedcolnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associatedcolname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterAssociatedcolname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitAssociatedcolname(this);
		}
	}

	public final AssociatedcolnameContext associatedcolname() throws RecognitionException {
		AssociatedcolnameContext _localctx = new AssociatedcolnameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_associatedcolname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneratedContext extends ParserRuleContext {
		public TerminalNode GENERATED_SYMBOL() { return getToken(HDBCDSParser.GENERATED_SYMBOL, 0); }
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public TerminalNode IDENTITY_SYMBOL() { return getToken(HDBCDSParser.IDENTITY_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public GeneratedalwaysContext generatedalways() {
			return getRuleContext(GeneratedalwaysContext.class,0);
		}
		public GeneratedbydefaultContext generatedbydefault() {
			return getRuleContext(GeneratedbydefaultContext.class,0);
		}
		public List<IdentitystartContext> identitystart() {
			return getRuleContexts(IdentitystartContext.class);
		}
		public IdentitystartContext identitystart(int i) {
			return getRuleContext(IdentitystartContext.class,i);
		}
		public List<IdentityincrementContext> identityincrement() {
			return getRuleContexts(IdentityincrementContext.class);
		}
		public IdentityincrementContext identityincrement(int i) {
			return getRuleContext(IdentityincrementContext.class,i);
		}
		public List<IdentityminclauseContext> identityminclause() {
			return getRuleContexts(IdentityminclauseContext.class);
		}
		public IdentityminclauseContext identityminclause(int i) {
			return getRuleContext(IdentityminclauseContext.class,i);
		}
		public List<IdentitymaxclauseContext> identitymaxclause() {
			return getRuleContexts(IdentitymaxclauseContext.class);
		}
		public IdentitymaxclauseContext identitymaxclause(int i) {
			return getRuleContext(IdentitymaxclauseContext.class,i);
		}
		public List<IdentitynochacheContext> identitynochache() {
			return getRuleContexts(IdentitynochacheContext.class);
		}
		public IdentitynochacheContext identitynochache(int i) {
			return getRuleContext(IdentitynochacheContext.class,i);
		}
		public List<IdentitynocycleContext> identitynocycle() {
			return getRuleContexts(IdentitynocycleContext.class);
		}
		public IdentitynocycleContext identitynocycle(int i) {
			return getRuleContext(IdentitynocycleContext.class,i);
		}
		public GeneratedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGenerated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGenerated(this);
		}
	}

	public final GeneratedContext generated() throws RecognitionException {
		GeneratedContext _localctx = new GeneratedContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_generated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(GENERATED_SYMBOL);
			setState(576);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALWAYS_SYMBOL:
				{
				setState(574);
				generatedalways();
				}
				break;
			case BY_SYMBOL:
				{
				setState(575);
				generatedbydefault();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(578);
			match(AS_SYMBOL);
			setState(579);
			match(IDENTITY_SYMBOL);
			setState(580);
			match(OPEN_PAR_SYMBOL);
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT_SYMBOL) | (1L << MINVALUE_SYMBOL) | (1L << MAXVALUE_SYMBOL) | (1L << CYCLE_SYMBOL) | (1L << START_SYMBOL) | (1L << CACHE_SYMBOL))) != 0) || _la==NO_SYMBOL) {
				{
				setState(587);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(581);
					identitystart();
					}
					break;
				case 2:
					{
					setState(582);
					identityincrement();
					}
					break;
				case 3:
					{
					setState(583);
					identityminclause();
					}
					break;
				case 4:
					{
					setState(584);
					identitymaxclause();
					}
					break;
				case 5:
					{
					setState(585);
					identitynochache();
					}
					break;
				case 6:
					{
					setState(586);
					identitynocycle();
					}
					break;
				}
				}
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(592);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneratedalwaysContext extends ParserRuleContext {
		public TerminalNode ALWAYS_SYMBOL() { return getToken(HDBCDSParser.ALWAYS_SYMBOL, 0); }
		public GeneratedalwaysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatedalways; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGeneratedalways(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGeneratedalways(this);
		}
	}

	public final GeneratedalwaysContext generatedalways() throws RecognitionException {
		GeneratedalwaysContext _localctx = new GeneratedalwaysContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_generatedalways);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			match(ALWAYS_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneratedbydefaultContext extends ParserRuleContext {
		public TerminalNode BY_SYMBOL() { return getToken(HDBCDSParser.BY_SYMBOL, 0); }
		public TerminalNode DEFAULT_SYMBOL() { return getToken(HDBCDSParser.DEFAULT_SYMBOL, 0); }
		public GeneratedbydefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatedbydefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGeneratedbydefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGeneratedbydefault(this);
		}
	}

	public final GeneratedbydefaultContext generatedbydefault() throws RecognitionException {
		GeneratedbydefaultContext _localctx = new GeneratedbydefaultContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_generatedbydefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(BY_SYMBOL);
			setState(597);
			match(DEFAULT_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitystartContext extends ParserRuleContext {
		public TerminalNode START_SYMBOL() { return getToken(HDBCDSParser.START_SYMBOL, 0); }
		public TerminalNode WITH_SYMBOL() { return getToken(HDBCDSParser.WITH_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public IdentitystartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitystart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitystart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitystart(this);
		}
	}

	public final IdentitystartContext identitystart() throws RecognitionException {
		IdentitystartContext _localctx = new IdentitystartContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_identitystart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(START_SYMBOL);
			setState(600);
			match(WITH_SYMBOL);
			setState(601);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentityincrementContext extends ParserRuleContext {
		public TerminalNode INCREMENT_SYMBOL() { return getToken(HDBCDSParser.INCREMENT_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBCDSParser.BY_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public IdentityincrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identityincrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentityincrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentityincrement(this);
		}
	}

	public final IdentityincrementContext identityincrement() throws RecognitionException {
		IdentityincrementContext _localctx = new IdentityincrementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_identityincrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(INCREMENT_SYMBOL);
			setState(604);
			match(BY_SYMBOL);
			setState(605);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentityminclauseContext extends ParserRuleContext {
		public IdentitynominContext identitynomin() {
			return getRuleContext(IdentitynominContext.class,0);
		}
		public IdentityminContext identitymin() {
			return getRuleContext(IdentityminContext.class,0);
		}
		public IdentityminclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identityminclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentityminclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentityminclause(this);
		}
	}

	public final IdentityminclauseContext identityminclause() throws RecognitionException {
		IdentityminclauseContext _localctx = new IdentityminclauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_identityminclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NO_SYMBOL:
				{
				setState(607);
				identitynomin();
				}
				break;
			case MINVALUE_SYMBOL:
				{
				setState(608);
				identitymin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitynominContext extends ParserRuleContext {
		public TerminalNode NO_SYMBOL() { return getToken(HDBCDSParser.NO_SYMBOL, 0); }
		public TerminalNode MINVALUE_SYMBOL() { return getToken(HDBCDSParser.MINVALUE_SYMBOL, 0); }
		public IdentitynominContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynomin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitynomin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitynomin(this);
		}
	}

	public final IdentitynominContext identitynomin() throws RecognitionException {
		IdentitynominContext _localctx = new IdentitynominContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_identitynomin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(NO_SYMBOL);
			setState(612);
			match(MINVALUE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentityminContext extends ParserRuleContext {
		public TerminalNode MINVALUE_SYMBOL() { return getToken(HDBCDSParser.MINVALUE_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public IdentityminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitymin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitymin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitymin(this);
		}
	}

	public final IdentityminContext identitymin() throws RecognitionException {
		IdentityminContext _localctx = new IdentityminContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_identitymin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(MINVALUE_SYMBOL);
			setState(615);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitymaxclauseContext extends ParserRuleContext {
		public IdentitynomaxContext identitynomax() {
			return getRuleContext(IdentitynomaxContext.class,0);
		}
		public IdentitymaxContext identitymax() {
			return getRuleContext(IdentitymaxContext.class,0);
		}
		public IdentitymaxclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitymaxclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitymaxclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitymaxclause(this);
		}
	}

	public final IdentitymaxclauseContext identitymaxclause() throws RecognitionException {
		IdentitymaxclauseContext _localctx = new IdentitymaxclauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_identitymaxclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NO_SYMBOL:
				{
				setState(617);
				identitynomax();
				}
				break;
			case MAXVALUE_SYMBOL:
				{
				setState(618);
				identitymax();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitynomaxContext extends ParserRuleContext {
		public TerminalNode NO_SYMBOL() { return getToken(HDBCDSParser.NO_SYMBOL, 0); }
		public TerminalNode MAXVALUE_SYMBOL() { return getToken(HDBCDSParser.MAXVALUE_SYMBOL, 0); }
		public IdentitynomaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynomax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitynomax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitynomax(this);
		}
	}

	public final IdentitynomaxContext identitynomax() throws RecognitionException {
		IdentitynomaxContext _localctx = new IdentitynomaxContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_identitynomax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(NO_SYMBOL);
			setState(622);
			match(MAXVALUE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitymaxContext extends ParserRuleContext {
		public TerminalNode MAXVALUE_SYMBOL() { return getToken(HDBCDSParser.MAXVALUE_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public IdentitymaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitymax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitymax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitymax(this);
		}
	}

	public final IdentitymaxContext identitymax() throws RecognitionException {
		IdentitymaxContext _localctx = new IdentitymaxContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_identitymax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(MAXVALUE_SYMBOL);
			setState(625);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitynochacheContext extends ParserRuleContext {
		public TerminalNode CACHE_SYMBOL() { return getToken(HDBCDSParser.CACHE_SYMBOL, 0); }
		public TerminalNode NO_SYMBOL() { return getToken(HDBCDSParser.NO_SYMBOL, 0); }
		public IdentitynochacheContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynochache; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitynochache(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitynochache(this);
		}
	}

	public final IdentitynochacheContext identitynochache() throws RecognitionException {
		IdentitynochacheContext _localctx = new IdentitynochacheContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_identitynochache);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NO_SYMBOL) {
				{
				setState(627);
				match(NO_SYMBOL);
				}
			}

			setState(630);
			match(CACHE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentitynocycleContext extends ParserRuleContext {
		public TerminalNode CYCLE_SYMBOL() { return getToken(HDBCDSParser.CYCLE_SYMBOL, 0); }
		public TerminalNode NO_SYMBOL() { return getToken(HDBCDSParser.NO_SYMBOL, 0); }
		public IdentitynocycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynocycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentitynocycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentitynocycle(this);
		}
	}

	public final IdentitynocycleContext identitynocycle() throws RecognitionException {
		IdentitynocycleContext _localctx = new IdentitynocycleContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_identitynocycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NO_SYMBOL) {
				{
				setState(632);
				match(NO_SYMBOL);
				}
			}

			setState(635);
			match(CYCLE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TechconfigContext extends ParserRuleContext {
		public TerminalNode TECHNICAL_SYMBOL() { return getToken(HDBCDSParser.TECHNICAL_SYMBOL, 0); }
		public TerminalNode CONFIGURATION_SYMBOL() { return getToken(HDBCDSParser.CONFIGURATION_SYMBOL, 0); }
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public TabletypeContext tabletype() {
			return getRuleContext(TabletypeContext.class,0);
		}
		public TechconfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_techconfig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTechconfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTechconfig(this);
		}
	}

	public final TechconfigContext techconfig() throws RecognitionException {
		TechconfigContext _localctx = new TechconfigContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_techconfig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(TECHNICAL_SYMBOL);
			setState(638);
			match(CONFIGURATION_SYMBOL);
			setState(639);
			match(OPEN_CURLY_SYMBOL);
			{
			setState(640);
			tabletype();
			}
			setState(641);
			match(CLOSE_CURLY_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TabletypeContext extends ParserRuleContext {
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public Tabletype1Context tabletype1() {
			return getRuleContext(Tabletype1Context.class,0);
		}
		public Tabletype2Context tabletype2() {
			return getRuleContext(Tabletype2Context.class,0);
		}
		public TabletypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabletype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTabletype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTabletype(this);
		}
	}

	public final TabletypeContext tabletype() throws RecognitionException {
		TabletypeContext _localctx = new TabletypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_tabletype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLUMN_SYMBOL:
				{
				setState(643);
				tabletype1();
				}
				break;
			case ROW_SYMBOL:
				{
				setState(644);
				tabletype2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(647);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tabletype1Context extends ParserRuleContext {
		public TerminalNode COLUMN_SYMBOL() { return getToken(HDBCDSParser.COLUMN_SYMBOL, 0); }
		public TerminalNode STORE_SYMBOL() { return getToken(HDBCDSParser.STORE_SYMBOL, 0); }
		public Tabletype1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabletype1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTabletype1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTabletype1(this);
		}
	}

	public final Tabletype1Context tabletype1() throws RecognitionException {
		Tabletype1Context _localctx = new Tabletype1Context(_ctx, getState());
		enterRule(_localctx, 88, RULE_tabletype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(COLUMN_SYMBOL);
			setState(650);
			match(STORE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tabletype2Context extends ParserRuleContext {
		public TerminalNode ROW_SYMBOL() { return getToken(HDBCDSParser.ROW_SYMBOL, 0); }
		public TerminalNode STORE_SYMBOL() { return getToken(HDBCDSParser.STORE_SYMBOL, 0); }
		public Tabletype2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabletype2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTabletype2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTabletype2(this);
		}
	}

	public final Tabletype2Context tabletype2() throws RecognitionException {
		Tabletype2Context _localctx = new Tabletype2Context(_ctx, getState());
		enterRule(_localctx, 90, RULE_tabletype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			match(ROW_SYMBOL);
			setState(653);
			match(STORE_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public TerminalNode VIEW_SYMBOL() { return getToken(HDBCDSParser.VIEW_SYMBOL, 0); }
		public ViewnameContext viewname() {
			return getRuleContext(ViewnameContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public TerminalNode SELECT_SYMBOL() { return getToken(HDBCDSParser.SELECT_SYMBOL, 0); }
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public ViewprojectionlistContext viewprojectionlist() {
			return getRuleContext(ViewprojectionlistContext.class,0);
		}
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public TerminalNode SEMICOLON_SYMBOL() { return getToken(HDBCDSParser.SEMICOLON_SYMBOL, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode DEFINE_SYMBOL() { return getToken(HDBCDSParser.DEFINE_SYMBOL, 0); }
		public ViewoptionsContext viewoptions() {
			return getRuleContext(ViewoptionsContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDefine(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_SYMBOL) {
				{
				setState(655);
				comment();
				}
			}

			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINE_SYMBOL) {
				{
				setState(658);
				match(DEFINE_SYMBOL);
				}
			}

			setState(661);
			match(VIEW_SYMBOL);
			setState(662);
			viewname();
			setState(663);
			match(AS_SYMBOL);
			setState(664);
			match(SELECT_SYMBOL);
			setState(665);
			fromClause();
			setState(666);
			match(OPEN_CURLY_SYMBOL);
			setState(667);
			viewprojectionlist();
			setState(668);
			match(CLOSE_CURLY_SYMBOL);
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_SYMBOL) {
				{
				setState(669);
				viewoptions();
				}
			}

			setState(672);
			match(SEMICOLON_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewnameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ViewnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterViewname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitViewname(this);
		}
	}

	public final ViewnameContext viewname() throws RecognitionException {
		ViewnameContext _localctx = new ViewnameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_viewname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewprojectionlistContext extends ParserRuleContext {
		public SelectItemListContext selectItemList() {
			return getRuleContext(SelectItemListContext.class,0);
		}
		public ViewprojectionlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewprojectionlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterViewprojectionlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitViewprojectionlist(this);
		}
	}

	public final ViewprojectionlistContext viewprojectionlist() throws RecognitionException {
		ViewprojectionlistContext _localctx = new ViewprojectionlistContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_viewprojectionlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			selectItemList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewoptionsContext extends ParserRuleContext {
		public ViewprivcheckContext viewprivcheck() {
			return getRuleContext(ViewprivcheckContext.class,0);
		}
		public ViewoptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewoptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterViewoptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitViewoptions(this);
		}
	}

	public final ViewoptionsContext viewoptions() throws RecognitionException {
		ViewoptionsContext _localctx = new ViewoptionsContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_viewoptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(678);
			viewprivcheck();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewprivcheckContext extends ParserRuleContext {
		public TerminalNode WITH_SYMBOL() { return getToken(HDBCDSParser.WITH_SYMBOL, 0); }
		public TerminalNode STRUCTURED_SYMBOL() { return getToken(HDBCDSParser.STRUCTURED_SYMBOL, 0); }
		public TerminalNode PRIVILEGE_SYMBOL() { return getToken(HDBCDSParser.PRIVILEGE_SYMBOL, 0); }
		public TerminalNode CHECK_SYMBOL() { return getToken(HDBCDSParser.CHECK_SYMBOL, 0); }
		public ViewprivcheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewprivcheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterViewprivcheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitViewprivcheck(this);
		}
	}

	public final ViewprivcheckContext viewprivcheck() throws RecognitionException {
		ViewprivcheckContext _localctx = new ViewprivcheckContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_viewprivcheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(WITH_SYMBOL);
			setState(681);
			match(STRUCTURED_SYMBOL);
			setState(682);
			match(PRIVILEGE_SYMBOL);
			setState(683);
			match(CHECK_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype1Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public Datatype1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDatatype1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDatatype1(this);
		}
	}

	public final Datatype1Context datatype1() throws RecognitionException {
		Datatype1Context _localctx = new Datatype1Context(_ctx, getState());
		enterRule(_localctx, 102, RULE_datatype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			match(IDENTIFIER);
			setState(686);
			match(OPEN_PAR_SYMBOL);
			setState(687);
			match(INT_NUMBER);
			setState(688);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype2Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<TerminalNode> INT_NUMBER() { return getTokens(HDBCDSParser.INT_NUMBER); }
		public TerminalNode INT_NUMBER(int i) {
			return getToken(HDBCDSParser.INT_NUMBER, i);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBCDSParser.COMMA_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public Datatype2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDatatype2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDatatype2(this);
		}
	}

	public final Datatype2Context datatype2() throws RecognitionException {
		Datatype2Context _localctx = new Datatype2Context(_ctx, getState());
		enterRule(_localctx, 104, RULE_datatype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(IDENTIFIER);
			setState(691);
			match(OPEN_PAR_SYMBOL);
			setState(692);
			match(INT_NUMBER);
			setState(693);
			match(COMMA_SYMBOL);
			setState(694);
			match(INT_NUMBER);
			setState(695);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype3Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public Datatype3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDatatype3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDatatype3(this);
		}
	}

	public final Datatype3Context datatype3() throws RecognitionException {
		Datatype3Context _localctx = new Datatype3Context(_ctx, getState());
		enterRule(_localctx, 106, RULE_datatype3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public QueryExpressionParensContext queryExpressionParens() {
			return getRuleContext(QueryExpressionParensContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_selectStatement);
		try {
			setState(701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(699);
				queryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				queryExpressionParens();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryExpressionContext extends ParserRuleContext {
		public QueryExpressionBodyContext queryExpressionBody() {
			return getRuleContext(QueryExpressionBodyContext.class,0);
		}
		public QueryExpressionParensContext queryExpressionParens() {
			return getRuleContext(QueryExpressionParensContext.class,0);
		}
		public WithClauseContext withClause() {
			return getRuleContext(WithClauseContext.class,0);
		}
		public LockingClauseContext lockingClause() {
			return getRuleContext(LockingClauseContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public QueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQueryExpression(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_queryExpression);
		int _la;
		try {
			setState(731);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH_SYMBOL) {
					{
					setState(703);
					withClause();
					}
				}

				setState(721);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(706);
					queryExpressionBody(0);
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER_SYMBOL) {
						{
						setState(707);
						orderClause();
						}
					}

					setState(711);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LIMIT_SYMBOL) {
						{
						setState(710);
						limitClause();
						}
					}

					}
					break;
				case 2:
					{
					setState(713);
					queryExpressionParens();
					setState(719);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ORDER_SYMBOL:
						{
						setState(714);
						orderClause();
						setState(716);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LIMIT_SYMBOL) {
							{
							setState(715);
							limitClause();
							}
						}

						}
						break;
					case LIMIT_SYMBOL:
						{
						setState(718);
						limitClause();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(723);
					lockingClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				withClause();
				setState(727);
				queryExpressionParens();
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(728);
					lockingClause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryExpressionBodyContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public List<QueryExpressionParensContext> queryExpressionParens() {
			return getRuleContexts(QueryExpressionParensContext.class);
		}
		public QueryExpressionParensContext queryExpressionParens(int i) {
			return getRuleContext(QueryExpressionParensContext.class,i);
		}
		public TerminalNode UNION_SYMBOL() { return getToken(HDBCDSParser.UNION_SYMBOL, 0); }
		public UnionOptionContext unionOption() {
			return getRuleContext(UnionOptionContext.class,0);
		}
		public QueryExpressionBodyContext queryExpressionBody() {
			return getRuleContext(QueryExpressionBodyContext.class,0);
		}
		public QueryExpressionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpressionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQueryExpressionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQueryExpressionBody(this);
		}
	}

	public final QueryExpressionBodyContext queryExpressionBody() throws RecognitionException {
		return queryExpressionBody(0);
	}

	private QueryExpressionBodyContext queryExpressionBody(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryExpressionBodyContext _localctx = new QueryExpressionBodyContext(_ctx, _parentState);
		QueryExpressionBodyContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_queryExpressionBody, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT_SYMBOL:
				{
				setState(734);
				querySpecification();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(735);
				queryExpressionParens();
				setState(736);
				match(UNION_SYMBOL);
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
					{
					setState(737);
					unionOption();
					}
				}

				setState(742);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT_SYMBOL:
					{
					setState(740);
					querySpecification();
					}
					break;
				case OPEN_PAR_SYMBOL:
					{
					setState(741);
					queryExpressionParens();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(757);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new QueryExpressionBodyContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_queryExpressionBody);
					setState(746);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(747);
					match(UNION_SYMBOL);
					setState(749);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
						{
						setState(748);
						unionOption();
						}
					}

					setState(753);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SELECT_SYMBOL:
						{
						setState(751);
						querySpecification();
						}
						break;
					case OPEN_PAR_SYMBOL:
						{
						setState(752);
						queryExpressionParens();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(759);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QueryExpressionParensContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public QueryExpressionParensContext queryExpressionParens() {
			return getRuleContext(QueryExpressionParensContext.class,0);
		}
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public QueryExpressionParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpressionParens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQueryExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQueryExpressionParens(this);
		}
	}

	public final QueryExpressionParensContext queryExpressionParens() throws RecognitionException {
		QueryExpressionParensContext _localctx = new QueryExpressionParensContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_queryExpressionParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(OPEN_PAR_SYMBOL);
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(761);
				queryExpressionParens();
				}
				break;
			case 2:
				{
				setState(762);
				queryExpression();
				}
				break;
			}
			setState(765);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public TerminalNode SELECT_SYMBOL() { return getToken(HDBCDSParser.SELECT_SYMBOL, 0); }
		public SelectItemListContext selectItemList() {
			return getRuleContext(SelectItemListContext.class,0);
		}
		public List<SelectOptionContext> selectOption() {
			return getRuleContexts(SelectOptionContext.class);
		}
		public SelectOptionContext selectOption(int i) {
			return getRuleContext(SelectOptionContext.class,i);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQuerySpecification(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(SELECT_SYMBOL);
			setState(771);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
				{
				{
				setState(768);
				selectOption();
				}
				}
				setState(773);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(774);
			selectItemList();
			setState(776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(775);
				fromClause();
				}
				break;
			}
			setState(779);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(778);
				whereClause();
				}
				break;
			}
			setState(782);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(781);
				groupByClause();
				}
				break;
			}
			setState(785);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(784);
				havingClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubqueryContext extends ParserRuleContext {
		public QueryExpressionParensContext queryExpressionParens() {
			return getRuleContext(QueryExpressionParensContext.class,0);
		}
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			queryExpressionParens();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecOptionContext extends ParserRuleContext {
		public TerminalNode ALL_SYMBOL() { return getToken(HDBCDSParser.ALL_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBCDSParser.DISTINCT_SYMBOL, 0); }
		public QuerySpecOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQuerySpecOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQuerySpecOption(this);
		}
	}

	public final QuerySpecOptionContext querySpecOption() throws RecognitionException {
		QuerySpecOptionContext _localctx = new QuerySpecOptionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_querySpecOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			_la = _input.LA(1);
			if ( !(_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public TerminalNode LIMIT_SYMBOL() { return getToken(HDBCDSParser.LIMIT_SYMBOL, 0); }
		public LimitOptionsContext limitOptions() {
			return getRuleContext(LimitOptionsContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(LIMIT_SYMBOL);
			setState(792);
			limitOptions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleLimitClauseContext extends ParserRuleContext {
		public TerminalNode LIMIT_SYMBOL() { return getToken(HDBCDSParser.LIMIT_SYMBOL, 0); }
		public LimitOptionContext limitOption() {
			return getRuleContext(LimitOptionContext.class,0);
		}
		public SimpleLimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLimitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleLimitClause(this);
		}
	}

	public final SimpleLimitClauseContext simpleLimitClause() throws RecognitionException {
		SimpleLimitClauseContext _localctx = new SimpleLimitClauseContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_simpleLimitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			match(LIMIT_SYMBOL);
			setState(795);
			limitOption();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitOptionsContext extends ParserRuleContext {
		public List<LimitOptionContext> limitOption() {
			return getRuleContexts(LimitOptionContext.class);
		}
		public LimitOptionContext limitOption(int i) {
			return getRuleContext(LimitOptionContext.class,i);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBCDSParser.COMMA_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(HDBCDSParser.OFFSET_SYMBOL, 0); }
		public LimitOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLimitOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLimitOptions(this);
		}
	}

	public final LimitOptionsContext limitOptions() throws RecognitionException {
		LimitOptionsContext _localctx = new LimitOptionsContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_limitOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			limitOption();
			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) {
				{
				setState(798);
				_la = _input.LA(1);
				if ( !(_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(799);
				limitOption();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitOptionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBCDSParser.PARAM_MARKER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public LimitOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLimitOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLimitOption(this);
		}
	}

	public final LimitOptionContext limitOption() throws RecognitionException {
		LimitOptionContext _localctx = new LimitOptionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_limitOption);
		int _la;
		try {
			setState(804);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(802);
				identifier();
				}
				break;
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PARAM_MARKER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(803);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PARAM_MARKER) | (1L << INT_NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingClauseContext extends ParserRuleContext {
		public TerminalNode HAVING_SYMBOL() { return getToken(HDBCDSParser.HAVING_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			match(HAVING_SYMBOL);
			setState(807);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowClauseContext extends ParserRuleContext {
		public TerminalNode WINDOW_SYMBOL() { return getToken(HDBCDSParser.WINDOW_SYMBOL, 0); }
		public List<WindowDefinitionContext> windowDefinition() {
			return getRuleContexts(WindowDefinitionContext.class);
		}
		public WindowDefinitionContext windowDefinition(int i) {
			return getRuleContext(WindowDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public WindowClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowClause(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_windowClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			match(WINDOW_SYMBOL);
			setState(810);
			windowDefinition();
			setState(815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(811);
				match(COMMA_SYMBOL);
				setState(812);
				windowDefinition();
				}
				}
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowDefinitionContext extends ParserRuleContext {
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public WindowDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowDefinition(this);
		}
	}

	public final WindowDefinitionContext windowDefinition() throws RecognitionException {
		WindowDefinitionContext _localctx = new WindowDefinitionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_windowDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			windowName();
			setState(819);
			match(AS_SYMBOL);
			setState(820);
			windowSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public WindowSpecDetailsContext windowSpecDetails() {
			return getRuleContext(WindowSpecDetailsContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowSpec(this);
		}
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_windowSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(OPEN_PAR_SYMBOL);
			setState(823);
			windowSpecDetails();
			setState(824);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecDetailsContext extends ParserRuleContext {
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public TerminalNode PARTITION_SYMBOL() { return getToken(HDBCDSParser.PARTITION_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBCDSParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public WindowFrameClauseContext windowFrameClause() {
			return getRuleContext(WindowFrameClauseContext.class,0);
		}
		public WindowSpecDetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpecDetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowSpecDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowSpecDetails(this);
		}
	}

	public final WindowSpecDetailsContext windowSpecDetails() throws RecognitionException {
		WindowSpecDetailsContext _localctx = new WindowSpecDetailsContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_windowSpecDetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (COALESCE_SYMBOL - 67)) | (1L << (NULLS_SYMBOL - 67)) | (1L << (PRECEDING_SYMBOL - 67)) | (1L << (UNBOUNDED_SYMBOL - 67)) | (1L << (CURRENT_SYMBOL - 67)) | (1L << (FOLLOWING_SYMBOL - 67)) | (1L << (EXCLUDE_SYMBOL - 67)) | (1L << (TIES_SYMBOL - 67)) | (1L << (OTHERS_SYMBOL - 67)) | (1L << (AVG_SYMBOL - 67)) | (1L << (MODE_SYMBOL - 67)) | (1L << (SHARE_SYMBOL - 67)) | (1L << (SKIP_SYMBOL - 67)) | (1L << (LOCKED_SYMBOL - 67)) | (1L << (ANY_SYMBOL - 67)) | (1L << (AT_SYMBOL - 67)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (DATE_SYMBOL - 135)) | (1L << (ESCAPE_SYMBOL - 135)) | (1L << (FIRST_SYMBOL - 135)) | (1L << (FULL_SYMBOL - 135)) | (1L << (LAST_SYMBOL - 135)) | (1L << (OFFSET_SYMBOL - 135)) | (1L << (TIMESTAMP_SYMBOL - 135)) | (1L << (TIME_SYMBOL - 135)) | (1L << (UNKNOWN_SYMBOL - 135)) | (1L << (NOWAIT_SYMBOL - 135)) | (1L << (IDENTIFIER - 135)) | (1L << (DOUBLE_QUOTED_TEXT - 135)))) != 0)) {
				{
				setState(826);
				windowName();
				}
			}

			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION_SYMBOL) {
				{
				setState(829);
				match(PARTITION_SYMBOL);
				setState(830);
				match(BY_SYMBOL);
				setState(831);
				orderList();
				}
			}

			setState(835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_SYMBOL) {
				{
				setState(834);
				orderClause();
				}
			}

			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROWS_SYMBOL) {
				{
				setState(837);
				windowFrameClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameClauseContext extends ParserRuleContext {
		public WindowFrameUnitsContext windowFrameUnits() {
			return getRuleContext(WindowFrameUnitsContext.class,0);
		}
		public WindowFrameExtentContext windowFrameExtent() {
			return getRuleContext(WindowFrameExtentContext.class,0);
		}
		public WindowFrameExclusionContext windowFrameExclusion() {
			return getRuleContext(WindowFrameExclusionContext.class,0);
		}
		public WindowFrameClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameClause(this);
		}
	}

	public final WindowFrameClauseContext windowFrameClause() throws RecognitionException {
		WindowFrameClauseContext _localctx = new WindowFrameClauseContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_windowFrameClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			windowFrameUnits();
			setState(841);
			windowFrameExtent();
			setState(843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUDE_SYMBOL) {
				{
				setState(842);
				windowFrameExclusion();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameUnitsContext extends ParserRuleContext {
		public TerminalNode ROWS_SYMBOL() { return getToken(HDBCDSParser.ROWS_SYMBOL, 0); }
		public WindowFrameUnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameUnits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameUnits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameUnits(this);
		}
	}

	public final WindowFrameUnitsContext windowFrameUnits() throws RecognitionException {
		WindowFrameUnitsContext _localctx = new WindowFrameUnitsContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_windowFrameUnits);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			match(ROWS_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameExtentContext extends ParserRuleContext {
		public WindowFrameStartContext windowFrameStart() {
			return getRuleContext(WindowFrameStartContext.class,0);
		}
		public WindowFrameBetweenContext windowFrameBetween() {
			return getRuleContext(WindowFrameBetweenContext.class,0);
		}
		public WindowFrameExtentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameExtent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameExtent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameExtent(this);
		}
	}

	public final WindowFrameExtentContext windowFrameExtent() throws RecognitionException {
		WindowFrameExtentContext _localctx = new WindowFrameExtentContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_windowFrameExtent);
		try {
			setState(849);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PARAM_MARKER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(847);
				windowFrameStart();
				}
				break;
			case BETWEEN_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(848);
				windowFrameBetween();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameStartContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBCDSParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(HDBCDSParser.PRECEDING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBCDSParser.PARAM_MARKER, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBCDSParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBCDSParser.ROW_SYMBOL, 0); }
		public WindowFrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameStart(this);
		}
	}

	public final WindowFrameStartContext windowFrameStart() throws RecognitionException {
		WindowFrameStartContext _localctx = new WindowFrameStartContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_windowFrameStart);
		try {
			setState(860);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNBOUNDED_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(851);
				match(UNBOUNDED_SYMBOL);
				setState(852);
				match(PRECEDING_SYMBOL);
				}
				break;
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(853);
				ulonglong_number();
				setState(854);
				match(PRECEDING_SYMBOL);
				}
				break;
			case PARAM_MARKER:
				enterOuterAlt(_localctx, 3);
				{
				setState(856);
				match(PARAM_MARKER);
				setState(857);
				match(PRECEDING_SYMBOL);
				}
				break;
			case CURRENT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(858);
				match(CURRENT_SYMBOL);
				setState(859);
				match(ROW_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBetweenContext extends ParserRuleContext {
		public TerminalNode BETWEEN_SYMBOL() { return getToken(HDBCDSParser.BETWEEN_SYMBOL, 0); }
		public List<WindowFrameBoundContext> windowFrameBound() {
			return getRuleContexts(WindowFrameBoundContext.class);
		}
		public WindowFrameBoundContext windowFrameBound(int i) {
			return getRuleContext(WindowFrameBoundContext.class,i);
		}
		public TerminalNode AND_SYMBOL() { return getToken(HDBCDSParser.AND_SYMBOL, 0); }
		public WindowFrameBetweenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBetween; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameBetween(this);
		}
	}

	public final WindowFrameBetweenContext windowFrameBetween() throws RecognitionException {
		WindowFrameBetweenContext _localctx = new WindowFrameBetweenContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_windowFrameBetween);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
			match(BETWEEN_SYMBOL);
			setState(863);
			windowFrameBound();
			setState(864);
			match(AND_SYMBOL);
			setState(865);
			windowFrameBound();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBoundContext extends ParserRuleContext {
		public WindowFrameStartContext windowFrameStart() {
			return getRuleContext(WindowFrameStartContext.class,0);
		}
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBCDSParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(HDBCDSParser.FOLLOWING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBCDSParser.PARAM_MARKER, 0); }
		public WindowFrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameBound(this);
		}
	}

	public final WindowFrameBoundContext windowFrameBound() throws RecognitionException {
		WindowFrameBoundContext _localctx = new WindowFrameBoundContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_windowFrameBound);
		try {
			setState(875);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(867);
				windowFrameStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				match(UNBOUNDED_SYMBOL);
				setState(869);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(870);
				ulonglong_number();
				setState(871);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(873);
				match(PARAM_MARKER);
				setState(874);
				match(FOLLOWING_SYMBOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameExclusionContext extends ParserRuleContext {
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(HDBCDSParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBCDSParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBCDSParser.ROW_SYMBOL, 0); }
		public TerminalNode GROUP_SYMBOL() { return getToken(HDBCDSParser.GROUP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(HDBCDSParser.TIES_SYMBOL, 0); }
		public TerminalNode NO_SYMBOL() { return getToken(HDBCDSParser.NO_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(HDBCDSParser.OTHERS_SYMBOL, 0); }
		public WindowFrameExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameExclusion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFrameExclusion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFrameExclusion(this);
		}
	}

	public final WindowFrameExclusionContext windowFrameExclusion() throws RecognitionException {
		WindowFrameExclusionContext _localctx = new WindowFrameExclusionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_windowFrameExclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			match(EXCLUDE_SYMBOL);
			setState(884);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_SYMBOL:
				{
				setState(878);
				match(CURRENT_SYMBOL);
				setState(879);
				match(ROW_SYMBOL);
				}
				break;
			case GROUP_SYMBOL:
				{
				setState(880);
				match(GROUP_SYMBOL);
				}
				break;
			case TIES_SYMBOL:
				{
				setState(881);
				match(TIES_SYMBOL);
				}
				break;
			case NO_SYMBOL:
				{
				setState(882);
				match(NO_SYMBOL);
				setState(883);
				match(OTHERS_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithClauseContext extends ParserRuleContext {
		public TerminalNode WITH_SYMBOL() { return getToken(HDBCDSParser.WITH_SYMBOL, 0); }
		public List<CommonTableExpressionContext> commonTableExpression() {
			return getRuleContexts(CommonTableExpressionContext.class);
		}
		public CommonTableExpressionContext commonTableExpression(int i) {
			return getRuleContext(CommonTableExpressionContext.class,i);
		}
		public TerminalNode RECURSIVE_SYMBOL() { return getToken(HDBCDSParser.RECURSIVE_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWithClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWithClause(this);
		}
	}

	public final WithClauseContext withClause() throws RecognitionException {
		WithClauseContext _localctx = new WithClauseContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_withClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			match(WITH_SYMBOL);
			setState(888);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RECURSIVE_SYMBOL) {
				{
				setState(887);
				match(RECURSIVE_SYMBOL);
				}
			}

			setState(890);
			commonTableExpression();
			setState(895);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(891);
				match(COMMA_SYMBOL);
				setState(892);
				commonTableExpression();
				}
				}
				setState(897);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonTableExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public ColumnInternalRefListContext columnInternalRefList() {
			return getRuleContext(ColumnInternalRefListContext.class,0);
		}
		public CommonTableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonTableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterCommonTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitCommonTableExpression(this);
		}
	}

	public final CommonTableExpressionContext commonTableExpression() throws RecognitionException {
		CommonTableExpressionContext _localctx = new CommonTableExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_commonTableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			identifier();
			setState(900);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR_SYMBOL) {
				{
				setState(899);
				columnInternalRefList();
				}
			}

			setState(902);
			match(AS_SYMBOL);
			setState(903);
			subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP_SYMBOL() { return getToken(HDBCDSParser.GROUP_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBCDSParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(GROUP_SYMBOL);
			setState(906);
			match(BY_SYMBOL);
			setState(907);
			orderList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderClauseContext extends ParserRuleContext {
		public TerminalNode ORDER_SYMBOL() { return getToken(HDBCDSParser.ORDER_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBCDSParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_orderClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			match(ORDER_SYMBOL);
			setState(910);
			match(BY_SYMBOL);
			setState(911);
			orderList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectionContext extends ParserRuleContext {
		public TerminalNode ASC_SYMBOL() { return getToken(HDBCDSParser.ASC_SYMBOL, 0); }
		public TerminalNode DESC_SYMBOL() { return getToken(HDBCDSParser.DESC_SYMBOL, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDirection(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_direction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			_la = _input.LA(1);
			if ( !(_la==ASC_SYMBOL || _la==DESC_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM_SYMBOL() { return getToken(HDBCDSParser.FROM_SYMBOL, 0); }
		public TerminalNode DUMMY_SYMBOL() { return getToken(HDBCDSParser.DUMMY_SYMBOL, 0); }
		public TableReferenceListContext tableReferenceList() {
			return getRuleContext(TableReferenceListContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(FROM_SYMBOL);
			setState(918);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DUMMY_SYMBOL:
				{
				setState(916);
				match(DUMMY_SYMBOL);
				}
				break;
			case DOT_SYMBOL:
			case OPEN_PAR_SYMBOL:
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case LATERAL_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				{
				setState(917);
				tableReferenceList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableReferenceListContext extends ParserRuleContext {
		public List<TableReferenceContext> tableReference() {
			return getRuleContexts(TableReferenceContext.class);
		}
		public TableReferenceContext tableReference(int i) {
			return getRuleContext(TableReferenceContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public TableReferenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReferenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableReferenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableReferenceList(this);
		}
	}

	public final TableReferenceListContext tableReferenceList() throws RecognitionException {
		TableReferenceListContext _localctx = new TableReferenceListContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_tableReferenceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			tableReference();
			setState(925);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(921);
					match(COMMA_SYMBOL);
					setState(922);
					tableReference();
					}
					} 
				}
				setState(927);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectOptionContext extends ParserRuleContext {
		public QuerySpecOptionContext querySpecOption() {
			return getRuleContext(QuerySpecOptionContext.class,0);
		}
		public SelectOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSelectOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSelectOption(this);
		}
	}

	public final SelectOptionContext selectOption() throws RecognitionException {
		SelectOptionContext _localctx = new SelectOptionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_selectOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			querySpecOption();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LockingClauseContext extends ParserRuleContext {
		public TerminalNode FOR_SYMBOL() { return getToken(HDBCDSParser.FOR_SYMBOL, 0); }
		public LockStrenghContext lockStrengh() {
			return getRuleContext(LockStrenghContext.class,0);
		}
		public TerminalNode OF_SYMBOL() { return getToken(HDBCDSParser.OF_SYMBOL, 0); }
		public TableAliasRefListContext tableAliasRefList() {
			return getRuleContext(TableAliasRefListContext.class,0);
		}
		public LockedRowActionContext lockedRowAction() {
			return getRuleContext(LockedRowActionContext.class,0);
		}
		public TerminalNode LOCK_SYMBOL() { return getToken(HDBCDSParser.LOCK_SYMBOL, 0); }
		public TerminalNode IN_SYMBOL() { return getToken(HDBCDSParser.IN_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBCDSParser.SHARE_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(HDBCDSParser.MODE_SYMBOL, 0); }
		public LockingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLockingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLockingClause(this);
		}
	}

	public final LockingClauseContext lockingClause() throws RecognitionException {
		LockingClauseContext _localctx = new LockingClauseContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_lockingClause);
		int _la;
		try {
			setState(943);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(930);
				match(FOR_SYMBOL);
				setState(931);
				lockStrengh();
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OF_SYMBOL) {
					{
					setState(932);
					match(OF_SYMBOL);
					setState(933);
					tableAliasRefList();
					}
				}

				setState(937);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SKIP_SYMBOL || _la==NOWAIT_SYMBOL) {
					{
					setState(936);
					lockedRowAction();
					}
				}

				}
				break;
			case LOCK_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(939);
				match(LOCK_SYMBOL);
				setState(940);
				match(IN_SYMBOL);
				setState(941);
				match(SHARE_SYMBOL);
				setState(942);
				match(MODE_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LockStrenghContext extends ParserRuleContext {
		public TerminalNode UPDATE_SYMBOL() { return getToken(HDBCDSParser.UPDATE_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBCDSParser.SHARE_SYMBOL, 0); }
		public LockStrenghContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockStrengh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLockStrengh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLockStrengh(this);
		}
	}

	public final LockStrenghContext lockStrengh() throws RecognitionException {
		LockStrenghContext _localctx = new LockStrenghContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_lockStrengh);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			_la = _input.LA(1);
			if ( !(_la==SHARE_SYMBOL || _la==UPDATE_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LockedRowActionContext extends ParserRuleContext {
		public TerminalNode SKIP_SYMBOL() { return getToken(HDBCDSParser.SKIP_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(HDBCDSParser.LOCKED_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(HDBCDSParser.NOWAIT_SYMBOL, 0); }
		public LockedRowActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockedRowAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLockedRowAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLockedRowAction(this);
		}
	}

	public final LockedRowActionContext lockedRowAction() throws RecognitionException {
		LockedRowActionContext _localctx = new LockedRowActionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_lockedRowAction);
		try {
			setState(950);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(947);
				match(SKIP_SYMBOL);
				setState(948);
				match(LOCKED_SYMBOL);
				}
				break;
			case NOWAIT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(949);
				match(NOWAIT_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemListContext extends ParserRuleContext {
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public SelectItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSelectItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSelectItemList(this);
		}
	}

	public final SelectItemListContext selectItemList() throws RecognitionException {
		SelectItemListContext _localctx = new SelectItemListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_selectItemList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT2_SYMBOL:
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PLUS_OPERATOR:
			case MINUS_OPERATOR:
			case DOT_SYMBOL:
			case OPEN_PAR_SYMBOL:
			case OPEN_CURLY_SYMBOL:
			case NULL2_SYMBOL:
			case PARAM_MARKER:
			case HEX_NUMBER:
			case BIN_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
			case ASCII_SYMBOL:
			case COALESCE_SYMBOL:
			case SUBSTRING_SYMBOL:
			case NOT_SYMBOL:
			case CURRENT_USER_SYMBOL:
			case DENSE_RANK_SYMBOL:
			case FIRST_VALUE_SYMBOL:
			case LAG_SYMBOL:
			case LAST_VALUE_SYMBOL:
			case LEAD_SYMBOL:
			case NTILE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case RANK_SYMBOL:
			case ROW_NUMBER_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case INTERVAL_SYMBOL:
			case CURRENT_SYMBOL:
			case ROW_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case COUNT_SYMBOL:
			case SUM_SYMBOL:
			case MAX_SYMBOL:
			case MIN_SYMBOL:
			case STD_SYMBOL:
			case VARIANCE_SYMBOL:
			case GROUP_CONCAT_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case LEFT_SYMBOL:
			case RIGHT_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case CASE_SYMBOL:
			case CAST_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case EXISTS_SYMBOL:
			case FALSE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case NOW_SYMBOL:
			case NULL_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case TRUE_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case GROUPING_SYMBOL:
			case IDENTIFIER:
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				{
				setState(952);
				selectItem();
				}
				break;
			case MULT_OPERATOR:
				{
				setState(953);
				match(MULT_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(960);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(956);
					match(COMMA_SYMBOL);
					setState(957);
					selectItem();
					}
					} 
				}
				setState(962);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemContext extends ParserRuleContext {
		public TableWildContext tableWild() {
			return getRuleContext(TableWildContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectAliasContext selectAlias() {
			return getRuleContext(SelectAliasContext.class,0);
		}
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSelectItem(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_selectItem);
		try {
			setState(968);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(963);
				tableWild();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(964);
				expr(0);
				setState(966);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(965);
					selectAlias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectAliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TextStringLiteralContext textStringLiteral() {
			return getRuleContext(TextStringLiteralContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public SelectAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSelectAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSelectAlias(this);
		}
	}

	public final SelectAliasContext selectAlias() throws RecognitionException {
		SelectAliasContext _localctx = new SelectAliasContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_selectAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(970);
				match(AS_SYMBOL);
				}
			}

			setState(975);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(973);
				identifier();
				}
				break;
			case 2:
				{
				setState(974);
				textStringLiteral();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE_SYMBOL() { return getToken(HDBCDSParser.WHERE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			match(WHERE_SYMBOL);
			setState(978);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableReferenceContext extends ParserRuleContext {
		public TableFactorContext tableFactor() {
			return getRuleContext(TableFactorContext.class,0);
		}
		public List<JoinedTableContext> joinedTable() {
			return getRuleContexts(JoinedTableContext.class);
		}
		public JoinedTableContext joinedTable(int i) {
			return getRuleContext(JoinedTableContext.class,i);
		}
		public TableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableReference(this);
		}
	}

	public final TableReferenceContext tableReference() throws RecognitionException {
		TableReferenceContext _localctx = new TableReferenceContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_tableReference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			tableFactor();
			setState(984);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(981);
					joinedTable();
					}
					} 
				}
				setState(986);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapedTableReferenceContext extends ParserRuleContext {
		public TableFactorContext tableFactor() {
			return getRuleContext(TableFactorContext.class,0);
		}
		public List<JoinedTableContext> joinedTable() {
			return getRuleContexts(JoinedTableContext.class);
		}
		public JoinedTableContext joinedTable(int i) {
			return getRuleContext(JoinedTableContext.class,i);
		}
		public EscapedTableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapedTableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterEscapedTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitEscapedTableReference(this);
		}
	}

	public final EscapedTableReferenceContext escapedTableReference() throws RecognitionException {
		EscapedTableReferenceContext _localctx = new EscapedTableReferenceContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_escapedTableReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			tableFactor();
			setState(991);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (CROSS_SYMBOL - 118)) | (1L << (INNER_SYMBOL - 118)) | (1L << (JOIN_SYMBOL - 118)) | (1L << (LEFT_SYMBOL - 118)) | (1L << (RIGHT_SYMBOL - 118)))) != 0)) {
				{
				{
				setState(988);
				joinedTable();
				}
				}
				setState(993);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinedTableContext extends ParserRuleContext {
		public InnerJoinTypeContext innerJoinType() {
			return getRuleContext(InnerJoinTypeContext.class,0);
		}
		public TableReferenceContext tableReference() {
			return getRuleContext(TableReferenceContext.class,0);
		}
		public TerminalNode ON_SYMBOL() { return getToken(HDBCDSParser.ON_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING_SYMBOL() { return getToken(HDBCDSParser.USING_SYMBOL, 0); }
		public IdentifierListWithParenthesesContext identifierListWithParentheses() {
			return getRuleContext(IdentifierListWithParenthesesContext.class,0);
		}
		public OuterJoinTypeContext outerJoinType() {
			return getRuleContext(OuterJoinTypeContext.class,0);
		}
		public JoinedTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinedTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterJoinedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitJoinedTable(this);
		}
	}

	public final JoinedTableContext joinedTable() throws RecognitionException {
		JoinedTableContext _localctx = new JoinedTableContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_joinedTable);
		try {
			setState(1010);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CROSS_SYMBOL:
			case INNER_SYMBOL:
			case JOIN_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(994);
				innerJoinType();
				setState(995);
				tableReference();
				setState(1000);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(996);
					match(ON_SYMBOL);
					setState(997);
					expr(0);
					}
					break;
				case 2:
					{
					setState(998);
					match(USING_SYMBOL);
					setState(999);
					identifierListWithParentheses();
					}
					break;
				}
				}
				break;
			case LEFT_SYMBOL:
			case RIGHT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1002);
				outerJoinType();
				setState(1003);
				tableReference();
				setState(1008);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ON_SYMBOL:
					{
					setState(1004);
					match(ON_SYMBOL);
					setState(1005);
					expr(0);
					}
					break;
				case USING_SYMBOL:
					{
					setState(1006);
					match(USING_SYMBOL);
					setState(1007);
					identifierListWithParentheses();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerJoinTypeContext extends ParserRuleContext {
		public Token type;
		public TerminalNode JOIN_SYMBOL() { return getToken(HDBCDSParser.JOIN_SYMBOL, 0); }
		public TerminalNode INNER_SYMBOL() { return getToken(HDBCDSParser.INNER_SYMBOL, 0); }
		public TerminalNode CROSS_SYMBOL() { return getToken(HDBCDSParser.CROSS_SYMBOL, 0); }
		public InnerJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterInnerJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitInnerJoinType(this);
		}
	}

	public final InnerJoinTypeContext innerJoinType() throws RecognitionException {
		InnerJoinTypeContext _localctx = new InnerJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_innerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CROSS_SYMBOL || _la==INNER_SYMBOL) {
				{
				setState(1012);
				((InnerJoinTypeContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CROSS_SYMBOL || _la==INNER_SYMBOL) ) {
					((InnerJoinTypeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1015);
			match(JOIN_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OuterJoinTypeContext extends ParserRuleContext {
		public Token type;
		public TerminalNode JOIN_SYMBOL() { return getToken(HDBCDSParser.JOIN_SYMBOL, 0); }
		public TerminalNode LEFT_SYMBOL() { return getToken(HDBCDSParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(HDBCDSParser.RIGHT_SYMBOL, 0); }
		public TerminalNode OUTER_SYMBOL() { return getToken(HDBCDSParser.OUTER_SYMBOL, 0); }
		public OuterJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterOuterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitOuterJoinType(this);
		}
	}

	public final OuterJoinTypeContext outerJoinType() throws RecognitionException {
		OuterJoinTypeContext _localctx = new OuterJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_outerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1017);
			((OuterJoinTypeContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==LEFT_SYMBOL || _la==RIGHT_SYMBOL) ) {
				((OuterJoinTypeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1019);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTER_SYMBOL) {
				{
				setState(1018);
				match(OUTER_SYMBOL);
				}
			}

			setState(1021);
			match(JOIN_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableFactorContext extends ParserRuleContext {
		public SingleTableContext singleTable() {
			return getRuleContext(SingleTableContext.class,0);
		}
		public SingleTableParensContext singleTableParens() {
			return getRuleContext(SingleTableParensContext.class,0);
		}
		public DerivedTableContext derivedTable() {
			return getRuleContext(DerivedTableContext.class,0);
		}
		public TableReferenceListParensContext tableReferenceListParens() {
			return getRuleContext(TableReferenceListParensContext.class,0);
		}
		public TableFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableFactor(this);
		}
	}

	public final TableFactorContext tableFactor() throws RecognitionException {
		TableFactorContext _localctx = new TableFactorContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_tableFactor);
		try {
			setState(1027);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1023);
				singleTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1024);
				singleTableParens();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1025);
				derivedTable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1026);
				tableReferenceListParens();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableContext extends ParserRuleContext {
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public SingleTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSingleTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSingleTable(this);
		}
	}

	public final SingleTableContext singleTable() throws RecognitionException {
		SingleTableContext _localctx = new SingleTableContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_singleTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			tableRef();
			setState(1031);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(1030);
				tableAlias();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableParensContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public SingleTableContext singleTable() {
			return getRuleContext(SingleTableContext.class,0);
		}
		public SingleTableParensContext singleTableParens() {
			return getRuleContext(SingleTableParensContext.class,0);
		}
		public SingleTableParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTableParens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSingleTableParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSingleTableParens(this);
		}
	}

	public final SingleTableParensContext singleTableParens() throws RecognitionException {
		SingleTableParensContext _localctx = new SingleTableParensContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_singleTableParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			match(OPEN_PAR_SYMBOL);
			setState(1036);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT_SYMBOL:
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				{
				setState(1034);
				singleTable();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(1035);
				singleTableParens();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1038);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DerivedTableContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public ColumnInternalRefListContext columnInternalRefList() {
			return getRuleContext(ColumnInternalRefListContext.class,0);
		}
		public TerminalNode LATERAL_SYMBOL() { return getToken(HDBCDSParser.LATERAL_SYMBOL, 0); }
		public DerivedTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDerivedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDerivedTable(this);
		}
	}

	public final DerivedTableContext derivedTable() throws RecognitionException {
		DerivedTableContext _localctx = new DerivedTableContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_derivedTable);
		try {
			setState(1055);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1040);
				subquery();
				setState(1042);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(1041);
					tableAlias();
					}
					break;
				}
				setState(1045);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(1044);
					columnInternalRefList();
					}
					break;
				}
				}
				break;
			case LATERAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1047);
				match(LATERAL_SYMBOL);
				setState(1048);
				subquery();
				setState(1050);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(1049);
					tableAlias();
					}
					break;
				}
				setState(1053);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(1052);
					columnInternalRefList();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableReferenceListParensContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TableReferenceListContext tableReferenceList() {
			return getRuleContext(TableReferenceListContext.class,0);
		}
		public TableReferenceListParensContext tableReferenceListParens() {
			return getRuleContext(TableReferenceListParensContext.class,0);
		}
		public TableReferenceListParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReferenceListParens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableReferenceListParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableReferenceListParens(this);
		}
	}

	public final TableReferenceListParensContext tableReferenceListParens() throws RecognitionException {
		TableReferenceListParensContext _localctx = new TableReferenceListParensContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_tableReferenceListParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			match(OPEN_PAR_SYMBOL);
			setState(1060);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(1058);
				tableReferenceList();
				}
				break;
			case 2:
				{
				setState(1059);
				tableReferenceListParens();
				}
				break;
			}
			setState(1062);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionOptionContext extends ParserRuleContext {
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBCDSParser.DISTINCT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(HDBCDSParser.ALL_SYMBOL, 0); }
		public UnionOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitUnionOption(this);
		}
	}

	public final UnionOptionContext unionOption() throws RecognitionException {
		UnionOptionContext _localctx = new UnionOptionContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_unionOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			_la = _input.LA(1);
			if ( !(_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableAliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableAlias(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_tableAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(1066);
				match(AS_SYMBOL);
				}
			}

			setState(1069);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprOrContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR_SYMBOL() { return getToken(HDBCDSParser.OR_SYMBOL, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprOr(this);
		}
	}
	public static class ExprNotContext extends ExprContext {
		public TerminalNode NOT_SYMBOL() { return getToken(HDBCDSParser.NOT_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprNot(this);
		}
	}
	public static class ExprIsContext extends ExprContext {
		public Token type;
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(HDBCDSParser.IS_SYMBOL, 0); }
		public TerminalNode TRUE_SYMBOL() { return getToken(HDBCDSParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(HDBCDSParser.FALSE_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(HDBCDSParser.UNKNOWN_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public ExprIsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprIs(this);
		}
	}
	public static class ExprAndContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_SYMBOL() { return getToken(HDBCDSParser.AND_SYMBOL, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprAnd(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 208;
		enterRecursionRule(_localctx, 208, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT2_SYMBOL:
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PLUS_OPERATOR:
			case MINUS_OPERATOR:
			case DOT_SYMBOL:
			case OPEN_PAR_SYMBOL:
			case OPEN_CURLY_SYMBOL:
			case NULL2_SYMBOL:
			case PARAM_MARKER:
			case HEX_NUMBER:
			case BIN_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
			case ASCII_SYMBOL:
			case COALESCE_SYMBOL:
			case SUBSTRING_SYMBOL:
			case CURRENT_USER_SYMBOL:
			case DENSE_RANK_SYMBOL:
			case FIRST_VALUE_SYMBOL:
			case LAG_SYMBOL:
			case LAST_VALUE_SYMBOL:
			case LEAD_SYMBOL:
			case NTILE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case RANK_SYMBOL:
			case ROW_NUMBER_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case INTERVAL_SYMBOL:
			case CURRENT_SYMBOL:
			case ROW_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case COUNT_SYMBOL:
			case SUM_SYMBOL:
			case MAX_SYMBOL:
			case MIN_SYMBOL:
			case STD_SYMBOL:
			case VARIANCE_SYMBOL:
			case GROUP_CONCAT_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case LEFT_SYMBOL:
			case RIGHT_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case CASE_SYMBOL:
			case CAST_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case EXISTS_SYMBOL:
			case FALSE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case NOW_SYMBOL:
			case NULL_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case TRUE_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case GROUPING_SYMBOL:
			case IDENTIFIER:
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				{
				_localctx = new ExprIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1072);
				boolPri(0);
				setState(1078);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(1073);
					match(IS_SYMBOL);
					setState(1075);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
						{
						setState(1074);
						notRule();
						}
					}

					setState(1077);
					((ExprIsContext)_localctx).type = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (FALSE_SYMBOL - 141)) | (1L << (TRUE_SYMBOL - 141)) | (1L << (UNKNOWN_SYMBOL - 141)))) != 0)) ) {
						((ExprIsContext)_localctx).type = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case NOT_SYMBOL:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1080);
				match(NOT_SYMBOL);
				setState(1081);
				expr(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1092);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1090);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
					case 1:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1084);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1085);
						((ExprAndContext)_localctx).op = match(AND_SYMBOL);
						setState(1086);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1087);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1088);
						((ExprOrContext)_localctx).op = match(OR_SYMBOL);
						setState(1089);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(1094);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BoolPriContext extends ParserRuleContext {
		public BoolPriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolPri; }
	 
		public BoolPriContext() { }
		public void copyFrom(BoolPriContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryExprPredicateContext extends BoolPriContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PrimaryExprPredicateContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrimaryExprPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrimaryExprPredicate(this);
		}
	}
	public static class PrimaryExprCompareContext extends BoolPriContext {
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PrimaryExprCompareContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrimaryExprCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrimaryExprCompare(this);
		}
	}
	public static class PrimaryExprAllAnyContext extends BoolPriContext {
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode ALL_SYMBOL() { return getToken(HDBCDSParser.ALL_SYMBOL, 0); }
		public TerminalNode ANY_SYMBOL() { return getToken(HDBCDSParser.ANY_SYMBOL, 0); }
		public PrimaryExprAllAnyContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrimaryExprAllAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrimaryExprAllAny(this);
		}
	}
	public static class PrimaryExprIsNullContext extends BoolPriContext {
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(HDBCDSParser.IS_SYMBOL, 0); }
		public TerminalNode NULL_SYMBOL() { return getToken(HDBCDSParser.NULL_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public PrimaryExprIsNullContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrimaryExprIsNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrimaryExprIsNull(this);
		}
	}

	public final BoolPriContext boolPri() throws RecognitionException {
		return boolPri(0);
	}

	private BoolPriContext boolPri(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolPriContext _localctx = new BoolPriContext(_ctx, _parentState);
		BoolPriContext _prevctx = _localctx;
		int _startState = 210;
		enterRecursionRule(_localctx, 210, RULE_boolPri, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExprPredicateContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(1096);
			predicate();
			}
			_ctx.stop = _input.LT(-1);
			setState(1115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
					case 1:
						{
						_localctx = new PrimaryExprIsNullContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(1098);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1099);
						match(IS_SYMBOL);
						setState(1101);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
							{
							setState(1100);
							notRule();
							}
						}

						setState(1103);
						match(NULL_SYMBOL);
						}
						break;
					case 2:
						{
						_localctx = new PrimaryExprCompareContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(1104);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1105);
						compOp();
						setState(1106);
						predicate();
						}
						break;
					case 3:
						{
						_localctx = new PrimaryExprAllAnyContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(1108);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1109);
						compOp();
						setState(1110);
						_la = _input.LA(1);
						if ( !(_la==ALL_SYMBOL || _la==ANY_SYMBOL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1111);
						subquery();
						}
						break;
					}
					} 
				}
				setState(1117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQUAL_OPERATOR() { return getToken(HDBCDSParser.EQUAL_OPERATOR, 0); }
		public TerminalNode NULL_SAFE_EQUAL_OPERATOR() { return getToken(HDBCDSParser.NULL_SAFE_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_OR_EQUAL_OPERATOR() { return getToken(HDBCDSParser.GREATER_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_THAN_OPERATOR() { return getToken(HDBCDSParser.GREATER_THAN_OPERATOR, 0); }
		public TerminalNode LESS_OR_EQUAL_OPERATOR() { return getToken(HDBCDSParser.LESS_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode LESS_THAN_OPERATOR() { return getToken(HDBCDSParser.LESS_THAN_OPERATOR, 0); }
		public TerminalNode NOT_EQUAL_OPERATOR() { return getToken(HDBCDSParser.NOT_EQUAL_OPERATOR, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL_OPERATOR) | (1L << NULL_SAFE_EQUAL_OPERATOR) | (1L << GREATER_OR_EQUAL_OPERATOR) | (1L << GREATER_THAN_OPERATOR) | (1L << LESS_OR_EQUAL_OPERATOR) | (1L << LESS_THAN_OPERATOR) | (1L << NOT_EQUAL_OPERATOR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public PredicateOperationsContext predicateOperations() {
			return getRuleContext(PredicateOperationsContext.class,0);
		}
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1120);
			bitExpr(0);
			setState(1125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(1122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
					{
					setState(1121);
					notRule();
					}
				}

				setState(1124);
				predicateOperations();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateOperationsContext extends ParserRuleContext {
		public PredicateOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateOperations; }
	 
		public PredicateOperationsContext() { }
		public void copyFrom(PredicateOperationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PredicateExprBetweenContext extends PredicateOperationsContext {
		public TerminalNode BETWEEN_SYMBOL() { return getToken(HDBCDSParser.BETWEEN_SYMBOL, 0); }
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public TerminalNode AND_SYMBOL() { return getToken(HDBCDSParser.AND_SYMBOL, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateExprBetweenContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPredicateExprBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPredicateExprBetween(this);
		}
	}
	public static class PredicateExprInContext extends PredicateOperationsContext {
		public TerminalNode IN_SYMBOL() { return getToken(HDBCDSParser.IN_SYMBOL, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public PredicateExprInContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPredicateExprIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPredicateExprIn(this);
		}
	}
	public static class PredicateExprLikeContext extends PredicateOperationsContext {
		public TerminalNode LIKE_SYMBOL() { return getToken(HDBCDSParser.LIKE_SYMBOL, 0); }
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode ESCAPE_SYMBOL() { return getToken(HDBCDSParser.ESCAPE_SYMBOL, 0); }
		public PredicateExprLikeContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPredicateExprLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPredicateExprLike(this);
		}
	}

	public final PredicateOperationsContext predicateOperations() throws RecognitionException {
		PredicateOperationsContext _localctx = new PredicateOperationsContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_predicateOperations);
		try {
			setState(1146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN_SYMBOL:
				_localctx = new PredicateExprInContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1127);
				match(IN_SYMBOL);
				setState(1133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1128);
					subquery();
					}
					break;
				case 2:
					{
					setState(1129);
					match(OPEN_PAR_SYMBOL);
					setState(1130);
					exprList();
					setState(1131);
					match(CLOSE_PAR_SYMBOL);
					}
					break;
				}
				}
				break;
			case BETWEEN_SYMBOL:
				_localctx = new PredicateExprBetweenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1135);
				match(BETWEEN_SYMBOL);
				setState(1136);
				bitExpr(0);
				setState(1137);
				match(AND_SYMBOL);
				setState(1138);
				predicate();
				}
				break;
			case LIKE_SYMBOL:
				_localctx = new PredicateExprLikeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1140);
				match(LIKE_SYMBOL);
				setState(1141);
				simpleExpr(0);
				setState(1144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(1142);
					match(ESCAPE_SYMBOL);
					setState(1143);
					simpleExpr(0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitExprContext extends ParserRuleContext {
		public Token op;
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public List<BitExprContext> bitExpr() {
			return getRuleContexts(BitExprContext.class);
		}
		public BitExprContext bitExpr(int i) {
			return getRuleContext(BitExprContext.class,i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public TerminalNode DIV_OPERATOR() { return getToken(HDBCDSParser.DIV_OPERATOR, 0); }
		public TerminalNode MOD_OPERATOR() { return getToken(HDBCDSParser.MOD_OPERATOR, 0); }
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBCDSParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBCDSParser.MINUS_OPERATOR, 0); }
		public BitExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterBitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitBitExpr(this);
		}
	}

	public final BitExprContext bitExpr() throws RecognitionException {
		return bitExpr(0);
	}

	private BitExprContext bitExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitExprContext _localctx = new BitExprContext(_ctx, _parentState);
		BitExprContext _prevctx = _localctx;
		int _startState = 218;
		enterRecursionRule(_localctx, 218, RULE_bitExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1149);
			simpleExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
					case 1:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(1151);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1152);
						((BitExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT_OPERATOR) | (1L << DIV_OPERATOR) | (1L << MOD_OPERATOR))) != 0)) ) {
							((BitExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1153);
						bitExpr(3);
						}
						break;
					case 2:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(1154);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1155);
						((BitExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS_OPERATOR || _la==MINUS_OPERATOR) ) {
							((BitExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1156);
						bitExpr(2);
						}
						break;
					}
					} 
				}
				setState(1161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SimpleExprContext extends ParserRuleContext {
		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr; }
	 
		public SimpleExprContext() { }
		public void copyFrom(SimpleExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleExprColumnRefContext extends SimpleExprContext {
		public ColumnRefContext columnRef() {
			return getRuleContext(ColumnRefContext.class,0);
		}
		public SimpleExprColumnRefContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprColumnRef(this);
		}
	}
	public static class SimpleExprParamMarkerContext extends SimpleExprContext {
		public TerminalNode PARAM_MARKER() { return getToken(HDBCDSParser.PARAM_MARKER, 0); }
		public SimpleExprParamMarkerContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprParamMarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprParamMarker(this);
		}
	}
	public static class SimpleExprSumContext extends SimpleExprContext {
		public SumExprContext sumExpr() {
			return getRuleContext(SumExprContext.class,0);
		}
		public SimpleExprSumContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprSum(this);
		}
	}
	public static class SimpleExprCastContext extends SimpleExprContext {
		public TerminalNode CAST_SYMBOL() { return getToken(HDBCDSParser.CAST_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBCDSParser.AS_SYMBOL, 0); }
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprCastContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprCast(this);
		}
	}
	public static class SimpleExprUnaryContext extends SimpleExprContext {
		public Token op;
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBCDSParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBCDSParser.MINUS_OPERATOR, 0); }
		public SimpleExprUnaryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprUnary(this);
		}
	}
	public static class SimpleExprSubQueryContext extends SimpleExprContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode EXISTS_SYMBOL() { return getToken(HDBCDSParser.EXISTS_SYMBOL, 0); }
		public SimpleExprSubQueryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprSubQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprSubQuery(this);
		}
	}
	public static class SimpleExprGroupingOperationContext extends SimpleExprContext {
		public GroupingOperationContext groupingOperation() {
			return getRuleContext(GroupingOperationContext.class,0);
		}
		public SimpleExprGroupingOperationContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprGroupingOperation(this);
		}
	}
	public static class SimpleExprNotContext extends SimpleExprContext {
		public Not2RuleContext not2Rule() {
			return getRuleContext(Not2RuleContext.class,0);
		}
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public SimpleExprNotContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprNot(this);
		}
	}
	public static class SimpleExprOdbcContext extends SimpleExprContext {
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBCDSParser.OPEN_CURLY_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBCDSParser.CLOSE_CURLY_SYMBOL, 0); }
		public SimpleExprOdbcContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprOdbc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprOdbc(this);
		}
	}
	public static class SimpleExprRuntimeFunctionContext extends SimpleExprContext {
		public RuntimeFunctionCallContext runtimeFunctionCall() {
			return getRuleContext(RuntimeFunctionCallContext.class,0);
		}
		public SimpleExprRuntimeFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprRuntimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprRuntimeFunction(this);
		}
	}
	public static class SimpleExprFunctionContext extends SimpleExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public SimpleExprFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprFunction(this);
		}
	}
	public static class SimpleExprListContext extends SimpleExprContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBCDSParser.ROW_SYMBOL, 0); }
		public SimpleExprListContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprList(this);
		}
	}
	public static class SimpleExprCaseContext extends SimpleExprContext {
		public TerminalNode CASE_SYMBOL() { return getToken(HDBCDSParser.CASE_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(HDBCDSParser.END_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<WhenExpressionContext> whenExpression() {
			return getRuleContexts(WhenExpressionContext.class);
		}
		public WhenExpressionContext whenExpression(int i) {
			return getRuleContext(WhenExpressionContext.class,i);
		}
		public List<ThenExpressionContext> thenExpression() {
			return getRuleContexts(ThenExpressionContext.class);
		}
		public ThenExpressionContext thenExpression(int i) {
			return getRuleContext(ThenExpressionContext.class,i);
		}
		public ElseExpressionContext elseExpression() {
			return getRuleContext(ElseExpressionContext.class,0);
		}
		public SimpleExprCaseContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprCase(this);
		}
	}
	public static class SimpleExprConcatContext extends SimpleExprContext {
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode CONCAT_PIPES_SYMBOL() { return getToken(HDBCDSParser.CONCAT_PIPES_SYMBOL, 0); }
		public SimpleExprConcatContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprConcat(this);
		}
	}
	public static class SimpleExprLiteralContext extends SimpleExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public SimpleExprLiteralContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprLiteral(this);
		}
	}
	public static class SimpleExprWindowingFunctionContext extends SimpleExprContext {
		public WindowFunctionCallContext windowFunctionCall() {
			return getRuleContext(WindowFunctionCallContext.class,0);
		}
		public SimpleExprWindowingFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprWindowingFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprWindowingFunction(this);
		}
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		return simpleExpr(0);
	}

	private SimpleExprContext simpleExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, _parentState);
		SimpleExprContext _prevctx = _localctx;
		int _startState = 220;
		enterRecursionRule(_localctx, 220, RULE_simpleExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				{
				_localctx = new SimpleExprColumnRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1163);
				columnRef();
				}
				break;
			case 2:
				{
				_localctx = new SimpleExprRuntimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1164);
				runtimeFunctionCall();
				}
				break;
			case 3:
				{
				_localctx = new SimpleExprFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1165);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new SimpleExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1166);
				literal();
				}
				break;
			case 5:
				{
				_localctx = new SimpleExprParamMarkerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1167);
				match(PARAM_MARKER);
				}
				break;
			case 6:
				{
				_localctx = new SimpleExprSumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1168);
				sumExpr();
				}
				break;
			case 7:
				{
				_localctx = new SimpleExprGroupingOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1169);
				groupingOperation();
				}
				break;
			case 8:
				{
				_localctx = new SimpleExprWindowingFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1170);
				windowFunctionCall();
				}
				break;
			case 9:
				{
				_localctx = new SimpleExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1171);
				((SimpleExprUnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS_OPERATOR || _la==MINUS_OPERATOR) ) {
					((SimpleExprUnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1172);
				simpleExpr(7);
				}
				break;
			case 10:
				{
				_localctx = new SimpleExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1173);
				not2Rule();
				setState(1174);
				simpleExpr(6);
				}
				break;
			case 11:
				{
				_localctx = new SimpleExprListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW_SYMBOL) {
					{
					setState(1176);
					match(ROW_SYMBOL);
					}
				}

				setState(1179);
				match(OPEN_PAR_SYMBOL);
				setState(1180);
				exprList();
				setState(1181);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 12:
				{
				_localctx = new SimpleExprSubQueryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXISTS_SYMBOL) {
					{
					setState(1183);
					match(EXISTS_SYMBOL);
					}
				}

				setState(1186);
				subquery();
				}
				break;
			case 13:
				{
				_localctx = new SimpleExprOdbcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1187);
				match(OPEN_CURLY_SYMBOL);
				setState(1188);
				identifier();
				setState(1189);
				expr(0);
				setState(1190);
				match(CLOSE_CURLY_SYMBOL);
				}
				break;
			case 14:
				{
				_localctx = new SimpleExprCastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1192);
				match(CAST_SYMBOL);
				setState(1193);
				match(OPEN_PAR_SYMBOL);
				setState(1194);
				expr(0);
				setState(1195);
				match(AS_SYMBOL);
				setState(1196);
				castType();
				setState(1197);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 15:
				{
				_localctx = new SimpleExprCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1199);
				match(CASE_SYMBOL);
				setState(1201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ASCII_SYMBOL - 66)) | (1L << (COALESCE_SYMBOL - 66)) | (1L << (SUBSTRING_SYMBOL - 66)) | (1L << (NOT_SYMBOL - 66)) | (1L << (CURRENT_USER_SYMBOL - 66)) | (1L << (DENSE_RANK_SYMBOL - 66)) | (1L << (FIRST_VALUE_SYMBOL - 66)) | (1L << (LAG_SYMBOL - 66)) | (1L << (LAST_VALUE_SYMBOL - 66)) | (1L << (LEAD_SYMBOL - 66)) | (1L << (NTILE_SYMBOL - 66)) | (1L << (NULLS_SYMBOL - 66)) | (1L << (PRECEDING_SYMBOL - 66)) | (1L << (RANK_SYMBOL - 66)) | (1L << (ROW_NUMBER_SYMBOL - 66)) | (1L << (UNBOUNDED_SYMBOL - 66)) | (1L << (INTERVAL_SYMBOL - 66)) | (1L << (CURRENT_SYMBOL - 66)) | (1L << (ROW_SYMBOL - 66)) | (1L << (FOLLOWING_SYMBOL - 66)) | (1L << (EXCLUDE_SYMBOL - 66)) | (1L << (TIES_SYMBOL - 66)) | (1L << (OTHERS_SYMBOL - 66)) | (1L << (AVG_SYMBOL - 66)) | (1L << (COUNT_SYMBOL - 66)) | (1L << (SUM_SYMBOL - 66)) | (1L << (MAX_SYMBOL - 66)) | (1L << (MIN_SYMBOL - 66)) | (1L << (STD_SYMBOL - 66)) | (1L << (VARIANCE_SYMBOL - 66)) | (1L << (GROUP_CONCAT_SYMBOL - 66)) | (1L << (MODE_SYMBOL - 66)) | (1L << (SHARE_SYMBOL - 66)) | (1L << (SKIP_SYMBOL - 66)) | (1L << (LOCKED_SYMBOL - 66)) | (1L << (LEFT_SYMBOL - 66)) | (1L << (RIGHT_SYMBOL - 66)) | (1L << (ANY_SYMBOL - 66)))) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (AT_SYMBOL - 130)) | (1L << (CASE_SYMBOL - 130)) | (1L << (CAST_SYMBOL - 130)) | (1L << (DATE_SYMBOL - 130)) | (1L << (ESCAPE_SYMBOL - 130)) | (1L << (EXISTS_SYMBOL - 130)) | (1L << (FALSE_SYMBOL - 130)) | (1L << (FIRST_SYMBOL - 130)) | (1L << (FULL_SYMBOL - 130)) | (1L << (LAST_SYMBOL - 130)) | (1L << (NOW_SYMBOL - 130)) | (1L << (NULL_SYMBOL - 130)) | (1L << (OFFSET_SYMBOL - 130)) | (1L << (TIMESTAMP_SYMBOL - 130)) | (1L << (TIME_SYMBOL - 130)) | (1L << (TRUE_SYMBOL - 130)) | (1L << (UNKNOWN_SYMBOL - 130)) | (1L << (NOWAIT_SYMBOL - 130)) | (1L << (GROUPING_SYMBOL - 130)) | (1L << (IDENTIFIER - 130)) | (1L << (NCHAR_TEXT - 130)) | (1L << (DOUBLE_QUOTED_TEXT - 130)) | (1L << (SINGLE_QUOTED_TEXT - 130)))) != 0)) {
					{
					setState(1200);
					expr(0);
					}
				}

				setState(1206); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1203);
					whenExpression();
					setState(1204);
					thenExpression();
					}
					}
					setState(1208); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_SYMBOL );
				setState(1211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_SYMBOL) {
					{
					setState(1210);
					elseExpression();
					}
				}

				setState(1213);
				match(END_SYMBOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SimpleExprConcatContext(new SimpleExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr);
					setState(1217);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(1218);
					match(CONCAT_PIPES_SYMBOL);
					setState(1219);
					simpleExpr(9);
					}
					} 
				}
				setState(1224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SumExprContext extends ParserRuleContext {
		public Token name;
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public InSumExprContext inSumExpr() {
			return getRuleContext(InSumExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(HDBCDSParser.AVG_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBCDSParser.DISTINCT_SYMBOL, 0); }
		public WindowingClauseContext windowingClause() {
			return getRuleContext(WindowingClauseContext.class,0);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public TerminalNode COUNT_SYMBOL() { return getToken(HDBCDSParser.COUNT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(HDBCDSParser.ALL_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode MIN_SYMBOL() { return getToken(HDBCDSParser.MIN_SYMBOL, 0); }
		public TerminalNode MAX_SYMBOL() { return getToken(HDBCDSParser.MAX_SYMBOL, 0); }
		public TerminalNode STD_SYMBOL() { return getToken(HDBCDSParser.STD_SYMBOL, 0); }
		public TerminalNode VARIANCE_SYMBOL() { return getToken(HDBCDSParser.VARIANCE_SYMBOL, 0); }
		public TerminalNode SUM_SYMBOL() { return getToken(HDBCDSParser.SUM_SYMBOL, 0); }
		public TerminalNode GROUP_CONCAT_SYMBOL() { return getToken(HDBCDSParser.GROUP_CONCAT_SYMBOL, 0); }
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public TerminalNode SEPARATOR_SYMBOL() { return getToken(HDBCDSParser.SEPARATOR_SYMBOL, 0); }
		public TextStringContext textString() {
			return getRuleContext(TextStringContext.class,0);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSumExpr(this);
		}
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_sumExpr);
		int _la;
		try {
			setState(1321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1225);
				((SumExprContext)_localctx).name = match(AVG_SYMBOL);
				setState(1226);
				match(OPEN_PAR_SYMBOL);
				setState(1228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(1227);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(1230);
				inSumExpr();
				setState(1231);
				match(CLOSE_PAR_SYMBOL);
				setState(1233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
				case 1:
					{
					setState(1232);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1235);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(1236);
				match(OPEN_PAR_SYMBOL);
				setState(1238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL) {
					{
					setState(1237);
					match(ALL_SYMBOL);
					}
				}

				setState(1240);
				match(MULT_OPERATOR);
				setState(1241);
				match(CLOSE_PAR_SYMBOL);
				setState(1243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
				case 1:
					{
					setState(1242);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1245);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(1246);
				match(OPEN_PAR_SYMBOL);
				setState(1254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
				case 1:
					{
					setState(1248);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL) {
						{
						setState(1247);
						match(ALL_SYMBOL);
						}
					}

					setState(1250);
					match(MULT_OPERATOR);
					}
					break;
				case 2:
					{
					setState(1251);
					inSumExpr();
					}
					break;
				case 3:
					{
					setState(1252);
					match(DISTINCT_SYMBOL);
					setState(1253);
					exprList();
					}
					break;
				}
				setState(1256);
				match(CLOSE_PAR_SYMBOL);
				setState(1258);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
				case 1:
					{
					setState(1257);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1260);
				((SumExprContext)_localctx).name = match(MIN_SYMBOL);
				setState(1261);
				match(OPEN_PAR_SYMBOL);
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(1262);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(1265);
				inSumExpr();
				setState(1266);
				match(CLOSE_PAR_SYMBOL);
				setState(1268);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
				case 1:
					{
					setState(1267);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1270);
				((SumExprContext)_localctx).name = match(MAX_SYMBOL);
				setState(1271);
				match(OPEN_PAR_SYMBOL);
				setState(1273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(1272);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(1275);
				inSumExpr();
				setState(1276);
				match(CLOSE_PAR_SYMBOL);
				setState(1278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
				case 1:
					{
					setState(1277);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1280);
				((SumExprContext)_localctx).name = match(STD_SYMBOL);
				setState(1281);
				match(OPEN_PAR_SYMBOL);
				setState(1282);
				inSumExpr();
				setState(1283);
				match(CLOSE_PAR_SYMBOL);
				setState(1285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
				case 1:
					{
					setState(1284);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1287);
				((SumExprContext)_localctx).name = match(VARIANCE_SYMBOL);
				setState(1288);
				match(OPEN_PAR_SYMBOL);
				setState(1289);
				inSumExpr();
				setState(1290);
				match(CLOSE_PAR_SYMBOL);
				setState(1292);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
				case 1:
					{
					setState(1291);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1294);
				((SumExprContext)_localctx).name = match(SUM_SYMBOL);
				setState(1295);
				match(OPEN_PAR_SYMBOL);
				setState(1297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(1296);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(1299);
				inSumExpr();
				setState(1300);
				match(CLOSE_PAR_SYMBOL);
				setState(1302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
				case 1:
					{
					setState(1301);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1304);
				((SumExprContext)_localctx).name = match(GROUP_CONCAT_SYMBOL);
				setState(1305);
				match(OPEN_PAR_SYMBOL);
				setState(1307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(1306);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(1309);
				exprList();
				setState(1311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_SYMBOL) {
					{
					setState(1310);
					orderClause();
					}
				}

				setState(1315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEPARATOR_SYMBOL) {
					{
					setState(1313);
					match(SEPARATOR_SYMBOL);
					setState(1314);
					textString();
					}
				}

				setState(1317);
				match(CLOSE_PAR_SYMBOL);
				setState(1319);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(1318);
					windowingClause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingOperationContext extends ParserRuleContext {
		public TerminalNode GROUPING_SYMBOL() { return getToken(HDBCDSParser.GROUPING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public GroupingOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGroupingOperation(this);
		}
	}

	public final GroupingOperationContext groupingOperation() throws RecognitionException {
		GroupingOperationContext _localctx = new GroupingOperationContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_groupingOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1323);
			match(GROUPING_SYMBOL);
			setState(1324);
			match(OPEN_PAR_SYMBOL);
			setState(1325);
			exprList();
			setState(1326);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFunctionCallContext extends ParserRuleContext {
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public WindowingClauseContext windowingClause() {
			return getRuleContext(WindowingClauseContext.class,0);
		}
		public TerminalNode ROW_NUMBER_SYMBOL() { return getToken(HDBCDSParser.ROW_NUMBER_SYMBOL, 0); }
		public TerminalNode RANK_SYMBOL() { return getToken(HDBCDSParser.RANK_SYMBOL, 0); }
		public TerminalNode DENSE_RANK_SYMBOL() { return getToken(HDBCDSParser.DENSE_RANK_SYMBOL, 0); }
		public TerminalNode NTILE_SYMBOL() { return getToken(HDBCDSParser.NTILE_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext simpleExprWithParentheses() {
			return getRuleContext(SimpleExprWithParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode LEAD_SYMBOL() { return getToken(HDBCDSParser.LEAD_SYMBOL, 0); }
		public TerminalNode LAG_SYMBOL() { return getToken(HDBCDSParser.LAG_SYMBOL, 0); }
		public LeadLagInfoContext leadLagInfo() {
			return getRuleContext(LeadLagInfoContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode FIRST_VALUE_SYMBOL() { return getToken(HDBCDSParser.FIRST_VALUE_SYMBOL, 0); }
		public TerminalNode LAST_VALUE_SYMBOL() { return getToken(HDBCDSParser.LAST_VALUE_SYMBOL, 0); }
		public WindowFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowFunctionCall(this);
		}
	}

	public final WindowFunctionCallContext windowFunctionCall() throws RecognitionException {
		WindowFunctionCallContext _localctx = new WindowFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_windowFunctionCall);
		int _la;
		try {
			setState(1349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DENSE_RANK_SYMBOL:
			case RANK_SYMBOL:
			case ROW_NUMBER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1328);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (DENSE_RANK_SYMBOL - 80)) | (1L << (RANK_SYMBOL - 80)) | (1L << (ROW_NUMBER_SYMBOL - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1329);
				parentheses();
				setState(1330);
				windowingClause();
				}
				break;
			case NTILE_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1332);
				match(NTILE_SYMBOL);
				setState(1333);
				simpleExprWithParentheses();
				setState(1334);
				windowingClause();
				}
				break;
			case LAG_SYMBOL:
			case LEAD_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1336);
				_la = _input.LA(1);
				if ( !(_la==LAG_SYMBOL || _la==LEAD_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1337);
				match(OPEN_PAR_SYMBOL);
				setState(1338);
				expr(0);
				setState(1340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(1339);
					leadLagInfo();
					}
				}

				setState(1342);
				match(CLOSE_PAR_SYMBOL);
				setState(1343);
				windowingClause();
				}
				break;
			case FIRST_VALUE_SYMBOL:
			case LAST_VALUE_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1345);
				_la = _input.LA(1);
				if ( !(_la==FIRST_VALUE_SYMBOL || _la==LAST_VALUE_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1346);
				exprWithParentheses();
				setState(1347);
				windowingClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowingClauseContext extends ParserRuleContext {
		public TerminalNode OVER_SYMBOL() { return getToken(HDBCDSParser.OVER_SYMBOL, 0); }
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public WindowingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowingClause(this);
		}
	}

	public final WindowingClauseContext windowingClause() throws RecognitionException {
		WindowingClauseContext _localctx = new WindowingClauseContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_windowingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1351);
			match(OVER_SYMBOL);
			setState(1354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				{
				setState(1352);
				windowName();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(1353);
				windowSpec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeadLagInfoContext extends ParserRuleContext {
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBCDSParser.PARAM_MARKER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeadLagInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leadLagInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLeadLagInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLeadLagInfo(this);
		}
	}

	public final LeadLagInfoContext leadLagInfo() throws RecognitionException {
		LeadLagInfoContext _localctx = new LeadLagInfoContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_leadLagInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1356);
			match(COMMA_SYMBOL);
			setState(1359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
				{
				setState(1357);
				ulonglong_number();
				}
				break;
			case PARAM_MARKER:
				{
				setState(1358);
				match(PARAM_MARKER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL) {
				{
				setState(1361);
				match(COMMA_SYMBOL);
				setState(1362);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InSumExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ALL_SYMBOL() { return getToken(HDBCDSParser.ALL_SYMBOL, 0); }
		public InSumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inSumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterInSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitInSumExpr(this);
		}
	}

	public final InSumExprContext inSumExpr() throws RecognitionException {
		InSumExprContext _localctx = new InSumExprContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_inSumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL_SYMBOL) {
				{
				setState(1365);
				match(ALL_SYMBOL);
				}
			}

			setState(1368);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentListArgContext extends ParserRuleContext {
		public IdentListContext identList() {
			return getRuleContext(IdentListContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identListArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentListArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentListArg(this);
		}
	}

	public final IdentListArgContext identListArg() throws RecognitionException {
		IdentListArgContext _localctx = new IdentListArgContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_identListArg);
		try {
			setState(1375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1370);
				identList();
				}
				break;
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1371);
				match(OPEN_PAR_SYMBOL);
				setState(1372);
				identList();
				setState(1373);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentListContext extends ParserRuleContext {
		public List<SimpleIdentifierContext> simpleIdentifier() {
			return getRuleContexts(SimpleIdentifierContext.class);
		}
		public SimpleIdentifierContext simpleIdentifier(int i) {
			return getRuleContext(SimpleIdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public IdentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentList(this);
		}
	}

	public final IdentListContext identList() throws RecognitionException {
		IdentListContext _localctx = new IdentListContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_identList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1377);
			simpleIdentifier();
			setState(1382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1378);
				match(COMMA_SYMBOL);
				setState(1379);
				simpleIdentifier();
				}
				}
				setState(1384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuntimeFunctionCallContext extends ParserRuleContext {
		public Token name;
		public TerminalNode CURRENT_USER_SYMBOL() { return getToken(HDBCDSParser.CURRENT_USER_SYMBOL, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode INTERVAL_SYMBOL() { return getToken(HDBCDSParser.INTERVAL_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public TerminalNode LEFT_SYMBOL() { return getToken(HDBCDSParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(HDBCDSParser.RIGHT_SYMBOL, 0); }
		public TerminalNode NOW_SYMBOL() { return getToken(HDBCDSParser.NOW_SYMBOL, 0); }
		public TimeFunctionParametersContext timeFunctionParameters() {
			return getRuleContext(TimeFunctionParametersContext.class,0);
		}
		public SubstringFunctionContext substringFunction() {
			return getRuleContext(SubstringFunctionContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode ASCII_SYMBOL() { return getToken(HDBCDSParser.ASCII_SYMBOL, 0); }
		public RuntimeFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runtimeFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterRuntimeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitRuntimeFunctionCall(this);
		}
	}

	public final RuntimeFunctionCallContext runtimeFunctionCall() throws RecognitionException {
		RuntimeFunctionCallContext _localctx = new RuntimeFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_runtimeFunctionCall);
		int _la;
		try {
			setState(1421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_USER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1385);
				((RuntimeFunctionCallContext)_localctx).name = match(CURRENT_USER_SYMBOL);
				setState(1387);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(1386);
					parentheses();
					}
					break;
				}
				}
				break;
			case INTERVAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1389);
				((RuntimeFunctionCallContext)_localctx).name = match(INTERVAL_SYMBOL);
				setState(1390);
				match(OPEN_PAR_SYMBOL);
				setState(1391);
				expr(0);
				setState(1394); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1392);
					match(COMMA_SYMBOL);
					setState(1393);
					expr(0);
					}
					}
					setState(1396); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA_SYMBOL );
				setState(1398);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case LEFT_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1400);
				((RuntimeFunctionCallContext)_localctx).name = match(LEFT_SYMBOL);
				setState(1401);
				match(OPEN_PAR_SYMBOL);
				setState(1402);
				expr(0);
				setState(1403);
				match(COMMA_SYMBOL);
				setState(1404);
				expr(0);
				setState(1405);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case RIGHT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1407);
				((RuntimeFunctionCallContext)_localctx).name = match(RIGHT_SYMBOL);
				setState(1408);
				match(OPEN_PAR_SYMBOL);
				setState(1409);
				expr(0);
				setState(1410);
				match(COMMA_SYMBOL);
				setState(1411);
				expr(0);
				setState(1412);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case NOW_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1414);
				((RuntimeFunctionCallContext)_localctx).name = match(NOW_SYMBOL);
				setState(1416);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
				case 1:
					{
					setState(1415);
					timeFunctionParameters();
					}
					break;
				}
				}
				break;
			case SUBSTRING_SYMBOL:
				enterOuterAlt(_localctx, 6);
				{
				setState(1418);
				substringFunction();
				}
				break;
			case ASCII_SYMBOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(1419);
				((RuntimeFunctionCallContext)_localctx).name = match(ASCII_SYMBOL);
				setState(1420);
				exprWithParentheses();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeFunctionParametersContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public FractionalPrecisionContext fractionalPrecision() {
			return getRuleContext(FractionalPrecisionContext.class,0);
		}
		public TimeFunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeFunctionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTimeFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTimeFunctionParameters(this);
		}
	}

	public final TimeFunctionParametersContext timeFunctionParameters() throws RecognitionException {
		TimeFunctionParametersContext _localctx = new TimeFunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_timeFunctionParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423);
			match(OPEN_PAR_SYMBOL);
			setState(1425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT_NUMBER) {
				{
				setState(1424);
				fractionalPrecision();
				}
			}

			setState(1427);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FractionalPrecisionContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public FractionalPrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fractionalPrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFractionalPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFractionalPrecision(this);
		}
	}

	public final FractionalPrecisionContext fractionalPrecision() throws RecognitionException {
		FractionalPrecisionContext _localctx = new FractionalPrecisionContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_fractionalPrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1429);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubstringFunctionContext extends ParserRuleContext {
		public TerminalNode SUBSTRING_SYMBOL() { return getToken(HDBCDSParser.SUBSTRING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public TerminalNode FROM_SYMBOL() { return getToken(HDBCDSParser.FROM_SYMBOL, 0); }
		public TerminalNode FOR_SYMBOL() { return getToken(HDBCDSParser.FOR_SYMBOL, 0); }
		public SubstringFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substringFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSubstringFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSubstringFunction(this);
		}
	}

	public final SubstringFunctionContext substringFunction() throws RecognitionException {
		SubstringFunctionContext _localctx = new SubstringFunctionContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_substringFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1431);
			match(SUBSTRING_SYMBOL);
			setState(1432);
			match(OPEN_PAR_SYMBOL);
			setState(1433);
			expr(0);
			setState(1446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA_SYMBOL:
				{
				setState(1434);
				match(COMMA_SYMBOL);
				setState(1435);
				expr(0);
				setState(1438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(1436);
					match(COMMA_SYMBOL);
					setState(1437);
					expr(0);
					}
				}

				}
				break;
			case FROM_SYMBOL:
				{
				setState(1440);
				match(FROM_SYMBOL);
				setState(1441);
				expr(0);
				setState(1444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL) {
					{
					setState(1442);
					match(FOR_SYMBOL);
					setState(1443);
					expr(0);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1448);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public PureIdentifierContext pureIdentifier() {
			return getRuleContext(PureIdentifierContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public UdfExprListContext udfExprList() {
			return getRuleContext(UdfExprListContext.class,0);
		}
		public QualifiedIdentifierContext qualifiedIdentifier() {
			return getRuleContext(QualifiedIdentifierContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_functionCall);
		int _la;
		try {
			setState(1464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1450);
				pureIdentifier();
				setState(1451);
				match(OPEN_PAR_SYMBOL);
				setState(1453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ASCII_SYMBOL - 66)) | (1L << (COALESCE_SYMBOL - 66)) | (1L << (SUBSTRING_SYMBOL - 66)) | (1L << (NOT_SYMBOL - 66)) | (1L << (CURRENT_USER_SYMBOL - 66)) | (1L << (DENSE_RANK_SYMBOL - 66)) | (1L << (FIRST_VALUE_SYMBOL - 66)) | (1L << (LAG_SYMBOL - 66)) | (1L << (LAST_VALUE_SYMBOL - 66)) | (1L << (LEAD_SYMBOL - 66)) | (1L << (NTILE_SYMBOL - 66)) | (1L << (NULLS_SYMBOL - 66)) | (1L << (PRECEDING_SYMBOL - 66)) | (1L << (RANK_SYMBOL - 66)) | (1L << (ROW_NUMBER_SYMBOL - 66)) | (1L << (UNBOUNDED_SYMBOL - 66)) | (1L << (INTERVAL_SYMBOL - 66)) | (1L << (CURRENT_SYMBOL - 66)) | (1L << (ROW_SYMBOL - 66)) | (1L << (FOLLOWING_SYMBOL - 66)) | (1L << (EXCLUDE_SYMBOL - 66)) | (1L << (TIES_SYMBOL - 66)) | (1L << (OTHERS_SYMBOL - 66)) | (1L << (AVG_SYMBOL - 66)) | (1L << (COUNT_SYMBOL - 66)) | (1L << (SUM_SYMBOL - 66)) | (1L << (MAX_SYMBOL - 66)) | (1L << (MIN_SYMBOL - 66)) | (1L << (STD_SYMBOL - 66)) | (1L << (VARIANCE_SYMBOL - 66)) | (1L << (GROUP_CONCAT_SYMBOL - 66)) | (1L << (MODE_SYMBOL - 66)) | (1L << (SHARE_SYMBOL - 66)) | (1L << (SKIP_SYMBOL - 66)) | (1L << (LOCKED_SYMBOL - 66)) | (1L << (LEFT_SYMBOL - 66)) | (1L << (RIGHT_SYMBOL - 66)) | (1L << (ANY_SYMBOL - 66)))) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (AT_SYMBOL - 130)) | (1L << (CASE_SYMBOL - 130)) | (1L << (CAST_SYMBOL - 130)) | (1L << (DATE_SYMBOL - 130)) | (1L << (ESCAPE_SYMBOL - 130)) | (1L << (EXISTS_SYMBOL - 130)) | (1L << (FALSE_SYMBOL - 130)) | (1L << (FIRST_SYMBOL - 130)) | (1L << (FULL_SYMBOL - 130)) | (1L << (LAST_SYMBOL - 130)) | (1L << (NOW_SYMBOL - 130)) | (1L << (NULL_SYMBOL - 130)) | (1L << (OFFSET_SYMBOL - 130)) | (1L << (TIMESTAMP_SYMBOL - 130)) | (1L << (TIME_SYMBOL - 130)) | (1L << (TRUE_SYMBOL - 130)) | (1L << (UNKNOWN_SYMBOL - 130)) | (1L << (NOWAIT_SYMBOL - 130)) | (1L << (GROUPING_SYMBOL - 130)) | (1L << (IDENTIFIER - 130)) | (1L << (NCHAR_TEXT - 130)) | (1L << (DOUBLE_QUOTED_TEXT - 130)) | (1L << (SINGLE_QUOTED_TEXT - 130)))) != 0)) {
					{
					setState(1452);
					udfExprList();
					}
				}

				setState(1455);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1457);
				qualifiedIdentifier();
				setState(1458);
				match(OPEN_PAR_SYMBOL);
				setState(1460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (ASCII_SYMBOL - 66)) | (1L << (COALESCE_SYMBOL - 66)) | (1L << (SUBSTRING_SYMBOL - 66)) | (1L << (NOT_SYMBOL - 66)) | (1L << (CURRENT_USER_SYMBOL - 66)) | (1L << (DENSE_RANK_SYMBOL - 66)) | (1L << (FIRST_VALUE_SYMBOL - 66)) | (1L << (LAG_SYMBOL - 66)) | (1L << (LAST_VALUE_SYMBOL - 66)) | (1L << (LEAD_SYMBOL - 66)) | (1L << (NTILE_SYMBOL - 66)) | (1L << (NULLS_SYMBOL - 66)) | (1L << (PRECEDING_SYMBOL - 66)) | (1L << (RANK_SYMBOL - 66)) | (1L << (ROW_NUMBER_SYMBOL - 66)) | (1L << (UNBOUNDED_SYMBOL - 66)) | (1L << (INTERVAL_SYMBOL - 66)) | (1L << (CURRENT_SYMBOL - 66)) | (1L << (ROW_SYMBOL - 66)) | (1L << (FOLLOWING_SYMBOL - 66)) | (1L << (EXCLUDE_SYMBOL - 66)) | (1L << (TIES_SYMBOL - 66)) | (1L << (OTHERS_SYMBOL - 66)) | (1L << (AVG_SYMBOL - 66)) | (1L << (COUNT_SYMBOL - 66)) | (1L << (SUM_SYMBOL - 66)) | (1L << (MAX_SYMBOL - 66)) | (1L << (MIN_SYMBOL - 66)) | (1L << (STD_SYMBOL - 66)) | (1L << (VARIANCE_SYMBOL - 66)) | (1L << (GROUP_CONCAT_SYMBOL - 66)) | (1L << (MODE_SYMBOL - 66)) | (1L << (SHARE_SYMBOL - 66)) | (1L << (SKIP_SYMBOL - 66)) | (1L << (LOCKED_SYMBOL - 66)) | (1L << (LEFT_SYMBOL - 66)) | (1L << (RIGHT_SYMBOL - 66)) | (1L << (ANY_SYMBOL - 66)))) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (AT_SYMBOL - 130)) | (1L << (CASE_SYMBOL - 130)) | (1L << (CAST_SYMBOL - 130)) | (1L << (DATE_SYMBOL - 130)) | (1L << (ESCAPE_SYMBOL - 130)) | (1L << (EXISTS_SYMBOL - 130)) | (1L << (FALSE_SYMBOL - 130)) | (1L << (FIRST_SYMBOL - 130)) | (1L << (FULL_SYMBOL - 130)) | (1L << (LAST_SYMBOL - 130)) | (1L << (NOW_SYMBOL - 130)) | (1L << (NULL_SYMBOL - 130)) | (1L << (OFFSET_SYMBOL - 130)) | (1L << (TIMESTAMP_SYMBOL - 130)) | (1L << (TIME_SYMBOL - 130)) | (1L << (TRUE_SYMBOL - 130)) | (1L << (UNKNOWN_SYMBOL - 130)) | (1L << (NOWAIT_SYMBOL - 130)) | (1L << (GROUPING_SYMBOL - 130)) | (1L << (IDENTIFIER - 130)) | (1L << (NCHAR_TEXT - 130)) | (1L << (DOUBLE_QUOTED_TEXT - 130)) | (1L << (SINGLE_QUOTED_TEXT - 130)))) != 0)) {
					{
					setState(1459);
					exprList();
					}
				}

				setState(1462);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdfExprListContext extends ParserRuleContext {
		public List<UdfExprContext> udfExpr() {
			return getRuleContexts(UdfExprContext.class);
		}
		public UdfExprContext udfExpr(int i) {
			return getRuleContext(UdfExprContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public UdfExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udfExprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterUdfExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitUdfExprList(this);
		}
	}

	public final UdfExprListContext udfExprList() throws RecognitionException {
		UdfExprListContext _localctx = new UdfExprListContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_udfExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			udfExpr();
			setState(1471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1467);
				match(COMMA_SYMBOL);
				setState(1468);
				udfExpr();
				}
				}
				setState(1473);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdfExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectAliasContext selectAlias() {
			return getRuleContext(SelectAliasContext.class,0);
		}
		public UdfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udfExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterUdfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitUdfExpr(this);
		}
	}

	public final UdfExprContext udfExpr() throws RecognitionException {
		UdfExprContext _localctx = new UdfExprContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_udfExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1474);
			expr(0);
			setState(1476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (COALESCE_SYMBOL - 67)) | (1L << (NULLS_SYMBOL - 67)) | (1L << (PRECEDING_SYMBOL - 67)) | (1L << (UNBOUNDED_SYMBOL - 67)) | (1L << (CURRENT_SYMBOL - 67)) | (1L << (FOLLOWING_SYMBOL - 67)) | (1L << (EXCLUDE_SYMBOL - 67)) | (1L << (TIES_SYMBOL - 67)) | (1L << (OTHERS_SYMBOL - 67)) | (1L << (AVG_SYMBOL - 67)) | (1L << (MODE_SYMBOL - 67)) | (1L << (SHARE_SYMBOL - 67)) | (1L << (SKIP_SYMBOL - 67)) | (1L << (LOCKED_SYMBOL - 67)) | (1L << (ANY_SYMBOL - 67)) | (1L << (AS_SYMBOL - 67)) | (1L << (AT_SYMBOL - 67)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (DATE_SYMBOL - 135)) | (1L << (ESCAPE_SYMBOL - 135)) | (1L << (FIRST_SYMBOL - 135)) | (1L << (FULL_SYMBOL - 135)) | (1L << (LAST_SYMBOL - 135)) | (1L << (OFFSET_SYMBOL - 135)) | (1L << (TIMESTAMP_SYMBOL - 135)) | (1L << (TIME_SYMBOL - 135)) | (1L << (UNKNOWN_SYMBOL - 135)) | (1L << (NOWAIT_SYMBOL - 135)) | (1L << (IDENTIFIER - 135)) | (1L << (DOUBLE_QUOTED_TEXT - 135)) | (1L << (SINGLE_QUOTED_TEXT - 135)))) != 0)) {
				{
				setState(1475);
				selectAlias();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenExpressionContext extends ParserRuleContext {
		public TerminalNode WHEN_SYMBOL() { return getToken(HDBCDSParser.WHEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWhenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWhenExpression(this);
		}
	}

	public final WhenExpressionContext whenExpression() throws RecognitionException {
		WhenExpressionContext _localctx = new WhenExpressionContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_whenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			match(WHEN_SYMBOL);
			setState(1479);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenExpressionContext extends ParserRuleContext {
		public TerminalNode THEN_SYMBOL() { return getToken(HDBCDSParser.THEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterThenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitThenExpression(this);
		}
	}

	public final ThenExpressionContext thenExpression() throws RecognitionException {
		ThenExpressionContext _localctx = new ThenExpressionContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_thenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1481);
			match(THEN_SYMBOL);
			setState(1482);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseExpressionContext extends ParserRuleContext {
		public TerminalNode ELSE_SYMBOL() { return getToken(HDBCDSParser.ELSE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterElseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitElseExpression(this);
		}
	}

	public final ElseExpressionContext elseExpression() throws RecognitionException {
		ElseExpressionContext _localctx = new ElseExpressionContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_elseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1484);
			match(ELSE_SYMBOL);
			setState(1485);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastTypeContext extends ParserRuleContext {
		public TerminalNode DATE_SYMBOL() { return getToken(HDBCDSParser.DATE_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBCDSParser.TIME_SYMBOL, 0); }
		public TypeDatetimePrecisionContext typeDatetimePrecision() {
			return getRuleContext(TypeDatetimePrecisionContext.class,0);
		}
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterCastType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitCastType(this);
		}
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_castType);
		int _la;
		try {
			setState(1492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1487);
				match(DATE_SYMBOL);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488);
				match(TIME_SYMBOL);
				setState(1490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR_SYMBOL) {
					{
					setState(1489);
					typeDatetimePrecision();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1494);
			expr(0);
			setState(1499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1495);
				match(COMMA_SYMBOL);
				setState(1496);
				expr(0);
				}
				}
				setState(1501);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotRuleContext extends ParserRuleContext {
		public TerminalNode NOT_SYMBOL() { return getToken(HDBCDSParser.NOT_SYMBOL, 0); }
		public TerminalNode NOT2_SYMBOL() { return getToken(HDBCDSParser.NOT2_SYMBOL, 0); }
		public NotRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterNotRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitNotRule(this);
		}
	}

	public final NotRuleContext notRule() throws RecognitionException {
		NotRuleContext _localctx = new NotRuleContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_notRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1502);
			_la = _input.LA(1);
			if ( !(_la==NOT2_SYMBOL || _la==NOT_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Not2RuleContext extends ParserRuleContext {
		public TerminalNode NOT2_SYMBOL() { return getToken(HDBCDSParser.NOT2_SYMBOL, 0); }
		public Not2RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not2Rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterNot2Rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitNot2Rule(this);
		}
	}

	public final Not2RuleContext not2Rule() throws RecognitionException {
		Not2RuleContext _localctx = new Not2RuleContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_not2Rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1504);
			match(NOT2_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListWithParenthesesContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprListWithParentheses(this);
		}
	}

	public final ExprListWithParenthesesContext exprListWithParentheses() throws RecognitionException {
		ExprListWithParenthesesContext _localctx = new ExprListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_exprListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1506);
			match(OPEN_PAR_SYMBOL);
			setState(1507);
			exprList();
			setState(1508);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprWithParenthesesContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitExprWithParentheses(this);
		}
	}

	public final ExprWithParenthesesContext exprWithParentheses() throws RecognitionException {
		ExprWithParenthesesContext _localctx = new ExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_exprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1510);
			match(OPEN_PAR_SYMBOL);
			setState(1511);
			expr(0);
			setState(1512);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExprWithParenthesesContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleExprWithParentheses(this);
		}
	}

	public final SimpleExprWithParenthesesContext simpleExprWithParentheses() throws RecognitionException {
		SimpleExprWithParenthesesContext _localctx = new SimpleExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_simpleExprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1514);
			match(OPEN_PAR_SYMBOL);
			setState(1515);
			simpleExpr(0);
			setState(1516);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderListContext extends ParserRuleContext {
		public List<OrderExpressionContext> orderExpression() {
			return getRuleContexts(OrderExpressionContext.class);
		}
		public OrderExpressionContext orderExpression(int i) {
			return getRuleContext(OrderExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public OrderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterOrderList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitOrderList(this);
		}
	}

	public final OrderListContext orderList() throws RecognitionException {
		OrderListContext _localctx = new OrderListContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_orderList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1518);
			orderExpression();
			setState(1523);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1519);
					match(COMMA_SYMBOL);
					setState(1520);
					orderExpression();
					}
					} 
				}
				setState(1525);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public OrderExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterOrderExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitOrderExpression(this);
		}
	}

	public final OrderExpressionContext orderExpression() throws RecognitionException {
		OrderExpressionContext _localctx = new OrderExpressionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_orderExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1526);
			expr(0);
			setState(1528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				{
				setState(1527);
				direction();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupListContext extends ParserRuleContext {
		public List<GroupingExpressionContext> groupingExpression() {
			return getRuleContexts(GroupingExpressionContext.class);
		}
		public GroupingExpressionContext groupingExpression(int i) {
			return getRuleContext(GroupingExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public GroupListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGroupList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGroupList(this);
		}
	}

	public final GroupListContext groupList() throws RecognitionException {
		GroupListContext _localctx = new GroupListContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_groupList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1530);
			groupingExpression();
			setState(1535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1531);
				match(COMMA_SYMBOL);
				setState(1532);
				groupingExpression();
				}
				}
				setState(1537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GroupingExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterGroupingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitGroupingExpression(this);
		}
	}

	public final GroupingExpressionContext groupingExpression() throws RecognitionException {
		GroupingExpressionContext _localctx = new GroupingExpressionContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_groupingExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1538);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PureIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HDBCDSParser.IDENTIFIER, 0); }
		public List<TerminalNode> DOT_IDENTIFIER() { return getTokens(HDBCDSParser.DOT_IDENTIFIER); }
		public TerminalNode DOT_IDENTIFIER(int i) {
			return getToken(HDBCDSParser.DOT_IDENTIFIER, i);
		}
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(HDBCDSParser.DOUBLE_QUOTED_TEXT, 0); }
		public PureIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPureIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPureIdentifier(this);
		}
	}

	public final PureIdentifierContext pureIdentifier() throws RecognitionException {
		PureIdentifierContext _localctx = new PureIdentifierContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_pureIdentifier);
		try {
			int _alt;
			setState(1548);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1540);
				match(IDENTIFIER);
				setState(1544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1541);
						match(DOT_IDENTIFIER);
						}
						} 
					}
					setState(1546);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				}
				}
				break;
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1547);
				match(DOUBLE_QUOTED_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public PureIdentifierContext pureIdentifier() {
			return getRuleContext(PureIdentifierContext.class,0);
		}
		public IdentifierKeywordContext identifierKeyword() {
			return getRuleContext(IdentifierKeywordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_identifier);
		try {
			setState(1552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1550);
				pureIdentifier();
				}
				break;
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1551);
				identifierKeyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1554);
			identifier();
			setState(1559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1555);
				match(COMMA_SYMBOL);
				setState(1556);
				identifier();
				}
				}
				setState(1561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListWithParenthesesContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentifierListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentifierListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentifierListWithParentheses(this);
		}
	}

	public final IdentifierListWithParenthesesContext identifierListWithParentheses() throws RecognitionException {
		IdentifierListWithParenthesesContext _localctx = new IdentifierListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_identifierListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1562);
			match(OPEN_PAR_SYMBOL);
			setState(1563);
			identifierList();
			setState(1564);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public QualifiedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterQualifiedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitQualifiedIdentifier(this);
		}
	}

	public final QualifiedIdentifierContext qualifiedIdentifier() throws RecognitionException {
		QualifiedIdentifierContext _localctx = new QualifiedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_qualifiedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			identifier();
			setState(1568);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				{
				setState(1567);
				dotIdentifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<DotIdentifierContext> dotIdentifier() {
			return getRuleContexts(DotIdentifierContext.class);
		}
		public DotIdentifierContext dotIdentifier(int i) {
			return getRuleContext(DotIdentifierContext.class,i);
		}
		public SimpleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSimpleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSimpleIdentifier(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_simpleIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			identifier();
			setState(1575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT_SYMBOL) {
				{
				setState(1571);
				dotIdentifier();
				setState(1573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1572);
					dotIdentifier();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DotIdentifierContext extends ParserRuleContext {
		public TerminalNode DOT_SYMBOL() { return getToken(HDBCDSParser.DOT_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterDotIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitDotIdentifier(this);
		}
	}

	public final DotIdentifierContext dotIdentifier() throws RecognitionException {
		DotIdentifierContext _localctx = new DotIdentifierContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_dotIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			match(DOT_SYMBOL);
			setState(1578);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ulong_numberContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBCDSParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBCDSParser.FLOAT_NUMBER, 0); }
		public Ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterUlong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitUlong_number(this);
		}
	}

	public final Ulong_numberContext ulong_number() throws RecognitionException {
		Ulong_numberContext _localctx = new Ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1580);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << HEX_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Real_ulong_numberContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public Real_ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterReal_ulong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitReal_ulong_number(this);
		}
	}

	public final Real_ulong_numberContext real_ulong_number() throws RecognitionException {
		Real_ulong_numberContext _localctx = new Real_ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_real_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1582);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << HEX_NUMBER) | (1L << INT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ulonglong_numberContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBCDSParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBCDSParser.FLOAT_NUMBER, 0); }
		public Ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterUlonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitUlonglong_number(this);
		}
	}

	public final Ulonglong_numberContext ulonglong_number() throws RecognitionException {
		Ulonglong_numberContext _localctx = new Ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1584);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Real_ulonglong_numberContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public Real_ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterReal_ulonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitReal_ulonglong_number(this);
		}
	}

	public final Real_ulonglong_numberContext real_ulonglong_number() throws RecognitionException {
		Real_ulonglong_numberContext _localctx = new Real_ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_real_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1586);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << HEX_NUMBER) | (1L << INT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TextLiteralContext textLiteral() {
			return getRuleContext(TextLiteralContext.class,0);
		}
		public NumLiteralContext numLiteral() {
			return getRuleContext(NumLiteralContext.class,0);
		}
		public TemporalLiteralContext temporalLiteral() {
			return getRuleContext(TemporalLiteralContext.class,0);
		}
		public NullLiteralContext nullLiteral() {
			return getRuleContext(NullLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(HDBCDSParser.BIN_NUMBER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_literal);
		int _la;
		try {
			setState(1594);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1588);
				textLiteral();
				}
				break;
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1589);
				numLiteral();
				}
				break;
			case DATE_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1590);
				temporalLiteral();
				}
				break;
			case NULL2_SYMBOL:
			case NULL_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1591);
				nullLiteral();
				}
				break;
			case FALSE_SYMBOL:
			case TRUE_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1592);
				boolLiteral();
				}
				break;
			case HEX_NUMBER:
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1593);
				_la = _input.LA(1);
				if ( !(_la==HEX_NUMBER || _la==BIN_NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedLiteralContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBCDSParser.PLUS_OPERATOR, 0); }
		public Ulong_numberContext ulong_number() {
			return getRuleContext(Ulong_numberContext.class,0);
		}
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBCDSParser.MINUS_OPERATOR, 0); }
		public SignedLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSignedLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSignedLiteral(this);
		}
	}

	public final SignedLiteralContext signedLiteral() throws RecognitionException {
		SignedLiteralContext _localctx = new SignedLiteralContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_signedLiteral);
		try {
			setState(1601);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case NULL2_SYMBOL:
			case HEX_NUMBER:
			case BIN_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
			case DATE_SYMBOL:
			case FALSE_SYMBOL:
			case NULL_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case TRUE_SYMBOL:
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1596);
				literal();
				}
				break;
			case PLUS_OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1597);
				match(PLUS_OPERATOR);
				setState(1598);
				ulong_number();
				}
				break;
			case MINUS_OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1599);
				match(MINUS_OPERATOR);
				setState(1600);
				ulong_number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringListContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<TextStringContext> textString() {
			return getRuleContexts(TextStringContext.class);
		}
		public TextStringContext textString(int i) {
			return getRuleContext(TextStringContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterStringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitStringList(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_stringList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1603);
			match(OPEN_PAR_SYMBOL);
			setState(1604);
			textString();
			setState(1609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1605);
				match(COMMA_SYMBOL);
				setState(1606);
				textString();
				}
				}
				setState(1611);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1612);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextStringLiteralContext extends ParserRuleContext {
		public Token value;
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(HDBCDSParser.DOUBLE_QUOTED_TEXT, 0); }
		public TextStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextStringLiteral(this);
		}
	}

	public final TextStringLiteralContext textStringLiteral() throws RecognitionException {
		TextStringLiteralContext _localctx = new TextStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_textStringLiteral);
		try {
			setState(1616);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1614);
				((TextStringLiteralContext)_localctx).value = match(SINGLE_QUOTED_TEXT);
				}
				break;
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1615);
				((TextStringLiteralContext)_localctx).value = match(DOUBLE_QUOTED_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextStringContext extends ParserRuleContext {
		public TextStringLiteralContext textStringLiteral() {
			return getRuleContext(TextStringLiteralContext.class,0);
		}
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(HDBCDSParser.BIN_NUMBER, 0); }
		public TextStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextString(this);
		}
	}

	public final TextStringContext textString() throws RecognitionException {
		TextStringContext _localctx = new TextStringContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_textString);
		try {
			setState(1621);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1618);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1619);
				match(HEX_NUMBER);
				}
				break;
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1620);
				match(BIN_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextStringHashContext extends ParserRuleContext {
		public TextStringLiteralContext textStringLiteral() {
			return getRuleContext(TextStringLiteralContext.class,0);
		}
		public TerminalNode HEX_NUMBER() { return getToken(HDBCDSParser.HEX_NUMBER, 0); }
		public TextStringHashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringHash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextStringHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextStringHash(this);
		}
	}

	public final TextStringHashContext textStringHash() throws RecognitionException {
		TextStringHashContext _localctx = new TextStringHashContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_textStringHash);
		try {
			setState(1625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1623);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1624);
				match(HEX_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextLiteralContext extends ParserRuleContext {
		public List<TextStringLiteralContext> textStringLiteral() {
			return getRuleContexts(TextStringLiteralContext.class);
		}
		public TextStringLiteralContext textStringLiteral(int i) {
			return getRuleContext(TextStringLiteralContext.class,i);
		}
		public TerminalNode NCHAR_TEXT() { return getToken(HDBCDSParser.NCHAR_TEXT, 0); }
		public TextLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextLiteral(this);
		}
	}

	public final TextLiteralContext textLiteral() throws RecognitionException {
		TextLiteralContext _localctx = new TextLiteralContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_textLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1629);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				{
				setState(1627);
				textStringLiteral();
				}
				break;
			case NCHAR_TEXT:
				{
				setState(1628);
				match(NCHAR_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1634);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1631);
					textStringLiteral();
					}
					} 
				}
				setState(1636);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextStringNoLinebreakContext extends ParserRuleContext {
		public TextStringLiteralContext textStringLiteral() {
			return getRuleContext(TextStringLiteralContext.class,0);
		}
		public TextStringNoLinebreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringNoLinebreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextStringNoLinebreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextStringNoLinebreak(this);
		}
	}

	public final TextStringNoLinebreakContext textStringNoLinebreak() throws RecognitionException {
		TextStringNoLinebreakContext _localctx = new TextStringNoLinebreakContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_textStringNoLinebreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1637);
			textStringLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextStringLiteralListContext extends ParserRuleContext {
		public List<TextStringLiteralContext> textStringLiteral() {
			return getRuleContexts(TextStringLiteralContext.class);
		}
		public TextStringLiteralContext textStringLiteral(int i) {
			return getRuleContext(TextStringLiteralContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public TextStringLiteralListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteralList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextStringLiteralList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextStringLiteralList(this);
		}
	}

	public final TextStringLiteralListContext textStringLiteralList() throws RecognitionException {
		TextStringLiteralListContext _localctx = new TextStringLiteralListContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_textStringLiteralList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1639);
			textStringLiteral();
			setState(1644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1640);
				match(COMMA_SYMBOL);
				setState(1641);
				textStringLiteral();
				}
				}
				setState(1646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumLiteralContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBCDSParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBCDSParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBCDSParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBCDSParser.FLOAT_NUMBER, 0); }
		public NumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterNumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitNumLiteral(this);
		}
	}

	public final NumLiteralContext numLiteral() throws RecognitionException {
		NumLiteralContext _localctx = new NumLiteralContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1647);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE_SYMBOL() { return getToken(HDBCDSParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(HDBCDSParser.FALSE_SYMBOL, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitBoolLiteral(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1649);
			_la = _input.LA(1);
			if ( !(_la==FALSE_SYMBOL || _la==TRUE_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullLiteralContext extends ParserRuleContext {
		public TerminalNode NULL_SYMBOL() { return getToken(HDBCDSParser.NULL_SYMBOL, 0); }
		public TerminalNode NULL2_SYMBOL() { return getToken(HDBCDSParser.NULL2_SYMBOL, 0); }
		public NullLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitNullLiteral(this);
		}
	}

	public final NullLiteralContext nullLiteral() throws RecognitionException {
		NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_nullLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			_la = _input.LA(1);
			if ( !(_la==NULL2_SYMBOL || _la==NULL_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalLiteralContext extends ParserRuleContext {
		public TerminalNode DATE_SYMBOL() { return getToken(HDBCDSParser.DATE_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBCDSParser.TIME_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(HDBCDSParser.TIMESTAMP_SYMBOL, 0); }
		public TemporalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTemporalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTemporalLiteral(this);
		}
	}

	public final TemporalLiteralContext temporalLiteral() throws RecognitionException {
		TemporalLiteralContext _localctx = new TemporalLiteralContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_temporalLiteral);
		try {
			setState(1659);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1653);
				match(DATE_SYMBOL);
				setState(1654);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1655);
				match(TIME_SYMBOL);
				setState(1656);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIMESTAMP_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1657);
				match(TIMESTAMP_SYMBOL);
				setState(1658);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatOptionsContext extends ParserRuleContext {
		public FieldLengthContext fieldLength() {
			return getRuleContext(FieldLengthContext.class,0);
		}
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public FloatOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFloatOptions(this);
		}
	}

	public final FloatOptionsContext floatOptions() throws RecognitionException {
		FloatOptionsContext _localctx = new FloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_floatOptions);
		try {
			setState(1663);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1661);
				fieldLength();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1662);
				precision();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StandardFloatOptionsContext extends ParserRuleContext {
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public StandardFloatOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardFloatOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterStandardFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitStandardFloatOptions(this);
		}
	}

	public final StandardFloatOptionsContext standardFloatOptions() throws RecognitionException {
		StandardFloatOptionsContext _localctx = new StandardFloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_standardFloatOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1665);
			precision();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrecisionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<TerminalNode> INT_NUMBER() { return getTokens(HDBCDSParser.INT_NUMBER); }
		public TerminalNode INT_NUMBER(int i) {
			return getToken(HDBCDSParser.INT_NUMBER, i);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBCDSParser.COMMA_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitPrecision(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1667);
			match(OPEN_PAR_SYMBOL);
			setState(1668);
			match(INT_NUMBER);
			setState(1669);
			match(COMMA_SYMBOL);
			setState(1670);
			match(INT_NUMBER);
			setState(1671);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextOrIdentifierContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBCDSParser.SINGLE_QUOTED_TEXT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TextOrIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textOrIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTextOrIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTextOrIdentifier(this);
		}
	}

	public final TextOrIdentifierContext textOrIdentifier() throws RecognitionException {
		TextOrIdentifierContext _localctx = new TextOrIdentifierContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_textOrIdentifier);
		try {
			setState(1675);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1673);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1674);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeNumberContext extends ParserRuleContext {
		public Real_ulonglong_numberContext real_ulonglong_number() {
			return getRuleContext(Real_ulonglong_numberContext.class,0);
		}
		public PureIdentifierContext pureIdentifier() {
			return getRuleContext(PureIdentifierContext.class,0);
		}
		public SizeNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterSizeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitSizeNumber(this);
		}
	}

	public final SizeNumberContext sizeNumber() throws RecognitionException {
		SizeNumberContext _localctx = new SizeNumberContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_sizeNumber);
		try {
			setState(1679);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1677);
				real_ulonglong_number();
				}
				break;
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1678);
				pureIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesesContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitParentheses(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1681);
			match(OPEN_PAR_SYMBOL);
			setState(1682);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualContext extends ParserRuleContext {
		public TerminalNode EQUAL_OPERATOR() { return getToken(HDBCDSParser.EQUAL_OPERATOR, 0); }
		public TerminalNode ASSIGN_OPERATOR() { return getToken(HDBCDSParser.ASSIGN_OPERATOR, 0); }
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_equal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1684);
			_la = _input.LA(1);
			if ( !(_la==EQUAL_OPERATOR || _la==ASSIGN_OPERATOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierKeywordContext extends ParserRuleContext {
		public IdentifierKeywordsUnambiguousContext identifierKeywordsUnambiguous() {
			return getRuleContext(IdentifierKeywordsUnambiguousContext.class,0);
		}
		public IdentifierKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentifierKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentifierKeyword(this);
		}
	}

	public final IdentifierKeywordContext identifierKeyword() throws RecognitionException {
		IdentifierKeywordContext _localctx = new IdentifierKeywordContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_identifierKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1686);
			identifierKeywordsUnambiguous();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierKeywordsUnambiguousContext extends ParserRuleContext {
		public TerminalNode ANY_SYMBOL() { return getToken(HDBCDSParser.ANY_SYMBOL, 0); }
		public TerminalNode AT_SYMBOL() { return getToken(HDBCDSParser.AT_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(HDBCDSParser.AVG_SYMBOL, 0); }
		public TerminalNode COALESCE_SYMBOL() { return getToken(HDBCDSParser.COALESCE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBCDSParser.CURRENT_SYMBOL, 0); }
		public TerminalNode DATE_SYMBOL() { return getToken(HDBCDSParser.DATE_SYMBOL, 0); }
		public TerminalNode ESCAPE_SYMBOL() { return getToken(HDBCDSParser.ESCAPE_SYMBOL, 0); }
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(HDBCDSParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode FIRST_SYMBOL() { return getToken(HDBCDSParser.FIRST_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(HDBCDSParser.FOLLOWING_SYMBOL, 0); }
		public TerminalNode FULL_SYMBOL() { return getToken(HDBCDSParser.FULL_SYMBOL, 0); }
		public TerminalNode LAST_SYMBOL() { return getToken(HDBCDSParser.LAST_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(HDBCDSParser.LOCKED_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(HDBCDSParser.MODE_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(HDBCDSParser.NOWAIT_SYMBOL, 0); }
		public TerminalNode NULLS_SYMBOL() { return getToken(HDBCDSParser.NULLS_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(HDBCDSParser.OFFSET_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(HDBCDSParser.OTHERS_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(HDBCDSParser.PRECEDING_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBCDSParser.SHARE_SYMBOL, 0); }
		public TerminalNode SKIP_SYMBOL() { return getToken(HDBCDSParser.SKIP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(HDBCDSParser.TIES_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(HDBCDSParser.TIMESTAMP_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBCDSParser.TIME_SYMBOL, 0); }
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBCDSParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(HDBCDSParser.UNKNOWN_SYMBOL, 0); }
		public IdentifierKeywordsUnambiguousContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierKeywordsUnambiguous; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterIdentifierKeywordsUnambiguous(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitIdentifierKeywordsUnambiguous(this);
		}
	}

	public final IdentifierKeywordsUnambiguousContext identifierKeywordsUnambiguous() throws RecognitionException {
		IdentifierKeywordsUnambiguousContext _localctx = new IdentifierKeywordsUnambiguousContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_identifierKeywordsUnambiguous);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1688);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (COALESCE_SYMBOL - 67)) | (1L << (NULLS_SYMBOL - 67)) | (1L << (PRECEDING_SYMBOL - 67)) | (1L << (UNBOUNDED_SYMBOL - 67)) | (1L << (CURRENT_SYMBOL - 67)) | (1L << (FOLLOWING_SYMBOL - 67)) | (1L << (EXCLUDE_SYMBOL - 67)) | (1L << (TIES_SYMBOL - 67)) | (1L << (OTHERS_SYMBOL - 67)) | (1L << (AVG_SYMBOL - 67)) | (1L << (MODE_SYMBOL - 67)) | (1L << (SHARE_SYMBOL - 67)) | (1L << (SKIP_SYMBOL - 67)) | (1L << (LOCKED_SYMBOL - 67)) | (1L << (ANY_SYMBOL - 67)) | (1L << (AT_SYMBOL - 67)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (DATE_SYMBOL - 135)) | (1L << (ESCAPE_SYMBOL - 135)) | (1L << (FIRST_SYMBOL - 135)) | (1L << (FULL_SYMBOL - 135)) | (1L << (LAST_SYMBOL - 135)) | (1L << (OFFSET_SYMBOL - 135)) | (1L << (TIMESTAMP_SYMBOL - 135)) | (1L << (TIME_SYMBOL - 135)) | (1L << (UNKNOWN_SYMBOL - 135)) | (1L << (NOWAIT_SYMBOL - 135)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public WindowNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterWindowName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitWindowName(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldIdentifierContext extends ParserRuleContext {
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public QualifiedIdentifierContext qualifiedIdentifier() {
			return getRuleContext(QualifiedIdentifierContext.class,0);
		}
		public FieldIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFieldIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFieldIdentifier(this);
		}
	}

	public final FieldIdentifierContext fieldIdentifier() throws RecognitionException {
		FieldIdentifierContext _localctx = new FieldIdentifierContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_fieldIdentifier);
		try {
			setState(1697);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1692);
				dotIdentifier();
				}
				break;
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1693);
				qualifiedIdentifier();
				setState(1695);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1694);
					dotIdentifier();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1699);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnInternalRefContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnInternalRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnInternalRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumnInternalRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumnInternalRef(this);
		}
	}

	public final ColumnInternalRefContext columnInternalRef() throws RecognitionException {
		ColumnInternalRefContext _localctx = new ColumnInternalRefContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_columnInternalRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnInternalRefListContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public List<ColumnInternalRefContext> columnInternalRef() {
			return getRuleContexts(ColumnInternalRefContext.class);
		}
		public ColumnInternalRefContext columnInternalRef(int i) {
			return getRuleContext(ColumnInternalRefContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public ColumnInternalRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnInternalRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumnInternalRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumnInternalRefList(this);
		}
	}

	public final ColumnInternalRefListContext columnInternalRefList() throws RecognitionException {
		ColumnInternalRefListContext _localctx = new ColumnInternalRefListContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_columnInternalRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1703);
			match(OPEN_PAR_SYMBOL);
			setState(1704);
			columnInternalRef();
			setState(1709);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1705);
				match(COMMA_SYMBOL);
				setState(1706);
				columnInternalRef();
				}
				}
				setState(1711);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1712);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnRefContext extends ParserRuleContext {
		public FieldIdentifierContext fieldIdentifier() {
			return getRuleContext(FieldIdentifierContext.class,0);
		}
		public ColumnRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitColumnRef(this);
		}
	}

	public final ColumnRefContext columnRef() throws RecognitionException {
		ColumnRefContext _localctx = new ColumnRefContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714);
			fieldIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableRefWithWildcardContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT_SYMBOL() { return getToken(HDBCDSParser.DOT_SYMBOL, 0); }
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public TableRefWithWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRefWithWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableRefWithWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableRefWithWildcard(this);
		}
	}

	public final TableRefWithWildcardContext tableRefWithWildcard() throws RecognitionException {
		TableRefWithWildcardContext _localctx = new TableRefWithWildcardContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_tableRefWithWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1716);
			identifier();
			setState(1724);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				{
				setState(1717);
				match(DOT_SYMBOL);
				setState(1718);
				match(MULT_OPERATOR);
				}
				break;
			case 2:
				{
				setState(1719);
				dotIdentifier();
				setState(1722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1720);
					match(DOT_SYMBOL);
					setState(1721);
					match(MULT_OPERATOR);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableAliasRefListContext extends ParserRuleContext {
		public List<TableRefWithWildcardContext> tableRefWithWildcard() {
			return getRuleContexts(TableRefWithWildcardContext.class);
		}
		public TableRefWithWildcardContext tableRefWithWildcard(int i) {
			return getRuleContext(TableRefWithWildcardContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBCDSParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBCDSParser.COMMA_SYMBOL, i);
		}
		public TableAliasRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAliasRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableAliasRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableAliasRefList(this);
		}
	}

	public final TableAliasRefListContext tableAliasRefList() throws RecognitionException {
		TableAliasRefListContext _localctx = new TableAliasRefListContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_tableAliasRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726);
			tableRefWithWildcard();
			setState(1731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1727);
				match(COMMA_SYMBOL);
				setState(1728);
				tableRefWithWildcard();
				}
				}
				setState(1733);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableWildContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT_SYMBOL() { return getTokens(HDBCDSParser.DOT_SYMBOL); }
		public TerminalNode DOT_SYMBOL(int i) {
			return getToken(HDBCDSParser.DOT_SYMBOL, i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBCDSParser.MULT_OPERATOR, 0); }
		public TableWildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableWild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableWild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableWild(this);
		}
	}

	public final TableWildContext tableWild() throws RecognitionException {
		TableWildContext _localctx = new TableWildContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_tableWild);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1734);
			identifier();
			setState(1735);
			match(DOT_SYMBOL);
			setState(1739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (COALESCE_SYMBOL - 67)) | (1L << (NULLS_SYMBOL - 67)) | (1L << (PRECEDING_SYMBOL - 67)) | (1L << (UNBOUNDED_SYMBOL - 67)) | (1L << (CURRENT_SYMBOL - 67)) | (1L << (FOLLOWING_SYMBOL - 67)) | (1L << (EXCLUDE_SYMBOL - 67)) | (1L << (TIES_SYMBOL - 67)) | (1L << (OTHERS_SYMBOL - 67)) | (1L << (AVG_SYMBOL - 67)) | (1L << (MODE_SYMBOL - 67)) | (1L << (SHARE_SYMBOL - 67)) | (1L << (SKIP_SYMBOL - 67)) | (1L << (LOCKED_SYMBOL - 67)) | (1L << (ANY_SYMBOL - 67)) | (1L << (AT_SYMBOL - 67)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (DATE_SYMBOL - 135)) | (1L << (ESCAPE_SYMBOL - 135)) | (1L << (FIRST_SYMBOL - 135)) | (1L << (FULL_SYMBOL - 135)) | (1L << (LAST_SYMBOL - 135)) | (1L << (OFFSET_SYMBOL - 135)) | (1L << (TIMESTAMP_SYMBOL - 135)) | (1L << (TIME_SYMBOL - 135)) | (1L << (UNKNOWN_SYMBOL - 135)) | (1L << (NOWAIT_SYMBOL - 135)) | (1L << (IDENTIFIER - 135)) | (1L << (DOUBLE_QUOTED_TEXT - 135)))) != 0)) {
				{
				setState(1736);
				identifier();
				setState(1737);
				match(DOT_SYMBOL);
				}
			}

			setState(1741);
			match(MULT_OPERATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableRefContext extends ParserRuleContext {
		public QualifiedIdentifierContext qualifiedIdentifier() {
			return getRuleContext(QualifiedIdentifierContext.class,0);
		}
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public TableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTableRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTableRef(this);
		}
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_tableRef);
		try {
			setState(1745);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COALESCE_SYMBOL:
			case NULLS_SYMBOL:
			case PRECEDING_SYMBOL:
			case UNBOUNDED_SYMBOL:
			case CURRENT_SYMBOL:
			case FOLLOWING_SYMBOL:
			case EXCLUDE_SYMBOL:
			case TIES_SYMBOL:
			case OTHERS_SYMBOL:
			case AVG_SYMBOL:
			case MODE_SYMBOL:
			case SHARE_SYMBOL:
			case SKIP_SYMBOL:
			case LOCKED_SYMBOL:
			case ANY_SYMBOL:
			case AT_SYMBOL:
			case DATE_SYMBOL:
			case ESCAPE_SYMBOL:
			case FIRST_SYMBOL:
			case FULL_SYMBOL:
			case LAST_SYMBOL:
			case OFFSET_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
			case UNKNOWN_SYMBOL:
			case NOWAIT_SYMBOL:
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1743);
				qualifiedIdentifier();
				}
				break;
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1744);
				dotIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldLengthContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public Real_ulonglong_numberContext real_ulonglong_number() {
			return getRuleContext(Real_ulonglong_numberContext.class,0);
		}
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBCDSParser.DECIMAL_NUMBER, 0); }
		public FieldLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterFieldLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitFieldLength(this);
		}
	}

	public final FieldLengthContext fieldLength() throws RecognitionException {
		FieldLengthContext _localctx = new FieldLengthContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_fieldLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1747);
			match(OPEN_PAR_SYMBOL);
			setState(1750);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				{
				setState(1748);
				real_ulonglong_number();
				}
				break;
			case DECIMAL_NUMBER:
				{
				setState(1749);
				match(DECIMAL_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1752);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDatetimePrecisionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBCDSParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBCDSParser.INT_NUMBER, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBCDSParser.CLOSE_PAR_SYMBOL, 0); }
		public TypeDatetimePrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDatetimePrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).enterTypeDatetimePrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSParserListener ) ((HDBCDSParserListener)listener).exitTypeDatetimePrecision(this);
		}
	}

	public final TypeDatetimePrecisionContext typeDatetimePrecision() throws RecognitionException {
		TypeDatetimePrecisionContext _localctx = new TypeDatetimePrecisionContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_typeDatetimePrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1754);
			match(OPEN_PAR_SYMBOL);
			setState(1755);
			match(INT_NUMBER);
			setState(1756);
			match(CLOSE_PAR_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 56:
			return queryExpressionBody_sempred((QueryExpressionBodyContext)_localctx, predIndex);
		case 104:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 105:
			return boolPri_sempred((BoolPriContext)_localctx, predIndex);
		case 109:
			return bitExpr_sempred((BitExprContext)_localctx, predIndex);
		case 110:
			return simpleExpr_sempred((SimpleExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryExpressionBody_sempred(QueryExpressionBodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean boolPri_sempred(BoolPriContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean bitExpr_sempred(BitExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simpleExpr_sempred(SimpleExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00ba\u06e1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\3\2\5"+
		"\2\u0176\n\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u017e\n\2\f\2\16\2\u0181\13\2"+
		"\3\3\3\3\3\3\3\3\3\4\5\4\u0188\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\u0193\n\4\f\4\16\4\u0196\13\4\3\4\3\4\3\4\3\5\5\5\u019c\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\5\6\u01a5\n\6\3\6\3\6\3\6\3\6\6\6\u01ab\n\6\r\6"+
		"\16\6\u01ac\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\5\b\u01b7\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\5\n\u01c2\n\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\21\5\21\u01db\n\21\3\22\5\22\u01de\n\22\3\22\3\22\3\22\3\22\6\22"+
		"\u01e4\n\22\r\22\16\22\u01e5\3\22\3\22\5\22\u01ea\n\22\3\22\3\22\3\23"+
		"\3\23\3\24\5\24\u01f1\n\24\3\24\3\24\5\24\u01f5\n\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\7\25\u01ff\n\25\f\25\16\25\u0202\13\25\3\25\5"+
		"\25\u0205\n\25\3\25\5\25\u0208\n\25\3\26\3\26\3\26\3\26\3\26\7\26\u020f"+
		"\n\26\f\26\16\26\u0212\13\26\3\26\5\26\u0215\n\26\3\26\5\26\u0218\n\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u0221\n\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u0229\n\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\7\35\u0237\n\35\f\35\16\35\u023a\13\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3\37\5\37\u0243\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\7\37\u024e\n\37\f\37\16\37\u0251\13\37\3\37\3\37\3 \3 \3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\5$\u0264\n$\3%\3%\3%\3&\3&\3&\3"+
		"\'\3\'\5\'\u026e\n\'\3(\3(\3(\3)\3)\3)\3*\5*\u0277\n*\3*\3*\3+\5+\u027c"+
		"\n+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\5-\u0288\n-\3-\3-\3.\3.\3.\3/\3/\3/"+
		"\3\60\5\60\u0293\n\60\3\60\5\60\u0296\n\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\5\60\u02a1\n\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\38\38\58\u02c0\n8\39\59\u02c3\n9\39\39"+
		"\59\u02c7\n9\39\59\u02ca\n9\39\39\39\59\u02cf\n9\39\59\u02d2\n9\59\u02d4"+
		"\n9\39\59\u02d7\n9\39\39\39\59\u02dc\n9\59\u02de\n9\3:\3:\3:\3:\3:\5:"+
		"\u02e5\n:\3:\3:\5:\u02e9\n:\5:\u02eb\n:\3:\3:\3:\5:\u02f0\n:\3:\3:\5:"+
		"\u02f4\n:\7:\u02f6\n:\f:\16:\u02f9\13:\3;\3;\3;\5;\u02fe\n;\3;\3;\3<\3"+
		"<\7<\u0304\n<\f<\16<\u0307\13<\3<\3<\5<\u030b\n<\3<\5<\u030e\n<\3<\5<"+
		"\u0311\n<\3<\5<\u0314\n<\3=\3=\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3A\5A\u0323"+
		"\nA\3B\3B\5B\u0327\nB\3C\3C\3C\3D\3D\3D\3D\7D\u0330\nD\fD\16D\u0333\13"+
		"D\3E\3E\3E\3E\3F\3F\3F\3F\3G\5G\u033e\nG\3G\3G\3G\5G\u0343\nG\3G\5G\u0346"+
		"\nG\3G\5G\u0349\nG\3H\3H\3H\5H\u034e\nH\3I\3I\3J\3J\5J\u0354\nJ\3K\3K"+
		"\3K\3K\3K\3K\3K\3K\3K\5K\u035f\nK\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M"+
		"\3M\5M\u036e\nM\3N\3N\3N\3N\3N\3N\3N\5N\u0377\nN\3O\3O\5O\u037b\nO\3O"+
		"\3O\3O\7O\u0380\nO\fO\16O\u0383\13O\3P\3P\5P\u0387\nP\3P\3P\3P\3Q\3Q\3"+
		"Q\3Q\3R\3R\3R\3R\3S\3S\3T\3T\3T\5T\u0399\nT\3U\3U\3U\7U\u039e\nU\fU\16"+
		"U\u03a1\13U\3V\3V\3W\3W\3W\3W\5W\u03a9\nW\3W\5W\u03ac\nW\3W\3W\3W\3W\5"+
		"W\u03b2\nW\3X\3X\3Y\3Y\3Y\5Y\u03b9\nY\3Z\3Z\5Z\u03bd\nZ\3Z\3Z\7Z\u03c1"+
		"\nZ\fZ\16Z\u03c4\13Z\3[\3[\3[\5[\u03c9\n[\5[\u03cb\n[\3\\\5\\\u03ce\n"+
		"\\\3\\\3\\\5\\\u03d2\n\\\3]\3]\3]\3^\3^\7^\u03d9\n^\f^\16^\u03dc\13^\3"+
		"_\3_\7_\u03e0\n_\f_\16_\u03e3\13_\3`\3`\3`\3`\3`\3`\5`\u03eb\n`\3`\3`"+
		"\3`\3`\3`\3`\5`\u03f3\n`\5`\u03f5\n`\3a\5a\u03f8\na\3a\3a\3b\3b\5b\u03fe"+
		"\nb\3b\3b\3c\3c\3c\3c\5c\u0406\nc\3d\3d\5d\u040a\nd\3e\3e\3e\5e\u040f"+
		"\ne\3e\3e\3f\3f\5f\u0415\nf\3f\5f\u0418\nf\3f\3f\3f\5f\u041d\nf\3f\5f"+
		"\u0420\nf\5f\u0422\nf\3g\3g\3g\5g\u0427\ng\3g\3g\3h\3h\3i\5i\u042e\ni"+
		"\3i\3i\3j\3j\3j\3j\5j\u0436\nj\3j\5j\u0439\nj\3j\3j\5j\u043d\nj\3j\3j"+
		"\3j\3j\3j\3j\7j\u0445\nj\fj\16j\u0448\13j\3k\3k\3k\3k\3k\3k\5k\u0450\n"+
		"k\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k\7k\u045c\nk\fk\16k\u045f\13k\3l\3l\3m"+
		"\3m\5m\u0465\nm\3m\5m\u0468\nm\3n\3n\3n\3n\3n\3n\5n\u0470\nn\3n\3n\3n"+
		"\3n\3n\3n\3n\3n\3n\5n\u047b\nn\5n\u047d\nn\3o\3o\3o\3o\3o\3o\3o\3o\3o"+
		"\7o\u0488\no\fo\16o\u048b\13o\3p\3p\3p\3p\3p\3p\3p\3p\3p\3p\3p\3p\3p\3"+
		"p\3p\5p\u049c\np\3p\3p\3p\3p\3p\5p\u04a3\np\3p\3p\3p\3p\3p\3p\3p\3p\3"+
		"p\3p\3p\3p\3p\3p\3p\5p\u04b4\np\3p\3p\3p\6p\u04b9\np\rp\16p\u04ba\3p\5"+
		"p\u04be\np\3p\3p\5p\u04c2\np\3p\3p\3p\7p\u04c7\np\fp\16p\u04ca\13p\3q"+
		"\3q\3q\5q\u04cf\nq\3q\3q\3q\5q\u04d4\nq\3q\3q\3q\5q\u04d9\nq\3q\3q\3q"+
		"\5q\u04de\nq\3q\3q\3q\5q\u04e3\nq\3q\3q\3q\3q\5q\u04e9\nq\3q\3q\5q\u04ed"+
		"\nq\3q\3q\3q\5q\u04f2\nq\3q\3q\3q\5q\u04f7\nq\3q\3q\3q\5q\u04fc\nq\3q"+
		"\3q\3q\5q\u0501\nq\3q\3q\3q\3q\3q\5q\u0508\nq\3q\3q\3q\3q\3q\5q\u050f"+
		"\nq\3q\3q\3q\5q\u0514\nq\3q\3q\3q\5q\u0519\nq\3q\3q\3q\5q\u051e\nq\3q"+
		"\3q\5q\u0522\nq\3q\3q\5q\u0526\nq\3q\3q\5q\u052a\nq\5q\u052c\nq\3r\3r"+
		"\3r\3r\3r\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\5s\u053f\ns\3s\3s\3s\3s"+
		"\3s\3s\3s\5s\u0548\ns\3t\3t\3t\5t\u054d\nt\3u\3u\3u\5u\u0552\nu\3u\3u"+
		"\5u\u0556\nu\3v\5v\u0559\nv\3v\3v\3w\3w\3w\3w\3w\5w\u0562\nw\3x\3x\3x"+
		"\7x\u0567\nx\fx\16x\u056a\13x\3y\3y\5y\u056e\ny\3y\3y\3y\3y\3y\6y\u0575"+
		"\ny\ry\16y\u0576\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3"+
		"y\5y\u058b\ny\3y\3y\3y\5y\u0590\ny\3z\3z\5z\u0594\nz\3z\3z\3{\3{\3|\3"+
		"|\3|\3|\3|\3|\3|\5|\u05a1\n|\3|\3|\3|\3|\5|\u05a7\n|\5|\u05a9\n|\3|\3"+
		"|\3}\3}\3}\5}\u05b0\n}\3}\3}\3}\3}\3}\5}\u05b7\n}\3}\3}\5}\u05bb\n}\3"+
		"~\3~\3~\7~\u05c0\n~\f~\16~\u05c3\13~\3\177\3\177\5\177\u05c7\n\177\3\u0080"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082\3\u0083"+
		"\3\u0083\3\u0083\5\u0083\u05d5\n\u0083\5\u0083\u05d7\n\u0083\3\u0084\3"+
		"\u0084\3\u0084\7\u0084\u05dc\n\u0084\f\u0084\16\u0084\u05df\13\u0084\3"+
		"\u0085\3\u0085\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a"+
		"\3\u008a\7\u008a\u05f4\n\u008a\f\u008a\16\u008a\u05f7\13\u008a\3\u008b"+
		"\3\u008b\5\u008b\u05fb\n\u008b\3\u008c\3\u008c\3\u008c\7\u008c\u0600\n"+
		"\u008c\f\u008c\16\u008c\u0603\13\u008c\3\u008d\3\u008d\3\u008e\3\u008e"+
		"\7\u008e\u0609\n\u008e\f\u008e\16\u008e\u060c\13\u008e\3\u008e\5\u008e"+
		"\u060f\n\u008e\3\u008f\3\u008f\5\u008f\u0613\n\u008f\3\u0090\3\u0090\3"+
		"\u0090\7\u0090\u0618\n\u0090\f\u0090\16\u0090\u061b\13\u0090\3\u0091\3"+
		"\u0091\3\u0091\3\u0091\3\u0092\3\u0092\5\u0092\u0623\n\u0092\3\u0093\3"+
		"\u0093\3\u0093\5\u0093\u0628\n\u0093\5\u0093\u062a\n\u0093\3\u0094\3\u0094"+
		"\3\u0094\3\u0095\3\u0095\3\u0096\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\5\u0099\u063d\n\u0099"+
		"\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\5\u009a\u0644\n\u009a\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\7\u009b\u064a\n\u009b\f\u009b\16\u009b\u064d"+
		"\13\u009b\3\u009b\3\u009b\3\u009c\3\u009c\5\u009c\u0653\n\u009c\3\u009d"+
		"\3\u009d\3\u009d\5\u009d\u0658\n\u009d\3\u009e\3\u009e\5\u009e\u065c\n"+
		"\u009e\3\u009f\3\u009f\5\u009f\u0660\n\u009f\3\u009f\7\u009f\u0663\n\u009f"+
		"\f\u009f\16\u009f\u0666\13\u009f\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1"+
		"\7\u00a1\u066d\n\u00a1\f\u00a1\16\u00a1\u0670\13\u00a1\3\u00a2\3\u00a2"+
		"\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a5\5\u00a5\u067e\n\u00a5\3\u00a6\3\u00a6\5\u00a6\u0682\n\u00a6\3"+
		"\u00a7\3\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9"+
		"\3\u00a9\5\u00a9\u068e\n\u00a9\3\u00aa\3\u00aa\5\u00aa\u0692\n\u00aa\3"+
		"\u00ab\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ae\3\u00ae"+
		"\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u06a2\n\u00b0\5\u00b0"+
		"\u06a4\n\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b3\3\u00b3\3\u00b3"+
		"\3\u00b3\7\u00b3\u06ae\n\u00b3\f\u00b3\16\u00b3\u06b1\13\u00b3\3\u00b3"+
		"\3\u00b3\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5"+
		"\5\u00b5\u06bd\n\u00b5\5\u00b5\u06bf\n\u00b5\3\u00b6\3\u00b6\3\u00b6\7"+
		"\u00b6\u06c4\n\u00b6\f\u00b6\16\u00b6\u06c7\13\u00b6\3\u00b7\3\u00b7\3"+
		"\u00b7\3\u00b7\3\u00b7\5\u00b7\u06ce\n\u00b7\3\u00b7\3\u00b7\3\u00b8\3"+
		"\u00b8\5\u00b8\u06d4\n\u00b8\3\u00b9\3\u00b9\3\u00b9\5\u00b9\u06d9\n\u00b9"+
		"\3\u00b9\3\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\2\7r\u00d2\u00d4"+
		"\u00dc\u00de\u00bb\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e"+
		"\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146"+
		"\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e"+
		"\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\2\35\4\2"+
		"\u00b2\u00b2\u00b5\u00b5\4\2??\u00b5\u00b5\5\2\7\7//??\4\2LLhh\4\2\63"+
		"\63\u00a0\u00a0\5\2\5\6<<??\4\2\u0083\u0083\u008a\u008a\3\2st\3\2xy\3"+
		"\2{|\4\2\u008f\u008f\u00a8\u00a9\4\2LL\u0081\u0081\4\2%%\',\3\2/\61\3"+
		"\2-.\4\2RR[\\\4\2TTVV\4\2SSUU\4\2\3\3JJ\5\2\5\6==?A\5\2\5\6==??\4\2\5"+
		"\6?A\3\2=>\4\2\u008f\u008f\u00a8\u00a8\4\2;;\u009f\u009f\3\2%&\26\2EE"+
		"XXZZ]]__adffrsvw\u0081\u0081\u0084\u0084\u0089\u0089\u008d\u008d\u0090"+
		"\u0090\u0092\u0092\u009a\u009a\u00a0\u00a0\u00a5\u00a6\u00a9\u00a9\u00ae"+
		"\u00ae\2\u072e\2\u0175\3\2\2\2\4\u0182\3\2\2\2\6\u0187\3\2\2\2\b\u019b"+
		"\3\2\2\2\n\u01a4\3\2\2\2\f\u01b1\3\2\2\2\16\u01b6\3\2\2\2\20\u01bd\3\2"+
		"\2\2\22\u01c1\3\2\2\2\24\u01c5\3\2\2\2\26\u01c7\3\2\2\2\30\u01c9\3\2\2"+
		"\2\32\u01cb\3\2\2\2\34\u01cd\3\2\2\2\36\u01d5\3\2\2\2 \u01da\3\2\2\2\""+
		"\u01dd\3\2\2\2$\u01ed\3\2\2\2&\u01f0\3\2\2\2(\u01f8\3\2\2\2*\u0209\3\2"+
		"\2\2,\u0219\3\2\2\2.\u021b\3\2\2\2\60\u022a\3\2\2\2\62\u022c\3\2\2\2\64"+
		"\u022e\3\2\2\2\66\u0230\3\2\2\28\u0232\3\2\2\2:\u023d\3\2\2\2<\u023f\3"+
		"\2\2\2>\u0254\3\2\2\2@\u0256\3\2\2\2B\u0259\3\2\2\2D\u025d\3\2\2\2F\u0263"+
		"\3\2\2\2H\u0265\3\2\2\2J\u0268\3\2\2\2L\u026d\3\2\2\2N\u026f\3\2\2\2P"+
		"\u0272\3\2\2\2R\u0276\3\2\2\2T\u027b\3\2\2\2V\u027f\3\2\2\2X\u0287\3\2"+
		"\2\2Z\u028b\3\2\2\2\\\u028e\3\2\2\2^\u0292\3\2\2\2`\u02a4\3\2\2\2b\u02a6"+
		"\3\2\2\2d\u02a8\3\2\2\2f\u02aa\3\2\2\2h\u02af\3\2\2\2j\u02b4\3\2\2\2l"+
		"\u02bb\3\2\2\2n\u02bf\3\2\2\2p\u02dd\3\2\2\2r\u02ea\3\2\2\2t\u02fa\3\2"+
		"\2\2v\u0301\3\2\2\2x\u0315\3\2\2\2z\u0317\3\2\2\2|\u0319\3\2\2\2~\u031c"+
		"\3\2\2\2\u0080\u031f\3\2\2\2\u0082\u0326\3\2\2\2\u0084\u0328\3\2\2\2\u0086"+
		"\u032b\3\2\2\2\u0088\u0334\3\2\2\2\u008a\u0338\3\2\2\2\u008c\u033d\3\2"+
		"\2\2\u008e\u034a\3\2\2\2\u0090\u034f\3\2\2\2\u0092\u0353\3\2\2\2\u0094"+
		"\u035e\3\2\2\2\u0096\u0360\3\2\2\2\u0098\u036d\3\2\2\2\u009a\u036f\3\2"+
		"\2\2\u009c\u0378\3\2\2\2\u009e\u0384\3\2\2\2\u00a0\u038b\3\2\2\2\u00a2"+
		"\u038f\3\2\2\2\u00a4\u0393\3\2\2\2\u00a6\u0395\3\2\2\2\u00a8\u039a\3\2"+
		"\2\2\u00aa\u03a2\3\2\2\2\u00ac\u03b1\3\2\2\2\u00ae\u03b3\3\2\2\2\u00b0"+
		"\u03b8\3\2\2\2\u00b2\u03bc\3\2\2\2\u00b4\u03ca\3\2\2\2\u00b6\u03cd\3\2"+
		"\2\2\u00b8\u03d3\3\2\2\2\u00ba\u03d6\3\2\2\2\u00bc\u03dd\3\2\2\2\u00be"+
		"\u03f4\3\2\2\2\u00c0\u03f7\3\2\2\2\u00c2\u03fb\3\2\2\2\u00c4\u0405\3\2"+
		"\2\2\u00c6\u0407\3\2\2\2\u00c8\u040b\3\2\2\2\u00ca\u0421\3\2\2\2\u00cc"+
		"\u0423\3\2\2\2\u00ce\u042a\3\2\2\2\u00d0\u042d\3\2\2\2\u00d2\u043c\3\2"+
		"\2\2\u00d4\u0449\3\2\2\2\u00d6\u0460\3\2\2\2\u00d8\u0462\3\2\2\2\u00da"+
		"\u047c\3\2\2\2\u00dc\u047e\3\2\2\2\u00de\u04c1\3\2\2\2\u00e0\u052b\3\2"+
		"\2\2\u00e2\u052d\3\2\2\2\u00e4\u0547\3\2\2\2\u00e6\u0549\3\2\2\2\u00e8"+
		"\u054e\3\2\2\2\u00ea\u0558\3\2\2\2\u00ec\u0561\3\2\2\2\u00ee\u0563\3\2"+
		"\2\2\u00f0\u058f\3\2\2\2\u00f2\u0591\3\2\2\2\u00f4\u0597\3\2\2\2\u00f6"+
		"\u0599\3\2\2\2\u00f8\u05ba\3\2\2\2\u00fa\u05bc\3\2\2\2\u00fc\u05c4\3\2"+
		"\2\2\u00fe\u05c8\3\2\2\2\u0100\u05cb\3\2\2\2\u0102\u05ce\3\2\2\2\u0104"+
		"\u05d6\3\2\2\2\u0106\u05d8\3\2\2\2\u0108\u05e0\3\2\2\2\u010a\u05e2\3\2"+
		"\2\2\u010c\u05e4\3\2\2\2\u010e\u05e8\3\2\2\2\u0110\u05ec\3\2\2\2\u0112"+
		"\u05f0\3\2\2\2\u0114\u05f8\3\2\2\2\u0116\u05fc\3\2\2\2\u0118\u0604\3\2"+
		"\2\2\u011a\u060e\3\2\2\2\u011c\u0612\3\2\2\2\u011e\u0614\3\2\2\2\u0120"+
		"\u061c\3\2\2\2\u0122\u0620\3\2\2\2\u0124\u0624\3\2\2\2\u0126\u062b\3\2"+
		"\2\2\u0128\u062e\3\2\2\2\u012a\u0630\3\2\2\2\u012c\u0632\3\2\2\2\u012e"+
		"\u0634\3\2\2\2\u0130\u063c\3\2\2\2\u0132\u0643\3\2\2\2\u0134\u0645\3\2"+
		"\2\2\u0136\u0652\3\2\2\2\u0138\u0657\3\2\2\2\u013a\u065b\3\2\2\2\u013c"+
		"\u065f\3\2\2\2\u013e\u0667\3\2\2\2\u0140\u0669\3\2\2\2\u0142\u0671\3\2"+
		"\2\2\u0144\u0673\3\2\2\2\u0146\u0675\3\2\2\2\u0148\u067d\3\2\2\2\u014a"+
		"\u0681\3\2\2\2\u014c\u0683\3\2\2\2\u014e\u0685\3\2\2\2\u0150\u068d\3\2"+
		"\2\2\u0152\u0691\3\2\2\2\u0154\u0693\3\2\2\2\u0156\u0696\3\2\2\2\u0158"+
		"\u0698\3\2\2\2\u015a\u069a\3\2\2\2\u015c\u069c\3\2\2\2\u015e\u06a3\3\2"+
		"\2\2\u0160\u06a5\3\2\2\2\u0162\u06a7\3\2\2\2\u0164\u06a9\3\2\2\2\u0166"+
		"\u06b4\3\2\2\2\u0168\u06b6\3\2\2\2\u016a\u06c0\3\2\2\2\u016c\u06c8\3\2"+
		"\2\2\u016e\u06d3\3\2\2\2\u0170\u06d5\3\2\2\2\u0172\u06dc\3\2\2\2\u0174"+
		"\u0176\5\4\3\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u017f\3\2"+
		"\2\2\u0177\u017e\5\6\4\2\u0178\u017e\5\b\5\2\u0179\u017e\5\n\6\2\u017a"+
		"\u017e\5\"\22\2\u017b\u017e\5^\60\2\u017c\u017e\5\34\17\2\u017d\u0177"+
		"\3\2\2\2\u017d\u0178\3\2\2\2\u017d\u0179\3\2\2\2\u017d\u017a\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\3\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183"+
		"\7\13\2\2\u0183\u0184\7\u00b2\2\2\u0184\u0185\7\64\2\2\u0185\5\3\2\2\2"+
		"\u0186\u0188\5\f\7\2\u0187\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189"+
		"\3\2\2\2\u0189\u018a\7\f\2\2\u018a\u018b\5\32\16\2\u018b\u0194\78\2\2"+
		"\u018c\u0193\5\6\4\2\u018d\u0193\5\b\5\2\u018e\u0193\5\n\6\2\u018f\u0193"+
		"\5\"\22\2\u0190\u0193\5^\60\2\u0191\u0193\5\34\17\2\u0192\u018c\3\2\2"+
		"\2\u0192\u018d\3\2\2\2\u0192\u018e\3\2\2\2\u0192\u018f\3\2\2\2\u0192\u0190"+
		"\3\2\2\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0198\79"+
		"\2\2\u0198\u0199\7\64\2\2\u0199\7\3\2\2\2\u019a\u019c\5\f\7\2\u019b\u019a"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\7\34\2\2"+
		"\u019e\u019f\5\24\13\2\u019f\u01a0\7\65\2\2\u01a0\u01a1\5 \21\2\u01a1"+
		"\u01a2\7\64\2\2\u01a2\t\3\2\2\2\u01a3\u01a5\5\f\7\2\u01a4\u01a3\3\2\2"+
		"\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7\34\2\2\u01a7"+
		"\u01a8\5\26\f\2\u01a8\u01aa\78\2\2\u01a9\u01ab\5\16\b\2\u01aa\u01a9\3"+
		"\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01af\79\2\2\u01af\u01b0\7\64\2\2\u01b0\13\3\2\2"+
		"\2\u01b1\u01b2\7\r\2\2\u01b2\u01b3\7\65\2\2\u01b3\u01b4\7\u00b5\2\2\u01b4"+
		"\r\3\2\2\2\u01b5\u01b7\5\f\7\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2"+
		"\u01b7\u01b8\3\2\2\2\u01b8\u01b9\5\30\r\2\u01b9\u01ba\7\65\2\2\u01ba\u01bb"+
		"\5 \21\2\u01bb\u01bc\7\64\2\2\u01bc\17\3\2\2\2\u01bd\u01be\7\35\2\2\u01be"+
		"\u01bf\t\2\2\2\u01bf\21\3\2\2\2\u01c0\u01c2\7J\2\2\u01c1\u01c0\3\2\2\2"+
		"\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\7\u009f\2\2\u01c4"+
		"\23\3\2\2\2\u01c5\u01c6\7\u00b2\2\2\u01c6\25\3\2\2\2\u01c7\u01c8\7\u00b2"+
		"\2\2\u01c8\27\3\2\2\2\u01c9\u01ca\7\u00b2\2\2\u01ca\31\3\2\2\2\u01cb\u01cc"+
		"\7\u00b2\2\2\u01cc\33\3\2\2\2\u01cd\u01ce\7\20\2\2\u01ce\u01cf\5\36\20"+
		"\2\u01cf\u01d0\7\65\2\2\u01d0\u01d1\5 \21\2\u01d1\u01d2\7%\2\2\u01d2\u01d3"+
		"\t\3\2\2\u01d3\u01d4\7\64\2\2\u01d4\35\3\2\2\2\u01d5\u01d6\7\u00b2\2\2"+
		"\u01d6\37\3\2\2\2\u01d7\u01db\5h\65\2\u01d8\u01db\5j\66\2\u01d9\u01db"+
		"\5l\67\2\u01da\u01d7\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01d9\3\2\2\2\u01db"+
		"!\3\2\2\2\u01dc\u01de\5\f\7\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2"+
		"\u01de\u01df\3\2\2\2\u01df\u01e0\7\16\2\2\u01e0\u01e1\5$\23\2\u01e1\u01e3"+
		"\78\2\2\u01e2\u01e4\5&\24\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\79"+
		"\2\2\u01e8\u01ea\5V,\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb"+
		"\3\2\2\2\u01eb\u01ec\7\64\2\2\u01ec#\3\2\2\2\u01ed\u01ee\7\u00b2\2\2\u01ee"+
		"%\3\2\2\2\u01ef\u01f1\5\f\7\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2"+
		"\u01f1\u01f4\3\2\2\2\u01f2\u01f5\5(\25\2\u01f3\u01f5\5*\26\2\u01f4\u01f2"+
		"\3\2\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\7\64\2\2"+
		"\u01f7\'\3\2\2\2\u01f8\u01f9\7\36\2\2\u01f9\u01fa\5,\27\2\u01fa\u0207"+
		"\7\65\2\2\u01fb\u0200\5 \21\2\u01fc\u01ff\5\20\t\2\u01fd\u01ff\5\22\n"+
		"\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe"+
		"\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0203"+
		"\u0205\5<\37\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208\3\2"+
		"\2\2\u0206\u0208\5.\30\2\u0207\u01fb\3\2\2\2\u0207\u0206\3\2\2\2\u0208"+
		")\3\2\2\2\u0209\u020a\5,\27\2\u020a\u0217\7\65\2\2\u020b\u0210\5 \21\2"+
		"\u020c\u020f\5\20\t\2\u020d\u020f\5\22\n\2\u020e\u020c\3\2\2\2\u020e\u020d"+
		"\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211"+
		"\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0215\5<\37\2\u0214\u0213\3\2"+
		"\2\2\u0214\u0215\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0218\5.\30\2\u0217"+
		"\u020b\3\2\2\2\u0217\u0216\3\2\2\2\u0218+\3\2\2\2\u0219\u021a\7\u00b2"+
		"\2\2\u021a-\3\2\2\2\u021b\u021c\7\17\2\2\u021c\u021d\7\b\2\2\u021d\u0220"+
		"\5\64\33\2\u021e\u021f\7\63\2\2\u021f\u0221\5\66\34\2\u0220\u021e\3\2"+
		"\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\7\t\2\2\u0223"+
		"\u0224\7\u00a7\2\2\u0224\u0228\5\60\31\2\u0225\u0226\7\u00a1\2\2\u0226"+
		"\u0229\5\62\32\2\u0227\u0229\58\35\2\u0228\u0225\3\2\2\2\u0228\u0227\3"+
		"\2\2\2\u0229/\3\2\2\2\u022a\u022b\7\u00b2\2\2\u022b\61\3\2\2\2\u022c\u022d"+
		"\5\u00d2j\2\u022d\63\3\2\2\2\u022e\u022f\t\4\2\2\u022f\65\3\2\2\2\u0230"+
		"\u0231\t\4\2\2\u0231\67\3\2\2\2\u0232\u0233\78\2\2\u0233\u0238\5:\36\2"+
		"\u0234\u0235\7\63\2\2\u0235\u0237\5:\36\2\u0236\u0234\3\2\2\2\u0237\u023a"+
		"\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\3\2\2\2\u023a"+
		"\u0238\3\2\2\2\u023b\u023c\79\2\2\u023c9\3\2\2\2\u023d\u023e\7\u00b2\2"+
		"\2\u023e;\3\2\2\2\u023f\u0242\7\37\2\2\u0240\u0243\5> \2\u0241\u0243\5"+
		"@!\2\u0242\u0240\3\2\2\2\u0242\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0245\7\u0082\2\2\u0245\u0246\7\n\2\2\u0246\u024f\7\66\2\2\u0247\u024e"+
		"\5B\"\2\u0248\u024e\5D#\2\u0249\u024e\5F$\2\u024a\u024e\5L\'\2\u024b\u024e"+
		"\5R*\2\u024c\u024e\5T+\2\u024d\u0247\3\2\2\2\u024d\u0248\3\2\2\2\u024d"+
		"\u0249\3\2\2\2\u024d\u024a\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024c\3\2"+
		"\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"\u0252\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0253\7\67\2\2\u0253=\3\2\2\2"+
		"\u0254\u0255\7\21\2\2\u0255?\3\2\2\2\u0256\u0257\7Q\2\2\u0257\u0258\7"+
		"\35\2\2\u0258A\3\2\2\2\u0259\u025a\7 \2\2\u025a\u025b\7\u00ac\2\2\u025b"+
		"\u025c\7?\2\2\u025cC\3\2\2\2\u025d\u025e\7\22\2\2\u025e\u025f\7Q\2\2\u025f"+
		"\u0260\7?\2\2\u0260E\3\2\2\2\u0261\u0264\5H%\2\u0262\u0264\5J&\2\u0263"+
		"\u0261\3\2\2\2\u0263\u0262\3\2\2\2\u0264G\3\2\2\2\u0265\u0266\7\u009e"+
		"\2\2\u0266\u0267\7\23\2\2\u0267I\3\2\2\2\u0268\u0269\7\23\2\2\u0269\u026a"+
		"\7?\2\2\u026aK\3\2\2\2\u026b\u026e\5N(\2\u026c\u026e\5P)\2\u026d\u026b"+
		"\3\2\2\2\u026d\u026c\3\2\2\2\u026eM\3\2\2\2\u026f\u0270\7\u009e\2\2\u0270"+
		"\u0271\7\24\2\2\u0271O\3\2\2\2\u0272\u0273\7\24\2\2\u0273\u0274\7?\2\2"+
		"\u0274Q\3\2\2\2\u0275\u0277\7\u009e\2\2\u0276\u0275\3\2\2\2\u0276\u0277"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\7!\2\2\u0279S\3\2\2\2\u027a\u027c"+
		"\7\u009e\2\2\u027b\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027d\3\2\2"+
		"\2\u027d\u027e\7\25\2\2\u027eU\3\2\2\2\u027f\u0280\7\27\2\2\u0280\u0281"+
		"\7\26\2\2\u0281\u0282\78\2\2\u0282\u0283\5X-\2\u0283\u0284\79\2\2\u0284"+
		"W\3\2\2\2\u0285\u0288\5Z.\2\u0286\u0288\5\\/\2\u0287\u0285\3\2\2\2\u0287"+
		"\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\7\64\2\2\u028aY\3\2\2\2"+
		"\u028b\u028c\7\"\2\2\u028c\u028d\7\30\2\2\u028d[\3\2\2\2\u028e\u028f\7"+
		"`\2\2\u028f\u0290\7\30\2\2\u0290]\3\2\2\2\u0291\u0293\5\f\7\2\u0292\u0291"+
		"\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0295\3\2\2\2\u0294\u0296\7\31\2\2"+
		"\u0295\u0294\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298"+
		"\7#\2\2\u0298\u0299\5`\61\2\u0299\u029a\7\u0082\2\2\u029a\u029b\7\u00a4"+
		"\2\2\u029b\u029c\5\u00a6T\2\u029c\u029d\78\2\2\u029d\u029e\5b\62\2\u029e"+
		"\u02a0\79\2\2\u029f\u02a1\5d\63\2\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2"+
		"\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\7\64\2\2\u02a3_\3\2\2\2\u02a4\u02a5"+
		"\5\u011c\u008f\2\u02a5a\3\2\2\2\u02a6\u02a7\5\u00b2Z\2\u02a7c\3\2\2\2"+
		"\u02a8\u02a9\5f\64\2\u02a9e\3\2\2\2\u02aa\u02ab\7\u00ac\2\2\u02ab\u02ac"+
		"\7\32\2\2\u02ac\u02ad\7\33\2\2\u02ad\u02ae\7$\2\2\u02aeg\3\2\2\2\u02af"+
		"\u02b0\7\u00b2\2\2\u02b0\u02b1\7\66\2\2\u02b1\u02b2\7?\2\2\u02b2\u02b3"+
		"\7\67\2\2\u02b3i\3\2\2\2\u02b4\u02b5\7\u00b2\2\2\u02b5\u02b6\7\66\2\2"+
		"\u02b6\u02b7\7?\2\2\u02b7\u02b8\7\63\2\2\u02b8\u02b9\7?\2\2\u02b9\u02ba"+
		"\7\67\2\2\u02bak\3\2\2\2\u02bb\u02bc\7\u00b2\2\2\u02bcm\3\2\2\2\u02bd"+
		"\u02c0\5p9\2\u02be\u02c0\5t;\2\u02bf\u02bd\3\2\2\2\u02bf\u02be\3\2\2\2"+
		"\u02c0o\3\2\2\2\u02c1\u02c3\5\u009cO\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3"+
		"\3\2\2\2\u02c3\u02d3\3\2\2\2\u02c4\u02c6\5r:\2\u02c5\u02c7\5\u00a2R\2"+
		"\u02c6\u02c5\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c9\3\2\2\2\u02c8\u02ca"+
		"\5|?\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02d4\3\2\2\2\u02cb"+
		"\u02d1\5t;\2\u02cc\u02ce\5\u00a2R\2\u02cd\u02cf\5|?\2\u02ce\u02cd\3\2"+
		"\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02d2\5|?\2\u02d1\u02cc"+
		"\3\2\2\2\u02d1\u02d0\3\2\2\2\u02d2\u02d4\3\2\2\2\u02d3\u02c4\3\2\2\2\u02d3"+
		"\u02cb\3\2\2\2\u02d4\u02d6\3\2\2\2\u02d5\u02d7\5\u00acW\2\u02d6\u02d5"+
		"\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02de\3\2\2\2\u02d8\u02d9\5\u009cO"+
		"\2\u02d9\u02db\5t;\2\u02da\u02dc\5\u00acW\2\u02db\u02da\3\2\2\2\u02db"+
		"\u02dc\3\2\2\2\u02dc\u02de\3\2\2\2\u02dd\u02c2\3\2\2\2\u02dd\u02d8\3\2"+
		"\2\2\u02deq\3\2\2\2\u02df\u02e0\b:\1\2\u02e0\u02eb\5v<\2\u02e1\u02e2\5"+
		"t;\2\u02e2\u02e4\7K\2\2\u02e3\u02e5\5\u00ceh\2\u02e4\u02e3\3\2\2\2\u02e4"+
		"\u02e5\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e9\5v<\2\u02e7\u02e9\5t;\2"+
		"\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02df"+
		"\3\2\2\2\u02ea\u02e1\3\2\2\2\u02eb\u02f7\3\2\2\2\u02ec\u02ed\f\4\2\2\u02ed"+
		"\u02ef\7K\2\2\u02ee\u02f0\5\u00ceh\2\u02ef\u02ee\3\2\2\2\u02ef\u02f0\3"+
		"\2\2\2\u02f0\u02f3\3\2\2\2\u02f1\u02f4\5v<\2\u02f2\u02f4\5t;\2\u02f3\u02f1"+
		"\3\2\2\2\u02f3\u02f2\3\2\2\2\u02f4\u02f6\3\2\2\2\u02f5\u02ec\3\2\2\2\u02f6"+
		"\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8s\3\2\2\2"+
		"\u02f9\u02f7\3\2\2\2\u02fa\u02fd\7\66\2\2\u02fb\u02fe\5t;\2\u02fc\u02fe"+
		"\5p9\2\u02fd\u02fb\3\2\2\2\u02fd\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff"+
		"\u0300\7\67\2\2\u0300u\3\2\2\2\u0301\u0305\7\u00a4\2\2\u0302\u0304\5\u00aa"+
		"V\2\u0303\u0302\3\2\2\2\u0304\u0307\3\2\2\2\u0305\u0303\3\2\2\2\u0305"+
		"\u0306\3\2\2\2\u0306\u0308\3\2\2\2\u0307\u0305\3\2\2\2\u0308\u030a\5\u00b2"+
		"Z\2\u0309\u030b\5\u00a6T\2\u030a\u0309\3\2\2\2\u030a\u030b\3\2\2\2\u030b"+
		"\u030d\3\2\2\2\u030c\u030e\5\u00b8]\2\u030d\u030c\3\2\2\2\u030d\u030e"+
		"\3\2\2\2\u030e\u0310\3\2\2\2\u030f\u0311\5\u00a0Q\2\u0310\u030f\3\2\2"+
		"\2\u0310\u0311\3\2\2\2\u0311\u0313\3\2\2\2\u0312\u0314\5\u0084C\2\u0313"+
		"\u0312\3\2\2\2\u0313\u0314\3\2\2\2\u0314w\3\2\2\2\u0315\u0316\5t;\2\u0316"+
		"y\3\2\2\2\u0317\u0318\t\5\2\2\u0318{\3\2\2\2\u0319\u031a\7\u009c\2\2\u031a"+
		"\u031b\5\u0080A\2\u031b}\3\2\2\2\u031c\u031d\7\u009c\2\2\u031d\u031e\5"+
		"\u0082B\2\u031e\177\3\2\2\2\u031f\u0322\5\u0082B\2\u0320\u0321\t\6\2\2"+
		"\u0321\u0323\5\u0082B\2\u0322\u0320\3\2\2\2\u0322\u0323\3\2\2\2\u0323"+
		"\u0081\3\2\2\2\u0324\u0327\5\u011c\u008f\2\u0325\u0327\t\7\2\2\u0326\u0324"+
		"\3\2\2\2\u0326\u0325\3\2\2\2\u0327\u0083\3\2\2\2\u0328\u0329\7\u0096\2"+
		"\2\u0329\u032a\5\u00d2j\2\u032a\u0085\3\2\2\2\u032b\u032c\7O\2\2\u032c"+
		"\u0331\5\u0088E\2\u032d\u032e\7\63\2\2\u032e\u0330\5\u0088E\2\u032f\u032d"+
		"\3\2\2\2\u0330\u0333\3\2\2\2\u0331\u032f\3\2\2\2\u0331\u0332\3\2\2\2\u0332"+
		"\u0087\3\2\2\2\u0333\u0331\3\2\2\2\u0334\u0335\5\u015c\u00af\2\u0335\u0336"+
		"\7\u0082\2\2\u0336\u0337\5\u008aF\2\u0337\u0089\3\2\2\2\u0338\u0339\7"+
		"\66\2\2\u0339\u033a\5\u008cG\2\u033a\u033b\7\67\2\2\u033b\u008b\3\2\2"+
		"\2\u033c\u033e\5\u015c\u00af\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2"+
		"\u033e\u0342\3\2\2\2\u033f\u0340\7P\2\2\u0340\u0341\7Q\2\2\u0341\u0343"+
		"\5\u0112\u008a\2\u0342\u033f\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0345\3"+
		"\2\2\2\u0344\u0346\5\u00a2R\2\u0345\u0344\3\2\2\2\u0345\u0346\3\2\2\2"+
		"\u0346\u0348\3\2\2\2\u0347\u0349\5\u008eH\2\u0348\u0347\3\2\2\2\u0348"+
		"\u0349\3\2\2\2\u0349\u008d\3\2\2\2\u034a\u034b\5\u0090I\2\u034b\u034d"+
		"\5\u0092J\2\u034c\u034e\5\u009aN\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2"+
		"\2\2\u034e\u008f\3\2\2\2\u034f\u0350\7N\2\2\u0350\u0091\3\2\2\2\u0351"+
		"\u0354\5\u0094K\2\u0352\u0354\5\u0096L\2\u0353\u0351\3\2\2\2\u0353\u0352"+
		"\3\2\2\2\u0354\u0093\3\2\2\2\u0355\u0356\7]\2\2\u0356\u035f\7Z\2\2\u0357"+
		"\u0358\5\u012c\u0097\2\u0358\u0359\7Z\2\2\u0359\u035f\3\2\2\2\u035a\u035b"+
		"\7<\2\2\u035b\u035f\7Z\2\2\u035c\u035d\7_\2\2\u035d\u035f\7`\2\2\u035e"+
		"\u0355\3\2\2\2\u035e\u0357\3\2\2\2\u035e\u035a\3\2\2\2\u035e\u035c\3\2"+
		"\2\2\u035f\u0095\3\2\2\2\u0360\u0361\7\u0085\2\2\u0361\u0362\5\u0098M"+
		"\2\u0362\u0363\7H\2\2\u0363\u0364\5\u0098M\2\u0364\u0097\3\2\2\2\u0365"+
		"\u036e\5\u0094K\2\u0366\u0367\7]\2\2\u0367\u036e\7a\2\2\u0368\u0369\5"+
		"\u012c\u0097\2\u0369\u036a\7a\2\2\u036a\u036e\3\2\2\2\u036b\u036c\7<\2"+
		"\2\u036c\u036e\7a\2\2\u036d\u0365\3\2\2\2\u036d\u0366\3\2\2\2\u036d\u0368"+
		"\3\2\2\2\u036d\u036b\3\2\2\2\u036e\u0099\3\2\2\2\u036f\u0376\7b\2\2\u0370"+
		"\u0371\7_\2\2\u0371\u0377\7`\2\2\u0372\u0377\7\u0095\2\2\u0373\u0377\7"+
		"c\2\2\u0374\u0375\7\u009e\2\2\u0375\u0377\7d\2\2\u0376\u0370\3\2\2\2\u0376"+
		"\u0372\3\2\2\2\u0376\u0373\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u009b\3\2"+
		"\2\2\u0378\u037a\7\u00ac\2\2\u0379\u037b\7e\2\2\u037a\u0379\3\2\2\2\u037a"+
		"\u037b\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u0381\5\u009eP\2\u037d\u037e"+
		"\7\63\2\2\u037e\u0380\5\u009eP\2\u037f\u037d\3\2\2\2\u0380\u0383\3\2\2"+
		"\2\u0381\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u009d\3\2\2\2\u0383\u0381"+
		"\3\2\2\2\u0384\u0386\5\u011c\u008f\2\u0385\u0387\5\u0164\u00b3\2\u0386"+
		"\u0385\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u0389\7\u0082"+
		"\2\2\u0389\u038a\5x=\2\u038a\u009f\3\2\2\2\u038b\u038c\7\u0095\2\2\u038c"+
		"\u038d\7Q\2\2\u038d\u038e\5\u0112\u008a\2\u038e\u00a1\3\2\2\2\u038f\u0390"+
		"\7\u00a2\2\2\u0390\u0391\7Q\2\2\u0391\u0392\5\u0112\u008a\2\u0392\u00a3"+
		"\3\2\2\2\u0393\u0394\t\b\2\2\u0394\u00a5\3\2\2\2\u0395\u0398\7\u0091\2"+
		"\2\u0396\u0399\7\u008b\2\2\u0397\u0399\5\u00a8U\2\u0398\u0396\3\2\2\2"+
		"\u0398\u0397\3\2\2\2\u0399\u00a7\3\2\2\2\u039a\u039f\5\u00ba^\2\u039b"+
		"\u039c\7\63\2\2\u039c\u039e\5\u00ba^\2\u039d\u039b\3\2\2\2\u039e\u03a1"+
		"\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u00a9\3\2\2\2\u03a1"+
		"\u039f\3\2\2\2\u03a2\u03a3\5z>\2\u03a3\u00ab\3\2\2\2\u03a4\u03a5\7q\2"+
		"\2\u03a5\u03a8\5\u00aeX\2\u03a6\u03a7\7\u00ad\2\2\u03a7\u03a9\5\u016a"+
		"\u00b6\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\3\2\2\2\u03aa"+
		"\u03ac\5\u00b0Y\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03b2"+
		"\3\2\2\2\u03ad\u03ae\7u\2\2\u03ae\u03af\7\u0097\2\2\u03af\u03b0\7s\2\2"+
		"\u03b0\u03b2\7r\2\2\u03b1\u03a4\3\2\2\2\u03b1\u03ad\3\2\2\2\u03b2\u00ad"+
		"\3\2\2\2\u03b3\u03b4\t\t\2\2\u03b4\u00af\3\2\2\2\u03b5\u03b6\7v\2\2\u03b6"+
		"\u03b9\7w\2\2\u03b7\u03b9\7\u00ae\2\2\u03b8\u03b5\3\2\2\2\u03b8\u03b7"+
		"\3\2\2\2\u03b9\u00b1\3\2\2\2\u03ba\u03bd\5\u00b4[\2\u03bb\u03bd\7/\2\2"+
		"\u03bc\u03ba\3\2\2\2\u03bc\u03bb\3\2\2\2\u03bd\u03c2\3\2\2\2\u03be\u03bf"+
		"\7\63\2\2\u03bf\u03c1\5\u00b4[\2\u03c0\u03be\3\2\2\2\u03c1\u03c4\3\2\2"+
		"\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u00b3\3\2\2\2\u03c4\u03c2"+
		"\3\2\2\2\u03c5\u03cb\5\u016c\u00b7\2\u03c6\u03c8\5\u00d2j\2\u03c7\u03c9"+
		"\5\u00b6\\\2\u03c8\u03c7\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03cb\3\2\2"+
		"\2\u03ca\u03c5\3\2\2\2\u03ca\u03c6\3\2\2\2\u03cb\u00b5\3\2\2\2\u03cc\u03ce"+
		"\7\u0082\2\2\u03cd\u03cc\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03d1\3\2\2"+
		"\2\u03cf\u03d2\5\u011c\u008f\2\u03d0\u03d2\5\u0136\u009c\2\u03d1\u03cf"+
		"\3\2\2\2\u03d1\u03d0\3\2\2\2\u03d2\u00b7\3\2\2\2\u03d3\u03d4\7\u00ab\2"+
		"\2\u03d4\u03d5\5\u00d2j\2\u03d5\u00b9\3\2\2\2\u03d6\u03da\5\u00c4c\2\u03d7"+
		"\u03d9\5\u00be`\2\u03d8\u03d7\3\2\2\2\u03d9\u03dc\3\2\2\2\u03da\u03d8"+
		"\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u00bb\3\2\2\2\u03dc\u03da\3\2\2\2\u03dd"+
		"\u03e1\5\u00c4c\2\u03de\u03e0\5\u00be`\2\u03df\u03de\3\2\2\2\u03e0\u03e3"+
		"\3\2\2\2\u03e1\u03df\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u00bd\3\2\2\2\u03e3"+
		"\u03e1\3\2\2\2\u03e4\u03e5\5\u00c0a\2\u03e5\u03ea\5\u00ba^\2\u03e6\u03e7"+
		"\7\u00a1\2\2\u03e7\u03eb\5\u00d2j\2\u03e8\u03e9\7\u00aa\2\2\u03e9\u03eb"+
		"\5\u0120\u0091\2\u03ea\u03e6\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea\u03eb\3"+
		"\2\2\2\u03eb\u03f5\3\2\2\2\u03ec\u03ed\5\u00c2b\2\u03ed\u03f2\5\u00ba"+
		"^\2\u03ee\u03ef\7\u00a1\2\2\u03ef\u03f3\5\u00d2j\2\u03f0\u03f1\7\u00aa"+
		"\2\2\u03f1\u03f3\5\u0120\u0091\2\u03f2\u03ee\3\2\2\2\u03f2\u03f0\3\2\2"+
		"\2\u03f3\u03f5\3\2\2\2\u03f4\u03e4\3\2\2\2\u03f4\u03ec\3\2\2\2\u03f5\u00bf"+
		"\3\2\2\2\u03f6\u03f8\t\n\2\2\u03f7\u03f6\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8"+
		"\u03f9\3\2\2\2\u03f9\u03fa\7z\2\2\u03fa\u00c1\3\2\2\2\u03fb\u03fd\t\13"+
		"\2\2\u03fc\u03fe\7\u00a3\2\2\u03fd\u03fc\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe"+
		"\u03ff\3\2\2\2\u03ff\u0400\7z\2\2\u0400\u00c3\3\2\2\2\u0401\u0406\5\u00c6"+
		"d\2\u0402\u0406\5\u00c8e\2\u0403\u0406\5\u00caf\2\u0404\u0406\5\u00cc"+
		"g\2\u0405\u0401\3\2\2\2\u0405\u0402\3\2\2\2\u0405\u0403\3\2\2\2\u0405"+
		"\u0404\3\2\2\2\u0406\u00c5\3\2\2\2\u0407\u0409\5\u016e\u00b8\2\u0408\u040a"+
		"\5\u00d0i\2\u0409\u0408\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u00c7\3\2\2"+
		"\2\u040b\u040e\7\66\2\2\u040c\u040f\5\u00c6d\2\u040d\u040f\5\u00c8e\2"+
		"\u040e\u040c\3\2\2\2\u040e\u040d\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0411"+
		"\7\67\2\2\u0411\u00c9\3\2\2\2\u0412\u0414\5x=\2\u0413\u0415\5\u00d0i\2"+
		"\u0414\u0413\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u0417\3\2\2\2\u0416\u0418"+
		"\5\u0164\u00b3\2\u0417\u0416\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u0422\3"+
		"\2\2\2\u0419\u041a\7}\2\2\u041a\u041c\5x=\2\u041b\u041d\5\u00d0i\2\u041c"+
		"\u041b\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u041f\3\2\2\2\u041e\u0420\5\u0164"+
		"\u00b3\2\u041f\u041e\3\2\2\2\u041f\u0420\3\2\2\2\u0420\u0422\3\2\2\2\u0421"+
		"\u0412\3\2\2\2\u0421\u0419\3\2\2\2\u0422\u00cb\3\2\2\2\u0423\u0426\7\66"+
		"\2\2\u0424\u0427\5\u00a8U\2\u0425\u0427\5\u00ccg\2\u0426\u0424\3\2\2\2"+
		"\u0426\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\7\67\2\2\u0429\u00cd"+
		"\3\2\2\2\u042a\u042b\t\5\2\2\u042b\u00cf\3\2\2\2\u042c\u042e\7\u0082\2"+
		"\2\u042d\u042c\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u042f\3\2\2\2\u042f\u0430"+
		"\5\u011c\u008f\2\u0430\u00d1\3\2\2\2\u0431\u0432\bj\1\2\u0432\u0438\5"+
		"\u00d4k\2\u0433\u0435\7\u0098\2\2\u0434\u0436\5\u0108\u0085\2\u0435\u0434"+
		"\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0437\3\2\2\2\u0437\u0439\t\f\2\2\u0438"+
		"\u0433\3\2\2\2\u0438\u0439\3\2\2\2\u0439\u043d\3\2\2\2\u043a\u043b\7J"+
		"\2\2\u043b\u043d\5\u00d2j\5\u043c\u0431\3\2\2\2\u043c\u043a\3\2\2\2\u043d"+
		"\u0446\3\2\2\2\u043e\u043f\f\4\2\2\u043f\u0440\7H\2\2\u0440\u0445\5\u00d2"+
		"j\5\u0441\u0442\f\3\2\2\u0442\u0443\7I\2\2\u0443\u0445\5\u00d2j\4\u0444"+
		"\u043e\3\2\2\2\u0444\u0441\3\2\2\2\u0445\u0448\3\2\2\2\u0446\u0444\3\2"+
		"\2\2\u0446\u0447\3\2\2\2\u0447\u00d3\3\2\2\2\u0448\u0446\3\2\2\2\u0449"+
		"\u044a\bk\1\2\u044a\u044b\5\u00d8m\2\u044b\u045d\3\2\2\2\u044c\u044d\f"+
		"\5\2\2\u044d\u044f\7\u0098\2\2\u044e\u0450\5\u0108\u0085\2\u044f\u044e"+
		"\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0451\3\2\2\2\u0451\u045c\7\u009f\2"+
		"\2\u0452\u0453\f\4\2\2\u0453\u0454\5\u00d6l\2\u0454\u0455\5\u00d8m\2\u0455"+
		"\u045c\3\2\2\2\u0456\u0457\f\3\2\2\u0457\u0458\5\u00d6l\2\u0458\u0459"+
		"\t\r\2\2\u0459\u045a\5x=\2\u045a\u045c\3\2\2\2\u045b\u044c\3\2\2\2\u045b"+
		"\u0452\3\2\2\2\u045b\u0456\3\2\2\2\u045c\u045f\3\2\2\2\u045d\u045b\3\2"+
		"\2\2\u045d\u045e\3\2\2\2\u045e\u00d5\3\2\2\2\u045f\u045d\3\2\2\2\u0460"+
		"\u0461\t\16\2\2\u0461\u00d7\3\2\2\2\u0462\u0467\5\u00dco\2\u0463\u0465"+
		"\5\u0108\u0085\2\u0464\u0463\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0466\3"+
		"\2\2\2\u0466\u0468\5\u00dan\2\u0467\u0464\3\2\2\2\u0467\u0468\3\2\2\2"+
		"\u0468\u00d9\3\2\2\2\u0469\u046f\7\u0097\2\2\u046a\u0470\5x=\2\u046b\u046c"+
		"\7\66\2\2\u046c\u046d\5\u0106\u0084\2\u046d\u046e\7\67\2\2\u046e\u0470"+
		"\3\2\2\2\u046f\u046a\3\2\2\2\u046f\u046b\3\2\2\2\u0470\u047d\3\2\2\2\u0471"+
		"\u0472\7\u0085\2\2\u0472\u0473\5\u00dco\2\u0473\u0474\7H\2\2\u0474\u0475"+
		"\5\u00d8m\2\u0475\u047d\3\2\2\2\u0476\u0477\7\u009b\2\2\u0477\u047a\5"+
		"\u00dep\2\u0478\u0479\7\u008d\2\2\u0479\u047b\5\u00dep\2\u047a\u0478\3"+
		"\2\2\2\u047a\u047b\3\2\2\2\u047b\u047d\3\2\2\2\u047c\u0469\3\2\2\2\u047c"+
		"\u0471\3\2\2\2\u047c\u0476\3\2\2\2\u047d\u00db\3\2\2\2\u047e\u047f\bo"+
		"\1\2\u047f\u0480\5\u00dep\2\u0480\u0489\3\2\2\2\u0481\u0482\f\4\2\2\u0482"+
		"\u0483\t\17\2\2\u0483\u0488\5\u00dco\5\u0484\u0485\f\3\2\2\u0485\u0486"+
		"\t\20\2\2\u0486\u0488\5\u00dco\4\u0487\u0481\3\2\2\2\u0487\u0484\3\2\2"+
		"\2\u0488\u048b\3\2\2\2\u0489\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u00dd"+
		"\3\2\2\2\u048b\u0489\3\2\2\2\u048c\u048d\bp\1\2\u048d\u04c2\5\u0166\u00b4"+
		"\2\u048e\u04c2\5\u00f0y\2\u048f\u04c2\5\u00f8}\2\u0490\u04c2\5\u0130\u0099"+
		"\2\u0491\u04c2\7<\2\2\u0492\u04c2\5\u00e0q\2\u0493\u04c2\5\u00e2r\2\u0494"+
		"\u04c2\5\u00e4s\2\u0495\u0496\t\20\2\2\u0496\u04c2\5\u00dep\t\u0497\u0498"+
		"\5\u010a\u0086\2\u0498\u0499\5\u00dep\b\u0499\u04c2\3\2\2\2\u049a\u049c"+
		"\7`\2\2\u049b\u049a\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049d\3\2\2\2\u049d"+
		"\u049e\7\66\2\2\u049e\u049f\5\u0106\u0084\2\u049f\u04a0\7\67\2\2\u04a0"+
		"\u04c2\3\2\2\2\u04a1\u04a3\7\u008e\2\2\u04a2\u04a1\3\2\2\2\u04a2\u04a3"+
		"\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04c2\5x=\2\u04a5\u04a6\78\2\2\u04a6"+
		"\u04a7\5\u011c\u008f\2\u04a7\u04a8\5\u00d2j\2\u04a8\u04a9\79\2\2\u04a9"+
		"\u04c2\3\2\2\2\u04aa\u04ab\7\u0087\2\2\u04ab\u04ac\7\66\2\2\u04ac\u04ad"+
		"\5\u00d2j\2\u04ad\u04ae\7\u0082\2\2\u04ae\u04af\5\u0104\u0083\2\u04af"+
		"\u04b0\7\67\2\2\u04b0\u04c2\3\2\2\2\u04b1\u04b3\7\u0086\2\2\u04b2\u04b4"+
		"\5\u00d2j\2\u04b3\u04b2\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b8\3\2\2"+
		"\2\u04b5\u04b6\5\u00fe\u0080\2\u04b6\u04b7\5\u0100\u0081\2\u04b7\u04b9"+
		"\3\2\2\2\u04b8\u04b5\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04b8\3\2\2\2\u04ba"+
		"\u04bb\3\2\2\2\u04bb\u04bd\3\2\2\2\u04bc\u04be\5\u0102\u0082\2\u04bd\u04bc"+
		"\3\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c0\7\u008c\2"+
		"\2\u04c0\u04c2\3\2\2\2\u04c1\u048c\3\2\2\2\u04c1\u048e\3\2\2\2\u04c1\u048f"+
		"\3\2\2\2\u04c1\u0490\3\2\2\2\u04c1\u0491\3\2\2\2\u04c1\u0492\3\2\2\2\u04c1"+
		"\u0493\3\2\2\2\u04c1\u0494\3\2\2\2\u04c1\u0495\3\2\2\2\u04c1\u0497\3\2"+
		"\2\2\u04c1\u049b\3\2\2\2\u04c1\u04a2\3\2\2\2\u04c1\u04a5\3\2\2\2\u04c1"+
		"\u04aa\3\2\2\2\u04c1\u04b1\3\2\2\2\u04c2\u04c8\3\2\2\2\u04c3\u04c4\f\n"+
		"\2\2\u04c4\u04c5\7\4\2\2\u04c5\u04c7\5\u00dep\13\u04c6\u04c3\3\2\2\2\u04c7"+
		"\u04ca\3\2\2\2\u04c8\u04c6\3\2\2\2\u04c8\u04c9\3\2\2\2\u04c9\u00df\3\2"+
		"\2\2\u04ca\u04c8\3\2\2\2\u04cb\u04cc\7f\2\2\u04cc\u04ce\7\66\2\2\u04cd"+
		"\u04cf\7h\2\2\u04ce\u04cd\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\3\2"+
		"\2\2\u04d0\u04d1\5\u00eav\2\u04d1\u04d3\7\67\2\2\u04d2\u04d4\5\u00e6t"+
		"\2\u04d3\u04d2\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u052c\3\2\2\2\u04d5\u04d6"+
		"\7g\2\2\u04d6\u04d8\7\66\2\2\u04d7\u04d9\7L\2\2\u04d8\u04d7\3\2\2\2\u04d8"+
		"\u04d9\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\7/\2\2\u04db\u04dd\7\67"+
		"\2\2\u04dc\u04de\5\u00e6t\2\u04dd\u04dc\3\2\2\2\u04dd\u04de\3\2\2\2\u04de"+
		"\u052c\3\2\2\2\u04df\u04e0\7g\2\2\u04e0\u04e8\7\66\2\2\u04e1\u04e3\7L"+
		"\2\2\u04e2\u04e1\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4"+
		"\u04e9\7/\2\2\u04e5\u04e9\5\u00eav\2\u04e6\u04e7\7h\2\2\u04e7\u04e9\5"+
		"\u0106\u0084\2\u04e8\u04e2\3\2\2\2\u04e8\u04e5\3\2\2\2\u04e8\u04e6\3\2"+
		"\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04ec\7\67\2\2\u04eb\u04ed\5\u00e6t\2\u04ec"+
		"\u04eb\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u052c\3\2\2\2\u04ee\u04ef\7k"+
		"\2\2\u04ef\u04f1\7\66\2\2\u04f0\u04f2\7h\2\2\u04f1\u04f0\3\2\2\2\u04f1"+
		"\u04f2\3\2\2\2\u04f2\u04f3\3\2\2\2\u04f3\u04f4\5\u00eav\2\u04f4\u04f6"+
		"\7\67\2\2\u04f5\u04f7\5\u00e6t\2\u04f6\u04f5\3\2\2\2\u04f6\u04f7\3\2\2"+
		"\2\u04f7\u052c\3\2\2\2\u04f8\u04f9\7j\2\2\u04f9\u04fb\7\66\2\2\u04fa\u04fc"+
		"\7h\2\2\u04fb\u04fa\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd"+
		"\u04fe\5\u00eav\2\u04fe\u0500\7\67\2\2\u04ff\u0501\5\u00e6t\2\u0500\u04ff"+
		"\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u052c\3\2\2\2\u0502\u0503\7l\2\2\u0503"+
		"\u0504\7\66\2\2\u0504\u0505\5\u00eav\2\u0505\u0507\7\67\2\2\u0506\u0508"+
		"\5\u00e6t\2\u0507\u0506\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u052c\3\2\2"+
		"\2\u0509\u050a\7n\2\2\u050a\u050b\7\66\2\2\u050b\u050c\5\u00eav\2\u050c"+
		"\u050e\7\67\2\2\u050d\u050f\5\u00e6t\2\u050e\u050d\3\2\2\2\u050e\u050f"+
		"\3\2\2\2\u050f\u052c\3\2\2\2\u0510\u0511\7i\2\2\u0511\u0513\7\66\2\2\u0512"+
		"\u0514\7h\2\2\u0513\u0512\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0515\3\2"+
		"\2\2\u0515\u0516\5\u00eav\2\u0516\u0518\7\67\2\2\u0517\u0519\5\u00e6t"+
		"\2\u0518\u0517\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u052c\3\2\2\2\u051a\u051b"+
		"\7o\2\2\u051b\u051d\7\66\2\2\u051c\u051e\7h\2\2\u051d\u051c\3\2\2\2\u051d"+
		"\u051e\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0521\5\u0106\u0084\2\u0520\u0522"+
		"\5\u00a2R\2\u0521\u0520\3\2\2\2\u0521\u0522\3\2\2\2\u0522\u0525\3\2\2"+
		"\2\u0523\u0524\7p\2\2\u0524\u0526\5\u0138\u009d\2\u0525\u0523\3\2\2\2"+
		"\u0525\u0526\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0529\7\67\2\2\u0528\u052a"+
		"\5\u00e6t\2\u0529\u0528\3\2\2\2\u0529\u052a\3\2\2\2\u052a\u052c\3\2\2"+
		"\2\u052b\u04cb\3\2\2\2\u052b\u04d5\3\2\2\2\u052b\u04df\3\2\2\2\u052b\u04ee"+
		"\3\2\2\2\u052b\u04f8\3\2\2\2\u052b\u0502\3\2\2\2\u052b\u0509\3\2\2\2\u052b"+
		"\u0510\3\2\2\2\u052b\u051a\3\2\2\2\u052c\u00e1\3\2\2\2\u052d\u052e\7\u00af"+
		"\2\2\u052e\u052f\7\66\2\2\u052f\u0530\5\u0106\u0084\2\u0530\u0531\7\67"+
		"\2\2\u0531\u00e3\3\2\2\2\u0532\u0533\t\21\2\2\u0533\u0534\5\u0154\u00ab"+
		"\2\u0534\u0535\5\u00e6t\2\u0535\u0548\3\2\2\2\u0536\u0537\7W\2\2\u0537"+
		"\u0538\5\u0110\u0089\2\u0538\u0539\5\u00e6t\2\u0539\u0548\3\2\2\2\u053a"+
		"\u053b\t\22\2\2\u053b\u053c\7\66\2\2\u053c\u053e\5\u00d2j\2\u053d\u053f"+
		"\5\u00e8u\2\u053e\u053d\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0540\3\2\2"+
		"\2\u0540\u0541\7\67\2\2\u0541\u0542\5\u00e6t\2\u0542\u0548\3\2\2\2\u0543"+
		"\u0544\t\23\2\2\u0544\u0545\5\u010e\u0088\2\u0545\u0546\5\u00e6t\2\u0546"+
		"\u0548\3\2\2\2\u0547\u0532\3\2\2\2\u0547\u0536\3\2\2\2\u0547\u053a\3\2"+
		"\2\2\u0547\u0543\3\2\2\2\u0548\u00e5\3\2\2\2\u0549\u054c\7Y\2\2\u054a"+
		"\u054d\5\u015c\u00af\2\u054b\u054d\5\u008aF\2\u054c\u054a\3\2\2\2\u054c"+
		"\u054b\3\2\2\2\u054d\u00e7\3\2\2\2\u054e\u0551\7\63\2\2\u054f\u0552\5"+
		"\u012c\u0097\2\u0550\u0552\7<\2\2\u0551\u054f\3\2\2\2\u0551\u0550\3\2"+
		"\2\2\u0552\u0555\3\2\2\2\u0553\u0554\7\63\2\2\u0554\u0556\5\u00d2j\2\u0555"+
		"\u0553\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u00e9\3\2\2\2\u0557\u0559\7L"+
		"\2\2\u0558\u0557\3\2\2\2\u0558\u0559\3\2\2\2\u0559\u055a\3\2\2\2\u055a"+
		"\u055b\5\u00d2j\2\u055b\u00eb\3\2\2\2\u055c\u0562\5\u00eex\2\u055d\u055e"+
		"\7\66\2\2\u055e\u055f\5\u00eex\2\u055f\u0560\7\67\2\2\u0560\u0562\3\2"+
		"\2\2\u0561\u055c\3\2\2\2\u0561\u055d\3\2\2\2\u0562\u00ed\3\2\2\2\u0563"+
		"\u0568\5\u0124\u0093\2\u0564\u0565\7\63\2\2\u0565\u0567\5\u0124\u0093"+
		"\2\u0566\u0564\3\2\2\2\u0567\u056a\3\2\2\2\u0568\u0566\3\2\2\2\u0568\u0569"+
		"\3\2\2\2\u0569\u00ef\3\2\2\2\u056a\u0568\3\2\2\2\u056b\u056d\7M\2\2\u056c"+
		"\u056e\5\u0154\u00ab\2\u056d\u056c\3\2\2\2\u056d\u056e\3\2\2\2\u056e\u0590"+
		"\3\2\2\2\u056f\u0570\7^\2\2\u0570\u0571\7\66\2\2\u0571\u0574\5\u00d2j"+
		"\2\u0572\u0573\7\63\2\2\u0573\u0575\5\u00d2j\2\u0574\u0572\3\2\2\2\u0575"+
		"\u0576\3\2\2\2\u0576\u0574\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0578\3\2"+
		"\2\2\u0578\u0579\7\67\2\2\u0579\u0590\3\2\2\2\u057a\u057b\7{\2\2\u057b"+
		"\u057c\7\66\2\2\u057c\u057d\5\u00d2j\2\u057d\u057e\7\63\2\2\u057e\u057f"+
		"\5\u00d2j\2\u057f\u0580\7\67\2\2\u0580\u0590\3\2\2\2\u0581\u0582\7|\2"+
		"\2\u0582\u0583\7\66\2\2\u0583\u0584\5\u00d2j\2\u0584\u0585\7\63\2\2\u0585"+
		"\u0586\5\u00d2j\2\u0586\u0587\7\67\2\2\u0587\u0590\3\2\2\2\u0588\u058a"+
		"\7\u009d\2\2\u0589\u058b\5\u00f2z\2\u058a\u0589\3\2\2\2\u058a\u058b\3"+
		"\2\2\2\u058b\u0590\3\2\2\2\u058c\u0590\5\u00f6|\2\u058d\u058e\7D\2\2\u058e"+
		"\u0590\5\u010e\u0088\2\u058f\u056b\3\2\2\2\u058f\u056f\3\2\2\2\u058f\u057a"+
		"\3\2\2\2\u058f\u0581\3\2\2\2\u058f\u0588\3\2\2\2\u058f\u058c\3\2\2\2\u058f"+
		"\u058d\3\2\2\2\u0590\u00f1\3\2\2\2\u0591\u0593\7\66\2\2\u0592\u0594\5"+
		"\u00f4{\2\u0593\u0592\3\2\2\2\u0593\u0594\3\2\2\2\u0594\u0595\3\2\2\2"+
		"\u0595\u0596\7\67\2\2\u0596\u00f3\3\2\2\2\u0597\u0598\7?\2\2\u0598\u00f5"+
		"\3\2\2\2\u0599\u059a\7G\2\2\u059a\u059b\7\66\2\2\u059b\u05a8\5\u00d2j"+
		"\2\u059c\u059d\7\63\2\2\u059d\u05a0\5\u00d2j\2\u059e\u059f\7\63\2\2\u059f"+
		"\u05a1\5\u00d2j\2\u05a0\u059e\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1\u05a9"+
		"\3\2\2\2\u05a2\u05a3\7\u0091\2\2\u05a3\u05a6\5\u00d2j\2\u05a4\u05a5\7"+
		"q\2\2\u05a5\u05a7\5\u00d2j\2\u05a6\u05a4\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7"+
		"\u05a9\3\2\2\2\u05a8\u059c\3\2\2\2\u05a8\u05a2\3\2\2\2\u05a9\u05aa\3\2"+
		"\2\2\u05aa\u05ab\7\67\2\2\u05ab\u00f7\3\2\2\2\u05ac\u05ad\5\u011a\u008e"+
		"\2\u05ad\u05af\7\66\2\2\u05ae\u05b0\5\u00fa~\2\u05af\u05ae\3\2\2\2\u05af"+
		"\u05b0\3\2\2\2\u05b0\u05b1\3\2\2\2\u05b1\u05b2\7\67\2\2\u05b2\u05bb\3"+
		"\2\2\2\u05b3\u05b4\5\u0122\u0092\2\u05b4\u05b6\7\66\2\2\u05b5\u05b7\5"+
		"\u0106\u0084\2\u05b6\u05b5\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b8\3\2"+
		"\2\2\u05b8\u05b9\7\67\2\2\u05b9\u05bb\3\2\2\2\u05ba\u05ac\3\2\2\2\u05ba"+
		"\u05b3\3\2\2\2\u05bb\u00f9\3\2\2\2\u05bc\u05c1\5\u00fc\177\2\u05bd\u05be"+
		"\7\63\2\2\u05be\u05c0\5\u00fc\177\2\u05bf\u05bd\3\2\2\2\u05c0\u05c3\3"+
		"\2\2\2\u05c1\u05bf\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2\u00fb\3\2\2\2\u05c3"+
		"\u05c1\3\2\2\2\u05c4\u05c6\5\u00d2j\2\u05c5\u05c7\5\u00b6\\\2\u05c6\u05c5"+
		"\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u00fd\3\2\2\2\u05c8\u05c9\7\u0080\2"+
		"\2\u05c9\u05ca\5\u00d2j\2\u05ca\u00ff\3\2\2\2\u05cb\u05cc\7\177\2\2\u05cc"+
		"\u05cd\5\u00d2j\2\u05cd\u0101\3\2\2\2\u05ce\u05cf\7~\2\2\u05cf\u05d0\5"+
		"\u00d2j\2\u05d0\u0103\3\2\2\2\u05d1\u05d7\7\u0089\2\2\u05d2\u05d4\7\u00a6"+
		"\2\2\u05d3\u05d5\5\u0172\u00ba\2\u05d4\u05d3\3\2\2\2\u05d4\u05d5\3\2\2"+
		"\2\u05d5\u05d7\3\2\2\2\u05d6\u05d1\3\2\2\2\u05d6\u05d2\3\2\2\2\u05d7\u0105"+
		"\3\2\2\2\u05d8\u05dd\5\u00d2j\2\u05d9\u05da\7\63\2\2\u05da\u05dc\5\u00d2"+
		"j\2\u05db\u05d9\3\2\2\2\u05dc\u05df\3\2\2\2\u05dd\u05db\3\2\2\2\u05dd"+
		"\u05de\3\2\2\2\u05de\u0107\3\2\2\2\u05df\u05dd\3\2\2\2\u05e0\u05e1\t\24"+
		"\2\2\u05e1\u0109\3\2\2\2\u05e2\u05e3\7\3\2\2\u05e3\u010b\3\2\2\2\u05e4"+
		"\u05e5\7\66\2\2\u05e5\u05e6\5\u0106\u0084\2\u05e6\u05e7\7\67\2\2\u05e7"+
		"\u010d\3\2\2\2\u05e8\u05e9\7\66\2\2\u05e9\u05ea\5\u00d2j\2\u05ea\u05eb"+
		"\7\67\2\2\u05eb\u010f\3\2\2\2\u05ec\u05ed\7\66\2\2\u05ed\u05ee\5\u00de"+
		"p\2\u05ee\u05ef\7\67\2\2\u05ef\u0111\3\2\2\2\u05f0\u05f5\5\u0114\u008b"+
		"\2\u05f1\u05f2\7\63\2\2\u05f2\u05f4\5\u0114\u008b\2\u05f3\u05f1\3\2\2"+
		"\2\u05f4\u05f7\3\2\2\2\u05f5\u05f3\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u0113"+
		"\3\2\2\2\u05f7\u05f5\3\2\2\2\u05f8\u05fa\5\u00d2j\2\u05f9\u05fb\5\u00a4"+
		"S\2\u05fa\u05f9\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u0115\3\2\2\2\u05fc"+
		"\u0601\5\u0118\u008d\2\u05fd\u05fe\7\63\2\2\u05fe\u0600\5\u0118\u008d"+
		"\2\u05ff\u05fd\3\2\2\2\u0600\u0603\3\2\2\2\u0601\u05ff\3\2\2\2\u0601\u0602"+
		"\3\2\2\2\u0602\u0117\3\2\2\2\u0603\u0601\3\2\2\2\u0604\u0605\5\u00d2j"+
		"\2\u0605\u0119\3\2\2\2\u0606\u060a\7\u00b2\2\2\u0607\u0609\7B\2\2\u0608"+
		"\u0607\3\2\2\2\u0609\u060c\3\2\2\2\u060a\u0608\3\2\2\2\u060a\u060b\3\2"+
		"\2\2\u060b\u060f\3\2\2\2\u060c\u060a\3\2\2\2\u060d\u060f\7\u00b4\2\2\u060e"+
		"\u0606\3\2\2\2\u060e\u060d\3\2\2\2\u060f\u011b\3\2\2\2\u0610\u0613\5\u011a"+
		"\u008e\2\u0611\u0613\5\u0158\u00ad\2\u0612\u0610\3\2\2\2\u0612\u0611\3"+
		"\2\2\2\u0613\u011d\3\2\2\2\u0614\u0619\5\u011c\u008f\2\u0615\u0616\7\63"+
		"\2\2\u0616\u0618\5\u011c\u008f\2\u0617\u0615\3\2\2\2\u0618\u061b\3\2\2"+
		"\2\u0619\u0617\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u011f\3\2\2\2\u061b\u0619"+
		"\3\2\2\2\u061c\u061d\7\66\2\2\u061d\u061e\5\u011e\u0090\2\u061e\u061f"+
		"\7\67\2\2\u061f\u0121\3\2\2\2\u0620\u0622\5\u011c\u008f\2\u0621\u0623"+
		"\5\u0126\u0094\2\u0622\u0621\3\2\2\2\u0622\u0623\3\2\2\2\u0623\u0123\3"+
		"\2\2\2\u0624\u0629\5\u011c\u008f\2\u0625\u0627\5\u0126\u0094\2\u0626\u0628"+
		"\5\u0126\u0094\2\u0627\u0626\3\2\2\2\u0627\u0628\3\2\2\2\u0628\u062a\3"+
		"\2\2\2\u0629\u0625\3\2\2\2\u0629\u062a\3\2\2\2\u062a\u0125\3\2\2\2\u062b"+
		"\u062c\7\62\2\2\u062c\u062d\5\u011c\u008f\2\u062d\u0127\3\2\2\2\u062e"+
		"\u062f\t\25\2\2\u062f\u0129\3\2\2\2\u0630\u0631\t\26\2\2\u0631\u012b\3"+
		"\2\2\2\u0632\u0633\t\27\2\2\u0633\u012d\3\2\2\2\u0634\u0635\t\26\2\2\u0635"+
		"\u012f\3\2\2\2\u0636\u063d\5\u013c\u009f\2\u0637\u063d\5\u0142\u00a2\2"+
		"\u0638\u063d\5\u0148\u00a5\2\u0639\u063d\5\u0146\u00a4\2\u063a\u063d\5"+
		"\u0144\u00a3\2\u063b\u063d\t\30\2\2\u063c\u0636\3\2\2\2\u063c\u0637\3"+
		"\2\2\2\u063c\u0638\3\2\2\2\u063c\u0639\3\2\2\2\u063c\u063a\3\2\2\2\u063c"+
		"\u063b\3\2\2\2\u063d\u0131\3\2\2\2\u063e\u0644\5\u0130\u0099\2\u063f\u0640"+
		"\7-\2\2\u0640\u0644\5\u0128\u0095\2\u0641\u0642\7.\2\2\u0642\u0644\5\u0128"+
		"\u0095\2\u0643\u063e\3\2\2\2\u0643\u063f\3\2\2\2\u0643\u0641\3\2\2\2\u0644"+
		"\u0133\3\2\2\2\u0645\u0646\7\66\2\2\u0646\u064b\5\u0138\u009d\2\u0647"+
		"\u0648\7\63\2\2\u0648\u064a\5\u0138\u009d\2\u0649\u0647\3\2\2\2\u064a"+
		"\u064d\3\2\2\2\u064b\u0649\3\2\2\2\u064b\u064c\3\2\2\2\u064c\u064e\3\2"+
		"\2\2\u064d\u064b\3\2\2\2\u064e\u064f\7\67\2\2\u064f\u0135\3\2\2\2\u0650"+
		"\u0653\7\u00b5\2\2\u0651\u0653\7\u00b4\2\2\u0652\u0650\3\2\2\2\u0652\u0651"+
		"\3\2\2\2\u0653\u0137\3\2\2\2\u0654\u0658\5\u0136\u009c\2\u0655\u0658\7"+
		"=\2\2\u0656\u0658\7>\2\2\u0657\u0654\3\2\2\2\u0657\u0655\3\2\2\2\u0657"+
		"\u0656\3\2\2\2\u0658\u0139\3\2\2\2\u0659\u065c\5\u0136\u009c\2\u065a\u065c"+
		"\7=\2\2\u065b\u0659\3\2\2\2\u065b\u065a\3\2\2\2\u065c\u013b\3\2\2\2\u065d"+
		"\u0660\5\u0136\u009c\2\u065e\u0660\7\u00b3\2\2\u065f\u065d\3\2\2\2\u065f"+
		"\u065e\3\2\2\2\u0660\u0664\3\2\2\2\u0661\u0663\5\u0136\u009c\2\u0662\u0661"+
		"\3\2\2\2\u0663\u0666\3\2\2\2\u0664\u0662\3\2\2\2\u0664\u0665\3\2\2\2\u0665"+
		"\u013d\3\2\2\2\u0666\u0664\3\2\2\2\u0667\u0668\5\u0136\u009c\2\u0668\u013f"+
		"\3\2\2\2\u0669\u066e\5\u0136\u009c\2\u066a\u066b\7\63\2\2\u066b\u066d"+
		"\5\u0136\u009c\2\u066c\u066a\3\2\2\2\u066d\u0670\3\2\2\2\u066e\u066c\3"+
		"\2\2\2\u066e\u066f\3\2\2\2\u066f\u0141\3\2\2\2\u0670\u066e\3\2\2\2\u0671"+
		"\u0672\t\27\2\2\u0672\u0143\3\2\2\2\u0673\u0674\t\31\2\2\u0674\u0145\3"+
		"\2\2\2\u0675\u0676\t\32\2\2\u0676\u0147\3\2\2\2\u0677\u0678\7\u0089\2"+
		"\2\u0678\u067e\7\u00b5\2\2\u0679\u067a\7\u00a6\2\2\u067a\u067e\7\u00b5"+
		"\2\2\u067b\u067c\7\u00a5\2\2\u067c\u067e\7\u00b5\2\2\u067d\u0677\3\2\2"+
		"\2\u067d\u0679\3\2\2\2\u067d\u067b\3\2\2\2\u067e\u0149\3\2\2\2\u067f\u0682"+
		"\5\u0170\u00b9\2\u0680\u0682\5\u014e\u00a8\2\u0681\u067f\3\2\2\2\u0681"+
		"\u0680\3\2\2\2\u0682\u014b\3\2\2\2\u0683\u0684\5\u014e\u00a8\2\u0684\u014d"+
		"\3\2\2\2\u0685\u0686\7\66\2\2\u0686\u0687\7?\2\2\u0687\u0688\7\63\2\2"+
		"\u0688\u0689\7?\2\2\u0689\u068a\7\67\2\2\u068a\u014f\3\2\2\2\u068b\u068e"+
		"\7\u00b5\2\2\u068c\u068e\5\u011c\u008f\2\u068d\u068b\3\2\2\2\u068d\u068c"+
		"\3\2\2\2\u068e\u0151\3\2\2\2\u068f\u0692\5\u012e\u0098\2\u0690\u0692\5"+
		"\u011a\u008e\2\u0691\u068f\3\2\2\2\u0691\u0690\3\2\2\2\u0692\u0153\3\2"+
		"\2\2\u0693\u0694\7\66\2\2\u0694\u0695\7\67\2\2\u0695\u0155\3\2\2\2\u0696"+
		"\u0697\t\33\2\2\u0697\u0157\3\2\2\2\u0698\u0699\5\u015a\u00ae\2\u0699"+
		"\u0159\3\2\2\2\u069a\u069b\t\34\2\2\u069b\u015b\3\2\2\2\u069c\u069d\5"+
		"\u011c\u008f\2\u069d\u015d\3\2\2\2\u069e\u06a4\5\u0126\u0094\2\u069f\u06a1"+
		"\5\u0122\u0092\2\u06a0\u06a2\5\u0126\u0094\2\u06a1\u06a0\3\2\2\2\u06a1"+
		"\u06a2\3\2\2\2\u06a2\u06a4\3\2\2\2\u06a3\u069e\3\2\2\2\u06a3\u069f\3\2"+
		"\2\2\u06a4\u015f\3\2\2\2\u06a5\u06a6\5\u011c\u008f\2\u06a6\u0161\3\2\2"+
		"\2\u06a7\u06a8\5\u011c\u008f\2\u06a8\u0163\3\2\2\2\u06a9\u06aa\7\66\2"+
		"\2\u06aa\u06af\5\u0162\u00b2\2\u06ab\u06ac\7\63\2\2\u06ac\u06ae\5\u0162"+
		"\u00b2\2\u06ad\u06ab\3\2\2\2\u06ae\u06b1\3\2\2\2\u06af\u06ad\3\2\2\2\u06af"+
		"\u06b0\3\2\2\2\u06b0\u06b2\3\2\2\2\u06b1\u06af\3\2\2\2\u06b2\u06b3\7\67"+
		"\2\2\u06b3\u0165\3\2\2\2\u06b4\u06b5\5\u015e\u00b0\2\u06b5\u0167\3\2\2"+
		"\2\u06b6\u06be\5\u011c\u008f\2\u06b7\u06b8\7\62\2\2\u06b8\u06bf\7/\2\2"+
		"\u06b9\u06bc\5\u0126\u0094\2\u06ba\u06bb\7\62\2\2\u06bb\u06bd\7/\2\2\u06bc"+
		"\u06ba\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd\u06bf\3\2\2\2\u06be\u06b7\3\2"+
		"\2\2\u06be\u06b9\3\2\2\2\u06be\u06bf\3\2\2\2\u06bf\u0169\3\2\2\2\u06c0"+
		"\u06c5\5\u0168\u00b5\2\u06c1\u06c2\7\63\2\2\u06c2\u06c4\5\u0168\u00b5"+
		"\2\u06c3\u06c1\3\2\2\2\u06c4\u06c7\3\2\2\2\u06c5\u06c3\3\2\2\2\u06c5\u06c6"+
		"\3\2\2\2\u06c6\u016b\3\2\2\2\u06c7\u06c5\3\2\2\2\u06c8\u06c9\5\u011c\u008f"+
		"\2\u06c9\u06cd\7\62\2\2\u06ca\u06cb\5\u011c\u008f\2\u06cb\u06cc\7\62\2"+
		"\2\u06cc\u06ce\3\2\2\2\u06cd\u06ca\3\2\2\2\u06cd\u06ce\3\2\2\2\u06ce\u06cf"+
		"\3\2\2\2\u06cf\u06d0\7/\2\2\u06d0\u016d\3\2\2\2\u06d1\u06d4\5\u0122\u0092"+
		"\2\u06d2\u06d4\5\u0126\u0094\2\u06d3\u06d1\3\2\2\2\u06d3\u06d2\3\2\2\2"+
		"\u06d4\u016f\3\2\2\2\u06d5\u06d8\7\66\2\2\u06d6\u06d9\5\u012e\u0098\2"+
		"\u06d7\u06d9\7@\2\2\u06d8\u06d6\3\2\2\2\u06d8\u06d7\3\2\2\2\u06d9\u06da"+
		"\3\2\2\2\u06da\u06db\7\67\2\2\u06db\u0171\3\2\2\2\u06dc\u06dd\7\66\2\2"+
		"\u06dd\u06de\7?\2\2\u06de\u06df\7\67\2\2\u06df\u0173\3\2\2\2\u00cd\u0175"+
		"\u017d\u017f\u0187\u0192\u0194\u019b\u01a4\u01ac\u01b6\u01c1\u01da\u01dd"+
		"\u01e5\u01e9\u01f0\u01f4\u01fe\u0200\u0204\u0207\u020e\u0210\u0214\u0217"+
		"\u0220\u0228\u0238\u0242\u024d\u024f\u0263\u026d\u0276\u027b\u0287\u0292"+
		"\u0295\u02a0\u02bf\u02c2\u02c6\u02c9\u02ce\u02d1\u02d3\u02d6\u02db\u02dd"+
		"\u02e4\u02e8\u02ea\u02ef\u02f3\u02f7\u02fd\u0305\u030a\u030d\u0310\u0313"+
		"\u0322\u0326\u0331\u033d\u0342\u0345\u0348\u034d\u0353\u035e\u036d\u0376"+
		"\u037a\u0381\u0386\u0398\u039f\u03a8\u03ab\u03b1\u03b8\u03bc\u03c2\u03c8"+
		"\u03ca\u03cd\u03d1\u03da\u03e1\u03ea\u03f2\u03f4\u03f7\u03fd\u0405\u0409"+
		"\u040e\u0414\u0417\u041c\u041f\u0421\u0426\u042d\u0435\u0438\u043c\u0444"+
		"\u0446\u044f\u045b\u045d\u0464\u0467\u046f\u047a\u047c\u0487\u0489\u049b"+
		"\u04a2\u04b3\u04ba\u04bd\u04c1\u04c8\u04ce\u04d3\u04d8\u04dd\u04e2\u04e8"+
		"\u04ec\u04f1\u04f6\u04fb\u0500\u0507\u050e\u0513\u0518\u051d\u0521\u0525"+
		"\u0529\u052b\u053e\u0547\u054c\u0551\u0555\u0558\u0561\u0568\u056d\u0576"+
		"\u058a\u058f\u0593\u05a0\u05a6\u05a8\u05af\u05b6\u05ba\u05c1\u05c6\u05d4"+
		"\u05d6\u05dd\u05f5\u05fa\u0601\u060a\u060e\u0612\u0619\u0622\u0627\u0629"+
		"\u063c\u0643\u064b\u0652\u0657\u065b\u065f\u0664\u066e\u067d\u0681\u068d"+
		"\u0691\u06a1\u06a3\u06af\u06bc\u06be\u06c5\u06cd\u06d3\u06d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}