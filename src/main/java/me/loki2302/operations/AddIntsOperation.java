package me.loki2302.operations;

import me.loki2302.Intention;
import me.loki2302.expressions.AddIntsExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.expressions.constraints.ExpressionIsOfCompatibleTypeExpressionConstraint;
import me.loki2302.types.Type;


public class AddIntsOperation extends AbstractEEEOperation {
    private final Type intType;
    
    public AddIntsOperation(Type intType) {
        this.intType = intType;
    }
    
    @Override
    public Intention getIntention() {
        return Intention.OperatorAdd;
    }
    
    @Override
    protected ExpressionConstraint getLeftExpressionConstraint() {            
        return new ExpressionIsOfCompatibleTypeExpressionConstraint(intType);
    }

    @Override
    protected ExpressionConstraint getRightExpressionConstraint() {
        return new ExpressionIsOfCompatibleTypeExpressionConstraint(intType);
    }

    @Override
    protected Expression processSafe(Expression left, Expression right) {
        return new AddIntsExpression(intType, left, right);
    }               
}