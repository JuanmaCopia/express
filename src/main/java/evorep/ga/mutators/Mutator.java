package evorep.ga.mutators;

import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtCodeElement;

public interface Mutator {

    boolean isApplicable(CtCodeElement gene);

    CtCodeElement mutate(CtCodeElement gene, Scope scope);

}
