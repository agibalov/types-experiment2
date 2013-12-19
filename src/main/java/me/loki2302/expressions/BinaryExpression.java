package me.loki2302.expressions;

import me.loki2302.Type;

public abstract class BinaryExpression implements Expression {
    private final Type resultType;
    private final Expression left;
    private final Expression right;
    
    public BinaryExpression(Type resultType, Expression left, Expression right) {
        this.resultType = resultType;
        this.left = left;
        this.right = right;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }

    public Type getResultType() {
        return resultType;
    }
}