package regex.test;

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
import edu.stanford.nlp.sempre.Session;
import fig.basic.LogInfo;
import fig.exec.Execution;
import regex.dataspec.Generator;

public class Test implements Runnable {

  String specFilePath = "regex/data/t/spec-test.txt";
  String srcFilePath = "regex/data/t/src-test.txt";
  String outputFilePath = "regex/data/t/pred-test.txt";

  public static void main(String[] args) {

    Test t = new Test();

    Execution.run(args, "test.Test", t, Master.getOptionsParser());

  }

  @Override
  public void run() {

    Builder builder = new Builder();
    builder.build();

    Master master = new Master(builder);

    Session session = master.getSession("stdin");

    int currIndx = 1;

    int coverageCount = 0;
    int accurateCount = 0;

    Generator g = new Generator();

    try (PrintWriter outputFile = new PrintWriter(outputFilePath)) {

      try (BufferedReader specFile = new BufferedReader(new FileReader(new File(this.specFilePath)))) {
        try (BufferedReader srcFile = new BufferedReader(new FileReader(new File(this.srcFilePath)))) {

          //
          //
          //

          for (String utterance = srcFile.readLine(); utterance != null;) {

            outputFile.println("=======================================================");

            outputFile.println("Test on utterance " + currIndx + " \n" + utterance);

            String gtLine = specFile.readLine();

            outputFile.println("Ground truth: " + gtLine);

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
              String topPred = "";
              List<Derivation> derivs = null;
              {

                Master.Response response = master.processQuery(session, utterance);

                derivs = response.ex.getPredDerivations();

                for (int i = 0; i < derivs.size(); i ++) {

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

                  // update top prediction 
                  if (i == 0) {
                    topPred = subDeriv;
                  }

                }

                // prints 
                outputFile.println("Top prediction: " + topPred);

              }

              assert (!derivToCount.isEmpty());
              assert (!topPred.equals(""));

              //
              //
              //
              // measure coverage and accuracy based on semantic equivalence 
              //
              //
              // 
              {

                Automaton gta = (new RegExp(g.generate(gtLine))).toAutomaton();

                // coverage 
                {
                  boolean covered = false;

                  for (String deriv : derivToCount.keySet()) {
                    String s = g.generate(deriv);
                    RegExp r = new RegExp(s);
                    Automaton a = r.toAutomaton();
                    if (a.equals(gta)) {
                      covered = true;
                      break;
                    }
                  }

                  if (covered) {
                    outputFile.println("Covered");
                    coverageCount ++;
                  } else {
                    outputFile.println("Not covered");
                  }
                }

                // accuracy 
                {
                  String s = g.generate(topPred);
                  RegExp r = new RegExp(s);
                  Automaton a = r.toAutomaton();
                  if (a.equals(gta)) {
                    outputFile.println("Accurate");
                    accurateCount ++;
                  } else {
                    outputFile.println("Not accurate");
                  }
                }

              }

              //
              // more prints 
              // 
              {
                outputFile.println("All " + derivToCount.size() + " derivations and their counts: ");
                for (String k : derivToCount.keySet()) {
                  int v = derivToCount.get(k);
                  outputFile.println("  " + k + " : " + v);
                }
              }

              {

                for (Derivation deriv : derivs) {

                  outputFile.println("--------------------------------");

                  outputFile.println(deriv.getFormula());

                  outputFile.println(deriv.getValue());

                  StringBuilder sb = new StringBuilder();
                  printDeriv(utterance, deriv, "", sb);
                  outputFile.println(sb.toString());

                  outputFile.println("--------------------------------");

                }

              }

              //
              //
              //

              utterance = srcFile.readLine();

              if (utterance == null || utterance.isEmpty()) break;

              currIndx ++;

            } catch (Throwable t) {

              while (LogInfo.getIndLevel() > indent)
                LogInfo.end_track();
              t.printStackTrace();

            }

          }

          //
          {
            outputFile.println("=======================================================");
            outputFile.println("=======================================================");
            outputFile.println("=======================SUMMARY=========================");
            outputFile.println("=======================================================");
            outputFile.println("Total: " + currIndx);
            outputFile.println("Covered: " + coverageCount);
            outputFile.println("Accurate: " + accurateCount);
          }

          //
          //
          //

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void printDeriv(String utterance, Derivation deriv, String prefix, StringBuilder sb) {

    sb.append(prefix + "|_");
    sb.append(deriv.getRule());
    sb.append(" [" + deriv.start + ", " + deriv.end + "]");
    sb.append("  " + deriv.getFormula());
    sb.append("\n");

    for (Derivation child : deriv.getChildren()) {
      printDeriv(utterance, child, prefix + "  ", sb);
    }

  }

}
