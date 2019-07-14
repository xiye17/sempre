package edu.stanford.nlp.sempre;

import fig.basic.*;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SketchExecutor extends Executor {
    public static class Options {

        @Option(gloss = "synthesizer time out")
        public int timeout = 30;
    }

    public static Options opts = new Options();

    public SketchExecutor() {
        System.out.println("Using SketchExecutor");
    }

    // Main entry point.
    public Response execute(Formula formula, ContextValue context) {
        try {
            NameValue val = (NameValue) ((ValueFormula) formula).value;
            ProcessBuilder pb = new
                    ProcessBuilder("python", "demo/query.py", String.valueOf(opts.timeout), val.description, val.id);
            pb.redirectErrorStream(true);

            final Process p =pb.start();

            String line;
            String output = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                System.out.println("LINE: " + line);
                output = line;
            }
            p.waitFor();
            in.close();
            System.out.println("RESULT: " + output);
            return new Response((new NameValue(output)));
        } catch (Exception ex) {
            System.out.println("EXECUTION ERROR");
//            do nothing
        }
        return new Response((new NameValue("false")));
    }
}
