package express.object.helpers;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class Objects {

    /**
     * Filter the types of the objects in the list.
     *
     * @param objects the list of objects
     * @return the set of types of the objects
     */
    public static Set<Class<?>> filterTypes(Collection<Object> objects) {
        Set<Class<?>> types = Collections.newSetFromMap(new IdentityHashMap<>());
        for (Object object : objects) {
            types.add(object.getClass());
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
    public static Set<Object> filterObjectsByType(Collection<Object> objects, Class<?> type) {
        Set<Object> filtered = Collections.newSetFromMap(new IdentityHashMap<>());
        for (Object object : objects) {
            if (type.isAssignableFrom(object.getClass())) {
                filtered.add(object);
            }
        }
        return filtered;
    }

}
