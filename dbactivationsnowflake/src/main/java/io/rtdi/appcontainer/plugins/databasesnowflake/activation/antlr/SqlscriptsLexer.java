// Generated from java-escape by ANTLR 4.11.1
package io.rtdi.appcontainer.plugins.databasesnowflake.activation.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SqlscriptsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LINE_COMMENT_START=3, BLOCK_COMMENT_START=4, BLOCK_COMMENT_END=5, 
		WS=6, NL=7, VARIABLE=8, ALIAS=9, OBJECT=10, COLUMN=11, DECLARE=12, BEGIN=13, 
		END=14, IF=15, FOR=16, WHILE=17, LOOP=18, SEMI=19, NOT=20, EXISTS=21, 
		SQ=22, DQ=23, BQ=24, DOT=25, COMMA=26, DD=27, WORD=28, ESC=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "LINE_COMMENT_START", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END", 
			"WS", "NL", "VARIABLE", "ALIAS", "OBJECT", "COLUMN", "DECLARE", "BEGIN", 
			"END", "IF", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", "SQ", "DQ", 
			"BQ", "DOT", "COMMA", "DD", "WORD", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'//'", "'/*'", "'*/'", null, null, null, null, "'OBJECT'", 
			"'COLUMN'", "'DECLARE'", "'BEGIN'", "'END'", "'IF'", "'FOR'", "'WHILE'", 
			"'LOOP'", "';'", "'NOT'", "'EXISTS'", "'''", "'\"'", "'`'", "'.'", "','", 
			"'$$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LINE_COMMENT_START", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END", 
			"WS", "NL", "VARIABLE", "ALIAS", "OBJECT", "COLUMN", "DECLARE", "BEGIN", 
			"END", "IF", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", "SQ", "DQ", 
			"BQ", "DOT", "COMMA", "DD", "WORD", "ESC"
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


	public SqlscriptsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sqlscripts.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u00ba\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0004\u0005J\b\u0005\u000b\u0005\f\u0005K\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006Q\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007V\b\u0007\n\u0007\f\u0007Y\t\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b`\b\b\n\b\f\bc\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0004\u001b\u00b4\b\u001b\u000b\u001b\f\u001b\u00b5\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d\u0001\u0000\u0019\u0003\u0000\t\t\f\r  \u0002\u0000AZa"+
		"z\u0004\u000009AZ__az\u0002\u0000OOoo\u0002\u0000BBbb\u0002\u0000JJjj"+
		"\u0002\u0000EEee\u0002\u0000CCcc\u0002\u0000TTtt\u0002\u0000LLll\u0002"+
		"\u0000UUuu\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000DDdd\u0002\u0000"+
		"AAaa\u0002\u0000RRrr\u0002\u0000GGgg\u0002\u0000IIii\u0002\u0000FFff\u0002"+
		"\u0000WWww\u0002\u0000HHhh\u0002\u0000PPpp\u0002\u0000XXxx\u0002\u0000"+
		"SSss\u000b\u0000!!#&*+--/:<[]]__a{}}\u0080\u8000\uffff\u00be\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0003=\u0001\u0000\u0000"+
		"\u0000\u0005?\u0001\u0000\u0000\u0000\u0007B\u0001\u0000\u0000\u0000\t"+
		"E\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rP\u0001\u0000"+
		"\u0000\u0000\u000fR\u0001\u0000\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000"+
		"\u0013f\u0001\u0000\u0000\u0000\u0015m\u0001\u0000\u0000\u0000\u0017t"+
		"\u0001\u0000\u0000\u0000\u0019|\u0001\u0000\u0000\u0000\u001b\u0082\u0001"+
		"\u0000\u0000\u0000\u001d\u0086\u0001\u0000\u0000\u0000\u001f\u0089\u0001"+
		"\u0000\u0000\u0000!\u008d\u0001\u0000\u0000\u0000#\u0093\u0001\u0000\u0000"+
		"\u0000%\u0098\u0001\u0000\u0000\u0000\'\u009a\u0001\u0000\u0000\u0000"+
		")\u009e\u0001\u0000\u0000\u0000+\u00a5\u0001\u0000\u0000\u0000-\u00a7"+
		"\u0001\u0000\u0000\u0000/\u00a9\u0001\u0000\u0000\u00001\u00ab\u0001\u0000"+
		"\u0000\u00003\u00ad\u0001\u0000\u0000\u00005\u00af\u0001\u0000\u0000\u0000"+
		"7\u00b3\u0001\u0000\u0000\u00009\u00b7\u0001\u0000\u0000\u0000;<\u0005"+
		"(\u0000\u0000<\u0002\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\u0004"+
		"\u0001\u0000\u0000\u0000?@\u0005/\u0000\u0000@A\u0005/\u0000\u0000A\u0006"+
		"\u0001\u0000\u0000\u0000BC\u0005/\u0000\u0000CD\u0005*\u0000\u0000D\b"+
		"\u0001\u0000\u0000\u0000EF\u0005*\u0000\u0000FG\u0005/\u0000\u0000G\n"+
		"\u0001\u0000\u0000\u0000HJ\u0007\u0000\u0000\u0000IH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005\r\u0000\u0000NQ\u0005"+
		"\n\u0000\u0000OQ\u0005\n\u0000\u0000PM\u0001\u0000\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000Q\u000e\u0001\u0000\u0000\u0000RS\u0005&\u0000\u0000"+
		"SW\u0007\u0001\u0000\u0000TV\u0007\u0002\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000X\u0010\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"Z[\u0005$\u0000\u0000[\\\u0005{\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]a\u0007\u0001\u0000\u0000^`\u0007\u0002\u0000\u0000_^\u0001\u0000\u0000"+
		"\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005"+
		"}\u0000\u0000e\u0012\u0001\u0000\u0000\u0000fg\u0007\u0003\u0000\u0000"+
		"gh\u0007\u0004\u0000\u0000hi\u0007\u0005\u0000\u0000ij\u0007\u0006\u0000"+
		"\u0000jk\u0007\u0007\u0000\u0000kl\u0007\b\u0000\u0000l\u0014\u0001\u0000"+
		"\u0000\u0000mn\u0007\u0007\u0000\u0000no\u0007\u0003\u0000\u0000op\u0007"+
		"\t\u0000\u0000pq\u0007\n\u0000\u0000qr\u0007\u000b\u0000\u0000rs\u0007"+
		"\f\u0000\u0000s\u0016\u0001\u0000\u0000\u0000tu\u0007\r\u0000\u0000uv"+
		"\u0007\u0006\u0000\u0000vw\u0007\u0007\u0000\u0000wx\u0007\t\u0000\u0000"+
		"xy\u0007\u000e\u0000\u0000yz\u0007\u000f\u0000\u0000z{\u0007\u0006\u0000"+
		"\u0000{\u0018\u0001\u0000\u0000\u0000|}\u0007\u0004\u0000\u0000}~\u0007"+
		"\u0006\u0000\u0000~\u007f\u0007\u0010\u0000\u0000\u007f\u0080\u0007\u0011"+
		"\u0000\u0000\u0080\u0081\u0007\f\u0000\u0000\u0081\u001a\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0007\u0006\u0000\u0000\u0083\u0084\u0007\f\u0000\u0000"+
		"\u0084\u0085\u0007\r\u0000\u0000\u0085\u001c\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0007\u0011\u0000\u0000\u0087\u0088\u0007\u0012\u0000\u0000\u0088"+
		"\u001e\u0001\u0000\u0000\u0000\u0089\u008a\u0007\u0012\u0000\u0000\u008a"+
		"\u008b\u0007\u0003\u0000\u0000\u008b\u008c\u0007\u000f\u0000\u0000\u008c"+
		" \u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0013\u0000\u0000\u008e\u008f"+
		"\u0007\u0014\u0000\u0000\u008f\u0090\u0007\u0011\u0000\u0000\u0090\u0091"+
		"\u0007\t\u0000\u0000\u0091\u0092\u0007\u0006\u0000\u0000\u0092\"\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0007\t\u0000\u0000\u0094\u0095\u0007\u0003"+
		"\u0000\u0000\u0095\u0096\u0007\u0003\u0000\u0000\u0096\u0097\u0007\u0015"+
		"\u0000\u0000\u0097$\u0001\u0000\u0000\u0000\u0098\u0099\u0005;\u0000\u0000"+
		"\u0099&\u0001\u0000\u0000\u0000\u009a\u009b\u0007\f\u0000\u0000\u009b"+
		"\u009c\u0007\u0003\u0000\u0000\u009c\u009d\u0007\b\u0000\u0000\u009d("+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0006\u0000\u0000\u009f\u00a0"+
		"\u0007\u0016\u0000\u0000\u00a0\u00a1\u0007\u0011\u0000\u0000\u00a1\u00a2"+
		"\u0007\u0017\u0000\u0000\u00a2\u00a3\u0007\b\u0000\u0000\u00a3\u00a4\u0007"+
		"\u0017\u0000\u0000\u00a4*\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\'"+
		"\u0000\u0000\u00a6,\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\"\u0000"+
		"\u0000\u00a8.\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005`\u0000\u0000\u00aa"+
		"0\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005.\u0000\u0000\u00ac2\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0005,\u0000\u0000\u00ae4\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005$\u0000\u0000\u00b0\u00b1\u0005$\u0000\u0000\u00b1"+
		"6\u0001\u0000\u0000\u0000\u00b2\u00b4\u0007\u0018\u0000\u0000\u00b3\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b68\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0005\\\u0000\u0000\u00b8\u00b9\t\u0000"+
		"\u0000\u0000\u00b9:\u0001\u0000\u0000\u0000\u0007\u0000KPWa\u00b3\u00b5"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}