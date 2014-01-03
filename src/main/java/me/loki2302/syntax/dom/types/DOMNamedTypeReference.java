package me.loki2302.syntax.dom.types;

public class DOMNamedTypeReference extends DOMTypeReference {
    private final String typeName;
    
    public DOMNamedTypeReference(String typeName) {
        this.typeName = typeName;
    }
    
    public String getTypeName() {
        return typeName;
    }
}