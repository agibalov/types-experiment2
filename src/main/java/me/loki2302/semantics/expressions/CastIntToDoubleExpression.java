package me.loki2302.semantics.expressions;

import me.loki2302.semantics.types.Type;

public class CastIntToDoubleExpression implements Expression {
    private final Type doubleType;
    private final Expression expression;
    
    public CastIntToDoubleExpression(Type doubleType, Expression expression) {
        this.doubleType = doubleType;
        this.expression = expression;
    }
    
    public Expression getExpression() {
        return expression;
    }

    @Override
    public Type getType() {
        return doubleType;
    }
    
    @Override
    public String toString() {
        return String.format("i2d(%s)", expression);
    }
}