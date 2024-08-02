package evoexpress.object;

import evoexpress.config.Config;
import evoexpress.execution.Executor;
import evoexpress.spoon.SpoonManager;

import java.util.logging.Logger;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 * @author Juan Manuel Copia <juanmanuel.copia@imdea.org>
 +
 */
public class ObjectGenerator {

    public static final Logger logger = Logger.getLogger(SpoonManager.class.getName());

    /**
     * Generate the set of positive and negative objects.
     */
    public static void generateObjects() {
        if (!SpoonManager.isInitialized())
            throw new IllegalStateException("SpoonManager must be initialized before generating objects");
        generatePositiveObjects();
        generateNegativeObjects();
        logger.info("Positive Objects Generated: " + ObjectCollector.positiveObjects.size());
        logger.info("Negative Objects Generated: " + ObjectCollector.negativeObjects.size());
    }

    public static void generatePositiveObjects() {
        Executor.runTestSuite(SpoonManager.getTestSuiteClass().getQualifiedName(), SpoonManager.getOutput().getClassLoader());
    }

    /**
     * Generate the negative objects by randomly mutating the positive objects.
     */
    private static void generateNegativeObjects() {
        for (Object positiveObject : ObjectCollector.positiveObjects) {
            for (int i = 0; i < SpoonManager.getConfig().maxMutationsPerInstance; i++) {
                Object copy = ObjectHelper.deepCopy(positiveObject);
                boolean wasMutated = ObjectMutator.mutate(copy);
                if (wasMutated)
                    ObjectCollector.negativeObjects.add(copy);
            }
        }
    }

}
