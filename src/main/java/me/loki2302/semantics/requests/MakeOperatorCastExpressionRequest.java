package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.types.Type;

public class MakeOperatorCastExpressionRequest implements Request<Expression> {
    private final Type targetType;
    private final Expression expression;
    
    public MakeOperatorCastExpressionRequest(Type targetType, Expression expression) {
        this.targetType = targetType;
        this.expression = expression;
    }

    @Override
    public Intention getIntention() {
        return Intention.OperatorCast;
    }

    @Override
    public int getArgumentCount() {
        return 2;
    }

    @Override
    public Object getArgument(int index) {
        if(index == 0) {
            return targetType;
        }
        
        if(index == 1) {
            return expression;
        }
        
        throw new RuntimeException();
    }
}