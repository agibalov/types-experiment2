package me.loki2302.expressions.constraints;

import me.loki2302.App;
import me.loki2302.App.ImplicitCastor;
import me.loki2302.expressions.Expression;

public interface ExpressionConstraint {
    ConstraintMatch match(Expression expression, ImplicitCastor implicitCastor);
}