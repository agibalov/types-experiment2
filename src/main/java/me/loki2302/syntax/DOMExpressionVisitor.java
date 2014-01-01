package me.loki2302.syntax;


public interface DOMExpressionVisitor<TResult> {
    TResult visit(IntLiteralDOMExpression e);
    TResult visit(DoubleLiteralDOMExpression e);
    TResult visit(OperatorAddDOMExpression e);
}