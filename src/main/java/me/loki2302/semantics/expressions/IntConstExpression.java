package me.loki2302.semantics.expressions;

import me.loki2302.semantics.types.Type;

public class IntConstExpression implements Expression {
    private final Type intType;
    private final String value;
    
    public IntConstExpression(Type intType, String value) {
        this.intType = intType;
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return intType;
    }
    
    @Override
    public String toString() {
        return String.format("iconst(%s)", value);
    }

    @Override
    public <TResult> TResult accept(ExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}