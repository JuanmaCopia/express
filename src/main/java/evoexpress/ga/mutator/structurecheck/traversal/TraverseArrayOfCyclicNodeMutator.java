package evoexpress.ga.mutator.structurecheck.traversal;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtMethod;

public class TraverseArrayOfCyclicNodeMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
//        Set<Path> paths = individual.getNonTraversedPathsToArrayNodes();
//        for (Path path : paths) {
//            CtVariableRead<?> arrayRead = path.getVariableRead();
//            CtArrayTypeReference<?> arrayType = (CtArrayTypeReference<?>) arrayRead.getType();
//            TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(path.get(0));
//            List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(arrayType.getComponentType());
//            if (!loopFields.isEmpty()) {
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
//        Set<Path> paths = individual.getNonTraversedPathsToArrayNodes();
//        Path chosenPath = paths.stream().toList().get(RandomUtils.nextInt(paths.size()));
//        paths.remove(chosenPath);
//
//        CtVariableRead<?> arrayRead = chosenPath.getVariableRead();
//        CtArrayTypeReference<?> arrayType = (CtArrayTypeReference<?>) arrayRead.getType();
//
//        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
//        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(arrayType.getComponentType());
//
//        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);
//
//        Processor<CtClass<?>> p = new TraverseArrayOfCyclicNodeProcessor(chosenPath, loopFields);
//        p.process(individual.getCtClass());

        //System.err.println("\nTraverseWorklistMutator:\n" + individual.getCtClass().toString());

        return true;
    }


}
