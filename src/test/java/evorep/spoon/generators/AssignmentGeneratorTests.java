package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentGeneratorTests {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "methodWithVisitedSet";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static Scope scope;

    static Set<String> possibleAssignments;


    private static void initializeAssignments() {
        if (possibleAssignments == null) {
            possibleAssignments = new HashSet<>();
            possibleAssignments.add("current = next");
            possibleAssignments.add("current = current");
            possibleAssignments.add("current = current.next");
            possibleAssignments.add("current = next.next");
        }
    }


    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass(CLASS_NAME);
        method = nodeClass.getMethodsByName(METHOD_NAME).get(0);
        scope = new Scope(method.getBody().getLastStatement());
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        launcher = SpoonFactory.getLauncher();
    }

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
        initializeAssignments();
    }

    @Test
    void varDeclarationGeneratorTest() {
        Set<String> assignments = new HashSet<>();
        while (assignments.size() < 4) {
            CtStatement varDecl = AssignmentGenerator.generateRandomAssignment(scope);
            assignments.add(varDecl.toString());
        }
        assertTrue(assignments.containsAll(possibleAssignments));
    }


}
