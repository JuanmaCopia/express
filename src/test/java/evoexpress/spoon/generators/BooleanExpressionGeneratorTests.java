package evoexpress.spoon.generators;

import evoexpress.config.ToolConfig;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.scope.Scope;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

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
    static Scope scope;

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
        scope = new Scope(method.getBody().getLastStatement());
    }

    private static void initializeSpoon() {
        // Initialize ToolConfig
        ToolConfig.subjectClassName = CLASS_NAME;
        ToolConfig.subjectTestSuiteClassName = "SLLTestSuite";
        ToolConfig.subjectSrcPath = SOURCE_PATH;
        ToolConfig.subjectSrcJavaVersion = 17;
        // Initialise Spoon
        SpoonManager.initialize();
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
        CtExpression<Boolean> expression = BooleanExpressionGenerator.generateNullComparison(scope);
        assertTrue(possibleNullCompExpressions.contains(expression.toString()));
    }


    @Test
    void ensureAllNullExpressionsAreGeneratedTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 5)
            expressionsGenerated.add(BooleanExpressionGenerator.generateNullComparison(scope).toString());

        assertTrue(expressionsGenerated.containsAll(possibleNullCompExpressions));
    }

    @Test
    void ensureAllExpressionsAreGeneratedTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 18)
            expressionsGenerated.add(BooleanExpressionGenerator.generateRandomExpression(scope).toString());
        assertTrue(expressionsGenerated.containsAll(allPossibleExpression));
    }

    @Test
    void choicesTest() {
        List<Integer> choices = BooleanExpressionGenerator.getChoices(scope);
        assertEquals(2, choices.size());
        assertTrue(choices.contains(0));
        assertTrue(choices.contains(1));
        assertTrue(!choices.contains(-1));
    }

    @Test
    void negateTest() {
        CtVariable<?> variable = SpoonQueries.getVariableByName(scope.getLocalVariables(), "current");
        CtExpression<Boolean> expression = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(variable, null, BinaryOperatorKind.EQ);
        expression = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(expression, UnaryOperatorKind.NOT);
        assertEquals("!(current == null)", expression.toString());
    }

}