package evorep.ga.mutators;

import evorep.ga.randomgen.ReferenceExpressionGenerator;
import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.code.CtVariableWrite;

public class VariableWriteMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtVariableRead;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtVariableWrite<?> varWrite = (CtVariableWrite<?>) gene;
        return ReferenceExpressionGenerator.generateRandomVarWriteOfType(scope.getAllVariables(), varWrite.getType());
    }

}
