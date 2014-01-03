package me.loki2302.syntax.expectations.element.statement;

import static org.junit.Assert.assertTrue;
import me.loki2302.syntax.dom.statements.DOMNullStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;

public class StatementIsNullStatementExpectation implements StatementExpectation {
    @Override
    public void check(DOMStatement domStatement) {
        assertTrue(domStatement instanceof DOMNullStatement);
    }
}