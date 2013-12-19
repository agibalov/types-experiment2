package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App.Parameter;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public abstract class UnaryOperation implements Operation {
    public List<Parameter> getParameters() {
        return Arrays.asList(new Parameter("e", getInputConstraint()));
    }       

    public Expression process(List<Expression> arguments) {
        return processUnary(arguments.get(0));
    }
            
    protected abstract ExpressionConstraint getInputConstraint();
    protected abstract Expression processUnary(Expression e);
}