package me.loki2302.syntax.expectations.element.statement;

import static org.junit.Assert.*;
import me.loki2302.syntax.dom.DOMBreakStatement;
import me.loki2302.syntax.dom.DOMStatement;

public class StatementIsBreakStatementExpectation implements StatementExpectation {
    @Override
    public void check(DOMStatement domStatement) {
        assertTrue(domStatement instanceof DOMBreakStatement);
    }    
}