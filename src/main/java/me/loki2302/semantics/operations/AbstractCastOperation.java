package me.loki2302.semantics.operations;

import java.util.List;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.constraints.ExpressionConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentIsExpressionConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentIsTypeConstraint;
import me.loki2302.semantics.types.Type;
import me.loki2302.semantics.types.constraints.TypeConstraint;

public abstract class AbstractCastOperation extends AbstractOperation {
    @Override
    public Intention getIntention() {
        return Intention.OperatorCast;
    }
    
    @Override
    protected int getArgumentCount() {
        return 2;
    }
    
    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        if(index == 0) {
            return new ArgumentIsTypeConstraint(getTargetTypeConstraint());
        }
                    
        if(index == 1) {
            return new ArgumentIsExpressionConstraint(getExpressionConstraint());
        }
        
        throw new RuntimeException();
    }
    
    @Override
    protected Object processSafe(List<Object> safeArguments) {
        Type targetType = (Type)safeArguments.get(0);
        Expression expression = (Expression)safeArguments.get(1);
        return processSafe(targetType, expression);
    }
    
    protected abstract TypeConstraint getTargetTypeConstraint();
    protected abstract ExpressionConstraint getExpressionConstraint();
    protected abstract Expression processSafe(Type targetType, Expression expression);
}