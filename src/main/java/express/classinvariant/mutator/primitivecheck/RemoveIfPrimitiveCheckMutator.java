package express.classinvariant.mutator.primitivecheck;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import spoon.reflect.declaration.CtMethod;

public class RemoveIfPrimitiveCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.PRIMITIVE_METHOD_NAME);
        return !MutatorHelper.getMutableIfs(method).isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
//        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.PRIMITIVE_METHOD_NAME);
//        List<CtIf> checks = MutatorHelper.getMutableIfs(method);
//        CtIf chosenCheck = checks.get(RandomUtils.nextInt(checks.size()));
//        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }


}
