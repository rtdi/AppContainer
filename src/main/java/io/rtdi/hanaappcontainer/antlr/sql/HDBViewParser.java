// Generated from HDBViewParser.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.antlr.sql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HDBViewParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT2_SYMBOL=1, CONCAT_PIPES_SYMBOL=2, LONG_NUMBER=3, ULONGLONG_NUMBER=4, 
		ASSICIATION_SYMBOL=5, VIEW_SYMBOL=6, EQUAL_OPERATOR=7, ASSIGN_OPERATOR=8, 
		NULL_SAFE_EQUAL_OPERATOR=9, GREATER_OR_EQUAL_OPERATOR=10, GREATER_THAN_OPERATOR=11, 
		LESS_OR_EQUAL_OPERATOR=12, LESS_THAN_OPERATOR=13, NOT_EQUAL_OPERATOR=14, 
		PLUS_OPERATOR=15, MINUS_OPERATOR=16, MULT_OPERATOR=17, DIV_OPERATOR=18, 
		MOD_OPERATOR=19, DOT_SYMBOL=20, COMMA_SYMBOL=21, SEMICOLON_SYMBOL=22, 
		COLON_SYMBOL=23, OPEN_PAR_SYMBOL=24, CLOSE_PAR_SYMBOL=25, OPEN_CURLY_SYMBOL=26, 
		CLOSE_CURLY_SYMBOL=27, UNDERLINE_SYMBOL=28, NULL2_SYMBOL=29, PARAM_MARKER=30, 
		HEX_NUMBER=31, BIN_NUMBER=32, INT_NUMBER=33, DECIMAL_NUMBER=34, FLOAT_NUMBER=35, 
		DOT_IDENTIFIER=36, LOCATE_SYMBOL=37, ASCII_SYMBOL=38, COALESCE_SYMBOL=39, 
		SUBSTR_SYMBOL=40, SUBSTRING_SYMBOL=41, AND_SYMBOL=42, OR_SYMBOL=43, NOT_SYMBOL=44, 
		UNION_SYMBOL=45, ALL_SYMBOL=46, CURRENT_USER_SYMBOL=47, ROWS_SYMBOL=48, 
		WINDOW_SYMBOL=49, PARTITION_SYMBOL=50, BY_SYMBOL=51, DENSE_RANK_SYMBOL=52, 
		FIRST_VALUE_SYMBOL=53, LAG_SYMBOL=54, LAST_VALUE_SYMBOL=55, LEAD_SYMBOL=56, 
		NTILE_SYMBOL=57, NULLS_SYMBOL=58, OVER_SYMBOL=59, PRECEDING_SYMBOL=60, 
		RANK_SYMBOL=61, ROW_NUMBER_SYMBOL=62, UNBOUNDED_SYMBOL=63, INTERVAL_SYMBOL=64, 
		CURRENT_SYMBOL=65, ROW_SYMBOL=66, FOLLOWING_SYMBOL=67, EXCLUDE_SYMBOL=68, 
		TIES_SYMBOL=69, OTHERS_SYMBOL=70, RECURSIVE_SYMBOL=71, AVG_SYMBOL=72, 
		COUNT_SYMBOL=73, DISTINCT_SYMBOL=74, SUM_SYMBOL=75, MAX_SYMBOL=76, MIN_SYMBOL=77, 
		STD_SYMBOL=78, STDDEV_SYMBOL=79, VARIANCE_SYMBOL=80, GROUP_CONCAT_SYMBOL=81, 
		SEPARATOR_SYMBOL=82, FOR_SYMBOL=83, MODE_SYMBOL=84, SHARE_SYMBOL=85, UPDATE_SYMBOL=86, 
		LOCK_SYMBOL=87, SKIP_SYMBOL=88, LOCKED_SYMBOL=89, CROSS_SYMBOL=90, INNER_SYMBOL=91, 
		JOIN_SYMBOL=92, LEFT_SYMBOL=93, RIGHT_SYMBOL=94, LATERAL_SYMBOL=95, ELSE_SYMBOL=96, 
		THEN_SYMBOL=97, WHEN_SYMBOL=98, ANY_SYMBOL=99, AS_SYMBOL=100, ASC_SYMBOL=101, 
		AT_SYMBOL=102, BETWEEN_SYMBOL=103, CASE_SYMBOL=104, CAST_SYMBOL=105, CONTAINS_SYMBOL=106, 
		DATE_SYMBOL=107, DESC_SYMBOL=108, DUMMY_SYMBOL=109, END_SYMBOL=110, ESCAPE_SYMBOL=111, 
		EXISTS_SYMBOL=112, FALSE_SYMBOL=113, FIRST_SYMBOL=114, FROM_SYMBOL=115, 
		FULL_SYMBOL=116, FULLTEXT_SYMBOL=117, FUNCTION_SYMBOL=118, GROUP_SYMBOL=119, 
		HAVING_SYMBOL=120, IN_SYMBOL=121, IS_SYMBOL=122, KEYS_SYMBOL=123, LAST_SYMBOL=124, 
		LIKE_SYMBOL=125, LIMIT_SYMBOL=126, NOW_SYMBOL=127, NO_SYMBOL=128, NULL_SYMBOL=129, 
		OFFSET_SYMBOL=130, ON_SYMBOL=131, ORDER_SYMBOL=132, OUTER_SYMBOL=133, 
		SELECT_SYMBOL=134, TIMESTAMP_SYMBOL=135, TIME_SYMBOL=136, TO_SYMBOL=137, 
		TRUE_SYMBOL=138, UNKNOWN_SYMBOL=139, USING_SYMBOL=140, WHERE_SYMBOL=141, 
		WITH_SYMBOL=142, OF_SYMBOL=143, NOWAIT_SYMBOL=144, GROUPING_SYMBOL=145, 
		WHITESPACE=146, INVALID_INPUT=147, IDENTIFIER=148, NCHAR_TEXT=149, DOUBLE_QUOTED_TEXT=150, 
		SINGLE_QUOTED_TEXT=151, BLOCK_COMMENT=152, POUND_COMMENT=153, DASHDASH_COMMENT=154, 
		SLASHSLASH_COMMENT=155, NOT_EQUAL2_OPERATOR=156;
	public static final int
		RULE_root = 0, RULE_selectStatement = 1, RULE_queryExpression = 2, RULE_queryExpressionBody = 3, 
		RULE_queryExpressionParens = 4, RULE_querySpecification = 5, RULE_subquery = 6, 
		RULE_querySpecOption = 7, RULE_limitClause = 8, RULE_simpleLimitClause = 9, 
		RULE_limitOptions = 10, RULE_limitOption = 11, RULE_havingClause = 12, 
		RULE_windowClause = 13, RULE_windowDefinition = 14, RULE_windowSpec = 15, 
		RULE_windowSpecDetails = 16, RULE_windowFrameClause = 17, RULE_windowFrameUnits = 18, 
		RULE_windowFrameExtent = 19, RULE_windowFrameStart = 20, RULE_windowFrameBetween = 21, 
		RULE_windowFrameBound = 22, RULE_windowFrameExclusion = 23, RULE_withClause = 24, 
		RULE_commonTableExpression = 25, RULE_groupByClause = 26, RULE_orderClause = 27, 
		RULE_direction = 28, RULE_fromClause = 29, RULE_tableReferenceList = 30, 
		RULE_selectOption = 31, RULE_lockingClause = 32, RULE_lockStrengh = 33, 
		RULE_lockedRowAction = 34, RULE_selectItemList = 35, RULE_selectItem = 36, 
		RULE_selectAlias = 37, RULE_whereClause = 38, RULE_tableReference = 39, 
		RULE_escapedTableReference = 40, RULE_joinedTable = 41, RULE_innerJoinType = 42, 
		RULE_outerJoinType = 43, RULE_tableFactor = 44, RULE_singleTable = 45, 
		RULE_singleTableParens = 46, RULE_derivedTable = 47, RULE_tableReferenceListParens = 48, 
		RULE_unionOption = 49, RULE_tableAlias = 50, RULE_expr = 51, RULE_boolPri = 52, 
		RULE_compOp = 53, RULE_predicate = 54, RULE_predicateOperations = 55, 
		RULE_bitExpr = 56, RULE_simpleExpr = 57, RULE_sumExpr = 58, RULE_groupingOperation = 59, 
		RULE_windowFunctionCall = 60, RULE_windowingClause = 61, RULE_leadLagInfo = 62, 
		RULE_inSumExpr = 63, RULE_identListArg = 64, RULE_identList = 65, RULE_runtimeFunctionCall = 66, 
		RULE_timeFunctionParameters = 67, RULE_fractionalPrecision = 68, RULE_substringFunction = 69, 
		RULE_functionCall = 70, RULE_udfExprList = 71, RULE_udfExpr = 72, RULE_whenExpression = 73, 
		RULE_thenExpression = 74, RULE_elseExpression = 75, RULE_castType = 76, 
		RULE_exprList = 77, RULE_notRule = 78, RULE_not2Rule = 79, RULE_exprListWithParentheses = 80, 
		RULE_exprWithParentheses = 81, RULE_simpleExprWithParentheses = 82, RULE_orderList = 83, 
		RULE_orderExpression = 84, RULE_groupList = 85, RULE_groupingExpression = 86, 
		RULE_pureIdentifier = 87, RULE_identifier = 88, RULE_identifierList = 89, 
		RULE_identifierListWithParentheses = 90, RULE_qualifiedIdentifier = 91, 
		RULE_simpleIdentifier = 92, RULE_dotIdentifier = 93, RULE_ulong_number = 94, 
		RULE_real_ulong_number = 95, RULE_ulonglong_number = 96, RULE_real_ulonglong_number = 97, 
		RULE_literal = 98, RULE_signedLiteral = 99, RULE_stringList = 100, RULE_textStringLiteral = 101, 
		RULE_textString = 102, RULE_textStringHash = 103, RULE_textLiteral = 104, 
		RULE_textStringNoLinebreak = 105, RULE_textStringLiteralList = 106, RULE_numLiteral = 107, 
		RULE_boolLiteral = 108, RULE_nullLiteral = 109, RULE_temporalLiteral = 110, 
		RULE_floatOptions = 111, RULE_standardFloatOptions = 112, RULE_precision = 113, 
		RULE_textOrIdentifier = 114, RULE_sizeNumber = 115, RULE_parentheses = 116, 
		RULE_equal = 117, RULE_identifierKeyword = 118, RULE_identifierKeywordsUnambiguous = 119, 
		RULE_windowName = 120, RULE_fieldIdentifier = 121, RULE_columnName = 122, 
		RULE_columnInternalRef = 123, RULE_columnInternalRefList = 124, RULE_columnRef = 125, 
		RULE_tableRefWithWildcard = 126, RULE_tableAliasRefList = 127, RULE_tableWild = 128, 
		RULE_tableRef = 129, RULE_fieldLength = 130, RULE_typeDatetimePrecision = 131;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "selectStatement", "queryExpression", "queryExpressionBody", 
			"queryExpressionParens", "querySpecification", "subquery", "querySpecOption", 
			"limitClause", "simpleLimitClause", "limitOptions", "limitOption", "havingClause", 
			"windowClause", "windowDefinition", "windowSpec", "windowSpecDetails", 
			"windowFrameClause", "windowFrameUnits", "windowFrameExtent", "windowFrameStart", 
			"windowFrameBetween", "windowFrameBound", "windowFrameExclusion", "withClause", 
			"commonTableExpression", "groupByClause", "orderClause", "direction", 
			"fromClause", "tableReferenceList", "selectOption", "lockingClause", 
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
			null, null, null, null, null, null, null, "'='", "':='", "'<=>'", "'>='", 
			"'>'", "'<='", "'<'", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", 
			"','", "';'", "':'", "'('", "')'", "'{'", "'}'", "'_'", "'\\N'", "'?'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NOT2_SYMBOL", "CONCAT_PIPES_SYMBOL", "LONG_NUMBER", "ULONGLONG_NUMBER", 
			"ASSICIATION_SYMBOL", "VIEW_SYMBOL", "EQUAL_OPERATOR", "ASSIGN_OPERATOR", 
			"NULL_SAFE_EQUAL_OPERATOR", "GREATER_OR_EQUAL_OPERATOR", "GREATER_THAN_OPERATOR", 
			"LESS_OR_EQUAL_OPERATOR", "LESS_THAN_OPERATOR", "NOT_EQUAL_OPERATOR", 
			"PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", "DIV_OPERATOR", "MOD_OPERATOR", 
			"DOT_SYMBOL", "COMMA_SYMBOL", "SEMICOLON_SYMBOL", "COLON_SYMBOL", "OPEN_PAR_SYMBOL", 
			"CLOSE_PAR_SYMBOL", "OPEN_CURLY_SYMBOL", "CLOSE_CURLY_SYMBOL", "UNDERLINE_SYMBOL", 
			"NULL2_SYMBOL", "PARAM_MARKER", "HEX_NUMBER", "BIN_NUMBER", "INT_NUMBER", 
			"DECIMAL_NUMBER", "FLOAT_NUMBER", "DOT_IDENTIFIER", "LOCATE_SYMBOL", 
			"ASCII_SYMBOL", "COALESCE_SYMBOL", "SUBSTR_SYMBOL", "SUBSTRING_SYMBOL", 
			"AND_SYMBOL", "OR_SYMBOL", "NOT_SYMBOL", "UNION_SYMBOL", "ALL_SYMBOL", 
			"CURRENT_USER_SYMBOL", "ROWS_SYMBOL", "WINDOW_SYMBOL", "PARTITION_SYMBOL", 
			"BY_SYMBOL", "DENSE_RANK_SYMBOL", "FIRST_VALUE_SYMBOL", "LAG_SYMBOL", 
			"LAST_VALUE_SYMBOL", "LEAD_SYMBOL", "NTILE_SYMBOL", "NULLS_SYMBOL", "OVER_SYMBOL", 
			"PRECEDING_SYMBOL", "RANK_SYMBOL", "ROW_NUMBER_SYMBOL", "UNBOUNDED_SYMBOL", 
			"INTERVAL_SYMBOL", "CURRENT_SYMBOL", "ROW_SYMBOL", "FOLLOWING_SYMBOL", 
			"EXCLUDE_SYMBOL", "TIES_SYMBOL", "OTHERS_SYMBOL", "RECURSIVE_SYMBOL", 
			"AVG_SYMBOL", "COUNT_SYMBOL", "DISTINCT_SYMBOL", "SUM_SYMBOL", "MAX_SYMBOL", 
			"MIN_SYMBOL", "STD_SYMBOL", "STDDEV_SYMBOL", "VARIANCE_SYMBOL", "GROUP_CONCAT_SYMBOL", 
			"SEPARATOR_SYMBOL", "FOR_SYMBOL", "MODE_SYMBOL", "SHARE_SYMBOL", "UPDATE_SYMBOL", 
			"LOCK_SYMBOL", "SKIP_SYMBOL", "LOCKED_SYMBOL", "CROSS_SYMBOL", "INNER_SYMBOL", 
			"JOIN_SYMBOL", "LEFT_SYMBOL", "RIGHT_SYMBOL", "LATERAL_SYMBOL", "ELSE_SYMBOL", 
			"THEN_SYMBOL", "WHEN_SYMBOL", "ANY_SYMBOL", "AS_SYMBOL", "ASC_SYMBOL", 
			"AT_SYMBOL", "BETWEEN_SYMBOL", "CASE_SYMBOL", "CAST_SYMBOL", "CONTAINS_SYMBOL", 
			"DATE_SYMBOL", "DESC_SYMBOL", "DUMMY_SYMBOL", "END_SYMBOL", "ESCAPE_SYMBOL", 
			"EXISTS_SYMBOL", "FALSE_SYMBOL", "FIRST_SYMBOL", "FROM_SYMBOL", "FULL_SYMBOL", 
			"FULLTEXT_SYMBOL", "FUNCTION_SYMBOL", "GROUP_SYMBOL", "HAVING_SYMBOL", 
			"IN_SYMBOL", "IS_SYMBOL", "KEYS_SYMBOL", "LAST_SYMBOL", "LIKE_SYMBOL", 
			"LIMIT_SYMBOL", "NOW_SYMBOL", "NO_SYMBOL", "NULL_SYMBOL", "OFFSET_SYMBOL", 
			"ON_SYMBOL", "ORDER_SYMBOL", "OUTER_SYMBOL", "SELECT_SYMBOL", "TIMESTAMP_SYMBOL", 
			"TIME_SYMBOL", "TO_SYMBOL", "TRUE_SYMBOL", "UNKNOWN_SYMBOL", "USING_SYMBOL", 
			"WHERE_SYMBOL", "WITH_SYMBOL", "OF_SYMBOL", "NOWAIT_SYMBOL", "GROUPING_SYMBOL", 
			"WHITESPACE", "INVALID_INPUT", "IDENTIFIER", "NCHAR_TEXT", "DOUBLE_QUOTED_TEXT", 
			"SINGLE_QUOTED_TEXT", "BLOCK_COMMENT", "POUND_COMMENT", "DASHDASH_COMMENT", 
			"SLASHSLASH_COMMENT", "NOT_EQUAL2_OPERATOR"
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
	public String getGrammarFileName() { return "HDBViewParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HDBViewParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode VIEW_SYMBOL() { return getToken(HDBViewParser.VIEW_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(VIEW_SYMBOL);
			setState(265);
			identifier();
			setState(266);
			match(AS_SYMBOL);
			setState(267);
			selectStatement();
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				queryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQueryExpression(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_queryExpression);
		int _la;
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH_SYMBOL) {
					{
					setState(273);
					withClause();
					}
				}

				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(276);
					queryExpressionBody(0);
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER_SYMBOL) {
						{
						setState(277);
						orderClause();
						}
					}

					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LIMIT_SYMBOL) {
						{
						setState(280);
						limitClause();
						}
					}

					}
					break;
				case 2:
					{
					setState(283);
					queryExpressionParens();
					setState(289);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ORDER_SYMBOL:
						{
						setState(284);
						orderClause();
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LIMIT_SYMBOL) {
							{
							setState(285);
							limitClause();
							}
						}

						}
						break;
					case LIMIT_SYMBOL:
						{
						setState(288);
						limitClause();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(293);
					lockingClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				withClause();
				setState(297);
				queryExpressionParens();
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(298);
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
		public TerminalNode UNION_SYMBOL() { return getToken(HDBViewParser.UNION_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQueryExpressionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQueryExpressionBody(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_queryExpressionBody, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT_SYMBOL:
				{
				setState(304);
				querySpecification();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(305);
				queryExpressionParens();
				setState(306);
				match(UNION_SYMBOL);
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
					{
					setState(307);
					unionOption();
					}
				}

				setState(312);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT_SYMBOL:
					{
					setState(310);
					querySpecification();
					}
					break;
				case OPEN_PAR_SYMBOL:
					{
					setState(311);
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
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new QueryExpressionBodyContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_queryExpressionBody);
					setState(316);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(317);
					match(UNION_SYMBOL);
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
						{
						setState(318);
						unionOption();
						}
					}

					setState(323);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SELECT_SYMBOL:
						{
						setState(321);
						querySpecification();
						}
						break;
					case OPEN_PAR_SYMBOL:
						{
						setState(322);
						queryExpressionParens();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQueryExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQueryExpressionParens(this);
		}
	}

	public final QueryExpressionParensContext queryExpressionParens() throws RecognitionException {
		QueryExpressionParensContext _localctx = new QueryExpressionParensContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_queryExpressionParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(OPEN_PAR_SYMBOL);
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(331);
				queryExpressionParens();
				}
				break;
			case 2:
				{
				setState(332);
				queryExpression();
				}
				break;
			}
			setState(335);
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
		public TerminalNode SELECT_SYMBOL() { return getToken(HDBViewParser.SELECT_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQuerySpecification(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(SELECT_SYMBOL);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
				{
				{
				setState(338);
				selectOption();
				}
				}
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(344);
			selectItemList();
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(345);
				fromClause();
				}
				break;
			}
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(348);
				whereClause();
				}
				break;
			}
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(351);
				groupByClause();
				}
				break;
			}
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(354);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
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
		public TerminalNode ALL_SYMBOL() { return getToken(HDBViewParser.ALL_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBViewParser.DISTINCT_SYMBOL, 0); }
		public QuerySpecOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQuerySpecOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQuerySpecOption(this);
		}
	}

	public final QuerySpecOptionContext querySpecOption() throws RecognitionException {
		QuerySpecOptionContext _localctx = new QuerySpecOptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_querySpecOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
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
		public TerminalNode LIMIT_SYMBOL() { return getToken(HDBViewParser.LIMIT_SYMBOL, 0); }
		public LimitOptionsContext limitOptions() {
			return getRuleContext(LimitOptionsContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(LIMIT_SYMBOL);
			setState(362);
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
		public TerminalNode LIMIT_SYMBOL() { return getToken(HDBViewParser.LIMIT_SYMBOL, 0); }
		public LimitOptionContext limitOption() {
			return getRuleContext(LimitOptionContext.class,0);
		}
		public SimpleLimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLimitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleLimitClause(this);
		}
	}

	public final SimpleLimitClauseContext simpleLimitClause() throws RecognitionException {
		SimpleLimitClauseContext _localctx = new SimpleLimitClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_simpleLimitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(LIMIT_SYMBOL);
			setState(365);
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
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBViewParser.COMMA_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(HDBViewParser.OFFSET_SYMBOL, 0); }
		public LimitOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLimitOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLimitOptions(this);
		}
	}

	public final LimitOptionsContext limitOptions() throws RecognitionException {
		LimitOptionsContext _localctx = new LimitOptionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_limitOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			limitOption();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) {
				{
				setState(368);
				_la = _input.LA(1);
				if ( !(_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(369);
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
		public TerminalNode PARAM_MARKER() { return getToken(HDBViewParser.PARAM_MARKER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public LimitOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLimitOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLimitOption(this);
		}
	}

	public final LimitOptionContext limitOption() throws RecognitionException {
		LimitOptionContext _localctx = new LimitOptionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_limitOption);
		int _la;
		try {
			setState(374);
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
				setState(372);
				identifier();
				}
				break;
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PARAM_MARKER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
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
		public TerminalNode HAVING_SYMBOL() { return getToken(HDBViewParser.HAVING_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(HAVING_SYMBOL);
			setState(377);
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
		public TerminalNode WINDOW_SYMBOL() { return getToken(HDBViewParser.WINDOW_SYMBOL, 0); }
		public List<WindowDefinitionContext> windowDefinition() {
			return getRuleContexts(WindowDefinitionContext.class);
		}
		public WindowDefinitionContext windowDefinition(int i) {
			return getRuleContext(WindowDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public WindowClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowClause(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_windowClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(WINDOW_SYMBOL);
			setState(380);
			windowDefinition();
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(381);
				match(COMMA_SYMBOL);
				setState(382);
				windowDefinition();
				}
				}
				setState(387);
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
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public WindowDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowDefinition(this);
		}
	}

	public final WindowDefinitionContext windowDefinition() throws RecognitionException {
		WindowDefinitionContext _localctx = new WindowDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_windowDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			windowName();
			setState(389);
			match(AS_SYMBOL);
			setState(390);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public WindowSpecDetailsContext windowSpecDetails() {
			return getRuleContext(WindowSpecDetailsContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowSpec(this);
		}
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_windowSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(OPEN_PAR_SYMBOL);
			setState(393);
			windowSpecDetails();
			setState(394);
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
		public TerminalNode PARTITION_SYMBOL() { return getToken(HDBViewParser.PARTITION_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBViewParser.BY_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowSpecDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowSpecDetails(this);
		}
	}

	public final WindowSpecDetailsContext windowSpecDetails() throws RecognitionException {
		WindowSpecDetailsContext _localctx = new WindowSpecDetailsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_windowSpecDetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (COALESCE_SYMBOL - 39)) | (1L << (NULLS_SYMBOL - 39)) | (1L << (PRECEDING_SYMBOL - 39)) | (1L << (UNBOUNDED_SYMBOL - 39)) | (1L << (CURRENT_SYMBOL - 39)) | (1L << (FOLLOWING_SYMBOL - 39)) | (1L << (EXCLUDE_SYMBOL - 39)) | (1L << (TIES_SYMBOL - 39)) | (1L << (OTHERS_SYMBOL - 39)) | (1L << (AVG_SYMBOL - 39)) | (1L << (MODE_SYMBOL - 39)) | (1L << (SHARE_SYMBOL - 39)) | (1L << (SKIP_SYMBOL - 39)) | (1L << (LOCKED_SYMBOL - 39)) | (1L << (ANY_SYMBOL - 39)) | (1L << (AT_SYMBOL - 39)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (DATE_SYMBOL - 107)) | (1L << (ESCAPE_SYMBOL - 107)) | (1L << (FIRST_SYMBOL - 107)) | (1L << (FULL_SYMBOL - 107)) | (1L << (LAST_SYMBOL - 107)) | (1L << (OFFSET_SYMBOL - 107)) | (1L << (TIMESTAMP_SYMBOL - 107)) | (1L << (TIME_SYMBOL - 107)) | (1L << (UNKNOWN_SYMBOL - 107)) | (1L << (NOWAIT_SYMBOL - 107)) | (1L << (IDENTIFIER - 107)) | (1L << (DOUBLE_QUOTED_TEXT - 107)))) != 0)) {
				{
				setState(396);
				windowName();
				}
			}

			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION_SYMBOL) {
				{
				setState(399);
				match(PARTITION_SYMBOL);
				setState(400);
				match(BY_SYMBOL);
				setState(401);
				orderList();
				}
			}

			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_SYMBOL) {
				{
				setState(404);
				orderClause();
				}
			}

			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROWS_SYMBOL) {
				{
				setState(407);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameClause(this);
		}
	}

	public final WindowFrameClauseContext windowFrameClause() throws RecognitionException {
		WindowFrameClauseContext _localctx = new WindowFrameClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_windowFrameClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			windowFrameUnits();
			setState(411);
			windowFrameExtent();
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUDE_SYMBOL) {
				{
				setState(412);
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
		public TerminalNode ROWS_SYMBOL() { return getToken(HDBViewParser.ROWS_SYMBOL, 0); }
		public WindowFrameUnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameUnits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameUnits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameUnits(this);
		}
	}

	public final WindowFrameUnitsContext windowFrameUnits() throws RecognitionException {
		WindowFrameUnitsContext _localctx = new WindowFrameUnitsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_windowFrameUnits);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameExtent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameExtent(this);
		}
	}

	public final WindowFrameExtentContext windowFrameExtent() throws RecognitionException {
		WindowFrameExtentContext _localctx = new WindowFrameExtentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_windowFrameExtent);
		try {
			setState(419);
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
				setState(417);
				windowFrameStart();
				}
				break;
			case BETWEEN_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
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
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBViewParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(HDBViewParser.PRECEDING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBViewParser.PARAM_MARKER, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBViewParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBViewParser.ROW_SYMBOL, 0); }
		public WindowFrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameStart(this);
		}
	}

	public final WindowFrameStartContext windowFrameStart() throws RecognitionException {
		WindowFrameStartContext _localctx = new WindowFrameStartContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_windowFrameStart);
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNBOUNDED_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				match(UNBOUNDED_SYMBOL);
				setState(422);
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
				setState(423);
				ulonglong_number();
				setState(424);
				match(PRECEDING_SYMBOL);
				}
				break;
			case PARAM_MARKER:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				match(PARAM_MARKER);
				setState(427);
				match(PRECEDING_SYMBOL);
				}
				break;
			case CURRENT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(428);
				match(CURRENT_SYMBOL);
				setState(429);
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
		public TerminalNode BETWEEN_SYMBOL() { return getToken(HDBViewParser.BETWEEN_SYMBOL, 0); }
		public List<WindowFrameBoundContext> windowFrameBound() {
			return getRuleContexts(WindowFrameBoundContext.class);
		}
		public WindowFrameBoundContext windowFrameBound(int i) {
			return getRuleContext(WindowFrameBoundContext.class,i);
		}
		public TerminalNode AND_SYMBOL() { return getToken(HDBViewParser.AND_SYMBOL, 0); }
		public WindowFrameBetweenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBetween; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameBetween(this);
		}
	}

	public final WindowFrameBetweenContext windowFrameBetween() throws RecognitionException {
		WindowFrameBetweenContext _localctx = new WindowFrameBetweenContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_windowFrameBetween);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(BETWEEN_SYMBOL);
			setState(433);
			windowFrameBound();
			setState(434);
			match(AND_SYMBOL);
			setState(435);
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
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBViewParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(HDBViewParser.FOLLOWING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBViewParser.PARAM_MARKER, 0); }
		public WindowFrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameBound(this);
		}
	}

	public final WindowFrameBoundContext windowFrameBound() throws RecognitionException {
		WindowFrameBoundContext _localctx = new WindowFrameBoundContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_windowFrameBound);
		try {
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				windowFrameStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(UNBOUNDED_SYMBOL);
				setState(439);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(440);
				ulonglong_number();
				setState(441);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(PARAM_MARKER);
				setState(444);
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
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(HDBViewParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBViewParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBViewParser.ROW_SYMBOL, 0); }
		public TerminalNode GROUP_SYMBOL() { return getToken(HDBViewParser.GROUP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(HDBViewParser.TIES_SYMBOL, 0); }
		public TerminalNode NO_SYMBOL() { return getToken(HDBViewParser.NO_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(HDBViewParser.OTHERS_SYMBOL, 0); }
		public WindowFrameExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameExclusion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFrameExclusion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFrameExclusion(this);
		}
	}

	public final WindowFrameExclusionContext windowFrameExclusion() throws RecognitionException {
		WindowFrameExclusionContext _localctx = new WindowFrameExclusionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_windowFrameExclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(EXCLUDE_SYMBOL);
			setState(454);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_SYMBOL:
				{
				setState(448);
				match(CURRENT_SYMBOL);
				setState(449);
				match(ROW_SYMBOL);
				}
				break;
			case GROUP_SYMBOL:
				{
				setState(450);
				match(GROUP_SYMBOL);
				}
				break;
			case TIES_SYMBOL:
				{
				setState(451);
				match(TIES_SYMBOL);
				}
				break;
			case NO_SYMBOL:
				{
				setState(452);
				match(NO_SYMBOL);
				setState(453);
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
		public TerminalNode WITH_SYMBOL() { return getToken(HDBViewParser.WITH_SYMBOL, 0); }
		public List<CommonTableExpressionContext> commonTableExpression() {
			return getRuleContexts(CommonTableExpressionContext.class);
		}
		public CommonTableExpressionContext commonTableExpression(int i) {
			return getRuleContext(CommonTableExpressionContext.class,i);
		}
		public TerminalNode RECURSIVE_SYMBOL() { return getToken(HDBViewParser.RECURSIVE_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWithClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWithClause(this);
		}
	}

	public final WithClauseContext withClause() throws RecognitionException {
		WithClauseContext _localctx = new WithClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_withClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(WITH_SYMBOL);
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RECURSIVE_SYMBOL) {
				{
				setState(457);
				match(RECURSIVE_SYMBOL);
				}
			}

			setState(460);
			commonTableExpression();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(461);
				match(COMMA_SYMBOL);
				setState(462);
				commonTableExpression();
				}
				}
				setState(467);
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
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterCommonTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitCommonTableExpression(this);
		}
	}

	public final CommonTableExpressionContext commonTableExpression() throws RecognitionException {
		CommonTableExpressionContext _localctx = new CommonTableExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_commonTableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			identifier();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR_SYMBOL) {
				{
				setState(469);
				columnInternalRefList();
				}
			}

			setState(472);
			match(AS_SYMBOL);
			setState(473);
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
		public TerminalNode GROUP_SYMBOL() { return getToken(HDBViewParser.GROUP_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBViewParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(GROUP_SYMBOL);
			setState(476);
			match(BY_SYMBOL);
			setState(477);
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
		public TerminalNode ORDER_SYMBOL() { return getToken(HDBViewParser.ORDER_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(HDBViewParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orderClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(ORDER_SYMBOL);
			setState(480);
			match(BY_SYMBOL);
			setState(481);
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
		public TerminalNode ASC_SYMBOL() { return getToken(HDBViewParser.ASC_SYMBOL, 0); }
		public TerminalNode DESC_SYMBOL() { return getToken(HDBViewParser.DESC_SYMBOL, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitDirection(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_direction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
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
		public TerminalNode FROM_SYMBOL() { return getToken(HDBViewParser.FROM_SYMBOL, 0); }
		public TerminalNode DUMMY_SYMBOL() { return getToken(HDBViewParser.DUMMY_SYMBOL, 0); }
		public TableReferenceListContext tableReferenceList() {
			return getRuleContext(TableReferenceListContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(FROM_SYMBOL);
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DUMMY_SYMBOL:
				{
				setState(486);
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
				setState(487);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public TableReferenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReferenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableReferenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableReferenceList(this);
		}
	}

	public final TableReferenceListContext tableReferenceList() throws RecognitionException {
		TableReferenceListContext _localctx = new TableReferenceListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tableReferenceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			tableReference();
			setState(495);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(491);
					match(COMMA_SYMBOL);
					setState(492);
					tableReference();
					}
					} 
				}
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSelectOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSelectOption(this);
		}
	}

	public final SelectOptionContext selectOption() throws RecognitionException {
		SelectOptionContext _localctx = new SelectOptionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selectOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
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
		public TerminalNode FOR_SYMBOL() { return getToken(HDBViewParser.FOR_SYMBOL, 0); }
		public LockStrenghContext lockStrengh() {
			return getRuleContext(LockStrenghContext.class,0);
		}
		public TerminalNode OF_SYMBOL() { return getToken(HDBViewParser.OF_SYMBOL, 0); }
		public TableAliasRefListContext tableAliasRefList() {
			return getRuleContext(TableAliasRefListContext.class,0);
		}
		public LockedRowActionContext lockedRowAction() {
			return getRuleContext(LockedRowActionContext.class,0);
		}
		public TerminalNode LOCK_SYMBOL() { return getToken(HDBViewParser.LOCK_SYMBOL, 0); }
		public TerminalNode IN_SYMBOL() { return getToken(HDBViewParser.IN_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBViewParser.SHARE_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(HDBViewParser.MODE_SYMBOL, 0); }
		public LockingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLockingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLockingClause(this);
		}
	}

	public final LockingClauseContext lockingClause() throws RecognitionException {
		LockingClauseContext _localctx = new LockingClauseContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lockingClause);
		int _la;
		try {
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				match(FOR_SYMBOL);
				setState(501);
				lockStrengh();
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OF_SYMBOL) {
					{
					setState(502);
					match(OF_SYMBOL);
					setState(503);
					tableAliasRefList();
					}
				}

				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SKIP_SYMBOL || _la==NOWAIT_SYMBOL) {
					{
					setState(506);
					lockedRowAction();
					}
				}

				}
				break;
			case LOCK_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				match(LOCK_SYMBOL);
				setState(510);
				match(IN_SYMBOL);
				setState(511);
				match(SHARE_SYMBOL);
				setState(512);
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
		public TerminalNode UPDATE_SYMBOL() { return getToken(HDBViewParser.UPDATE_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBViewParser.SHARE_SYMBOL, 0); }
		public LockStrenghContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockStrengh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLockStrengh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLockStrengh(this);
		}
	}

	public final LockStrenghContext lockStrengh() throws RecognitionException {
		LockStrenghContext _localctx = new LockStrenghContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lockStrengh);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
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
		public TerminalNode SKIP_SYMBOL() { return getToken(HDBViewParser.SKIP_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(HDBViewParser.LOCKED_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(HDBViewParser.NOWAIT_SYMBOL, 0); }
		public LockedRowActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockedRowAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLockedRowAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLockedRowAction(this);
		}
	}

	public final LockedRowActionContext lockedRowAction() throws RecognitionException {
		LockedRowActionContext _localctx = new LockedRowActionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_lockedRowAction);
		try {
			setState(520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(SKIP_SYMBOL);
				setState(518);
				match(LOCKED_SYMBOL);
				}
				break;
			case NOWAIT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
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
		public TerminalNode MULT_OPERATOR() { return getToken(HDBViewParser.MULT_OPERATOR, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public SelectItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSelectItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSelectItemList(this);
		}
	}

	public final SelectItemListContext selectItemList() throws RecognitionException {
		SelectItemListContext _localctx = new SelectItemListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectItemList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
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
				setState(522);
				selectItem();
				}
				break;
			case MULT_OPERATOR:
				{
				setState(523);
				match(MULT_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(526);
					match(COMMA_SYMBOL);
					setState(527);
					selectItem();
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSelectItem(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_selectItem);
		try {
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(533);
				tableWild();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				expr(0);
				setState(536);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(535);
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
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
		public SelectAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSelectAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSelectAlias(this);
		}
	}

	public final SelectAliasContext selectAlias() throws RecognitionException {
		SelectAliasContext _localctx = new SelectAliasContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_selectAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(540);
				match(AS_SYMBOL);
				}
			}

			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(543);
				identifier();
				}
				break;
			case 2:
				{
				setState(544);
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
		public TerminalNode WHERE_SYMBOL() { return getToken(HDBViewParser.WHERE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(WHERE_SYMBOL);
			setState(548);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableReference(this);
		}
	}

	public final TableReferenceContext tableReference() throws RecognitionException {
		TableReferenceContext _localctx = new TableReferenceContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_tableReference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			tableFactor();
			setState(554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(551);
					joinedTable();
					}
					} 
				}
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterEscapedTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitEscapedTableReference(this);
		}
	}

	public final EscapedTableReferenceContext escapedTableReference() throws RecognitionException {
		EscapedTableReferenceContext _localctx = new EscapedTableReferenceContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_escapedTableReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			tableFactor();
			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (CROSS_SYMBOL - 90)) | (1L << (INNER_SYMBOL - 90)) | (1L << (JOIN_SYMBOL - 90)) | (1L << (LEFT_SYMBOL - 90)) | (1L << (RIGHT_SYMBOL - 90)))) != 0)) {
				{
				{
				setState(558);
				joinedTable();
				}
				}
				setState(563);
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
		public TerminalNode ON_SYMBOL() { return getToken(HDBViewParser.ON_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING_SYMBOL() { return getToken(HDBViewParser.USING_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterJoinedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitJoinedTable(this);
		}
	}

	public final JoinedTableContext joinedTable() throws RecognitionException {
		JoinedTableContext _localctx = new JoinedTableContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_joinedTable);
		try {
			setState(580);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CROSS_SYMBOL:
			case INNER_SYMBOL:
			case JOIN_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(564);
				innerJoinType();
				setState(565);
				tableReference();
				setState(570);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(566);
					match(ON_SYMBOL);
					setState(567);
					expr(0);
					}
					break;
				case 2:
					{
					setState(568);
					match(USING_SYMBOL);
					setState(569);
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
				setState(572);
				outerJoinType();
				setState(573);
				tableReference();
				setState(578);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ON_SYMBOL:
					{
					setState(574);
					match(ON_SYMBOL);
					setState(575);
					expr(0);
					}
					break;
				case USING_SYMBOL:
					{
					setState(576);
					match(USING_SYMBOL);
					setState(577);
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
		public TerminalNode JOIN_SYMBOL() { return getToken(HDBViewParser.JOIN_SYMBOL, 0); }
		public TerminalNode INNER_SYMBOL() { return getToken(HDBViewParser.INNER_SYMBOL, 0); }
		public TerminalNode CROSS_SYMBOL() { return getToken(HDBViewParser.CROSS_SYMBOL, 0); }
		public InnerJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterInnerJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitInnerJoinType(this);
		}
	}

	public final InnerJoinTypeContext innerJoinType() throws RecognitionException {
		InnerJoinTypeContext _localctx = new InnerJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_innerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CROSS_SYMBOL || _la==INNER_SYMBOL) {
				{
				setState(582);
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

			setState(585);
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
		public TerminalNode JOIN_SYMBOL() { return getToken(HDBViewParser.JOIN_SYMBOL, 0); }
		public TerminalNode LEFT_SYMBOL() { return getToken(HDBViewParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(HDBViewParser.RIGHT_SYMBOL, 0); }
		public TerminalNode OUTER_SYMBOL() { return getToken(HDBViewParser.OUTER_SYMBOL, 0); }
		public OuterJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterOuterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitOuterJoinType(this);
		}
	}

	public final OuterJoinTypeContext outerJoinType() throws RecognitionException {
		OuterJoinTypeContext _localctx = new OuterJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_outerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
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
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTER_SYMBOL) {
				{
				setState(588);
				match(OUTER_SYMBOL);
				}
			}

			setState(591);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableFactor(this);
		}
	}

	public final TableFactorContext tableFactor() throws RecognitionException {
		TableFactorContext _localctx = new TableFactorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tableFactor);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(593);
				singleTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				singleTableParens();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(595);
				derivedTable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(596);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSingleTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSingleTable(this);
		}
	}

	public final SingleTableContext singleTable() throws RecognitionException {
		SingleTableContext _localctx = new SingleTableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_singleTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			tableRef();
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(600);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSingleTableParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSingleTableParens(this);
		}
	}

	public final SingleTableParensContext singleTableParens() throws RecognitionException {
		SingleTableParensContext _localctx = new SingleTableParensContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_singleTableParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(OPEN_PAR_SYMBOL);
			setState(606);
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
				setState(604);
				singleTable();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(605);
				singleTableParens();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(608);
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
		public TerminalNode LATERAL_SYMBOL() { return getToken(HDBViewParser.LATERAL_SYMBOL, 0); }
		public DerivedTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterDerivedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitDerivedTable(this);
		}
	}

	public final DerivedTableContext derivedTable() throws RecognitionException {
		DerivedTableContext _localctx = new DerivedTableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_derivedTable);
		try {
			setState(625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(610);
				subquery();
				setState(612);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(611);
					tableAlias();
					}
					break;
				}
				setState(615);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(614);
					columnInternalRefList();
					}
					break;
				}
				}
				break;
			case LATERAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				match(LATERAL_SYMBOL);
				setState(618);
				subquery();
				setState(620);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(619);
					tableAlias();
					}
					break;
				}
				setState(623);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(622);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableReferenceListParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableReferenceListParens(this);
		}
	}

	public final TableReferenceListParensContext tableReferenceListParens() throws RecognitionException {
		TableReferenceListParensContext _localctx = new TableReferenceListParensContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_tableReferenceListParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(OPEN_PAR_SYMBOL);
			setState(630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(628);
				tableReferenceList();
				}
				break;
			case 2:
				{
				setState(629);
				tableReferenceListParens();
				}
				break;
			}
			setState(632);
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
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBViewParser.DISTINCT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(HDBViewParser.ALL_SYMBOL, 0); }
		public UnionOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitUnionOption(this);
		}
	}

	public final UnionOptionContext unionOption() throws RecognitionException {
		UnionOptionContext _localctx = new UnionOptionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_unionOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
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
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableAlias(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_tableAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(636);
				match(AS_SYMBOL);
				}
			}

			setState(639);
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
		public TerminalNode OR_SYMBOL() { return getToken(HDBViewParser.OR_SYMBOL, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprOr(this);
		}
	}
	public static class ExprNotContext extends ExprContext {
		public TerminalNode NOT_SYMBOL() { return getToken(HDBViewParser.NOT_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprNot(this);
		}
	}
	public static class ExprIsContext extends ExprContext {
		public Token type;
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(HDBViewParser.IS_SYMBOL, 0); }
		public TerminalNode TRUE_SYMBOL() { return getToken(HDBViewParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(HDBViewParser.FALSE_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(HDBViewParser.UNKNOWN_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public ExprIsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprIs(this);
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
		public TerminalNode AND_SYMBOL() { return getToken(HDBViewParser.AND_SYMBOL, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprAnd(this);
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
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
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

				setState(642);
				boolPri(0);
				setState(648);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(643);
					match(IS_SYMBOL);
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
						{
						setState(644);
						notRule();
						}
					}

					setState(647);
					((ExprIsContext)_localctx).type = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (FALSE_SYMBOL - 113)) | (1L << (TRUE_SYMBOL - 113)) | (1L << (UNKNOWN_SYMBOL - 113)))) != 0)) ) {
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
				setState(650);
				match(NOT_SYMBOL);
				setState(651);
				expr(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(662);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(660);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(654);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(655);
						((ExprAndContext)_localctx).op = match(AND_SYMBOL);
						setState(656);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(657);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(658);
						((ExprOrContext)_localctx).op = match(OR_SYMBOL);
						setState(659);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(664);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPrimaryExprPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPrimaryExprPredicate(this);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPrimaryExprCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPrimaryExprCompare(this);
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
		public TerminalNode ALL_SYMBOL() { return getToken(HDBViewParser.ALL_SYMBOL, 0); }
		public TerminalNode ANY_SYMBOL() { return getToken(HDBViewParser.ANY_SYMBOL, 0); }
		public PrimaryExprAllAnyContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPrimaryExprAllAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPrimaryExprAllAny(this);
		}
	}
	public static class PrimaryExprIsNullContext extends BoolPriContext {
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(HDBViewParser.IS_SYMBOL, 0); }
		public TerminalNode NULL_SYMBOL() { return getToken(HDBViewParser.NULL_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public PrimaryExprIsNullContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPrimaryExprIsNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPrimaryExprIsNull(this);
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
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_boolPri, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExprPredicateContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(666);
			predicate();
			}
			_ctx.stop = _input.LT(-1);
			setState(685);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(683);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
					case 1:
						{
						_localctx = new PrimaryExprIsNullContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(668);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(669);
						match(IS_SYMBOL);
						setState(671);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
							{
							setState(670);
							notRule();
							}
						}

						setState(673);
						match(NULL_SYMBOL);
						}
						break;
					case 2:
						{
						_localctx = new PrimaryExprCompareContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(674);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(675);
						compOp();
						setState(676);
						predicate();
						}
						break;
					case 3:
						{
						_localctx = new PrimaryExprAllAnyContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(678);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(679);
						compOp();
						setState(680);
						_la = _input.LA(1);
						if ( !(_la==ALL_SYMBOL || _la==ANY_SYMBOL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(681);
						subquery();
						}
						break;
					}
					} 
				}
				setState(687);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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
		public TerminalNode EQUAL_OPERATOR() { return getToken(HDBViewParser.EQUAL_OPERATOR, 0); }
		public TerminalNode NULL_SAFE_EQUAL_OPERATOR() { return getToken(HDBViewParser.NULL_SAFE_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_OR_EQUAL_OPERATOR() { return getToken(HDBViewParser.GREATER_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_THAN_OPERATOR() { return getToken(HDBViewParser.GREATER_THAN_OPERATOR, 0); }
		public TerminalNode LESS_OR_EQUAL_OPERATOR() { return getToken(HDBViewParser.LESS_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode LESS_THAN_OPERATOR() { return getToken(HDBViewParser.LESS_THAN_OPERATOR, 0); }
		public TerminalNode NOT_EQUAL_OPERATOR() { return getToken(HDBViewParser.NOT_EQUAL_OPERATOR, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			bitExpr(0);
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
					{
					setState(691);
					notRule();
					}
				}

				setState(694);
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
		public TerminalNode BETWEEN_SYMBOL() { return getToken(HDBViewParser.BETWEEN_SYMBOL, 0); }
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public TerminalNode AND_SYMBOL() { return getToken(HDBViewParser.AND_SYMBOL, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateExprBetweenContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPredicateExprBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPredicateExprBetween(this);
		}
	}
	public static class PredicateExprInContext extends PredicateOperationsContext {
		public TerminalNode IN_SYMBOL() { return getToken(HDBViewParser.IN_SYMBOL, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public PredicateExprInContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPredicateExprIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPredicateExprIn(this);
		}
	}
	public static class PredicateExprLikeContext extends PredicateOperationsContext {
		public TerminalNode LIKE_SYMBOL() { return getToken(HDBViewParser.LIKE_SYMBOL, 0); }
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode ESCAPE_SYMBOL() { return getToken(HDBViewParser.ESCAPE_SYMBOL, 0); }
		public PredicateExprLikeContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPredicateExprLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPredicateExprLike(this);
		}
	}

	public final PredicateOperationsContext predicateOperations() throws RecognitionException {
		PredicateOperationsContext _localctx = new PredicateOperationsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_predicateOperations);
		try {
			setState(716);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN_SYMBOL:
				_localctx = new PredicateExprInContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(697);
				match(IN_SYMBOL);
				setState(703);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(698);
					subquery();
					}
					break;
				case 2:
					{
					setState(699);
					match(OPEN_PAR_SYMBOL);
					setState(700);
					exprList();
					setState(701);
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
				setState(705);
				match(BETWEEN_SYMBOL);
				setState(706);
				bitExpr(0);
				setState(707);
				match(AND_SYMBOL);
				setState(708);
				predicate();
				}
				break;
			case LIKE_SYMBOL:
				_localctx = new PredicateExprLikeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(710);
				match(LIKE_SYMBOL);
				setState(711);
				simpleExpr(0);
				setState(714);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(712);
					match(ESCAPE_SYMBOL);
					setState(713);
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
		public TerminalNode MULT_OPERATOR() { return getToken(HDBViewParser.MULT_OPERATOR, 0); }
		public TerminalNode DIV_OPERATOR() { return getToken(HDBViewParser.DIV_OPERATOR, 0); }
		public TerminalNode MOD_OPERATOR() { return getToken(HDBViewParser.MOD_OPERATOR, 0); }
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBViewParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBViewParser.MINUS_OPERATOR, 0); }
		public BitExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterBitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitBitExpr(this);
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
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_bitExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(719);
			simpleExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(729);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(727);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(721);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(722);
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
						setState(723);
						bitExpr(3);
						}
						break;
					case 2:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(724);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(725);
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
						setState(726);
						bitExpr(2);
						}
						break;
					}
					} 
				}
				setState(731);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprColumnRef(this);
		}
	}
	public static class SimpleExprParamMarkerContext extends SimpleExprContext {
		public TerminalNode PARAM_MARKER() { return getToken(HDBViewParser.PARAM_MARKER, 0); }
		public SimpleExprParamMarkerContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprParamMarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprParamMarker(this);
		}
	}
	public static class SimpleExprSumContext extends SimpleExprContext {
		public SumExprContext sumExpr() {
			return getRuleContext(SumExprContext.class,0);
		}
		public SimpleExprSumContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprSum(this);
		}
	}
	public static class SimpleExprCastContext extends SimpleExprContext {
		public TerminalNode CAST_SYMBOL() { return getToken(HDBViewParser.CAST_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(HDBViewParser.AS_SYMBOL, 0); }
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprCastContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprCast(this);
		}
	}
	public static class SimpleExprUnaryContext extends SimpleExprContext {
		public Token op;
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBViewParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBViewParser.MINUS_OPERATOR, 0); }
		public SimpleExprUnaryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprUnary(this);
		}
	}
	public static class SimpleExprSubQueryContext extends SimpleExprContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode EXISTS_SYMBOL() { return getToken(HDBViewParser.EXISTS_SYMBOL, 0); }
		public SimpleExprSubQueryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprSubQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprSubQuery(this);
		}
	}
	public static class SimpleExprGroupingOperationContext extends SimpleExprContext {
		public GroupingOperationContext groupingOperation() {
			return getRuleContext(GroupingOperationContext.class,0);
		}
		public SimpleExprGroupingOperationContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprGroupingOperation(this);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprNot(this);
		}
	}
	public static class SimpleExprOdbcContext extends SimpleExprContext {
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(HDBViewParser.OPEN_CURLY_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(HDBViewParser.CLOSE_CURLY_SYMBOL, 0); }
		public SimpleExprOdbcContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprOdbc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprOdbc(this);
		}
	}
	public static class SimpleExprRuntimeFunctionContext extends SimpleExprContext {
		public RuntimeFunctionCallContext runtimeFunctionCall() {
			return getRuleContext(RuntimeFunctionCallContext.class,0);
		}
		public SimpleExprRuntimeFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprRuntimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprRuntimeFunction(this);
		}
	}
	public static class SimpleExprFunctionContext extends SimpleExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public SimpleExprFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprFunction(this);
		}
	}
	public static class SimpleExprListContext extends SimpleExprContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(HDBViewParser.ROW_SYMBOL, 0); }
		public SimpleExprListContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprList(this);
		}
	}
	public static class SimpleExprCaseContext extends SimpleExprContext {
		public TerminalNode CASE_SYMBOL() { return getToken(HDBViewParser.CASE_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(HDBViewParser.END_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprCase(this);
		}
	}
	public static class SimpleExprConcatContext extends SimpleExprContext {
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode CONCAT_PIPES_SYMBOL() { return getToken(HDBViewParser.CONCAT_PIPES_SYMBOL, 0); }
		public SimpleExprConcatContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprConcat(this);
		}
	}
	public static class SimpleExprLiteralContext extends SimpleExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public SimpleExprLiteralContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprLiteral(this);
		}
	}
	public static class SimpleExprWindowingFunctionContext extends SimpleExprContext {
		public WindowFunctionCallContext windowFunctionCall() {
			return getRuleContext(WindowFunctionCallContext.class,0);
		}
		public SimpleExprWindowingFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprWindowingFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprWindowingFunction(this);
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
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_simpleExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				_localctx = new SimpleExprColumnRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(733);
				columnRef();
				}
				break;
			case 2:
				{
				_localctx = new SimpleExprRuntimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(734);
				runtimeFunctionCall();
				}
				break;
			case 3:
				{
				_localctx = new SimpleExprFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(735);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new SimpleExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(736);
				literal();
				}
				break;
			case 5:
				{
				_localctx = new SimpleExprParamMarkerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(737);
				match(PARAM_MARKER);
				}
				break;
			case 6:
				{
				_localctx = new SimpleExprSumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(738);
				sumExpr();
				}
				break;
			case 7:
				{
				_localctx = new SimpleExprGroupingOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(739);
				groupingOperation();
				}
				break;
			case 8:
				{
				_localctx = new SimpleExprWindowingFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(740);
				windowFunctionCall();
				}
				break;
			case 9:
				{
				_localctx = new SimpleExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(741);
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
				setState(742);
				simpleExpr(7);
				}
				break;
			case 10:
				{
				_localctx = new SimpleExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(743);
				not2Rule();
				setState(744);
				simpleExpr(6);
				}
				break;
			case 11:
				{
				_localctx = new SimpleExprListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(747);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW_SYMBOL) {
					{
					setState(746);
					match(ROW_SYMBOL);
					}
				}

				setState(749);
				match(OPEN_PAR_SYMBOL);
				setState(750);
				exprList();
				setState(751);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 12:
				{
				_localctx = new SimpleExprSubQueryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXISTS_SYMBOL) {
					{
					setState(753);
					match(EXISTS_SYMBOL);
					}
				}

				setState(756);
				subquery();
				}
				break;
			case 13:
				{
				_localctx = new SimpleExprOdbcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(757);
				match(OPEN_CURLY_SYMBOL);
				setState(758);
				identifier();
				setState(759);
				expr(0);
				setState(760);
				match(CLOSE_CURLY_SYMBOL);
				}
				break;
			case 14:
				{
				_localctx = new SimpleExprCastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(762);
				match(CAST_SYMBOL);
				setState(763);
				match(OPEN_PAR_SYMBOL);
				setState(764);
				expr(0);
				setState(765);
				match(AS_SYMBOL);
				setState(766);
				castType();
				setState(767);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 15:
				{
				_localctx = new SimpleExprCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(769);
				match(CASE_SYMBOL);
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERVAL_SYMBOL - 64)) | (1L << (CURRENT_SYMBOL - 64)) | (1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (NULL_SYMBOL - 129)) | (1L << (OFFSET_SYMBOL - 129)) | (1L << (TIMESTAMP_SYMBOL - 129)) | (1L << (TIME_SYMBOL - 129)) | (1L << (TRUE_SYMBOL - 129)) | (1L << (UNKNOWN_SYMBOL - 129)) | (1L << (NOWAIT_SYMBOL - 129)) | (1L << (GROUPING_SYMBOL - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (NCHAR_TEXT - 129)) | (1L << (DOUBLE_QUOTED_TEXT - 129)) | (1L << (SINGLE_QUOTED_TEXT - 129)))) != 0)) {
					{
					setState(770);
					expr(0);
					}
				}

				setState(776); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(773);
					whenExpression();
					setState(774);
					thenExpression();
					}
					}
					setState(778); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_SYMBOL );
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_SYMBOL) {
					{
					setState(780);
					elseExpression();
					}
				}

				setState(783);
				match(END_SYMBOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(792);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SimpleExprConcatContext(new SimpleExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_simpleExpr);
					setState(787);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(788);
					match(CONCAT_PIPES_SYMBOL);
					setState(789);
					simpleExpr(9);
					}
					} 
				}
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public InSumExprContext inSumExpr() {
			return getRuleContext(InSumExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(HDBViewParser.AVG_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(HDBViewParser.DISTINCT_SYMBOL, 0); }
		public WindowingClauseContext windowingClause() {
			return getRuleContext(WindowingClauseContext.class,0);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBViewParser.MULT_OPERATOR, 0); }
		public TerminalNode COUNT_SYMBOL() { return getToken(HDBViewParser.COUNT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(HDBViewParser.ALL_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode MIN_SYMBOL() { return getToken(HDBViewParser.MIN_SYMBOL, 0); }
		public TerminalNode MAX_SYMBOL() { return getToken(HDBViewParser.MAX_SYMBOL, 0); }
		public TerminalNode STD_SYMBOL() { return getToken(HDBViewParser.STD_SYMBOL, 0); }
		public TerminalNode VARIANCE_SYMBOL() { return getToken(HDBViewParser.VARIANCE_SYMBOL, 0); }
		public TerminalNode SUM_SYMBOL() { return getToken(HDBViewParser.SUM_SYMBOL, 0); }
		public TerminalNode GROUP_CONCAT_SYMBOL() { return getToken(HDBViewParser.GROUP_CONCAT_SYMBOL, 0); }
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public TerminalNode SEPARATOR_SYMBOL() { return getToken(HDBViewParser.SEPARATOR_SYMBOL, 0); }
		public TextStringContext textString() {
			return getRuleContext(TextStringContext.class,0);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSumExpr(this);
		}
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_sumExpr);
		int _la;
		try {
			setState(891);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(795);
				((SumExprContext)_localctx).name = match(AVG_SYMBOL);
				setState(796);
				match(OPEN_PAR_SYMBOL);
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(797);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(800);
				inSumExpr();
				setState(801);
				match(CLOSE_PAR_SYMBOL);
				setState(803);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(802);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(805);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(806);
				match(OPEN_PAR_SYMBOL);
				setState(808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL) {
					{
					setState(807);
					match(ALL_SYMBOL);
					}
				}

				setState(810);
				match(MULT_OPERATOR);
				setState(811);
				match(CLOSE_PAR_SYMBOL);
				setState(813);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(812);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(815);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(816);
				match(OPEN_PAR_SYMBOL);
				setState(824);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(818);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL) {
						{
						setState(817);
						match(ALL_SYMBOL);
						}
					}

					setState(820);
					match(MULT_OPERATOR);
					}
					break;
				case 2:
					{
					setState(821);
					inSumExpr();
					}
					break;
				case 3:
					{
					setState(822);
					match(DISTINCT_SYMBOL);
					setState(823);
					exprList();
					}
					break;
				}
				setState(826);
				match(CLOSE_PAR_SYMBOL);
				setState(828);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(827);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(830);
				((SumExprContext)_localctx).name = match(MIN_SYMBOL);
				setState(831);
				match(OPEN_PAR_SYMBOL);
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(832);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(835);
				inSumExpr();
				setState(836);
				match(CLOSE_PAR_SYMBOL);
				setState(838);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(837);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(840);
				((SumExprContext)_localctx).name = match(MAX_SYMBOL);
				setState(841);
				match(OPEN_PAR_SYMBOL);
				setState(843);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(842);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(845);
				inSumExpr();
				setState(846);
				match(CLOSE_PAR_SYMBOL);
				setState(848);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(847);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(850);
				((SumExprContext)_localctx).name = match(STD_SYMBOL);
				setState(851);
				match(OPEN_PAR_SYMBOL);
				setState(852);
				inSumExpr();
				setState(853);
				match(CLOSE_PAR_SYMBOL);
				setState(855);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(854);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(857);
				((SumExprContext)_localctx).name = match(VARIANCE_SYMBOL);
				setState(858);
				match(OPEN_PAR_SYMBOL);
				setState(859);
				inSumExpr();
				setState(860);
				match(CLOSE_PAR_SYMBOL);
				setState(862);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(861);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(864);
				((SumExprContext)_localctx).name = match(SUM_SYMBOL);
				setState(865);
				match(OPEN_PAR_SYMBOL);
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(866);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(869);
				inSumExpr();
				setState(870);
				match(CLOSE_PAR_SYMBOL);
				setState(872);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(871);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(874);
				((SumExprContext)_localctx).name = match(GROUP_CONCAT_SYMBOL);
				setState(875);
				match(OPEN_PAR_SYMBOL);
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(876);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(879);
				exprList();
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_SYMBOL) {
					{
					setState(880);
					orderClause();
					}
				}

				setState(885);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEPARATOR_SYMBOL) {
					{
					setState(883);
					match(SEPARATOR_SYMBOL);
					setState(884);
					textString();
					}
				}

				setState(887);
				match(CLOSE_PAR_SYMBOL);
				setState(889);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(888);
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
		public TerminalNode GROUPING_SYMBOL() { return getToken(HDBViewParser.GROUPING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public GroupingOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitGroupingOperation(this);
		}
	}

	public final GroupingOperationContext groupingOperation() throws RecognitionException {
		GroupingOperationContext _localctx = new GroupingOperationContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_groupingOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
			match(GROUPING_SYMBOL);
			setState(894);
			match(OPEN_PAR_SYMBOL);
			setState(895);
			exprList();
			setState(896);
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
		public TerminalNode ROW_NUMBER_SYMBOL() { return getToken(HDBViewParser.ROW_NUMBER_SYMBOL, 0); }
		public TerminalNode RANK_SYMBOL() { return getToken(HDBViewParser.RANK_SYMBOL, 0); }
		public TerminalNode DENSE_RANK_SYMBOL() { return getToken(HDBViewParser.DENSE_RANK_SYMBOL, 0); }
		public TerminalNode NTILE_SYMBOL() { return getToken(HDBViewParser.NTILE_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext simpleExprWithParentheses() {
			return getRuleContext(SimpleExprWithParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode LEAD_SYMBOL() { return getToken(HDBViewParser.LEAD_SYMBOL, 0); }
		public TerminalNode LAG_SYMBOL() { return getToken(HDBViewParser.LAG_SYMBOL, 0); }
		public LeadLagInfoContext leadLagInfo() {
			return getRuleContext(LeadLagInfoContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode FIRST_VALUE_SYMBOL() { return getToken(HDBViewParser.FIRST_VALUE_SYMBOL, 0); }
		public TerminalNode LAST_VALUE_SYMBOL() { return getToken(HDBViewParser.LAST_VALUE_SYMBOL, 0); }
		public WindowFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowFunctionCall(this);
		}
	}

	public final WindowFunctionCallContext windowFunctionCall() throws RecognitionException {
		WindowFunctionCallContext _localctx = new WindowFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_windowFunctionCall);
		int _la;
		try {
			setState(919);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DENSE_RANK_SYMBOL:
			case RANK_SYMBOL:
			case ROW_NUMBER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(898);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DENSE_RANK_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(899);
				parentheses();
				setState(900);
				windowingClause();
				}
				break;
			case NTILE_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(902);
				match(NTILE_SYMBOL);
				setState(903);
				simpleExprWithParentheses();
				setState(904);
				windowingClause();
				}
				break;
			case LAG_SYMBOL:
			case LEAD_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(906);
				_la = _input.LA(1);
				if ( !(_la==LAG_SYMBOL || _la==LEAD_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(907);
				match(OPEN_PAR_SYMBOL);
				setState(908);
				expr(0);
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(909);
					leadLagInfo();
					}
				}

				setState(912);
				match(CLOSE_PAR_SYMBOL);
				setState(913);
				windowingClause();
				}
				break;
			case FIRST_VALUE_SYMBOL:
			case LAST_VALUE_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(915);
				_la = _input.LA(1);
				if ( !(_la==FIRST_VALUE_SYMBOL || _la==LAST_VALUE_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(916);
				exprWithParentheses();
				setState(917);
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
		public TerminalNode OVER_SYMBOL() { return getToken(HDBViewParser.OVER_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowingClause(this);
		}
	}

	public final WindowingClauseContext windowingClause() throws RecognitionException {
		WindowingClauseContext _localctx = new WindowingClauseContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_windowingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			match(OVER_SYMBOL);
			setState(924);
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
				setState(922);
				windowName();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(923);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(HDBViewParser.PARAM_MARKER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeadLagInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leadLagInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLeadLagInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLeadLagInfo(this);
		}
	}

	public final LeadLagInfoContext leadLagInfo() throws RecognitionException {
		LeadLagInfoContext _localctx = new LeadLagInfoContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_leadLagInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			match(COMMA_SYMBOL);
			setState(929);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
				{
				setState(927);
				ulonglong_number();
				}
				break;
			case PARAM_MARKER:
				{
				setState(928);
				match(PARAM_MARKER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL) {
				{
				setState(931);
				match(COMMA_SYMBOL);
				setState(932);
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
		public TerminalNode ALL_SYMBOL() { return getToken(HDBViewParser.ALL_SYMBOL, 0); }
		public InSumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inSumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterInSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitInSumExpr(this);
		}
	}

	public final InSumExprContext inSumExpr() throws RecognitionException {
		InSumExprContext _localctx = new InSumExprContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_inSumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL_SYMBOL) {
				{
				setState(935);
				match(ALL_SYMBOL);
				}
			}

			setState(938);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identListArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentListArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentListArg(this);
		}
	}

	public final IdentListArgContext identListArg() throws RecognitionException {
		IdentListArgContext _localctx = new IdentListArgContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_identListArg);
		try {
			setState(945);
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
				setState(940);
				identList();
				}
				break;
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(941);
				match(OPEN_PAR_SYMBOL);
				setState(942);
				identList();
				setState(943);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public IdentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentList(this);
		}
	}

	public final IdentListContext identList() throws RecognitionException {
		IdentListContext _localctx = new IdentListContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_identList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			simpleIdentifier();
			setState(952);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(948);
				match(COMMA_SYMBOL);
				setState(949);
				simpleIdentifier();
				}
				}
				setState(954);
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
		public TerminalNode CURRENT_USER_SYMBOL() { return getToken(HDBViewParser.CURRENT_USER_SYMBOL, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode INTERVAL_SYMBOL() { return getToken(HDBViewParser.INTERVAL_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public TerminalNode LEFT_SYMBOL() { return getToken(HDBViewParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(HDBViewParser.RIGHT_SYMBOL, 0); }
		public TerminalNode NOW_SYMBOL() { return getToken(HDBViewParser.NOW_SYMBOL, 0); }
		public TimeFunctionParametersContext timeFunctionParameters() {
			return getRuleContext(TimeFunctionParametersContext.class,0);
		}
		public SubstringFunctionContext substringFunction() {
			return getRuleContext(SubstringFunctionContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode ASCII_SYMBOL() { return getToken(HDBViewParser.ASCII_SYMBOL, 0); }
		public RuntimeFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runtimeFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterRuntimeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitRuntimeFunctionCall(this);
		}
	}

	public final RuntimeFunctionCallContext runtimeFunctionCall() throws RecognitionException {
		RuntimeFunctionCallContext _localctx = new RuntimeFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_runtimeFunctionCall);
		int _la;
		try {
			setState(991);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_USER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(955);
				((RuntimeFunctionCallContext)_localctx).name = match(CURRENT_USER_SYMBOL);
				setState(957);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(956);
					parentheses();
					}
					break;
				}
				}
				break;
			case INTERVAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(959);
				((RuntimeFunctionCallContext)_localctx).name = match(INTERVAL_SYMBOL);
				setState(960);
				match(OPEN_PAR_SYMBOL);
				setState(961);
				expr(0);
				setState(964); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(962);
					match(COMMA_SYMBOL);
					setState(963);
					expr(0);
					}
					}
					setState(966); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA_SYMBOL );
				setState(968);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case LEFT_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(970);
				((RuntimeFunctionCallContext)_localctx).name = match(LEFT_SYMBOL);
				setState(971);
				match(OPEN_PAR_SYMBOL);
				setState(972);
				expr(0);
				setState(973);
				match(COMMA_SYMBOL);
				setState(974);
				expr(0);
				setState(975);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case RIGHT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(977);
				((RuntimeFunctionCallContext)_localctx).name = match(RIGHT_SYMBOL);
				setState(978);
				match(OPEN_PAR_SYMBOL);
				setState(979);
				expr(0);
				setState(980);
				match(COMMA_SYMBOL);
				setState(981);
				expr(0);
				setState(982);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case NOW_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(984);
				((RuntimeFunctionCallContext)_localctx).name = match(NOW_SYMBOL);
				setState(986);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(985);
					timeFunctionParameters();
					}
					break;
				}
				}
				break;
			case SUBSTRING_SYMBOL:
				enterOuterAlt(_localctx, 6);
				{
				setState(988);
				substringFunction();
				}
				break;
			case ASCII_SYMBOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(989);
				((RuntimeFunctionCallContext)_localctx).name = match(ASCII_SYMBOL);
				setState(990);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public FractionalPrecisionContext fractionalPrecision() {
			return getRuleContext(FractionalPrecisionContext.class,0);
		}
		public TimeFunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeFunctionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTimeFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTimeFunctionParameters(this);
		}
	}

	public final TimeFunctionParametersContext timeFunctionParameters() throws RecognitionException {
		TimeFunctionParametersContext _localctx = new TimeFunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_timeFunctionParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(993);
			match(OPEN_PAR_SYMBOL);
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT_NUMBER) {
				{
				setState(994);
				fractionalPrecision();
				}
			}

			setState(997);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public FractionalPrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fractionalPrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFractionalPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFractionalPrecision(this);
		}
	}

	public final FractionalPrecisionContext fractionalPrecision() throws RecognitionException {
		FractionalPrecisionContext _localctx = new FractionalPrecisionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_fractionalPrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(999);
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
		public TerminalNode SUBSTRING_SYMBOL() { return getToken(HDBViewParser.SUBSTRING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public TerminalNode FROM_SYMBOL() { return getToken(HDBViewParser.FROM_SYMBOL, 0); }
		public TerminalNode FOR_SYMBOL() { return getToken(HDBViewParser.FOR_SYMBOL, 0); }
		public SubstringFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substringFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSubstringFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSubstringFunction(this);
		}
	}

	public final SubstringFunctionContext substringFunction() throws RecognitionException {
		SubstringFunctionContext _localctx = new SubstringFunctionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_substringFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1001);
			match(SUBSTRING_SYMBOL);
			setState(1002);
			match(OPEN_PAR_SYMBOL);
			setState(1003);
			expr(0);
			setState(1016);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA_SYMBOL:
				{
				setState(1004);
				match(COMMA_SYMBOL);
				setState(1005);
				expr(0);
				setState(1008);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(1006);
					match(COMMA_SYMBOL);
					setState(1007);
					expr(0);
					}
				}

				}
				break;
			case FROM_SYMBOL:
				{
				setState(1010);
				match(FROM_SYMBOL);
				setState(1011);
				expr(0);
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL) {
					{
					setState(1012);
					match(FOR_SYMBOL);
					setState(1013);
					expr(0);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1018);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_functionCall);
		int _la;
		try {
			setState(1034);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1020);
				pureIdentifier();
				setState(1021);
				match(OPEN_PAR_SYMBOL);
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERVAL_SYMBOL - 64)) | (1L << (CURRENT_SYMBOL - 64)) | (1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (NULL_SYMBOL - 129)) | (1L << (OFFSET_SYMBOL - 129)) | (1L << (TIMESTAMP_SYMBOL - 129)) | (1L << (TIME_SYMBOL - 129)) | (1L << (TRUE_SYMBOL - 129)) | (1L << (UNKNOWN_SYMBOL - 129)) | (1L << (NOWAIT_SYMBOL - 129)) | (1L << (GROUPING_SYMBOL - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (NCHAR_TEXT - 129)) | (1L << (DOUBLE_QUOTED_TEXT - 129)) | (1L << (SINGLE_QUOTED_TEXT - 129)))) != 0)) {
					{
					setState(1022);
					udfExprList();
					}
				}

				setState(1025);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1027);
				qualifiedIdentifier();
				setState(1028);
				match(OPEN_PAR_SYMBOL);
				setState(1030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERVAL_SYMBOL - 64)) | (1L << (CURRENT_SYMBOL - 64)) | (1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (NULL_SYMBOL - 129)) | (1L << (OFFSET_SYMBOL - 129)) | (1L << (TIMESTAMP_SYMBOL - 129)) | (1L << (TIME_SYMBOL - 129)) | (1L << (TRUE_SYMBOL - 129)) | (1L << (UNKNOWN_SYMBOL - 129)) | (1L << (NOWAIT_SYMBOL - 129)) | (1L << (GROUPING_SYMBOL - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (NCHAR_TEXT - 129)) | (1L << (DOUBLE_QUOTED_TEXT - 129)) | (1L << (SINGLE_QUOTED_TEXT - 129)))) != 0)) {
					{
					setState(1029);
					exprList();
					}
				}

				setState(1032);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public UdfExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udfExprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterUdfExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitUdfExprList(this);
		}
	}

	public final UdfExprListContext udfExprList() throws RecognitionException {
		UdfExprListContext _localctx = new UdfExprListContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_udfExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			udfExpr();
			setState(1041);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1037);
				match(COMMA_SYMBOL);
				setState(1038);
				udfExpr();
				}
				}
				setState(1043);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterUdfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitUdfExpr(this);
		}
	}

	public final UdfExprContext udfExpr() throws RecognitionException {
		UdfExprContext _localctx = new UdfExprContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_udfExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			expr(0);
			setState(1046);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (COALESCE_SYMBOL - 39)) | (1L << (NULLS_SYMBOL - 39)) | (1L << (PRECEDING_SYMBOL - 39)) | (1L << (UNBOUNDED_SYMBOL - 39)) | (1L << (CURRENT_SYMBOL - 39)) | (1L << (FOLLOWING_SYMBOL - 39)) | (1L << (EXCLUDE_SYMBOL - 39)) | (1L << (TIES_SYMBOL - 39)) | (1L << (OTHERS_SYMBOL - 39)) | (1L << (AVG_SYMBOL - 39)) | (1L << (MODE_SYMBOL - 39)) | (1L << (SHARE_SYMBOL - 39)) | (1L << (SKIP_SYMBOL - 39)) | (1L << (LOCKED_SYMBOL - 39)) | (1L << (ANY_SYMBOL - 39)) | (1L << (AS_SYMBOL - 39)) | (1L << (AT_SYMBOL - 39)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (DATE_SYMBOL - 107)) | (1L << (ESCAPE_SYMBOL - 107)) | (1L << (FIRST_SYMBOL - 107)) | (1L << (FULL_SYMBOL - 107)) | (1L << (LAST_SYMBOL - 107)) | (1L << (OFFSET_SYMBOL - 107)) | (1L << (TIMESTAMP_SYMBOL - 107)) | (1L << (TIME_SYMBOL - 107)) | (1L << (UNKNOWN_SYMBOL - 107)) | (1L << (NOWAIT_SYMBOL - 107)) | (1L << (IDENTIFIER - 107)) | (1L << (DOUBLE_QUOTED_TEXT - 107)) | (1L << (SINGLE_QUOTED_TEXT - 107)))) != 0)) {
				{
				setState(1045);
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
		public TerminalNode WHEN_SYMBOL() { return getToken(HDBViewParser.WHEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWhenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWhenExpression(this);
		}
	}

	public final WhenExpressionContext whenExpression() throws RecognitionException {
		WhenExpressionContext _localctx = new WhenExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_whenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			match(WHEN_SYMBOL);
			setState(1049);
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
		public TerminalNode THEN_SYMBOL() { return getToken(HDBViewParser.THEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterThenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitThenExpression(this);
		}
	}

	public final ThenExpressionContext thenExpression() throws RecognitionException {
		ThenExpressionContext _localctx = new ThenExpressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_thenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1051);
			match(THEN_SYMBOL);
			setState(1052);
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
		public TerminalNode ELSE_SYMBOL() { return getToken(HDBViewParser.ELSE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterElseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitElseExpression(this);
		}
	}

	public final ElseExpressionContext elseExpression() throws RecognitionException {
		ElseExpressionContext _localctx = new ElseExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_elseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
			match(ELSE_SYMBOL);
			setState(1055);
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
		public TerminalNode DATE_SYMBOL() { return getToken(HDBViewParser.DATE_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBViewParser.TIME_SYMBOL, 0); }
		public TypeDatetimePrecisionContext typeDatetimePrecision() {
			return getRuleContext(TypeDatetimePrecisionContext.class,0);
		}
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterCastType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitCastType(this);
		}
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_castType);
		int _la;
		try {
			setState(1062);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1057);
				match(DATE_SYMBOL);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1058);
				match(TIME_SYMBOL);
				setState(1060);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR_SYMBOL) {
					{
					setState(1059);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			expr(0);
			setState(1069);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1065);
				match(COMMA_SYMBOL);
				setState(1066);
				expr(0);
				}
				}
				setState(1071);
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
		public TerminalNode NOT_SYMBOL() { return getToken(HDBViewParser.NOT_SYMBOL, 0); }
		public TerminalNode NOT2_SYMBOL() { return getToken(HDBViewParser.NOT2_SYMBOL, 0); }
		public NotRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterNotRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitNotRule(this);
		}
	}

	public final NotRuleContext notRule() throws RecognitionException {
		NotRuleContext _localctx = new NotRuleContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_notRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
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
		public TerminalNode NOT2_SYMBOL() { return getToken(HDBViewParser.NOT2_SYMBOL, 0); }
		public Not2RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not2Rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterNot2Rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitNot2Rule(this);
		}
	}

	public final Not2RuleContext not2Rule() throws RecognitionException {
		Not2RuleContext _localctx = new Not2RuleContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_not2Rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1074);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprListWithParentheses(this);
		}
	}

	public final ExprListWithParenthesesContext exprListWithParentheses() throws RecognitionException {
		ExprListWithParenthesesContext _localctx = new ExprListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_exprListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			match(OPEN_PAR_SYMBOL);
			setState(1077);
			exprList();
			setState(1078);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitExprWithParentheses(this);
		}
	}

	public final ExprWithParenthesesContext exprWithParentheses() throws RecognitionException {
		ExprWithParenthesesContext _localctx = new ExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_exprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			match(OPEN_PAR_SYMBOL);
			setState(1081);
			expr(0);
			setState(1082);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleExprWithParentheses(this);
		}
	}

	public final SimpleExprWithParenthesesContext simpleExprWithParentheses() throws RecognitionException {
		SimpleExprWithParenthesesContext _localctx = new SimpleExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_simpleExprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			match(OPEN_PAR_SYMBOL);
			setState(1085);
			simpleExpr(0);
			setState(1086);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public OrderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterOrderList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitOrderList(this);
		}
	}

	public final OrderListContext orderList() throws RecognitionException {
		OrderListContext _localctx = new OrderListContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_orderList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			orderExpression();
			setState(1093);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1089);
					match(COMMA_SYMBOL);
					setState(1090);
					orderExpression();
					}
					} 
				}
				setState(1095);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterOrderExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitOrderExpression(this);
		}
	}

	public final OrderExpressionContext orderExpression() throws RecognitionException {
		OrderExpressionContext _localctx = new OrderExpressionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_orderExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			expr(0);
			setState(1098);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1097);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public GroupListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterGroupList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitGroupList(this);
		}
	}

	public final GroupListContext groupList() throws RecognitionException {
		GroupListContext _localctx = new GroupListContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_groupList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1100);
			groupingExpression();
			setState(1105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1101);
				match(COMMA_SYMBOL);
				setState(1102);
				groupingExpression();
				}
				}
				setState(1107);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterGroupingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitGroupingExpression(this);
		}
	}

	public final GroupingExpressionContext groupingExpression() throws RecognitionException {
		GroupingExpressionContext _localctx = new GroupingExpressionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_groupingExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
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
		public TerminalNode IDENTIFIER() { return getToken(HDBViewParser.IDENTIFIER, 0); }
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(HDBViewParser.DOUBLE_QUOTED_TEXT, 0); }
		public PureIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPureIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPureIdentifier(this);
		}
	}

	public final PureIdentifierContext pureIdentifier() throws RecognitionException {
		PureIdentifierContext _localctx = new PureIdentifierContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_pureIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1110);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==DOUBLE_QUOTED_TEXT) ) {
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_identifier);
		try {
			setState(1114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1112);
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
				setState(1113);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1116);
			identifier();
			setState(1121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1117);
				match(COMMA_SYMBOL);
				setState(1118);
				identifier();
				}
				}
				setState(1123);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentifierListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentifierListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentifierListWithParentheses(this);
		}
	}

	public final IdentifierListWithParenthesesContext identifierListWithParentheses() throws RecognitionException {
		IdentifierListWithParenthesesContext _localctx = new IdentifierListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_identifierListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1124);
			match(OPEN_PAR_SYMBOL);
			setState(1125);
			identifierList();
			setState(1126);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterQualifiedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitQualifiedIdentifier(this);
		}
	}

	public final QualifiedIdentifierContext qualifiedIdentifier() throws RecognitionException {
		QualifiedIdentifierContext _localctx = new QualifiedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_qualifiedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			identifier();
			setState(1130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				{
				setState(1129);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSimpleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSimpleIdentifier(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_simpleIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			identifier();
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT_SYMBOL) {
				{
				setState(1133);
				dotIdentifier();
				setState(1135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1134);
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
		public TerminalNode DOT_SYMBOL() { return getToken(HDBViewParser.DOT_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterDotIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitDotIdentifier(this);
		}
	}

	public final DotIdentifierContext dotIdentifier() throws RecognitionException {
		DotIdentifierContext _localctx = new DotIdentifierContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_dotIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			match(DOT_SYMBOL);
			setState(1140);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBViewParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBViewParser.FLOAT_NUMBER, 0); }
		public Ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterUlong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitUlong_number(this);
		}
	}

	public final Ulong_numberContext ulong_number() throws RecognitionException {
		Ulong_numberContext _localctx = new Ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public Real_ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterReal_ulong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitReal_ulong_number(this);
		}
	}

	public final Real_ulong_numberContext real_ulong_number() throws RecognitionException {
		Real_ulong_numberContext _localctx = new Real_ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_real_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBViewParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBViewParser.FLOAT_NUMBER, 0); }
		public Ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterUlonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitUlonglong_number(this);
		}
	}

	public final Ulonglong_numberContext ulonglong_number() throws RecognitionException {
		Ulonglong_numberContext _localctx = new Ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1146);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public Real_ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterReal_ulonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitReal_ulonglong_number(this);
		}
	}

	public final Real_ulonglong_numberContext real_ulonglong_number() throws RecognitionException {
		Real_ulonglong_numberContext _localctx = new Real_ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_real_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1148);
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
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(HDBViewParser.BIN_NUMBER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_literal);
		int _la;
		try {
			setState(1156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1150);
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
				setState(1151);
				numLiteral();
				}
				break;
			case DATE_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1152);
				temporalLiteral();
				}
				break;
			case NULL2_SYMBOL:
			case NULL_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1153);
				nullLiteral();
				}
				break;
			case FALSE_SYMBOL:
			case TRUE_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1154);
				boolLiteral();
				}
				break;
			case HEX_NUMBER:
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1155);
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
		public TerminalNode PLUS_OPERATOR() { return getToken(HDBViewParser.PLUS_OPERATOR, 0); }
		public Ulong_numberContext ulong_number() {
			return getRuleContext(Ulong_numberContext.class,0);
		}
		public TerminalNode MINUS_OPERATOR() { return getToken(HDBViewParser.MINUS_OPERATOR, 0); }
		public SignedLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSignedLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSignedLiteral(this);
		}
	}

	public final SignedLiteralContext signedLiteral() throws RecognitionException {
		SignedLiteralContext _localctx = new SignedLiteralContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_signedLiteral);
		try {
			setState(1163);
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
				setState(1158);
				literal();
				}
				break;
			case PLUS_OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1159);
				match(PLUS_OPERATOR);
				setState(1160);
				ulong_number();
				}
				break;
			case MINUS_OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1161);
				match(MINUS_OPERATOR);
				setState(1162);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public List<TextStringContext> textString() {
			return getRuleContexts(TextStringContext.class);
		}
		public TextStringContext textString(int i) {
			return getRuleContext(TextStringContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterStringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitStringList(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_stringList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			match(OPEN_PAR_SYMBOL);
			setState(1166);
			textString();
			setState(1171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1167);
				match(COMMA_SYMBOL);
				setState(1168);
				textString();
				}
				}
				setState(1173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1174);
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
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBViewParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(HDBViewParser.DOUBLE_QUOTED_TEXT, 0); }
		public TextStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextStringLiteral(this);
		}
	}

	public final TextStringLiteralContext textStringLiteral() throws RecognitionException {
		TextStringLiteralContext _localctx = new TextStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_textStringLiteral);
		try {
			setState(1178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1176);
				((TextStringLiteralContext)_localctx).value = match(SINGLE_QUOTED_TEXT);
				}
				break;
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1177);
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
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(HDBViewParser.BIN_NUMBER, 0); }
		public TextStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextString(this);
		}
	}

	public final TextStringContext textString() throws RecognitionException {
		TextStringContext _localctx = new TextStringContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_textString);
		try {
			setState(1183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1180);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1181);
				match(HEX_NUMBER);
				}
				break;
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1182);
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
		public TerminalNode HEX_NUMBER() { return getToken(HDBViewParser.HEX_NUMBER, 0); }
		public TextStringHashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringHash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextStringHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextStringHash(this);
		}
	}

	public final TextStringHashContext textStringHash() throws RecognitionException {
		TextStringHashContext _localctx = new TextStringHashContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_textStringHash);
		try {
			setState(1187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1185);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1186);
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
		public TerminalNode NCHAR_TEXT() { return getToken(HDBViewParser.NCHAR_TEXT, 0); }
		public TextLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextLiteral(this);
		}
	}

	public final TextLiteralContext textLiteral() throws RecognitionException {
		TextLiteralContext _localctx = new TextLiteralContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_textLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				{
				setState(1189);
				textStringLiteral();
				}
				break;
			case NCHAR_TEXT:
				{
				setState(1190);
				match(NCHAR_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1193);
					textStringLiteral();
					}
					} 
				}
				setState(1198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextStringNoLinebreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextStringNoLinebreak(this);
		}
	}

	public final TextStringNoLinebreakContext textStringNoLinebreak() throws RecognitionException {
		TextStringNoLinebreakContext _localctx = new TextStringNoLinebreakContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_textStringNoLinebreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public TextStringLiteralListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteralList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextStringLiteralList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextStringLiteralList(this);
		}
	}

	public final TextStringLiteralListContext textStringLiteralList() throws RecognitionException {
		TextStringLiteralListContext _localctx = new TextStringLiteralListContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_textStringLiteralList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			textStringLiteral();
			setState(1206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1202);
				match(COMMA_SYMBOL);
				setState(1203);
				textStringLiteral();
				}
				}
				setState(1208);
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
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(HDBViewParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(HDBViewParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBViewParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(HDBViewParser.FLOAT_NUMBER, 0); }
		public NumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterNumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitNumLiteral(this);
		}
	}

	public final NumLiteralContext numLiteral() throws RecognitionException {
		NumLiteralContext _localctx = new NumLiteralContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1209);
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
		public TerminalNode TRUE_SYMBOL() { return getToken(HDBViewParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(HDBViewParser.FALSE_SYMBOL, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitBoolLiteral(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1211);
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
		public TerminalNode NULL_SYMBOL() { return getToken(HDBViewParser.NULL_SYMBOL, 0); }
		public TerminalNode NULL2_SYMBOL() { return getToken(HDBViewParser.NULL2_SYMBOL, 0); }
		public NullLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitNullLiteral(this);
		}
	}

	public final NullLiteralContext nullLiteral() throws RecognitionException {
		NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_nullLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1213);
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
		public TerminalNode DATE_SYMBOL() { return getToken(HDBViewParser.DATE_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBViewParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBViewParser.TIME_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(HDBViewParser.TIMESTAMP_SYMBOL, 0); }
		public TemporalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTemporalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTemporalLiteral(this);
		}
	}

	public final TemporalLiteralContext temporalLiteral() throws RecognitionException {
		TemporalLiteralContext _localctx = new TemporalLiteralContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_temporalLiteral);
		try {
			setState(1221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1215);
				match(DATE_SYMBOL);
				setState(1216);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1217);
				match(TIME_SYMBOL);
				setState(1218);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIMESTAMP_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1219);
				match(TIMESTAMP_SYMBOL);
				setState(1220);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFloatOptions(this);
		}
	}

	public final FloatOptionsContext floatOptions() throws RecognitionException {
		FloatOptionsContext _localctx = new FloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_floatOptions);
		try {
			setState(1225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1223);
				fieldLength();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1224);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterStandardFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitStandardFloatOptions(this);
		}
	}

	public final StandardFloatOptionsContext standardFloatOptions() throws RecognitionException {
		StandardFloatOptionsContext _localctx = new StandardFloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_standardFloatOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1227);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public List<TerminalNode> INT_NUMBER() { return getTokens(HDBViewParser.INT_NUMBER); }
		public TerminalNode INT_NUMBER(int i) {
			return getToken(HDBViewParser.INT_NUMBER, i);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(HDBViewParser.COMMA_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitPrecision(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1229);
			match(OPEN_PAR_SYMBOL);
			setState(1230);
			match(INT_NUMBER);
			setState(1231);
			match(COMMA_SYMBOL);
			setState(1232);
			match(INT_NUMBER);
			setState(1233);
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
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(HDBViewParser.SINGLE_QUOTED_TEXT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TextOrIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textOrIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTextOrIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTextOrIdentifier(this);
		}
	}

	public final TextOrIdentifierContext textOrIdentifier() throws RecognitionException {
		TextOrIdentifierContext _localctx = new TextOrIdentifierContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_textOrIdentifier);
		try {
			setState(1237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1235);
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
				setState(1236);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterSizeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitSizeNumber(this);
		}
	}

	public final SizeNumberContext sizeNumber() throws RecognitionException {
		SizeNumberContext _localctx = new SizeNumberContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_sizeNumber);
		try {
			setState(1241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1239);
				real_ulonglong_number();
				}
				break;
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1240);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitParentheses(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			match(OPEN_PAR_SYMBOL);
			setState(1244);
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
		public TerminalNode EQUAL_OPERATOR() { return getToken(HDBViewParser.EQUAL_OPERATOR, 0); }
		public TerminalNode ASSIGN_OPERATOR() { return getToken(HDBViewParser.ASSIGN_OPERATOR, 0); }
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_equal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentifierKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentifierKeyword(this);
		}
	}

	public final IdentifierKeywordContext identifierKeyword() throws RecognitionException {
		IdentifierKeywordContext _localctx = new IdentifierKeywordContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_identifierKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1248);
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
		public TerminalNode ANY_SYMBOL() { return getToken(HDBViewParser.ANY_SYMBOL, 0); }
		public TerminalNode AT_SYMBOL() { return getToken(HDBViewParser.AT_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(HDBViewParser.AVG_SYMBOL, 0); }
		public TerminalNode COALESCE_SYMBOL() { return getToken(HDBViewParser.COALESCE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(HDBViewParser.CURRENT_SYMBOL, 0); }
		public TerminalNode DATE_SYMBOL() { return getToken(HDBViewParser.DATE_SYMBOL, 0); }
		public TerminalNode ESCAPE_SYMBOL() { return getToken(HDBViewParser.ESCAPE_SYMBOL, 0); }
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(HDBViewParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode FIRST_SYMBOL() { return getToken(HDBViewParser.FIRST_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(HDBViewParser.FOLLOWING_SYMBOL, 0); }
		public TerminalNode FULL_SYMBOL() { return getToken(HDBViewParser.FULL_SYMBOL, 0); }
		public TerminalNode LAST_SYMBOL() { return getToken(HDBViewParser.LAST_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(HDBViewParser.LOCKED_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(HDBViewParser.MODE_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(HDBViewParser.NOWAIT_SYMBOL, 0); }
		public TerminalNode NULLS_SYMBOL() { return getToken(HDBViewParser.NULLS_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(HDBViewParser.OFFSET_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(HDBViewParser.OTHERS_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(HDBViewParser.PRECEDING_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(HDBViewParser.SHARE_SYMBOL, 0); }
		public TerminalNode SKIP_SYMBOL() { return getToken(HDBViewParser.SKIP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(HDBViewParser.TIES_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(HDBViewParser.TIMESTAMP_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(HDBViewParser.TIME_SYMBOL, 0); }
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(HDBViewParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(HDBViewParser.UNKNOWN_SYMBOL, 0); }
		public IdentifierKeywordsUnambiguousContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierKeywordsUnambiguous; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterIdentifierKeywordsUnambiguous(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitIdentifierKeywordsUnambiguous(this);
		}
	}

	public final IdentifierKeywordsUnambiguousContext identifierKeywordsUnambiguous() throws RecognitionException {
		IdentifierKeywordsUnambiguousContext _localctx = new IdentifierKeywordsUnambiguousContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_identifierKeywordsUnambiguous);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1250);
			_la = _input.LA(1);
			if ( !(((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (COALESCE_SYMBOL - 39)) | (1L << (NULLS_SYMBOL - 39)) | (1L << (PRECEDING_SYMBOL - 39)) | (1L << (UNBOUNDED_SYMBOL - 39)) | (1L << (CURRENT_SYMBOL - 39)) | (1L << (FOLLOWING_SYMBOL - 39)) | (1L << (EXCLUDE_SYMBOL - 39)) | (1L << (TIES_SYMBOL - 39)) | (1L << (OTHERS_SYMBOL - 39)) | (1L << (AVG_SYMBOL - 39)) | (1L << (MODE_SYMBOL - 39)) | (1L << (SHARE_SYMBOL - 39)) | (1L << (SKIP_SYMBOL - 39)) | (1L << (LOCKED_SYMBOL - 39)) | (1L << (ANY_SYMBOL - 39)) | (1L << (AT_SYMBOL - 39)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (DATE_SYMBOL - 107)) | (1L << (ESCAPE_SYMBOL - 107)) | (1L << (FIRST_SYMBOL - 107)) | (1L << (FULL_SYMBOL - 107)) | (1L << (LAST_SYMBOL - 107)) | (1L << (OFFSET_SYMBOL - 107)) | (1L << (TIMESTAMP_SYMBOL - 107)) | (1L << (TIME_SYMBOL - 107)) | (1L << (UNKNOWN_SYMBOL - 107)) | (1L << (NOWAIT_SYMBOL - 107)))) != 0)) ) {
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterWindowName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitWindowName(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1252);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFieldIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFieldIdentifier(this);
		}
	}

	public final FieldIdentifierContext fieldIdentifier() throws RecognitionException {
		FieldIdentifierContext _localctx = new FieldIdentifierContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_fieldIdentifier);
		try {
			setState(1259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1254);
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
				setState(1255);
				qualifiedIdentifier();
				setState(1257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
				case 1:
					{
					setState(1256);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1261);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterColumnInternalRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitColumnInternalRef(this);
		}
	}

	public final ColumnInternalRefContext columnInternalRef() throws RecognitionException {
		ColumnInternalRefContext _localctx = new ColumnInternalRefContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_columnInternalRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1263);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public List<ColumnInternalRefContext> columnInternalRef() {
			return getRuleContexts(ColumnInternalRefContext.class);
		}
		public ColumnInternalRefContext columnInternalRef(int i) {
			return getRuleContext(ColumnInternalRefContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public ColumnInternalRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnInternalRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterColumnInternalRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitColumnInternalRefList(this);
		}
	}

	public final ColumnInternalRefListContext columnInternalRefList() throws RecognitionException {
		ColumnInternalRefListContext _localctx = new ColumnInternalRefListContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_columnInternalRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1265);
			match(OPEN_PAR_SYMBOL);
			setState(1266);
			columnInternalRef();
			setState(1271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1267);
				match(COMMA_SYMBOL);
				setState(1268);
				columnInternalRef();
				}
				}
				setState(1273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1274);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitColumnRef(this);
		}
	}

	public final ColumnRefContext columnRef() throws RecognitionException {
		ColumnRefContext _localctx = new ColumnRefContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
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
		public TerminalNode DOT_SYMBOL() { return getToken(HDBViewParser.DOT_SYMBOL, 0); }
		public TerminalNode MULT_OPERATOR() { return getToken(HDBViewParser.MULT_OPERATOR, 0); }
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public TableRefWithWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRefWithWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableRefWithWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableRefWithWildcard(this);
		}
	}

	public final TableRefWithWildcardContext tableRefWithWildcard() throws RecognitionException {
		TableRefWithWildcardContext _localctx = new TableRefWithWildcardContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_tableRefWithWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1278);
			identifier();
			setState(1286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				{
				setState(1279);
				match(DOT_SYMBOL);
				setState(1280);
				match(MULT_OPERATOR);
				}
				break;
			case 2:
				{
				setState(1281);
				dotIdentifier();
				setState(1284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1282);
					match(DOT_SYMBOL);
					setState(1283);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(HDBViewParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(HDBViewParser.COMMA_SYMBOL, i);
		}
		public TableAliasRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAliasRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableAliasRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableAliasRefList(this);
		}
	}

	public final TableAliasRefListContext tableAliasRefList() throws RecognitionException {
		TableAliasRefListContext _localctx = new TableAliasRefListContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_tableAliasRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1288);
			tableRefWithWildcard();
			setState(1293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1289);
				match(COMMA_SYMBOL);
				setState(1290);
				tableRefWithWildcard();
				}
				}
				setState(1295);
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
		public List<TerminalNode> DOT_SYMBOL() { return getTokens(HDBViewParser.DOT_SYMBOL); }
		public TerminalNode DOT_SYMBOL(int i) {
			return getToken(HDBViewParser.DOT_SYMBOL, i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(HDBViewParser.MULT_OPERATOR, 0); }
		public TableWildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableWild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableWild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableWild(this);
		}
	}

	public final TableWildContext tableWild() throws RecognitionException {
		TableWildContext _localctx = new TableWildContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_tableWild);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1296);
			identifier();
			setState(1297);
			match(DOT_SYMBOL);
			setState(1301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (COALESCE_SYMBOL - 39)) | (1L << (NULLS_SYMBOL - 39)) | (1L << (PRECEDING_SYMBOL - 39)) | (1L << (UNBOUNDED_SYMBOL - 39)) | (1L << (CURRENT_SYMBOL - 39)) | (1L << (FOLLOWING_SYMBOL - 39)) | (1L << (EXCLUDE_SYMBOL - 39)) | (1L << (TIES_SYMBOL - 39)) | (1L << (OTHERS_SYMBOL - 39)) | (1L << (AVG_SYMBOL - 39)) | (1L << (MODE_SYMBOL - 39)) | (1L << (SHARE_SYMBOL - 39)) | (1L << (SKIP_SYMBOL - 39)) | (1L << (LOCKED_SYMBOL - 39)) | (1L << (ANY_SYMBOL - 39)) | (1L << (AT_SYMBOL - 39)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (DATE_SYMBOL - 107)) | (1L << (ESCAPE_SYMBOL - 107)) | (1L << (FIRST_SYMBOL - 107)) | (1L << (FULL_SYMBOL - 107)) | (1L << (LAST_SYMBOL - 107)) | (1L << (OFFSET_SYMBOL - 107)) | (1L << (TIMESTAMP_SYMBOL - 107)) | (1L << (TIME_SYMBOL - 107)) | (1L << (UNKNOWN_SYMBOL - 107)) | (1L << (NOWAIT_SYMBOL - 107)) | (1L << (IDENTIFIER - 107)) | (1L << (DOUBLE_QUOTED_TEXT - 107)))) != 0)) {
				{
				setState(1298);
				identifier();
				setState(1299);
				match(DOT_SYMBOL);
				}
			}

			setState(1303);
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
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTableRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTableRef(this);
		}
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_tableRef);
		try {
			setState(1307);
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
				setState(1305);
				qualifiedIdentifier();
				}
				break;
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1306);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public Real_ulonglong_numberContext real_ulonglong_number() {
			return getRuleContext(Real_ulonglong_numberContext.class,0);
		}
		public TerminalNode DECIMAL_NUMBER() { return getToken(HDBViewParser.DECIMAL_NUMBER, 0); }
		public FieldLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterFieldLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitFieldLength(this);
		}
	}

	public final FieldLengthContext fieldLength() throws RecognitionException {
		FieldLengthContext _localctx = new FieldLengthContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_fieldLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1309);
			match(OPEN_PAR_SYMBOL);
			setState(1312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				{
				setState(1310);
				real_ulonglong_number();
				}
				break;
			case DECIMAL_NUMBER:
				{
				setState(1311);
				match(DECIMAL_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1314);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(HDBViewParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(HDBViewParser.INT_NUMBER, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(HDBViewParser.CLOSE_PAR_SYMBOL, 0); }
		public TypeDatetimePrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDatetimePrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).enterTypeDatetimePrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBViewParserListener ) ((HDBViewParserListener)listener).exitTypeDatetimePrecision(this);
		}
	}

	public final TypeDatetimePrecisionContext typeDatetimePrecision() throws RecognitionException {
		TypeDatetimePrecisionContext _localctx = new TypeDatetimePrecisionContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_typeDatetimePrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1316);
			match(OPEN_PAR_SYMBOL);
			setState(1317);
			match(INT_NUMBER);
			setState(1318);
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
		case 3:
			return queryExpressionBody_sempred((QueryExpressionBodyContext)_localctx, predIndex);
		case 51:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 52:
			return boolPri_sempred((BoolPriContext)_localctx, predIndex);
		case 56:
			return bitExpr_sempred((BitExprContext)_localctx, predIndex);
		case 57:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u009e\u052b\4\2\t"+
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
		"\t\u0085\3\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3\u0112\n\3\3\4\5\4\u0115\n\4\3"+
		"\4\3\4\5\4\u0119\n\4\3\4\5\4\u011c\n\4\3\4\3\4\3\4\5\4\u0121\n\4\3\4\5"+
		"\4\u0124\n\4\5\4\u0126\n\4\3\4\5\4\u0129\n\4\3\4\3\4\3\4\5\4\u012e\n\4"+
		"\5\4\u0130\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u0137\n\5\3\5\3\5\5\5\u013b\n\5"+
		"\5\5\u013d\n\5\3\5\3\5\3\5\5\5\u0142\n\5\3\5\3\5\5\5\u0146\n\5\7\5\u0148"+
		"\n\5\f\5\16\5\u014b\13\5\3\6\3\6\3\6\5\6\u0150\n\6\3\6\3\6\3\7\3\7\7\7"+
		"\u0156\n\7\f\7\16\7\u0159\13\7\3\7\3\7\5\7\u015d\n\7\3\7\5\7\u0160\n\7"+
		"\3\7\5\7\u0163\n\7\3\7\5\7\u0166\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\5\f\u0175\n\f\3\r\3\r\5\r\u0179\n\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\7\17\u0182\n\17\f\17\16\17\u0185\13\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\5\22\u0190\n\22\3\22\3\22\3\22"+
		"\5\22\u0195\n\22\3\22\5\22\u0198\n\22\3\22\5\22\u019b\n\22\3\23\3\23\3"+
		"\23\5\23\u01a0\n\23\3\24\3\24\3\25\3\25\5\25\u01a6\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01b1\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01c0\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u01c9\n\31\3\32\3\32\5\32\u01cd\n\32\3\32\3"+
		"\32\3\32\7\32\u01d2\n\32\f\32\16\32\u01d5\13\32\3\33\3\33\5\33\u01d9\n"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\5\37\u01eb\n\37\3 \3 \3 \7 \u01f0\n \f \16 \u01f3\13 \3"+
		"!\3!\3\"\3\"\3\"\3\"\5\"\u01fb\n\"\3\"\5\"\u01fe\n\"\3\"\3\"\3\"\3\"\5"+
		"\"\u0204\n\"\3#\3#\3$\3$\3$\5$\u020b\n$\3%\3%\5%\u020f\n%\3%\3%\7%\u0213"+
		"\n%\f%\16%\u0216\13%\3&\3&\3&\5&\u021b\n&\5&\u021d\n&\3\'\5\'\u0220\n"+
		"\'\3\'\3\'\5\'\u0224\n\'\3(\3(\3(\3)\3)\7)\u022b\n)\f)\16)\u022e\13)\3"+
		"*\3*\7*\u0232\n*\f*\16*\u0235\13*\3+\3+\3+\3+\3+\3+\5+\u023d\n+\3+\3+"+
		"\3+\3+\3+\3+\5+\u0245\n+\5+\u0247\n+\3,\5,\u024a\n,\3,\3,\3-\3-\5-\u0250"+
		"\n-\3-\3-\3.\3.\3.\3.\5.\u0258\n.\3/\3/\5/\u025c\n/\3\60\3\60\3\60\5\60"+
		"\u0261\n\60\3\60\3\60\3\61\3\61\5\61\u0267\n\61\3\61\5\61\u026a\n\61\3"+
		"\61\3\61\3\61\5\61\u026f\n\61\3\61\5\61\u0272\n\61\5\61\u0274\n\61\3\62"+
		"\3\62\3\62\5\62\u0279\n\62\3\62\3\62\3\63\3\63\3\64\5\64\u0280\n\64\3"+
		"\64\3\64\3\65\3\65\3\65\3\65\5\65\u0288\n\65\3\65\5\65\u028b\n\65\3\65"+
		"\3\65\5\65\u028f\n\65\3\65\3\65\3\65\3\65\3\65\3\65\7\65\u0297\n\65\f"+
		"\65\16\65\u029a\13\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u02a2\n\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u02ae\n\66\f\66"+
		"\16\66\u02b1\13\66\3\67\3\67\38\38\58\u02b7\n8\38\58\u02ba\n8\39\39\3"+
		"9\39\39\39\59\u02c2\n9\39\39\39\39\39\39\39\39\39\59\u02cd\n9\59\u02cf"+
		"\n9\3:\3:\3:\3:\3:\3:\3:\3:\3:\7:\u02da\n:\f:\16:\u02dd\13:\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u02ee\n;\3;\3;\3;\3;\3;\5;\u02f5"+
		"\n;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u0306\n;\3;\3;\3;"+
		"\6;\u030b\n;\r;\16;\u030c\3;\5;\u0310\n;\3;\3;\5;\u0314\n;\3;\3;\3;\7"+
		";\u0319\n;\f;\16;\u031c\13;\3<\3<\3<\5<\u0321\n<\3<\3<\3<\5<\u0326\n<"+
		"\3<\3<\3<\5<\u032b\n<\3<\3<\3<\5<\u0330\n<\3<\3<\3<\5<\u0335\n<\3<\3<"+
		"\3<\3<\5<\u033b\n<\3<\3<\5<\u033f\n<\3<\3<\3<\5<\u0344\n<\3<\3<\3<\5<"+
		"\u0349\n<\3<\3<\3<\5<\u034e\n<\3<\3<\3<\5<\u0353\n<\3<\3<\3<\3<\3<\5<"+
		"\u035a\n<\3<\3<\3<\3<\3<\5<\u0361\n<\3<\3<\3<\5<\u0366\n<\3<\3<\3<\5<"+
		"\u036b\n<\3<\3<\3<\5<\u0370\n<\3<\3<\5<\u0374\n<\3<\3<\5<\u0378\n<\3<"+
		"\3<\5<\u037c\n<\5<\u037e\n<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\5>\u0391\n>\3>\3>\3>\3>\3>\3>\3>\5>\u039a\n>\3?\3?\3?\5?\u039f"+
		"\n?\3@\3@\3@\5@\u03a4\n@\3@\3@\5@\u03a8\n@\3A\5A\u03ab\nA\3A\3A\3B\3B"+
		"\3B\3B\3B\5B\u03b4\nB\3C\3C\3C\7C\u03b9\nC\fC\16C\u03bc\13C\3D\3D\5D\u03c0"+
		"\nD\3D\3D\3D\3D\3D\6D\u03c7\nD\rD\16D\u03c8\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3D\3D\3D\3D\3D\3D\3D\5D\u03dd\nD\3D\3D\3D\5D\u03e2\nD\3E\3E\5"+
		"E\u03e6\nE\3E\3E\3F\3F\3G\3G\3G\3G\3G\3G\3G\5G\u03f3\nG\3G\3G\3G\3G\5"+
		"G\u03f9\nG\5G\u03fb\nG\3G\3G\3H\3H\3H\5H\u0402\nH\3H\3H\3H\3H\3H\5H\u0409"+
		"\nH\3H\3H\5H\u040d\nH\3I\3I\3I\7I\u0412\nI\fI\16I\u0415\13I\3J\3J\5J\u0419"+
		"\nJ\3K\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3N\5N\u0427\nN\5N\u0429\nN\3O\3O"+
		"\3O\7O\u042e\nO\fO\16O\u0431\13O\3P\3P\3Q\3Q\3R\3R\3R\3R\3S\3S\3S\3S\3"+
		"T\3T\3T\3T\3U\3U\3U\7U\u0446\nU\fU\16U\u0449\13U\3V\3V\5V\u044d\nV\3W"+
		"\3W\3W\7W\u0452\nW\fW\16W\u0455\13W\3X\3X\3Y\3Y\3Z\3Z\5Z\u045d\nZ\3[\3"+
		"[\3[\7[\u0462\n[\f[\16[\u0465\13[\3\\\3\\\3\\\3\\\3]\3]\5]\u046d\n]\3"+
		"^\3^\3^\5^\u0472\n^\5^\u0474\n^\3_\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3"+
		"d\3d\3d\3d\3d\5d\u0487\nd\3e\3e\3e\3e\3e\5e\u048e\ne\3f\3f\3f\3f\7f\u0494"+
		"\nf\ff\16f\u0497\13f\3f\3f\3g\3g\5g\u049d\ng\3h\3h\3h\5h\u04a2\nh\3i\3"+
		"i\5i\u04a6\ni\3j\3j\5j\u04aa\nj\3j\7j\u04ad\nj\fj\16j\u04b0\13j\3k\3k"+
		"\3l\3l\3l\7l\u04b7\nl\fl\16l\u04ba\13l\3m\3m\3n\3n\3o\3o\3p\3p\3p\3p\3"+
		"p\3p\5p\u04c8\np\3q\3q\5q\u04cc\nq\3r\3r\3s\3s\3s\3s\3s\3s\3t\3t\5t\u04d8"+
		"\nt\3u\3u\5u\u04dc\nu\3v\3v\3v\3w\3w\3x\3x\3y\3y\3z\3z\3{\3{\3{\5{\u04ec"+
		"\n{\5{\u04ee\n{\3|\3|\3}\3}\3~\3~\3~\3~\7~\u04f8\n~\f~\16~\u04fb\13~\3"+
		"~\3~\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\5\u0080"+
		"\u0507\n\u0080\5\u0080\u0509\n\u0080\3\u0081\3\u0081\3\u0081\7\u0081\u050e"+
		"\n\u0081\f\u0081\16\u0081\u0511\13\u0081\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\3\u0082\5\u0082\u0518\n\u0082\3\u0082\3\u0082\3\u0083\3\u0083\5\u0083"+
		"\u051e\n\u0083\3\u0084\3\u0084\3\u0084\5\u0084\u0523\n\u0084\3\u0084\3"+
		"\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\2\7\bhjrt\u0086\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8"+
		"\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0"+
		"\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108"+
		"\2\33\4\2\60\60LL\4\2\27\27\u0084\u0084\5\2\5\6  ##\4\2ggnn\3\2WX\3\2"+
		"\\]\3\2_`\4\2ss\u008c\u008d\4\2\60\60ee\4\2\t\t\13\20\3\2\23\25\3\2\21"+
		"\22\4\2\66\66?@\4\288::\4\2\67\6799\4\2\3\3..\4\2\u0096\u0096\u0098\u0098"+
		"\5\2\5\6!!#%\5\2\5\6!!##\4\2\5\6#%\3\2!\"\4\2ss\u008c\u008c\4\2\37\37"+
		"\u0083\u0083\3\2\t\n\26\2))<<>>AACCEHJJVWZ[eehhmmqqttvv~~\u0084\u0084"+
		"\u0089\u008a\u008d\u008d\u0092\u0092\2\u0577\2\u010a\3\2\2\2\4\u0111\3"+
		"\2\2\2\6\u012f\3\2\2\2\b\u013c\3\2\2\2\n\u014c\3\2\2\2\f\u0153\3\2\2\2"+
		"\16\u0167\3\2\2\2\20\u0169\3\2\2\2\22\u016b\3\2\2\2\24\u016e\3\2\2\2\26"+
		"\u0171\3\2\2\2\30\u0178\3\2\2\2\32\u017a\3\2\2\2\34\u017d\3\2\2\2\36\u0186"+
		"\3\2\2\2 \u018a\3\2\2\2\"\u018f\3\2\2\2$\u019c\3\2\2\2&\u01a1\3\2\2\2"+
		"(\u01a5\3\2\2\2*\u01b0\3\2\2\2,\u01b2\3\2\2\2.\u01bf\3\2\2\2\60\u01c1"+
		"\3\2\2\2\62\u01ca\3\2\2\2\64\u01d6\3\2\2\2\66\u01dd\3\2\2\28\u01e1\3\2"+
		"\2\2:\u01e5\3\2\2\2<\u01e7\3\2\2\2>\u01ec\3\2\2\2@\u01f4\3\2\2\2B\u0203"+
		"\3\2\2\2D\u0205\3\2\2\2F\u020a\3\2\2\2H\u020e\3\2\2\2J\u021c\3\2\2\2L"+
		"\u021f\3\2\2\2N\u0225\3\2\2\2P\u0228\3\2\2\2R\u022f\3\2\2\2T\u0246\3\2"+
		"\2\2V\u0249\3\2\2\2X\u024d\3\2\2\2Z\u0257\3\2\2\2\\\u0259\3\2\2\2^\u025d"+
		"\3\2\2\2`\u0273\3\2\2\2b\u0275\3\2\2\2d\u027c\3\2\2\2f\u027f\3\2\2\2h"+
		"\u028e\3\2\2\2j\u029b\3\2\2\2l\u02b2\3\2\2\2n\u02b4\3\2\2\2p\u02ce\3\2"+
		"\2\2r\u02d0\3\2\2\2t\u0313\3\2\2\2v\u037d\3\2\2\2x\u037f\3\2\2\2z\u0399"+
		"\3\2\2\2|\u039b\3\2\2\2~\u03a0\3\2\2\2\u0080\u03aa\3\2\2\2\u0082\u03b3"+
		"\3\2\2\2\u0084\u03b5\3\2\2\2\u0086\u03e1\3\2\2\2\u0088\u03e3\3\2\2\2\u008a"+
		"\u03e9\3\2\2\2\u008c\u03eb\3\2\2\2\u008e\u040c\3\2\2\2\u0090\u040e\3\2"+
		"\2\2\u0092\u0416\3\2\2\2\u0094\u041a\3\2\2\2\u0096\u041d\3\2\2\2\u0098"+
		"\u0420\3\2\2\2\u009a\u0428\3\2\2\2\u009c\u042a\3\2\2\2\u009e\u0432\3\2"+
		"\2\2\u00a0\u0434\3\2\2\2\u00a2\u0436\3\2\2\2\u00a4\u043a\3\2\2\2\u00a6"+
		"\u043e\3\2\2\2\u00a8\u0442\3\2\2\2\u00aa\u044a\3\2\2\2\u00ac\u044e\3\2"+
		"\2\2\u00ae\u0456\3\2\2\2\u00b0\u0458\3\2\2\2\u00b2\u045c\3\2\2\2\u00b4"+
		"\u045e\3\2\2\2\u00b6\u0466\3\2\2\2\u00b8\u046a\3\2\2\2\u00ba\u046e\3\2"+
		"\2\2\u00bc\u0475\3\2\2\2\u00be\u0478\3\2\2\2\u00c0\u047a\3\2\2\2\u00c2"+
		"\u047c\3\2\2\2\u00c4\u047e\3\2\2\2\u00c6\u0486\3\2\2\2\u00c8\u048d\3\2"+
		"\2\2\u00ca\u048f\3\2\2\2\u00cc\u049c\3\2\2\2\u00ce\u04a1\3\2\2\2\u00d0"+
		"\u04a5\3\2\2\2\u00d2\u04a9\3\2\2\2\u00d4\u04b1\3\2\2\2\u00d6\u04b3\3\2"+
		"\2\2\u00d8\u04bb\3\2\2\2\u00da\u04bd\3\2\2\2\u00dc\u04bf\3\2\2\2\u00de"+
		"\u04c7\3\2\2\2\u00e0\u04cb\3\2\2\2\u00e2\u04cd\3\2\2\2\u00e4\u04cf\3\2"+
		"\2\2\u00e6\u04d7\3\2\2\2\u00e8\u04db\3\2\2\2\u00ea\u04dd\3\2\2\2\u00ec"+
		"\u04e0\3\2\2\2\u00ee\u04e2\3\2\2\2\u00f0\u04e4\3\2\2\2\u00f2\u04e6\3\2"+
		"\2\2\u00f4\u04ed\3\2\2\2\u00f6\u04ef\3\2\2\2\u00f8\u04f1\3\2\2\2\u00fa"+
		"\u04f3\3\2\2\2\u00fc\u04fe\3\2\2\2\u00fe\u0500\3\2\2\2\u0100\u050a\3\2"+
		"\2\2\u0102\u0512\3\2\2\2\u0104\u051d\3\2\2\2\u0106\u051f\3\2\2\2\u0108"+
		"\u0526\3\2\2\2\u010a\u010b\7\b\2\2\u010b\u010c\5\u00b2Z\2\u010c\u010d"+
		"\7f\2\2\u010d\u010e\5\4\3\2\u010e\3\3\2\2\2\u010f\u0112\5\6\4\2\u0110"+
		"\u0112\5\n\6\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\5\3\2\2\2"+
		"\u0113\u0115\5\62\32\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0125"+
		"\3\2\2\2\u0116\u0118\5\b\5\2\u0117\u0119\58\35\2\u0118\u0117\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u011c\5\22\n\2\u011b\u011a\3"+
		"\2\2\2\u011b\u011c\3\2\2\2\u011c\u0126\3\2\2\2\u011d\u0123\5\n\6\2\u011e"+
		"\u0120\58\35\2\u011f\u0121\5\22\n\2\u0120\u011f\3\2\2\2\u0120\u0121\3"+
		"\2\2\2\u0121\u0124\3\2\2\2\u0122\u0124\5\22\n\2\u0123\u011e\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0116\3\2\2\2\u0125\u011d\3\2"+
		"\2\2\u0126\u0128\3\2\2\2\u0127\u0129\5B\"\2\u0128\u0127\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u0130\3\2\2\2\u012a\u012b\5\62\32\2\u012b\u012d\5"+
		"\n\6\2\u012c\u012e\5B\"\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u0114\3\2\2\2\u012f\u012a\3\2\2\2\u0130\7\3\2\2\2"+
		"\u0131\u0132\b\5\1\2\u0132\u013d\5\f\7\2\u0133\u0134\5\n\6\2\u0134\u0136"+
		"\7/\2\2\u0135\u0137\5d\63\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u013b\5\f\7\2\u0139\u013b\5\n\6\2\u013a\u0138\3\2"+
		"\2\2\u013a\u0139\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u0131\3\2\2\2\u013c"+
		"\u0133\3\2\2\2\u013d\u0149\3\2\2\2\u013e\u013f\f\4\2\2\u013f\u0141\7/"+
		"\2\2\u0140\u0142\5d\63\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0145\3\2\2\2\u0143\u0146\5\f\7\2\u0144\u0146\5\n\6\2\u0145\u0143\3\2"+
		"\2\2\u0145\u0144\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u013e\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\t\3\2\2\2"+
		"\u014b\u0149\3\2\2\2\u014c\u014f\7\32\2\2\u014d\u0150\5\n\6\2\u014e\u0150"+
		"\5\6\4\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\7\33\2\2\u0152\13\3\2\2\2\u0153\u0157\7\u0088\2\2\u0154\u0156\5"+
		"@!\2\u0155\u0154\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015c\5H"+
		"%\2\u015b\u015d\5<\37\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u0160\5N(\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2"+
		"\2\u0160\u0162\3\2\2\2\u0161\u0163\5\66\34\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0166\5\32\16\2\u0165\u0164\3"+
		"\2\2\2\u0165\u0166\3\2\2\2\u0166\r\3\2\2\2\u0167\u0168\5\n\6\2\u0168\17"+
		"\3\2\2\2\u0169\u016a\t\2\2\2\u016a\21\3\2\2\2\u016b\u016c\7\u0080\2\2"+
		"\u016c\u016d\5\26\f\2\u016d\23\3\2\2\2\u016e\u016f\7\u0080\2\2\u016f\u0170"+
		"\5\30\r\2\u0170\25\3\2\2\2\u0171\u0174\5\30\r\2\u0172\u0173\t\3\2\2\u0173"+
		"\u0175\5\30\r\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\27\3\2\2"+
		"\2\u0176\u0179\5\u00b2Z\2\u0177\u0179\t\4\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0177\3\2\2\2\u0179\31\3\2\2\2\u017a\u017b\7z\2\2\u017b\u017c\5h\65\2"+
		"\u017c\33\3\2\2\2\u017d\u017e\7\63\2\2\u017e\u0183\5\36\20\2\u017f\u0180"+
		"\7\27\2\2\u0180\u0182\5\36\20\2\u0181\u017f\3\2\2\2\u0182\u0185\3\2\2"+
		"\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\35\3\2\2\2\u0185\u0183"+
		"\3\2\2\2\u0186\u0187\5\u00f2z\2\u0187\u0188\7f\2\2\u0188\u0189\5 \21\2"+
		"\u0189\37\3\2\2\2\u018a\u018b\7\32\2\2\u018b\u018c\5\"\22\2\u018c\u018d"+
		"\7\33\2\2\u018d!\3\2\2\2\u018e\u0190\5\u00f2z\2\u018f\u018e\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u0194\3\2\2\2\u0191\u0192\7\64\2\2\u0192\u0193\7"+
		"\65\2\2\u0193\u0195\5\u00a8U\2\u0194\u0191\3\2\2\2\u0194\u0195\3\2\2\2"+
		"\u0195\u0197\3\2\2\2\u0196\u0198\58\35\2\u0197\u0196\3\2\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u019b\5$\23\2\u019a\u0199\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b#\3\2\2\2\u019c\u019d\5&\24\2\u019d\u019f\5(\25\2"+
		"\u019e\u01a0\5\60\31\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0%"+
		"\3\2\2\2\u01a1\u01a2\7\62\2\2\u01a2\'\3\2\2\2\u01a3\u01a6\5*\26\2\u01a4"+
		"\u01a6\5,\27\2\u01a5\u01a3\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6)\3\2\2\2"+
		"\u01a7\u01a8\7A\2\2\u01a8\u01b1\7>\2\2\u01a9\u01aa\5\u00c2b\2\u01aa\u01ab"+
		"\7>\2\2\u01ab\u01b1\3\2\2\2\u01ac\u01ad\7 \2\2\u01ad\u01b1\7>\2\2\u01ae"+
		"\u01af\7C\2\2\u01af\u01b1\7D\2\2\u01b0\u01a7\3\2\2\2\u01b0\u01a9\3\2\2"+
		"\2\u01b0\u01ac\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1+\3\2\2\2\u01b2\u01b3"+
		"\7i\2\2\u01b3\u01b4\5.\30\2\u01b4\u01b5\7,\2\2\u01b5\u01b6\5.\30\2\u01b6"+
		"-\3\2\2\2\u01b7\u01c0\5*\26\2\u01b8\u01b9\7A\2\2\u01b9\u01c0\7E\2\2\u01ba"+
		"\u01bb\5\u00c2b\2\u01bb\u01bc\7E\2\2\u01bc\u01c0\3\2\2\2\u01bd\u01be\7"+
		" \2\2\u01be\u01c0\7E\2\2\u01bf\u01b7\3\2\2\2\u01bf\u01b8\3\2\2\2\u01bf"+
		"\u01ba\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0/\3\2\2\2\u01c1\u01c8\7F\2\2\u01c2"+
		"\u01c3\7C\2\2\u01c3\u01c9\7D\2\2\u01c4\u01c9\7y\2\2\u01c5\u01c9\7G\2\2"+
		"\u01c6\u01c7\7\u0082\2\2\u01c7\u01c9\7H\2\2\u01c8\u01c2\3\2\2\2\u01c8"+
		"\u01c4\3\2\2\2\u01c8\u01c5\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\61\3\2\2"+
		"\2\u01ca\u01cc\7\u0090\2\2\u01cb\u01cd\7I\2\2\u01cc\u01cb\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d3\5\64\33\2\u01cf\u01d0\7"+
		"\27\2\2\u01d0\u01d2\5\64\33\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2\2"+
		"\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\63\3\2\2\2\u01d5\u01d3"+
		"\3\2\2\2\u01d6\u01d8\5\u00b2Z\2\u01d7\u01d9\5\u00fa~\2\u01d8\u01d7\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7f\2\2\u01db"+
		"\u01dc\5\16\b\2\u01dc\65\3\2\2\2\u01dd\u01de\7y\2\2\u01de\u01df\7\65\2"+
		"\2\u01df\u01e0\5\u00a8U\2\u01e0\67\3\2\2\2\u01e1\u01e2\7\u0086\2\2\u01e2"+
		"\u01e3\7\65\2\2\u01e3\u01e4\5\u00a8U\2\u01e49\3\2\2\2\u01e5\u01e6\t\5"+
		"\2\2\u01e6;\3\2\2\2\u01e7\u01ea\7u\2\2\u01e8\u01eb\7o\2\2\u01e9\u01eb"+
		"\5> \2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb=\3\2\2\2\u01ec\u01f1"+
		"\5P)\2\u01ed\u01ee\7\27\2\2\u01ee\u01f0\5P)\2\u01ef\u01ed\3\2\2\2\u01f0"+
		"\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2?\3\2\2\2"+
		"\u01f3\u01f1\3\2\2\2\u01f4\u01f5\5\20\t\2\u01f5A\3\2\2\2\u01f6\u01f7\7"+
		"U\2\2\u01f7\u01fa\5D#\2\u01f8\u01f9\7\u0091\2\2\u01f9\u01fb\5\u0100\u0081"+
		"\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01fe"+
		"\5F$\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0204\3\2\2\2\u01ff"+
		"\u0200\7Y\2\2\u0200\u0201\7{\2\2\u0201\u0202\7W\2\2\u0202\u0204\7V\2\2"+
		"\u0203\u01f6\3\2\2\2\u0203\u01ff\3\2\2\2\u0204C\3\2\2\2\u0205\u0206\t"+
		"\6\2\2\u0206E\3\2\2\2\u0207\u0208\7Z\2\2\u0208\u020b\7[\2\2\u0209\u020b"+
		"\7\u0092\2\2\u020a\u0207\3\2\2\2\u020a\u0209\3\2\2\2\u020bG\3\2\2\2\u020c"+
		"\u020f\5J&\2\u020d\u020f\7\23\2\2\u020e\u020c\3\2\2\2\u020e\u020d\3\2"+
		"\2\2\u020f\u0214\3\2\2\2\u0210\u0211\7\27\2\2\u0211\u0213\5J&\2\u0212"+
		"\u0210\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2"+
		"\2\2\u0215I\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u021d\5\u0102\u0082\2\u0218"+
		"\u021a\5h\65\2\u0219\u021b\5L\'\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021d\3\2\2\2\u021c\u0217\3\2\2\2\u021c\u0218\3\2\2\2\u021d"+
		"K\3\2\2\2\u021e\u0220\7f\2\2\u021f\u021e\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u0223\3\2\2\2\u0221\u0224\5\u00b2Z\2\u0222\u0224\5\u00ccg\2\u0223\u0221"+
		"\3\2\2\2\u0223\u0222\3\2\2\2\u0224M\3\2\2\2\u0225\u0226\7\u008f\2\2\u0226"+
		"\u0227\5h\65\2\u0227O\3\2\2\2\u0228\u022c\5Z.\2\u0229\u022b\5T+\2\u022a"+
		"\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2"+
		"\2\2\u022dQ\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0233\5Z.\2\u0230\u0232"+
		"\5T+\2\u0231\u0230\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234S\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0237\5V,\2\u0237"+
		"\u023c\5P)\2\u0238\u0239\7\u0085\2\2\u0239\u023d\5h\65\2\u023a\u023b\7"+
		"\u008e\2\2\u023b\u023d\5\u00b6\\\2\u023c\u0238\3\2\2\2\u023c\u023a\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d\u0247\3\2\2\2\u023e\u023f\5X-\2\u023f\u0244"+
		"\5P)\2\u0240\u0241\7\u0085\2\2\u0241\u0245\5h\65\2\u0242\u0243\7\u008e"+
		"\2\2\u0243\u0245\5\u00b6\\\2\u0244\u0240\3\2\2\2\u0244\u0242\3\2\2\2\u0245"+
		"\u0247\3\2\2\2\u0246\u0236\3\2\2\2\u0246\u023e\3\2\2\2\u0247U\3\2\2\2"+
		"\u0248\u024a\t\7\2\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b"+
		"\3\2\2\2\u024b\u024c\7^\2\2\u024cW\3\2\2\2\u024d\u024f\t\b\2\2\u024e\u0250"+
		"\7\u0087\2\2\u024f\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2"+
		"\2\u0251\u0252\7^\2\2\u0252Y\3\2\2\2\u0253\u0258\5\\/\2\u0254\u0258\5"+
		"^\60\2\u0255\u0258\5`\61\2\u0256\u0258\5b\62\2\u0257\u0253\3\2\2\2\u0257"+
		"\u0254\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0258[\3\2\2\2"+
		"\u0259\u025b\5\u0104\u0083\2\u025a\u025c\5f\64\2\u025b\u025a\3\2\2\2\u025b"+
		"\u025c\3\2\2\2\u025c]\3\2\2\2\u025d\u0260\7\32\2\2\u025e\u0261\5\\/\2"+
		"\u025f\u0261\5^\60\2\u0260\u025e\3\2\2\2\u0260\u025f\3\2\2\2\u0261\u0262"+
		"\3\2\2\2\u0262\u0263\7\33\2\2\u0263_\3\2\2\2\u0264\u0266\5\16\b\2\u0265"+
		"\u0267\5f\64\2\u0266\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2"+
		"\2\2\u0268\u026a\5\u00fa~\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a"+
		"\u0274\3\2\2\2\u026b\u026c\7a\2\2\u026c\u026e\5\16\b\2\u026d\u026f\5f"+
		"\64\2\u026e\u026d\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270"+
		"\u0272\5\u00fa~\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274"+
		"\3\2\2\2\u0273\u0264\3\2\2\2\u0273\u026b\3\2\2\2\u0274a\3\2\2\2\u0275"+
		"\u0278\7\32\2\2\u0276\u0279\5> \2\u0277\u0279\5b\62\2\u0278\u0276\3\2"+
		"\2\2\u0278\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\7\33\2\2\u027b"+
		"c\3\2\2\2\u027c\u027d\t\2\2\2\u027de\3\2\2\2\u027e\u0280\7f\2\2\u027f"+
		"\u027e\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\5\u00b2"+
		"Z\2\u0282g\3\2\2\2\u0283\u0284\b\65\1\2\u0284\u028a\5j\66\2\u0285\u0287"+
		"\7|\2\2\u0286\u0288\5\u009eP\2\u0287\u0286\3\2\2\2\u0287\u0288\3\2\2\2"+
		"\u0288\u0289\3\2\2\2\u0289\u028b\t\t\2\2\u028a\u0285\3\2\2\2\u028a\u028b"+
		"\3\2\2\2\u028b\u028f\3\2\2\2\u028c\u028d\7.\2\2\u028d\u028f\5h\65\5\u028e"+
		"\u0283\3\2\2\2\u028e\u028c\3\2\2\2\u028f\u0298\3\2\2\2\u0290\u0291\f\4"+
		"\2\2\u0291\u0292\7,\2\2\u0292\u0297\5h\65\5\u0293\u0294\f\3\2\2\u0294"+
		"\u0295\7-\2\2\u0295\u0297\5h\65\4\u0296\u0290\3\2\2\2\u0296\u0293\3\2"+
		"\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299"+
		"i\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029c\b\66\1\2\u029c\u029d\5n8\2\u029d"+
		"\u02af\3\2\2\2\u029e\u029f\f\5\2\2\u029f\u02a1\7|\2\2\u02a0\u02a2\5\u009e"+
		"P\2\u02a1\u02a0\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3"+
		"\u02ae\7\u0083\2\2\u02a4\u02a5\f\4\2\2\u02a5\u02a6\5l\67\2\u02a6\u02a7"+
		"\5n8\2\u02a7\u02ae\3\2\2\2\u02a8\u02a9\f\3\2\2\u02a9\u02aa\5l\67\2\u02aa"+
		"\u02ab\t\n\2\2\u02ab\u02ac\5\16\b\2\u02ac\u02ae\3\2\2\2\u02ad\u029e\3"+
		"\2\2\2\u02ad\u02a4\3\2\2\2\u02ad\u02a8\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0k\3\2\2\2\u02b1\u02af\3\2\2\2"+
		"\u02b2\u02b3\t\13\2\2\u02b3m\3\2\2\2\u02b4\u02b9\5r:\2\u02b5\u02b7\5\u009e"+
		"P\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"+
		"\u02ba\5p9\2\u02b9\u02b6\3\2\2\2\u02b9\u02ba\3\2\2\2\u02bao\3\2\2\2\u02bb"+
		"\u02c1\7{\2\2\u02bc\u02c2\5\16\b\2\u02bd\u02be\7\32\2\2\u02be\u02bf\5"+
		"\u009cO\2\u02bf\u02c0\7\33\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02bc\3\2\2\2"+
		"\u02c1\u02bd\3\2\2\2\u02c2\u02cf\3\2\2\2\u02c3\u02c4\7i\2\2\u02c4\u02c5"+
		"\5r:\2\u02c5\u02c6\7,\2\2\u02c6\u02c7\5n8\2\u02c7\u02cf\3\2\2\2\u02c8"+
		"\u02c9\7\177\2\2\u02c9\u02cc\5t;\2\u02ca\u02cb\7q\2\2\u02cb\u02cd\5t;"+
		"\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf\3\2\2\2\u02ce\u02bb"+
		"\3\2\2\2\u02ce\u02c3\3\2\2\2\u02ce\u02c8\3\2\2\2\u02cfq\3\2\2\2\u02d0"+
		"\u02d1\b:\1\2\u02d1\u02d2\5t;\2\u02d2\u02db\3\2\2\2\u02d3\u02d4\f\4\2"+
		"\2\u02d4\u02d5\t\f\2\2\u02d5\u02da\5r:\5\u02d6\u02d7\f\3\2\2\u02d7\u02d8"+
		"\t\r\2\2\u02d8\u02da\5r:\4\u02d9\u02d3\3\2\2\2\u02d9\u02d6\3\2\2\2\u02da"+
		"\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dcs\3\2\2\2"+
		"\u02dd\u02db\3\2\2\2\u02de\u02df\b;\1\2\u02df\u0314\5\u00fc\177\2\u02e0"+
		"\u0314\5\u0086D\2\u02e1\u0314\5\u008eH\2\u02e2\u0314\5\u00c6d\2\u02e3"+
		"\u0314\7 \2\2\u02e4\u0314\5v<\2\u02e5\u0314\5x=\2\u02e6\u0314\5z>\2\u02e7"+
		"\u02e8\t\r\2\2\u02e8\u0314\5t;\t\u02e9\u02ea\5\u00a0Q\2\u02ea\u02eb\5"+
		"t;\b\u02eb\u0314\3\2\2\2\u02ec\u02ee\7D\2\2\u02ed\u02ec\3\2\2\2\u02ed"+
		"\u02ee\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f0\7\32\2\2\u02f0\u02f1\5"+
		"\u009cO\2\u02f1\u02f2\7\33\2\2\u02f2\u0314\3\2\2\2\u02f3\u02f5\7r\2\2"+
		"\u02f4\u02f3\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u0314"+
		"\5\16\b\2\u02f7\u02f8\7\34\2\2\u02f8\u02f9\5\u00b2Z\2\u02f9\u02fa\5h\65"+
		"\2\u02fa\u02fb\7\35\2\2\u02fb\u0314\3\2\2\2\u02fc\u02fd\7k\2\2\u02fd\u02fe"+
		"\7\32\2\2\u02fe\u02ff\5h\65\2\u02ff\u0300\7f\2\2\u0300\u0301\5\u009aN"+
		"\2\u0301\u0302\7\33\2\2\u0302\u0314\3\2\2\2\u0303\u0305\7j\2\2\u0304\u0306"+
		"\5h\65\2\u0305\u0304\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u030a\3\2\2\2\u0307"+
		"\u0308\5\u0094K\2\u0308\u0309\5\u0096L\2\u0309\u030b\3\2\2\2\u030a\u0307"+
		"\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d"+
		"\u030f\3\2\2\2\u030e\u0310\5\u0098M\2\u030f\u030e\3\2\2\2\u030f\u0310"+
		"\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\7p\2\2\u0312\u0314\3\2\2\2\u0313"+
		"\u02de\3\2\2\2\u0313\u02e0\3\2\2\2\u0313\u02e1\3\2\2\2\u0313\u02e2\3\2"+
		"\2\2\u0313\u02e3\3\2\2\2\u0313\u02e4\3\2\2\2\u0313\u02e5\3\2\2\2\u0313"+
		"\u02e6\3\2\2\2\u0313\u02e7\3\2\2\2\u0313\u02e9\3\2\2\2\u0313\u02ed\3\2"+
		"\2\2\u0313\u02f4\3\2\2\2\u0313\u02f7\3\2\2\2\u0313\u02fc\3\2\2\2\u0313"+
		"\u0303\3\2\2\2\u0314\u031a\3\2\2\2\u0315\u0316\f\n\2\2\u0316\u0317\7\4"+
		"\2\2\u0317\u0319\5t;\13\u0318\u0315\3\2\2\2\u0319\u031c\3\2\2\2\u031a"+
		"\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031bu\3\2\2\2\u031c\u031a\3\2\2\2"+
		"\u031d\u031e\7J\2\2\u031e\u0320\7\32\2\2\u031f\u0321\7L\2\2\u0320\u031f"+
		"\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0323\5\u0080A"+
		"\2\u0323\u0325\7\33\2\2\u0324\u0326\5|?\2\u0325\u0324\3\2\2\2\u0325\u0326"+
		"\3\2\2\2\u0326\u037e\3\2\2\2\u0327\u0328\7K\2\2\u0328\u032a\7\32\2\2\u0329"+
		"\u032b\7\60\2\2\u032a\u0329\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\3"+
		"\2\2\2\u032c\u032d\7\23\2\2\u032d\u032f\7\33\2\2\u032e\u0330\5|?\2\u032f"+
		"\u032e\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u037e\3\2\2\2\u0331\u0332\7K"+
		"\2\2\u0332\u033a\7\32\2\2\u0333\u0335\7\60\2\2\u0334\u0333\3\2\2\2\u0334"+
		"\u0335\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u033b\7\23\2\2\u0337\u033b\5"+
		"\u0080A\2\u0338\u0339\7L\2\2\u0339\u033b\5\u009cO\2\u033a\u0334\3\2\2"+
		"\2\u033a\u0337\3\2\2\2\u033a\u0338\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033e"+
		"\7\33\2\2\u033d\u033f\5|?\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2\2\u033f"+
		"\u037e\3\2\2\2\u0340\u0341\7O\2\2\u0341\u0343\7\32\2\2\u0342\u0344\7L"+
		"\2\2\u0343\u0342\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0345\3\2\2\2\u0345"+
		"\u0346\5\u0080A\2\u0346\u0348\7\33\2\2\u0347\u0349\5|?\2\u0348\u0347\3"+
		"\2\2\2\u0348\u0349\3\2\2\2\u0349\u037e\3\2\2\2\u034a\u034b\7N\2\2\u034b"+
		"\u034d\7\32\2\2\u034c\u034e\7L\2\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2"+
		"\2\2\u034e\u034f\3\2\2\2\u034f\u0350\5\u0080A\2\u0350\u0352\7\33\2\2\u0351"+
		"\u0353\5|?\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u037e\3\2\2"+
		"\2\u0354\u0355\7P\2\2\u0355\u0356\7\32\2\2\u0356\u0357\5\u0080A\2\u0357"+
		"\u0359\7\33\2\2\u0358\u035a\5|?\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2"+
		"\2\2\u035a\u037e\3\2\2\2\u035b\u035c\7R\2\2\u035c\u035d\7\32\2\2\u035d"+
		"\u035e\5\u0080A\2\u035e\u0360\7\33\2\2\u035f\u0361\5|?\2\u0360\u035f\3"+
		"\2\2\2\u0360\u0361\3\2\2\2\u0361\u037e\3\2\2\2\u0362\u0363\7M\2\2\u0363"+
		"\u0365\7\32\2\2\u0364\u0366\7L\2\2\u0365\u0364\3\2\2\2\u0365\u0366\3\2"+
		"\2\2\u0366\u0367\3\2\2\2\u0367\u0368\5\u0080A\2\u0368\u036a\7\33\2\2\u0369"+
		"\u036b\5|?\2\u036a\u0369\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u037e\3\2\2"+
		"\2\u036c\u036d\7S\2\2\u036d\u036f\7\32\2\2\u036e\u0370\7L\2\2\u036f\u036e"+
		"\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0373\5\u009cO"+
		"\2\u0372\u0374\58\35\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0377"+
		"\3\2\2\2\u0375\u0376\7T\2\2\u0376\u0378\5\u00ceh\2\u0377\u0375\3\2\2\2"+
		"\u0377\u0378\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037b\7\33\2\2\u037a\u037c"+
		"\5|?\2\u037b\u037a\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037e\3\2\2\2\u037d"+
		"\u031d\3\2\2\2\u037d\u0327\3\2\2\2\u037d\u0331\3\2\2\2\u037d\u0340\3\2"+
		"\2\2\u037d\u034a\3\2\2\2\u037d\u0354\3\2\2\2\u037d\u035b\3\2\2\2\u037d"+
		"\u0362\3\2\2\2\u037d\u036c\3\2\2\2\u037ew\3\2\2\2\u037f\u0380\7\u0093"+
		"\2\2\u0380\u0381\7\32\2\2\u0381\u0382\5\u009cO\2\u0382\u0383\7\33\2\2"+
		"\u0383y\3\2\2\2\u0384\u0385\t\16\2\2\u0385\u0386\5\u00eav\2\u0386\u0387"+
		"\5|?\2\u0387\u039a\3\2\2\2\u0388\u0389\7;\2\2\u0389\u038a\5\u00a6T\2\u038a"+
		"\u038b\5|?\2\u038b\u039a\3\2\2\2\u038c\u038d\t\17\2\2\u038d\u038e\7\32"+
		"\2\2\u038e\u0390\5h\65\2\u038f\u0391\5~@\2\u0390\u038f\3\2\2\2\u0390\u0391"+
		"\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0393\7\33\2\2\u0393\u0394\5|?\2\u0394"+
		"\u039a\3\2\2\2\u0395\u0396\t\20\2\2\u0396\u0397\5\u00a4S\2\u0397\u0398"+
		"\5|?\2\u0398\u039a\3\2\2\2\u0399\u0384\3\2\2\2\u0399\u0388\3\2\2\2\u0399"+
		"\u038c\3\2\2\2\u0399\u0395\3\2\2\2\u039a{\3\2\2\2\u039b\u039e\7=\2\2\u039c"+
		"\u039f\5\u00f2z\2\u039d\u039f\5 \21\2\u039e\u039c\3\2\2\2\u039e\u039d"+
		"\3\2\2\2\u039f}\3\2\2\2\u03a0\u03a3\7\27\2\2\u03a1\u03a4\5\u00c2b\2\u03a2"+
		"\u03a4\7 \2\2\u03a3\u03a1\3\2\2\2\u03a3\u03a2\3\2\2\2\u03a4\u03a7\3\2"+
		"\2\2\u03a5\u03a6\7\27\2\2\u03a6\u03a8\5h\65\2\u03a7\u03a5\3\2\2\2\u03a7"+
		"\u03a8\3\2\2\2\u03a8\177\3\2\2\2\u03a9\u03ab\7\60\2\2\u03aa\u03a9\3\2"+
		"\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ad\5h\65\2\u03ad"+
		"\u0081\3\2\2\2\u03ae\u03b4\5\u0084C\2\u03af\u03b0\7\32\2\2\u03b0\u03b1"+
		"\5\u0084C\2\u03b1\u03b2\7\33\2\2\u03b2\u03b4\3\2\2\2\u03b3\u03ae\3\2\2"+
		"\2\u03b3\u03af\3\2\2\2\u03b4\u0083\3\2\2\2\u03b5\u03ba\5\u00ba^\2\u03b6"+
		"\u03b7\7\27\2\2\u03b7\u03b9\5\u00ba^\2\u03b8\u03b6\3\2\2\2\u03b9\u03bc"+
		"\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u0085\3\2\2\2\u03bc"+
		"\u03ba\3\2\2\2\u03bd\u03bf\7\61\2\2\u03be\u03c0\5\u00eav\2\u03bf\u03be"+
		"\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03e2\3\2\2\2\u03c1\u03c2\7B\2\2\u03c2"+
		"\u03c3\7\32\2\2\u03c3\u03c6\5h\65\2\u03c4\u03c5\7\27\2\2\u03c5\u03c7\5"+
		"h\65\2\u03c6\u03c4\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c8"+
		"\u03c9\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03cb\7\33\2\2\u03cb\u03e2\3"+
		"\2\2\2\u03cc\u03cd\7_\2\2\u03cd\u03ce\7\32\2\2\u03ce\u03cf\5h\65\2\u03cf"+
		"\u03d0\7\27\2\2\u03d0\u03d1\5h\65\2\u03d1\u03d2\7\33\2\2\u03d2\u03e2\3"+
		"\2\2\2\u03d3\u03d4\7`\2\2\u03d4\u03d5\7\32\2\2\u03d5\u03d6\5h\65\2\u03d6"+
		"\u03d7\7\27\2\2\u03d7\u03d8\5h\65\2\u03d8\u03d9\7\33\2\2\u03d9\u03e2\3"+
		"\2\2\2\u03da\u03dc\7\u0081\2\2\u03db\u03dd\5\u0088E\2\u03dc\u03db\3\2"+
		"\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03e2\3\2\2\2\u03de\u03e2\5\u008cG\2\u03df"+
		"\u03e0\7(\2\2\u03e0\u03e2\5\u00a4S\2\u03e1\u03bd\3\2\2\2\u03e1\u03c1\3"+
		"\2\2\2\u03e1\u03cc\3\2\2\2\u03e1\u03d3\3\2\2\2\u03e1\u03da\3\2\2\2\u03e1"+
		"\u03de\3\2\2\2\u03e1\u03df\3\2\2\2\u03e2\u0087\3\2\2\2\u03e3\u03e5\7\32"+
		"\2\2\u03e4\u03e6\5\u008aF\2\u03e5\u03e4\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"\u03e7\3\2\2\2\u03e7\u03e8\7\33\2\2\u03e8\u0089\3\2\2\2\u03e9\u03ea\7"+
		"#\2\2\u03ea\u008b\3\2\2\2\u03eb\u03ec\7+\2\2\u03ec\u03ed\7\32\2\2\u03ed"+
		"\u03fa\5h\65\2\u03ee\u03ef\7\27\2\2\u03ef\u03f2\5h\65\2\u03f0\u03f1\7"+
		"\27\2\2\u03f1\u03f3\5h\65\2\u03f2\u03f0\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3"+
		"\u03fb\3\2\2\2\u03f4\u03f5\7u\2\2\u03f5\u03f8\5h\65\2\u03f6\u03f7\7U\2"+
		"\2\u03f7\u03f9\5h\65\2\u03f8\u03f6\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fb"+
		"\3\2\2\2\u03fa\u03ee\3\2\2\2\u03fa\u03f4\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc"+
		"\u03fd\7\33\2\2\u03fd\u008d\3\2\2\2\u03fe\u03ff\5\u00b0Y\2\u03ff\u0401"+
		"\7\32\2\2\u0400\u0402\5\u0090I\2\u0401\u0400\3\2\2\2\u0401\u0402\3\2\2"+
		"\2\u0402\u0403\3\2\2\2\u0403\u0404\7\33\2\2\u0404\u040d\3\2\2\2\u0405"+
		"\u0406\5\u00b8]\2\u0406\u0408\7\32\2\2\u0407\u0409\5\u009cO\2\u0408\u0407"+
		"\3\2\2\2\u0408\u0409\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040b\7\33\2\2"+
		"\u040b\u040d\3\2\2\2\u040c\u03fe\3\2\2\2\u040c\u0405\3\2\2\2\u040d\u008f"+
		"\3\2\2\2\u040e\u0413\5\u0092J\2\u040f\u0410\7\27\2\2\u0410\u0412\5\u0092"+
		"J\2\u0411\u040f\3\2\2\2\u0412\u0415\3\2\2\2\u0413\u0411\3\2\2\2\u0413"+
		"\u0414\3\2\2\2\u0414\u0091\3\2\2\2\u0415\u0413\3\2\2\2\u0416\u0418\5h"+
		"\65\2\u0417\u0419\5L\'\2\u0418\u0417\3\2\2\2\u0418\u0419\3\2\2\2\u0419"+
		"\u0093\3\2\2\2\u041a\u041b\7d\2\2\u041b\u041c\5h\65\2\u041c\u0095\3\2"+
		"\2\2\u041d\u041e\7c\2\2\u041e\u041f\5h\65\2\u041f\u0097\3\2\2\2\u0420"+
		"\u0421\7b\2\2\u0421\u0422\5h\65\2\u0422\u0099\3\2\2\2\u0423\u0429\7m\2"+
		"\2\u0424\u0426\7\u008a\2\2\u0425\u0427\5\u0108\u0085\2\u0426\u0425\3\2"+
		"\2\2\u0426\u0427\3\2\2\2\u0427\u0429\3\2\2\2\u0428\u0423\3\2\2\2\u0428"+
		"\u0424\3\2\2\2\u0429\u009b\3\2\2\2\u042a\u042f\5h\65\2\u042b\u042c\7\27"+
		"\2\2\u042c\u042e\5h\65\2\u042d\u042b\3\2\2\2\u042e\u0431\3\2\2\2\u042f"+
		"\u042d\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u009d\3\2\2\2\u0431\u042f\3\2"+
		"\2\2\u0432\u0433\t\21\2\2\u0433\u009f\3\2\2\2\u0434\u0435\7\3\2\2\u0435"+
		"\u00a1\3\2\2\2\u0436\u0437\7\32\2\2\u0437\u0438\5\u009cO\2\u0438\u0439"+
		"\7\33\2\2\u0439\u00a3\3\2\2\2\u043a\u043b\7\32\2\2\u043b\u043c\5h\65\2"+
		"\u043c\u043d\7\33\2\2\u043d\u00a5\3\2\2\2\u043e\u043f\7\32\2\2\u043f\u0440"+
		"\5t;\2\u0440\u0441\7\33\2\2\u0441\u00a7\3\2\2\2\u0442\u0447\5\u00aaV\2"+
		"\u0443\u0444\7\27\2\2\u0444\u0446\5\u00aaV\2\u0445\u0443\3\2\2\2\u0446"+
		"\u0449\3\2\2\2\u0447\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u00a9\3\2"+
		"\2\2\u0449\u0447\3\2\2\2\u044a\u044c\5h\65\2\u044b\u044d\5:\36\2\u044c"+
		"\u044b\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u00ab\3\2\2\2\u044e\u0453\5\u00ae"+
		"X\2\u044f\u0450\7\27\2\2\u0450\u0452\5\u00aeX\2\u0451\u044f\3\2\2\2\u0452"+
		"\u0455\3\2\2\2\u0453\u0451\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u00ad\3\2"+
		"\2\2\u0455\u0453\3\2\2\2\u0456\u0457\5h\65\2\u0457\u00af\3\2\2\2\u0458"+
		"\u0459\t\22\2\2\u0459\u00b1\3\2\2\2\u045a\u045d\5\u00b0Y\2\u045b\u045d"+
		"\5\u00eex\2\u045c\u045a\3\2\2\2\u045c\u045b\3\2\2\2\u045d\u00b3\3\2\2"+
		"\2\u045e\u0463\5\u00b2Z\2\u045f\u0460\7\27\2\2\u0460\u0462\5\u00b2Z\2"+
		"\u0461\u045f\3\2\2\2\u0462\u0465\3\2\2\2\u0463\u0461\3\2\2\2\u0463\u0464"+
		"\3\2\2\2\u0464\u00b5\3\2\2\2\u0465\u0463\3\2\2\2\u0466\u0467\7\32\2\2"+
		"\u0467\u0468\5\u00b4[\2\u0468\u0469\7\33\2\2\u0469\u00b7\3\2\2\2\u046a"+
		"\u046c\5\u00b2Z\2\u046b\u046d\5\u00bc_\2\u046c\u046b\3\2\2\2\u046c\u046d"+
		"\3\2\2\2\u046d\u00b9\3\2\2\2\u046e\u0473\5\u00b2Z\2\u046f\u0471\5\u00bc"+
		"_\2\u0470\u0472\5\u00bc_\2\u0471\u0470\3\2\2\2\u0471\u0472\3\2\2\2\u0472"+
		"\u0474\3\2\2\2\u0473\u046f\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u00bb\3\2"+
		"\2\2\u0475\u0476\7\26\2\2\u0476\u0477\5\u00b2Z\2\u0477\u00bd\3\2\2\2\u0478"+
		"\u0479\t\23\2\2\u0479\u00bf\3\2\2\2\u047a\u047b\t\24\2\2\u047b\u00c1\3"+
		"\2\2\2\u047c\u047d\t\25\2\2\u047d\u00c3\3\2\2\2\u047e\u047f\t\24\2\2\u047f"+
		"\u00c5\3\2\2\2\u0480\u0487\5\u00d2j\2\u0481\u0487\5\u00d8m\2\u0482\u0487"+
		"\5\u00dep\2\u0483\u0487\5\u00dco\2\u0484\u0487\5\u00dan\2\u0485\u0487"+
		"\t\26\2\2\u0486\u0480\3\2\2\2\u0486\u0481\3\2\2\2\u0486\u0482\3\2\2\2"+
		"\u0486\u0483\3\2\2\2\u0486\u0484\3\2\2\2\u0486\u0485\3\2\2\2\u0487\u00c7"+
		"\3\2\2\2\u0488\u048e\5\u00c6d\2\u0489\u048a\7\21\2\2\u048a\u048e\5\u00be"+
		"`\2\u048b\u048c\7\22\2\2\u048c\u048e\5\u00be`\2\u048d\u0488\3\2\2\2\u048d"+
		"\u0489\3\2\2\2\u048d\u048b\3\2\2\2\u048e\u00c9\3\2\2\2\u048f\u0490\7\32"+
		"\2\2\u0490\u0495\5\u00ceh\2\u0491\u0492\7\27\2\2\u0492\u0494\5\u00ceh"+
		"\2\u0493\u0491\3\2\2\2\u0494\u0497\3\2\2\2\u0495\u0493\3\2\2\2\u0495\u0496"+
		"\3\2\2\2\u0496\u0498\3\2\2\2\u0497\u0495\3\2\2\2\u0498\u0499\7\33\2\2"+
		"\u0499\u00cb\3\2\2\2\u049a\u049d\7\u0099\2\2\u049b\u049d\7\u0098\2\2\u049c"+
		"\u049a\3\2\2\2\u049c\u049b\3\2\2\2\u049d\u00cd\3\2\2\2\u049e\u04a2\5\u00cc"+
		"g\2\u049f\u04a2\7!\2\2\u04a0\u04a2\7\"\2\2\u04a1\u049e\3\2\2\2\u04a1\u049f"+
		"\3\2\2\2\u04a1\u04a0\3\2\2\2\u04a2\u00cf\3\2\2\2\u04a3\u04a6\5\u00ccg"+
		"\2\u04a4\u04a6\7!\2\2\u04a5\u04a3\3\2\2\2\u04a5\u04a4\3\2\2\2\u04a6\u00d1"+
		"\3\2\2\2\u04a7\u04aa\5\u00ccg\2\u04a8\u04aa\7\u0097\2\2\u04a9\u04a7\3"+
		"\2\2\2\u04a9\u04a8\3\2\2\2\u04aa\u04ae\3\2\2\2\u04ab\u04ad\5\u00ccg\2"+
		"\u04ac\u04ab\3\2\2\2\u04ad\u04b0\3\2\2\2\u04ae\u04ac\3\2\2\2\u04ae\u04af"+
		"\3\2\2\2\u04af\u00d3\3\2\2\2\u04b0\u04ae\3\2\2\2\u04b1\u04b2\5\u00ccg"+
		"\2\u04b2\u00d5\3\2\2\2\u04b3\u04b8\5\u00ccg\2\u04b4\u04b5\7\27\2\2\u04b5"+
		"\u04b7\5\u00ccg\2\u04b6\u04b4\3\2\2\2\u04b7\u04ba\3\2\2\2\u04b8\u04b6"+
		"\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u00d7\3\2\2\2\u04ba\u04b8\3\2\2\2\u04bb"+
		"\u04bc\t\25\2\2\u04bc\u00d9\3\2\2\2\u04bd\u04be\t\27\2\2\u04be\u00db\3"+
		"\2\2\2\u04bf\u04c0\t\30\2\2\u04c0\u00dd\3\2\2\2\u04c1\u04c2\7m\2\2\u04c2"+
		"\u04c8\7\u0099\2\2\u04c3\u04c4\7\u008a\2\2\u04c4\u04c8\7\u0099\2\2\u04c5"+
		"\u04c6\7\u0089\2\2\u04c6\u04c8\7\u0099\2\2\u04c7\u04c1\3\2\2\2\u04c7\u04c3"+
		"\3\2\2\2\u04c7\u04c5\3\2\2\2\u04c8\u00df\3\2\2\2\u04c9\u04cc\5\u0106\u0084"+
		"\2\u04ca\u04cc\5\u00e4s\2\u04cb\u04c9\3\2\2\2\u04cb\u04ca\3\2\2\2\u04cc"+
		"\u00e1\3\2\2\2\u04cd\u04ce\5\u00e4s\2\u04ce\u00e3\3\2\2\2\u04cf\u04d0"+
		"\7\32\2\2\u04d0\u04d1\7#\2\2\u04d1\u04d2\7\27\2\2\u04d2\u04d3\7#\2\2\u04d3"+
		"\u04d4\7\33\2\2\u04d4\u00e5\3\2\2\2\u04d5\u04d8\7\u0099\2\2\u04d6\u04d8"+
		"\5\u00b2Z\2\u04d7\u04d5\3\2\2\2\u04d7\u04d6\3\2\2\2\u04d8\u00e7\3\2\2"+
		"\2\u04d9\u04dc\5\u00c4c\2\u04da\u04dc\5\u00b0Y\2\u04db\u04d9\3\2\2\2\u04db"+
		"\u04da\3\2\2\2\u04dc\u00e9\3\2\2\2\u04dd\u04de\7\32\2\2\u04de\u04df\7"+
		"\33\2\2\u04df\u00eb\3\2\2\2\u04e0\u04e1\t\31\2\2\u04e1\u00ed\3\2\2\2\u04e2"+
		"\u04e3\5\u00f0y\2\u04e3\u00ef\3\2\2\2\u04e4\u04e5\t\32\2\2\u04e5\u00f1"+
		"\3\2\2\2\u04e6\u04e7\5\u00b2Z\2\u04e7\u00f3\3\2\2\2\u04e8\u04ee\5\u00bc"+
		"_\2\u04e9\u04eb\5\u00b8]\2\u04ea\u04ec\5\u00bc_\2\u04eb\u04ea\3\2\2\2"+
		"\u04eb\u04ec\3\2\2\2\u04ec\u04ee\3\2\2\2\u04ed\u04e8\3\2\2\2\u04ed\u04e9"+
		"\3\2\2\2\u04ee\u00f5\3\2\2\2\u04ef\u04f0\5\u00b2Z\2\u04f0\u00f7\3\2\2"+
		"\2\u04f1\u04f2\5\u00b2Z\2\u04f2\u00f9\3\2\2\2\u04f3\u04f4\7\32\2\2\u04f4"+
		"\u04f9\5\u00f8}\2\u04f5\u04f6\7\27\2\2\u04f6\u04f8\5\u00f8}\2\u04f7\u04f5"+
		"\3\2\2\2\u04f8\u04fb\3\2\2\2\u04f9\u04f7\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa"+
		"\u04fc\3\2\2\2\u04fb\u04f9\3\2\2\2\u04fc\u04fd\7\33\2\2\u04fd\u00fb\3"+
		"\2\2\2\u04fe\u04ff\5\u00f4{\2\u04ff\u00fd\3\2\2\2\u0500\u0508\5\u00b2"+
		"Z\2\u0501\u0502\7\26\2\2\u0502\u0509\7\23\2\2\u0503\u0506\5\u00bc_\2\u0504"+
		"\u0505\7\26\2\2\u0505\u0507\7\23\2\2\u0506\u0504\3\2\2\2\u0506\u0507\3"+
		"\2\2\2\u0507\u0509\3\2\2\2\u0508\u0501\3\2\2\2\u0508\u0503\3\2\2\2\u0508"+
		"\u0509\3\2\2\2\u0509\u00ff\3\2\2\2\u050a\u050f\5\u00fe\u0080\2\u050b\u050c"+
		"\7\27\2\2\u050c\u050e\5\u00fe\u0080\2\u050d\u050b\3\2\2\2\u050e\u0511"+
		"\3\2\2\2\u050f\u050d\3\2\2\2\u050f\u0510\3\2\2\2\u0510\u0101\3\2\2\2\u0511"+
		"\u050f\3\2\2\2\u0512\u0513\5\u00b2Z\2\u0513\u0517\7\26\2\2\u0514\u0515"+
		"\5\u00b2Z\2\u0515\u0516\7\26\2\2\u0516\u0518\3\2\2\2\u0517\u0514\3\2\2"+
		"\2\u0517\u0518\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051a\7\23\2\2\u051a"+
		"\u0103\3\2\2\2\u051b\u051e\5\u00b8]\2\u051c\u051e\5\u00bc_\2\u051d\u051b"+
		"\3\2\2\2\u051d\u051c\3\2\2\2\u051e\u0105\3\2\2\2\u051f\u0522\7\32\2\2"+
		"\u0520\u0523\5\u00c4c\2\u0521\u0523\7$\2\2\u0522\u0520\3\2\2\2\u0522\u0521"+
		"\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0525\7\33\2\2\u0525\u0107\3\2\2\2"+
		"\u0526\u0527\7\32\2\2\u0527\u0528\7#\2\2\u0528\u0529\7\33\2\2\u0529\u0109"+
		"\3\2\2\2\u00a4\u0111\u0114\u0118\u011b\u0120\u0123\u0125\u0128\u012d\u012f"+
		"\u0136\u013a\u013c\u0141\u0145\u0149\u014f\u0157\u015c\u015f\u0162\u0165"+
		"\u0174\u0178\u0183\u018f\u0194\u0197\u019a\u019f\u01a5\u01b0\u01bf\u01c8"+
		"\u01cc\u01d3\u01d8\u01ea\u01f1\u01fa\u01fd\u0203\u020a\u020e\u0214\u021a"+
		"\u021c\u021f\u0223\u022c\u0233\u023c\u0244\u0246\u0249\u024f\u0257\u025b"+
		"\u0260\u0266\u0269\u026e\u0271\u0273\u0278\u027f\u0287\u028a\u028e\u0296"+
		"\u0298\u02a1\u02ad\u02af\u02b6\u02b9\u02c1\u02cc\u02ce\u02d9\u02db\u02ed"+
		"\u02f4\u0305\u030c\u030f\u0313\u031a\u0320\u0325\u032a\u032f\u0334\u033a"+
		"\u033e\u0343\u0348\u034d\u0352\u0359\u0360\u0365\u036a\u036f\u0373\u0377"+
		"\u037b\u037d\u0390\u0399\u039e\u03a3\u03a7\u03aa\u03b3\u03ba\u03bf\u03c8"+
		"\u03dc\u03e1\u03e5\u03f2\u03f8\u03fa\u0401\u0408\u040c\u0413\u0418\u0426"+
		"\u0428\u042f\u0447\u044c\u0453\u045c\u0463\u046c\u0471\u0473\u0486\u048d"+
		"\u0495\u049c\u04a1\u04a5\u04a9\u04ae\u04b8\u04c7\u04cb\u04d7\u04db\u04eb"+
		"\u04ed\u04f9\u0506\u0508\u050f\u0517\u051d\u0522";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}