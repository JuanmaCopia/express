package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

public class BinaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtElement element) {
        return element instanceof CtBinaryOperator;
    }

    @Override
    public void mutate(CtElement elementToMutate, Scope scope) {

    }

}
