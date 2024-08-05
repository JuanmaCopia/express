package evoexpress.classinvariant.mutator.structurecheck;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveVisitedSetMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        return !SpoonQueries.getVisitedSetLocalVars(structureMethodBody).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtMethod<?> structureMethod = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        CtBlock<?> structureMethodBody = structureMethod.getBody();

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));

        List<CtIf> checks = MutatorHelper.getMutablesIfReturnFalse(structureMethod);
        for (CtIf check : checks) {
            if (check.getCondition().toString().contains(setVar.getSimpleName())) {
                check.delete();
                return true;
            }
        }

        setVar.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
