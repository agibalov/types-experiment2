package me.loki2302.syntax.dom;

public class DoubleLiteralDOMExpression implements DOMExpression {
    private final String literalString;
    
    public DoubleLiteralDOMExpression(String literalString) {
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
        return String.format("d[%s]", literalString);
    }
}