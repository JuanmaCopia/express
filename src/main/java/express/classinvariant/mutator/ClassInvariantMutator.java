package express.classinvariant.mutator;

import express.classinvariant.state.ClassInvariantState;

public interface ClassInvariantMutator {

    boolean isApplicable(ClassInvariantState state);

    boolean mutate(ClassInvariantState state);

}
