package me.loki2302.operations;

import java.util.List;

import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public abstract class BinaryOperation extends AbstractOperation {
    @Override
    protected int getParameterCount() {
        return 2;
    }

    @Override
    protected ExpressionConstraint getExpressionConstraint(int parameterIndex) {
        if(parameterIndex == 0) {
            return getLeftConstraint();
        }
                    
        if(parameterIndex == 1) {
            return getRightConstraint();
        }
        
        throw new RuntimeException();
    }

    @Override
    protected Expression processSafe(List<Expression> arguments) {
        Expression left = arguments.get(0);
        Expression right = arguments.get(1);
        return processBinary(left, right);
    }
    
    protected abstract ExpressionConstraint getLeftConstraint();
    protected abstract ExpressionConstraint getRightConstraint();
    protected abstract Expression processBinary(Expression left, Expression right);        
}