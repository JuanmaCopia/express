import evorep.ga.randomgen.ReferenceExpressionGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    static List<CtVariable<?>> fields;
    static List<CtVariable<?>> localVars;
    static List<CtVariable<?>> allVars;

    static Set<String> possibleNodeVarReads;
    static Set<String> possibleIntVarReads;

    private static void initializeVarReads() {
        if (possibleNodeVarReads == null) {
            possibleNodeVarReads = new HashSet<>();
            possibleNodeVarReads.add("next");
            possibleNodeVarReads.add("next.next");
            possibleNodeVarReads.add("current");
            possibleNodeVarReads.add("current.next");
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
        initializeVarReads();
    }

    @Test
    void ensureAllVariableReadsAreGeneratedTest() {
        Set<String> variableReads = new HashSet<>();

        CtVariable<?> nextField = nodeClass.getField("next");
        while (variableReads.size() < 2)
            variableReads.add(ReferenceExpressionGenerator.generateRandomVariableAccessRefType(nextField).toString());

        CtVariable<?> currentVar = localVars.get(0);
        while (variableReads.size() < 4)
            variableReads.add(ReferenceExpressionGenerator.generateRandomVariableAccessRefType(currentVar).toString());

        assertTrue(variableReads.containsAll(possibleNodeVarReads));
    }

    @Test
    void generateAllVarReadsOfNodeTest() {
        Set<String> variableReads = new HashSet<>();
        ReferenceExpressionGenerator.generateAllVarReadsOfType(allVars, nodeClass.getReference()).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(4, variableReads.size());
        assertTrue(variableReads.containsAll(possibleNodeVarReads));
    }

    @Test
    void generateAllVarReadsOfIntTest() {
        Set<String> variableReads = new HashSet<>();

        ReferenceExpressionGenerator.generateAllVarReadsOfType(allVars, SpoonFactory.createReference(int.class)).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(3, variableReads.size());
        assertTrue(variableReads.containsAll(possibleIntVarReads));
    }

    @Test
    void generateAllUserDefVarReadsOfNodeTest() {
        Set<String> variableReads = new HashSet<>();
        ReferenceExpressionGenerator.generateAllUserDefVarReadsOfReferenceType(fields).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertEquals(2, variableReads.size());
        assertTrue(variableReads.contains("next"));
        assertTrue(variableReads.contains("next.next"));
    }
}
