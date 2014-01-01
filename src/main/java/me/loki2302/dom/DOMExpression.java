package me.loki2302.dom;

public interface DOMExpression {
    <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor);
}