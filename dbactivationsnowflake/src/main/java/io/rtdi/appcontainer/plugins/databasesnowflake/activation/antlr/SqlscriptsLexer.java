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
		END=14, IF=15, CASE=16, FOR=17, WHILE=18, LOOP=19, SEMI=20, NOT=21, EXISTS=22, 
		SQ=23, DQ=24, BQ=25, DOT=26, COMMA=27, DD=28, WORD=29, ESC=30;
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
			"END", "IF", "CASE", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", 
			"SQ", "DQ", "BQ", "DOT", "COMMA", "DD", "WORD", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'//'", "'/*'", "'*/'", null, null, null, null, "'OBJECT'", 
			"'COLUMN'", "'DECLARE'", "'BEGIN'", "'END'", "'IF'", "'CASE'", "'FOR'", 
			"'WHILE'", "'LOOP'", "';'", "'NOT'", "'EXISTS'", "'''", "'\"'", "'`'", 
			"'.'", "','", "'$$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LINE_COMMENT_START", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END", 
			"WS", "NL", "VARIABLE", "ALIAS", "OBJECT", "COLUMN", "DECLARE", "BEGIN", 
			"END", "IF", "CASE", "FOR", "WHILE", "LOOP", "SEMI", "NOT", "EXISTS", 
			"SQ", "DQ", "BQ", "DOT", "COMMA", "DD", "WORD", "ESC"
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
		"\u0004\u0000\u001e\u00c1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0004\u0005L\b\u0005\u000b\u0005\f\u0005M\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007X\b\u0007\n\u0007\f\u0007[\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bb\b\b\n\b\f\be\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0004\u001c\u00bb\b\u001c\u000b\u001c\f\u001c"+
		"\u00bc\u0001\u001d\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001\u0000\u0019\u0003\u0000"+
		"\t\t\f\r  \u0002\u0000AZaz\u0004\u000009AZ__az\u0002\u0000OOoo\u0002\u0000"+
		"BBbb\u0002\u0000JJjj\u0002\u0000EEee\u0002\u0000CCcc\u0002\u0000TTtt\u0002"+
		"\u0000LLll\u0002\u0000UUuu\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000"+
		"DDdd\u0002\u0000AAaa\u0002\u0000RRrr\u0002\u0000GGgg\u0002\u0000IIii\u0002"+
		"\u0000FFff\u0002\u0000SSss\u0002\u0000WWww\u0002\u0000HHhh\u0002\u0000"+
		"PPpp\u0002\u0000XXxx\n\u0000!!#&*+--/:<[]]__a}\u0080\u8000\uffff\u00c5"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0001="+
		"\u0001\u0000\u0000\u0000\u0003?\u0001\u0000\u0000\u0000\u0005A\u0001\u0000"+
		"\u0000\u0000\u0007D\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000"+
		"\u000bK\u0001\u0000\u0000\u0000\rR\u0001\u0000\u0000\u0000\u000fT\u0001"+
		"\u0000\u0000\u0000\u0011\\\u0001\u0000\u0000\u0000\u0013h\u0001\u0000"+
		"\u0000\u0000\u0015o\u0001\u0000\u0000\u0000\u0017v\u0001\u0000\u0000\u0000"+
		"\u0019~\u0001\u0000\u0000\u0000\u001b\u0084\u0001\u0000\u0000\u0000\u001d"+
		"\u0088\u0001\u0000\u0000\u0000\u001f\u008b\u0001\u0000\u0000\u0000!\u0090"+
		"\u0001\u0000\u0000\u0000#\u0094\u0001\u0000\u0000\u0000%\u009a\u0001\u0000"+
		"\u0000\u0000\'\u009f\u0001\u0000\u0000\u0000)\u00a1\u0001\u0000\u0000"+
		"\u0000+\u00a5\u0001\u0000\u0000\u0000-\u00ac\u0001\u0000\u0000\u0000/"+
		"\u00ae\u0001\u0000\u0000\u00001\u00b0\u0001\u0000\u0000\u00003\u00b2\u0001"+
		"\u0000\u0000\u00005\u00b4\u0001\u0000\u0000\u00007\u00b6\u0001\u0000\u0000"+
		"\u00009\u00ba\u0001\u0000\u0000\u0000;\u00be\u0001\u0000\u0000\u0000="+
		">\u0005(\u0000\u0000>\u0002\u0001\u0000\u0000\u0000?@\u0005)\u0000\u0000"+
		"@\u0004\u0001\u0000\u0000\u0000AB\u0005/\u0000\u0000BC\u0005/\u0000\u0000"+
		"C\u0006\u0001\u0000\u0000\u0000DE\u0005/\u0000\u0000EF\u0005*\u0000\u0000"+
		"F\b\u0001\u0000\u0000\u0000GH\u0005*\u0000\u0000HI\u0005/\u0000\u0000"+
		"I\n\u0001\u0000\u0000\u0000JL\u0007\u0000\u0000\u0000KJ\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000N\f\u0001\u0000\u0000\u0000OP\u0005\r\u0000\u0000PS\u0005"+
		"\n\u0000\u0000QS\u0005\n\u0000\u0000RO\u0001\u0000\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000S\u000e\u0001\u0000\u0000\u0000TU\u0005&\u0000\u0000"+
		"UY\u0007\u0001\u0000\u0000VX\u0007\u0002\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z\u0010\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\]\u0005$\u0000\u0000]^\u0005{\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_c\u0007\u0001\u0000\u0000`b\u0007\u0002\u0000\u0000a`\u0001\u0000\u0000"+
		"\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005"+
		"}\u0000\u0000g\u0012\u0001\u0000\u0000\u0000hi\u0007\u0003\u0000\u0000"+
		"ij\u0007\u0004\u0000\u0000jk\u0007\u0005\u0000\u0000kl\u0007\u0006\u0000"+
		"\u0000lm\u0007\u0007\u0000\u0000mn\u0007\b\u0000\u0000n\u0014\u0001\u0000"+
		"\u0000\u0000op\u0007\u0007\u0000\u0000pq\u0007\u0003\u0000\u0000qr\u0007"+
		"\t\u0000\u0000rs\u0007\n\u0000\u0000st\u0007\u000b\u0000\u0000tu\u0007"+
		"\f\u0000\u0000u\u0016\u0001\u0000\u0000\u0000vw\u0007\r\u0000\u0000wx"+
		"\u0007\u0006\u0000\u0000xy\u0007\u0007\u0000\u0000yz\u0007\t\u0000\u0000"+
		"z{\u0007\u000e\u0000\u0000{|\u0007\u000f\u0000\u0000|}\u0007\u0006\u0000"+
		"\u0000}\u0018\u0001\u0000\u0000\u0000~\u007f\u0007\u0004\u0000\u0000\u007f"+
		"\u0080\u0007\u0006\u0000\u0000\u0080\u0081\u0007\u0010\u0000\u0000\u0081"+
		"\u0082\u0007\u0011\u0000\u0000\u0082\u0083\u0007\f\u0000\u0000\u0083\u001a"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0006\u0000\u0000\u0085\u0086"+
		"\u0007\f\u0000\u0000\u0086\u0087\u0007\r\u0000\u0000\u0087\u001c\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0007\u0011\u0000\u0000\u0089\u008a\u0007"+
		"\u0012\u0000\u0000\u008a\u001e\u0001\u0000\u0000\u0000\u008b\u008c\u0007"+
		"\u0007\u0000\u0000\u008c\u008d\u0007\u000e\u0000\u0000\u008d\u008e\u0007"+
		"\u0013\u0000\u0000\u008e\u008f\u0007\u0006\u0000\u0000\u008f \u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0007\u0012\u0000\u0000\u0091\u0092\u0007\u0003"+
		"\u0000\u0000\u0092\u0093\u0007\u000f\u0000\u0000\u0093\"\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0007\u0014\u0000\u0000\u0095\u0096\u0007\u0015\u0000"+
		"\u0000\u0096\u0097\u0007\u0011\u0000\u0000\u0097\u0098\u0007\t\u0000\u0000"+
		"\u0098\u0099\u0007\u0006\u0000\u0000\u0099$\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0007\t\u0000\u0000\u009b\u009c\u0007\u0003\u0000\u0000\u009c\u009d"+
		"\u0007\u0003\u0000\u0000\u009d\u009e\u0007\u0016\u0000\u0000\u009e&\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005;\u0000\u0000\u00a0(\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0007\f\u0000\u0000\u00a2\u00a3\u0007\u0003\u0000\u0000"+
		"\u00a3\u00a4\u0007\b\u0000\u0000\u00a4*\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0007\u0006\u0000\u0000\u00a6\u00a7\u0007\u0017\u0000\u0000\u00a7"+
		"\u00a8\u0007\u0011\u0000\u0000\u00a8\u00a9\u0007\u0013\u0000\u0000\u00a9"+
		"\u00aa\u0007\b\u0000\u0000\u00aa\u00ab\u0007\u0013\u0000\u0000\u00ab,"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\'\u0000\u0000\u00ad.\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005\"\u0000\u0000\u00af0\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005`\u0000\u0000\u00b12\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005.\u0000\u0000\u00b34\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005,\u0000\u0000\u00b56\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005$"+
		"\u0000\u0000\u00b7\u00b8\u0005$\u0000\u0000\u00b88\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0007\u0018\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd:\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0005\\\u0000\u0000\u00bf\u00c0\t\u0000\u0000\u0000\u00c0<\u0001"+
		"\u0000\u0000\u0000\u0007\u0000MRYc\u00ba\u00bc\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}