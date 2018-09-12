package regex;

import edu.stanford.nlp.sempre.NameValue;

public class RegexFunctions {

  public static NameValue contain(NameValue arg0) {

    String id = "contain(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue and(NameValue arg0, NameValue arg1) {

    String id = "and(" + arg0.id + "," + arg1.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue startwith(NameValue arg0) {

    String id = "startwith(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue endwith(NameValue arg0) {

    String id = "endwith(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue repeat(NameValue arg0, Integer arg1) {
    
    String id = "repeat(" + arg0.id + "," + arg1 + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue followedby(NameValue arg0, NameValue arg1) {
    String id = "followedby(" + arg0.id + "," + arg1.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue not(NameValue arg0) {
    String id = "not(" + arg0.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue or(NameValue arg0, NameValue arg1) {
    String id = "or(" + arg0.id + "," + arg1.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  }

}
