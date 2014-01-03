package me.loki2302.syntax.expectations.element.expression;

import static org.junit.Assert.*;
import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.dom.DOMLiteralExpression;
import me.loki2302.syntax.expectations.element.expression.literal.LiteralExpressionExpectation;

public class ExpressionIsLiteralExpressionExpectation implements ExpressionExpectation {
	private final LiteralExpressionExpectation[] expectations;
	
	public ExpressionIsLiteralExpressionExpectation() {
		this(new LiteralExpressionExpectation[]{});
	}
	
	public ExpressionIsLiteralExpressionExpectation(LiteralExpressionExpectation[] expectations) {
		this.expectations = expectations;
	}
	
	public void check(DOMExpression domExpression) {
		assertTrue(domExpression instanceof DOMLiteralExpression);
		DOMLiteralExpression domLiteralExpression = (DOMLiteralExpression)domExpression;
		for(LiteralExpressionExpectation expectation : expectations) {
			expectation.check(domLiteralExpression);
		}
	}
}