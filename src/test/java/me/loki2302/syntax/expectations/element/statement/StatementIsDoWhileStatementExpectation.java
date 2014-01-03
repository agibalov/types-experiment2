package me.loki2302.syntax.expectations.element.statement;

import static org.junit.Assert.assertTrue;
import me.loki2302.syntax.dom.statements.DOMDoWhileStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.dowhile.DoWhileStatementExpectation;

public class StatementIsDoWhileStatementExpectation implements StatementExpectation {
    private final DoWhileStatementExpectation[] expectations;
    
    public StatementIsDoWhileStatementExpectation(DoWhileStatementExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMStatement domStatement) {
        assertTrue(domStatement instanceof DOMDoWhileStatement);
        DOMDoWhileStatement domDoWhileStatement = (DOMDoWhileStatement)domStatement;
        for(DoWhileStatementExpectation expectation : expectations) {
            expectation.check(domDoWhileStatement);
        }
    }        
}