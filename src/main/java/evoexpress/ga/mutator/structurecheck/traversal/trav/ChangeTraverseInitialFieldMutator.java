package evoexpress.ga.mutator.structurecheck.traversal.trav;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.processors.traversals.InvokeWorklistProcessor;
import evoexpress.spoon.processors.traversals.TraverseWorklistProcessor;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChangeTraverseInitialFieldMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        return !SpoonQueries.getTraversals(individual.getCtClass()).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        System.err.println("started ChangeTraverseInitialFieldMutator");
        List<CtMethod<?>> traversals = SpoonQueries.getTraversals(individual.getCtClass());
        CtMethod<?> chosenTraversal = traversals.get(RandomUtils.nextInt(traversals.size()));

        List<CtParameter<?>> params = chosenTraversal.getParameters();
        CtVariable<?> parentOfFirstElement = params.get(params.size() - 2);

        CtLocalVariable<?> firstElement = (CtLocalVariable<?>) chosenTraversal.getElements(
                e -> e instanceof CtLocalVariable<?> var &&
                        var.getSimpleName().equals(LocalVarHelper.FIRST_ELEMENT_VAR_NAME)
        ).get(0);

        CtVariableRead<?> firstElemRead = (CtVariableRead<?>) firstElement.getAssignment();
        CtTypeReference<?> typeOfFirstElem = firstElemRead.getType();

        String[] fields = firstElemRead.toString().split("\\.");
        String fieldName = fields[fields.length - 1];

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypegraphOfNode(typeOfFirstElem);
        List<CtVariable<?>> candidateFields = typeGraph.getOutgoingFields(parentOfFirstElement.getType()).stream().filter(
                field -> field.getType().equals(typeOfFirstElem) && !field.getSimpleName().equals(fieldName)
        ).toList();
        if (candidateFields.isEmpty()) {
            return false;
        }

        CtVariable<?> chosenField = candidateFields.get(RandomUtils.nextInt(candidateFields.size()));


        CtFieldRead newFirstElementRead = SpoonFactory.createFieldRead(parentOfFirstElement, chosenField);
        firstElement.setAssignment(newFirstElementRead);

        updateIndividualPaths(individual, typeOfFirstElem, fieldName, chosenField);

        System.err.println("ChangeTraverseInitialFieldMutator: " + chosenField.getSimpleName() + " instead of " + fieldName);
        System.err.println("Result: \n" + chosenTraversal);

        return true;
    }

    private void updateIndividualPaths(Individual individual, CtTypeReference<?> typeOfFirstElem, String fieldName, CtVariable<?> chosenField) {
        Set<Path> traversedPaths = individual.getTraversedPathsToCyclicNodes();
        assert !traversedPaths.isEmpty();

        Set<Path> thisTraversalPaths = filterPaths(traversedPaths, typeOfFirstElem, fieldName);
        assert !thisTraversalPaths.isEmpty();
        updateNonTraversedPaths(thisTraversalPaths, individual);

        for (Path path : thisTraversalPaths) {
            path.setLast(chosenField);
        }

    }

    private void updateNonTraversedPaths(Set<Path> paths, Individual individual) {
        for (Path path : paths) {
            individual.getNonTraversedPathsToCyclicNodes().add(path.clone());
        }
    }

    public Set<Path> filterPaths(Collection<Path> paths, CtTypeReference<?> type, String fieldName) {
        Set<Path> filteredPaths = new HashSet<>();
        for (Path path : paths) {
            if (path.getTypeReference().equals(type) && path.getLast().toString().equals(fieldName)) {
                filteredPaths.add(path);
            }
        }
        return filteredPaths;
    }

//    private void replaceTraversalMethod(Path chosenPath, Individual individual, CtBlock<?> block) {
//        CtMethod<?> traversal = getTraversalOfNode(individual.getCtClass(), chosenPath.getTypeReference());
//        String traversalName = traversal.getSimpleName();
//        removeInvocation(traversalName, block);
//        individual.getCtClass().removeMethod(traversal);
//        instantiateTraversalMethod(chosenPath, individual);
//    }

//    private void removeInvocation(String traversalName, CtBlock<?> block) {
//        List<CtElement> ifContainingInvocations = SpoonQueries.getIfsInvokingMethod(block, traversalName);
//        for (CtElement statement : ifContainingInvocations) {
//            block.removeStatement((CtStatement) statement);
//        }
//    }

    private void instantiateTraversalMethod(Path chosenPath, Individual individual) {
        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        boolean useBreakInsteadOfReturn = RandomUtils.nextBoolean();
        Processor<CtClass<?>> p = new TraverseWorklistProcessor(chosenPath, loopFields, useBreakInsteadOfReturn);
        p.process(individual.getCtClass());
    }

    private boolean addTraversalInvocation(Path chosenPath, Individual individual) {
        CtMethod<?> traversal = getTraversalOfNode(individual.getCtClass(), chosenPath.getTypeReference());
        assert traversal != null;

        List<CtParameter<?>> params = traversal.getParameters();
        if (!params.get(params.size() - 2).getType().equals(chosenPath.getParentPath().getTypeReference()))
            return false;

        Processor<CtClass<?>> p = new InvokeWorklistProcessor(chosenPath, traversal);
        p.process(individual.getCtClass());
        return true;
    }

    public CtMethod<?> getTraversalOfNode(CtClass<?> ctClass, CtTypeReference<?> node) {
        Set<CtMethod<?>> traversals = ctClass.getMethods();
        for (CtMethod<?> m : traversals) {
            if (m.getSimpleName().startsWith(LocalVarHelper.TRAVERSAL_PREFIX)) {
                CtVariable<?> visitedSetParam = m.getParameters().get(m.getParameters().size() - 1);
                if (visitedSetParam.getType().getActualTypeArguments().get(0).equals(node)) {
                    return m;
                }
            }
        }
        return null;
    }


}
