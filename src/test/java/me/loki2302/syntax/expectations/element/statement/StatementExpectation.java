package me.loki2302.syntax.expectations.element.statement;

import me.loki2302.syntax.dom.DOMStatement;

public interface StatementExpectation {
    void check(DOMStatement domStatement);
}