package me.loki2302.operations;

import java.util.List;

import me.loki2302.expressions.Expression;
import me.loki2302.operations.constraints.ArgumentConstraint;
import me.loki2302.strings.ArgumentIsStringConstraint;
import me.loki2302.strings.StringConstraint;

public abstract class MakeConstExpressionOperation extends AbstractOperation {
    @Override
    protected int getArgumentCount() {
        return 1;
    }

    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        if(index == 0) {
            return new ArgumentIsStringConstraint(getStringConstraint());
        }
        
        throw new RuntimeException();
    }

    @Override
    protected Object processSafe(List<Object> safeArguments) {
        String literal = (String)safeArguments.get(0);
        return processSafe(literal);
    }
    
    protected abstract StringConstraint getStringConstraint();
    protected abstract Expression processSafe(String literal);
}