package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.stanford.nlp.sempre.Builder;
import edu.stanford.nlp.sempre.Dataset;
import edu.stanford.nlp.sempre.Derivation;
import edu.stanford.nlp.sempre.Learner;
import edu.stanford.nlp.sempre.Master;
import edu.stanford.nlp.sempre.Parser;
import edu.stanford.nlp.sempre.Session;
import fig.basic.LogInfo;
import fig.exec.Execution;

public class Main implements Runnable {

//  public String filePath = "regex/data/test/src-train.txt";
//  public String src_filePath = "regex/data/test/src-t-2.txt";
  public String src_filePath = "";
//  public String filePath = "regex/data/test/src-c.txt";
//  public String gt_filePath = "regex/data/test/spec-train.txt";
//  public String spec_filePath = "regex/data/test/spec-t-2.txt";
  public String spec_filePath = "";
//  public String ig_filePath = "regex/data/test/ignore.txt";
//  public String noCoverage_filePath = "regex/data/test/noCoverage.txt";
  public String noCoverage_filePath = "";
//  public String stat_filePath = "regex/data/test/stats.txt";
  public String stat_filePath = "";
  
  int currIndx = 1;

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
    
    // findout file path
    String dPath = Dataset.opts.inPaths.get(0).getSecond();
    if(dPath.equals("regex/data/turk_1k/regex.examples")) {
      src_filePath = "regex/data/turk_1k/src-test.txt";
      spec_filePath = "regex/data/turk_1k/spec-test.txt";
      
      noCoverage_filePath = "b" + Parser.opts.beamSize + "ds1k_noCoverage";
      stat_filePath = "b" + Parser.opts.beamSize + "ds1k_stat";
      
    }
    
    else if(dPath.equals("regex/data/turk/regex.examples")) {
      src_filePath = "regex/data/turk/src-test.txt";
      spec_filePath = "regex/data/turk/spec-test.txt";
      
      noCoverage_filePath = "b" + Parser.opts.beamSize + "ds10k_noCoverage";
      stat_filePath = "b" + Parser.opts.beamSize + "ds10k_stat";
    }
    // for testing 
    else if(dPath.equals("regex/data/t/regex.examples")) {
      src_filePath = "regex/data/t/src-test.txt";
      spec_filePath = "regex/data/t/spec-test.txt";
      
      noCoverage_filePath = "b" + Parser.opts.beamSize + "ds1k_noCoverage";
      stat_filePath = "b" + Parser.opts.beamSize + "ds1k_stat";
      
    }
    
    int coverageCount = 0;
    int accurateCount = 0;
    
    List<Integer> noCoverageIndx = new ArrayList<Integer>();
    
    // stat: print the coverage, accuracy percentage and unique set count
    try(PrintWriter stat = new PrintWriter(stat_filePath)) {
            
      // noCoverage: print the benchmarks that are not able to covered      
      try(PrintWriter noCoverage = new PrintWriter(new FileOutputStream(new File(noCoverage_filePath), true))) {
        
        // brGt: read ground truth
        try(BufferedReader brGt = new BufferedReader(new FileReader(new File(spec_filePath)))) {
          
          // br: read source
          try (BufferedReader br = new BufferedReader(new FileReader(new File(src_filePath)))) {

            for (String line = br.readLine(); line != null;) {
              
              // read ground truth 
              String gtLine = brGt.readLine();

              int indent = LogInfo.getIndLevel();
              
              try {

                Master.Response response = master.processQuery(session, line);

                List<Derivation> derivations = response.ex.getPredDerivations();
                
                Set<String> derivStringSet = new HashSet<String>();
                
                String topPrediction = "";
                
                for(int i = 0; i < derivations.size(); i++) {
                  String derivString = ((derivations.get(i)).value).toString();
                  String subDeriv = "";
                  if(derivString.contains("\"")) {
                    subDeriv = derivString.split("\"")[1];
                  } else {
                    subDeriv = derivString.split(" ")[1];
                    subDeriv = subDeriv.substring(0, subDeriv.indexOf(")"));
                  }
                  derivStringSet.add(subDeriv);
                  
                  if(i == 0) {
                    topPrediction = subDeriv;
                  }
                  
                  System.out.println(subDeriv);
                }
                
                // read the ground truth for the current example
                System.out.println("gtline:" + gtLine);
                System.out.println("toppredict: " + topPrediction);
                
                // get the unique deriv set size and print to stat
                stat.println(currIndx + ": " + "unique deriv size = " + derivStringSet.size());
                
                // findout if the ground truth is contain in any of the derivation
                if(derivStringSet.contains(gtLine)) {
                  coverageCount++;
                } else {
                  noCoverageIndx.add(currIndx);
                  // output format: <benchmark indx>,<ground truth spec>,<top 1 deriviation>
                  noCoverage.println(currIndx + "," + gtLine + "," + topPrediction);
                }
                
                // findout if the ground truth is the one predicited at the top
                if(topPrediction.equals(gtLine)) {
                  accurateCount ++;
                }
             
              } catch (Throwable t) {

                while (LogInfo.getIndLevel() > indent)
                  LogInfo.end_track();
                t.printStackTrace();

              }

              line = br.readLine();

              if (line == null || line.isEmpty()) break;
              
              currIndx++;

            }

          } catch (Exception exception) {

            exception.printStackTrace();

          }
        }   
        catch(Exception e) {
          e.printStackTrace();
        }
      }
      catch(Exception e) {
        e.printStackTrace();
      }
      
      // output statistics
      stat.println("----------------------");
      stat.println("Statistics:");
      stat.println("----------------------");
      stat.println("coverage#: " + coverageCount);
      stat.println("accurate prediction#: " + accurateCount);
      stat.println("total #: " + currIndx);
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    Execution.run(args, "Main", new Main(), Master.getOptionsParser());
  }

}