package me.loki2302.syntax.dom.functions;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;
import me.loki2302.syntax.dom.types.DOMTypeReference;

public class DOMParameterDefinition implements DOMElement {
    private final String name;
    private final DOMTypeReference type;
    
    public DOMParameterDefinition(String name, DOMTypeReference type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public DOMTypeReference getType() {
        return type;
    }

    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}
