package evorep.spoon.typesgraph;


import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class TypeGraph {

    CtTypeReference<?> rootType;
    Map<CtTypeReference<?>, List<Edge>> adjacencyList = new HashMap<>();

    public TypeGraph(CtTypeReference<?> rootType) {
        this.rootType = rootType;
        populateGraph();
    }

    private void populateGraph() {
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
            for (CtField<?> field : fields) {
                CtTypeReference fieldType = field.getType();
                if (fieldType != null) {
                    addEdge(currentType, fieldType, field);
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }
        }
    }

    public void addNode(CtTypeReference<?> node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(CtTypeReference<?> source, CtTypeReference<?> destination, CtField<?> label) {
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

    public List<CtField<?>> getOutgoingFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).collect(Collectors.toList());
    }

    public List<CtVariable<?>> getOutgoingReferenceFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isReferenceType).collect(Collectors.toList());
    }

    public List<CtField<?>> getOutgoingUserDefinedFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isUserDefined).collect(Collectors.toList());
    }


    public List<CtField<?>> getOutgoingPrimitiveFields(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(Edge::getLabel).filter(SpoonQueries::isPrimitiveType).collect(Collectors.toList());
    }

    public List<CtTypeReference<?>> getAdjacentNodes(CtTypeReference<?> source) {
        return adjacencyList.get(source).stream().map(edge -> edge.getDestination()).collect(Collectors.toList());
    }

    /*public List<CtTypeReference<?>> getNodesWithSelfCycles() {
        List<CtTypeReference<?>> nodesWithCycles = new LinkedList<>();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            if (nodeHasCycle(node))
                nodesWithCycles.add(node);
        }
        return nodesWithCycles;
    }
*/
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
            for (CtField<?> field : fields) {
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

    public List<CtField<?>> getSelfCyclicFieldsOfNode(CtTypeReference<?> node) {
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

    public List<List<CtField<?>>> getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination) {
        List<List<CtField<?>>> paths = new LinkedList<>();
        List<CtField<?>> currentPath = new LinkedList<>();
        getSimplePaths(source, destination, currentPath, paths);
        return paths;
    }

    private void getSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination, List<CtField<?>> currentPath, List<List<CtField<?>>> paths) {
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
    public List<List<CtField<?>>> getAllPaths(CtTypeReference<?> source, int k) {
        List<List<CtField<?>>> paths = new LinkedList<>();
        List<CtField<?>> currentPath = new LinkedList<>();
        getAllPaths(source, currentPath, paths, k);
        return paths;
    }

    private void getAllPaths(CtTypeReference<?> source, List<CtField<?>> currentPath, List<List<CtField<?>>> paths, int k) {
        if (k == 1) {
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

    public Set<CtVariableRead<?>> getReacheableCyclicFieldReads() {
        Set<CtVariableRead<?>> reacheableCyclicFieldReads = new HashSet<>();
        Set<CtTypeReference<?>> nodesWithCycles = getNodesWithSelfCycles();
        for (CtTypeReference<?> node : nodesWithCycles) {
            List<List<CtField<?>>> simplePaths = getSimplePaths(rootType, node);
            for (List<CtField<?>> path : simplePaths) {
                reacheableCyclicFieldReads.add(SpoonFactory.createFieldRead(path));
            }
        }
        return reacheableCyclicFieldReads;
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


    static class Edge {
        private final CtTypeReference<?> destination;
        private final CtField<?> label;

        public Edge(CtTypeReference<?> destination, CtField<?> label) {
            this.destination = destination;
            this.label = label;
        }

        public CtTypeReference<?> getDestination() {
            return destination;
        }

        public CtField<?> getLabel() {
            return label;
        }

        public String toString() {
            return "(" + label.getSimpleName() + ") " + destination.getSimpleName();
        }
    }

}
