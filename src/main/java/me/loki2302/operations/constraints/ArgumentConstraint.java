package me.loki2302.operations.constraints;

import me.loki2302.Compiler;

public interface ArgumentConstraint {
    ConstrainedArgumentResult test(Compiler compiler, Object argument);
}