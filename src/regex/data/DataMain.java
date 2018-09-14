package regex.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import regex.SpecLanguage.Symbol;

public class DataMain {

  public static String turkInputFilePath = "../deep-regex/deep-regex-model/data_turk_eval_turk_spec/targ-test.txt";
  public static String turkOutputFilePath = "../deep-regex/deep-regex-model/data_turk_eval_turk_spec/spec-test.txt";

  public static String utteranceFilePath = "regex/data/turk_1k/utterance.txt";
  public static String specFilePath = "regex/data/turk_1k/spec.txt";
  public static String turkExampleFilePath = "regex/data/turk_1k/regex.examples";

  public static void main(String[] args) {

    DataMain main = new DataMain();

//    main.generateSempreSpec(turkInputFilePath, turkOutputFilePath);

    main.generateDeepRegexSpec(turkInputFilePath, turkOutputFilePath);

//    main.generateTrainExample(utteranceFilePath, specFilePath, turkExampleFilePath);

  }

  public void generateDeepRegexSpec(String inputFilePath, String outputFilePath) {

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

          String deepRegexName = spec.toDeepRegexName();

          System.out.println("DeepRegex: " + deepRegexName);

          sb.append(deepRegexName);

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

  public void generateSempreSpec(String inputFilePath, String outputFilePath) {

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

          String sempreName = spec.toSempreName();

          System.out.println("Sempre: " + sempreName);

          sb.append(sempreName);

          line = br.readLine();

          if (line == null || line.isEmpty()) break;

          sb.append("\n");

//          if (i == 5) assert false;

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
