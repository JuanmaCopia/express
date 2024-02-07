import evorep.ga.randomgen.MethodCallGenerator;
import evorep.scope.Scope;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodCallGeneratorTest {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "methodWithVisitedSet";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static Scope scope;

    static Set<String> possibleCallExpressions;

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
        initializeExpressions();
    }

    private static void initializeExpressions() {
        if (possibleCallExpressions == null) {
            possibleCallExpressions = new HashSet<>();
            possibleCallExpressions.add("visited.add(next)");
            possibleCallExpressions.add("visited.add(next.next)");
            possibleCallExpressions.add("visited.add(current)");
            possibleCallExpressions.add("visited.add(current.next)");
        }
    }

    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass(CLASS_NAME);
        method = nodeClass.getMethodsByName(METHOD_NAME).get(0);
        scope = new Scope(method.getBody().getLastStatement());
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME);
        launcher = SpoonFactory.getLauncher();
    }

    @Test
    void generateAddMethodCallTest() {
        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 4) {
            CtExpression<Boolean> expr = MethodCallGenerator.generateRandomCollectionMethodCallExpression(scope);
            expressionsGenerated.add(expr.toString());
        }
        assertTrue(expressionsGenerated.containsAll(possibleCallExpressions));
    }
}
