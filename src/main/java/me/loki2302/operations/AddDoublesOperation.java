package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App;
import me.loki2302.Type;
import me.loki2302.App.ExpressionConstraint;
import me.loki2302.expressions.AddDoublesExpression;
import me.loki2302.expressions.Expression;

public class AddDoublesOperation extends BinaryOperation {
    private final Type doubleType;
    
    public AddDoublesOperation(Type doubleType) {
        this.doubleType = doubleType;
    }
    
    public List<Intention> getIntentions() {
        return Arrays.asList(Intention.Add);
    }
    
    @Override
    protected ExpressionConstraint getLeftConstraint() {
        return App.isOfType(doubleType);
    }

    @Override
    protected ExpressionConstraint getRightConstraint() {
        return App.isOfType(doubleType);
    }

    @Override
    protected Expression processBinary(Expression left, Expression right) {
        return new AddDoublesExpression(doubleType, left, right);
    }
    
    @Override
    public String toString() {
        return "AddDoublesOp";
    }
}