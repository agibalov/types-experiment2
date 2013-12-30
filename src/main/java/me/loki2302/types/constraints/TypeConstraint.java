package me.loki2302.types.constraints;

import me.loki2302.types.Type;

public interface TypeConstraint {
    ConstrainedTypeResult test(Type type);
}