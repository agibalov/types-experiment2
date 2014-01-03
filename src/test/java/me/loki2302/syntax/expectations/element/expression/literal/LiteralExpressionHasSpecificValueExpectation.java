package me.loki2302.syntax.expectations.element.expression.literal;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.expressions.DOMLiteralExpression;

public class LiteralExpressionHasSpecificValueExpectation implements LiteralExpressionExpectation {
	private final String stringValue;
	
	public LiteralExpressionHasSpecificValueExpectation(String stringValue) {
		this.stringValue = stringValue;
	}

	@Override
	public void check(DOMLiteralExpression domLiteralExpression) {
		assertEquals(stringValue, domLiteralExpression.getStringValue());			
	}		
}