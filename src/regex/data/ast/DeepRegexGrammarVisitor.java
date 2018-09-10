// Generated from DeepRegexGrammar.g4 by ANTLR 4.7.1
package regex.data.ast;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DeepRegexGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DeepRegexGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code FollowedBy}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowedBy(DeepRegexGrammarParser.FollowedByContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Word}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(DeepRegexGrammarParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(DeepRegexGrammarParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharClass}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharClass(DeepRegexGrammarParser.CharClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndsWith1}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndsWith1(DeepRegexGrammarParser.EndsWith1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code FollowedBy1}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowedBy1(DeepRegexGrammarParser.FollowedBy1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code Repeat}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(DeepRegexGrammarParser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StartsWith}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartsWith(DeepRegexGrammarParser.StartsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KleeneStar}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleeneStar(DeepRegexGrammarParser.KleeneStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(DeepRegexGrammarParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(DeepRegexGrammarParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StartsWith1}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartsWith1(DeepRegexGrammarParser.StartsWith1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(DeepRegexGrammarParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(DeepRegexGrammarParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndsWith}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndsWith(DeepRegexGrammarParser.EndsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link DeepRegexGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(DeepRegexGrammarParser.ParenContext ctx);
}