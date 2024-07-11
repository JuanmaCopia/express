package evoexpress.ga.mutator.structurecheck.traversal.trav;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.template.WorklistTraversal;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class ChangeLoopFieldsMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("traverse_"))
            return false;
        return !SpoonQueries.getTraversals(individual.getCtClass()).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        CtMethod<?> traversal = blockGene.getParent(CtMethod.class);

        CtVariable<?> worklist = SpoonQueries.getTraversalWorklistVariable(traversal);
        CtVariable<?> visitedSet = SpoonQueries.getTraversalSetVariable(traversal);
        CtVariable<?> currentVar = SpoonQueries.getTraversalCurrentVariable(traversal);
        CtTypeReference<?> traversedNode = currentVar.getType();

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypegraphOfNode(traversedNode);
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(traversedNode);
        List<CtVariable<?>> newLoopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        List<CtIf> newIfs = WorklistTraversal.createIfsForLoopFields(newLoopFields, currentVar, visitedSet, worklist, RandomUtils.nextBoolean());

        CtBlock<?> traversalBody = traversal.getBody();

        List<CtIf> traverseIfs = SpoonQueries.getTraversalIfsForTraversedFields(traversalBody);
        for (CtIf oldIf : traverseIfs) {
            oldIf.delete();
        }

        CtStatement endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        for (CtIf newIf : newIfs) {
            endOfHandleCurrentComment.insertAfter(newIf);
        }

        traversal.setBody(traversalBody);

        //System.err.println("ChangeTraversalFieldsMutator AFTER: \n" + chosenTraversal);
        return true;
    }


}
