package evorep.object;

import evorep.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.net.URLClassLoader;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectGeneratorManager {


    final static int MUTANTS_PER_VALID_INSTANCE = 6;


    /**
     * Generate the set of positive and negative objects.
     */
    public static void generateObjects(URLClassLoader classLoader) {
        // Clearing is necessary because fitness recreates the
        // objects (because the classloader each time is different)
        ObjectCollector.clear();

        CtClass<?> testSuiteClass = SpoonManager.getTestSuiteClass();
        // Generate the positive objects
        SpoonManager.runTestSuite(testSuiteClass.getQualifiedName(), classLoader);
        generateNegativeObjects();
    }

    /**
     * Generate the negative objects by randomly mutating the positive objects.
     */
    private static void generateNegativeObjects() {
        //Gson gson = new Gson();
        for (Object positiveObject : ObjectCollector.positiveObjects) {
            for (int i = 0; i < MUTANTS_PER_VALID_INSTANCE; i++) {
                Object copy = ObjectHelper.deepCopy(positiveObject);
                //Object copy = gson.fromJson(gson.toJson(positiveObject), positiveObject.getClass());
                boolean wasMutated = ObjectMutator.mutate(copy);
                if (wasMutated)
                    ObjectCollector.negativeObjects.add(copy);
            }

        }
    }

}
