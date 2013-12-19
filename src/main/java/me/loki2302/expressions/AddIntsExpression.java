package me.loki2302.expressions;

import me.loki2302.Type;

public class AddIntsExpression extends BinaryExpression {        
    public AddIntsExpression(Type intType, Expression left, Expression right) {
        super(intType, left, right);
    }
    
    @Override
    public String toString() {
        return String.format("iadd(%s,%s)", getLeft(), getRight());
    }
}