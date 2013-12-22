package me.loki2302.operations;

import java.util.List;

import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public abstract class UnaryOperation extends AbstractOperation {
    @Override
    protected int getParameterCount() {
        return 1;
    }

    @Override
    protected ExpressionConstraint getExpressionConstraint(int parameterIndex) {
        if(parameterIndex == 0) {
            return getInputConstraint();
        }
        
        throw new RuntimeException();
    }

    @Override
    protected Expression processSafe(List<Expression> arguments) {
        Expression input = arguments.get(0);
        return processUnary(input);
    }
    
    protected abstract ExpressionConstraint getInputConstraint();
    protected abstract Expression processUnary(Expression input);
}