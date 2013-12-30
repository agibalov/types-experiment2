package me.loki2302.operations;

import java.util.List;

import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.operations.constraints.ArgumentConstraint;
import me.loki2302.operations.constraints.ArgumentIsExpressionConstraint;

public abstract class AbstractEEEOperation extends AbstractOperation {
    @Override
    protected int getArgumentCount() {
        return 2;
    }

    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        if(index == 0) {
            return new ArgumentIsExpressionConstraint(getLeftExpressionConstraint());
        }
                    
        if(index == 1) {
            return new ArgumentIsExpressionConstraint(getRightExpressionConstraint());
        }
        
        throw new RuntimeException();
    }

    @Override
    protected Object processSafe(List<Object> safeArguments) {
        Expression leftExpression = (Expression)safeArguments.get(0);
        Expression rightExpression = (Expression)safeArguments.get(1);
        return processSafe(leftExpression, rightExpression);
    }
    
    protected abstract ExpressionConstraint getLeftExpressionConstraint();
    protected abstract ExpressionConstraint getRightExpressionConstraint();
    protected abstract Expression processSafe(Expression left, Expression right);
}