package evorep.spoon.processors;

import evorep.ga.helper.LocalVarHelper;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseCircularReferenceProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariableRead<?> initialField;
    CtVariable<?> loopField;

    public TraverseCircularReferenceProcessor(CtVariableRead<?> initialField, CtVariable<?> loopField) {
        super();
        this.initialField = initialField;
        this.loopField = loopField;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtTypeReference<?> cyclicNode = initialField.getVariable().getType();
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(ctBlock, cyclicNode);
        CtStatement visitedSetStatement = null;
        CtVariable<?> setVar = null;
        if (setVars.isEmpty()) {
            setVar = SpoonFactory.createVisitedSetDeclaration(cyclicNode, ctBlock);
            visitedSetStatement = (CtStatement) setVar;
        } else {
            setVar = setVars.get(RandomUtils.nextInt(setVars.size()));
        }

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(ctBlock), initialField.getType(), initialField);
        CtVariableRead<?> currentRead = SpoonFactory.createVariableRead(currentDeclaration);

        CtExpression<Boolean> currentNullComp = SpoonFactory.generateNullComparisonClause(currentRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addCurrentToSet = SpoonFactory.createAddToSetInvocation(setVar, currentDeclaration);
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(currentNullComp, addCurrentToSet, BinaryOperatorKind.AND);

        // Create While body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        whileBody.addStatement(SpoonFactory.createComment("Handle current:"));
        whileBody.addStatement(SpoonFactory.createComment("End of Handle current:"));

        CtExpression<Boolean> nullCompLoopField = SpoonFactory.generateNullComparisonClause(SpoonFactory.createFieldRead(currentDeclaration, loopField), BinaryOperatorKind.EQ);
        CtIf nullCheck = SpoonFactory.createIfReturnFalse(nullCompLoopField);
        whileBody.addStatement(nullCheck);

        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
        CtAssignment assignment = SpoonFactory.createAssignment(currentDeclaration, loopFieldRead);
        whileBody.addStatement(assignment);

        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtExpression<Boolean> finalCheckCondition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                currentRead, initialField, BinaryOperatorKind.NE);
        CtIf finalCheck = SpoonFactory.createIfReturnFalse(finalCheckCondition);


        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(ctBlock);
        lastStatement.insertBefore(SpoonFactory.createComment("Begin of traversal"));
        if (visitedSetStatement != null)
            lastStatement.insertBefore(visitedSetStatement);
        lastStatement.insertBefore(SpoonFactory.createComment("Initialize root element:"));
        lastStatement.insertBefore(currentDeclaration);
        lastStatement.insertBefore(SpoonFactory.createComment("Cycle over cyclic references:"));
        lastStatement.insertBefore(whileStatement);
        lastStatement.insertBefore(finalCheck);
        lastStatement.insertBefore(SpoonFactory.createComment("End of traversal"));
    }
}