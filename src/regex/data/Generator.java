package regex.data;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import regex.SpecLanguage.And;
import regex.SpecLanguage.CharClass;
import regex.SpecLanguage.Contains;
import regex.SpecLanguage.EndsWith;
import regex.SpecLanguage.FollowedBy;
import regex.SpecLanguage.Not;
import regex.SpecLanguage.Or;
import regex.SpecLanguage.Repeat;
import regex.SpecLanguage.StartsWith;
import regex.SpecLanguage.Symbol;
import regex.data.ast.DeepRegexGrammarLexer;
import regex.data.ast.DeepRegexGrammarParser;
import regex.data.ast.DeepRegexGrammarParser.AndContext;
import regex.data.ast.DeepRegexGrammarParser.CharClassContext;
import regex.data.ast.DeepRegexGrammarParser.ContainsContext;
import regex.data.ast.DeepRegexGrammarParser.EndsWith1Context;
import regex.data.ast.DeepRegexGrammarParser.EndsWithContext;
import regex.data.ast.DeepRegexGrammarParser.FollowedBy1Context;
import regex.data.ast.DeepRegexGrammarParser.FollowedByContext;
import regex.data.ast.DeepRegexGrammarParser.KleeneStarContext;
import regex.data.ast.DeepRegexGrammarParser.NotContext;
import regex.data.ast.DeepRegexGrammarParser.OrContext;
import regex.data.ast.DeepRegexGrammarParser.ParenContext;
import regex.data.ast.DeepRegexGrammarParser.PlusContext;
import regex.data.ast.DeepRegexGrammarParser.RepeatContext;
import regex.data.ast.DeepRegexGrammarParser.StartsWith1Context;
import regex.data.ast.DeepRegexGrammarParser.StartsWithContext;
import regex.data.ast.DeepRegexGrammarParser.WordContext;
import regex.data.ast.DeepRegexGrammarVisitor;

//
// DeepRegex grammar (see DeepRegexGrammar.g4) 
//
// Regex := 
//   CC 
// | ( Regex )          # Paren 
// | .* Regex .*        # Contains 
// | Regex | Regex      # Or 
// | Regex +            # Plus 
// | ~ Regex            # Not 
// | Regex & Regex      # And 
// | .* Regex           # EndsWith 
// | (.*) Regex         # EndsWith1 
// | Regex .*           # StartsWith 
// | Regex (.*)         # StartsWith1 
// | Regex { INT, }     # Repeat 
// | CC .* CC           # FollowedBy 
// | (Regex) .* (Regex) # FollowedBy1
// | (Regex)*           # KleeneStar 
// | \b Regex \b        # Word 
// 
public class Generator extends AbstractParseTreeVisitor<Object> implements DeepRegexGrammarVisitor<Object> {

  public Symbol generate(String regex) {

    CharStream input = CharStreams.fromString(regex);

    DeepRegexGrammarLexer lexer = new DeepRegexGrammarLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    DeepRegexGrammarParser parser = new DeepRegexGrammarParser(tokens);

    ParseTree tree = parser.regex();

    assert (tree.getText().equals(regex));

    Symbol ret = (Symbol) this.visit(tree);

    return ret;

  }

  public CharClass mkCharClass(String name) {

    CharClass ret = null;

    if (".".equals(name)) {

      ret = new CharClass("<ANY>");

    } else if ("<NUM>".equals(name)

        || "<CAP>".equals(name)

        || "<VOW>".equals(name)

        || "<LET>".equals(name)

        || "<LOW>".equals(name)

        || "<M0>".equals(name)

        || "<M1>".equals(name)

        || "<M2>".equals(name)

        || "<M3>".equals(name)) {

      ret = new CharClass(name);

    } else {

      System.out.println(name);
      throw new RuntimeException();

    }

    assert ret != null;
    return ret;

  }

  // 
  @Override
  public Object visitCharClass(CharClassContext ctx) {

    String s = ctx.getText();

    CharClass ret = mkCharClass(s);

    return ret;

  }

  // ( Regex ) 
  @Override
  public Object visitParen(ParenContext ctx) {

    Symbol ret = (Symbol) visit(ctx.regex());

    return ret;

  }

  // .* Regex .* 
  @Override
  public Object visitContains(ContainsContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Contains ret = new Contains(arg0);

    return ret;

  }

  // Regex | Regex 
  @Override
  public Object visitOr(OrContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex(0));
    Symbol arg1 = (Symbol) visit(ctx.regex(1));

    Or ret = new Or(arg0, arg1);

    return ret;

  }

  // Regex + 
  @Override
  public Object visitPlus(PlusContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Repeat ret = new Repeat(arg0, 1);

    return ret;

  }

  // ~ Regex 
  @Override
  public Object visitNot(NotContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Not ret = new Not(arg0);

    return ret;

  }

  // Regex & Regex 
  @Override
  public Object visitAnd(AndContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex(0));
    Symbol arg1 = (Symbol) visit(ctx.regex(1));

    And ret = new And(arg0, arg1);

    return ret;

  }

  // .* Regex 
  @Override
  public Object visitEndsWith(EndsWithContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    EndsWith ret = new EndsWith(arg0);

    return ret;

  }

  // (.*) Regex 
  @Override
  public Object visitEndsWith1(EndsWith1Context ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    EndsWith ret = new EndsWith(arg0);

    return ret;

  }

  // Regex .* 
  @Override
  public Object visitStartsWith(StartsWithContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Symbol ret = null;
//    StartsWith ret = new StartsWith(arg0);
    if (arg0 instanceof FollowedBy) {
      ret = new Contains(arg0);
    } else {
      assert false;
//      ret = new StartsWith(arg0);
    }

    return ret;

  }

  // Regex (.*) 
  @Override
  public Object visitStartsWith1(StartsWith1Context ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Symbol ret = null;
//  StartsWith ret = new StartsWith(arg0);
    if (arg0 instanceof FollowedBy) {
      assert false;
//      ret = new Contains(arg0);
    } else {
      ret = new StartsWith(arg0);
    }

    return ret;

  }

  // Regex { INT, } 
  @Override
  public Object visitRepeat(RepeatContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());
    int arg1 = Integer.valueOf(ctx.INT().getText());

    Repeat ret = new Repeat(arg0, arg1);

    return ret;

  }

  // CC .* CC 
  @Override
  public Object visitFollowedBy(FollowedByContext ctx) {

    Symbol arg0 = mkCharClass(ctx.CC(0).getText());
    Symbol arg1 = mkCharClass(ctx.CC(1).getText());

    FollowedBy ret = new FollowedBy(arg0, arg1);

    return ret;

  }

  // (Regex) .* (Regex) 
  @Override
  public Object visitFollowedBy1(FollowedBy1Context ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex(0));
    Symbol arg1 = (Symbol) visit(ctx.regex(1));

    FollowedBy ret = new FollowedBy(arg0, arg1);

    return ret;

  }

  // (Regex)*
  @Override
  public Object visitKleeneStar(KleeneStarContext ctx) {

    Symbol arg0 = (Symbol) visit(ctx.regex());

    Repeat ret = new Repeat(arg0, 0);

    return ret;

  }

  // \b Regex \b 
  @Override
  public Object visitWord(WordContext ctx) {

    Symbol ret = (Symbol) visit(ctx.regex());

    return ret;

  }

}
