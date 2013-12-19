package me.loki2302.expressions.constraints;

import me.loki2302.Type;

public abstract class ExpressionConstraints {    
    public static ExpressionConstraint isOfType(Type type) {
        return new ExpressionHasResultTypeExpressionConstraint(type);
    }
}