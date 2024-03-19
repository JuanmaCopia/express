package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonHelper;
import evorep.spoon.SpoonQueries;
import evorep.spoon.generators.BooleanExpressionGenerator;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TraversalBlockMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !block.getElements(SpoonQueries::isTraversalLoop).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> block = (CtBlock<?>) gene;
        CtWhile chosenLoop = (CtWhile) RandomUtils.getRandomElement(block.getElements(SpoonQueries::isTraversalLoop));
        CtBlock<?> loopBody = (CtBlock<?>) chosenLoop.getBody();
        CtBlock<?> handleBlock = SpoonQueries.getBlockOfHandleCurrent(loopBody);
        CtStatement lastStatement = loopBody.getLastStatement();
        Scope scope = SpoonHelper.getScope(individual, lastStatement);
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getCurrentVarDeclaration(chosenLoop);

        switch (getChoice(handleBlock)) {
            case 0 -> addIf(handleBlock, currentDeclaration, scope);
            //case 1 -> mutateIf(handleBlock, currentDeclaration, scope);
            //case 2 -> removeIf(handleBlock);
            default -> throw new RuntimeException("Invalid choice");
        }

        CtBlock<?> mutatedBody = SpoonQueries.generateMutatedBody(loopBody, handleBlock);
        chosenLoop.setBody(mutatedBody);

    }


    private int getChoice(CtBlock<?> handleBlock) {
        List<Integer> filteredChoices = new ArrayList<>();
        filteredChoices.add(0);
        List<CtIf> ifs = handleBlock.getElements(Objects::nonNull);
        if (!ifs.isEmpty()) {
            //filteredChoices.add(1);
            //filteredChoices.add(2);
        }
        return RandomUtils.getRandomInteger(filteredChoices);
    }

    private void addIf(
            CtBlock<?> handleBlock,
            CtLocalVariable<?> currentDeclaration,
            Scope scope
    ) {
        CtReturn<?> returnFalse = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        CtExpression<Boolean> condition = generateNewCondition(currentDeclaration, scope);
        CtIf ifStatement = SpoonFactory.createIfThenStatement(condition, returnFalse);
        handleBlock.addStatement(ifStatement);
    }

    private void mutateIf(CtBlock<?> handleBlock, CtLocalVariable<?> currentDeclaration, Scope scope) {
        CtIf chosenIf = (CtIf) RandomUtils.getRandomElement(handleBlock.getElements(e -> e instanceof CtIf));
        switch (getMutationChoice(chosenIf)) {
            case 0 -> mutateVarRead(chosenIf, currentDeclaration, scope);
            case 1 -> mutateOperator(chosenIf);
            case 2 -> expandCondition(chosenIf, currentDeclaration, scope);
            default -> throw new RuntimeException("Invalid choice");
        }
    }

    private CtExpression<Boolean> generateNewCondition(CtLocalVariable<?> currentDeclaration, Scope scope) {
        CtExpression<Boolean> condition;
        switch (getConditionChoice()) {
            case 0 -> {
                condition = BooleanExpressionGenerator.generateRandomFieldAccessNullComparison(currentDeclaration);
            }
            case 1 -> {
                condition = BooleanExpressionGenerator.createReferenceComparisonSameType(currentDeclaration, scope);
            }
            default -> throw new RuntimeException("Invalid choice");
        }
        return condition;
    }

    private int getMutationChoice(CtIf ifStatement) {
        List<Integer> filteredChoices = new ArrayList<>();

        CtExpression<Boolean> condition = ifStatement.getCondition();
        if (RandomUtils.getRandomElement(condition.getElements(e -> e instanceof CtVariableRead)) != null)
            filteredChoices.add(0);

        if (condition instanceof CtBinaryOperator<?> || condition instanceof CtUnaryOperator<?>) {
            filteredChoices.add(1);
        }

        filteredChoices.add(2);

        return RandomUtils.getRandomInteger(filteredChoices);
    }

    private void mutateVarRead(CtIf ifStatement, CtLocalVariable<?> currentDeclaration, Scope scope) {
        CtVariableRead<?> toReplaceVar = (CtVariableRead<?>) RandomUtils.getRandomElement(ifStatement.getCondition().getElements(e -> e instanceof CtVariableRead));
        List<CtCodeElement> variableReads;
        if (toReplaceVar.getType().equals(currentDeclaration.getType()))
            variableReads = ReferenceExpressionGenerator.generateAllVarReadsSameType(currentDeclaration, scope.getAllVariables());
        else
            variableReads = ReferenceExpressionGenerator.generateAllVarReadsOfType(scope.getAllVariables(), toReplaceVar.getType());

        CtCodeElement newVarRead = RandomUtils.getRandomElement(variableReads);
        toReplaceVar.replace(newVarRead);
    }

    private void mutateOperator(CtIf chosenIf) {
        CtExpression<Boolean> condition = chosenIf.getCondition();
        if (condition instanceof CtBinaryOperator<?> binaryOperator) {
            BinaryOperatorKind newOperator = negateBinaryOperator(binaryOperator.getKind());
            binaryOperator.setKind(newOperator);
        } else if (condition instanceof CtUnaryOperator<?> unaryOperator) {
            if (unaryOperator.getKind().equals(UnaryOperatorKind.NOT))
                chosenIf.setCondition((CtExpression<Boolean>) unaryOperator.getOperand());
        }
    }

    private void expandCondition(CtIf chosenIf, CtLocalVariable<?> currentDeclaration, Scope scope) {
        CtExpression<Boolean> condition = generateNewCondition(currentDeclaration, scope);
        CtBinaryOperator<Boolean> newCondition =
                (CtBinaryOperator<Boolean>) SpoonFactory.createBinaryExpression(chosenIf.getCondition(), condition, BinaryOperatorKind.AND);
        chosenIf.setCondition(newCondition);
    }


    private int getConditionChoice() {
        List<Integer> filteredChoices = new ArrayList<>();
        filteredChoices.add(0);
        filteredChoices.add(1);
        return RandomUtils.getRandomInteger(filteredChoices);
    }


    private BinaryOperatorKind negateBinaryOperator(BinaryOperatorKind operator) {
        BinaryOperatorKind newOperator;
        switch (operator) {
            case EQ -> newOperator = BinaryOperatorKind.NE;
            case NE -> newOperator = BinaryOperatorKind.EQ;
            case AND -> newOperator = BinaryOperatorKind.OR;
            case OR -> newOperator = BinaryOperatorKind.AND;
            default -> throw new RuntimeException("Invalid operator");
        }
        return newOperator;
    }

    private void removeIf(CtBlock<?> handleBlock) {
        CtIf chosenIf = (CtIf) handleBlock.getElements(e -> e instanceof CtIf).stream().findAny().get();
        handleBlock.removeStatement(chosenIf);
    }


}
