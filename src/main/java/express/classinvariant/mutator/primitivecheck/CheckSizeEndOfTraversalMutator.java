package express.classinvariant.mutator.primitivecheck;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonManager;

public class CheckSizeEndOfTraversalMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        if (MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX).isEmpty())
            return false;

        return !SpoonManager.getSubjectTypeData().getIntegerPaths().isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
//        List<CtMethod<?>> traversalMethods = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
//        CtMethod<?> traversal = traversalMethods.get(RandomUtils.nextInt(traversalMethods.size()));
//        CtBlock<?> traversalBody = traversal.getBody();
//        if (SpoonQueries.getInitialSizeVariable(traversalBody) != null)
//            return false;
//
//        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
//        CtVariable<?> visitedSetVar = SpoonQueries.getVisitedSetParameter(traversal);
//
//        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(visitedSetVar, "size");
//        CtLocalVariable<?> initialSizeVar = SpoonFactory.createLocalVariable(LocalVarHelper.getInitialSizeVarName(), SpoonFactory.getTypeFactory().integerPrimitiveType(), sizeInvocation);
//
//        CtExpression<?> leftExpr = SpoonFactory.createBinaryExpression(sizeInvocation, initialSizeVar, BinaryOperatorKind.MINUS);
//
//        List<Path> candidates = SpoonManager.getTypeData().getIntegerPaths();
//        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
//        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();
//
//        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(leftExpr, chosenVarRead, BinaryOperatorKind.NE);
//        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
//            return false;
//
//        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
//
//        CtStatement beginOfTraversalComment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
//        beginOfTraversalComment.insertAfter(initialSizeVar);
//        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(traversalBody);
//        endOfTraversalComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + traversalBody);
    }


}
