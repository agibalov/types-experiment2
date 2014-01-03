package me.loki2302.semantics.requests;

import java.util.List;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.statements.Statement;

public class MakeCompositeStatementRequest implements Request<Statement> {
    private final List<Statement> statements;
    
    public MakeCompositeStatementRequest(List<Statement> statements) {
        this.statements = statements;
    }
    
    @Override
    public Intention getIntention() {
        return Intention.MakeCompositeStatement;
    }

    @Override
    public int getArgumentCount() {
        return 1;
    }

    @Override
    public Object getArgument(int index) {
        return statements;
    }
}