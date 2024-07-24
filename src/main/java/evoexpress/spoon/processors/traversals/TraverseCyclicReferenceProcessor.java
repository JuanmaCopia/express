package evoexpress.spoon.processors.traversals;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseCyclicReferenceProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariableRead<?> initialField;
    CtVariable<?> loopField;

    public TraverseCyclicReferenceProcessor(CtVariableRead<?> initialField, CtVariable<?> loopField) {
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

        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(currentDeclaration, null, BinaryOperatorKind.NE);

        // Create While body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Add visited check
        CtIf ifStatement = SpoonFactory.createVisitedCheck(setVar, currentDeclaration, true, false);
        whileBody.addStatement(ifStatement);

        whileBody.addStatement(SpoonFactory.createComment("Handle current:"));
        whileBody.addStatement(SpoonFactory.createComment("End of Handle current:"));

        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
        CtAssignment assignment = SpoonFactory.createAssignment(currentDeclaration, loopFieldRead);
        whileBody.addStatement(assignment);

        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(ctBlock);
        lastStatement.insertBefore(SpoonFactory.createComment("Begin of traversal"));
        if (visitedSetStatement != null)
            lastStatement.insertBefore(visitedSetStatement);
        lastStatement.insertBefore(SpoonFactory.createComment("Initialize root element:"));
        lastStatement.insertBefore(currentDeclaration);
        lastStatement.insertBefore(SpoonFactory.createComment("Cycle over cyclic references:"));
        lastStatement.insertBefore(whileStatement);
        lastStatement.insertBefore(SpoonFactory.createComment("End of traversal"));
    }
}