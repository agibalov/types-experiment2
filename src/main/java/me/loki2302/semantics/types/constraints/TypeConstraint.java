package me.loki2302.semantics.types.constraints;

import me.loki2302.semantics.types.Type;

public interface TypeConstraint {
    ConstrainedTypeResult test(Type type);
}