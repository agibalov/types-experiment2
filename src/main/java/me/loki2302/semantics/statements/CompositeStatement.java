package me.loki2302.semantics.statements;

import java.util.List;

public class CompositeStatement implements Statement {
    private final List<Statement> statements;
    
    public CompositeStatement(List<Statement> statements) {
        this.statements = statements;
    }
    
    public List<Statement> getStatements() {
        return statements;
    }
    
    @Override
    public <TResult> TResult accept(StatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}