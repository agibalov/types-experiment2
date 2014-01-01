package me.loki2302.semantics.operations;

import me.loki2302.semantics.expressions.CastIntToDoubleExpression;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.constraints.ExpressionConstraint;
import me.loki2302.semantics.expressions.constraints.ExpressionIsOfExactTypeExpressionConstraint;
import me.loki2302.semantics.types.Type;
import me.loki2302.semantics.types.constraints.TypeConstraint;
import me.loki2302.semantics.types.constraints.TypeIsExactlyTypeConstraint;

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