package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtElement;

public class InvocationMutator implements Mutator {

    public boolean isApplicable(CtElement element) {
        return element instanceof CtInvocation;
    }

    @Override
    public void mutate(CtElement elementToMutate, Scope scope) {

    }

/*    public void mutate(CtInvocation<?> invocation, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newInv = BooleanExpressionGenerator.generateRandomCollectionMethodCallExpression(fields, localVariables);
        invocation.replace(newInv);
    }*/
}
