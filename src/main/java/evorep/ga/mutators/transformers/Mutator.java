package evorep.ga.mutators.transformers;

import evorep.ga.Individual;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class Mutator {

    private static CtStatement selectRandomStatement(Individual individual) {
        List<CtStatement> statements = SpoonQueries.getStatements(individual.getChromosome());
        return statements.get(RandomUtils.nextInt(statements.size()));
    }

    private static List<CtVariable<?>> getFields(Individual individual) {
        return SpoonQueries.getFields(SpoonManager.getTargetClass());
    }

    public static void mutate(Individual individual) {
        CtStatement statementToMutate = selectRandomStatement(individual);
        List<CtVariable<?>> fields = getFields(individual);
        List<CtVariable<?>> localVariables = SpoonQueries.getAllReachableLocalVariables(statementToMutate);
        if (statementToMutate instanceof CtBlock) {
            BlockMutator.mutate((CtBlock<?>) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtWhile) {
            WhileMutator.mutate((CtWhile) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtIf) {
            IfMutator.mutate((CtIf) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtAssignment) {
            AssignmentMutator.mutate((CtAssignment) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtReturn) {
            ReturnMutator.mutate((CtReturn) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtInvocation) {
            InvocationMutator.mutate((CtInvocation) statementToMutate, fields, localVariables);
        } else if (statementToMutate instanceof CtLocalVariable) {

        } else {
            //System.err.println("No mutator found for statement: " + statementToMutate.getClass().getSimpleName());
        }
        /*else if (statementToMutate instanceof CtFor) {

        } else if (statementToMutate instanceof CtForEach) {
        }*/
    }

}
