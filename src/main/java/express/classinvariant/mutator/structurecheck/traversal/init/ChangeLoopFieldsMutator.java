package express.classinvariant.mutator.structurecheck.traversal.init;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.WorklistTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class ChangeLoopFieldsMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        return !traversals.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));

        CtVariable<?> worklist = SpoonQueries.getTraversalWorklistVariable(traversal);
        CtVariable<?> visitedSet = SpoonQueries.getTraversalSetParameter(traversal);
        CtVariable<?> currentVar = SpoonQueries.getTraversalCurrentVariable(traversal);
        CtTypeReference<?> traversedNode = currentVar.getType();

        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(traversedNode);
        List<CtVariable<?>> newLoopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        List<CtIf> newIfs = WorklistTraversalTemplate.createIfsForLoopFields(newLoopFields, currentVar, visitedSet, worklist, RandomUtils.nextBoolean());

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
