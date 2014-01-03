package me.loki2302.syntax.dom.statements;

import java.util.List;

public class DOMCompositeStatement extends DOMStatement {
    private final List<DOMStatement> domStatements;
    
    public DOMCompositeStatement(List<DOMStatement> domStatements) {
        this.domStatements = domStatements;
    }
    
    public List<DOMStatement> getStatements() {
        return domStatements;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}