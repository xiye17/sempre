package regex.dataspec;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import regex.dataspec.ast.SpecGrammarLexer;
import regex.dataspec.ast.SpecGrammarParser;
import regex.dataspec.ast.SpecGrammarParser.AndContext;
import regex.dataspec.ast.SpecGrammarParser.CharClassContext;
import regex.dataspec.ast.SpecGrammarParser.ContainsContext;
import regex.dataspec.ast.SpecGrammarParser.EndsWithContext;
import regex.dataspec.ast.SpecGrammarParser.FollowedByContext;
import regex.dataspec.ast.SpecGrammarParser.NotContext;
import regex.dataspec.ast.SpecGrammarParser.OptionalContext;
import regex.dataspec.ast.SpecGrammarParser.OrContext;
import regex.dataspec.ast.SpecGrammarParser.Repeat0Context;
import regex.dataspec.ast.SpecGrammarParser.Repeat1Context;
import regex.dataspec.ast.SpecGrammarParser.Repeat2Context;
import regex.dataspec.ast.SpecGrammarParser.StartsWithContext;
import regex.dataspec.ast.SpecGrammarVisitor;

// 
// Spec language (SEMPRE) 
//
// Phi := 
// fb:en.num | fb:en.let | fb:en.any | fb:en.vow | fb:en.cap | fb:en.low | fb:en.const | fb:en.letnum 
// | contain( Phi ) 
// | startwith( Phi ) 
// | endwith( Phi ) 
// | repeat0( Phi, INT )
// | repeat1( Phi, INT, )
// | repeat2( Phi, INT, INT )
// | followedby( Phi, Phi ) 
// | not( Phi ) 
// | and( Phi, Phi ) 
// | or( Phi, Phi ) 
// 
public class Generator extends AbstractParseTreeVisitor<Object>
    implements SpecGrammarVisitor<Object> {

  public String generate(String spec) {

    CharStream input = CharStreams.fromString(spec);

    SpecGrammarLexer lexer = new SpecGrammarLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    SpecGrammarParser parser = new SpecGrammarParser(tokens);

    ParseTree tree = parser.regex();

    assert (tree.getText().equals(spec)) : tree.getText() + " != " + spec;

    String ret = (String) this.visit(tree);

    return ret;

  }

  public String mkCharClass(String name) {

    String ret = null;

    if ("fb:en.any".equals(name)) {
      ret = ".";

    } else if ("fb:en.num".equals(name)) {
      ret = "[0-9]";

    } else if ("fb:en.cap".equals(name)) {
      ret = "[A-Z]";

    } else if ("fb:en.let".equals(name)) {
      ret = "[A-Za-z]";

    } else if ("fb:en.low".equals(name)) {
      ret = "[a-z]";

    } else if ("fb:en.vow".equals(name)) {
      ret = "[AEIOUaeiou]";

    } else if ("fb:en.const".equals(name)) {
      ret = "M0";

    } else if ("fb:en.letnum".equals(name)) {
      ret = "[A-Za-z0-9]";

    } else if ("fb:en.dp".equals(name)) {
      ret = "\\.";

    } else {

      System.out.println(name);
      throw new RuntimeException();

    }

    return ret;

  }

  @Override
  public Object visitCharClass(CharClassContext ctx) {

    String s = ctx.getText();

    String ret = mkCharClass(s);

    return ret;
  }

  @Override
  public Object visitContains(ContainsContext ctx) {

    String arg0 = (String) visit(ctx.regex());

    String ret = "((.)*)(" + arg0 + ")((.)*)";

    return ret;

  }

  @Override
  public Object visitStartsWith(StartsWithContext ctx) {

    String arg0 = (String) visit(ctx.regex());

    String ret = "(" + arg0 + ")((.)*)";

    return ret;

  }

  @Override
  public Object visitEndsWith(EndsWithContext ctx) {

    String arg0 = (String) visit(ctx.regex());

    String ret = "((.)*)(" + arg0 + ")";

    return ret;

  }

  @Override
  public Object visitFollowedBy(FollowedByContext ctx) {

    String arg0 = (String) visit(ctx.regex(0));
    String arg1 = (String) visit(ctx.regex(1));

    String ret = "(" + arg0 + ")(" + arg1 + ")";

    return ret;

  }

  @Override
  public Object visitNot(NotContext ctx) {

    String arg0 = (String) visit(ctx.regex());

    String ret = "~(" + arg0 + ")";

    return ret;

  }

  @Override
  public Object visitAnd(AndContext ctx) {

    String arg0 = (String) visit(ctx.regex(0));
    String arg1 = (String) visit(ctx.regex(1));

    String ret = "(" + arg0 + ")&(" + arg1 + ")";

    return ret;

  }

  @Override
  public Object visitOr(OrContext ctx) {

    String arg0 = (String) visit(ctx.regex(0));
    String arg1 = (String) visit(ctx.regex(1));

    String ret = "(" + arg0 + ")|(" + arg1 + ")";

    return ret;
  }

  @Override
  public Object visitRepeat0(Repeat0Context ctx) {

    String arg0 = (String) visit(ctx.regex());
    int arg1 = Integer.valueOf(ctx.INT().getText());

    String ret = "(" + arg0 + "){" + arg1 + "}";

    return ret;

  }

  @Override
  public Object visitRepeat1(Repeat1Context ctx) {

    String arg0 = (String) visit(ctx.regex());
    int arg1 = Integer.valueOf(ctx.INT().getText());

    String ret = "(" + arg0 + "){" + arg1 + ",}";

    return ret;

  }

  @Override
  public Object visitRepeat2(Repeat2Context ctx) {

    String arg0 = (String) visit(ctx.regex());
    int arg1 = Integer.valueOf(ctx.INT(0).getText());
    int arg2 = Integer.valueOf(ctx.INT(1).getText());

    String ret = "(" + arg0 + "){" + arg1 + "," + arg2 + "}";

    return ret;

  }

  @Override
  public Object visitOptional(OptionalContext ctx) {

    String arg0 = (String) visit(ctx.regex());

    String ret = "(" + arg0 + ")?";

    return ret;
  }

}
