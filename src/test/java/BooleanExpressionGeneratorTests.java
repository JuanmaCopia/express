import evorep.ga.mutators.codegenerators.BooleanExpressionGenerator;
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
    final static String METHOD_NAME = "m";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static List<CtVariable<?>> fields;
    static List<CtVariable<?>> localVars;
    static List<CtVariable<?>> allVars;

    static Set<String> possibleExpressions;

    private static void initializeExpressions() {
        if (possibleExpressions == null) {
            possibleExpressions = new HashSet<>();
            possibleExpressions.add("next == null");
            possibleExpressions.add("next.next == null");
            possibleExpressions.add("current == null");
            possibleExpressions.add("current.next == null");
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
        assertTrue(possibleExpressions.contains(expression.toString()));
    }


    @Test
    void ensureAllNullExpressionsAreGeneratedTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 4)
            expressionsGenerated.add(BooleanExpressionGenerator.generateNullComparison(fields, localVars).toString());

        assertTrue(expressionsGenerated.containsAll(possibleExpressions));
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
        CtExpression<Boolean> expression = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(localVars.get(0), null, BinaryOperatorKind.EQ);
        expression = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(expression, UnaryOperatorKind.NOT);
        assertEquals("!(current == null)", expression.toString());
    }

}
