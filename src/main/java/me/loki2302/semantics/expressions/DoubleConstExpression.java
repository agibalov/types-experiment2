package me.loki2302.semantics.expressions;

import me.loki2302.semantics.types.Type;

public class DoubleConstExpression implements Expression {
    private final Type doubleType;
    private final String value;
    
    public DoubleConstExpression(Type doubleType, String value) {
        this.doubleType = doubleType;
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return doubleType;
    }
    
    @Override
    public String toString() {
        return String.format("dconst(%s)", value);
    }

    @Override
    public <TResult> TResult accept(ExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}