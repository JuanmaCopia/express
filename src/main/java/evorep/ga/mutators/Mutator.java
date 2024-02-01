package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.declaration.CtElement;

interface Mutator {

    boolean isApplicable(CtElement element);

    void mutate(CtElement elementToMutate, Scope scope);

}
