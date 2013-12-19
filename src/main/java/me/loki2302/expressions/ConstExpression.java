package me.loki2302.expressions;

import me.loki2302.Type;

public abstract class ConstExpression implements Expression {
    private final Type type;
    
    public ConstExpression(Type type) {
        this.type = type;
    }
    
    public Type getResultType() {
        return type;
    }   
}