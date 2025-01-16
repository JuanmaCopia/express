package express.object;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import collector.ObjectCollector;
import express.execution.Executor;
import express.object.helpers.Copy;
import express.object.helpers.Hash;
import express.object.mutate.ObjectInitializationMutator;
import express.object.mutate.PrimitiveTypeMutator;
import express.spoon.SpoonManager;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 * @author Juan Manuel Copia <juanmanuel.copia@imdea.org>
 * +
 */
public class ObjectGenerator {

    public static final Logger logger = Logger.getLogger(SpoonManager.class.getName());

    private static final Map<String, Object> hashcodeToObjects = new HashMap<>();

    public static final List<Object> positiveObjects = new ArrayList<>();
    public static final List<Object> allNegativeObjects = new ArrayList<>();
    public static final List<Object> negativeInitializationObjects = new ArrayList<>();
    public static final List<Object> negativeHeapObjects = new ArrayList<>();
    public static final List<Object> negativePrimitiveObjects = new ArrayList<>();

    /**
     * Generate the set of positive and negative objects.
     */
    public static void generateObjects() {
        if (!SpoonManager.isInitialized())
            throw new IllegalStateException("SpoonManager must be initialized before generating objects");
        generatePositiveObjects();
        generateNegativeInitializationObjects();
        generateNegativeHeapObjects();
        generateNegativePrimitiveObjects();
        setAllNegativeObjects();
    }

    public static void generatePositiveObjects() {
        Executor.runTestSuite(SpoonManager.getSubjectTestClass().getQualifiedName(), SpoonManager.getClassLoader());
        positiveObjects.addAll(ObjectCollector.positiveObjects);
    }

    private static void generateNegativeInitializationObjects() {
        for (Object positiveObject : positiveObjects) {
            for (int i = 0; i < SpoonManager.getConfig().maxMutationsPerInstance; i++) {
                Object copy = Copy.deepCopy(positiveObject);
                boolean wasMutated = ObjectInitializationMutator.mutateObject(copy, 4);
                if (wasMutated)
                    addObjectIfNotPresent(copy, negativeInitializationObjects);
            }
        }
    }

    /**
     * Generate the negative objects by randomly mutating the positive objects.
     */
    private static void generateNegativeHeapObjects() {
        for (Object positiveObject : positiveObjects) {
            for (int i = 0; i < SpoonManager.getConfig().maxMutationsPerInstance; i++) {
                Object copy = Copy.deepCopy(positiveObject);
                boolean wasMutated = ObjectInitializationMutator.mutateObject(copy, 10);
                if (wasMutated)
                    addObjectIfNotPresent(copy, negativeHeapObjects);
            }
        }
    }

    private static void generateNegativePrimitiveObjects() {
        for (Object positiveObject : positiveObjects) {
            for (int i = 0; i < SpoonManager.getConfig().maxMutationsPerInstance; i++) {
                Object copy = Copy.deepCopy(positiveObject);
                boolean wasMutated = PrimitiveTypeMutator.mutatePrimitiveValues(copy);
                if (wasMutated)
                    negativePrimitiveObjects.add(copy);
            }
        }
    }

    private static void addObjectIfNotPresent(Object object, Collection<Object> collection) {
        String hash = Hash.calculateHash(object);
        if (!hashcodeToObjects.containsKey(hash)) {
            hashcodeToObjects.put(hash, object);
            collection.add(object);
        }
    }

    private static void setAllNegativeObjects() {
        allNegativeObjects.addAll(negativeInitializationObjects);
        allNegativeObjects.addAll(negativeHeapObjects);
        allNegativeObjects.addAll(negativePrimitiveObjects);
    }


}
