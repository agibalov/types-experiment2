package me.loki2302.operations;

import java.util.Arrays;
import java.util.List;

import me.loki2302.App;
import me.loki2302.Type;
import me.loki2302.App.ExpressionConstraint;
import me.loki2302.expressions.CastIntToDoubleExpression;
import me.loki2302.expressions.Expression;

public class CastIntToDoubleOperation extends UnaryOperation {
    private final Type intType;
    private final Type doubleType;
    
    public CastIntToDoubleOperation(Type intType, Type doubleType) {
        this.intType = intType;
        this.doubleType = doubleType;
    }

    public List<Intention> getIntentions() {
        return Arrays.asList(Intention.ImplicitCast, Intention.ExcplicitCast);
    }

    @Override
    protected ExpressionConstraint getInputConstraint() {
        return App.isOfType(intType);
    }

    @Override
    protected Expression processUnary(Expression e) {
        return new CastIntToDoubleExpression(doubleType, e);
    }
}