package me.loki2302.syntax.expectations.element.expression;

import me.loki2302.syntax.dom.DOMExpression;

public interface ExpressionExpectation {
	void check(DOMExpression domExpression);
}