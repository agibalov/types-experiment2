package me.loki2302.dom;


public interface DOMExpressionVisitor<TResult> {
    TResult visit(IntLiteralDOMExpression e);
    TResult visit(DoubleLiteralDOMExpression e);
    TResult visit(OperatorAddDOMExpression e);
}