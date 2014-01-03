package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.expressions.DOMExpression;

public class DOMIfStatement extends DOMStatement {
    private final DOMExpression conditionExpression;
    private final DOMStatement trueBranch;
    private final DOMStatement falseBranch;
    
    public DOMIfStatement(
            DOMExpression conditionExpression, 
            DOMStatement trueBranch, 
            DOMStatement falseBranch) {
        
        this.conditionExpression = conditionExpression;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;            
    }
    
    public DOMExpression getConditionExpression() {
        return conditionExpression;
    }
    
    public DOMStatement getTrueBranch() {
        return trueBranch;
    }
    
    public DOMStatement getFalseBranch() {
        return falseBranch;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}