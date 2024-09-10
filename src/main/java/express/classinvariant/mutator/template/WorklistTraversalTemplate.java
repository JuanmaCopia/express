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

import java.util.ArrayList;
import java.util.List;

public class WorklistTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path initialField, List<CtVariable<?>> loopFields, int splitIndex) {
        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtMethod<?> traversal = TemplateHelper.createTraversalMethod(ctClass, leftPath);

        createTraversalBody(rightPath, traversal, loopFields);
        return traversal;
    }

    private static void createTraversalBody(Path firstElem, CtMethod<?> traversal, List<CtVariable<?>> loopFields) {
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

        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(rootElementType, body);
        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", rootElementType, rootElementRead);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);


        CtBlock<?> whileBody = SpoonFactory.createBlock();
        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.CURRENT_VAR_NAME, rootElementType, removeFirstMethodCall);

        whileBody.insertEnd(currentDeclaration);
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtIf ifStatement : createIfsForLoopFields(loopFields, currentDeclaration, visitedSetDeclaration, worklist)) {
            whileBody.insertEnd(ifStatement);
        }

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(pathNullCheck);
        body.insertEnd(rootElement);
        body.insertEnd(visitedSetDeclaration);
        body.insertEnd(firstElemVisitedCheck);
        body.insertEnd(worklist);
        body.insertEnd(addToWorklistCall);

        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);
        body.insertEnd(whileStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        traversal.setBody(body);
        //System.out.println("\nWorklistTraversalTemplate.createTraversalBody()" + body.toString());
    }

    public static List<CtIf> createIfsForLoopFields(List<CtVariable<?>> loopFields, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet, CtVariable<?> worklist) {
        List<CtIf> ifs = new ArrayList<>();
        for (CtVariable<?> loopField : loopFields) {
            ifs.add(createIfForLoopField(loopField, currentDeclaration, visitedSet, worklist));
        }
        return ifs;
    }

    public static CtIf createIfForLoopField(CtVariable<?> loopFields, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet, CtVariable<?> worklist) {
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopFields);
        CtExpression<Boolean> fieldNullComp = SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

        CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", worklist.getType(), loopFieldRead);
        CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);

        CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true);
        addToListCall.insertBefore(visitedCheck);

        return ifNotNull;
    }
}
