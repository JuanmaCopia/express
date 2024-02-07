import evorep.ga.randomgen.ReferenceExpressionGenerator;
import evorep.scope.Scope;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VariableReadGeneratorTests {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "m";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static Scope scope;

    static Set<String> possibleNodeVarAccess;
    static Set<String> possibleIntVarReads;

    private static void initializeVarReads() {
        if (possibleNodeVarAccess == null) {
            possibleNodeVarAccess = new HashSet<>();
            possibleNodeVarAccess.add("next");
            possibleNodeVarAccess.add("next.next");
            possibleNodeVarAccess.add("current");
            possibleNodeVarAccess.add("current.next");
        }
        if (possibleIntVarReads == null) {
            possibleIntVarReads = new HashSet<>();
            possibleIntVarReads.add("data");
            possibleIntVarReads.add("next.data");
            possibleIntVarReads.add("current.data");
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
        initializeVarReads();
    }

    @Test
    void ensureAllVariableReadsAreGeneratedTest() {
        Set<String> variableReads = new HashSet<>();

        CtVariable<?> nextField = nodeClass.getField("next");
        while (variableReads.size() < 2)
            variableReads.add(ReferenceExpressionGenerator.generateRandomVarReadRefType(nextField, true).toString());

        CtVariable<?> currentVar = scope.getLocalVariables().get(0);
        while (variableReads.size() < 4)
            variableReads.add(ReferenceExpressionGenerator.generateRandomVarReadRefType(currentVar, true).toString());

        assertTrue(variableReads.containsAll(possibleNodeVarAccess));
    }

    @Test
    void ensureAllVariableWritesAreGeneratedTest() {
        Set<String> variableWrites = new HashSet<>();

        CtVariable<?> nextField = nodeClass.getField("next");
        while (variableWrites.size() < 2)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarWriteOfRefType(nextField, true).toString());

        CtVariable<?> currentVar = scope.getLocalVariables().get(0);
        while (variableWrites.size() < 4)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarWriteOfRefType(currentVar, true).toString());

        System.err.println(variableWrites.toString());
        assertTrue(variableWrites.containsAll(possibleNodeVarAccess));
    }

    @Test
    void ensureAllVariableReadsPerTypeAreGeneratedTest() {
        Set<String> variableWrites = new HashSet<>();

        CtVariable<?> nextField = nodeClass.getField("next");
        while (variableWrites.size() < 2)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarReadOfType(nextField, nextField.getType(), true).toString());

        CtVariable<?> currentVar = scope.getLocalVariables().get(0);
        while (variableWrites.size() < 4)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarReadOfType(currentVar, nextField.getType(), true).toString());

        System.err.println(variableWrites.toString());
        assertTrue(variableWrites.containsAll(possibleNodeVarAccess));
    }

    @Test
    void ensureAllVariableWritesPerTypeAreGeneratedTest() {
        Set<String> variableWrites = new HashSet<>();

        CtVariable<?> nextField = nodeClass.getField("next");
        while (variableWrites.size() < 2)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarWriteOfType(nextField, nextField.getType(), true).toString());

        CtVariable<?> currentVar = scope.getLocalVariables().get(0);
        while (variableWrites.size() < 4)
            variableWrites.add(ReferenceExpressionGenerator.generateRandomVarWriteOfType(currentVar, nextField.getType(), true).toString());

        System.err.println(variableWrites.toString());
        assertTrue(variableWrites.containsAll(possibleNodeVarAccess));
    }

    @Test
    void generateAllVarReadsOfNodeTest() {
        Set<String> variableReads = new HashSet<>();
        ReferenceExpressionGenerator.generateAllVarReadsOfType(scope.getAllVariables(), nodeClass.getReference()).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(4, variableReads.size());
        assertTrue(variableReads.containsAll(possibleNodeVarAccess));
    }

    @Test
    void generateAllVarWritesOfNodeTest() {
        Set<String> variableWrites = new HashSet<>();
        System.err.println(scope.getAllVariables().toString());
        ReferenceExpressionGenerator.generateAllVarWritesOfType(scope.getAllVariables(), nodeClass.getReference()).forEach(
                varWrite -> variableWrites.add(varWrite.toString())
        );

        assertEquals(4, variableWrites.size());
        assertTrue(variableWrites.containsAll(possibleNodeVarAccess));
    }

    @Test
    void generateAllVarReadsOfIntTest() {
        Set<String> variableReads = new HashSet<>();

        ReferenceExpressionGenerator.generateAllVarReadsOfType(scope.getAllVariables(), SpoonFactory.createReference(int.class)).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(3, variableReads.size());
        assertTrue(variableReads.containsAll(possibleIntVarReads));
    }

    @Test
    void generateAllVarWritesOfIntTest() {
        Set<String> variableWrites = new HashSet<>();

        ReferenceExpressionGenerator.generateAllVarWritesOfType(scope.getAllVariables(), SpoonFactory.createReference(int.class)).forEach(
                varWrite -> variableWrites.add(varWrite.toString())
        );

        assertEquals(3, variableWrites.size());
        assertTrue(variableWrites.containsAll(possibleIntVarReads));
    }

    @Test
    void generateAllUserDefVarReadsOfNodeTest() {
        Set<String> variableReads = new HashSet<>();
        ReferenceExpressionGenerator.generateAllVarReadsOfReferenceType(scope.getFields()).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(2, variableReads.size());
        assertTrue(variableReads.contains("next"));
        assertTrue(variableReads.contains("next.next"));
    }


}
