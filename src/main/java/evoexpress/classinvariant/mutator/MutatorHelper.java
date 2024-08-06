package evoexpress.classinvariant.mutator;

import evoexpress.classinvariant.mutator.template.ArrayTraversalTemplate;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;

public class MutatorHelper {

    public static List<CtVariable<?>> selectRandomVariablesFromList(List<CtVariable<?>> list) {
        List<CtVariable<?>> candidates = new ArrayList<>(list);
        int varsToRemove = RandomUtils.nextInt(candidates.size());
        for (int i = 0; i < varsToRemove; i++)
            candidates.remove(RandomUtils.nextInt(candidates.size()));
        return candidates;
    }

    public static boolean isTraversalBlock(CtCodeElement elem) {
        return elem instanceof CtBlock<?> block && block.getParent() instanceof CtMethod<?> m && m.getSimpleName().startsWith(LocalVarHelper.TRAVERSAL_PREFIX);
    }

    public static CtMethod<?> getMethodByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).findFirst().orElse(null);
    }

    public static List<CtMethod<?>> getMethodsByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).toList();
    }

    public static boolean isInitialCheckBlock(CtCodeElement elem) {
        return elem instanceof CtBlock<?> block && block.getParent() instanceof CtMethod<?> m && m.getSimpleName().startsWith("initialCheck");
    }

    public static CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, CtStatement statement, CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = pickVisitedSetVariable(methodBody, setSubtype);
        if (setVar != null)
            return setVar;

        return declareVisitedSetVariable(methodBody, statement, setSubtype);
    }

    private static CtVariable<?> pickVisitedSetVariable(CtBlock<?> methodBody, CtTypeReference<?> setSubtype) {
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, setSubtype);
        if (setVars.isEmpty())
            return null;
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

    public static CtVariable<?> declareVisitedSetVariable(CtBlock<?> methodBody, CtStatement statement, CtTypeReference<?> setSubtype) {
        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(setSubtype, methodBody);
        statement.insertBefore((CtStatement) setVar);
        return setVar;
    }

    public static boolean isMutableMethod(CtMethod<?> method) {
        String methodName = method.getSimpleName();
        return methodName.startsWith(LocalVarHelper.STRUCTURE_METHOD_NAME) ||
                methodName.startsWith(LocalVarHelper.PRIMITIVE_METHOD_NAME) ||
                methodName.startsWith(LocalVarHelper.INITIAL_METHOD_NAME) ||
                methodName.startsWith(LocalVarHelper.TRAVERSAL_PREFIX);
    }

    public static List<CtIf> getMutablesIfReturnFalse(CtClass<?> clazz) {
        return clazz.getElements(e -> isIfReturnFalse(e) && isMutableMethod(e.getParent(CtMethod.class)));
    }

    public static List<CtIf> getIfsCallingMethod(CtClass<?> clazz, String methodName) {
        return clazz.getElements(e -> isIfReturnFalse(e) && callsMethod(e, methodName));
    }

    private static boolean callsMethod(CtIf e, String methodName) {
        return e.toString().contains(methodName);
    }

    public static List<CtIf> getMutablesIfReturnFalse(CtMethod<?> method) {
        return method.getBody().getElements(e -> isMutableIf(e) && isIfReturnFalse(e));
    }

    public static boolean isMutableIf(CtIf ifStatement) {
        return ifStatement.getParent(CtIf.class) == null;
    }

    public static List<CtIf> getIfsReturnFalses(CtBlock<?> block) {
        List<CtIf> ifsReturnFalses = new LinkedList<>();
        List<CtIf> ifs = block.getElements(Objects::nonNull);
        for (CtIf ifStatement : ifs) {
            if (ifStatement.getThenStatement() instanceof CtBlock<?> ifBlock) {
                if (isReturnFalseBlock(ifBlock))
                    ifsReturnFalses.add(ifStatement);
            }
        }
        return ifsReturnFalses;
    }

    public static boolean isIfReturnFalse(CtIf ifStatement) {
        if (ifStatement == null || ifStatement.getThenStatement() == null)
            return false;
        if (ifStatement.getThenStatement() instanceof CtBlock<?> ifBlock) {
            return isReturnFalseBlock(ifBlock);
        }
        return isReturnFalseStatement(ifStatement.getThenStatement());
    }

    public static boolean isReturnFalseBlock(CtBlock<?> block) {
        List<CtStatement> statements = block.getStatements();
        if (statements.size() != 1)
            return false;
        CtStatement statement = statements.get(0);
        return isReturnFalseStatement(statement);
    }

    public static boolean isReturnFalseStatement(CtStatement statement) {
        return statement instanceof CtReturn<?> returnStatement && returnStatement.getReturnedExpression().toString().equals("false");
    }

    public static List<CtIf> getIfsWithVariableInCondition(CtBlock<?> block, CtVariable<?> var) {
        List<CtIf> ifs = block.getElements(Objects::nonNull);
        List<CtIf> ifsWithVar = new LinkedList<>();
        for (CtIf ifStatement : ifs) {
            if (ifStatement.getCondition().toString().contains(var.getSimpleName()))
                ifsWithVar.add(ifStatement);
        }
        return ifsWithVar;
    }

    public static CtTypeReference<?> getTraversedType(CtMethod<?> traversal) {
        return traversal.getParameters().get(2).getType().getActualTypeArguments().get(0);
    }

    public static CtTypeReference<?> getTraversedArrayType(CtMethod<?> arrayTraversal) {
        return arrayTraversal.getParameters().get(1).getType();
    }

    public static Set<CtTypeReference<?>> getTraversedTypes(CtClass<?> cls) {
        Set<CtTypeReference<?>> traversedTypes = new HashSet<>();
        for (CtMethod<?> method : cls.getMethods()) {
            if (method.getSimpleName().startsWith(LocalVarHelper.TRAVERSAL_PREFIX)) {
                traversedTypes.add(getTraversedType(method));
            }
        }
        return traversedTypes;
    }

    public static Set<CtTypeReference<?>> getTraversedArrayTypes(CtClass<?> cls) {
        Set<CtTypeReference<?>> traversedTypes = new HashSet<>();
        for (CtMethod<?> method : cls.getMethods()) {
            if (method.getSimpleName().startsWith(LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)) {
                traversedTypes.add(getTraversedArrayType(method));
            }
        }
        return traversedTypes;
    }

    public static List<CtMethod<?>> getAllTraversalsOfReferenceObjects(CtClass<?> cls) {
        List<CtMethod<?>> traversals = new LinkedList<>(MutatorHelper.getMethodsByName(cls, LocalVarHelper.TRAVERSAL_PREFIX));
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(cls, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX).stream().filter(
                ArrayTraversalTemplate::isReferenceArrayTraversal
        ).toList();

        traversals.addAll(arrayTraversals);
        return traversals;
    }


}
