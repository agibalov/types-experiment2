package me.loki2302.expressions;

import me.loki2302.types.Type;


public class DoubleConstExpression implements Expression {
    private final Type doubleType;
    private final String value;
    
    public DoubleConstExpression(Type doubleType, String value) {
        this.doubleType = doubleType;
        this.value = value;
    }

    @Override
    public Type getType() {
        return doubleType;
    }
    
    @Override
    public String toString() {
        return String.format("dconst(%s)", value);
    }
}