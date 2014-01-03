package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;

public abstract class DOMStatement implements DOMElement {
    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }    
    
    public abstract <TResult> TResult accept(DOMStatementVisitor<TResult> visitor);    
}