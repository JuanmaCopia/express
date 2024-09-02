package express.classinvariant.mutator.unused;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonQueries;
import express.util.Utils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;

import java.util.LinkedList;
import java.util.List;

public class RemoveVisitedSetMutator implements ClassInvariantMutator {

    CtLocalVariable<?> chosenSetVar;
    List<CtIf> checksToDelete;

    public boolean isApplicable(ClassInvariantState state) {
        CtMethod<?> structureMethod = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        CtBlock<?> structureMethodBody = structureMethod.getBody();

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody);
        if (visitedSetVars.isEmpty()) {
            return false;
        }

        chosenSetVar = Utils.getRandomElement(visitedSetVars);

        List<CtIf> checks = MutatorHelper.getMutableIfs(structureMethod);
        checksToDelete = new LinkedList<>();
        for (CtIf check : checks) {
            if (check.getCondition().toString().contains(chosenSetVar.getSimpleName())) {
                checksToDelete.add(check);
            }
        }

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        for (CtIf check : checksToDelete) {
            check.delete();
        }

        chosenSetVar.delete();
        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }


}
