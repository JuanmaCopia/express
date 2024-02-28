package evorep.object;

import com.google.gson.Gson;
import evorep.config.ToolConfig;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectGeneratorManager {

  /**
   * Generate the set of positive and negative objects.
   */
  public static void generate() {
    CtClass<?> testSuiteClass = SpoonQueries.getClass(ToolConfig.testSuiteClassName);
    generateObjects(testSuiteClass);
  }

  /**
   * Generate the set of positive and negative objects.
   * @param testSuiteClass is the spoon class corresponding to the test suite under analysis
   */
  protected static void generateObjects(CtClass<?> testSuiteClass) {
    // Initialize the test suite class by instrumenting the test methods
    initialize(testSuiteClass);
    // Generate the positive objects
    System.out.println("Running test suite: "+ testSuiteClass.getQualifiedName());
    generatePositiveObjects(testSuiteClass);
    System.out.println("Positive objects: "+ObjectCollector.positiveObjects.size());
    System.out.println();
    // Generate the negative objects
    generateNegativeObjects();
    System.out.println("Negative objects: "+ObjectCollector.negativeObjects.size());
  }

  /**
   * Initialize the test suite class by instrumenting the test methods to collect the positive and negative objects.
   * @param testSuiteClass is the spoon class corresponding to the test suite under analysis
   */
  private static void initialize(CtClass<?> testSuiteClass) {
    testSuiteClass.getMethods().forEach(method -> {
      // Check if the method contains the test annotation
      if (isTestMethod(method)) {
        Instrumenter.instrumentMethod(method);
      }
    });
  }

  /**
   * Check if the given method is a test method by checking if it has the @Test annotation.
   */
  private static boolean isTestMethod(CtMethod<?> method) {
    for (CtAnnotation<?> annotation : method.getAnnotations()) {
      if (annotation.getName().equals("Test")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Generate the positive objects by compiling and running the instrumented test suite.
   * @param testSuiteClass is the spoon class corresponding to the test suite under analysis.
   */
  private static void generatePositiveObjects(CtClass<?> testSuiteClass) {
    boolean compiled = SpoonManager.compileModel();
    if (!compiled)
      throw new RuntimeException("The instrumented test suite could not be compiled");
    SpoonManager.runTestSuite(testSuiteClass.getQualifiedName());
  }

  /**
   * Generate the negative objects by randomly mutating the positive objects.
   */
  private static void generateNegativeObjects() {
    Gson gson = new Gson();
    List<List<CtField<?>>> mutableExpressions = getMutableExpressions();
    System.out.println("Generating negative objects");
    for (Object positiveObject : ObjectCollector.positiveObjects) {
      // Create a deep copy of the positive object
      Object copy = gson.fromJson(gson.toJson(positiveObject), positiveObject.getClass());
      // Mutate the negative object
      ObjectMutator.mutate(copy, mutableExpressions);
      // Add the negative object to the list of negative objects
      ObjectCollector.negativeObjects.add(copy);
    }
  }

  /**
   * Get mutable expressions for the current class under analysis
   * Mutable expressions are chains of fields that can be mutated to generate negative objects
   * @return a list of mutable expressions
   */
  private static List<List<CtField<?>>> getMutableExpressions() {
    TypesGraph graph = SpoonManager.getTypesGraph();
    // TODO k should be a parameter from the configuration
    return graph.getAllPaths(SpoonManager.getTargetClass().getReference(), 3);
  }

}
