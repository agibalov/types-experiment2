package me.loki2302.syntax.expectations.element.expression;

import static org.junit.Assert.*;
import me.loki2302.syntax.dom.DOMBinaryExpression;
import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.expectations.element.expression.binary.BinaryExpressionExpectation;

public class ExpressionIsBinaryExpressionExpectation implements ExpressionExpectation {
	private final BinaryExpressionExpectation[] expectations;
	
	public ExpressionIsBinaryExpressionExpectation() {
		this(new BinaryExpressionExpectation[]{});
	}
	
	public ExpressionIsBinaryExpressionExpectation(BinaryExpressionExpectation[] expectations) {
		this.expectations = expectations;
	}

	@Override
	public void check(DOMExpression domExpression) {
		assertTrue(domExpression instanceof DOMBinaryExpression);
		DOMBinaryExpression domBinaryExpression = (DOMBinaryExpression)domExpression;
		for(BinaryExpressionExpectation expectation : expectations) {
			expectation.check(domBinaryExpression);
		}			
	}
}