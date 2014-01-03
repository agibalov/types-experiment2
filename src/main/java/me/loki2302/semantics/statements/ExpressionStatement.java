package me.loki2302.semantics.statements;

import me.loki2302.semantics.expressions.Expression;

public class ExpressionStatement implements Statement {
    private final Expression expression;
    
    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }
    
    public Expression getExpression() {
        return expression;
    }
    
    @Override
    public <TResult> TResult accept(StatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }        
}