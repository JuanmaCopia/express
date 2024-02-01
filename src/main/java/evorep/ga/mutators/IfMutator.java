package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtElement;

public class IfMutator implements Mutator {

    public boolean isApplicable(CtElement element) {
        return element instanceof CtIf;
    }

    @Override
    public void mutate(CtElement elementToMutate, Scope scope) {

    }

/*    public void mutate(CtIf ifStatement, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newCondition = BooleanExpressionGenerator.generateRandomExpression(fields, localVariables);
        ifStatement.setCondition(newCondition);
    }*/
}
