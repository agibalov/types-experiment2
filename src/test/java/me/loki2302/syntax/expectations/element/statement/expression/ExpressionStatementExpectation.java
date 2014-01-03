package me.loki2302.syntax.expectations.element.statement.expression;

import me.loki2302.syntax.dom.statements.DOMExpressionStatement;

public interface ExpressionStatementExpectation {
    void check(DOMExpressionStatement domExpressionStatement);
}