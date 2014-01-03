package me.loki2302.syntax.expectations.element.statement.expression;

import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.dom.DOMExpressionStatement;
import me.loki2302.syntax.expectations.element.expression.ExpressionExpectation;

public class ExpressionStatementHasSpecificExpressionExpectation implements ExpressionStatementExpectation {
    private final ExpressionExpectation[] expectations;
    
    public ExpressionStatementHasSpecificExpressionExpectation(ExpressionExpectation[] expectations) {
        this.expectations = expectations;
    }

    @Override
    public void check(DOMExpressionStatement domExpressionStatement) {
        DOMExpression domExpression = (DOMExpression)domExpressionStatement.getExpression();
        for(ExpressionExpectation expectation : expectations) {
            expectation.check(domExpression);
        }            
    }        
}