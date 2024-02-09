package evorep.spoon;

import evorep.ga.Individual;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

public class SpoonHelper {

    public static void putIndividualIntoTheEnvironment(Individual individual) {
        SpoonManager.getTargetClass().removeMethod(individual.getChromosome());
        SpoonManager.getTargetClass().addMethod(individual.getChromosome());
    }

    public static Scope getScope(Individual individual) {
        putIndividualIntoTheEnvironment(individual);
        return new Scope(individual.getChromosome().getBody().getLastStatement());
    }

    public static String getFalseFitnessString() {
        CtClass<?> clazz = SpoonManager.getTargetClass();
        CtMethod<?> method = clazz.getMethodsByName("structureRepOK2").get(0);
        return getStatementsString(method);
    }

    public static String getStatementsString(CtMethod method) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CtStatement statement : method.getBody().getStatements()) {
            stringBuilder.append(statement.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String methodBodyToString(CtMethod<?> method) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CtStatement statement : method.getBody().getStatements()) {
            stringBuilder.append(statement.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void replace(CtElement e, CtElement op) {
        if (e instanceof CtStatement && op instanceof CtStatement) {
            e.replace(op);
            return;
        }
        if (e instanceof CtExpression && op instanceof CtExpression) {
            e.replace(op);
            return;
        }
        throw new IllegalArgumentException(e.getClass() + " " + op.getClass());
    }
}
