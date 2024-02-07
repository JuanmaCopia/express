package evorep.spoon;

import evorep.ga.Individual;
import spoon.SpoonAPI;
import spoon.SpoonModelBuilder;

public class SpoonCompiler {

    private static SpoonModelBuilder compiler;

    public static void initialize(SpoonAPI launcher) {
        // targetClass.compileAndReplaceSnippets();
        compiler = launcher.createCompiler();
        compiler.compile();
    }

    public static boolean compileIndividual(Individual individual) {
        SpoonHelper.putIndividualIntoTheEnvironment(individual);
        boolean compiles = false;
        //System.out.println("Compiling individual: " + individual);
        try {
            compiles = compiler.compile();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return compiles;
    }

}
