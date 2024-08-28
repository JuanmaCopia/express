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

public class WorklistTraversalTemplate {

    public static CtMethod<?> instantiate(Path initialField, List<CtVariable<?>> loopFields, int splitIndex) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().booleanPrimitiveType();
        List<CtParameter<?>> parameters = createParameters(leftPath, initialField.getTypeReference());
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(leftPath.getTypeReference()), parameters);

        CtBlock<?> traversalBody = createTraversalBody(rightPath, parameters, loopFields);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    private static List<CtParameter<?>> createParameters(Path leftPath, CtTypeReference<?> setSubtype) {
        List<CtParameter<?>> parameters = new ArrayList<>();
        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(setSubtype);
        parameters.add((CtParameter<?>) SpoonManager.getSubjectTypeData().getThisVariable());
        parameters.add(SpoonFactory.createParameter(TypeUtils.convertGenericsToWildcard(leftPath.getTypeReference()), LocalVarHelper.TRAVERSED_ELEMENT_VAR_NAME));
        parameters.add(SpoonFactory.createParameter(setVar.getType(), LocalVarHelper.SET_VAR_NAME));
        return parameters;
    }

    public static String createMethodName(CtTypeReference<?> type) {
        return LocalVarHelper.TRAVERSAL_PREFIX + type.getSimpleName() + LocalVarHelper.MUTABLE_METHOD_SUFFIX;
    }


    private static CtBlock<?> createTraversalBody(Path firstElem, List<CtParameter<?>> params, List<CtVariable<?>> loopFields) {
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

        CtVariable<?> visitedSet = params.get(params.size() - 1);

        CtIf firstElemVisitedCheck = SpoonFactory.createVisitedCheck(visitedSet, firstElementRead, true);


        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(firstElementRead.getType(), body);

        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, firstElementRead);
        //CtInvocation<?> addToSetCall = (CtInvocation<?>) SpoonFactory.createAddToSetInvocation(visitedSet, firstElementRead);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(body), subtypeOfWorklist, removeFirstMethodCall);
        //CtAssignment<?, ?> assignRemoveFirst = SpoonFactory.createAssignment(currentDeclaration, removeFirstMethodCall);
        whileBody.insertEnd(currentDeclaration);

        // Create comment: // Handle current:
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));

        // Create comment: // Add children to worklist:
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtIf ifStatement : createIfsForLoopFields(loopFields, currentDeclaration, visitedSet, worklist)) {
            whileBody.insertEnd(ifStatement);
        }

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(pathNullCheck);
        body.insertEnd(firstElemVisitedCheck);

        MutatorHelper.addImmutableComment(pathNullCheck);
        MutatorHelper.addImmutableComment(firstElemVisitedCheck);

        body.insertEnd(worklist);


        body.insertEnd(addToWorklistCall);
        //body.insertEnd(addToSetCall);

        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
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
        CtExpression<Boolean> fieldNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

        CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", worklist.getType(), loopFieldRead);
        CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);

        CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true);
        addToListCall.insertBefore(visitedCheck);

        return ifNotNull;
    }
}
