package me.loki2302.expressions;

import me.loki2302.Type;

public class CastDoubleToIntExpression extends UnaryExpression {        
    public CastDoubleToIntExpression(Type intType, Expression e) {
        super(intType, e);
    }
    
    @Override
    public String toString() {
        return String.format("d2i(%s)", getInput());
    }
}