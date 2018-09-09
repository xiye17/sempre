package regex;

import edu.stanford.nlp.sempre.NameValue;

public class RegexFunctions {

  public static NameValue contain(NameValue regex) {

    String id = "contain(" + regex.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

}
