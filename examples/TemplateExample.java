package casestudies.pli.schedule;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
public class Predicate {
    public static boolean repOkStructure_M_(Schedule _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((_this.<PATH_TO_TARGET_OR_PARENT> != null) && (!traverse_0_M_(_this.<PATH_TO_TARGET_OR_PARENT>, mapOfVisited))) {
            return false;
        }
        return true;
    }

    public static boolean repOkPrimitive_M_(Schedule _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        return true;
    }

    public static boolean predicate(Schedule _this) {
        Map<Class<?>, Set<Object>> mapOfVisited = new IdentityHashMap<>();
        if (!repOkStructure_M_(_this, mapOfVisited)) {
            return false;
        }
        if (!repOkPrimitive_M_(_this, mapOfVisited)) {
            return false;
        }
        return true;
    }

    private static boolean traverse_0_M_(<TARGET_CLASS_OR_PARENT> subject, Map<Class<?>, Set<Object>> mapOfVisited) {
        /*
            <MUTABLE BLOCK OF CODE>
        */
        <TARGET_CLASS> rootElement = <TARGET_PATH> // e.g: subject.field;
        Set<Object> visited = mapOfVisited.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        if (!visited.add(rootElement)) {
            return false;
        }
        Job current_ = rootElement;
        while (current_ != null) {
            /*
                <MUTABLE BLOCK OF CODE>
            */
            if (current_.<TARGET_FIELD> != null) {
                if (!visited.add(current_.<TARGET_FIELD>)) {
                    return false;
                }
            }
            current_ = current_.<TARGET_FIELD>;
        }
        /*
            <MUTABLE BLOCK OF CODE>
        */
        return true;
    }
}