package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonQueries;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedCurrentOnArrayTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> arrayTraversal;
    CtExpression<Boolean> condition;

    CtLocalVariable<?> visitedSetVar;
    boolean mustDeclareVisitedSet = false;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (arrayTraversals.isEmpty())
            return false;

        arrayTraversal = RandomUtils.getRandomElement(arrayTraversals);
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(
                arrayTraversal.getBody(), LocalVarHelper.CURRENT_VAR_NAME
        );

        mustDeclareVisitedSet = false;
        visitedSetVar = TemplateHelper.getTraversalVisitedElementsVariable(arrayTraversal);
        if (visitedSetVar == null) {
            mustDeclareVisitedSet = true;

            CtVariable<?> mapOfVisitedParameter = TemplateHelper.getMapOfVisitedParameter(arrayTraversal);
            CtTypeReference<?> arraySubtype = TemplateHelper.getArrayTraversalElementType(arrayTraversal);
            visitedSetVar = TemplateHelper.createVisitedElementsSet(mapOfVisitedParameter, arraySubtype);
        }
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, currentDeclaration);
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);

        condition = addToSetInvocation;
        return !SpoonQueries.checkAlreadyExist(condition, arrayTraversal.getBody());
    }

    @Override
    public void mutate(ClassInvariantState state) {
        if (mustDeclareVisitedSet) {
            arrayTraversal.getBody().insertBegin(visitedSetVar);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(arrayTraversal.getBody());
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("CheckVisitedCurrentMutator:\n" + arrayTraversal.getBody());
    }


}
