// Generated from DeepRegexGrammar.g4 by ANTLR 4.7.1
package regex.data.ast;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeepRegexGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, CC=14, INT=15;
	public static final int
		RULE_regex = 0;
	public static final String[] ruleNames = {
		"regex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.*'", "'|'", "'+'", "'~'", "'&'", "'(.*)'", "'{'", 
		"',}'", "').*('", "')*'", "'\\b'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "CC", "INT"
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
	public String getGrammarFileName() { return "DeepRegexGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DeepRegexGrammarParser(TokenStream input) {
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
		public List<TerminalNode> CC() { return getTokens(DeepRegexGrammarParser.CC); }
		public TerminalNode CC(int i) {
			return getToken(DeepRegexGrammarParser.CC, i);
		}
		public FollowedByContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitFollowedBy(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WordContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public WordContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitWord(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharClassContext extends RegexContext {
		public TerminalNode CC() { return getToken(DeepRegexGrammarParser.CC, 0); }
		public CharClassContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitCharClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EndsWith1Context extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public EndsWith1Context(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitEndsWith1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FollowedBy1Context extends RegexContext {
		public List<RegexContext> regex() {
			return getRuleContexts(RegexContext.class);
		}
		public RegexContext regex(int i) {
			return getRuleContext(RegexContext.class,i);
		}
		public FollowedBy1Context(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitFollowedBy1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public TerminalNode INT() { return getToken(DeepRegexGrammarParser.INT, 0); }
		public RepeatContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitRepeat(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitStartsWith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KleeneStarContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public KleeneStarContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitKleeneStar(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitNot(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StartsWith1Context extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public StartsWith1Context(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitStartsWith1(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitContains(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public PlusContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitPlus(this);
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
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitEndsWith(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends RegexContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public ParenContext(RegexContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DeepRegexGrammarVisitor ) return ((DeepRegexGrammarVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegexContext regex() throws RecognitionException {
		return regex(0);
	}

	private RegexContext regex(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RegexContext _localctx = new RegexContext(_ctx, _parentState);
		RegexContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_regex, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new CharClassContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(CC);
				}
				break;
			case 2:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(4);
				match(T__0);
				setState(5);
				regex(0);
				setState(6);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new ContainsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(8);
				match(T__2);
				setState(9);
				regex(0);
				setState(10);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				match(T__5);
				setState(13);
				regex(11);
				}
				break;
			case 5:
				{
				_localctx = new EndsWithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				match(T__2);
				setState(15);
				regex(9);
				}
				break;
			case 6:
				{
				_localctx = new EndsWith1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(T__7);
				setState(17);
				regex(8);
				}
				break;
			case 7:
				{
				_localctx = new FollowedByContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(CC);
				setState(19);
				match(T__2);
				setState(20);
				match(CC);
				}
				break;
			case 8:
				{
				_localctx = new FollowedBy1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(T__0);
				setState(22);
				regex(0);
				setState(23);
				match(T__10);
				setState(24);
				regex(0);
				setState(25);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new KleeneStarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(T__0);
				setState(28);
				regex(0);
				setState(29);
				match(T__11);
				}
				break;
			case 10:
				{
				_localctx = new WordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(T__12);
				setState(32);
				regex(0);
				setState(33);
				match(T__12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new OrContext(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(37);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(38);
						match(T__3);
						setState(39);
						regex(14);
						}
						break;
					case 2:
						{
						_localctx = new AndContext(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(40);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(41);
						match(T__6);
						setState(42);
						regex(11);
						}
						break;
					case 3:
						{
						_localctx = new PlusContext(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(43);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(44);
						match(T__4);
						}
						break;
					case 4:
						{
						_localctx = new StartsWithContext(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(45);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(46);
						match(T__2);
						}
						break;
					case 5:
						{
						_localctx = new StartsWith1Context(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(47);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(48);
						match(T__7);
						}
						break;
					case 6:
						{
						_localctx = new RepeatContext(new RegexContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_regex);
						setState(49);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(50);
						match(T__8);
						setState(51);
						match(INT);
						setState(52);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return regex_sempred((RegexContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean regex_sempred(RegexContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21=\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2&\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\28\n\2"+
		"\f\2\16\2;\13\2\3\2\2\3\2\3\2\2\2\2J\2%\3\2\2\2\4\5\b\2\1\2\5&\7\20\2"+
		"\2\6\7\7\3\2\2\7\b\5\2\2\2\b\t\7\4\2\2\t&\3\2\2\2\n\13\7\5\2\2\13\f\5"+
		"\2\2\2\f\r\7\5\2\2\r&\3\2\2\2\16\17\7\b\2\2\17&\5\2\2\r\20\21\7\5\2\2"+
		"\21&\5\2\2\13\22\23\7\n\2\2\23&\5\2\2\n\24\25\7\20\2\2\25\26\7\5\2\2\26"+
		"&\7\20\2\2\27\30\7\3\2\2\30\31\5\2\2\2\31\32\7\r\2\2\32\33\5\2\2\2\33"+
		"\34\7\4\2\2\34&\3\2\2\2\35\36\7\3\2\2\36\37\5\2\2\2\37 \7\16\2\2 &\3\2"+
		"\2\2!\"\7\17\2\2\"#\5\2\2\2#$\7\17\2\2$&\3\2\2\2%\4\3\2\2\2%\6\3\2\2\2"+
		"%\n\3\2\2\2%\16\3\2\2\2%\20\3\2\2\2%\22\3\2\2\2%\24\3\2\2\2%\27\3\2\2"+
		"\2%\35\3\2\2\2%!\3\2\2\2&9\3\2\2\2\'(\f\17\2\2()\7\6\2\2)8\5\2\2\20*+"+
		"\f\f\2\2+,\7\t\2\2,8\5\2\2\r-.\f\16\2\2.8\7\7\2\2/\60\f\t\2\2\608\7\5"+
		"\2\2\61\62\f\b\2\2\628\7\n\2\2\63\64\f\7\2\2\64\65\7\13\2\2\65\66\7\21"+
		"\2\2\668\7\f\2\2\67\'\3\2\2\2\67*\3\2\2\2\67-\3\2\2\2\67/\3\2\2\2\67\61"+
		"\3\2\2\2\67\63\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\3\3\2\2\2;9\3"+
		"\2\2\2\5%\679";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}