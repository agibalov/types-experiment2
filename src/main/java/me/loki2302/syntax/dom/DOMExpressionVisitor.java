package me.loki2302.syntax.dom;

public interface DOMExpressionVisitor<TResult> {
    TResult visit(DOMBinaryExpression e);
    TResult visit(DOMExplicitCastExpression e);
    TResult visit(DOMFunctionCallExpression e);
    TResult visit(DOMLiteralExpression e);
    TResult visit(DOMUnaryExpression e);
    TResult visit(DOMVariableReferenceExpression e);
}