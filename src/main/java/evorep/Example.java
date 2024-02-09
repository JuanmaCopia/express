package evorep;

import evorep.ga.mutators.MutatorManager;
import evorep.spoon.SpoonManager;
import evorep.spoon.typesgraph.TypesGraph;
import evorep.spoon.typesgraph.TypesGraphFactory;
import spoon.reflect.declaration.CtClass;

public class Example {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "BinTree";

    private static void initialize() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        MutatorManager.initialize();
    }


    public static void main(String[] args) {
        initialize();
        CtClass<?> targetClass = SpoonManager.getTargetClass();
        TypesGraph graph = TypesGraphFactory.createTypesGraph(targetClass.getReference());
        System.out.println(graph.toString());
    }
}
