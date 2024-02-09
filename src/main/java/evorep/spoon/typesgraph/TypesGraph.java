package evorep.spoon.typesgraph;


import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TypesGraph {

    Map<CtTypeReference<?>, List<Edge>> adjacencyList = new HashMap<>();

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

    public List<Edge> getAdjacentNodes(CtTypeReference<?> source) {
        return adjacencyList.get(source);
    }

    public boolean nodeHasCycle(CtTypeReference<?> node) {
        List<Edge> adjacent = adjacencyList.get(node);
        for (Edge edge : adjacent) {
            if (edge.getDestination().equals(node))
                return true;
        }
        return false;
    }

    public List<CtTypeReference<?>> getNodesWithSelfCycles() {
        List<CtTypeReference<?>> nodesWithCycles = new LinkedList<>();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            if (nodeHasCycle(node))
                nodesWithCycles.add(node);
        }
        return nodesWithCycles;
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

    public List<CtField<?>> getSelfCyclicFieldsOfNode(CtTypeReference<?> node) {
        return getSelfCyclesOfNode(node).stream().map(edge -> edge.getLabel()).collect(Collectors.toList());
    }

    public List<List<CtField<?>>> getAllSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination) {
        List<List<CtField<?>>> paths = new LinkedList<>();
        List<CtField<?>> currentPath = new LinkedList<>();
        getAllSimplePaths(source, destination, currentPath, paths);
        return paths;
    }

    private void getAllSimplePaths(CtTypeReference<?> source, CtTypeReference<?> destination, List<CtField<?>> currentPath, List<List<CtField<?>>> paths) {
        if (source.equals(destination)) {
            paths.add(new LinkedList<>(currentPath));
            return;
        }
        //System.out.println("\nThe graph is: " + toString());
        //System.out.println("Source: " + source.getSimpleName());
        List<Edge> adjacent = adjacencyList.get(source);
        for (Edge edge : adjacent) {
            currentPath.add(edge.getLabel());
            getAllSimplePaths(edge.getDestination(), destination, currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (CtTypeReference<?> node : adjacencyList.keySet()) {
            List<String> adj = adjacencyList.get(node).stream().map(edge -> edge.toString()).toList();
            builder.append(node.getSimpleName() + " -> " + adj.toString() + "\n");
        }
        return builder.toString();
    }


    static class Edge {
        private CtTypeReference<?> destination;
        private CtField<?> label;

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
