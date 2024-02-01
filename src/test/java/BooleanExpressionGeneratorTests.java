import evorep.ga.randomgen.BooleanExpressionGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanExpressionGeneratorTests {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "methodWithVisitedSet";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static List<CtVariable<?>> fields;
    static List<CtVariable<?>> localVars;
    static List<CtVariable<?>> allVars;

    static Set<String> possibleNullCompExpressions;
    static Set<String> allPossibleExpression;

    private static void initializeExpressions() {
        if (possibleNullCompExpressions == null) {
            possibleNullCompExpressions = new HashSet<>();
            possibleNullCompExpressions.add("next == null");
            possibleNullCompExpressions.add("next.next == null");
            possibleNullCompExpressions.add("current == null");
            possibleNullCompExpressions.add("current.next == null");
            possibleNullCompExpressions.add("visited == null");
        }
        if (allPossibleExpression == null) {
            allPossibleExpression = new HashSet<>();
            allPossibleExpression.addAll(possibleNullCompExpressions);
            allPossibleExpression.add("visited.add(next)");
            allPossibleExpression.add("visited.add(next.next)");
            allPossibleExpression.add("visited.add(current)");
            allPossibleExpression.add("visited.add(current.next)");
            allPossibleExpression.add("!visited.add(next)");
            allPossibleExpression.add("!visited.add(next.next)");
            allPossibleExpression.add("!visited.add(current)");
            allPossibleExpression.add("!visited.add(current.next)");

            for (String expression : possibleNullCompExpressions)
                allPossibleExpression.add("!(" + expression + ")");
        }
    }

    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass(CLASS_NAME);
        method = nodeClass.getMethodsByName(METHOD_NAME).get(0);
        fields = SpoonQueries.getFields(nodeClass);
        localVars = SpoonQueries.getLocalVariables(method);
        allVars = new ArrayList<>();
        allVars.addAll(fields);
        allVars.addAll(localVars);
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME);
        launcher = SpoonFactory.getLauncher();
    }

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
        initializeExpressions();
    }

    @Test
    void nullEqualityGenerationTest() {
        CtExpression<Boolean> expression = BooleanExpressionGenerator.generateNullComparison(fields, localVars);
        assertTrue(possibleNullCompExpressions.contains(expression.toString()));
    }


    @Test
    void ensureAllNullExpressionsAreGeneratedTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 5)
            expressionsGenerated.add(BooleanExpressionGenerator.generateNullComparison(fields, localVars).toString());

        assertTrue(expressionsGenerated.containsAll(possibleNullCompExpressions));
    }

    @Test
    void ensureAllExpressionsAreGeneratedTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 18)
            expressionsGenerated.add(BooleanExpressionGenerator.generateRandomExpression(fields, localVars).toString());
        assertTrue(expressionsGenerated.containsAll(allPossibleExpression));
    }

    @Test
    void choicesTest() {
        List<Integer> choices = BooleanExpressionGenerator.getChoices(fields, localVars);
        assertEquals(2, choices.size());
        assertTrue(choices.contains(0));
        assertTrue(choices.contains(1));
        assertTrue(!choices.contains(-1));
    }

    @Test
    void negateTest() {
        CtVariable<?> variable = SpoonQueries.getVariableByName(localVars, "current");
        CtExpression<Boolean> expression = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(variable, null, BinaryOperatorKind.EQ);
        expression = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(expression, UnaryOperatorKind.NOT);
        assertEquals("!(current == null)", expression.toString());
    }

}
