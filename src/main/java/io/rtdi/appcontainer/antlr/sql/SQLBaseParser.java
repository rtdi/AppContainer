// Generated from SQLBaseParser.g4 by ANTLR 4.8
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
public class SQLBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT2_SYMBOL=1, CONCAT_PIPES_SYMBOL=2, LONG_NUMBER=3, ULONGLONG_NUMBER=4, 
		EQUAL_OPERATOR=5, ASSIGN_OPERATOR=6, NULL_SAFE_EQUAL_OPERATOR=7, GREATER_OR_EQUAL_OPERATOR=8, 
		GREATER_THAN_OPERATOR=9, LESS_OR_EQUAL_OPERATOR=10, LESS_THAN_OPERATOR=11, 
		NOT_EQUAL_OPERATOR=12, PLUS_OPERATOR=13, MINUS_OPERATOR=14, MULT_OPERATOR=15, 
		DIV_OPERATOR=16, MOD_OPERATOR=17, DOT_SYMBOL=18, COMMA_SYMBOL=19, SEMICOLON_SYMBOL=20, 
		COLON_SYMBOL=21, OPEN_PAR_SYMBOL=22, CLOSE_PAR_SYMBOL=23, OPEN_CURLY_SYMBOL=24, 
		CLOSE_CURLY_SYMBOL=25, UNDERLINE_SYMBOL=26, NULL2_SYMBOL=27, PARAM_MARKER=28, 
		HEX_NUMBER=29, BIN_NUMBER=30, INT_NUMBER=31, DECIMAL_NUMBER=32, FLOAT_NUMBER=33, 
		DOT_IDENTIFIER=34, LOCATE_SYMBOL=35, ASCII_SYMBOL=36, COALESCE_SYMBOL=37, 
		SUBSTR_SYMBOL=38, SUBSTRING_SYMBOL=39, AND_SYMBOL=40, OR_SYMBOL=41, NOT_SYMBOL=42, 
		UNION_SYMBOL=43, ALL_SYMBOL=44, CURRENT_USER_SYMBOL=45, ROWS_SYMBOL=46, 
		WINDOW_SYMBOL=47, PARTITION_SYMBOL=48, BY_SYMBOL=49, DENSE_RANK_SYMBOL=50, 
		FIRST_VALUE_SYMBOL=51, LAG_SYMBOL=52, LAST_VALUE_SYMBOL=53, LEAD_SYMBOL=54, 
		NTILE_SYMBOL=55, NULLS_SYMBOL=56, OVER_SYMBOL=57, PRECEDING_SYMBOL=58, 
		RANK_SYMBOL=59, ROW_NUMBER_SYMBOL=60, UNBOUNDED_SYMBOL=61, INTERVAL_SYMBOL=62, 
		CURRENT_SYMBOL=63, ROW_SYMBOL=64, FOLLOWING_SYMBOL=65, EXCLUDE_SYMBOL=66, 
		TIES_SYMBOL=67, OTHERS_SYMBOL=68, RECURSIVE_SYMBOL=69, AVG_SYMBOL=70, 
		COUNT_SYMBOL=71, DISTINCT_SYMBOL=72, SUM_SYMBOL=73, MAX_SYMBOL=74, MIN_SYMBOL=75, 
		STD_SYMBOL=76, STDDEV_SYMBOL=77, VARIANCE_SYMBOL=78, GROUP_CONCAT_SYMBOL=79, 
		SEPARATOR_SYMBOL=80, FOR_SYMBOL=81, MODE_SYMBOL=82, SHARE_SYMBOL=83, UPDATE_SYMBOL=84, 
		LOCK_SYMBOL=85, SKIP_SYMBOL=86, LOCKED_SYMBOL=87, CROSS_SYMBOL=88, INNER_SYMBOL=89, 
		JOIN_SYMBOL=90, LEFT_SYMBOL=91, RIGHT_SYMBOL=92, LATERAL_SYMBOL=93, ELSE_SYMBOL=94, 
		THEN_SYMBOL=95, WHEN_SYMBOL=96, ANY_SYMBOL=97, AS_SYMBOL=98, ASC_SYMBOL=99, 
		AT_SYMBOL=100, BETWEEN_SYMBOL=101, CASE_SYMBOL=102, CAST_SYMBOL=103, CONTAINS_SYMBOL=104, 
		DATE_SYMBOL=105, DESC_SYMBOL=106, DUMMY_SYMBOL=107, END_SYMBOL=108, ESCAPE_SYMBOL=109, 
		EXISTS_SYMBOL=110, FALSE_SYMBOL=111, FIRST_SYMBOL=112, FROM_SYMBOL=113, 
		FULL_SYMBOL=114, FULLTEXT_SYMBOL=115, FUNCTION_SYMBOL=116, GROUP_SYMBOL=117, 
		HAVING_SYMBOL=118, IN_SYMBOL=119, IS_SYMBOL=120, KEYS_SYMBOL=121, LAST_SYMBOL=122, 
		LIKE_SYMBOL=123, LIMIT_SYMBOL=124, NOW_SYMBOL=125, NO_SYMBOL=126, NULL_SYMBOL=127, 
		OFFSET_SYMBOL=128, ON_SYMBOL=129, ORDER_SYMBOL=130, OUTER_SYMBOL=131, 
		SELECT_SYMBOL=132, TIMESTAMP_SYMBOL=133, TIME_SYMBOL=134, TO_SYMBOL=135, 
		TRUE_SYMBOL=136, UNKNOWN_SYMBOL=137, USING_SYMBOL=138, WHERE_SYMBOL=139, 
		WITH_SYMBOL=140, OF_SYMBOL=141, NOWAIT_SYMBOL=142, GROUPING_SYMBOL=143, 
		WHITESPACE=144, INVALID_INPUT=145, IDENTIFIER=146, NCHAR_TEXT=147, DOUBLE_QUOTED_TEXT=148, 
		SINGLE_QUOTED_TEXT=149, BLOCK_COMMENT=150, POUND_COMMENT=151, DASHDASH_COMMENT=152, 
		SLASHSLASH_COMMENT=153, NOT_EQUAL2_OPERATOR=154;
	public static final int
		RULE_selectStatement = 0, RULE_queryExpression = 1, RULE_queryExpressionBody = 2, 
		RULE_queryExpressionParens = 3, RULE_querySpecification = 4, RULE_subquery = 5, 
		RULE_querySpecOption = 6, RULE_limitClause = 7, RULE_simpleLimitClause = 8, 
		RULE_limitOptions = 9, RULE_limitOption = 10, RULE_havingClause = 11, 
		RULE_windowClause = 12, RULE_windowDefinition = 13, RULE_windowSpec = 14, 
		RULE_windowSpecDetails = 15, RULE_windowFrameClause = 16, RULE_windowFrameUnits = 17, 
		RULE_windowFrameExtent = 18, RULE_windowFrameStart = 19, RULE_windowFrameBetween = 20, 
		RULE_windowFrameBound = 21, RULE_windowFrameExclusion = 22, RULE_withClause = 23, 
		RULE_commonTableExpression = 24, RULE_groupByClause = 25, RULE_orderClause = 26, 
		RULE_direction = 27, RULE_fromClause = 28, RULE_tableReferenceList = 29, 
		RULE_selectOption = 30, RULE_lockingClause = 31, RULE_lockStrengh = 32, 
		RULE_lockedRowAction = 33, RULE_selectItemList = 34, RULE_selectItem = 35, 
		RULE_selectAlias = 36, RULE_whereClause = 37, RULE_tableReference = 38, 
		RULE_escapedTableReference = 39, RULE_joinedTable = 40, RULE_innerJoinType = 41, 
		RULE_outerJoinType = 42, RULE_tableFactor = 43, RULE_singleTable = 44, 
		RULE_singleTableParens = 45, RULE_derivedTable = 46, RULE_tableReferenceListParens = 47, 
		RULE_unionOption = 48, RULE_tableAlias = 49, RULE_expr = 50, RULE_boolPri = 51, 
		RULE_compOp = 52, RULE_predicate = 53, RULE_predicateOperations = 54, 
		RULE_bitExpr = 55, RULE_simpleExpr = 56, RULE_sumExpr = 57, RULE_groupingOperation = 58, 
		RULE_windowFunctionCall = 59, RULE_windowingClause = 60, RULE_leadLagInfo = 61, 
		RULE_inSumExpr = 62, RULE_identListArg = 63, RULE_identList = 64, RULE_runtimeFunctionCall = 65, 
		RULE_timeFunctionParameters = 66, RULE_fractionalPrecision = 67, RULE_substringFunction = 68, 
		RULE_functionCall = 69, RULE_udfExprList = 70, RULE_udfExpr = 71, RULE_whenExpression = 72, 
		RULE_thenExpression = 73, RULE_elseExpression = 74, RULE_castType = 75, 
		RULE_exprList = 76, RULE_notRule = 77, RULE_not2Rule = 78, RULE_exprListWithParentheses = 79, 
		RULE_exprWithParentheses = 80, RULE_simpleExprWithParentheses = 81, RULE_orderList = 82, 
		RULE_orderExpression = 83, RULE_groupList = 84, RULE_groupingExpression = 85, 
		RULE_pureIdentifier = 86, RULE_identifier = 87, RULE_identifierList = 88, 
		RULE_identifierListWithParentheses = 89, RULE_qualifiedIdentifier = 90, 
		RULE_simpleIdentifier = 91, RULE_dotIdentifier = 92, RULE_ulong_number = 93, 
		RULE_real_ulong_number = 94, RULE_ulonglong_number = 95, RULE_real_ulonglong_number = 96, 
		RULE_literal = 97, RULE_signedLiteral = 98, RULE_stringList = 99, RULE_textStringLiteral = 100, 
		RULE_textString = 101, RULE_textStringHash = 102, RULE_textLiteral = 103, 
		RULE_textStringNoLinebreak = 104, RULE_textStringLiteralList = 105, RULE_numLiteral = 106, 
		RULE_boolLiteral = 107, RULE_nullLiteral = 108, RULE_temporalLiteral = 109, 
		RULE_floatOptions = 110, RULE_standardFloatOptions = 111, RULE_precision = 112, 
		RULE_textOrIdentifier = 113, RULE_sizeNumber = 114, RULE_parentheses = 115, 
		RULE_equal = 116, RULE_identifierKeyword = 117, RULE_identifierKeywordsUnambiguous = 118, 
		RULE_windowName = 119, RULE_fieldIdentifier = 120, RULE_columnName = 121, 
		RULE_columnInternalRef = 122, RULE_columnInternalRefList = 123, RULE_columnRef = 124, 
		RULE_tableRefWithWildcard = 125, RULE_tableAliasRefList = 126, RULE_tableWild = 127, 
		RULE_tableRef = 128, RULE_fieldLength = 129, RULE_typeDatetimePrecision = 130;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "queryExpression", "queryExpressionBody", "queryExpressionParens", 
			"querySpecification", "subquery", "querySpecOption", "limitClause", "simpleLimitClause", 
			"limitOptions", "limitOption", "havingClause", "windowClause", "windowDefinition", 
			"windowSpec", "windowSpecDetails", "windowFrameClause", "windowFrameUnits", 
			"windowFrameExtent", "windowFrameStart", "windowFrameBetween", "windowFrameBound", 
			"windowFrameExclusion", "withClause", "commonTableExpression", "groupByClause", 
			"orderClause", "direction", "fromClause", "tableReferenceList", "selectOption", 
			"lockingClause", "lockStrengh", "lockedRowAction", "selectItemList", 
			"selectItem", "selectAlias", "whereClause", "tableReference", "escapedTableReference", 
			"joinedTable", "innerJoinType", "outerJoinType", "tableFactor", "singleTable", 
			"singleTableParens", "derivedTable", "tableReferenceListParens", "unionOption", 
			"tableAlias", "expr", "boolPri", "compOp", "predicate", "predicateOperations", 
			"bitExpr", "simpleExpr", "sumExpr", "groupingOperation", "windowFunctionCall", 
			"windowingClause", "leadLagInfo", "inSumExpr", "identListArg", "identList", 
			"runtimeFunctionCall", "timeFunctionParameters", "fractionalPrecision", 
			"substringFunction", "functionCall", "udfExprList", "udfExpr", "whenExpression", 
			"thenExpression", "elseExpression", "castType", "exprList", "notRule", 
			"not2Rule", "exprListWithParentheses", "exprWithParentheses", "simpleExprWithParentheses", 
			"orderList", "orderExpression", "groupList", "groupingExpression", "pureIdentifier", 
			"identifier", "identifierList", "identifierListWithParentheses", "qualifiedIdentifier", 
			"simpleIdentifier", "dotIdentifier", "ulong_number", "real_ulong_number", 
			"ulonglong_number", "real_ulonglong_number", "literal", "signedLiteral", 
			"stringList", "textStringLiteral", "textString", "textStringHash", "textLiteral", 
			"textStringNoLinebreak", "textStringLiteralList", "numLiteral", "boolLiteral", 
			"nullLiteral", "temporalLiteral", "floatOptions", "standardFloatOptions", 
			"precision", "textOrIdentifier", "sizeNumber", "parentheses", "equal", 
			"identifierKeyword", "identifierKeywordsUnambiguous", "windowName", "fieldIdentifier", 
			"columnName", "columnInternalRef", "columnInternalRefList", "columnRef", 
			"tableRefWithWildcard", "tableAliasRefList", "tableWild", "tableRef", 
			"fieldLength", "typeDatetimePrecision"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'='", "':='", "'<=>'", "'>='", "'>'", 
			"'<='", "'<'", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "','", 
			"';'", "':'", "'('", "')'", "'{'", "'}'", "'_'", "'\\N'", "'?'", null, 
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
			null, null, null, null, "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NOT2_SYMBOL", "CONCAT_PIPES_SYMBOL", "LONG_NUMBER", "ULONGLONG_NUMBER", 
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
	public String getGrammarFileName() { return "SQLBaseParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				queryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQueryExpression(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_queryExpression);
		int _la;
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH_SYMBOL) {
					{
					setState(266);
					withClause();
					}
				}

				setState(284);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(269);
					queryExpressionBody(0);
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER_SYMBOL) {
						{
						setState(270);
						orderClause();
						}
					}

					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LIMIT_SYMBOL) {
						{
						setState(273);
						limitClause();
						}
					}

					}
					break;
				case 2:
					{
					setState(276);
					queryExpressionParens();
					setState(282);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ORDER_SYMBOL:
						{
						setState(277);
						orderClause();
						setState(279);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LIMIT_SYMBOL) {
							{
							setState(278);
							limitClause();
							}
						}

						}
						break;
					case LIMIT_SYMBOL:
						{
						setState(281);
						limitClause();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(286);
					lockingClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				withClause();
				setState(290);
				queryExpressionParens();
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL || _la==LOCK_SYMBOL) {
					{
					setState(291);
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
		public TerminalNode UNION_SYMBOL() { return getToken(SQLBaseParser.UNION_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQueryExpressionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQueryExpressionBody(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_queryExpressionBody, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT_SYMBOL:
				{
				setState(297);
				querySpecification();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(298);
				queryExpressionParens();
				setState(299);
				match(UNION_SYMBOL);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
					{
					setState(300);
					unionOption();
					}
				}

				setState(305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT_SYMBOL:
					{
					setState(303);
					querySpecification();
					}
					break;
				case OPEN_PAR_SYMBOL:
					{
					setState(304);
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
			setState(320);
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
					setState(309);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(310);
					match(UNION_SYMBOL);
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
						{
						setState(311);
						unionOption();
						}
					}

					setState(316);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SELECT_SYMBOL:
						{
						setState(314);
						querySpecification();
						}
						break;
					case OPEN_PAR_SYMBOL:
						{
						setState(315);
						queryExpressionParens();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(322);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQueryExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQueryExpressionParens(this);
		}
	}

	public final QueryExpressionParensContext queryExpressionParens() throws RecognitionException {
		QueryExpressionParensContext _localctx = new QueryExpressionParensContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_queryExpressionParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(OPEN_PAR_SYMBOL);
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(324);
				queryExpressionParens();
				}
				break;
			case 2:
				{
				setState(325);
				queryExpression();
				}
				break;
			}
			setState(328);
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
		public TerminalNode SELECT_SYMBOL() { return getToken(SQLBaseParser.SELECT_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQuerySpecification(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(SELECT_SYMBOL);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALL_SYMBOL || _la==DISTINCT_SYMBOL) {
				{
				{
				setState(331);
				selectOption();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			selectItemList();
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(338);
				fromClause();
				}
				break;
			}
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(341);
				whereClause();
				}
				break;
			}
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(344);
				groupByClause();
				}
				break;
			}
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(347);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
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
		public TerminalNode ALL_SYMBOL() { return getToken(SQLBaseParser.ALL_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(SQLBaseParser.DISTINCT_SYMBOL, 0); }
		public QuerySpecOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQuerySpecOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQuerySpecOption(this);
		}
	}

	public final QuerySpecOptionContext querySpecOption() throws RecognitionException {
		QuerySpecOptionContext _localctx = new QuerySpecOptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_querySpecOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
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
		public TerminalNode LIMIT_SYMBOL() { return getToken(SQLBaseParser.LIMIT_SYMBOL, 0); }
		public LimitOptionsContext limitOptions() {
			return getRuleContext(LimitOptionsContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(LIMIT_SYMBOL);
			setState(355);
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
		public TerminalNode LIMIT_SYMBOL() { return getToken(SQLBaseParser.LIMIT_SYMBOL, 0); }
		public LimitOptionContext limitOption() {
			return getRuleContext(LimitOptionContext.class,0);
		}
		public SimpleLimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLimitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleLimitClause(this);
		}
	}

	public final SimpleLimitClauseContext simpleLimitClause() throws RecognitionException {
		SimpleLimitClauseContext _localctx = new SimpleLimitClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simpleLimitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(LIMIT_SYMBOL);
			setState(358);
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
		public TerminalNode COMMA_SYMBOL() { return getToken(SQLBaseParser.COMMA_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(SQLBaseParser.OFFSET_SYMBOL, 0); }
		public LimitOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLimitOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLimitOptions(this);
		}
	}

	public final LimitOptionsContext limitOptions() throws RecognitionException {
		LimitOptionsContext _localctx = new LimitOptionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_limitOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			limitOption();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) {
				{
				setState(361);
				_la = _input.LA(1);
				if ( !(_la==COMMA_SYMBOL || _la==OFFSET_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(362);
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
		public TerminalNode PARAM_MARKER() { return getToken(SQLBaseParser.PARAM_MARKER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public LimitOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLimitOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLimitOption(this);
		}
	}

	public final LimitOptionContext limitOption() throws RecognitionException {
		LimitOptionContext _localctx = new LimitOptionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_limitOption);
		int _la;
		try {
			setState(367);
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
				setState(365);
				identifier();
				}
				break;
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case PARAM_MARKER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
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
		public TerminalNode HAVING_SYMBOL() { return getToken(SQLBaseParser.HAVING_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(HAVING_SYMBOL);
			setState(370);
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
		public TerminalNode WINDOW_SYMBOL() { return getToken(SQLBaseParser.WINDOW_SYMBOL, 0); }
		public List<WindowDefinitionContext> windowDefinition() {
			return getRuleContexts(WindowDefinitionContext.class);
		}
		public WindowDefinitionContext windowDefinition(int i) {
			return getRuleContext(WindowDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public WindowClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowClause(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_windowClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(WINDOW_SYMBOL);
			setState(373);
			windowDefinition();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(374);
				match(COMMA_SYMBOL);
				setState(375);
				windowDefinition();
				}
				}
				setState(380);
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
		public TerminalNode AS_SYMBOL() { return getToken(SQLBaseParser.AS_SYMBOL, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public WindowDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowDefinition(this);
		}
	}

	public final WindowDefinitionContext windowDefinition() throws RecognitionException {
		WindowDefinitionContext _localctx = new WindowDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_windowDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			windowName();
			setState(382);
			match(AS_SYMBOL);
			setState(383);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public WindowSpecDetailsContext windowSpecDetails() {
			return getRuleContext(WindowSpecDetailsContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowSpec(this);
		}
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_windowSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(OPEN_PAR_SYMBOL);
			setState(386);
			windowSpecDetails();
			setState(387);
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
		public TerminalNode PARTITION_SYMBOL() { return getToken(SQLBaseParser.PARTITION_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(SQLBaseParser.BY_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowSpecDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowSpecDetails(this);
		}
	}

	public final WindowSpecDetailsContext windowSpecDetails() throws RecognitionException {
		WindowSpecDetailsContext _localctx = new WindowSpecDetailsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_windowSpecDetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (COALESCE_SYMBOL - 37)) | (1L << (NULLS_SYMBOL - 37)) | (1L << (PRECEDING_SYMBOL - 37)) | (1L << (UNBOUNDED_SYMBOL - 37)) | (1L << (CURRENT_SYMBOL - 37)) | (1L << (FOLLOWING_SYMBOL - 37)) | (1L << (EXCLUDE_SYMBOL - 37)) | (1L << (TIES_SYMBOL - 37)) | (1L << (OTHERS_SYMBOL - 37)) | (1L << (AVG_SYMBOL - 37)) | (1L << (MODE_SYMBOL - 37)) | (1L << (SHARE_SYMBOL - 37)) | (1L << (SKIP_SYMBOL - 37)) | (1L << (LOCKED_SYMBOL - 37)) | (1L << (ANY_SYMBOL - 37)) | (1L << (AT_SYMBOL - 37)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (DATE_SYMBOL - 105)) | (1L << (ESCAPE_SYMBOL - 105)) | (1L << (FIRST_SYMBOL - 105)) | (1L << (FULL_SYMBOL - 105)) | (1L << (LAST_SYMBOL - 105)) | (1L << (OFFSET_SYMBOL - 105)) | (1L << (TIMESTAMP_SYMBOL - 105)) | (1L << (TIME_SYMBOL - 105)) | (1L << (UNKNOWN_SYMBOL - 105)) | (1L << (NOWAIT_SYMBOL - 105)) | (1L << (IDENTIFIER - 105)) | (1L << (DOUBLE_QUOTED_TEXT - 105)))) != 0)) {
				{
				setState(389);
				windowName();
				}
			}

			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION_SYMBOL) {
				{
				setState(392);
				match(PARTITION_SYMBOL);
				setState(393);
				match(BY_SYMBOL);
				setState(394);
				orderList();
				}
			}

			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_SYMBOL) {
				{
				setState(397);
				orderClause();
				}
			}

			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROWS_SYMBOL) {
				{
				setState(400);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameClause(this);
		}
	}

	public final WindowFrameClauseContext windowFrameClause() throws RecognitionException {
		WindowFrameClauseContext _localctx = new WindowFrameClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_windowFrameClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			windowFrameUnits();
			setState(404);
			windowFrameExtent();
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUDE_SYMBOL) {
				{
				setState(405);
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
		public TerminalNode ROWS_SYMBOL() { return getToken(SQLBaseParser.ROWS_SYMBOL, 0); }
		public WindowFrameUnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameUnits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameUnits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameUnits(this);
		}
	}

	public final WindowFrameUnitsContext windowFrameUnits() throws RecognitionException {
		WindowFrameUnitsContext _localctx = new WindowFrameUnitsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_windowFrameUnits);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameExtent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameExtent(this);
		}
	}

	public final WindowFrameExtentContext windowFrameExtent() throws RecognitionException {
		WindowFrameExtentContext _localctx = new WindowFrameExtentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_windowFrameExtent);
		try {
			setState(412);
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
				setState(410);
				windowFrameStart();
				}
				break;
			case BETWEEN_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
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
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(SQLBaseParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(SQLBaseParser.PRECEDING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(SQLBaseParser.PARAM_MARKER, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(SQLBaseParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(SQLBaseParser.ROW_SYMBOL, 0); }
		public WindowFrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameStart(this);
		}
	}

	public final WindowFrameStartContext windowFrameStart() throws RecognitionException {
		WindowFrameStartContext _localctx = new WindowFrameStartContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_windowFrameStart);
		try {
			setState(423);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNBOUNDED_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				match(UNBOUNDED_SYMBOL);
				setState(415);
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
				setState(416);
				ulonglong_number();
				setState(417);
				match(PRECEDING_SYMBOL);
				}
				break;
			case PARAM_MARKER:
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				match(PARAM_MARKER);
				setState(420);
				match(PRECEDING_SYMBOL);
				}
				break;
			case CURRENT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(421);
				match(CURRENT_SYMBOL);
				setState(422);
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
		public TerminalNode BETWEEN_SYMBOL() { return getToken(SQLBaseParser.BETWEEN_SYMBOL, 0); }
		public List<WindowFrameBoundContext> windowFrameBound() {
			return getRuleContexts(WindowFrameBoundContext.class);
		}
		public WindowFrameBoundContext windowFrameBound(int i) {
			return getRuleContext(WindowFrameBoundContext.class,i);
		}
		public TerminalNode AND_SYMBOL() { return getToken(SQLBaseParser.AND_SYMBOL, 0); }
		public WindowFrameBetweenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBetween; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameBetween(this);
		}
	}

	public final WindowFrameBetweenContext windowFrameBetween() throws RecognitionException {
		WindowFrameBetweenContext _localctx = new WindowFrameBetweenContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_windowFrameBetween);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(BETWEEN_SYMBOL);
			setState(426);
			windowFrameBound();
			setState(427);
			match(AND_SYMBOL);
			setState(428);
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
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(SQLBaseParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(SQLBaseParser.FOLLOWING_SYMBOL, 0); }
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(SQLBaseParser.PARAM_MARKER, 0); }
		public WindowFrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameBound(this);
		}
	}

	public final WindowFrameBoundContext windowFrameBound() throws RecognitionException {
		WindowFrameBoundContext _localctx = new WindowFrameBoundContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_windowFrameBound);
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				windowFrameStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(UNBOUNDED_SYMBOL);
				setState(432);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				ulonglong_number();
				setState(434);
				match(FOLLOWING_SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(436);
				match(PARAM_MARKER);
				setState(437);
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
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(SQLBaseParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(SQLBaseParser.CURRENT_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(SQLBaseParser.ROW_SYMBOL, 0); }
		public TerminalNode GROUP_SYMBOL() { return getToken(SQLBaseParser.GROUP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(SQLBaseParser.TIES_SYMBOL, 0); }
		public TerminalNode NO_SYMBOL() { return getToken(SQLBaseParser.NO_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(SQLBaseParser.OTHERS_SYMBOL, 0); }
		public WindowFrameExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameExclusion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFrameExclusion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFrameExclusion(this);
		}
	}

	public final WindowFrameExclusionContext windowFrameExclusion() throws RecognitionException {
		WindowFrameExclusionContext _localctx = new WindowFrameExclusionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_windowFrameExclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(EXCLUDE_SYMBOL);
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_SYMBOL:
				{
				setState(441);
				match(CURRENT_SYMBOL);
				setState(442);
				match(ROW_SYMBOL);
				}
				break;
			case GROUP_SYMBOL:
				{
				setState(443);
				match(GROUP_SYMBOL);
				}
				break;
			case TIES_SYMBOL:
				{
				setState(444);
				match(TIES_SYMBOL);
				}
				break;
			case NO_SYMBOL:
				{
				setState(445);
				match(NO_SYMBOL);
				setState(446);
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
		public TerminalNode WITH_SYMBOL() { return getToken(SQLBaseParser.WITH_SYMBOL, 0); }
		public List<CommonTableExpressionContext> commonTableExpression() {
			return getRuleContexts(CommonTableExpressionContext.class);
		}
		public CommonTableExpressionContext commonTableExpression(int i) {
			return getRuleContext(CommonTableExpressionContext.class,i);
		}
		public TerminalNode RECURSIVE_SYMBOL() { return getToken(SQLBaseParser.RECURSIVE_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWithClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWithClause(this);
		}
	}

	public final WithClauseContext withClause() throws RecognitionException {
		WithClauseContext _localctx = new WithClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_withClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(WITH_SYMBOL);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RECURSIVE_SYMBOL) {
				{
				setState(450);
				match(RECURSIVE_SYMBOL);
				}
			}

			setState(453);
			commonTableExpression();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(454);
				match(COMMA_SYMBOL);
				setState(455);
				commonTableExpression();
				}
				}
				setState(460);
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
		public TerminalNode AS_SYMBOL() { return getToken(SQLBaseParser.AS_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterCommonTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitCommonTableExpression(this);
		}
	}

	public final CommonTableExpressionContext commonTableExpression() throws RecognitionException {
		CommonTableExpressionContext _localctx = new CommonTableExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_commonTableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			identifier();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR_SYMBOL) {
				{
				setState(462);
				columnInternalRefList();
				}
			}

			setState(465);
			match(AS_SYMBOL);
			setState(466);
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
		public TerminalNode GROUP_SYMBOL() { return getToken(SQLBaseParser.GROUP_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(SQLBaseParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(GROUP_SYMBOL);
			setState(469);
			match(BY_SYMBOL);
			setState(470);
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
		public TerminalNode ORDER_SYMBOL() { return getToken(SQLBaseParser.ORDER_SYMBOL, 0); }
		public TerminalNode BY_SYMBOL() { return getToken(SQLBaseParser.BY_SYMBOL, 0); }
		public OrderListContext orderList() {
			return getRuleContext(OrderListContext.class,0);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_orderClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(ORDER_SYMBOL);
			setState(473);
			match(BY_SYMBOL);
			setState(474);
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
		public TerminalNode ASC_SYMBOL() { return getToken(SQLBaseParser.ASC_SYMBOL, 0); }
		public TerminalNode DESC_SYMBOL() { return getToken(SQLBaseParser.DESC_SYMBOL, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitDirection(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_direction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
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
		public TerminalNode FROM_SYMBOL() { return getToken(SQLBaseParser.FROM_SYMBOL, 0); }
		public TerminalNode DUMMY_SYMBOL() { return getToken(SQLBaseParser.DUMMY_SYMBOL, 0); }
		public TableReferenceListContext tableReferenceList() {
			return getRuleContext(TableReferenceListContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(FROM_SYMBOL);
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DUMMY_SYMBOL:
				{
				setState(479);
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
				setState(480);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public TableReferenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReferenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableReferenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableReferenceList(this);
		}
	}

	public final TableReferenceListContext tableReferenceList() throws RecognitionException {
		TableReferenceListContext _localctx = new TableReferenceListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_tableReferenceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			tableReference();
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(484);
					match(COMMA_SYMBOL);
					setState(485);
					tableReference();
					}
					} 
				}
				setState(490);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSelectOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSelectOption(this);
		}
	}

	public final SelectOptionContext selectOption() throws RecognitionException {
		SelectOptionContext _localctx = new SelectOptionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_selectOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
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
		public TerminalNode FOR_SYMBOL() { return getToken(SQLBaseParser.FOR_SYMBOL, 0); }
		public LockStrenghContext lockStrengh() {
			return getRuleContext(LockStrenghContext.class,0);
		}
		public TerminalNode OF_SYMBOL() { return getToken(SQLBaseParser.OF_SYMBOL, 0); }
		public TableAliasRefListContext tableAliasRefList() {
			return getRuleContext(TableAliasRefListContext.class,0);
		}
		public LockedRowActionContext lockedRowAction() {
			return getRuleContext(LockedRowActionContext.class,0);
		}
		public TerminalNode LOCK_SYMBOL() { return getToken(SQLBaseParser.LOCK_SYMBOL, 0); }
		public TerminalNode IN_SYMBOL() { return getToken(SQLBaseParser.IN_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(SQLBaseParser.SHARE_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(SQLBaseParser.MODE_SYMBOL, 0); }
		public LockingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLockingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLockingClause(this);
		}
	}

	public final LockingClauseContext lockingClause() throws RecognitionException {
		LockingClauseContext _localctx = new LockingClauseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lockingClause);
		int _la;
		try {
			setState(506);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				match(FOR_SYMBOL);
				setState(494);
				lockStrengh();
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OF_SYMBOL) {
					{
					setState(495);
					match(OF_SYMBOL);
					setState(496);
					tableAliasRefList();
					}
				}

				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SKIP_SYMBOL || _la==NOWAIT_SYMBOL) {
					{
					setState(499);
					lockedRowAction();
					}
				}

				}
				break;
			case LOCK_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				match(LOCK_SYMBOL);
				setState(503);
				match(IN_SYMBOL);
				setState(504);
				match(SHARE_SYMBOL);
				setState(505);
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
		public TerminalNode UPDATE_SYMBOL() { return getToken(SQLBaseParser.UPDATE_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(SQLBaseParser.SHARE_SYMBOL, 0); }
		public LockStrenghContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockStrengh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLockStrengh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLockStrengh(this);
		}
	}

	public final LockStrenghContext lockStrengh() throws RecognitionException {
		LockStrenghContext _localctx = new LockStrenghContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lockStrengh);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
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
		public TerminalNode SKIP_SYMBOL() { return getToken(SQLBaseParser.SKIP_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(SQLBaseParser.LOCKED_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(SQLBaseParser.NOWAIT_SYMBOL, 0); }
		public LockedRowActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockedRowAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLockedRowAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLockedRowAction(this);
		}
	}

	public final LockedRowActionContext lockedRowAction() throws RecognitionException {
		LockedRowActionContext _localctx = new LockedRowActionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lockedRowAction);
		try {
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				match(SKIP_SYMBOL);
				setState(511);
				match(LOCKED_SYMBOL);
				}
				break;
			case NOWAIT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
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
		public TerminalNode MULT_OPERATOR() { return getToken(SQLBaseParser.MULT_OPERATOR, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public SelectItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSelectItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSelectItemList(this);
		}
	}

	public final SelectItemListContext selectItemList() throws RecognitionException {
		SelectItemListContext _localctx = new SelectItemListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selectItemList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
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
				setState(515);
				selectItem();
				}
				break;
			case MULT_OPERATOR:
				{
				setState(516);
				match(MULT_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(523);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(519);
					match(COMMA_SYMBOL);
					setState(520);
					selectItem();
					}
					} 
				}
				setState(525);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSelectItem(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectItem);
		try {
			setState(531);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(526);
				tableWild();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(527);
				expr(0);
				setState(529);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(528);
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
		public TerminalNode AS_SYMBOL() { return getToken(SQLBaseParser.AS_SYMBOL, 0); }
		public SelectAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSelectAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSelectAlias(this);
		}
	}

	public final SelectAliasContext selectAlias() throws RecognitionException {
		SelectAliasContext _localctx = new SelectAliasContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_selectAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(533);
				match(AS_SYMBOL);
				}
			}

			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(536);
				identifier();
				}
				break;
			case 2:
				{
				setState(537);
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
		public TerminalNode WHERE_SYMBOL() { return getToken(SQLBaseParser.WHERE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(WHERE_SYMBOL);
			setState(541);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableReference(this);
		}
	}

	public final TableReferenceContext tableReference() throws RecognitionException {
		TableReferenceContext _localctx = new TableReferenceContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tableReference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			tableFactor();
			setState(547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(544);
					joinedTable();
					}
					} 
				}
				setState(549);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterEscapedTableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitEscapedTableReference(this);
		}
	}

	public final EscapedTableReferenceContext escapedTableReference() throws RecognitionException {
		EscapedTableReferenceContext _localctx = new EscapedTableReferenceContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_escapedTableReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			tableFactor();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (CROSS_SYMBOL - 88)) | (1L << (INNER_SYMBOL - 88)) | (1L << (JOIN_SYMBOL - 88)) | (1L << (LEFT_SYMBOL - 88)) | (1L << (RIGHT_SYMBOL - 88)))) != 0)) {
				{
				{
				setState(551);
				joinedTable();
				}
				}
				setState(556);
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
		public TerminalNode ON_SYMBOL() { return getToken(SQLBaseParser.ON_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING_SYMBOL() { return getToken(SQLBaseParser.USING_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterJoinedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitJoinedTable(this);
		}
	}

	public final JoinedTableContext joinedTable() throws RecognitionException {
		JoinedTableContext _localctx = new JoinedTableContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_joinedTable);
		try {
			setState(573);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CROSS_SYMBOL:
			case INNER_SYMBOL:
			case JOIN_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(557);
				innerJoinType();
				setState(558);
				tableReference();
				setState(563);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(559);
					match(ON_SYMBOL);
					setState(560);
					expr(0);
					}
					break;
				case 2:
					{
					setState(561);
					match(USING_SYMBOL);
					setState(562);
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
				setState(565);
				outerJoinType();
				setState(566);
				tableReference();
				setState(571);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ON_SYMBOL:
					{
					setState(567);
					match(ON_SYMBOL);
					setState(568);
					expr(0);
					}
					break;
				case USING_SYMBOL:
					{
					setState(569);
					match(USING_SYMBOL);
					setState(570);
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
		public TerminalNode JOIN_SYMBOL() { return getToken(SQLBaseParser.JOIN_SYMBOL, 0); }
		public TerminalNode INNER_SYMBOL() { return getToken(SQLBaseParser.INNER_SYMBOL, 0); }
		public TerminalNode CROSS_SYMBOL() { return getToken(SQLBaseParser.CROSS_SYMBOL, 0); }
		public InnerJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterInnerJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitInnerJoinType(this);
		}
	}

	public final InnerJoinTypeContext innerJoinType() throws RecognitionException {
		InnerJoinTypeContext _localctx = new InnerJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_innerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CROSS_SYMBOL || _la==INNER_SYMBOL) {
				{
				setState(575);
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

			setState(578);
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
		public TerminalNode JOIN_SYMBOL() { return getToken(SQLBaseParser.JOIN_SYMBOL, 0); }
		public TerminalNode LEFT_SYMBOL() { return getToken(SQLBaseParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(SQLBaseParser.RIGHT_SYMBOL, 0); }
		public TerminalNode OUTER_SYMBOL() { return getToken(SQLBaseParser.OUTER_SYMBOL, 0); }
		public OuterJoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerJoinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterOuterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitOuterJoinType(this);
		}
	}

	public final OuterJoinTypeContext outerJoinType() throws RecognitionException {
		OuterJoinTypeContext _localctx = new OuterJoinTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_outerJoinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
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
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTER_SYMBOL) {
				{
				setState(581);
				match(OUTER_SYMBOL);
				}
			}

			setState(584);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableFactor(this);
		}
	}

	public final TableFactorContext tableFactor() throws RecognitionException {
		TableFactorContext _localctx = new TableFactorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_tableFactor);
		try {
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				singleTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				singleTableParens();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(588);
				derivedTable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(589);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSingleTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSingleTable(this);
		}
	}

	public final SingleTableContext singleTable() throws RecognitionException {
		SingleTableContext _localctx = new SingleTableContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_singleTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			tableRef();
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(593);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSingleTableParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSingleTableParens(this);
		}
	}

	public final SingleTableParensContext singleTableParens() throws RecognitionException {
		SingleTableParensContext _localctx = new SingleTableParensContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_singleTableParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(OPEN_PAR_SYMBOL);
			setState(599);
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
				setState(597);
				singleTable();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(598);
				singleTableParens();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(601);
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
		public TerminalNode LATERAL_SYMBOL() { return getToken(SQLBaseParser.LATERAL_SYMBOL, 0); }
		public DerivedTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterDerivedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitDerivedTable(this);
		}
	}

	public final DerivedTableContext derivedTable() throws RecognitionException {
		DerivedTableContext _localctx = new DerivedTableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_derivedTable);
		try {
			setState(618);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				subquery();
				setState(605);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(604);
					tableAlias();
					}
					break;
				}
				setState(608);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(607);
					columnInternalRefList();
					}
					break;
				}
				}
				break;
			case LATERAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				match(LATERAL_SYMBOL);
				setState(611);
				subquery();
				setState(613);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(612);
					tableAlias();
					}
					break;
				}
				setState(616);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(615);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableReferenceListParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableReferenceListParens(this);
		}
	}

	public final TableReferenceListParensContext tableReferenceListParens() throws RecognitionException {
		TableReferenceListParensContext _localctx = new TableReferenceListParensContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_tableReferenceListParens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(OPEN_PAR_SYMBOL);
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(621);
				tableReferenceList();
				}
				break;
			case 2:
				{
				setState(622);
				tableReferenceListParens();
				}
				break;
			}
			setState(625);
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
		public TerminalNode DISTINCT_SYMBOL() { return getToken(SQLBaseParser.DISTINCT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(SQLBaseParser.ALL_SYMBOL, 0); }
		public UnionOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitUnionOption(this);
		}
	}

	public final UnionOptionContext unionOption() throws RecognitionException {
		UnionOptionContext _localctx = new UnionOptionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_unionOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
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
		public TerminalNode AS_SYMBOL() { return getToken(SQLBaseParser.AS_SYMBOL, 0); }
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableAlias(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_tableAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_SYMBOL) {
				{
				setState(629);
				match(AS_SYMBOL);
				}
			}

			setState(632);
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
		public TerminalNode OR_SYMBOL() { return getToken(SQLBaseParser.OR_SYMBOL, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprOr(this);
		}
	}
	public static class ExprNotContext extends ExprContext {
		public TerminalNode NOT_SYMBOL() { return getToken(SQLBaseParser.NOT_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprNot(this);
		}
	}
	public static class ExprIsContext extends ExprContext {
		public Token type;
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(SQLBaseParser.IS_SYMBOL, 0); }
		public TerminalNode TRUE_SYMBOL() { return getToken(SQLBaseParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(SQLBaseParser.FALSE_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(SQLBaseParser.UNKNOWN_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public ExprIsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprIs(this);
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
		public TerminalNode AND_SYMBOL() { return getToken(SQLBaseParser.AND_SYMBOL, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprAnd(this);
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
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
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

				setState(635);
				boolPri(0);
				setState(641);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(636);
					match(IS_SYMBOL);
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
						{
						setState(637);
						notRule();
						}
					}

					setState(640);
					((ExprIsContext)_localctx).type = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & ((1L << (FALSE_SYMBOL - 111)) | (1L << (TRUE_SYMBOL - 111)) | (1L << (UNKNOWN_SYMBOL - 111)))) != 0)) ) {
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
				setState(643);
				match(NOT_SYMBOL);
				setState(644);
				expr(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(655);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(653);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(647);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(648);
						((ExprAndContext)_localctx).op = match(AND_SYMBOL);
						setState(649);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(650);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(651);
						((ExprOrContext)_localctx).op = match(OR_SYMBOL);
						setState(652);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(657);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPrimaryExprPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPrimaryExprPredicate(this);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPrimaryExprCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPrimaryExprCompare(this);
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
		public TerminalNode ALL_SYMBOL() { return getToken(SQLBaseParser.ALL_SYMBOL, 0); }
		public TerminalNode ANY_SYMBOL() { return getToken(SQLBaseParser.ANY_SYMBOL, 0); }
		public PrimaryExprAllAnyContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPrimaryExprAllAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPrimaryExprAllAny(this);
		}
	}
	public static class PrimaryExprIsNullContext extends BoolPriContext {
		public BoolPriContext boolPri() {
			return getRuleContext(BoolPriContext.class,0);
		}
		public TerminalNode IS_SYMBOL() { return getToken(SQLBaseParser.IS_SYMBOL, 0); }
		public TerminalNode NULL_SYMBOL() { return getToken(SQLBaseParser.NULL_SYMBOL, 0); }
		public NotRuleContext notRule() {
			return getRuleContext(NotRuleContext.class,0);
		}
		public PrimaryExprIsNullContext(BoolPriContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPrimaryExprIsNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPrimaryExprIsNull(this);
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
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_boolPri, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExprPredicateContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(659);
			predicate();
			}
			_ctx.stop = _input.LT(-1);
			setState(678);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(676);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
					case 1:
						{
						_localctx = new PrimaryExprIsNullContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(661);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(662);
						match(IS_SYMBOL);
						setState(664);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
							{
							setState(663);
							notRule();
							}
						}

						setState(666);
						match(NULL_SYMBOL);
						}
						break;
					case 2:
						{
						_localctx = new PrimaryExprCompareContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(667);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(668);
						compOp();
						setState(669);
						predicate();
						}
						break;
					case 3:
						{
						_localctx = new PrimaryExprAllAnyContext(new BoolPriContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_boolPri);
						setState(671);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(672);
						compOp();
						setState(673);
						_la = _input.LA(1);
						if ( !(_la==ALL_SYMBOL || _la==ANY_SYMBOL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(674);
						subquery();
						}
						break;
					}
					} 
				}
				setState(680);
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
		public TerminalNode EQUAL_OPERATOR() { return getToken(SQLBaseParser.EQUAL_OPERATOR, 0); }
		public TerminalNode NULL_SAFE_EQUAL_OPERATOR() { return getToken(SQLBaseParser.NULL_SAFE_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_OR_EQUAL_OPERATOR() { return getToken(SQLBaseParser.GREATER_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode GREATER_THAN_OPERATOR() { return getToken(SQLBaseParser.GREATER_THAN_OPERATOR, 0); }
		public TerminalNode LESS_OR_EQUAL_OPERATOR() { return getToken(SQLBaseParser.LESS_OR_EQUAL_OPERATOR, 0); }
		public TerminalNode LESS_THAN_OPERATOR() { return getToken(SQLBaseParser.LESS_THAN_OPERATOR, 0); }
		public TerminalNode NOT_EQUAL_OPERATOR() { return getToken(SQLBaseParser.NOT_EQUAL_OPERATOR, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			bitExpr(0);
			setState(688);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(685);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT2_SYMBOL || _la==NOT_SYMBOL) {
					{
					setState(684);
					notRule();
					}
				}

				setState(687);
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
		public TerminalNode BETWEEN_SYMBOL() { return getToken(SQLBaseParser.BETWEEN_SYMBOL, 0); }
		public BitExprContext bitExpr() {
			return getRuleContext(BitExprContext.class,0);
		}
		public TerminalNode AND_SYMBOL() { return getToken(SQLBaseParser.AND_SYMBOL, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateExprBetweenContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPredicateExprBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPredicateExprBetween(this);
		}
	}
	public static class PredicateExprInContext extends PredicateOperationsContext {
		public TerminalNode IN_SYMBOL() { return getToken(SQLBaseParser.IN_SYMBOL, 0); }
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public PredicateExprInContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPredicateExprIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPredicateExprIn(this);
		}
	}
	public static class PredicateExprLikeContext extends PredicateOperationsContext {
		public TerminalNode LIKE_SYMBOL() { return getToken(SQLBaseParser.LIKE_SYMBOL, 0); }
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode ESCAPE_SYMBOL() { return getToken(SQLBaseParser.ESCAPE_SYMBOL, 0); }
		public PredicateExprLikeContext(PredicateOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPredicateExprLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPredicateExprLike(this);
		}
	}

	public final PredicateOperationsContext predicateOperations() throws RecognitionException {
		PredicateOperationsContext _localctx = new PredicateOperationsContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_predicateOperations);
		try {
			setState(709);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN_SYMBOL:
				_localctx = new PredicateExprInContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(690);
				match(IN_SYMBOL);
				setState(696);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(691);
					subquery();
					}
					break;
				case 2:
					{
					setState(692);
					match(OPEN_PAR_SYMBOL);
					setState(693);
					exprList();
					setState(694);
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
				setState(698);
				match(BETWEEN_SYMBOL);
				setState(699);
				bitExpr(0);
				setState(700);
				match(AND_SYMBOL);
				setState(701);
				predicate();
				}
				break;
			case LIKE_SYMBOL:
				_localctx = new PredicateExprLikeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(703);
				match(LIKE_SYMBOL);
				setState(704);
				simpleExpr(0);
				setState(707);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(705);
					match(ESCAPE_SYMBOL);
					setState(706);
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
		public TerminalNode MULT_OPERATOR() { return getToken(SQLBaseParser.MULT_OPERATOR, 0); }
		public TerminalNode DIV_OPERATOR() { return getToken(SQLBaseParser.DIV_OPERATOR, 0); }
		public TerminalNode MOD_OPERATOR() { return getToken(SQLBaseParser.MOD_OPERATOR, 0); }
		public TerminalNode PLUS_OPERATOR() { return getToken(SQLBaseParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(SQLBaseParser.MINUS_OPERATOR, 0); }
		public BitExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterBitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitBitExpr(this);
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
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_bitExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(712);
			simpleExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(722);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(720);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(714);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(715);
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
						setState(716);
						bitExpr(3);
						}
						break;
					case 2:
						{
						_localctx = new BitExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bitExpr);
						setState(717);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(718);
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
						setState(719);
						bitExpr(2);
						}
						break;
					}
					} 
				}
				setState(724);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprColumnRef(this);
		}
	}
	public static class SimpleExprParamMarkerContext extends SimpleExprContext {
		public TerminalNode PARAM_MARKER() { return getToken(SQLBaseParser.PARAM_MARKER, 0); }
		public SimpleExprParamMarkerContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprParamMarker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprParamMarker(this);
		}
	}
	public static class SimpleExprSumContext extends SimpleExprContext {
		public SumExprContext sumExpr() {
			return getRuleContext(SumExprContext.class,0);
		}
		public SimpleExprSumContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprSum(this);
		}
	}
	public static class SimpleExprCastContext extends SimpleExprContext {
		public TerminalNode CAST_SYMBOL() { return getToken(SQLBaseParser.CAST_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS_SYMBOL() { return getToken(SQLBaseParser.AS_SYMBOL, 0); }
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprCastContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprCast(this);
		}
	}
	public static class SimpleExprUnaryContext extends SimpleExprContext {
		public Token op;
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode PLUS_OPERATOR() { return getToken(SQLBaseParser.PLUS_OPERATOR, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(SQLBaseParser.MINUS_OPERATOR, 0); }
		public SimpleExprUnaryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprUnary(this);
		}
	}
	public static class SimpleExprSubQueryContext extends SimpleExprContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public TerminalNode EXISTS_SYMBOL() { return getToken(SQLBaseParser.EXISTS_SYMBOL, 0); }
		public SimpleExprSubQueryContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprSubQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprSubQuery(this);
		}
	}
	public static class SimpleExprGroupingOperationContext extends SimpleExprContext {
		public GroupingOperationContext groupingOperation() {
			return getRuleContext(GroupingOperationContext.class,0);
		}
		public SimpleExprGroupingOperationContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprGroupingOperation(this);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprNot(this);
		}
	}
	public static class SimpleExprOdbcContext extends SimpleExprContext {
		public TerminalNode OPEN_CURLY_SYMBOL() { return getToken(SQLBaseParser.OPEN_CURLY_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_CURLY_SYMBOL() { return getToken(SQLBaseParser.CLOSE_CURLY_SYMBOL, 0); }
		public SimpleExprOdbcContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprOdbc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprOdbc(this);
		}
	}
	public static class SimpleExprRuntimeFunctionContext extends SimpleExprContext {
		public RuntimeFunctionCallContext runtimeFunctionCall() {
			return getRuleContext(RuntimeFunctionCallContext.class,0);
		}
		public SimpleExprRuntimeFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprRuntimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprRuntimeFunction(this);
		}
	}
	public static class SimpleExprFunctionContext extends SimpleExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public SimpleExprFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprFunction(this);
		}
	}
	public static class SimpleExprListContext extends SimpleExprContext {
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode ROW_SYMBOL() { return getToken(SQLBaseParser.ROW_SYMBOL, 0); }
		public SimpleExprListContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprList(this);
		}
	}
	public static class SimpleExprCaseContext extends SimpleExprContext {
		public TerminalNode CASE_SYMBOL() { return getToken(SQLBaseParser.CASE_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(SQLBaseParser.END_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprCase(this);
		}
	}
	public static class SimpleExprConcatContext extends SimpleExprContext {
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode CONCAT_PIPES_SYMBOL() { return getToken(SQLBaseParser.CONCAT_PIPES_SYMBOL, 0); }
		public SimpleExprConcatContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprConcat(this);
		}
	}
	public static class SimpleExprLiteralContext extends SimpleExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public SimpleExprLiteralContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprLiteral(this);
		}
	}
	public static class SimpleExprWindowingFunctionContext extends SimpleExprContext {
		public WindowFunctionCallContext windowFunctionCall() {
			return getRuleContext(WindowFunctionCallContext.class,0);
		}
		public SimpleExprWindowingFunctionContext(SimpleExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprWindowingFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprWindowingFunction(this);
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
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_simpleExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				_localctx = new SimpleExprColumnRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(726);
				columnRef();
				}
				break;
			case 2:
				{
				_localctx = new SimpleExprRuntimeFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(727);
				runtimeFunctionCall();
				}
				break;
			case 3:
				{
				_localctx = new SimpleExprFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(728);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new SimpleExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(729);
				literal();
				}
				break;
			case 5:
				{
				_localctx = new SimpleExprParamMarkerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(730);
				match(PARAM_MARKER);
				}
				break;
			case 6:
				{
				_localctx = new SimpleExprSumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(731);
				sumExpr();
				}
				break;
			case 7:
				{
				_localctx = new SimpleExprGroupingOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(732);
				groupingOperation();
				}
				break;
			case 8:
				{
				_localctx = new SimpleExprWindowingFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(733);
				windowFunctionCall();
				}
				break;
			case 9:
				{
				_localctx = new SimpleExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(734);
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
				setState(735);
				simpleExpr(7);
				}
				break;
			case 10:
				{
				_localctx = new SimpleExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(736);
				not2Rule();
				setState(737);
				simpleExpr(6);
				}
				break;
			case 11:
				{
				_localctx = new SimpleExprListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(740);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW_SYMBOL) {
					{
					setState(739);
					match(ROW_SYMBOL);
					}
				}

				setState(742);
				match(OPEN_PAR_SYMBOL);
				setState(743);
				exprList();
				setState(744);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 12:
				{
				_localctx = new SimpleExprSubQueryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(747);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXISTS_SYMBOL) {
					{
					setState(746);
					match(EXISTS_SYMBOL);
					}
				}

				setState(749);
				subquery();
				}
				break;
			case 13:
				{
				_localctx = new SimpleExprOdbcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(750);
				match(OPEN_CURLY_SYMBOL);
				setState(751);
				identifier();
				setState(752);
				expr(0);
				setState(753);
				match(CLOSE_CURLY_SYMBOL);
				}
				break;
			case 14:
				{
				_localctx = new SimpleExprCastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(755);
				match(CAST_SYMBOL);
				setState(756);
				match(OPEN_PAR_SYMBOL);
				setState(757);
				expr(0);
				setState(758);
				match(AS_SYMBOL);
				setState(759);
				castType();
				setState(760);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 15:
				{
				_localctx = new SimpleExprCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(762);
				match(CASE_SYMBOL);
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL) | (1L << INTERVAL_SYMBOL) | (1L << CURRENT_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)) | (1L << (NULL_SYMBOL - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (OFFSET_SYMBOL - 128)) | (1L << (TIMESTAMP_SYMBOL - 128)) | (1L << (TIME_SYMBOL - 128)) | (1L << (TRUE_SYMBOL - 128)) | (1L << (UNKNOWN_SYMBOL - 128)) | (1L << (NOWAIT_SYMBOL - 128)) | (1L << (GROUPING_SYMBOL - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NCHAR_TEXT - 128)) | (1L << (DOUBLE_QUOTED_TEXT - 128)) | (1L << (SINGLE_QUOTED_TEXT - 128)))) != 0)) {
					{
					setState(763);
					expr(0);
					}
				}

				setState(769); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(766);
					whenExpression();
					setState(767);
					thenExpression();
					}
					}
					setState(771); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_SYMBOL );
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_SYMBOL) {
					{
					setState(773);
					elseExpression();
					}
				}

				setState(776);
				match(END_SYMBOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(785);
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
					setState(780);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(781);
					match(CONCAT_PIPES_SYMBOL);
					setState(782);
					simpleExpr(9);
					}
					} 
				}
				setState(787);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public InSumExprContext inSumExpr() {
			return getRuleContext(InSumExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(SQLBaseParser.AVG_SYMBOL, 0); }
		public TerminalNode DISTINCT_SYMBOL() { return getToken(SQLBaseParser.DISTINCT_SYMBOL, 0); }
		public WindowingClauseContext windowingClause() {
			return getRuleContext(WindowingClauseContext.class,0);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(SQLBaseParser.MULT_OPERATOR, 0); }
		public TerminalNode COUNT_SYMBOL() { return getToken(SQLBaseParser.COUNT_SYMBOL, 0); }
		public TerminalNode ALL_SYMBOL() { return getToken(SQLBaseParser.ALL_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode MIN_SYMBOL() { return getToken(SQLBaseParser.MIN_SYMBOL, 0); }
		public TerminalNode MAX_SYMBOL() { return getToken(SQLBaseParser.MAX_SYMBOL, 0); }
		public TerminalNode STD_SYMBOL() { return getToken(SQLBaseParser.STD_SYMBOL, 0); }
		public TerminalNode VARIANCE_SYMBOL() { return getToken(SQLBaseParser.VARIANCE_SYMBOL, 0); }
		public TerminalNode SUM_SYMBOL() { return getToken(SQLBaseParser.SUM_SYMBOL, 0); }
		public TerminalNode GROUP_CONCAT_SYMBOL() { return getToken(SQLBaseParser.GROUP_CONCAT_SYMBOL, 0); }
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public TerminalNode SEPARATOR_SYMBOL() { return getToken(SQLBaseParser.SEPARATOR_SYMBOL, 0); }
		public TextStringContext textString() {
			return getRuleContext(TextStringContext.class,0);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSumExpr(this);
		}
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_sumExpr);
		int _la;
		try {
			setState(884);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(788);
				((SumExprContext)_localctx).name = match(AVG_SYMBOL);
				setState(789);
				match(OPEN_PAR_SYMBOL);
				setState(791);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(790);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(793);
				inSumExpr();
				setState(794);
				match(CLOSE_PAR_SYMBOL);
				setState(796);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(795);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(798);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(799);
				match(OPEN_PAR_SYMBOL);
				setState(801);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_SYMBOL) {
					{
					setState(800);
					match(ALL_SYMBOL);
					}
				}

				setState(803);
				match(MULT_OPERATOR);
				setState(804);
				match(CLOSE_PAR_SYMBOL);
				setState(806);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(805);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(808);
				((SumExprContext)_localctx).name = match(COUNT_SYMBOL);
				setState(809);
				match(OPEN_PAR_SYMBOL);
				setState(817);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(811);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_SYMBOL) {
						{
						setState(810);
						match(ALL_SYMBOL);
						}
					}

					setState(813);
					match(MULT_OPERATOR);
					}
					break;
				case 2:
					{
					setState(814);
					inSumExpr();
					}
					break;
				case 3:
					{
					setState(815);
					match(DISTINCT_SYMBOL);
					setState(816);
					exprList();
					}
					break;
				}
				setState(819);
				match(CLOSE_PAR_SYMBOL);
				setState(821);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(820);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(823);
				((SumExprContext)_localctx).name = match(MIN_SYMBOL);
				setState(824);
				match(OPEN_PAR_SYMBOL);
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(825);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(828);
				inSumExpr();
				setState(829);
				match(CLOSE_PAR_SYMBOL);
				setState(831);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(830);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(833);
				((SumExprContext)_localctx).name = match(MAX_SYMBOL);
				setState(834);
				match(OPEN_PAR_SYMBOL);
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(835);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(838);
				inSumExpr();
				setState(839);
				match(CLOSE_PAR_SYMBOL);
				setState(841);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(840);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(843);
				((SumExprContext)_localctx).name = match(STD_SYMBOL);
				setState(844);
				match(OPEN_PAR_SYMBOL);
				setState(845);
				inSumExpr();
				setState(846);
				match(CLOSE_PAR_SYMBOL);
				setState(848);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(847);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(850);
				((SumExprContext)_localctx).name = match(VARIANCE_SYMBOL);
				setState(851);
				match(OPEN_PAR_SYMBOL);
				setState(852);
				inSumExpr();
				setState(853);
				match(CLOSE_PAR_SYMBOL);
				setState(855);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(854);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(857);
				((SumExprContext)_localctx).name = match(SUM_SYMBOL);
				setState(858);
				match(OPEN_PAR_SYMBOL);
				setState(860);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(859);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(862);
				inSumExpr();
				setState(863);
				match(CLOSE_PAR_SYMBOL);
				setState(865);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(864);
					windowingClause();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(867);
				((SumExprContext)_localctx).name = match(GROUP_CONCAT_SYMBOL);
				setState(868);
				match(OPEN_PAR_SYMBOL);
				setState(870);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DISTINCT_SYMBOL) {
					{
					setState(869);
					match(DISTINCT_SYMBOL);
					}
				}

				setState(872);
				exprList();
				setState(874);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_SYMBOL) {
					{
					setState(873);
					orderClause();
					}
				}

				setState(878);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEPARATOR_SYMBOL) {
					{
					setState(876);
					match(SEPARATOR_SYMBOL);
					setState(877);
					textString();
					}
				}

				setState(880);
				match(CLOSE_PAR_SYMBOL);
				setState(882);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(881);
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
		public TerminalNode GROUPING_SYMBOL() { return getToken(SQLBaseParser.GROUPING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public GroupingOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterGroupingOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitGroupingOperation(this);
		}
	}

	public final GroupingOperationContext groupingOperation() throws RecognitionException {
		GroupingOperationContext _localctx = new GroupingOperationContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_groupingOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			match(GROUPING_SYMBOL);
			setState(887);
			match(OPEN_PAR_SYMBOL);
			setState(888);
			exprList();
			setState(889);
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
		public TerminalNode ROW_NUMBER_SYMBOL() { return getToken(SQLBaseParser.ROW_NUMBER_SYMBOL, 0); }
		public TerminalNode RANK_SYMBOL() { return getToken(SQLBaseParser.RANK_SYMBOL, 0); }
		public TerminalNode DENSE_RANK_SYMBOL() { return getToken(SQLBaseParser.DENSE_RANK_SYMBOL, 0); }
		public TerminalNode NTILE_SYMBOL() { return getToken(SQLBaseParser.NTILE_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext simpleExprWithParentheses() {
			return getRuleContext(SimpleExprWithParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode LEAD_SYMBOL() { return getToken(SQLBaseParser.LEAD_SYMBOL, 0); }
		public TerminalNode LAG_SYMBOL() { return getToken(SQLBaseParser.LAG_SYMBOL, 0); }
		public LeadLagInfoContext leadLagInfo() {
			return getRuleContext(LeadLagInfoContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode FIRST_VALUE_SYMBOL() { return getToken(SQLBaseParser.FIRST_VALUE_SYMBOL, 0); }
		public TerminalNode LAST_VALUE_SYMBOL() { return getToken(SQLBaseParser.LAST_VALUE_SYMBOL, 0); }
		public WindowFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowFunctionCall(this);
		}
	}

	public final WindowFunctionCallContext windowFunctionCall() throws RecognitionException {
		WindowFunctionCallContext _localctx = new WindowFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_windowFunctionCall);
		int _la;
		try {
			setState(912);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DENSE_RANK_SYMBOL:
			case RANK_SYMBOL:
			case ROW_NUMBER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(891);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DENSE_RANK_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(892);
				parentheses();
				setState(893);
				windowingClause();
				}
				break;
			case NTILE_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(895);
				match(NTILE_SYMBOL);
				setState(896);
				simpleExprWithParentheses();
				setState(897);
				windowingClause();
				}
				break;
			case LAG_SYMBOL:
			case LEAD_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(899);
				_la = _input.LA(1);
				if ( !(_la==LAG_SYMBOL || _la==LEAD_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(900);
				match(OPEN_PAR_SYMBOL);
				setState(901);
				expr(0);
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(902);
					leadLagInfo();
					}
				}

				setState(905);
				match(CLOSE_PAR_SYMBOL);
				setState(906);
				windowingClause();
				}
				break;
			case FIRST_VALUE_SYMBOL:
			case LAST_VALUE_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(908);
				_la = _input.LA(1);
				if ( !(_la==FIRST_VALUE_SYMBOL || _la==LAST_VALUE_SYMBOL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(909);
				exprWithParentheses();
				setState(910);
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
		public TerminalNode OVER_SYMBOL() { return getToken(SQLBaseParser.OVER_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowingClause(this);
		}
	}

	public final WindowingClauseContext windowingClause() throws RecognitionException {
		WindowingClauseContext _localctx = new WindowingClauseContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_windowingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(OVER_SYMBOL);
			setState(917);
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
				setState(915);
				windowName();
				}
				break;
			case OPEN_PAR_SYMBOL:
				{
				setState(916);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public Ulonglong_numberContext ulonglong_number() {
			return getRuleContext(Ulonglong_numberContext.class,0);
		}
		public TerminalNode PARAM_MARKER() { return getToken(SQLBaseParser.PARAM_MARKER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeadLagInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leadLagInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLeadLagInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLeadLagInfo(this);
		}
	}

	public final LeadLagInfoContext leadLagInfo() throws RecognitionException {
		LeadLagInfoContext _localctx = new LeadLagInfoContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_leadLagInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			match(COMMA_SYMBOL);
			setState(922);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case INT_NUMBER:
			case DECIMAL_NUMBER:
			case FLOAT_NUMBER:
				{
				setState(920);
				ulonglong_number();
				}
				break;
			case PARAM_MARKER:
				{
				setState(921);
				match(PARAM_MARKER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_SYMBOL) {
				{
				setState(924);
				match(COMMA_SYMBOL);
				setState(925);
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
		public TerminalNode ALL_SYMBOL() { return getToken(SQLBaseParser.ALL_SYMBOL, 0); }
		public InSumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inSumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterInSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitInSumExpr(this);
		}
	}

	public final InSumExprContext inSumExpr() throws RecognitionException {
		InSumExprContext _localctx = new InSumExprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_inSumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL_SYMBOL) {
				{
				setState(928);
				match(ALL_SYMBOL);
				}
			}

			setState(931);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identListArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentListArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentListArg(this);
		}
	}

	public final IdentListArgContext identListArg() throws RecognitionException {
		IdentListArgContext _localctx = new IdentListArgContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_identListArg);
		try {
			setState(938);
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
				setState(933);
				identList();
				}
				break;
			case OPEN_PAR_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(934);
				match(OPEN_PAR_SYMBOL);
				setState(935);
				identList();
				setState(936);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public IdentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentList(this);
		}
	}

	public final IdentListContext identList() throws RecognitionException {
		IdentListContext _localctx = new IdentListContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_identList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940);
			simpleIdentifier();
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(941);
				match(COMMA_SYMBOL);
				setState(942);
				simpleIdentifier();
				}
				}
				setState(947);
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
		public TerminalNode CURRENT_USER_SYMBOL() { return getToken(SQLBaseParser.CURRENT_USER_SYMBOL, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public TerminalNode INTERVAL_SYMBOL() { return getToken(SQLBaseParser.INTERVAL_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public TerminalNode LEFT_SYMBOL() { return getToken(SQLBaseParser.LEFT_SYMBOL, 0); }
		public TerminalNode RIGHT_SYMBOL() { return getToken(SQLBaseParser.RIGHT_SYMBOL, 0); }
		public TerminalNode NOW_SYMBOL() { return getToken(SQLBaseParser.NOW_SYMBOL, 0); }
		public TimeFunctionParametersContext timeFunctionParameters() {
			return getRuleContext(TimeFunctionParametersContext.class,0);
		}
		public SubstringFunctionContext substringFunction() {
			return getRuleContext(SubstringFunctionContext.class,0);
		}
		public ExprWithParenthesesContext exprWithParentheses() {
			return getRuleContext(ExprWithParenthesesContext.class,0);
		}
		public TerminalNode ASCII_SYMBOL() { return getToken(SQLBaseParser.ASCII_SYMBOL, 0); }
		public RuntimeFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runtimeFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterRuntimeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitRuntimeFunctionCall(this);
		}
	}

	public final RuntimeFunctionCallContext runtimeFunctionCall() throws RecognitionException {
		RuntimeFunctionCallContext _localctx = new RuntimeFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_runtimeFunctionCall);
		int _la;
		try {
			setState(984);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_USER_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(948);
				((RuntimeFunctionCallContext)_localctx).name = match(CURRENT_USER_SYMBOL);
				setState(950);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(949);
					parentheses();
					}
					break;
				}
				}
				break;
			case INTERVAL_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(952);
				((RuntimeFunctionCallContext)_localctx).name = match(INTERVAL_SYMBOL);
				setState(953);
				match(OPEN_PAR_SYMBOL);
				setState(954);
				expr(0);
				setState(957); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(955);
					match(COMMA_SYMBOL);
					setState(956);
					expr(0);
					}
					}
					setState(959); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA_SYMBOL );
				setState(961);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case LEFT_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(963);
				((RuntimeFunctionCallContext)_localctx).name = match(LEFT_SYMBOL);
				setState(964);
				match(OPEN_PAR_SYMBOL);
				setState(965);
				expr(0);
				setState(966);
				match(COMMA_SYMBOL);
				setState(967);
				expr(0);
				setState(968);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case RIGHT_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(970);
				((RuntimeFunctionCallContext)_localctx).name = match(RIGHT_SYMBOL);
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
			case NOW_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(977);
				((RuntimeFunctionCallContext)_localctx).name = match(NOW_SYMBOL);
				setState(979);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(978);
					timeFunctionParameters();
					}
					break;
				}
				}
				break;
			case SUBSTRING_SYMBOL:
				enterOuterAlt(_localctx, 6);
				{
				setState(981);
				substringFunction();
				}
				break;
			case ASCII_SYMBOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(982);
				((RuntimeFunctionCallContext)_localctx).name = match(ASCII_SYMBOL);
				setState(983);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public FractionalPrecisionContext fractionalPrecision() {
			return getRuleContext(FractionalPrecisionContext.class,0);
		}
		public TimeFunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeFunctionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTimeFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTimeFunctionParameters(this);
		}
	}

	public final TimeFunctionParametersContext timeFunctionParameters() throws RecognitionException {
		TimeFunctionParametersContext _localctx = new TimeFunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_timeFunctionParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(986);
			match(OPEN_PAR_SYMBOL);
			setState(988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT_NUMBER) {
				{
				setState(987);
				fractionalPrecision();
				}
			}

			setState(990);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public FractionalPrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fractionalPrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFractionalPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFractionalPrecision(this);
		}
	}

	public final FractionalPrecisionContext fractionalPrecision() throws RecognitionException {
		FractionalPrecisionContext _localctx = new FractionalPrecisionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_fractionalPrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992);
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
		public TerminalNode SUBSTRING_SYMBOL() { return getToken(SQLBaseParser.SUBSTRING_SYMBOL, 0); }
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public TerminalNode FROM_SYMBOL() { return getToken(SQLBaseParser.FROM_SYMBOL, 0); }
		public TerminalNode FOR_SYMBOL() { return getToken(SQLBaseParser.FOR_SYMBOL, 0); }
		public SubstringFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substringFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSubstringFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSubstringFunction(this);
		}
	}

	public final SubstringFunctionContext substringFunction() throws RecognitionException {
		SubstringFunctionContext _localctx = new SubstringFunctionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_substringFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(994);
			match(SUBSTRING_SYMBOL);
			setState(995);
			match(OPEN_PAR_SYMBOL);
			setState(996);
			expr(0);
			setState(1009);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA_SYMBOL:
				{
				setState(997);
				match(COMMA_SYMBOL);
				setState(998);
				expr(0);
				setState(1001);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_SYMBOL) {
					{
					setState(999);
					match(COMMA_SYMBOL);
					setState(1000);
					expr(0);
					}
				}

				}
				break;
			case FROM_SYMBOL:
				{
				setState(1003);
				match(FROM_SYMBOL);
				setState(1004);
				expr(0);
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR_SYMBOL) {
					{
					setState(1005);
					match(FOR_SYMBOL);
					setState(1006);
					expr(0);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1011);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_functionCall);
		int _la;
		try {
			setState(1027);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1013);
				pureIdentifier();
				setState(1014);
				match(OPEN_PAR_SYMBOL);
				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL) | (1L << INTERVAL_SYMBOL) | (1L << CURRENT_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)) | (1L << (NULL_SYMBOL - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (OFFSET_SYMBOL - 128)) | (1L << (TIMESTAMP_SYMBOL - 128)) | (1L << (TIME_SYMBOL - 128)) | (1L << (TRUE_SYMBOL - 128)) | (1L << (UNKNOWN_SYMBOL - 128)) | (1L << (NOWAIT_SYMBOL - 128)) | (1L << (GROUPING_SYMBOL - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NCHAR_TEXT - 128)) | (1L << (DOUBLE_QUOTED_TEXT - 128)) | (1L << (SINGLE_QUOTED_TEXT - 128)))) != 0)) {
					{
					setState(1015);
					udfExprList();
					}
				}

				setState(1018);
				match(CLOSE_PAR_SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1020);
				qualifiedIdentifier();
				setState(1021);
				match(OPEN_PAR_SYMBOL);
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT2_SYMBOL) | (1L << LONG_NUMBER) | (1L << ULONGLONG_NUMBER) | (1L << PLUS_OPERATOR) | (1L << MINUS_OPERATOR) | (1L << DOT_SYMBOL) | (1L << OPEN_PAR_SYMBOL) | (1L << OPEN_CURLY_SYMBOL) | (1L << NULL2_SYMBOL) | (1L << PARAM_MARKER) | (1L << HEX_NUMBER) | (1L << BIN_NUMBER) | (1L << INT_NUMBER) | (1L << DECIMAL_NUMBER) | (1L << FLOAT_NUMBER) | (1L << ASCII_SYMBOL) | (1L << COALESCE_SYMBOL) | (1L << SUBSTRING_SYMBOL) | (1L << NOT_SYMBOL) | (1L << CURRENT_USER_SYMBOL) | (1L << DENSE_RANK_SYMBOL) | (1L << FIRST_VALUE_SYMBOL) | (1L << LAG_SYMBOL) | (1L << LAST_VALUE_SYMBOL) | (1L << LEAD_SYMBOL) | (1L << NTILE_SYMBOL) | (1L << NULLS_SYMBOL) | (1L << PRECEDING_SYMBOL) | (1L << RANK_SYMBOL) | (1L << ROW_NUMBER_SYMBOL) | (1L << UNBOUNDED_SYMBOL) | (1L << INTERVAL_SYMBOL) | (1L << CURRENT_SYMBOL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ROW_SYMBOL - 64)) | (1L << (FOLLOWING_SYMBOL - 64)) | (1L << (EXCLUDE_SYMBOL - 64)) | (1L << (TIES_SYMBOL - 64)) | (1L << (OTHERS_SYMBOL - 64)) | (1L << (AVG_SYMBOL - 64)) | (1L << (COUNT_SYMBOL - 64)) | (1L << (SUM_SYMBOL - 64)) | (1L << (MAX_SYMBOL - 64)) | (1L << (MIN_SYMBOL - 64)) | (1L << (STD_SYMBOL - 64)) | (1L << (VARIANCE_SYMBOL - 64)) | (1L << (GROUP_CONCAT_SYMBOL - 64)) | (1L << (MODE_SYMBOL - 64)) | (1L << (SHARE_SYMBOL - 64)) | (1L << (SKIP_SYMBOL - 64)) | (1L << (LOCKED_SYMBOL - 64)) | (1L << (LEFT_SYMBOL - 64)) | (1L << (RIGHT_SYMBOL - 64)) | (1L << (ANY_SYMBOL - 64)) | (1L << (AT_SYMBOL - 64)) | (1L << (CASE_SYMBOL - 64)) | (1L << (CAST_SYMBOL - 64)) | (1L << (DATE_SYMBOL - 64)) | (1L << (ESCAPE_SYMBOL - 64)) | (1L << (EXISTS_SYMBOL - 64)) | (1L << (FALSE_SYMBOL - 64)) | (1L << (FIRST_SYMBOL - 64)) | (1L << (FULL_SYMBOL - 64)) | (1L << (LAST_SYMBOL - 64)) | (1L << (NOW_SYMBOL - 64)) | (1L << (NULL_SYMBOL - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (OFFSET_SYMBOL - 128)) | (1L << (TIMESTAMP_SYMBOL - 128)) | (1L << (TIME_SYMBOL - 128)) | (1L << (TRUE_SYMBOL - 128)) | (1L << (UNKNOWN_SYMBOL - 128)) | (1L << (NOWAIT_SYMBOL - 128)) | (1L << (GROUPING_SYMBOL - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NCHAR_TEXT - 128)) | (1L << (DOUBLE_QUOTED_TEXT - 128)) | (1L << (SINGLE_QUOTED_TEXT - 128)))) != 0)) {
					{
					setState(1022);
					exprList();
					}
				}

				setState(1025);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public UdfExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udfExprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterUdfExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitUdfExprList(this);
		}
	}

	public final UdfExprListContext udfExprList() throws RecognitionException {
		UdfExprListContext _localctx = new UdfExprListContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_udfExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			udfExpr();
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1030);
				match(COMMA_SYMBOL);
				setState(1031);
				udfExpr();
				}
				}
				setState(1036);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterUdfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitUdfExpr(this);
		}
	}

	public final UdfExprContext udfExpr() throws RecognitionException {
		UdfExprContext _localctx = new UdfExprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_udfExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			expr(0);
			setState(1039);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (COALESCE_SYMBOL - 37)) | (1L << (NULLS_SYMBOL - 37)) | (1L << (PRECEDING_SYMBOL - 37)) | (1L << (UNBOUNDED_SYMBOL - 37)) | (1L << (CURRENT_SYMBOL - 37)) | (1L << (FOLLOWING_SYMBOL - 37)) | (1L << (EXCLUDE_SYMBOL - 37)) | (1L << (TIES_SYMBOL - 37)) | (1L << (OTHERS_SYMBOL - 37)) | (1L << (AVG_SYMBOL - 37)) | (1L << (MODE_SYMBOL - 37)) | (1L << (SHARE_SYMBOL - 37)) | (1L << (SKIP_SYMBOL - 37)) | (1L << (LOCKED_SYMBOL - 37)) | (1L << (ANY_SYMBOL - 37)) | (1L << (AS_SYMBOL - 37)) | (1L << (AT_SYMBOL - 37)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (DATE_SYMBOL - 105)) | (1L << (ESCAPE_SYMBOL - 105)) | (1L << (FIRST_SYMBOL - 105)) | (1L << (FULL_SYMBOL - 105)) | (1L << (LAST_SYMBOL - 105)) | (1L << (OFFSET_SYMBOL - 105)) | (1L << (TIMESTAMP_SYMBOL - 105)) | (1L << (TIME_SYMBOL - 105)) | (1L << (UNKNOWN_SYMBOL - 105)) | (1L << (NOWAIT_SYMBOL - 105)) | (1L << (IDENTIFIER - 105)) | (1L << (DOUBLE_QUOTED_TEXT - 105)) | (1L << (SINGLE_QUOTED_TEXT - 105)))) != 0)) {
				{
				setState(1038);
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
		public TerminalNode WHEN_SYMBOL() { return getToken(SQLBaseParser.WHEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWhenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWhenExpression(this);
		}
	}

	public final WhenExpressionContext whenExpression() throws RecognitionException {
		WhenExpressionContext _localctx = new WhenExpressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_whenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			match(WHEN_SYMBOL);
			setState(1042);
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
		public TerminalNode THEN_SYMBOL() { return getToken(SQLBaseParser.THEN_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterThenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitThenExpression(this);
		}
	}

	public final ThenExpressionContext thenExpression() throws RecognitionException {
		ThenExpressionContext _localctx = new ThenExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_thenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			match(THEN_SYMBOL);
			setState(1045);
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
		public TerminalNode ELSE_SYMBOL() { return getToken(SQLBaseParser.ELSE_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterElseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitElseExpression(this);
		}
	}

	public final ElseExpressionContext elseExpression() throws RecognitionException {
		ElseExpressionContext _localctx = new ElseExpressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_elseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047);
			match(ELSE_SYMBOL);
			setState(1048);
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
		public TerminalNode DATE_SYMBOL() { return getToken(SQLBaseParser.DATE_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(SQLBaseParser.TIME_SYMBOL, 0); }
		public TypeDatetimePrecisionContext typeDatetimePrecision() {
			return getRuleContext(TypeDatetimePrecisionContext.class,0);
		}
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterCastType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitCastType(this);
		}
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_castType);
		int _la;
		try {
			setState(1055);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				match(DATE_SYMBOL);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051);
				match(TIME_SYMBOL);
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR_SYMBOL) {
					{
					setState(1052);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			expr(0);
			setState(1062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1058);
				match(COMMA_SYMBOL);
				setState(1059);
				expr(0);
				}
				}
				setState(1064);
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
		public TerminalNode NOT_SYMBOL() { return getToken(SQLBaseParser.NOT_SYMBOL, 0); }
		public TerminalNode NOT2_SYMBOL() { return getToken(SQLBaseParser.NOT2_SYMBOL, 0); }
		public NotRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterNotRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitNotRule(this);
		}
	}

	public final NotRuleContext notRule() throws RecognitionException {
		NotRuleContext _localctx = new NotRuleContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_notRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
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
		public TerminalNode NOT2_SYMBOL() { return getToken(SQLBaseParser.NOT2_SYMBOL, 0); }
		public Not2RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not2Rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterNot2Rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitNot2Rule(this);
		}
	}

	public final Not2RuleContext not2Rule() throws RecognitionException {
		Not2RuleContext _localctx = new Not2RuleContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_not2Rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprListWithParentheses(this);
		}
	}

	public final ExprListWithParenthesesContext exprListWithParentheses() throws RecognitionException {
		ExprListWithParenthesesContext _localctx = new ExprListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_exprListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			match(OPEN_PAR_SYMBOL);
			setState(1070);
			exprList();
			setState(1071);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public ExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitExprWithParentheses(this);
		}
	}

	public final ExprWithParenthesesContext exprWithParentheses() throws RecognitionException {
		ExprWithParenthesesContext _localctx = new ExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_exprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073);
			match(OPEN_PAR_SYMBOL);
			setState(1074);
			expr(0);
			setState(1075);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public SimpleExprWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExprWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleExprWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleExprWithParentheses(this);
		}
	}

	public final SimpleExprWithParenthesesContext simpleExprWithParentheses() throws RecognitionException {
		SimpleExprWithParenthesesContext _localctx = new SimpleExprWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_simpleExprWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1077);
			match(OPEN_PAR_SYMBOL);
			setState(1078);
			simpleExpr(0);
			setState(1079);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public OrderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterOrderList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitOrderList(this);
		}
	}

	public final OrderListContext orderList() throws RecognitionException {
		OrderListContext _localctx = new OrderListContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_orderList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1081);
			orderExpression();
			setState(1086);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1082);
					match(COMMA_SYMBOL);
					setState(1083);
					orderExpression();
					}
					} 
				}
				setState(1088);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterOrderExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitOrderExpression(this);
		}
	}

	public final OrderExpressionContext orderExpression() throws RecognitionException {
		OrderExpressionContext _localctx = new OrderExpressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_orderExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			expr(0);
			setState(1091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1090);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public GroupListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterGroupList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitGroupList(this);
		}
	}

	public final GroupListContext groupList() throws RecognitionException {
		GroupListContext _localctx = new GroupListContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_groupList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1093);
			groupingExpression();
			setState(1098);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1094);
				match(COMMA_SYMBOL);
				setState(1095);
				groupingExpression();
				}
				}
				setState(1100);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterGroupingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitGroupingExpression(this);
		}
	}

	public final GroupingExpressionContext groupingExpression() throws RecognitionException {
		GroupingExpressionContext _localctx = new GroupingExpressionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_groupingExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1101);
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
		public TerminalNode IDENTIFIER() { return getToken(SQLBaseParser.IDENTIFIER, 0); }
		public List<TerminalNode> DOT_IDENTIFIER() { return getTokens(SQLBaseParser.DOT_IDENTIFIER); }
		public TerminalNode DOT_IDENTIFIER(int i) {
			return getToken(SQLBaseParser.DOT_IDENTIFIER, i);
		}
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(SQLBaseParser.DOUBLE_QUOTED_TEXT, 0); }
		public PureIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPureIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPureIdentifier(this);
		}
	}

	public final PureIdentifierContext pureIdentifier() throws RecognitionException {
		PureIdentifierContext _localctx = new PureIdentifierContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_pureIdentifier);
		try {
			int _alt;
			setState(1111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1103);
				match(IDENTIFIER);
				setState(1107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1104);
						match(DOT_IDENTIFIER);
						}
						} 
					}
					setState(1109);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				}
				break;
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1110);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_identifier);
		try {
			setState(1115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1113);
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
				setState(1114);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1117);
			identifier();
			setState(1122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1118);
				match(COMMA_SYMBOL);
				setState(1119);
				identifier();
				}
				}
				setState(1124);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public IdentifierListWithParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierListWithParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentifierListWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentifierListWithParentheses(this);
		}
	}

	public final IdentifierListWithParenthesesContext identifierListWithParentheses() throws RecognitionException {
		IdentifierListWithParenthesesContext _localctx = new IdentifierListWithParenthesesContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_identifierListWithParentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1125);
			match(OPEN_PAR_SYMBOL);
			setState(1126);
			identifierList();
			setState(1127);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterQualifiedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitQualifiedIdentifier(this);
		}
	}

	public final QualifiedIdentifierContext qualifiedIdentifier() throws RecognitionException {
		QualifiedIdentifierContext _localctx = new QualifiedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_qualifiedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			identifier();
			setState(1131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				{
				setState(1130);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSimpleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSimpleIdentifier(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_simpleIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1133);
			identifier();
			setState(1138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT_SYMBOL) {
				{
				setState(1134);
				dotIdentifier();
				setState(1136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1135);
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
		public TerminalNode DOT_SYMBOL() { return getToken(SQLBaseParser.DOT_SYMBOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterDotIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitDotIdentifier(this);
		}
	}

	public final DotIdentifierContext dotIdentifier() throws RecognitionException {
		DotIdentifierContext _localctx = new DotIdentifierContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_dotIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1140);
			match(DOT_SYMBOL);
			setState(1141);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(SQLBaseParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(SQLBaseParser.FLOAT_NUMBER, 0); }
		public Ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterUlong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitUlong_number(this);
		}
	}

	public final Ulong_numberContext ulong_number() throws RecognitionException {
		Ulong_numberContext _localctx = new Ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public Real_ulong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterReal_ulong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitReal_ulong_number(this);
		}
	}

	public final Real_ulong_numberContext real_ulong_number() throws RecognitionException {
		Real_ulong_numberContext _localctx = new Real_ulong_numberContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_real_ulong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1145);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(SQLBaseParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(SQLBaseParser.FLOAT_NUMBER, 0); }
		public Ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterUlonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitUlonglong_number(this);
		}
	}

	public final Ulonglong_numberContext ulonglong_number() throws RecognitionException {
		Ulonglong_numberContext _localctx = new Ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public Real_ulonglong_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_ulonglong_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterReal_ulonglong_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitReal_ulonglong_number(this);
		}
	}

	public final Real_ulonglong_numberContext real_ulonglong_number() throws RecognitionException {
		Real_ulonglong_numberContext _localctx = new Real_ulonglong_numberContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_real_ulonglong_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149);
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
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(SQLBaseParser.BIN_NUMBER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_literal);
		int _la;
		try {
			setState(1157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCHAR_TEXT:
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1151);
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
				setState(1152);
				numLiteral();
				}
				break;
			case DATE_SYMBOL:
			case TIMESTAMP_SYMBOL:
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1153);
				temporalLiteral();
				}
				break;
			case NULL2_SYMBOL:
			case NULL_SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1154);
				nullLiteral();
				}
				break;
			case FALSE_SYMBOL:
			case TRUE_SYMBOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1155);
				boolLiteral();
				}
				break;
			case HEX_NUMBER:
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1156);
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
		public TerminalNode PLUS_OPERATOR() { return getToken(SQLBaseParser.PLUS_OPERATOR, 0); }
		public Ulong_numberContext ulong_number() {
			return getRuleContext(Ulong_numberContext.class,0);
		}
		public TerminalNode MINUS_OPERATOR() { return getToken(SQLBaseParser.MINUS_OPERATOR, 0); }
		public SignedLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSignedLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSignedLiteral(this);
		}
	}

	public final SignedLiteralContext signedLiteral() throws RecognitionException {
		SignedLiteralContext _localctx = new SignedLiteralContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_signedLiteral);
		try {
			setState(1164);
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
				setState(1159);
				literal();
				}
				break;
			case PLUS_OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1160);
				match(PLUS_OPERATOR);
				setState(1161);
				ulong_number();
				}
				break;
			case MINUS_OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1162);
				match(MINUS_OPERATOR);
				setState(1163);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public List<TextStringContext> textString() {
			return getRuleContexts(TextStringContext.class);
		}
		public TextStringContext textString(int i) {
			return getRuleContext(TextStringContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterStringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitStringList(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_stringList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			match(OPEN_PAR_SYMBOL);
			setState(1167);
			textString();
			setState(1172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1168);
				match(COMMA_SYMBOL);
				setState(1169);
				textString();
				}
				}
				setState(1174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1175);
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
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(SQLBaseParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode DOUBLE_QUOTED_TEXT() { return getToken(SQLBaseParser.DOUBLE_QUOTED_TEXT, 0); }
		public TextStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextStringLiteral(this);
		}
	}

	public final TextStringLiteralContext textStringLiteral() throws RecognitionException {
		TextStringLiteralContext _localctx = new TextStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_textStringLiteral);
		try {
			setState(1179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1177);
				((TextStringLiteralContext)_localctx).value = match(SINGLE_QUOTED_TEXT);
				}
				break;
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1178);
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
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TerminalNode BIN_NUMBER() { return getToken(SQLBaseParser.BIN_NUMBER, 0); }
		public TextStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextString(this);
		}
	}

	public final TextStringContext textString() throws RecognitionException {
		TextStringContext _localctx = new TextStringContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_textString);
		try {
			setState(1184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1181);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1182);
				match(HEX_NUMBER);
				}
				break;
			case BIN_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1183);
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
		public TerminalNode HEX_NUMBER() { return getToken(SQLBaseParser.HEX_NUMBER, 0); }
		public TextStringHashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringHash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextStringHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextStringHash(this);
		}
	}

	public final TextStringHashContext textStringHash() throws RecognitionException {
		TextStringHashContext _localctx = new TextStringHashContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_textStringHash);
		try {
			setState(1188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1186);
				textStringLiteral();
				}
				break;
			case HEX_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1187);
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
		public TerminalNode NCHAR_TEXT() { return getToken(SQLBaseParser.NCHAR_TEXT, 0); }
		public TextLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextLiteral(this);
		}
	}

	public final TextLiteralContext textLiteral() throws RecognitionException {
		TextLiteralContext _localctx = new TextLiteralContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_textLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTED_TEXT:
			case SINGLE_QUOTED_TEXT:
				{
				setState(1190);
				textStringLiteral();
				}
				break;
			case NCHAR_TEXT:
				{
				setState(1191);
				match(NCHAR_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1194);
					textStringLiteral();
					}
					} 
				}
				setState(1199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextStringNoLinebreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextStringNoLinebreak(this);
		}
	}

	public final TextStringNoLinebreakContext textStringNoLinebreak() throws RecognitionException {
		TextStringNoLinebreakContext _localctx = new TextStringNoLinebreakContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_textStringNoLinebreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1200);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public TextStringLiteralListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStringLiteralList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextStringLiteralList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextStringLiteralList(this);
		}
	}

	public final TextStringLiteralListContext textStringLiteralList() throws RecognitionException {
		TextStringLiteralListContext _localctx = new TextStringLiteralListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_textStringLiteralList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1202);
			textStringLiteral();
			setState(1207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1203);
				match(COMMA_SYMBOL);
				setState(1204);
				textStringLiteral();
				}
				}
				setState(1209);
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
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode LONG_NUMBER() { return getToken(SQLBaseParser.LONG_NUMBER, 0); }
		public TerminalNode ULONGLONG_NUMBER() { return getToken(SQLBaseParser.ULONGLONG_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(SQLBaseParser.DECIMAL_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(SQLBaseParser.FLOAT_NUMBER, 0); }
		public NumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterNumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitNumLiteral(this);
		}
	}

	public final NumLiteralContext numLiteral() throws RecognitionException {
		NumLiteralContext _localctx = new NumLiteralContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_numLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
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
		public TerminalNode TRUE_SYMBOL() { return getToken(SQLBaseParser.TRUE_SYMBOL, 0); }
		public TerminalNode FALSE_SYMBOL() { return getToken(SQLBaseParser.FALSE_SYMBOL, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitBoolLiteral(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1212);
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
		public TerminalNode NULL_SYMBOL() { return getToken(SQLBaseParser.NULL_SYMBOL, 0); }
		public TerminalNode NULL2_SYMBOL() { return getToken(SQLBaseParser.NULL2_SYMBOL, 0); }
		public NullLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitNullLiteral(this);
		}
	}

	public final NullLiteralContext nullLiteral() throws RecognitionException {
		NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_nullLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214);
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
		public TerminalNode DATE_SYMBOL() { return getToken(SQLBaseParser.DATE_SYMBOL, 0); }
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(SQLBaseParser.SINGLE_QUOTED_TEXT, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(SQLBaseParser.TIME_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(SQLBaseParser.TIMESTAMP_SYMBOL, 0); }
		public TemporalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTemporalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTemporalLiteral(this);
		}
	}

	public final TemporalLiteralContext temporalLiteral() throws RecognitionException {
		TemporalLiteralContext _localctx = new TemporalLiteralContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_temporalLiteral);
		try {
			setState(1222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATE_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1216);
				match(DATE_SYMBOL);
				setState(1217);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIME_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1218);
				match(TIME_SYMBOL);
				setState(1219);
				match(SINGLE_QUOTED_TEXT);
				}
				break;
			case TIMESTAMP_SYMBOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1220);
				match(TIMESTAMP_SYMBOL);
				setState(1221);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFloatOptions(this);
		}
	}

	public final FloatOptionsContext floatOptions() throws RecognitionException {
		FloatOptionsContext _localctx = new FloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_floatOptions);
		try {
			setState(1226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1224);
				fieldLength();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1225);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterStandardFloatOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitStandardFloatOptions(this);
		}
	}

	public final StandardFloatOptionsContext standardFloatOptions() throws RecognitionException {
		StandardFloatOptionsContext _localctx = new StandardFloatOptionsContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_standardFloatOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1228);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public List<TerminalNode> INT_NUMBER() { return getTokens(SQLBaseParser.INT_NUMBER); }
		public TerminalNode INT_NUMBER(int i) {
			return getToken(SQLBaseParser.INT_NUMBER, i);
		}
		public TerminalNode COMMA_SYMBOL() { return getToken(SQLBaseParser.COMMA_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitPrecision(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1230);
			match(OPEN_PAR_SYMBOL);
			setState(1231);
			match(INT_NUMBER);
			setState(1232);
			match(COMMA_SYMBOL);
			setState(1233);
			match(INT_NUMBER);
			setState(1234);
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
		public TerminalNode SINGLE_QUOTED_TEXT() { return getToken(SQLBaseParser.SINGLE_QUOTED_TEXT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TextOrIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textOrIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTextOrIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTextOrIdentifier(this);
		}
	}

	public final TextOrIdentifierContext textOrIdentifier() throws RecognitionException {
		TextOrIdentifierContext _localctx = new TextOrIdentifierContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_textOrIdentifier);
		try {
			setState(1238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1236);
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
				setState(1237);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterSizeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitSizeNumber(this);
		}
	}

	public final SizeNumberContext sizeNumber() throws RecognitionException {
		SizeNumberContext _localctx = new SizeNumberContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_sizeNumber);
		try {
			setState(1242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1240);
				real_ulonglong_number();
				}
				break;
			case IDENTIFIER:
			case DOUBLE_QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1241);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitParentheses(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1244);
			match(OPEN_PAR_SYMBOL);
			setState(1245);
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
		public TerminalNode EQUAL_OPERATOR() { return getToken(SQLBaseParser.EQUAL_OPERATOR, 0); }
		public TerminalNode ASSIGN_OPERATOR() { return getToken(SQLBaseParser.ASSIGN_OPERATOR, 0); }
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_equal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1247);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentifierKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentifierKeyword(this);
		}
	}

	public final IdentifierKeywordContext identifierKeyword() throws RecognitionException {
		IdentifierKeywordContext _localctx = new IdentifierKeywordContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_identifierKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1249);
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
		public TerminalNode ANY_SYMBOL() { return getToken(SQLBaseParser.ANY_SYMBOL, 0); }
		public TerminalNode AT_SYMBOL() { return getToken(SQLBaseParser.AT_SYMBOL, 0); }
		public TerminalNode AVG_SYMBOL() { return getToken(SQLBaseParser.AVG_SYMBOL, 0); }
		public TerminalNode COALESCE_SYMBOL() { return getToken(SQLBaseParser.COALESCE_SYMBOL, 0); }
		public TerminalNode CURRENT_SYMBOL() { return getToken(SQLBaseParser.CURRENT_SYMBOL, 0); }
		public TerminalNode DATE_SYMBOL() { return getToken(SQLBaseParser.DATE_SYMBOL, 0); }
		public TerminalNode ESCAPE_SYMBOL() { return getToken(SQLBaseParser.ESCAPE_SYMBOL, 0); }
		public TerminalNode EXCLUDE_SYMBOL() { return getToken(SQLBaseParser.EXCLUDE_SYMBOL, 0); }
		public TerminalNode FIRST_SYMBOL() { return getToken(SQLBaseParser.FIRST_SYMBOL, 0); }
		public TerminalNode FOLLOWING_SYMBOL() { return getToken(SQLBaseParser.FOLLOWING_SYMBOL, 0); }
		public TerminalNode FULL_SYMBOL() { return getToken(SQLBaseParser.FULL_SYMBOL, 0); }
		public TerminalNode LAST_SYMBOL() { return getToken(SQLBaseParser.LAST_SYMBOL, 0); }
		public TerminalNode LOCKED_SYMBOL() { return getToken(SQLBaseParser.LOCKED_SYMBOL, 0); }
		public TerminalNode MODE_SYMBOL() { return getToken(SQLBaseParser.MODE_SYMBOL, 0); }
		public TerminalNode NOWAIT_SYMBOL() { return getToken(SQLBaseParser.NOWAIT_SYMBOL, 0); }
		public TerminalNode NULLS_SYMBOL() { return getToken(SQLBaseParser.NULLS_SYMBOL, 0); }
		public TerminalNode OFFSET_SYMBOL() { return getToken(SQLBaseParser.OFFSET_SYMBOL, 0); }
		public TerminalNode OTHERS_SYMBOL() { return getToken(SQLBaseParser.OTHERS_SYMBOL, 0); }
		public TerminalNode PRECEDING_SYMBOL() { return getToken(SQLBaseParser.PRECEDING_SYMBOL, 0); }
		public TerminalNode SHARE_SYMBOL() { return getToken(SQLBaseParser.SHARE_SYMBOL, 0); }
		public TerminalNode SKIP_SYMBOL() { return getToken(SQLBaseParser.SKIP_SYMBOL, 0); }
		public TerminalNode TIES_SYMBOL() { return getToken(SQLBaseParser.TIES_SYMBOL, 0); }
		public TerminalNode TIMESTAMP_SYMBOL() { return getToken(SQLBaseParser.TIMESTAMP_SYMBOL, 0); }
		public TerminalNode TIME_SYMBOL() { return getToken(SQLBaseParser.TIME_SYMBOL, 0); }
		public TerminalNode UNBOUNDED_SYMBOL() { return getToken(SQLBaseParser.UNBOUNDED_SYMBOL, 0); }
		public TerminalNode UNKNOWN_SYMBOL() { return getToken(SQLBaseParser.UNKNOWN_SYMBOL, 0); }
		public IdentifierKeywordsUnambiguousContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierKeywordsUnambiguous; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterIdentifierKeywordsUnambiguous(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitIdentifierKeywordsUnambiguous(this);
		}
	}

	public final IdentifierKeywordsUnambiguousContext identifierKeywordsUnambiguous() throws RecognitionException {
		IdentifierKeywordsUnambiguousContext _localctx = new IdentifierKeywordsUnambiguousContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_identifierKeywordsUnambiguous);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1251);
			_la = _input.LA(1);
			if ( !(((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (COALESCE_SYMBOL - 37)) | (1L << (NULLS_SYMBOL - 37)) | (1L << (PRECEDING_SYMBOL - 37)) | (1L << (UNBOUNDED_SYMBOL - 37)) | (1L << (CURRENT_SYMBOL - 37)) | (1L << (FOLLOWING_SYMBOL - 37)) | (1L << (EXCLUDE_SYMBOL - 37)) | (1L << (TIES_SYMBOL - 37)) | (1L << (OTHERS_SYMBOL - 37)) | (1L << (AVG_SYMBOL - 37)) | (1L << (MODE_SYMBOL - 37)) | (1L << (SHARE_SYMBOL - 37)) | (1L << (SKIP_SYMBOL - 37)) | (1L << (LOCKED_SYMBOL - 37)) | (1L << (ANY_SYMBOL - 37)) | (1L << (AT_SYMBOL - 37)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (DATE_SYMBOL - 105)) | (1L << (ESCAPE_SYMBOL - 105)) | (1L << (FIRST_SYMBOL - 105)) | (1L << (FULL_SYMBOL - 105)) | (1L << (LAST_SYMBOL - 105)) | (1L << (OFFSET_SYMBOL - 105)) | (1L << (TIMESTAMP_SYMBOL - 105)) | (1L << (TIME_SYMBOL - 105)) | (1L << (UNKNOWN_SYMBOL - 105)) | (1L << (NOWAIT_SYMBOL - 105)))) != 0)) ) {
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterWindowName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitWindowName(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1253);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFieldIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFieldIdentifier(this);
		}
	}

	public final FieldIdentifierContext fieldIdentifier() throws RecognitionException {
		FieldIdentifierContext _localctx = new FieldIdentifierContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_fieldIdentifier);
		try {
			setState(1260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1255);
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
				setState(1256);
				qualifiedIdentifier();
				setState(1258);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(1257);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1262);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterColumnInternalRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitColumnInternalRef(this);
		}
	}

	public final ColumnInternalRefContext columnInternalRef() throws RecognitionException {
		ColumnInternalRefContext _localctx = new ColumnInternalRefContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_columnInternalRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1264);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public List<ColumnInternalRefContext> columnInternalRef() {
			return getRuleContexts(ColumnInternalRefContext.class);
		}
		public ColumnInternalRefContext columnInternalRef(int i) {
			return getRuleContext(ColumnInternalRefContext.class,i);
		}
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public ColumnInternalRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnInternalRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterColumnInternalRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitColumnInternalRefList(this);
		}
	}

	public final ColumnInternalRefListContext columnInternalRefList() throws RecognitionException {
		ColumnInternalRefListContext _localctx = new ColumnInternalRefListContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_columnInternalRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1266);
			match(OPEN_PAR_SYMBOL);
			setState(1267);
			columnInternalRef();
			setState(1272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1268);
				match(COMMA_SYMBOL);
				setState(1269);
				columnInternalRef();
				}
				}
				setState(1274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1275);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitColumnRef(this);
		}
	}

	public final ColumnRefContext columnRef() throws RecognitionException {
		ColumnRefContext _localctx = new ColumnRefContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1277);
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
		public TerminalNode DOT_SYMBOL() { return getToken(SQLBaseParser.DOT_SYMBOL, 0); }
		public TerminalNode MULT_OPERATOR() { return getToken(SQLBaseParser.MULT_OPERATOR, 0); }
		public DotIdentifierContext dotIdentifier() {
			return getRuleContext(DotIdentifierContext.class,0);
		}
		public TableRefWithWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRefWithWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableRefWithWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableRefWithWildcard(this);
		}
	}

	public final TableRefWithWildcardContext tableRefWithWildcard() throws RecognitionException {
		TableRefWithWildcardContext _localctx = new TableRefWithWildcardContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_tableRefWithWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279);
			identifier();
			setState(1287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				{
				setState(1280);
				match(DOT_SYMBOL);
				setState(1281);
				match(MULT_OPERATOR);
				}
				break;
			case 2:
				{
				setState(1282);
				dotIdentifier();
				setState(1285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT_SYMBOL) {
					{
					setState(1283);
					match(DOT_SYMBOL);
					setState(1284);
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
		public List<TerminalNode> COMMA_SYMBOL() { return getTokens(SQLBaseParser.COMMA_SYMBOL); }
		public TerminalNode COMMA_SYMBOL(int i) {
			return getToken(SQLBaseParser.COMMA_SYMBOL, i);
		}
		public TableAliasRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAliasRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableAliasRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableAliasRefList(this);
		}
	}

	public final TableAliasRefListContext tableAliasRefList() throws RecognitionException {
		TableAliasRefListContext _localctx = new TableAliasRefListContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_tableAliasRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1289);
			tableRefWithWildcard();
			setState(1294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_SYMBOL) {
				{
				{
				setState(1290);
				match(COMMA_SYMBOL);
				setState(1291);
				tableRefWithWildcard();
				}
				}
				setState(1296);
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
		public List<TerminalNode> DOT_SYMBOL() { return getTokens(SQLBaseParser.DOT_SYMBOL); }
		public TerminalNode DOT_SYMBOL(int i) {
			return getToken(SQLBaseParser.DOT_SYMBOL, i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(SQLBaseParser.MULT_OPERATOR, 0); }
		public TableWildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableWild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableWild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableWild(this);
		}
	}

	public final TableWildContext tableWild() throws RecognitionException {
		TableWildContext _localctx = new TableWildContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_tableWild);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1297);
			identifier();
			setState(1298);
			match(DOT_SYMBOL);
			setState(1302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (COALESCE_SYMBOL - 37)) | (1L << (NULLS_SYMBOL - 37)) | (1L << (PRECEDING_SYMBOL - 37)) | (1L << (UNBOUNDED_SYMBOL - 37)) | (1L << (CURRENT_SYMBOL - 37)) | (1L << (FOLLOWING_SYMBOL - 37)) | (1L << (EXCLUDE_SYMBOL - 37)) | (1L << (TIES_SYMBOL - 37)) | (1L << (OTHERS_SYMBOL - 37)) | (1L << (AVG_SYMBOL - 37)) | (1L << (MODE_SYMBOL - 37)) | (1L << (SHARE_SYMBOL - 37)) | (1L << (SKIP_SYMBOL - 37)) | (1L << (LOCKED_SYMBOL - 37)) | (1L << (ANY_SYMBOL - 37)) | (1L << (AT_SYMBOL - 37)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (DATE_SYMBOL - 105)) | (1L << (ESCAPE_SYMBOL - 105)) | (1L << (FIRST_SYMBOL - 105)) | (1L << (FULL_SYMBOL - 105)) | (1L << (LAST_SYMBOL - 105)) | (1L << (OFFSET_SYMBOL - 105)) | (1L << (TIMESTAMP_SYMBOL - 105)) | (1L << (TIME_SYMBOL - 105)) | (1L << (UNKNOWN_SYMBOL - 105)) | (1L << (NOWAIT_SYMBOL - 105)) | (1L << (IDENTIFIER - 105)) | (1L << (DOUBLE_QUOTED_TEXT - 105)))) != 0)) {
				{
				setState(1299);
				identifier();
				setState(1300);
				match(DOT_SYMBOL);
				}
			}

			setState(1304);
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
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTableRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTableRef(this);
		}
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_tableRef);
		try {
			setState(1308);
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
				setState(1306);
				qualifiedIdentifier();
				}
				break;
			case DOT_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1307);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public Real_ulonglong_numberContext real_ulonglong_number() {
			return getRuleContext(Real_ulonglong_numberContext.class,0);
		}
		public TerminalNode DECIMAL_NUMBER() { return getToken(SQLBaseParser.DECIMAL_NUMBER, 0); }
		public FieldLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterFieldLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitFieldLength(this);
		}
	}

	public final FieldLengthContext fieldLength() throws RecognitionException {
		FieldLengthContext _localctx = new FieldLengthContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_fieldLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1310);
			match(OPEN_PAR_SYMBOL);
			setState(1313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG_NUMBER:
			case ULONGLONG_NUMBER:
			case HEX_NUMBER:
			case INT_NUMBER:
				{
				setState(1311);
				real_ulonglong_number();
				}
				break;
			case DECIMAL_NUMBER:
				{
				setState(1312);
				match(DECIMAL_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1315);
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
		public TerminalNode OPEN_PAR_SYMBOL() { return getToken(SQLBaseParser.OPEN_PAR_SYMBOL, 0); }
		public TerminalNode INT_NUMBER() { return getToken(SQLBaseParser.INT_NUMBER, 0); }
		public TerminalNode CLOSE_PAR_SYMBOL() { return getToken(SQLBaseParser.CLOSE_PAR_SYMBOL, 0); }
		public TypeDatetimePrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDatetimePrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).enterTypeDatetimePrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseParserListener ) ((SQLBaseParserListener)listener).exitTypeDatetimePrecision(this);
		}
	}

	public final TypeDatetimePrecisionContext typeDatetimePrecision() throws RecognitionException {
		TypeDatetimePrecisionContext _localctx = new TypeDatetimePrecisionContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_typeDatetimePrecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1317);
			match(OPEN_PAR_SYMBOL);
			setState(1318);
			match(INT_NUMBER);
			setState(1319);
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
		case 2:
			return queryExpressionBody_sempred((QueryExpressionBodyContext)_localctx, predIndex);
		case 50:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 51:
			return boolPri_sempred((BoolPriContext)_localctx, predIndex);
		case 55:
			return bitExpr_sempred((BitExprContext)_localctx, predIndex);
		case 56:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u009c\u052c\4\2\t"+
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
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\3\2\3"+
		"\2\5\2\u010b\n\2\3\3\5\3\u010e\n\3\3\3\3\3\5\3\u0112\n\3\3\3\5\3\u0115"+
		"\n\3\3\3\3\3\3\3\5\3\u011a\n\3\3\3\5\3\u011d\n\3\5\3\u011f\n\3\3\3\5\3"+
		"\u0122\n\3\3\3\3\3\3\3\5\3\u0127\n\3\5\3\u0129\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u0130\n\4\3\4\3\4\5\4\u0134\n\4\5\4\u0136\n\4\3\4\3\4\3\4\5\4\u013b"+
		"\n\4\3\4\3\4\5\4\u013f\n\4\7\4\u0141\n\4\f\4\16\4\u0144\13\4\3\5\3\5\3"+
		"\5\5\5\u0149\n\5\3\5\3\5\3\6\3\6\7\6\u014f\n\6\f\6\16\6\u0152\13\6\3\6"+
		"\3\6\5\6\u0156\n\6\3\6\5\6\u0159\n\6\3\6\5\6\u015c\n\6\3\6\5\6\u015f\n"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u016e\n"+
		"\13\3\f\3\f\5\f\u0172\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u017b\n"+
		"\16\f\16\16\16\u017e\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\5\21\u0189\n\21\3\21\3\21\3\21\5\21\u018e\n\21\3\21\5\21\u0191\n\21\3"+
		"\21\5\21\u0194\n\21\3\22\3\22\3\22\5\22\u0199\n\22\3\23\3\23\3\24\3\24"+
		"\5\24\u019f\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01aa"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u01b9\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01c2\n\30\3"+
		"\31\3\31\5\31\u01c6\n\31\3\31\3\31\3\31\7\31\u01cb\n\31\f\31\16\31\u01ce"+
		"\13\31\3\32\3\32\5\32\u01d2\n\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\5\36\u01e4\n\36\3\37\3\37"+
		"\3\37\7\37\u01e9\n\37\f\37\16\37\u01ec\13\37\3 \3 \3!\3!\3!\3!\5!\u01f4"+
		"\n!\3!\5!\u01f7\n!\3!\3!\3!\3!\5!\u01fd\n!\3\"\3\"\3#\3#\3#\5#\u0204\n"+
		"#\3$\3$\5$\u0208\n$\3$\3$\7$\u020c\n$\f$\16$\u020f\13$\3%\3%\3%\5%\u0214"+
		"\n%\5%\u0216\n%\3&\5&\u0219\n&\3&\3&\5&\u021d\n&\3\'\3\'\3\'\3(\3(\7("+
		"\u0224\n(\f(\16(\u0227\13(\3)\3)\7)\u022b\n)\f)\16)\u022e\13)\3*\3*\3"+
		"*\3*\3*\3*\5*\u0236\n*\3*\3*\3*\3*\3*\3*\5*\u023e\n*\5*\u0240\n*\3+\5"+
		"+\u0243\n+\3+\3+\3,\3,\5,\u0249\n,\3,\3,\3-\3-\3-\3-\5-\u0251\n-\3.\3"+
		".\5.\u0255\n.\3/\3/\3/\5/\u025a\n/\3/\3/\3\60\3\60\5\60\u0260\n\60\3\60"+
		"\5\60\u0263\n\60\3\60\3\60\3\60\5\60\u0268\n\60\3\60\5\60\u026b\n\60\5"+
		"\60\u026d\n\60\3\61\3\61\3\61\5\61\u0272\n\61\3\61\3\61\3\62\3\62\3\63"+
		"\5\63\u0279\n\63\3\63\3\63\3\64\3\64\3\64\3\64\5\64\u0281\n\64\3\64\5"+
		"\64\u0284\n\64\3\64\3\64\5\64\u0288\n\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\7\64\u0290\n\64\f\64\16\64\u0293\13\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\5\65\u029b\n\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\7\65"+
		"\u02a7\n\65\f\65\16\65\u02aa\13\65\3\66\3\66\3\67\3\67\5\67\u02b0\n\67"+
		"\3\67\5\67\u02b3\n\67\38\38\38\38\38\38\58\u02bb\n8\38\38\38\38\38\38"+
		"\38\38\38\58\u02c6\n8\58\u02c8\n8\39\39\39\39\39\39\39\39\39\79\u02d3"+
		"\n9\f9\169\u02d6\139\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u02e7"+
		"\n:\3:\3:\3:\3:\3:\5:\u02ee\n:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\3:\3:\5:\u02ff\n:\3:\3:\3:\6:\u0304\n:\r:\16:\u0305\3:\5:\u0309\n:\3"+
		":\3:\5:\u030d\n:\3:\3:\3:\7:\u0312\n:\f:\16:\u0315\13:\3;\3;\3;\5;\u031a"+
		"\n;\3;\3;\3;\5;\u031f\n;\3;\3;\3;\5;\u0324\n;\3;\3;\3;\5;\u0329\n;\3;"+
		"\3;\3;\5;\u032e\n;\3;\3;\3;\3;\5;\u0334\n;\3;\3;\5;\u0338\n;\3;\3;\3;"+
		"\5;\u033d\n;\3;\3;\3;\5;\u0342\n;\3;\3;\3;\5;\u0347\n;\3;\3;\3;\5;\u034c"+
		"\n;\3;\3;\3;\3;\3;\5;\u0353\n;\3;\3;\3;\3;\3;\5;\u035a\n;\3;\3;\3;\5;"+
		"\u035f\n;\3;\3;\3;\5;\u0364\n;\3;\3;\3;\5;\u0369\n;\3;\3;\5;\u036d\n;"+
		"\3;\3;\5;\u0371\n;\3;\3;\5;\u0375\n;\5;\u0377\n;\3<\3<\3<\3<\3<\3=\3="+
		"\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u038a\n=\3=\3=\3=\3=\3=\3=\3=\5=\u0393"+
		"\n=\3>\3>\3>\5>\u0398\n>\3?\3?\3?\5?\u039d\n?\3?\3?\5?\u03a1\n?\3@\5@"+
		"\u03a4\n@\3@\3@\3A\3A\3A\3A\3A\5A\u03ad\nA\3B\3B\3B\7B\u03b2\nB\fB\16"+
		"B\u03b5\13B\3C\3C\5C\u03b9\nC\3C\3C\3C\3C\3C\6C\u03c0\nC\rC\16C\u03c1"+
		"\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u03d6\nC\3C"+
		"\3C\3C\5C\u03db\nC\3D\3D\5D\u03df\nD\3D\3D\3E\3E\3F\3F\3F\3F\3F\3F\3F"+
		"\5F\u03ec\nF\3F\3F\3F\3F\5F\u03f2\nF\5F\u03f4\nF\3F\3F\3G\3G\3G\5G\u03fb"+
		"\nG\3G\3G\3G\3G\3G\5G\u0402\nG\3G\3G\5G\u0406\nG\3H\3H\3H\7H\u040b\nH"+
		"\fH\16H\u040e\13H\3I\3I\5I\u0412\nI\3J\3J\3J\3K\3K\3K\3L\3L\3L\3M\3M\3"+
		"M\5M\u0420\nM\5M\u0422\nM\3N\3N\3N\7N\u0427\nN\fN\16N\u042a\13N\3O\3O"+
		"\3P\3P\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3S\3S\3S\3S\3T\3T\3T\7T\u043f\nT\fT\16"+
		"T\u0442\13T\3U\3U\5U\u0446\nU\3V\3V\3V\7V\u044b\nV\fV\16V\u044e\13V\3"+
		"W\3W\3X\3X\7X\u0454\nX\fX\16X\u0457\13X\3X\5X\u045a\nX\3Y\3Y\5Y\u045e"+
		"\nY\3Z\3Z\3Z\7Z\u0463\nZ\fZ\16Z\u0466\13Z\3[\3[\3[\3[\3\\\3\\\5\\\u046e"+
		"\n\\\3]\3]\3]\5]\u0473\n]\5]\u0475\n]\3^\3^\3^\3_\3_\3`\3`\3a\3a\3b\3"+
		"b\3c\3c\3c\3c\3c\3c\5c\u0488\nc\3d\3d\3d\3d\3d\5d\u048f\nd\3e\3e\3e\3"+
		"e\7e\u0495\ne\fe\16e\u0498\13e\3e\3e\3f\3f\5f\u049e\nf\3g\3g\3g\5g\u04a3"+
		"\ng\3h\3h\5h\u04a7\nh\3i\3i\5i\u04ab\ni\3i\7i\u04ae\ni\fi\16i\u04b1\13"+
		"i\3j\3j\3k\3k\3k\7k\u04b8\nk\fk\16k\u04bb\13k\3l\3l\3m\3m\3n\3n\3o\3o"+
		"\3o\3o\3o\3o\5o\u04c9\no\3p\3p\5p\u04cd\np\3q\3q\3r\3r\3r\3r\3r\3r\3s"+
		"\3s\5s\u04d9\ns\3t\3t\5t\u04dd\nt\3u\3u\3u\3v\3v\3w\3w\3x\3x\3y\3y\3z"+
		"\3z\3z\5z\u04ed\nz\5z\u04ef\nz\3{\3{\3|\3|\3}\3}\3}\3}\7}\u04f9\n}\f}"+
		"\16}\u04fc\13}\3}\3}\3~\3~\3\177\3\177\3\177\3\177\3\177\3\177\5\177\u0508"+
		"\n\177\5\177\u050a\n\177\3\u0080\3\u0080\3\u0080\7\u0080\u050f\n\u0080"+
		"\f\u0080\16\u0080\u0512\13\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081"+
		"\5\u0081\u0519\n\u0081\3\u0081\3\u0081\3\u0082\3\u0082\5\u0082\u051f\n"+
		"\u0082\3\u0083\3\u0083\3\u0083\5\u0083\u0524\n\u0083\3\u0083\3\u0083\3"+
		"\u0084\3\u0084\3\u0084\3\u0084\3\u0084\2\7\6fhpr\u0085\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\2\32\4\2"+
		"..JJ\4\2\25\25\u0082\u0082\5\2\5\6\36\36!!\4\2eell\3\2UV\3\2Z[\3\2]^\4"+
		"\2qq\u008a\u008b\4\2..cc\4\2\7\7\t\16\3\2\21\23\3\2\17\20\4\2\64\64=>"+
		"\4\2\66\6688\4\2\65\65\67\67\4\2\3\3,,\5\2\5\6\37\37!#\5\2\5\6\37\37!"+
		"!\4\2\5\6!#\3\2\37 \4\2qq\u008a\u008a\4\2\35\35\u0081\u0081\3\2\7\b\26"+
		"\2\'\'::<<??AACFHHTUXYccffkkoorrtt||\u0082\u0082\u0087\u0088\u008b\u008b"+
		"\u0090\u0090\2\u057b\2\u010a\3\2\2\2\4\u0128\3\2\2\2\6\u0135\3\2\2\2\b"+
		"\u0145\3\2\2\2\n\u014c\3\2\2\2\f\u0160\3\2\2\2\16\u0162\3\2\2\2\20\u0164"+
		"\3\2\2\2\22\u0167\3\2\2\2\24\u016a\3\2\2\2\26\u0171\3\2\2\2\30\u0173\3"+
		"\2\2\2\32\u0176\3\2\2\2\34\u017f\3\2\2\2\36\u0183\3\2\2\2 \u0188\3\2\2"+
		"\2\"\u0195\3\2\2\2$\u019a\3\2\2\2&\u019e\3\2\2\2(\u01a9\3\2\2\2*\u01ab"+
		"\3\2\2\2,\u01b8\3\2\2\2.\u01ba\3\2\2\2\60\u01c3\3\2\2\2\62\u01cf\3\2\2"+
		"\2\64\u01d6\3\2\2\2\66\u01da\3\2\2\28\u01de\3\2\2\2:\u01e0\3\2\2\2<\u01e5"+
		"\3\2\2\2>\u01ed\3\2\2\2@\u01fc\3\2\2\2B\u01fe\3\2\2\2D\u0203\3\2\2\2F"+
		"\u0207\3\2\2\2H\u0215\3\2\2\2J\u0218\3\2\2\2L\u021e\3\2\2\2N\u0221\3\2"+
		"\2\2P\u0228\3\2\2\2R\u023f\3\2\2\2T\u0242\3\2\2\2V\u0246\3\2\2\2X\u0250"+
		"\3\2\2\2Z\u0252\3\2\2\2\\\u0256\3\2\2\2^\u026c\3\2\2\2`\u026e\3\2\2\2"+
		"b\u0275\3\2\2\2d\u0278\3\2\2\2f\u0287\3\2\2\2h\u0294\3\2\2\2j\u02ab\3"+
		"\2\2\2l\u02ad\3\2\2\2n\u02c7\3\2\2\2p\u02c9\3\2\2\2r\u030c\3\2\2\2t\u0376"+
		"\3\2\2\2v\u0378\3\2\2\2x\u0392\3\2\2\2z\u0394\3\2\2\2|\u0399\3\2\2\2~"+
		"\u03a3\3\2\2\2\u0080\u03ac\3\2\2\2\u0082\u03ae\3\2\2\2\u0084\u03da\3\2"+
		"\2\2\u0086\u03dc\3\2\2\2\u0088\u03e2\3\2\2\2\u008a\u03e4\3\2\2\2\u008c"+
		"\u0405\3\2\2\2\u008e\u0407\3\2\2\2\u0090\u040f\3\2\2\2\u0092\u0413\3\2"+
		"\2\2\u0094\u0416\3\2\2\2\u0096\u0419\3\2\2\2\u0098\u0421\3\2\2\2\u009a"+
		"\u0423\3\2\2\2\u009c\u042b\3\2\2\2\u009e\u042d\3\2\2\2\u00a0\u042f\3\2"+
		"\2\2\u00a2\u0433\3\2\2\2\u00a4\u0437\3\2\2\2\u00a6\u043b\3\2\2\2\u00a8"+
		"\u0443\3\2\2\2\u00aa\u0447\3\2\2\2\u00ac\u044f\3\2\2\2\u00ae\u0459\3\2"+
		"\2\2\u00b0\u045d\3\2\2\2\u00b2\u045f\3\2\2\2\u00b4\u0467\3\2\2\2\u00b6"+
		"\u046b\3\2\2\2\u00b8\u046f\3\2\2\2\u00ba\u0476\3\2\2\2\u00bc\u0479\3\2"+
		"\2\2\u00be\u047b\3\2\2\2\u00c0\u047d\3\2\2\2\u00c2\u047f\3\2\2\2\u00c4"+
		"\u0487\3\2\2\2\u00c6\u048e\3\2\2\2\u00c8\u0490\3\2\2\2\u00ca\u049d\3\2"+
		"\2\2\u00cc\u04a2\3\2\2\2\u00ce\u04a6\3\2\2\2\u00d0\u04aa\3\2\2\2\u00d2"+
		"\u04b2\3\2\2\2\u00d4\u04b4\3\2\2\2\u00d6\u04bc\3\2\2\2\u00d8\u04be\3\2"+
		"\2\2\u00da\u04c0\3\2\2\2\u00dc\u04c8\3\2\2\2\u00de\u04cc\3\2\2\2\u00e0"+
		"\u04ce\3\2\2\2\u00e2\u04d0\3\2\2\2\u00e4\u04d8\3\2\2\2\u00e6\u04dc\3\2"+
		"\2\2\u00e8\u04de\3\2\2\2\u00ea\u04e1\3\2\2\2\u00ec\u04e3\3\2\2\2\u00ee"+
		"\u04e5\3\2\2\2\u00f0\u04e7\3\2\2\2\u00f2\u04ee\3\2\2\2\u00f4\u04f0\3\2"+
		"\2\2\u00f6\u04f2\3\2\2\2\u00f8\u04f4\3\2\2\2\u00fa\u04ff\3\2\2\2\u00fc"+
		"\u0501\3\2\2\2\u00fe\u050b\3\2\2\2\u0100\u0513\3\2\2\2\u0102\u051e\3\2"+
		"\2\2\u0104\u0520\3\2\2\2\u0106\u0527\3\2\2\2\u0108\u010b\5\4\3\2\u0109"+
		"\u010b\5\b\5\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\3\3\2\2\2"+
		"\u010c\u010e\5\60\31\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u011e"+
		"\3\2\2\2\u010f\u0111\5\6\4\2\u0110\u0112\5\66\34\2\u0111\u0110\3\2\2\2"+
		"\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0115\5\20\t\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011f\3\2\2\2\u0116\u011c\5\b\5\2\u0117"+
		"\u0119\5\66\34\2\u0118\u011a\5\20\t\2\u0119\u0118\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u011d\5\20\t\2\u011c\u0117\3\2\2\2"+
		"\u011c\u011b\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u010f\3\2\2\2\u011e\u0116"+
		"\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u0122\5@!\2\u0121\u0120\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0129\3\2\2\2\u0123\u0124\5\60\31\2\u0124\u0126\5"+
		"\b\5\2\u0125\u0127\5@!\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0129\3\2\2\2\u0128\u010d\3\2\2\2\u0128\u0123\3\2\2\2\u0129\5\3\2\2\2"+
		"\u012a\u012b\b\4\1\2\u012b\u0136\5\n\6\2\u012c\u012d\5\b\5\2\u012d\u012f"+
		"\7-\2\2\u012e\u0130\5b\62\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u0134\5\n\6\2\u0132\u0134\5\b\5\2\u0133\u0131\3\2"+
		"\2\2\u0133\u0132\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u012a\3\2\2\2\u0135"+
		"\u012c\3\2\2\2\u0136\u0142\3\2\2\2\u0137\u0138\f\4\2\2\u0138\u013a\7-"+
		"\2\2\u0139\u013b\5b\62\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013e\3\2\2\2\u013c\u013f\5\n\6\2\u013d\u013f\5\b\5\2\u013e\u013c\3\2"+
		"\2\2\u013e\u013d\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u0137\3\2\2\2\u0141"+
		"\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\7\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0145\u0148\7\30\2\2\u0146\u0149\5\b\5\2\u0147\u0149"+
		"\5\4\3\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\7\31\2\2\u014b\t\3\2\2\2\u014c\u0150\7\u0086\2\2\u014d\u014f\5"+
		"> \2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0155\5F"+
		"$\2\u0154\u0156\5:\36\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0158\3\2\2\2\u0157\u0159\5L\'\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015b\3\2\2\2\u015a\u015c\5\64\33\2\u015b\u015a\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\5\30\r\2\u015e\u015d\3"+
		"\2\2\2\u015e\u015f\3\2\2\2\u015f\13\3\2\2\2\u0160\u0161\5\b\5\2\u0161"+
		"\r\3\2\2\2\u0162\u0163\t\2\2\2\u0163\17\3\2\2\2\u0164\u0165\7~\2\2\u0165"+
		"\u0166\5\24\13\2\u0166\21\3\2\2\2\u0167\u0168\7~\2\2\u0168\u0169\5\26"+
		"\f\2\u0169\23\3\2\2\2\u016a\u016d\5\26\f\2\u016b\u016c\t\3\2\2\u016c\u016e"+
		"\5\26\f\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\25\3\2\2\2\u016f"+
		"\u0172\5\u00b0Y\2\u0170\u0172\t\4\2\2\u0171\u016f\3\2\2\2\u0171\u0170"+
		"\3\2\2\2\u0172\27\3\2\2\2\u0173\u0174\7x\2\2\u0174\u0175\5f\64\2\u0175"+
		"\31\3\2\2\2\u0176\u0177\7\61\2\2\u0177\u017c\5\34\17\2\u0178\u0179\7\25"+
		"\2\2\u0179\u017b\5\34\17\2\u017a\u0178\3\2\2\2\u017b\u017e\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\33\3\2\2\2\u017e\u017c\3\2\2"+
		"\2\u017f\u0180\5\u00f0y\2\u0180\u0181\7d\2\2\u0181\u0182\5\36\20\2\u0182"+
		"\35\3\2\2\2\u0183\u0184\7\30\2\2\u0184\u0185\5 \21\2\u0185\u0186\7\31"+
		"\2\2\u0186\37\3\2\2\2\u0187\u0189\5\u00f0y\2\u0188\u0187\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018d\3\2\2\2\u018a\u018b\7\62\2\2\u018b\u018c\7"+
		"\63\2\2\u018c\u018e\5\u00a6T\2\u018d\u018a\3\2\2\2\u018d\u018e\3\2\2\2"+
		"\u018e\u0190\3\2\2\2\u018f\u0191\5\66\34\2\u0190\u018f\3\2\2\2\u0190\u0191"+
		"\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0194\5\"\22\2\u0193\u0192\3\2\2\2"+
		"\u0193\u0194\3\2\2\2\u0194!\3\2\2\2\u0195\u0196\5$\23\2\u0196\u0198\5"+
		"&\24\2\u0197\u0199\5.\30\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"#\3\2\2\2\u019a\u019b\7\60\2\2\u019b%\3\2\2\2\u019c\u019f\5(\25\2\u019d"+
		"\u019f\5*\26\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019f\'\3\2\2\2"+
		"\u01a0\u01a1\7?\2\2\u01a1\u01aa\7<\2\2\u01a2\u01a3\5\u00c0a\2\u01a3\u01a4"+
		"\7<\2\2\u01a4\u01aa\3\2\2\2\u01a5\u01a6\7\36\2\2\u01a6\u01aa\7<\2\2\u01a7"+
		"\u01a8\7A\2\2\u01a8\u01aa\7B\2\2\u01a9\u01a0\3\2\2\2\u01a9\u01a2\3\2\2"+
		"\2\u01a9\u01a5\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa)\3\2\2\2\u01ab\u01ac"+
		"\7g\2\2\u01ac\u01ad\5,\27\2\u01ad\u01ae\7*\2\2\u01ae\u01af\5,\27\2\u01af"+
		"+\3\2\2\2\u01b0\u01b9\5(\25\2\u01b1\u01b2\7?\2\2\u01b2\u01b9\7C\2\2\u01b3"+
		"\u01b4\5\u00c0a\2\u01b4\u01b5\7C\2\2\u01b5\u01b9\3\2\2\2\u01b6\u01b7\7"+
		"\36\2\2\u01b7\u01b9\7C\2\2\u01b8\u01b0\3\2\2\2\u01b8\u01b1\3\2\2\2\u01b8"+
		"\u01b3\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9-\3\2\2\2\u01ba\u01c1\7D\2\2\u01bb"+
		"\u01bc\7A\2\2\u01bc\u01c2\7B\2\2\u01bd\u01c2\7w\2\2\u01be\u01c2\7E\2\2"+
		"\u01bf\u01c0\7\u0080\2\2\u01c0\u01c2\7F\2\2\u01c1\u01bb\3\2\2\2\u01c1"+
		"\u01bd\3\2\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2/\3\2\2\2"+
		"\u01c3\u01c5\7\u008e\2\2\u01c4\u01c6\7G\2\2\u01c5\u01c4\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01cc\5\62\32\2\u01c8\u01c9\7"+
		"\25\2\2\u01c9\u01cb\5\62\32\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce\3\2\2\2"+
		"\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\61\3\2\2\2\u01ce\u01cc"+
		"\3\2\2\2\u01cf\u01d1\5\u00b0Y\2\u01d0\u01d2\5\u00f8}\2\u01d1\u01d0\3\2"+
		"\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\7d\2\2\u01d4"+
		"\u01d5\5\f\7\2\u01d5\63\3\2\2\2\u01d6\u01d7\7w\2\2\u01d7\u01d8\7\63\2"+
		"\2\u01d8\u01d9\5\u00a6T\2\u01d9\65\3\2\2\2\u01da\u01db\7\u0084\2\2\u01db"+
		"\u01dc\7\63\2\2\u01dc\u01dd\5\u00a6T\2\u01dd\67\3\2\2\2\u01de\u01df\t"+
		"\5\2\2\u01df9\3\2\2\2\u01e0\u01e3\7s\2\2\u01e1\u01e4\7m\2\2\u01e2\u01e4"+
		"\5<\37\2\u01e3\u01e1\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e4;\3\2\2\2\u01e5"+
		"\u01ea\5N(\2\u01e6\u01e7\7\25\2\2\u01e7\u01e9\5N(\2\u01e8\u01e6\3\2\2"+
		"\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb="+
		"\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ee\5\16\b\2\u01ee?\3\2\2\2\u01ef"+
		"\u01f0\7S\2\2\u01f0\u01f3\5B\"\2\u01f1\u01f2\7\u008f\2\2\u01f2\u01f4\5"+
		"\u00fe\u0080\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2"+
		"\2\2\u01f5\u01f7\5D#\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01fd"+
		"\3\2\2\2\u01f8\u01f9\7W\2\2\u01f9\u01fa\7y\2\2\u01fa\u01fb\7U\2\2\u01fb"+
		"\u01fd\7T\2\2\u01fc\u01ef\3\2\2\2\u01fc\u01f8\3\2\2\2\u01fdA\3\2\2\2\u01fe"+
		"\u01ff\t\6\2\2\u01ffC\3\2\2\2\u0200\u0201\7X\2\2\u0201\u0204\7Y\2\2\u0202"+
		"\u0204\7\u0090\2\2\u0203\u0200\3\2\2\2\u0203\u0202\3\2\2\2\u0204E\3\2"+
		"\2\2\u0205\u0208\5H%\2\u0206\u0208\7\21\2\2\u0207\u0205\3\2\2\2\u0207"+
		"\u0206\3\2\2\2\u0208\u020d\3\2\2\2\u0209\u020a\7\25\2\2\u020a\u020c\5"+
		"H%\2\u020b\u0209\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d"+
		"\u020e\3\2\2\2\u020eG\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0216\5\u0100"+
		"\u0081\2\u0211\u0213\5f\64\2\u0212\u0214\5J&\2\u0213\u0212\3\2\2\2\u0213"+
		"\u0214\3\2\2\2\u0214\u0216\3\2\2\2\u0215\u0210\3\2\2\2\u0215\u0211\3\2"+
		"\2\2\u0216I\3\2\2\2\u0217\u0219\7d\2\2\u0218\u0217\3\2\2\2\u0218\u0219"+
		"\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u021d\5\u00b0Y\2\u021b\u021d\5\u00ca"+
		"f\2\u021c\u021a\3\2\2\2\u021c\u021b\3\2\2\2\u021dK\3\2\2\2\u021e\u021f"+
		"\7\u008d\2\2\u021f\u0220\5f\64\2\u0220M\3\2\2\2\u0221\u0225\5X-\2\u0222"+
		"\u0224\5R*\2\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2"+
		"\2\u0225\u0226\3\2\2\2\u0226O\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u022c"+
		"\5X-\2\u0229\u022b\5R*\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c"+
		"\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022dQ\3\2\2\2\u022e\u022c\3\2\2\2"+
		"\u022f\u0230\5T+\2\u0230\u0235\5N(\2\u0231\u0232\7\u0083\2\2\u0232\u0236"+
		"\5f\64\2\u0233\u0234\7\u008c\2\2\u0234\u0236\5\u00b4[\2\u0235\u0231\3"+
		"\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0240\3\2\2\2\u0237"+
		"\u0238\5V,\2\u0238\u023d\5N(\2\u0239\u023a\7\u0083\2\2\u023a\u023e\5f"+
		"\64\2\u023b\u023c\7\u008c\2\2\u023c\u023e\5\u00b4[\2\u023d\u0239\3\2\2"+
		"\2\u023d\u023b\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u022f\3\2\2\2\u023f\u0237"+
		"\3\2\2\2\u0240S\3\2\2\2\u0241\u0243\t\7\2\2\u0242\u0241\3\2\2\2\u0242"+
		"\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0245\7\\\2\2\u0245U\3\2\2\2"+
		"\u0246\u0248\t\b\2\2\u0247\u0249\7\u0085\2\2\u0248\u0247\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\7\\\2\2\u024bW\3\2\2\2"+
		"\u024c\u0251\5Z.\2\u024d\u0251\5\\/\2\u024e\u0251\5^\60\2\u024f\u0251"+
		"\5`\61\2\u0250\u024c\3\2\2\2\u0250\u024d\3\2\2\2\u0250\u024e\3\2\2\2\u0250"+
		"\u024f\3\2\2\2\u0251Y\3\2\2\2\u0252\u0254\5\u0102\u0082\2\u0253\u0255"+
		"\5d\63\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255[\3\2\2\2\u0256"+
		"\u0259\7\30\2\2\u0257\u025a\5Z.\2\u0258\u025a\5\\/\2\u0259\u0257\3\2\2"+
		"\2\u0259\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u025c\7\31\2\2\u025c"+
		"]\3\2\2\2\u025d\u025f\5\f\7\2\u025e\u0260\5d\63\2\u025f\u025e\3\2\2\2"+
		"\u025f\u0260\3\2\2\2\u0260\u0262\3\2\2\2\u0261\u0263\5\u00f8}\2\u0262"+
		"\u0261\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u026d\3\2\2\2\u0264\u0265\7_"+
		"\2\2\u0265\u0267\5\f\7\2\u0266\u0268\5d\63\2\u0267\u0266\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u026a\3\2\2\2\u0269\u026b\5\u00f8}\2\u026a\u0269"+
		"\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u025d\3\2\2\2\u026c"+
		"\u0264\3\2\2\2\u026d_\3\2\2\2\u026e\u0271\7\30\2\2\u026f\u0272\5<\37\2"+
		"\u0270\u0272\5`\61\2\u0271\u026f\3\2\2\2\u0271\u0270\3\2\2\2\u0272\u0273"+
		"\3\2\2\2\u0273\u0274\7\31\2\2\u0274a\3\2\2\2\u0275\u0276\t\2\2\2\u0276"+
		"c\3\2\2\2\u0277\u0279\7d\2\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027b\5\u00b0Y\2\u027be\3\2\2\2\u027c\u027d\b\64"+
		"\1\2\u027d\u0283\5h\65\2\u027e\u0280\7z\2\2\u027f\u0281\5\u009cO\2\u0280"+
		"\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\t\t"+
		"\2\2\u0283\u027e\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0288\3\2\2\2\u0285"+
		"\u0286\7,\2\2\u0286\u0288\5f\64\5\u0287\u027c\3\2\2\2\u0287\u0285\3\2"+
		"\2\2\u0288\u0291\3\2\2\2\u0289\u028a\f\4\2\2\u028a\u028b\7*\2\2\u028b"+
		"\u0290\5f\64\5\u028c\u028d\f\3\2\2\u028d\u028e\7+\2\2\u028e\u0290\5f\64"+
		"\4\u028f\u0289\3\2\2\2\u028f\u028c\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292g\3\2\2\2\u0293\u0291\3\2\2\2\u0294"+
		"\u0295\b\65\1\2\u0295\u0296\5l\67\2\u0296\u02a8\3\2\2\2\u0297\u0298\f"+
		"\5\2\2\u0298\u029a\7z\2\2\u0299\u029b\5\u009cO\2\u029a\u0299\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02a7\7\u0081\2\2\u029d\u029e"+
		"\f\4\2\2\u029e\u029f\5j\66\2\u029f\u02a0\5l\67\2\u02a0\u02a7\3\2\2\2\u02a1"+
		"\u02a2\f\3\2\2\u02a2\u02a3\5j\66\2\u02a3\u02a4\t\n\2\2\u02a4\u02a5\5\f"+
		"\7\2\u02a5\u02a7\3\2\2\2\u02a6\u0297\3\2\2\2\u02a6\u029d\3\2\2\2\u02a6"+
		"\u02a1\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2"+
		"\2\2\u02a9i\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02ac\t\13\2\2\u02ack\3"+
		"\2\2\2\u02ad\u02b2\5p9\2\u02ae\u02b0\5\u009cO\2\u02af\u02ae\3\2\2\2\u02af"+
		"\u02b0\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b3\5n8\2\u02b2\u02af\3\2\2"+
		"\2\u02b2\u02b3\3\2\2\2\u02b3m\3\2\2\2\u02b4\u02ba\7y\2\2\u02b5\u02bb\5"+
		"\f\7\2\u02b6\u02b7\7\30\2\2\u02b7\u02b8\5\u009aN\2\u02b8\u02b9\7\31\2"+
		"\2\u02b9\u02bb\3\2\2\2\u02ba\u02b5\3\2\2\2\u02ba\u02b6\3\2\2\2\u02bb\u02c8"+
		"\3\2\2\2\u02bc\u02bd\7g\2\2\u02bd\u02be\5p9\2\u02be\u02bf\7*\2\2\u02bf"+
		"\u02c0\5l\67\2\u02c0\u02c8\3\2\2\2\u02c1\u02c2\7}\2\2\u02c2\u02c5\5r:"+
		"\2\u02c3\u02c4\7o\2\2\u02c4\u02c6\5r:\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6"+
		"\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02b4\3\2\2\2\u02c7\u02bc\3\2\2\2\u02c7"+
		"\u02c1\3\2\2\2\u02c8o\3\2\2\2\u02c9\u02ca\b9\1\2\u02ca\u02cb\5r:\2\u02cb"+
		"\u02d4\3\2\2\2\u02cc\u02cd\f\4\2\2\u02cd\u02ce\t\f\2\2\u02ce\u02d3\5p"+
		"9\5\u02cf\u02d0\f\3\2\2\u02d0\u02d1\t\r\2\2\u02d1\u02d3\5p9\4\u02d2\u02cc"+
		"\3\2\2\2\u02d2\u02cf\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4"+
		"\u02d5\3\2\2\2\u02d5q\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d8\b:\1\2\u02d8"+
		"\u030d\5\u00fa~\2\u02d9\u030d\5\u0084C\2\u02da\u030d\5\u008cG\2\u02db"+
		"\u030d\5\u00c4c\2\u02dc\u030d\7\36\2\2\u02dd\u030d\5t;\2\u02de\u030d\5"+
		"v<\2\u02df\u030d\5x=\2\u02e0\u02e1\t\r\2\2\u02e1\u030d\5r:\t\u02e2\u02e3"+
		"\5\u009eP\2\u02e3\u02e4\5r:\b\u02e4\u030d\3\2\2\2\u02e5\u02e7\7B\2\2\u02e6"+
		"\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e9\7\30"+
		"\2\2\u02e9\u02ea\5\u009aN\2\u02ea\u02eb\7\31\2\2\u02eb\u030d\3\2\2\2\u02ec"+
		"\u02ee\7p\2\2\u02ed\u02ec\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef\3\2"+
		"\2\2\u02ef\u030d\5\f\7\2\u02f0\u02f1\7\32\2\2\u02f1\u02f2\5\u00b0Y\2\u02f2"+
		"\u02f3\5f\64\2\u02f3\u02f4\7\33\2\2\u02f4\u030d\3\2\2\2\u02f5\u02f6\7"+
		"i\2\2\u02f6\u02f7\7\30\2\2\u02f7\u02f8\5f\64\2\u02f8\u02f9\7d\2\2\u02f9"+
		"\u02fa\5\u0098M\2\u02fa\u02fb\7\31\2\2\u02fb\u030d\3\2\2\2\u02fc\u02fe"+
		"\7h\2\2\u02fd\u02ff\5f\64\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff"+
		"\u0303\3\2\2\2\u0300\u0301\5\u0092J\2\u0301\u0302\5\u0094K\2\u0302\u0304"+
		"\3\2\2\2\u0303\u0300\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0303\3\2\2\2\u0305"+
		"\u0306\3\2\2\2\u0306\u0308\3\2\2\2\u0307\u0309\5\u0096L\2\u0308\u0307"+
		"\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030b\7n\2\2\u030b"+
		"\u030d\3\2\2\2\u030c\u02d7\3\2\2\2\u030c\u02d9\3\2\2\2\u030c\u02da\3\2"+
		"\2\2\u030c\u02db\3\2\2\2\u030c\u02dc\3\2\2\2\u030c\u02dd\3\2\2\2\u030c"+
		"\u02de\3\2\2\2\u030c\u02df\3\2\2\2\u030c\u02e0\3\2\2\2\u030c\u02e2\3\2"+
		"\2\2\u030c\u02e6\3\2\2\2\u030c\u02ed\3\2\2\2\u030c\u02f0\3\2\2\2\u030c"+
		"\u02f5\3\2\2\2\u030c\u02fc\3\2\2\2\u030d\u0313\3\2\2\2\u030e\u030f\f\n"+
		"\2\2\u030f\u0310\7\4\2\2\u0310\u0312\5r:\13\u0311\u030e\3\2\2\2\u0312"+
		"\u0315\3\2\2\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314s\3\2\2\2"+
		"\u0315\u0313\3\2\2\2\u0316\u0317\7H\2\2\u0317\u0319\7\30\2\2\u0318\u031a"+
		"\7J\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2\2\2\u031b"+
		"\u031c\5~@\2\u031c\u031e\7\31\2\2\u031d\u031f\5z>\2\u031e\u031d\3\2\2"+
		"\2\u031e\u031f\3\2\2\2\u031f\u0377\3\2\2\2\u0320\u0321\7I\2\2\u0321\u0323"+
		"\7\30\2\2\u0322\u0324\7.\2\2\u0323\u0322\3\2\2\2\u0323\u0324\3\2\2\2\u0324"+
		"\u0325\3\2\2\2\u0325\u0326\7\21\2\2\u0326\u0328\7\31\2\2\u0327\u0329\5"+
		"z>\2\u0328\u0327\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u0377\3\2\2\2\u032a"+
		"\u032b\7I\2\2\u032b\u0333\7\30\2\2\u032c\u032e\7.\2\2\u032d\u032c\3\2"+
		"\2\2\u032d\u032e\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0334\7\21\2\2\u0330"+
		"\u0334\5~@\2\u0331\u0332\7J\2\2\u0332\u0334\5\u009aN\2\u0333\u032d\3\2"+
		"\2\2\u0333\u0330\3\2\2\2\u0333\u0331\3\2\2\2\u0334\u0335\3\2\2\2\u0335"+
		"\u0337\7\31\2\2\u0336\u0338\5z>\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2"+
		"\2\2\u0338\u0377\3\2\2\2\u0339\u033a\7M\2\2\u033a\u033c\7\30\2\2\u033b"+
		"\u033d\7J\2\2\u033c\u033b\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\3\2"+
		"\2\2\u033e\u033f\5~@\2\u033f\u0341\7\31\2\2\u0340\u0342\5z>\2\u0341\u0340"+
		"\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0377\3\2\2\2\u0343\u0344\7L\2\2\u0344"+
		"\u0346\7\30\2\2\u0345\u0347\7J\2\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2"+
		"\2\2\u0347\u0348\3\2\2\2\u0348\u0349\5~@\2\u0349\u034b\7\31\2\2\u034a"+
		"\u034c\5z>\2\u034b\u034a\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u0377\3\2\2"+
		"\2\u034d\u034e\7N\2\2\u034e\u034f\7\30\2\2\u034f\u0350\5~@\2\u0350\u0352"+
		"\7\31\2\2\u0351\u0353\5z>\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0377\3\2\2\2\u0354\u0355\7P\2\2\u0355\u0356\7\30\2\2\u0356\u0357\5~"+
		"@\2\u0357\u0359\7\31\2\2\u0358\u035a\5z>\2\u0359\u0358\3\2\2\2\u0359\u035a"+
		"\3\2\2\2\u035a\u0377\3\2\2\2\u035b\u035c\7K\2\2\u035c\u035e\7\30\2\2\u035d"+
		"\u035f\7J\2\2\u035e\u035d\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0360\3\2"+
		"\2\2\u0360\u0361\5~@\2\u0361\u0363\7\31\2\2\u0362\u0364\5z>\2\u0363\u0362"+
		"\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0377\3\2\2\2\u0365\u0366\7Q\2\2\u0366"+
		"\u0368\7\30\2\2\u0367\u0369\7J\2\2\u0368\u0367\3\2\2\2\u0368\u0369\3\2"+
		"\2\2\u0369\u036a\3\2\2\2\u036a\u036c\5\u009aN\2\u036b\u036d\5\66\34\2"+
		"\u036c\u036b\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u0370\3\2\2\2\u036e\u036f"+
		"\7R\2\2\u036f\u0371\5\u00ccg\2\u0370\u036e\3\2\2\2\u0370\u0371\3\2\2\2"+
		"\u0371\u0372\3\2\2\2\u0372\u0374\7\31\2\2\u0373\u0375\5z>\2\u0374\u0373"+
		"\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377\3\2\2\2\u0376\u0316\3\2\2\2\u0376"+
		"\u0320\3\2\2\2\u0376\u032a\3\2\2\2\u0376\u0339\3\2\2\2\u0376\u0343\3\2"+
		"\2\2\u0376\u034d\3\2\2\2\u0376\u0354\3\2\2\2\u0376\u035b\3\2\2\2\u0376"+
		"\u0365\3\2\2\2\u0377u\3\2\2\2\u0378\u0379\7\u0091\2\2\u0379\u037a\7\30"+
		"\2\2\u037a\u037b\5\u009aN\2\u037b\u037c\7\31\2\2\u037cw\3\2\2\2\u037d"+
		"\u037e\t\16\2\2\u037e\u037f\5\u00e8u\2\u037f\u0380\5z>\2\u0380\u0393\3"+
		"\2\2\2\u0381\u0382\79\2\2\u0382\u0383\5\u00a4S\2\u0383\u0384\5z>\2\u0384"+
		"\u0393\3\2\2\2\u0385\u0386\t\17\2\2\u0386\u0387\7\30\2\2\u0387\u0389\5"+
		"f\64\2\u0388\u038a\5|?\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2\u038a"+
		"\u038b\3\2\2\2\u038b\u038c\7\31\2\2\u038c\u038d\5z>\2\u038d\u0393\3\2"+
		"\2\2\u038e\u038f\t\20\2\2\u038f\u0390\5\u00a2R\2\u0390\u0391\5z>\2\u0391"+
		"\u0393\3\2\2\2\u0392\u037d\3\2\2\2\u0392\u0381\3\2\2\2\u0392\u0385\3\2"+
		"\2\2\u0392\u038e\3\2\2\2\u0393y\3\2\2\2\u0394\u0397\7;\2\2\u0395\u0398"+
		"\5\u00f0y\2\u0396\u0398\5\36\20\2\u0397\u0395\3\2\2\2\u0397\u0396\3\2"+
		"\2\2\u0398{\3\2\2\2\u0399\u039c\7\25\2\2\u039a\u039d\5\u00c0a\2\u039b"+
		"\u039d\7\36\2\2\u039c\u039a\3\2\2\2\u039c\u039b\3\2\2\2\u039d\u03a0\3"+
		"\2\2\2\u039e\u039f\7\25\2\2\u039f\u03a1\5f\64\2\u03a0\u039e\3\2\2\2\u03a0"+
		"\u03a1\3\2\2\2\u03a1}\3\2\2\2\u03a2\u03a4\7.\2\2\u03a3\u03a2\3\2\2\2\u03a3"+
		"\u03a4\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\5f\64\2\u03a6\177\3\2\2"+
		"\2\u03a7\u03ad\5\u0082B\2\u03a8\u03a9\7\30\2\2\u03a9\u03aa\5\u0082B\2"+
		"\u03aa\u03ab\7\31\2\2\u03ab\u03ad\3\2\2\2\u03ac\u03a7\3\2\2\2\u03ac\u03a8"+
		"\3\2\2\2\u03ad\u0081\3\2\2\2\u03ae\u03b3\5\u00b8]\2\u03af\u03b0\7\25\2"+
		"\2\u03b0\u03b2\5\u00b8]\2\u03b1\u03af\3\2\2\2\u03b2\u03b5\3\2\2\2\u03b3"+
		"\u03b1\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u0083\3\2\2\2\u03b5\u03b3\3\2"+
		"\2\2\u03b6\u03b8\7/\2\2\u03b7\u03b9\5\u00e8u\2\u03b8\u03b7\3\2\2\2\u03b8"+
		"\u03b9\3\2\2\2\u03b9\u03db\3\2\2\2\u03ba\u03bb\7@\2\2\u03bb\u03bc\7\30"+
		"\2\2\u03bc\u03bf\5f\64\2\u03bd\u03be\7\25\2\2\u03be\u03c0\5f\64\2\u03bf"+
		"\u03bd\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c1\u03c2\3\2"+
		"\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\7\31\2\2\u03c4\u03db\3\2\2\2\u03c5"+
		"\u03c6\7]\2\2\u03c6\u03c7\7\30\2\2\u03c7\u03c8\5f\64\2\u03c8\u03c9\7\25"+
		"\2\2\u03c9\u03ca\5f\64\2\u03ca\u03cb\7\31\2\2\u03cb\u03db\3\2\2\2\u03cc"+
		"\u03cd\7^\2\2\u03cd\u03ce\7\30\2\2\u03ce\u03cf\5f\64\2\u03cf\u03d0\7\25"+
		"\2\2\u03d0\u03d1\5f\64\2\u03d1\u03d2\7\31\2\2\u03d2\u03db\3\2\2\2\u03d3"+
		"\u03d5\7\177\2\2\u03d4\u03d6\5\u0086D\2\u03d5\u03d4\3\2\2\2\u03d5\u03d6"+
		"\3\2\2\2\u03d6\u03db\3\2\2\2\u03d7\u03db\5\u008aF\2\u03d8\u03d9\7&\2\2"+
		"\u03d9\u03db\5\u00a2R\2\u03da\u03b6\3\2\2\2\u03da\u03ba\3\2\2\2\u03da"+
		"\u03c5\3\2\2\2\u03da\u03cc\3\2\2\2\u03da\u03d3\3\2\2\2\u03da\u03d7\3\2"+
		"\2\2\u03da\u03d8\3\2\2\2\u03db\u0085\3\2\2\2\u03dc\u03de\7\30\2\2\u03dd"+
		"\u03df\5\u0088E\2\u03de\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0"+
		"\3\2\2\2\u03e0\u03e1\7\31\2\2\u03e1\u0087\3\2\2\2\u03e2\u03e3\7!\2\2\u03e3"+
		"\u0089\3\2\2\2\u03e4\u03e5\7)\2\2\u03e5\u03e6\7\30\2\2\u03e6\u03f3\5f"+
		"\64\2\u03e7\u03e8\7\25\2\2\u03e8\u03eb\5f\64\2\u03e9\u03ea\7\25\2\2\u03ea"+
		"\u03ec\5f\64\2\u03eb\u03e9\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03f4\3\2"+
		"\2\2\u03ed\u03ee\7s\2\2\u03ee\u03f1\5f\64\2\u03ef\u03f0\7S\2\2\u03f0\u03f2"+
		"\5f\64\2\u03f1\u03ef\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f4\3\2\2\2\u03f3"+
		"\u03e7\3\2\2\2\u03f3\u03ed\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\7\31"+
		"\2\2\u03f6\u008b\3\2\2\2\u03f7\u03f8\5\u00aeX\2\u03f8\u03fa\7\30\2\2\u03f9"+
		"\u03fb\5\u008eH\2\u03fa\u03f9\3\2\2\2\u03fa\u03fb\3\2\2\2\u03fb\u03fc"+
		"\3\2\2\2\u03fc\u03fd\7\31\2\2\u03fd\u0406\3\2\2\2\u03fe\u03ff\5\u00b6"+
		"\\\2\u03ff\u0401\7\30\2\2\u0400\u0402\5\u009aN\2\u0401\u0400\3\2\2\2\u0401"+
		"\u0402\3\2\2\2\u0402\u0403\3\2\2\2\u0403\u0404\7\31\2\2\u0404\u0406\3"+
		"\2\2\2\u0405\u03f7\3\2\2\2\u0405\u03fe\3\2\2\2\u0406\u008d\3\2\2\2\u0407"+
		"\u040c\5\u0090I\2\u0408\u0409\7\25\2\2\u0409\u040b\5\u0090I\2\u040a\u0408"+
		"\3\2\2\2\u040b\u040e\3\2\2\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"\u008f\3\2\2\2\u040e\u040c\3\2\2\2\u040f\u0411\5f\64\2\u0410\u0412\5J"+
		"&\2\u0411\u0410\3\2\2\2\u0411\u0412\3\2\2\2\u0412\u0091\3\2\2\2\u0413"+
		"\u0414\7b\2\2\u0414\u0415\5f\64\2\u0415\u0093\3\2\2\2\u0416\u0417\7a\2"+
		"\2\u0417\u0418\5f\64\2\u0418\u0095\3\2\2\2\u0419\u041a\7`\2\2\u041a\u041b"+
		"\5f\64\2\u041b\u0097\3\2\2\2\u041c\u0422\7k\2\2\u041d\u041f\7\u0088\2"+
		"\2\u041e\u0420\5\u0106\u0084\2\u041f\u041e\3\2\2\2\u041f\u0420\3\2\2\2"+
		"\u0420\u0422\3\2\2\2\u0421\u041c\3\2\2\2\u0421\u041d\3\2\2\2\u0422\u0099"+
		"\3\2\2\2\u0423\u0428\5f\64\2\u0424\u0425\7\25\2\2\u0425\u0427\5f\64\2"+
		"\u0426\u0424\3\2\2\2\u0427\u042a\3\2\2\2\u0428\u0426\3\2\2\2\u0428\u0429"+
		"\3\2\2\2\u0429\u009b\3\2\2\2\u042a\u0428\3\2\2\2\u042b\u042c\t\21\2\2"+
		"\u042c\u009d\3\2\2\2\u042d\u042e\7\3\2\2\u042e\u009f\3\2\2\2\u042f\u0430"+
		"\7\30\2\2\u0430\u0431\5\u009aN\2\u0431\u0432\7\31\2\2\u0432\u00a1\3\2"+
		"\2\2\u0433\u0434\7\30\2\2\u0434\u0435\5f\64\2\u0435\u0436\7\31\2\2\u0436"+
		"\u00a3\3\2\2\2\u0437\u0438\7\30\2\2\u0438\u0439\5r:\2\u0439\u043a\7\31"+
		"\2\2\u043a\u00a5\3\2\2\2\u043b\u0440\5\u00a8U\2\u043c\u043d\7\25\2\2\u043d"+
		"\u043f\5\u00a8U\2\u043e\u043c\3\2\2\2\u043f\u0442\3\2\2\2\u0440\u043e"+
		"\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u00a7\3\2\2\2\u0442\u0440\3\2\2\2\u0443"+
		"\u0445\5f\64\2\u0444\u0446\58\35\2\u0445\u0444\3\2\2\2\u0445\u0446\3\2"+
		"\2\2\u0446\u00a9\3\2\2\2\u0447\u044c\5\u00acW\2\u0448\u0449\7\25\2\2\u0449"+
		"\u044b\5\u00acW\2\u044a\u0448\3\2\2\2\u044b\u044e\3\2\2\2\u044c\u044a"+
		"\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u00ab\3\2\2\2\u044e\u044c\3\2\2\2\u044f"+
		"\u0450\5f\64\2\u0450\u00ad\3\2\2\2\u0451\u0455\7\u0094\2\2\u0452\u0454"+
		"\7$\2\2\u0453\u0452\3\2\2\2\u0454\u0457\3\2\2\2\u0455\u0453\3\2\2\2\u0455"+
		"\u0456\3\2\2\2\u0456\u045a\3\2\2\2\u0457\u0455\3\2\2\2\u0458\u045a\7\u0096"+
		"\2\2\u0459\u0451\3\2\2\2\u0459\u0458\3\2\2\2\u045a\u00af\3\2\2\2\u045b"+
		"\u045e\5\u00aeX\2\u045c\u045e\5\u00ecw\2\u045d\u045b\3\2\2\2\u045d\u045c"+
		"\3\2\2\2\u045e\u00b1\3\2\2\2\u045f\u0464\5\u00b0Y\2\u0460\u0461\7\25\2"+
		"\2\u0461\u0463\5\u00b0Y\2\u0462\u0460\3\2\2\2\u0463\u0466\3\2\2\2\u0464"+
		"\u0462\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u00b3\3\2\2\2\u0466\u0464\3\2"+
		"\2\2\u0467\u0468\7\30\2\2\u0468\u0469\5\u00b2Z\2\u0469\u046a\7\31\2\2"+
		"\u046a\u00b5\3\2\2\2\u046b\u046d\5\u00b0Y\2\u046c\u046e\5\u00ba^\2\u046d"+
		"\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u00b7\3\2\2\2\u046f\u0474\5\u00b0"+
		"Y\2\u0470\u0472\5\u00ba^\2\u0471\u0473\5\u00ba^\2\u0472\u0471\3\2\2\2"+
		"\u0472\u0473\3\2\2\2\u0473\u0475\3\2\2\2\u0474\u0470\3\2\2\2\u0474\u0475"+
		"\3\2\2\2\u0475\u00b9\3\2\2\2\u0476\u0477\7\24\2\2\u0477\u0478\5\u00b0"+
		"Y\2\u0478\u00bb\3\2\2\2\u0479\u047a\t\22\2\2\u047a\u00bd\3\2\2\2\u047b"+
		"\u047c\t\23\2\2\u047c\u00bf\3\2\2\2\u047d\u047e\t\24\2\2\u047e\u00c1\3"+
		"\2\2\2\u047f\u0480\t\23\2\2\u0480\u00c3\3\2\2\2\u0481\u0488\5\u00d0i\2"+
		"\u0482\u0488\5\u00d6l\2\u0483\u0488\5\u00dco\2\u0484\u0488\5\u00dan\2"+
		"\u0485\u0488\5\u00d8m\2\u0486\u0488\t\25\2\2\u0487\u0481\3\2\2\2\u0487"+
		"\u0482\3\2\2\2\u0487\u0483\3\2\2\2\u0487\u0484\3\2\2\2\u0487\u0485\3\2"+
		"\2\2\u0487\u0486\3\2\2\2\u0488\u00c5\3\2\2\2\u0489\u048f\5\u00c4c\2\u048a"+
		"\u048b\7\17\2\2\u048b\u048f\5\u00bc_\2\u048c\u048d\7\20\2\2\u048d\u048f"+
		"\5\u00bc_\2\u048e\u0489\3\2\2\2\u048e\u048a\3\2\2\2\u048e\u048c\3\2\2"+
		"\2\u048f\u00c7\3\2\2\2\u0490\u0491\7\30\2\2\u0491\u0496\5\u00ccg\2\u0492"+
		"\u0493\7\25\2\2\u0493\u0495\5\u00ccg\2\u0494\u0492\3\2\2\2\u0495\u0498"+
		"\3\2\2\2\u0496\u0494\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499\3\2\2\2\u0498"+
		"\u0496\3\2\2\2\u0499\u049a\7\31\2\2\u049a\u00c9\3\2\2\2\u049b\u049e\7"+
		"\u0097\2\2\u049c\u049e\7\u0096\2\2\u049d\u049b\3\2\2\2\u049d\u049c\3\2"+
		"\2\2\u049e\u00cb\3\2\2\2\u049f\u04a3\5\u00caf\2\u04a0\u04a3\7\37\2\2\u04a1"+
		"\u04a3\7 \2\2\u04a2\u049f\3\2\2\2\u04a2\u04a0\3\2\2\2\u04a2\u04a1\3\2"+
		"\2\2\u04a3\u00cd\3\2\2\2\u04a4\u04a7\5\u00caf\2\u04a5\u04a7\7\37\2\2\u04a6"+
		"\u04a4\3\2\2\2\u04a6\u04a5\3\2\2\2\u04a7\u00cf\3\2\2\2\u04a8\u04ab\5\u00ca"+
		"f\2\u04a9\u04ab\7\u0095\2\2\u04aa\u04a8\3\2\2\2\u04aa\u04a9\3\2\2\2\u04ab"+
		"\u04af\3\2\2\2\u04ac\u04ae\5\u00caf\2\u04ad\u04ac\3\2\2\2\u04ae\u04b1"+
		"\3\2\2\2\u04af\u04ad\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u00d1\3\2\2\2\u04b1"+
		"\u04af\3\2\2\2\u04b2\u04b3\5\u00caf\2\u04b3\u00d3\3\2\2\2\u04b4\u04b9"+
		"\5\u00caf\2\u04b5\u04b6\7\25\2\2\u04b6\u04b8\5\u00caf\2\u04b7\u04b5\3"+
		"\2\2\2\u04b8\u04bb\3\2\2\2\u04b9\u04b7\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba"+
		"\u00d5\3\2\2\2\u04bb\u04b9\3\2\2\2\u04bc\u04bd\t\24\2\2\u04bd\u00d7\3"+
		"\2\2\2\u04be\u04bf\t\26\2\2\u04bf\u00d9\3\2\2\2\u04c0\u04c1\t\27\2\2\u04c1"+
		"\u00db\3\2\2\2\u04c2\u04c3\7k\2\2\u04c3\u04c9\7\u0097\2\2\u04c4\u04c5"+
		"\7\u0088\2\2\u04c5\u04c9\7\u0097\2\2\u04c6\u04c7\7\u0087\2\2\u04c7\u04c9"+
		"\7\u0097\2\2\u04c8\u04c2\3\2\2\2\u04c8\u04c4\3\2\2\2\u04c8\u04c6\3\2\2"+
		"\2\u04c9\u00dd\3\2\2\2\u04ca\u04cd\5\u0104\u0083\2\u04cb\u04cd\5\u00e2"+
		"r\2\u04cc\u04ca\3\2\2\2\u04cc\u04cb\3\2\2\2\u04cd\u00df\3\2\2\2\u04ce"+
		"\u04cf\5\u00e2r\2\u04cf\u00e1\3\2\2\2\u04d0\u04d1\7\30\2\2\u04d1\u04d2"+
		"\7!\2\2\u04d2\u04d3\7\25\2\2\u04d3\u04d4\7!\2\2\u04d4\u04d5\7\31\2\2\u04d5"+
		"\u00e3\3\2\2\2\u04d6\u04d9\7\u0097\2\2\u04d7\u04d9\5\u00b0Y\2\u04d8\u04d6"+
		"\3\2\2\2\u04d8\u04d7\3\2\2\2\u04d9\u00e5\3\2\2\2\u04da\u04dd\5\u00c2b"+
		"\2\u04db\u04dd\5\u00aeX\2\u04dc\u04da\3\2\2\2\u04dc\u04db\3\2\2\2\u04dd"+
		"\u00e7\3\2\2\2\u04de\u04df\7\30\2\2\u04df\u04e0\7\31\2\2\u04e0\u00e9\3"+
		"\2\2\2\u04e1\u04e2\t\30\2\2\u04e2\u00eb\3\2\2\2\u04e3\u04e4\5\u00eex\2"+
		"\u04e4\u00ed\3\2\2\2\u04e5\u04e6\t\31\2\2\u04e6\u00ef\3\2\2\2\u04e7\u04e8"+
		"\5\u00b0Y\2\u04e8\u00f1\3\2\2\2\u04e9\u04ef\5\u00ba^\2\u04ea\u04ec\5\u00b6"+
		"\\\2\u04eb\u04ed\5\u00ba^\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed"+
		"\u04ef\3\2\2\2\u04ee\u04e9\3\2\2\2\u04ee\u04ea\3\2\2\2\u04ef\u00f3\3\2"+
		"\2\2\u04f0\u04f1\5\u00b0Y\2\u04f1\u00f5\3\2\2\2\u04f2\u04f3\5\u00b0Y\2"+
		"\u04f3\u00f7\3\2\2\2\u04f4\u04f5\7\30\2\2\u04f5\u04fa\5\u00f6|\2\u04f6"+
		"\u04f7\7\25\2\2\u04f7\u04f9\5\u00f6|\2\u04f8\u04f6\3\2\2\2\u04f9\u04fc"+
		"\3\2\2\2\u04fa\u04f8\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fd\3\2\2\2\u04fc"+
		"\u04fa\3\2\2\2\u04fd\u04fe\7\31\2\2\u04fe\u00f9\3\2\2\2\u04ff\u0500\5"+
		"\u00f2z\2\u0500\u00fb\3\2\2\2\u0501\u0509\5\u00b0Y\2\u0502\u0503\7\24"+
		"\2\2\u0503\u050a\7\21\2\2\u0504\u0507\5\u00ba^\2\u0505\u0506\7\24\2\2"+
		"\u0506\u0508\7\21\2\2\u0507\u0505\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u050a"+
		"\3\2\2\2\u0509\u0502\3\2\2\2\u0509\u0504\3\2\2\2\u0509\u050a\3\2\2\2\u050a"+
		"\u00fd\3\2\2\2\u050b\u0510\5\u00fc\177\2\u050c\u050d\7\25\2\2\u050d\u050f"+
		"\5\u00fc\177\2\u050e\u050c\3\2\2\2\u050f\u0512\3\2\2\2\u0510\u050e\3\2"+
		"\2\2\u0510\u0511\3\2\2\2\u0511\u00ff\3\2\2\2\u0512\u0510\3\2\2\2\u0513"+
		"\u0514\5\u00b0Y\2\u0514\u0518\7\24\2\2\u0515\u0516\5\u00b0Y\2\u0516\u0517"+
		"\7\24\2\2\u0517\u0519\3\2\2\2\u0518\u0515\3\2\2\2\u0518\u0519\3\2\2\2"+
		"\u0519\u051a\3\2\2\2\u051a\u051b\7\21\2\2\u051b\u0101\3\2\2\2\u051c\u051f"+
		"\5\u00b6\\\2\u051d\u051f\5\u00ba^\2\u051e\u051c\3\2\2\2\u051e\u051d\3"+
		"\2\2\2\u051f\u0103\3\2\2\2\u0520\u0523\7\30\2\2\u0521\u0524\5\u00c2b\2"+
		"\u0522\u0524\7\"\2\2\u0523\u0521\3\2\2\2\u0523\u0522\3\2\2\2\u0524\u0525"+
		"\3\2\2\2\u0525\u0526\7\31\2\2\u0526\u0105\3\2\2\2\u0527\u0528\7\30\2\2"+
		"\u0528\u0529\7!\2\2\u0529\u052a\7\31\2\2\u052a\u0107\3\2\2\2\u00a6\u010a"+
		"\u010d\u0111\u0114\u0119\u011c\u011e\u0121\u0126\u0128\u012f\u0133\u0135"+
		"\u013a\u013e\u0142\u0148\u0150\u0155\u0158\u015b\u015e\u016d\u0171\u017c"+
		"\u0188\u018d\u0190\u0193\u0198\u019e\u01a9\u01b8\u01c1\u01c5\u01cc\u01d1"+
		"\u01e3\u01ea\u01f3\u01f6\u01fc\u0203\u0207\u020d\u0213\u0215\u0218\u021c"+
		"\u0225\u022c\u0235\u023d\u023f\u0242\u0248\u0250\u0254\u0259\u025f\u0262"+
		"\u0267\u026a\u026c\u0271\u0278\u0280\u0283\u0287\u028f\u0291\u029a\u02a6"+
		"\u02a8\u02af\u02b2\u02ba\u02c5\u02c7\u02d2\u02d4\u02e6\u02ed\u02fe\u0305"+
		"\u0308\u030c\u0313\u0319\u031e\u0323\u0328\u032d\u0333\u0337\u033c\u0341"+
		"\u0346\u034b\u0352\u0359\u035e\u0363\u0368\u036c\u0370\u0374\u0376\u0389"+
		"\u0392\u0397\u039c\u03a0\u03a3\u03ac\u03b3\u03b8\u03c1\u03d5\u03da\u03de"+
		"\u03eb\u03f1\u03f3\u03fa\u0401\u0405\u040c\u0411\u041f\u0421\u0428\u0440"+
		"\u0445\u044c\u0455\u0459\u045d\u0464\u046d\u0472\u0474\u0487\u048e\u0496"+
		"\u049d\u04a2\u04a6\u04aa\u04af\u04b9\u04c8\u04cc\u04d8\u04dc\u04ec\u04ee"+
		"\u04fa\u0507\u0509\u0510\u0518\u051e\u0523";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}