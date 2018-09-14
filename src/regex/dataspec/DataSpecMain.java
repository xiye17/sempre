package regex.dataspec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;

public class DataSpecMain {

  public static String turkInputFilePath = "regex/data/turk/spec-train.txt";
  public static String turkOutputFilePath = "regex/data/turk/r-train.txt";

  public static void main(String[] args) {

    DataSpecMain main = new DataSpecMain();

    main.run(turkInputFilePath, turkOutputFilePath);

  }

  public void run(String inputFilePath, String outputFilePath) {

    Generator generator = new Generator();

    StringBuilder sb = new StringBuilder();

    // convert data 
    {
      try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFilePath)))) {

        int i = 1;

        for (String line = br.readLine(); line != null;) {

          line = line.replaceAll(" ", "");

          System.out.println("--------------------------");

          System.out.println("Process line " + i ++);

          System.out.println("Input: " + line);

          // convert to specification 
          String out = (String) generator.generate(line);

          System.out.println("Output: " + out);

          sb.append(out);

          line = br.readLine();

          if (line == null || line.isEmpty()) break;

          sb.append("\n");

        }

        br.close();

      } catch (Exception exception) {

        exception.printStackTrace();

      }

    }

    // write output 
    {
      try {

        PrintWriter out = new PrintWriter(outputFilePath);

        out.println(sb.toString());

        out.close();

      } catch (Exception e) {

        e.printStackTrace();

      }

    }

  }

  public void test1() {
    Generator g = new Generator();

    String spec = "and(fb:en.low,fb:en.cap)";
    System.out.println("Spec: " + spec);
    String out = g.generate(spec);
    System.out.println("Output: " + out);
    RegExp r = new RegExp(out);
    Automaton a = r.toAutomaton();

    String spec1 = "fb:en.num";
    System.out.println("Spec: " + spec1);
    String out1 = g.generate(spec1);
    System.out.println("Output: " + out1);
    RegExp r1 = new RegExp(out1);
    Automaton a1 = r1.toAutomaton();

    System.out.println(a.equals(a1));
  }

}
