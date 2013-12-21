package me.loki2302.operations;

import static me.loki2302.expressions.constraints.ExpressionConstraints.isOfType;

import me.loki2302.Type;
import me.loki2302.expressions.CastDoubleToIntExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public class CastDoubleToIntOperation extends UnaryOperation {
    private final Type doubleType;
    private final Type intType;
    
    public CastDoubleToIntOperation(Type doubleType, Type intType) {
        this.doubleType = doubleType;
        this.intType = intType;            
    }

    public Intention getIntention() {
        return Intention.Cast;
    }

    @Override
    protected ExpressionConstraint getInputConstraint() {
        return isOfType(doubleType);
    }

    @Override
    protected Expression processUnary(Expression e) {
        return new CastDoubleToIntExpression(intType, e);
    }
}