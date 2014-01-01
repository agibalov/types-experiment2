package me.loki2302.semantics.requests;

import me.loki2302.semantics.expressions.Expression;

public abstract class EEERequest implements Request<Expression> {
    @Override
    public int getArgumentCount() {
        return 2;
    }

    @Override
    public Object getArgument(int index) {   
        if(index == 0) {
            return getLeft();
        }
        
        if(index == 1) {
            return getRight();
        }
        
        throw new RuntimeException();
    }
    
    protected abstract Expression getLeft();
    protected abstract Expression getRight();
}