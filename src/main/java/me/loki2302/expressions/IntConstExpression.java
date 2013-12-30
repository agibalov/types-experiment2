package me.loki2302.expressions;

import me.loki2302.types.Type;

public class IntConstExpression implements Expression {
    private final Type intType;
    private final String value;
    
    public IntConstExpression(Type intType, String value) {
        this.intType = intType;
        this.value = value;
    }

    @Override
    public Type getType() {
        return intType;
    }
    
    @Override
    public String toString() {
        return String.format("iconst(%s)", value);
    }
}