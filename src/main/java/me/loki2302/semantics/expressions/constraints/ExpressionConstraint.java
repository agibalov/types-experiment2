package me.loki2302.semantics.expressions.constraints;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.expressions.Expression;

public interface ExpressionConstraint {
    ConstrainedExpressionResult test(Compiler compiler, Expression expression);
}