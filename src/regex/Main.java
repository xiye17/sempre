package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import edu.stanford.nlp.sempre.Builder;
import edu.stanford.nlp.sempre.Dataset;
import edu.stanford.nlp.sempre.Learner;
import edu.stanford.nlp.sempre.Master;
import edu.stanford.nlp.sempre.Session;
import fig.basic.LogInfo;
import fig.exec.Execution;

public class Main implements Runnable {

  public String filePath = "benchmarks/test/src.txt";

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

          master.processQuery(session, line);

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