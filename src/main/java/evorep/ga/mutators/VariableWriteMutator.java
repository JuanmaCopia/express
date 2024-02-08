package evorep.ga.mutators;

import evorep.spoon.scope.Scope;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableWrite;

public class VariableWriteMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtVariableWrite;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtVariableWrite<?> varWrite = (CtVariableWrite<?>) gene;
        return ReferenceExpressionGenerator.generateRandomVarWriteOfType(scope.getLocalVariables(), varWrite.getType());
    }

}
