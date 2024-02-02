package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeElement;

public class BinaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtCodeElement element) {
        return element instanceof CtBinaryOperator;
    }

    @Override
    public void mutate(CtCodeElement elementToMutate, Scope scope) {

    }

}
