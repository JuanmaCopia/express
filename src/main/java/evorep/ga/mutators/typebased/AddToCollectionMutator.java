package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class AddToCollectionMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        List<CtLocalVariable<?>> traversalCollections = SpoonQueries.getWorklistDeclared(block);
        traversalCollections.addAll(SpoonQueries.getVisitedSetDeclared(block));

        return !traversalCollections.isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        
        List<CtLocalVariable<?>> traversalCollections = SpoonQueries.getWorklistDeclared(blockGene);
        traversalCollections.addAll(SpoonQueries.getVisitedSetDeclared(blockGene));

        CtLocalVariable<?> chosenCollection = traversalCollections.stream().findAny().get();
        CtTypeReference<?> collectionSubtype = chosenCollection.getType().getActualTypeArguments().get(0);

        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        List<CtField<?>> candidateFields = typesGraph.getOutgoingFields(typesGraph.getRoot());
        candidateFields = SpoonQueries.filterFieldsByType(candidateFields, collectionSubtype);
        CtField<?> chosenField = candidateFields.stream().findAny().get();

        CtInvocation<?> addToCollectionCall = SpoonFactory.createInvocation(chosenCollection, "add", collectionSubtype, chosenField);

        chosenCollection.insertAfter(addToCollectionCall);
    }


}