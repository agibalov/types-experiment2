package me.loki2302.dom;

public class DOMIntLiteralExpression implements DOMExpression {
    @Override
    public <T> T accept(DOMExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }        
}