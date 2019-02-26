package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import edu.stanford.nlp.sempre.Builder;
import edu.stanford.nlp.sempre.Derivation;
import edu.stanford.nlp.sempre.Master;
import edu.stanford.nlp.sempre.Parser;
import edu.stanford.nlp.sempre.Session;
import fig.basic.LogInfo;
import fig.exec.Execution;
import regex.dataspec.Generator;

public class TestDemo implements Runnable {

  public String dataset = null;
  public int beam = -1;

  public void runPrediction(
      //
      Master master, Session session,
      //
      String srcFilePath,
      //
      String specFilePath,
      //
      String outputFilePath) {

    int currIndx = 1;

    Generator g = new Generator();

    try (PrintWriter outputFile = new PrintWriter(outputFilePath)) {
      try (BufferedReader srcFile = new BufferedReader(new FileReader(new File(srcFilePath)))) {

        for (String lineStr = srcFile.readLine(); lineStr != null;) {

          // if (utterance == null) {
          // break;
          // }
          String[] fields = lineStr.split("\t", 2);
          String id = fields[0];
          String utterance = fields[1];
          // outputFile.println("=======================================================");
          // outputFile.println("Test on utterance " + currIndx + " : " + utterance);
          // outputFile.println("ID:"+id);
          // outputFile.println("Test on utterance " + currIndx + " : " + utterance);

          int indent = LogInfo.getIndLevel();

          try {

            //
            //
            //
            // construct candidate derivations
            // construct top prediction
            //
            //
            //
            Map<String, Integer> derivToCount = new HashMap<>();
            Map<String, Integer> derivToOrder = new HashMap<>();
            Map<Integer, String> orderToDeriv = new HashMap<>();

            String topPred = "";
            {

              Master.Response response = master.processQuery(session, utterance);

              List<Derivation> derivs = response.ex.getPredDerivations();

              for (int i = 0; i < derivs.size(); i++) {

                String derivString = ((derivs.get(i)).value).toString();
                String subDeriv = "";
                if (derivString.contains("\"")) {
                  subDeriv = derivString.split("\"")[1];
                } else {
                  subDeriv = derivString.split(" ")[1];
                  subDeriv = subDeriv.substring(0, subDeriv.indexOf(")"));
                }

                // update derivation-to-count map
                if (derivToCount.containsKey(subDeriv)) {
                  derivToCount.put(subDeriv, derivToCount.get(subDeriv) + 1);
                } else {
                  derivToCount.put(subDeriv, 1);
                }

                if (!derivToOrder.containsKey(subDeriv)) {
                  derivToOrder.put(subDeriv, i);
                  orderToDeriv.put(i, subDeriv);
                }

                // update top prediction
                if (i == 0) {
                  topPred = subDeriv;
                }

              }

              // prints
              // outputFile.println("Top prediction: " + topPred);

            }

            // assert (!derivToCount.isEmpty());
            // assert (!topPred.equals(""));

            if ((derivToCount.isEmpty()) || (topPred.equals(""))) {

              lineStr = srcFile.readLine();

              if (lineStr == null || lineStr.isEmpty())
                break;

              currIndx++;
              continue;
            }

            //
            //
            //
            // measure coverage and accuracy based on semantic equivalence
            //
            //
            //
            //
            // more prints
            //
            {
              outputFile.println(id + "\t" + derivToOrder.size());
              for (int i = 0; i < derivToOrder.size(); i++) {
                String v = orderToDeriv.get(i);
                outputFile.println(v + "\t" + i);
              }
            }

            lineStr = srcFile.readLine();

            if (lineStr == null || lineStr.isEmpty())
              break;

            currIndx++;

          } catch (Throwable t) {
            System.out.println("Excpetion at the outer try");
            while (LogInfo.getIndLevel() > indent)
              LogInfo.end_track();
            t.printStackTrace();

          }
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void run() {

    // parse our arguments
    {
      this.beam = Parser.opts.beamSize;
    }

    // run prediction
    {
      Builder builder = new Builder();
      builder.build();

      Master master = new Master(builder);

      Session session = master.getSession("stdin");

      // // test on train set
      // {
      //   String srcFilePath = "regex/data/" + this.dataset + "/src-train.txt";
      //   String specFilePath = "regex/data/" + this.dataset + "/spec-train.txt";
      //   String outputFilePath = "regex/data/" + this.dataset + "/" + this.beam + "-pred-train.txt";
      //   runPrediction(master, session, srcFilePath, specFilePath, outputFilePath);
      // }

      // test on test set
      {
        String srcFilePath = "regex/data/" + this.dataset + "/src-test.txt";
        String specFilePath = "regex/data/" + this.dataset + "/spec-test.txt";
        String outputFilePath = "regex/data/" + this.dataset + "/" + this.beam + "-pred-test.txt";
        runPrediction(master, session, srcFilePath, specFilePath, outputFilePath);
      }

    }

  }

  public static void main(String[] args) {

    TestDemo t = new TestDemo();

    // parse our own arguments
    {
      String dataset = args[args.length - 1];
      t.dataset = dataset;
    }

    // parse sempre arguments and run
    {
      String[] args1 = new String[args.length - 1];
      System.arraycopy(args, 0, args1, 0, args.length - 1);
      Execution.run(args1, "Test", t, Master.getOptionsParser());
    }

  }

}
