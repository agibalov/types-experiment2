package me.loki2302.syntax.expectations.element.expression.binary;

import me.loki2302.syntax.dom.DOMBinaryExpression;
import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.expectations.element.expression.ExpressionExpectation;

public class BinaryExpressionHasSpecificLeftExpressionExpectation implements BinaryExpressionExpectation {
	private final ExpressionExpectation[] expectations;
	
	public BinaryExpressionHasSpecificLeftExpressionExpectation(ExpressionExpectation[] expectations) {
		this.expectations = expectations;
	}
	
	@Override
	public void check(DOMBinaryExpression domBinaryExpression) {
		DOMExpression leftExpression = domBinaryExpression.getLeftExpression();
		for(ExpressionExpectation expectation : expectations) {
			expectation.check(leftExpression);
		}
	}
}