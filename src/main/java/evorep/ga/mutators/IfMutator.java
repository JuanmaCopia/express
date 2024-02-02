package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtIf;

public class IfMutator implements Mutator {

    public boolean isApplicable(CtCodeElement element) {
        return element instanceof CtIf;
    }

    @Override
    public void mutate(CtCodeElement elementToMutate, Scope scope) {

    }

/*    public void mutate(CtIf ifStatement, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newCondition = BooleanExpressionGenerator.generateRandomExpression(fields, localVariables);
        ifStatement.setCondition(newCondition);
    }*/
}
