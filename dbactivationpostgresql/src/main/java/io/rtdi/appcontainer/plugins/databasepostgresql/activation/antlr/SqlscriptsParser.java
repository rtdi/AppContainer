// Generated from java-escape by ANTLR 4.11.1
package io.rtdi.appcontainer.plugins.databasepostgresql.activation.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SqlscriptsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LINE_COMMENT_START=3, BLOCK_COMMENT_START=4, BLOCK_COMMENT_END=5, 
		WS=6, NL=7, VARIABLE=8, ALIAS=9, OBJECT=10, COLUMN=11, DECLARE=12, BEGIN=13, 
		END=14, IF=15, FOR=16, WHILE=17, LOOP=18, SEMI=19, NOT=20, EXISTS=21, 
		SQ=22, DQ=23, BQ=24, DOT=25, COMMA=26, WORD=27, ESC=28;
	public static final int
		RULE_blockcomment = 0, RULE_alias = 1, RULE_variable = 2, RULE_squoted = 3, 
		RULE_dquoted = 4, RULE_bquoted = 5, RULE_identifier = 6, RULE_directive = 7, 
		RULE_directivecondition = 8, RULE_directiveend = 9, RULE_linecomment = 10, 
		RULE_beginblock = 11, RULE_declarestart = 12, RULE_beginstart = 13, RULE_beginend = 14, 
		RULE_ifblock = 15, RULE_ifstart = 16, RULE_ifend = 17, RULE_forblock = 18, 
		RULE_forstart = 19, RULE_forend = 20, RULE_whileblock = 21, RULE_whilestart = 22, 
		RULE_whileend = 23, RULE_loopblock = 24, RULE_loopstart = 25, RULE_loopend = 26, 
		RULE_extra = 27, RULE_semi = 28, RULE_text = 29, RULE_escapedchar = 30, 
		RULE_command = 31, RULE_commandblock = 32, RULE_statement = 33, RULE_paramclause = 34, 
		RULE_paramclausestart = 35, RULE_paramclauseend = 36, RULE_param_list = 37, 
		RULE_script = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"blockcomment", "alias", "variable", "squoted", "dquoted", "bquoted", 
			"identifier", "directive", "directivecondition", "directiveend", "linecomment", 
			"beginblock", "declarestart", "beginstart", "beginend", "ifblock", "ifstart", 
			"ifend", "forblock", "forstart", "forend", "whileblock", "whilestart", 
			"whileend", "loopblock", "loopstart", "loopend", "extra", "semi", "text", 
			"escapedchar", "command", "commandblock", "statement", "paramclause", 
			"paramclausestart", "paramclauseend", "param_list", "script"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'//'", "'/*'", "'*/'", null, null, null, null, "'OBJECT'", 
			"'COLUMN'", "'DECLARE'", "'BEGIN'", "'END'", "'IF'", "'FOR'", "'WHILE'", 
			"'LOOP'", "';'", "'NOT'", "'EXISTS'", "'''", "'\"'", "'`'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LINE_COMMENT_START", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END", 
			"WS", "NL", "VARIABLE", "ALIAS", "OBJECT", "COLUMN", "DECLARE", "BEGIN", 
			"END", "IF", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", "SQ", "DQ", 
			"BQ", "DOT", "COMMA", "WORD", "ESC"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlscriptsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockcommentContext extends ParserRuleContext {
		public TerminalNode BLOCK_COMMENT_START() { return getToken(SqlscriptsParser.BLOCK_COMMENT_START, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public List<TerminalNode> BLOCK_COMMENT_END() { return getTokens(SqlscriptsParser.BLOCK_COMMENT_END); }
		public TerminalNode BLOCK_COMMENT_END(int i) {
			return getToken(SqlscriptsParser.BLOCK_COMMENT_END, i);
		}
		public BlockcommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockcomment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterBlockcomment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitBlockcomment(this);
		}
	}

	public final BlockcommentContext blockcomment() throws RecognitionException {
		BlockcommentContext _localctx = new BlockcommentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_blockcomment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(BLOCK_COMMENT_START);
			setState(79);
			match(WS);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==BLOCK_COMMENT_END) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(86);
			match(WS);
			setState(87);
			match(BLOCK_COMMENT_END);
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(88);
				match(WS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AliasContext extends ParserRuleContext {
		public TerminalNode ALIAS() { return getToken(SqlscriptsParser.ALIAS, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ALIAS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(SqlscriptsParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SquotedContext extends ParserRuleContext {
		public List<TerminalNode> SQ() { return getTokens(SqlscriptsParser.SQ); }
		public TerminalNode SQ(int i) {
			return getToken(SqlscriptsParser.SQ, i);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> ESC() { return getTokens(SqlscriptsParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(SqlscriptsParser.ESC, i);
		}
		public SquotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterSquoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitSquoted(this);
		}
	}

	public final SquotedContext squoted() throws RecognitionException {
		SquotedContext _localctx = new SquotedContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_squoted);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(SQ);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 532676606L) != 0) {
				{
				setState(100);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(96);
					alias();
					}
					break;
				case 2:
					{
					setState(97);
					variable();
					}
					break;
				case 3:
					{
					setState(98);
					match(ESC);
					}
					break;
				case 4:
					{
					setState(99);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==SQ) ) {
					_errHandler.recoverInline(this);
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
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DquotedContext extends ParserRuleContext {
		public List<TerminalNode> DQ() { return getTokens(SqlscriptsParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(SqlscriptsParser.DQ, i);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> ESC() { return getTokens(SqlscriptsParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(SqlscriptsParser.ESC, i);
		}
		public DquotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dquoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterDquoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitDquoted(this);
		}
	}

	public final DquotedContext dquoted() throws RecognitionException {
		DquotedContext _localctx = new DquotedContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dquoted);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(DQ);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 528482302L) != 0) {
				{
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(108);
					alias();
					}
					break;
				case 2:
					{
					setState(109);
					variable();
					}
					break;
				case 3:
					{
					setState(110);
					match(ESC);
					}
					break;
				case 4:
					{
					setState(111);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==DQ) ) {
					_errHandler.recoverInline(this);
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
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(DQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BquotedContext extends ParserRuleContext {
		public List<TerminalNode> BQ() { return getTokens(SqlscriptsParser.BQ); }
		public TerminalNode BQ(int i) {
			return getToken(SqlscriptsParser.BQ, i);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public BquotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bquoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterBquoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitBquoted(this);
		}
	}

	public final BquotedContext bquoted() throws RecognitionException {
		BquotedContext _localctx = new BquotedContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bquoted);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(BQ);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 520093694L) != 0) {
				{
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(120);
					alias();
					}
					break;
				case 2:
					{
					setState(121);
					variable();
					}
					break;
				case 3:
					{
					setState(122);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==BQ) ) {
					_errHandler.recoverInline(this);
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
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(BQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(SqlscriptsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(SqlscriptsParser.WORD, i);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SqlscriptsParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SqlscriptsParser.DOT, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				{
				setState(130);
				match(WORD);
				}
				break;
			case ALIAS:
				{
				setState(131);
				alias();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(134);
				match(DOT);
				setState(137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WORD:
					{
					setState(135);
					match(WORD);
					}
					break;
				case ALIAS:
					{
					setState(136);
					alias();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(143);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveContext extends ParserRuleContext {
		public DirectiveconditionContext directivecondition() {
			return getRuleContext(DirectiveconditionContext.class,0);
		}
		public DirectiveendContext directiveend() {
			return getRuleContext(DirectiveendContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitDirective(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_directive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(144);
				match(WS);
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			directivecondition();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					statement();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(157);
			directiveend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveconditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SqlscriptsParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlscriptsParser.EXISTS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NL() { return getToken(SqlscriptsParser.NL, 0); }
		public TerminalNode OBJECT() { return getToken(SqlscriptsParser.OBJECT, 0); }
		public TerminalNode COLUMN() { return getToken(SqlscriptsParser.COLUMN, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public TerminalNode NOT() { return getToken(SqlscriptsParser.NOT, 0); }
		public DirectiveconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directivecondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterDirectivecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitDirectivecondition(this);
		}
	}

	public final DirectiveconditionContext directivecondition() throws RecognitionException {
		DirectiveconditionContext _localctx = new DirectiveconditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_directivecondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(IF);
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match(WS);
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==OBJECT || _la==COLUMN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(WS);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(171);
				match(NOT);
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					match(WS);
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				}
			}

			setState(179);
			match(EXISTS);
			setState(181); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				match(WS);
				}
				}
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(185);
			identifier();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(186);
				match(WS);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveendContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT_START() { return getToken(SqlscriptsParser.LINE_COMMENT_START, 0); }
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public TerminalNode IF() { return getToken(SqlscriptsParser.IF, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public DirectiveendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterDirectiveend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitDirectiveend(this);
		}
	}

	public final DirectiveendContext directiveend() throws RecognitionException {
		DirectiveendContext _localctx = new DirectiveendContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_directiveend);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(LINE_COMMENT_START);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(195);
				match(WS);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(END);
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				match(WS);
				}
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(207);
			match(IF);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					match(WS);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LinecommentContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT_START() { return getToken(SqlscriptsParser.LINE_COMMENT_START, 0); }
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public LinecommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linecomment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterLinecomment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitLinecomment(this);
		}
	}

	public final LinecommentContext linecomment() throws RecognitionException {
		LinecommentContext _localctx = new LinecommentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_linecomment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(LINE_COMMENT_START);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(215);
					match(WS);
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(221);
				directive();
				}
				break;
			case 2:
				{
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(222);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==NL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(227);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BeginblockContext extends ParserRuleContext {
		public BeginstartContext beginstart() {
			return getRuleContext(BeginstartContext.class,0);
		}
		public BeginendContext beginend() {
			return getRuleContext(BeginendContext.class,0);
		}
		public DeclarestartContext declarestart() {
			return getRuleContext(DeclarestartContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BeginblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterBeginblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitBeginblock(this);
		}
	}

	public final BeginblockContext beginblock() throws RecognitionException {
		BeginblockContext _localctx = new BeginblockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_beginblock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECLARE) {
				{
				setState(230);
				declarestart();
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(231);
						statement();
						}
						} 
					}
					setState(236);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
			}

			setState(239);
			beginstart();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(240);
				statement();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			beginend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarestartContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(SqlscriptsParser.DECLARE, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public DeclarestartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarestart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterDeclarestart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitDeclarestart(this);
		}
	}

	public final DeclarestartContext declarestart() throws RecognitionException {
		DeclarestartContext _localctx = new DeclarestartContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(DECLARE);
			setState(250); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(249);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(252); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeginstartContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SqlscriptsParser.BEGIN, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public BeginstartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginstart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterBeginstart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitBeginstart(this);
		}
	}

	public final BeginstartContext beginstart() throws RecognitionException {
		BeginstartContext _localctx = new BeginstartContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_beginstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(BEGIN);
			setState(256); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(255);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeginendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public ExtraContext extra() {
			return getRuleContext(ExtraContext.class,0);
		}
		public BeginendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterBeginend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitBeginend(this);
		}
	}

	public final BeginendContext beginend() throws RecognitionException {
		BeginendContext _localctx = new BeginendContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_beginend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(END);
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(261);
				extra();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfblockContext extends ParserRuleContext {
		public IfstartContext ifstart() {
			return getRuleContext(IfstartContext.class,0);
		}
		public IfendContext ifend() {
			return getRuleContext(IfendContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterIfblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitIfblock(this);
		}
	}

	public final IfblockContext ifblock() throws RecognitionException {
		IfblockContext _localctx = new IfblockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			ifstart();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(265);
				statement();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
			ifend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstartContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SqlscriptsParser.IF, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public IfstartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterIfstart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitIfstart(this);
		}
	}

	public final IfstartContext ifstart() throws RecognitionException {
		IfstartContext _localctx = new IfstartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(IF);
			setState(275); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(274);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(277); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public TerminalNode IF() { return getToken(SqlscriptsParser.IF, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public IfendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterIfend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitIfend(this);
		}
	}

	public final IfendContext ifend() throws RecognitionException {
		IfendContext _localctx = new IfendContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(END);
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				match(WS);
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(285);
			match(IF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForblockContext extends ParserRuleContext {
		public ForstartContext forstart() {
			return getRuleContext(ForstartContext.class,0);
		}
		public ForendContext forend() {
			return getRuleContext(ForendContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterForblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitForblock(this);
		}
	}

	public final ForblockContext forblock() throws RecognitionException {
		ForblockContext _localctx = new ForblockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			forstart();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(288);
				statement();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			forend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForstartContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SqlscriptsParser.FOR, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public ForstartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterForstart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitForstart(this);
		}
	}

	public final ForstartContext forstart() throws RecognitionException {
		ForstartContext _localctx = new ForstartContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(FOR);
			setState(298); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(297);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(300); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public TerminalNode FOR() { return getToken(SqlscriptsParser.FOR, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public ForendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterForend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitForend(this);
		}
	}

	public final ForendContext forend() throws RecognitionException {
		ForendContext _localctx = new ForendContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_forend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(END);
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303);
				match(WS);
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(308);
			match(FOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileblockContext extends ParserRuleContext {
		public WhilestartContext whilestart() {
			return getRuleContext(WhilestartContext.class,0);
		}
		public WhileendContext whileend() {
			return getRuleContext(WhileendContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterWhileblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitWhileblock(this);
		}
	}

	public final WhileblockContext whileblock() throws RecognitionException {
		WhileblockContext _localctx = new WhileblockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			whilestart();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(311);
				statement();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			whileend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestartContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SqlscriptsParser.WHILE, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public WhilestartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterWhilestart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitWhilestart(this);
		}
	}

	public final WhilestartContext whilestart() throws RecognitionException {
		WhilestartContext _localctx = new WhilestartContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_whilestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(WHILE);
			setState(321); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(320);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(323); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public TerminalNode WHILE() { return getToken(SqlscriptsParser.WHILE, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public WhileendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterWhileend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitWhileend(this);
		}
	}

	public final WhileendContext whileend() throws RecognitionException {
		WhileendContext _localctx = new WhileendContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(END);
			setState(327); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(326);
				match(WS);
				}
				}
				setState(329); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(331);
			match(WHILE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopblockContext extends ParserRuleContext {
		public LoopstartContext loopstart() {
			return getRuleContext(LoopstartContext.class,0);
		}
		public LoopendContext loopend() {
			return getRuleContext(LoopendContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterLoopblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitLoopblock(this);
		}
	}

	public final LoopblockContext loopblock() throws RecognitionException {
		LoopblockContext _localctx = new LoopblockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_loopblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			loopstart();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(334);
				statement();
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(340);
			loopend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopstartContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(SqlscriptsParser.LOOP, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public LoopstartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopstart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterLoopstart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitLoopstart(this);
		}
	}

	public final LoopstartContext loopstart() throws RecognitionException {
		LoopstartContext _localctx = new LoopstartContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loopstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(LOOP);
			setState(344); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(343);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(346); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public TerminalNode LOOP() { return getToken(SqlscriptsParser.LOOP, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public LoopendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterLoopend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitLoopend(this);
		}
	}

	public final LoopendContext loopend() throws RecognitionException {
		LoopendContext _localctx = new LoopendContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_loopend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(END);
			setState(350); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(349);
				match(WS);
				}
				}
				setState(352); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(354);
			match(LOOP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtraContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public ExtraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterExtra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitExtra(this);
		}
	}

	public final ExtraContext extra() throws RecognitionException {
		ExtraContext _localctx = new ExtraContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_extra);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(357); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(356);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SemiContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(SqlscriptsParser.SEMI, 0); }
		public SemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterSemi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitSemi(this);
		}
	}

	public final SemiContext semi() throws RecognitionException {
		SemiContext _localctx = new SemiContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_semi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(SqlscriptsParser.WORD, 0); }
		public TerminalNode OBJECT() { return getToken(SqlscriptsParser.OBJECT, 0); }
		public TerminalNode COLUMN() { return getToken(SqlscriptsParser.COLUMN, 0); }
		public TerminalNode NOT() { return getToken(SqlscriptsParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlscriptsParser.EXISTS, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public TerminalNode COMMA() { return getToken(SqlscriptsParser.COMMA, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_text);
		try {
			int _alt;
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(WORD);
				}
				break;
			case OBJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(OBJECT);
				}
				break;
			case COLUMN:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				match(COLUMN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
				match(NOT);
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 5);
				{
				setState(367);
				match(EXISTS);
				}
				break;
			case WS:
				enterOuterAlt(_localctx, 6);
				{
				setState(369); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(368);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(371); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 7);
				{
				setState(373);
				match(COMMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EscapedcharContext extends ParserRuleContext {
		public TerminalNode ESC() { return getToken(SqlscriptsParser.ESC, 0); }
		public EscapedcharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapedchar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterEscapedchar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitEscapedchar(this);
		}
	}

	public final EscapedcharContext escapedchar() throws RecognitionException {
		EscapedcharContext _localctx = new EscapedcharContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_escapedchar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(ESC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SquotedContext squoted() {
			return getRuleContext(SquotedContext.class,0);
		}
		public DquotedContext dquoted() {
			return getRuleContext(DquotedContext.class,0);
		}
		public BquotedContext bquoted() {
			return getRuleContext(BquotedContext.class,0);
		}
		public ParamclauseContext paramclause() {
			return getRuleContext(ParamclauseContext.class,0);
		}
		public BeginblockContext beginblock() {
			return getRuleContext(BeginblockContext.class,0);
		}
		public IfblockContext ifblock() {
			return getRuleContext(IfblockContext.class,0);
		}
		public ForblockContext forblock() {
			return getRuleContext(ForblockContext.class,0);
		}
		public WhileblockContext whileblock() {
			return getRuleContext(WhileblockContext.class,0);
		}
		public LoopblockContext loopblock() {
			return getRuleContext(LoopblockContext.class,0);
		}
		public LinecommentContext linecomment() {
			return getRuleContext(LinecommentContext.class,0);
		}
		public BlockcommentContext blockcomment() {
			return getRuleContext(BlockcommentContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public ExtraContext extra() {
			return getRuleContext(ExtraContext.class,0);
		}
		public EscapedcharContext escapedchar() {
			return getRuleContext(EscapedcharContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_command);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				squoted();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				dquoted();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(381);
				bquoted();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(382);
				paramclause();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(383);
				beginblock();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(384);
				ifblock();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(385);
				forblock();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(386);
				whileblock();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(387);
				loopblock();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(388);
				linecomment();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(389);
				blockcomment();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(390);
				variable();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(391);
				alias();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(392);
				extra();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(393);
				variable();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(394);
				escapedchar();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CommandblockContext extends ParserRuleContext {
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ExtraContext extra() {
			return getRuleContext(ExtraContext.class,0);
		}
		public CommandblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterCommandblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitCommandblock(this);
		}
	}

	public final CommandblockContext commandblock() throws RecognitionException {
		CommandblockContext _localctx = new CommandblockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_commandblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 502775770L) != 0) {
				{
				setState(399);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(397);
					text();
					}
					break;
				case 2:
					{
					setState(398);
					command();
					}
					break;
				}
				}
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(404);
			semi();
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(405);
				extra();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LinecommentContext linecomment() {
			return getRuleContext(LinecommentContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockcommentContext blockcomment() {
			return getRuleContext(BlockcommentContext.class,0);
		}
		public ExtraContext extra() {
			return getRuleContext(ExtraContext.class,0);
		}
		public CommandblockContext commandblock() {
			return getRuleContext(CommandblockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_statement);
		try {
			int _alt;
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				linecomment();
				setState(415);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(409);
						match(NL);
						setState(411);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
						case 1:
							{
							setState(410);
							statement();
							}
							break;
						}
						}
						} 
					}
					setState(417);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				blockcomment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				extra();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(420);
				commandblock();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamclauseContext extends ParserRuleContext {
		public ParamclausestartContext paramclausestart() {
			return getRuleContext(ParamclausestartContext.class,0);
		}
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public ParamclauseendContext paramclauseend() {
			return getRuleContext(ParamclauseendContext.class,0);
		}
		public ParamclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterParamclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitParamclause(this);
		}
	}

	public final ParamclauseContext paramclause() throws RecognitionException {
		ParamclauseContext _localctx = new ParamclauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_paramclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			paramclausestart();
			setState(424);
			param_list();
			setState(425);
			paramclauseend();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamclausestartContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public ParamclausestartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramclausestart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterParamclausestart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitParamclausestart(this);
		}
	}

	public final ParamclausestartContext paramclausestart() throws RecognitionException {
		ParamclausestartContext _localctx = new ParamclausestartContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_paramclausestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(T__0);
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(428);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamclauseendContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public ParamclauseendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramclauseend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterParamclauseend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitParamclauseend(this);
		}
	}

	public final ParamclauseendContext paramclauseend() throws RecognitionException {
		ParamclauseendContext _localctx = new ParamclauseendContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_paramclauseend);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(T__1);
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(435);
					_la = _input.LA(1);
					if ( !(_la==WS || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(440);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Param_listContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterParam_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitParam_list(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 502775770L) != 0) {
				{
				setState(443);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(441);
					text();
					}
					break;
				case 2:
					{
					setState(442);
					command();
					}
					break;
				}
				}
				setState(447);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SqlscriptsParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 503300058L) != 0) {
				{
				{
				setState(448);
				statement();
				}
				}
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		"\u0004\u0001\u001c\u01c9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000R\b\u0000\n\u0000\f\u0000U\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000Z\b\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003e\b\u0003\n\u0003\f\u0003h\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004q\b\u0004\n\u0004\f\u0004t\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"|\b\u0005\n\u0005\f\u0005\u007f\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0085\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u008a\b\u0006\u0005\u0006\u008c\b\u0006\n\u0006\f\u0006"+
		"\u008f\t\u0006\u0001\u0007\u0005\u0007\u0092\b\u0007\n\u0007\f\u0007\u0095"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0099\b\u0007\n\u0007\f\u0007"+
		"\u009c\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\b\u00a2\b"+
		"\b\u000b\b\f\b\u00a3\u0001\b\u0001\b\u0004\b\u00a8\b\b\u000b\b\f\b\u00a9"+
		"\u0001\b\u0001\b\u0004\b\u00ae\b\b\u000b\b\f\b\u00af\u0003\b\u00b2\b\b"+
		"\u0001\b\u0001\b\u0004\b\u00b6\b\b\u000b\b\f\b\u00b7\u0001\b\u0001\b\u0005"+
		"\b\u00bc\b\b\n\b\f\b\u00bf\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t"+
		"\u00c5\b\t\n\t\f\t\u00c8\t\t\u0001\t\u0001\t\u0004\t\u00cc\b\t\u000b\t"+
		"\f\t\u00cd\u0001\t\u0001\t\u0005\t\u00d2\b\t\n\t\f\t\u00d5\t\t\u0001\n"+
		"\u0001\n\u0005\n\u00d9\b\n\n\n\f\n\u00dc\t\n\u0001\n\u0001\n\u0005\n\u00e0"+
		"\b\n\n\n\f\n\u00e3\t\n\u0003\n\u00e5\b\n\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00e9\b\u000b\n\u000b\f\u000b\u00ec\t\u000b\u0003\u000b\u00ee\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00f2\b\u000b\n\u000b\f\u000b"+
		"\u00f5\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f\u00fb\b"+
		"\f\u000b\f\f\f\u00fc\u0001\r\u0001\r\u0004\r\u0101\b\r\u000b\r\f\r\u0102"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0107\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u010b\b\u000f\n\u000f\f\u000f\u010e\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0004\u0010\u0114\b\u0010\u000b\u0010\f"+
		"\u0010\u0115\u0001\u0011\u0001\u0011\u0004\u0011\u011a\b\u0011\u000b\u0011"+
		"\f\u0011\u011b\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u0122\b\u0012\n\u0012\f\u0012\u0125\t\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0004\u0013\u012b\b\u0013\u000b\u0013\f\u0013\u012c"+
		"\u0001\u0014\u0001\u0014\u0004\u0014\u0131\b\u0014\u000b\u0014\f\u0014"+
		"\u0132\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0139"+
		"\b\u0015\n\u0015\f\u0015\u013c\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0004\u0016\u0142\b\u0016\u000b\u0016\f\u0016\u0143\u0001"+
		"\u0017\u0001\u0017\u0004\u0017\u0148\b\u0017\u000b\u0017\f\u0017\u0149"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u0150\b\u0018"+
		"\n\u0018\f\u0018\u0153\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0004\u0019\u0159\b\u0019\u000b\u0019\f\u0019\u015a\u0001\u001a"+
		"\u0001\u001a\u0004\u001a\u015f\b\u001a\u000b\u001a\f\u001a\u0160\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0004\u001b\u0166\b\u001b\u000b\u001b\f"+
		"\u001b\u0167\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0004\u001d\u0172\b\u001d\u000b\u001d"+
		"\f\u001d\u0173\u0001\u001d\u0003\u001d\u0177\b\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u018c\b\u001f\u0001 \u0001 \u0005 \u0190\b \n \f \u0193\t \u0001"+
		" \u0001 \u0003 \u0197\b \u0001!\u0001!\u0001!\u0003!\u019c\b!\u0005!\u019e"+
		"\b!\n!\f!\u01a1\t!\u0001!\u0001!\u0001!\u0003!\u01a6\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001#\u0001#\u0005#\u01ae\b#\n#\f#\u01b1\t#\u0001"+
		"$\u0001$\u0005$\u01b5\b$\n$\f$\u01b8\t$\u0001%\u0001%\u0005%\u01bc\b%"+
		"\n%\f%\u01bf\t%\u0001&\u0005&\u01c2\b&\n&\f&\u01c5\t&\u0001&\u0001&\u0001"+
		"&\u0000\u0000\'\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJL\u0000\u0007\u0001"+
		"\u0000\u0005\u0005\u0001\u0000\u0016\u0016\u0001\u0000\u0017\u0017\u0001"+
		"\u0000\u0018\u0018\u0001\u0000\n\u000b\u0001\u0000\u0007\u0007\u0001\u0000"+
		"\u0006\u0007\u01f6\u0000N\u0001\u0000\u0000\u0000\u0002[\u0001\u0000\u0000"+
		"\u0000\u0004]\u0001\u0000\u0000\u0000\u0006_\u0001\u0000\u0000\u0000\b"+
		"k\u0001\u0000\u0000\u0000\nw\u0001\u0000\u0000\u0000\f\u0084\u0001\u0000"+
		"\u0000\u0000\u000e\u0093\u0001\u0000\u0000\u0000\u0010\u009f\u0001\u0000"+
		"\u0000\u0000\u0012\u00c2\u0001\u0000\u0000\u0000\u0014\u00d6\u0001\u0000"+
		"\u0000\u0000\u0016\u00ed\u0001\u0000\u0000\u0000\u0018\u00f8\u0001\u0000"+
		"\u0000\u0000\u001a\u00fe\u0001\u0000\u0000\u0000\u001c\u0104\u0001\u0000"+
		"\u0000\u0000\u001e\u0108\u0001\u0000\u0000\u0000 \u0111\u0001\u0000\u0000"+
		"\u0000\"\u0117\u0001\u0000\u0000\u0000$\u011f\u0001\u0000\u0000\u0000"+
		"&\u0128\u0001\u0000\u0000\u0000(\u012e\u0001\u0000\u0000\u0000*\u0136"+
		"\u0001\u0000\u0000\u0000,\u013f\u0001\u0000\u0000\u0000.\u0145\u0001\u0000"+
		"\u0000\u00000\u014d\u0001\u0000\u0000\u00002\u0156\u0001\u0000\u0000\u0000"+
		"4\u015c\u0001\u0000\u0000\u00006\u0165\u0001\u0000\u0000\u00008\u0169"+
		"\u0001\u0000\u0000\u0000:\u0176\u0001\u0000\u0000\u0000<\u0178\u0001\u0000"+
		"\u0000\u0000>\u018b\u0001\u0000\u0000\u0000@\u0191\u0001\u0000\u0000\u0000"+
		"B\u01a5\u0001\u0000\u0000\u0000D\u01a7\u0001\u0000\u0000\u0000F\u01ab"+
		"\u0001\u0000\u0000\u0000H\u01b2\u0001\u0000\u0000\u0000J\u01bd\u0001\u0000"+
		"\u0000\u0000L\u01c3\u0001\u0000\u0000\u0000NO\u0005\u0004\u0000\u0000"+
		"OS\u0005\u0006\u0000\u0000PR\b\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000"+
		"RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\u0006"+
		"\u0000\u0000WY\u0005\u0005\u0000\u0000XZ\u0005\u0006\u0000\u0000YX\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0001\u0001\u0000\u0000"+
		"\u0000[\\\u0005\t\u0000\u0000\\\u0003\u0001\u0000\u0000\u0000]^\u0005"+
		"\b\u0000\u0000^\u0005\u0001\u0000\u0000\u0000_f\u0005\u0016\u0000\u0000"+
		"`e\u0003\u0002\u0001\u0000ae\u0003\u0004\u0002\u0000be\u0005\u001c\u0000"+
		"\u0000ce\b\u0001\u0000\u0000d`\u0001\u0000\u0000\u0000da\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0005\u0016\u0000\u0000"+
		"j\u0007\u0001\u0000\u0000\u0000kr\u0005\u0017\u0000\u0000lq\u0003\u0002"+
		"\u0001\u0000mq\u0003\u0004\u0002\u0000nq\u0005\u001c\u0000\u0000oq\b\u0002"+
		"\u0000\u0000pl\u0001\u0000\u0000\u0000pm\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u0017\u0000\u0000v\t\u0001\u0000"+
		"\u0000\u0000w}\u0005\u0018\u0000\u0000x|\u0003\u0002\u0001\u0000y|\u0003"+
		"\u0004\u0002\u0000z|\b\u0003\u0000\u0000{x\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0018"+
		"\u0000\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082\u0085\u0005\u001b"+
		"\u0000\u0000\u0083\u0085\u0003\u0002\u0001\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u008d\u0001\u0000"+
		"\u0000\u0000\u0086\u0089\u0005\u0019\u0000\u0000\u0087\u008a\u0005\u001b"+
		"\u0000\u0000\u0088\u008a\u0003\u0002\u0001\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000"+
		"\u0000\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\r\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u0090\u0092\u0005\u0006\u0000\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u009a\u0003\u0010\b\u0000"+
		"\u0097\u0099\u0003B!\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u0012\t\u0000\u009e\u000f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a1\u0005\u000f\u0000\u0000\u00a0\u00a2\u0005"+
		"\u0006\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007"+
		"\u0004\u0000\u0000\u00a6\u00a8\u0005\u0006\u0000\u0000\u00a7\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00b1\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ad\u0005\u0014\u0000\u0000\u00ac\u00ae\u0005"+
		"\u0006\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b5\u0005\u0015\u0000\u0000\u00b4\u00b6\u0005"+
		"\u0006\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bd\u0003"+
		"\f\u0006\u0000\u00ba\u00bc\u0005\u0006\u0000\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0007"+
		"\u0000\u0000\u00c1\u0011\u0001\u0000\u0000\u0000\u00c2\u00c6\u0005\u0003"+
		"\u0000\u0000\u00c3\u00c5\u0005\u0006\u0000\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005\u000e"+
		"\u0000\u0000\u00ca\u00cc\u0005\u0006\u0000\u0000\u00cb\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d3\u0005\u000f\u0000\u0000\u00d0\u00d2\u0005\u0006"+
		"\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u0013\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00da\u0005\u0003\u0000\u0000\u00d7\u00d9\u0005\u0006"+
		"\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000"+
		"\u0000\u0000\u00db\u00e4\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000"+
		"\u0000\u0000\u00dd\u00e5\u0003\u000e\u0007\u0000\u00de\u00e0\b\u0005\u0000"+
		"\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e4\u00dd\u0001\u0000\u0000\u0000\u00e4\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e5\u0015\u0001\u0000\u0000\u0000\u00e6\u00ea\u0003\u0018\f\u0000"+
		"\u00e7\u00e9\u0003B!\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ed\u00e6\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f3"+
		"\u0003\u001a\r\u0000\u00f0\u00f2\u0003B!\u0000\u00f1\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f7\u0003\u001c"+
		"\u000e\u0000\u00f7\u0017\u0001\u0000\u0000\u0000\u00f8\u00fa\u0005\f\u0000"+
		"\u0000\u00f9\u00fb\u0007\u0006\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0019\u0001\u0000\u0000"+
		"\u0000\u00fe\u0100\u0005\r\u0000\u0000\u00ff\u0101\u0007\u0006\u0000\u0000"+
		"\u0100\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000"+
		"\u0103\u001b\u0001\u0000\u0000\u0000\u0104\u0106\u0005\u000e\u0000\u0000"+
		"\u0105\u0107\u00036\u001b\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107\u001d\u0001\u0000\u0000\u0000\u0108"+
		"\u010c\u0003 \u0010\u0000\u0109\u010b\u0003B!\u0000\u010a\u0109\u0001"+
		"\u0000\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010f\u0001"+
		"\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0110\u0003"+
		"\"\u0011\u0000\u0110\u001f\u0001\u0000\u0000\u0000\u0111\u0113\u0005\u000f"+
		"\u0000\u0000\u0112\u0114\u0007\u0006\u0000\u0000\u0113\u0112\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116!\u0001\u0000\u0000"+
		"\u0000\u0117\u0119\u0005\u000e\u0000\u0000\u0118\u011a\u0005\u0006\u0000"+
		"\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u000f\u0000"+
		"\u0000\u011e#\u0001\u0000\u0000\u0000\u011f\u0123\u0003&\u0013\u0000\u0120"+
		"\u0122\u0003B!\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122\u0125\u0001"+
		"\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001"+
		"\u0000\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0123\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0003(\u0014\u0000\u0127%\u0001\u0000\u0000"+
		"\u0000\u0128\u012a\u0005\u0010\u0000\u0000\u0129\u012b\u0007\u0006\u0000"+
		"\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000"+
		"\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012d\'\u0001\u0000\u0000\u0000\u012e\u0130\u0005\u000e\u0000\u0000"+
		"\u012f\u0131\u0005\u0006\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0005\u0010\u0000\u0000\u0135)\u0001\u0000\u0000\u0000\u0136"+
		"\u013a\u0003,\u0016\u0000\u0137\u0139\u0003B!\u0000\u0138\u0137\u0001"+
		"\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013d\u0001"+
		"\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u013e\u0003"+
		".\u0017\u0000\u013e+\u0001\u0000\u0000\u0000\u013f\u0141\u0005\u0011\u0000"+
		"\u0000\u0140\u0142\u0007\u0006\u0000\u0000\u0141\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144-\u0001\u0000\u0000\u0000"+
		"\u0145\u0147\u0005\u000e\u0000\u0000\u0146\u0148\u0005\u0006\u0000\u0000"+
		"\u0147\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000"+
		"\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0005\u0011\u0000\u0000"+
		"\u014c/\u0001\u0000\u0000\u0000\u014d\u0151\u00032\u0019\u0000\u014e\u0150"+
		"\u0003B!\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000"+
		"\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000"+
		"\u0000\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0154\u0155\u00034\u001a\u0000\u01551\u0001\u0000\u0000\u0000"+
		"\u0156\u0158\u0005\u0012\u0000\u0000\u0157\u0159\u0007\u0006\u0000\u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b3\u0001\u0000\u0000\u0000\u015c\u015e\u0005\u000e\u0000\u0000\u015d"+
		"\u015f\u0005\u0006\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0005\u0012\u0000\u0000\u01635\u0001\u0000\u0000\u0000\u0164\u0166"+
		"\u0007\u0006\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168"+
		"\u0001\u0000\u0000\u0000\u01687\u0001\u0000\u0000\u0000\u0169\u016a\u0005"+
		"\u0013\u0000\u0000\u016a9\u0001\u0000\u0000\u0000\u016b\u0177\u0005\u001b"+
		"\u0000\u0000\u016c\u0177\u0005\n\u0000\u0000\u016d\u0177\u0005\u000b\u0000"+
		"\u0000\u016e\u0177\u0005\u0014\u0000\u0000\u016f\u0177\u0005\u0015\u0000"+
		"\u0000\u0170\u0172\u0005\u0006\u0000\u0000\u0171\u0170\u0001\u0000\u0000"+
		"\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000"+
		"\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000"+
		"\u0000\u0175\u0177\u0005\u001a\u0000\u0000\u0176\u016b\u0001\u0000\u0000"+
		"\u0000\u0176\u016c\u0001\u0000\u0000\u0000\u0176\u016d\u0001\u0000\u0000"+
		"\u0000\u0176\u016e\u0001\u0000\u0000\u0000\u0176\u016f\u0001\u0000\u0000"+
		"\u0000\u0176\u0171\u0001\u0000\u0000\u0000\u0176\u0175\u0001\u0000\u0000"+
		"\u0000\u0177;\u0001\u0000\u0000\u0000\u0178\u0179\u0005\u001c\u0000\u0000"+
		"\u0179=\u0001\u0000\u0000\u0000\u017a\u018c\u0003\f\u0006\u0000\u017b"+
		"\u018c\u0003\u0006\u0003\u0000\u017c\u018c\u0003\b\u0004\u0000\u017d\u018c"+
		"\u0003\n\u0005\u0000\u017e\u018c\u0003D\"\u0000\u017f\u018c\u0003\u0016"+
		"\u000b\u0000\u0180\u018c\u0003\u001e\u000f\u0000\u0181\u018c\u0003$\u0012"+
		"\u0000\u0182\u018c\u0003*\u0015\u0000\u0183\u018c\u00030\u0018\u0000\u0184"+
		"\u018c\u0003\u0014\n\u0000\u0185\u018c\u0003\u0000\u0000\u0000\u0186\u018c"+
		"\u0003\u0004\u0002\u0000\u0187\u018c\u0003\u0002\u0001\u0000\u0188\u018c"+
		"\u00036\u001b\u0000\u0189\u018c\u0003\u0004\u0002\u0000\u018a\u018c\u0003"+
		"<\u001e\u0000\u018b\u017a\u0001\u0000\u0000\u0000\u018b\u017b\u0001\u0000"+
		"\u0000\u0000\u018b\u017c\u0001\u0000\u0000\u0000\u018b\u017d\u0001\u0000"+
		"\u0000\u0000\u018b\u017e\u0001\u0000\u0000\u0000\u018b\u017f\u0001\u0000"+
		"\u0000\u0000\u018b\u0180\u0001\u0000\u0000\u0000\u018b\u0181\u0001\u0000"+
		"\u0000\u0000\u018b\u0182\u0001\u0000\u0000\u0000\u018b\u0183\u0001\u0000"+
		"\u0000\u0000\u018b\u0184\u0001\u0000\u0000\u0000\u018b\u0185\u0001\u0000"+
		"\u0000\u0000\u018b\u0186\u0001\u0000\u0000\u0000\u018b\u0187\u0001\u0000"+
		"\u0000\u0000\u018b\u0188\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018c?\u0001\u0000\u0000"+
		"\u0000\u018d\u0190\u0003:\u001d\u0000\u018e\u0190\u0003>\u001f\u0000\u018f"+
		"\u018d\u0001\u0000\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u0190"+
		"\u0193\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191"+
		"\u0192\u0001\u0000\u0000\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193"+
		"\u0191\u0001\u0000\u0000\u0000\u0194\u0196\u00038\u001c\u0000\u0195\u0197"+
		"\u00036\u001b\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0196\u0197\u0001"+
		"\u0000\u0000\u0000\u0197A\u0001\u0000\u0000\u0000\u0198\u019f\u0003\u0014"+
		"\n\u0000\u0199\u019b\u0005\u0007\u0000\u0000\u019a\u019c\u0003B!\u0000"+
		"\u019b\u019a\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000"+
		"\u019c\u019e\u0001\u0000\u0000\u0000\u019d\u0199\u0001\u0000\u0000\u0000"+
		"\u019e\u01a1\u0001\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000"+
		"\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a1\u019f\u0001\u0000\u0000\u0000\u01a2\u01a6\u0003\u0000\u0000\u0000"+
		"\u01a3\u01a6\u00036\u001b\u0000\u01a4\u01a6\u0003@ \u0000\u01a5\u0198"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6C\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a8\u0003F#\u0000\u01a8\u01a9\u0003J%\u0000"+
		"\u01a9\u01aa\u0003H$\u0000\u01aaE\u0001\u0000\u0000\u0000\u01ab\u01af"+
		"\u0005\u0001\u0000\u0000\u01ac\u01ae\u0007\u0006\u0000\u0000\u01ad\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0G\u0001"+
		"\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b6\u0005"+
		"\u0002\u0000\u0000\u01b3\u01b5\u0007\u0006\u0000\u0000\u01b4\u01b3\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7I\u0001\u0000"+
		"\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b9\u01bc\u0003:\u001d"+
		"\u0000\u01ba\u01bc\u0003>\u001f\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000"+
		"\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000"+
		"\u01beK\u0001\u0000\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c2\u0003B!\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c2\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c6\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\u0005\u0000\u0000\u0001\u01c7M\u0001\u0000"+
		"\u0000\u0000:SYdfpr{}\u0084\u0089\u008d\u0093\u009a\u00a3\u00a9\u00af"+
		"\u00b1\u00b7\u00bd\u00c6\u00cd\u00d3\u00da\u00e1\u00e4\u00ea\u00ed\u00f3"+
		"\u00fc\u0102\u0106\u010c\u0115\u011b\u0123\u012c\u0132\u013a\u0143\u0149"+
		"\u0151\u015a\u0160\u0167\u0173\u0176\u018b\u018f\u0191\u0196\u019b\u019f"+
		"\u01a5\u01af\u01b6\u01bb\u01bd\u01c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}