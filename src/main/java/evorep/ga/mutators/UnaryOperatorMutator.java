package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.declaration.CtElement;

public class UnaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtElement element) {
        return element instanceof CtUnaryOperator;
    }

    @Override
    public void mutate(CtElement elementToMutate, Scope scope) {

    }

}
