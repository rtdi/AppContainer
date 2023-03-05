// Generated from java-escape by ANTLR 4.11.1
package io.rtdi.appcontainer.plugins.databasehana.activation.antlr;
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
		SQ=22, DQ=23, BQ=24, DOT=25, COMMA=26, WORD=27, ESC=28;
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
			"BQ", "DOT", "COMMA", "WORD", "ESC"
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
		"\u0004\u0000\u001c\u00b5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005H\b\u0005"+
		"\u000b\u0005\f\u0005I\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"O\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007T\b\u0007\n\u0007"+
		"\f\u0007W\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b^\b\b"+
		"\n\b\f\ba\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0004\u001a\u00af\b\u001a\u000b\u001a"+
		"\f\u001a\u00b0\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0000\u001c\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0019\u0003\u0000\t\t\f"+
		"\r  \u0002\u0000AZaz\u0004\u000009AZ__az\u0002\u0000OOoo\u0002\u0000B"+
		"Bbb\u0002\u0000JJjj\u0002\u0000EEee\u0002\u0000CCcc\u0002\u0000TTtt\u0002"+
		"\u0000LLll\u0002\u0000UUuu\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000"+
		"DDdd\u0002\u0000AAaa\u0002\u0000RRrr\u0002\u0000GGgg\u0002\u0000IIii\u0002"+
		"\u0000FFff\u0002\u0000WWww\u0002\u0000HHhh\u0002\u0000PPpp\u0002\u0000"+
		"XXxx\u0002\u0000SSss\u000b\u0000!!#&*+--/:<[]]__a{}}\u0080\u8000\uffff"+
		"\u00b9\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000"+
		"\u0005=\u0001\u0000\u0000\u0000\u0007@\u0001\u0000\u0000\u0000\tC\u0001"+
		"\u0000\u0000\u0000\u000bG\u0001\u0000\u0000\u0000\rN\u0001\u0000\u0000"+
		"\u0000\u000fP\u0001\u0000\u0000\u0000\u0011X\u0001\u0000\u0000\u0000\u0013"+
		"d\u0001\u0000\u0000\u0000\u0015k\u0001\u0000\u0000\u0000\u0017r\u0001"+
		"\u0000\u0000\u0000\u0019z\u0001\u0000\u0000\u0000\u001b\u0080\u0001\u0000"+
		"\u0000\u0000\u001d\u0084\u0001\u0000\u0000\u0000\u001f\u0087\u0001\u0000"+
		"\u0000\u0000!\u008b\u0001\u0000\u0000\u0000#\u0091\u0001\u0000\u0000\u0000"+
		"%\u0096\u0001\u0000\u0000\u0000\'\u0098\u0001\u0000\u0000\u0000)\u009c"+
		"\u0001\u0000\u0000\u0000+\u00a3\u0001\u0000\u0000\u0000-\u00a5\u0001\u0000"+
		"\u0000\u0000/\u00a7\u0001\u0000\u0000\u00001\u00a9\u0001\u0000\u0000\u0000"+
		"3\u00ab\u0001\u0000\u0000\u00005\u00ae\u0001\u0000\u0000\u00007\u00b2"+
		"\u0001\u0000\u0000\u00009:\u0005(\u0000\u0000:\u0002\u0001\u0000\u0000"+
		"\u0000;<\u0005)\u0000\u0000<\u0004\u0001\u0000\u0000\u0000=>\u0005/\u0000"+
		"\u0000>?\u0005/\u0000\u0000?\u0006\u0001\u0000\u0000\u0000@A\u0005/\u0000"+
		"\u0000AB\u0005*\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005*\u0000"+
		"\u0000DE\u0005/\u0000\u0000E\n\u0001\u0000\u0000\u0000FH\u0007\u0000\u0000"+
		"\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000J\f\u0001\u0000\u0000\u0000KL\u0005"+
		"\r\u0000\u0000LO\u0005\n\u0000\u0000MO\u0005\n\u0000\u0000NK\u0001\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000O\u000e\u0001\u0000\u0000\u0000"+
		"PQ\u0005&\u0000\u0000QU\u0007\u0001\u0000\u0000RT\u0007\u0002\u0000\u0000"+
		"SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000V\u0010\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000XY\u0005$\u0000\u0000YZ\u0005{\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[_\u0007\u0001\u0000\u0000\\^\u0007\u0002\u0000\u0000]\\\u0001"+
		"\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000bc\u0005}\u0000\u0000c\u0012\u0001\u0000\u0000\u0000de\u0007\u0003"+
		"\u0000\u0000ef\u0007\u0004\u0000\u0000fg\u0007\u0005\u0000\u0000gh\u0007"+
		"\u0006\u0000\u0000hi\u0007\u0007\u0000\u0000ij\u0007\b\u0000\u0000j\u0014"+
		"\u0001\u0000\u0000\u0000kl\u0007\u0007\u0000\u0000lm\u0007\u0003\u0000"+
		"\u0000mn\u0007\t\u0000\u0000no\u0007\n\u0000\u0000op\u0007\u000b\u0000"+
		"\u0000pq\u0007\f\u0000\u0000q\u0016\u0001\u0000\u0000\u0000rs\u0007\r"+
		"\u0000\u0000st\u0007\u0006\u0000\u0000tu\u0007\u0007\u0000\u0000uv\u0007"+
		"\t\u0000\u0000vw\u0007\u000e\u0000\u0000wx\u0007\u000f\u0000\u0000xy\u0007"+
		"\u0006\u0000\u0000y\u0018\u0001\u0000\u0000\u0000z{\u0007\u0004\u0000"+
		"\u0000{|\u0007\u0006\u0000\u0000|}\u0007\u0010\u0000\u0000}~\u0007\u0011"+
		"\u0000\u0000~\u007f\u0007\f\u0000\u0000\u007f\u001a\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0007\u0006\u0000\u0000\u0081\u0082\u0007\f\u0000\u0000"+
		"\u0082\u0083\u0007\r\u0000\u0000\u0083\u001c\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0007\u0011\u0000\u0000\u0085\u0086\u0007\u0012\u0000\u0000\u0086"+
		"\u001e\u0001\u0000\u0000\u0000\u0087\u0088\u0007\u0012\u0000\u0000\u0088"+
		"\u0089\u0007\u0003\u0000\u0000\u0089\u008a\u0007\u000f\u0000\u0000\u008a"+
		" \u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0013\u0000\u0000\u008c\u008d"+
		"\u0007\u0014\u0000\u0000\u008d\u008e\u0007\u0011\u0000\u0000\u008e\u008f"+
		"\u0007\t\u0000\u0000\u008f\u0090\u0007\u0006\u0000\u0000\u0090\"\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0007\t\u0000\u0000\u0092\u0093\u0007\u0003"+
		"\u0000\u0000\u0093\u0094\u0007\u0003\u0000\u0000\u0094\u0095\u0007\u0015"+
		"\u0000\u0000\u0095$\u0001\u0000\u0000\u0000\u0096\u0097\u0005;\u0000\u0000"+
		"\u0097&\u0001\u0000\u0000\u0000\u0098\u0099\u0007\f\u0000\u0000\u0099"+
		"\u009a\u0007\u0003\u0000\u0000\u009a\u009b\u0007\b\u0000\u0000\u009b("+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0006\u0000\u0000\u009d\u009e"+
		"\u0007\u0016\u0000\u0000\u009e\u009f\u0007\u0011\u0000\u0000\u009f\u00a0"+
		"\u0007\u0017\u0000\u0000\u00a0\u00a1\u0007\b\u0000\u0000\u00a1\u00a2\u0007"+
		"\u0017\u0000\u0000\u00a2*\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\'"+
		"\u0000\u0000\u00a4,\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\"\u0000"+
		"\u0000\u00a6.\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005`\u0000\u0000\u00a8"+
		"0\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005.\u0000\u0000\u00aa2\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0005,\u0000\u0000\u00ac4\u0001\u0000\u0000"+
		"\u0000\u00ad\u00af\u0007\u0018\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b16\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\\\u0000\u0000\u00b3\u00b4\t\u0000\u0000\u0000\u00b4"+
		"8\u0001\u0000\u0000\u0000\u0007\u0000INU_\u00ae\u00b0\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}