package evorep.object;

import evorep.config.ToolConfig;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.reflect.declaration.CtClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectGeneratorTests {

    private final static String SOURCE_PATH = "./src/test/resources";
    private final static String CLASS_NAME = "SortedListTestSuite";

    private static CtClass<?> testSuiteClass;

    @BeforeAll
    public static void setUp() {
        // Initialise ToolConfig
        ToolConfig.className = "SortedList";
        ToolConfig.testSuiteClassName = "SortedListTestSuite";
        // Initialise Spoon
        SpoonManager.initialize(SOURCE_PATH, SOURCE_PATH, null, ToolConfig.className, 17);
        // Get the test suite class
        testSuiteClass = SpoonQueries.getClass(CLASS_NAME);
    }

    @Test
    public void testGenerateObjectsInitialization() {
        // TODO: Implement test
    }

    @Test
    public void testGenerateObjectsSortedList() {
        ObjectGeneratorManager.generateObjects(testSuiteClass);
        assertEquals(3, ObjectCollector.positiveObjects.size());
        assertEquals(3, ObjectCollector.negativeObjects.size());
    }

}
