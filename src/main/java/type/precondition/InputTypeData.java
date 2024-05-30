package type.precondition;

import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;
import type.TypeUtils;
import type.typegraph.Path;
import type.typegraph.TypeGraph;

import java.util.*;

public class InputTypeData {

    List<CtParameter<?>> inputs;
    Map<CtVariable<?>, TypeGraph> typeGraphMap = new HashMap<>();

    Set<Path> pathsToCyclicNodes;
    //Map<CtVariable<?>, Set<Path>> parametersToTraversableNodes;

    public InputTypeData(List<CtParameter<?>> methodInputs) {
        inputs = methodInputs;
        initializeTypeGraphs();
        initializeParametersToTraversableNodes();
    }

    private void initializeTypeGraphs() {
        for (CtVariable<?> p : inputs) {
            CtTypeReference<?> type = p.getType();
            if (TypeUtils.isUserDefined(type)) {
                typeGraphMap.put(p, new TypeGraph(p));
            }
        }
    }

    private void initializeParametersToTraversableNodes() {
        pathsToCyclicNodes = new HashSet<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                pathsToCyclicNodes.addAll(typeGraphMap.get(p).getPathsToCyclicNodes());
            }
        }
    }

    public Set<Path> getPathsToCyclicNodes() {
        return new HashSet<>(pathsToCyclicNodes);
    }

//    private void initializeParametersToTraversableNodes() {
//        parametersToTraversableNodes = new HashMap<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                parametersToTraversableNodes.put(p, typeGraphMap.get(p).getPathsToCyclicNodes());
//            }
//        }
//    }

    public List<CtParameter<?>> getInputs() {
        return inputs;
    }

//    public Map<CtVariable<?>, Set<Path>> getMapParameterToTraversableNodes() {
//        return new HashMap<>(parametersToTraversableNodes);
//    }

    public TypeGraph getTypeGraphOfParameter(CtVariable<?> parameter) {
        CtTypeReference<?> type = parameter.getType();
        if (!TypeUtils.isUserDefined(type))
            throw new IllegalArgumentException("Type is not user defined");
        return typeGraphMap.get(parameter);
    }

    public Set<Path> getPathsToCyclicNodesOfParameter(CtVariable<?> parameter) {
        CtTypeReference<?> type = parameter.getType();
        if (!TypeUtils.isUserDefined(type))
            throw new IllegalArgumentException("Type is not user defined");
        return typeGraphMap.get(parameter).getPathsToCyclicNodes();
    }


    public List<Path> getAllReferencePaths(int depth) {
        List<Path> allPaths = new ArrayList<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                allPaths.addAll(typeGraphMap.get(p).getAllReferencePaths(depth));
            }
        }
        return allPaths;
    }

}
