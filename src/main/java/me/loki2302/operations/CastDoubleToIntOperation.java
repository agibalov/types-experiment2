package me.loki2302.operations;

import me.loki2302.expressions.CastDoubleToIntExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.expressions.constraints.ExpressionIsOfExactTypeExpressionConstraint;
import me.loki2302.types.Type;
import me.loki2302.types.constraints.TypeConstraint;
import me.loki2302.types.constraints.TypeIsExactlyTypeConstraint;

public class CastDoubleToIntOperation extends AbstractCastOperation {
    private final Type intType;
    private final Type doubleType;        
    
    public CastDoubleToIntOperation(Type intType, Type doubleType) {
        this.intType = intType;
        this.doubleType = doubleType;            
    }
    
    @Override
    protected TypeConstraint getTargetTypeConstraint() {
        return new TypeIsExactlyTypeConstraint(intType);
    }

    @Override
    protected ExpressionConstraint getExpressionConstraint() {
        return new ExpressionIsOfExactTypeExpressionConstraint(doubleType);
    }

    @Override
    protected Expression processSafe(Type targetType, Expression expression) {
        return new CastDoubleToIntExpression(intType, expression);
    }        
}