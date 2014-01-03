package me.loki2302.syntax.expectations.element.statement.whilestatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.DOMStatement;
import me.loki2302.syntax.dom.DOMWhileStatement;
import me.loki2302.syntax.expectations.element.statement.StatementExpectation;

public class WhileStatementHasBodyStatementExpectation implements WhileStatementExpectation {
    private final StatementExpectation[] expectations;
    
    public WhileStatementHasBodyStatementExpectation(StatementExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMWhileStatement domWhileStatement) {
        DOMStatement bodyStatement = domWhileStatement.getBodyStatement();
        assertNotNull(bodyStatement);
        for(StatementExpectation expectation : expectations) {
            expectation.check(bodyStatement);
        }
    }        
}