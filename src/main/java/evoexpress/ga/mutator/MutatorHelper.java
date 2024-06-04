package evoexpress.ga.mutator;

import evoexpress.spoon.RandomUtils;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.List;

public class MutatorHelper {

    public static List<CtVariable<?>> selectRandomVariablesFromList(List<CtVariable<?>> list) {
        List<CtVariable<?>> candidates = new ArrayList<>(list);
        int varsToRemove = RandomUtils.nextInt(candidates.size());
        for (int i = 0; i < varsToRemove; i++)
            candidates.remove(RandomUtils.nextInt(candidates.size()));
        return candidates;
    }
}
