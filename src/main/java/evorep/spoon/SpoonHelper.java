package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;

public class SpoonHelper {

    public static CtClass<?> putIndividualIntoTheEnvironment(Individual individual) {
        CtClass<?> preconditionClass = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + individual.id);

        CtMethod<?> initialChecks = preconditionClass.getMethodsByName("initialCheck").get(0);
        CtMethod<?> structureChecks = preconditionClass.getMethodsByName("structureCheck").get(0);
        CtMethod<?> primitiveChecks = preconditionClass.getMethodsByName("primitiveCheck").get(0);
        initialChecks.setBody(individual.getInitialCheck());
        structureChecks.setBody(individual.getStructureCheck());
        primitiveChecks.setBody(individual.getPrimitiveCheck());

        /*CtStatement printStatement = SpoonFactory.getCodeFactory()
                .createCodeSnippetStatement("System.out.println(rootObject.toString())");
        initialChecks.getBody().insertBegin(printStatement);*/

        CtPackage ctPackage = SpoonManager.targetClass.getPackage();
        ctPackage.addType(preconditionClass);
        individual.className = preconditionClass.getQualifiedName();
        return preconditionClass;
    }

    public static void removeClassFromEnvironment(CtClass<?> ctClass) {
        CtPackage ctPackage = SpoonManager.targetClass.getPackage();
        ctPackage.removeType(ctClass);
    }

    public static Scope getScope(Individual individual, CtCodeElement gene) {
        putIndividualIntoTheEnvironment(individual);
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
