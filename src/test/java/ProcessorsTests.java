import evorep.spoon.SpoonFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import evorep.ga.mutators.processors.NullCheckProcessor;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import spoon.SpoonAPI;
import spoon.processing.Processor;
import spoon.reflect.declaration.*;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorsTests {

    SpoonAPI launcher;
    CtClass<?> nodeClass;

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "Node");
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass("Node");
    }

    @Test
    void nullCheckProcessorTest() {
        CtMethod<?> actual = nodeClass.getMethodsByName("actual1").get(0);
        CtMethod<?> expected = nodeClass.getMethodsByName("expected1").get(0);

        CtVariable<?> nextField = nodeClass.getField("next");

        Processor<CtMethod<?>> p = new NullCheckProcessor(nextField);
        p.process(actual);

        assertEquals(expected.getBody().toString(), actual.getBody().toString());
    }
}
