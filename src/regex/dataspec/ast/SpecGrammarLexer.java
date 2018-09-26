// Generated from SpecGrammar.g4 by ANTLR 4.7.1
package regex.dataspec.ast;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpecGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, CC=13, INT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "CC", "INT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'contain('", "')'", "'startwith('", "'endwith('", "'repeat('", 
		"','", "',)'", "'followedby('", "'not('", "'and('", "'or('", "'optional('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "CC", "INT"
	};
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


	public SpecGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SpecGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u00cb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00c5\n\16\3\17\6\17\u00c8\n\17\r\17\16"+
		"\17\u00c9\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\3\2\3\3\2\62;\2\u00d3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\3\37\3\2\2\2\5(\3\2\2\2\7*\3\2\2\2\t\65\3\2\2\2\13>\3\2\2\2\rF"+
		"\3\2\2\2\17H\3\2\2\2\21K\3\2\2\2\23W\3\2\2\2\25\\\3\2\2\2\27a\3\2\2\2"+
		"\31e\3\2\2\2\33\u00c4\3\2\2\2\35\u00c7\3\2\2\2\37 \7e\2\2 !\7q\2\2!\""+
		"\7p\2\2\"#\7v\2\2#$\7c\2\2$%\7k\2\2%&\7p\2\2&\'\7*\2\2\'\4\3\2\2\2()\7"+
		"+\2\2)\6\3\2\2\2*+\7u\2\2+,\7v\2\2,-\7c\2\2-.\7t\2\2./\7v\2\2/\60\7y\2"+
		"\2\60\61\7k\2\2\61\62\7v\2\2\62\63\7j\2\2\63\64\7*\2\2\64\b\3\2\2\2\65"+
		"\66\7g\2\2\66\67\7p\2\2\678\7f\2\289\7y\2\29:\7k\2\2:;\7v\2\2;<\7j\2\2"+
		"<=\7*\2\2=\n\3\2\2\2>?\7t\2\2?@\7g\2\2@A\7r\2\2AB\7g\2\2BC\7c\2\2CD\7"+
		"v\2\2DE\7*\2\2E\f\3\2\2\2FG\7.\2\2G\16\3\2\2\2HI\7.\2\2IJ\7+\2\2J\20\3"+
		"\2\2\2KL\7h\2\2LM\7q\2\2MN\7n\2\2NO\7n\2\2OP\7q\2\2PQ\7y\2\2QR\7g\2\2"+
		"RS\7f\2\2ST\7d\2\2TU\7{\2\2UV\7*\2\2V\22\3\2\2\2WX\7p\2\2XY\7q\2\2YZ\7"+
		"v\2\2Z[\7*\2\2[\24\3\2\2\2\\]\7c\2\2]^\7p\2\2^_\7f\2\2_`\7*\2\2`\26\3"+
		"\2\2\2ab\7q\2\2bc\7t\2\2cd\7*\2\2d\30\3\2\2\2ef\7q\2\2fg\7r\2\2gh\7v\2"+
		"\2hi\7k\2\2ij\7q\2\2jk\7p\2\2kl\7c\2\2lm\7n\2\2mn\7*\2\2n\32\3\2\2\2o"+
		"p\7h\2\2pq\7d\2\2qr\7<\2\2rs\7g\2\2st\7p\2\2tu\7\60\2\2uv\7p\2\2vw\7w"+
		"\2\2w\u00c5\7o\2\2xy\7h\2\2yz\7d\2\2z{\7<\2\2{|\7g\2\2|}\7p\2\2}~\7\60"+
		"\2\2~\177\7e\2\2\177\u0080\7c\2\2\u0080\u00c5\7r\2\2\u0081\u0082\7h\2"+
		"\2\u0082\u0083\7d\2\2\u0083\u0084\7<\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7p\2\2\u0086\u0087\7\60\2\2\u0087\u0088\7n\2\2\u0088\u0089\7q\2\2\u0089"+
		"\u00c5\7y\2\2\u008a\u008b\7h\2\2\u008b\u008c\7d\2\2\u008c\u008d\7<\2\2"+
		"\u008d\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f\u0090\7\60\2\2\u0090\u0091"+
		"\7x\2\2\u0091\u0092\7q\2\2\u0092\u00c5\7y\2\2\u0093\u0094\7h\2\2\u0094"+
		"\u0095\7d\2\2\u0095\u0096\7<\2\2\u0096\u0097\7g\2\2\u0097\u0098\7p\2\2"+
		"\u0098\u0099\7\60\2\2\u0099\u009a\7n\2\2\u009a\u009b\7g\2\2\u009b\u00c5"+
		"\7v\2\2\u009c\u009d\7h\2\2\u009d\u009e\7d\2\2\u009e\u009f\7<\2\2\u009f"+
		"\u00a0\7g\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7\60\2\2\u00a2\u00a3\7c\2"+
		"\2\u00a3\u00a4\7p\2\2\u00a4\u00c5\7{\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7"+
		"\7d\2\2\u00a7\u00a8\7<\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7\60\2\2\u00ab\u00ac\7e\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7p\2"+
		"\2\u00ae\u00af\7u\2\2\u00af\u00c5\7v\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2"+
		"\7d\2\2\u00b2\u00b3\7<\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\u00b6\7\60\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7v\2"+
		"\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7w\2\2\u00bb\u00c5\7o\2\2\u00bc\u00bd"+
		"\7h\2\2\u00bd\u00be\7d\2\2\u00be\u00bf\7<\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7p\2\2\u00c1\u00c2\7\60\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c5\7r\2"+
		"\2\u00c4o\3\2\2\2\u00c4x\3\2\2\2\u00c4\u0081\3\2\2\2\u00c4\u008a\3\2\2"+
		"\2\u00c4\u0093\3\2\2\2\u00c4\u009c\3\2\2\2\u00c4\u00a5\3\2\2\2\u00c4\u00b0"+
		"\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c5\34\3\2\2\2\u00c6\u00c8\t\2\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\36\3\2\2\2\5\2\u00c4\u00c9\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}