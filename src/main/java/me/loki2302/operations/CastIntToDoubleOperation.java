package me.loki2302.operations;

import static me.loki2302.expressions.constraints.ExpressionConstraints.isOfType;
import me.loki2302.Type;
import me.loki2302.expressions.CastIntToDoubleExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public class CastIntToDoubleOperation extends UnaryOperation {
    private final Type intType;
    private final Type doubleType;
    
    public CastIntToDoubleOperation(Type intType, Type doubleType) {
        this.intType = intType;
        this.doubleType = doubleType;
    }

    @Override
    public Intention getIntention() {
        return Intention.Cast;
    }

    @Override
    protected ExpressionConstraint getInputConstraint() {
        return isOfType(intType);
    }

    @Override
    protected Expression processUnary(Expression input) {
        return new CastIntToDoubleExpression(doubleType, input);
    }        
}