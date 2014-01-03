package me.loki2302.syntax.expectations.element.statement.dowhile;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.DOMDoWhileStatement;
import me.loki2302.syntax.dom.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.StatementExpectation;

public class DoWhileStatementHasBodyStatementExpectation implements DoWhileStatementExpectation {
    private final StatementExpectation[] expectations;
    
    public DoWhileStatementHasBodyStatementExpectation(StatementExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMDoWhileStatement domDoWhileStatement) {
        DOMStatement bodyStatement = domDoWhileStatement.getBodyStatement();
        assertNotNull(bodyStatement);
        for(StatementExpectation expectation : expectations) {
            expectation.check(bodyStatement);
        }
    }        
}