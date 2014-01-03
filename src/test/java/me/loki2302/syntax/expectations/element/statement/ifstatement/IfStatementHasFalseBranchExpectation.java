package me.loki2302.syntax.expectations.element.statement.ifstatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.statements.DOMIfStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.StatementExpectation;

public class IfStatementHasFalseBranchExpectation implements IfStatementExpectation {
    private final StatementExpectation[] expectations;
    
    public IfStatementHasFalseBranchExpectation(StatementExpectation[] expectations) {
        this.expectations = expectations;
    }

    @Override
    public void check(DOMIfStatement domIfStatement) {
        DOMStatement falseBranch = domIfStatement.getFalseBranch(); 
        assertNotNull(falseBranch);            
        for(StatementExpectation expectation : expectations) {
            expectation.check(falseBranch);
        }
    }
}