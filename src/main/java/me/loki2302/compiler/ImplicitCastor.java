package me.loki2302.compiler;

import me.loki2302.Type;
import me.loki2302.expressions.Expression;

public interface ImplicitCastor {
    Expression wrapWithImplicitCast(Type desiredType, Expression e);
}