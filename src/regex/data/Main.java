package regex.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import regex.SpecLanguage.Symbol;

public class Main {

  public static String turkInputFilePath = "regex/data/turk/targ-train.txt";
  public static String turkOutputFilePath = "regex/data/turk/spec-train.txt";

  public static void main(String[] args) {

    Main main = new Main();

//    String deepRegexDataFilePath = args[0];
//    String resnaxDataFilePath = args[1];

    String deepRegexDataFilePath = turkInputFilePath;
    String sempreDataFilePath = turkOutputFilePath;

    main.run(deepRegexDataFilePath, sempreDataFilePath);

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

          // change [<NUM>] to <NUM> 
          line = line.replace("[<", "<");
          line = line.replace(">]", ">");

          // convert to specification 
          Symbol spec = (Symbol) generator.generate(line);

          System.out.println("Output: " + spec);

          sb.append(spec);

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

}
