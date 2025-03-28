package express.type.typegraph;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import express.type.TypeUtils;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class TypeGraph {

    private CtVariable<?> root;
    private final Map<CtVariable<?>, List<CtVariable<?>>> adjacencyList = new LinkedHashMap<>();

    public TypeGraph(CtVariable<?> rootVariable) {
        root = rootVariable;
        LinkedList<CtVariable<?>> workList = new LinkedList<>();
        workList.add(root);

        while (!workList.isEmpty()) {
            CtVariable<?> current = workList.removeFirst();

            List<CtVariable<?>> currentAdjacency = new LinkedList<>();
            adjacencyList.put(current, currentAdjacency);

            CtType<?> declaration = current.getType().getTypeDeclaration();
            if (declaration == null)
                continue; // Type is not declared in the current project

            List<CtField<?>> fields = TypeUtils.getAccessibleFields(declaration);
            for (CtVariable<?> field : fields) {
                currentAdjacency.add(field);
                if (!adjacencyList.containsKey(field))
                    workList.add(field);
            }
        }
    }

    public LinkedHashSet<Path> computeSimplePaths(CtVariable<?> source) {
        LinkedHashSet<Path> allPaths = new LinkedHashSet<>();
        Path currentPath = new Path(source);
        computeSimplePaths(source, currentPath, allPaths);
        return allPaths;
    }

    public Set<Path> computeSimplePathsForAlternativeVar(CtVariable<?> source) {
        CtVariable<?> initialVar;
        boolean shouldReplace = false;
        if (!adjacencyList.containsKey(source)) {
            initialVar = searchVariableOfType(source.getType());
            if (initialVar == null)
                return new LinkedHashSet<>();
            shouldReplace = true;
        } else {
            initialVar = source;
        }
        Set<Path> allPaths = new LinkedHashSet<>();
        Path currentPath = new Path(source);
        computeSimplePaths(initialVar, currentPath, allPaths);
        if (shouldReplace)
            replaceFirstVariableInPaths(allPaths, source);
        return allPaths;
    }


    private void replaceFirstVariableInPaths(Set<Path> allPaths, CtVariable<?> newFirstVar) {
        for (Path path : allPaths) {
            if (!path.isEmpty())
                path.set(0, newFirstVar);
        }
    }

    private CtVariable<?> searchVariableOfType(CtTypeReference<?> type) {
        for (CtVariable<?> node : adjacencyList.keySet()) {
            if (node.getType().isSubtypeOf(type))
                return node;
        }
        return null;
    }

    private void computeSimplePaths(CtVariable<?> current, Path currentPath, Set<Path> allPaths) {
        allPaths.add(currentPath.clone());
        List<CtVariable<?>> adjacent = adjacencyList.get(current);
        for (CtVariable<?> node : adjacent) {
            if (!currentPath.contains(node)) {
                currentPath.add(node);
                computeSimplePaths(node, currentPath, allPaths);
                currentPath.removeLast();
            }
        }
    }

//    public Set<CtTypeReference<?>> computeTypes() {
//        Set<CtTypeReference<?>> types = new LinkedHashSet<>();
//        for (CtVariable<?> node : adjacencyList.keySet())
//            types.add(node.getType());
//        return new LinkedHashSet<>(types);
//    }

    public LinkedHashSet<CtTypeReference<?>> computeTypes() {
        Set<CtTypeReference<?>> types = new LinkedHashSet<>();
        for (CtVariable<?> node : adjacencyList.keySet()) {
            CtTypeReference<?> type = node.getType();
            if (!type.getActualTypeArguments().isEmpty() || !type.isGenerics())
                types.add(type);
        }
        return new LinkedHashSet<>(types);
    }

    /**
     * Get all the possible paths of length minor or equal to k from the source node to any other
     * node in the graph.
     *
     * @param source the source node
     * @param k      the maximum length of the paths
     * @return the list of all the possible paths of length minor or equal to k
     */
    public Set<Path> computeAllPathsOfLengthK(CtVariable<?> source, int k) {
        Set<Path> allPaths = new LinkedHashSet<>();
        Path currentPath = new Path(source);
        computeAllPathsOfLengthK(source, currentPath, allPaths, k);
        return allPaths;
    }

    private void computeAllPathsOfLengthK(CtVariable<?> current, Path currentPath, Set<Path> allPaths, int k) {
        if (currentPath.size() > k)
            return;
        allPaths.add(currentPath.clone());
        List<CtVariable<?>> adjacent = adjacencyList.get(current);
        for (CtVariable<?> node : adjacent) {
            currentPath.add(node);
            computeAllPathsOfLengthK(node, currentPath, allPaths, k);
            currentPath.removeLast();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CtVariable<?> node : adjacencyList.keySet()) {
            sb.append(node.getSimpleName()).append(" -> ");
            List<CtVariable<?>> adjacent = adjacencyList.get(node);
            for (CtVariable<?> adj : adjacent) {
                sb.append(adj.getSimpleName()).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
