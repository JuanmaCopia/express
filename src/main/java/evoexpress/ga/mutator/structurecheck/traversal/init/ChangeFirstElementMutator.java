package evoexpress.ga.mutator.structurecheck.traversal.init;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class ChangeFirstElementMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("traverse_"))
            return false;
        return !SpoonQueries.getTraversals(individual.getCtClass()).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        CtMethod<?> traversal = blockGene.getParent(CtMethod.class);

        List<CtParameter<?>> params = traversal.getParameters();
        CtVariable<?> parentOfFirstElement = params.get(params.size() - 2);

        CtLocalVariable<?> firstElement = (CtLocalVariable<?>) traversal.getElements(
                e -> e instanceof CtLocalVariable<?> var &&
                        var.getSimpleName().equals(LocalVarHelper.FIRST_ELEMENT_VAR_NAME)
        ).get(0);

        CtVariableRead<?> firstElemRead = (CtVariableRead<?>) firstElement.getAssignment();
        CtTypeReference<?> typeOfFirstElem = firstElemRead.getType();

        String[] fields = firstElemRead.toString().split("\\.");
        String fieldName = fields[fields.length - 1];

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypegraphOfNode(typeOfFirstElem);
        List<CtVariable<?>> candidateFields = typeGraph.getOutgoingFields(parentOfFirstElement.getType()).stream().filter(
                field -> field.getType().equals(typeOfFirstElem) && !field.getSimpleName().equals(fieldName)
        ).toList();
        if (candidateFields.isEmpty()) {
            return false;
        }

        CtVariable<?> chosenField = candidateFields.get(RandomUtils.nextInt(candidateFields.size()));

        CtFieldRead newFirstElementRead = SpoonFactory.createFieldRead(parentOfFirstElement, chosenField);
        firstElement.setAssignment(newFirstElementRead);

        //System.err.println("ChangeTraverseInitialFieldMutator: " + chosenField.getSimpleName() + " instead of " + fieldName);
        //System.err.println("Result: \n" + chosenTraversal);

        return true;
    }


}
