package me.loki2302.syntax.expectations.element.statement.ifstatement;

import static org.junit.Assert.assertNull;
import me.loki2302.syntax.dom.statements.DOMIfStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;

public class IfStatementDoesNotHaveFalseBranchExpectation implements IfStatementExpectation {        
    @Override
    public void check(DOMIfStatement domIfStatement) {
        DOMStatement falseBranch = domIfStatement.getFalseBranch(); 
        assertNull(falseBranch);
    }
}