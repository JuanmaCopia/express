package evoexpress.classinvariant.mutator.structurecheck;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeData;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeclareVisitedSetMutator implements ClassInvariantMutator {

    List<CtTypeReference<?>> candidateTypes;
    CtBlock<?> structureMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        Set<CtVariable<?>> visitedSets = new HashSet<>(SpoonQueries.getVisitedSetLocalVars(structureMethodBody));
        Set<CtTypeReference<?>> visitedSetTypes = visitedSets.stream().map(
                v -> v.getType().getActualTypeArguments().get(0)
        ).collect(Collectors.toSet());
        TypeData typeData = SpoonManager.getTypeData();
        candidateTypes = typeData.getReferenceTypes().stream().filter(t -> !visitedSetTypes.contains(t)).toList();

        return !candidateTypes.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtTypeReference<?> chosenType = candidateTypes.get(RandomUtils.nextInt(candidateTypes.size()));
        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(chosenType);
        structureMethodBody.insertBegin((CtStatement) setVar);
//        System.err.println("DeclareVisitedSetMutator:\n" + setVar);
        return true;
    }


}
