package evorep.object;

import evorep.config.ToolConfig;
import evorep.execution.Executor;
import evorep.spoon.SpoonManager;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectGeneratorManager {

    /**
     * Generate the set of positive and negative objects.
     */
    public static void generateObjects() {
        generatePositiveObjects();
        generateNegativeObjects();
    }

    public static void generatePositiveObjects() {
        Executor.runTestSuite(SpoonManager.testSuiteClass.getQualifiedName(), SpoonManager.classLoader);
    }

    /**
     * Generate the negative objects by randomly mutating the positive objects.
     */
    private static void generateNegativeObjects() {
        //Gson gson = new Gson();
        for (Object positiveObject : ObjectCollector.positiveObjects) {
            for (int i = 0; i < ToolConfig.maxMutationsPerInstance; i++) {
                Object copy = ObjectHelper.deepCopy(positiveObject);
                //Object copy = gson.fromJson(gson.toJson(positiveObject), positiveObject.getClass());
                boolean wasMutated = ObjectMutator.mutate(copy);
                if (wasMutated)
                    ObjectCollector.negativeObjects.add(copy);
            }

        }
    }

}
