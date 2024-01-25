import evorep.ga.mutators.codegenerators.BooleanExpressionGenerator;
import evorep.ga.mutators.codegenerators.ReferenceExpressionGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanExpressionGeneratorTests {

    static SpoonAPI launcher;

    static Set<String> possibleExpressions;
    static Set<String> possibleNodeVarReads;
    static Set<String> possibleIntVarReads;

    private static void initializeExpressions() {
        if (possibleExpressions == null) {
            possibleExpressions = new HashSet<>();
            possibleExpressions.add("next == null");
            possibleExpressions.add("next.next == null");
            possibleExpressions.add("current == null");
            possibleExpressions.add("current.next == null");
        }
    }

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

    @BeforeAll
    static void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "Node");
        launcher = SpoonFactory.getLauncher();
        initializeExpressions();
        initializeVarReads();
    }

    @Test
    void nullEqualityGenerationTest() {
        CtClass<?> nodeClass = SpoonQueries.getClass("Node");

        CtMethod<?> m = nodeClass.getMethodsByName("m").get(0);

        List<CtVariable<?>> fields = SpoonQueries.getFields(nodeClass);
        List<CtVariable<?>> localVars = SpoonQueries.getLocalVariables(m);

        assertEquals(2, fields.size());
        assertEquals(1, localVars.size());

        CtExpression<Boolean> expression = BooleanExpressionGenerator.generateNullComparison(fields, localVars);

        assertTrue(possibleExpressions.contains(expression.toString()));
    }

    @Test
    void ensureAllVariableReadsAreGeneratedTest() {
        CtClass<?> nodeClass = SpoonQueries.getClass("Node");

        CtMethod<?> m = nodeClass.getMethodsByName("m").get(0);
        List<CtVariable<?>> localVars = SpoonQueries.getLocalVariables(m);
        assertEquals(1, localVars.size());

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
    void ensureAllNullExpressionsAreGeneratedTest() {
        CtClass<?> nodeClass = SpoonQueries.getClass("Node");

        CtMethod<?> m = nodeClass.getMethodsByName("m").get(0);

        List<CtVariable<?>> fields = SpoonQueries.getFields(nodeClass);
        List<CtVariable<?>> localVars = SpoonQueries.getLocalVariables(m);

        assertEquals(2, fields.size());
        assertEquals(1, localVars.size());

        Set<String> expressionsGenerated = new HashSet<>();
        while (expressionsGenerated.size() < 4)
            expressionsGenerated.add(BooleanExpressionGenerator.generateNullComparison(fields, localVars).toString());

        assertTrue(expressionsGenerated.containsAll(possibleExpressions));
    }

    @Test
    void generateAllVarReadsOfNodeTest() {
        CtClass<?> nodeClass = SpoonQueries.getClass("Node");

        CtMethod<?> m = nodeClass.getMethodsByName("m").get(0);

        List<CtVariable<?>> allVars = SpoonQueries.getFields(nodeClass);
        allVars.addAll(SpoonQueries.getLocalVariables(m));

        assertEquals(3, allVars.size());

        Set<String> variableReads = new HashSet<>();

        ReferenceExpressionGenerator.generateAllVarReadsOfType(allVars, nodeClass.getReference()).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        assertTrue(variableReads.containsAll(possibleNodeVarReads));
    }

    @Test
    void generateAllVarReadsOfIntTest() {
        CtClass<?> nodeClass = SpoonQueries.getClass("Node");

        CtMethod<?> m = nodeClass.getMethodsByName("m").get(0);

        List<CtVariable<?>> allVars = SpoonQueries.getFields(nodeClass);
        allVars.addAll(SpoonQueries.getLocalVariables(m));

        assertEquals(3, allVars.size());

        Set<String> variableReads = new HashSet<>();

        ReferenceExpressionGenerator.generateAllVarReadsOfType(allVars, SpoonFactory.createReference(int.class)).forEach(
                varRead -> variableReads.add(varRead.toString())
        );

        //System.out.println(variableReads.toString());
        assertEquals(3, variableReads.size());
        assertTrue(variableReads.containsAll(possibleIntVarReads));
    }


}
