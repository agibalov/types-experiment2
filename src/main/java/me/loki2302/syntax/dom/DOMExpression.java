package me.loki2302.syntax.dom;

public interface DOMExpression {
    <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor);
}