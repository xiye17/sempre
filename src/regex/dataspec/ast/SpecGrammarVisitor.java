// Generated from SpecGrammar.g4 by ANTLR 4.7.1
package regex.dataspec.ast;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpecGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpecGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code CharClass}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharClass(SpecGrammarParser.CharClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(SpecGrammarParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StartsWith}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartsWith(SpecGrammarParser.StartsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndsWith}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndsWith(SpecGrammarParser.EndsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Repeat0}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat0(SpecGrammarParser.Repeat0Context ctx);
	/**
	 * Visit a parse tree produced by the {@code Repeat1}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat1(SpecGrammarParser.Repeat1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code Repeat2}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat2(SpecGrammarParser.Repeat2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code FollowedBy}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowedBy(SpecGrammarParser.FollowedByContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(SpecGrammarParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SpecGrammarParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SpecGrammarParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Optional}
	 * labeled alternative in {@link SpecGrammarParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptional(SpecGrammarParser.OptionalContext ctx);
}