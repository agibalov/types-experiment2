package me.loki2302.syntax.dom.types;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;

public abstract class DOMTypeReference implements DOMElement {
    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }        
}