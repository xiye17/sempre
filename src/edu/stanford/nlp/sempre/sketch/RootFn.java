package edu.stanford.nlp.sempre.sketch;

import edu.stanford.nlp.sempre.*;

public class RootFn extends SemanticFn {
    public DerivationStream call(Example ex, final Callable c) {
        return new SingleDerivationStream() {
            @Override
            public Derivation createDerivation() {
            if (c.child(0).start != 0) return null;

            String arg0 = Formulas.getString(c.child(0).formula);
            String arg1 = Formulas.getString(c.child(1).formula);
//            System.out.println("ROOT FN " + arg0 + " " + arg1);
            NameValue formula = new NameValue(arg1, arg0);
            return new Derivation.Builder()
                    .withCallable(c)
                    .formula(new ValueFormula<>(formula))
                    .createDerivation();
            }
        };
    }
}
