// Generated from HDBCDS.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HDBCDSLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "INTEGER", 
			"NAME", "SEPARATOR", "STRING", "WS", "COMMENT", "LINE_COMMENT"
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


	public HDBCDSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HDBCDS.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u01be\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$"+
		"\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\62\6\62\u018b\n\62\r\62"+
		"\16\62\u018c\3\63\6\63\u0190\n\63\r\63\16\63\u0191\3\64\3\64\3\65\3\65"+
		"\7\65\u0198\n\65\f\65\16\65\u019b\13\65\3\65\3\65\3\66\6\66\u01a0\n\66"+
		"\r\66\16\66\u01a1\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u01aa\n\67\f\67\16"+
		"\67\u01ad\13\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\78\u01b8\n8\f8\16"+
		"8\u01bb\138\38\38\4\u0199\u01ab\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9\3\2\6\3\2\62;\b\2&&,,\60<C\\aac"+
		"|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u01c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3q\3\2\2\2\5{"+
		"\3\2\2\2\7\u0083\3\2\2\2\t\u0085\3\2\2\2\13\u0087\3\2\2\2\r\u008c\3\2"+
		"\2\2\17\u008e\3\2\2\2\21\u0097\3\2\2\2\23\u009f\3\2\2\2\25\u00a3\3\2\2"+
		"\2\27\u00a8\3\2\2\2\31\u00af\3\2\2\2\33\u00b3\3\2\2\2\35\u00bf\3\2\2\2"+
		"\37\u00c1\3\2\2\2!\u00c3\3\2\2\2#\u00c5\3\2\2\2%\u00c8\3\2\2\2\'\u00cb"+
		"\3\2\2\2)\u00cd\3\2\2\2+\u00d1\3\2\2\2-\u00db\3\2\2\2/\u00de\3\2\2\2\61"+
		"\u00e7\3\2\2\2\63\u00e9\3\2\2\2\65\u00eb\3\2\2\2\67\u00f2\3\2\2\29\u00f5"+
		"\3\2\2\2;\u00fb\3\2\2\2=\u0100\3\2\2\2?\u010a\3\2\2\2A\u010d\3\2\2\2C"+
		"\u0116\3\2\2\2E\u011f\3\2\2\2G\u0125\3\2\2\2I\u012b\3\2\2\2K\u0135\3\2"+
		"\2\2M\u0143\3\2\2\2O\u014a\3\2\2\2Q\u0150\3\2\2\2S\u0154\3\2\2\2U\u015b"+
		"\3\2\2\2W\u0160\3\2\2\2Y\u0167\3\2\2\2[\u016c\3\2\2\2]\u0177\3\2\2\2_"+
		"\u0181\3\2\2\2a\u0187\3\2\2\2c\u018a\3\2\2\2e\u018f\3\2\2\2g\u0193\3\2"+
		"\2\2i\u0195\3\2\2\2k\u019f\3\2\2\2m\u01a5\3\2\2\2o\u01b3\3\2\2\2qr\7p"+
		"\2\2rs\7c\2\2st\7o\2\2tu\7g\2\2uv\7u\2\2vw\7r\2\2wx\7c\2\2xy\7e\2\2yz"+
		"\7g\2\2z\4\3\2\2\2{|\7e\2\2|}\7q\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7"+
		"g\2\2\u0080\u0081\7z\2\2\u0081\u0082\7v\2\2\u0082\6\3\2\2\2\u0083\u0084"+
		"\7}\2\2\u0084\b\3\2\2\2\u0085\u0086\7\177\2\2\u0086\n\3\2\2\2\u0087\u0088"+
		"\7v\2\2\u0088\u0089\7{\2\2\u0089\u008a\7r\2\2\u008a\u008b\7g\2\2\u008b"+
		"\f\3\2\2\2\u008c\u008d\7<\2\2\u008d\16\3\2\2\2\u008e\u008f\7B\2\2\u008f"+
		"\u0090\7E\2\2\u0090\u0091\7q\2\2\u0091\u0092\7o\2\2\u0092\u0093\7o\2\2"+
		"\u0093\u0094\7g\2\2\u0094\u0095\7p\2\2\u0095\u0096\7v\2\2\u0096\20\3\2"+
		"\2\2\u0097\u0098\7f\2\2\u0098\u0099\7g\2\2\u0099\u009a\7h\2\2\u009a\u009b"+
		"\7c\2\2\u009b\u009c\7w\2\2\u009c\u009d\7n\2\2\u009d\u009e\7v\2\2\u009e"+
		"\22\3\2\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7v\2\2\u00a2"+
		"\24\3\2\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\26\3\2\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7v\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7{\2\2"+
		"\u00ae\30\3\2\2\2\u00af\u00b0\7m\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7"+
		"{\2\2\u00b2\32\3\2\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6"+
		"\7u\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7k\2\2\u00b9"+
		"\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7q\2\2"+
		"\u00bd\u00be\7p\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7]\2\2\u00c0\36\3\2\2"+
		"\2\u00c1\u00c2\7.\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7_\2\2\u00c4\"\3\2\2"+
		"\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7q\2\2\u00c7$\3\2\2\2\u00c8\u00c9\7"+
		"q\2\2\u00c9\u00ca\7p\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7?\2\2\u00cc(\3\2"+
		"\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7f\2\2\u00d0*\3"+
		"\2\2\2\u00d1\u00d2\7i\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\u00d5\7g\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7v\2\2"+
		"\u00d8\u00d9\7g\2\2\u00d9\u00da\7f\2\2\u00da,\3\2\2\2\u00db\u00dc\7c\2"+
		"\2\u00dc\u00dd\7u\2\2\u00dd.\3\2\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7"+
		"f\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4"+
		"\7k\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7{\2\2\u00e6\60\3\2\2\2\u00e7\u00e8"+
		"\7*\2\2\u00e8\62\3\2\2\2\u00e9\u00ea\7+\2\2\u00ea\64\3\2\2\2\u00eb\u00ec"+
		"\7c\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7y\2\2\u00ee\u00ef\7c\2\2\u00ef"+
		"\u00f0\7{\2\2\u00f0\u00f1\7u\2\2\u00f1\66\3\2\2\2\u00f2\u00f3\7d\2\2\u00f3"+
		"\u00f4\7{\2\2\u00f48\3\2\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7v\2\2\u00f7"+
		"\u00f8\7c\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7v\2\2\u00fa:\3\2\2\2\u00fb"+
		"\u00fc\7y\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7j\2\2"+
		"\u00ff<\3\2\2\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2\2\u0102\u0103\7e\2"+
		"\2\u0103\u0104\7t\2\2\u0104\u0105\7g\2\2\u0105\u0106\7o\2\2\u0106\u0107"+
		"\7g\2\2\u0107\u0108\7p\2\2\u0108\u0109\7v\2\2\u0109>\3\2\2\2\u010a\u010b"+
		"\7p\2\2\u010b\u010c\7q\2\2\u010c@\3\2\2\2\u010d\u010e\7o\2\2\u010e\u010f"+
		"\7k\2\2\u010f\u0110\7p\2\2\u0110\u0111\7x\2\2\u0111\u0112\7c\2\2\u0112"+
		"\u0113\7n\2\2\u0113\u0114\7w\2\2\u0114\u0115\7g\2\2\u0115B\3\2\2\2\u0116"+
		"\u0117\7o\2\2\u0117\u0118\7c\2\2\u0118\u0119\7z\2\2\u0119\u011a\7x\2\2"+
		"\u011a\u011b\7c\2\2\u011b\u011c\7n\2\2\u011c\u011d\7w\2\2\u011d\u011e"+
		"\7g\2\2\u011eD\3\2\2\2\u011f\u0120\7e\2\2\u0120\u0121\7c\2\2\u0121\u0122"+
		"\7e\2\2\u0122\u0123\7j\2\2\u0123\u0124\7g\2\2\u0124F\3\2\2\2\u0125\u0126"+
		"\7e\2\2\u0126\u0127\7{\2\2\u0127\u0128\7e\2\2\u0128\u0129\7n\2\2\u0129"+
		"\u012a\7g\2\2\u012aH\3\2\2\2\u012b\u012c\7v\2\2\u012c\u012d\7g\2\2\u012d"+
		"\u012e\7e\2\2\u012e\u012f\7j\2\2\u012f\u0130\7p\2\2\u0130\u0131\7k\2\2"+
		"\u0131\u0132\7e\2\2\u0132\u0133\7c\2\2\u0133\u0134\7n\2\2\u0134J\3\2\2"+
		"\2\u0135\u0136\7e\2\2\u0136\u0137\7q\2\2\u0137\u0138\7p\2\2\u0138\u0139"+
		"\7h\2\2\u0139\u013a\7k\2\2\u013a\u013b\7i\2\2\u013b\u013c\7w\2\2\u013c"+
		"\u013d\7t\2\2\u013d\u013e\7c\2\2\u013e\u013f\7v\2\2\u013f\u0140\7k\2\2"+
		"\u0140\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142L\3\2\2\2\u0143\u0144\7e\2"+
		"\2\u0144\u0145\7q\2\2\u0145\u0146\7n\2\2\u0146\u0147\7w\2\2\u0147\u0148"+
		"\7o\2\2\u0148\u0149\7p\2\2\u0149N\3\2\2\2\u014a\u014b\7u\2\2\u014b\u014c"+
		"\7v\2\2\u014c\u014d\7q\2\2\u014d\u014e\7t\2\2\u014e\u014f\7g\2\2\u014f"+
		"P\3\2\2\2\u0150\u0151\7t\2\2\u0151\u0152\7q\2\2\u0152\u0153\7y\2\2\u0153"+
		"R\3\2\2\2\u0154\u0155\7f\2\2\u0155\u0156\7g\2\2\u0156\u0157\7h\2\2\u0157"+
		"\u0158\7k\2\2\u0158\u0159\7p\2\2\u0159\u015a\7g\2\2\u015aT\3\2\2\2\u015b"+
		"\u015c\7x\2\2\u015c\u015d\7k\2\2\u015d\u015e\7g\2\2\u015e\u015f\7y\2\2"+
		"\u015fV\3\2\2\2\u0160\u0161\7u\2\2\u0161\u0162\7g\2\2\u0162\u0163\7n\2"+
		"\2\u0163\u0164\7g\2\2\u0164\u0165\7e\2\2\u0165\u0166\7v\2\2\u0166X\3\2"+
		"\2\2\u0167\u0168\7h\2\2\u0168\u0169\7t\2\2\u0169\u016a\7q\2\2\u016a\u016b"+
		"\7o\2\2\u016bZ\3\2\2\2\u016c\u016d\7u\2\2\u016d\u016e\7v\2\2\u016e\u016f"+
		"\7t\2\2\u016f\u0170\7w\2\2\u0170\u0171\7e\2\2\u0171\u0172\7v\2\2\u0172"+
		"\u0173\7w\2\2\u0173\u0174\7t\2\2\u0174\u0175\7g\2\2\u0175\u0176\7f\2\2"+
		"\u0176\\\3\2\2\2\u0177\u0178\7r\2\2\u0178\u0179\7t\2\2\u0179\u017a\7k"+
		"\2\2\u017a\u017b\7x\2\2\u017b\u017c\7k\2\2\u017c\u017d\7n\2\2\u017d\u017e"+
		"\7g\2\2\u017e\u017f\7i\2\2\u017f\u0180\7g\2\2\u0180^\3\2\2\2\u0181\u0182"+
		"\7e\2\2\u0182\u0183\7j\2\2\u0183\u0184\7g\2\2\u0184\u0185\7e\2\2\u0185"+
		"\u0186\7m\2\2\u0186`\3\2\2\2\u0187\u0188\7$\2\2\u0188b\3\2\2\2\u0189\u018b"+
		"\t\2\2\2\u018a\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018dd\3\2\2\2\u018e\u0190\t\3\2\2\u018f\u018e\3\2\2\2"+
		"\u0190\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192f\3"+
		"\2\2\2\u0193\u0194\7=\2\2\u0194h\3\2\2\2\u0195\u0199\7)\2\2\u0196\u0198"+
		"\13\2\2\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u019a\3\2\2\2"+
		"\u0199\u0197\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u019d"+
		"\7)\2\2\u019dj\3\2\2\2\u019e\u01a0\t\4\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\b\66\2\2\u01a4l\3\2\2\2\u01a5\u01a6\7\61\2\2\u01a6\u01a7\7,\2\2"+
		"\u01a7\u01ab\3\2\2\2\u01a8\u01aa\13\2\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad"+
		"\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01af\7,\2\2\u01af\u01b0\7\61\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b2\b\67\2\2\u01b2n\3\2\2\2\u01b3\u01b4\7\61\2\2\u01b4\u01b5"+
		"\7\61\2\2\u01b5\u01b9\3\2\2\2\u01b6\u01b8\n\5\2\2\u01b7\u01b6\3\2\2\2"+
		"\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc"+
		"\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd\b8\2\2\u01bdp\3\2\2\2\t\2\u018c"+
		"\u0191\u0199\u01a1\u01ab\u01b9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}