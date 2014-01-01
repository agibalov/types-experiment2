package me.loki2302.semantics.expressions;

import me.loki2302.semantics.types.Type;

public class AddDoublesExpression implements Expression {
    private final Type doubleType;
    private final Expression leftExpression;
    private final Expression rightExpression;
    
    public AddDoublesExpression(Type doubleType, Expression leftExpression, Expression rightExpression) {
        this.doubleType = doubleType;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    
    public Expression getLeftExpression() {
        return leftExpression;
    }
    
    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public Type getType() {
        return doubleType;
    }
    
    @Override
    public String toString() {
        return String.format("dadd(%s,%s)", leftExpression, rightExpression);
    }
}