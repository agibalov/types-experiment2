package me.loki2302.operations;

import me.loki2302.expressions.CastIntToDoubleExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.expressions.constraints.ExpressionIsOfExactTypeExpressionConstraint;
import me.loki2302.types.Type;
import me.loki2302.types.constraints.TypeConstraint;
import me.loki2302.types.constraints.TypeIsExactlyTypeConstraint;


public class CastIntToDoubleOperation extends AbstractCastOperation {
    private final Type doubleType;
    private final Type intType;
    
    public CastIntToDoubleOperation(Type doubleType, Type intType) {
        this.doubleType = doubleType;
        this.intType = intType;
    }
    
    @Override
    protected TypeConstraint getTargetTypeConstraint() {
        return new TypeIsExactlyTypeConstraint(doubleType);
    }

    @Override
    protected ExpressionConstraint getExpressionConstraint() {
        return new ExpressionIsOfExactTypeExpressionConstraint(intType);
    }

    @Override
    protected Expression processSafe(Type targetType, Expression expression) {
        return new CastIntToDoubleExpression(doubleType, expression);
    }        
}