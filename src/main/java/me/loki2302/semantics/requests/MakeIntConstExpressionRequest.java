package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;

public class MakeIntConstExpressionRequest implements Request<Expression> {
    private final String literal;
    
    public MakeIntConstExpressionRequest(String literal) {
        this.literal = literal;
    }

    @Override
    public Intention getIntention() {
        return Intention.MakeIntConst;
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