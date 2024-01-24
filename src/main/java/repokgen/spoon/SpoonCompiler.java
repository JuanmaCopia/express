package repokgen.spoon;

import spoon.SpoonAPI;
import spoon.SpoonModelBuilder;

public class SpoonCompiler {

    private static SpoonModelBuilder compiler;

    public static void initialize(SpoonAPI launcher) {
        compiler = launcher.createCompiler();
        compiler.compile();
    }

    public static boolean compile() {
        return compiler.compile();
    }

}
