package me.loki2302.semantics.expressions.constraints;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.expressions.Expression;

public class AnyExpressionConstraint implements ExpressionConstraint {
    @Override
    public ConstrainedExpressionResult test(Compiler compiler, Expression expression) {
        return ConstrainedExpressionResult.ok(0, expression);
    }        
}