package me.loki2302.semantics.operations;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.AddIntsExpression;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.constraints.ExpressionConstraint;
import me.loki2302.semantics.expressions.constraints.ExpressionIsOfCompatibleTypeExpressionConstraint;
import me.loki2302.semantics.types.Type;

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