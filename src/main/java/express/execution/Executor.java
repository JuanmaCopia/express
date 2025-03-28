package express.execution;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import express.compile.InMemoryCompiler;
import express.object.ObjectGenerator;
import express.reflection.Reflection;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

public class Executor {

    public static int runPredicate(Method predicate, Object[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Boolean> task = () -> {
            return (boolean) predicate.invoke(null, args);
        };

        boolean result = false;
        try {
            // Submit the task to the executor and get a Future object
            Future<Boolean> future = executor.submit(task);
            // Set a timeout for the task
            result = future.get(300, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            // Handle timeout exception
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            return -1;
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
        if (result)
            return 1;
        return 0;
    }

    public static boolean runPredicateBoolean(Method predicate, Object[] args) {
        switch (runPredicate(predicate, args)) {
            case 0:
                return true;
            case 1:
                return false;
        }
        throw new RuntimeException("Error while running predicate");
    }

    public static void runTestSuite(String testSuiteFullyQualifiedName, ClassLoader classLoader) {
        try {
            Class<?> testClass = classLoader.loadClass(testSuiteFullyQualifiedName);
            List<Method> testMethods = Reflection.getRunnableTests(testClass);
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            for (Method testMethod : testMethods) {
                // Run the test method and let the instrumentation collect the created objects
                try {
                    Object result = testMethod.invoke(testObject);
                } catch (Exception e) {
                    System.err.println("error running test " + testMethod.getName() + ": " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<Object> obtainSurvivors(CtClass<?> spoonClass, Collection<Object> negativeObjects) {
        List<Object> survivors = new LinkedList<>();

        SpoonManager.addClassToMainPackage(spoonClass);
        String classQualifiedName = spoonClass.getQualifiedName();
        String classSourceCode = SpoonManager.getPrettyPrintedSourceCode(spoonClass);
        SpoonManager.removeClassFromMainPackage(spoonClass);

        InMemoryCompiler compiler = SpoonManager.getInMemoryCompiler();
        compiler.compileSingleClass(classQualifiedName, classSourceCode);

        Class<?> predicateClass;
        try {
            predicateClass = compiler.loadClass(spoonClass.getQualifiedName());
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading class: " + spoonClass.getQualifiedName());
            throw new RuntimeException(e);
        }

        Method predicate = Reflection.loadMethod(predicateClass, SpoonManager.getConfig().predicateMethodName);

        for (Object invalidInstance : negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;

            int result = Executor.runPredicate(predicate, args);
            if (result == 1) {
                survivors.add(invalidInstance);
            } else if (result == -1) {
                throw new RuntimeException("Error running predicate during survivor check");
            }
        }

        return survivors;
    }

    public static void printSurvivors(CtClass<?> cls) {
        SpoonManager.addClassToMainPackage(cls);
        String classQualifiedName = cls.getQualifiedName();
        String classSourceCode = SpoonManager.getPrettyPrintedSourceCode(cls);
        SpoonManager.removeClassFromMainPackage(cls);

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

        for (Object invalidInstance : ObjectGenerator.allNegativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;

            int result = Executor.runPredicate(predicate, args);
            if (result == 1) {
                System.out.println("\n\nCould not kill:\n" + invalidInstance.toString());
            } else if (result == -1) {
                System.err.println("\nError with" + invalidInstance.toString());
                System.err.println("\n\n Class:\n" + classSourceCode);
                return;
            }
        }

    }

}
