package me.loki2302.semantics.operations.constraints;

import me.loki2302.semantics.Compiler;

public interface ArgumentConstraint {
    ConstrainedArgumentResult test(Compiler compiler, Object argument);
}