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
		RULE_root = 0, RULE_namespace = 1, RULE_context = 2, RULE_primitivetype = 3, 
		RULE_complextype = 4, RULE_comment = 5, RULE_typecolumn = 6, RULE_columndefault = 7, 
		RULE_columnnullable = 8, RULE_typenameprimitive = 9, RULE_typenamecomplex = 10, 
		RULE_typecolumnname = 11, RULE_contextname = 12, RULE_datatype = 13, RULE_entity = 14, 
		RULE_entityname = 15, RULE_tablecolumn = 16, RULE_keycolumn = 17, RULE_regularcolumn = 18, 
		RULE_columnname = 19, RULE_association = 20, RULE_joinclause = 21, RULE_associatedcols = 22, 
		RULE_generated = 23, RULE_generatedalways = 24, RULE_generatedbydefault = 25, 
		RULE_identitystart = 26, RULE_identityincrement = 27, RULE_identityminclause = 28, 
		RULE_identitynomin = 29, RULE_identitymin = 30, RULE_identitymaxclause = 31, 
		RULE_identitynomax = 32, RULE_identitymax = 33, RULE_identitynochache = 34, 
		RULE_identitynocycle = 35, RULE_techconfig = 36, RULE_tabletype = 37, 
		RULE_tabletype1 = 38, RULE_tabletype2 = 39, RULE_define = 40, RULE_projection = 41, 
		RULE_viewoptions = 42, RULE_privcheck = 43, RULE_databaseobject = 44, 
		RULE_datatype1 = 45, RULE_datatype2 = 46, RULE_datatype3 = 47, RULE_quotedname = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "namespace", "context", "primitivetype", "complextype", "comment", 
			"typecolumn", "columndefault", "columnnullable", "typenameprimitive", 
			"typenamecomplex", "typecolumnname", "contextname", "datatype", "entity", 
			"entityname", "tablecolumn", "keycolumn", "regularcolumn", "columnname", 
			"association", "joinclause", "associatedcols", "generated", "generatedalways", 
			"generatedbydefault", "identitystart", "identityincrement", "identityminclause", 
			"identitynomin", "identitymin", "identitymaxclause", "identitynomax", 
			"identitymax", "identitynochache", "identitynocycle", "techconfig", "tabletype", 
			"tabletype1", "tabletype2", "define", "projection", "viewoptions", "privcheck", 
			"databaseobject", "datatype1", "datatype2", "datatype3", "quotedname"
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
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(98);
				namespace();
				}
			}

			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(101);
					context();
					}
					break;
				case 2:
					{
					setState(102);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(103);
					complextype();
					}
					break;
				case 4:
					{
					setState(104);
					entity();
					}
					break;
				case 5:
					{
					setState(105);
					define();
					}
					break;
				}
				}
				setState(110);
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
			setState(111);
			match(T__0);
			setState(112);
			match(NAME);
			setState(113);
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
		public ContextnameContext contextname() {
			return getRuleContext(ContextnameContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
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
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(115);
				comment();
				}
			}

			setState(118);
			match(T__1);
			setState(119);
			contextname();
			setState(120);
			match(T__2);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(121);
					context();
					}
					break;
				case 2:
					{
					setState(122);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(123);
					complextype();
					}
					break;
				case 4:
					{
					setState(124);
					entity();
					}
					break;
				case 5:
					{
					setState(125);
					define();
					}
					break;
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(T__3);
			setState(132);
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
		public TypenameprimitiveContext typenameprimitive() {
			return getRuleContext(TypenameprimitiveContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
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
		enterRule(_localctx, 6, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(134);
				comment();
				}
			}

			setState(137);
			match(T__4);
			setState(138);
			typenameprimitive();
			setState(139);
			match(T__5);
			setState(140);
			datatype();
			setState(141);
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

	public static class ComplextypeContext extends ParserRuleContext {
		public TypenamecomplexContext typenamecomplex() {
			return getRuleContext(TypenamecomplexContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterComplextype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitComplextype(this);
		}
	}

	public final ComplextypeContext complextype() throws RecognitionException {
		ComplextypeContext _localctx = new ComplextypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_complextype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(143);
				comment();
				}
			}

			setState(146);
			match(T__4);
			setState(147);
			typenamecomplex();
			setState(148);
			match(T__2);
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				typecolumn();
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 || _la==NAME );
			setState(154);
			match(T__3);
			setState(155);
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
		enterRule(_localctx, 10, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__6);
			setState(158);
			match(T__5);
			setState(159);
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
		public TypecolumnnameContext typecolumnname() {
			return getRuleContext(TypecolumnnameContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
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
		enterRule(_localctx, 12, RULE_typecolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(161);
				comment();
				}
			}

			setState(164);
			typecolumnname();
			setState(165);
			match(T__5);
			setState(166);
			datatype();
			setState(167);
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
		enterRule(_localctx, 14, RULE_columndefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__7);
			setState(170);
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
		enterRule(_localctx, 16, RULE_columnnullable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(172);
				match(T__8);
				}
			}

			setState(175);
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

	public static class TypenameprimitiveContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TypenameprimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenameprimitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTypenameprimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTypenameprimitive(this);
		}
	}

	public final TypenameprimitiveContext typenameprimitive() throws RecognitionException {
		TypenameprimitiveContext _localctx = new TypenameprimitiveContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typenameprimitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TypenamecomplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenamecomplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTypenamecomplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTypenamecomplex(this);
		}
	}

	public final TypenamecomplexContext typenamecomplex() throws RecognitionException {
		TypenamecomplexContext _localctx = new TypenamecomplexContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typenamecomplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public TypecolumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typecolumnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTypecolumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTypecolumnname(this);
		}
	}

	public final TypecolumnnameContext typecolumnname() throws RecognitionException {
		TypecolumnnameContext _localctx = new TypecolumnnameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typecolumnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public ContextnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterContextname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitContextname(this);
		}
	}

	public final ContextnameContext contextname() throws RecognitionException {
		ContextnameContext _localctx = new ContextnameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_contextname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDatatype(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_datatype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(185);
				datatype1();
				}
				break;
			case 2:
				{
				setState(186);
				datatype2();
				}
				break;
			case 3:
				{
				setState(187);
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
		public EntitynameContext entityname() {
			return getRuleContext(EntitynameContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(190);
				comment();
				}
			}

			setState(193);
			match(T__10);
			setState(194);
			entityname();
			setState(195);
			match(T__2);
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(196);
				tablecolumn();
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__11) | (1L << NAME))) != 0) );
			setState(201);
			match(T__3);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(202);
				techconfig();
				}
			}

			setState(205);
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

	public static class EntitynameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public EntitynameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterEntityname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitEntityname(this);
		}
	}

	public final EntitynameContext entityname() throws RecognitionException {
		EntitynameContext _localctx = new EntitynameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_entityname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode SEPARATOR() { return getToken(HDBCDSParser.SEPARATOR, 0); }
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterTablecolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitTablecolumn(this);
		}
	}

	public final TablecolumnContext tablecolumn() throws RecognitionException {
		TablecolumnContext _localctx = new TablecolumnContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tablecolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(209);
				comment();
				}
			}

			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(212);
				keycolumn();
				}
				break;
			case NAME:
				{
				setState(213);
				regularcolumn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(216);
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

	public static class KeycolumnContext extends ParserRuleContext {
		public ColumnnameContext columnname() {
			return getRuleContext(ColumnnameContext.class,0);
		}
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterKeycolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitKeycolumn(this);
		}
	}

	public final KeycolumnContext keycolumn() throws RecognitionException {
		KeycolumnContext _localctx = new KeycolumnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keycolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__11);
			setState(219);
			columnname();
			setState(220);
			match(T__5);
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				{
				setState(221);
				datatype();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
					{
					setState(224);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
						{
						setState(222);
						columndefault();
						}
						break;
					case T__8:
					case T__9:
						{
						setState(223);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(229);
					generated();
					}
				}

				}
				}
				break;
			case T__12:
				{
				setState(232);
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
		public ColumnnameContext columnname() {
			return getRuleContext(ColumnnameContext.class,0);
		}
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
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterRegularcolumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitRegularcolumn(this);
		}
	}

	public final RegularcolumnContext regularcolumn() throws RecognitionException {
		RegularcolumnContext _localctx = new RegularcolumnContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_regularcolumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			columnname();
			setState(236);
			match(T__5);
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				{
				setState(237);
				datatype();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
					{
					setState(240);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
						{
						setState(238);
						columndefault();
						}
						break;
					case T__8:
					case T__9:
						{
						setState(239);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(245);
					generated();
					}
				}

				}
				}
				break;
			case T__12:
				{
				setState(248);
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

	public static class ColumnnameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public ColumnnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterColumnname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitColumnname(this);
		}
	}

	public final ColumnnameContext columnname() throws RecognitionException {
		ColumnnameContext _localctx = new ColumnnameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_columnname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_association);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__12);
			setState(254);
			match(T__13);
			setState(255);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(256);
			match(T__14);
			setState(257);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(258);
			match(T__15);
			setState(259);
			match(T__16);
			setState(260);
			match(NAME);
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				{
				setState(261);
				joinclause();
				}
				break;
			case T__2:
				{
				setState(262);
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
		enterRule(_localctx, 42, RULE_joinclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__17);
			setState(266);
			match(NAME);
			setState(267);
			match(T__18);
			setState(268);
			match(NAME);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(269);
				match(T__19);
				setState(270);
				match(NAME);
				setState(271);
				match(T__18);
				setState(272);
				match(NAME);
				}
				}
				setState(277);
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
		enterRule(_localctx, 44, RULE_associatedcols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__2);
			setState(279);
			match(NAME);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(280);
				match(T__14);
				setState(281);
				match(NAME);
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
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
		enterRule(_localctx, 46, RULE_generated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__20);
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(290);
				generatedalways();
				}
				break;
			case T__26:
				{
				setState(291);
				generatedbydefault();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(294);
			match(T__21);
			setState(295);
			match(T__22);
			setState(296);
			match(T__23);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) {
				{
				setState(303);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(297);
					identitystart();
					}
					break;
				case 2:
					{
					setState(298);
					identityincrement();
					}
					break;
				case 3:
					{
					setState(299);
					identityminclause();
					}
					break;
				case 4:
					{
					setState(300);
					identitymaxclause();
					}
					break;
				case 5:
					{
					setState(301);
					identitynochache();
					}
					break;
				case 6:
					{
					setState(302);
					identitynocycle();
					}
					break;
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
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
		enterRule(_localctx, 48, RULE_generatedalways);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
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
		enterRule(_localctx, 50, RULE_generatedbydefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__26);
			setState(313);
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
		enterRule(_localctx, 52, RULE_identitystart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(T__27);
			setState(316);
			match(T__28);
			setState(317);
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
		enterRule(_localctx, 54, RULE_identityincrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(T__29);
			setState(320);
			match(T__26);
			setState(321);
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
		enterRule(_localctx, 56, RULE_identityminclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(323);
				identitynomin();
				}
				break;
			case T__31:
				{
				setState(324);
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
		enterRule(_localctx, 58, RULE_identitynomin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(T__30);
			setState(328);
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
		enterRule(_localctx, 60, RULE_identitymin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(T__31);
			setState(331);
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
		enterRule(_localctx, 62, RULE_identitymaxclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(333);
				identitynomax();
				}
				break;
			case T__32:
				{
				setState(334);
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
		enterRule(_localctx, 64, RULE_identitynomax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__30);
			setState(338);
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
		enterRule(_localctx, 66, RULE_identitymax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__32);
			setState(341);
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
		enterRule(_localctx, 68, RULE_identitynochache);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(343);
				match(T__30);
				}
			}

			setState(346);
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
		enterRule(_localctx, 70, RULE_identitynocycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(348);
				match(T__30);
				}
			}

			setState(351);
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
		enterRule(_localctx, 72, RULE_techconfig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(T__35);
			setState(354);
			match(T__36);
			setState(355);
			match(T__2);
			{
			setState(356);
			tabletype();
			}
			setState(357);
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
		enterRule(_localctx, 74, RULE_tabletype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				{
				setState(359);
				tabletype1();
				}
				break;
			case T__39:
				{
				setState(360);
				tabletype2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(363);
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
		enterRule(_localctx, 76, RULE_tabletype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(T__37);
			setState(366);
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
		enterRule(_localctx, 78, RULE_tabletype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(T__39);
			setState(369);
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
		enterRule(_localctx, 80, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(371);
				comment();
				}
			}

			setState(374);
			match(T__40);
			setState(375);
			match(T__41);
			setState(376);
			match(NAME);
			setState(377);
			match(T__21);
			setState(378);
			match(T__42);
			setState(379);
			match(T__43);
			setState(380);
			match(NAME);
			setState(381);
			match(T__2);
			setState(382);
			projection();
			setState(385); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(383);
				match(T__14);
				setState(384);
				projection();
				}
				}
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__14 );
			setState(389);
			match(T__3);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(390);
				viewoptions();
				}
			}

			setState(393);
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
		enterRule(_localctx, 82, RULE_projection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(NAME);
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(396);
				match(T__21);
				setState(397);
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
		enterRule(_localctx, 84, RULE_viewoptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(400);
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
		enterRule(_localctx, 86, RULE_privcheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(T__28);
			setState(403);
			match(T__44);
			setState(404);
			match(T__45);
			setState(405);
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
		enterRule(_localctx, 88, RULE_databaseobject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
				{
				setState(407);
				quotedname();
				}
				break;
			case NAME:
				{
				setState(408);
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
		enterRule(_localctx, 90, RULE_datatype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(NAME);
			setState(412);
			match(T__23);
			setState(413);
			match(INTEGER);
			setState(414);
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
		enterRule(_localctx, 92, RULE_datatype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(NAME);
			setState(417);
			match(T__23);
			setState(418);
			match(INTEGER);
			setState(419);
			match(T__14);
			setState(420);
			match(INTEGER);
			setState(421);
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

	public static class Datatype3Context extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public Datatype3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterDatatype3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitDatatype3(this);
		}
	}

	public final Datatype3Context datatype3() throws RecognitionException {
		Datatype3Context _localctx = new Datatype3Context(_ctx, getState());
		enterRule(_localctx, 94, RULE_datatype3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_quotedname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(T__47);
			setState(426);
			match(NAME);
			setState(427);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u01b0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\5\2f\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\3\3\3\3\3\3\3\3\4\5\4w\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0081\n\4\f\4\16\4\u0084\13\4\3\4"+
		"\3\4\3\4\3\5\5\5\u008a\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\5\6\u0093\n\6\3"+
		"\6\3\6\3\6\3\6\6\6\u0099\n\6\r\6\16\6\u009a\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\5\b\u00a5\n\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\5\n\u00b0\n\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u00bf"+
		"\n\17\3\20\5\20\u00c2\n\20\3\20\3\20\3\20\3\20\6\20\u00c8\n\20\r\20\16"+
		"\20\u00c9\3\20\3\20\5\20\u00ce\n\20\3\20\3\20\3\21\3\21\3\22\5\22\u00d5"+
		"\n\22\3\22\3\22\5\22\u00d9\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u00e3\n\23\f\23\16\23\u00e6\13\23\3\23\5\23\u00e9\n\23\3\23\5\23"+
		"\u00ec\n\23\3\24\3\24\3\24\3\24\3\24\7\24\u00f3\n\24\f\24\16\24\u00f6"+
		"\13\24\3\24\5\24\u00f9\n\24\3\24\5\24\u00fc\n\24\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u010a\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\7\27\u0114\n\27\f\27\16\27\u0117\13\27\3\30"+
		"\3\30\3\30\3\30\7\30\u011d\n\30\f\30\16\30\u0120\13\30\3\30\3\30\3\31"+
		"\3\31\3\31\5\31\u0127\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u0132\n\31\f\31\16\31\u0135\13\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\5\36\u0148\n\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3!\3!\5!\u0152\n!\3\"\3\"\3\"\3#\3#\3#\3$\5$"+
		"\u015b\n$\3$\3$\3%\5%\u0160\n%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\5\'\u016c"+
		"\n\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\5*\u0177\n*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\6*\u0184\n*\r*\16*\u0185\3*\3*\5*\u018a\n*\3*\3*\3+\3+\3+\5"+
		"+\u0191\n+\3,\3,\3-\3-\3-\3-\3-\3.\3.\5.\u019c\n.\3/\3/\3/\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62\3\62\2\2"+
		"\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`b\2\4\4\2\64\64\66\66\3\2\63\64\2\u01b2\2e\3\2\2\2\4q"+
		"\3\2\2\2\6v\3\2\2\2\b\u0089\3\2\2\2\n\u0092\3\2\2\2\f\u009f\3\2\2\2\16"+
		"\u00a4\3\2\2\2\20\u00ab\3\2\2\2\22\u00af\3\2\2\2\24\u00b3\3\2\2\2\26\u00b5"+
		"\3\2\2\2\30\u00b7\3\2\2\2\32\u00b9\3\2\2\2\34\u00be\3\2\2\2\36\u00c1\3"+
		"\2\2\2 \u00d1\3\2\2\2\"\u00d4\3\2\2\2$\u00dc\3\2\2\2&\u00ed\3\2\2\2(\u00fd"+
		"\3\2\2\2*\u00ff\3\2\2\2,\u010b\3\2\2\2.\u0118\3\2\2\2\60\u0123\3\2\2\2"+
		"\62\u0138\3\2\2\2\64\u013a\3\2\2\2\66\u013d\3\2\2\28\u0141\3\2\2\2:\u0147"+
		"\3\2\2\2<\u0149\3\2\2\2>\u014c\3\2\2\2@\u0151\3\2\2\2B\u0153\3\2\2\2D"+
		"\u0156\3\2\2\2F\u015a\3\2\2\2H\u015f\3\2\2\2J\u0163\3\2\2\2L\u016b\3\2"+
		"\2\2N\u016f\3\2\2\2P\u0172\3\2\2\2R\u0176\3\2\2\2T\u018d\3\2\2\2V\u0192"+
		"\3\2\2\2X\u0194\3\2\2\2Z\u019b\3\2\2\2\\\u019d\3\2\2\2^\u01a2\3\2\2\2"+
		"`\u01a9\3\2\2\2b\u01ab\3\2\2\2df\5\4\3\2ed\3\2\2\2ef\3\2\2\2fn\3\2\2\2"+
		"gm\5\6\4\2hm\5\b\5\2im\5\n\6\2jm\5\36\20\2km\5R*\2lg\3\2\2\2lh\3\2\2\2"+
		"li\3\2\2\2lj\3\2\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\3\3\2\2"+
		"\2pn\3\2\2\2qr\7\3\2\2rs\7\64\2\2st\7\65\2\2t\5\3\2\2\2uw\5\f\7\2vu\3"+
		"\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\4\2\2yz\5\32\16\2z\u0082\7\5\2\2{\u0081"+
		"\5\6\4\2|\u0081\5\b\5\2}\u0081\5\n\6\2~\u0081\5\36\20\2\177\u0081\5R*"+
		"\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\6\2\2\u0086\u0087\7\65"+
		"\2\2\u0087\7\3\2\2\2\u0088\u008a\5\f\7\2\u0089\u0088\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\7\2\2\u008c\u008d\5\24\13\2"+
		"\u008d\u008e\7\b\2\2\u008e\u008f\5\34\17\2\u008f\u0090\7\65\2\2\u0090"+
		"\t\3\2\2\2\u0091\u0093\5\f\7\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2"+
		"\u0093\u0094\3\2\2\2\u0094\u0095\7\7\2\2\u0095\u0096\5\26\f\2\u0096\u0098"+
		"\7\5\2\2\u0097\u0099\5\16\b\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\7\6\2\2\u009d\u009e\7\65\2\2\u009e\13\3\2\2\2\u009f\u00a0\7\t\2\2\u00a0"+
		"\u00a1\7\b\2\2\u00a1\u00a2\7\66\2\2\u00a2\r\3\2\2\2\u00a3\u00a5\5\f\7"+
		"\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\5\30\r\2\u00a7\u00a8\7\b\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7\65\2"+
		"\2\u00aa\17\3\2\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00ad\t\2\2\2\u00ad\21\3"+
		"\2\2\2\u00ae\u00b0\7\13\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\7\f\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\7\64\2"+
		"\2\u00b4\25\3\2\2\2\u00b5\u00b6\7\64\2\2\u00b6\27\3\2\2\2\u00b7\u00b8"+
		"\7\64\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\7\64\2\2\u00ba\33\3\2\2\2\u00bb"+
		"\u00bf\5\\/\2\u00bc\u00bf\5^\60\2\u00bd\u00bf\5`\61\2\u00be\u00bb\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\35\3\2\2\2\u00c0\u00c2"+
		"\5\f\7\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\7\r\2\2\u00c4\u00c5\5 \21\2\u00c5\u00c7\7\5\2\2\u00c6\u00c8\5\""+
		"\22\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\7\6\2\2\u00cc\u00ce\5J"+
		"&\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\7\65\2\2\u00d0\37\3\2\2\2\u00d1\u00d2\7\64\2\2\u00d2!\3\2\2\2\u00d3"+
		"\u00d5\5\f\7\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d9\5$\23\2\u00d7\u00d9\5&\24\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\7\65\2\2\u00db#\3\2\2\2"+
		"\u00dc\u00dd\7\16\2\2\u00dd\u00de\5(\25\2\u00de\u00eb\7\b\2\2\u00df\u00e4"+
		"\5\34\17\2\u00e0\u00e3\5\20\t\2\u00e1\u00e3\5\22\n\2\u00e2\u00e0\3\2\2"+
		"\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\5\60\31\2"+
		"\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00ec"+
		"\5*\26\2\u00eb\u00df\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec%\3\2\2\2\u00ed"+
		"\u00ee\5(\25\2\u00ee\u00fb\7\b\2\2\u00ef\u00f4\5\34\17\2\u00f0\u00f3\5"+
		"\20\t\2\u00f1\u00f3\5\22\n\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f8\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\5\60\31\2\u00f8\u00f7\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\5*\26\2\u00fb\u00ef\3\2"+
		"\2\2\u00fb\u00fa\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u00fe\7\64\2\2\u00fe)\3"+
		"\2\2\2\u00ff\u0100\7\17\2\2\u0100\u0101\7\20\2\2\u0101\u0102\t\3\2\2\u0102"+
		"\u0103\7\21\2\2\u0103\u0104\t\3\2\2\u0104\u0105\7\22\2\2\u0105\u0106\7"+
		"\23\2\2\u0106\u0109\7\64\2\2\u0107\u010a\5,\27\2\u0108\u010a\5.\30\2\u0109"+
		"\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a+\3\2\2\2\u010b\u010c\7\24\2\2"+
		"\u010c\u010d\7\64\2\2\u010d\u010e\7\25\2\2\u010e\u0115\7\64\2\2\u010f"+
		"\u0110\7\26\2\2\u0110\u0111\7\64\2\2\u0111\u0112\7\25\2\2\u0112\u0114"+
		"\7\64\2\2\u0113\u010f\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2"+
		"\u0115\u0116\3\2\2\2\u0116-\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7"+
		"\5\2\2\u0119\u011e\7\64\2\2\u011a\u011b\7\21\2\2\u011b\u011d\7\64\2\2"+
		"\u011c\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\6\2\2\u0122"+
		"/\3\2\2\2\u0123\u0126\7\27\2\2\u0124\u0127\5\62\32\2\u0125\u0127\5\64"+
		"\33\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\7\30\2\2\u0129\u012a\7\31\2\2\u012a\u0133\7\32\2\2\u012b\u0132"+
		"\5\66\34\2\u012c\u0132\58\35\2\u012d\u0132\5:\36\2\u012e\u0132\5@!\2\u012f"+
		"\u0132\5F$\2\u0130\u0132\5H%\2\u0131\u012b\3\2\2\2\u0131\u012c\3\2\2\2"+
		"\u0131\u012d\3\2\2\2\u0131\u012e\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0130"+
		"\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7\33\2\2\u0137\61\3\2\2"+
		"\2\u0138\u0139\7\34\2\2\u0139\63\3\2\2\2\u013a\u013b\7\35\2\2\u013b\u013c"+
		"\7\n\2\2\u013c\65\3\2\2\2\u013d\u013e\7\36\2\2\u013e\u013f\7\37\2\2\u013f"+
		"\u0140\7\63\2\2\u0140\67\3\2\2\2\u0141\u0142\7 \2\2\u0142\u0143\7\35\2"+
		"\2\u0143\u0144\7\63\2\2\u01449\3\2\2\2\u0145\u0148\5<\37\2\u0146\u0148"+
		"\5> \2\u0147\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148;\3\2\2\2\u0149\u014a"+
		"\7!\2\2\u014a\u014b\7\"\2\2\u014b=\3\2\2\2\u014c\u014d\7\"\2\2\u014d\u014e"+
		"\7\63\2\2\u014e?\3\2\2\2\u014f\u0152\5B\"\2\u0150\u0152\5D#\2\u0151\u014f"+
		"\3\2\2\2\u0151\u0150\3\2\2\2\u0152A\3\2\2\2\u0153\u0154\7!\2\2\u0154\u0155"+
		"\7#\2\2\u0155C\3\2\2\2\u0156\u0157\7#\2\2\u0157\u0158\7\63\2\2\u0158E"+
		"\3\2\2\2\u0159\u015b\7!\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015d\7$\2\2\u015dG\3\2\2\2\u015e\u0160\7!\2\2\u015f"+
		"\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\7%"+
		"\2\2\u0162I\3\2\2\2\u0163\u0164\7&\2\2\u0164\u0165\7\'\2\2\u0165\u0166"+
		"\7\5\2\2\u0166\u0167\5L\'\2\u0167\u0168\7\6\2\2\u0168K\3\2\2\2\u0169\u016c"+
		"\5N(\2\u016a\u016c\5P)\2\u016b\u0169\3\2\2\2\u016b\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016e\7\65\2\2\u016eM\3\2\2\2\u016f\u0170\7(\2\2"+
		"\u0170\u0171\7)\2\2\u0171O\3\2\2\2\u0172\u0173\7*\2\2\u0173\u0174\7)\2"+
		"\2\u0174Q\3\2\2\2\u0175\u0177\5\f\7\2\u0176\u0175\3\2\2\2\u0176\u0177"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7+\2\2\u0179\u017a\7,\2\2\u017a"+
		"\u017b\7\64\2\2\u017b\u017c\7\30\2\2\u017c\u017d\7-\2\2\u017d\u017e\7"+
		".\2\2\u017e\u017f\7\64\2\2\u017f\u0180\7\5\2\2\u0180\u0183\5T+\2\u0181"+
		"\u0182\7\21\2\2\u0182\u0184\5T+\2\u0183\u0181\3\2\2\2\u0184\u0185\3\2"+
		"\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0189\7\6\2\2\u0188\u018a\5V,\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2"+
		"\2\u018a\u018b\3\2\2\2\u018b\u018c\7\65\2\2\u018cS\3\2\2\2\u018d\u0190"+
		"\7\64\2\2\u018e\u018f\7\30\2\2\u018f\u0191\5Z.\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191U\3\2\2\2\u0192\u0193\5X-\2\u0193W\3\2\2\2\u0194\u0195"+
		"\7\37\2\2\u0195\u0196\7/\2\2\u0196\u0197\7\60\2\2\u0197\u0198\7\61\2\2"+
		"\u0198Y\3\2\2\2\u0199\u019c\5b\62\2\u019a\u019c\7\64\2\2\u019b\u0199\3"+
		"\2\2\2\u019b\u019a\3\2\2\2\u019c[\3\2\2\2\u019d\u019e\7\64\2\2\u019e\u019f"+
		"\7\32\2\2\u019f\u01a0\7\63\2\2\u01a0\u01a1\7\33\2\2\u01a1]\3\2\2\2\u01a2"+
		"\u01a3\7\64\2\2\u01a3\u01a4\7\32\2\2\u01a4\u01a5\7\63\2\2\u01a5\u01a6"+
		"\7\21\2\2\u01a6\u01a7\7\63\2\2\u01a7\u01a8\7\33\2\2\u01a8_\3\2\2\2\u01a9"+
		"\u01aa\7\64\2\2\u01aaa\3\2\2\2\u01ab\u01ac\7\62\2\2\u01ac\u01ad\7\64\2"+
		"\2\u01ad\u01ae\7\62\2\2\u01aec\3\2\2\2+elnv\u0080\u0082\u0089\u0092\u009a"+
		"\u00a4\u00af\u00be\u00c1\u00c9\u00cd\u00d4\u00d8\u00e2\u00e4\u00e8\u00eb"+
		"\u00f2\u00f4\u00f8\u00fb\u0109\u0115\u011e\u0126\u0131\u0133\u0147\u0151"+
		"\u015a\u015f\u016b\u0176\u0185\u0189\u0190\u019b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}