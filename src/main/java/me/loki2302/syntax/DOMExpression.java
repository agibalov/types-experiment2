package me.loki2302.syntax;

public interface DOMExpression {
    <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor);
}