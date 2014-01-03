package me.loki2302.syntax.dom.expressions;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;

public abstract class DOMExpression implements DOMElement {
    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
    
    public abstract <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor);    
}