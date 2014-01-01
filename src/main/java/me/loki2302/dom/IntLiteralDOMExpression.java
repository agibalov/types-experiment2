package me.loki2302.dom;

public class IntLiteralDOMExpression implements DOMExpression {
    private final String literalString;
    
    public IntLiteralDOMExpression(String literalString) {
        this.literalString = literalString;
    }
    
    public String getLiteralString() {
        return literalString;
    }
    
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return String.format("i[%s]", literalString);
    }
}