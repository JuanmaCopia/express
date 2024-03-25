package evorep.spoon.processors;

import evorep.config.ToolConfig;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.processing.Processor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorsTests {

    SpoonAPI launcher;
    CtClass<?> nodeClass;

    @BeforeEach
    void setUp() {
        // Initialize ToolConfig
        ToolConfig.className = "Node";
        ToolConfig.testSuiteClassName = "SLLTestSuite";
        ToolConfig.srcPath = "./src/test/resources";
        ToolConfig.srcJavaVersion = 17;
        // Initialise Spoon
        SpoonManager.initialize();
        
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
