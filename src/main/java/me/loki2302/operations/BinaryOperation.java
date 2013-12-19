package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App.ExpressionConstraint;
import me.loki2302.App.Parameter;
import me.loki2302.expressions.Expression;

public abstract class BinaryOperation implements Operation {
    public List<Parameter> getParameters() {
        return Arrays.asList(
                new Parameter("left", getLeftConstraint()), 
                new Parameter("right", getRightConstraint()));
    }
    
    public Expression process(List<Expression> arguments) {
        return processBinary(arguments.get(0), arguments.get(1));
    }
    
    protected abstract ExpressionConstraint getLeftConstraint();
    protected abstract ExpressionConstraint getRightConstraint();
    protected abstract Expression processBinary(Expression left, Expression right);
}