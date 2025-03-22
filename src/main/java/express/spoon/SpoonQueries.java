package express.spoon;

import express.classinvariant.mutator.LocalVarHelper;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.PotentialVariableDeclarationFunction;

import java.util.*;

public class SpoonQueries {

    public static CtClass<?> getClass(String qualifiedClassName) {
        return SpoonFactory.getFactory().Class().get(qualifiedClassName);
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, CtTypeReference<?> type) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");
        return list.stream().filter(var -> var.getType().isSubtypeOf(type)).toList();
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, Class<?> type) {
        return getVariablesOfType(list, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getAllReachableVariables(CtElement statement) {
        return statement.map(new PotentialVariableDeclarationFunction()).list();
    }

    public static boolean containsReturnStatement(CtBlock<?> block) {
        return !block.getElements(e -> e instanceof CtReturn).isEmpty();
    }

    public static boolean isHandleCurrentComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Handle current:");
    }

    public static boolean isEndOfHandleCurrentComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        // System.out.println("The content of the comment is:" + comment.getContent());
        return comment.getContent().equals("End of Handle current:");
    }

    public static boolean isEndOfInitialChecksComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("End of Initial Checks");
    }

    public static boolean isSizeCheckComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Size check:");
    }

    public static boolean isBeginOfTraversalComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Begin of traversal");
    }

    public static boolean isEndOfTraversalComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("End of traversal");
    }

    public static boolean isReturnTrueLabel(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals(LocalVarHelper.RETURN_TRUE_LABEL);
    }

    public static boolean isSeparatorLabel(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals(LocalVarHelper.SEPARATOR_LABEL);
    }

    public static CtWhile getTraversalLoop(CtBlock<?> block) {
        return (CtWhile) block.getElements(e -> e instanceof CtWhile).stream().findFirst().orElse(null);
    }

    public static CtStatement getEndHandleCurrentComment(CtBlock<?> block) {
        List<CtElement> handleCurrentEndComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isEndOfHandleCurrentComment).toList();
        if (handleCurrentEndComments.isEmpty())
            return null;
        return (CtStatement) handleCurrentEndComments.get(RandomUtils.nextInt(handleCurrentEndComments.size()));
    }

    public static CtStatement getReturnTrueLabel(CtBlock<?> block) {
        List<CtElement> returnTrueComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isReturnTrueLabel).toList();
        if (returnTrueComments.isEmpty())
            return null;
        return (CtStatement) returnTrueComments.get(RandomUtils.nextInt(returnTrueComments.size()));
    }

    public static CtStatement getSeparatorLabelComment(CtBlock<?> block) {
        List<CtElement> returnMark1Comments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isSeparatorLabel).toList();
        if (returnMark1Comments.isEmpty())
            return null;
        return (CtStatement) returnMark1Comments.get(RandomUtils.nextInt(returnMark1Comments.size()));
    }

    public static CtStatement getEndOfTraversalComment(CtBlock<?> block) {
        List<CtElement> traversalEndComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isEndOfTraversalComment).toList();
        if (traversalEndComments.isEmpty())
            return null;
        return (CtStatement) traversalEndComments.get(RandomUtils.nextInt(traversalEndComments.size()));
    }

    public static CtStatement getBeginOfTraversalComment(CtBlock<?> block) {
        List<CtElement> matchingComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isBeginOfTraversalComment).toList();
        if (matchingComments.isEmpty())
            return null;
        return (CtStatement) matchingComments.get(RandomUtils.nextInt(matchingComments.size()));
    }

    public static CtStatement getEndOfTraversedFieldsComment(CtBlock<?> block) {
        List<CtElement> matchingComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isEndOfTraversedFieldsComment).toList();
        if (matchingComments.isEmpty())
            return null;
        return (CtStatement) matchingComments.get(RandomUtils.nextInt(matchingComments.size()));
    }

    public static CtStatement getSizeCheckComment(CtBlock<?> block) {
        List<CtElement> matchingComments = block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isSizeCheckComment).toList();
        if (matchingComments.isEmpty())
            return null;
        return (CtStatement) matchingComments.get(RandomUtils.nextInt(matchingComments.size()));
    }

    public static boolean isEndOfTraversedFieldsComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("End of Traversed Fields");
    }

    public static List<CtIf> getTraversalIfsForTraversedFields(CtBlock<?> traversalBody) {
        List<CtIf> traversalIfs = new LinkedList<>();
        CtStatement currStatement = getNextStatement(getEndOfHandleCurrentComment(traversalBody));
        while (!isEndOfTraversedFieldsComment(currStatement)) {
            assert currStatement instanceof CtIf;
            traversalIfs.add((CtIf) currStatement);
            currStatement = getNextStatement(currStatement);
        }
        return traversalIfs;
    }

    public static CtStatement getNextStatement(CtStatement statement) {
        CtElement parent = statement.getParent();

        // Ensure the parent is a block
        if (parent instanceof CtBlock) {
            CtBlock<?> block = (CtBlock<?>) parent;
            int index = block.getStatements().indexOf(statement);
            if (index != -1 && index < block.getStatements().size() - 1) {
                return block.getStatements().get(index + 1);
            }
        }
        // No next statement found
        return null;
    }

    public static List<CtLocalVariable<?>> getLocalVariablesMatchingPrefix(CtBlock<?> code, String varPrefix) {
        return code.getElements(var -> var.getSimpleName().startsWith(varPrefix));
    }

    public static CtElement getElementMatchingPrefix(CtElement code, String prefix) {
        return code.getElements(elem -> prefixMatch(elem, prefix)).get(0);
    }

    public static boolean prefixMatch(CtElement elem, String prefix) {
        if (elem instanceof CtLocalVariable<?> var)
            return var.getSimpleName().startsWith(prefix);
        if (elem instanceof CtVariableAccess<?> varAccess)
            return varAccess.getVariable().getSimpleName().startsWith(prefix);
        return false;
    }

    public static List<CtLocalVariable<?>> getLocalVariablesMatchingPrefix(List<CtStatement> statements,
                                                                           String varPrefix) {
        List<CtLocalVariable<?>> setVars = new ArrayList<>();
        for (CtStatement statement : statements) {
            if (statement instanceof CtLocalVariable<?> var && var.getSimpleName().startsWith(varPrefix))
                setVars.add(var);
        }
        return setVars;
    }

    public static boolean isTraversalLoop(CtElement element) {
        if (!(element instanceof CtWhile loop))
            return false;
        String condition = loop.getLoopingExpression().toString();
        return condition.contains(LocalVarHelper.CURRENT_VAR_NAME);
    }

    public static CtLocalVariable<?> getLocalVarMatchingPrefix(CtElement element, String prefix) {
        CtElement matchingElement = getElementMatchingPrefix(element, prefix);
        if (matchingElement instanceof CtLocalVariable<?> var)
            return var;
        if (matchingElement instanceof CtVariableAccess<?> varWrite)
            return (CtLocalVariable<?>) varWrite.getVariable().getDeclaration();
        return null;
    }

    public static List<CtLocalVariable<?>> getVisitedSetLocalVars(CtBlock<?> block) {
        return getLocalVariablesMatchingPrefix(block, LocalVarHelper.SET_VAR_NAME);
    }

/*    public static CtVariable<?> searchVisitedSetInBlock(CtBlock<?> block, CtTypeReference<?> setSubtype) {
        setSubtype = TypeUtils.getBoxedPrimitive(setSubtype);
        List<CtLocalVariable<?>> visitedSetVars = getLocalVariablesMatchingPrefix(block, LocalVarHelper.SET_VAR_NAME);
        if (visitedSetVars.isEmpty())
            return null;
        for (CtLocalVariable<?> setVar : visitedSetVars) {
            CtTypeReference<?> subtype = setVar.getType().getActualTypeArguments().get(0);
            if (setSubtype.isSubtypeOf(subtype)) {
                return setVar;
            }
        }
        return null;
    }*/

    public static CtVariable<?> searchVisitedSetInBlockPrimitiveType(CtBlock<?> block, CtTypeReference<?> setSubtype) {
        setSubtype = TypeUtils.getBoxedPrimitive(setSubtype);
        List<CtLocalVariable<?>> visitedSetVars = getLocalVariablesMatchingPrefix(block, LocalVarHelper.SET_VAR_NAME);
        if (visitedSetVars.isEmpty())
            return null;
        for (CtLocalVariable<?> setVar : visitedSetVars) {
            CtTypeReference<?> subtype = setVar.getType().getActualTypeArguments().get(0);
            if (setSubtype.equals(subtype)) {
                return setVar;
            }
        }
        return null;
    }

    public static List<CtElement> getIfsInvokingMethod(CtBlock<?> block, String methodName) {
        return block.getElements(e -> e instanceof CtIf).stream().filter(ifStatement -> {
            CtIf ifStatement1 = (CtIf) ifStatement;
            return ifStatement1.getCondition().toString().contains(methodName);
        }).toList();
    }

    public static List<CtLocalVariable<?>> getVisitedSetLocalVarsOfType(CtBlock<?> block, CtTypeReference<?> type) {
        return getLocalVariablesMatchingPrefix(block, LocalVarHelper.SET_VAR_NAME).stream().filter(
                var -> var.getType().getActualTypeArguments().get(0).isSubtypeOf(type)).toList();
    }

    public static boolean containsSizeCheck(CtBlock<?> block) {
        return !block.getElements(SpoonQueries::isSizeCheckComment).isEmpty();
    }

    public static List<Path> chooseNPaths(List<Path> paths, int n) {
        List<Path> chosenPaths = new ArrayList<>();
        List<Integer> indices = RandomUtils.generateRandomIntegers(paths.size() - 1, n);
        for (int index : indices) {
            chosenPaths.add(paths.get(index));
        }
        return chosenPaths;
    }

    public static CtComment getEndOfInitialChecksComment(CtBlock<?> block) {
        List<CtComment> comments = block.getElements(SpoonQueries::isEndOfInitialChecksComment);
        return comments.get(0);
    }

    public static CtComment getEndOfHandleCurrentComment(CtBlock<?> block) {
        List<CtComment> comments = block.getElements(SpoonQueries::isEndOfHandleCurrentComment);
        return comments.get(0);
    }

    public static CtComment getEndOfTraversalComment(List<CtStatement> statements) {
        for (CtStatement statement : statements) {
            if (isEndOfTraversalComment(statement))
                return (CtComment) statement;
        }
        return null;
    }

    public static boolean checkAlreadyExistSimple(CtElement condition, CtBlock<?> block) {
        List<CtIf> ifs = block.getElements(Objects::nonNull);
        for (CtIf ifStatement : ifs) {
            if (ifStatement.getCondition().toString().equals(condition.toString()))
                return true;
        }
        return false;
    }

    public static boolean checkAlreadyExist(CtElement condition, CtBlock<?> block) {
        List<CtIf> ifs = block.getElements(Objects::nonNull);
        for (CtIf ifStatement : ifs) {
            if (ifStatement.getCondition().toString().equals(condition.toString())) {
                return true;
            } else if (condition instanceof CtBinaryOperator<?> binaryOperator) {
                if (ifStatement.getCondition() instanceof CtBinaryOperator<?> ifBinaryOperator) {
                    if (areBinaryOperationsEqual(binaryOperator, ifBinaryOperator))
                        return true;
                }
            }

        }
        return false;
    }

    public static boolean areBinaryOperationsEqual(CtBinaryOperator<?> condition1, CtBinaryOperator<?> condition2) {
        if (!condition1.getKind().equals(condition2.getKind()))
            return false;
        CtExpression<?> leftOperand1 = condition1.getLeftHandOperand();
        CtExpression<?> rightOperand1 = condition1.getRightHandOperand();
        CtExpression<?> leftOperand2 = condition2.getLeftHandOperand();
        CtExpression<?> rightOperand2 = condition2.getRightHandOperand();
        if (!leftOperand1.toString().equals(leftOperand2.toString())
                && !leftOperand1.toString().equals(rightOperand2.toString()))
            return false;
        if (!rightOperand1.toString().equals(leftOperand2.toString())
                && !rightOperand1.toString().equals(rightOperand2.toString()))
            return false;
        return true;
    }

}
