package express.object.helpers;

import java.lang.reflect.Field;
import java.util.*;

public class Hash {

    private static long id = 0;

    private static String createObjectHash(Object object) {
        return object.getClass().getSimpleName() + id++;
    }

    public static String calculateHash(Object object) {
        id = 0;
        List<String> hashList = new LinkedList<>();
        calculateHash(object, new IdentityHashMap<>(), hashList);
        return String.join("", hashList);
    }

    public static void calculateHash(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (object == null) {
            hashList.add("null");
        } else if (Types.isUserDefinedClass(object.getClass())) {
            hashObject(object, objToHash, hashList);
        } else if (Types.isWrapperType(object) || object instanceof String) {
            // hashList.add(object.getClass().getSimpleName());
        } else if (object instanceof Collection<?>) {
            hashCollection((Collection<?>) object, objToHash, hashList);
        } else if (object instanceof Map<?, ?>) {
            hashMap((Map<?, ?>) object, objToHash, hashList);
        } else if (object.getClass().isArray()) {
            hashArray(object, objToHash, hashList);
        } else {
            hashObject(object, objToHash, hashList);
        }
    }

    private static void hashArray(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String arrayHash = createObjectHash(object);
        objToHash.put(object, arrayHash);
        hashList.add(arrayHash);

        Object[] array = (Object[]) object;
        for (Object element : array) {
            calculateHash(element, objToHash, hashList);
        }
    }

    private static void hashCollection(Collection<?> object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        for (Object element : object) {
            calculateHash(element, objToHash, hashList);
        }
    }

    private static void hashMap(Map<?, ?> object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        for (Map.Entry<?, ?> entry : object.entrySet()) {
            calculateHash(entry.getKey(), objToHash, hashList);
            calculateHash(entry.getValue(), objToHash, hashList);
        }
    }

    private static void hashObject(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        List<Field> fields = Reflection.getAccessibleFields(object.getClass());
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                calculateHash(fieldValue, objToHash, hashList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
