// Generated from HDBCDS.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, INTEGER=49, NAME=50, SEPARATOR=51, STRING=52, 
		WS=53, COMMENT=54, LINE_COMMENT=55;
	public static final int
		RULE_root = 0, RULE_namespace = 1, RULE_context = 2, RULE_type = 3, RULE_primitivetype = 4, 
		RULE_complextype = 5, RULE_typecolumnunit = 6, RULE_comment = 7, RULE_typecolumn = 8, 
		RULE_columndefault = 9, RULE_columnnullable = 10, RULE_entity = 11, RULE_tablecolumnunit = 12, 
		RULE_tablecolumn = 13, RULE_keycolumn = 14, RULE_regularcolumn = 15, RULE_association = 16, 
		RULE_joinclause = 17, RULE_associatedcols = 18, RULE_generated = 19, RULE_generatedalways = 20, 
		RULE_generatedbydefault = 21, RULE_identitystart = 22, RULE_identityincrement = 23, 
		RULE_identityminclause = 24, RULE_identitynomin = 25, RULE_identitymin = 26, 
		RULE_identitymaxclause = 27, RULE_identitynomax = 28, RULE_identitymax = 29, 
		RULE_identitynochache = 30, RULE_identitynocycle = 31, RULE_techconfig = 32, 
		RULE_tabletype = 33, RULE_tabletype1 = 34, RULE_tabletype2 = 35, RULE_define = 36, 
		RULE_projection = 37, RULE_viewoptions = 38, RULE_privcheck = 39, RULE_databaseobject = 40, 
		RULE_datatype1 = 41, RULE_datatype2 = 42, RULE_quotedname = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "namespace", "context", "type", "primitivetype", "complextype", 
			"typecolumnunit", "comment", "typecolumn", "columndefault", "columnnullable", 
			"entity", "tablecolumnunit", "tablecolumn", "keycolumn", "regularcolumn", 
			"association", "joinclause", "associatedcols", "generated", "generatedalways", 
			"generatedbydefault", "identitystart", "identityincrement", "identityminclause", 
			"identitynomin", "identitymin", "identitymaxclause", "identitynomax", 
			"identitymax", "identitynochache", "identitynocycle", "techconfig", "tabletype", 
			"tabletype1", "tabletype2", "define", "projection", "viewoptions", "privcheck", 
			"databaseobject", "datatype1", "datatype2", "quotedname"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'namespace'", "'context'", "'{'", "'}'", "'type'", "':'", "'@Comment'", 
			"'default'", "'not'", "'null'", "'entity'", "'key'", "'association'", 
			"'['", "','", "']'", "'to'", "'on'", "'='", "'and'", "'generated'", "'as'", 
			"'identity'", "'('", "')'", "'always'", "'by'", "'start'", "'with'", 
			"'increment'", "'no'", "'minvalue'", "'maxvalue'", "'cache'", "'cycle'", 
			"'technical'", "'configuration'", "'column'", "'store'", "'row'", "'define'", 
			"'view'", "'select'", "'from'", "'structured'", "'privilege'", "'check'", 
			"'\"'", null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INTEGER", "NAME", "SEPARATOR", "STRING", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "HDBCDS.g4"; }

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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(88);
				namespace();
				}
			}

			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(91);
					context();
					}
					break;
				case 2:
					{
					setState(92);
					type();
					}
					break;
				case 3:
					{
					setState(93);
					entity();
					}
					break;
				case 4:
					{
					setState(94);
					define();
					}
					break;
				}
				}
				setState(99);
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitNamespace(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__0);
			setState(101);
			match(NAME);
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

	public static class ContextContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitContext(this);
		}
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_context);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__1);
			setState(105);
			match(NAME);
			setState(106);
			match(T__2);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(107);
					type();
					}
					break;
				case 2:
					{
					setState(108);
					entity();
					}
					break;
				case 3:
					{
					setState(109);
					define();
					}
					break;
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(T__3);
			setState(116);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public ComplextypeContext complextype() {
			return getRuleContext(ComplextypeContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(118);
				comment();
				}
			}

			setState(121);
			match(T__4);
			setState(122);
			match(NAME);
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(123);
				primitivetype();
				}
				break;
			case T__2:
				{
				setState(124);
				complextype();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class PrimitivetypeContext extends ParserRuleContext {
		public Datatype1Context datatype1() {
			return getRuleContext(Datatype1Context.class,0);
		}
		public Datatype2Context datatype2() {
			return getRuleContext(Datatype2Context.class,0);
		}
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
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
		public PrimitivetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitivetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterPrimitivetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitPrimitivetype(this);
		}
	}

	public final PrimitivetypeContext primitivetype() throws RecognitionException {
		PrimitivetypeContext _localctx = new PrimitivetypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__5);
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(130);
				datatype1();
				}
				break;
			case 2:
				{
				setState(131);
				datatype2();
				}
				break;
			case 3:
				{
				setState(132);
				match(NAME);
				}
				break;
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(135);
					columndefault();
					}
					break;
				case T__8:
				case T__9:
					{
					setState(136);
					columnnullable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(141);
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

	public static class ComplextypeContext extends ParserRuleContext {
		public List<TypecolumnunitContext> typecolumnunit() {
			return getRuleContexts(TypecolumnunitContext.class);
		}
		public TypecolumnunitContext typecolumnunit(int i) {
			return getRuleContext(TypecolumnunitContext.class,i);
		}
		public ComplextypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complextype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterComplextype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitComplextype(this);
		}
	}

	public final ComplextypeContext complextype() throws RecognitionException {
		ComplextypeContext _localctx = new ComplextypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_complextype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__2);
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				typecolumnunit();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 || _la==NAME );
			setState(148);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypecolumnunitContext extends ParserRuleContext {
		public TypecolumnContext typecolumn() {
			return getRuleContext(TypecolumnContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TypecolumnunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typecolumnunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTypecolumnunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTypecolumnunit(this);
		}
	}

	public final TypecolumnunitContext typecolumnunit() throws RecognitionException {
		TypecolumnunitContext _localctx = new TypecolumnunitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typecolumnunit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(150);
				comment();
				}
			}

			setState(153);
			typecolumn();
			setState(154);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HDBCDSParser.STRING, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__6);
			setState(157);
			match(T__5);
			setState(158);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TypecolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typecolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTypecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTypecolumn(this);
		}
	}

	public final TypecolumnContext typecolumn() throws RecognitionException {
		TypecolumnContext _localctx = new TypecolumnContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typecolumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(NAME);
			setState(161);
			primitivetype();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STRING() { return getToken(HDBCDSParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public ColumndefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columndefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterColumndefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitColumndefault(this);
		}
	}

	public final ColumndefaultContext columndefault() throws RecognitionException {
		ColumndefaultContext _localctx = new ColumndefaultContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columndefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__7);
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==STRING) ) {
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
		public ColumnnullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnnullable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterColumnnullable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitColumnnullable(this);
		}
	}

	public final ColumnnullableContext columnnullable() throws RecognitionException {
		ColumnnullableContext _localctx = new ColumnnullableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_columnnullable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(166);
				match(T__8);
				}
			}

			setState(169);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<TablecolumnunitContext> tablecolumnunit() {
			return getRuleContexts(TablecolumnunitContext.class);
		}
		public TablecolumnunitContext tablecolumnunit(int i) {
			return getRuleContext(TablecolumnunitContext.class,i);
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(171);
				comment();
				}
			}

			setState(174);
			match(T__10);
			setState(175);
			match(NAME);
			setState(176);
			match(T__2);
			setState(178); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(177);
				tablecolumnunit();
				}
				}
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__11) | (1L << NAME))) != 0) );
			setState(182);
			match(T__3);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(183);
				techconfig();
				}
			}

			setState(186);
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

	public static class TablecolumnunitContext extends ParserRuleContext {
		public TablecolumnContext tablecolumn() {
			return getRuleContext(TablecolumnContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TablecolumnunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablecolumnunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTablecolumnunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTablecolumnunit(this);
		}
	}

	public final TablecolumnunitContext tablecolumnunit() throws RecognitionException {
		TablecolumnunitContext _localctx = new TablecolumnunitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tablecolumnunit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(188);
				comment();
				}
			}

			setState(191);
			tablecolumn();
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

	public static class TablecolumnContext extends ParserRuleContext {
		public KeycolumnContext keycolumn() {
			return getRuleContext(KeycolumnContext.class,0);
		}
		public RegularcolumnContext regularcolumn() {
			return getRuleContext(RegularcolumnContext.class,0);
		}
		public TablecolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablecolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTablecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTablecolumn(this);
		}
	}

	public final TablecolumnContext tablecolumn() throws RecognitionException {
		TablecolumnContext _localctx = new TablecolumnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tablecolumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(194);
				keycolumn();
				}
				break;
			case NAME:
				{
				setState(195);
				regularcolumn();
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

	public static class KeycolumnContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterKeycolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitKeycolumn(this);
		}
	}

	public final KeycolumnContext keycolumn() throws RecognitionException {
		KeycolumnContext _localctx = new KeycolumnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keycolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__11);
			setState(199);
			match(NAME);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				{
				setState(200);
				primitivetype();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(201);
					generated();
					}
				}

				}
				}
				break;
			case 2:
				{
				setState(204);
				association();
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

	public static class RegularcolumnContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public RegularcolumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularcolumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterRegularcolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitRegularcolumn(this);
		}
	}

	public final RegularcolumnContext regularcolumn() throws RecognitionException {
		RegularcolumnContext _localctx = new RegularcolumnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_regularcolumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(NAME);
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(208);
				primitivetype();
				}
				break;
			case 2:
				{
				setState(209);
				association();
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

	public static class AssociationContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(HDBCDSParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HDBCDSParser.NAME, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(HDBCDSParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(HDBCDSParser.INTEGER, i);
		}
		public JoinclauseContext joinclause() {
			return getRuleContext(JoinclauseContext.class,0);
		}
		public AssociatedcolsContext associatedcols() {
			return getRuleContext(AssociatedcolsContext.class,0);
		}
		public AssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_association; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociation(this);
		}
	}

	public final AssociationContext association() throws RecognitionException {
		AssociationContext _localctx = new AssociationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_association);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__5);
			setState(213);
			match(T__12);
			setState(214);
			match(T__13);
			setState(215);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(216);
			match(T__14);
			setState(217);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(218);
			match(T__15);
			setState(219);
			match(T__16);
			setState(220);
			match(NAME);
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				{
				setState(221);
				joinclause();
				}
				break;
			case T__2:
				{
				setState(222);
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

	public static class JoinclauseContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(HDBCDSParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HDBCDSParser.NAME, i);
		}
		public JoinclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterJoinclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitJoinclause(this);
		}
	}

	public final JoinclauseContext joinclause() throws RecognitionException {
		JoinclauseContext _localctx = new JoinclauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_joinclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__17);
			setState(226);
			match(NAME);
			setState(227);
			match(T__18);
			setState(228);
			match(NAME);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(229);
				match(T__19);
				setState(230);
				match(NAME);
				setState(231);
				match(T__18);
				setState(232);
				match(NAME);
				}
				}
				setState(237);
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

	public static class AssociatedcolsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(HDBCDSParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HDBCDSParser.NAME, i);
		}
		public AssociatedcolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associatedcols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociatedcols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociatedcols(this);
		}
	}

	public final AssociatedcolsContext associatedcols() throws RecognitionException {
		AssociatedcolsContext _localctx = new AssociatedcolsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_associatedcols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__2);
			setState(239);
			match(NAME);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(240);
				match(T__14);
				setState(241);
				match(NAME);
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterGenerated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitGenerated(this);
		}
	}

	public final GeneratedContext generated() throws RecognitionException {
		GeneratedContext _localctx = new GeneratedContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_generated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__20);
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(250);
				generatedalways();
				}
				break;
			case T__26:
				{
				setState(251);
				generatedbydefault();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(254);
			match(T__21);
			setState(255);
			match(T__22);
			setState(256);
			match(T__23);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) {
				{
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(257);
					identitystart();
					}
					break;
				case 2:
					{
					setState(258);
					identityincrement();
					}
					break;
				case 3:
					{
					setState(259);
					identityminclause();
					}
					break;
				case 4:
					{
					setState(260);
					identitymaxclause();
					}
					break;
				case 5:
					{
					setState(261);
					identitynochache();
					}
					break;
				case 6:
					{
					setState(262);
					identitynocycle();
					}
					break;
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
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
		public GeneratedalwaysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatedalways; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterGeneratedalways(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitGeneratedalways(this);
		}
	}

	public final GeneratedalwaysContext generatedalways() throws RecognitionException {
		GeneratedalwaysContext _localctx = new GeneratedalwaysContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_generatedalways);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
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
		public GeneratedbydefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generatedbydefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterGeneratedbydefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitGeneratedbydefault(this);
		}
	}

	public final GeneratedbydefaultContext generatedbydefault() throws RecognitionException {
		GeneratedbydefaultContext _localctx = new GeneratedbydefaultContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_generatedbydefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__26);
			setState(273);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public IdentitystartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitystart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitystart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitystart(this);
		}
	}

	public final IdentitystartContext identitystart() throws RecognitionException {
		IdentitystartContext _localctx = new IdentitystartContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identitystart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__27);
			setState(276);
			match(T__28);
			setState(277);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public IdentityincrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identityincrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentityincrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentityincrement(this);
		}
	}

	public final IdentityincrementContext identityincrement() throws RecognitionException {
		IdentityincrementContext _localctx = new IdentityincrementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_identityincrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__29);
			setState(280);
			match(T__26);
			setState(281);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentityminclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentityminclause(this);
		}
	}

	public final IdentityminclauseContext identityminclause() throws RecognitionException {
		IdentityminclauseContext _localctx = new IdentityminclauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_identityminclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(283);
				identitynomin();
				}
				break;
			case T__31:
				{
				setState(284);
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
		public IdentitynominContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynomin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitynomin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitynomin(this);
		}
	}

	public final IdentitynominContext identitynomin() throws RecognitionException {
		IdentitynominContext _localctx = new IdentitynominContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_identitynomin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__30);
			setState(288);
			match(T__31);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public IdentityminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitymin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitymin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitymin(this);
		}
	}

	public final IdentityminContext identitymin() throws RecognitionException {
		IdentityminContext _localctx = new IdentityminContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_identitymin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__31);
			setState(291);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitymaxclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitymaxclause(this);
		}
	}

	public final IdentitymaxclauseContext identitymaxclause() throws RecognitionException {
		IdentitymaxclauseContext _localctx = new IdentitymaxclauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_identitymaxclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(293);
				identitynomax();
				}
				break;
			case T__32:
				{
				setState(294);
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
		public IdentitynomaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynomax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitynomax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitynomax(this);
		}
	}

	public final IdentitynomaxContext identitynomax() throws RecognitionException {
		IdentitynomaxContext _localctx = new IdentitynomaxContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_identitynomax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__30);
			setState(298);
			match(T__32);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public IdentitymaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitymax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitymax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitymax(this);
		}
	}

	public final IdentitymaxContext identitymax() throws RecognitionException {
		IdentitymaxContext _localctx = new IdentitymaxContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_identitymax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__32);
			setState(301);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
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
		public IdentitynochacheContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynochache; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitynochache(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitynochache(this);
		}
	}

	public final IdentitynochacheContext identitynochache() throws RecognitionException {
		IdentitynochacheContext _localctx = new IdentitynochacheContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_identitynochache);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(303);
				match(T__30);
				}
			}

			setState(306);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
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
		public IdentitynocycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identitynocycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterIdentitynocycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitIdentitynocycle(this);
		}
	}

	public final IdentitynocycleContext identitynocycle() throws RecognitionException {
		IdentitynocycleContext _localctx = new IdentitynocycleContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_identitynocycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(308);
				match(T__30);
				}
			}

			setState(311);
			match(T__34);
			}
		}
		catch (RecognitionException re) {
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
		public TabletypeContext tabletype() {
			return getRuleContext(TabletypeContext.class,0);
		}
		public TechconfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_techconfig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTechconfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTechconfig(this);
		}
	}

	public final TechconfigContext techconfig() throws RecognitionException {
		TechconfigContext _localctx = new TechconfigContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_techconfig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(T__35);
			setState(314);
			match(T__36);
			setState(315);
			match(T__2);
			{
			setState(316);
			tabletype();
			}
			setState(317);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTabletype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTabletype(this);
		}
	}

	public final TabletypeContext tabletype() throws RecognitionException {
		TabletypeContext _localctx = new TabletypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tabletype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				{
				setState(319);
				tabletype1();
				}
				break;
			case T__39:
				{
				setState(320);
				tabletype2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(323);
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

	public static class Tabletype1Context extends ParserRuleContext {
		public Tabletype1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabletype1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTabletype1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTabletype1(this);
		}
	}

	public final Tabletype1Context tabletype1() throws RecognitionException {
		Tabletype1Context _localctx = new Tabletype1Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_tabletype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(T__37);
			setState(326);
			match(T__38);
			}
		}
		catch (RecognitionException re) {
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
		public Tabletype2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabletype2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTabletype2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTabletype2(this);
		}
	}

	public final Tabletype2Context tabletype2() throws RecognitionException {
		Tabletype2Context _localctx = new Tabletype2Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_tabletype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__39);
			setState(329);
			match(T__38);
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> NAME() { return getTokens(HDBCDSParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HDBCDSParser.NAME, i);
		}
		public List<ProjectionContext> projection() {
			return getRuleContexts(ProjectionContext.class);
		}
		public ProjectionContext projection(int i) {
			return getRuleContext(ProjectionContext.class,i);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public ViewoptionsContext viewoptions() {
			return getRuleContext(ViewoptionsContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDefine(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(331);
				comment();
				}
			}

			setState(334);
			match(T__40);
			setState(335);
			match(T__41);
			setState(336);
			match(NAME);
			setState(337);
			match(T__21);
			setState(338);
			match(T__42);
			setState(339);
			match(T__43);
			setState(340);
			match(NAME);
			setState(341);
			match(T__2);
			setState(342);
			projection();
			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(343);
				match(T__14);
				setState(344);
				projection();
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__14 );
			setState(349);
			match(T__3);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(350);
				viewoptions();
				}
			}

			setState(353);
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

	public static class ProjectionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public DatabaseobjectContext databaseobject() {
			return getRuleContext(DatabaseobjectContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitProjection(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_projection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(NAME);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(356);
				match(T__21);
				setState(357);
				databaseobject();
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

	public static class ViewoptionsContext extends ParserRuleContext {
		public PrivcheckContext privcheck() {
			return getRuleContext(PrivcheckContext.class,0);
		}
		public ViewoptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewoptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterViewoptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitViewoptions(this);
		}
	}

	public final ViewoptionsContext viewoptions() throws RecognitionException {
		ViewoptionsContext _localctx = new ViewoptionsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_viewoptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(360);
			privcheck();
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

	public static class PrivcheckContext extends ParserRuleContext {
		public PrivcheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_privcheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterPrivcheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitPrivcheck(this);
		}
	}

	public final PrivcheckContext privcheck() throws RecognitionException {
		PrivcheckContext _localctx = new PrivcheckContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_privcheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(T__28);
			setState(363);
			match(T__44);
			setState(364);
			match(T__45);
			setState(365);
			match(T__46);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatabaseobjectContext extends ParserRuleContext {
		public QuotednameContext quotedname() {
			return getRuleContext(QuotednameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public DatabaseobjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_databaseobject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDatabaseobject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDatabaseobject(this);
		}
	}

	public final DatabaseobjectContext databaseobject() throws RecognitionException {
		DatabaseobjectContext _localctx = new DatabaseobjectContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_databaseobject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
				{
				setState(367);
				quotedname();
				}
				break;
			case NAME:
				{
				setState(368);
				match(NAME);
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

	public static class Datatype1Context extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public Datatype1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDatatype1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDatatype1(this);
		}
	}

	public final Datatype1Context datatype1() throws RecognitionException {
		Datatype1Context _localctx = new Datatype1Context(_ctx, getState());
		enterRule(_localctx, 82, RULE_datatype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(NAME);
			setState(372);
			match(T__23);
			setState(373);
			match(INTEGER);
			setState(374);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(HDBCDSParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(HDBCDSParser.INTEGER, i);
		}
		public Datatype2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDatatype2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDatatype2(this);
		}
	}

	public final Datatype2Context datatype2() throws RecognitionException {
		Datatype2Context _localctx = new Datatype2Context(_ctx, getState());
		enterRule(_localctx, 84, RULE_datatype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(NAME);
			setState(377);
			match(T__23);
			setState(378);
			match(INTEGER);
			setState(379);
			match(T__14);
			setState(380);
			match(INTEGER);
			setState(381);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotednameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public QuotednameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterQuotedname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitQuotedname(this);
		}
	}

	public final QuotednameContext quotedname() throws RecognitionException {
		QuotednameContext _localctx = new QuotednameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_quotedname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(T__47);
			setState(384);
			match(NAME);
			setState(385);
			match(T__47);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u0186\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\5\2\\\n\2\3\2\3\2\3\2\3\2\7\2b\n\2\f\2\16\2e\13\2\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4q\n\4\f\4\16\4t\13\4\3\4\3\4\3\4"+
		"\3\5\5\5z\n\5\3\5\3\5\3\5\3\5\5\5\u0080\n\5\3\5\3\5\3\6\3\6\3\6\3\6\5"+
		"\6\u0088\n\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\7\3\7\6\7\u0093"+
		"\n\7\r\7\16\7\u0094\3\7\3\7\3\b\5\b\u009a\n\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\5\f\u00aa\n\f\3\f\3\f\3\r\5\r\u00af"+
		"\n\r\3\r\3\r\3\r\3\r\6\r\u00b5\n\r\r\r\16\r\u00b6\3\r\3\r\5\r\u00bb\n"+
		"\r\3\r\3\r\3\16\5\16\u00c0\n\16\3\16\3\16\3\16\3\17\3\17\5\17\u00c7\n"+
		"\17\3\20\3\20\3\20\3\20\5\20\u00cd\n\20\3\20\5\20\u00d0\n\20\3\21\3\21"+
		"\3\21\5\21\u00d5\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00e2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00ec"+
		"\n\23\f\23\16\23\u00ef\13\23\3\24\3\24\3\24\3\24\7\24\u00f5\n\24\f\24"+
		"\16\24\u00f8\13\24\3\24\3\24\3\25\3\25\3\25\5\25\u00ff\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u010a\n\25\f\25\16\25\u010d\13"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\5\32\u0120\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\5\35\u012a\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \5 \u0133\n \3 "+
		"\3 \3!\5!\u0138\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\5#\u0144\n#\3#"+
		"\3#\3$\3$\3$\3%\3%\3%\3&\5&\u014f\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\6&\u015c\n&\r&\16&\u015d\3&\3&\5&\u0162\n&\3&\3&\3\'\3\'\3\'\5\'\u0169"+
		"\n\'\3(\3(\3)\3)\3)\3)\3)\3*\3*\5*\u0174\n*\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3-\3-\3-\3-\3-\2\2.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\4\4\2\64\64\66\66\3\2\63\64\2"+
		"\u0186\2[\3\2\2\2\4f\3\2\2\2\6j\3\2\2\2\by\3\2\2\2\n\u0083\3\2\2\2\f\u0090"+
		"\3\2\2\2\16\u0099\3\2\2\2\20\u009e\3\2\2\2\22\u00a2\3\2\2\2\24\u00a5\3"+
		"\2\2\2\26\u00a9\3\2\2\2\30\u00ae\3\2\2\2\32\u00bf\3\2\2\2\34\u00c6\3\2"+
		"\2\2\36\u00c8\3\2\2\2 \u00d1\3\2\2\2\"\u00d6\3\2\2\2$\u00e3\3\2\2\2&\u00f0"+
		"\3\2\2\2(\u00fb\3\2\2\2*\u0110\3\2\2\2,\u0112\3\2\2\2.\u0115\3\2\2\2\60"+
		"\u0119\3\2\2\2\62\u011f\3\2\2\2\64\u0121\3\2\2\2\66\u0124\3\2\2\28\u0129"+
		"\3\2\2\2:\u012b\3\2\2\2<\u012e\3\2\2\2>\u0132\3\2\2\2@\u0137\3\2\2\2B"+
		"\u013b\3\2\2\2D\u0143\3\2\2\2F\u0147\3\2\2\2H\u014a\3\2\2\2J\u014e\3\2"+
		"\2\2L\u0165\3\2\2\2N\u016a\3\2\2\2P\u016c\3\2\2\2R\u0173\3\2\2\2T\u0175"+
		"\3\2\2\2V\u017a\3\2\2\2X\u0181\3\2\2\2Z\\\5\4\3\2[Z\3\2\2\2[\\\3\2\2\2"+
		"\\c\3\2\2\2]b\5\6\4\2^b\5\b\5\2_b\5\30\r\2`b\5J&\2a]\3\2\2\2a^\3\2\2\2"+
		"a_\3\2\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\3\3\2\2\2ec\3\2\2"+
		"\2fg\7\3\2\2gh\7\64\2\2hi\7\65\2\2i\5\3\2\2\2jk\7\4\2\2kl\7\64\2\2lr\7"+
		"\5\2\2mq\5\b\5\2nq\5\30\r\2oq\5J&\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2qt\3"+
		"\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\6\2\2vw\7\65\2\2w\7"+
		"\3\2\2\2xz\5\20\t\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\7\2\2|\177\7\64"+
		"\2\2}\u0080\5\n\6\2~\u0080\5\f\7\2\177}\3\2\2\2\177~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\7\65\2\2\u0082\t\3\2\2\2\u0083\u0087\7\b\2\2\u0084"+
		"\u0088\5T+\2\u0085\u0088\5V,\2\u0086\u0088\7\64\2\2\u0087\u0084\3\2\2"+
		"\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\u008d\3\2\2\2\u0089\u008c"+
		"\5\24\13\2\u008a\u008c\5\26\f\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2"+
		"\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\13"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\7\5\2\2\u0091\u0093\5\16\b\2"+
		"\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\6\2\2\u0097\r\3\2\2\2\u0098"+
		"\u009a\5\20\t\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3"+
		"\2\2\2\u009b\u009c\5\22\n\2\u009c\u009d\7\65\2\2\u009d\17\3\2\2\2\u009e"+
		"\u009f\7\t\2\2\u009f\u00a0\7\b\2\2\u00a0\u00a1\7\66\2\2\u00a1\21\3\2\2"+
		"\2\u00a2\u00a3\7\64\2\2\u00a3\u00a4\5\n\6\2\u00a4\23\3\2\2\2\u00a5\u00a6"+
		"\7\n\2\2\u00a6\u00a7\t\2\2\2\u00a7\25\3\2\2\2\u00a8\u00aa\7\13\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\f"+
		"\2\2\u00ac\27\3\2\2\2\u00ad\u00af\5\20\t\2\u00ae\u00ad\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\r\2\2\u00b1\u00b2\7\64\2\2"+
		"\u00b2\u00b4\7\5\2\2\u00b3\u00b5\5\32\16\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\7\6\2\2\u00b9\u00bb\5B\"\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\65\2\2\u00bd\31\3\2\2\2\u00be\u00c0"+
		"\5\20\t\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2"+
		"\u00c1\u00c2\5\34\17\2\u00c2\u00c3\7\65\2\2\u00c3\33\3\2\2\2\u00c4\u00c7"+
		"\5\36\20\2\u00c5\u00c7\5 \21\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2"+
		"\u00c7\35\3\2\2\2\u00c8\u00c9\7\16\2\2\u00c9\u00cf\7\64\2\2\u00ca\u00cc"+
		"\5\n\6\2\u00cb\u00cd\5(\25\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00d0\5\"\22\2\u00cf\u00ca\3\2\2\2\u00cf\u00ce\3"+
		"\2\2\2\u00d0\37\3\2\2\2\u00d1\u00d4\7\64\2\2\u00d2\u00d5\5\n\6\2\u00d3"+
		"\u00d5\5\"\22\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5!\3\2\2\2"+
		"\u00d6\u00d7\7\b\2\2\u00d7\u00d8\7\17\2\2\u00d8\u00d9\7\20\2\2\u00d9\u00da"+
		"\t\3\2\2\u00da\u00db\7\21\2\2\u00db\u00dc\t\3\2\2\u00dc\u00dd\7\22\2\2"+
		"\u00dd\u00de\7\23\2\2\u00de\u00e1\7\64\2\2\u00df\u00e2\5$\23\2\u00e0\u00e2"+
		"\5&\24\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2#\3\2\2\2\u00e3"+
		"\u00e4\7\24\2\2\u00e4\u00e5\7\64\2\2\u00e5\u00e6\7\25\2\2\u00e6\u00ed"+
		"\7\64\2\2\u00e7\u00e8\7\26\2\2\u00e8\u00e9\7\64\2\2\u00e9\u00ea\7\25\2"+
		"\2\u00ea\u00ec\7\64\2\2\u00eb\u00e7\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee%\3\2\2\2\u00ef\u00ed\3\2\2\2"+
		"\u00f0\u00f1\7\5\2\2\u00f1\u00f6\7\64\2\2\u00f2\u00f3\7\21\2\2\u00f3\u00f5"+
		"\7\64\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa"+
		"\7\6\2\2\u00fa\'\3\2\2\2\u00fb\u00fe\7\27\2\2\u00fc\u00ff\5*\26\2\u00fd"+
		"\u00ff\5,\27\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\7\30\2\2\u0101\u0102\7\31\2\2\u0102\u010b\7\32\2\2\u0103"+
		"\u010a\5.\30\2\u0104\u010a\5\60\31\2\u0105\u010a\5\62\32\2\u0106\u010a"+
		"\58\35\2\u0107\u010a\5> \2\u0108\u010a\5@!\2\u0109\u0103\3\2\2\2\u0109"+
		"\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7\33"+
		"\2\2\u010f)\3\2\2\2\u0110\u0111\7\34\2\2\u0111+\3\2\2\2\u0112\u0113\7"+
		"\35\2\2\u0113\u0114\7\n\2\2\u0114-\3\2\2\2\u0115\u0116\7\36\2\2\u0116"+
		"\u0117\7\37\2\2\u0117\u0118\7\63\2\2\u0118/\3\2\2\2\u0119\u011a\7 \2\2"+
		"\u011a\u011b\7\35\2\2\u011b\u011c\7\63\2\2\u011c\61\3\2\2\2\u011d\u0120"+
		"\5\64\33\2\u011e\u0120\5\66\34\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2"+
		"\2\u0120\63\3\2\2\2\u0121\u0122\7!\2\2\u0122\u0123\7\"\2\2\u0123\65\3"+
		"\2\2\2\u0124\u0125\7\"\2\2\u0125\u0126\7\63\2\2\u0126\67\3\2\2\2\u0127"+
		"\u012a\5:\36\2\u0128\u012a\5<\37\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2"+
		"\2\2\u012a9\3\2\2\2\u012b\u012c\7!\2\2\u012c\u012d\7#\2\2\u012d;\3\2\2"+
		"\2\u012e\u012f\7#\2\2\u012f\u0130\7\63\2\2\u0130=\3\2\2\2\u0131\u0133"+
		"\7!\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\7$\2\2\u0135?\3\2\2\2\u0136\u0138\7!\2\2\u0137\u0136\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\7%\2\2\u013aA\3\2\2\2\u013b"+
		"\u013c\7&\2\2\u013c\u013d\7\'\2\2\u013d\u013e\7\5\2\2\u013e\u013f\5D#"+
		"\2\u013f\u0140\7\6\2\2\u0140C\3\2\2\2\u0141\u0144\5F$\2\u0142\u0144\5"+
		"H%\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\7\65\2\2\u0146E\3\2\2\2\u0147\u0148\7(\2\2\u0148\u0149\7)\2\2\u0149"+
		"G\3\2\2\2\u014a\u014b\7*\2\2\u014b\u014c\7)\2\2\u014cI\3\2\2\2\u014d\u014f"+
		"\5\20\t\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2"+
		"\u0150\u0151\7+\2\2\u0151\u0152\7,\2\2\u0152\u0153\7\64\2\2\u0153\u0154"+
		"\7\30\2\2\u0154\u0155\7-\2\2\u0155\u0156\7.\2\2\u0156\u0157\7\64\2\2\u0157"+
		"\u0158\7\5\2\2\u0158\u015b\5L\'\2\u0159\u015a\7\21\2\2\u015a\u015c\5L"+
		"\'\2\u015b\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\7\6\2\2\u0160\u0162\5N"+
		"(\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\7\65\2\2\u0164K\3\2\2\2\u0165\u0168\7\64\2\2\u0166\u0167\7\30\2"+
		"\2\u0167\u0169\5R*\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169M\3"+
		"\2\2\2\u016a\u016b\5P)\2\u016bO\3\2\2\2\u016c\u016d\7\37\2\2\u016d\u016e"+
		"\7/\2\2\u016e\u016f\7\60\2\2\u016f\u0170\7\61\2\2\u0170Q\3\2\2\2\u0171"+
		"\u0174\5X-\2\u0172\u0174\7\64\2\2\u0173\u0171\3\2\2\2\u0173\u0172\3\2"+
		"\2\2\u0174S\3\2\2\2\u0175\u0176\7\64\2\2\u0176\u0177\7\32\2\2\u0177\u0178"+
		"\7\63\2\2\u0178\u0179\7\33\2\2\u0179U\3\2\2\2\u017a\u017b\7\64\2\2\u017b"+
		"\u017c\7\32\2\2\u017c\u017d\7\63\2\2\u017d\u017e\7\21\2\2\u017e\u017f"+
		"\7\63\2\2\u017f\u0180\7\33\2\2\u0180W\3\2\2\2\u0181\u0182\7\62\2\2\u0182"+
		"\u0183\7\64\2\2\u0183\u0184\7\62\2\2\u0184Y\3\2\2\2\'[acpry\177\u0087"+
		"\u008b\u008d\u0094\u0099\u00a9\u00ae\u00b6\u00ba\u00bf\u00c6\u00cc\u00cf"+
		"\u00d4\u00e1\u00ed\u00f6\u00fe\u0109\u010b\u011f\u0129\u0132\u0137\u0143"+
		"\u014e\u015d\u0161\u0168\u0173";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}