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

}
