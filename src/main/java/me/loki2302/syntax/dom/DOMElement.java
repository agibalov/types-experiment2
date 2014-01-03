package me.loki2302.syntax.dom;

public interface DOMElement {
    <TResult> TResult accept(DOMElementVisitor<TResult> visitor);
}