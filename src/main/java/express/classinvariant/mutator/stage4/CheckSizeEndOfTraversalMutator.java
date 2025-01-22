package express.classinvariant.mutator.stage4;

import java.util.List;
import java.util.stream.Collectors;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.type.typegraph.TypeGraph;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

public class CheckSizeEndOfTraversalMutator implements ClassInvariantMutator {

    CtLocalVariable<?> initialSizeVar;
    CtExpression<Boolean> condition;
    CtBlock<?> traversalBody;
    CtLocalVariable<?> visitedSetVar;
    boolean sizeDeclared = false;
    CtMethod<?> traversal;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty())
            return false;

        traversal = RandomUtils.getRandomElement(traversals);

        traversalBody = traversal.getBody();

        List<CtLocalVariable<?>> localVars = SpoonQueries.getLocalVariablesMatchingPrefix(traversalBody, LocalVarHelper.INITIAL_SIZE_VAR_NAME);
        if (!localVars.isEmpty()) {
            sizeDeclared = true;
        } else {
            sizeDeclared = false;
        }

        CtVariable<?> traversedElement = TemplateHelper.getTraversedElementParameter(traversal);

        TypeGraph typeGraph = SpoonManager.getSubjectTypeData().getThisTypeGraph();

        List<Path> candidatePaths = typeGraph
                .computeSimplePathsForAlternativeVar(traversedElement).stream()
                .filter(p -> TypeUtils.isIntegerType(p.getTypeReference()) && p.size() < 3)
                .collect(Collectors.toList());

        CtVariable<?> thisInstance = MutatorHelper.getFieldByName(state.getCtClass(), LocalVarHelper.THIS_FIELD_NAME);
        List<Path> candidatePaths2 = typeGraph
                .computeSimplePathsForAlternativeVar(thisInstance).stream()
                .filter(p -> TypeUtils.isIntegerType(p.getTypeReference()) && p.size() < 3)
                .toList();

        candidatePaths.addAll(candidatePaths2);

        if (candidatePaths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(candidatePaths);

        visitedSetVar = TemplateHelper.getTraversalVisitedElementsVariable(traversal);
        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(visitedSetVar, "size");
        initialSizeVar = SpoonFactory.createLocalVariable(LocalVarHelper.INITIAL_SIZE_VAR_NAME, SpoonFactory.getTypeFactory().integerPrimitiveType(), sizeInvocation);

        CtExpression<?> sizeMinus = sizeInvocation;
        int minus = RandomUtils.nextInt(0, 3);
        if (minus > 0)
            sizeMinus = SpoonFactory.createBinaryExpression(sizeInvocation, minus, BinaryOperatorKind.MINUS);

        CtExpression<?> leftExpr = SpoonFactory.createBinaryExpression(sizeMinus, initialSizeVar, BinaryOperatorKind.MINUS);
        condition = SpoonFactory.createBinaryExpression(leftExpr, chosenPath.getVariableRead(), BinaryOperatorKind.NE);

        return !SpoonQueries.checkAlreadyExist(condition, traversalBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        if (!sizeDeclared) {
            visitedSetVar.insertAfter(initialSizeVar);
        }
        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(traversalBody);
        endOfTraversalComment.insertAfter(ifStatement);

        // System.err.println("CheckSizeEndOfTraversalMutator:\n" + ifStatement);
        // System.err.println("On traversal:" + traversal.getSimpleName());
        // System.err.println("Final Block:\n" + traversalBody);
    }

}
