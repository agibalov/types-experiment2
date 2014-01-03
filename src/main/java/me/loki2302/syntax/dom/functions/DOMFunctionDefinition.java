package me.loki2302.syntax.dom.functions;

import java.util.List;

import me.loki2302.syntax.dom.DOMElement;
import me.loki2302.syntax.dom.DOMElementVisitor;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.dom.types.DOMTypeReference;

public class DOMFunctionDefinition implements DOMElement {
    private final String functionName; 
    private final DOMTypeReference returnType;
    private final List<DOMParameterDefinition> parameterDefinitions;
    private final DOMStatement body;
    
    public DOMFunctionDefinition(
            String functionName, 
            DOMTypeReference returnType,
            List<DOMParameterDefinition> parameterDefinitions,
            DOMStatement body) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.parameterDefinitions = parameterDefinitions;
        this.body = body;
    }        
    
    public String getFunctionName() {
        return functionName;
    }
    
    public DOMTypeReference getReturnType() {
        return returnType;
    }
    
    public List<DOMParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }
    
    public DOMStatement getBody() {
        return body;
    }

    @Override
    public <TResult> TResult accept(DOMElementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}