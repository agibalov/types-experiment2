package me.loki2302.syntax.expectations.element.statement.composite;

import static org.junit.Assert.*;
import me.loki2302.syntax.dom.statements.DOMCompositeStatement;

public class CompositeStatementHasNumberOfChildrenExpectation implements CompositeStatementExpectation {
    private final int childCount;
    
    public CompositeStatementHasNumberOfChildrenExpectation(int childCount) {
        this.childCount = childCount;
    }
    
    @Override
    public void check(DOMCompositeStatement domCompositeStatement) {
        assertEquals(childCount, domCompositeStatement.getStatements().size());            
    }
}