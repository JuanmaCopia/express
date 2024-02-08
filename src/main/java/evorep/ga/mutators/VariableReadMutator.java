package evorep.ga.mutators;

import evorep.scope.Scope;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableAccess;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.path.CtRole;

public class VariableReadMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtVariableRead && !gene.getRoleInParent().equals(CtRole.TARGET);
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtVariableRead<?> varRead = (CtVariableRead<?>) gene;
        //System.out.println("\nVariableReadMutator: " + varRead.toString());
        CtVariableAccess newGene = ReferenceExpressionGenerator.generateRandomVarReadOfType(scope.getAllVariables(), varRead.getType());
        if (newGene == null)
            return gene;
        return newGene;
    }

}
