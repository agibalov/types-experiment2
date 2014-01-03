package me.loki2302.syntax.dom;

public interface DOMExpression extends DOMElement {
    <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor);
}