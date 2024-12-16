package express.object.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Objects {

    /**
     * Filter the types of the objects in the list.
     *
     * @param objects the list of objects
     * @return the set of types of the objects
     */
    public static List<Class<?>> filterTypes(List<Object> objects) {
        List<Class<?>> types = new ArrayList<>();
        Set<Class<?>> visitedClasses = new HashSet<>();
        for (Object object : objects) {
            Class<?> type = object.getClass();
            if (visitedClasses.add(type))
                types.add(type);
        }
        return types;
    }

    /**
     * Filter the objects in the list by the given type.
     *
     * @param objects the list of objects
     * @param type    the type to filter by
     * @return the set of objects of the given type
     */
    public static List<Object> filterObjectsByType(List<Object> objects, Class<?> type) {
        List<Object> filtered = new ArrayList<>();
        for (Object object : objects) {
            if (type.isAssignableFrom(object.getClass())) {
                filtered.add(object);
            }
        }
        return filtered;
    }

}
