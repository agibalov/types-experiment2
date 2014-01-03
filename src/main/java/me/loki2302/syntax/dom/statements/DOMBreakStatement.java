package me.loki2302.syntax.dom.statements;


public class DOMBreakStatement extends DOMStatement {
    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}