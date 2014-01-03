package me.loki2302.syntax.dom;

public class DOMExplicitCastExpression implements DOMExpression {
    private final DOMTypeReference typeReference;
    private final DOMExpression innerExpression;
    
    public DOMExplicitCastExpression(
            DOMTypeReference typeReference, 
            DOMExpression innerExpression) {
        this.typeReference = typeReference;
        this.innerExpression = innerExpression;
    }
    
    public DOMTypeReference getTypeReference() {
        return typeReference;
    }
    
    public DOMExpression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}