package evorep.ga.mutators.typebased;

import evorep.spoon.scope.Scope;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.CtCodeElement;

interface TypeBasedMutator {

    boolean isApplicable(CtCodeElement gene, TypesGraph graph);

    CtCodeElement mutate(CtCodeElement gene, Scope scope);

}
