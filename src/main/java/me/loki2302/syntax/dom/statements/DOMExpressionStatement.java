package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.expressions.DOMExpression;

public class DOMExpressionStatement extends DOMStatement {
    private final DOMExpression expression;
    
    public DOMExpressionStatement(DOMExpression expression) {
        this.expression = expression;
    }
    
    public DOMExpression getExpression() {
        return expression;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}