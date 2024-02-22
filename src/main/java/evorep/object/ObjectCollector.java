package evorep.object;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods that are included in test methods in order to save the objects
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectCollector {

  public static List<Object> positiveObjects = new ArrayList<>();

  public static void saveObject(Object object) {
    positiveObjects.add(object);
  }

}
