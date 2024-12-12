package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.spoon.SpoonFactory;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class SimpleTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path initialField, CtVariable<?> loopField, int splitIndex, boolean checkCircular) {
        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtMethod<?> traversal = TemplateHelper.createTraversalMethod(ctClass, leftPath, LocalVarHelper.TRAVERSAL_PREFIX);

        createTraversalBody(rightPath, traversal, loopField, checkCircular);
        return traversal;
    }

    private static void createTraversalBody(Path firstElem, CtMethod<?> traversal, CtVariable<?> loopField, boolean checkCircular) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtVariable<?> traversedElement = TemplateHelper.getTraversedElementParameter(traversal);
        CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(traversal);

        CtExpression<Boolean> nullCheckCondition;
        CtVariableRead<?> firstElementRead;
        if (!firstElem.isEmpty()) {
            Path pathToFirstElement = new Path(traversedElement, firstElem);
            nullCheckCondition = SpoonFactory.generateOrConcatenationOfNullComparisons(pathToFirstElement);
            firstElementRead = pathToFirstElement.getVariableRead();
        } else {
            firstElementRead = SpoonFactory.createVariableRead(traversedElement);
            nullCheckCondition = SpoonFactory.createNullComparisonClause(traversedElement, BinaryOperatorKind.EQ);
        }

        CtIf pathNullCheck = SpoonFactory.createIfReturnTrue(nullCheckCondition);

        CtTypeReference<?> rootElementType = TypeUtils.convertGenericsToWildcard(firstElementRead.getType());
        CtLocalVariable<?> rootElement = SpoonFactory.createLocalVariable(LocalVarHelper.TRAVERSAL_ROOT_VAR_NAME, rootElementType, firstElementRead);
        CtVariableRead<?> rootElementRead = SpoonFactory.createVariableRead(rootElement);

        CtLocalVariable<?> visitedSetDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisited, rootElementRead);

        CtIf firstElemVisitedCheck = SpoonFactory.createVisitedCheck(visitedSetDeclaration, rootElementRead, true);

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.CURRENT_VAR_NAME, rootElementType, rootElementRead);
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
        CtIf ifStatement = createIfForLoopField(loopField, currentDeclaration, visitedSetDeclaration);
        whileBody.insertEnd(ifStatement);

        // Create assingment: current = current.<loopField>;
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentRead, loopField);
        CtAssignment<?, ?> assignmentToCurrent = SpoonFactory.createAssignment(currentDeclaration, loopFieldRead);

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));
        whileBody.insertEnd(assignmentToCurrent);


        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(pathNullCheck);
        body.insertEnd(rootElement);
        body.insertEnd(visitedSetDeclaration);
        body.insertEnd(firstElemVisitedCheck);
        body.insertEnd(currentDeclaration);

        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));

        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);
        body.insertEnd(whileStatement);

        body.insertEnd(SpoonFactory.createComment("End of traversal"));

        if (checkCircular) {
            CtExpression<Boolean> whileExpression = whileStatement.getLoopingExpression();
            CtExpression<Boolean> comparisonToFirstElem = SpoonFactory.createBinaryExpression(loopFieldRead, rootElementRead, BinaryOperatorKind.NE);
            whileExpression = SpoonFactory.createBinaryExpression(whileExpression, comparisonToFirstElem, BinaryOperatorKind.AND);
            whileStatement.setLoopingExpression(whileExpression);

            CtExpression<Boolean> currentNullCheck = SpoonFactory.createNullComparisonClause(currentDeclaration, BinaryOperatorKind.EQ);
            CtIf ifCircularCheck = SpoonFactory.createIfReturnFalse(currentNullCheck);

            body.insertEnd(ifCircularCheck);
        }

        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        traversal.setBody(body);
        //System.out.println("\nSimpleTraversalTemplate.createTraversalBody()" + body.toString());
    }

    public static CtIf createIfForLoopField(CtVariable<?> loopField, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet) {
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
        CtExpression<Boolean> fieldNullComp = SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);
        CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true);
        return SpoonFactory.createIfThenStatement(fieldNullComp, visitedCheck);
    }
}