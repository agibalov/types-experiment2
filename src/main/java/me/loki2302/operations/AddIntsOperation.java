package me.loki2302.operations;

import static me.loki2302.expressions.constraints.ExpressionConstraints.isOfType;

import java.util.Arrays;
import java.util.List;

import me.loki2302.Type;
import me.loki2302.expressions.AddIntsExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public class AddIntsOperation extends BinaryOperation {
    private final Type intType;
    
    public AddIntsOperation(Type intType) {
        this.intType = intType;
    }
    
    public List<Intention> getIntentions() {
        return Arrays.asList(Intention.Add);
    }
    
    @Override
    protected ExpressionConstraint getLeftConstraint() {
        return isOfType(intType);
    }

    @Override
    protected ExpressionConstraint getRightConstraint() {
        return isOfType(intType);
    }

    @Override
    protected Expression processBinary(Expression left, Expression right) {            
        return new AddIntsExpression(intType, left, right);
    }               
    
    @Override
    public String toString() {
        return "AddIntsOp";
    }
}