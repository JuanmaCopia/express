package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Set;

public class LoopOverCyclicVarMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.isCurrentVarDefined(block);
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        Set<CtVariableRead<?>> cyclicVarReads = SpoonQueries.getReacheableCyclicFieldReads(blockGene);
        CtVariableRead<?> chosenVarRead = cyclicVarReads.stream().findAny().get();
        CtTypeReference<?> cyclicNode = chosenVarRead.getVariable().getType();
        List<CtField<?>> loopFields = SpoonManager.getTypesGraph().getSelfCyclicFieldsOfNode(cyclicNode);
        CtField<?> chosenLoopField = loopFields.stream().findAny().get();

        List<CtStatement> statements = SpoonFactory.creteCyclicReferenceTraversal(chosenVarRead, chosenLoopField);

        CtStatement firstNonNullCheck = SpoonQueries.getFirstNonNullCheck(blockGene);
        assert firstNonNullCheck != null;
        for (CtStatement statement : statements) {
            firstNonNullCheck.insertBefore(statement);
        }
    }


}
