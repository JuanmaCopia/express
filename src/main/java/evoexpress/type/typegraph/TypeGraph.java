package evoexpress.type.typegraph;


import evoexpress.type.TypeUtils;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class TypeGraph {

    CtVariable<?> rootVariable;
    CtTypeReference<?> rootType;
    Map<CtTypeReference<?>, List<Edge>> adjacencyList = new HashMap<>();

    Set<Edge> edges = new HashSet<>();

    Set<Path> pathsToCyclicNodes = new HashSet<>();
    Map<CtTypeReference<?>, List<CtVariable<?>>> cyclicFieldsMap = new HashMap<>();


    public TypeGraph(CtVariable<?> rootVariable) {
        initializeGraph(rootVariable);
        initializeCyclicFieldsMap();
    }

    private void initializeCyclicFieldsMap() {
        Set<CtTypeReference<?>> nodesWithCycles = getNodes().stream().filter(this::nodeHasCycle).collect(Collectors.toSet());
        for (CtTypeReference<?> node : nodesWithCycles) {
            List<CtVariable<?>> cyclicFields = _getCyclicFieldsOfNode(node);
            cyclicFieldsMap.put(node, cyclicFields);
            pathsToCyclicNodes.addAll(getSimplePaths(rootType, node));
        }
    }

    private void initializeGraph(CtVariable<?> rootVariable) {
        this.rootVariable = rootVariable;
        this.rootType = rootVariable.getType();
        addNode(rootType);

        Set<CtTypeReference<?>> visited = new HashSet<>();
        LinkedList<CtTypeReference<?>> workList = new LinkedList<>();
        visited.add(rootType);
        workList.add(rootType);

        while (!workList.isEmpty()) {
            CtTypeReference<?> currentType = workList.removeFirst();
            addNode(currentType);

            CtType<?> declaration = currentType.getDeclaration();
            if (declaration == null)
                continue; // Type is not declared in the current project

            List<CtField<?>> fields = declaration.getFields();
            for (CtVariable<?> field : fields) {
                CtTypeReference<?> fieldType = field.getType();
                if (fieldType != null) {
                    addEdge(currentType, fieldType, field);
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }
        }
    }


    public boolean nodeHasCycle(CtTypeReference<?> node) {
        List<TypeGraph.Edge> adjacent = adjacencyList.get(node);
        for (TypeGraph.Edge edge : adjacent) {
            if (edge.destination().equals(node))
                return true;
        }
        return false;
    }

    public void addNode(CtTypeReference<?> node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(CtTypeReference<?> source, CtTypeReference<?> destination, CtVariable<?> label) {
        Edge newEdge = new Edge(source, destination, label);
        edges.add(newEdge);
        if (!adjacencyList.containsKey(source)) {
            List<Edge> adj = new LinkedList<>();
            adj.add(newEdge);
            adjacencyList.put(source, adj);
        } else {
            adjacencyList.get(source).add(newEdge);
        }
    }

    public CtTypeReference<?> getRoot() {
        return rootType;
    }

    public Set<CtTypeReference<?>> getNodes() {
        return adjacencyList.keySet();
    }

    public Set<Path> getPathsToCyclicNodes() {
        return pathsToCyclicNodes;
    }

    public List<Edge> getOutgoingEdges(CtTypeReference<?> source) {
        return adjacencyList.get(source);
    }

    public List<CtVariable<?>> getCyclicFieldsOfNode(CtTypeReference<?> node) {
        return cyclicFieldsMap.get(node);
    }

    public Set<CtTypeReference<?>> getNodesWithSelfCycles() {
        return cyclicFieldsMap.keySet();
    }

    public Set<CtTypeReference<?>> getUserDefinedTypes() {
        return adjacencyList.keySet().stream().filter(TypeUtils::isUserDefined).collect(Collectors.toSet());
    }

    public List<Edge> getOutgoingEdgesOfNode(CtTypeReference<?> source) {
        return adjacencyList.get(source);
    }

    public List<CtVariable<?>> getOutgoingFields(CtTypeReference<?> source) {
        return getOutgoingEdgesOfNode(source).stream().map(Edge::label).collect(Collectors.toList());
    }

    private List<CtVariable<?>> _getCyclicFieldsOfNode(CtTypeReference<?> node) {
        return adjacencyList.get(node).stream()
                .filter(edge -> edge.destination().equals(node))
                .map(Edge::label)
                .collect(Collectors.toList());
    }

    public LinkedList<Path> getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination) {
        LinkedList<Path> paths = new LinkedList<>();
        List<CtVariable<?>> currentPath = new LinkedList<>();
        getSimplePaths(source, destination, currentPath, paths);
        return paths;
    }

    public void getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination, List<CtVariable<?>> currentPath, List<Path> paths) {
        if (source.equals(destination)) {
            paths.add(new Path(rootVariable, currentPath));
            return;
        }

        List<TypeGraph.Edge> adjacent = adjacencyList.get(source);
        for (TypeGraph.Edge edge : adjacent) {
            currentPath.add(edge.label());
            getSimplePaths(edge.destination(), destination, currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    /**
     * Get all the possible paths of length k from the source node to any other node in the graph.
     *
     * @param source the source node
     * @param k      the length of the paths
     * @return the list of all the possible paths of length k from the source node to any other node in the graph
     */
    public List<Path> getAllPaths(CtTypeReference<?> source, int k) {
        List<Path> paths = new LinkedList<>();
        List<CtVariable<?>> currentPath = new LinkedList<>();
        getAllPaths(source, currentPath, paths, k);
        return paths;
    }

    public void getAllPaths(CtTypeReference<?> source, List<CtVariable<?>> currentFieldChain, List<Path> paths, int k) {
        if (k == 0) {
            return;
        }
        List<TypeGraph.Edge> adjacent = adjacencyList.get(source);
        for (TypeGraph.Edge edge : adjacent) {
            currentFieldChain.add(edge.label());
            paths.add(new Path(rootVariable, currentFieldChain));
            getAllPaths(edge.destination(), currentFieldChain, paths, k - 1);
            currentFieldChain.remove(currentFieldChain.size() - 1);
        }
    }

    public List<Path> getAllReferencePaths(int depth) {
        return getAllPaths(rootType, depth).stream().filter(p -> !p.isPrimitiveOrBoxedPrimitive()).toList();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            List<String> adj = adjacencyList.get(node).stream().map(Edge::toString).toList();
            builder.append(node.getSimpleName()).append(" -> ").append(adj).append("\n");
        }
        return builder.toString();
    }

    public record Edge(CtTypeReference<?> source, CtTypeReference<?> destination, CtVariable<?> label) {

        public String toString() {
            return "(" + label.getSimpleName() + ") " + destination.getSimpleName();
        }
    }

}
