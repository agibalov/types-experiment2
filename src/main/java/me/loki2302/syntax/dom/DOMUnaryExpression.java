package me.loki2302.syntax.dom;

public class DOMUnaryExpression implements DOMExpression {
    private DOMUnaryExpressionType expressionType;
    private DOMExpression innerExpression;
    
    public DOMUnaryExpression(
            DOMUnaryExpressionType expressionType, 
            DOMExpression innerExpression) {
        
        this.expressionType = expressionType;
        this.innerExpression = innerExpression;
    }
    
    public DOMUnaryExpressionType getExpressionType() {
        return expressionType;
    }
    
    public DOMExpression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}