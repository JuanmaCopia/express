package evoexpress.typegraph;

import evoexpress.config.ToolConfig;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeGraphTest {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "SLL";
    static SpoonAPI launcher;

    static CtClass<?> targetClass;

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
    }

    private static void initializeSpoon() {
        ToolConfig.subjectClassName = CLASS_NAME;
        ToolConfig.subjectSrcPath = SOURCE_PATH;
        ToolConfig.subjectSrcJavaVersion = 17;
        SpoonManager.initialize();

        launcher = SpoonFactory.getLauncher();
    }

    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        targetClass = SpoonQueries.getClass(CLASS_NAME);
    }

    @Test
    void createTypeGraphTest() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("SLL").getReference();
        TypeGraph graph = new TypeGraph(rootType);

        List<TypeGraph.Edge> adjOfSLL = graph.getOutgoingEdges(graph.getRoot());
        assertEquals(2, adjOfSLL.size());

        TypeGraph.Edge headEdge = adjOfSLL.get(0);
        CtTypeReference<?> nodeType = headEdge.getDestination();
        CtVariable<?> headField = headEdge.getLabel();
        assertEquals("Node", nodeType.getSimpleName());
        assertEquals("head", headField.getSimpleName());

        TypeGraph.Edge sizeEdge = adjOfSLL.get(1);
        CtTypeReference<?> intType = sizeEdge.getDestination();
        CtVariable<?> sizeField = sizeEdge.getLabel();
        assertEquals("int", intType.getSimpleName());
        assertEquals("size", sizeField.getSimpleName());

        List<TypeGraph.Edge> adjOfNode = graph.getOutgoingEdges(nodeType);
        assertEquals(2, adjOfNode.size());

        TypeGraph.Edge dataEdge = adjOfNode.get(0);
        CtTypeReference<?> dataType = dataEdge.getDestination();
        CtVariable<?> dataField = dataEdge.getLabel();
        assertEquals("int", dataType.getSimpleName());
        assertEquals("data", dataField.getSimpleName());

        TypeGraph.Edge nextEdge = adjOfNode.get(1);
        CtTypeReference<?> nextType = nextEdge.getDestination();
        CtVariable<?> nextField = nextEdge.getLabel();
        assertEquals("Node", nextType.getSimpleName());
        assertEquals("next", nextField.getSimpleName());
    }

    @Test
    void createTypeGraphTest2() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("BinTree").getReference();
        TypeGraph graph = new TypeGraph(rootType);

        List<TypeGraph.Edge> adjOfBinTree = graph.getOutgoingEdges(rootType);
        assertEquals(2, adjOfBinTree.size());

        TypeGraph.Edge rootEdge = adjOfBinTree.get(0);
        CtTypeReference<?> btNodeType = rootEdge.getDestination();
        CtVariable<?> rootField = rootEdge.getLabel();
        assertEquals("BTNode", btNodeType.getSimpleName());
        assertEquals("root", rootField.getSimpleName());

        TypeGraph.Edge sizeEdge = adjOfBinTree.get(1);
        CtTypeReference<?> intType = sizeEdge.getDestination();
        CtVariable<?> sizeField = sizeEdge.getLabel();
        assertEquals("int", intType.getSimpleName());
        assertEquals("size", sizeField.getSimpleName());

        List<TypeGraph.Edge> adjOfBTNode = graph.getOutgoingEdges(btNodeType);
        assertEquals(3, adjOfBTNode.size());

        TypeGraph.Edge dataEdge = adjOfBTNode.get(0);
        CtTypeReference<?> dataType = dataEdge.getDestination();
        CtVariable<?> dataField = dataEdge.getLabel();
        assertEquals("int", dataType.getSimpleName());
        assertEquals("data", dataField.getSimpleName());

        TypeGraph.Edge leftEdge = adjOfBTNode.get(1);
        CtTypeReference<?> leftType = leftEdge.getDestination();
        CtVariable<?> leftField = leftEdge.getLabel();
        assertEquals("BTNode", leftType.getSimpleName());
        assertEquals("left", leftField.getSimpleName());

        TypeGraph.Edge rightEdge = adjOfBTNode.get(2);
        CtTypeReference<?> rightType = rightEdge.getDestination();
        CtVariable<?> rightField = rightEdge.getLabel();
        assertEquals("BTNode", rightType.getSimpleName());
        assertEquals("right", rightField.getSimpleName());

    }

    @Test
    void createTypeGraphTest3() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("BinTree").getReference();
        TypeGraph graph = new TypeGraph(rootType);
        Set<CtTypeReference<?>> nodesWithCycles = graph.getNodesWithSelfCycles();

        System.out.println("Nodes with cycles: " + nodesWithCycles.toString());

        CtTypeReference<?> randomNode = nodesWithCycles.stream().findAny().get();

        System.out.println("Chosen node: " + randomNode);

        List<List<CtVariable<?>>> simplePaths = graph.getSimplePaths(rootType, randomNode);

        System.out.println("Simple paths from root to chose node: " + simplePaths.toString());

        List<CtVariable<?>> cyclicFields = graph.getSelfCyclicFieldsOfNode(randomNode);

        System.out.println("Cyclic fields of chosen node: " + cyclicFields.toString());

    }

    @Test
    public void allPathsTest() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("BinTree").getReference();
        TypeGraph graph = new TypeGraph(rootType);
        int maxLength = 2;
        List<List<CtVariable<?>>> allPaths = graph.getAllPaths(rootType, maxLength);
        assertEquals(5, allPaths.size());
    }
}
