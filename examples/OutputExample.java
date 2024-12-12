package casestudies.pli.schedule;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
public class Predicate {
    public static boolean repOkStructure_M_(Schedule _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        if (_this.prio_1 == null) {
            return false;
        }
        if (_this.blockQueue == null) {
            return false;
        }
        if (_this.prio_2 == null) {
            return false;
        }
        if ((_this.prio_3 == null) && (_this.prio_2 != null)) {
            return false;
        }
        if (_this.prio_0 != null) {
            return false;
        }
        Set<Object> visitedJob = mapOfVisited.computeIfAbsent(Job.class, k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        if ((_this.prio_3 != null) && (!traverse_3_M_(_this.prio_3, mapOfVisited))) {
            return false;
        }
        if ((_this.prio_2 != null) && (!traverse_3_M_(_this.prio_2, mapOfVisited))) {
            return false;
        }
        if ((_this.prio_1 != null) && (!traverse_3_M_(_this.prio_1, mapOfVisited))) {
            return false;
        }
        if ((_this.blockQueue != null) && (!traverse_0_M_(_this.blockQueue, mapOfVisited))) {
            return false;
        }
        if ((_this.curProc != null) && visitedJob.add(_this.curProc)) {
            return false;
        }
        if (visitedJob.size() != _this.numProcesses) {
            return false;
        }
        return true;
    }

    public static boolean repOkPrimitive_M_(Schedule _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((((((_this != null) && (_this.prio_3 != null)) && (_this.prio_3.last != null)) && (_this.prio_1 != null)) && (_this.prio_1.last != null)) && (!(_this.prio_3.last.val < _this.prio_1.last.val))) {
            return false;
        }
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

    private static boolean traverse_3_M_(List subject, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((subject.last != null) && (subject.last.next != null)) {
            return false;
        }
        if ((subject.last == null) && (subject.first != null)) {
            return false;
        }
        if ((subject.first != null) && (subject.first.prev != null)) {
            return false;
        }
        if ((subject == null) || (subject.first == null)) {
            return true;
        }
        Job rootElement = subject.first;
        Set<Object> visitedJob = mapOfVisited.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        int initialSize_ = visitedJob.size();
        if (!visitedJob.add(rootElement)) {
            return false;
        }
        Job current_ = rootElement;
        while (current_ != null) {
            if (((current_ != null) && (current_.next != null)) && (current_.next.prev != current_)) {
                return false;
            }
            if (((current_ != null) && (current_.next != null)) && (current_.priority < current_.next.priority)) {
                return false;
            }
            if (current_.next != null) {
                if (!visitedJob.add(current_.next)) {
                    return false;
                }
            }
            current_ = current_.next;
        }
        if ((subject.last != null) && visitedJob.add(subject.last)) {
            return false;
        }
        if ((visitedJob.size() - initialSize_) != subject.mem_count) {
            return false;
        }
        return true;
    }

    private static boolean traverse_0_M_(List subject, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((subject.first == null) && (subject.last != null)) {
            return false;
        }
        if ((subject.first != null) && (subject.last == null)) {
            return false;
        }
        if ((subject == null) || (subject.last == null)) {
            return true;
        }
        Job rootElement = subject.last;
        Set<Object> visitedJob = mapOfVisited.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        int initialSize_ = visitedJob.size();
        if (!visitedJob.add(rootElement)) {
            return false;
        }
        Job current_ = rootElement;
        while (current_ != null) {
            if (((current_ != null) && (current_.next != null)) && (current_.next.prev != current_)) {
                return false;
            }
            if (current_.prev != null) {
                if (!visitedJob.add(current_.prev)) {
                    return false;
                }
            }
            current_ = current_.prev;
        }
        if ((subject.first != null) && visitedJob.add(subject.first)) {
            return false;
        }
        if ((visitedJob.size() - initialSize_) != subject.mem_count) {
            return false;
        }
        return true;
    }
}