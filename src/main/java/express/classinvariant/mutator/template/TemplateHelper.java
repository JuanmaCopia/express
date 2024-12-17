package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonFactory;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.factory.CoreFactory;
import spoon.reflect.factory.TypeFactory;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;

public class TemplateHelper {

    public static CtMethod<?> createTraversalMethod(CtClass<?> ctClass, Path leftPath, String traversalPrefix) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().booleanPrimitiveType();
        List<CtParameter<?>> formalParameters = TemplateHelper.createTraversalFormalParameters(leftPath);
        String traversalName = LocalVarHelper.getNextTraversalName(ctClass, traversalPrefix);
        return SpoonFactory.createMethod(modifiers, returnType, traversalName, formalParameters);
    }

    public static List<CtParameter<?>> createTraversalFormalParameters(Path leftPath) {
        List<CtParameter<?>> parameters = new ArrayList<>();
        CtParameter<?> mapOfVisitedParameter = TemplateHelper.createMapOfVisitedParameter();
        CtParameter<?> traversedElementParameter = TemplateHelper.createTraversedElementParameter(leftPath);
        parameters.add(traversedElementParameter);
        parameters.add(mapOfVisitedParameter);
        return parameters;
    }

    // Creates the following parameter:  Map<Class<?>, Set<Object>> mapOfVisited
    public static CtParameter<?> createMapOfVisitedParameter() {
        CtTypeReference<?> visitedMapType = createMapOfVisitedTypeReference();
        CtParameter<?> visitedMapParameter = SpoonFactory.getCoreFactory().createParameter();
        visitedMapParameter.setType(visitedMapType);
        visitedMapParameter.setSimpleName(LocalVarHelper.MAP_OF_VISITED);
        return visitedMapParameter;
    }

    // Create the type reference:  Map<Class<?>, Set<Object>>
    public static CtTypeReference<?> createMapOfVisitedTypeReference() {
        CoreFactory coreFactory = SpoonFactory.getCoreFactory();
        TypeFactory typeFactory = SpoonFactory.getTypeFactory();
        CtTypeReference<?> setOfObjects = SpoonFactory.createTypeWithSubtypeReference(Set.class, typeFactory.objectType());
        CtTypeReference<?> classOfWildcard = SpoonFactory.createTypeWithSubtypeReference(Class.class, coreFactory.createWildcardReference());
        List<CtTypeReference<?>> actualTypeArguments = new ArrayList<>();
        actualTypeArguments.add(classOfWildcard);
        actualTypeArguments.add(setOfObjects);
        return SpoonFactory.createTypeWithSubtypeReference(Map.class, actualTypeArguments);
    }

    public static CtParameter<?> createTraversedElementParameter(Path pathToTraversedElement) {
        CtParameter<?> traversedElementParameter = SpoonFactory.getCoreFactory().createParameter();
        CtTypeReference<?> typeOfTraversedElement = TypeUtils.convertGenericsToWildcard(pathToTraversedElement.getTypeReference());
        traversedElementParameter.setType(typeOfTraversedElement);
        traversedElementParameter.setSimpleName(LocalVarHelper.TRAVERSED_ELEMENT_VAR_NAME);
        return traversedElementParameter;
    }

    public static CtVariable<?> getTraversedElementParameter(CtMethod<?> traversal) {
        return traversal.getParameters().get(0);
    }

    public static CtVariable<?> getMapOfVisitedParameter(CtMethod<?> traversal) {
        return traversal.getParameters().get(1);
    }

    public static boolean isReferenceArrayTraversal(CtMethod<?> traversal) {
        CtTypeReference<?> traversedElementType = getTraversedElementParameter(traversal).getType();
        if (!traversedElementType.isArray())
            return false;
        CtArrayTypeReference<?> arrayType = (CtArrayTypeReference<?>) traversedElementType;
        return TypeUtils.isReferenceType(arrayType.getComponentType());
    }

    // creates the following local variable: Set<Object> visitedElements = visitedMap.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
    public static CtLocalVariable<?> createVisitedElementsSet(CtVariable<?> visitedMap, CtVariableRead<?> rootElementRead) {
        CoreFactory coreFactory = SpoonFactory.getCoreFactory();
        TypeFactory typeFactory = SpoonFactory.getTypeFactory();

        String visitedElementsName = LocalVarHelper.getVisitedSetVarName(rootElementRead.getType());
        CtLocalVariable<?> visitedElements = coreFactory.createLocalVariable();
        visitedElements.setSimpleName(visitedElementsName);
        visitedElements.setType(SpoonFactory.createTypeWithSubtypeReference(Set.class, typeFactory.objectType()));

        CtExpression<?> param1 = createRootElementGetClassInvocation(rootElementRead);
        CtExpression<?> param2 = createSetCreationLambdaExpression();
        CtInvocation computeIfAbsentInvocation = createComputeIfAbsentInvocation(param1, param2, visitedMap);

        visitedElements.setAssignment(computeIfAbsentInvocation);
        return visitedElements;
    }

    // creates the following local variable: Set<Object> visitedElements = visitedMap.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
    public static CtLocalVariable<?> createVisitedElementsSet(CtVariable<?> visitedMap, CtTypeReference<?> subtypeOfSet) {
        CoreFactory coreFactory = SpoonFactory.getCoreFactory();
        TypeFactory typeFactory = SpoonFactory.getTypeFactory();

        String visitedElementsName = LocalVarHelper.getVisitedSetVarName(subtypeOfSet);
        CtLocalVariable<?> visitedElements = coreFactory.createLocalVariable();
        visitedElements.setSimpleName(visitedElementsName);
        visitedElements.setType(SpoonFactory.createTypeWithSubtypeReference(Set.class, typeFactory.objectType()));

        CtExpression<?> param1 = subtypeOfSet.getFactory().createClassAccess(subtypeOfSet);
        CtExpression<?> param2 = createSetCreationLambdaExpression();
        CtInvocation computeIfAbsentInvocation = createComputeIfAbsentInvocation(param1, param2, visitedMap);

        visitedElements.setAssignment(computeIfAbsentInvocation);
        return visitedElements;
    }

    private static CtInvocation<?> createComputeIfAbsentInvocation(CtExpression<?> param1, CtExpression<?> param2, CtVariable<?> visitedMap) {
        TypeFactory typeFactory = SpoonFactory.getTypeFactory();

        CtTypeReference<?> classType = typeFactory.createReference(Class.class);
        CtTypeReference<?> setOfObjectsType = SpoonFactory.createTypeWithSubtypeReference(Set.class, typeFactory.objectType());

        List<CtTypeReference<?>> argumentTypes = new ArrayList<>();
        argumentTypes.add(classType);
        argumentTypes.add(setOfObjectsType);

        List<Object> argumentValues = new ArrayList<>();
        argumentValues.add(param1);
        argumentValues.add(param2);

        CtInvocation<?> computeIfAbsentInvocation = SpoonFactory.createInvocation(visitedMap, "computeIfAbsent", argumentTypes, argumentValues);
        return computeIfAbsentInvocation;
    }

    private static CtExpression<?> createRootElementGetClassInvocation(CtVariableRead<?> rootElementRead) {
        if (rootElementRead.getType().isArray()) {
            CtInvocation getClassInvocation = SpoonFactory.createInvocation(rootElementRead, "getClass", Collections.emptyList(), Collections.emptyList());
            return SpoonFactory.createInvocation(getClassInvocation, "getComponentType", Collections.emptyList(), Collections.emptyList());
        }
        return SpoonFactory.createInvocation(rootElementRead, "getClass", Collections.emptyList(), Collections.emptyList());
    }

    // creates the following lambda expression: k -> Collections.newSetFromMap(new IdentityHashMap<>())
    private static CtExpression<?> createSetCreationLambdaExpression() {
        CoreFactory coreFactory = SpoonFactory.getCoreFactory();
        CtLambda<?> lambda = coreFactory.createLambda();
        CtParameter<?> kVariable = coreFactory.createParameter();
        kVariable.setSimpleName("k");
        lambda.setParameters(Collections.singletonList(kVariable));

        CtInvocation newSetFromMapInvocation = SpoonFactory.createIdentitySetInvocation();
        lambda.setExpression(newSetFromMapInvocation);
        return lambda;
    }

    // creates the following declaration Map<Class<?>, Set<Object>> mapOfVisited = new IdentityHashMap<>();
    public static CtLocalVariable<?> createMapOfVisitedDeclaration() {
        CoreFactory coreFactory = SpoonFactory.getCoreFactory();
        TypeFactory typeFactory = SpoonFactory.getTypeFactory();
        CtLocalVariable<?> mapOfVisited = coreFactory.createLocalVariable();
        mapOfVisited.setSimpleName(LocalVarHelper.MAP_OF_VISITED);
        CtTypeReference<?> mapOfVisitedType = createMapOfVisitedTypeReference();
        mapOfVisited.setType(mapOfVisitedType);
        CtConstructorCall IdentityHashMapConstructorCall = SpoonFactory.createConstructorCall(typeFactory.createReference(IdentityHashMap.class));
        mapOfVisited.setAssignment(IdentityHashMapConstructorCall);
        return mapOfVisited;
    }

    public static CtExpression<?>[] createActualArgumentsForTraversal(CtVariableRead<?> traversedElementRead, CtVariableRead<?> mapOfVisitedRead) {
        return new CtExpression<?>[]{traversedElementRead, mapOfVisitedRead};
    }

    public static CtMethod<?> getStructureMethod(ClassInvariantState state) {
        return MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
    }

    public static CtMethod<?> getPrimitiveMethod(ClassInvariantState state) {
        return MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.PRIMITIVE_METHOD_NAME);
    }

    public static CtVariable<?> getTraversalWorklistVariable(CtMethod<?> traversal) {
        List<CtLocalVariable<?>> localVars = traversal.getBody().getElements(var -> var.getSimpleName().startsWith(LocalVarHelper.WORKLIST_VAR_NAME));
        if (localVars.isEmpty())
            return null;
        return localVars.get(0);
    }

    public static CtVariable<?> getTraversalCurrentVariable(CtMethod<?> traversal) {
        return (CtVariable<?>) traversal.getBody().getElements(e -> e instanceof CtLocalVariable<?> var
                && var.getSimpleName().startsWith(LocalVarHelper.CURRENT_VAR_NAME)).stream().findFirst().orElse(null);
    }

    public static CtLocalVariable<?> getTraversalVisitedElementsVariable(CtMethod<?> traversal) {
        return (CtLocalVariable<?>) traversal.getBody().getElements(e -> e instanceof CtLocalVariable<?> var
                && var.getSimpleName().startsWith(LocalVarHelper.SET_VAR_NAME)).stream().findFirst().orElse(null);
    }

    public static CtInvocation<Boolean> createTraversalInvocation(Path chosenPath, CtMethod<?> traversal, CtVariable<?> mapOfVisited) {
        CtExpression<?>[] args = TemplateHelper.createActualArgumentsForTraversal(chosenPath.getVariableRead(), SpoonFactory.createVariableRead(mapOfVisited));
        return (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);
    }

    public static CtTypeReference<?> getArrayTraversalElementType(CtMethod<?> arrayTraversal) {
        return ((CtArrayTypeReference<?>) TemplateHelper.getTraversedElementParameter(arrayTraversal).getType()).getComponentType();
    }


}