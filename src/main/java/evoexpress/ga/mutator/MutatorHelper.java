package evoexpress.ga.mutator;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

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

    public static CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, CtStatement statement, CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = pickVisitedSetVariable(methodBody, setSubtype);
        if (setVar != null)
            return setVar;

        return declareVisitedSetVariable(methodBody, statement, setSubtype);
    }

    private static CtVariable<?> pickVisitedSetVariable(CtBlock<?> methodBody, CtTypeReference<?> setSubtype) {
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, setSubtype);
        if (setVars.isEmpty())
            return null;
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

    public static CtVariable<?> declareVisitedSetVariable(CtBlock<?> methodBody, CtStatement statement, CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(setSubtype, methodBody);
        statement.insertBefore((CtStatement) setVar);
        return setVar;
    }
}
