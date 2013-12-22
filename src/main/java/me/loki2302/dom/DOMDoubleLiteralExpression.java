package me.loki2302.dom;

public class DOMDoubleLiteralExpression implements DOMExpression {
    @Override
    public <T> T accept(DOMExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }        
}