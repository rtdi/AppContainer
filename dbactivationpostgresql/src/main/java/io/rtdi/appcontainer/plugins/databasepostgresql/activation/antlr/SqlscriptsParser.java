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
		END=14, IF=15, CASE=16, FOR=17, WHILE=18, LOOP=19, SEMI=20, NOT=21, EXISTS=22, 
		SQ=23, DQ=24, BQ=25, DOT=26, COMMA=27, WORD=28, ESC=29;
	public static final int
		RULE_blockcomment = 0, RULE_alias = 1, RULE_variable = 2, RULE_squoted = 3, 
		RULE_dquoted = 4, RULE_bquoted = 5, RULE_identifier = 6, RULE_directive = 7, 
		RULE_directivecondition = 8, RULE_directiveend = 9, RULE_linecomment = 10, 
		RULE_beginblock = 11, RULE_declarestart = 12, RULE_beginstart = 13, RULE_beginend = 14, 
		RULE_ifblock = 15, RULE_ifstart = 16, RULE_ifend = 17, RULE_caseblock = 18, 
		RULE_casestart = 19, RULE_caseend = 20, RULE_forblock = 21, RULE_forstart = 22, 
		RULE_forend = 23, RULE_whileblock = 24, RULE_whilestart = 25, RULE_whileend = 26, 
		RULE_loopblock = 27, RULE_loopstart = 28, RULE_loopend = 29, RULE_extra = 30, 
		RULE_semi = 31, RULE_text = 32, RULE_escapedchar = 33, RULE_command = 34, 
		RULE_commandblock = 35, RULE_statement = 36, RULE_inlinestatement = 37, 
		RULE_paramclause = 38, RULE_paramclausestart = 39, RULE_paramclauseend = 40, 
		RULE_param_list = 41, RULE_script = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"blockcomment", "alias", "variable", "squoted", "dquoted", "bquoted", 
			"identifier", "directive", "directivecondition", "directiveend", "linecomment", 
			"beginblock", "declarestart", "beginstart", "beginend", "ifblock", "ifstart", 
			"ifend", "caseblock", "casestart", "caseend", "forblock", "forstart", 
			"forend", "whileblock", "whilestart", "whileend", "loopblock", "loopstart", 
			"loopend", "extra", "semi", "text", "escapedchar", "command", "commandblock", 
			"statement", "inlinestatement", "paramclause", "paramclausestart", "paramclauseend", 
			"param_list", "script"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'//'", "'/*'", "'*/'", null, null, null, null, "'OBJECT'", 
			"'COLUMN'", "'DECLARE'", "'BEGIN'", "'END'", "'IF'", "'CASE'", "'FOR'", 
			"'WHILE'", "'LOOP'", "';'", "'NOT'", "'EXISTS'", "'''", "'\"'", "'`'", 
			"'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LINE_COMMENT_START", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END", 
			"WS", "NL", "VARIABLE", "ALIAS", "OBJECT", "COLUMN", "DECLARE", "BEGIN", 
			"END", "IF", "CASE", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", 
			"SQ", "DQ", "BQ", "DOT", "COMMA", "WORD", "ESC"
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
			setState(86);
			match(BLOCK_COMMENT_START);
			setState(87);
			match(WS);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
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
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(94);
			match(WS);
			setState(95);
			match(BLOCK_COMMENT_END);
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(96);
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
			setState(99);
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
			setState(101);
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
			setState(103);
			match(SQ);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065353214L) != 0) {
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(104);
					alias();
					}
					break;
				case 2:
					{
					setState(105);
					variable();
					}
					break;
				case 3:
					{
					setState(106);
					match(ESC);
					}
					break;
				case 4:
					{
					setState(107);
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
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
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
			setState(115);
			match(DQ);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1056964606L) != 0) {
				{
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(116);
					alias();
					}
					break;
				case 2:
					{
					setState(117);
					variable();
					}
					break;
				case 3:
					{
					setState(118);
					match(ESC);
					}
					break;
				case 4:
					{
					setState(119);
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
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
			setState(127);
			match(BQ);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1040187390L) != 0) {
				{
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(128);
					alias();
					}
					break;
				case 2:
					{
					setState(129);
					variable();
					}
					break;
				case 3:
					{
					setState(130);
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
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				{
				setState(138);
				match(WORD);
				}
				break;
			case ALIAS:
				{
				setState(139);
				alias();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(142);
				match(DOT);
				setState(145);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WORD:
					{
					setState(143);
					match(WORD);
					}
					break;
				case ALIAS:
					{
					setState(144);
					alias();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(151);
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
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(152);
				match(WS);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			directivecondition();
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					statement();
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(165);
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
			setState(167);
			match(IF);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				match(WS);
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(173);
			_la = _input.LA(1);
			if ( !(_la==OBJECT || _la==COLUMN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				match(WS);
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(179);
				match(NOT);
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
				}
			}

			setState(187);
			match(EXISTS);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				match(WS);
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(193);
			identifier();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(194);
				match(WS);
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
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
			setState(202);
			match(LINE_COMMENT_START);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(203);
				match(WS);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(END);
			setState(211); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(210);
				match(WS);
				}
				}
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(215);
			match(IF);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(216);
					match(WS);
					}
					} 
				}
				setState(221);
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
			setState(222);
			match(LINE_COMMENT_START);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					match(WS);
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(229);
				directive();
				}
				break;
			case 2:
				{
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(230);
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
					setState(235);
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
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECLARE) {
				{
				setState(238);
				declarestart();
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(239);
						statement();
						}
						} 
					}
					setState(244);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
			}

			setState(247);
			beginstart();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(248);
				statement();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
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
			setState(256);
			match(DECLARE);
			setState(258); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(257);
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
				setState(260); 
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
			setState(262);
			match(BEGIN);
			setState(264); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(263);
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
				setState(266); 
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
			setState(268);
			match(END);
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(269);
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
			setState(272);
			ifstart();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(273);
				statement();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
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
			setState(281);
			match(IF);
			setState(283); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(282);
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
				setState(285); 
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
			setState(287);
			match(END);
			setState(289); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(288);
				match(WS);
				}
				}
				setState(291); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(293);
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
	public static class CaseblockContext extends ParserRuleContext {
		public CasestartContext casestart() {
			return getRuleContext(CasestartContext.class,0);
		}
		public CaseendContext caseend() {
			return getRuleContext(CaseendContext.class,0);
		}
		public List<InlinestatementContext> inlinestatement() {
			return getRuleContexts(InlinestatementContext.class);
		}
		public InlinestatementContext inlinestatement(int i) {
			return getRuleContext(InlinestatementContext.class,i);
		}
		public CaseblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterCaseblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitCaseblock(this);
		}
	}

	public final CaseblockContext caseblock() throws RecognitionException {
		CaseblockContext _localctx = new CaseblockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_caseblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			casestart();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 865055706L) != 0) {
				{
				{
				setState(296);
				inlinestatement();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			caseend();
			}
		}
		catch (RecognitionException re) {
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
	public static class CasestartContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(SqlscriptsParser.CASE, 0); }
		public List<TerminalNode> NL() { return getTokens(SqlscriptsParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(SqlscriptsParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public CasestartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casestart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterCasestart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitCasestart(this);
		}
	}

	public final CasestartContext casestart() throws RecognitionException {
		CasestartContext _localctx = new CasestartContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_casestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(CASE);
			setState(306); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(305);
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
				setState(308); 
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
	public static class CaseendContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlscriptsParser.END, 0); }
		public List<TerminalNode> WS() { return getTokens(SqlscriptsParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(SqlscriptsParser.WS, i);
		}
		public CaseendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterCaseend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitCaseend(this);
		}
	}

	public final CaseendContext caseend() throws RecognitionException {
		CaseendContext _localctx = new CaseendContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_caseend);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(END);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					match(WS);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 42, RULE_forblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			forstart();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(318);
				statement();
				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
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
		enterRule(_localctx, 44, RULE_forstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(FOR);
			setState(328); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(327);
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
				setState(330); 
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
		enterRule(_localctx, 46, RULE_forend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(END);
			setState(334); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(333);
				match(WS);
				}
				}
				setState(336); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(338);
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
		enterRule(_localctx, 48, RULE_whileblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			whilestart();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(341);
				statement();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347);
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
		enterRule(_localctx, 50, RULE_whilestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(WHILE);
			setState(351); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(350);
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
				setState(353); 
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
		enterRule(_localctx, 52, RULE_whileend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(END);
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356);
				match(WS);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(361);
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
		enterRule(_localctx, 54, RULE_loopblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			loopstart();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(364);
				statement();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
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
		enterRule(_localctx, 56, RULE_loopstart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(LOOP);
			setState(374); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(373);
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
				setState(376); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		enterRule(_localctx, 58, RULE_loopend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(END);
			setState(380); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(379);
				match(WS);
				}
				}
				setState(382); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(384);
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
		enterRule(_localctx, 60, RULE_extra);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(387); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(386);
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
				setState(389); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 62, RULE_semi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
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
		enterRule(_localctx, 64, RULE_text);
		try {
			int _alt;
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				match(WORD);
				}
				break;
			case OBJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				match(OBJECT);
				}
				break;
			case COLUMN:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				match(COLUMN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(396);
				match(NOT);
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 5);
				{
				setState(397);
				match(EXISTS);
				}
				break;
			case WS:
				enterOuterAlt(_localctx, 6);
				{
				setState(399); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(398);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(401); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 7);
				{
				setState(403);
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
		enterRule(_localctx, 66, RULE_escapedchar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
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
		public CaseblockContext caseblock() {
			return getRuleContext(CaseblockContext.class,0);
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
		enterRule(_localctx, 68, RULE_command);
		try {
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				squoted();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(410);
				dquoted();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(411);
				bquoted();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(412);
				paramclause();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(413);
				beginblock();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(414);
				ifblock();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(415);
				caseblock();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(416);
				forblock();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(417);
				whileblock();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(418);
				loopblock();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(419);
				linecomment();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(420);
				blockcomment();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(421);
				variable();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(422);
				alias();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(423);
				extra();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(424);
				variable();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(425);
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
		enterRule(_localctx, 70, RULE_commandblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1005567962L) != 0) {
				{
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(428);
					text();
					}
					break;
				case 2:
					{
					setState(429);
					command();
					}
					break;
				}
				}
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(435);
			semi();
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(436);
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
		enterRule(_localctx, 72, RULE_statement);
		try {
			int _alt;
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				linecomment();
				setState(446);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(440);
						match(NL);
						setState(442);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
						case 1:
							{
							setState(441);
							statement();
							}
							break;
						}
						}
						} 
					}
					setState(448);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				blockcomment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				extra();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
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
	public static class InlinestatementContext extends ParserRuleContext {
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
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public InlinestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlinestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).enterInlinestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlscriptsListener ) ((SqlscriptsListener)listener).exitInlinestatement(this);
		}
	}

	public final InlinestatementContext inlinestatement() throws RecognitionException {
		InlinestatementContext _localctx = new InlinestatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_inlinestatement);
		try {
			int _alt;
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				linecomment();
				setState(461);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(455);
						match(NL);
						setState(457);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
						case 1:
							{
							setState(456);
							statement();
							}
							break;
						}
						}
						} 
					}
					setState(463);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				blockcomment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(465);
				extra();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(466);
				command();
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
		enterRule(_localctx, 76, RULE_paramclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			paramclausestart();
			setState(470);
			param_list();
			setState(471);
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
		enterRule(_localctx, 78, RULE_paramclausestart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(T__0);
			setState(477);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(474);
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
				setState(479);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
		enterRule(_localctx, 80, RULE_paramclauseend);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(T__1);
			setState(484);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(481);
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
				setState(486);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
		enterRule(_localctx, 82, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1005567962L) != 0) {
				{
				setState(489);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(487);
					text();
					}
					break;
				case 2:
					{
					setState(488);
					command();
					}
					break;
				}
				}
				setState(493);
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
		enterRule(_localctx, 84, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006616538L) != 0) {
				{
				{
				setState(494);
				statement();
				}
				}
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(500);
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
		"\u0004\u0001\u001d\u01f7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000Z\b\u0000\n\u0000\f\u0000]\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000b\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003m\b\u0003\n\u0003\f\u0003p\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004y\b\u0004\n\u0004\f\u0004|\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0084\b\u0005\n"+
		"\u0005\f\u0005\u0087\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u008d\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u0092\b\u0006\u0005\u0006\u0094\b\u0006\n\u0006\f\u0006\u0097\t"+
		"\u0006\u0001\u0007\u0005\u0007\u009a\b\u0007\n\u0007\f\u0007\u009d\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00a1\b\u0007\n\u0007\f\u0007\u00a4"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\b\u00aa\b\b\u000b"+
		"\b\f\b\u00ab\u0001\b\u0001\b\u0004\b\u00b0\b\b\u000b\b\f\b\u00b1\u0001"+
		"\b\u0001\b\u0004\b\u00b6\b\b\u000b\b\f\b\u00b7\u0003\b\u00ba\b\b\u0001"+
		"\b\u0001\b\u0004\b\u00be\b\b\u000b\b\f\b\u00bf\u0001\b\u0001\b\u0005\b"+
		"\u00c4\b\b\n\b\f\b\u00c7\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u00cd"+
		"\b\t\n\t\f\t\u00d0\t\t\u0001\t\u0001\t\u0004\t\u00d4\b\t\u000b\t\f\t\u00d5"+
		"\u0001\t\u0001\t\u0005\t\u00da\b\t\n\t\f\t\u00dd\t\t\u0001\n\u0001\n\u0005"+
		"\n\u00e1\b\n\n\n\f\n\u00e4\t\n\u0001\n\u0001\n\u0005\n\u00e8\b\n\n\n\f"+
		"\n\u00eb\t\n\u0003\n\u00ed\b\n\u0001\u000b\u0001\u000b\u0005\u000b\u00f1"+
		"\b\u000b\n\u000b\f\u000b\u00f4\t\u000b\u0003\u000b\u00f6\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00fa\b\u000b\n\u000b\f\u000b\u00fd\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f\u0103\b\f\u000b\f\f\f"+
		"\u0104\u0001\r\u0001\r\u0004\r\u0109\b\r\u000b\r\f\r\u010a\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u010f\b\u000e\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0113\b\u000f\n\u000f\f\u000f\u0116\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0004\u0010\u011c\b\u0010\u000b\u0010\f\u0010\u011d"+
		"\u0001\u0011\u0001\u0011\u0004\u0011\u0122\b\u0011\u000b\u0011\f\u0011"+
		"\u0123\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u012a"+
		"\b\u0012\n\u0012\f\u0012\u012d\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0004\u0013\u0133\b\u0013\u000b\u0013\f\u0013\u0134\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u0139\b\u0014\n\u0014\f\u0014\u013c\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u0140\b\u0015\n\u0015\f\u0015\u0143"+
		"\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0004\u0016\u0149"+
		"\b\u0016\u000b\u0016\f\u0016\u014a\u0001\u0017\u0001\u0017\u0004\u0017"+
		"\u014f\b\u0017\u000b\u0017\f\u0017\u0150\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u0157\b\u0018\n\u0018\f\u0018\u015a\t\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0004\u0019\u0160\b\u0019"+
		"\u000b\u0019\f\u0019\u0161\u0001\u001a\u0001\u001a\u0004\u001a\u0166\b"+
		"\u001a\u000b\u001a\f\u001a\u0167\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u016e\b\u001b\n\u001b\f\u001b\u0171\t\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0004\u001c\u0177\b\u001c\u000b\u001c"+
		"\f\u001c\u0178\u0001\u001d\u0001\u001d\u0004\u001d\u017d\b\u001d\u000b"+
		"\u001d\f\u001d\u017e\u0001\u001d\u0001\u001d\u0001\u001e\u0004\u001e\u0184"+
		"\b\u001e\u000b\u001e\f\u001e\u0185\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0004 \u0190\b \u000b \f \u0191\u0001 \u0003"+
		" \u0195\b \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0003\"\u01ab\b\"\u0001#\u0001#\u0005#\u01af"+
		"\b#\n#\f#\u01b2\t#\u0001#\u0001#\u0003#\u01b6\b#\u0001$\u0001$\u0001$"+
		"\u0003$\u01bb\b$\u0005$\u01bd\b$\n$\f$\u01c0\t$\u0001$\u0001$\u0001$\u0003"+
		"$\u01c5\b$\u0001%\u0001%\u0001%\u0003%\u01ca\b%\u0005%\u01cc\b%\n%\f%"+
		"\u01cf\t%\u0001%\u0001%\u0001%\u0003%\u01d4\b%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001\'\u0001\'\u0005\'\u01dc\b\'\n\'\f\'\u01df\t\'\u0001(\u0001(\u0005"+
		"(\u01e3\b(\n(\f(\u01e6\t(\u0001)\u0001)\u0005)\u01ea\b)\n)\f)\u01ed\t"+
		")\u0001*\u0005*\u01f0\b*\n*\f*\u01f3\t*\u0001*\u0001*\u0001*\u0000\u0000"+
		"+\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRT\u0000\u0007\u0001\u0000\u0005"+
		"\u0005\u0001\u0000\u0017\u0017\u0001\u0000\u0018\u0018\u0001\u0000\u0019"+
		"\u0019\u0001\u0000\n\u000b\u0001\u0000\u0007\u0007\u0001\u0000\u0006\u0007"+
		"\u0229\u0000V\u0001\u0000\u0000\u0000\u0002c\u0001\u0000\u0000\u0000\u0004"+
		"e\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000\bs\u0001\u0000"+
		"\u0000\u0000\n\u007f\u0001\u0000\u0000\u0000\f\u008c\u0001\u0000\u0000"+
		"\u0000\u000e\u009b\u0001\u0000\u0000\u0000\u0010\u00a7\u0001\u0000\u0000"+
		"\u0000\u0012\u00ca\u0001\u0000\u0000\u0000\u0014\u00de\u0001\u0000\u0000"+
		"\u0000\u0016\u00f5\u0001\u0000\u0000\u0000\u0018\u0100\u0001\u0000\u0000"+
		"\u0000\u001a\u0106\u0001\u0000\u0000\u0000\u001c\u010c\u0001\u0000\u0000"+
		"\u0000\u001e\u0110\u0001\u0000\u0000\u0000 \u0119\u0001\u0000\u0000\u0000"+
		"\"\u011f\u0001\u0000\u0000\u0000$\u0127\u0001\u0000\u0000\u0000&\u0130"+
		"\u0001\u0000\u0000\u0000(\u0136\u0001\u0000\u0000\u0000*\u013d\u0001\u0000"+
		"\u0000\u0000,\u0146\u0001\u0000\u0000\u0000.\u014c\u0001\u0000\u0000\u0000"+
		"0\u0154\u0001\u0000\u0000\u00002\u015d\u0001\u0000\u0000\u00004\u0163"+
		"\u0001\u0000\u0000\u00006\u016b\u0001\u0000\u0000\u00008\u0174\u0001\u0000"+
		"\u0000\u0000:\u017a\u0001\u0000\u0000\u0000<\u0183\u0001\u0000\u0000\u0000"+
		">\u0187\u0001\u0000\u0000\u0000@\u0194\u0001\u0000\u0000\u0000B\u0196"+
		"\u0001\u0000\u0000\u0000D\u01aa\u0001\u0000\u0000\u0000F\u01b0\u0001\u0000"+
		"\u0000\u0000H\u01c4\u0001\u0000\u0000\u0000J\u01d3\u0001\u0000\u0000\u0000"+
		"L\u01d5\u0001\u0000\u0000\u0000N\u01d9\u0001\u0000\u0000\u0000P\u01e0"+
		"\u0001\u0000\u0000\u0000R\u01eb\u0001\u0000\u0000\u0000T\u01f1\u0001\u0000"+
		"\u0000\u0000VW\u0005\u0004\u0000\u0000W[\u0005\u0006\u0000\u0000XZ\b\u0000"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000^_\u0005\u0006\u0000\u0000_a\u0005\u0005\u0000"+
		"\u0000`b\u0005\u0006\u0000\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000b\u0001\u0001\u0000\u0000\u0000cd\u0005\t\u0000\u0000d\u0003"+
		"\u0001\u0000\u0000\u0000ef\u0005\b\u0000\u0000f\u0005\u0001\u0000\u0000"+
		"\u0000gn\u0005\u0017\u0000\u0000hm\u0003\u0002\u0001\u0000im\u0003\u0004"+
		"\u0002\u0000jm\u0005\u001d\u0000\u0000km\b\u0001\u0000\u0000lh\u0001\u0000"+
		"\u0000\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lk\u0001"+
		"\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000qr\u0005\u0017\u0000\u0000r\u0007\u0001\u0000\u0000\u0000sz\u0005"+
		"\u0018\u0000\u0000ty\u0003\u0002\u0001\u0000uy\u0003\u0004\u0002\u0000"+
		"vy\u0005\u001d\u0000\u0000wy\b\u0002\u0000\u0000xt\u0001\u0000\u0000\u0000"+
		"xu\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005"+
		"\u0018\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f\u0085\u0005\u0019"+
		"\u0000\u0000\u0080\u0084\u0003\u0002\u0001\u0000\u0081\u0084\u0003\u0004"+
		"\u0002\u0000\u0082\u0084\b\u0003\u0000\u0000\u0083\u0080\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0019\u0000"+
		"\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u008d\u0005\u001c\u0000"+
		"\u0000\u008b\u008d\u0003\u0002\u0001\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0095\u0001\u0000\u0000"+
		"\u0000\u008e\u0091\u0005\u001a\u0000\u0000\u008f\u0092\u0005\u001c\u0000"+
		"\u0000\u0090\u0092\u0003\u0002\u0001\u0000\u0091\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000"+
		"\u0000\u0093\u008e\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\r\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0098\u009a\u0005\u0006\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a2\u0003\u0010\b\u0000\u009f"+
		"\u00a1\u0003H$\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0003\u0012\t\u0000\u00a6\u000f\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a9\u0005\u000f\u0000\u0000\u00a8\u00aa\u0005\u0006"+
		"\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0007\u0004"+
		"\u0000\u0000\u00ae\u00b0\u0005\u0006\u0000\u0000\u00af\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\u0005\u0015\u0000\u0000\u00b4\u00b6\u0005\u0006"+
		"\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bd\u0005\u0016\u0000\u0000\u00bc\u00be\u0005\u0006"+
		"\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c5\u0003\f\u0006"+
		"\u0000\u00c2\u00c4\u0005\u0006\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0007\u0000"+
		"\u0000\u00c9\u0011\u0001\u0000\u0000\u0000\u00ca\u00ce\u0005\u0003\u0000"+
		"\u0000\u00cb\u00cd\u0005\u0006\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u000e\u0000"+
		"\u0000\u00d2\u00d4\u0005\u0006\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7\u00db\u0005\u000f\u0000\u0000\u00d8\u00da\u0005\u0006\u0000"+
		"\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000"+
		"\u0000\u00dc\u0013\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00de\u00e2\u0005\u0003\u0000\u0000\u00df\u00e1\u0005\u0006\u0000"+
		"\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e3\u00ec\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e5\u00ed\u0003\u000e\u0007\u0000\u00e6\u00e8\b\u0005\u0000\u0000"+
		"\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000"+
		"\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ec\u00e5\u0001\u0000\u0000\u0000\u00ec\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ed\u0015\u0001\u0000\u0000\u0000\u00ee\u00f2\u0003\u0018\f\u0000\u00ef"+
		"\u00f1\u0003H$\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f5\u00ee\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fb\u0003"+
		"\u001a\r\u0000\u00f8\u00fa\u0003H$\u0000\u00f9\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0003\u001c\u000e"+
		"\u0000\u00ff\u0017\u0001\u0000\u0000\u0000\u0100\u0102\u0005\f\u0000\u0000"+
		"\u0101\u0103\u0007\u0006\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0019\u0001\u0000\u0000\u0000"+
		"\u0106\u0108\u0005\r\u0000\u0000\u0107\u0109\u0007\u0006\u0000\u0000\u0108"+
		"\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a"+
		"\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u001b\u0001\u0000\u0000\u0000\u010c\u010e\u0005\u000e\u0000\u0000\u010d"+
		"\u010f\u0003<\u001e\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e\u010f"+
		"\u0001\u0000\u0000\u0000\u010f\u001d\u0001\u0000\u0000\u0000\u0110\u0114"+
		"\u0003 \u0010\u0000\u0111\u0113\u0003H$\u0000\u0112\u0111\u0001\u0000"+
		"\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0117\u0001\u0000"+
		"\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u0118\u0003\"\u0011"+
		"\u0000\u0118\u001f\u0001\u0000\u0000\u0000\u0119\u011b\u0005\u000f\u0000"+
		"\u0000\u011a\u011c\u0007\u0006\u0000\u0000\u011b\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e!\u0001\u0000\u0000\u0000"+
		"\u011f\u0121\u0005\u000e\u0000\u0000\u0120\u0122\u0005\u0006\u0000\u0000"+
		"\u0121\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000"+
		"\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0005\u000f\u0000\u0000"+
		"\u0126#\u0001\u0000\u0000\u0000\u0127\u012b\u0003&\u0013\u0000\u0128\u012a"+
		"\u0003J%\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012e\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0003(\u0014\u0000\u012f%\u0001\u0000\u0000\u0000"+
		"\u0130\u0132\u0005\u0010\u0000\u0000\u0131\u0133\u0007\u0006\u0000\u0000"+
		"\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000"+
		"\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000"+
		"\u0135\'\u0001\u0000\u0000\u0000\u0136\u013a\u0005\u000e\u0000\u0000\u0137"+
		"\u0139\u0005\u0006\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0139"+
		"\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0001\u0000\u0000\u0000\u013b)\u0001\u0000\u0000\u0000\u013c\u013a"+
		"\u0001\u0000\u0000\u0000\u013d\u0141\u0003,\u0016\u0000\u013e\u0140\u0003"+
		"H$\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000"+
		"\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000"+
		"\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0003.\u0017\u0000\u0145+\u0001\u0000\u0000\u0000\u0146"+
		"\u0148\u0005\u0011\u0000\u0000\u0147\u0149\u0007\u0006\u0000\u0000\u0148"+
		"\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a"+
		"\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b"+
		"-\u0001\u0000\u0000\u0000\u014c\u014e\u0005\u000e\u0000\u0000\u014d\u014f"+
		"\u0005\u0006\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0150"+
		"\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0005\u0011\u0000\u0000\u0153/\u0001\u0000\u0000\u0000\u0154\u0158\u0003"+
		"2\u0019\u0000\u0155\u0157\u0003H$\u0000\u0156\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000"+
		"\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015b\u0001\u0000\u0000"+
		"\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u015c\u00034\u001a\u0000"+
		"\u015c1\u0001\u0000\u0000\u0000\u015d\u015f\u0005\u0012\u0000\u0000\u015e"+
		"\u0160\u0007\u0006\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u0001\u0000\u0000\u0000\u01623\u0001\u0000\u0000\u0000\u0163\u0165"+
		"\u0005\u000e\u0000\u0000\u0164\u0166\u0005\u0006\u0000\u0000\u0165\u0164"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0165"+
		"\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0001\u0000\u0000\u0000\u0169\u016a\u0005\u0012\u0000\u0000\u016a5\u0001"+
		"\u0000\u0000\u0000\u016b\u016f\u00038\u001c\u0000\u016c\u016e\u0003H$"+
		"\u0000\u016d\u016c\u0001\u0000\u0000\u0000\u016e\u0171\u0001\u0000\u0000"+
		"\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000"+
		"\u0000\u0170\u0172\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000"+
		"\u0000\u0172\u0173\u0003:\u001d\u0000\u01737\u0001\u0000\u0000\u0000\u0174"+
		"\u0176\u0005\u0013\u0000\u0000\u0175\u0177\u0007\u0006\u0000\u0000\u0176"+
		"\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178"+
		"\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179"+
		"9\u0001\u0000\u0000\u0000\u017a\u017c\u0005\u000e\u0000\u0000\u017b\u017d"+
		"\u0005\u0006\u0000\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017d\u017e"+
		"\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e\u017f"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0181"+
		"\u0005\u0013\u0000\u0000\u0181;\u0001\u0000\u0000\u0000\u0182\u0184\u0007"+
		"\u0006\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001"+
		"\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001"+
		"\u0000\u0000\u0000\u0186=\u0001\u0000\u0000\u0000\u0187\u0188\u0005\u0014"+
		"\u0000\u0000\u0188?\u0001\u0000\u0000\u0000\u0189\u0195\u0005\u001c\u0000"+
		"\u0000\u018a\u0195\u0005\n\u0000\u0000\u018b\u0195\u0005\u000b\u0000\u0000"+
		"\u018c\u0195\u0005\u0015\u0000\u0000\u018d\u0195\u0005\u0016\u0000\u0000"+
		"\u018e\u0190\u0005\u0006\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000"+
		"\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000"+
		"\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000"+
		"\u0193\u0195\u0005\u001b\u0000\u0000\u0194\u0189\u0001\u0000\u0000\u0000"+
		"\u0194\u018a\u0001\u0000\u0000\u0000\u0194\u018b\u0001\u0000\u0000\u0000"+
		"\u0194\u018c\u0001\u0000\u0000\u0000\u0194\u018d\u0001\u0000\u0000\u0000"+
		"\u0194\u018f\u0001\u0000\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000"+
		"\u0195A\u0001\u0000\u0000\u0000\u0196\u0197\u0005\u001d\u0000\u0000\u0197"+
		"C\u0001\u0000\u0000\u0000\u0198\u01ab\u0003\f\u0006\u0000\u0199\u01ab"+
		"\u0003\u0006\u0003\u0000\u019a\u01ab\u0003\b\u0004\u0000\u019b\u01ab\u0003"+
		"\n\u0005\u0000\u019c\u01ab\u0003L&\u0000\u019d\u01ab\u0003\u0016\u000b"+
		"\u0000\u019e\u01ab\u0003\u001e\u000f\u0000\u019f\u01ab\u0003$\u0012\u0000"+
		"\u01a0\u01ab\u0003*\u0015\u0000\u01a1\u01ab\u00030\u0018\u0000\u01a2\u01ab"+
		"\u00036\u001b\u0000\u01a3\u01ab\u0003\u0014\n\u0000\u01a4\u01ab\u0003"+
		"\u0000\u0000\u0000\u01a5\u01ab\u0003\u0004\u0002\u0000\u01a6\u01ab\u0003"+
		"\u0002\u0001\u0000\u01a7\u01ab\u0003<\u001e\u0000\u01a8\u01ab\u0003\u0004"+
		"\u0002\u0000\u01a9\u01ab\u0003B!\u0000\u01aa\u0198\u0001\u0000\u0000\u0000"+
		"\u01aa\u0199\u0001\u0000\u0000\u0000\u01aa\u019a\u0001\u0000\u0000\u0000"+
		"\u01aa\u019b\u0001\u0000\u0000\u0000\u01aa\u019c\u0001\u0000\u0000\u0000"+
		"\u01aa\u019d\u0001\u0000\u0000\u0000\u01aa\u019e\u0001\u0000\u0000\u0000"+
		"\u01aa\u019f\u0001\u0000\u0000\u0000\u01aa\u01a0\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a1\u0001\u0000\u0000\u0000\u01aa\u01a2\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a3\u0001\u0000\u0000\u0000\u01aa\u01a4\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a5\u0001\u0000\u0000\u0000\u01aa\u01a6\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a7\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a9\u0001\u0000\u0000\u0000\u01abE\u0001\u0000\u0000\u0000\u01ac"+
		"\u01af\u0003@ \u0000\u01ad\u01af\u0003D\"\u0000\u01ae\u01ac\u0001\u0000"+
		"\u0000\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b3\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b5\u0003>\u001f\u0000\u01b4\u01b6\u0003<\u001e\u0000"+
		"\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6G\u0001\u0000\u0000\u0000\u01b7\u01be\u0003\u0014\n\u0000\u01b8"+
		"\u01ba\u0005\u0007\u0000\u0000\u01b9\u01bb\u0003H$\u0000\u01ba\u01b9\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01bd\u0001"+
		"\u0000\u0000\u0000\u01bc\u01b8\u0001\u0000\u0000\u0000\u01bd\u01c0\u0001"+
		"\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c5\u0001\u0000\u0000\u0000\u01c0\u01be\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c5\u0003\u0000\u0000\u0000\u01c2\u01c5\u0003"+
		"<\u001e\u0000\u01c3\u01c5\u0003F#\u0000\u01c4\u01b7\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c1\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c3\u0001\u0000\u0000\u0000\u01c5I\u0001\u0000\u0000\u0000"+
		"\u01c6\u01cd\u0003\u0014\n\u0000\u01c7\u01c9\u0005\u0007\u0000\u0000\u01c8"+
		"\u01ca\u0003H$\u0000\u01c9\u01c8\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001"+
		"\u0000\u0000\u0000\u01ca\u01cc\u0001\u0000\u0000\u0000\u01cb\u01c7\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001"+
		"\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01d4\u0001"+
		"\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d4\u0003"+
		"\u0000\u0000\u0000\u01d1\u01d4\u0003<\u001e\u0000\u01d2\u01d4\u0003D\""+
		"\u0000\u01d3\u01c6\u0001\u0000\u0000\u0000\u01d3\u01d0\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d4K\u0001\u0000\u0000\u0000\u01d5\u01d6\u0003N\'\u0000\u01d6"+
		"\u01d7\u0003R)\u0000\u01d7\u01d8\u0003P(\u0000\u01d8M\u0001\u0000\u0000"+
		"\u0000\u01d9\u01dd\u0005\u0001\u0000\u0000\u01da\u01dc\u0007\u0006\u0000"+
		"\u0000\u01db\u01da\u0001\u0000\u0000\u0000\u01dc\u01df\u0001\u0000\u0000"+
		"\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000"+
		"\u0000\u01deO\u0001\u0000\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e4\u0005\u0002\u0000\u0000\u01e1\u01e3\u0007\u0006\u0000\u0000"+
		"\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e5Q\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7"+
		"\u01ea\u0003@ \u0000\u01e8\u01ea\u0003D\"\u0000\u01e9\u01e7\u0001\u0000"+
		"\u0000\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000\u01ea\u01ed\u0001\u0000"+
		"\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ecS\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000"+
		"\u0000\u01ee\u01f0\u0003H$\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f3\u0001\u0000\u0000\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1"+
		"\u01f2\u0001\u0000\u0000\u0000\u01f2\u01f4\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f5\u0005\u0000\u0000\u0001\u01f5"+
		"U\u0001\u0000\u0000\u0000@[alnxz\u0083\u0085\u008c\u0091\u0095\u009b\u00a2"+
		"\u00ab\u00b1\u00b7\u00b9\u00bf\u00c5\u00ce\u00d5\u00db\u00e2\u00e9\u00ec"+
		"\u00f2\u00f5\u00fb\u0104\u010a\u010e\u0114\u011d\u0123\u012b\u0134\u013a"+
		"\u0141\u014a\u0150\u0158\u0161\u0167\u016f\u0178\u017e\u0185\u0191\u0194"+
		"\u01aa\u01ae\u01b0\u01b5\u01ba\u01be\u01c4\u01c9\u01cd\u01d3\u01dd\u01e4"+
		"\u01e9\u01eb\u01f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}