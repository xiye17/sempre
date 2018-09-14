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
		T__9=10, CC=11, INT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "CC", "INT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'contain('", "')'", "'startwith('", "'endwith('", "'repeat('", 
		"','", "'followedby('", "'not('", "'and('", "'or('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "CC", 
		"INT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00a0\n\f\3\r\6\r\u00a3\n\r\r\r\16\r\u00a4\2\2\16\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\3\3\2\62;\2\u00ac\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\3\33\3\2\2\2\5$\3\2\2\2\7&\3\2\2\2\t\61\3\2\2\2\13:\3\2\2\2\rB\3\2"+
		"\2\2\17D\3\2\2\2\21P\3\2\2\2\23U\3\2\2\2\25Z\3\2\2\2\27\u009f\3\2\2\2"+
		"\31\u00a2\3\2\2\2\33\34\7e\2\2\34\35\7q\2\2\35\36\7p\2\2\36\37\7v\2\2"+
		"\37 \7c\2\2 !\7k\2\2!\"\7p\2\2\"#\7*\2\2#\4\3\2\2\2$%\7+\2\2%\6\3\2\2"+
		"\2&\'\7u\2\2\'(\7v\2\2()\7c\2\2)*\7t\2\2*+\7v\2\2+,\7y\2\2,-\7k\2\2-."+
		"\7v\2\2./\7j\2\2/\60\7*\2\2\60\b\3\2\2\2\61\62\7g\2\2\62\63\7p\2\2\63"+
		"\64\7f\2\2\64\65\7y\2\2\65\66\7k\2\2\66\67\7v\2\2\678\7j\2\289\7*\2\2"+
		"9\n\3\2\2\2:;\7t\2\2;<\7g\2\2<=\7r\2\2=>\7g\2\2>?\7c\2\2?@\7v\2\2@A\7"+
		"*\2\2A\f\3\2\2\2BC\7.\2\2C\16\3\2\2\2DE\7h\2\2EF\7q\2\2FG\7n\2\2GH\7n"+
		"\2\2HI\7q\2\2IJ\7y\2\2JK\7g\2\2KL\7f\2\2LM\7d\2\2MN\7{\2\2NO\7*\2\2O\20"+
		"\3\2\2\2PQ\7p\2\2QR\7q\2\2RS\7v\2\2ST\7*\2\2T\22\3\2\2\2UV\7c\2\2VW\7"+
		"p\2\2WX\7f\2\2XY\7*\2\2Y\24\3\2\2\2Z[\7q\2\2[\\\7t\2\2\\]\7*\2\2]\26\3"+
		"\2\2\2^_\7h\2\2_`\7d\2\2`a\7<\2\2ab\7g\2\2bc\7p\2\2cd\7\60\2\2de\7p\2"+
		"\2ef\7w\2\2f\u00a0\7o\2\2gh\7h\2\2hi\7d\2\2ij\7<\2\2jk\7g\2\2kl\7p\2\2"+
		"lm\7\60\2\2mn\7e\2\2no\7c\2\2o\u00a0\7r\2\2pq\7h\2\2qr\7d\2\2rs\7<\2\2"+
		"st\7g\2\2tu\7p\2\2uv\7\60\2\2vw\7n\2\2wx\7q\2\2x\u00a0\7y\2\2yz\7h\2\2"+
		"z{\7d\2\2{|\7<\2\2|}\7g\2\2}~\7p\2\2~\177\7\60\2\2\177\u0080\7x\2\2\u0080"+
		"\u0081\7q\2\2\u0081\u00a0\7y\2\2\u0082\u0083\7h\2\2\u0083\u0084\7d\2\2"+
		"\u0084\u0085\7<\2\2\u0085\u0086\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088"+
		"\7\60\2\2\u0088\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\u00a0\7v\2\2\u008b"+
		"\u008c\7h\2\2\u008c\u008d\7d\2\2\u008d\u008e\7<\2\2\u008e\u008f\7g\2\2"+
		"\u008f\u0090\7p\2\2\u0090\u0091\7\60\2\2\u0091\u0092\7c\2\2\u0092\u0093"+
		"\7p\2\2\u0093\u00a0\7{\2\2\u0094\u0095\7h\2\2\u0095\u0096\7d\2\2\u0096"+
		"\u0097\7<\2\2\u0097\u0098\7g\2\2\u0098\u0099\7p\2\2\u0099\u009a\7\60\2"+
		"\2\u009a\u009b\7e\2\2\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e"+
		"\7u\2\2\u009e\u00a0\7v\2\2\u009f^\3\2\2\2\u009fg\3\2\2\2\u009fp\3\2\2"+
		"\2\u009fy\3\2\2\2\u009f\u0082\3\2\2\2\u009f\u008b\3\2\2\2\u009f\u0094"+
		"\3\2\2\2\u00a0\30\3\2\2\2\u00a1\u00a3\t\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\32\3\2\2"+
		"\2\5\2\u009f\u00a4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}