package evorep;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.ModifierKind;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SpoonModelCompiler2 {

    public static void main(String[] args) throws IOException {
        Launcher launcher = new Launcher();
        launcher.addInputResource("./src/main/resources/ex");
        launcher.getEnvironment().setComplianceLevel(17);
        launcher.getEnvironment().setShouldCompile(true);
        //launcher.getEnvironment().setAutoImports(true);
        CtModel model = launcher.buildModel();

        CtClass<?> sllClass = launcher.getFactory().Class().get("ex.SLL");
        CtPackage exPackage = sllClass.getPackage();


        CtClass<?> clazz = launcher.getFactory().Core().createClass();
        clazz.setSimpleName("MyClass");

        CtMethod<Boolean> newMethod = launcher.getFactory().Core().createMethod();
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PUBLIC);
        newMethod.setModifiers(modifiers);
        newMethod.setType(launcher.getFactory().Type().BOOLEAN_PRIMITIVE);
        newMethod.setSimpleName("myMethod");
        newMethod.setParameters(new ArrayList<>());

        CtBlock body = launcher.getFactory().Core().createBlock();
        CtReturn ret = launcher.getFactory().Core().createReturn();
        CtExpression returnExpression = launcher.getFactory().Code().createLiteral(true);
        ret.setReturnedExpression(returnExpression);

        body.addStatement(ret);
        newMethod.setBody(body);

        clazz.addMethod(newMethod);

        //launcher.addInputResource(new VirtualFile(clazz.toString()));

        System.err.println("\n\n" + clazz.toString() + "\n\n");

        exPackage.addType(clazz);

        boolean compiles = launcher.getModelBuilder().compile();
        System.out.println("Compilation result: " + compiles);
    }

/*    public static void main(String[] args) throws IOException {
        Launcher launcher1 = new Launcher();
        launcher1.addInputResource("./src/main/resources/ex");
        launcher1.getEnvironment().setComplianceLevel(17);
        launcher1.getEnvironment().setShouldCompile(true);
        //launcher1.getEnvironment().setAutoImports(true);
        CtModel model = launcher1.buildModel();


        CtClass<?> clazz = launcher1.getFactory().Class().get("ex.SLL");


        CtClass<?> parsed = Launcher.parseClass(clazz.toString());


        //System.out.println("\n\n" + clazz.toString() + "\n\n");

        Launcher launcher = new Launcher();
        launcher.addInputResource(new VirtualFile(clazz.toString()));


*//*        VirtualFolder vf = new VirtualFolder();
        launcher.setBinaryOutputDirectory(vf.toFile());*//*
        //launcher.getEnvironment().setNoClasspath(true);
        launcher.getEnvironment().setAutoImports(true);

        CtClass<?> clazz2 = launcher1.getFactory().Class().get("ex.SLL");

        //System.out.println("\n\n" + clazz2.toString() + "\n\n");

        launcher.buildModel();


        PrettyPrinter pp = launcher.createPrettyPrinter();
        System.out.println("\n the src is: \n" + pp.getResult());


        SpoonModelBuilder mb = launcher.getModelBuilder();
        if (launcher.getModelBuilder().compile()) {
            System.out.println(" 1 Compilation successful!");
        } else {
            System.out.println(" 1 Compilation failed!");
        }
    }*/

}