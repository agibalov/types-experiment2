package me.loki2302.expressions;

import me.loki2302.Type;

public abstract class UnaryExpression implements Expression {
    private final Type resultType;
    private final Expression input;
    
    public UnaryExpression(Type resultType, Expression input) {
        this.resultType = resultType;
        this.input = input;
    }
    
    public Expression getInput() {
        return input;
    }

    public Type getResultType() {
        return resultType;
    }
}