package express.classinvariant.mutator.unused;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.state.ClassInvariantState;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;

import java.util.List;

public class RemoveVisitedSetMutator implements ClassInvariantMutator {

    CtLocalVariable<?> chosenSetVar;
    List<CtIf> checksToDelete;

    public boolean isApplicable(ClassInvariantState state) {
/*        CtMethod<?> structureMethod = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        CtBlock<?> structureMethodBody = structureMethod.getBody();

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody);
        if (visitedSetVars.isEmpty()) {
            return false;
        }

        chosenSetVar = RandomUtils.getRandomElement(visitedSetVars);

        List<CtIf> checks = MutatorHelper.getMutableIfs(structureMethod);
        checksToDelete = new LinkedList<>();
        for (CtIf check : checks) {
            if (check.getCondition().toString().contains(chosenSetVar.getSimpleName())) {
                checksToDelete.add(check);
            }
        }*/

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
/*        for (CtIf check : checksToDelete) {
            check.delete();
        }

        chosenSetVar.delete();*/
        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }


}
