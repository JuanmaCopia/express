package evorep;

import evorep.config.ToolConfig;
import evorep.ga.mutators.MutatorManager;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.typesgraph.TypesGraph;
import evorep.typesgraph.TypesGraphFactory;
import spoon.reflect.declaration.CtClass;

public class Example {

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.getTargetClass().addMethod(SpoonFactory.createRepOK("repOK"));
        MutatorManager.initialize();
    }


    public static void main(String[] args) {
        initialize();
        CtClass<?> targetClass = SpoonManager.getTargetClass();
        TypesGraph graph = TypesGraphFactory.createTypesGraph(targetClass);
        System.out.println(graph.toString());
    }
}
