package me.loki2302.syntax.expectations.element.expression.variable;

import me.loki2302.syntax.dom.expressions.DOMVariableReferenceExpression;

public interface VariableReferenceExpectation {
    void check(DOMVariableReferenceExpression domVariableReferenceExpression);
}