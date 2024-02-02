package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtUnaryOperator;

public class UnaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtCodeElement element) {
        return element instanceof CtUnaryOperator;
    }

    @Override
    public void mutate(CtCodeElement elementToMutate, Scope scope) {

    }

}
