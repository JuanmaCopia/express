package evoexpress.object;

import evoexpress.config.ToolConfig;
import evoexpress.spoon.SpoonManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObjectGeneratorTests {

    @BeforeAll
    public static void setUp() {
        // Initialize ToolConfig
        ToolConfig.subjectClassName = "SLL";
        ToolConfig.subjectTestSuiteClassName = "SLLTestSuite";
        ToolConfig.subjectSrcPath = "./src/test/resources";
        ToolConfig.subjectSrcJavaVersion = 17;
        // Initialise Spoon
        SpoonManager.initialize();
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
