package evorep.ga.mutators;

import evorep.ga.randomgen.ReferenceExpressionGenerator;
import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;

public class VariableReadMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtVariableRead;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtVariableRead<?> varRead = (CtVariableRead<?>) gene;
        return ReferenceExpressionGenerator.generateRandomVarReadOfType(scope.getAllVariables(), varRead.getType());
    }

}
