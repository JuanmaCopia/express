package evorep.object;

import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.options.Options;

import java.util.HashSet;
import java.util.Set;

/**
 * This class allows to generate a set of positive and negative objects from a given test suite.
 * Positive objects are objects that can be built from the current implementation of the class under test.
 * Negative objects are objects that are 'mutations' of the positive objects, i.e.,
 * they are obtained by modifying the positive objects through random mutations.
 */
public class ObjectGenerator {

  private static SootClass SOOT_TEST_CLASS; // Soot representation of the test suite class

  private static Set<Object> positiveObjects = new HashSet<>(); // Set of positive objects
  private static Set<Object> negativeObjects = new HashSet<>(); // Set of negative objects

  /**
   * Generate the set of positive and negative objects.
   * @param testSuiteClassName the fully qualified name of the test suite class
   */
  public static void generateObjects(String testSuiteClassName) {
    init(testSuiteClassName);
    if (positiveObjects.isEmpty() && negativeObjects.isEmpty()) {

    }
  }

  /**
   * Initialize the test suite class and setup Soot.
   * @param testSuiteClassName the fully qualified name of the test suite class
   */
  private static void init(String testSuiteClassName) {
    try {
      // Load class and setup
      Class.forName(testSuiteClassName);
      setupSoot();
      // Load the Soot class
      //SOOT_TEST_CLASS = Scene.v().loadClassAndSupport(testSuiteClassName);
      //Scene.v().loadClassAndSupport("evorep.object.ObjectCollector");
      //SOOT_TEST_CLASS.setApplicationClass();
      //Scene.v().loadNecessaryClasses();
      // Instrument tests
      instrumentTests();
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("The test suite class " + testSuiteClassName + " was not found.");
    }
  }

  /**
   * Setup all the necessary for Soot
   */
  private static void setupSoot() {
    // Setup Soot
    G.reset();
    Options.v().set_prepend_classpath(true);
    Options.v().set_allow_phantom_refs(true);
    Options.v().set_soot_classpath(System.getProperty("java.class.path"));
  }

  /**
   * Instrument every test within the test suite to collect the positive and negative objects.
   */
  private static void instrumentTests() {
    // TODO: Implement this method
  }

}
