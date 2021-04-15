// Generated from HDBTable.g4 by ANTLR 4.8
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
public class HDBTableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, SEPARATOR=29, STRING=30, CODE=31, 
		WS=32;
	public static final int
		RULE_keyvaluepairs = 0, RULE_kvtypes = 1, RULE_schemaname = 2, RULE_synonym = 3, 
		RULE_description = 4, RULE_temporary = 5, RULE_logging = 6, RULE_columnar = 7, 
		RULE_columns = 8, RULE_indexes = 9, RULE_primarykeys = 10, RULE_primarykeyindextype = 11, 
		RULE_columnarray = 12, RULE_columndef = 13, RULE_indexarray = 14, RULE_indexdef = 15, 
		RULE_columnname = 16, RULE_columnsqltype = 17, RULE_columnnullable = 18, 
		RULE_columnlength = 19, RULE_columnprecision = 20, RULE_columnscale = 21, 
		RULE_columndefaultvalue = 22, RULE_columncomment = 23, RULE_columnunique = 24, 
		RULE_indexname = 25, RULE_indexunique = 26, RULE_indexorder = 27, RULE_indexType = 28, 
		RULE_indexcolumns = 29, RULE_stringarray = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"keyvaluepairs", "kvtypes", "schemaname", "synonym", "description", "temporary", 
			"logging", "columnar", "columns", "indexes", "primarykeys", "primarykeyindextype", 
			"columnarray", "columndef", "indexarray", "indexdef", "columnname", "columnsqltype", 
			"columnnullable", "columnlength", "columnprecision", "columnscale", "columndefaultvalue", 
			"columncomment", "columnunique", "indexname", "indexunique", "indexorder", 
			"indexType", "indexcolumns", "stringarray"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'table.schemaName'", "'='", "'table.public'", "'table.description'", 
			"'table.temporary'", "'table.loggingType'", "'table.tableType'", "'table.columns'", 
			"'table.indexes'", "'table.primaryKey.pkcolumns'", "'table.primaryKey.indexType'", 
			"'['", "','", "']'", "'{'", "'}'", "'name'", "'sqlType'", "'nullable'", 
			"'length'", "'precision'", "'scale'", "'defaultValue'", "'comment'", 
			"'unique'", "'order'", "'indexType'", "'indexColumns'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "SEPARATOR", "STRING", "CODE", "WS"
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
	public String getGrammarFileName() { return "HDBTable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HDBTableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class KeyvaluepairsContext extends ParserRuleContext {
		public List<KvtypesContext> kvtypes() {
			return getRuleContexts(KvtypesContext.class);
		}
		public KvtypesContext kvtypes(int i) {
			return getRuleContext(KvtypesContext.class,i);
		}
		public KeyvaluepairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvaluepairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterKeyvaluepairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitKeyvaluepairs(this);
		}
	}

	public final KeyvaluepairsContext keyvaluepairs() throws RecognitionException {
		KeyvaluepairsContext _localctx = new KeyvaluepairsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_keyvaluepairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				{
				setState(62);
				kvtypes();
				}
				}
				setState(67);
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

	public static class KvtypesContext extends ParserRuleContext {
		public SchemanameContext schemaname() {
			return getRuleContext(SchemanameContext.class,0);
		}
		public TemporaryContext temporary() {
			return getRuleContext(TemporaryContext.class,0);
		}
		public SynonymContext synonym() {
			return getRuleContext(SynonymContext.class,0);
		}
		public LoggingContext logging() {
			return getRuleContext(LoggingContext.class,0);
		}
		public ColumnarContext columnar() {
			return getRuleContext(ColumnarContext.class,0);
		}
		public ColumnsContext columns() {
			return getRuleContext(ColumnsContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public PrimarykeysContext primarykeys() {
			return getRuleContext(PrimarykeysContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public KvtypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvtypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterKvtypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitKvtypes(this);
		}
	}

	public final KvtypesContext kvtypes() throws RecognitionException {
		KvtypesContext _localctx = new KvtypesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_kvtypes);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				schemaname();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				temporary();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				synonym();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				logging();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				columnar();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				columns();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
				indexes();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 8);
				{
				setState(75);
				primarykeys();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 9);
				{
				setState(76);
				description();
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

	public static class SchemanameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public SchemanameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterSchemaname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitSchemaname(this);
		}
	}

	public final SchemanameContext schemaname() throws RecognitionException {
		SchemanameContext _localctx = new SchemanameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_schemaname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__0);
			setState(80);
			match(T__1);
			setState(81);
			match(STRING);
			setState(82);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynonymContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public SynonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synonym; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterSynonym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitSynonym(this);
		}
	}

	public final SynonymContext synonym() throws RecognitionException {
		SynonymContext _localctx = new SynonymContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_synonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__2);
			setState(85);
			match(T__1);
			setState(86);
			match(CODE);
			setState(87);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__3);
			setState(90);
			match(T__1);
			setState(91);
			match(STRING);
			setState(92);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporaryContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public TemporaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterTemporary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitTemporary(this);
		}
	}

	public final TemporaryContext temporary() throws RecognitionException {
		TemporaryContext _localctx = new TemporaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_temporary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__4);
			setState(95);
			match(T__1);
			setState(96);
			match(CODE);
			setState(97);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoggingContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public LoggingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logging; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterLogging(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitLogging(this);
		}
	}

	public final LoggingContext logging() throws RecognitionException {
		LoggingContext _localctx = new LoggingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_logging);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__5);
			setState(100);
			match(T__1);
			setState(101);
			match(CODE);
			setState(102);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnarContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnar(this);
		}
	}

	public final ColumnarContext columnar() throws RecognitionException {
		ColumnarContext _localctx = new ColumnarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_columnar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__6);
			setState(105);
			match(T__1);
			setState(106);
			match(CODE);
			setState(107);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnsContext extends ParserRuleContext {
		public ColumnarrayContext columnarray() {
			return getRuleContext(ColumnarrayContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumns(this);
		}
	}

	public final ColumnsContext columns() throws RecognitionException {
		ColumnsContext _localctx = new ColumnsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__7);
			setState(110);
			match(T__1);
			setState(111);
			columnarray();
			setState(112);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexesContext extends ParserRuleContext {
		public IndexarrayContext indexarray() {
			return getRuleContext(IndexarrayContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexes(this);
		}
	}

	public final IndexesContext indexes() throws RecognitionException {
		IndexesContext _localctx = new IndexesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_indexes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__8);
			setState(115);
			match(T__1);
			setState(116);
			indexarray();
			setState(117);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimarykeysContext extends ParserRuleContext {
		public StringarrayContext stringarray() {
			return getRuleContext(StringarrayContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public PrimarykeysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primarykeys; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterPrimarykeys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitPrimarykeys(this);
		}
	}

	public final PrimarykeysContext primarykeys() throws RecognitionException {
		PrimarykeysContext _localctx = new PrimarykeysContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primarykeys);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__9);
			setState(120);
			match(T__1);
			setState(121);
			stringarray();
			setState(122);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimarykeyindextypeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public PrimarykeyindextypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primarykeyindextype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterPrimarykeyindextype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitPrimarykeyindextype(this);
		}
	}

	public final PrimarykeyindextypeContext primarykeyindextype() throws RecognitionException {
		PrimarykeyindextypeContext _localctx = new PrimarykeyindextypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primarykeyindextype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__10);
			setState(125);
			match(T__1);
			setState(126);
			match(CODE);
			setState(127);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnarrayContext extends ParserRuleContext {
		public List<ColumndefContext> columndef() {
			return getRuleContexts(ColumndefContext.class);
		}
		public ColumndefContext columndef(int i) {
			return getRuleContext(ColumndefContext.class,i);
		}
		public ColumnarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnarray(this);
		}
	}

	public final ColumnarrayContext columnarray() throws RecognitionException {
		ColumnarrayContext _localctx = new ColumnarrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnarray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__11);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(130);
				columndef();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(131);
					match(T__12);
					setState(132);
					columndef();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(140);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumndefContext extends ParserRuleContext {
		public List<ColumnnameContext> columnname() {
			return getRuleContexts(ColumnnameContext.class);
		}
		public ColumnnameContext columnname(int i) {
			return getRuleContext(ColumnnameContext.class,i);
		}
		public List<ColumnsqltypeContext> columnsqltype() {
			return getRuleContexts(ColumnsqltypeContext.class);
		}
		public ColumnsqltypeContext columnsqltype(int i) {
			return getRuleContext(ColumnsqltypeContext.class,i);
		}
		public List<ColumnnullableContext> columnnullable() {
			return getRuleContexts(ColumnnullableContext.class);
		}
		public ColumnnullableContext columnnullable(int i) {
			return getRuleContext(ColumnnullableContext.class,i);
		}
		public List<ColumnuniqueContext> columnunique() {
			return getRuleContexts(ColumnuniqueContext.class);
		}
		public ColumnuniqueContext columnunique(int i) {
			return getRuleContext(ColumnuniqueContext.class,i);
		}
		public List<ColumnlengthContext> columnlength() {
			return getRuleContexts(ColumnlengthContext.class);
		}
		public ColumnlengthContext columnlength(int i) {
			return getRuleContext(ColumnlengthContext.class,i);
		}
		public List<ColumnprecisionContext> columnprecision() {
			return getRuleContexts(ColumnprecisionContext.class);
		}
		public ColumnprecisionContext columnprecision(int i) {
			return getRuleContext(ColumnprecisionContext.class,i);
		}
		public List<ColumnscaleContext> columnscale() {
			return getRuleContexts(ColumnscaleContext.class);
		}
		public ColumnscaleContext columnscale(int i) {
			return getRuleContext(ColumnscaleContext.class,i);
		}
		public List<ColumncommentContext> columncomment() {
			return getRuleContexts(ColumncommentContext.class);
		}
		public ColumncommentContext columncomment(int i) {
			return getRuleContext(ColumncommentContext.class,i);
		}
		public List<ColumndefaultvalueContext> columndefaultvalue() {
			return getRuleContexts(ColumndefaultvalueContext.class);
		}
		public ColumndefaultvalueContext columndefaultvalue(int i) {
			return getRuleContext(ColumndefaultvalueContext.class,i);
		}
		public ColumndefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columndef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumndef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumndef(this);
		}
	}

	public final ColumndefContext columndef() throws RecognitionException {
		ColumndefContext _localctx = new ColumndefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_columndef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__14);
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__16:
					{
					setState(143);
					columnname();
					}
					break;
				case T__17:
					{
					setState(144);
					columnsqltype();
					}
					break;
				case T__18:
					{
					setState(145);
					columnnullable();
					}
					break;
				case T__24:
					{
					setState(146);
					columnunique();
					}
					break;
				case T__19:
					{
					setState(147);
					columnlength();
					}
					break;
				case T__20:
					{
					setState(148);
					columnprecision();
					}
					break;
				case T__21:
					{
					setState(149);
					columnscale();
					}
					break;
				case T__23:
					{
					setState(150);
					columncomment();
					}
					break;
				case T__22:
					{
					setState(151);
					columndefaultvalue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0) );
			setState(156);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexarrayContext extends ParserRuleContext {
		public List<IndexdefContext> indexdef() {
			return getRuleContexts(IndexdefContext.class);
		}
		public IndexdefContext indexdef(int i) {
			return getRuleContext(IndexdefContext.class,i);
		}
		public IndexarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexarray(this);
		}
	}

	public final IndexarrayContext indexarray() throws RecognitionException {
		IndexarrayContext _localctx = new IndexarrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_indexarray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__11);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(159);
				indexdef();
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(160);
					match(T__12);
					setState(161);
					indexdef();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(169);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexdefContext extends ParserRuleContext {
		public List<IndexnameContext> indexname() {
			return getRuleContexts(IndexnameContext.class);
		}
		public IndexnameContext indexname(int i) {
			return getRuleContext(IndexnameContext.class,i);
		}
		public List<IndexuniqueContext> indexunique() {
			return getRuleContexts(IndexuniqueContext.class);
		}
		public IndexuniqueContext indexunique(int i) {
			return getRuleContext(IndexuniqueContext.class,i);
		}
		public List<IndexorderContext> indexorder() {
			return getRuleContexts(IndexorderContext.class);
		}
		public IndexorderContext indexorder(int i) {
			return getRuleContext(IndexorderContext.class,i);
		}
		public List<IndexTypeContext> indexType() {
			return getRuleContexts(IndexTypeContext.class);
		}
		public IndexTypeContext indexType(int i) {
			return getRuleContext(IndexTypeContext.class,i);
		}
		public List<IndexcolumnsContext> indexcolumns() {
			return getRuleContexts(IndexcolumnsContext.class);
		}
		public IndexcolumnsContext indexcolumns(int i) {
			return getRuleContext(IndexcolumnsContext.class,i);
		}
		public IndexdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexdef(this);
		}
	}

	public final IndexdefContext indexdef() throws RecognitionException {
		IndexdefContext _localctx = new IndexdefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_indexdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__14);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) {
				{
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__16:
					{
					setState(172);
					indexname();
					}
					break;
				case T__24:
					{
					setState(173);
					indexunique();
					}
					break;
				case T__25:
					{
					setState(174);
					indexorder();
					}
					break;
				case T__26:
					{
					setState(175);
					indexType();
					}
					break;
				case T__27:
					{
					setState(176);
					indexcolumns();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnnameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnname(this);
		}
	}

	public final ColumnnameContext columnname() throws RecognitionException {
		ColumnnameContext _localctx = new ColumnnameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_columnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__16);
			setState(185);
			match(T__1);
			setState(186);
			match(STRING);
			setState(187);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnsqltypeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnsqltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnsqltype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnsqltype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnsqltype(this);
		}
	}

	public final ColumnsqltypeContext columnsqltype() throws RecognitionException {
		ColumnsqltypeContext _localctx = new ColumnsqltypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_columnsqltype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__17);
			setState(190);
			match(T__1);
			setState(191);
			match(CODE);
			setState(192);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnnullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnnullable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnnullable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnnullable(this);
		}
	}

	public final ColumnnullableContext columnnullable() throws RecognitionException {
		ColumnnullableContext _localctx = new ColumnnullableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_columnnullable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__18);
			setState(195);
			match(T__1);
			setState(196);
			match(CODE);
			setState(197);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnlengthContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnlengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnlength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnlength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnlength(this);
		}
	}

	public final ColumnlengthContext columnlength() throws RecognitionException {
		ColumnlengthContext _localctx = new ColumnlengthContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_columnlength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__19);
			setState(200);
			match(T__1);
			setState(201);
			match(CODE);
			setState(202);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnprecisionContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnprecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnprecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnprecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnprecision(this);
		}
	}

	public final ColumnprecisionContext columnprecision() throws RecognitionException {
		ColumnprecisionContext _localctx = new ColumnprecisionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_columnprecision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__20);
			setState(205);
			match(T__1);
			setState(206);
			match(CODE);
			setState(207);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnscaleContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnscaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnscale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnscale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnscale(this);
		}
	}

	public final ColumnscaleContext columnscale() throws RecognitionException {
		ColumnscaleContext _localctx = new ColumnscaleContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_columnscale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__21);
			setState(210);
			match(T__1);
			setState(211);
			match(CODE);
			setState(212);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumndefaultvalueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumndefaultvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columndefaultvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumndefaultvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumndefaultvalue(this);
		}
	}

	public final ColumndefaultvalueContext columndefaultvalue() throws RecognitionException {
		ColumndefaultvalueContext _localctx = new ColumndefaultvalueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_columndefaultvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__22);
			setState(215);
			match(T__1);
			setState(216);
			match(STRING);
			setState(217);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumncommentContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumncommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columncomment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumncomment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumncomment(this);
		}
	}

	public final ColumncommentContext columncomment() throws RecognitionException {
		ColumncommentContext _localctx = new ColumncommentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_columncomment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__23);
			setState(220);
			match(T__1);
			setState(221);
			match(STRING);
			setState(222);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnuniqueContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public ColumnuniqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnunique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterColumnunique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitColumnunique(this);
		}
	}

	public final ColumnuniqueContext columnunique() throws RecognitionException {
		ColumnuniqueContext _localctx = new ColumnuniqueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_columnunique);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__24);
			setState(225);
			match(T__1);
			setState(226);
			match(CODE);
			setState(227);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexnameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBTableParser.STRING, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexname(this);
		}
	}

	public final IndexnameContext indexname() throws RecognitionException {
		IndexnameContext _localctx = new IndexnameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_indexname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__16);
			setState(230);
			match(T__1);
			setState(231);
			match(STRING);
			setState(232);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexuniqueContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexuniqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexunique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexunique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexunique(this);
		}
	}

	public final IndexuniqueContext indexunique() throws RecognitionException {
		IndexuniqueContext _localctx = new IndexuniqueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_indexunique);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__24);
			setState(235);
			match(T__1);
			setState(236);
			match(CODE);
			setState(237);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexorderContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexorderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexorder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexorder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexorder(this);
		}
	}

	public final IndexorderContext indexorder() throws RecognitionException {
		IndexorderContext _localctx = new IndexorderContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_indexorder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__25);
			setState(240);
			match(T__1);
			setState(241);
			match(CODE);
			setState(242);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexTypeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(HDBTableParser.CODE, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexType(this);
		}
	}

	public final IndexTypeContext indexType() throws RecognitionException {
		IndexTypeContext _localctx = new IndexTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_indexType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__26);
			setState(245);
			match(T__1);
			setState(246);
			match(CODE);
			setState(247);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexcolumnsContext extends ParserRuleContext {
		public StringarrayContext stringarray() {
			return getRuleContext(StringarrayContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBTableParser.SEPARATOR, 0); }
		public IndexcolumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexcolumns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterIndexcolumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitIndexcolumns(this);
		}
	}

	public final IndexcolumnsContext indexcolumns() throws RecognitionException {
		IndexcolumnsContext _localctx = new IndexcolumnsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_indexcolumns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__27);
			setState(250);
			match(T__1);
			setState(251);
			stringarray();
			setState(252);
			match(SEPARATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringarrayContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(HDBTableParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(HDBTableParser.STRING, i);
		}
		public StringarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).enterStringarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBTableListener ) ((HDBTableListener)listener).exitStringarray(this);
		}
	}

	public final StringarrayContext stringarray() throws RecognitionException {
		StringarrayContext _localctx = new StringarrayContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stringarray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__11);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(255);
				match(STRING);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(256);
					match(T__12);
					setState(257);
					match(STRING);
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(265);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u010e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\7\16\u0088\n\16\f\16\16\16\u008b\13\16\5\16\u008d\n\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u009b"+
		"\n\17\r\17\16\17\u009c\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00a5\n\20\f"+
		"\20\16\20\u00a8\13\20\5\20\u00aa\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u00b4\n\21\f\21\16\21\u00b7\13\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \7 \u0105\n \f \16 \u0108\13 \5 \u010a\n \3 \3 \3 \2\2!\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\2\2\u010b\2C\3\2\2"+
		"\2\4O\3\2\2\2\6Q\3\2\2\2\bV\3\2\2\2\n[\3\2\2\2\f`\3\2\2\2\16e\3\2\2\2"+
		"\20j\3\2\2\2\22o\3\2\2\2\24t\3\2\2\2\26y\3\2\2\2\30~\3\2\2\2\32\u0083"+
		"\3\2\2\2\34\u0090\3\2\2\2\36\u00a0\3\2\2\2 \u00ad\3\2\2\2\"\u00ba\3\2"+
		"\2\2$\u00bf\3\2\2\2&\u00c4\3\2\2\2(\u00c9\3\2\2\2*\u00ce\3\2\2\2,\u00d3"+
		"\3\2\2\2.\u00d8\3\2\2\2\60\u00dd\3\2\2\2\62\u00e2\3\2\2\2\64\u00e7\3\2"+
		"\2\2\66\u00ec\3\2\2\28\u00f1\3\2\2\2:\u00f6\3\2\2\2<\u00fb\3\2\2\2>\u0100"+
		"\3\2\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2"+
		"EC\3\2\2\2FP\5\6\4\2GP\5\f\7\2HP\5\b\5\2IP\5\16\b\2JP\5\20\t\2KP\5\22"+
		"\n\2LP\5\24\13\2MP\5\26\f\2NP\5\n\6\2OF\3\2\2\2OG\3\2\2\2OH\3\2\2\2OI"+
		"\3\2\2\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\5\3\2\2\2"+
		"QR\7\3\2\2RS\7\4\2\2ST\7 \2\2TU\7\37\2\2U\7\3\2\2\2VW\7\5\2\2WX\7\4\2"+
		"\2XY\7!\2\2YZ\7\37\2\2Z\t\3\2\2\2[\\\7\6\2\2\\]\7\4\2\2]^\7 \2\2^_\7\37"+
		"\2\2_\13\3\2\2\2`a\7\7\2\2ab\7\4\2\2bc\7!\2\2cd\7\37\2\2d\r\3\2\2\2ef"+
		"\7\b\2\2fg\7\4\2\2gh\7!\2\2hi\7\37\2\2i\17\3\2\2\2jk\7\t\2\2kl\7\4\2\2"+
		"lm\7!\2\2mn\7\37\2\2n\21\3\2\2\2op\7\n\2\2pq\7\4\2\2qr\5\32\16\2rs\7\37"+
		"\2\2s\23\3\2\2\2tu\7\13\2\2uv\7\4\2\2vw\5\36\20\2wx\7\37\2\2x\25\3\2\2"+
		"\2yz\7\f\2\2z{\7\4\2\2{|\5> \2|}\7\37\2\2}\27\3\2\2\2~\177\7\r\2\2\177"+
		"\u0080\7\4\2\2\u0080\u0081\7!\2\2\u0081\u0082\7\37\2\2\u0082\31\3\2\2"+
		"\2\u0083\u008c\7\16\2\2\u0084\u0089\5\34\17\2\u0085\u0086\7\17\2\2\u0086"+
		"\u0088\5\34\17\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u0084\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\20"+
		"\2\2\u008f\33\3\2\2\2\u0090\u009a\7\21\2\2\u0091\u009b\5\"\22\2\u0092"+
		"\u009b\5$\23\2\u0093\u009b\5&\24\2\u0094\u009b\5\62\32\2\u0095\u009b\5"+
		"(\25\2\u0096\u009b\5*\26\2\u0097\u009b\5,\27\2\u0098\u009b\5\60\31\2\u0099"+
		"\u009b\5.\30\2\u009a\u0091\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0093\3\2"+
		"\2\2\u009a\u0094\3\2\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009a"+
		"\u0097\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\7\22\2\2\u009f\35\3\2\2\2\u00a0\u00a9\7\16\2\2\u00a1\u00a6\5 \21"+
		"\2\u00a2\u00a3\7\17\2\2\u00a3\u00a5\5 \21\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\7\20\2\2\u00ac\37\3\2\2\2\u00ad\u00b5\7\21"+
		"\2\2\u00ae\u00b4\5\64\33\2\u00af\u00b4\5\66\34\2\u00b0\u00b4\58\35\2\u00b1"+
		"\u00b4\5:\36\2\u00b2\u00b4\5<\37\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2"+
		"\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\22\2\2\u00b9!\3\2\2\2\u00ba\u00bb"+
		"\7\23\2\2\u00bb\u00bc\7\4\2\2\u00bc\u00bd\7 \2\2\u00bd\u00be\7\37\2\2"+
		"\u00be#\3\2\2\2\u00bf\u00c0\7\24\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c2\7"+
		"!\2\2\u00c2\u00c3\7\37\2\2\u00c3%\3\2\2\2\u00c4\u00c5\7\25\2\2\u00c5\u00c6"+
		"\7\4\2\2\u00c6\u00c7\7!\2\2\u00c7\u00c8\7\37\2\2\u00c8\'\3\2\2\2\u00c9"+
		"\u00ca\7\26\2\2\u00ca\u00cb\7\4\2\2\u00cb\u00cc\7!\2\2\u00cc\u00cd\7\37"+
		"\2\2\u00cd)\3\2\2\2\u00ce\u00cf\7\27\2\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1"+
		"\7!\2\2\u00d1\u00d2\7\37\2\2\u00d2+\3\2\2\2\u00d3\u00d4\7\30\2\2\u00d4"+
		"\u00d5\7\4\2\2\u00d5\u00d6\7!\2\2\u00d6\u00d7\7\37\2\2\u00d7-\3\2\2\2"+
		"\u00d8\u00d9\7\31\2\2\u00d9\u00da\7\4\2\2\u00da\u00db\7 \2\2\u00db\u00dc"+
		"\7\37\2\2\u00dc/\3\2\2\2\u00dd\u00de\7\32\2\2\u00de\u00df\7\4\2\2\u00df"+
		"\u00e0\7 \2\2\u00e0\u00e1\7\37\2\2\u00e1\61\3\2\2\2\u00e2\u00e3\7\33\2"+
		"\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\7!\2\2\u00e5\u00e6\7\37\2\2\u00e6\63"+
		"\3\2\2\2\u00e7\u00e8\7\23\2\2\u00e8\u00e9\7\4\2\2\u00e9\u00ea\7 \2\2\u00ea"+
		"\u00eb\7\37\2\2\u00eb\65\3\2\2\2\u00ec\u00ed\7\33\2\2\u00ed\u00ee\7\4"+
		"\2\2\u00ee\u00ef\7!\2\2\u00ef\u00f0\7\37\2\2\u00f0\67\3\2\2\2\u00f1\u00f2"+
		"\7\34\2\2\u00f2\u00f3\7\4\2\2\u00f3\u00f4\7!\2\2\u00f4\u00f5\7\37\2\2"+
		"\u00f59\3\2\2\2\u00f6\u00f7\7\35\2\2\u00f7\u00f8\7\4\2\2\u00f8\u00f9\7"+
		"!\2\2\u00f9\u00fa\7\37\2\2\u00fa;\3\2\2\2\u00fb\u00fc\7\36\2\2\u00fc\u00fd"+
		"\7\4\2\2\u00fd\u00fe\5> \2\u00fe\u00ff\7\37\2\2\u00ff=\3\2\2\2\u0100\u0109"+
		"\7\16\2\2\u0101\u0106\7 \2\2\u0102\u0103\7\17\2\2\u0103\u0105\7 \2\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u0101\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\20\2\2\u010c?\3\2\2\2"+
		"\16CO\u0089\u008c\u009a\u009c\u00a6\u00a9\u00b3\u00b5\u0106\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}