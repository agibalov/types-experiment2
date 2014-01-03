package me.loki2302.syntax.expectations.element.expression.binary;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.DOMBinaryExpression;
import me.loki2302.syntax.dom.DOMBinaryExpressionType;

public class BinaryExpressionHasSpecificTypeExpectation implements BinaryExpressionExpectation {
	private final DOMBinaryExpressionType expressionType;
	
	public BinaryExpressionHasSpecificTypeExpectation(DOMBinaryExpressionType expressionType) {
		this.expressionType = expressionType;
	}

	@Override
	public void check(DOMBinaryExpression domBinaryExpression) {
		assertEquals(expressionType, domBinaryExpression.getExpressionType());			
	}
}