package evoexpress.spoon;

import evoexpress.ga.Individual;
import evoexpress.spoon.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

public class SpoonHelper {

    public static Scope getScope(Individual individual, CtCodeElement gene) {
        SpoonManager.putIndividualIntoTheEnvironment(individual);
        return new Scope(gene);
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
