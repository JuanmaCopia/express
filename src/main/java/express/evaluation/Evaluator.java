package express.evaluation;

import java.lang.reflect.Method;

import eval.config.EvalConfig;
import express.compile.InMemoryCompiler;
import express.execution.Executor;
import express.reflection.Reflection;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;
import eval.StructureGenerator;

public class Evaluator {

    StructureGenerator generator;

    public Evaluator(EvalConfig generatorConfig) {
        this.generator = new StructureGenerator(generatorConfig);
    }

    public Results evaluate(CtClass<?> individualClass, Class<?> targetClass) {
        SpoonManager.addClassToMainPackage(individualClass);
        String classQualifiedName = individualClass.getQualifiedName();
        String classSourceCode = SpoonManager.getPrettyPrintedSourceCode(individualClass);
        SpoonManager.removeClassFromMainPackage(individualClass);

        InMemoryCompiler compiler = SpoonManager.getInMemoryCompiler();
        compiler.compileSingleClass(classQualifiedName, classSourceCode);

        Class<?> predicateClass;
        try {
            predicateClass = compiler.loadClass(classQualifiedName);
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading class: " + classQualifiedName);
            throw new RuntimeException(e);
        }

        Method predicate = Reflection.loadMethod(predicateClass, SpoonManager.getConfig().predicateMethodName);

        Method groundTruth = Reflection.loadMethod(targetClass, "groundTruth");

        Results results = new Results();
        while (generator.hasNext()) {
            Object[] args = new Object[1];
            args[0] = generator.next();


            if (Executor.runPredicateBoolean(groundTruth, args)) {
                // Ground Truth returned true
                if (Executor.runPredicateBoolean(predicate, args)) {
                    results.incrementTruePositives();
                } else {
                    results.incrementFalseNegatives();
                }

            } else {
                // Ground Truth returned false
                if (Executor.runPredicateBoolean(predicate, args)) {
                    results.incrementTruePositives();
                } else {
                    results.incrementFalseNegatives();
                }
            }
        }
        return results;
    }

}
