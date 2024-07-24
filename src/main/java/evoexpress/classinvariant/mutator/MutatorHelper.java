package evoexpress.classinvariant.mutator;

import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    public static List<CtIf> getMutablesIfReturnFalse(CtMethod<?> method) {
        return method.getBody().getElements(e -> isIfReturnFalse(e));
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

}
