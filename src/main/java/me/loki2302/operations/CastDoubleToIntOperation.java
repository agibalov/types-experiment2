package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App;
import me.loki2302.Type;
import me.loki2302.App.ExpressionConstraint;
import me.loki2302.expressions.CastDoubleToIntExpression;
import me.loki2302.expressions.Expression;

public class CastDoubleToIntOperation extends UnaryOperation {
    private final Type doubleType;
    private final Type intType;
    
    public CastDoubleToIntOperation(Type doubleType, Type intType) {
        this.doubleType = doubleType;
        this.intType = intType;            
    }

    public List<Intention> getIntentions() {
        return Arrays.asList(Intention.ExcplicitCast);
    }

    @Override
    protected ExpressionConstraint getInputConstraint() {
        return App.isOfType(doubleType);
    }

    @Override
    protected Expression processUnary(Expression e) {
        return new CastDoubleToIntExpression(intType, e);
    }
}