package me.loki2302.operations;

import me.loki2302.Intention;
import me.loki2302.expressions.AddDoublesExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.expressions.constraints.ExpressionIsOfCompatibleTypeExpressionConstraint;
import me.loki2302.types.Type;

public class AddDoublesOperation extends AbstractEEEOperation {
    private final Type doubleType;
    
    public AddDoublesOperation(Type doubleType) {
        this.doubleType = doubleType;
    }
    
    @Override
    public Intention getIntention() {
        return Intention.OperatorAdd;
    }
    
    @Override
    protected ExpressionConstraint getLeftExpressionConstraint() {            
        return new ExpressionIsOfCompatibleTypeExpressionConstraint(doubleType);
    }

    @Override
    protected ExpressionConstraint getRightExpressionConstraint() {
        return new ExpressionIsOfCompatibleTypeExpressionConstraint(doubleType);
    }

    @Override
    protected Expression processSafe(Expression left, Expression right) {
        return new AddDoublesExpression(doubleType, left, right);
    }               
}