package me.loki2302.syntax.expectations.element.expression.variable;

import me.loki2302.syntax.dom.DOMVariableReferenceExpression;

public interface VariableReferenceExpectation {
    void check(DOMVariableReferenceExpression domVariableReferenceExpression);
}