package regex;

//
// Specification language grammar 
//
// Phi := 
// <NUM> | <LET> | <ANY> | <VOW> | <CAP> | <LOW> | <M0> | <M1> | <M2> | <M3> 
// | Contains( Phi ) 
// | StartsWith( Phi ) 
// | EndsWith( Phi ) 
// | Repeat( Phi, INT ) 
// | FollowedBy( Phi, Phi ) 
// | Not( Phi ) 
// | And( Phi, Phi ) 
// | Or( Phi, Phi ) 
//
public class SpecLanguage {

  public static abstract class Symbol {

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();

    public abstract String toSempreName();

  }

  public static abstract class TerminalSymbol extends Symbol {

  }

  public static abstract class NonterminalSymbol extends Symbol {

  }

  // <NUM> ... 
  public static final class CharClass extends TerminalSymbol {

    public final String name;

    public CharClass(String name) {
      this.name = name;
    }

    @Override
    public int hashCode() {
      return this.name.hashCode() << 1;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof CharClass)) return false;
      CharClass other = (CharClass) o;
      return other.name.equals(this.name);
    }

    @Override
    public String toString() {
      return this.name;
    }

    @Override
    public String toSempreName() {

      String ret = null;

      if ("<NUM>".equals(this.name)) {
        ret = "fb:en.num";
      } else if ("<CAP>".equals(this.name)) {
        ret = "fb:en.cap";
      } else if ("<VOW>".equals(this.name)) {
        ret = "fb:en.vow";
      } else if ("<LET>".equals(this.name)) {
        ret = "fb:en.let";
      } else if ("<LOW>".equals(this.name)) {
        ret = "fb:en.low";
      } else if ("<ANY>".equals(this.name)) {
        ret = "fb:en.any";
      } else if ("<M0>".equals(this.name)

          || "<M1>".equals(this.name)

          || "<M2>".equals(this.name)

          || "<M3>".equals(this.name)) {
        ret = "fb:en.const";
      } else {

        System.out.println(this.name);
        throw new RuntimeException();

      }

      assert ret != null;

      return ret;

    }

  }

  // Contains( Phi ) 
  public static final class Contains extends NonterminalSymbol {

    public final Symbol arg0;

    public Contains(Symbol arg0) {
      this.arg0 = arg0;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 2;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Contains)) return false;
      Contains other = (Contains) o;
      return other.arg0.equals(this.arg0);
    }

    @Override
    public String toString() {
      return "Contains(" + this.arg0 + ")";
    }

    @Override
    public String toSempreName() {
      return "contain(" + this.arg0.toSempreName() + ")";
    }

  }

  // StartsWith( Phi ) 
  public static final class StartsWith extends NonterminalSymbol {

    public final Symbol arg0;

    public StartsWith(Symbol arg0) {
      this.arg0 = arg0;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 3;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof StartsWith)) return false;
      StartsWith other = (StartsWith) o;
      return other.arg0.equals(this.arg0);
    }

    @Override
    public String toString() {
      return "StartsWith(" + this.arg0 + ")";
    }

    @Override
    public String toSempreName() {
      return "startwith(" + this.arg0.toSempreName() + ")";
    }

  }

  // EndsWith( Phi ) 
  public static final class EndsWith extends NonterminalSymbol {

    public final Symbol arg0;

    public EndsWith(Symbol arg0) {
      this.arg0 = arg0;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 4;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof EndsWith)) return false;
      EndsWith other = (EndsWith) o;
      return other.arg0.equals(this.arg0);
    }

    @Override
    public String toString() {
      return "EndsWith(" + this.arg0 + ")";
    }

    @Override
    public String toSempreName() {
      return "endwith(" + this.arg0.toSempreName() + ")";
    }

  }

  // Repeat( Phi, INT ) 
  public static final class Repeat extends NonterminalSymbol {

    public final Symbol arg0;
    public final int arg1;

    public Repeat(Symbol arg0, int arg1) {
      this.arg0 = arg0;
      this.arg1 = arg1;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 5 + this.arg1;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Repeat)) return false;
      Repeat other = (Repeat) o;
      return other.arg0.equals(this.arg0) && other.arg1 == this.arg1;
    }

    @Override
    public String toString() {
      return "Repeat(" + this.arg0 + "," + this.arg1 + ")";
    }

    @Override
    public String toSempreName() {
      return "repeat(" + this.arg0.toSempreName() + "," + this.arg1 + ")";
    }

  }

  // FollowedBy( Phi, Phi ) 
  public static final class FollowedBy extends NonterminalSymbol {

    public final Symbol arg0;
    public final Symbol arg1;

    public FollowedBy(Symbol arg0, Symbol arg1) {
      this.arg0 = arg0;
      this.arg1 = arg1;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 7 + this.arg1.hashCode() << 3;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof FollowedBy)) return false;
      FollowedBy other = (FollowedBy) o;
      return other.arg0.equals(this.arg0) && other.arg1.equals(this.arg1);
    }

    @Override
    public String toString() {
      return "FollowedBy(" + this.arg0 + "," + this.arg1 + ")";
    }

    @Override
    public String toSempreName() {
      return "followedby(" + this.arg0.toSempreName() + "," + this.arg1.toSempreName() + ")";
    }

  }

  // Not( Phi ) 
  public static final class Not extends NonterminalSymbol {

    public final Symbol arg0;

    public Not(Symbol arg0) {
      this.arg0 = arg0;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 3;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Not)) return false;
      Not other = (Not) o;
      return other.arg0.equals(this.arg0);
    }

    @Override
    public String toString() {
      return "Not(" + this.arg0 + ")";
    }

    @Override
    public String toSempreName() {
      return "not(" + this.arg0.toSempreName() + ")";
    }

  }

  // And( Phi, Phi ) 
  public static final class And extends NonterminalSymbol {

    public final Symbol arg0;
    public final Symbol arg1;

    public And(Symbol arg0, Symbol arg1) {
      this.arg0 = arg0;
      this.arg1 = arg1;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 7 + this.arg1.hashCode() << 3;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof And)) return false;
      And other = (And) o;
      return other.arg0.equals(this.arg0) && other.arg1.equals(this.arg1);
    }

    @Override
    public String toString() {
      return this.arg0 + "&" + this.arg1;
    }

    @Override
    public String toSempreName() {
      return "and(" + this.arg0.toSempreName() + "," + this.arg1.toSempreName() + ")";
    }

  }

  // Or( Phi, Phi ) 
  public static final class Or extends NonterminalSymbol {

    public final Symbol arg0;
    public final Symbol arg1;

    public Or(Symbol arg0, Symbol arg1) {
      this.arg0 = arg0;
      this.arg1 = arg1;
    }

    @Override
    public int hashCode() {
      return this.arg0.hashCode() << 7 + this.arg1.hashCode() << 5;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Or)) return false;
      Or other = (Or) o;
      return other.arg0.equals(this.arg0) && other.arg1.equals(this.arg1);
    }

    @Override
    public String toString() {
      return this.arg0 + "|" + this.arg1;
    }

    @Override
    public String toSempreName() {
      return "or(" + this.arg0.toSempreName() + "," + this.arg1.toSempreName() + ")";
    }

  }

}
