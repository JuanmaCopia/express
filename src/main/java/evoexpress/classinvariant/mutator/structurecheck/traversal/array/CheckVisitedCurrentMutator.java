package evoexpress.classinvariant.mutator.structurecheck.traversal.array;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedCurrentMutator implements ClassInvariantMutator {

    CtMethod<?> arrayTraversal;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (arrayTraversals.isEmpty())
            return false;

        arrayTraversal = Utils.getRandomElement(arrayTraversals);
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(
                arrayTraversal.getBody(), LocalVarHelper.CURRENT_VAR_NAME
        );
        CtVariable<?> visitedSetVar = SpoonQueries.getVisitedSetParameter(arrayTraversal);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, currentDeclaration);
        condition = SpoonFactory.negateExpresion(addToSetInvocation);
        return !SpoonQueries.checkAlreadyExist(condition, arrayTraversal.getBody());
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(arrayTraversal.getBody());
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("CheckVisitedCurrentMutator:\n" + arrayTraversal.getBody());
        return true;
    }


}
