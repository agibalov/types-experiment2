package me.loki2302.syntax.dom.expressions;

public class DOMVariableReferenceExpression extends DOMExpression {
    private final String variableName;
    
    public DOMVariableReferenceExpression(String variableName) {
        this.variableName = variableName;
    }
    
    public String getVariableName() {
        return variableName;
    }

    @Override
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}