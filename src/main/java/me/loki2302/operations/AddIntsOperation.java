package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App;
import me.loki2302.Type;
import me.loki2302.App.ExpressionConstraint;
import me.loki2302.expressions.AddIntsExpression;
import me.loki2302.expressions.Expression;

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
        return App.isOfType(intType);
    }

    @Override
    protected ExpressionConstraint getRightConstraint() {
        return App.isOfType(intType);
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