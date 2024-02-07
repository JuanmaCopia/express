package evorep.ga.mutators;

import evorep.ga.randomgen.LocalVarDeclarationGenerator;
import evorep.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;

public class DeclareVarRootBlockMutator implements Mutator {

    @Override
    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBlock;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtBlock block = (CtBlock) gene.clone();
        block.addStatement(0, LocalVarDeclarationGenerator.chooseLocalVarDeclaration(scope));
        return block;
    }
}
