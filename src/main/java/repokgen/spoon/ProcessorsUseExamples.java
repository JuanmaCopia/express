package repokgen.spoon;

import java.util.List;
import java.util.Random;
import java.util.Set;

import repokgen.ga.mutators.processors.AddMethodCallProcessor;
import repokgen.ga.mutators.processors.AlreadyVisitedCheckProcessor;
import repokgen.ga.mutators.processors.DeclareVisitedSetProcessor;
import repokgen.ga.mutators.processors.ExampleClassProcessor;
import repokgen.ga.mutators.processors.NullCheckAllFieldsProcessor;
import repokgen.ga.mutators.processors.ReferenceTraversalProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class ProcessorsUseExamples {

    public static void classProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> cls = SpoonQueries.getClass("code.ExampleClass");

        Processor<CtClass<?>> p = new ExampleClassProcessor();

        System.err.println("\n\n ==== BEFORE ==== \n\n" + cls.toString());
        p.process(cls);
        System.err.println("\n\n ==== AFTER ==== \n\n" + cls.toString());

    }

    public static void nullCheckProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> cls = SpoonManager.getTargetClass();
        CtMethod<?> method = SpoonQueries.findMethodByName(cls, "mymethod2");

        Processor<CtMethod<?>> p = new NullCheckAllFieldsProcessor();

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method);
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

    }

    public static void referenceTraversalExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtMethod<?> method = SpoonQueries.findMethodByName(sllClass, "mymethod2");

        CtClass<?> nodeClass = SpoonQueries.getClass("examples.SLL$Node");

        CtField<?> headField = SpoonQueries.findFieldByName(sllClass, "head");
        CtField<?> nextField = SpoonQueries.findFieldByName(nodeClass, "next");

        // System.err.println(headField.toString());
        // System.err.println(nextField.toString());

        Processor<CtBlock<?>> p = new ReferenceTraversalProcessor(headField, nextField);

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method.getBody());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

    }

    public static void declareVisitedProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtClass<?> nodeClass = SpoonQueries.getClass("examples.SLL$Node");

        CtMethod<?> method = SpoonQueries.findMethodByName(sllClass, "mymethod2");

        CtTypeReference<?> nodeType = nodeClass.getReference();

        DeclareVisitedSetProcessor p = new DeclareVisitedSetProcessor(nodeType);

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p.process(method.getBody());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());

        System.err.println("\n--------------------------------------------------------------------\n");

        CtVariable<?> headField = SpoonQueries.findFieldByName(sllClass, "head");

        CtVariableRead<?> exp = SpoonFactory.createVariableRead(headField);

        AddMethodCallProcessor p2 = new AddMethodCallProcessor(p.getDeclaredVariable(), "add", exp,
                headField.getReference().getType());

        System.err.println("\n\n ==== BEFORE ==== \n\n" + method.toString());
        p2.process(method.getBody().getLastStatement());
        System.err.println("\n\n ==== AFTER ==== \n\n" + method.toString());
    }

    public static void alreadyVisitedCheckProcessorExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");

        CtMethod<?> method = SpoonQueries.findMethodByName(sllClass, "mymethod3");

        // System.err.println(SpoonQueries.getAllRecheableVariables(method.getBody()).toString();

        List<CtVariable<?>> localAndParamVars = SpoonQueries
                .getAllRecheableLocalVariablesOfType(method.getBody().getLastStatement(), Set.class);
        assert (!localAndParamVars.isEmpty());

        CtVariable<?> setVariable = localAndParamVars.get(0);

        CtTypeReference<?> typeOfElementsInSet = setVariable.getReference().getType().getActualTypeArguments().get(0);

        List<CtVariable<?>> localVarsOfSetType = SpoonQueries.getAllRecheableLocalVariablesOfType(
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

    public static void obtainLocalVariablesExample() {
        SpoonManager.initialize("./src/main/resources", "./target/class-sll", "examples.SLL");
        CtClass<?> sllClass = SpoonQueries.getClass("examples.SLL");
        CtMethod<?> method = SpoonQueries.findMethodByName(sllClass, "mymethod4");

        System.err.println(method.toString());

        CtStatement last = method.getBody().getLastStatement();

        List<CtVariable<?>> query = SpoonQueries.getAllRecheableLocalVariables(last);

        System.err.println("\n\nPotentialVariableDeclarationFunction:\n");
        for (CtElement e : query) {
            System.err.println(e.toString());
        }

    }

}
