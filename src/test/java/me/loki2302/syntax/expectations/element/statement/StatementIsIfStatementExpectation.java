package me.loki2302.syntax.expectations.element.statement;

import static org.junit.Assert.*;
import me.loki2302.syntax.dom.DOMIfStatement;
import me.loki2302.syntax.dom.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.ifstatement.IfStatementExpectation;

public class StatementIsIfStatementExpectation implements StatementExpectation {
    private final IfStatementExpectation[] expectations;
    
    public StatementIsIfStatementExpectation(IfStatementExpectation[] expectations) {
        this.expectations = expectations;
    }

    @Override
    public void check(DOMStatement domStatement) {
        assertTrue(domStatement instanceof DOMIfStatement);
        DOMIfStatement domIfStatement = (DOMIfStatement)domStatement;
        for(IfStatementExpectation expectation : expectations) {
            expectation.check(domIfStatement);
        }            
    }
}