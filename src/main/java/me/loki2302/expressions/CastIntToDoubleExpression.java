package me.loki2302.expressions;

import me.loki2302.Type;

public class CastIntToDoubleExpression extends UnaryExpression {        
    public CastIntToDoubleExpression(Type doubleType, Expression e) {
        super(doubleType, e);
    }        
    
    @Override
    public String toString() {
        return String.format("i2d(%s)", getInput());
    }
}