package evorep.typesgraph;


import spoon.reflect.declaration.CtType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TypesGraph {

    Map<CtType<?>, List<CtType<?>>> adjacencyList = new HashMap<>();

    public void addNode(CtType<?> node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new LinkedList<>());
        }
    }

    public void addEdge(CtType<?> source, CtType<?> destination) {
        if (!adjacencyList.containsKey(source)) {
            List<CtType<?>> adj = new LinkedList<>();
            adj.add(destination);
            adjacencyList.put(source, adj);
        } else {
            adjacencyList.get(source).add(destination);
        }
    }

    public List<CtType<?>> getAdjacentNodes(CtType<?> source) {
        return adjacencyList.get(source);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (CtType<?> node : adjacencyList.keySet()) {
            List<String> adj = adjacencyList.get(node).stream().map(type -> type.getSimpleName()).toList();
            builder.append(node.getSimpleName() + " -> " + adj.toString() + "\n");
        }
        return builder.toString();
    }

}
