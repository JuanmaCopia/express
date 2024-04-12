package evoexpress.spoon.generators;

import evoexpress.config.ToolConfig;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.scope.Scope;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IfGeneratorTests {

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
        ToolConfig.subjectSrcPath = "./src/test/resources";
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
    void ifExpressionReturnFalseTest() {
        CtIf ifAssignment = (CtIf) IfGenerator.generateIfExprReturnFalse(scope);

        CtBlock thenBlock = ifAssignment.getThenStatement();
        CtStatement thenStatement = thenBlock.getStatement(0);
        assertTrue(thenStatement != null);
        assertTrue(thenStatement.toString().equals("return false"));

        CtExpression<?> condition = ifAssignment.getCondition();
        assertTrue(allPossibleExpression.contains(condition.toString()));
    }

    @Test
    void ifFalseReturnFalseTest() {
        CtIf ifAssignment = (CtIf) IfGenerator.generateIfFalseReturnFalse(scope);

        CtBlock thenBlock = ifAssignment.getThenStatement();
        CtStatement thenStatement = thenBlock.getStatement(0);
        assertTrue(thenStatement != null);
        assertTrue(thenStatement.toString().equals("return false"));

        CtExpression<?> condition = ifAssignment.getCondition();
        assertEquals("false", condition.toString());
    }


}
