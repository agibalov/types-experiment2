package me.loki2302.expressions;

import me.loki2302.Type;

public class IntConstExpression extends ConstExpression {                
    public IntConstExpression(Type intType) {
        super(intType);
    }        
    
    @Override
    public String toString() {
        return "iconst";
    }
}