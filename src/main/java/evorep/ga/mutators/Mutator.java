package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;

interface Mutator {

    boolean isApplicable(CtCodeElement gene);

    CtCodeElement mutate(CtCodeElement gene, Scope scope);

}
