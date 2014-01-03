package me.loki2302.syntax.expectations.element.statement.forstatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.statements.DOMForStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.expectations.element.statement.StatementExpectation;

public class ForStatementHasBodyStatementExpectation implements ForStatementExpectation {
    private final StatementExpectation[] expectations;
    
    public ForStatementHasBodyStatementExpectation(StatementExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMForStatement domForStatement) {
        DOMStatement bodyStatement = domForStatement.getBodyStatement();
        assertNotNull(bodyStatement);
        for(StatementExpectation expectation : expectations) {
            expectation.check(bodyStatement);
        }
    }        
}