package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;

public class MakeDoubleConstExpressionRequest implements Request<Expression> {
    private final String literal;
    
    public MakeDoubleConstExpressionRequest(String literal) {
        this.literal = literal;
    }

    @Override
    public Intention getIntention() {
        return Intention.MakeDoubleConst;
    }

    @Override
    public int getArgumentCount() {
        return 1;
    }

    @Override
    public Object getArgument(int index) {
        if(index == 0) {
            return literal;
        }
        
        throw new RuntimeException();
    }
}