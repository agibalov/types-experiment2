package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.statements.Statement;

public class MakeExpressionStatementRequest implements Request<Statement> {
    private final Expression expression;
    
    public MakeExpressionStatementRequest(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public Intention getIntention() {
        return Intention.MakeExpressionStatement;
    }

    @Override
    public int getArgumentCount() {
        return 1;
    }

    @Override
    public Object getArgument(int index) {
        if(index == 0) {
            return expression;
        }
        
        throw new RuntimeException();
    }
}