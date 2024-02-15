package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.helper.LocalVarHelper;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

public class DeclareRootAdjacentLocalVarMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getCandidateFields(block).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        CtField<?> chosenField = SpoonQueries.getCandidateFields(blockGene).stream().findAny().get();
        CtLocalVariable<?> varDeclaration = SpoonFactory.createLocalVariable(
                LocalVarHelper.getVarName(),
                chosenField.getType(),
                chosenField
        );
        blockGene.insertBegin(varDeclaration);
    }


}
