package me.loki2302.syntax.expectations.element.statement.ifstatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.statements.DOMIfStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.StatementExpectation;

public class IfStatementHasTrueBranchExpectation implements IfStatementExpectation {
    private final StatementExpectation[] expectations;
    
    public IfStatementHasTrueBranchExpectation(StatementExpectation[] expectations) {
        this.expectations = expectations;
    }

    @Override
    public void check(DOMIfStatement domIfStatement) {
        DOMStatement trueBranch = domIfStatement.getTrueBranch(); 
        assertNotNull(trueBranch);            
        for(StatementExpectation expectation : expectations) {
            expectation.check(trueBranch);
        }
    }
}