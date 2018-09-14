// Generated from SpecGrammar.g4 by ANTLR 4.7.1
package regex.dataspec.ast;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpecGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CC=11, INT=12;
	public static final int
		RULE_regex = 0;
	public static final String[] ruleNames = {
		"regex"
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

	@Override
	public String getGrammarFileName() { return "SpecGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpecGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RegexContext extends ParserRuleContext {
		public RegexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex; }
	 
		public RegexContext() { }
		public void copyFrom(RegexContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FollowedByContext extends RegexContext {
		public List<RegexContext> regex() {
			return getRuleContexts(RegexContext.class);
		}
		public RegexContext regex(int i) {
			return getRuleContext(RegexContext.class,i);
		}
		public FollowedByContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitFollowedBy(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public NotContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends RegexContext {
		public List<RegexContext> regex() {
			return getRuleContexts(RegexContext.class);
		}
		public RegexContext regex(int i) {
			return getRuleContext(RegexContext.class,i);
		}
		public OrContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends RegexContext {
		public List<RegexContext> regex() {
			return getRuleContexts(RegexContext.class);
		}
		public RegexContext regex(int i) {
			return getRuleContext(RegexContext.class,i);
		}
		public AndContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharClassContext extends RegexContext {
		public TerminalNode CC() { return getToken(SpecGrammarParser.CC, 0); }
		public CharClassContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitCharClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContainsContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public ContainsContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitContains(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public TerminalNode INT() { return getToken(SpecGrammarParser.INT, 0); }
		public RepeatContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StartsWithContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public StartsWithContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitStartsWith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EndsWithContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public EndsWithContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpecGrammarVisitor ) return ((SpecGrammarVisitor<? extends T>)visitor).visitEndsWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegexContext regex() throws RecognitionException {
		RegexContext _localctx = new RegexContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_regex);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CC:
				_localctx = new CharClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2);
				match(CC);
				}
				break;
			case T__0:
				_localctx = new ContainsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(3);
				match(T__0);
				setState(4);
				regex();
				setState(5);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new StartsWithContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(7);
				match(T__2);
				setState(8);
				regex();
				setState(9);
				match(T__1);
				}
				break;
			case T__3:
				_localctx = new EndsWithContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(11);
				match(T__3);
				setState(12);
				regex();
				setState(13);
				match(T__1);
				}
				break;
			case T__4:
				_localctx = new RepeatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(15);
				match(T__4);
				setState(16);
				regex();
				setState(17);
				match(T__5);
				setState(18);
				match(INT);
				setState(19);
				match(T__1);
				}
				break;
			case T__6:
				_localctx = new FollowedByContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(21);
				match(T__6);
				setState(22);
				regex();
				setState(23);
				match(T__5);
				setState(24);
				regex();
				setState(25);
				match(T__1);
				}
				break;
			case T__7:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(27);
				match(T__7);
				setState(28);
				regex();
				setState(29);
				match(T__1);
				}
				break;
			case T__8:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(31);
				match(T__8);
				setState(32);
				regex();
				setState(33);
				match(T__5);
				setState(34);
				regex();
				setState(35);
				match(T__1);
				}
				break;
			case T__9:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(37);
				match(T__9);
				setState(38);
				regex();
				setState(39);
				match(T__5);
				setState(40);
				regex();
				setState(41);
				match(T__1);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\60\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2.\n\2\3\2\2\2\3\2\2\2\2\66\2-\3\2\2\2\4.\7\r\2"+
		"\2\5\6\7\3\2\2\6\7\5\2\2\2\7\b\7\4\2\2\b.\3\2\2\2\t\n\7\5\2\2\n\13\5\2"+
		"\2\2\13\f\7\4\2\2\f.\3\2\2\2\r\16\7\6\2\2\16\17\5\2\2\2\17\20\7\4\2\2"+
		"\20.\3\2\2\2\21\22\7\7\2\2\22\23\5\2\2\2\23\24\7\b\2\2\24\25\7\16\2\2"+
		"\25\26\7\4\2\2\26.\3\2\2\2\27\30\7\t\2\2\30\31\5\2\2\2\31\32\7\b\2\2\32"+
		"\33\5\2\2\2\33\34\7\4\2\2\34.\3\2\2\2\35\36\7\n\2\2\36\37\5\2\2\2\37 "+
		"\7\4\2\2 .\3\2\2\2!\"\7\13\2\2\"#\5\2\2\2#$\7\b\2\2$%\5\2\2\2%&\7\4\2"+
		"\2&.\3\2\2\2\'(\7\f\2\2()\5\2\2\2)*\7\b\2\2*+\5\2\2\2+,\7\4\2\2,.\3\2"+
		"\2\2-\4\3\2\2\2-\5\3\2\2\2-\t\3\2\2\2-\r\3\2\2\2-\21\3\2\2\2-\27\3\2\2"+
		"\2-\35\3\2\2\2-!\3\2\2\2-\'\3\2\2\2.\3\3\2\2\2\3-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}