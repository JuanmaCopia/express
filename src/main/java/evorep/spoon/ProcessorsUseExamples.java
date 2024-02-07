package evorep.spoon;

import evorep.ga.mutators.processors.*;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ProcessorsUseExamples {

    public static void classProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> cls = SpoonQueries.getClass("code.ExampleClass");

        Processor<CtClass<?>> p = new ExampleClassProcessor();

        System.err.println("\n\n ==== BEFORE ==== \n\n" + cls.toString());
        p.process(cls);
        System.err.println("\n\n ==== AFTER ==== \n\n" + cls.toString());

    }

    public static void nullCheckProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> cls = SpoonManager.getTargetClass();
        CtMethod<?> method = cls.getMethodsByName("mymethod2").get(0);

        Processor<CtMethod<?>> p = new NullCheckAllFieldsProcessor();

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method);
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

    }

    public static void referenceTraversalExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtMethod<?> method = sllClass.getMethodsByName("mymethod2").get(0);

        CtClass<?> nodeClass = SpoonQueries.getClass("examples.SLL$Node");

        CtField<?> headField = sllClass.getField("head");
        CtField<?> nextField = sllClass.getField("next");

        // System.err.println(headField.toString());
        // System.err.println(nextField.toString());

        Processor<CtBlock<?>> p = new ReferenceTraversalProcessor(headField, nextField);

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method.getBody());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

    }

    public static void declareVisitedProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtClass<?> nodeClass = SpoonQueries.getClass("examples.SLL$Node");

        CtMethod<?> method = sllClass.getMethodsByName("mymethod2").get(0);

        CtTypeReference<?> nodeType = nodeClass.getReference();

        DeclareVisitedSetProcessor p = new DeclareVisitedSetProcessor(nodeType);

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method.getBody());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

        System.err.println("\n--------------------------------------------------------------------\n");

        CtVariable<?> headField = sllClass.getField("head");

        CtVariableRead<?> exp = SpoonFactory.createVariableRead(headField);

        AddMethodCallProcessor p2 = new AddMethodCallProcessor(p.getDeclaredVariable(), "add", exp,
                headField.getReference().getType());

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p2.process(method.getBody().getLastStatement());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());
    }

    public static void alreadyVisitedCheckProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");

        CtMethod<?> method = sllClass.getMethodsByName("mymethod3").get(0);

        // System.err.println(SpoonQueries.getAllRecheableVariables(method.getBody()).toString();

        List<CtVariable<?>> localAndParamVars = SpoonQueries
                .getAllReachableLocalVariablesOfType(method.getBody().getLastStatement(), Set.class);
        assert (!localAndParamVars.isEmpty());

        CtVariable<?> setVariable = localAndParamVars.get(0);

        CtTypeReference<?> typeOfElementsInSet = setVariable.getReference().getType().getActualTypeArguments().get(0);

        List<CtVariable<?>> localVarsOfSetType = SpoonQueries.getAllReachableLocalVariablesOfType(
                method.getBody().getLastStatement(),
                typeOfElementsInSet);

        List<CtVariable<?>> fields = SpoonQueries.getVariablesOfType(SpoonQueries.getFields(sllClass),
                typeOfElementsInSet);

        Random r = new Random();
        int choice = r.nextInt(2);
        CtVariable<?> elem = null;
        boolean isLocal = false;
        if (choice == 0) {
            choice = r.nextInt(fields.size());
            elem = fields.get(choice);
        } else if (choice == 1) {
            isLocal = true;
            choice = r.nextInt(localVarsOfSetType.size());
            elem = localVarsOfSetType.get(choice);
        } else {
            System.err.println("Something went wrong!");
            return;
        }

        CtStatement selectedStatement = method.getBody().getStatements().get(0);
        int setDeclPosition = SpoonQueries.getVariableDeclarationPosition(setVariable, method.getBody());
        if (isLocal) {
            setDeclPosition = Math.max(setDeclPosition, SpoonQueries.getVariableDeclarationPosition(
                    elem, method.getBody()));
        }

        if (setDeclPosition > -1) {
            int pos = r.nextInt(setDeclPosition + 1, method.getBody().getStatements().size());
            selectedStatement = method.getBody().getStatement(pos);
            for (CtStatement s : method.getBody().getStatements()) {
                System.err.println(s.toString());
            }
        }

        Processor<CtStatement> p = new AlreadyVisitedCheckProcessor(setVariable, elem);

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(selectedStatement);
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());
    }

/*    public static void obtainLocalVariablesExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtMethod<?> method = sllClass.getMethodsByName("mymethod4").get(0);

        System.err.println(method.toString());

        CtStatement last = method.getBody().getLastStatement();

        List<CtVariable<?>> query = SpoonQueries.getAllReachableLocalVariables(last);

        System.err.println("\n\nPotentialVariableDeclarationFunction:\n");
        for (CtElement e : query) {
            System.err.println(e.toString());
        }

    }*/

    public static void printStatements() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL", 17);
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtMethod<?> method = sllClass.getMethodsByName("structureRepOK").get(0);

        SpoonQueries.getStatements(method).forEach(
                s -> System.err.println("Statement:\n" + s.toString() + "\n")
        );

        /*method.getBody().getStatements().forEach(
                s -> System.err.println("Statement:\n" + s.toString() + "\n")
        );*/


    }

}
