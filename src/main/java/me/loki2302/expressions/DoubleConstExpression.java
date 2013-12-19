package me.loki2302.expressions;

import me.loki2302.Type;

public class DoubleConstExpression extends ConstExpression {                
    public DoubleConstExpression(Type doubleType) {
        super(doubleType);
    }        
    
    @Override
    public String toString() {
        return "dconst";
    }
}