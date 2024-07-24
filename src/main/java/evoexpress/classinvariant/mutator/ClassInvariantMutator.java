package evoexpress.classinvariant.mutator;

import evoexpress.classinvariant.state.ClassInvariantState;

public interface ClassInvariantMutator {

    boolean isApplicable(ClassInvariantState state);

    boolean mutate(ClassInvariantState state);

}
