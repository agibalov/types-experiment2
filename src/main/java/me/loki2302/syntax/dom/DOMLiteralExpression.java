package me.loki2302.syntax.dom;

public class DOMLiteralExpression implements DOMExpression {
	private final DOMLiteralType literalType;
	private final String stringValue;
	
	public DOMLiteralExpression(DOMLiteralType literalType, String stringValue) {
		this.literalType = literalType;
		this.stringValue = stringValue;
	}
	
	public DOMLiteralType getLiteralType() {
		return literalType;
	}
	
	public String getStringValue() {
		return stringValue;
	}

    @Override
    public <TResult> TResult accept(DOMExpressionVisitor<TResult> visitor) {
        return visitor.visit(this);
    }
}