package evoexpress.classinvariant.mutator.template;

import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorklistTraversalTemplate {

    public static void instantiate(CtClass<?> ctClass, Path initialField, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn, boolean useParent) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethodBody);

        CtVariable<?> setVar = MutatorHelper.handleVisitedSetVariable(structureMethodBody, lastStatement, initialField.getTypeReference());

        CtMethod<?> traversalMethod = createTraversalMethod(ctClass, initialField, loopFields, setVar, useBreakInsteadOfReturn, useParent);
        ctClass.addMethod(traversalMethod);
    }

    private static List<CtParameter<?>> createParameters(Path initialField, CtVariable<?> visitedSet, boolean useParent) {
        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
        if (useParent) {
            parameters.add(SpoonFactory.createParameter(initialField.getParentPath().getTypeReference(), LocalVarHelper.PARENT_OF_ELEMENT_PARAM));
        } else {
            parameters.add(SpoonFactory.createParameter(initialField.getTypeReference(), LocalVarHelper.FIRST_ELEMENT_VAR_NAME));
        }
        parameters.add(SpoonFactory.createParameter(visitedSet.getType(), visitedSet.getSimpleName()));
        return parameters;
    }

    public static CtMethod<?> createTraversalMethod(CtClass<?> ctClass, Path initialField, List<CtVariable<?>> loopFields, CtVariable<?> setVar, boolean useBreakInsteadOfReturn, boolean useParent) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().BOOLEAN_PRIMITIVE;
        List<CtParameter<?>> parameters = createParameters(initialField, setVar, useParent);
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(), parameters);
        traversalMethod.setSimpleName(traversalMethod.getSimpleName() + LocalVarHelper.getNextTraversalId(ctClass, LocalVarHelper.TRAVERSAL_PREFIX));

        CtBlock<?> traversalBody = createTraversalBody(initialField, parameters, loopFields, useBreakInsteadOfReturn, useParent);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    public static String createMethodName() {
        return LocalVarHelper.TRAVERSAL_PREFIX;
    }


    private static CtBlock<?> createTraversalBody(Path initialField, List<CtParameter<?>> params, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn, boolean useParent) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtVariable<?> firstElement;
        if (useParent) {
            CtVariable<?> initFieldParent = params.get(params.size() - 2);
            CtVariableRead<?> initFieldRead = SpoonFactory.createFieldRead(initFieldParent, initialField.getLast());
            firstElement = SpoonFactory.createLocalVariable(LocalVarHelper.FIRST_ELEMENT_VAR_NAME, initFieldRead.getType(), initFieldRead);
        } else {
            firstElement = params.get(params.size() - 2);
        }
        CtVariableRead<?> firstElementRead = SpoonFactory.createVariableRead(firstElement);
        CtVariable<?> visitedSet = params.get(params.size() - 1);

        CtIf firstElemVisitedCheck = SpoonFactory.createVisitedCheck(visitedSet, firstElementRead, true, false);


        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(firstElementRead.getType(), body);

        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, firstElementRead);
        CtInvocation<?> addToSetCall = (CtInvocation<?>) SpoonFactory.createAddToSetInvocation(visitedSet, firstElementRead);
        CtBlock<?> ifBlock = SpoonFactory.createBlock();
        ifBlock.insertEnd(firstElemVisitedCheck);
        ifBlock.insertEnd(addToWorklistCall);
        ifBlock.insertEnd(addToSetCall);


        CtExpression<Boolean> ifCondition = SpoonFactory.createNullComparisonClause(firstElementRead, BinaryOperatorKind.NE);
        CtIf initialFieldNullCheck = SpoonFactory.createIfThenStatement(ifCondition, ifBlock);

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

        // Add visited check
        //CtIf ifStatement = SpoonFactory.createVisitedCheck(visitedSet, currentDeclaration, true);
        //whileBody.insertEnd(ifStatement);

        // Create comment: // Handle current:
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));

        // Create comment: // Add children to worklist:
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtIf ifStatement : createIfsForLoopFields(loopFields, currentDeclaration, visitedSet, worklist, useBreakInsteadOfReturn)) {
            whileBody.insertEnd(ifStatement);
        }

        whileBody.insertEnd(SpoonFactory.createComment("End of Traversed Fields"));

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);


        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(worklist);
        if (useParent) {
            body.insertEnd(SpoonFactory.createComment("Initialize root element:"));
            body.insertEnd((CtStatement) firstElement);
        }
        body.insertEnd(initialFieldNullCheck);
        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        body.insertEnd(whileStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        return body;
    }

    public static List<CtIf> createIfsForLoopFields(List<CtVariable<?>> loopFields, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet, CtVariable<?> worklist, boolean useBreakInsteadOfReturn) {
        List<CtIf> ifs = new ArrayList<>();
        for (CtVariable<?> loopField : loopFields) {
            ifs.add(createIfForLoopField(loopField, currentDeclaration, visitedSet, worklist, useBreakInsteadOfReturn));
        }
        return ifs;
    }

    public static CtIf createIfForLoopField(CtVariable<?> loopFields, CtVariable<?> currentDeclaration, CtVariable<?> visitedSet, CtVariable<?> worklist, boolean useBreakInsteadOfReturn) {
        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopFields);
        CtExpression<Boolean> fieldNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

        CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", worklist.getType(), loopFieldRead);
        CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);

        CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true, useBreakInsteadOfReturn);
        addToListCall.insertBefore(visitedCheck);

        return ifNotNull;
    }
}