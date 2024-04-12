package evorep.typegraph;


import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class TypeGraph {

    private static TypeGraph instance;
    CtTypeReference<?> rootType;
    Map<CtTypeReference<?>, List<Edge>> adjacencyList = new HashMap<>();

    protected TypeGraph(CtTypeReference<?> rootType) {
        this.rootType = rootType;
        addNode(rootType);

        Set<CtTypeReference> visited = new HashSet<>();
        LinkedList<CtTypeReference> workList = new LinkedList<>();
        visited.add(rootType);
        workList.add(rootType);

        while (!workList.isEmpty()) {
            CtTypeReference currentType = workList.removeFirst();
            addNode(currentType);

            CtType<?> declaration = currentType.getDeclaration();
            if (declaration == null)
                continue; // Type is not declared in the current project

            List<CtField<?>> fields = declaration.getFields();
            for (CtVariable<?> field : fields) {
                CtTypeReference fieldType = field.getType();
                if (fieldType != null) {
                    addEdge(currentType, fieldType, field);
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }
        }
    }

    public static TypeGraph getInstance() {
        if (instance == null) {
            instance = new TypeGraph(SpoonManager.targetClass.getReference());
        }
        return instance;
    }

    public void addNode(CtTypeReference<?> node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(CtTypeReference<?> source, CtTypeReference<?> destination, CtVariable<?> label) {
        Edge newEdge = new Edge(destination, label);
        if (!adjacencyList.containsKey(source)) {
            List<Edge> adj = new LinkedList<>();
            adj.add(newEdge);
            adjacencyList.put(source, adj);
        } else {
            adjacencyList.get(source).add(newEdge);
        }
    }

    public List<Edge> getOutgoingEdges(CtTypeReference<?> source) {
        return adjacencyList.get(source);
    }

    public List<CtVariable<?>> getOutgoingFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).collect(Collectors.toList());
    }

    public List<CtVariable<?>> getOutgoingReferenceFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isReferenceType).collect(Collectors.toList());
    }

    public List<CtVariable<?>> getOutgoingUserDefinedFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isUserDefined).collect(Collectors.toList());
    }


    public List<CtVariable<?>> getOutgoingPrimitiveFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isPrimitiveType).collect(Collectors.toList());
    }

    public List<CtTypeReference<?>> getAdjacentNodes(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(edge -> edge.getDestination()).collect(Collectors.toList());
    }

    public Set<CtTypeReference<?>> getNodesWithSelfCycles() {
        Set<CtTypeReference> visited = new HashSet<>();
        LinkedList<CtTypeReference> workList = new LinkedList<>();
        visited.add(rootType);
        workList.add(rootType);

        Set<CtTypeReference<?>> nodesWithCycles = new HashSet<>();
        while (!workList.isEmpty()) {
            CtTypeReference currentType = workList.removeFirst();

            if (nodeHasCycle(currentType))
                nodesWithCycles.add(currentType);

            CtType<?> declaration = currentType.getDeclaration();
            if (declaration == null)
                continue; // Type is not declared in the current project

            List<CtField<?>> fields = declaration.getFields();
            for (CtVariable<?> field : fields) {
                CtTypeReference fieldType = field.getType();
                if (fieldType != null) {
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }
        }

        return nodesWithCycles;
    }

    public boolean nodeHasCycle(CtTypeReference<?> node) {
        List<Edge> adjacent = adjacencyList.get(node);
        for (Edge edge : adjacent) {
            if (edge.getDestination().equals(node))
                return true;
        }
        return false;
    }

    public List<CtVariable<?>> getSelfCyclicFieldsOfNode(CtTypeReference<?> node) {
        return getSelfCyclesOfNode(node).stream().map(edge -> edge.getLabel()).collect(Collectors.toList());
    }

    public List<Edge> getSelfCyclesOfNode(CtTypeReference<?> node) {
        List<Edge> selfCycles = new LinkedList<>();
        List<Edge> adjacent = adjacencyList.get(node);
        for (Edge edge : adjacent) {
            if (edge.getDestination().equals(node))
                selfCycles.add(edge);
        }
        return selfCycles;
    }

    public List<List<CtVariable<?>>> getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination) {
        List<List<CtVariable<?>>> paths = new LinkedList<>();
        List<CtVariable<?>> currentPath = new LinkedList<>();
        getSimplePaths(source, destination, currentPath, paths);
        return paths;
    }

    private void getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination, List<CtVariable<?>> currentPath, List<List<CtVariable<?>>> paths) {
        if (source.equals(destination)) {
            paths.add(new LinkedList<>(currentPath));
            return;
        }
        //System.out.println("\nThe graph is: " + toString());
        //System.out.println("Source: " + source.getSimpleName());
        List<Edge> adjacent = adjacencyList.get(source);
        for (Edge edge : adjacent) {
            currentPath.add(edge.getLabel());
            getSimplePaths(edge.getDestination(), destination, currentPath, paths);
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
    public List<List<CtVariable<?>>> getAllPaths(CtTypeReference<?> source, int k) {
        List<List<CtVariable<?>>> paths = new LinkedList<>();
        List<CtVariable<?>> currentPath = new LinkedList<>();
        getAllPaths(source, currentPath, paths, k);
        return paths;
    }

    private void getAllPaths(CtTypeReference<?> source, List<CtVariable<?>> currentPath, List<List<CtVariable<?>>> paths, int k) {
        if (k == 0) {
            return;
        }
        List<Edge> adjacent = adjacencyList.get(source);
        for (Edge edge : adjacent) {
            currentPath.add(edge.getLabel());
            paths.add(new LinkedList<>(currentPath));
            getAllPaths(edge.getDestination(), currentPath, paths, k - 1);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public List<List<CtVariable<?>>> getPathsToCyclicFields() {
        List<List<CtVariable<?>>> pathsToCyclicFields = new ArrayList<>();
        Set<CtTypeReference<?>> nodesWithCycles = getNodesWithSelfCycles();
        for (CtTypeReference<?> node : nodesWithCycles) {
            List<List<CtVariable<?>>> simplePaths = getSimplePaths(rootType, node);
            for (List<CtVariable<?>> path : simplePaths) {
                pathsToCyclicFields.add(path);
            }
        }
        return pathsToCyclicFields;
    }

    public CtTypeReference<?> getRoot() {
        return rootType;
    }

    public Set<CtTypeReference<?>> getAllNodes() {
        return adjacencyList.keySet();
    }

    public Set<CtTypeReference<?>> getUserDefinedTypes() {
        return adjacencyList.keySet().stream().filter(SpoonQueries::isUserDefined).collect(Collectors.toSet());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            List<String> adj = adjacencyList.get(node).stream().map(edge -> edge.toString()).toList();
            builder.append(node.getSimpleName() + " -> " + adj + "\n");
        }
        return builder.toString();
    }


    public static class Edge {
        private final CtTypeReference<?> destination;
        private final CtVariable<?> label;

        public Edge(CtTypeReference<?> destination, CtVariable<?> label) {
            this.destination = destination;
            this.label = label;
        }

        public CtTypeReference<?> getDestination() {
            return destination;
        }

        public CtVariable<?> getLabel() {
            return label;
        }

        public String toString() {
            return "(" + label.getSimpleName() + ") " + destination.getSimpleName();
        }
    }

}
