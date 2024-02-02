package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtInvocation;

public class InvocationMutator implements Mutator {

    public boolean isApplicable(CtCodeElement element) {
        return element instanceof CtInvocation;
    }

    @Override
    public void mutate(CtCodeElement elementToMutate, Scope scope) {

    }

/*    public void mutate(CtInvocation<?> invocation, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newInv = BooleanExpressionGenerator.generateRandomCollectionMethodCallExpression(fields, localVariables);
        invocation.replace(newInv);
    }*/
}
