package me.loki2302.syntax.expectations.element.statement.composite;

import me.loki2302.syntax.dom.DOMCompositeStatement;

public interface CompositeStatementExpectation {
    void check(DOMCompositeStatement domCompositeStatement);
}