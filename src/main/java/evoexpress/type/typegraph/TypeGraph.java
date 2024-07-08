package evoexpress.type.typegraph;


import evoexpress.spoon.SpoonFactory;
import evoexpress.type.TypeUtils;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeInformation;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class TypeGraph {

    CtVariable<?> rootVariable;
    CtTypeReference<?> rootType;
    Map<CtTypeReference<?>, List<Edge>> adjacencyList = new HashMap<>();

    Set<Edge> edges = new HashSet<>();

    Set<Path> pathsToArrayNodes = new HashSet<>();
    Set<Path> pathsToCyclicNodes = new HashSet<>();
    Map<CtTypeReference<?>, List<CtVariable<?>>> cyclicFieldsMap = new HashMap<>();

    List<Path> allSimplePaths = new LinkedList<>();
    Map<CtTypeReference<?>, List<Path>> typesToPathsMap = new HashMap<>();


    public TypeGraph(CtVariable<?> rootVariable) {
        initializeGraph(rootVariable);
        initializeCyclicFieldsMap();
        initializePathsToArrayNodes();
        initializeSimplePaths();
    }

    private void initializeCyclicFieldsMap() {
        Set<CtTypeReference<?>> nodesWithCycles = getNodes().stream().filter(this::nodeHasCycle).collect(Collectors.toSet());
        for (CtTypeReference<?> node : nodesWithCycles) {
            List<CtVariable<?>> cyclicFields = _getCyclicFieldsOfNode(node);
            cyclicFieldsMap.put(node, cyclicFields);
            pathsToCyclicNodes.addAll(getSimplePaths(rootType, node));
        }
    }

    private void initializePathsToArrayNodes() {
        Set<CtTypeReference<?>> arrayNodes = getNodes().stream().filter(CtTypeInformation::isArray).collect(Collectors.toSet());
        for (CtTypeReference<?> node : arrayNodes) {
            pathsToArrayNodes.addAll(getSimplePaths(rootType, node));
        }
    }

    private void initializeSimplePaths() {
        List<CtVariable<?>> currentPath = new LinkedList<>();
        initializeSimplePaths(rootType, currentPath, allSimplePaths);
    }

    private void initializeSimplePaths(CtTypeReference<?> currNode, List<CtVariable<?>> currentPath, List<Path> paths) {
        if (typesToPathsMap.containsKey(currNode)) {
            Path newPath = new Path(rootVariable, currentPath);
            paths.add(newPath);
            typesToPathsMap.get(currNode).add(newPath);
            return;
        }

        typesToPathsMap.put(currNode, new LinkedList<>());

        List<TypeGraph.Edge> adjacent = adjacencyList.get(currNode);
        for (TypeGraph.Edge edge : adjacent) {
            currentPath.add(edge.label());
            initializeSimplePaths(edge.destination(), currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
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

    public Set<CtTypeReference<?>> getNodesWithCycles() {
        return getNodes().stream().filter(this::nodeHasCycle).collect(Collectors.toSet());
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

    public List<CtTypeReference<?>> getRefNodesWithAliasing() {
        List<CtTypeReference<?>> nodesWithAliasing = new LinkedList<>();
        for (CtTypeReference<?> node : getNodes()) {
            if (TypeUtils.isReferenceType(node) && typesToPathsMap.get(node).size() > 1)
                nodesWithAliasing.add(node);
        }
        return nodesWithAliasing;
    }

    public Set<CtTypeReference<?>> getUserDefinedTypes() {
        return adjacencyList.keySet().stream().filter(TypeUtils::isUserDefined).collect(Collectors.toSet());
    }

    public List<CtVariable<?>> getOutgoingFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::label).collect(Collectors.toList());
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

    public List<Path> getAllSimplePaths() {
        return allSimplePaths;
    }

    /**
     * Get all the possible paths of length k from the source node to any other node in the graph.
     *
     * @param source the source node
     * @param k      the length of the paths
     * @return the list of all the possible paths of length k from the source node to any other node in the graph
     */
    public List<Path> getAllPaths(CtVariable<?> initialVariable, CtTypeReference<?> source, int k) {
        List<Path> paths = new LinkedList<>();
        paths.add(new Path(initialVariable, new LinkedList<>()));
        List<CtVariable<?>> currentPath = new LinkedList<>();
        getAllPaths(initialVariable, source, currentPath, paths, k);
        return paths;
    }

    public List<Path> getAllPaths(int k) {
        return getAllPaths(rootVariable, rootType, k);
    }

    public void getAllPaths(CtVariable<?> initialVariable, CtTypeReference<?> source, List<CtVariable<?>> currentFieldChain, List<Path> paths, int k) {
        if (k == 0) {
            return;
        }
        List<TypeGraph.Edge> adjacent = adjacencyList.get(source);
        for (TypeGraph.Edge edge : adjacent) {
            currentFieldChain.add(edge.label());
            paths.add(new Path(initialVariable, currentFieldChain));
            getAllPaths(initialVariable, edge.destination(), currentFieldChain, paths, k - 1);
            currentFieldChain.remove(currentFieldChain.size() - 1);
        }
    }

    public List<Path> getAllReferencePaths(int depth) {
        return getAllPaths(depth).stream().filter(p -> !p.isPrimitiveOrBoxedPrimitive()).toList();
    }

    public List<Path> getAllReferenceSimplePaths(CtTypeReference<?> destination) {
        return getSimplePaths(rootType, destination).stream().filter(p -> !p.isPrimitiveOrBoxedPrimitive()).toList();
    }

    public List<Path> getAllReferencePaths(CtVariable<?> initialVariable, int depth) {
        return getAllPaths(initialVariable, initialVariable.getType(), depth).stream().filter(p -> !p.isPrimitiveOrBoxedPrimitive()).toList();
    }

    public List<Path> getIntegerFieldsOfRoot() {
        List<CtVariable<?>> rootFields = getOutgoingFields(rootType);
        List<CtVariable<?>> integerFields = rootFields.stream().filter(
                field -> field.getType().isSubtypeOf(SpoonFactory.getTypeFactory().INTEGER) ||
                        field.getType().isSubtypeOf(SpoonFactory.getTypeFactory().INTEGER_PRIMITIVE)
        ).toList();
        List<Path> paths = new LinkedList<>();
        for (CtVariable<?> field : integerFields) {
            paths.add(new Path(rootVariable, List.of(field)));
        }
        return paths;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            List<String> adj = adjacencyList.get(node).stream().map(Edge::toString).toList();
            builder.append(node.getSimpleName()).append(" -> ").append(adj).append("\n");
        }
        return builder.toString();
    }

    public Collection<? extends Path> getPathsToArrayNodes() {
        return pathsToArrayNodes;
    }

    public record Edge(CtTypeReference<?> source, CtTypeReference<?> destination, CtVariable<?> label) {

        public String toString() {
            return "(" + label.getSimpleName() + ") " + destination.getSimpleName();
        }
    }

}
