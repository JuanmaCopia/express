package evoexpress.spoon.processors.traversals;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraverseWorklistProcessor extends AbstractProcessor<CtClass<?>> {

    List<CtVariable<?>> loopFields;
    CtVariableRead<?> initialField;

    public TraverseWorklistProcessor(CtVariableRead<?> initialField, List<CtVariable<?>> loopFields) {
        super();
        this.loopFields = loopFields;
        this.initialField = initialField;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(structureMethod.getBody());

        CtVariable<?> setVar = handleVisitedSetVariable(structureMethodBody, lastStatement);

        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
        parameters.add(SpoonFactory.createParameter(setVar.getType(), setVar.getSimpleName()));

        CtMethod<?> traversalMethod = createTraversalMethod(ctClass, parameters);
        ctClass.addMethod(traversalMethod);

        CtExpression<?>[] args = SpoonFactory.createArgumentsFromParameters(parameters);
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversalMethod, args);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        lastStatement.insertBefore(ifStatement);

    }

    private CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, CtStatement lastStatement) {
        CtTypeReference<?> cyclicNode = initialField.getVariable().getType();
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, cyclicNode);
        CtVariable<?> setVar = null;
        if (setVars.isEmpty()) {
            setVar = SpoonFactory.createVisitedSetDeclaration(cyclicNode, methodBody);
            lastStatement.insertBefore((CtStatement) setVar);
            return setVar;
        }
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

    private CtMethod<?> createTraversalMethod(CtClass<?> ctClass, List<CtParameter<?>> parameters) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().BOOLEAN_PRIMITIVE;
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, LocalVarHelper.getTraversalMethodName(ctClass), parameters);

        createTraversalBody(traversalMethod, parameters.get(parameters.size() - 1));
        return traversalMethod;
    }

    private void createTraversalBody(CtMethod<?> traversalMethod, CtVariable<?> visitedSet) {
        CtBlock<?> ctBlock = SpoonFactory.createBlock();
        traversalMethod.setBody(ctBlock);

        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(initialField.getType(), ctBlock);

        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, initialField);
        CtInvocation<?> addToSetCall = (CtInvocation<?>) SpoonFactory.createAddToSetInvocation(visitedSet, initialField);
        CtBlock<?> ifBlock = SpoonFactory.createBlock();
        ifBlock.insertEnd(addToWorklistCall);
        ifBlock.insertEnd(addToSetCall);


        CtExpression<Boolean> ifCondition = SpoonFactory.createNullComparisonClause(initialField, BinaryOperatorKind.NE);
        CtIf initialFieldNullCheck = SpoonFactory.createIfThenStatement(ifCondition, ifBlock);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(ctBlock), subtypeOfWorklist, removeFirstMethodCall);
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
        for (CtVariable<?> loopField : loopFields) {
            CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
            CtExpression<Boolean> fieldNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

            CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, loopFieldRead);
            CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);

            CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true);
            addToListCall.insertBefore(visitedCheck);

            whileBody.insertEnd(ifNotNull);
        }

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);


        ctBlock.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        ctBlock.insertEnd(worklist);
        ctBlock.insertEnd(SpoonFactory.createComment("Initialize root element:"));
        ctBlock.insertEnd(initialFieldNullCheck);
        ctBlock.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        ctBlock.insertEnd(whileStatement);
        ctBlock.insertEnd(SpoonFactory.createComment("End of traversal"));
        ctBlock.insertEnd(SpoonFactory.createReturnTrueStatement());
    }

}