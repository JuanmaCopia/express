package evoexpress.ga.mutator;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtMethod;
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

    public static boolean isTraversalBlock(CtCodeElement elem) {
        return elem instanceof CtBlock<?> block && block.getParent() instanceof CtMethod<?> m && m.getSimpleName().startsWith(LocalVarHelper.TRAVERSAL_PREFIX);
    }

    public static boolean isInitialCheckBlock(CtCodeElement elem) {
        return elem instanceof CtBlock<?> block && block.getParent() instanceof CtMethod<?> m && m.getSimpleName().startsWith("initialCheck");
    }
}
