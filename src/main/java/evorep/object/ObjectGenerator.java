package evorep.object;

import evorep.spoon.SpoonManager;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectGenerator {

  /**
   * Generate the set of positive and negative objects.
   * @param testSuiteClass is the spoon class corresponding to the test suite under analysis
   */
  public static void generateObjects(CtClass<?> testSuiteClass) {
    // Initialize the test suite class by instrumenting the test methods
    initialize(testSuiteClass);
    // Generate the positive objects
    generatePositiveObjects(testSuiteClass);
    System.out.println("Positive objects: "+ObjectCollector.positiveObjects.size());
    // Generate the negative objects
    generateNegativeObjects();
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
    for (Object positiveObject : ObjectCollector.positiveObjects) {
      //
    }
  }

}
