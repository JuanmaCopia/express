package express.compile;

import express.spoon.SpoonManager;
import spoon.Launcher;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.CompilationUnitFactory;
import spoon.reflect.factory.TypeFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Compiler {

    Launcher launcher;
    CtPackage subjectPackage;

    Compiler(Launcher launcher, CtPackage subjectPackage) {
        this.launcher = launcher;
        this.subjectPackage = subjectPackage;
    }

    public void compileModel() {
        if (!launcher.getModelBuilder().compile())
            throw new RuntimeException("Compilation failed");
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

}
