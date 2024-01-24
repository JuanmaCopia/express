import evorep.ga.mutators.codegenerators.BooleanExpressionGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
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

    SpoonAPI launcher;

    Set<String> possibleExpressions;

    private void initializeExpressions() {
        if (possibleExpressions == null){
            possibleExpressions = new HashSet<>();
            possibleExpressions.add("next == null");
            possibleExpressions.add("next.next == null");
            possibleExpressions.add("current == null");
            possibleExpressions.add("current.next == null");
        }
    }

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "Node");
        launcher = SpoonFactory.getLauncher();
        initializeExpressions();
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

        System.out.println(expression.toString());

        assertTrue(possibleExpressions.contains(expression.toString()));
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
        for (int i = 0; i < 200; i++) {
            CtExpression<Boolean> expression = BooleanExpressionGenerator.generateNullComparison(fields, localVars);
            expressionsGenerated.add(expression.toString());
        }

        System.out.println(expressionsGenerated.toString());

        assertTrue(expressionsGenerated.containsAll(possibleExpressions));


    }

}
