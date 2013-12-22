package me.loki2302.compiler;

import me.loki2302.Type;
import me.loki2302.expressions.Expression;

public class NullImplicitCastor implements ImplicitCastor {
    @Override
    public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
        return null;
    }        
}