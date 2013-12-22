package me.loki2302.dom;


public interface DOMExpressionVisitor<T> {
    T visit(DOMIntLiteralExpression e);
    T visit(DOMDoubleLiteralExpression e);
    T visit(DOMAddExpression e);
}