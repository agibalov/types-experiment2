package me.loki2302.semantics.types;

public class PrimitiveType implements Type {
    private final String typeName;
    
    public PrimitiveType(String typeName) {
        this.typeName = typeName;
    }
    
    public String getTypeName() {
        return typeName;
    }
}