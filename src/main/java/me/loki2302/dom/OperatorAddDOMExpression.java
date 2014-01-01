package me.loki2302.dom;

public class OperatorAddDOMExpression implements DOMExpression {
    private final DOMExpression leftExpression;
    private final DOMExpression rightExpression;
    
    public OperatorAddDOMExpression(DOMExpression leftExpression, DOMExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    
    public DOMExpression getLeftExpression() {
        return leftExpression;
    }
    
    public DOMExpression getRightExpression() {
        return rightExpression;
    }
    
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return String.format("add(%s,%s)", leftExpression, rightExpression);
    }
}