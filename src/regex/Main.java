package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import edu.stanford.nlp.sempre.Builder;
import edu.stanford.nlp.sempre.Dataset;
import edu.stanford.nlp.sempre.Derivation;
import edu.stanford.nlp.sempre.Learner;
import edu.stanford.nlp.sempre.Master;
import edu.stanford.nlp.sempre.Session;
import fig.basic.LogInfo;
import fig.exec.Execution;

public class Main implements Runnable {

  public String filePath = "regex/data/test/src-train.txt";

  @Override
  public void run() {

    Builder builder = new Builder();
    builder.build();

    Dataset dataset = new Dataset();
    dataset.read();

    Learner learner = new Learner(builder.parser, builder.params, dataset);
    learner.learn();

    Master master = new Master(builder);

    Session session = master.getSession("stdin");

    try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {

      for (String line = br.readLine(); line != null;) {

        int indent = LogInfo.getIndLevel();
        try {

          Master.Response response = master.processQuery(session, line);

          // get derivations from response 
          // UNCOMMENT this to see how it prints 

//          List<Derivation> derivations = response.ex.getPredDerivations();
//
//          for (Derivation derivation : derivations) {

          
          // This prints: 
          // (name "contain(fb:en.let)") --> we want contain(fb:en.let) [extract the substring from first space to last "] 
          // (name fb:en.let) --> we want fb:en.let 
          //            System.out.println(derivation.value);

//            System.out.println(derivation);
//          }
//
//          assert false;

        } catch (Throwable t) {

          while (LogInfo.getIndLevel() > indent)
            LogInfo.end_track();
          t.printStackTrace();

        }

        line = br.readLine();

        if (line == null || line.isEmpty()) break;

      }

    } catch (Exception exception) {

      exception.printStackTrace();

    }

  }

  public static void main(String[] args) {
    Execution.run(args, "Main", new Main(), Master.getOptionsParser());
  }

}