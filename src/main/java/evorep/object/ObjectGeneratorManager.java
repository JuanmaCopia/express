package evorep.object;

import com.google.gson.Gson;
import evorep.spoon.SpoonManager;
import evorep.spoon.typesgraph.TypeGraph;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;

import java.net.URLClassLoader;
import java.util.List;

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
    public static void generateObjects(URLClassLoader classLoader) {
        ObjectCollector.clear();

        CtClass<?> testSuiteClass = SpoonManager.getTestSuiteClass();

        // Generate the positive objects
        //System.out.println("Running test suite: " + testSuiteClass.getQualifiedName());
        SpoonManager.runTestSuite(testSuiteClass.getQualifiedName(), classLoader);
        //System.out.println("Positive objects: " + ObjectCollector.positiveObjects.size());
        //System.out.println();
        // Generate the negative objects
        generateNegativeObjects();
        //System.out.println("Negative objects: " + ObjectCollector.negativeObjects.size());
    }

    /**
     * Generate the negative objects by randomly mutating the positive objects.
     */
    private static void generateNegativeObjects() {
        Gson gson = new Gson();
        //System.out.println("Generating negative objects");
        for (Object positiveObject : ObjectCollector.positiveObjects) {
            // Create a deep copy of the positive object
            Object copy = gson.fromJson(gson.toJson(positiveObject), positiveObject.getClass());
            // Mutate the negative object
            boolean wasMutated = ObjectMutator.mutate(copy);
            // Add the negative object to the list of negative objects
            if (wasMutated)
                ObjectCollector.negativeObjects.add(copy);
        }
    }

    /**
     * Get mutable expressions for the current class under analysis
     * Mutable expressions are chains of fields that can be mutated to generate negative objects
     *
     * @return a list of mutable expressions
     */
    private static List<List<CtField<?>>> getMutableExpressions() {
        TypeGraph graph = SpoonManager.getTypeGraph();
        // TODO k should be a parameter from the configuration
        return graph.getAllPaths(SpoonManager.getTargetClass().getReference(), 3);
    }

}
