package me.loki2302.operations;

import java.util.List;

import me.loki2302.compiler.ImplicitCastor;
import me.loki2302.expressions.Expression;

public interface Operation {
    Intention getIntention();
    ExpressionResult process(ImplicitCastor implicitCastor, List<Expression> arguments);
}