package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.helper.LocalVarHelper;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.Set;

public class DeclareWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        Set<CtTypeReference<?>> candidateTypes = SpoonQueries.getCandidateCyclicTypes(block, LocalVarHelper.WORKLIST_VAR_NAME);
        return !candidateTypes.isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        Set<CtTypeReference<?>> candidateTypes = SpoonQueries.getCandidateCyclicTypes(blockGene, LocalVarHelper.WORKLIST_VAR_NAME);
        CtTypeReference<?> chosenType = candidateTypes.stream().findAny().get();

        CtLocalVariable<?> visitedSet = SpoonFactory.createWorkListDeclaration(chosenType);
        blockGene.insertBegin(visitedSet);
    }


}
