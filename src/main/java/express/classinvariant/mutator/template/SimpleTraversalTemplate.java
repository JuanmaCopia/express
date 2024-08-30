package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleTraversalTemplate {

    public static CtMethod<?> instantiate(Path initialField, CtVariable<?> loopField, int splitIndex, boolean checkCircular) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().booleanPrimitiveType();
        List<CtParameter<?>> parameters = createParameters(leftPath, initialField.getTypeReference());
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(leftPath.getTypeReference()), parameters);

        CtBlock<?> traversalBody = createTraversalBody(rightPath, parameters, loopField, checkCircular);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    private static List<CtParameter<?>> createParameters(Path leftPath, CtTypeReference<?> setSubtype) {
        List<CtParameter<?>> parameters = new ArrayList<>();
        CtVariable<?> setVar = SpoonFactory.createVisitedIdentitySetDeclaration(setSubtype);
        parameters.add((CtParameter<?>) SpoonManager.getSubjectTypeData().getThisVariable());
        parameters.add(SpoonFactory.createParameter(TypeUtils.convertGenericsToWildcard(leftPath.getTypeReference()), LocalVarHelper.TRAVERSED_ELEMENT_VAR_NAME));
        parameters.add(SpoonFactory.createParameter(setVar.getType(), LocalVarHelper.SET_VAR_NAME));
        return parameters;
    }

    public static String createMethodName(CtTypeReference<?> type) {
        return LocalVarHelper.TRAVERSAL_PREFIX + type.getSimpleName() + LocalVarHelper.MUTABLE_METHOD_SUFFIX;
    }


    private static CtBlock<?> createTraversalBody(Path firstElem, List<CtParameter<?>> params, CtVariable<?> loopField, boolean checkCircular) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtIf pathNullCheck = null;
        CtVariableRead<?> firstElementRead;
        if (!firstElem.isEmpty()) {
            CtVariable<?> initFieldParent = params.get(params.size() - 2);
            Path pathToFirstElement = new Path(initFieldParent, firstElem);
            CtExpression<Boolean> nullPathCheckCond = SpoonFactory.generateOrConcatenationOfNullComparisons(pathToFirstElement);
            pathNullCheck = SpoonFactory.createIfReturnTrue(nullPathCheckCond);
            firstElementRead = pathToFirstElement.getVariableRead();
        } else {
            CtVariable<?> firstElement = params.get(params.size() - 2);
            firstElementRead = SpoonFactory.createVariableRead(firstElement);
            CtExpression<Boolean> nullPathCheckCond = SpoonFactory.createNullComparisonClause(firstElement, BinaryOperatorKind.EQ);
            pathNullCheck = SpoonFactory.createIfReturnTrue(nullPathCheckCond);
        }

        CtTypeReference<?> firstElemType = TypeUtils.convertGenericsToWildcard(firstElementRead.getType());

        CtVariable<?> visitedSet = params.get(params.size() - 1);

        CtIf firstElemVisitedCheck = SpoonFactory.createVisitedCheck(visitedSet, firstElementRead, true);

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(body), firstElemType, firstElementRead);
        CtVariableRead<?> currentRead = SpoonFactory.createVariableRead(currentDeclaration);

        // create condition: current != null
        CtExpression<Boolean> whileCondition = SpoonFactory.createNullComparisonClause(currentRead, BinaryOperatorKind.NE);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create comment: // Handle current:
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));

        // Create comment: // Add children to worklist:
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        CtIf ifStatement = createIfForLoopField(loopField, currentDeclaration, visitedSet);
        whileBody.insertEnd(ifStatement);

        // Create assingment: current = current.<loopField>;
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentRead, loopField);
        CtAssignment<?, ?> assignmentToCurrent = SpoonFactory.createAssignment(currentDeclaration, loopFieldRead);

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));
        whileBody.insertEnd(assignmentToCurrent);

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(pathNullCheck);
        body.insertEnd(firstElemVisitedCheck);
        body.insertEnd(currentDeclaration);

        MutatorHelper.addImmutableComment(pathNullCheck);
        MutatorHelper.addImmutableComment(firstElemVisitedCheck);

        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        body.insertEnd(whileStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));

        if (checkCircular) {
            CtExpression<Boolean> whileExpression = whileStatement.getLoopingExpression();
            CtExpression<Boolean> comparisonToFirstElem = SpoonFactory.createBinaryExpression(loopFieldRead, firstElementRead, BinaryOperatorKind.NE);
            whileExpression = SpoonFactory.createBinaryExpression(whileExpression, comparisonToFirstElem, BinaryOperatorKind.AND);
            whileStatement.setLoopingExpression(whileExpression);

            CtExpression<Boolean> currentNullCheck = SpoonFactory.createNullComparisonClause(currentDeclaration, BinaryOperatorKind.EQ);
            CtIf ifCircularCheck = SpoonFactory.createIfReturnFalse(currentNullCheck);

            MutatorHelper.addImmutableComment(ifCircularCheck);
            body.insertEnd(ifCircularCheck);
        }

        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        //System.out.println("\nSimpleTraversalTemplate.createTraversalBody()" + body.toString());

        return body;
    }

    public static CtIf createIfForLoopField(CtVariable<?> loopField, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet) {
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
        CtExpression<Boolean> fieldNullComp = SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);
        CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true);
        return SpoonFactory.createIfThenStatement(fieldNullComp, visitedCheck);
    }
}