package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
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

    CtVariable<?> worklist;
    CtMethod<?> traversal;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        traversal = RandomUtils.getRandomElement(traversals);
        worklist = TemplateHelper.getTraversalWorklistVariable(traversal);
        if (worklist == null) {
            return false;
        }

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtVariable<?> visitedSet = TemplateHelper.getTraversalVisitedElementsVariable(traversal);
        CtVariable<?> currentVar = TemplateHelper.getTraversalCurrentVariable(traversal);
        CtTypeReference<?> traversedNode = currentVar.getType();

        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(traversedNode);
        List<CtVariable<?>> newLoopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        List<CtIf> newIfs = WorklistTraversalTemplate.createIfsForLoopFields(newLoopFields, currentVar, visitedSet, worklist);

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
    }


}
