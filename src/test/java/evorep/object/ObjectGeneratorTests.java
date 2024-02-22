package evorep.object;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.scope.Scope;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectGeneratorTests {

  private final static String SOURCE_PATH = "./src/test/resources";
  private final static String CLASS_NAME = "SortedListTestSuite";

  private static CtClass<?> testSuiteClass;

  @BeforeAll
  public static void setUp() {
    // Initialise Spoon
    SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
    // Get the test suite class
    testSuiteClass = SpoonQueries.getClass(CLASS_NAME);
  }

  @Test
  public void testGenerateObjectsInitialization() {
    // TODO: Implement test
  }

  @Test
  public void testGenerateObjectsSortedList() {
    ObjectGenerator.generateObjects(testSuiteClass);
    assertEquals(3, ObjectCollector.positiveObjects.size());
  }

}
