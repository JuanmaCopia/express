import evorep.ga.mutators.codegenerators.WhileGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhileGeneratorTests {

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
    void emptyWhileWithFalseConditionTest() {
        CtWhile whileAssignment = (CtWhile) WhileGenerator.generateWhileFalse(fields, localVars);

        CtBlock body = (CtBlock) whileAssignment.getBody();
        assertEquals(0, body.getStatements().size());


        CtExpression<?> condition = whileAssignment.getLoopingExpression();
        assertEquals("false", condition.toString());
    }

    @Test
    void emptyWhileWithRandomConditionTest() {
        CtWhile whileAssignment = (CtWhile) WhileGenerator.generateWhileWithRandomExpression(fields, localVars);

        CtBlock body = (CtBlock) whileAssignment.getBody();
        assertEquals(0, body.getStatements().size());

        CtExpression<?> condition = whileAssignment.getLoopingExpression();
        assertTrue(allPossibleExpression.contains(condition.toString()));
    }

    @Test
    void whileWithIfReturnAndRandomConditionTest() {
        CtWhile whileAssignment = (CtWhile) WhileGenerator.generateWhileWithIfStatement(fields, localVars);

        CtBlock body = (CtBlock) whileAssignment.getBody();
        assertEquals(1, body.getStatements().size());
        CtIf ifStatement = (CtIf) body.getStatement(0);

        CtBlock<?> thenBlock = ifStatement.getThenStatement();
        CtReturn<?> returnStatement = (CtReturn<?>) thenBlock.getStatement(0);
        assertEquals("return false", returnStatement.toString());

        CtExpression<?> ifCondition = ifStatement.getCondition();
        assertTrue(allPossibleExpression.contains(ifCondition.toString()));

        CtExpression<?> condition = whileAssignment.getLoopingExpression();
        assertTrue(allPossibleExpression.contains(condition.toString()));
    }


}
