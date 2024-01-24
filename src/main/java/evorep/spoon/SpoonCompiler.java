package evorep.spoon;

import spoon.SpoonAPI;
import spoon.SpoonModelBuilder;

public class SpoonCompiler {

    private static SpoonModelBuilder compiler;

    public static void initialize(SpoonAPI launcher) {
        // targetClass.compileAndReplaceSnippets();
        compiler = launcher.createCompiler();
        compiler.compile();
    }

    public static boolean compile() {
        return compiler.compile();
    }

}
