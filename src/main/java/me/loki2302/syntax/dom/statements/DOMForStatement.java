package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.expressions.DOMExpression;

public class DOMForStatement extends DOMStatement {
    private final DOMStatement initializerStatement;
    private final DOMExpression conditionExpression;
    private final DOMStatement stepStatement;
    private final DOMStatement bodyStatement;
    
    public DOMForStatement(
            DOMStatement initializerStatement, 
            DOMExpression conditionExpression, 
            DOMStatement stepStatement,
            DOMStatement bodyStatement) {
        this.initializerStatement = initializerStatement;
        this.conditionExpression = conditionExpression;
        this.stepStatement = stepStatement;
        this.bodyStatement = bodyStatement;
    }
    
    public DOMStatement getInitializerStatement() {
        return initializerStatement;
    }
    
    public DOMExpression getConditionExpression() {
        return conditionExpression;
    }
    
    public DOMStatement getStepStatement() {
        return stepStatement;
    }
    
    public DOMStatement getBodyStatement() {
        return bodyStatement;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}