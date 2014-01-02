package me.loki2302.semantics.expressions;

import me.loki2302.semantics.types.Type;

public class CastDoubleToIntExpression implements Expression {
    private final Type intType;
    private final Expression expression;
    
    public CastDoubleToIntExpression(Type intType, Expression expression) {
        this.intType = intType;
        this.expression = expression;
    }
    
    public Expression getExpression() {
        return expression;
    }

    @Override
    public Type getType() {
        return intType;
    }
    
    @Override
    public String toString() {
        return String.format("d2i(%s)", expression);
    }

    @Override
    public <TResult> TResult accept(ExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}