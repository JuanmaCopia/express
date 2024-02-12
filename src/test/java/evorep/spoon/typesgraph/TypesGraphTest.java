package evorep.spoon.typesgraph;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypesGraphTest {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "SLL";
    static SpoonAPI launcher;

    static CtClass<?> targetClass;

    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        targetClass = SpoonQueries.getClass(CLASS_NAME);
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        launcher = SpoonFactory.getLauncher();
    }

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
    }

    @Test
    void createTypeGraphTest() {
        CtTypeReference<?> rootType = targetClass.getReference();
        TypesGraph graph = TypesGraph.createTypesGraph(rootType);

        List<TypesGraph.Edge> adjOfSLL = graph.getAdjacentNodes(rootType);
        assertEquals(2, adjOfSLL.size());

        TypesGraph.Edge headEdge = adjOfSLL.get(0);
        CtTypeReference<?> nodeType = headEdge.getDestination();
        CtField<?> headField = headEdge.getLabel();
        assertEquals("Node", nodeType.getSimpleName());
        assertEquals("head", headField.getSimpleName());

        TypesGraph.Edge sizeEdge = adjOfSLL.get(1);
        CtTypeReference<?> intType = sizeEdge.getDestination();
        CtField<?> sizeField = sizeEdge.getLabel();
        assertEquals("int", intType.getSimpleName());
        assertEquals("size", sizeField.getSimpleName());

        List<TypesGraph.Edge> adjOfNode = graph.getAdjacentNodes(nodeType);
        assertEquals(2, adjOfNode.size());

        TypesGraph.Edge dataEdge = adjOfNode.get(0);
        CtTypeReference<?> dataType = dataEdge.getDestination();
        CtField<?> dataField = dataEdge.getLabel();
        assertEquals("int", dataType.getSimpleName());
        assertEquals("data", dataField.getSimpleName());

        TypesGraph.Edge nextEdge = adjOfNode.get(1);
        CtTypeReference<?> nextType = nextEdge.getDestination();
        CtField<?> nextField = nextEdge.getLabel();
        assertEquals("Node", nextType.getSimpleName());
        assertEquals("next", nextField.getSimpleName());
    }

    @Test
    void createTypeGraphTest2() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("BinTree").getReference();
        TypesGraph graph = TypesGraph.createTypesGraph(rootType);

        List<TypesGraph.Edge> adjOfBinTree = graph.getAdjacentNodes(rootType);
        assertEquals(2, adjOfBinTree.size());

        TypesGraph.Edge rootEdge = adjOfBinTree.get(0);
        CtTypeReference<?> btNodeType = rootEdge.getDestination();
        CtField<?> rootField = rootEdge.getLabel();
        assertEquals("BTNode", btNodeType.getSimpleName());
        assertEquals("root", rootField.getSimpleName());

        TypesGraph.Edge sizeEdge = adjOfBinTree.get(1);
        CtTypeReference<?> intType = sizeEdge.getDestination();
        CtField<?> sizeField = sizeEdge.getLabel();
        assertEquals("int", intType.getSimpleName());
        assertEquals("size", sizeField.getSimpleName());

        List<TypesGraph.Edge> adjOfBTNode = graph.getAdjacentNodes(btNodeType);
        assertEquals(3, adjOfBTNode.size());

        TypesGraph.Edge dataEdge = adjOfBTNode.get(0);
        CtTypeReference<?> dataType = dataEdge.getDestination();
        CtField<?> dataField = dataEdge.getLabel();
        assertEquals("int", dataType.getSimpleName());
        assertEquals("data", dataField.getSimpleName());

        TypesGraph.Edge leftEdge = adjOfBTNode.get(1);
        CtTypeReference<?> leftType = leftEdge.getDestination();
        CtField<?> leftField = leftEdge.getLabel();
        assertEquals("BTNode", leftType.getSimpleName());
        assertEquals("left", leftField.getSimpleName());

        TypesGraph.Edge rightEdge = adjOfBTNode.get(2);
        CtTypeReference<?> rightType = rightEdge.getDestination();
        CtField<?> rightField = rightEdge.getLabel();
        assertEquals("BTNode", rightType.getSimpleName());
        assertEquals("right", rightField.getSimpleName());

    }

    @Test
    void createTypeGraphTest3() {
        CtTypeReference<?> rootType = SpoonQueries.getClass("BinTree").getReference();
        TypesGraph graph = TypesGraph.createTypesGraph(rootType);
        List<CtTypeReference<?>> nodesWithCycles = graph.getNodesWithSelfCycles();

        System.out.println("Nodes with cycles: " + nodesWithCycles.toString());

        CtTypeReference<?> randomNode = nodesWithCycles.get(RandomUtils.nextInt(nodesWithCycles.size()));

        System.out.println("Chosen node: " + randomNode.toString());

        List<List<CtField<?>>> simplePaths = graph.getSimplePaths(rootType, randomNode);

        System.out.println("Simple paths from root to chose node: " + simplePaths.toString());

        List<CtField<?>> cyclicFields = graph.getSelfCyclicFieldsOfNode(randomNode);

        System.out.println("Cyclic fields of chosen node: " + cyclicFields.toString());

    }
}
