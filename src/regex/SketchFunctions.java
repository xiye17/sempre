package regex;

import edu.stanford.nlp.sempre.NameValue;
import java.io.*;

public class SketchFunctions {

  public static NameValue unarysketchop(NameValue arg0) {

    String id = "?{" + arg0.id + "}";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue constop(String arg0) {

    String id = "<" + arg0 + ">";

    NameValue ret = new NameValue(id);

    return ret;

  };
  
  public static NameValue orop(NameValue arg0, NameValue arg1) {
    String id = "or(" + arg0.id + "," + arg1.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue sepop(NameValue arg0, NameValue arg1) {
    String id = "sep(" + arg0.id + "," + arg1.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue concatop(NameValue arg0, NameValue arg1) {
    String id = "concat(" + arg0.id + "," + arg1.id + ")";
    
    NameValue ret = new NameValue(id);
    
    return ret;
  };

  public static NameValue listjoin(NameValue arg0, NameValue arg1) {
    String id = arg0.id + " " + arg1.id;

    NameValue ret = new NameValue(id);
    
    return ret;
  };


  public static NameValue notcontainop(NameValue arg0) {

    String id = "not(contain(" + arg0.id + "))";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue containop(NameValue arg0) {

    String id = "contain(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue startwithop(NameValue arg0) {

    String id = "startwith(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue endwithop(NameValue arg0) {

    String id = "endwith(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

  public static NameValue repeatop(Integer arg0, NameValue arg1) {

    String id = "repeat(" + arg1.id + "," + arg0 + ")";

    NameValue ret = new NameValue(id);

    return ret;
  };

  public static NameValue repeatrangeop(NameValue arg0, Integer arg1, Integer arg2) {

    String id = "repeatrange(" + arg0.id + "," + arg1 + "," + arg2 + ")";

    NameValue ret = new NameValue(id);

    return ret;
  };

  public static NameValue notop(NameValue arg0) {

    String id = "not(" + arg0.id + ")";

    NameValue ret = new NameValue(id);

    return ret;

  };

}
