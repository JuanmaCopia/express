package evoexpress.compile;

import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.SpoonManager;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtCompilationUnit;
import spoon.reflect.factory.CompilationUnitFactory;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;

import java.util.HashMap;
import java.util.Map;

public class Compiler {

    Launcher launcher;
    CtPackage subjectPackage;

    Compiler(Launcher launcher, CtPackage subjectPackage) {
        this.launcher = launcher;
        this.subjectPackage = subjectPackage;
    }

    public void compileModel() {
        launcher.getModelBuilder().compile();
    }

    public void compileModel(CtClass<?> cls) {
        addClassToPackage(cls);
        try {
            launcher.getModelBuilder().compile();
        } catch (Exception e) {
            System.err.println("\n---------- Compilation failed ----------\n");
            System.err.println(cls.toString());
            e.printStackTrace();
            throw new RuntimeException("Compilation failed");
        } finally {
            removeClassFromPackage(cls);
        }
    }

    public void addClassToPackage(CtType<?> ctType) {
        if (subjectPackage.getType(ctType.getSimpleName()) == null) {
            subjectPackage.addType(ctType);
        }

    }

    public void removeClassFromPackage(CtType<?> ctType) {
        subjectPackage.removeType(ctType);
    }

//     public Map<String, String> getMapOfSourceCode() {
//         CompilationUnitFactory factory = launcher.getFactory().CompilationUnit();
//         //CompilationUnitFactory factory = launcher.getFactory().CompilationUnit().getOrCreate(CtType);
//         Map<String, CompilationUnit> sourceCodeMap = factory.getMap();

//         Map<String, String> result = new HashMap<>();
//         for (Map.Entry<String, CompilationUnit> entry : sourceCodeMap.entrySet()) {
//             result.put(entry.getKey(), launcher.createPrettyPrinter().printCompilationUnit(entry.getValue()));
//             System.out.println("\nClass: " + entry.getKey());
//             System.out.println("\nSource:\n\n" + entry.getValue());
//         }
//         return result;

// //        String asString = launcher.createPrettyPrinter().printCompilationUnit(unit);
// //        System.out.println(asString);
// //
// //        ClassLoader loader = JavacFacade.compileFiles(Map.of("Foo.java", asString), List.of());
// //        System.out.println(loader.loadClass("Foo"));
//     }

}
