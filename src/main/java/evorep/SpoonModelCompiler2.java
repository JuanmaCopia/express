package evorep;

import spoon.Launcher;
import spoon.SpoonModelBuilder;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.support.compiler.VirtualFile;

import java.io.IOException;

public class SpoonModelCompiler2 {
    public static void main(String[] args) throws IOException {
        Launcher launcher1 = new Launcher();
        launcher1.addInputResource("./src/main/resources/ex");
        launcher1.getEnvironment().setComplianceLevel(17);
        launcher1.getEnvironment().setShouldCompile(true);
        //launcher1.getEnvironment().setAutoImports(true);
        CtModel model = launcher1.buildModel();

        CtClass<?> clazz = launcher1.getFactory().Class().get("ex.SLL");

        System.out.println("\n\n" + clazz.toString() + "\n\n");

        Launcher launcher = new Launcher();
        launcher.addInputResource(new VirtualFile(clazz.toString()));
/*        VirtualFolder vf = new VirtualFolder();
        launcher.setBinaryOutputDirectory(vf.toFile());*/
        //launcher.getEnvironment().setNoClasspath(true);
        launcher.getEnvironment().setAutoImports(true);

        CtClass<?> clazz2 = launcher1.getFactory().Class().get("ex.SLL");

        System.out.println("\n\n" + clazz2.toString() + "\n\n");

        launcher.buildModel();
        SpoonModelBuilder mb = launcher.getModelBuilder();
        System.err.println(mb.toString());
        if (launcher.getModelBuilder().compile()) {
            System.out.println(" 1 Compilation successful!");
        } else {
            System.out.println(" 1 Compilation failed!");
        }


    }


}