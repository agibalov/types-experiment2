package me.loki2302.syntax.dom;

import java.util.List;

public class DOMCompositeStatement implements DOMStatement {
    private final List<DOMStatement> domStatements;
    
    public DOMCompositeStatement(List<DOMStatement> domStatements) {
        this.domStatements = domStatements;
    }
    
    public List<DOMStatement> getStatements() {
        return domStatements;
    }
}