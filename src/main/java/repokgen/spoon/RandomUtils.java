package repokgen.spoon;

import java.util.List;
import java.util.Random;

import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class RandomUtils {

    private static Random r = new Random();

    public static CtVariable<?> getRandomElementOfType(List<CtVariable<?>> list, Class<?> type) {
        List<CtVariable<?>> newList = SpoonQueries.getVariablesOfType(list, type);
        if (newList.isEmpty())
            return null;
        return newList.get(r.nextInt(list.size()));
    }

    public static CtVariable<?> getRandomElementOfType(List<CtVariable<?>> list, CtTypeReference<?> type) {
        return getRandomElementOfType(list, type.getActualClass());
    }

    public static CtVariable<?> getRandomElement(List<CtVariable<?>> list1, List<CtVariable<?>> list2) {
        if (list1 == null || list2 == null)
            throw new IllegalArgumentException("Lists cannot be null");

        int totalElements = list1.size() + list2.size();

        int choice = r.nextInt(totalElements);

        if (choice < list1.size())
            return list1.get(choice);
        return list2.get(choice - list1.size());
    }

    public static CtVariable<?> getRandomElement(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("Lists cannot be null");

        return list.get(r.nextInt(list.size()));
    }

}
