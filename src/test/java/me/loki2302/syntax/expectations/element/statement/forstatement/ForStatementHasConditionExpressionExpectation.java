package me.loki2302.syntax.expectations.element.statement.forstatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.dom.DOMForStatement;
import me.loki2302.syntax.expectations.element.expression.ExpressionExpectation;

public class ForStatementHasConditionExpressionExpectation implements ForStatementExpectation {
    private final ExpressionExpectation[] expectations;
    
    public ForStatementHasConditionExpressionExpectation(ExpressionExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMForStatement domForStatement) {
        DOMExpression conditionExpression = domForStatement.getConditionExpression();
        assertNotNull(conditionExpression);
        for(ExpressionExpectation expectation : expectations) {
            expectation.check(conditionExpression);
        }
    }        
}