package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.expressions.DOMExpression;

public class DOMWhileStatement extends DOMStatement {
    private final DOMExpression conditionExpression;
    private final DOMStatement bodyStatement;
    
    public DOMWhileStatement(
            DOMExpression conditionExpression, 
            DOMStatement bodyStatement) {
        this.conditionExpression = conditionExpression;
        this.bodyStatement = bodyStatement;
    }
    
    public DOMExpression getConditionExpression() {
        return conditionExpression;
    }
    
    public DOMStatement getBodyStatement() {
        return bodyStatement;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}