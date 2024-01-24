
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import repokgen.ga.mutators.processors.NullCheckProcessor;
import repokgen.spoon.SpoonManager;
import repokgen.spoon.SpoonQueries;
import spoon.pattern.Match;
import spoon.pattern.Pattern;
import spoon.pattern.PatternBuilder;
import spoon.processing.Processor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;

class MyTest {

    CtClass<?> nodeClass;

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "Node");

    }

    @Test
    void exampleTest() {

        // creating an simple template from a method
        CtType<?> nodeClass = SpoonQueries.getClass("Node");
        CtMethod<?> actual = nodeClass.getMethodsByName("actual1").get(0);

        List<CtVariable<?>> fields = SpoonQueries.getFields(nodeClass);

        assertEquals(2, fields.size());

        List<CtVariable<?>> refFields = SpoonQueries.getVariablesOfReferenceType(fields);

        assertEquals(1, refFields.size());

        CtVariable<?> nextField = refFields.get(0);

        assertEquals("next", nextField.getSimpleName());
        assertTrue(nextField.getType().isSubtypeOf(nodeClass.getReference()));

        Processor<CtMethod<?>> p = new NullCheckProcessor(nextField);

        p.process(actual);

        System.err.println("\nProcessed method:\n");
        System.err.println(actual.toString());

        CtMethod<?> expected = nodeClass.getMethodsByName("expected1").get(0);

        Pattern t2 = PatternBuilder.create(expected.getBody()).build();
        List<Match> matches2 = t2.getMatches(actual);
        // assertEquals(1, matches2.size());

        // {
        // // creating the pattern with no parameter
        // Pattern t1 = PatternBuilder.create(actual.clone()).build();
        // List<Match> matches =
        // t1.getMatches(SpoonFactory.getFactory().getModel().getRootPackage());
        // // we match itself, only 1 match
        // assertEquals(1, matches.size());
        // for (Match m : matches) {
        // System.out.println(m.getMatchingElement().getPosition());
        // }
        // }

        {
            // now we take the body
            // Pattern t2 = PatternBuilder.create(expected.getBody()).build();
            // List<Match> matches2 = t2.getMatches(actual);
            // assertEquals(1, matches2.size());
            // for (Match m : matches2) {
            // // one variable is not in the scope it is automatically a parameter
            // assertEquals(1, m.getParametersMap().size());
            // }

        }
    }
}
