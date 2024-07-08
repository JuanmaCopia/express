package evoexpress.type.precondition;

import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;

public class InputTypeData {

    List<CtParameter<?>> inputs;
    List<CtVariable<?>> inputsWithCyclicNodes = new ArrayList<>();
    Map<CtVariable<?>, TypeGraph> typeGraphMap = new HashMap<>();

    Set<Path> pathsToCyclicNodes;
    Set<Path> pathsToArrayNodes;


    public InputTypeData(List<CtParameter<?>> methodInputs) {
        inputs = methodInputs;
        initializeTypeGraphs();
        initializePathsToCyclicNodes();
        initializePathsToArrayNodes();
    }

    private void initializeTypeGraphs() {
        for (CtVariable<?> p : inputs) {
            CtTypeReference<?> type = p.getType();
            if (TypeUtils.isUserDefined(type)) {
                TypeGraph g = new TypeGraph(p);
                typeGraphMap.put(p, g);
                if (!g.getNodesWithCycles().isEmpty())
                    inputsWithCyclicNodes.add(p);
            }
        }
    }

    private void initializePathsToCyclicNodes() {
        pathsToCyclicNodes = new HashSet<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                pathsToCyclicNodes.addAll(typeGraphMap.get(p).getPathsToCyclicNodes());
            }
        }
    }

    private void initializePathsToArrayNodes() {
        pathsToArrayNodes = new HashSet<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                pathsToArrayNodes.addAll(typeGraphMap.get(p).getPathsToArrayNodes());
            }
        }
    }

    public Set<Path> getPathsToCyclicNodes() {
        return new HashSet<>(pathsToCyclicNodes);
    }

    public List<CtVariable<?>> getParameters() {
        return new ArrayList<>(inputs);
    }

    public List<CtVariable<?>> getParametersWithCyclicNodes() {
        return new ArrayList<>(inputsWithCyclicNodes);
    }

    public LinkedList<CtParameter<?>> getInputs() {
        return new LinkedList<>(inputs);
    }

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

    public List<Path> getAllReferencePaths(CtVariable<?> initialVariable, int depth) {
        List<Path> allPaths = new ArrayList<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                allPaths.addAll(typeGraphMap.get(p).getAllReferencePaths(initialVariable, depth));
            }
        }
        return allPaths;
    }

    public List<Path> getAllPaths(int depth) {
        List<Path> allPaths = new ArrayList<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                allPaths.addAll(typeGraphMap.get(p).getAllPaths(depth));
            }
        }
        return allPaths;
    }

    public List<Path> getAllReferencePathsOfType(CtTypeReference<?> type, int depth) {
        return getAllReferencePaths(depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
    }

    public List<Path> getAllPathsOfType(CtTypeReference<?> type, int depth) {
        return getAllPaths(depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
    }

    public List<Path> getAllReferencePathsOfType(CtVariable<?> initialVariable, CtTypeReference<?> type, int depth) {
        return getAllReferencePaths(initialVariable, depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
    }

    public List<Path> getIntegerFieldsOfParameters() {
        List<Path> integerFields = new ArrayList<>();
        for (CtVariable<?> p : inputs) {
            if (TypeUtils.isUserDefined(p.getType())) {
                integerFields.addAll(typeGraphMap.get(p).getIntegerFieldsOfRoot());
            } else if (TypeUtils.isInteger(p.getType())) {
                integerFields.add(new Path(p, new ArrayList<>()));
            }
        }
        return integerFields;
    }

    public Set<Path> getPathsToArrayNodes() {
        return new HashSet<>(pathsToArrayNodes);
    }
}
