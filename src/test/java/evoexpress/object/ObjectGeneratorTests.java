package evoexpress.object;

import evoexpress.config.Config;
import evoexpress.spoon.SpoonManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObjectGeneratorTests {

    private static final Config config = new Config();

    @BeforeAll
    public static void setUp() {
        // Initialize ToolConfig
        config.subjectClassName = "SLL";
        config.subjectTestSuiteClassName = "SLLTestSuite";
        config.subjectSrcPath = "./src/test/resources";
        config.subjectSrcJavaVersion = 17;
        // Initialise Spoon
        SpoonManager.initialize(config);
    }

    @Test
    public void testGenerateObjectsSLL() {
/*        ObjectGeneratorManager.generateObjects(SpoonManager.createClassLoader());
        assertEquals(9, ObjectCollector.positiveObjects.size());*/

        // Print negative objects
/*        for (Object negativeObject : ObjectCollector.negativeObjects) {
            System.out.println(negativeObject.toString());
        }*/
    }

}
