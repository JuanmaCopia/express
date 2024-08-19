package express.execution;

import collector.ObjectCollector;
import express.compile.Compiler;
import express.reflection.Reflection;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.List;
import java.util.concurrent.*;

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

    public static void runTestSuite(String testSuiteFullyQualifiedName, ClassLoader classLoader) {
        try {
            Class<?> testClass = classLoader.loadClass(testSuiteFullyQualifiedName);
            List<Method> testMethods = Reflection.getRunnableTests(testClass);
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            int testsExecuted = 0;
            int errors = 0;
            for (Method testMethod : testMethods) {
                // Run the test method and let the instrumentation collect the created objects
                try {
                    Object result = testMethod.invoke(testObject);
                    testsExecuted++;
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

    public static void printSurvivors(CtClass<?> cls) {
        Compiler compiler = SpoonManager.getOutput().getCompiler();
        compiler.compileModel(cls);

        Class<?> predicateClass = Reflection.loadClass(SpoonManager.getOutput().getClassLoader(), cls.getQualifiedName());
        Method predicate = Reflection.loadMethod(predicateClass, SpoonManager.getConfig().predicateMethodName);

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;

            int result = Executor.runPredicate(predicate, args);
            if (result == 1) {
                System.out.println("\n\nCould not kill:\n" + invalidInstance.toString());
            } else if (result == -1) {
                System.err.println("\nError with" + invalidInstance.toString());
                System.err.println("\n\n Class: " + cls.toString());
                return;
            }
        }
    }

}
