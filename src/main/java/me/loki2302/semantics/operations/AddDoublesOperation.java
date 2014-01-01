package me.loki2302.semantics.operations;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.AddDoublesExpression;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.constraints.ExpressionConstraint;
import me.loki2302.semantics.expressions.constraints.ExpressionIsOfCompatibleTypeExpressionConstraint;
import me.loki2302.semantics.types.Type;

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