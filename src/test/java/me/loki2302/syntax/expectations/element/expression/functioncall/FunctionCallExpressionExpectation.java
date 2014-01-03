package me.loki2302.syntax.expectations.element.expression.functioncall;

import me.loki2302.syntax.dom.DOMFunctionCallExpression;

public interface FunctionCallExpressionExpectation {
    void check(DOMFunctionCallExpression domFunctionCallExpression);
}