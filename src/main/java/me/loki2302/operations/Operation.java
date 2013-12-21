package me.loki2302.operations;

import java.util.List;

import me.loki2302.App.Parameter;
import me.loki2302.expressions.Expression;

public interface Operation {
    Intention getIntention();
    List<Parameter> getParameters();
    Expression process(List<Expression> arguments);
}