package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.TypeData;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
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
        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME)
                .getBody();
        Set<CtVariable<?>> visitedSets = new HashSet<>(SpoonQueries.getVisitedSetLocalVars(structureMethodBody));
        // System.err.println("\nVisitedSets: " + visitedSets);
        Set<String> visitedSetTypes = visitedSets.stream().map(
                v -> v.getType().getActualTypeArguments().get(0).getQualifiedName()).collect(Collectors.toSet());
        TypeData typeData = SpoonManager.getSubjectTypeData();
        candidateTypes = typeData.getReferenceTypes().stream()
                .filter(t -> !visitedSetTypes.contains(t.getQualifiedName())).toList();
        // System.err.println("\nCandidateTypes: " + candidateTypes);

        return !candidateTypes.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtTypeReference<?> chosenType = candidateTypes.get(RandomUtils.nextInt(candidateTypes.size()));
        CtVariable<?> setVar = SpoonFactory.createVisitedIdentitySetDeclaration(chosenType);
        structureMethodBody.insertBegin((CtStatement) setVar);
        // System.err.println("DeclareVisitedSetMutator:\n" + setVar);
    }

}