package evorep.object;

import evorep.config.ToolConfig;
import evorep.spoon.SpoonManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObjectGeneratorTests {

    @BeforeAll
    public static void setUp() {
        // Initialize ToolConfig
        ToolConfig.className = "SLL";
        ToolConfig.testSuiteClassName = "SLLTestSuite";
        ToolConfig.srcPath = "./src/test/resources";
        ToolConfig.srcJavaVersion = 17;
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
