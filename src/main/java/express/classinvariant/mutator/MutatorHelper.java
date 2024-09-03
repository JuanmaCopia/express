package express.classinvariant.mutator;

import express.classinvariant.mutator.template.ArrayTraversalTemplate;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class MutatorHelper {

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

    public static Set<CtMethod<?>> getMutableMethods(CtClass<?> clazz) {
        return clazz.getMethods().stream().filter(MutatorHelper::isMutableMethod).collect(Collectors.toSet());
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

    public static boolean callsMethod(CtIf e, String methodName) {
        return e.toString().contains(methodName);
    }

    public static boolean callsMethod(CtIf e, CtMethod<?> method) {
        return e.toString().contains(method.getSimpleName());
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
        List<CtMethod<?>> traversals = new LinkedList<>(
                MutatorHelper.getMethodsByName(cls, LocalVarHelper.TRAVERSAL_PREFIX));
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(cls, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)
                .stream().filter(
                        ArrayTraversalTemplate::isReferenceArrayTraversal)
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

/*    public static boolean isIfReturnFalse(CtIf ifStatement) {
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
        return statement instanceof CtReturn<?> returnStatement
                && returnStatement.getReturnedExpression().toString().equals("false");
    }*/


//    public static Path trimPath(Path path) {
//        CtTypeReference<?> type = path.getTypeReference();
//        int i = 0;
//        for (CtVariable<?> field : path.getFieldChain()) {
//            i++;
//            if (field.getType().isSubtypeOf(type) && i < path.size()) {
//                return path.subPath(i);
//            }
//        }
//        return path;
//    }

}
