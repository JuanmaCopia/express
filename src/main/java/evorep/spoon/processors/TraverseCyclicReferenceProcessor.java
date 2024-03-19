package evorep.spoon.processors;

import evorep.ga.helper.LocalVarHelper;
import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;

public class TraverseCyclicReferenceProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariableRead<?> initialField;
    CtField<?> loopField;
    CtLocalVariable<?> visitedSet;

    public TraverseCyclicReferenceProcessor(CtVariableRead<?> initialField, CtField<?> loopField, CtLocalVariable<?> visitedSet) {
        super();
        this.initialField = initialField;
        this.loopField = loopField;
        this.visitedSet = visitedSet;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(ctBlock), initialField.getType(), initialField);

        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(currentDeclaration, null, BinaryOperatorKind.NE);

        // Create While body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Add visited check
        CtIf ifStatement = SpoonFactory.createVisitedCheck(visitedSet, currentDeclaration);
        whileBody.addStatement(ifStatement);

        whileBody.addStatement(SpoonFactory.createComment("Handle current:"));
        whileBody.addStatement(SpoonFactory.createComment("End of Handle current:"));

        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
        CtAssignment assignment = SpoonFactory.createAssignment(currentDeclaration, loopFieldRead);
        whileBody.addStatement(assignment);

        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtStatement lastStatement = ctBlock.getLastStatement();
        lastStatement.insertBefore(visitedSet);
        lastStatement.insertBefore(SpoonFactory.createComment("Initialize root element:"));
        lastStatement.insertBefore(currentDeclaration);
        lastStatement.insertBefore(SpoonFactory.createComment("Cycle over cyclic references:"));
        lastStatement.insertBefore(whileStatement);
    }
}