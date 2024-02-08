package evorep.typesgraph;


import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
