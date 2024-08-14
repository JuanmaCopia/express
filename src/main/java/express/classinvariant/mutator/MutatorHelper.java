package express.classinvariant.mutator;

import express.classinvariant.mutator.template.ArrayTraversalTemplate;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
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

    public static CtMethod<?> getMethodByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).findFirst().orElse(null);
    }

    public static List<CtMethod<?>> getMethodsByName(CtClass<?> clazz, String methodNamePrefix) {
        return clazz.getMethods().stream().filter(m -> m.getSimpleName().startsWith(methodNamePrefix)).toList();
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
        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(setSubtype);
        statement.insertBefore((CtStatement) setVar);
        return setVar;
    }


    public static List<CtMethod<?>> getMutableMethods(CtClass<?> clazz) {
        return clazz.getMethods().stream().filter(MutatorHelper::isMutableMethod).toList();
    }

    public static boolean isMutableMethod(CtMethod<?> method) {
        return method.getSimpleName().contains(LocalVarHelper.MUTABLE_METHOD_SUFFIX);
    }

    public static List<CtIf> getMutableIfs(CtMethod<?> method) {
        return method.getBody().getElements(MutatorHelper::isMutableIf);
    }


    public static List<CtIf> getMutableIfs(CtClass<?> ctClass) {
        return getMutableIfs(getMutableMethods(ctClass));
    }

    public static List<CtIf> getMutableIfs(Collection<CtMethod<?>> methods) {
        List<CtIf> ifs = new LinkedList<>();
        for (CtMethod<?> method : methods) {
            ifs.addAll(method.getBody().getElements(MutatorHelper::isMutableIf));
        }
        return ifs;
    }

    public static boolean isMutableIf(CtIf ifStatement) {
        if (ifStatement.getParent(CtIf.class) != null)
            return false;
        if (ifStatement.getThenStatement() instanceof CtBlock<?> block &&
                block.getStatement(0) instanceof CtComment comment &&
                comment.getContent().contains(LocalVarHelper.IMMUTABLE_COMMENT))
            return false;
        if (!isIfReturnFalse(ifStatement))
            return false;

        CtMethod<?> method = ifStatement.getParent(CtMethod.class);
        return isMutableMethod(method);
    }

    public static List<CtIf> getIfsCallingMethod(CtClass<?> clazz, String methodName) {
        return getMutableIfs(clazz).stream().filter(e -> callsMethod(e, methodName)).toList();
    }

    public static boolean callsMethod(CtIf e, String methodName) {
        return e.toString().contains(methodName);
    }

    public static boolean callsMethod(CtIf e, CtMethod<?> method) {
        return e.toString().contains(method.getSimpleName());
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
        if (statements.isEmpty())
            return false;
        CtStatement lastStatement = statements.get(statements.size() - 1);
        return isReturnFalseStatement(lastStatement);
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

    public static List<CtMethod<?>> getAllTraversals(CtClass<?> cls) {
        List<CtMethod<?>> traversals = new LinkedList<>(MutatorHelper.getMethodsByName(cls, LocalVarHelper.TRAVERSAL_PREFIX));
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(cls, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        traversals.addAll(arrayTraversals);
        return traversals;
    }

    public static CtParameter<?> createThisParameter(CtThisAccess<?> thisAccess) {
        return SpoonFactory.createParameter(thisAccess.getType(), LocalVarHelper.THIS_PARAM_NAME);
    }

    public static void addImmutableComment(CtIf check) {
        CtComment comment = SpoonFactory.createComment(LocalVarHelper.IMMUTABLE_COMMENT);
        if (!(check.getThenStatement() instanceof CtBlock<?> block))
            throw new IllegalArgumentException("Expected block statement");
        block.insertBegin(comment);
    }


}
