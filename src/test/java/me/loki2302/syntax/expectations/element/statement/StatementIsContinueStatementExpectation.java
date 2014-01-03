package me.loki2302.syntax.expectations.element.statement;

import static org.junit.Assert.assertTrue;
import me.loki2302.syntax.dom.statements.DOMContinueStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;

public class StatementIsContinueStatementExpectation implements StatementExpectation {
    @Override
    public void check(DOMStatement domStatement) {
        assertTrue(domStatement instanceof DOMContinueStatement);
    }
}