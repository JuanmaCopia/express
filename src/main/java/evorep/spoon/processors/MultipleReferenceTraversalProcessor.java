package evorep.spoon.processors;

import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class MultipleReferenceTraversalProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariableRead<?> initialField;
    List<CtField<?>> loopFields;

    public MultipleReferenceTraversalProcessor() {
        super();
    }

    public MultipleReferenceTraversalProcessor(CtVariableRead<?> initialField, List<CtField<?>> loopFields) {
        super();
        this.initialField = initialField;
        this.loopFields = loopFields;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtBlock<?> newBlock = SpoonFactory.createBlock();

        CtTypeReference<?> nodeType = initialField.getType();

        CtLocalVariable<?> visitedSetDeclaration = SpoonFactory.createVisitedSetDeclaration(nodeType);
        CtLocalVariable<?> workListDeclaration = SpoonFactory.createWorkListDeclaration(nodeType);
        CtInvocation<?> addInitialToListCall = SpoonFactory.createInvocation(workListDeclaration, "add", nodeType, initialField);


        // create while (workList.isEmpty()) { ... }
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(workListDeclaration, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        CtBlock<?> whileBody = SpoonFactory.createBlock();


        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(workListDeclaration, "removeFirst");
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable("current", nodeType, removeFirstMethodCall);
        whileBody.insertEnd(currentDeclaration);

        // Create if (current == null) continue;
        CtExpression<Boolean> currentNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(currentDeclaration, null, BinaryOperatorKind.EQ);
        CtContinue continueStatement = SpoonFactory.createContinueStatement();
        CtIf ifStatement = SpoonFactory.createIfThenStatement(currentNullComp, continueStatement);
        whileBody.insertEnd(ifStatement);

        // Create if (!visited.add(current)) return false;
        CtInvocation<?> addCurrentToSetCall = SpoonFactory.createInvocation(visitedSetDeclaration, "add", nodeType, currentDeclaration);
        CtExpression<Boolean> negationOfAddCall = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(addCurrentToSetCall, UnaryOperatorKind.NOT);
        CtIf ifStatement2 = SpoonFactory.createIfThenStatement(negationOfAddCall, SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false)));
        whileBody.insertEnd(ifStatement2);

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtField<?> loopField : loopFields) {
            CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
            CtInvocation<?> addToListCall = SpoonFactory.createInvocation(workListDeclaration, "add", nodeType, loopFieldRead);
            whileBody.insertEnd(addToListCall);
        }

        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtReturn<?> returnTrueStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(true));

        newBlock.insertEnd(visitedSetDeclaration);
        newBlock.insertEnd(workListDeclaration);
        newBlock.insertEnd(addInitialToListCall);
        newBlock.insertEnd(whileStatement);
        newBlock.insertEnd(returnTrueStatement);

        ctBlock.replace(newBlock);
    }
}