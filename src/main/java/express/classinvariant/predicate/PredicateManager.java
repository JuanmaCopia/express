package express.classinvariant.predicate;

import express.classinvariant.mutator.LocalVarHelper;
import express.config.Config;
import express.spoon.SpoonFactory;
import express.type.typegraph.TypeData;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PredicateManager {

    private static TypeData subjectTypeData;
    private static Config config;

    public static void initialize(Config c, TypeData typeData) {
        config = c;
        subjectTypeData = typeData;
    }

    public static CtClass<?> createPredicateClass(long id) {
        CtClass<?> predicateClass = SpoonFactory.getCoreFactory().createClass();
        String className = createPredicateClassName(id);
        predicateClass.setSimpleName(className);
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PUBLIC);
        predicateClass.setModifiers(modifiers);

        CtClass<?> thisClass = subjectTypeData.getThisCtClass();

        CtPackage ctPackage = thisClass.getPackage();
        ctPackage.addType(predicateClass);

        List<CtParameter<?>> parameters = new ArrayList<>();
        parameters.add((CtParameter<?>) subjectTypeData.getThisVariable());
        createSubPredicates(predicateClass, parameters);

        return predicateClass;
    }

    public static String createPredicateClassName(long id) {
        return config.predicateClassName + id;
    }

    private static void createSubPredicates(CtClass<?> predicateClass, List<CtParameter<?>> parameters) {
        List<CtMethod<Boolean>> subPredicates = createSubPredicates(parameters);
        for (CtMethod<?> subPredicate : subPredicates)
            predicateClass.addMethod(subPredicate);

        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PUBLIC);
        modifiers.add(ModifierKind.STATIC);

        CtMethod<Boolean> predicateMethod = SpoonFactory.createMethod(
                modifiers,
                SpoonFactory.getTypeFactory().booleanPrimitiveType(),
                config.predicateMethodName,
                parameters
        );
        CtExpression<?>[] args = SpoonFactory.createArgumentsFromParameters(predicateMethod);

        CtBlock<?> body = SpoonFactory.createBlock();
        for (CtMethod<?> subPredicate : subPredicates) {
            CtInvocation<?> subPredicateInvocation = SpoonFactory.createStaticInvocation(SpoonFactory.getTypeFactory().createReference(predicateClass), subPredicate.getSimpleName(), args);
            CtExpression<Boolean> predicateNegation = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(subPredicateInvocation, UnaryOperatorKind.NOT);
            CtIf ifStatement = SpoonFactory.createIfThenStatement(predicateNegation, SpoonFactory.createReturnStatement(SpoonFactory.getCodeFactory().createLiteral(false)));
            body.addStatement(ifStatement);
        }
        body.addStatement(SpoonFactory.createReturnStatement(SpoonFactory.getCodeFactory().createLiteral(true)));
        predicateMethod.setBody(body);

        predicateClass.addMethod(predicateMethod);
    }


    private static List<CtMethod<Boolean>> createSubPredicates(List<CtParameter<?>> parameters) {
        List<CtMethod<Boolean>> subPredicates = new ArrayList<>();
        subPredicates.add(createSubPredicateMethod(LocalVarHelper.STRUCTURE_METHOD_NAME, parameters));
        subPredicates.add(createSubPredicateMethod(LocalVarHelper.PRIMITIVE_METHOD_NAME, parameters));
        return subPredicates;
    }

    private static String createSubPredicateMethodName(String name) {
        return name + LocalVarHelper.MUTABLE_METHOD_SUFFIX;
    }

    public static CtMethod<Boolean> createSubPredicateMethod(String name, List<CtParameter<?>> parameters) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PUBLIC);
        modifiers.add(ModifierKind.STATIC);

        String methodName = createSubPredicateMethodName(name);

        CtMethod<Boolean> predicateMethod = SpoonFactory.createMethod(modifiers, SpoonFactory.getTypeFactory().booleanPrimitiveType(), methodName, parameters);

        predicateMethod.setBody(createReturnTrueBlock());
        return predicateMethod;
    }

    public static CtBlock<?> createReturnTrueBlock() {
        CtBlock<Boolean> block = SpoonFactory.getCoreFactory().createBlock();
        block.addStatement(SpoonFactory.createComment(LocalVarHelper.SEPARATOR_LABEL));
        block.addStatement(SpoonFactory.createComment(LocalVarHelper.RETURN_TRUE_LABEL));
        block.addStatement(SpoonFactory.createReturnStatement(SpoonFactory.getCodeFactory().createLiteral(true)));
        return block;
    }
}
