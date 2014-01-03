package me.loki2302.syntax.dom.programs;

import java.util.List;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;
import me.loki2302.syntax.dom.functions.DOMFunctionDefinition;

public class DOMProgram implements DOMElement {
    private final List<DOMFunctionDefinition> functionDefinitions;
    
    public DOMProgram(List<DOMFunctionDefinition> functionDefinitions) {
        this.functionDefinitions = functionDefinitions;
    }
    
    public List<DOMFunctionDefinition> getFunctionDefinitions() {
        return functionDefinitions;
    }

    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}