package me.loki2302.syntax.dom.statements;

import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.types.DOMTypeReference;

public class DOMVariableDefinitionStatement extends DOMStatement {
    private DOMTypeReference typeReference;
    private String variableName;
    private DOMExpression expression;
    
    public DOMVariableDefinitionStatement(
            DOMTypeReference typeReference, 
            String variableName, 
            DOMExpression expression) {
        this.typeReference = typeReference;
        this.variableName = variableName;
        this.expression = expression;
    }
    
    public DOMTypeReference getTypeReference() {
        return typeReference;
    }
    
    public String getVariableName() {
        return variableName;
    }
    
    public DOMExpression getExpression() {
        return expression;
    }

    @Override
    public <TResult> TResult accept(DOMStatementVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}