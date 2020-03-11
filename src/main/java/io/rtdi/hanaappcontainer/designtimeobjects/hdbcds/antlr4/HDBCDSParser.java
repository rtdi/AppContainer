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
		RULE_columnname = 19, RULE_association = 20, RULE_associationfromcardinality = 21, 
		RULE_associationtocardinality = 22, RULE_associationreferenceto = 23, 
		RULE_associationjoinclause = 24, RULE_associationjoinclauseleft = 25, 
		RULE_associationjoinclauseright = 26, RULE_associatedcols = 27, RULE_associatedcolname = 28, 
		RULE_generated = 29, RULE_generatedalways = 30, RULE_generatedbydefault = 31, 
		RULE_identitystart = 32, RULE_identityincrement = 33, RULE_identityminclause = 34, 
		RULE_identitynomin = 35, RULE_identitymin = 36, RULE_identitymaxclause = 37, 
		RULE_identitynomax = 38, RULE_identitymax = 39, RULE_identitynochache = 40, 
		RULE_identitynocycle = 41, RULE_techconfig = 42, RULE_tabletype = 43, 
		RULE_tabletype1 = 44, RULE_tabletype2 = 45, RULE_define = 46, RULE_projection = 47, 
		RULE_viewoptions = 48, RULE_privcheck = 49, RULE_databaseobject = 50, 
		RULE_datatype1 = 51, RULE_datatype2 = 52, RULE_datatype3 = 53, RULE_quotedname = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "namespace", "context", "primitivetype", "complextype", "comment", 
			"typecolumn", "columndefault", "columnnullable", "typenameprimitive", 
			"typenamecomplex", "typecolumnname", "contextname", "datatype", "entity", 
			"entityname", "tablecolumn", "keycolumn", "regularcolumn", "columnname", 
			"association", "associationfromcardinality", "associationtocardinality", 
			"associationreferenceto", "associationjoinclause", "associationjoinclauseleft", 
			"associationjoinclauseright", "associatedcols", "associatedcolname", 
			"generated", "generatedalways", "generatedbydefault", "identitystart", 
			"identityincrement", "identityminclause", "identitynomin", "identitymin", 
			"identitymaxclause", "identitynomax", "identitymax", "identitynochache", 
			"identitynocycle", "techconfig", "tabletype", "tabletype1", "tabletype2", 
			"define", "projection", "viewoptions", "privcheck", "databaseobject", 
			"datatype1", "datatype2", "datatype3", "quotedname"
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(110);
				namespace();
				}
			}

			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(118);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(113);
					context();
					}
					break;
				case 2:
					{
					setState(114);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(115);
					complextype();
					}
					break;
				case 4:
					{
					setState(116);
					entity();
					}
					break;
				case 5:
					{
					setState(117);
					define();
					}
					break;
				}
				}
				setState(122);
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
			setState(123);
			match(T__0);
			setState(124);
			match(NAME);
			setState(125);
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
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(127);
				comment();
				}
			}

			setState(130);
			match(T__1);
			setState(131);
			contextname();
			setState(132);
			match(T__2);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__40))) != 0)) {
				{
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(133);
					context();
					}
					break;
				case 2:
					{
					setState(134);
					primitivetype();
					}
					break;
				case 3:
					{
					setState(135);
					complextype();
					}
					break;
				case 4:
					{
					setState(136);
					entity();
					}
					break;
				case 5:
					{
					setState(137);
					define();
					}
					break;
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(T__3);
			setState(144);
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
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(146);
				comment();
				}
			}

			setState(149);
			match(T__4);
			setState(150);
			typenameprimitive();
			setState(151);
			match(T__5);
			setState(152);
			datatype();
			setState(153);
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
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(155);
				comment();
				}
			}

			setState(158);
			match(T__4);
			setState(159);
			typenamecomplex();
			setState(160);
			match(T__2);
			setState(162); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(161);
				typecolumn();
				}
				}
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 || _la==NAME );
			setState(166);
			match(T__3);
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
			setState(169);
			match(T__6);
			setState(170);
			match(T__5);
			setState(171);
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(173);
				comment();
				}
			}

			setState(176);
			typecolumnname();
			setState(177);
			match(T__5);
			setState(178);
			datatype();
			setState(179);
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
			setState(181);
			match(T__7);
			setState(182);
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
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(184);
				match(T__8);
				}
			}

			setState(187);
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
			setState(189);
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
			setState(191);
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
			setState(193);
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
			setState(195);
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
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(197);
				datatype1();
				}
				break;
			case 2:
				{
				setState(198);
				datatype2();
				}
				break;
			case 3:
				{
				setState(199);
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
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(202);
				comment();
				}
			}

			setState(205);
			match(T__10);
			setState(206);
			entityname();
			setState(207);
			match(T__2);
			setState(209); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(208);
				tablecolumn();
				}
				}
				setState(211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__11) | (1L << NAME))) != 0) );
			setState(213);
			match(T__3);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(214);
				techconfig();
				}
			}

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
			setState(219);
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
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(221);
				comment();
				}
			}

			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(224);
				keycolumn();
				}
				break;
			case NAME:
				{
				setState(225);
				regularcolumn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(228);
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
			setState(230);
			match(T__11);
			setState(231);
			columnname();
			setState(232);
			match(T__5);
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				{
				setState(233);
				datatype();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
					{
					setState(236);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
						{
						setState(234);
						columndefault();
						}
						break;
					case T__8:
					case T__9:
						{
						setState(235);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(241);
					generated();
					}
				}

				}
				}
				break;
			case T__12:
				{
				setState(244);
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
			setState(247);
			columnname();
			setState(248);
			match(T__5);
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				{
				setState(249);
				datatype();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
					{
					setState(252);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
						{
						setState(250);
						columndefault();
						}
						break;
					case T__8:
					case T__9:
						{
						setState(251);
						columnnullable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(257);
					generated();
					}
				}

				}
				}
				break;
			case T__12:
				{
				setState(260);
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
			setState(263);
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
		public AssociationfromcardinalityContext associationfromcardinality() {
			return getRuleContext(AssociationfromcardinalityContext.class,0);
		}
		public AssociationreferencetoContext associationreferenceto() {
			return getRuleContext(AssociationreferencetoContext.class,0);
		}
		public AssociationjoinclauseContext associationjoinclause() {
			return getRuleContext(AssociationjoinclauseContext.class,0);
		}
		public AssociatedcolsContext associatedcols() {
			return getRuleContext(AssociatedcolsContext.class,0);
		}
		public AssociationtocardinalityContext associationtocardinality() {
			return getRuleContext(AssociationtocardinalityContext.class,0);
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
			setState(265);
			match(T__12);
			setState(266);
			match(T__13);
			setState(267);
			associationfromcardinality();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(268);
				match(T__14);
				setState(269);
				associationtocardinality();
				}
			}

			setState(272);
			match(T__15);
			setState(273);
			match(T__16);
			setState(274);
			associationreferenceto();
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				{
				setState(275);
				associationjoinclause();
				}
				break;
			case T__2:
				{
				setState(276);
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

	public static class AssociationfromcardinalityContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationfromcardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationfromcardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationfromcardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationfromcardinality(this);
		}
	}

	public final AssociationfromcardinalityContext associationfromcardinality() throws RecognitionException {
		AssociationfromcardinalityContext _localctx = new AssociationfromcardinalityContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_associationfromcardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
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
		public TerminalNode INTEGER() { return getToken(HDBCDSParser.INTEGER, 0); }
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationtocardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationtocardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationtocardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationtocardinality(this);
		}
	}

	public final AssociationtocardinalityContext associationtocardinality() throws RecognitionException {
		AssociationtocardinalityContext _localctx = new AssociationtocardinalityContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_associationtocardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==NAME) ) {
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

	public static class AssociationreferencetoContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationreferencetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationreferenceto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationreferenceto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationreferenceto(this);
		}
	}

	public final AssociationreferencetoContext associationreferenceto() throws RecognitionException {
		AssociationreferencetoContext _localctx = new AssociationreferencetoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_associationreferenceto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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

	public static class AssociationjoinclauseContext extends ParserRuleContext {
		public List<AssociationjoinclauseleftContext> associationjoinclauseleft() {
			return getRuleContexts(AssociationjoinclauseleftContext.class);
		}
		public AssociationjoinclauseleftContext associationjoinclauseleft(int i) {
			return getRuleContext(AssociationjoinclauseleftContext.class,i);
		}
		public List<AssociationjoinclauserightContext> associationjoinclauseright() {
			return getRuleContexts(AssociationjoinclauserightContext.class);
		}
		public AssociationjoinclauserightContext associationjoinclauseright(int i) {
			return getRuleContext(AssociationjoinclauserightContext.class,i);
		}
		public AssociationjoinclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationjoinclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationjoinclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationjoinclause(this);
		}
	}

	public final AssociationjoinclauseContext associationjoinclause() throws RecognitionException {
		AssociationjoinclauseContext _localctx = new AssociationjoinclauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_associationjoinclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__17);
			setState(286);
			associationjoinclauseleft();
			setState(287);
			match(T__18);
			setState(288);
			associationjoinclauseright();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(289);
				match(T__19);
				setState(290);
				associationjoinclauseleft();
				setState(291);
				match(T__18);
				setState(292);
				associationjoinclauseright();
				}
				}
				setState(298);
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

	public static class AssociationjoinclauseleftContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationjoinclauseleftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationjoinclauseleft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationjoinclauseleft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationjoinclauseleft(this);
		}
	}

	public final AssociationjoinclauseleftContext associationjoinclauseleft() throws RecognitionException {
		AssociationjoinclauseleftContext _localctx = new AssociationjoinclauseleftContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_associationjoinclauseleft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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

	public static class AssociationjoinclauserightContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociationjoinclauserightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationjoinclauseright; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociationjoinclauseright(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociationjoinclauseright(this);
		}
	}

	public final AssociationjoinclauserightContext associationjoinclauseright() throws RecognitionException {
		AssociationjoinclauserightContext _localctx = new AssociationjoinclauserightContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_associationjoinclauseright);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
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

	public static class AssociatedcolsContext extends ParserRuleContext {
		public List<AssociatedcolnameContext> associatedcolname() {
			return getRuleContexts(AssociatedcolnameContext.class);
		}
		public AssociatedcolnameContext associatedcolname(int i) {
			return getRuleContext(AssociatedcolnameContext.class,i);
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
		enterRule(_localctx, 54, RULE_associatedcols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(T__2);
			setState(304);
			associatedcolname();
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(305);
				match(T__14);
				setState(306);
				associatedcolname();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
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

	public static class AssociatedcolnameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(HDBCDSParser.NAME, 0); }
		public AssociatedcolnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associatedcolname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).enterAssociatedcolname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBCDSListener ) ((HDBCDSListener)listener).exitAssociatedcolname(this);
		}
	}

	public final AssociatedcolnameContext associatedcolname() throws RecognitionException {
		AssociatedcolnameContext _localctx = new AssociatedcolnameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_associatedcolname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
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
		enterRule(_localctx, 58, RULE_generated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(T__20);
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(317);
				generatedalways();
				}
				break;
			case T__26:
				{
				setState(318);
				generatedbydefault();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(321);
			match(T__21);
			setState(322);
			match(T__22);
			setState(323);
			match(T__23);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) {
				{
				setState(330);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(324);
					identitystart();
					}
					break;
				case 2:
					{
					setState(325);
					identityincrement();
					}
					break;
				case 3:
					{
					setState(326);
					identityminclause();
					}
					break;
				case 4:
					{
					setState(327);
					identitymaxclause();
					}
					break;
				case 5:
					{
					setState(328);
					identitynochache();
					}
					break;
				case 6:
					{
					setState(329);
					identitynocycle();
					}
					break;
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
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
		enterRule(_localctx, 60, RULE_generatedalways);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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
		enterRule(_localctx, 62, RULE_generatedbydefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(T__26);
			setState(340);
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
		enterRule(_localctx, 64, RULE_identitystart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(T__27);
			setState(343);
			match(T__28);
			setState(344);
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
		enterRule(_localctx, 66, RULE_identityincrement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__29);
			setState(347);
			match(T__26);
			setState(348);
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
		enterRule(_localctx, 68, RULE_identityminclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(350);
				identitynomin();
				}
				break;
			case T__31:
				{
				setState(351);
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
		enterRule(_localctx, 70, RULE_identitynomin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(T__30);
			setState(355);
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
		enterRule(_localctx, 72, RULE_identitymin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(T__31);
			setState(358);
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
		enterRule(_localctx, 74, RULE_identitymaxclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(360);
				identitynomax();
				}
				break;
			case T__32:
				{
				setState(361);
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
		enterRule(_localctx, 76, RULE_identitynomax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(T__30);
			setState(365);
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
		enterRule(_localctx, 78, RULE_identitymax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__32);
			setState(368);
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
		enterRule(_localctx, 80, RULE_identitynochache);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(370);
				match(T__30);
				}
			}

			setState(373);
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
		enterRule(_localctx, 82, RULE_identitynocycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(375);
				match(T__30);
				}
			}

			setState(378);
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
		enterRule(_localctx, 84, RULE_techconfig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(T__35);
			setState(381);
			match(T__36);
			setState(382);
			match(T__2);
			{
			setState(383);
			tabletype();
			}
			setState(384);
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
		enterRule(_localctx, 86, RULE_tabletype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				{
				setState(386);
				tabletype1();
				}
				break;
			case T__39:
				{
				setState(387);
				tabletype2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(390);
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
		enterRule(_localctx, 88, RULE_tabletype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(T__37);
			setState(393);
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
		enterRule(_localctx, 90, RULE_tabletype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(T__39);
			setState(396);
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
		enterRule(_localctx, 92, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(398);
				comment();
				}
			}

			setState(401);
			match(T__40);
			setState(402);
			match(T__41);
			setState(403);
			match(NAME);
			setState(404);
			match(T__21);
			setState(405);
			match(T__42);
			setState(406);
			match(T__43);
			setState(407);
			match(NAME);
			setState(408);
			match(T__2);
			setState(409);
			projection();
			setState(412); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(410);
				match(T__14);
				setState(411);
				projection();
				}
				}
				setState(414); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__14 );
			setState(416);
			match(T__3);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(417);
				viewoptions();
				}
			}

			setState(420);
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
		enterRule(_localctx, 94, RULE_projection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(NAME);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(423);
				match(T__21);
				setState(424);
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
		enterRule(_localctx, 96, RULE_viewoptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(427);
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
		enterRule(_localctx, 98, RULE_privcheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(T__28);
			setState(430);
			match(T__44);
			setState(431);
			match(T__45);
			setState(432);
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
		enterRule(_localctx, 100, RULE_databaseobject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
				{
				setState(434);
				quotedname();
				}
				break;
			case NAME:
				{
				setState(435);
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
		enterRule(_localctx, 102, RULE_datatype1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(NAME);
			setState(439);
			match(T__23);
			setState(440);
			match(INTEGER);
			setState(441);
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
		enterRule(_localctx, 104, RULE_datatype2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(NAME);
			setState(444);
			match(T__23);
			setState(445);
			match(INTEGER);
			setState(446);
			match(T__14);
			setState(447);
			match(INTEGER);
			setState(448);
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
		enterRule(_localctx, 106, RULE_datatype3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
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
		enterRule(_localctx, 108, RULE_quotedname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(T__47);
			setState(453);
			match(NAME);
			setState(454);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u01cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\5\2r\n\2\3\2\3\2\3\2\3\2\3"+
		"\2\7\2y\n\2\f\2\16\2|\13\2\3\3\3\3\3\3\3\3\3\4\5\4\u0083\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\u008d\n\4\f\4\16\4\u0090\13\4\3\4\3\4\3\4\3"+
		"\5\5\5\u0096\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\5\6\u009f\n\6\3\6\3\6\3\6"+
		"\3\6\6\6\u00a5\n\6\r\6\16\6\u00a6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\5\b"+
		"\u00b1\n\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\5\n\u00bc\n\n\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u00cb\n\17\3\20"+
		"\5\20\u00ce\n\20\3\20\3\20\3\20\3\20\6\20\u00d4\n\20\r\20\16\20\u00d5"+
		"\3\20\3\20\5\20\u00da\n\20\3\20\3\20\3\21\3\21\3\22\5\22\u00e1\n\22\3"+
		"\22\3\22\5\22\u00e5\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u00ef\n\23\f\23\16\23\u00f2\13\23\3\23\5\23\u00f5\n\23\3\23\5\23\u00f8"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\7\24\u00ff\n\24\f\24\16\24\u0102\13\24"+
		"\3\24\5\24\u0105\n\24\3\24\5\24\u0108\n\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0111\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u0118\n\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0129\n\32\f\32\16\32\u012c\13\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\7\35\u0136\n\35\f\35\16\35\u0139\13\35\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3\37\5\37\u0142\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\7\37\u014d\n\37\f\37\16\37\u0150\13\37\3\37\3\37\3 \3 \3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\5$\u0163\n$\3%\3%\3%\3&\3&\3&\3\'\3"+
		"\'\5\'\u016d\n\'\3(\3(\3(\3)\3)\3)\3*\5*\u0176\n*\3*\3*\3+\5+\u017b\n"+
		"+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\5-\u0187\n-\3-\3-\3.\3.\3.\3/\3/\3/\3"+
		"\60\5\60\u0192\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\6\60\u019f\n\60\r\60\16\60\u01a0\3\60\3\60\5\60\u01a5\n\60\3\60"+
		"\3\60\3\61\3\61\3\61\5\61\u01ac\n\61\3\62\3\62\3\63\3\63\3\63\3\63\3\63"+
		"\3\64\3\64\5\64\u01b7\n\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\38\38\38\38\38\2\29\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjln\2\4"+
		"\4\2\64\64\66\66\3\2\63\64\2\u01c8\2q\3\2\2\2\4}\3\2\2\2\6\u0082\3\2\2"+
		"\2\b\u0095\3\2\2\2\n\u009e\3\2\2\2\f\u00ab\3\2\2\2\16\u00b0\3\2\2\2\20"+
		"\u00b7\3\2\2\2\22\u00bb\3\2\2\2\24\u00bf\3\2\2\2\26\u00c1\3\2\2\2\30\u00c3"+
		"\3\2\2\2\32\u00c5\3\2\2\2\34\u00ca\3\2\2\2\36\u00cd\3\2\2\2 \u00dd\3\2"+
		"\2\2\"\u00e0\3\2\2\2$\u00e8\3\2\2\2&\u00f9\3\2\2\2(\u0109\3\2\2\2*\u010b"+
		"\3\2\2\2,\u0119\3\2\2\2.\u011b\3\2\2\2\60\u011d\3\2\2\2\62\u011f\3\2\2"+
		"\2\64\u012d\3\2\2\2\66\u012f\3\2\2\28\u0131\3\2\2\2:\u013c\3\2\2\2<\u013e"+
		"\3\2\2\2>\u0153\3\2\2\2@\u0155\3\2\2\2B\u0158\3\2\2\2D\u015c\3\2\2\2F"+
		"\u0162\3\2\2\2H\u0164\3\2\2\2J\u0167\3\2\2\2L\u016c\3\2\2\2N\u016e\3\2"+
		"\2\2P\u0171\3\2\2\2R\u0175\3\2\2\2T\u017a\3\2\2\2V\u017e\3\2\2\2X\u0186"+
		"\3\2\2\2Z\u018a\3\2\2\2\\\u018d\3\2\2\2^\u0191\3\2\2\2`\u01a8\3\2\2\2"+
		"b\u01ad\3\2\2\2d\u01af\3\2\2\2f\u01b6\3\2\2\2h\u01b8\3\2\2\2j\u01bd\3"+
		"\2\2\2l\u01c4\3\2\2\2n\u01c6\3\2\2\2pr\5\4\3\2qp\3\2\2\2qr\3\2\2\2rz\3"+
		"\2\2\2sy\5\6\4\2ty\5\b\5\2uy\5\n\6\2vy\5\36\20\2wy\5^\60\2xs\3\2\2\2x"+
		"t\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{\3\3\2\2\2|z\3\2\2\2}~\7\3\2\2~\177\7\64\2\2\177\u0080\7\65\2\2\u0080"+
		"\5\3\2\2\2\u0081\u0083\5\f\7\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u0086\5\32\16\2\u0086\u008e"+
		"\7\5\2\2\u0087\u008d\5\6\4\2\u0088\u008d\5\b\5\2\u0089\u008d\5\n\6\2\u008a"+
		"\u008d\5\36\20\2\u008b\u008d\5^\60\2\u008c\u0087\3\2\2\2\u008c\u0088\3"+
		"\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\6\2\2\u0092\u0093\7\65\2\2\u0093"+
		"\7\3\2\2\2\u0094\u0096\5\f\7\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0098\7\7\2\2\u0098\u0099\5\24\13\2\u0099\u009a"+
		"\7\b\2\2\u009a\u009b\5\34\17\2\u009b\u009c\7\65\2\2\u009c\t\3\2\2\2\u009d"+
		"\u009f\5\f\7\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\7\7\2\2\u00a1\u00a2\5\26\f\2\u00a2\u00a4\7\5\2\2\u00a3"+
		"\u00a5\5\16\b\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\6\2\2\u00a9"+
		"\u00aa\7\65\2\2\u00aa\13\3\2\2\2\u00ab\u00ac\7\t\2\2\u00ac\u00ad\7\b\2"+
		"\2\u00ad\u00ae\7\66\2\2\u00ae\r\3\2\2\2\u00af\u00b1\5\f\7\2\u00b0\u00af"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\5\30\r\2"+
		"\u00b3\u00b4\7\b\2\2\u00b4\u00b5\5\34\17\2\u00b5\u00b6\7\65\2\2\u00b6"+
		"\17\3\2\2\2\u00b7\u00b8\7\n\2\2\u00b8\u00b9\t\2\2\2\u00b9\21\3\2\2\2\u00ba"+
		"\u00bc\7\13\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\u00be\7\f\2\2\u00be\23\3\2\2\2\u00bf\u00c0\7\64\2\2\u00c0"+
		"\25\3\2\2\2\u00c1\u00c2\7\64\2\2\u00c2\27\3\2\2\2\u00c3\u00c4\7\64\2\2"+
		"\u00c4\31\3\2\2\2\u00c5\u00c6\7\64\2\2\u00c6\33\3\2\2\2\u00c7\u00cb\5"+
		"h\65\2\u00c8\u00cb\5j\66\2\u00c9\u00cb\5l\67\2\u00ca\u00c7\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00ce\5\f\7"+
		"\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0"+
		"\7\r\2\2\u00d0\u00d1\5 \21\2\u00d1\u00d3\7\5\2\2\u00d2\u00d4\5\"\22\2"+
		"\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\7\6\2\2\u00d8\u00da\5V,\2\u00d9"+
		"\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\65"+
		"\2\2\u00dc\37\3\2\2\2\u00dd\u00de\7\64\2\2\u00de!\3\2\2\2\u00df\u00e1"+
		"\5\f\7\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e5\5$\23\2\u00e3\u00e5\5&\24\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\65\2\2\u00e7#\3\2\2\2\u00e8\u00e9"+
		"\7\16\2\2\u00e9\u00ea\5(\25\2\u00ea\u00f7\7\b\2\2\u00eb\u00f0\5\34\17"+
		"\2\u00ec\u00ef\5\20\t\2\u00ed\u00ef\5\22\n\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\5<\37\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f8\5*"+
		"\26\2\u00f7\u00eb\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8%\3\2\2\2\u00f9\u00fa"+
		"\5(\25\2\u00fa\u0107\7\b\2\2\u00fb\u0100\5\34\17\2\u00fc\u00ff\5\20\t"+
		"\2\u00fd\u00ff\5\22\n\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff"+
		"\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0103\u0105\5<\37\2\u0104\u0103\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0108\5*\26\2\u0107\u00fb\3\2"+
		"\2\2\u0107\u0106\3\2\2\2\u0108\'\3\2\2\2\u0109\u010a\7\64\2\2\u010a)\3"+
		"\2\2\2\u010b\u010c\7\17\2\2\u010c\u010d\7\20\2\2\u010d\u0110\5,\27\2\u010e"+
		"\u010f\7\21\2\2\u010f\u0111\5.\30\2\u0110\u010e\3\2\2\2\u0110\u0111\3"+
		"\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\22\2\2\u0113\u0114\7\23\2\2\u0114"+
		"\u0117\5\60\31\2\u0115\u0118\5\62\32\2\u0116\u0118\58\35\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0116\3\2\2\2\u0118+\3\2\2\2\u0119\u011a\t\3\2\2\u011a"+
		"-\3\2\2\2\u011b\u011c\t\3\2\2\u011c/\3\2\2\2\u011d\u011e\7\64\2\2\u011e"+
		"\61\3\2\2\2\u011f\u0120\7\24\2\2\u0120\u0121\5\64\33\2\u0121\u0122\7\25"+
		"\2\2\u0122\u012a\5\66\34\2\u0123\u0124\7\26\2\2\u0124\u0125\5\64\33\2"+
		"\u0125\u0126\7\25\2\2\u0126\u0127\5\66\34\2\u0127\u0129\3\2\2\2\u0128"+
		"\u0123\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\63\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7\64\2\2\u012e\65"+
		"\3\2\2\2\u012f\u0130\7\64\2\2\u0130\67\3\2\2\2\u0131\u0132\7\5\2\2\u0132"+
		"\u0137\5:\36\2\u0133\u0134\7\21\2\2\u0134\u0136\5:\36\2\u0135\u0133\3"+
		"\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7\6\2\2\u013b9\3\2\2\2"+
		"\u013c\u013d\7\64\2\2\u013d;\3\2\2\2\u013e\u0141\7\27\2\2\u013f\u0142"+
		"\5> \2\u0140\u0142\5@!\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\7\30\2\2\u0144\u0145\7\31\2\2\u0145\u014e\7"+
		"\32\2\2\u0146\u014d\5B\"\2\u0147\u014d\5D#\2\u0148\u014d\5F$\2\u0149\u014d"+
		"\5L\'\2\u014a\u014d\5R*\2\u014b\u014d\5T+\2\u014c\u0146\3\2\2\2\u014c"+
		"\u0147\3\2\2\2\u014c\u0148\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7\33"+
		"\2\2\u0152=\3\2\2\2\u0153\u0154\7\34\2\2\u0154?\3\2\2\2\u0155\u0156\7"+
		"\35\2\2\u0156\u0157\7\n\2\2\u0157A\3\2\2\2\u0158\u0159\7\36\2\2\u0159"+
		"\u015a\7\37\2\2\u015a\u015b\7\63\2\2\u015bC\3\2\2\2\u015c\u015d\7 \2\2"+
		"\u015d\u015e\7\35\2\2\u015e\u015f\7\63\2\2\u015fE\3\2\2\2\u0160\u0163"+
		"\5H%\2\u0161\u0163\5J&\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163"+
		"G\3\2\2\2\u0164\u0165\7!\2\2\u0165\u0166\7\"\2\2\u0166I\3\2\2\2\u0167"+
		"\u0168\7\"\2\2\u0168\u0169\7\63\2\2\u0169K\3\2\2\2\u016a\u016d\5N(\2\u016b"+
		"\u016d\5P)\2\u016c\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016dM\3\2\2\2\u016e"+
		"\u016f\7!\2\2\u016f\u0170\7#\2\2\u0170O\3\2\2\2\u0171\u0172\7#\2\2\u0172"+
		"\u0173\7\63\2\2\u0173Q\3\2\2\2\u0174\u0176\7!\2\2\u0175\u0174\3\2\2\2"+
		"\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7$\2\2\u0178S\3\2"+
		"\2\2\u0179\u017b\7!\2\2\u017a\u0179\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017d\7%\2\2\u017dU\3\2\2\2\u017e\u017f\7&\2\2\u017f"+
		"\u0180\7\'\2\2\u0180\u0181\7\5\2\2\u0181\u0182\5X-\2\u0182\u0183\7\6\2"+
		"\2\u0183W\3\2\2\2\u0184\u0187\5Z.\2\u0185\u0187\5\\/\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\7\65\2\2\u0189"+
		"Y\3\2\2\2\u018a\u018b\7(\2\2\u018b\u018c\7)\2\2\u018c[\3\2\2\2\u018d\u018e"+
		"\7*\2\2\u018e\u018f\7)\2\2\u018f]\3\2\2\2\u0190\u0192\5\f\7\2\u0191\u0190"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7+\2\2\u0194"+
		"\u0195\7,\2\2\u0195\u0196\7\64\2\2\u0196\u0197\7\30\2\2\u0197\u0198\7"+
		"-\2\2\u0198\u0199\7.\2\2\u0199\u019a\7\64\2\2\u019a\u019b\7\5\2\2\u019b"+
		"\u019e\5`\61\2\u019c\u019d\7\21\2\2\u019d\u019f\5`\61\2\u019e\u019c\3"+
		"\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a4\7\6\2\2\u01a3\u01a5\5b\62\2\u01a4\u01a3\3\2"+
		"\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7\65\2\2\u01a7"+
		"_\3\2\2\2\u01a8\u01ab\7\64\2\2\u01a9\u01aa\7\30\2\2\u01aa\u01ac\5f\64"+
		"\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01aca\3\2\2\2\u01ad\u01ae"+
		"\5d\63\2\u01aec\3\2\2\2\u01af\u01b0\7\37\2\2\u01b0\u01b1\7/\2\2\u01b1"+
		"\u01b2\7\60\2\2\u01b2\u01b3\7\61\2\2\u01b3e\3\2\2\2\u01b4\u01b7\5n8\2"+
		"\u01b5\u01b7\7\64\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7g\3"+
		"\2\2\2\u01b8\u01b9\7\64\2\2\u01b9\u01ba\7\32\2\2\u01ba\u01bb\7\63\2\2"+
		"\u01bb\u01bc\7\33\2\2\u01bci\3\2\2\2\u01bd\u01be\7\64\2\2\u01be\u01bf"+
		"\7\32\2\2\u01bf\u01c0\7\63\2\2\u01c0\u01c1\7\21\2\2\u01c1\u01c2\7\63\2"+
		"\2\u01c2\u01c3\7\33\2\2\u01c3k\3\2\2\2\u01c4\u01c5\7\64\2\2\u01c5m\3\2"+
		"\2\2\u01c6\u01c7\7\62\2\2\u01c7\u01c8\7\64\2\2\u01c8\u01c9\7\62\2\2\u01c9"+
		"o\3\2\2\2,qxz\u0082\u008c\u008e\u0095\u009e\u00a6\u00b0\u00bb\u00ca\u00cd"+
		"\u00d5\u00d9\u00e0\u00e4\u00ee\u00f0\u00f4\u00f7\u00fe\u0100\u0104\u0107"+
		"\u0110\u0117\u012a\u0137\u0141\u014c\u014e\u0162\u016c\u0175\u017a\u0186"+
		"\u0191\u01a0\u01a4\u01ab\u01b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}