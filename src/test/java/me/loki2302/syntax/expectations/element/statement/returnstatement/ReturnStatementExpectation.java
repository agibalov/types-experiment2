package me.loki2302.syntax.expectations.element.statement.returnstatement;

import me.loki2302.syntax.dom.statements.DOMReturnStatement;

public interface ReturnStatementExpectation {
    void check(DOMReturnStatement domReturnStatement);
}