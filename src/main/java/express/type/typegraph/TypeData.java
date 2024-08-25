package express.type.typegraph;

import express.classinvariant.mutator.LocalVarHelper;
import express.type.TypeUtils;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TypeData {

    private CtClass<?> thisClass;
    private CtVariable<?> thisVariable;
    private CtTypeReference<?> thisTypeRef;
    private TypeGraph typeGraph;

    private Set<CtTypeReference<?>> types;

    private Set<CtTypeReference<?>> userDefinedTypes;
    private Set<CtTypeReference<?>> cyclicTypes;
    private Set<CtTypeReference<?>> integerTypes;
    private Set<CtTypeReference<?>> booleanTypes;
    private Set<CtTypeReference<?>> charTypes;
    private Set<CtTypeReference<?>> floatingPointTypes;
    private Set<CtTypeReference<?>> referencesTypes;
    private Set<CtTypeReference<?>> arrayTypes;
    private Set<CtTypeReference<?>> iterableTypes;

    private Set<Path> simplePaths;

    private Set<Path> cyclicPaths;
    private Set<Path> integerPaths;
    private Set<Path> booleanPaths;
    private Set<Path> charPaths;
    private Set<Path> floatingPointPaths;
    private Set<Path> referencePaths;
    private Set<Path> arrayPaths;
    private Set<Path> iterablePaths;

    public TypeData(CtClass<?> subjectClass) {
        initializeSubjectData(subjectClass);
        initializeTypes();
        initializePaths();
    }

    private void initializeSubjectData(CtClass<?> subjectClass) {
        thisClass = subjectClass;
        thisVariable = thisClass.getFactory().Core().createParameter();
        thisVariable.setType(thisClass.getReference());
        thisVariable.setSimpleName(LocalVarHelper.THIS_PARAM_NAME);
        thisTypeRef = thisVariable.getType();
        typeGraph = new TypeGraph(thisVariable);
    }

    private void initializePaths() {
        simplePaths = typeGraph.computeSimplePaths(thisVariable);
        cyclicPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isCyclicType);
        integerPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isIntegerType);
        booleanPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isBooleanType);
        charPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isCharType);
        floatingPointPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isFloatingPointType);
        referencePaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isReferenceType);
        arrayPaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isArrayType);
        iterablePaths = TypeUtils.filterPaths(simplePaths, TypeUtils::isIterableType);
    }

    private void initializeTypes() {
        types = typeGraph.computeTypes();
        userDefinedTypes = TypeUtils.filterTypes(types, TypeUtils::isUserDefinedType);
        cyclicTypes = TypeUtils.filterTypes(types, TypeUtils::isCyclicType);
        integerTypes = TypeUtils.filterTypes(types, TypeUtils::isIntegerType);
        booleanTypes = TypeUtils.filterTypes(types, TypeUtils::isBooleanType);
        charTypes = TypeUtils.filterTypes(types, TypeUtils::isCharType);
        floatingPointTypes = TypeUtils.filterTypes(types, TypeUtils::isFloatingPointType);
        referencesTypes = TypeUtils.filterTypes(types, TypeUtils::isReferenceType);
        arrayTypes = TypeUtils.filterTypes(types, TypeUtils::isArrayType);
        iterableTypes = TypeUtils.filterTypes(types, TypeUtils::isIterableType);
    }

    public CtClass<?> getThisCtClass() {
        return thisClass;
    }

    public CtVariable<?> getThisVariable() {
        return thisVariable;
    }

    public CtTypeReference<?> getThisTypeReference() {
        return thisTypeRef;
    }

    public TypeGraph getThisTypeGraph() {
        return typeGraph;
    }

    public List<Path> getSimplePaths() {
        return new LinkedList<>(simplePaths);
    }

    public List<Path> getCyclicPaths() {
        return new LinkedList<>(cyclicPaths);
    }

    public List<Path> getIntegerPaths() {
        return new LinkedList<>(integerPaths);
    }

    public List<Path> getBooleanPaths() {
        return new LinkedList<>(booleanPaths);
    }

    public List<Path> getCharPaths() {
        return new LinkedList<>(charPaths);
    }

    public List<Path> getFloatingPointPaths() {
        return new LinkedList<>(floatingPointPaths);
    }

    public List<Path> getReferencePaths() {
        return new LinkedList<>(referencePaths);
    }

    public List<Path> getArrayPaths() {
        return new LinkedList<>(arrayPaths);
    }

    public List<Path> getIterablePaths() {
        return new LinkedList<>(iterablePaths);
    }

    public List<CtTypeReference<?>> getTypes() {
        return new LinkedList<>(types);
    }

    public List<CtTypeReference<?>> getCyclicTypes() {
        return new LinkedList<>(cyclicTypes);
    }

    public List<CtTypeReference<?>> getIntegerTypes() {
        return new LinkedList<>(integerTypes);
    }

    public List<CtTypeReference<?>> getBooleanTypes() {
        return new LinkedList<>(booleanTypes);
    }

    public List<CtTypeReference<?>> getCharTypes() {
        return new LinkedList<>(charTypes);
    }

    public List<CtTypeReference<?>> getFloatingPointTypes() {
        return new LinkedList<>(floatingPointTypes);
    }

    public List<CtTypeReference<?>> getReferenceTypes() {
        return new LinkedList<>(referencesTypes);
    }

    public List<CtTypeReference<?>> getArrayTypes() {
        return new LinkedList<>(arrayTypes);
    }

    public List<CtTypeReference<?>> getIterableTypes() {
        return new LinkedList<>(iterableTypes);
    }

    public List<CtTypeReference<?>> getUserDefinedTypes() {
        return new LinkedList<>(userDefinedTypes);
    }

    public List<Path> getSimplePathsOfType(CtTypeReference<?> type) {
        return simplePaths.stream().filter(p -> p.getTypeReference().equals(type)).toList();
    }

}
