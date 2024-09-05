package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorklistTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path initialField, List<CtVariable<?>> loopFields, int splitIndex) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().booleanPrimitiveType();
        List<CtParameter<?>> parameters = createParameters(leftPath, initialField.getTypeReference());
        String traversalName = LocalVarHelper.getNextTraversalName(ctClass, LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, traversalName, parameters);

        CtBlock<?> traversalBody = createTraversalBody(rightPath, parameters, loopFields);
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

    private static CtBlock<?> createTraversalBody(Path firstElem, List<CtParameter<?>> params, List<CtVariable<?>> loopFields) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtExpression<Boolean> nullCheckCondition;
        CtVariableRead<?> firstElementRead;
        if (!firstElem.isEmpty()) {
            CtVariable<?> initFieldParent = params.get(params.size() - 2);
            Path pathToFirstElement = new Path(initFieldParent, firstElem);
            nullCheckCondition = SpoonFactory.generateOrConcatenationOfNullComparisons(pathToFirstElement);
            firstElementRead = pathToFirstElement.getVariableRead();
        } else {
            CtVariable<?> firstElement = params.get(params.size() - 2);
            firstElementRead = SpoonFactory.createVariableRead(firstElement);
            nullCheckCondition = SpoonFactory.createNullComparisonClause(firstElement, BinaryOperatorKind.EQ);
        }

        CtIf pathNullCheck = SpoonFactory.createIfReturnTrue(nullCheckCondition);

        CtTypeReference<?> rootElementType = TypeUtils.convertGenericsToWildcard(firstElementRead.getType());
        CtLocalVariable<?> rootElement = SpoonFactory.createLocalVariable(LocalVarHelper.TRAVERSAL_ROOT_VAR_NAME, rootElementType, firstElementRead);
        CtVariableRead<?> rootElementRead = SpoonFactory.createVariableRead(rootElement);


        CtVariable<?> visitedSet = params.get(params.size() - 1);

        CtIf firstElemVisitedCheck = SpoonFactory.createVisitedCheck(visitedSet, rootElementRead, true);


        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(rootElementType, body);

        //CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", rootElementType, rootElementRead);
        //CtInvocation<?> addToSetCall = (CtInvocation<?>) SpoonFactory.createAddToSetInvocation(visitedSet, firstElementRead);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);


        CtBlock<?> whileBody = SpoonFactory.createBlock();
        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(body), rootElementType, removeFirstMethodCall);

        whileBody.insertEnd(currentDeclaration);
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtIf ifStatement : createIfsForLoopFields(loopFields, currentDeclaration, visitedSet, worklist)) {
            whileBody.insertEnd(ifStatement);
        }

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(pathNullCheck);
        body.insertEnd(rootElement);
        body.insertEnd(firstElemVisitedCheck);
        body.insertEnd(worklist);
        body.insertEnd(addToWorklistCall);

        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);
        body.insertEnd(whileStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        //System.out.println("\nWorklistTraversalTemplate.createTraversalBody()" + body.toString());

        return body;
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
