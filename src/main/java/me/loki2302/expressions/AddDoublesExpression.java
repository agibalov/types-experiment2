package me.loki2302.expressions;

import me.loki2302.Type;

public class AddDoublesExpression extends BinaryExpression {        
    public AddDoublesExpression(Type doubleType, Expression left, Expression right) {
        super(doubleType, left, right);
    }
    
    @Override
    public String toString() {
        return String.format("dadd(%s,%s)", getLeft(), getRight());
    }
}