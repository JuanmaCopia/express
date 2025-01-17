package express.classinvariant.mutator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import express.classinvariant.mutator.template.TemplateHelper;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableAccess;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtLocalVariableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.reflect.visitor.filter.VariableAccessFilter;

public class MutatorHelper {

    public static void selectMutationOption(CtIf ifStatement, CtBlock<?> targetMethodBody, CtStatement insertBeforeStatement, String label) {
        List<CtIf> mutableIfs = MutatorHelper.getMutableIfs(targetMethodBody, label);

        int option = 1;
        if (!mutableIfs.isEmpty()) {
            option = 2;
        }
        switch (RandomUtils.nextInt(option)) {
            case 0:
                insertBeforeStatement.insertBefore(ifStatement);
                break;
            case 1:
                RandomUtils.getRandomElement(mutableIfs).replace(ifStatement);
                break;
        }
    }

    public static void insertOrReplaceCheck(List<CtIf> existentChecks, CtIf newCheck, CtStatement insertBeforeStatement) {
        int option = 1;
        if (existentChecks != null && !existentChecks.isEmpty()) {
            option = 2;
        }
        switch (RandomUtils.nextInt(option)) {
            case 0:
                insertBeforeStatement.insertBefore(newCheck);
                break;
            case 1:
                CtIf toReplace = RandomUtils.getRandomElement(existentChecks);
                //System.out.println("\nReplacing:\n" + toReplace);
                //System.out.println("\nWith:\n" + newCheck);
                toReplace.replace(newCheck);

                break;
        }
    }

    public static List<CtVariable<?>> selectRandomVariablesFromList(List<CtVariable<?>> list) {
        List<CtVariable<?>> candidates = new ArrayList<>(list);
        int varsToRemove = RandomUtils.nextInt(candidates.size());
        for (int i = 0; i < varsToRemove; i++)
            candidates.remove(RandomUtils.nextInt(candidates.size()));
        return candidates;
    }

    public static CtMethod<?> getMethodByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).findFirst()
                .orElse(null);
    }

    public static List<CtMethod<?>> getMethodsByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).toList();
    }

    public static CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, CtStatement statement,
                                                         CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = pickVisitedSetVariable(methodBody, setSubtype);
        if (setVar != null)
            return setVar;

        return declareVisitedSetVariable(statement, setSubtype);
    }

    private static CtVariable<?> pickVisitedSetVariable(CtBlock<?> methodBody, CtTypeReference<?> setSubtype) {
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, setSubtype);
        if (setVars.isEmpty())
            return null;
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

    public static CtVariable<?> declareVisitedSetVariable(CtStatement statement, CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = SpoonFactory.createVisitedIdentitySetDeclaration(setSubtype);
        statement.insertBefore((CtStatement) setVar);
        return setVar;
    }

    public static List<CtMethod<?>> getMutableMethods(CtClass<?> clazz) {
        return clazz.getMethods().stream().filter(MutatorHelper::isMutableMethod).collect(Collectors.toList());
    }

    public static boolean isMutableMethod(CtMethod<?> method) {
        return method.getSimpleName().contains(LocalVarHelper.MUTABLE_METHOD_SUFFIX);
    }

/*    public static List<CtIf> getMutableIfs(CtMethod<?> method, String labelComment) {
        return method.getBody().getElements(ifStatement -> isMutableIf(ifStatement, labelComment));
    }*/

    public static List<CtIf> getMutableIfs(CtClass<?> ctClass, String labelComment) {
        List<CtIf> mutableIfs = new LinkedList<>();
        getMutableMethods(ctClass).forEach(
                method -> mutableIfs.addAll(getMutableIfs(method.getBody(), labelComment))
        );
        return mutableIfs;
    }

    public static List<CtIf> getMutableIfs(CtBlock<?> methodBody, String labelComment) {
        return methodBody.getElements(ifStatement -> isMutableIf(ifStatement, labelComment));
    }

    public static boolean isMutableIf(CtIf ifStatement, String labelComment) {
        CtBlock<?> thenBlock = ifStatement.getThenStatement();
        if (thenBlock == null)
            return false;
        return isLabel(thenBlock.getStatement(0), labelComment);
    }

    public static boolean isLabel(CtElement element, String label) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals(label);
    }

    public static List<CtIf> getIfsCallingMethod(CtClass<?> clazz, String label, String methodName) {
        return getMutableMethods(clazz).stream().map(m -> getMutableIfs(m.getBody(), label)).flatMap(List::stream).filter(
                ifStatement -> callsMethod(ifStatement, methodName)
        ).toList();
    }

    public static List<CtIf> getIfsCallingMethod(CtBlock<?> body, String label, String methodName) {
        return body.getElements(ifStatement -> isMutableIf(ifStatement, label) && callsMethod(ifStatement, methodName));
    }

    public static boolean callsMethod(CtIf e, String methodName) {
        return e.toString().contains(methodName);
    }

    public static boolean callsMethod(CtIf e, CtMethod<?> method) {
        return e.toString().contains(method.getSimpleName());
    }

    public static Set<CtTypeReference<?>> getTraversedArrayTypes(CtClass<?> cls) {
        Set<CtTypeReference<?>> traversedTypes = new LinkedHashSet<>();
        for (CtMethod<?> method : cls.getMethods()) {
            if (method.getSimpleName().startsWith(LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)) {
                traversedTypes.add(TemplateHelper.getTraversedElementParameter(method).getType());
            }
        }
        return traversedTypes;
    }

    public static List<CtMethod<?>> getAllTraversalsOfReferenceObjects(CtClass<?> cls) {
        List<CtMethod<?>> traversals = new LinkedList<>(
                MutatorHelper.getMethodsByName(cls, LocalVarHelper.TRAVERSAL_PREFIX));
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(cls, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)
                .stream().filter(
                        TemplateHelper::isReferenceArrayTraversal)
                .toList();

        traversals.addAll(arrayTraversals);
        return traversals;
    }

    public static List<CtMethod<?>> getAllTraversals(CtClass<?> cls) {
        List<CtMethod<?>> traversals = new LinkedList<>(
                MutatorHelper.getMethodsByName(cls, LocalVarHelper.TRAVERSAL_PREFIX));
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(cls, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        traversals.addAll(arrayTraversals);
        return traversals;
    }

    public static void addImmutableComment(CtIf check) {
        CtComment comment = SpoonFactory.createComment(LocalVarHelper.IMMUTABLE_COMMENT);
        if (!(check.getThenStatement() instanceof CtBlock<?> block))
            throw new IllegalArgumentException("Expected block statement");
        block.insertBegin(comment);
    }

    public static CtIf getFirstIf(CtBlock<?> block) {
        for (CtStatement statement : block.getStatements()) {
            if (statement instanceof CtIf ifStatement) {
                return ifStatement;
            }
        }
        return null;
    }


    public static boolean isUnusedLocalVar(CtBlock<?> block, CtLocalVariable<?> var) {
        CtLocalVariableReference<?> varReference = var.getReference();
        List<CtVariableAccess<?>> accesses = block.getElements(new VariableAccessFilter<>(varReference));
        return accesses.isEmpty();
    }

    public static List<CtMethod<?>> findTraversalsWithSameParameters(CtClass<?> ctClass, CtMethod<?> traversal) {
        List<CtTypeReference<?>> traversalParamTypes = traversal.getParameters().stream()
                .map(CtParameter::getType)
                .collect(Collectors.toList());

        Set<CtMethod<?>> traversals = new LinkedHashSet<>(MutatorHelper.getMethodsByName(ctClass, LocalVarHelper.TRAVERSAL_PREFIX));
        traversals.remove(traversal);
        for (CtMethod<?> t : new LinkedHashSet<>(traversals)) {
            List<CtTypeReference<?>> methodParamTypes = t.getParameters().stream()
                    .map(CtParameter::getType)
                    .collect(Collectors.toList());

            if (!traversalParamTypes.equals(methodParamTypes)) {
                traversals.remove(t);
            }
        }
        return new LinkedList<>(traversals);
    }

    public static List<CtMethod<?>> findTraversalsWithDifferentParameters(CtClass<?> ctClass, CtMethod<?> traversal) {
        List<CtTypeReference<?>> traversalParamTypes = traversal.getParameters().stream()
                .map(CtParameter::getType)
                .collect(Collectors.toList());

        Set<CtMethod<?>> traversals = new LinkedHashSet<>(MutatorHelper.getMethodsByName(ctClass, LocalVarHelper.TRAVERSAL_PREFIX));
        traversals.remove(traversal);
        for (CtMethod<?> t : new LinkedHashSet<>(traversals)) {
            List<CtTypeReference<?>> methodParamTypes = t.getParameters().stream()
                    .map(CtParameter::getType)
                    .collect(Collectors.toList());

            if (traversalParamTypes.equals(methodParamTypes)) {
                traversals.remove(t);
            }
        }
        return new LinkedList<>(traversals);
    }


    public static CtInvocation<?> extractInvocation(CtIf check) {
        List<CtInvocation<?>> invocations = check.getCondition().getElements(new TypeFilter<>(CtInvocation.class));
        if (invocations.isEmpty()) {
            return null;
        }
        return invocations.get(0);
    }

    public static void unifyTraversals(CtClass<?> ctClass, CtMethod<Boolean> traversal, List<CtMethod<?>> traversalsSameParams) {
        for (CtMethod<?> t : traversalsSameParams) {
            List<CtIf> checks = MutatorHelper.getIfsCallingMethod(ctClass, LocalVarHelper.STAGE_2_LABEL, t.getSimpleName());
            for (CtIf check : checks) {
                CtInvocation<Boolean> invocation = (CtInvocation<Boolean>) MutatorHelper.extractInvocation(check);
                invocation.setExecutable(traversal.getReference());
            }
            ctClass.removeMethod(t);
        }
    }

    public static boolean isUnusedTraversal(CtClass<?> ctClass, CtMethod<?> traversal) {
        List<CtIf> invocations = MutatorHelper.getIfsCallingMethod(ctClass, LocalVarHelper.STAGE_2_LABEL, traversal.getSimpleName());
        return invocations.isEmpty();
    }

    public static CtField<?> getFieldByName(CtClass<?> clazz, String fieldName) {
        return clazz.getFields().stream().filter(f -> f.getSimpleName().equals(fieldName)).findFirst().orElse(null);
    }

}
