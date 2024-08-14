package express.type.predicate;

public class InputTypeDataToRemove {

//    List<CtParameter<?>> inputs;
//    List<CtVariable<?>> inputsWithCyclicNodes = new ArrayList<>();
//    Map<CtVariable<?>, TypeGraph> paramTotypeGraphMap = new HashMap<>();
//    Map<CtTypeReference<?>, TypeGraph> typeToTypeGraphMap = new HashMap<>();
//
//    Set<Path> pathsToCyclicNodes;
//    Set<Path> pathsToArrayNodes;
//    Set<CtTypeReference<?>> nodesWithCycles = new HashSet<>();
//    Set<CtTypeReference<?>> arrayNodes = new HashSet<>();
//
//
//    public InputTypeData(List<CtParameter<?>> methodInputs) {
//        inputs = methodInputs;
//        initializeTypeGraphs();
//        initializePathsToCyclicNodes();
//        initializePathsToArrayNodes();
//        System.out.println("Paths to cyclic nodes: \n");
//        for (Path path : pathsToCyclicNodes) {
//            System.out.println(path.toString());
//        }
//    }
//
//    private void initializeTypeGraphs() {
//        for (CtVariable<?> p : inputs) {
//            CtTypeReference<?> type = p.getType();
//            if (TypeUtils.isUserDefined(type)) {
//                TypeGraph g = new TypeGraph(p);
//                initializeTypeToTypeGraphMap(g);
//                paramTotypeGraphMap.put(p, g);
//                nodesWithCycles.addAll(g.getNodesWithCycles());
//                if (!g.getNodesWithCycles().isEmpty())
//                    inputsWithCyclicNodes.add(p);
//            }
//        }
//    }
//
//    private void initializeTypeToTypeGraphMap(TypeGraph typeGraph) {
//        for (CtTypeReference<?> node : typeGraph.getNodes()) {
//            typeToTypeGraphMap.put(node, typeGraph);
//        }
//    }
//
//    private void initializePathsToCyclicNodes() {
//        pathsToCyclicNodes = new HashSet<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                pathsToCyclicNodes.addAll(paramTotypeGraphMap.get(p).getPathsToCyclicNodes());
//            }
//        }
//    }
//
//    private void initializePathsToArrayNodes() {
//        pathsToArrayNodes = new HashSet<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                TypeGraph g = paramTotypeGraphMap.get(p);
//                Collection<Path> pathToArrayNodes = g.getPathsToArrayNodes();
//                arrayNodes.addAll(g.getArrayNodes());
//                pathsToArrayNodes.addAll(pathToArrayNodes);
//            }
//        }
//    }
//
//    public Set<Path> getPathsToCyclicNodes() {
//        return new HashSet<>(pathsToCyclicNodes);
//    }
//
//    public Set<CtTypeReference<?>> getNodesWithCycles() {
//        return new HashSet<>(nodesWithCycles);
//    }
//
//    public List<CtVariable<?>> getParameters() {
//        return new ArrayList<>(inputs);
//    }
//
//    public List<CtVariable<?>> getParametersWithCyclicNodes() {
//        return new ArrayList<>(inputsWithCyclicNodes);
//    }
//
//    public TypeGraph getTypegraphOfNode(CtTypeReference<?> type) {
//        return typeToTypeGraphMap.get(type);
//    }
//
//    public LinkedList<CtParameter<?>> getInputs() {
//        return new LinkedList<>(inputs);
//    }
//
//    public TypeGraph getTypeGraphOfParameter(CtVariable<?> parameter) {
//        CtTypeReference<?> type = parameter.getType();
//        if (!TypeUtils.isUserDefined(type))
//            throw new IllegalArgumentException("Type is not user defined");
//        return paramTotypeGraphMap.get(parameter);
//    }
//
//    public Set<Path> getPathsToCyclicNodesOfParameter(CtVariable<?> parameter) {
//        CtTypeReference<?> type = parameter.getType();
//        if (!TypeUtils.isUserDefined(type))
//            throw new IllegalArgumentException("Type is not user defined");
//        return paramTotypeGraphMap.get(parameter).getPathsToCyclicNodes();
//    }
//
//
//    public List<Path> getAllReferencePaths(int depth) {
//        List<Path> allPaths = new ArrayList<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                allPaths.addAll(paramTotypeGraphMap.get(p).getAllReferencePaths(depth));
//            }
//        }
//        return allPaths;
//    }
//
//    public List<Path> getAllReferencePaths(CtVariable<?> initialVariable, int depth) {
//        List<Path> allPaths = new ArrayList<>();
//        TypeGraph typeGraph = typeToTypeGraphMap.get(initialVariable.getType());
//        allPaths.addAll(typeGraph.getAllReferencePaths(initialVariable, depth));
//        return allPaths;
//    }
//
//    public List<Path> getAllPaths(int depth) {
//        List<Path> allPaths = new ArrayList<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                allPaths.addAll(paramTotypeGraphMap.get(p).getAllPaths(depth));
//            }
//        }
//        return allPaths;
//    }
//
//    public List<Path> getAllPathsOfType(CtTypeReference<?> type, int depth) {
//        return getAllPaths(depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
//    }
//
//    public List<Path> getAllPathsOfType(CtVariable<?> initialVariable, CtTypeReference<?> type, int depth) {
//        TypeGraph typeGraph = typeToTypeGraphMap.get(initialVariable.getType());
//        return new ArrayList<>(
//                typeGraph.getAllPaths(initialVariable, depth).stream().filter(p -> p.getTypeReference().equals(type)).toList()
//        );
//    }
//
//    public List<Path> getAllReferencePathsOfType(CtTypeReference<?> type, int depth) {
//        return getAllReferencePaths(depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
//    }
//
//
//    public List<Path> getAllReferencePathsOfType(CtVariable<?> initialVariable, CtTypeReference<?> type, int depth) {
//        return getAllReferencePaths(initialVariable, depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
//    }
//
//    public List<Path> getAllSimpleReferencePathsOfType(CtVariable<?> initialVariable, CtTypeReference<?> type, int depth) {
//        return getAllReferencePaths(initialVariable, depth).stream().filter(p -> p.getTypeReference().equals(type) && p.isSimple()).toList();
//    }
//
////    public List<Path> getAllReferenceSimplePathsOfType(CtVariable<?> initialVariable, CtTypeReference<?> type, int depth) {
////        return getAllReferencePaths(initialVariable, depth).stream().filter(p -> p.getTypeReference().equals(type)).toList();
////    }
//
//    public List<Path> getIntegerFieldsOfParameters() {
//        List<Path> integerFields = new ArrayList<>();
//        for (CtVariable<?> p : inputs) {
//            if (TypeUtils.isUserDefined(p.getType())) {
//                integerFields.addAll(paramTotypeGraphMap.get(p).getIntegerFieldsOfRoot());
//            } else if (TypeUtils.isInteger(p.getType())) {
//                integerFields.add(new Path(p, new ArrayList<>()));
//            }
//        }
//        return integerFields;
//    }
//
//    public Set<Path> getPathsToArrayNodes() {
//        return new HashSet<>(pathsToArrayNodes);
//    }
//
//    public Set<CtTypeReference<?>> getArrayNodes() {
//        return new HashSet<>(arrayNodes);
//    }
}
