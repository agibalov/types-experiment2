package me.loki2302.expressions.constraints;

import me.loki2302.Compiler;
import me.loki2302.expressions.Expression;

public interface ExpressionConstraint {
    ConstrainedExpressionResult test(Compiler compiler, Expression expression);
}