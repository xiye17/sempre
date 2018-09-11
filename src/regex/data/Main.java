package regex.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import regex.SpecLanguage.Symbol;

public class Main {

  public static String turkInputFilePath = "regex/data/turk/targ-test.txt";
  public static String turkOutputFilePath = "regex/data/turk/spec-test.txt";

  public static String utteranceFilePath = "regex/data/turk/utterance.txt";
  public static String specFilePath = "regex/data/turk/spec.txt";
  public static String turkExampleFilePath = "regex/data/turk/regex.examples";

  public static void main(String[] args) {

    Main main = new Main();

//    main.generateSpec(turkInputFilePath, turkOutputFilePath);

    main.generateTrainExample(utteranceFilePath, specFilePath, turkExampleFilePath);

  }

  public void generateSpec(String inputFilePath, String outputFilePath) {

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

          // change [<NUM>] to <NUM> 
          line = line.replace("[<", "<");
          line = line.replace(">]", ">");

          // convert to specification 
          Symbol spec = (Symbol) generator.generate(line);

          System.out.println("Output: " + spec);

          sb.append(spec.toSempreName());

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

  public void generateTrainExample(String utteranceFilePath, String specFilePath, String outputFilePath) {

    StringBuilder sb = new StringBuilder();

    {
      try (BufferedReader utteranceBr = new BufferedReader(new FileReader(new File(utteranceFilePath)))) {

        BufferedReader specBr = new BufferedReader(new FileReader(new File(specFilePath)));

        int i = 1;

        String utteranceLine = utteranceBr.readLine();
        String specLine = specBr.readLine();

        for (; utteranceLine != null;) {

          utteranceLine = utteranceLine.replace("\"", "\\\"");

          System.out.println("--------------------------");

          System.out.println("Process line " + i ++);

          System.out.println("Utterance: " + utteranceLine);

          System.out.println("Spec: " + specLine);

          String output = "(example (utterance \"" + utteranceLine.trim() + "\") (targetValue (name \"" + specLine + "\")))";

          System.out.println("Output: " + output);

          sb.append(output);

          utteranceLine = utteranceBr.readLine();

          specLine = specBr.readLine();

          if (utteranceLine == null || utteranceLine.isEmpty()) break;

          sb.append("\n");

        }

        utteranceBr.close();
        specBr.close();

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

}
