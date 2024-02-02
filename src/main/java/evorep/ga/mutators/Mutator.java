package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;

interface Mutator {

    boolean isApplicable(CtCodeElement element);

    void mutate(CtCodeElement elementToMutate, Scope scope);

}
