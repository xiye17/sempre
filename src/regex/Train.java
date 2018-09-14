package regex;

import edu.stanford.nlp.sempre.Builder;
import edu.stanford.nlp.sempre.Dataset;
import edu.stanford.nlp.sempre.Learner;
import edu.stanford.nlp.sempre.Master;
import fig.exec.Execution;

public class Train implements Runnable {

  @Override
  public void run() {

    Builder builder = new Builder();
    builder.build();

    Dataset dataset = new Dataset();
    dataset.read();

    Learner learner = new Learner(builder.parser, builder.params, dataset);
    learner.learn();

  }

  public static void main(String[] args) {

    Execution.execDir = "./tmplog/";

    Execution.run(args, "Train", new Train(), Master.getOptionsParser());
  }

}
